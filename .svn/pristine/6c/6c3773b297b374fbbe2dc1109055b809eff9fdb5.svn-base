require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 
         'jquery.validate', 'jquery.serialize', 'laydate','pagination','common/validateRules'],
function(layer, dataTable, util, http, handlebars) {
    var objWin;
//    json_data_array();//初始化联动数据
    init();
//    var dataArray;  //省市县数据
//    var jsonArea ;  //县 或 区
//    var jsonArea2 ;  //县 或 区
    /**
     * 初始化函数集合
     */
    function init() {
    	tableInit();
    	initlicence();//初始化许可证
    	initwebsite();//初始化网站    	
    	formValid();
    	websiteformValid()
//        websitformValid();
        licenceformValid();
        lianxiValid();
        bind();
//        $("#select_city, #select_area, #select_stree, #desc_address,#icon-close-delete").on("click keyup", select_keyup);//触发事件
    }

    ////////////////////////////////////////////////行政区划 start ////////////////////////////////////////////////////

//提取数据
    function json_data_array(){
        //初始化设置数据
        http.httpRequest({
            url: '/reg/server/yr/SelectCodeAddress/getJson',
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
        //设置当前年报的纸质补录状态为已补录时不可编辑
//    	if(window._CONFIG._addRecState =='2' ){
//    		$(":radio").attr("disabled","disabled");
//    		$(":checkbox").attr("disabled","disabled");
//    		$(".pbReport").attr("disabled","disabled");
//    		$(".pbReportbutton").hide();
//    		$(".icon-close").hide();
//    		$(".select-txt").attr("disabled","disabled");
//            $("input,select").attr("disabled","disabled");
////            $(".icon-close,.btn-save,._wesittrhide,._delete").hide();
//    	}
    	
    	var websiteFlag = $("input:radio[name='websiteFlag']:checked").val();//是否有网站
    	if(websiteFlag == "0"){//否选中
    		$("#js-website-add").hide();
    	}
    	
    	
    	//初始化联系信息
    	initeppassword();
    	//共产党员党建情况初始化(党建情况属于基本信息表单中，但信息处在基本信息表单之外，将展示党建情况中的填报值传给隐藏表单)
    	innitPart();
    	//初始化财务数据
		initFinance();
		
		
    }
    
    //初始状态下若有联络员备案信息  则显示   若无  则添加非空验证
    function initeppassword(){
    	if(window._CONFIG.pubEppassword != null && window._CONFIG.pubEppassword != ""){
    		$("#lerep").val(window._CONFIG.leRep);
    		if(window._CONFIG.leRepPhone != null && window._CONFIG.leRepPhone != "" && (window._CONFIG.leRepPhone).length == 11){
        		$("#lerepphone").val(window._CONFIG.leRepPhone).prop("readonly",true);
    		}
    		$("#lianame").val(window._CONFIG.liaName).prop("readonly",true);
    		$("#tel").val(window._CONFIG.tel).prop("readonly",true);
    		$("#liaidtype").val(window._CONFIG.liaIDType).prop("readonly",true);
    		$("#liaidnum").val(window._CONFIG.liaIDNum).prop("readonly",true);
    		$(".viewicon").hide();    
    	}else{
//			$("#leRepPhone").addClass("required");
//			$("#leRepPhone").addClass("checkMobile");
//			$("#liaName").addClass("required");
//    		$("#liaPhone").addClass("required").addClass("checkMobile");
//			$("#tel").addClass("required");
//			$("#liaIDNum").addClass("required");
//			$("#liaIDType").addClass("required");
			$("#liaidtype").removeAttr("onfocus").removeAttr("onchange");
			if ($("#liaidtype option:selected").val() == '10') {
	             $("#liaidnum").addClass("idCard");
	         }else{
	        	 $("#liaidnum").removeClass("idCard");
	         }
    		$(".viewicon").show();
    	}
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
     	   $("#comPhone").focus();
            $("#comPhone").addClass("required");
            $("#comPhone").removeAttr("readonly","readonly");
           var patten = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})|(([0-9]{3,4}-)?[0-9]{7,8})$/ ;
	         if(! patten.test($("#comPhone").val())){
	            layer.tips('请输入正确的手机号码或固定电话如：1388888888或0571-8888888','#comPhone',{tips:3, tipsMore:true, ltype:0});
	            commitFlag = false;
	         }
        } else {
     	   $("#comPhone").attr("readonly","readonly");
            $("#comPhone").removeClass("required");
        }
		
	};
        
    //财务数据初始化    
    function initFinance(){
    	//将页面中财务相关输入框中，值为空的，设置默认值0.00
        $(".finance").focus(function() {
            $(this).select();
        }).blur(function() {
             var reg = /^[\-\+]?\d+(\.\d{1,2})?$/;  //只能输入数字和小数的正则表达式,小数点后面保留1到2位{1,2}表示的是小数点后面保留几位小数
             var _v = $(this).val();      //获取当前值
             if(_v){
                 if(!reg.test(_v)){
                     layer.tips('金额为数字且最多精确到分! 如：100.68',$(this),{tips:3, tipsMore:true, ltype:0});
                     $(this).focus();return;
                 }
             }
            //长度校验
            if(_v.length>16){
                layer.tips('您输入的金额度长度超出正常值！',$(this),{tips:3, tipsMore:true, ltype:0});
                $(this).focus();return;
            }

            $(this).val(parseFloat((_v == "" || isNaN(_v) ? "0.00" : _v) - 0).toFixed(2));  //为空或为整数的时候(默认追加小数点后2为小数00)
        });
    }
    
    /**
     * 许可证初始化(传值为年报id)
     */
    function initlicence(){
    	 loadData_one(0,5);
    };
    
    function loadData_one(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/server/yr/pb/pblicence/licencelist.json',
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
     * 初始化网站
     */
    function initwebsite(){
    	loadData(0,5);
    };//初始化网站
    
    function loadData(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/server/yr/pb/pbwebsite/websitelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination2').pagination(itemCount, {
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
                        loadData(page,5);
                    }
                });
                handlebars.registerHelper("num", function(index) {return index+1+(page*5);});//序号
                handlebars.registerHelper("webtype", function(webType) {
                	if(webType == '2') {
                		return "网店";
            		}else if(webType == '1') {
            			return "网站";
        			}
                });
                var myTemplate = handlebars.compile($("#table-template").html());
                $('#dbao_page').html(myTemplate(data));
                $("#itemCount").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount").text(pageNum);//共多少页
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
//                pbFundAm: { //其中，2015年投入经营资金
//                    required: true,
//                    min:0
//                },
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
                    required: true,
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
                }
                //**************************************省级联动 start*********************************//
