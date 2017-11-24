require([
    'component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'handlebars',
    'component/clearform',
    'jquery',
    'jquery.validate',
    'jquery.serialize',
    'laydate',
    'pagination',
    'common/validateRules',
    'jquery.placeholder',
    'jquery.icinfo'
], function(layer, dataTable, util, http, handlebars,clearform) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    var objWin;
    json_data_array();//初始化联动数据
    init();
    var dataArray;  //省市县数据
    var jsonArea ;  //县 或 区
    var jsonArea2 ;  //县 或 区
    /**
     * 初始化函数集合
     */
    function init() {
        //判断输入框中是否有因为 ' 号
        $.validator.addMethod("specials", function(value, element) {
            if(value){
                return  value.indexOf("'")>-1?false:true;
            }
        }, "输入文本中不能有特殊符号 如：（活动 '） 中的 ' 号 ");
    	tableInit();
    	initlicence();//初始化许可证
    	formValid();
        licenceformValid();
        bind();
        $("#select_city, #select_area, #select_stree, #desc_address,#icon-close-delete").on("click keyup", select_keyup);//触发事件
    }

    ////////////////////////////////////////////////行政区划 start ////////////////////////////////////////////////////

//提取数据
    function json_data_array(){
        //初始化设置数据
        http.httpRequest({
            url: '/reg/client/yr/SelectCodeAddress/getJson',
            serializable: false,
            data: {},
            async: false,
            type: 'post',
            success: function (data) {
                dataArray = data.data;
                select_data();      //企业通讯 省级联动
                select_data_copy();//住所省级联动初始化
            }
        });
    }


    //触发事件
    function select_keyup(){

        $("#info_address").val('');
        var str1,str2,str3,str4,address;
        var select_city_value =  $("#select_city").val();
        var select_area_value =  $("#select_area").val();
        var select_stree_value = $("#select_stree").val();
        var desc_address_value = $("#desc_address").val();

        if(select_city_value){str1 = $("#select_city").find("option:selected").text();}
        if(select_area_value){str2 = $("#select_area").find("option:selected").text();}
        if(select_stree_value&&select_stree_value!='0'&&select_stree_value!='999999999000'){str3 = $("#select_stree").find("option:selected").text();}
        if(desc_address_value){str4 = $("#desc_address").val();}

        if(str1){address = "浙江省"+str1;}
        if(str2){address+=str2}
        if(str3){address+=str3;}
        if(str1){              //判断市是否选中
            if(str4){address+=str4}
        }
        $("#info_address").val(address);
    }


    function select_data() {
        var jsonData = dataArray;
        var jsonCity = jsonData.codeAddress; //市
        var dataCode ;
        var params_area_address = $("#params_area_address").val();
        var params_stree_address = $("#params_stree_address").val();
        if(params_stree_address && params_stree_address!='0'&&params_stree_address!='999999999000'){   //先判断 街道 是否有街道编码
            dataCode = params_stree_address;
        }else{
            if(params_area_address){  //获取 区或县
                dataCode = params_area_address;
            }
        }
        var select_city, select_area, select_stree;
        if (dataCode) {
            select_city = dataCode.substring(0, 4) + "00000000";              //杭州市
            select_area = dataCode.substring(0, 6) + "000000";                //西湖区
            select_stree = dataCode.substring(0, 9) + "000";                 //街道
        }
        //市
        tm_append_template(jsonCity, "select_city", select_city);
        city_template_data(select_city, select_area, jsonCity);
        area_template_data(select_area, select_stree, jsonArea);

        //根据市选择
        $("#select_city").change(function () {
            jsonArea = null;
            //获取选中的值：
            var selectedValue = $("#select_city").val();
            if (!selectedValue) {
                $("#select_stree").html("<option value=''>-请选择-</option>")
            };
            //如果选择的是空 则 街道 初始化
            if (!selectedValue) {
                $("#select_area").html("<option value=''>-请选择-</option>")
            };
            //如果选择的是空 则 街道 初始化
            city_template_data(selectedValue, null, jsonCity);
        });
        //县或区的选择
        $("#select_area").change(function () {
            //获取选中的值：
            var selectedValue = $("#select_area").val();
            area_template_data(selectedValue, null, jsonArea);
        });
    };




    //初始化和选择触发模板  县或区  selectedCityValue：选中的值    EchoselectedCode：回显的值    data：数据
    function city_template_data(selectedCityValue,EchoselectedCode,data){
        var obj;
        if(!data)return;
        var jsonData_city = data;
        var leng = jsonData_city.length;
        for(var i=0;i<leng;i++){
            if(selectedCityValue==jsonData_city[i].code){
                obj=jsonData_city[i] ;
            }
        }
        //判断选中的是否是 '--请选择--'
        var html;
        if(obj){
            jsonArea = obj.codeAddress;
            tm_append_template(obj.codeAddress,"select_area",EchoselectedCode);
            html = "<option value=''>-请选择-</option>";
            $("#select_stree").html(html);

        }else{
            html = "<option value=''>-请选择-</option>";
            $("#select_area").html(html);
        }
    };

    //初始化和选择触发模板  街道    selecteAreaValue：选中的值,   EchoselectedCode：回显得值   ,data：数据
    function area_template_data(selecteAreaValue,EchoselectedCode,data){
        var obj;
        if(!data)return;
        var jsonData_area = data;
        var leng = jsonData_area.length;
        for(var i=0;i<leng;i++){
            if(selecteAreaValue==jsonData_area[i].code){
                obj=jsonData_area[i] ;
            }
        }
        //判断选中的是否是 '--请选择--'
        if(obj){
            tm_append_template(obj.codeAddress,"select_stree",EchoselectedCode,"area");
        }else{
            var html = "<option value=''>-请选择-</option>";
            $("#select_stree").html(html);
        }
    };

    //数据拼接模板 jsonData：data数据源    target：目标     EchoselectedCode：回显选择的值     falg 是用于判断是否有 街道 的标志
    function tm_append_template(jsonData,target,EchoselectedCode,falg){  //
        if (falg) {
            if (!(jsonData.length != 0)) {
                $("#" + target).html("<option value='0'>无</option>");return;
            }
        }
        var length = jsonData.length;
        var html = "<option value=''>-请选择-</option>";
        for(var i=0;i<length;i++){
            if(EchoselectedCode == jsonData[i].code){
                html +="<option value='"+jsonData[i].code+"' selected >"+jsonData[i].addressName+"</option>";
            }else{
                html +="<option value='"+jsonData[i].code+"'>"+jsonData[i].addressName+"</option>";
            }
        }
        if(target=='select_stree'){
            if($("#params_stree_address").val()&&$("#params_stree_address").val()=='999999999000'){
                html += "<option value='999999999000' selected>其他</option>";
            }else{
                html += "<option value='999999999000'>其他</option>";
            }
        }
        $("#"+target).html(html);
    };


    function select_data_copy() {
        //初始化设置数据
        var jsonData = dataArray;
        var jsonCity = jsonData.codeAddress; //市
        var dataCodeCopy ;
        var params_area_addresscopy = $("#params_area_addresscopy").val();
        var params_stree_addresscopy = $("#params_stree_addresscopy").val();

        if(params_stree_addresscopy && params_stree_addresscopy!='0'&&params_stree_addresscopy!='999999999000'){   //先判断 街道 是否有街道编码
            dataCodeCopy = params_stree_addresscopy;
        }else{
            if(params_area_addresscopy){  //获取 区或县
                dataCodeCopy = params_area_addresscopy;
            }
        }
        var select_city, select_area, select_stree;
        if (dataCodeCopy) {
            select_city = dataCodeCopy.substring(0, 4) + "00000000";              //杭州市
            select_area = dataCodeCopy.substring(0, 6) + "000000";                //西湖区
            select_stree = dataCodeCopy.substring(0, 9) + "000";                 //街道
        }
        //市
        tm_append_template_copy(jsonCity, "select_city_copy", select_city);
        city_template_data_copy(select_city, select_area, jsonCity);
        area_template_data_copy(select_area, select_stree, jsonArea2);


        //根据市选择
        $("#select_city_copy").change(function () {
            jsonArea2 = null;
            //获取选中的值：
            var selectedValue = $("#select_city_copy").val();
            if (!selectedValue) {
                $("#select_stree_copy").html("<option value=''>-请选择-</option>")
            };
            //如果选择的是空 则 街道 初始化
            if (!selectedValue) {
                $("#select_area_copy").html("<option value=''>-请选择-</option>")
            }
            //如果选择的是空 则 街道 初始化
            city_template_data_copy(selectedValue, null, jsonCity);
        });
        //县或区的选择
        $("#select_area_copy").change(function () {
            //获取选中的值：
            var selectedValue = $("#select_area_copy").val();
            area_template_data_copy(selectedValue, null, jsonArea2);
        });
    };


    //初始化和选择触发模板  县或区  selectedCityValue：选中的值    EchoselectedCode：回显的值    data：数据
    function city_template_data_copy(selectedCityValue,EchoselectedCode,data){
        var obj;
        if(!data)return;
        var jsonData_city = data;
        var leng = jsonData_city.length;
        for(var i=0;i<leng;i++){
            if(selectedCityValue==jsonData_city[i].code){
                obj=jsonData_city[i] ;
            }
        }
        //判断选中的是否是 '--请选择--'
        var html;
        if(obj){
            jsonArea2 = obj.codeAddress;
            tm_append_template_copy(obj.codeAddress,"select_area_copy",EchoselectedCode);
            html = "<option value=''>-请选择-</option>";
            $("#select_stree_copy").html(html);

        }else{
            html = "<option value=''>-请选择-</option>";
            $("#select_area_copy").html(html);
        }
    };

    //初始化和选择触发模板  街道    selecteAreaValue：选中的值,   EchoselectedCode：回显得值   ,data：数据
    function area_template_data_copy(selecteAreaValue,EchoselectedCode,data){
        var obj;
        if(!data)return;
        var jsonData_area = data;
        var leng = jsonData_area.length;
        for(var i=0;i<leng;i++){
            if(selecteAreaValue==jsonData_area[i].code){
                obj=jsonData_area[i] ;
            }
        }
        //判断选中的是否是 '--请选择--'
        if(obj){
            tm_append_template_copy(obj.codeAddress,"select_stree_copy",EchoselectedCode,"area");
        }else{
            var html = "<option value=''>-请选择-</option>";
            $("#select_stree_copy").html(html);
        }
    };

    //数据拼接模板 jsonData：data数据源    target：目标     EchoselectedCode：回显选择的值     falg 是用于判断是否有 街道 的标志
    function tm_append_template_copy(jsonData,target,EchoselectedCode,falg){  //
        if (falg) {
            if (!(jsonData.length != 0)) {
                $("#" + target).html("<option value='0'>无</option>");return;
            }
        }
        var length = jsonData.length;
        var html = "<option value=''>-请选择-</option>";
        for(var i=0;i<length;i++){
            if(EchoselectedCode == jsonData[i].code){
                html +="<option value='"+jsonData[i].code+"' selected >"+jsonData[i].addressName+"</option>";
            }else{
                html +="<option value='"+jsonData[i].code+"'>"+jsonData[i].addressName+"</option>";
            }
        }
        if(target=='select_stree_copy'){
            if($("#params_stree_addresscopy").val()&&$("#params_stree_addresscopy").val()=='999999999000'){
                html += "<option value='999999999000' selected>其他</option>";
            }else{
                html += "<option value='999999999000'>其他</option>";
            }
        }
        $("#"+target).html(html);
    };



    ////////////////////////////////////////////////行政区划 end ////////////////////////////////////////////////////

    laydate.skin('molv');//初始化皮肤
    var end = {
            elem: '#valTo',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             //结束日选好后，重置开始日的最大日期
            }
        };

     //开始时间和结束时间
     $("#valTo").click(function(){laydate(end);});
    //提交表单初始化
    function tableInit(){  	
        //设置为年报状态不为未公示及待修改时表单不能修改
    	if(window._CONFIG._reportState !='00' && window._CONFIG._reportState !='13' && window._CONFIG._reportState !='20' ){
            $("input,select").attr("disabled","disabled");
    		$(":radio").attr("disabled","disabled");
    		$(":checkbox").attr("disabled","disabled");
    		$(".pbReport").attr("disabled","disabled");
    		$(".pbReportbutton").hide();
    		$(".icon-close").hide();
    	}
    	//共产党员党建情况初始化(党建情况属于基本信息表单中，但信息处在基本信息表单之外，将展示党建情况中的填报值传给隐藏表单)
    	innitPart();
    }
    
    //共产党员党建情况初始化
	function innitPart(){
		if($("#rreeTaxYes").prop("checked")){ //属于免税对象时，纳税总额初始化
  			$("#ratGro").val("0.00");
  			$("#ratGro").attr("readonly","readonly");
  			$("#ratGro").removeClass("required");
    		$(".viewicon").hide();
  		 }else{
  			$("#ratGro").removeAttr("readonly","readonly");
  			$("#ratGro").addClass("required");
  		 }
		if($("#resParMSignNO").prop("checked")){  //经营者不为党员时，经营者是否为党组织书记不必选
			$(".resParSecSign").attr("disabled","true");
			$(".resParSecSign").removeAttr("checked");
  		 }else{
  			$(".resParSecSign").removeAttr("disabled","true");
  		 }
		if ($("#isComphone option:selected").val() == 1) {
     	    $("#_tel").focus();
            $("#_tel").addClass("required");
            $("#_tel").removeAttr("readonly","readonly");
        } else {
     	   $("#_tel").attr("readonly","readonly");$("#_tel").removeClass("required");
        }
		
	};

    
    /**
     * 许可证初始化(传值为年报id)
     */
    function initlicence(){
    	 loadData_one(0,5);
    };
    
    function loadData_one(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/pb/pblicence/licencelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination1').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,  //每页条数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_one(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("valto", function(valTo) {
                	if(valTo =="9999-09-09"){
                		return "长期有效";
                	}else{
                		return valTo;
                	}
                });
                var myTemplate = handlebars.compile($('#table-template-one').html());
                $('#dbao_page_one').html(myTemplate(data));
                $("#itemCount1").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount1").text(pageNum);//共多少页
            }
        });
    };
    
    
   

    /**
     * 基本信息表单验证 并保存
     */
    var _flag = false;  //提交标志
    var saveFlag = false;   //是暂存还是预览（暂存提示保存成功  预览保存后  直接打开新页面）
    function formValid() {
        $('#form').validate({
            rules: {
                tel:{
                    required: function(){
                        var _v = $("#isComphone option:selected").val();
                        if(_v=='1'){return true;}
                        return false;
                    },
                    telandphone:true
                },
            	comPhone: { //联系手机号码
                    required: true,
                    telandphone:true
                },
                opLoc: { //经营场所
                    //required: true
                },
                fundAm: { //累积已投入经营资金
                    required: true,
                    min:0
                },
                pbFundAm: { //其中，2015年投入经营资金
                    required: true,
                    min:0
                },
                empNum: { //2015年末,从业人数（含雇工）
                    required: true,
                    digits:true,
                    min:1
                },
                uniGradEmps: { //雇工人员中属于高校毕业生
                    required: true,
                    digits:true
                },
                exSoldEmps:{ //雇工人员中属于退役士兵
                    required: true,
                    digits:true
                },
                disEmps: { //雇工人员中属于残疾人
                    required: true,
                    digits:true
                },
                unemEmps: { //雇工人员中属于失业人员再就业
                    required: true,
                    digits:true

                },
                vendInc:{
                    required: true
                },
                numParM: { //从业人员中，有中共党员（含预备党员）
                    required: true,
                    digits:true
                },
                isLegRep:{//经营者属于
                	required:true
                },
                vendIncIsPub:{//营业额或营业收入是否公示
                	required:true
                },
                rreeTaxIs:{//是否属于免征税对象
                	required:true
                },
                ratGroIsPub:{//纳税总额是否公示
                	required:true
                },
                partOrgIs:{//是否已独立或联合建立党支部
                	required:true
                },
                resParMSign:{//经营者本人是否为党员
                	required:true
                },
                websiteFlag:{  //是否有网站
                    required:function(){
                        //判断当前网站网店是否选中一项
                        var vs = $("input:radio[name=websiteFlag]:checked").val();
                        if(!vs){layer.tips('请选择一项', '#js-yes', {tips:3, tipsMore:true, ltype:0});return true;}else{return false;}
                    }
                },
                //**************************************省级联动 start*********************************//
                cityAddressCopy: { // 住所-市
                    required: true
                },
                areaAddressCopy: { // 住所-县区
                    required: true
                },
                streeAddressCopy: { //住所-街道
                    required: true
                },
                cityAddress: { //地址-市
                    required: true
                },
                areaAddress: { //地址-县区
                    required: true
                },
                streeAddress: { //地址-街道
                    required: true
                },
                desAddress: { //地址-描述信息
                    required: true,
                    specials:true,
                    maxlength:200
                }
                //**************************************省级联动 end*********************************//
            },
            messages: {
            	empNum:{
            		min:"从业人数不允许填写0和负数，必须是大于1及以上的整数!"
            	},
            	fundAm:{
            		min:"累积已投入经营资金应大于或等于0"
            	},
            	pbFundAm:{
            		min:"当前年份已投入资金应大于或等于0"
            	}
              /*  cityAddressCopy:"请选择一项",
                areaAddressCopy:"请选择一项",
                streeAddressCopy:"请选择一项",

                cityAddress:"请选择一项",
                areaAddress:"请选择一项",
                streeAddress:"请选择一项"*/
            },
            onkeyup:false,
            onfocusout:function(el){
                var parentEle, cls,ele = $(el);
                if (ele.valid()) {
                    if (ele.is('input') && ele.attr('type') != 'text') {
                        cls = 'error-tips-radio';
                        ele.closest('.radio-box').removeClass(cls);
                    } else if (ele.is('select')) {
                        cls = 'error-tips';
                        ele.removeClass(cls);
                    } else {
                        cls = 'error-tips';
                        ele.removeClass(cls);
                        parentEle = ele.parent();
                        if (parentEle.has('.js-error-tips').length) {
                            parentEle.find('.js-error-tips').remove();
                        }
                    }
                }
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#form input[name='+i+'],#form select[name='+i+']'), index, parentEle, cls;
                    if (ele.is('input') && ele.attr('type') != 'text') {
                        cls = 'error-tips-radio';
                        ele.closest('.radio-box').addClass(cls);
                    } else if (ele.is('select')) {
                        cls = 'error-tips';
                        ele.addClass(cls);
                    } else {
                        cls = 'error-tips';
                        ele.addClass(cls);
                        parentEle = ele.parent();
                        if (!parentEle.has('.js-error-tips').length) {
                            parentEle.append('<em class="js-error-tips error-tips-icon"></em>');
                        }
                    }
                    (function (i) {
                        parentEle && (parentEle.find('.js-error-tips').hover(function () {
                            index = layer.tips(errorMap[i], $(this), {tips: 3, time: 0})
                        }, function () {
                            layer.close(index);
                        }))
                    })(i);
                }
            },
            submitHandler: function () {

                //判断网站是否有添加信息
                if($('#js-yes').is(':checked')){
                    if($('#_websit').attr("dataSize")==0){
                        layer.msg('您网站或网店信息还未进行添加信息!',{time:3000});
                        $("#js-checkbox-one").focus();
                        layer.tips('请选中一项进行添加', '#js-checkbox-one', {tips:3, tipsMore:true, ltype:0,time:6000});
                        return ;
                    }
                }

            	//校验通过提交
            	if(check()){
            		_flag = true;
            		_submit();
            	}
            	
            	//数据及填写范围校验（单个事件加校验（提示）  同时提交加校验，确保不会重复提交）
            	function check(){
            		var flag = true;

            		 //2015年投入经营资金额≤累计已投入经营资金额 ✔
            		 //累计金额
            		 var fundAm = Number($("#fundAm").val()) * 100;
            		 //2015金额
            		 var pbFundAm = Number($("#pbFundAm").val()) * 100;
            		 if(pbFundAm > fundAm){
            			 flag = false;
            			 commitFlag = false;
         	        	 $("#pbFundAm").focus();
            			 layer.tips('当前年份年投入经营资金额应小于或等于累计已投入经营资金额!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#pbFundAm',{tips:3, tipsMore:true, ltype:0,time:0});
            		     return false;
            		 } 
            		 
            		 // 从业人数>雇工中的高校毕业生数+退役士兵数+残疾人数+失业再就业人数之和 ✔
            		 var empNum = Number($("#empNum").val());//从业人数
            		 var uniGradEmps = Number($("#uniGradEmps").val());//高校毕业生数
            		 var exSoldEmps = Number($("#exSoldEmps").val());//退役士兵数
            		 var disEmps = Number($("#disEmps").val());//残疾人数
            		 var unemEmps = Number($("#unemEmps").val());//失业再就业人数
            		 if(empNum <= (uniGradEmps+exSoldEmps+disEmps+unemEmps)){
            			 flag = false;
            			 $("#empNum").focus();
         	             layer.tips('从业人数应大于雇工中的高校毕业生数加退役士兵数加残疾人数加失业再就业人数之和!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#empNum',{tips:3, tipsMore:true, ltype:0,time:0});
            		     return false;
            		 }
            		 
            	     //　属于“免征纳税”情况时，则纳税总额自动为“0”，不可修改；不属于免征纳税情况时，纳税总额必须≥0 ✔
            		 if($("#rreeTaxYes").prop("checked")){
            			 $("#ratGro").val("0.00");
            			 $("#ratGro").attr("readonly","readonly");
            		 }else{
            			 if(Number($("#ratGro").val()) < 0){
            				 $("#ratGro").focus();
             	             layer.tips('纳税总额必须大于或等于0!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                                 '#ratGro',{tips:3, tipsMore:true, ltype:0,time:0});
             	             flag = false;
            				 return false;
            			 }
            		 }
            		 
            		//　党员人数≤从业人数 ✔
            		 var numParM = Number($("#numParM").val());//党员人数
            		 if(numParM > empNum){
            			 flag = false;
        				 $("#numParM").focus();
         	             layer.tips('党员人数应小于或等于从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#numParM',{tips:3, tipsMore:true, ltype:0,time:0});
            			 return false
            		 }

            		 //经营者本人为党员时 必须选择经营者是否为党组织书记 ；不为党员 是否为党组织书记不需选择
            		 if($("#resParMSignYes").prop("checked")){
            			 if($(".resParSecSign:checked").length < 1){
            				 $("#resParMSignYes").focus();
             	             layer.tips('请选择 经营者本人是否为党组织书记!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                                 '.resParSecSign',{tips:3, tipsMore:true, ltype:0,time:0});
            				 flag = false;
            				 return false;
            			 } 
            		 }else{
            			 if($("#resParMSignNO").prop("checked")){
            				 $(".resParSecSign").attr("readonly","readonly");
            			 }
            		 }
            		 return flag;
            	}
            	
                //提交：
                function _submit() {
                	var formParam = $('#form').serializeObject();
                    http.httpRequest({
                        url: '/reg/client/yr/pb/pbbaseinfo/save',
                        serializable: false,
                        data: formParam,
                        type: 'post',
                        async:false,
                        success: function (data) {
                        	if(data.status= "success"){
                        		if(saveFlag){
                        			layer.msg("保存成功", {time: 1000}, function () {
                        				window.location.reload();
                                    });
                        		}
                        	}else{//失败
                        		layer.msg("保存失败", {time: 1000}, function () {
                                });
                        	}  
                        }
                    });
                }	
            }
        })
    };

    /**
     * licence from表单提交
     */
    function licenceformValid(){
        $('#licenceForm').validate({
            rules: {
            	licNameCN: {required:true,maxlength: 50 },
            	valTo: {required:true}
            },
            messages: {
            	licNameCN:{required:"请选择一种许可证!",maxlength:"许可证名称最大长度为25"},
            	valTo:{required:"请选择许可证日期!"}

            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#licenceForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#licenceForm').serializeObject();
                http.httpRequest({
                    url: '/reg/client/yr/pb/pblicence/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                     $('#licenceForm')[0].reset();//输入框重置为空*/
                     $('.lichidden').val('');  //隐藏框重置
                     if(data.status=='success'){
                       	 if(data.msg =='1'){//修改
                       		 layer.msg("表单修改成功", {time: 1000}, function () {   
                                 $("#mod_licence").slideUp("slow");//设置添加框隐藏
                       	 });
                        }else{
                        	layer.msg("表单保存成功", {time: 1000}, function () {   
                      	 });
                        }	 
                       	initlicence();  
                     }else{
                    	   layer.msg(data.msg, {time: 1000}, function () {   
                            
                       	 });
                       }
                    }
                });
            }
        })
    };


    //按钮事件
    function bind() {
        util.bindEvents([	     	     
	     {
	         el: '#licenceList', //选择许可证列表
	         event: 'click',
	         handler: function () {
                layer.dialog({
                    title: '许可证列表',
                    area: ['500px', '600px'],
                    content: '/reg/client/yr/pb/pbbaseinfo/treeview',
                    callback: function (data) {
                    	if(data.reload!=null){
               			 $("#licNameCN").val(data.reload.returnName);
                         $("#licName").val(data.reload.returncode);
               		}
                    }
                })    
	         }
	     },
        {
            el: '#js-add',  //许可证添加
            event: 'click',
            handler: function () {
                $("#mod_licence").slideDown().show();
            }
        } ,
        {
            el: '#js-edit',
            event: 'click',
            handler: function() {//修改操作
                var id;
                var index=0;
                $(":checkbox[name=licencechose]:checked").each(function(k,v){
                	id=this.value; 
                	index++; 
                });
                
                if(index==0){
                    layer.msg("请您<em style='color: red;'>【选择一条】</em>进行修改操作!", {icon: 7,time: 1000});
                	return false;                	
                }
                
                if(index>1){
                    layer.msg("当前操作<em style='color: red;'>【只能选择一条】</em>进行修改操作!", {icon: 7,time: 1000});
                	return false;
                }
                $('#licenceForm')[0].reset();//输入框重置为空*/
                $('.lichidden').val('');  //隐藏框重置
               
                http.httpRequest({
                    url: '/reg/client/yr/pb/pblicence/show',
                    serializable: false,
                    data: {licID:id},
                    type: 'post',
                    success: function (data) {
                    	$("#mod_licence").slideDown().show();
                    	var data=data.data;
                    	 $("#anCheID").val(data.anCheID);
                    	 $("#licName").val(data.licName);
                    	 $("#licID").val(data.licID);
                    	 $("#licNameCN").val(data.licNameCN);
                    	 $("#valTo").val(data.valTo);
                    }
                })     
            }
        },
        {
            el: '#js-delete',
            event: 'click',
            handler: function() {//删除操作
              var ids=new Array();
                 $(":checkbox[name=licencechose]:checked").each(function(k,v){
                	ids[k]=this.value; 
                 });
                 if(ids[0]==""||ids[0]==null){
                     layer.msg("请您<em style='color: red;'>【至少选择一条】</em>进行删除操作!", {icon: 7,time: 1000});
                	 return false;
                 }
               
                layer.confirm('您确定要删除选中的<em style="color: red;">'+ids.length+'</em>数据吗？', {
                    icon: 2,
                    title: '提示'
                },
                function(index) {
                    http.httpRequest({
                        url: '/reg/client/yr/pb/pblicence/batchDelete',
                        data: {
                        	licenceIds:ids.toString()
                        },
                        success: function(data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {
                                        time: 500
                                    },
                                    function() {
                                    	initlicence();//刷新表格
                                    });
                                }
                            } else {
                                if (data.msg) {
                                    layer.msg(data.msg, {
                                        time: 500
                                    },
                                    function() {
                                    	initlicence();//重新刷新表格
                                    });
                                }
                            }
                        }
                    });

                });
            }
        },
        {
            el: '#licenceCancel', //许可证取消
            event: 'click',
            handler: function () {
             $('#licenceForm')[0].reset();//输入框重置为空*/
             $("#mod_licence").slideUp("slow");//设置输入修改框隐藏 
            }
        },
        {
        	 el: '#checkLicAll', //许可证全选触发
             event: 'click',
             handler: function () {
            	 var flag=$(this).prop("checked");
    	         $("input:checkbox[name='licencechose']").prop("checked", flag);
             }	   	  
        },
       { el: '#save', //表单保存触发
           event: 'click',
           handler: function () {
        	   saveFlag = true;
        	   $("#form").submit();
           }	   
       },
       { el: '#view', //预览并提交表单触发
           event: 'click',
           handler: function () {
        	   var num = window._CONFIG. _empNum;
               var url = "/reg/client/yr/pb/pbbaseinfo/view?year="+$("#encodeYear").val();
               if (objWin == null || objWin.closed) {
             	  if(window._CONFIG. _empNum == null || window._CONFIG. _empNum == "" ){
       	             layer.msg("请先保存年报",500);
             	  }else{
             		  saveFlag = false;
             		  $("#form").submit();

                      //判断网站网店是否填写
                      var websiteFlagValue =  $("input:radio[name=websiteFlag]:checked").val();
                      if(!websiteFlagValue){
                          layer.tips('请选择一项', '#js-yes', {tips:3, tipsMore:true, ltype:0});
                          return;
                      }

             		  if(!_flag){return;}
             		  else{
                          objWin = window.open(url);
             		  }
             	  }
               } else {
                   layer.msg("<em style='color: red;font-size: 16px;'>【预览并提交】已经处于打开的状态</em>", {icon: 7,time: 3000});
               }
           }	   
       },
       { el: '#longTime', //无有效期或长期有效事件触发
           event: 'click',
           handler: function () {
        	   if($(this).prop("checked")){
        			$("#valTo").val("9999-09-09");
        		}else{
        			$("#valTo").val("");
        		}
           }	   
       }, {
           el: '#printpbreport',
           event: 'click',
           handler: function () {
        	  var _id = "_doPrint_"+new Date().getTime();
              var url = "/reg/client/yr/pb/yrprint/printPubPbPrintProve?year="+$("#encodeYear").val();
              try{
                  window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
              }catch(e){
                  alert("打印错误!");
              }  
              /* layer.dialog({
                   title: '打印年度报告证明',
                   area: ['100%', '100%'],
                   content: url,
                   callback: function (data) {
                       //重新加载列表数据
                       if (data.reload) {
                           table.ajax.reload();
                       }
                   }
                })*/
           }
       },{ el: '#isComphone', //对外公开联系电话中事件改变
           event: 'change',
           handler: function () {
        	   $("#comPhone").val("");
               if ($("#isComphone option:selected").val() == 1) {
            	   $("#_tel").focus();
                   $("#_tel").addClass("required");
                   $("#_tel").removeAttr("readonly","readonly");

               } else {
            	   $("#_tel").attr("readonly","readonly");
                   $("#_tel").removeClass("required");
                   clearform.clearSelect($("#_tel"));//消除验证的红色边框和提示
               }
           }
       },
       { el: '#rreeTaxNo', //不属于免征税对象
           event: 'click',
           handler: function () {
        	   if(!$(this).prop("checked")){
      			$("#ratGro").val("0.00");
      			$("#ratGro").attr("readonly","readonly");
      			$("#ratGro").removeClass("required");
      			$(".viewicon").hide();
      		 }else{
      			$("#ratGro").removeAttr("readonly","readonly");
      			$("#ratGro").addClass("required");
      			$(".viewicon").show();
      			if(Number($("#ratGro").val()) < 0){
      			 $("#ratGro").focus();
   	             layer.tips('纳税总额必须大于或等于0!','#ratGro',{tips:3, tipsMore:true, ltype:0});
     			}
      		 }
           }	   
       },
       { el: '#rreeTaxYes', //属于免征税对象
           event: 'click',
           handler: function () {
        	   if($(this).prop("checked")){
      			$("#ratGro").val("0.00");
      			$("#ratGro").attr("readonly","readonly");
      			$("#ratGro").removeClass("required");
      			$(".viewicon").hide();
      		 }else{
      			$("#ratGro").removeAttr("readonly","readonly");
      			$("#ratGro").addClass("required");
      			$(".viewicon").show();
      			if(Number($("#ratGro").val()) < 0){
       			     $("#ratGro").focus();
    	             layer.tips('纳税总额必须大于或等于0!','#ratGro',{tips:3, tipsMore:true, ltype:0});
      			}
      		 }
           }	   
       },
       { el: '#resParMSignYes', //经营者本人为党员
           event: 'click',
           handler: function () {
        	   if($(this).prop("checked")){
          		$(".resParSecSign").removeAttr("disabled","true");
        		if($(".resParSecSign:checked").length < 1){
      	            layer.tips('请选择 经营者本人是否为党组织书记！','.resParSecSign',{tips:3, tipsMore:true, ltype:0});
        		}
      		 }else{
       			$(".resParSecSign").attr("disabled","true");
      		 }	   
           }
      
       },
       { el: '#resParMSignNO', //经营者本人不为党员
           event: 'click',
           handler: function () {
        	   if(!$(this).prop("checked")){
             	$(".resParSecSign").removeAttr("disabled","true");
        		if($(".resParSecSign:checked").length < 1){
      	            layer.tips('请选择 经营者本人是否为党组织书记！','.resParSecSign',{tips:3, tipsMore:true, ltype:0});
        		}
      		 }else{
      			$(".resParSecSign").removeAttr("checked");
      			$(".resParSecSign").attr("disabled","true");      		 }	   
           }
       },
       {
         	 // 申请修改年报（6月30日后 或者 之前年度）
         	 el: '#modapply',
           event: 'click',
           handler: function () {
              var url = window._CONFIG.mod_url + "?year=" + $("#encodeYear").val();
              window.open(url);
           }
         },{
        	// 修改年报（6月30日前）
        	el: '#mod',
          event: 'click',
          handler: function () {
            layer.confirm('确定修改年度报告？', {icon: 7, title: '提示'}, function (index) {
	          	http.httpRequest({
	                  url: '/reg/client/yr/yrcommit/pb/modreport',
	                  data: {year: $("#year").val()}, //未加密的年份
	                  success: function (data) {
	                      if (data.status == 'success') {
	                      	layer.msg(data.msg, {time: 1000}, function () {
	                      		//成功后现有页面刷新
	                          	location.assign('/reg/client/yr/pb/pbbaseinfo/list?year=' + $("#year").val() + "&pripid=" + window._CONFIG.pripid);
	                              return;
	                          });
	                      }else {
	                      	layer.msg(data.msg, {time: 1000}, function () {
	                              return;
	                          });
	                      }
	                  }
	              });
	          	layer.close(index);
            });
          }
        },
        {
            el: '.js_close_tips',          //触发提示关闭tip层
            event: 'click',
            handler: function () {
                layer.closeAll('tips'); //关闭所有的tips层
            }
        },

