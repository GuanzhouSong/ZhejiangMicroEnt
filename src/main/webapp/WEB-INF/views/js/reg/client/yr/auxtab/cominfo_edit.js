require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/paginationPage',
    'component/clearform',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'pagination',
    'laydate',
    'component/sfc_report',
    'jquery.placeholder',
    'jquery.icinfo'
], function (layer, util, http,handlebars,paginationPage,clearform) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    init();
    laydate.skin('molv');//初始化皮肤
    var start = {
        elem: '#_start', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas; //将结束日的初始值设定为开始日
            var $this = $('#_start');var cls = 'error-tips';
            if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
            }
        }
    };
    var end = {
        elem: '#_end',
        format: 'YYYY-MM-DD',
        min: '1970-01-01',
        max: '2099-06-16',
        istime: true,
        istoday: false,
        start: laydate.now(0,"YYYY-MM-DD"),
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
            var $this = $('#_end');var cls = 'error-tips';
            if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
            }
        }
    };

    //开始时间和结束时间
    $("#_start").click(function(){laydate(start);});
    $("#_end").click(function(){laydate(end);});

    //重置时间开始时间选择 初始化
    function  _intTime(){
        start.min= '1970-01-01';
        start.max='2099-06-16';
        end.min= '1970-01-01';
        end.max= '2099-06-16';
        end.start= laydate.now(0,"YYYY-MM-DD");
    }
    /**
     * 初始化函数集合
     */

    function init() {
        init_table();
        Form1FormValid();// 综合表
        Form3FormValid(); //综合分表
        Form2Valid();//荣誉表
        bind();
        eacho();//回显初始化
    }

    //判断综合信息表得 年报 状态来判断是查看还填报或修改状态
    function eacho(){
        var declStatus = $("#_declStatus").val();// 获取 综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回
        if(declStatus=='1'||declStatus=='2'){ //只能查看
            $("input,select").attr("disabled","disabled");
            $("textarea").attr("readonly","readonly");
            $(".js-edit,.js-delete,.icon-close,.btn-common").hide();
        }
    }

    /**
     * 其他信息表单验证 并保存
     */
    function Form1FormValid() {

        $('#Form1').validate({
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
              /* if(el.name!='farArtType'){ // 提交的时候再进行判断
                   $(el).valid();
               }*/
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#Form1 input[name='+i+'],#Form1 select[name='+i+']'), index, parentEle, cls;
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
                farArtType: { //合作社类型
                    required: true
                },
                farArtProName:{ // 主要农产品名称
                   maxlength:100
                },
                farArtMemNum:{ //合作社成员数(人)
                    digits: true,
                    maxlength:10

                },
                farArtArea:{ //生产基地面积(亩)
                    area:true,
                   maxlength:16
                },
                farArtDriFarmerNum:{ //带动农户
                    digits: true,
                    maxlength:10
                },
                farArtPriProArea:{ //自有产权房面积(平方米)
                   area:true,
                   maxlength:16
                },
                farArtSalesIncRatio:{ //销售额年增长率
                   percent:true,
                   maxlength:6
                },
                farArtInpProRatio:{ //统一采购农业投入品比例
                   percent:true,
                   maxlength:6
                },
                farArtSaleProRatio:{ //统一销售主产品比例
                    percent:true,
                    maxlength:6
                },
                farArtOtherItem:{ //其他事项执行情况
                    maxlength:500
                },

                farArtTecTrain: { //上年度组织开展技术培训
                    required:true
                },
               laiyuan: { //培训师来源
                   required:function(){
                       //获取当前选择中的值
                       var _v = $("input:radio[name=farArtTecTrain]:checked").val();
                       if(_v=='0'){return false;}return true;
                   }
                },
                farArtTrainNum:{ //上年度组织或参加培训总数
                    required:function(){
                        //获取当前选择中的值
                        var _v = $("input:radio[name=farArtTecTrain]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    digits: true,
                    maxlength:4
                },
                farArtMemAttNum:{ //参加培训人数
                    required:function(){
                        //获取当前选择中的值
                        var _v = $("input:radio[name=farArtTecTrain]:checked").val();
                        if(_v=='0'){return false;}
                        return true;
                    },
                    digits: true,
                    maxlength:10
                },
                far:{         //已开展的质量工作有
                   required: true
                },
                farArtWebName:{  //网站
                    //url:true,
                   maxlength:100
                },
                farArtWebUrl:{   //网址
                    url:true,
                   maxlength:100
                },
                farArtDemoCoopGrade:{ //示范合作社验收情况
                   required:true
                },
               farArtBank:{ //开户银行（基本户
                   maxlength:100
                },
               farArtBankAccount:{  //帐号
                   maxlength:30
                },
               entOrgCode:{  //组织机构代码证号
                   maxlength:50
                },
               taxRegNo:{  //税务登记证号
                   maxlength:50
                }

            },
            messages: {
               /* farArtDemoCoopGrade:"请选择一项",
                farArtTecTrain:"请选择一项",
                farArtType:"请选择一项"*/
            },
            submitHandler: function () {
                //判断Form3效验是否通过

               /* if(!($('#Form3').valid())){ //效验没有通过则不往下执行
                    return ;
                }*/

                //判断chebox选项没有填写的默认设置为0
                $("._default").each(function(i,index){
                    if(!$(this).prop('checked')){
                        $(this).val("0").prop("checked",true);//将值设置为0 并且选中
                    }
                });

                var formParam1 = $('#Form1').serializeObject();

                //* 上年度组织开展技术培训  有   培训师来源
                if($("input:radio[name=farArtTecTrain]:checked").val()=='1'){
                    $(".source").each(function(i,index){
                        if($(this).prop('checked')){
                            var paramsName = $(this).data('name');
                           formParam1[paramsName]='1';
                        }
                    });
                }else{
                    formParam1['farArtTeaExt']='';
                    formParam1['farArtTeaInt']='';
                }

                //已开展的质量工作有 判断 start
                $(".work").each(function(i,index){
                    var $this = $(this);
                    if($(this).prop('checked')){
                        var paramsName = $(this).data('name');
                        formParam1[paramsName]='1';
                    }else{
                        var _name = $this.data('name');
                        formParam1[_name]='';
                    }
                });
                //已开展的质量工作有 判断 end

              /*  var formParam3 = $('#Form3').serializeObject();
                var fromParam = $.extend({}, formParam1, formParam3);*/

                $(".js-btn-save").attr("disabled", true); //防止表单重复提交

                http.httpRequest({
                    url: '/reg/client/yr/sfc/cominfo/save',
                    serializable: false,
                    data: formParam1,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success'){
                            layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                //window.close();
                                window.location.reload();//延迟重新刷新页面
                                /* var timer = null;
                                 clearTimeout(timer);
                                 timer = setTimeout(function(){
                                 //window.close();

                                 },1000);*/
                            });
                        }else if(data.status=='fail'){
                            $(".js-btn-save").attr("disabled", false); //
                            layer.msg(data.msg, {icon: 2,time: 1000});
                        }
                    },
                    error:function(){
                        $(".js-btn-save").attr("disabled", false); //
                    }
                });

            }
        });
    };
    //Form3 表单校验
    function Form3FormValid(){
        //Form3 表单校验
        $('#Form3').validate({
            onkeyup:false,
            onfocusout:function(el){
              $(el).valid();
            },
            onsubmit:false,
            rules: {
                leRep: { //法定代表人
                    //required: true,
                    maxlength:30
                },
                leRepTel: { //固定电话
                    //required: true,
                    isTel:true,
                    maxlength:30
                },
                leRepPhone: { //移动电话
                    //required: true,
                    checkMobile:true,
                    maxlength:30
                },
                finance: { //财务负责人
                    //required: true,
                    maxlength:30
                },
                financeTel: { //固定电话
                    //required: true,
                    isTel:true,
                    maxlength:30
                },
                financePhone: { //移动电话
                    //required: true,
                    checkMobile:true,
                    maxlength:30
                },
                liaName: { //工商联络员
                    //required: true,
                    maxlength:30
                },
                liaTel: { //固定电话
                    //required: true,
                    isTel:true,
                    maxlength:30
                },
                liaPhone: { //移动电话
                    //required: true,
                    checkMobile:true,
                    maxlength:30
                },
                unitEmail: { //单位电子邮箱
                    //required: true,
                    email:true,
                    maxlength:100
                },
                liaEMail: { //联络员电子邮箱
                    //required: true,
                    email:true,
                    maxlength:100
                }

            },
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#Form3 input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });
                }
            },
            messages: {},
            submitHandler: function () {
            }
        });
    }


    //列表初始化
    function init_table(){
        //loadData(0,5);
        var options = {
            page:0,                                     //开始页
            length:5,                                   //长度
            items_per_page:5,                           //每页显示几条              默认10条
            params:$('#_params').serializeObject(),     //查询参数,                 必填项
            url:'/reg/client/yr/sfc/honor/list_json',    //url 访问路径              必填项
            type:'post',                                //请求方式
            pagination:'#pagination',                   //分页显示的位置             必填项
            myTemplate:'#table-template',               //script:模板路径           必填项
            html:'#_listPage',                          //需要渲染的html            必填项
            total:'#_total',                            //显示页面总数的位置         必填项
            pageNmber:'#_pageNum'                      //显示多少页的位置           必填项
        };
       paginationPage.loadData(options);

    };

    var _flag = false; //用于判断是新增还是修改的标记字符  true：表示新增  false:修改
    //保存荣誉 Form2　表单
    function Form2Valid(){
        $('#Form2').validate({
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
               /* if(el.name!='valFrom'&&el.name!='valTo'){ //时间的特殊处理
                    $(el).valid();
                }*/
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#Form2 input[name='+i+']'), index, parentEle, cls;
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
                farArtHonorName: {
                    required: true,
                    maxlength:100
                },
                farArtHonorIssAut: {
                    required: true,
                    maxlength:100
                },
                valFrom: {
                    required: true
                },
                valTo:{
                    required: true
                }
            },
            messages: {
                valFrom: "请选择开始时间",
                valTo:"请选择结束时间"
            },
            submitHandler: function () {
                var formParam = $('#Form2').serializeObject();
                $(".js-submit").attr("disabled",true);
                $(".js-submit").val("提交中...");
                http.httpRequest({
                    url: '/reg/client/yr/sfc/honor/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {

                        _intTime(); //重新初始化时间
                        if(data.status=='success'){
                            layer.msg(data.msg, {icon: 1,time: 1000},function (){
                                $('#Form2')[0].reset();//重置为空字符串
                                $('#Form2 input[type="text"]').val('');
                                init_table();
                                if (!_flag) { //判断当前是新增还是修改
                                    $(".js-editUI").slideUp("slow");
                                }
                                $(".js-submit").attr("disabled",false);
                                $(".js-submit").val("确定");

                            });
                        }else{
                            $(".js-submit").attr("disabled",false);
                            $(".js-submit").val("确定");
                            layer.msg('添加失败!', {icon: 2,time: 1000});
                        }
                    },
                    error:function(){

                        $(".js-submit").attr("disabled",false);
                        $(".js-submit").val("确定");

                    }
                });
            }
        })
    };


    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-cancel',  // 荣誉 表单填写中的 取消操作
                event: 'click',
                handler: function () {
                    clearform.clearTips('Form2'); //清除表单验证校验
                    $('#Form2')[0].reset();//重置为空字符串
                    $('#Form2 input[type="text"]').val('');
                    $(".js-editUI").slideUp("slow");
                }
            },
            {
                el: '.js-addUI',  //新增展开页面
                event: 'click',
                handler: function () {
                    _flag = true ; //新增的时候设置为true
                    $(".js-editUI").slideDown('slow');
                }
            },
            {
                el: '#_checkAll',  // 全选 操作
                event: 'click',
                handler: function () {
                    var flag=$(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            },
            {
                el: '.js-delete',  //批量删除
                event: 'click',
                handler: function () {
                    var batch_arr = [];
                    $("input:checkbox[name='_checkbox']:checked").each(function () {
                        batch_arr.push($(this).val());
                    });
                    if (batch_arr.length > 0) {
                        layer.confirm('您确定要删除选中的<em style="color: red;">'+batch_arr.length+'</em>数据吗？', {icon: 2, title: '提示'}, function (index) {
                            var uid = batch_arr.toString();
                            var _index;
                            http.httpRequest({
                                url: '/reg/client/yr/sfc/honor/batch_delete',
                                beforeSend:function(){ //发送前执
                                    _index = layer.load(2, {shade: 0.5});
                                },
                                serializable: false,
                                data: {'uid': uid},
                                type: 'post',
                                success: function (data) {
                                    layer.close(_index);
                                    if(data.status=='success'){
                                        layer.msg("删除成功", {icon: 1,time: 1000},function(){
                                            //重新加载列表：
                                            init_table();
                                        });

                                    }
                                }
                            });
                            layer.close(index);//关闭窗口
                        });
                    }else {
                        layer.msg("请您<em style='color: red;'>【选中一项】</em>进行删除操作!", {icon: 7,time: 1000});
                    }
                }
            },
            {
                el: '.js-edit',  //修改
                event: 'click',
                handler: function () {
                    clearform.clearTips('Form2'); //清除表单验证校验
                    //解决下一页的修改的问题
                    $('#Form2')[0].reset();//重置为空字符串
                    $('#Form2 input[type="text"]').val('');
                    _flag = false;   // 修改的时候讲标志修改为false
                    var batch_arr = [];
                    $("input:checkbox[name='_checkbox']:checked").each(function () {
                        batch_arr.push($(this).val());
                    });
                    if(batch_arr.length>0&&batch_arr.length==1){
                        $(".js-editUI").slideDown("slow");
                        var uid = batch_arr.toString();
                        http.httpRequest({
                            url: '/reg/client/yr/sfc/honor/edit_show',
                            serializable: false,
                            data: {'uid':uid},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                    //数据回显
                                    $("#_uid").val(data.data.uid);
                                    $("#_priPID").val(data.data.priPID);
                                    $("#_year").val(data.data.year);
                                    $("#farArtHonorName").val(data.data.farArtHonorName);
                                    $("#farArtHonorIssAut").val(data.data.farArtHonorIssAut);
                                    $("#_start").val(data.data.valFrom);
                                    $("#_end").val(data.data.valTo);
                                }
                            }
                        });
                    }else if(batch_arr.length>1){
                        layer.msg("当前操作<em style='color: red;'>【只能选择一条】</em>进行操作!", {icon: 7,time: 1000});
                    }else{
                        layer.msg("请您<em style='color: red;'>【至少选中一项】</em>进行修改操作!", {icon: 7,time: 1000});
                    }
                }
            },

            {
                el: '.js-btn-save',  // 总表提交
                event: 'click',
                handler: function () {
                    $('#Form1').submit();
                }
            },
            {
                el: '.js-btn-cancel',  // 取消
                event: 'click',
                handler: function () {
                    layer.confirm('您确定取消当前操作吗？', { btn: ['确定', '取消'],icon: 3, title: '温馨提示',closeBtn: 0}, function (index) {
                        window.close();//关闭当前窗口
                    });

                }
            },
            {
                el: '#tel_no',  //企业联系电话 无
                event: 'click',
                handler: function () {
                    $('input[name="tel"]').val("");//设置值为空
                    $('input[name="tel"]').attr("readonly","readonly").css("background","#CCC");
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
                el: '.js-farArtTecTrain_no',  //上年度组织开展技术培训  选择无
                event: 'click',
                handler: function () {
                    $('.source').prop("checked",false).attr("disabled","disabled");
                    $("#farArtTrainNum").val('').prop('readonly', true);//上年度组织或参加培训总数(次)
                    $("#farArtMemAttNum").val('').prop('readonly', true);//参加培训人数(人/次)
                    clearform.clearTips('js-source'); //清除chebox校验
                    clearform.clearSelect($('#farArtTrainNum'));//消除验证的红色边框和提示
                    clearform.clearSelect($('#farArtMemAttNum'));//消除验证的红色边框和提示
                }
            },
            {
                el: '.js-farArtTecTrain_have',  //上年度组织开展技术培训  选择有
                event: 'click',
                handler: function () {
                    $('.source').prop("checked",false).removeAttr("disabled");
                    $("#farArtTrainNum").val('').prop('readonly', false);//上年度组织或参加培训总数(次)
                    $("#farArtMemAttNum").val('').prop('readonly', false);//参加培训人数(人/次)
                }
            },
            {
                el: '#farArtWebsite_no',  //设立独立网站或网页 设置 无
                event: 'click',
                handler: function () {
                   $('#farArtWebName, #farArtWebUrl').val('').prop('readonly', true).removeClass('required');
                    clearform.clearSelect($('#farArtWebName'));clearform.clearSelect($('#farArtWebUrl'));
                }
            },
            {
                el: '#farArtNetRelInfo_no',  //运用互联网络发布信息 设置 无
                event: 'click',
                handler: function () {
                    $('#farArtNetAdCost').val('').prop('readonly', true).removeClass('required');
                    clearform.clearSelect($('#farArtNetAdCost'));
                }
            },
            {
                el: '#farArtNetSales_no',  //通过网络销售产品或服务 设置 无
                event: 'click',
                handler: function () {
                    $('#farArtNetSalesAmount').val('').prop('readonly', true).removeClass('required');
                    clearform.clearSelect($('#farArtNetSalesAmount'));
                }
            },
            {
                el: '#setTimes',  //设置长期有效时间
                event: 'click',
                handler: function () {
                    $('#_end').val('9999-09-09')
                    var $this = $('#_end');var cls = 'error-tips';
                    if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                        if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
                    }
                }
            }


        ])
    }


});