//                cityAddressCopy: { // 住所-市
//                    required: true
//                },
//                areaAddressCopy: { // 住所-县区
//                    required: true
//                },
//                streeAddressCopy: { //住所-街道
//                    required: true
//                },
//                cityAddress: { //地址-市
//                    required: true
//                },
//                areaAddress: { //地址-县区
//                    required: true
//                },
//                streeAddress: { //地址-街道
//                    required: true
//                },
//                desAddress: { //地址-描述信息
//                    required: true,
//                    maxlength:200
//                }
                //**************************************省级联动 end*********************************//
            },
            messages: {
            	empNum:{
            		min:"从业人数不允许填写0和负数，必须是大于1及以上的整数!"
            	},
            	fundAm:{
            		min:"累积已投入经营资金应大于或等于0"
            	}
//                cityAddressCopy:"请选择一项",
//                areaAddressCopy:"请选择一项",
//                streeAddressCopy:"请选择一项",
//
//                cityAddress:"请选择一项",
//                areaAddress:"请选择一项",
//                streeAddress:"请选择一项"
            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#form input[name='+i+'],#form select[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
            	//判断联络员效验是否通过
//                if(!($('#epasswordForm').valid())){ //效验没有通过则不往下执行
//                    return false;
//                }
            	//校验通过提交
            	if(check()){
            		_flag = true;
            		_submit();
            	}
            	
            	//数据及填写范围校验（单个事件加校验（提示）  同时提交加校验，确保不会重复提交）
            	function check(){
            		var flag = true;
            		
            		//判断是否有网站网店是否选中
                	var websiteFlag = $("input:radio[name='websiteFlag']:checked").val();//是否有网站
                	if(websiteFlag == null || websiteFlag == '' ){
        	            layer.tips('请输入正确的手机号码或固定电话如：1388888888或0571-8888888','#input [name="websiteFlag"]',{tips:3, tipsMore:true, ltype:0});
                	}
            		
            		
            		
            		//判断金额输入值是否满足数据格式
            		$(".finance").each(function(){
            	            var reg = /^[\-\+]?\d+(\.\d{2})?$/;
            	            var _v = $(this).val();      //获取当前值
            	            if(_v){ if (!reg.test(_v)){
//                	            layer.tips('请','.finance',{tips:3, tipsMore:true, ltype:0});
                	            flag = false;
                	            return false; } }
            	            //长度校验
            	            if(_v.length>16){flag = false;return false }
            	        });
            		
            		//判断对外公开联系电话（若有）
            		 if($("#isComphone").val() == '1'){
            	         var patten = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})|(([0-9]{3,4}-)?[0-9]{7,8})$/ ;
            	         if(! patten.test($("#comPhone").val())){
            	        	$("#comPhone").focus();
            	            layer.tips('请输入正确的手机号码或固定电话如：1388888888或0571-8888888','#comPhone',{tips:3, tipsMore:true, ltype:0});
            	        	flag = false;
            	        	return false;
            	         }
            		 }
            		
            		 //2015年投入经营资金额≤累计已投入经营资金额 ✔
            		 //累计金额
            		 var fundAm = Number($("#fundAm").val()) * 100;
            		 //2015金额