//------- 网站网店 js  start ------
            {
                el: '#js-yes',  //是
                event: 'click',
                handler: function () {
                    $("#js-checkbox").show();
                }
            },
            {
                el: '#js-checkbox-one',  //添加 信息网站
                event: 'click',
                handler: function () {
                    var $this= $(this);
                    var wz_params  = $("#form-wz-params").serialize();
                    if($this.is(':checked')){
                        wz_params +="&selectedValue="+$("#js-checkbox-one").val();
                        layer.dialog({
                            title: ['', 'font-size:18px;background:#deeef7;'],
                            closeBtn: 0,
                            area: ['78%', '60%'],
                            content: '/reg/client/yr/pb/website/show?'+wz_params,
                            callback: function (data) {
                                $this.prop("checked",false);
                                if(data.reload==true){
                                    loadData_webSite();//加载列表
                                }
                            }
                        });
                    }
                }
            },
            {
                el: '#js-checkbox-two',  //添加 交易网站
                event: 'click',
                handler: function () {
                    var $this= $(this);
                    var wz_params  = $("#form-wz-params").serialize();
                    if($this.is(':checked')){
                        wz_params += "&selectedValue=" + $("#js-checkbox-two").val();
                        layer.dialog({
                            title: ['', 'font-size:18px;background:#deeef7;'],
                            closeBtn: 0,
                            area: ['80%', '60%'],
                            content: '/reg/client/yr/pb/website/show?' + wz_params,
                            callback: function (data) {
                                $this.prop("checked",false);
                                if(data.reload==true){
                                    loadData_webSite();//加载列表
                                }
                            }
                        });
                    }
                }
            },
            {
                el: '#js-checkbox-three',  //添加 网店
                event: 'click',
                handler: function () {
                    var $this= $(this);
                    var wz_params  = $("#form-wz-params").serialize();
                    if($this.is(':checked')){
                        wz_params += "&selectedValue=" + $("#js-checkbox-three").val();
                        layer.dialog({
                            title: ['', 'font-size:18px;background:#deeef7;'],
                            closeBtn: 0,
                            area: ['80%', '60%'],
                            content: '/reg/client/yr/pb/website/show?' + wz_params,
                            callback: function (data) {
                                $this.prop("checked",false);
                                if(data.reload==true){
                                    loadData_webSite();//加载列表
                                }
                            }
                        });
                    }
                }
            },
            {
                el: '#js-no', //企业无网站或网店
                event: 'click',
                handler: function () {
                    $("#js-checkbox").hide();
                    var $this = $(this);
                    var list_value = $("#_websit").attr("dataSize");
                    if(list_value>0){
                        layer.confirm('该操作将清空已录入的网站或网店信息,您确定继续吗？',
                            { btn: ['确定', '取消'],icon: 3, title: '提示',closeBtn:0}, function (index) {
                                var formParam  = $("#form-wz-params").serializeObject();
                                http.httpRequest({
                                    url: '/reg/client/yr/pb/website/delete_all',
                                    serializable: false,
                                    data:formParam,
                                    type: 'post',
                                    success: function (data) {
                                        if(data.status=='success'){
                                            layer.msg("网站或网店信息已清空！" ,{icon: 1,time: 1000}, function () {
                                                loadData_webSite();//加载列表
                                            });
                                        }
                                    }
                                });
                            },function(){
                                layer.msg('请重新选择【是】或【否】');
                                $this.prop("checked",false);
                            });
                    }
                }
            },
            {
                el: '._delete',// 网站或网店 删除
                event: 'click',
                handler: function () {
                    var $this = $(this);
                    var webid = $(this).data("webid");//类型
                    var anCheID= $(this).data("ancheid");//年报ID
                    layer.confirm('您确定要执行删除操作吗?', { btn: ['确定', '取消'],icon: 3, title: '提示'}, function () {
                        http.httpRequest({
                            url: '/reg/client/yr/pb/website/delete',
                            serializable: false,
                            data: {"webid":webid,'anCheID':anCheID},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                    layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                        loadData_webSite();//加载列表
                                        //$this.parent().parent().remove(); //删除选中的一行
                                    });
                                }
                            }
                        });
                    });
                }
            },
            {
                el: '._show',// 网站或网店 查看详情
                event: 'click',
                handler: function () {
                    var webid = $(this).data("webid");
                    layer.dialog({
                        title: '',
                        area: ['80%', '48%'],
                        content: '/reg/client/yr/pb/website/view?webid='+webid,
                        callback: function (data) {
                        }
                    });
                }
            }
//------- 网站网店 js  start ------
        ])
    }
    //网站 网店加载列表：
    function loadData_webSite() {
        var _params = $('#form-wz-params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/pb/website/doReadList',
            serializable: false,
            data: _params,
            type: 'post',
            success: function (data) {
                if(data){
                    if(data.data&&data.data.length>0){
                        var len = data.data.length;
                        $("#_websit").attr("dataSize",len);
                    }else{
                        $("#_websit").attr("dataSize",'0');
                    }
                    if(data.status=='success'){
                        //判断是网站还是网店
                        var handleHelper = handlebars.registerHelper("descText", function(webType) {
                            if(webType&&webType=='2'){
                                return '网店(或微店)';
                            }else{
                                var webSmallType = this.webSmallType;
                                if(webSmallType){return webSmallType=='1'?'交易网站':'信息网站';}else{return '';}
                            }
                        });
                        var myTemplate = handlebars.compile($("#table-template-web").html());
                        $('#_websit').html(myTemplate(data));
                    }
                }
            }
        });
    };
});
