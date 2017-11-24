require([
    'component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'handlebars',
    'layer1',
    'common/ajaxfileupload',
    'jquery',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'laydate',
    'jquery.placeholder',
    'jquery.icinfo',
    'pagination'
], function (layer, dataTable, util, http, handlebars,layer1) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initInvid();
        bind();
        getReportDueDays();
        formValidOne();
        formValidTwo();
        formValid_liaison_One();
        formValid_liaison_Two();

        hx_dialog();//联络员弹出框
        //获取文书回执条数
        getWenShuResultCount();
    }
    
    
    //获取文书回执条数
    function  getWenShuResultCount(){ 
        http.httpRequest({
            url: '/reg/client/yr/ent/writ/queryYearReportPageResult.json',
            serializable: false,
            data: $("#queryYearReportForm").serializeObject(),
            type: 'get',
            success: function (data) { 
            	 try {
		        	  var dataArr=data.data;
		              var trHtml="<tr>"+
		 			  "<td colspan='4'>暂无数据</td>" +
		 			   "</tr>";
		             	if(dataArr.length>0){
		             		var count=1;
		             		$(dataArr).each(function(a,b){
		             			var trHtml="<tr>"+
		             					"<td>"+count+"</td>" +
		             					"<td>"+b.taskCode+"</td>" +
		             					"<td>"+b.taskName+"</td>" +
		             					"<td width='100'><a target='_blank' href='/reg/client/yr/ent/writ/noticeprint?resultUid="+b.uid+"&priPID="+b.priPID+"'>通知书</a></td>" +
		             					"</tr> " 
		             			count++;
		             			$("#writ_sccheck_list").append(trHtml);
		             		});
		             	}else{ 
		             		$("#writ_sccheck_list").append(trHtml);
		             	}
		             	var wenshu_total=data.recordsTotal==null?"0":data.recordsTotal; 
		          	    $("#wenshu_total").text(wenshu_total); 
                 } catch (err) { 
                 } 
            }
        });
     }


    //联络员弹出框
    function hx_dialog(){
        //////////////////////////////////////证书登录的联络员 弹出框 start////////////////////////////////////////////////////////////////////////
        var liaisonLogin = $("#liaisonLogin").val();//判断是否是联络员登录
        var date_flag = $("#date_flag").val();      //用于判断新的一年是否是首次登录
        if(!liaisonLogin){ //用于判断是否是联络员登录
            var liaison = $("#_liaison").val(); //联络员是否有数据
            var flag = $("#_flag").val(); //用于判断法人代表是否发生变更

            if(!liaison){        //联络员信息是否存在 不存在则弹出*/
                layer.dialog({title:'', content: $('#js-liaison-info'), closeBtn: 0, type: 1, area: ['946px','388px']});
            }
            if(flag=='false'){    //判断法定代表人是否发生变化 发生变化则弹出
                layer.dialog({title:'', content: $('#js-liaison-info'), closeBtn: 0, type: 1, area: ['946px','388px']});
            }
            if(date_flag=="false"){
                layer.dialog({title:'', content: $('#js-liaison-info'), closeBtn: 0, type: 1, area: ['946px','388px']});
            }
            /////////////////////////////////////证书登录的联络员 弹出框 end/////////////////////////////////////////////////////////////////////////

        }else{

            ////////////////////////////////////联络员登录的 弹出框  start/////////////////////////////////////////////////////////////////////////
            var _lerep = $("#liaison_lerep_two").val();//法定代表人（负责人）姓名
            var _lerepphone = $("#liaison_lerepphone_two").val();//法定代表人（负责人）手机号码
            if(!(_lerep&&_lerepphone)){
                layer.dialog({title:'', content: $('#js-liaison-login-info'), closeBtn: 0, type: 1, area: ['946px','358px']});
            }
            if(date_flag=="false"){
                layer.dialog({title:'', content: $('#js-liaison-login-info'), closeBtn: 0, type: 1, area: ['946px','358px']});
            }

            ////////////////////////////////////联络员登录的 弹出框  end  //////////////////////////////////////////////////////////////////////////
        }
    }

    //////////////////////////////////////证书登录的联络员 表单处理 start////////////////////////////////////////////////////////////////////////
    // 联络员表单 变更
    function formValidOne() {
        $('#FormOne').validate({
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
                    var ele = $('#FormOne input[name='+i+'],#FormOne select[name='+i+']'), index, parentEle, cls;
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
                lerep: { //法定代表人（负责人）姓名
                    required: true,
                    maxlength:100
                },
                lerepphone:{ //法定代表人（负责人）手机号码
                    required: true,
                    checkMobile:true
                },
                lianame:{  //企业联络员姓名
                    required: true,
                    maxlength:50
                },
                liaidtype:{  //企业联络员证件类型
                    required: true
                },
                tel:{  //企业联络员手机号码
                    required: true,
                    checkMobile:true
                },
                liaidnum:{  //企业联络员证件号码
                    required:true,
                    idCard:{
                        depends: function(element) {
                            var _v = $('#_select1').val();
                            if(_v=='10')return true;
                            return false;
                        }
                    }
                }
            },
            messages: {
                //liaidtype:"请选择一项"
            },
            submitHandler: function () {

                //法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样
                var lerep1 = $.trim($("#lerep1").val());            //法人代表姓名
                var lerepphone1 = $.trim($("#lerepphone1").val());  //法人代表手机号码
                var lianame1 = $.trim($("#lianame1").val());        //企业联络员姓名
                var tel1 = $.trim($("#tel1").val());                //联络员的手机号码

                //判断手机号码是否相同
                if(lerepphone1==tel1){
                    if(lerep1!=lianame1){
                        layer.alert("法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样",{ title: '提示', icon: 7,closeBtn: 0,yes:function(index){
                            $("#tel1").select();
                            layer.close(index);
                        }});
                        return;
                    }
                }
                //判断验证码是否为空
                var password = $("#js-password-one").val();
                if(!password){  //判断验证码是否为空
                    layer.tips('请输入验证码','#js-password-one',{tips:3, tipsMore:true, ltype:0});
                    return;
                }

                var _formParam = $('#FormOne').serializeObject();
                $(".js-change-save").attr("disabled", true).val("提交中...");  //防止表单重复提交

                http.httpRequest({
                    url: '/reg/client/liaison/save',
                    data: _formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {

                                $("#js-password-one").val(''); //清空验证码
                                $(".js-change-save").attr("disabled", false).val("确定");
                                $("#js-change-UI").slideUp("slow");

                                //回显页面修改的值
                                $("#liaison_lerep").html(_formParam['lerep']);//法人姓名
                                $("#liaison_lerepphone").html(_formParam['lerepphone']);//法人联系电话
                                $("#liaison_lianame").html(_formParam['lianame']);//联络员姓名
                                $("#liaison_tel").html(_formParam['tel']);//联络员电话

                            });
                        }else if(data.status=='fail'){
                            layer.alert(data.msg, {icon:5},function(index){
                                layer.close(index);
                            });
                            $(".js-change-save").attr("disabled", false).val("确定");

                        }
                    },
                    error:function(){
                        $(".js-change-save").attr("disabled", false).val("确定");
                    }
                });
            }
        })
    };

    //联络员表单Two 添加 和  变更
    //联络员表单 变更
    function formValidTwo() {
        $('#FormTwo').validate({
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
                    var ele = $('#FormTwo input[name='+i+'],#FormTwo select[name='+i+']'), index, parentEle, cls;
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
                            index = layer.tips(errorMap[i], $(this), {tips: 3, time: 0,zIndex:19891099999})
                        }, function () {
                            layer.close(index);
                        }))
                    })(i);
                }
            },
            rules: {
                lerep: { //法定代表人（负责人）姓名
                    required: true,
                    maxlength:100
                },
                lerepphone:{ //法定代表人（负责人）手机号码
                    required: true,
                    checkMobile:true
                },
                lianame:{  //企业联络员姓名
                    required: true,
                    maxlength:50
                },
                liaidtype:{  //企业联络员证件类型
                    required: true
                },
                tel:{  //企业联络员手机号码
                    required: true,
                    checkMobile:true
                },
                liaidnum:{  //企业联络员证件号码
                    required:true,
                    idCard:{
                        depends: function(element) {
                            var _v = $('#_select2').val();
                            if(_v=='10')return true;
                            return false;
                        }
                    }
                }
            },
            messages: {
                //liaidtype:"请选择一项"
            },
            submitHandler: function () {

                //法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样
                var lerep2 = $.trim($("#lerep2").val());            //法人代表姓名
                var lerepphone2 = $.trim($("#lerepphone2").val());  //法人代表手机号码
                var lianame2 = $.trim($("#lianame2").val());        //企业联络员姓名
                var tel2 = $.trim($("#tel2").val());                //联络员的手机号码

                //判断手机号码是否相同
                if(lerepphone2==tel2){
                    if(lerep2!=lianame2){
                        layer.alert("法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样",{ title: '提示', icon: 7,closeBtn: 0,yes:function(index){
                            $("#tel2").select();
                            layer.close(index);
                        }});
                        return ;
                    }
                }
                //判断验证码是否为空
                var password = $("#js-password-two").val();
                if(!password){  //判断验证码是否为空
                    layer.tips('请输入验证码','#js-password-two',{tips:3, tipsMore:true, ltype:0,zIndex:19891099999});
                    //layer.msg("请输入验证码", {icon: 7,time: 2000},function(){ $("#js-password-two").focus()});
                    return;
                }
                var formParam = $('#FormTwo').serializeObject();
                $(".js-FormTwo").attr("disabled", true).val("提交中...");  //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/liaison/save',
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function (index) {
                                $("#js-password-two").val(''); //清空验证码
                                layer.closeAll();//关闭弹出层
                            });
                            window.location.reload(); //重新加载页面
                        }else if(data.status=='fail'){
                            layer.alert(data.msg, {icon: 5},function(index){
                                layer.close(index);
                            });
                            $(".js-FormTwo").attr("disabled", false).val("提交");
                        }
                    },
                    error:function(){
                        $(".js-FormTwo").attr("disabled", false).val("提交");
                    }
                });
            }
        })
    };
    //////////////////////////////////////证书登录的联络员 表单处理 end////////////////////////////////////////////////////////////////////////



    //=========================================================================================================================================
    //////////////////////////////////////联络员登录的 联络员表单处理 start////////////////////////////////////////////////////////////////////////
    function formValid_liaison_One() {
        $('#Form_lianson_one').validate({
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
                    var ele = $('#Form_lianson_one input[name='+i+']'), index, parentEle, cls;
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
                lerep: { //法定代表人（负责人）姓名
                    required: true,
                    maxlength:100
                },
                lerepphone:{ //法定代表人（负责人）手机号码
                    required: true,
                    checkMobile:true
                }
            },
            submitHandler: function () {

                //法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样
                var liaison_lerep_one = $.trim($("#liaison_lerep_one").val());            //法人代表姓名
                var liaison_lerepphone_one = $.trim($("#liaison_lerepphone_one").val());  //法人代表手机号码
                var liaison_lianame_one = $.trim($("#liaison_lianame_one").val());        //企业联络员姓名
                var liaison_tel_one = $.trim($("#liaison_tel_one").val());                //联络员的手机号码

                //判断手机号码是否相同
                if(liaison_lerepphone_one==liaison_tel_one){
                    if(liaison_lerep_one!=liaison_lianame_one){
                        layer.alert("法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样",{ title: '提示', icon: 7,closeBtn: 0,yes:function(index){
                            $("#liaison_lerepphone_one").select();
                            layer.close(index);
                        }});
                        return;
                    }
                }
                var lianson_formParam_one = $('#Form_lianson_one').serializeObject();
                $(".js-liaisonChange-save").attr("disabled", true).val("提交中...");  //防止表单重复提交

                http.httpRequest({
                    url: '/reg/client/liaison/liaisonUpdate',
                    data: lianson_formParam_one,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {

                                $(".js-liaisonChange-save").attr("disabled", false).val("确定");
                                $("#js-change-UI").slideUp("slow");
                                $("#liaison_lerepphone_one").prop("readonly",true);
                                $("#liaison_lerep_one").prop("readonly",true);
                                $(".js-liaisonChange-save").hide();

                                //回显页面修改的值
                                $("#liaison_lerep").html(lianson_formParam_one['lerep']);//法人姓名
                                $("#liaison_lerepphone").html(lianson_formParam_one['lerepphone']);//法人联系电话
                                $("#liaison_lianame").html(lianson_formParam_one['lianame']);//联络员姓名
                                $("#liaison_tel").html(lianson_formParam_one['tel']);//联络员电话

                            });
                        }else if(data.status=='fail'){
                            layer.alert(data.msg, {icon:5},function(index){
                                layer.close(index);
                            });
                            $(".js-liaisonChange-save").attr("disabled", false).val("确定");

                        }
                    },
                    error:function(){
                        $(".js-liaisonChange-save").attr("disabled", false).val("确定");
                    }
                });
            }
        })
    };

    function formValid_liaison_Two() {
        $('#Form_lianson_two').validate({
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
                    var ele = $('#Form_lianson_two input[name='+i+']'), index, parentEle, cls;
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
                            index = layer.tips(errorMap[i], $(this), {tips: 3, time: 0,zIndex:19891099999})
                        }, function () {
                            layer.close(index);
                        }))
                    })(i);
                }
            },
            rules: {
                lerep: { //法定代表人（负责人）姓名
                    required: true,
                    maxlength:100
                },
                lerepphone:{ //法定代表人（负责人）手机号码
                    required: true,
                    checkMobile:true
                }
            },
            submitHandler: function () {

                //法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样
                var liaison_lerep_two = $.trim($("#liaison_lerep_two").val());            //法人代表姓名
                var liaison_lerepphone_two = $.trim($("#liaison_lerepphone_two").val());  //法人代表手机号码
                var liaison_lianame_two = $.trim($("#liaison_lianame_two").val());        //企业联络员姓名
                var liaison_tel_two = $.trim($("#liaison_tel_two").val());                //联络员的手机号码

                //判断手机号码是否相同
                if(liaison_lerepphone_two==liaison_tel_two){
                    if(liaison_lerep_two!=liaison_lianame_two){
                        layer.alert("法定代表人（负责人）和联络员非同一人时，不允许法定代表人（负责人）的手机号码和联络员的手机号一样",{ title: '提示', icon: 7,closeBtn: 0,yes:function(index){
                            $("#liaison_tel_two").select();
                            layer.close(index);
                        }});
                        return;
                    }
                }
                var lianson_formParam_two= $('#Form_lianson_two').serializeObject();
                $(".js-liaison-save").attr("disabled", true).val("提交中...");  //防止表单重复提交

                http.httpRequest({
                    url: '/reg/client/liaison/liaisonUpdate',
                    data: lianson_formParam_two,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                layer.closeAll();//关闭弹出层
                            });
                            window.location.reload(); //重新加载页面
                        }else if(data.status=='fail'){
                            layer.alert(data.msg, {icon:5},function(index){
                                layer.close(index);
                            });
                            $(".js-liaison-save").attr("disabled", false).val("提交");

                        }
                    },
                    error:function(){
                        $(".js-liaison-save").attr("disabled", false).val("提交");
                    }
                });
            }
        })
    };

    //////////////////////////////////////联络员登录的 联络员表单处理 end ////////////////////////////////////////////////////////////////////////


    //手机验证码获取倒计时
    var wait = 60;//时间
    function time($this) {
        if (wait == 0) {
            $this.val('获取验证码');//显示按钮
            //绑定获取验证码事件
            var codeClass = $this.data("code");
            $this.addClass(codeClass);
            wait = 60;
        } else {
            $this.val(wait + '秒');//显示时间
            wait--;
            setTimeout(function() {
                time($this);//循环调用
            },1000);
        }
    }

    //触发事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-Code-one',  // 获取验证码  one
                event: 'click',
                handler: function () {
                    var $this = $(this);
                    //校验通过才能获取验证码
                    if($('#FormOne').valid()) {
                        var phone = $.trim($("#tel1").val());
                        var lianame = $.trim($("#lianame1").val());
                        http.httpRequest({
                            url: '/reg/client/liaison/acceptPwd',
                            data: {'phone':phone,'lianame':lianame},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success') {
                                    layer.alert("验证码已发至你企业联络员<em style='color: red'>" + lianame + "</em>号码为<em style='color: red'>" + phone + "</em>的手机上，<em style='color: red'>10</em>分钟内有效，过期请重新获取！", {icon: 6,title:"提示"},function(index){layer.close(index)});
                                    $this.removeClass("js-Code-one");//移出点击事件
                                    time($this); //60秒倒计时
                                }else if(data.status=='fail'){
                                    layer.alert("获取失败!短信机故障,请告知技术支持,请稍后再试,敬请谅解！", {icon: 5,title:"提示"},function(index){layer.close(index)});
                                }
                            },
                            error: function () {}
                        });
                    }
                }
            },
            {
                el: '.js-Code-two',  // 获取验证码  two
                event: 'click',
                handler: function () {
                    var $this = $(this);
                    //校验通过才能获取验证码
                    if($('#FormTwo').valid()){
                        var phone = $.trim($("#tel2").val());
                        var lianame = $.trim($("#lianame2").val());
                        http.httpRequest({
                            url: '/reg/client/liaison/acceptPwd',
                            data: {'phone':phone,'lianame':lianame},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success') {
                                    layer.alert("验证码已发至你企业联络员<em style='color: red'>" + lianame + "</em>号码为<em style='color: red'>" + phone + "</em>的手机上，<em style='color: red'>10</em>分钟内有效，过期请重新获取！", {icon: 6,title:"提示"},function(index){layer.close(index)});
                                    $this.removeClass("js-Code-two");//移出点击事件
                                    time($this); //60秒倒计时
                                }else if(data.status=='fail'){
                                    layer.alert("获取失败!短信机故障,请告知技术支持,请稍后再试,敬请谅解！", {icon: 5,title:"提示"},function(index){layer.close(index)});
                                }
                            },
                            error:function(){}
                        });
                    }
                }
            },
            {
                el: '.js-change',  // 变更
                event: 'click',
                handler: function () {
                    $("#js-change-UI").slideDown("slow");
                }
            },
            {
              el:'.js-change-cancel',//变更取消
              event:'click',
              handler:function(){
                  $("#js-change-UI").slideUp("slow");
              }
            },
            {
                el:'.modify_liaison_phone',//修改
                event:'click',
                handler:function(){
                    $("#liaison_lerepphone_one").prop("readonly",false);
                    $(".js-liaisonChange-save").show();
                    var hehuo_value = $("#commCopany").val();
                    if(hehuo_value && hehuo_value=="2733"){
                        $("#liaison_lerep_one").prop("readonly",false);
                    }

                }
            },

            {
            el: '#_operation',
            event: 'click',
            handler: function () {

                var _EntTypeCatg = $("#_EntTypeCatg").val();//获取企业大类的值
                if(_EntTypeCatg&&_EntTypeCatg!='50'){  //用于判断不是个体户的需要年份顺序进行填报操作
                    /*获取当前年份和年报状态*/
                    var _obj = new Object();
                    $("._reportCheck").each(function(){
                        var key = $(this).data("year");
                        var _value = $(this).data("status");
                        _obj[key] = _value;
                    });
                    var _year = $(this).data("year");//获取选中年份
                    for(var key in _obj){
                        if(key<parseInt(_year,10)){//将年份转换为10进制
                            if(_obj[key]=='0'){
                                layer.msg("上年度年报未完成前不能申报本年度年报！请先完成<em style='color: red;'>"+key+"</em>年度报告。", {icon: 7,time: 5000});
                                return;
                            }
                        }
                    }
                }
                //路径：window._CONFIG.operation_url：<c:url value="/reg/client/yr/yrwritehomepage/write_homepage"/>
                var encodeYear =  $(this).data("encodeyear"); //获取加密的年份参数
                var url = window._CONFIG.operation_url+"?year="+encodeYear;
                var reportState = $(this).data("reportstate");
                var _windows = new Array();
                var index = 0;
                //打开新窗口
                _windows[index] = window.open(url);
                if(reportState=='00'||reportState=='13'||reportState=='20') {  //判断当前年报处于何种状态  填报  修改 将执行下面的代码
                    var text = $(this).text().replace(/(^\s*)|(\s*$)/g, "");   //获取当前所处的状态文本值并去掉左右空格
                    layer.alert("您当前操作处于年报<em style='color:red'>"+text+"</em>状态!",{ title: '温馨提示', icon: 7,closeBtn: 0,yes:function(index){
                        window.location.reload();
                        layer.close(index);
                    }});

                }
            }
        },
        {
            el: '#sfc_operation',  //  农专 辅助报表
            event: 'click',
            handler: function () {
               var $this = $(this);
               var isReported = $this.data("status");//获取目前年报的状态：0未年报；1已年报；2已年报（逾期）
               var year = $this.data("year");       //获取年份
               var pripid = $this.data("pripid"); //获取身份主体代码
               var url = $this.data("url");       //获取跳转的填报页面
               if(isReported=='0'){
                   layer.msg("年度年报未完成前不能申报辅助报表！请先完成<em style='color: red;'>"+year+"</em>年度报告。", {icon: 7,time: 5000});
                   return;
               }
               var encodeYear =  $(this).data("encodeyear"); //获取加密的年份参数
               window.open(url+"?year="+encodeYear); //打开 农专填报页面
            }
        },

            {
        	 el: '#questionaireView',
             event: 'click',
             handler: function () {
            	 var auditState = $("#auditState").val();
            	 if(auditState =='1' || auditState ==''){
    	        	 layer.confirm('是否确认完成个转企经营情况表的填报？', {icon: 2, title: '提示'}, function (index) {
    	        		 http.httpRequest({
                             url: '/reg/client/yr/ent/indiviquemain/search',
                             serializable: false,
                             type: 'get',
                             success: function (data) {
                                 if(data.status=='success'){
                                	 var backState = data.data.auditState;
                                	 if(backState == '2' || backState == '3'){
                                		 $("#indiviStatus").html("").removeClass("nopass").text("已报送：");
                                		 $("#auditState").val(backState);
                                	 }
                                 }
                             }
                         });
    	      		   layer.close(index);
    	             });
            	 }
             }
        },{
       	 el: '#foodBaseView',
         event: 'click',
         handler: function () {
        	 var submitState = $("#submitState").val();
        	 if(submitState != '2'){
	        	 layer.confirm('是否确认完成食品仓储备案表填表？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url: '/reg/client/yr/ent/foodstoragebase/search',
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 var backState = data.data.submitState;
                            	 if(backState == '2'){
                            		 $("#foodStatus").html("").removeClass("nopass").text("已报送：");
                            		 $("#submitState").val(backState);
                            	 }
                             }
                         }
                     });
	      		   layer.close(index);
	             });
        	 }
         }
    },{//------------------------------------------------简易注销开始---------------------------------------------------------
    	el: '.tab-apply',
    	event: 'click',
    	handler: function () {
      		 http.httpRequest({
                 url: '/reg/client/simpleesc/erescappinfo/check',
                 serializable: false,
                 type: 'get',
                 success: function (data) {
                	 if(data.status=='success'){
	                     if(data.data !=null && (data.data.simplecanRea == null || data.data.simplecanRea == '')){ // 已经保存还未公示
	                    	   $("#simpleapply").show();
	                    	   $("#escid").val(data.data.id);
	                    	   if(data.data.commitment != null){
	                    		   var commitment = data.data.commitment;
	                    		   var post = commitment.indexOf("-");
	                    		   var file = commitment.substring(post+1);
	                    		   $("#commitment_file,#uploadfile").hide();
	                       		   $("#showfile").show().val(file);
	                       		   $("#uploadurl").val(commitment);
	                       		   $("#reloadfile").show();
	                    	   }
	                     }else if(data.data !=null && data.data.simplecanRea !=null){                         // 已经保存已经公示或者撤销
	                    	   $("#simpleinfo").show();
	                    	   var noticeFrom = data.data.noticeFrom;
	                    	   var noticeTo = data.data.noticeTo;
	                    	   var endDate = data.data.endDate;
	                    	   var simplecanRea = data.data.simplecanRea;
	                    	   $("#noticeTime").text(noticeFrom+' 至 '+noticeTo);
	                    	   // 公告期开始
	                    	   $("#startTime").text(noticeFrom);
	                    	   // 公告期结束
	                    	   $("#endTime").text(noticeTo);
	                    	   // 内网申请截止日期
	                    	   $("#endDate").text(endDate);
	                    	   $("#simple_status").text(handleDataToContent(simplecanRea));
	                    	   if(data.data.simplecanRea == '5'){
	                    		   $("#apply_cancel").hide();
	                    	   }
	                    	   // 加载异议申请信息
	                    	   loadObjectionInfo(0,10);
	                     }else{                                                                                // 未保存未公示
		                 	   layer1.open({
		                       shade: [0.5,'#000'],
		                       type: 1,
		                       content: $('.logout-layer'),
		                       title: false,
		                       area: ['68%','74%']
		                    }) 
	                     }
	                 }
                 }
             });
    	}
    },{
    	el: '.btn-sure',
    	event: 'click',
    	handler: function () {
    		if($("#read").prop("checked")){
	       		 http.httpRequest({
	                 url: '/reg/client/simpleesc/erescappinfo/isMatch',
	                 serializable: false,
	                 type: 'get',
	                 success: function (data) {
	                     if(data.status=='success'){
	                    	 layer1.closeAll();
	                    	 $("#simpleapply").show();
	                     }else{
	                    	 layer.alert(data.msg, {icon: 5});
	                     }
	                 }
	             });
    		}else{
    			 layer.msg("请先阅读你企业是否满足简易注销的条件!", {time: 3000});
    		}
    	 }
    },{
    	el: '.apply-save',
    	event: 'click',
    	handler: function () {
    		var saveType = $(this).attr("state");
        	if($("#showfile").val() == ""){
        		layer.msg("请先上传全体投资人承诺书！", {time: 3000}, function() {});
        		return false;
        	}
    		var formParam = $('#simapplyform').serializeObject();
    		formParam.saveType = saveType;
    		if(saveType == "02"){
    			http.httpRequest({
    	            url: '/reg/client/simpleesc/erescappinfo/tipInfo',
    	            serializable: false,
    	            data: formParam,
    	            type: 'get',
    	            success: function (data) {
    	               if(data.status=='success'){
                    	   $("#noticefrom").text(dateFormate(data.data.noticeFrom));
                    	   $(".noticeto").text(dateFormate(data.data.noticeTo));
                    	   $(".tipTime").text(dateFormate(data.data.endDate));
        	           	   layer1.open({
        	                   shade: [0.5,'#000'],
        	                   type: 1,
        	                   content: $('.simConfirm'),
        	                   title: false,
        	                   area: ['600px','280px']
        	               }) 
    	                }
    	             }
    	        });
    		}else{
    			//保存
    			saveSimpleInfo(formParam);
    		 }
    	  }
       },{
    	   el: '#confirm',
	       event: 'click',
	       handler: function () {
    		 http.httpRequest({
                 url: '/reg/client/simpleesc/erescappinfo/cancel',
                 serializable: false,
                 type: 'get',
                 success: function (data) {
                     if(data !=null){
                    	 layer.msg(data.msg, {time: 2000});
                    	 layer1.closeAll();
                    	 $(".tab-apply").trigger("click");
                     }
                  }
              });
	       }
       },{
    	   el: '#confirm02',
	       event: 'click',
	       handler: function () {
	    	   var formParam = $('#simapplyform').serializeObject();
	    	   formParam.saveType = "02";
	    	   // 保存并公示
	    	   saveSimpleInfo(formParam);
	    	   layer1.closeAll();
	       }
       },{
    	   el: '#apply_cancel',
	       event: 'click',
	       handler: function () {
	    	   layer1.open({
                   shade: [0.5,'#000'],
                   type: 1,
                   content: $('.tzy-cns-box'),
                   title: false,
                   area: ['445px','220px']
                }) 
	        }
       },{
    	   el: '#reloadfile',
	       event: 'click',
	       handler: function () {
	    	   $(this).hide();
	    	   $("#uploadfile").show();
	    	   $("#commitment_file").show();
	    	   $("#showfile").val("").hide();
	    	   $("#uploadurl").val("");
	        }
       },{
           el: '#print',
           event: 'click',
           handler: function () {
               var _id = "_doPrint_"+new Date().getTime();
               var priPID = $("#priPID").val();
               var url = "/reg/client/simpleesc/erescappinfo/print?priPID="+priPID;
               try{
                   window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
               }catch(e){
                   alert("打印错误!");
               }
           }
       },{
    	   el: '.tipcancel',
	       event: 'click',
	       handler: function () {
	    	   layer1.closeAll();
	       }
       }])
    }
    
    $("#uploadfile").click(function(){
    	upload($(this));
    })
    
    // 上传
	function upload(e){
    	var file = $("#commitment_file").val();
    	var prefix = $("#priPID").val()+new Date().getTime();
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	
    	var ext = file.substr(file.lastIndexOf("."));
    	if(!(ext.indexOf(".jpg") != -1 || ext.indexOf(".JPG") != -1)){
    		layer.msg("请上传格式为jpg的图片！", {time: 3000}, function() {});
    		return false;
    	}
    	
    	var pos=file.lastIndexOf("\\");
    	file = file.substring(pos+1);
    	e.hide();
    	$("#uploading").show();
    	$.ajaxFileUpload({
            url: "/reg/client/simpleesc/erescappinfo/upload",
            type: 'post',
            data: {"prefix":prefix},
            secureuri: false,
            fileElementId: 'commitment_file',
            dataType: 'text',
            success: function(data, status){
            	if(data !="error" && data != "false") {
            		// 限制路径结构，防止失败的上传返回值存入DB
            		if(data.indexOf("simpleesc/commitment") == -1){
            			layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            		}else{
            			$("#uploadurl").val(data);
                		$("#showfile").val(file);
    	            	layer.msg("上传成功", {time: 1200}, function() {});
            		}
            	}else if(data == "error"){
            		layer.msg("上传失败", {time: 2000}, function() {});
            	}else if(data == "false"){
            		layer.msg("上传的文件大小不能超过1M", {time: 2000}, function() {});
            	}
            	$("#uploading").hide();
            	e.show();
            },error: function(data, status){
            	$("#uploading").hide();
            	e.show();
            	layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            }
        });
    }
    
    function saveSimpleInfo(formParam){
		http.httpRequest({
            url: '/reg/client/simpleesc/erescappinfo/save',
            serializable: false,
            data: formParam,
            type: 'post',
            success: function (data) {
           	 if(data.status == 'error'){
           		 layer.msg(data.msg, {time: 2000}); 
           	 }else{
               	 layer.msg(data.msg, {time: 2000});
               	 $("#simpleapply").hide();
               	 $(".tab-apply").trigger("click");
                }
            }
        });
    }
    
    function dateFormate(pramdate){
    	if(pramdate == null || pramdate == '' || pramdate == 'undefined' ){
    		return '';
    	}
    	var timeArry = pramdate.split('-');
        return timeArry[0]+'年'+timeArry[1]+'月'+timeArry[2]+'日';
    }
    
	// 加载简易注销异议信息
    function loadObjectionInfo(page, length, callback){
        	var params = {priPID:$("#priPID").val()};
            http.httpRequest({
                url: '/pub/simpleesc/erescobjinfo/list.json',
                data: {start: page*length,length: length,params:params},
                success: function (data) {
                    var itemCount = data.recordsTotal;
                    //生产许可证个数
                    $('.pagination').pagination(itemCount, {
                        prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,
                        num_edge_entries: 2,
                        current_page: page,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页',
                        callback:function(page,jq){
                        	loadObjectionInfo(page,10);
                        }
                    });
                    var infoArry = data.data;
                    var showResult = "";
                    if(infoArry != null){
                    	for(var j=0;j<infoArry.length;j++){
                    		var objectionStr = infoArry[j].objection;
                    		var scResultArr = objectionStr.split(",");
                        	for(var i=0;i<scResultArr.length;i++){
                        		if(parseInt(scResultArr[i]) == 1){
                        			showResult = showResult + '有债权债务未结清;';
                        		}else if(parseInt(scResultArr[i]) == 2){
                        			showResult = showResult + '属于涉及国家规定实施准入特别管理措施的外商投资企业;';
                        		}else if(parseInt(scResultArr[i]) == 3){
                        			showResult = showResult + '正在被列入企业经营异常名录或严重违法失信企业名单;';
                        		}else if(parseInt(scResultArr[i]) == 4){
                        			showResult = showResult + '存在股权（投资权益）被冻结，出质或动产抵押等情形;';
                        		}else if(parseInt(scResultArr[i]) == 5){
                        			showResult = showResult + '有正在被立案调查或采取行政强制，司法协助，被予以行政处罚等情形的;';
                        		}else if(parseInt(scResultArr[i]) == 6){
                        			showResult = showResult +  '企业所属的非法人分支机构未办理注销登记;';
                        		}else if(parseInt(scResultArr[i]) == 7){
                        			showResult = showResult +  '曾被终止简易注销程序;';
                        		}else if(parseInt(scResultArr[i]) == 8){
                        			showResult = showResult +  '属于法律，行政法规或者国务院决定规定在注销登记前需经批准的企业;';
                        		}else{
                        		}
                        	}
                        	infoArry[j].objection = showResult;
                    	}
                    }
                    var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
                    var myTemplate = handlebars.compile($("#objection_table").html());
                    $('#objection_page').html(myTemplate(data));
                    $("#tody_total").text(itemCount);
                    var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                    $("#tody_pageNum").text(pageNum);
                }
           });
    }
    
    function handleDataToContent(changeNum){
    	if(changeNum == '1'){return "准予简易注销";}
    	if(changeNum == '2'){return "不予简易注销";}
    	if(changeNum == '3'){return "不予受理";}
    	if(changeNum == '4'){return "正在进行简易注销公告";}
    	if(changeNum == '5'){return "已撤销简易注销公告";}
    }
    
    //-----------------------------------------------简易注销结束-----------------------------------------------
    //获取年报截止天数
    function getReportDueDays() {
        var nowDate  = new Date();
        if(nowDate.getMonth() < 6){
        	var endDate = new Date(nowDate.getFullYear() + '-06-30');
        	var days  =  Math.ceil(Math.abs(nowDate - endDate) / 1000 / 60 / 60 / 24);
        	$(".dueDays").html(days);
        	$("#reportDueDays").show();
        }else{
        	$("#reportDueDays").hide();
        }
    };

    //是否填报个转企经营表提示
    function initInvid(){
    	var auditState = $("#auditState").val();
    	var questionaireFlag = $("#questionaireFlag").val();
    	if((auditState == '1' || auditState == "") && questionaireFlag == "true"){
    		layer.confirm('你企业尚未填写或提交《“个转企”企业发展情况调查表》，请尽快完成。', {icon: 2, title: '提示'}, function (index) {
    		   window.open("/reg/client/yr/ent/individquestionnaire/view");
    		   layer.close(index);
           });
    	}
    }
});