//            		 var pbFundAm = Number($("#pbFundAm").val()) * 100;
//            		 if(pbFundAm > fundAm){
//            			 flag = false;
//            			 commitFlag = false;
//         	        	 $("#pbFundAm").focus();
//            			 layer.tips('当前年份年投入经营资金额应小于或等于累计已投入经营资金额!','#pbFundAm',{tips:3, tipsMore:true, ltype:0}); 
//            		     return false;
//            		 } 
            		 
            		 // 从业人数>雇工中的高校毕业生数+退役士兵数+残疾人数+失业再就业人数之和 ✔
            		 var empNum = Number($("#empNum").val());//从业人数
            		 var uniGradEmps = Number($("#uniGradEmps").val());//高校毕业生数
            		 var exSoldEmps = Number($("#exSoldEmps").val());//退役士兵数
            		 var disEmps = Number($("#disEmps").val());//残疾人数
            		 var unemEmps = Number($("#unemEmps").val());//失业再就业人数
            		 if(empNum <= (uniGradEmps+exSoldEmps+disEmps+unemEmps)){
            			 flag = false;
            			 $("#empNum").focus();
         	             layer.tips('从业人数应大于雇工中的高校毕业生数加退役士兵数加残疾人数加失业再就业人数之和!','#empNum',{tips:3, tipsMore:true, ltype:0});
            		     return false;
            		 }
            		 
            	     //　属于“免征纳税”情况时，则纳税总额自动为“0”，不可修改；不属于免征纳税情况时，纳税总额必须≥0 ✔
            		 if($("#rreeTaxYes").prop("checked")){
            			 $("#ratGro").val("0.00");
            			 $("#ratGro").attr("readonly","readonly");
            		 }else{
            			 if(Number($("#ratGro").val()) < 0){
            				 $("#ratGro").focus();
             	             layer.tips('纳税总额必须大于或等于0!','#ratGro',{tips:3, tipsMore:true, ltype:0});
             	             flag = false;
            				 return false;
            			 }
            		 }
            		 
            		//　党员人数≤从业人数 ✔
            		 var numParM = Number($("#numParM").val());//党员人数
            		 if(numParM > empNum){
            			 flag = false;
        				 $("#numParM").focus();
         	             layer.tips('党员人数应小于或等于从业人数!','#numParM',{tips:3, tipsMore:true, ltype:0});
            			 return false
            		 }

            		 //经营者本人为党员时 必须选择经营者是否为党组织书记 ；不为党员 是否为党组织书记不需选择
            		 if($("#resParMSignYes").prop("checked")){
            			 if($(".resParSecSign:checked").length < 1){
            				 $("#resParMSignYes").focus();
             	             layer.tips('请选择 经营者本人是否为党组织书记!','.resParSecSign',{tips:3, tipsMore:true, ltype:0});
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
                	var websiteFlag = $("input:radio[name='websiteFlag']:checked").val();//是否有网站
                    $("#websiteFlag").val(websiteFlag);
                	var formParam = $('#form').serializeObject();
//                	var epasswordForm = $('#epasswordForm').serializeObject();
                    http.httpRequest({
                        url: '/reg/server/yr/pbaddrec/save',
                        serializable: false,
                        data: formParam,
                        type: 'post',
                        async:false,
                        success: function (data) {
                        	if(data.status= "success"){
//                        		console.log(saveFlag);
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
                    url: '/reg/server/yr/pb/pblicence/save',
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

    
    
    /**
     * 
     */
    function lianxiValid(){
    	$('#epasswordForm').validate({
    		rules: {
    			lerep: {required:true,maxlength: 50 },
    			apprevieworg: {checkMobile:true,required:true,maxlength: 50 },
    			lianame: {required:true,maxlength: 50 },
    			lerepphone: {checkMobile:true,required:true,maxlength: 50 },
    			liaidtype: {required:true,maxlength: 50 },
    			liaidnum: {required:true}
    		},
    		onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#epasswordForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
    		submitHandler: function () {
    		}
    	})
    };


    /**
     * webSite from表单提交
     */
    function websiteformValid(){
        $('#websiteForm').validate({
            rules: {
                webType: {required: true},
                webSitName: {required: true , maxlength: 50},
                webSite: {
                	required: true , maxlength: 50 ,
                	url:function(){
//                		var webSiteurl = $("#webSite").val();
//	                	if(webSiteurl.indexOf("http") == -1){
//	                		$("#webSite").val("http"+webSiteurl);
//	                	}
                		return true	;
                	}
                	}
            },
            messages: {
                webType: {required:"请选择一种类型!"},
                webSitName:{required:"请输入网站或网店的名称!",maxlength:"网站名称最大长度为25"},
                webSite:{
                    required:"请输入网址",
                    url:"请输入正确的网站/网店的网址,如：http://www.baidu.com,</br>https://www.baidu.com"
                    	}
            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#websiteForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#websiteForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/yr/pb/pbwebsite/saveWeb',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	 $('input[name="webType"]').attr("selected",false);//下拉框恢复不选中
                         $('#websiteForm')[0].reset();//输入框重置为空*/
                    	 $('.webhidden').val('');  //隐藏框改为空
                    	 if(data.status=='success'){
                        	 if(data.msg =='1'){//修改
                           		 layer.msg("表单修改成功", {time: 1000}, function () {   //操作之后刷新许可证列表
                                     $("#mod_website").slideUp("slow");//设置添加框隐藏
                           	 });
                            }else{
                            	layer.msg("表单保存成功", {time: 1000}, function () {   
                             	 });
                               }	 
                        	   initwebsite();  
                            }else{
                         	   layer.msg(data.msg, {time: 1000}, function () {   
                                   
                             	 });
                             }
                         }
                });
            }
        })
    };
    
    
    
    
    
    
    
    /**
     * webSite from表单提交
     */
    /**
     * 网站 网店 from表单提交
     */
//    function websitformValid(){
//        $('#websitForm').validate({
//            onkeyup:false,
//            rules: {
//                webType: {required: true},
//                webSitName: {required: true,maxlength:100},
//                webSite: {required: true,url:true,maxlength:100}
//            },
//            showErrors:function(errorMap,errorList){
//                for(var i in errorMap){
//                    layer.tips(errorMap[i],$('#websitForm input[name='+i+']'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//                });
//                }
//            },
//            messages: {
//                webType: "请选择一种类型",
//               webSitName:{
//                    required:"请输入网站或网店的名称!",
//                    maxlength:"输入的字数长度不能超过80个字符"
//                },
//                webSitName:"请输入网站或网店的名称!",
//                webSite:{
//                    required:"请输入网址",
//                    url:"请输入正确的网站/网店的网址,如：http://www.baidu.com,</br>https://www.baidu.com"
//                }
//
//            },
//            submitHandler: function () {
//            	if(!setDefaulf()){
//            		return false;
//            	}
//                var formParam = $('#websitForm').serializeObject();
//                http.httpRequest({
//                    url: '/reg/server/yr/pb/pbwebsite/save',
//                    serializable: false,
//                    data: formParam,
//                    type: 'post',
//                    success: function (data) {
//                     if(data.status=='success'){
//                         layer.msg(data.msg, {icon: 1,time: 1000});
//                        //获取当前输入的值：
//                         var webid= data.data; //获取webid主键
//                         var webTypeKey =  $('input[name="webType"]:checked').val();//类型
//                         var webType =  $('input[name="webType"]:checked').val()=='1'?'网站':'网店';//类型
//                         var webSitName = $("#webSitName").val();//名称
//                         var webSite  = $("#webSite").val();//域名icpBackNO
//                         var icpBackNO  = $("#icpBackNO").val();//域名
//                         //模拟的json对象
//                         var data = {
//                             "webType": webType,
//                             "webSitName": webSitName,
//                             "webSite": webSite,
//                             "icpBackNO": icpBackNO,
//                             "webid":webid,
//                             "webTypeKey":webTypeKey
//                         };
//                         var myTemplate = handlebars.compile($("#table-template-web").html());
//                         $('#_websit').append(myTemplate(data));
//                         //清空网站填写信息
//                         $('input[name="webType"]').attr("checked",false);//单选按钮恢复不选中
//                         $('#webSitName').val("");// 网站或网店名称
//                         $('#webSite').val("");//网址（域名）
//                         cleanWztableValue();
//                         cleanWdtableValue();
//                         $("#webTable1").hide();
//                     	 $("#webTr1").hide();
//                     	 $("#webTr2").hide();
//                     	 $("#webTr3").hide();
//                     	 $("#webTr4").hide();
//                     	 $("#webSmallType").val("");
//                     	 var websiteFlag = $("input:radio[name='websiteFlag']:checked").val();//是否有网站
//                    	 if(!websiteFlag){
//                    		 $("#_yes").prop("checked",true);
//                    	 }
//                     }else{
//                         layer.msg('添加失败!', {icon: 2,time: 1000});
//                     }
//
//                    }
//
//
//                });
//            }
//        })
//    }
    
  //默认赋值，用于传到后台保存
//    function setDefaulf(){
//    	var webType = $("input:radio[name='webType']:checked").val();//网站类型
//    	if(webType == '2'){
//    		var belongPlatFormName = $("input:radio[name='belongPlatFormRadio']:checked").val();//网站类型
//    		if(belongPlatFormName == "" || belongPlatFormName == null || belongPlatFormName == "undefined"){
//				layer.tips("请选择所属平台名称",$('#belong_checkbox'),{
//                    tips:3,
//                    tipsMore:true,
//                    ltype:0
//    			});
//    			return false;
//    		}else if(belongPlatFormName == "other"){
//    			var belongPlatFormNameother = $("#belongPlatFormNameother").val();
//    			if(belongPlatFormNameother == "" || belongPlatFormNameother.length >= 50){
//    				layer.tips("其他选项内容不能为空且长度不能超过25个中文字",$('#belongPlatFormNameother'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//        			});
//    				return false;
//    			}else{
//    				$("#belongPlatFormName").val(belongPlatFormNameother);//所属平台赋值
//    			}
//    		}else{
//    			$("#belongPlatFormName").val(belongPlatFormName);//所属平台赋值
//    		}
//    		var sendAddress = $("#sendAddress").val();//发货地址
//    		if(sendAddress == "" || sendAddress.length > 100){
//    			layer.tips("发货地址不能为空或长度不能超过50个中文字",$('#sendAddress'),{
//                    tips:3,
//                    tipsMore:true,
//                    ltype:0
//    			});
//    			return false;
//    		}
//    		var backAddress = $("#backAddress").val();//发货地址
//    		if(backAddress == "" || backAddress.length > 100){
//    			layer.tips("退货地址不能为空且长度不能超过50个中文字",$('#backAddress'),{
//                    tips:3,
//                    tipsMore:true,
//                    ltype:0
//    			});
//    			return false;
//    		}
//    	}else if(webType == '1'){
//    		var webSmallType = $("#webSmallType").val();
//    		if(webSmallType == ""){
//    			layer.tips("请选择网站类型",$('#webSmallType'),{
//                    tips:3,
//                    tipsMore:true,
//                    ltype:0
//    			});
//    			return false;
//    		}else if(webSmallType == "2"){
//    			var webicpbackno2 = $("#webicpbackno2").val();//ICP证号/备案号
////        		if(webicpbackno2 == "" || webicpbackno2.length > 50){
////        			layer.tips("ICP证号/备案号不能为空且长度不能超过50个字符",$('#webicpbackno2'),{
////                        tips:3,
////                        tipsMore:true,
////                        ltype:0
////        			});
////        			return false;
////        		}else{
//        			$("#icpBackNO").val(webicpbackno2);
////        		}
//    		}else if(webSmallType == "1"){
//    			var webPlatFormType = $("input:radio[name='webPlatFormTypecbox']:checked").val();
//        		if(webPlatFormType == "" || webPlatFormType == null ||webPlatFormType== "undefined"){
//        			layer.tips("请选择网络交易平台运营类型",$('#webPlatFormType3'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//        			});
//        			return false;
//        		}else{
//        			$("#webPlatFormType").val(webPlatFormType);//网络交易平台运营类型
//        		}
//        		var webGoodsType = $("input:radio[name='webGoodsTypecbox']:checked").val();
//        		if(webGoodsType == "" || webGoodsType == null ||webGoodsType== "undefined"){
//        			layer.tips("请选择网络交易产品类型",$('#webGoodsType3'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//        			});
//        			return false;
//        		}else{
//        			$("#webGoodsType").val(webGoodsType);//网络交易产品类型
//        		}
//        		var eCommerceType = $("input:radio[name='eCommerceTyperadio']:checked").val();
//        		if(eCommerceType == "" || eCommerceType == "undefined" || eCommerceType == null){
//        			layer.tips("请选择电商类型",$('#eCommerceTyperadio1'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//        			});
//        			return false;
//        		}else{
//        			$("#eCommerceType").val(eCommerceType);//电商类型
//        		}
//        		var webicpbackno1 = $("#webicpbackno1").val();
////        		if(webicpbackno1 == "" || webicpbackno1.length > 50){
////        			layer.tips("ICP证号/备案号不能为空且长度不能超过50个字符",$('#webicpbackno1'),{
////                        tips:3,
////                        tipsMore:true,
////                        ltype:0
////        			});
////        			return false;
////        		}else{
//        			$("#icpBackNO").val(webicpbackno1);//ICP证号/备案号
////        		}
//        		var weChatPublicNOradio = $("input:radio[name='weChatPublicNOradio']:checked").val();
//        		if(weChatPublicNOradio == "" || weChatPublicNOradio == "undefined" || weChatPublicNOradio == null){
//        			layer.tips("请选择是否有微信公众服务号",$('#weChatPublicNOradio1'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//        			});
//        			return false;
//        		}
//        		if(weChatPublicNOradio == "2"){
//        			var weChatPublicNO = $("#weChatPublicNO").val();
//            		if(weChatPublicNO == "" || weChatPublicNO.length > 50){
//            			layer.tips("微信公众服务号不能为空且长度不能超过50个字符",$('#weChatPublicNO'),{
//                            tips:3,
//                            tipsMore:true,
//                            ltype:0
//            			});
//            			return false;
//            		}
//        		}else{
//        			$("#weChatPublicNO").val("无");
//        		}
//        		var appNamesradio = $("input:radio[name='appNamesradio']:checked").val();
//        		if(appNamesradio == "" || appNamesradio == "undefined" || appNamesradio == null){
//        			layer.tips("请选择是否有APP软件名称",$('#appNamesradio1'),{
//                        tips:3,
//                        tipsMore:true,
//                        ltype:0
//        			});
//        			return false;
//        		}
//        		if(appNamesradio == "2"){
//        			var appNames = $("#appNames").val();
//            		if(appNames == "" || appNames.length > 100){
//            			layer.tips("APP软件名称不能为空且长度不能超过50个中文字",$('#appNames'),{
//                            tips:3,
//                            tipsMore:true,
//                            ltype:0
//            			});
//            			return false;
//            		}
//        		}else{
//        			$("#appNames").val("无");
//        		}
//    		}
//    	}
//    	return true;
//    }
//    
//    function cleanWdtableValue(){
//    	$("#belongPlatFormName_div input:radio").each(function(){
//    		$(this).prop("checked",false);
//    	});
//    	$("#belongPlatFormName").val("");
//    	$("#belongPlatFormInput_div").hide();
//    	$("#belongPlatFormNameother").val("");
//    	$("#sendAddress").val("");
//    	$("#backAddress").val("");
//    }
//    
//    function cleanWztableValue(){
//    	$("#webicpbackno2").val("");
//    	$("#icpBackNO").val("");
//    	$("#webSmallType").val("");
//    	$("#webTable1 input[type='hidden']").each(function(){
//    		$(this).val("");
//    	});
//    	$("#webTable1 input[type='text']").each(function(){
//    		$(this).val("");
//    	});
//    	$("#webTable1 input:radio").each(function(){
//    		$(this).prop("checked",false);
//    	});
//    	$("#weChatPublicNOradio1").click();
//    	$("#appNamesradio1").click();
//    	$("#eCommerceTyperadio1").click();
//    }
//    
//    function cleanWztableValue1(){
//    	$("#webicpbackno2").val("");
//    	$("#webTable1 input[type='hidden']").each(function(){
//    		$(this).val("");
//    	});
//    	$("#webTable1 input[type='text']").each(function(){
//    		$(this).val("");
//    	});
//    	$("#webTable1 input:radio").each(function(){
//    		$(this).prop("checked",false);
//    	});
//    	$("#weChatPublicNOradio1").click();
//    	$("#appNamesradio1").click();
//    	$("#eCommerceTyperadio1").click();
//    }
    

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
                    content: '/reg/server/yr/pb/pbbaseinfo/treeview',
                    callback: function (data) {
                    	if(data.reload!=null){
               			 $("#licNameCN").val(data.reload.returnName);
                         $("#licName").val(data.reload.returncode);
               		}
                    }
                })    
	         }
	     }
