require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/clearform',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'laydate',
    'component/report',
    'jquery.placeholder',
    'jquery.icinfo'

], function (layer, util, http,handlebars,clearform) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    json_data_array();//初始化联动数据
    init();
    laydate.skin('molv');//初始化皮肤

    //********时间校验特殊处理 start *************
    $("#_parSetTime").click(function(){
        laydate({elem: '#_parSetTime', istime: true, format: 'YYYY-MM-DD',
            choose:function(){
                var $this = $('#_parSetTime');var cls = 'error-tips';
                if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                    if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
                }
            }
        });
    });
    //********时间校验特殊处理 end *************

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
        //select_data();      //企业通讯 省级联动
        //select_data_copy();//住所省级联动初始化
        eacho();//数据回显
        formValid();
        bind();
        reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
        _hover();  //逻辑关系提示初始化

        $("#select_city, #select_area, #select_stree, #desc_address,#icon-close-delete").on("click keyup", select_keyup);//触发事件
    }

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



    //逻辑关系提示初始化
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

    //年报状态判断
    function reportStateFrom(){
        var _value = $("#_reportState").val();
        if(_value!='00'&&_value!=='20'&&_value!='13'){
            $("input,select").attr("disabled","disabled");
            $(".icon-close,.btn-save,._wesittrhide,._delete").hide();
        }
    }


    //数据回显
    function eacho(){
        //电话 邮件
        var _tel =   $("input:radio[name=otherInfoIsTel]:checked").val();
        var _email = $("input:radio[name=otherInfoIsEmail]:checked").val();
        if(_tel=="0"){
            $('input[name="tel"]').attr("readonly","readonly").css("background","#CCC");
        }
        if(_email=="0"){
            $('input[name="email"]').attr("readonly","readonly").css("background","#CCC");
        }

        if($("#parIns").find("option:selected").val()=='0'){
            $(".js-ui-state").hide();
            $("#_parSetTime").attr("disabled","disabled");//设置为隐藏域并添加disabled属性避免效验
            $("#_one").css("display","none");
            $("#_two").css("display","none");
        }
        //组建方式 回显
        var _parInsVlaue = $("#_parIns").val();//获取 党组织建制的值
        if(_parInsVlaue=='0'){
            $(".js-ui-state").hide();
            $("#_parSetTime").attr("disabled","disabled");//设置为隐藏域并添加disabled属性避免效验
            $("#_one").css("display","none");
            $("#_two").css("display","none");
        }
        if(_parInsVlaue=='1'){

            $(".js-ui-state").show();
            $("#_parSetTime").removeAttr("disabled");//显示并移除disabled属性  时间
            $("#_one").css("display","block").removeAttr("disabled");
            $("#_two").css("display","none").attr("disabled","disabled");
            //获取组建方式的值：
            var _v = $("#_parOrgW").val();
            $("#_one option").each(function(){
                var $v = $(this).val();
                if(_v==$v){$(this).prop("selected",true);}
            });
        }
        if(_parInsVlaue=='2'||_parInsVlaue=='3'){
            $(".js-ui-state").show();
            $("#_parSetTime").removeAttr("disabled");//显示并移除disabled属性  时间
            $("#_two").css("display","block").removeAttr("disabled");
            $("#_one").css("display","none").attr("disabled","disabled");
            //获取组建方式的值：
            var _v = $("#_parOrgW").val();
            $("#_two option").each(function(){
                var $v = $(this).val();
                if(_v==$v){$(this).prop("selected",true);}
            });
        }

        //是否经营广告 默认选否  如果回显值为0 则隐藏 广告经费
        var _advBusFlag = $("#_advBusFlag").val();
        if((!_advBusFlag)||(_advBusFlag=='0')){
            $("input:radio[name='advBusFlag'][value='0']").prop("checked",true);
            $('.js-ui-advBusFlag').hide();
        }
        //判断网站是否回显
//        var yrWebsiteInfoList = $("#yrWebsiteInfoList").val();
//        if(!yrWebsiteInfoList){$("#qywz").hide();}


    }

    /**保存按钮**/
    $("#save").click(function(){
        $("#otherForm").submit();
    });

    /**
     * 其他信息表单验证 并保存
     */
    function formValid() {

        $('#otherForm').validate({
            onkeyup:false, //键盘按下不进行触发 默认是鼠标移出输入框后再进行触发
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
               /* if(el.name!='parSetTime'){ //时间的特殊处理
                    $(el).valid();
                }*/
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#otherForm input[name='+i+'],#otherForm select[name='+i+']'), index, parentEle, cls;
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
            rules: {
                otherInfoIsTel: { //企业联系电话 有无选择
                    required: true
                },
                tel: { //企业联系电话
                    required: function(){
                        //获取当前选择中的值
                        var _v = $("input:radio[name=otherInfoIsTel]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    telandphone:true,
                    maxlength:30
                },
                otherInfoIsEmail: { //企业电子邮箱 有无选择
                    required: true
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
                addr: { //企业通讯地址
                    //required: true,
                    maxlength:100
                },
                postalCode: { //邮政编码
                    required: true,
                    isZipCode: true,
                    maxlength:6
                },
                supEntname: { //隶属企业名称
                    required: true,
                    maxlength:100
                },
                supRegNO:{ //隶属企业统一代码/注册号
                    required: true,
                    maxlength:18
                },
                numParM: { //其中党员（含预备党员）
                    required: true,
                    digits: true,
                    maxlength:6
                },
                websiteFlag:{  //是否有网站
                  required:function(){
                      //判断当前网站网店是否选中一项
                      var vs = $("input:radio[name=websiteFlag]:checked").val();
                      if(!vs){layer.tips('请选择一项', '#js-yes', {tips:3, tipsMore:true, ltype:0});return true;}else{return false;}
                  }
                },
                resParMSign: { //法定代表人 是否
                    required: true
                },
                resParSecSign:{ //是否担任党组织书记
                    required: function (){
                        //判断当前法定代表人选中的是否是  否
                        var _v = $("input:radio[name=resParMSign]:checked").val();
                        if(!_v)return false;
                        if(_v=='2'){return false;} return true;
                    }
                },
                parIns: { //党组织建制
                    required: true
                },
                parSetTime: { //组建时间
                    required: true
                },
                parOrgW: { //组建方式
                    required: true
                },

                otherInfoPatAmount: { //企业拥有专利的数
                    digits: true,
                    maxlength:6
                },
                domTraRegs: { //国内商标注册数
                    digits: true,
                    maxlength:11
                },
                abrTraRegs: { //境外商标注册数
                    digits: true,
                    maxlength:11
                },
                usingTraRegs: { //实际在使用商标数
                    digits: true,
                    maxlength:11
                },
                licOthTraRegs: { //许可他人使用商标数
                    digits: true,
                    maxlength:11
                },
                newAppTraRegs: { //本年新申请商标数
                    digits: true,
                    maxlength:11
                },
                thAnnAdvFee: { //本年度投入广告费
                    units:true,
                    maxlength:16
                },
                units:true,
                thIntAnnAdvFee: { //在互联网投入广告费
                    maxlength:16
                },
                advBusFlag: { //是否经营广告费
                    required: true
                },
                thAdvTurnover: { //本年度广告经营额
                    required: function(){
                        var _v = $("input:radio[name=advBusFlag]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    units:true,
                    maxlength:16
                },
                advTurTaxPaid: { //广告经营上缴税收
                    required: function(){
                        var _v = $("input:radio[name=advBusFlag]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    units:true,
                    maxlength:16
                },
                thNetTraBusTur : { //本年度通过网络交易经营额
                    millionUnits:true,
                    maxlength:16
                },
                partyAccNetAmount: { //跨境网络交易进出口经营额
                    millionUnits:true,
                    maxlength:16
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
                liaIDType:"请选择一项",
                resParSecSign:"请选择一项",
                resParMSign:"请选择一项",
                otherInfoIsEmail:"请选择一项",
                parSetTime:"请选择时间",
                parOrgW:"请选择一项",

                cityAddressCopy:"请选择一项",
                areaAddressCopy:"请选择一项",
                streeAddressCopy:"请选择一项",

                cityAddress:"请选择一项",
                areaAddress:"请选择一项",
                streeAddress:"请选择一项"
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

               //获取企业从业人数：  判断 党员人数与企业从业人数的大小
                var _empNum = parseInt($("#_empNum").val(),10);
                if(_empNum>0){
                    //获取其中党员(含预备党员)人数：
                    var _numParM = parseInt($("#_numParM").val(),10);
                    if(_numParM>_empNum){
                        layer.tips('党员人数不能大于企业从业人数<em style="color: red">'+_empNum+"人</em>",'#_numParM',{tips:3, tipsMore:true, ltype:0,time:5000});
                        $("#_numParM").focus();
                        return;
                    }
                }
                var formParam = $('#otherForm').serializeObject();

                //但【党组织建制】 选择的是 【未组建党支部】 则将【组建时间】【组建方式】的值设置为空
                if($("#parIns").find("option:selected").val()=='0'){
                    formParam["parOrgW"]='';
                }
                formParam['sign'] = "preservation";  //保存标记

                if($("#web-sgin").val()){ formParam['websign'] = "200"};  //网站网店操作标记

                $(".js-save").attr("disabled", true); //防止表单重复提交
                $(".js-temporary").attr("disabled", true); //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/ent/yrotherinfo/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success'){
                            layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                window.location.reload();//重新刷新页面
                            });
                        }else if(data.status=='fail'){
                            layer.msg(data.msg, {icon: 2,time: 1000},function(){
                                $(".js-save").attr("disabled", false); //
                                $(".js-temporary").attr("disabled", false);
                            });
                        }
                    },
                    error:function(){
                        $(".js-save").attr("disabled", false);
                        $(".js-temporary").attr("disabled", false);
                    }
                });
            }
        })
    };

    //党组织建制 选择
    $("#parIns").change(function(){
        //获取选中的文本值
        var _text = $("#parIns").find("option:selected").text();
        $("#parInsCN").val(_text);//设置值
        //获取选中值
        var _value = $("#parIns").find("option:selected").val();
        if(_value=='0'){

            $(".js-ui-state").hide();

            $("#_parSetTime").attr("disabled","disabled");//设置为隐藏域并添加disabled属性避免效验

            $("#_one").css("display","none").attr("disabled","disabled");
            $("#_two").css("display","none").attr("disabled","disabled");
        }
        if(_value=='1'){

            $(".js-ui-state").show();

            $("#_parSetTime").removeAttr("disabled");//显示并移除disabled属性  时间
            $("#_parSetTime").val("");//清空时间值


            $("#_one").find("option:first").prop("selected",true);       //初始化 --请选择--
            $("#_one").css("display","block").removeAttr("disabled");
            $("#_two").css("display","none").attr("disabled","disabled");
         }
         if(_value=='2'||_value=='3'){

            $(".js-ui-state").show();

            $("#_parSetTime").removeAttr("disabled");//显示并移除disabled属性  时间
            $("#_parSetTime").val("");//清空时间值

            $("#_two").find("option:first").prop("selected",true);       //初始化 --请选择--
            $("#_two").css("display","block").removeAttr("disabled");
            $("#_one").css("display","none").attr("disabled","disabled");
         }

    });

    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '#No_ResParMSign',  //法定代表人不是党员的时候触发
                event: 'click',
                handler: function () {
                    $("input:radio[name=resParSecSign]").prop("checked",false);//设置为默认不选中的状态
                    $("#_resParSecSign").attr("name","resParSecSign");
                }
            },
            {
                el: '#tel_no',  //企业联系电话 无
                event: 'click',
                handler: function () {
                    $('input[name="tel"]').val("");//设置值为空
                    $('input[name="tel"]').attr("readonly","readonly").css("background","#CCC");
                    clearform.clearSelect($('input[name="tel"]'));//消除验证的红色边框和提示
                }
            },
            {
                el: '#tel_yes',  //企业联系电话 有
                event: 'click',
                handler: function () {
                    $('input[name="tel"]').removeAttr("readonly").css("background","none");
                }
            },
            {
                el: '#email_no',  //企业电子邮箱 无
                event: 'click',
                handler: function () {
                    $('input[name="email"]').val("");
                    $('input[name="email"]').attr("readonly","readonly").css("background","#CCC");
                    clearform.clearSelect($('input[name="email"]'));//消除验证的红色边框和提示
                }
            },
            {
                el: '#email_yes',  //企业电子邮箱 有
                event: 'click',
                handler: function () {
                    $('input[name="email"]').removeAttr("readonly").css("background","none");
                }
            },
            {
                el: '.js-temporary',   //暂存操作
                event: 'click',
                handler: function () {
                    var formParam = $('#otherForm').serializeObject();
                    if($("#web-sgin").val()){ formParam['websign'] = "200"};  //网站网店操作标记
                    formParam['sign'] = "temporary";  //暂存标记
                    $(".js-temporary").attr("disabled", true); //防止表单重复提交
                    $(".js-save").attr("disabled", true); //防止表单重复提交
                    http.httpRequest({
                        url: '/reg/client/yr/ent/yrotherinfo/save',
                        serializable: false,
                        data: formParam,
                        type: 'post',
                        success: function (data) {
                            if(data.status=='success') {
                                layer.msg("暂存成功", {icon: 1, time: 1000}, function () {
                                    window.location.reload(); //重新加载页面
                                });
                            }else if(data.status=='fail'){
                                layer.msg("暂存失败", {icon:2,time: 1000},function(){
                                    $(".js-temporary").attr("disabled", false);
                                    $(".js-save").attr("disabled", false); //
                                });
                            }
                        },
                        error:function(){
                            $(".js-temporary").attr("disabled", false);
                            $(".js-save").attr("disabled", false); //
                        }
                    });
                }
            },
            {
                el: 'input:radio[name=advBusFlag]', // <input type="radio" name="advBusFlag" value="1"
                event: 'click',
                handler: function () {
                    var $this = $(this);
                    if($this.val()=='0'){
                        $("#_thAdvTurnover").val('0.00');
                        $("#_advTurTaxPaid").val('0.00');
                        $('.js-ui-advBusFlag').hide();
                    }else if($this.val()=='1'){
                        $("#_thAdvTurnover").val('');
                        $("#_advTurTaxPaid").val('');
                        $('.js-ui-advBusFlag').show();
                    }else if($this.val()=='2'){
                        $("#_thAdvTurnover").val('');
                        $("#_advTurTaxPaid").val('');
                        $('.js-ui-advBusFlag').show();
                    }
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
                            content: '/reg/client/yr/ent/yrwebsiteinfo/show?'+wz_params,
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
                            content: '/reg/client/yr/ent/yrwebsiteinfo/show?' + wz_params,
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
                            content: '/reg/client/yr/ent/yrwebsiteinfo/show?' + wz_params,
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
                                    url: '/reg/client/yr/ent/yrwebsiteinfo/deleteall',
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
                            url: '/reg/client/yr/ent/yrwebsiteinfo/delete',
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
                        content: '/reg/client/yr/ent/yrwebsiteinfo/view?webid='+webid,
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
            url: '/reg/client/yr/ent/yrwebsiteinfo/doReadList',
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

                        $('#web-sgin').val('200');//用于标记操作了网站网店
                    }
                }
            }
        });
    };
});
