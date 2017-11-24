require(['component/iframeLayer', 'component/dataTable',
    'common/util', 'common/http', 'handlebars', 'jquery.validate', 'common/validateRules',
    'jquery.serialize', 'laydate'], function
    (layer, dataTable, util, http, handlebars) {

    if(_fromtype != 'batch'){ //批量无
    	json_data_array();//初始化联动数据
    }

    init();
    var table;
    var table2;
    var dataArray;  //省市县数据
    var jsonArea;  //县 或 区

    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        initDataTable();
        initDataTable2();
        bind();
        initShow();
        if(_fromtype != 'batch'){ //批量无
            $("#select_city, #select_area, #select_stree, #desc_address").on("click keyup", select_keyup);//触发事件
        }
        if(_fromtype != 'batch'){ //批量无
            $("#select_actualcity,#select_actualarea,#select_actualarea,#select_actualstree,#desc_actualaddress").on("click keyup", select_actualkeyup);//触发事件
        }
    }

    //首次加载全部数据
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
                select_actualdata(); 
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
    
  //触发事件
    function select_actualkeyup(){
        $("#info_actualaddress").val('');
        var str1,str2,str3,str4,address;
        var select_city_value =  $("#select_actualcity").val();
        var select_area_value =  $("#select_actualarea").val();
        var select_stree_value = $("#select_actualstree").val();
        var desc_address_value = $("#desc_actualaddress").val();

        if(select_city_value){str1 = $("#select_actualcity").find("option:selected").text();}
        if(select_area_value){str2 = $("#select_actualarea").find("option:selected").text();}
        if(select_stree_value&&select_stree_value!='0'&&select_stree_value!='999999999000'){str3 = $("#select_actualstree").find("option:selected").text();}
        if(desc_address_value){str4 = $("#desc_actualaddress").val();}

        if(str1){address = "浙江省"+str1;}
        if(str2){address+=str2}
        if(str3){address+=str3;}
        if(str1){              //判断市是否选中
            if(str4){address+=str4}
        }
        $("#info_actualaddress").val(address);
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
    }
    
    function select_actualdata() {
        var jsonData = dataArray;
        var jsonCity = jsonData.codeAddress; //市
        var dataCode ;
        var params_area_address = $("#params_area_actualaddress").val();
        var params_stree_address = $("#params_stree_actualaddress").val();
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
        tm_append_actualtemplate(jsonCity, "select_actualcity", select_city);
        city_template_actualdata(select_city, select_area, jsonCity);
        area_template_actualdata(select_area, select_stree, jsonArea);

        //根据市选择
        $("#select_actualcity").change(function () {
            jsonArea = null;
            //获取选中的值：
            var selectedValue = $("#select_actualcity").val();
            if (!selectedValue) {
                $("#select_actualstree").html("<option value=''>-请选择-</option>")
            };
            //如果选择的是空 则 街道 初始化
            if (!selectedValue) {
                $("#select_actualarea").html("<option value=''>-请选择-</option>")
            };
            //如果选择的是空 则 街道 初始化
            city_template_actualdata(selectedValue, null, jsonCity);
        });
        //县或区的选择
        $("#select_actualarea").change(function () {
            //获取选中的值：
            var selectedValue = $("#select_actualarea").val();
            area_template_actualdata(selectedValue, null, jsonArea);
        });
    }

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
    }
    
    function city_template_actualdata(selectedCityValue,EchoselectedCode,data){
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
            tm_append_template(obj.codeAddress,"select_actualarea",EchoselectedCode);
            html = "<option value=''>-请选择-</option>";
            $("#select_actualstree").html(html);

        }else{
            html = "<option value=''>-请选择-</option>";
            $("#select_actualarea").html(html);
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
    }
    
    function area_template_actualdata(selecteAreaValue,EchoselectedCode,data){
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
            tm_append_template(obj.codeAddress,"select_actualstree",EchoselectedCode,"area");
        }else{
            var html = "<option value=''>-请选择-</option>";
            $("#select_actualstree").html(html);
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
    }
    
    function tm_append_actualtemplate(jsonData,target,EchoselectedCode,falg){  //
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
        if(target=='select_actualstree'){
            if($("#params_stree_actualaddress").val()&&$("#params_stree_actualaddress").val()=='999999999000'){
                html += "<option value='999999999000' selected>其他</option>";
            }else{
                html += "<option value='999999999000'>其他</option>";
            }
        }
        $("#"+target).html(html);
    };

    
    /**
     * 初始化管辖人员显示
     */
    function initShow() {
        if (_sliceMan.length < 1) return;
        var man = _sliceMan.split(",");
        var tel = _sliceTel.split(",");
        var show = '';
        for (var i = 0; i < man.length; i++) {
            show += ';' + man[i] + '  电话：' + tel[i];
        }
        $('#sliceManp').html(show.substr(1));
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#registInfoForm').validate({
            onkeyup: false,
            onfocusout: function (el) {
            },
            rules: {
                individDate: {//个转企日期
                    required: true
                },
                changeArchState: {//变更重建档类型
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
                    maxlength:200
                }
            },
            messages: {
                individDate: {
                    required: '请选择转企时间'
                },
                changeArchState: {
                    required: '请选择建档变更类型'
                },
                cityAddress: { //地址-市
                    required: '请选择一项'
                },
                areaAddress: { //地址-县区
                    required: '请选择一项'
                },
                streeAddress: { //地址-街道
                    required: '请选择一项'
                },
            },

            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#registInfoForm input[name=' + i + '],#registInfoForm select[name='+i+']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });

                }
            },

            submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                if($('input[name="registMarkType"]:checked').val()){
                	if ($('input[name="registMarkType"]:checked').val() == '2' && ($('#iDCodeNames').val() == '' || $('#iDCodes').val() == '')) {
                		layer.msg('请设置分类监管标签！', {time: 1000});
                		return false;	
                	}
                }else{
                	layer.msg('请选择分类标签！', {time: 1000});
            		return false;	
                }
                if ($('input[name="diffAddrReason"]:checked').length == 0 ||
                    $('input[name="diffAddrReason"]:checked').val() != '0') {  //不是查无下落，才验证这3项
                    if ($('#sliceNOName').val() == '') {
                        layer.msg('请选择片区商圈！', {time: 1000});
                        return false;
                    }
                    if ($('#sliceManp').val() == '') {
                        layer.msg('请选择管辖人员！', {time: 1000});
                        return false;
                    }
                }

                //表单验证end
                var url = '/reg/server/registinfo/registinfo/modi';
                if (_fromtype == 'batch') {
                	//去除不为批量建档的字段
	    			delete formParam.areaAddress;
	    			delete formParam.cityAddress;
	    			delete formParam.desAddress;
	    			delete formParam.individDate;
	    			delete formParam.investigateDate;
	    			delete formParam.isChangeArch;
	    			delete formParam.linkPhone;
	    			delete formParam.linkman;
	    			delete formParam.linktel;
	    			delete formParam.streeAddress;
	    			delete formParam.street;
	    			delete formParam.opLoc;
	    			delete formParam.tel;
	    			delete formParam.actualCityAddress;
	    			delete formParam.actualAreaAddress;
	    			delete formParam.actualStreeAddress;
	    			delete formParam.actualDesAddress;
	    			delete formParam.unitTel;
	    			delete formParam.unitEmail;
	    			delete formParam.webSiteName;
	    			delete formParam.webSite;
                    url = '/reg/server/registinfo/registinfo/batchModi';
                }
                http.httpRequest({
                    url: url,
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
            }
        })

        //拼接管辖人员字符串
        function sliceMantoStr() {
            var sliceMan = '';
            if ($('input[name="sliceMan"]').length < 1)return "";
            $('input[name="sliceMan"]').each(function (item) {
                sliceMan += "," + $(this).val();
            });
            return sliceMan.substr(1);
        }

        //拼接管辖人员联系电话字符串
        function sliceMantoStr() {
            var sliceMan = '';
            if ($('input[name="sliceMan"]').length < 1)return "";
            $('input[name="sliceMan"]').each(function (item) {
                sliceMan += "," + $(this).val();
            });
            return sliceMan.substr(1);
        }
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#logoff-table',
            //是否加索引值
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                url: '/reg/server/registinfo/unlicensedinfo/listForLogoff.json',
                data: function (d) {
                    d.params = {
                       /* name: leRep,
                        cerNO: cerNO,
                        entName: entName,
                        proLoc: dom*/
                    }
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center'},
                {data: null, 'className': 'center'},
                {data: 'name'},
                {data: 'cerNO'},
                {data: 'mgrName'},
                {data: 'sliceNoName'},
                {data: 'setName'},
                {data: 'setTime'}

            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="radio" data-unlicstate="' + row.unlicState + '" data-uid="' + row.uid + '" data-pripid="' + row.priPID + '" name="_checkbox" value=' + row.uid + '>';
                    }
                }
            ]
        })
    }
    
    function initDataTable2() {
    	var priPID = $("#priPID").val();
        table2 = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#kancha-table',
            //是否加索引值
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                url: '/reg/server/registinfo/registinfo/registSurverList.json',
                data: function (d) {
                    d.params = {
                        priPID: priPID
                    }
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center',width:'15px'},
                {data: null, 'className': 'center'},
                {data: 'surverDate'},
                {data: 'surverName',className: 'left',cut: {length: 20,mark:'...'}},
                {data: 'surverInfo',className: 'left',cut: {length: 40,mark:'...'}}

            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<a href="javascript:void(0)" class="js_edit">修改</a>';
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    layer.close();
                }
            },
            {
                el: '#save',
                event: 'click',
                handler: function () {
                	var isSameAddr = $("input[name='isSameAddr']:checked").val();
                	var diffAddrReason = $("input[name='diffAddrReason']:checked").val();
                	if(isSameAddr=="0"){
                		if(diffAddrReason==null||diffAddrReason==undefined||diffAddrReason=="undefined"){
                			layer.msg("注册地址与实地地址不一致必须选择原因！", {ltype: 0, time: 1000});
                		}else{
                			$('#registInfoForm').submit();
                		}
                	}else{
                		$('#registInfoForm').submit();
                	}
                }
            },
            {
                el: '.js_edit',
                event: 'click',
                handler: function () {
                	var data = table2.row($(this).closest('td')).data();
                	var priPID = $("#priPID").val();
                	layer.dialog({
                        title: '修改勘查记录',
                        area: ['80%', '80%'],
                        content: '/reg/server/registinfo/registinfo/addRecordPage?priPID='+priPID+"&uid="+data.uid,
                        callback: function (data) {
                            if (data.reload) {
                                table2.ajax.reload();
                            }
                        }
                    })
                }
            },
            {
                el: '#print',
                event: 'click',
                handler: function () {
                    var _id = "_doPrint_" + new Date().getTime();
                    var url = '/reg/server/registinfo/registinfo/toShow?fromtype=print&priPID=' + $('#priPID').val() + '&uid=' + $('#uid').val();
                    try {
                        window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no,width=1000");
                    }
                    catch (e) {
                        alert("打印错误!");
                    }
                }
            },
            {
                el: '.js-logoff',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var index = 0;
                    var uid = '';
                    var priPID = '';

                    $(":radio[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                        uid = $(this).data('uid');
                        priPID = $(this).data('pripid');

                    });
                    if (ItemIds.length <1) {
                        layer.msg("请选择一项进行操作", { time: 500});
                        return;
                    }
                    if (ItemIds.length >1) {
                        layer.msg("只能选择一项进行操作", { time: 500});
                        return;
                    }
                    layer.dialog({
                        title: '编辑销户信息',
                        area: ['90%', '90%'],
                        content: '/reg/server/registinfo/unlicensedinfo/toLogoffShow?uid=' + uid + '&priPid=' + priPID,
                        callback: function (data) {
                            //重新加载列表数据
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            },
            {
                el: '.js_addrecord',
                event: 'click',
                handler: function () {
                	var priPID = $("#priPID").val();
                    layer.dialog({
                        title: '添加勘查记录',
                        area: ['80%', '80%'],
                        content: '/reg/server/registinfo/registinfo/addRecordPage?priPID='+priPID,
                        callback: function (data) {
                            if (data.reload) {
                                table2.ajax.reload();
                            }
                        }
                    })
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            },
            {
                el: '.js-fold',
                event: 'click',
                handler: function () {
                    if ($(this).hasClass('fold-on')) {
                        $(this).text('展开企业信息');
                        $(this).removeClass("fold-on");
                    } else {
                        $(this).text('隐藏企业信息');
                        $(this).addClass("fold-on");
                    }

                    $(this).parent().prev('.table-horizontal').toggle();
                    $('.detail-brief').toggleClass('border-bottom');
                }
            },
            {//1乡镇街道编辑
                el: '#streetAdd',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '乡镇街道编辑',
                        area: ['90%', '600px'],
                        content: '/reg/server/registinfo/registinfo/tostreetAdd?supCode=' + $('#localAdm').val() + '&content=' + $('#streetd').html() + '&code=' + $('#street').val(),
                        callback: function (data) {
                            if (data.names == null) return;
                            $('#streetd').html(data.names);
                            $('#street').val(data.codes);
                        }
                    });
                }
            },
            {//2片区商圈编辑
                el: '#sliceNOAdd',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '片区商圈编辑',
                        area: ['90%', '600px'],
                        content: '/reg/server/registinfo/registinfo/tosliceNOAdd?supCode=' + $('#localAdm').val() + '&sliceNOName=' + $('input[name="sliceNOName"]').val() + '&sliceNO=' + $('input[name="sliceNO"]').val(),
                        callback: function (data) {
                            if (data.names == null) return;
                            $('#sliceNONameDiv').val(data.names);
                            $('input[name="sliceNOName"]').val(data.names);
                            $('input[name="sliceNO"]').val(data.codes);
                        }
                    });
                }
            },
            {//3管辖人员编辑
                el: '#sliceManAdd',
                event: 'click',
                handler: function () {
                    var priPID = $('input[name="priPID"]').val();
                    var localAdm = $('#localAdm').val();
                    var sliceMan = $('#sliceMan').val();
                    var sliceTel = $('#sliceTel').val();
                    layer.dialog({
                        title: '请选择管辖人员',
                        area: ['90%', '600px'],
                        /*content: '/reg/server/registinfo/registinfo/toAddsliceman?priPID=' + priPID + '&localAdm=' + localAdm +
                        '&sliceMan=' + sliceMan + '&sliceTel=' + sliceTel,*/
                        content: '/reg/server/registinfo/registinfo/toSlicemanAdd?sliceMan=' + sliceMan + '&sliceTel=' + sliceTel,
                        callback: function (data) {
                            if (data.sliceManShow == null || data.sliceManShow == '') return;
                            $('#sliceManp').val(data.sliceManShow);
                            $('#sliceMan').val(data.sliceMan);
                            $('#sliceTel').val(data.sliceTel);
                        }
                    });
                }
            },
            { //4监管对象编辑
                el: '#supAdd',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '编辑监管项目',
                        area: ['30%', '600px'],
                        content: '/reg/server/registinfo/registinfo/toSuperAdd?superNoNames=' + $('#superNoNames').val() +
                        '&superNos=' + $('#superNos').val() + '&superType=' + $('#superType').val(),
                        callback: function (data) {
                            if (data.names == null) return;
                            //回显选择的数据
                            $('#superNoNamesDiv').html(data.names);
                            $('#superNoNames').val(data.names);
                            $('#superNos').val(data.codes);
                            $('#superType').val('');
                        }
                    })
                }
            },
            { //5主体标签--编辑
                el: '#_markfocusAdd',
                event: 'click',
                handler: function () {
                	var val=$('input:radio[name="registMarkType"]:checked').val();
                	if(val==null||val==""||val=="undefined"||val==undefined){
                		layer.msg('无分类标签时请勾选一般标签！', {time: 1000});
                	}else{
                		var pripid = _fromtype == 'batch' ? "" : $("#priPID").val(); 
                		layer.dialog({
                			title: "编辑标签",
                			area: ['90%', '600px'],
                			content: '/reg/server/registinfo/registinfo/toMarkAdd?priPID=' + pripid,
                			callback: function (data) {
                				if (data.names == null) return;
                				$('#iDCodeNamesDiv').html("");
                				var array = data.names.split(",");
                				for(i=0;i<array.length ;i++){
                					$('#iDCodeNamesDiv').append("<span class='tag33cccc tag-item' >"+array[i]+"</span>");
                				}
//                            $('#iDCodeNamesDiv').html(data.names);
                				$('#iDCodes').val(data.codes);
                				$('#iDCodeNames').val(data.names);
                				
                			}
                		});
                	}

                }
            },
            { //6是否实地勘察：是 显示
                el: 'input[name="isInvestigate"]',
                event: 'click',
                handler: function () {
                    if ($('input[name="isInvestigate"]:checked').val() == '1') {
                        $('.isInvestigateDiv').show();
                    } else {
                        $('.isInvestigateDiv').hide();
                    }

                }
            }
            ,
            { //7经营场所地址与实地是否一致：不一致 显示
                el: 'input[name="isSameAddr"]',
                event: 'click',
                handler: function () {
                    if ($('input[name="isSameAddr"]:checked').val() == '0') {
                        $('.isSameAddrDiv').attr('style', 'visibility:visible');
                    } else {
                        $('.isSameAddrDiv').attr('style', 'visibility:hidden');
                        if ($('input[name="diffAddrReason"]:checked').val() == '2') {
                            $('#opLoc').attr('style', 'visibility:hidden');
                        } else {
                            $('#opLoc').attr('style', 'visibility:hidden');
                        }
                    }

                }
            }
            ,
            { //8选中异地经营显示
                el: 'input[name="diffAddrReason"]',
                event: 'click',
                handler: function () {
                    if ($('input[name="diffAddrReason"]:checked').val() == '2') {
                        $('#opLoc').attr('style', 'visibility:visible;width:350px;');
                    } else {
                        $('#opLoc').attr('style', 'visibility:hidden');
                    }
                }
            },
            { //9个转企日期显示
                el: 'input[name="changeArchState"]',
                event: 'click',
                handler: function () {
                    if ($('input[name="changeArchState"]:checked').val() == '3' || $('input[name="changeArchState"]:checked').val() == '4') {
                        $('#changeArchState_span').attr('style', 'display:inline-block');
                    } else {
                        $('#changeArchState_span').attr('style', 'display:none');
                    }
                }
            },
            { //行政许可信息展开与收起
                el: '#licenceinfo',
                event: 'click',
                handler: function () {
                    if ($(this).hasClass('flexed-icon')) {
                    	$("#_tab-pubotherlicence").show();
                        $(this).removeClass("flexed-icon");
                    } else {
                    	$("#_tab-pubotherlicence").hide();
                        $(this).addClass("flexed-icon");
                    }
                }
            },
            {
                el: '.js-fold-pubinfo',
                event: 'click',
                handler: function () {
                    if ($(this).hasClass('reverse')) {
                        $(this).html('收起全部详情<i></i>');
                        $(this).removeClass("reverse");
                        $(this).addClass("more");
                        $(".js-show").show();
                        //强制重新计算datatable列宽
                        $.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
                    } else {
                        $(this).html('展开公示详情<i></i>');
                        $(this).addClass("reverse");
                        $(this).addClass("more");
                        $(".js-show").hide();
                    }
                }
            },
            {
                el: '.js-registMarkType',
                event: 'click',
                handler: function () {
                	 if ($('input[name="registMarkType"]:checked').val() == '1') {//选择一般监管
                		$('.js-markfocus').hide();
                		$('#iDCodes').val('');
                		$('#iDCodeNames').val('');
                    	$('#iDCodeNamesDiv').html("");
                	}else{//选择其他
                		$('.js-markfocus').show();
                	}

                }
            }
        ])
    }

    /**拼接各种字主体标签和监管项目管辖人员字符串传到后台解析
     */
    function addParam(formParam) {
        //主体标签
        var iDType = '';
        var iDCodeNames = '';
        var iDCodes = '';
        $('_markfocusAdd').each(function () {
            var type = $(this).data('marktype');
            iDType += ',' + type;
            iDCodes += '&' + $('.IDCode' + type).val();
            iDCodeNames += '&' + $('.IDName' + type).val();

        });
        formParam.iDType = iDType.substr(1);
        formParam.iDCodeNames = iDCodeNames.substr(1);
        formParam.iDCodes = iDCodes.substr(1);
        return formParam;

    }
})