//	     ,
//         {
//             el: "#weChatPublicNOradio1",  //
//             event: 'click',
//             handler: function () {
//             	$("#weChatPublicNO").val("无");
//             	$("#weChatPublicNOdiv").hide();
//             }
//         },
//         {
//             el: "#weChatPublicNOradio2",  //
//             event: 'click',
//             handler: function () {
//             	$("#weChatPublicNO").val("");
//             	$("#weChatPublicNOdiv").show();
//             }
//         },
//         {
//             el: "#appNamesradio1",  //
//             event: 'click',
//             handler: function () {
//             	$("#appNames").val("无");
//             	$("#appNamesdiv").hide();
//             }
//         },
//         {
//             el: "#appNamesradio2",  //
//             event: 'click',
//             handler: function () {
//             	$("#appNames").val("");
//             	$("#appNamesdiv").show();
//             }
//         },
//         {
//             el: "#belongPlatFormName_div input:radio",  //
//             event: 'click',
//             handler: function () {
//            	var webType = $("input:radio[name='belongPlatFormRadio']:checked").val();
//            	if(webType == "other"){
//            		$("#belongPlatFormInput_div").show();
//            	}else{
//            		$("#belongPlatFormNameother").val("");
//            		$("#belongPlatFormInput_div").hide();
//            	}
//             }
//         },{
//             el: '#webinput1',  //网站
//             event: 'click',
//             handler: function () {
//             	$("#webTr2").hide();
//             	$("#webTr3").hide();
//             	$("#webTr4").hide();
//             	$("#webTable2").show();
//             	cleanWdtableValue();
//             }
//         },{
//             el: '#webinput2',  //网店
//             event: 'click',
//             handler: function () {
//             	$("#webTable1").hide();
//             	$("#webTable2").hide();
//             	$("#webTr2").show();
//             	$("#webTr3").show();
//             	$("#webTr4").show();
//             	cleanWztableValue();
//             	$("#webTable1").hide();
//         		$("#webTr1").hide();
//             }
//         },{
//             el: '#webSmallType',  //
//             event: 'change',
//             handler: function () {
//             	var webSmallType = $(this).val();
//             	if(webSmallType == "1"){
//             		$("#webTable1").show();
//             		$("#webTr1").hide();
//             		cleanWztableValue1();
//             	}else if(webSmallType == "2"){
//             		$("#webTable1").hide();
//             		$("#webTr1").show();
//             		cleanWztableValue1();
//             	}else{
//             		$("#webTable1").hide();
//             		$("#webTr1").hide();
//             		cleanWztableValue1();
//             	}
//             }
//         },
//         {
//             el: '._delete',// 网站或网店 删除
//             event: 'click',
//             handler: function () {
//                 var $this = $(this);
//                 var webid = $(this).data("webid");//类型
//                 layer.confirm('您确定要执行删除操作吗?', { btn: ['确定', '取消'],icon: 7, title: '提示'}, function () {
//                     http.httpRequest({
//                         url: '/reg/server/yr/pb/pbwebsite/delete',
//                         serializable: false,
//                         data: {"webID":webid},
//                         type: 'post',
//                         success: function (data) {
//                             if(data.status=='success'){
//                                 layer.msg(data.msg, {icon: 1,time: 1000}, function () {
//                                     $this.parent().parent().remove();
//                                 });
//                             }
//                         }
//                     });
//                 });
//             }
//         },
//         {
//             el: '._show',// 网站或网店 查看详情
//             event: 'click',
//             handler: function () {
//                 var webid = $(this).data("webid");
//                 var webTypeKey = $(this).data("webtypekey");
//                 var title = '';
//                 var height = ''; 
//                 if(webTypeKey == '1'){
//                 	title = '网站';
//                 	height = '55%';
//                 }else if(webTypeKey == '2'){
//                 	title = '网店';
//                 	height = '45%';
//                 }
//                 layer.dialog({
//                     title: title,
//                     area: ['48%', height],
//                     content: '/reg/server/yr/pb/pbwebsite/show?webID='+webid,
//                     callback: function (data) {
//                     }
//                 });
//             }
//         },
         
         ,
         {
             el: '#js-website-add',  //网站添加
             event: 'click',
             handler: function () {
                 $("#mod_website").slideDown().show();
             }
         } ,
         {
             el: '#js-website-edit',
             event: 'click',
             handler: function() {//修改操作
                 var id;
                 var index=0;
                 $(":checkbox[name=websitechose]:checked").each(function(k,v){
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
                
                 http.httpRequest({
                     url: '/reg/server/yr/pb/pbwebsite/showWeb',
                     serializable: false,
                     data: {webID:id},
                     type: 'post',
                     success: function (data) {
                     	$("#mod_website").slideDown().show();
                     	var data=data.data;
                     	 $(".anCheID").val(data.anCheID);
                     	 $("#webID").val(data.webID);
                     	 $("#webselect").val(data.webType);
                     	  $("#webSitName").val(data.webSitName);
                     	  $("#webSite").val(data.webSite);
                     }
                 })     
             }
         },
         {
             el: '#js-website-delete',
             event: 'click',
             handler: function() {//删除操作
               var ids=new Array();
                  $(":checkbox[name=websitechose]:checked").each(function(k,v){
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
                         url: '/reg/server/yr/pb/pbwebsite/batchDelete',
                         data: {
                         	webIds:ids.toString()
                         },
                         success: function(data) {
                             if (data.status == 'success') {
                                 //重新加载列表数据
                                 if (data.msg) {
                                     layer.msg(data.msg, {
                                         time: 500
                                     },
                                     function() {
                                     	initwebsite();//重新刷新表格
                                     });
                                 }
                             } else {
                                 if (data.msg) {
                                     layer.msg(data.msg, {
                                         time: 500
                                     },
                                     function() {
                                     	initwebsite();//重新刷新表格
                                     });
                                 }
                             }
                         }
                     });

                 });
             }
         },
         {
             el: '#webcancel', //网站取消
             event: 'click',
             handler: function () {
              $('input[name="webType"]').attr("checked",false);//单选按钮恢复不选中
              $('#websiteForm')[0].reset();//输入框重置为空*/
              $("#mod_website").slideUp("slow");//设置添加框隐藏 
             }
         },


         {
             el: '#_yes',  //企业是有网站或网店
             event: 'click',
             handler: function () {
				$("#js-website-add").show();
             }
         },
         {
             el: '#_no', //企业无网站或网店
             event: 'click',
             handler: function () {
            	 layer.confirm('该操作将清空已录入的网站或网店信息,您确定继续吗？', { btn: ['确定', '取消'],icon: 7, title: '提示',closeBtn:0}, function (index) {
            		var _websit = $("#itemCount").text();
             		if(_websit != "" && _websit != null && _websit.trim() != "" && _websit > 0){
             	    	var anCheID = $('#anCheID').val();//查询参数
             			http.httpRequest({
             				url: '/reg/server/yr/pb/pbwebsite/deleteall',
             				serializable: false,
             				data: {"anCheID":anCheID},
             				type: 'post',
             				success: function (data) {
             					if(data.status=='success'){
             						layer.msg("网站或网店信息已清空！" ,{icon: 1,time: 1000}, function () {
             						});
             					}
                             	initwebsite();//重新刷新表格
             				}
             			});
             		}
 					$("#js-website-add").hide();
 					layer.close(index);
            	 },function(){
             		$("#_yes").prop("checked",true);
             	});	
             }
         },
        
        {
            el: '#js-add',  //许可证添加
            event: 'click',
            handler: function () {
                $('#licenceForm')[0].reset();//输入框重置为空*/
                $('.lichidden').val('');  //隐藏框重置
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
                    url: '/reg/server/yr/pb/pblicence/show',
                    serializable: false,
                    data: {licID:id},
                    type: 'post',
                    success: function (data) {
                    	$("#mod_licence").slideDown().show();
                    	var data=data.data;
                    	 $(".anCheID").val(data.anCheID);
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
                        url: '/reg/server/yr/pb/pblicence/batchDelete',
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
       { el: '#longTime', //无有效期或长期有效事件触发
           event: 'click',
           handler: function () {
        	   if($(this).prop("checked")){
        			$("#valTo").val("9999-09-09");
        		}else{
        			$("#valTo").val("");
        		}
           }	   
       },{ el: '#isComphone', //对外公开联系电话中事件改变
           event: 'change',
           handler: function () {
        	   $("#comPhone").val("");
               if ($("#isComphone option:selected").val() == 1) {
            	   $("#comPhone").focus();
                   $("#comPhone").addClass("required");
                   $("#comPhone").removeAttr("readonly","readonly");
                 var patten = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})|(([0-9]{3,4}-)?[0-9]{7,8})$/ ;
      	         if(! patten.test($("#comPhone").val())){
      	            layer.tips('请输入正确的手机号码或固定电话如：1388888888或0571-8888888','#comPhone',{tips:3, tipsMore:true, ltype:0});
      	         }
               } else {
            	   $("#comPhone").attr("readonly","readonly");
                   $("#comPhone").removeClass("required");
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
      			$(".resParSecSign").attr("disabled","true");      		 
      			}	   
           }
       },
       {el: '#liaidtype', //证件类型下拉框改变情况
           event: 'change',
           handler: function () {
               if ($("#liaidtype option:selected").val() == 10) {
                   $("#liaidnum").addClass("idCard");
               } else {
                   $("#liaidnum").removeClass("idCard");
               }
           }
    	   
       },
       { el: '#view', //预览并提交表单触发
           event: 'click',
           handler: function () {
        	   var num = window._CONFIG. _empNum;
               var url = "/reg/server/yr/pbaddrec/preview?year="+$("#encodeYear").val()+"&priPID="+$("#priPID").val();
//               if (objWin == null || objWin.closed) {
             	  if(window._CONFIG. _empNum == null || window._CONFIG. _empNum == "" ){
       	             layer.msg("请先保存年报",500);
             	  }else{
             		  saveFlag = false;
             		  $("#form").submit();
             		  if(!_flag){return;}
             		  else{
                      	layer.dialog({
                            title: '个体户纸质补录提交',
                            area: ['95%', '80%'],
                            content: url,
                            callback: function (data) {
                                //重新加载列表数据
                                if (data.reload) {
                                    layer.close({reload: true});
                                }
                            }
                        }) 
//                          objWin = window.open(url);
//                          layer.close({reload: true});
             		  }
             	  }
//               } else {
//                   layer.msg("<em style='color: red;font-size: 16px;'>【预览并提交】已经处于打开的状态</em>", {icon: 7,time: 3000});
//               }
           }	   
       }
        ])
    }
});
