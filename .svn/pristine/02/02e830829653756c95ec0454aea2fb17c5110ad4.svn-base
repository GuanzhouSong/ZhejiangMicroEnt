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
    var dataArray;  //省市县数据
    var jsonArea ;  //县 或 区
    var jsonArea2 ;  //县 或 区
    init();
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
    	initBranch();//初始化分支机构
    	shebaoformValid(); //社保信息表单校验
    	formValid(); //基本信息表单验证提交
        licenceformValid(); //许可证验证提交
        branchValid(); //分支机构验证提交
        _hover();  //逻辑关系提示初始化
        bind();

        $("#select_city, #select_area, #select_stree, #desc_address,#icon-close-delete").on("click keyup", select_keyup);//触发事件
    }

/////////////////////////////////////////////////行政区划 start///////////////////////////////////////////////////////////////////////////////////////////

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

    /*****************************省级联动数据处理 start***************************************/
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

    /*****************************省级联动数据处理 end  ***************************************/


    /*****************************企业住所  start***************************************/
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

    /*****************************企业住所 end  ****************************************************/
/////////////////////////////////////////////////行政区划 end///////////////////////////////////////////////////////////////////////////////////////////


    //处理日期选择样式
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
    		$(".sfcreport").attr("disabled","disabled");
    		$(".sfcreportbutton").hide();
    		$(".icon-close").hide();
    	}
        var _tel = $("input:radio[name=otherInfoIsTel]:checked").val();
        if(_tel=="0"){
            $('input[name="tel"]').attr("readonly","readonly").css("background","#CCC");
        }
        var _email = $("input:radio[name=otherInfoIsEmail]:checked").val();
        if(_email=="0"){
            $('input[name="email"]').attr("readonly","readonly").css("background","#CCC");
        }
		//联络员信息初始化
		initeppassword();
		//其他工商服务信息初始化
		initIcService();
		//社保信息合计初始化
		init_total();
    }
    
    function _hover(){
        var index;
        $(".icon-question").hover(function (){
            var id = $(this).data("id");
            var msg = $(this).data("msg");
           index = layer.tips(msg,'#'+id,{tips:1, tipsMore:true, ltype:0,time:1000000});
        },function (){
            layer.close(index);
        });
    }
        

    //初始状态下若有联络员备案信息  则显示   若无  则添加非空验证
    function initeppassword(){
    	if(window._CONFIG.pubEppassword != null && window._CONFIG.pubEppassword != ""){
    		$("#leRep").val(window._CONFIG.leRep);
    		$("#leRepPhone").val(window._CONFIG.leRepPhone).prop("readonly",true);
    		$("#liaName").val(window._CONFIG.liaName).prop("readonly",true);
    		$("#liaPhone").val(window._CONFIG.tel).prop("readonly",true);
    		$("#liaIDType").val(window._CONFIG.liaIDType).prop("readonly",true);
    		$("#liaIDNum").val(window._CONFIG.liaIDNum).prop("readonly",true);
    		$(".viewicon").hide();    
    	}else{
			$("#leRepPhone").addClass("required");
			$("#leRepPhone").addClass("checkMobile");
			$("#liaName").addClass("required");
    		$("#liaPhone").addClass("required").addClass("checkMobile");
			$("#tel").addClass("required");
			$("#liaIDNum").addClass("required");
			$("#liaIDType").addClass("required");
			$("#liaIDType").removeAttr("onfocus").removeAttr("onchange");
			if ($("#liaIDType option:selected").val() == '10') {
	             $("#liaIDNum").addClass("idCard");
	         }else{
	        	 $("#liaIDNum").removeClass("idCard");
	         }
    		$(".viewicon").show();
    	}
    }
    
    //其他工商服务
    function initIcService(){
    	var icServiceArray = $("#icService").val();
        $("input:checkbox[name=icServiceCheck]").each(function(){
            if(util.in_array(icServiceArray,$(this).val())){
                $(this).prop("checked",true);
                if($("#icServiceCheck6").prop("checked")){
                	$("#othICService").show();
                	$("#othICService").val(window._CONFIG.othICService);
                }
            }
        });
    }
    
    //合计金额
    function init_total(){
        $("#socialsecurityform").find(".two,.three").bind("blur",doCal);
        $("#socialsecurityform").find(".icon-close").bind("click",doCal);//点击小叉
    }

    //计算金额值
    function doCal(){
        $("#paymentBase").val('');
        $("#actualPayment").val('');
        $("#cumulArrears").val('');
        var v1=0,v2=0,v3=0;
//        $("#socialsecurityform").find(".one").each(function(){  if(!isNaN($(this).val())){v1 += parseFloat(($(this).val() - 0).toFixed(4));}});
        $("#socialsecurityform").find(".two").each(function(){  if(!isNaN($(this).val())){v2 += parseFloat(($(this).val() - 0).toFixed(4));}});
        $("#socialsecurityform").find(".three").each(function(){if(!isNaN($(this).val())){v3 += parseFloat(($(this).val() - 0).toFixed(4));}});
//        v1 = v1.toFixed(4);
        v2 = v2.toFixed(4);v3 = v3.toFixed(4);
//        if(!isNaN(v1)){$("#paymentBase").val(v1);}
        if(!isNaN(v2)){$("#actualPayment").val(v2);}
        if(!isNaN(v3)){$("#cumulArrears").val(v3);}
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
            url: '/reg/client/yr/sfc/sfclicence/licencelist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数          	
                $('#pagination1').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    items_per_page:5,  //每页条数
                    num_display_entries: 3,//主体页数`104
                    num_edge_entries: 2,//边缘页数
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
     * 分支机构初始化
     */
    function initBranch(){
    	loadData_two(0,5);
    };//初始化网站
    
    
    
    function loadData_two(page, length, callback) {
    	var anCheID = $('#anCheID').val();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/sfc/sfcbranch/branchlist.json',
            serializable: false,
            data: {start: page*length,length: length,params:{"anCheID":anCheID}},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination3').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    items_per_page:5,  //每页条数（默认为10）
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_two(page,5);
                    }
                });
                handlebars.registerHelper("addOne", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($("#table-template-three").html());
                $('#dbao_page_branch').html(myTemplate(data));
                $("#itemCount3").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pageCount3").text(pageNum);//共多少页
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
            	dom: { //通讯地址
                    required: true,
                    maxlength: 100
                },
                opScope: { //经营业务范围
                    required: true
                },
                annNewMemNum: { //本年度新增
                    required: true,
                    digits:true
                },
                websiteFlag:{  //是否有网站
                    required:function(){
                        //判断当前网站网店是否选中一项
                        var vs = $("input:radio[name=websiteFlag]:checked").val();
                        if(!vs){layer.tips('请选择一项', '#js-yes', {tips:3, tipsMore:true, ltype:0});return true;}else{return false;}
                    }
                },
                annRedMemNum: { //退出
                    required: true,
                    digits:true
                },
                memNum: { //实际人数共
                    required: true,
                    digits:true,
                    min:1
                },
                farnum: { //其中农民人数
                    required: true,
                    digits:true
                },
                memConGro:{ //出资总额
                    required: true
                },
                creditMem: { //社员信用户
                    required: true,
                    range:[0,100],
                    maxlength: 18
                },
                vendInc: { //销售额或营业收入(元)
                    required: true
                },
                vendIncIsPub: { //销售额或营业收入(元)是否公示
                    required: true
                },
                priYeaProfit:{//盈余总额(元)
                	required:true
                },
                maiBusIncIsPub:{//盈余总额(元)是否公示
                	required:true
                },
                ratGro:{//纳税总额(元)
                	required:true
                },
                ratGroIsPub:{//纳税总额是否公示
                	required:true
                },
                priYeaSub:{//获得政府扶持资金、补助(元)
                	required:true
                },
                priYeaSubIsPub:{//获得政府扶持资金、补助(元)是否公示
                	required:true
                },
                priYeaLoan:{//金融贷款(元)
                	required:true
                },
                priYeaLoanIsPub:{//金融贷款(元)是否公示
                	required:true
                },
                tel:{//农专社电话
                    required: function(){
                        //获取当前选中的值
                        var _v = $("input:radio[name=otherInfoIsTel]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    telandphone:true
                },
                email: { //企业电子邮箱
                    required: function(){
                        //获取当前选中的值
                        var _v = $("input:radio[name=otherInfoIsEmail]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    email:true,
                    maxlength:100

                },
                empNum:{//从业人数
                    required: true,
                    digits:true,
                    min:1
                },
                empNumDis:{//从业人数是否公示
                	required: true
                },
                femaleEmploye:{//女性从业人数
                	required: true,
                	digits:true
                },
                femaleEmployeIsPub:{//女性从业人数是否公示
                	required: true
                },
                entMainBusActivity:{//主要业务活动
                	/*required:function(){
                		if($("#year").val() > 2015){
                			return true;
                		}
                	},*/
                    required:true,
                    specials:true

                },
                othICService:{
                    specials:true
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
                cityAddress: { //通讯地址-市
                    required: true
                },
                areaAddress: { //通讯地址-县区
                    required: true
                },
                streeAddress: { //通讯地址-街道
                    required: true
                },
                desAddress: { //通讯地址-描述信息
                    required: true,
                    specials:true,
                    maxlength:200
                }
                //**************************************省级联动 end*********************************//
            },
            messages: {
            	memNum:{
            		min:"实际人数不允许填写0和负数，必须是大于1及以上的整数!"
            	},
            	creditMem: {
            		range:"社员信用户为百分数，请输入合适的百分数"
            	},
            	othICService:{
            		required:"请输入其他工商服务"
            	}
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
                    var ele = $('#form input[name='+i+'],textarea[name='+i+'],select[name='+i+']'), index, parentEle, cls;
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

            	//获取年份
            	var year = $("#year").val();

            	//校验通过提交
            	if(check()){
                    if(year > 2015){
                        //判断社保信息表效验是否通过
                        if(!($('#socialsecurityform').valid())){ //效验没有通过则不往下执行
                            return false;
                        }
                    }
            		_flag = true;
            		_submit();
            	}
            	
            	//数据及填写范围校验
            	function check(){ 
            		var flag = true;
            		 //实际成员人数不允许填写0和负数，必须≥1及以上的整数 ✔

            		 // 成员人数>本年度新增成员人数-本年度退出成员人数 ✔   成员人数中农民人数
            		 var memNum = Number($("#memNum").val());//实际人数
            		 var annNewMemNum = Number($("#annNewMemNum").val());//新增人数
            		 var annRedMemNum = Number($("#annRedMemNum").val());//退出人数
            		 var farnum = Number($("#farnum").val());//其中农民人数
            		 if(memNum <= (annNewMemNum-annRedMemNum)){
            			 flag = false;
         	        	 $("#memNum").focus();
         	             layer.tips('成员人数应大于本年度新增成员人数与本年度退出成员人数之差!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#memNum',{tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		// 成员人数> 成员人数中农民人数 ✔ 
            		 var memNum = Number($("#memNum").val());//实际人数
            		 var farnum = Number($("#farnum").val());//其中农民人数
            		 if(memNum < farnum){
            			 flag = false;
         	        	 $("#memNum").focus();
         	             layer.tips('成员人数应大于成员中农民人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#farnum',{tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 //从业人数>女性从业人数 ✔
            		 var empNum = Number($("#empNum").val()); //从业人数
            		 var feEmpNum = Number($("#femaleEmploye").val()); //女性从业人数
            		 var endowmentNum = Number($("#endowmentNum").val()); //城镇职工基本养老保险人数
            		 var unemploymentNum = Number($("#unemploymentNum").val());//失业保险人数	
            		 var medicalNum = Number($("#medicalNum").val());//职工基本医疗保险人数	
            		 var empInjuryNum = Number($("#empInjuryNum").val());//工伤保险人数
            		 var maternityNum = Number($("#maternityNum").val());//生育保险人数
            		 if(empNum < feEmpNum){
            			 flag = false;
         	        	 $("#femaleEmploye").focus();
         	             layer.tips('从业人数应大于女性从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#feEmpNum',{tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 if(empNum < endowmentNum){
            			 flag = false;
         	        	 $("#endowmentNum").focus();
         	             layer.tips('城镇职工基本养老保险人数不得大于从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#endowmentNum',{tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 if(empNum < unemploymentNum){
            			 flag = false;
         	        	 $("#unemploymentNum").focus();
         	             layer.tips('失业保险人数不得大于从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#unemploymentNum',
                             {tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 if(empNum < medicalNum){
            			 flag = false;
         	        	 $("#medicalNum").focus();
         	             layer.tips('职工基本医疗保险人数不得大于从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#medicalNum',
                             {tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 if(empNum < empInjuryNum){
            			 flag = false;
         	        	 $("#empInjuryNum").focus();
         	             layer.tips('工伤保险人数不得大于从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#empInjuryNum',
                             {tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 if(empNum < maternityNum){
            			 flag = false;
         	        	 $("#maternityNum").focus();
         	             layer.tips('生育保险人数不得大于从业人数!'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>',
                             '#maternityNum',
                             {tips:3, tipsMore:true, ltype:0,time:0});
            			 return false;
            		 }
            		 
            		 return flag;
            	}
            	
            	
            	//提交：
                function _submit() {
                	//防止社保信息重复提交，点击之后禁掉暂存和预览按钮
	            	$("#save").attr("disabled","disabled");
	            	$("#view").attr("disabled","disabled");
                	//设置工商服务
                	var icArray = [];
                	 $("input:checkbox[name=icServiceCheck]:checked").each(function(){
                		 icArray.push($(this).val());
                     });
                     $("#icService").val(icArray.toString());
                	var formParam = $('#form').serializeObject();
                	var socialsecurityform = $('#socialsecurityform').serializeObject();
                	var dataObject;
                	if($("#year").val()>2015){
                		dataObject = $.extend({}, formParam,socialsecurityform);
                	}else{
                		dataObject = formParam;
                	}
                    http.httpRequest({
                        url: '/reg/client/yr/sfc/sfcbaseinfo/save',
                        serializable: false,
                        data: dataObject,
                        type: 'post',
                        async:false,
                        success: function (data) {
                        	if(data.status= "success"){
                        		_flag = true;
                        		if(saveFlag){
                        			layer.msg("保存成功", {time: 1000}, function () {
                        				window.location.reload();
                                    });
                        		}
            	            	$("#save").removeAttr("disabled","disabled");
            	            	$("#view").removeAttr("disabled","disabled");
                        	}else{//失败
                        		_flag = false;
                        		layer.msg("保存失败", {time: 1000}, function () {
                	            	$("#save").removeAttr("disabled","disabled");
                	            	$("#view").removeAttr("disabled","disabled");
                                });
                        	}  
                        },
                    error:function(){
                		_flag = false;
    	            	$("#save").removeAttr("disabled","disabled");
    	            	$("#view").removeAttr("disabled","disabled");
                    }
                    });
                }	
            }
        })
    };
    
    //社保信息表单校验
    function shebaoformValid(){
        $('#socialsecurityform').validate({
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
                    var ele = $('#socialsecurityform input[name='+i+']'), index, parentEle, cls;
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
            onsubmit:false,
            rules: {
                endowmentNum: {  //城镇职工基本养老保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                unemploymentNum:{  //失业保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                medicalNum:{   //职工基本医疗保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                empInjuryNum:{    //工伤保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                maternityNum:{   //生育保险
                    required: true,
                    digits: true,
                    maxlength:11
                },

                paymentEndowment:{  //单位缴费基数-城镇职工基本养老保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentUnemployment:{  //单位缴费基数-失业保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentMedical:{  //单位缴费基数-医疗保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentEmpInjury:{  //单位缴费基数-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentMaternity:{  //单位缴费基数-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayEndowment:{  //本期实际缴费金额-城镇职工基本养老保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayUnemployment:{  //本期实际缴费金额-失业保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayMedical:{  //本期实际缴费金额-医疗保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayEmpInjury:{  //本期实际缴费金额-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayMaternity:{  //本期实际缴费金额-生育保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuEndowment:{  //单位累计欠缴金额-城镇职工基本养老保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuUnemployment:{  //单位累计欠缴金额-失业保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuMedical:{  //单位累计欠缴金额-医疗保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuEmpInjury:{  //单位累计欠缴金额-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuMaternity:{  //单位累计欠缴金额-生育保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentBase:{  //单位缴费基数
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentBaseIsPub:{ //单位缴费基数 公示 不公示
                    required: true
                },
                cumulArrears:{     //单位累计欠缴金额
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumulArrearsIsPub:{    //单位累计欠缴金额 公示 不公示
                    required: true
                },
                actualPayment:{        //本期实际缴费金额
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPaymentIsPub:{   //本期实际缴费金额 公示 不公示
                    required: true
                }
            },

            messages: {
             /*   paymentBaseIsPub:"请选择一项",
                cumulArrearsIsPub:"请选择一项",
                actualPaymentIsPub:"请选择一项"*/
            },
            submitHandler: function () {
            }
        });
    }

   
    /**
     * licence from表单提交
     */
    function licenceformValid(){
        $('#licenceForm').validate({
            rules: {
            	licNameCN: {required: true,maxlength: 50},
            	valTo: {required: true,maxlength: 10}
            },
            messages: {
            	licNameCN: {required:"请选择一种许可证!"},
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
                    url: '/reg/client/yr/sfc/sfclicence/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    async:false,
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
     * branch from表单提交
     */
    function branchValid(){
        $('#brachForm').validate({
            rules: {
            	brName: {required: true,maxlength: 35},
            	uniCode: {required: true,maxlength: 18}
            },
            messages: {
            	brName: {required:"请输入分支机构的名称!"},
                uniCode:{required:"请输入分支机构的主体代码或注册号!"}

            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#brachForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#brachForm').serializeObject();
                http.httpRequest({
                    url: '/reg/client/yr/sfc/sfcbranch/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                         $('#brachForm')[0].reset();//输入框重置为空*/
                         $('.brhidden').val('');  //隐藏框改为空
                       	 if(data.status=='success'){
                           	 if(data.msg =='1'){//修改
                              		 layer.msg("表单修改成功", {time: 1000}, function () {   //操作之后刷新许可证列表
                                        $("#mod_brach").slideUp("slow");//设置添加框隐藏
                              	 });
                               }else{
                               	layer.msg("表单保存成功", {time: 1000}, function () {   
                                	 });
                                  }	 
                           	    initBranch();  
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
                         $("#licName").val(data.reload.retruncode);
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
            	$('#licenceForm')[0].reset();//输入框重置为空*/
                $('.lichidden').val('');  //隐藏框重置
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
               
                http.httpRequest({
                    url: '/reg/client/yr/sfc/sfclicence/show',
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
                        url: '/reg/client/yr/sfc/sfclicence/batchDelete',
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
            el: '#js-branch-add',  //分支机构添加
            event: 'click',
            handler: function () {
                $("#mod_brach").slideDown().show();
            }
        } ,
        {
            el: '#js-branch-edit',
            event: 'click',
            handler: function() {//分支机构修改操作
                var id;
                var index=0;
                $(":checkbox[name=branchchose]:checked").each(function(k,v){
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
                
                $('#brachForm')[0].reset();//输入框重置为空*/
                $('.brhidden').val('');  //隐藏框改为空
               
                http.httpRequest({
                    url: '/reg/client/yr/sfc/sfcbranch/show',
                    serializable: false,
                    data: {brID:id},
                    type: 'post',
                    success: function (data) {
                    	 $("#mod_brach").slideDown().show();
                    	 var data=data.data;
                    	 $(".anCheID").val(data.anCheID);
                    	 $("#brID").val(data.brID);
                    	 $("#brName").val(data.brName);
                    	 $("#branUniCode").val(data.uniCode);
                    }
                })     
            }
        },
        {
            el: '#js-branch-delete',
            event: 'click',
            handler: function() {//删除操作
              var ids=new Array();
                 $(":checkbox[name=branchchose]:checked").each(function(k,v){
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
                        url: '/reg/client/yr/sfc/sfcbranch/batchDelete',
                        data: {
                        	brIDs:ids.toString()
                        },
                        success: function(data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {
                                        time: 500
                                    },
                                    function() {
                                    	initBranch();//刷新表格
                                    });
                                }
                            } else {
                                if (data.msg) {
                                    layer.msg(data.msg, {
                                        time: 500
                                    },
                                    function() {
                                    	initBranch();//重新刷新表格
                                    });
                                }
                            }
                        }
                    });

                });
            }
        },
        {
            el: '#branchCancel', //分支机构取消
            event: 'click',
            handler: function () {
             $('#brachForm')[0].reset();//输入框重置为空*/
             $("#mod_brach").slideUp("slow");//设置输入修改框隐藏 
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
       {
         	 el: '#checkBranchAll', //分支机构全选触发
              event: 'click',
              handler: function () {
             	 var flag=$(this).prop("checked");
     	         $("input:checkbox[name='branchchose']").prop("checked", flag);
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
       },
       { el: '#icServiceCheck6', //其他工商服务选中情况
           event: 'click',
           handler: function () {
        	   if($(this).prop("checked")){
        			$("#othICService").show();
        			$("#othICServiceReal").addClass("required");
        		}else{
        			$("#othICService").hide();
        			$("#othICServiceReal").val("");
        			$("#othICServiceReal").removeClass("required");
        		}
           }	   
       },
       {el: '#liaIDType', //证件类型下拉框改变情况
           event: 'change',
           handler: function () {
               if ($("#liaIDType option:selected").val() == 10) {
                   $("#liaIDNum").addClass("idCard");
               } else {
                   $("#liaIDNum").removeClass("idCard");
               }
           }
    	   
       },
       {
           el: '#email_no',  //电子邮箱 无
           event: 'click',
           handler: function () {
               $('input[name="email"]').val("");
               $('input[name="email"]').attr("readonly","readonly").css("background","#CCC");
               clearform.clearSelect($('input[name="email"]'));//消除验证的红色边框和提示
           }
       },
       {
           el: '#email_yes',  //电子邮箱 有
           event: 'click',
           handler: function () {
               $('input[name="email"]').removeAttr("readonly").css("background","none");
           }
       },
        {
            el: '#tel_no',  //联系电话 无
            event: 'click',
            handler: function () {
                $('input[name="tel"]').val("");
                $('input[name="tel"]').attr("readonly","readonly").css("background","#CCC");
                clearform.clearSelect($('input[name="tel"]'));//消除验证的红色边框和提示
            }
        },
        {
            el: '#tel_yes',  //联系电话 有
            event: 'click',
            handler: function () {
                $('input[name="tel"]').removeAttr("readonly").css("background","none");
            }
        },
       { el: '#view', //预览并提交表单触发
           event: 'click',
           handler: function () {
               var memNum = window._CONFIG. _memNum;
               var url = "/reg/client/yr/sfc/sfcbaseinfo/view?year="+$("#encodeYear").val();
               if (objWin == null || objWin.closed) {
                   if(window._CONFIG. _memNum == null || window._CONFIG. _memNum == "" ){
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

                       if(!_flag){return false;}
                       else{
                           objWin = window.open(url);
                       }
                   }
               } else {
                   layer.msg("<em style='color: red;font-size: 16px;'>【预览并提交】已经处于打开的状态</em>", {icon: 7,time: 3000});
               }

           }	   
       },
       {
           el: '#printsfcReportProve',
           event: 'click',
           handler: function () {
        	   var _id = "_doPrint_"+new Date().getTime();
               var url = "/reg/client/yr/sfc/yrprint/printPubSfcPrintProve?year="+$("#encodeYear").val();
               try{
                   window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
               }catch(e){
                   alert("打印错误!");
               }  
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
	                  url: '/reg/client/yr/yrcommit/sfc/modreport',
	                  data: {year: $("#year").val()},  //未加密的年份
	                  success: function (data) {
	                      if (data.status == 'success') {
	                      	layer.msg(data.msg, {time: 1000}, function () {
	                          	location.assign('/reg/client/yr/sfc/sfcbaseinfo/show?year=' + $("#encodeYear").val() + "&pripid=" + window._CONFIG.pripid);
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
        	 // 分支机构注册号（信用代码），失去焦点事件
        	 el: '#branUniCode',
          event: 'blur',
          handler: function () {
             var branUniCode = $("#branUniCode").val();
             if(branUniCode == '' || branUniCode == null){
                 $("#brName").prop("readonly",true);
                 return false;
             }else{
            	 if(branUniCode == $("#regNO").val() || branUniCode == $("#uniCode").val()){
                     layer.msg("输入的分支机构统一社会信用码/注册号不能与当前企业相同", {icon: 7,time: 1000});
                     return false;
            	 }else{
                     http.httpRequest({
                         url: '/reg/client/yr/sfc/sfcbranch/search',
                         serializable: false,
                         data: {"branUniCode":branUniCode},
                         type: 'post',
                         success: function (data) {
                         	 if(data.data !=null && data.data.length >0){
                         		 if(data.data[0].uniCode != null && data.data[0].uniCode != '' && branUniCode != data.data[0].uniCode){
                                     layer.msg("输入的分支机构有统一社会信用代码必须输入统一社会信用代码", {icon: 7,time: 1000});
                         		 }else{
                                     $("#brName").val(data.data[0].entName);
                                     $("#brName").attr("readonly",true);
                         		 }
                         	 }else{
                                 $("#brName").prop("readonly",false);
                         	 }
                         }
                     })
            	 }
             }
             
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
                        content: '/reg/client/yr/sfc/sfcwebsite/show?'+wz_params,
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
                        content: '/reg/client/yr/sfc/sfcwebsite/show?' + wz_params,
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
                        content: '/reg/client/yr/sfc/sfcwebsite/show?' + wz_params,
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
                                url: '/reg/client/yr/sfc/sfcwebsite/deleteall',
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
                var priPID= $(this).data("pripid");//内部序号
                layer.confirm('您确定要执行删除操作吗?', { btn: ['确定', '取消'],icon: 3, title: '提示'}, function () {
                    http.httpRequest({
                        url: '/reg/client/yr/sfc/sfcwebsite/delete',
                        serializable: false,
                        data: {"webid":webid,"priPID":priPID},
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
                    content: '/reg/client/yr/sfc/sfcwebsite/view?webid='+webid,
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
            url: '/reg/client/yr/sfc/sfcwebsite/doReadList',
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
