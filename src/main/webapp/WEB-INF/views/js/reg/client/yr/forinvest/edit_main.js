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
    'pagination',
    'laydate',
    'component/report',
    'jquery.placeholder',
    'jquery.icinfo'
], function (layer, util, http,handlebars,clearform) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        int_table_last();//初始化表 前一年的数据
        init_table_tody();//初始化表 当前年份
        formValid();
        init_acConAm(); //实缴出资额 逻辑判断初始化
        reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
        bind();
    }

    // 判断 实缴投资（总额） 是否为 0
    function init_acConAm(){
        $("#acConAm").blur(function() {
            var _v = $(this).val().replace(/(^\s*)|(\s*$)/g, "");
            _v =  parseFloat(_v);
            if(_v==0){
                clearform.clearTips('_czfs');
                //出资方式：
                $("#_czfs").css("background","#E9E8E8");
                $("._acConForm").attr("disabled","disabled");
            }else{
                //出资方式：
                $("#_czfs").css("background","");
                $("._acConForm").removeAttr("disabled");
            }
        });
    }


    //年报状态判断
    function reportStateFrom(){
        var _value = $("#_reportState").val();
        if(_value!='00'&&_value!=='20'&&_value!='13'){
            //$("input").attr("disabled","disabled");
            $(".subcapital-tips, .btn-add, .btn-box, .js-radio").hide();
        }
    }

    var _flag = false; //用于判断是新增还是修改的标记字符  true：表示新增  false:修改

    /**
     *  对外投资信息表单验证 并保存
     */
    function formValid() {
        $('#forinvestForm').validate({
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
                    var ele = $('#forinvestForm input[name='+i+']'), index, parentEle, cls;
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
                uniCode: { //对外投资企业统一社会信用代码（或注册号）
                    required: true,
                    maxlength:18
                },
                entName:{ //投资设立（或购买股权境内）企业名称
                    required: true,
                    maxlength:200
                },
                subConAm:{ //认缴投资总额
                    required:true,
                    millionUnits:true,
                    checkMoney:true,
                    maxlength:16
                },
                subConProp:{ //认缴投资所占比例(%)
                    required:true,
                    percentTwo:true
                },
                acConAmProp:{ //实缴投资所占比例(%)
                    required:true,
                    percentTwo:true
                },
                conForm:{ //认缴投资方式
                    required:true
                },
                acConAm:{ //实缴投资总额
                    required:true,
                    millionUnits:true,
                    maxlength:16
                },
                _acConForm:{ //实缴投资方式
                    required:true
                }
            },
            messages: {
               /* conForm:"请勾选出资方式",
                _acConForm:"请勾选出资方式"*/
            },
            submitHandler: function () {

                /*checkbox 设置值 start*/
                //认缴
                var arr_oneCode = [];
                var arr_oneText = [];
                $("input:checkbox[name=conForm]:checked").each(function(){
                    arr_oneCode.push($(this).val());
                    arr_oneText.push($(this).data("text"));
                });
                $("#select_subConForm").val(arr_oneCode.toString());
                $("#select_conFormCN").val(arr_oneText.toString());//存中文

                //实缴
                var arr_towCode = [];
                var arr_towText = [];
                $("input:checkbox[name=_acConForm]:checked").each(function(){
                    arr_towCode.push($(this).val());
                    arr_towText.push($(this).data("text"));
                });
                $("#select_acConForm").val(arr_towCode.toString());
                $("#select_acConFormCn").val(arr_towText.toString());//存中文

                /*checkbox 设置值 end*/

                /*序列化表单 并过滤不必传递的name属性值*/
                var formParam = $('#forinvestForm').serializeObject();

                //移出不需要提交的name值
                delete formParam.conForm;
                delete formParam._acConForm;

                $(".js-submit").attr("disabled", true);  //防止表单重复提交
                $(".js-submit").val("提交中...");
                http.httpRequest({
                    url: '/reg/client/yr/ent/forinvestment/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {

                        $(".js-submit").attr("disabled", false);
                        $(".js-submit").val("确定");

                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                $("#outinvid").val("");
                                $("#select_subConForm").val("");
                                $("#select_conFormCN").val("");
                                $("#select_acConForm").val("");
                                $("#select_acConFormCn").val("");
                                $('#forinvestForm')[0].reset();//重置为空字符串
                                $('#forinvestForm input[type="text"]').val('');

                                if (!_flag) { //判断当前是新增还是修改
                                    //收起
                                    var $span = $(this).find("span");
                                    $span.text($span.text() == '收起' ? '展开' : '收起');
                                    $(this).toggleClass('drop-on');
                                    $(".js-editUI").slideUp("slow");
                                }
                                init_table_tody();//重新排列
                                $(".js-submit").attr("disabled", false);
                                $(".js-submit").val("确定");
                            });
                        }else if(data.status=='fail'){
                            $(".js-submit").attr("disabled", false);
                            $(".js-submit").val("确定");
                            layer.msg(data.msg, {icon: 2,time: 1000});
                        }
                    },
                    error:function(){
                        $(".js-submit").attr("disabled", false);
                        $(".js-submit").val("确定");
                    }
                });
            }
        })
    };



    /**
     * 初始化表1 当前年份的前一年
     *
     */
    function int_table_last(){
        var year = $("#_year").val();//获取当前年份
        if(!(parseInt(year-1)==parseInt(2012))) {  //如果当前年份的上一年不等于2012年怎进行加载数据
            loadData_last(0, 5);
            year = parseInt(year-1,10);
            var priPID = $("#_priPID").val();
            var msg = "last";
            _money(year,priPID,msg); //重新计算金额值
        }
    };

    function loadData_last(page, length, callback) {
        var params = $('#last_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/forinvestment/list_json_last',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#last_pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page: 5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_last(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("num", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($('#last-table-template').html());
                $('#last_list').html(myTemplate(data));
                $("#last_total").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#last_pageNum").text(pageNum);//共多少页
            }
        });
    };

    //设置 认缴 和实缴 的合计值
    function _money(year,priPID,msg){
        http.httpRequest({
            url: '/reg/client/yr/ent/forinvestment/countMoney',
            serializable: false,
            type: 'post',
            data:{'year':year,'priPID':priPID},
            success: function (data) {
                if(data.status=='success'){
                    if(data.data){
                        var money = (data.data).split(",");
                        if(msg=='tody'){
                            $("#tody_money_rj").text(money[0]);
                            $("#tody_money_sj").text(money[1]);
                        }else if(msg=='last'){
                            $("#last_money_rj").text(money[0]);
                            $("#last_money_sj").text(money[1]);
                        }
                    }
                }
            }
        });
    }


    /**
     * 初始化表2 当前年份
     */
    function init_table_tody(){
        loadData_tody(0,5);

    };
    function loadData_tody(page, length, callback) {
        var _params = $('#tody_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/forinvestment/list_json_tody',
            serializable: false,
            data: {start: page*length,length: length,params:_params},
            type: 'post',
            success: function (data) {

                var year = $("#_year").val();
                var priPID = $("#_priPID").val();
                var msg = "tody";
                _money(year,priPID,msg); //重新计算金额值

                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#tody_pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page: 5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_tody(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("num", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($("#tody-table-template").html());
                $('#tody_list').html(myTemplate(data));
                $("#tody_total").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#tody_pageNum").text(pageNum);//共多少页

                //判断有无对外担保是否进行选中状态：
                if(itemCount>0){
                    $('input[type="radio"][name="touzhi"][value="1"]').prop("checked",true);
                }
            }
        });
    };




    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '#uniCode',  // 根据统一社会信用代码和注册号  获取境内企业名称
                event: 'blur',
                handler: function () {
                    var $this  = $(this);
                    var thisValue = $.trim($this.val()); //获取当前对象值并且去掉左右空格
                    if(thisValue&&thisValue.length>4){
                        http.httpRequest({
                            url: '/reg/client/yr/ent/forinvestment/regNo_getEntName',
                            serializable: false,
                            data: {'regNo': thisValue},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                  $("#entName").val(data.data).prop("readonly",false);
                                }
                            }
                        });
                    }else{
                        $("#entName").val('').prop("readonly",true);
                    }

                }
            },
            {
                el: '.js-cancel',  // 表单填写中的 取消操作
                event: 'click',
                handler: function () {
                    clearform.clearTips('forinvestForm'); //清除表单验证校验
                    layer.closeAll('tips'); //关闭所有的tips层
                    $("#outinvid").val("");
                    $("#entName").val("").prop("readonly",true);
                    $("#select_subConForm").val("");
                    $("#select_conFormCN").val("");
                    $("#select_acConForm").val("");
                    $("#select_acConFormCn").val("");
                    $('#forinvestForm')[0].reset();//重置为空字符串
                    $('#forinvestForm input[type="text"]').val('');
                    //收起
                    var $span = $(this).find("span");
                    $span.text($span.text() == '收起' ? '展开' : '收起');
                    $(this).toggleClass('drop-on');
                    $(".js-editUI").slideUp("slow");
                }
            },
            {
                el: '.btn-edit',  //修改
                event: 'click',
                handler: function () {
                    clearform.clearTips('forinvestForm'); //清除表单验证校验
                    //解决下一页的修改的问题
                    $('#forinvestForm')[0].reset();//重置为空字符串
                    $('#forinvestForm input[type="text"]').val('');

                    _flag = false;   // 修改的时候讲标志修改为false
                    var batch_arr = [];
                    $("input:checkbox[name='_checkbox']:checked").each(function () {
                        batch_arr.push($(this).val());
                    });
                    if(batch_arr.length>0&&batch_arr.length==1){
                        //先展开
                        var $span = $(this).find("span");
                        $span.text($span.text() == '收起' ? '展开' : '收起');
                        $(this).toggleClass('drop-on');
                        $(".js-editUI").slideDown("slow");

                        var outinvid = batch_arr.toString();
                        var priPID = $("#_priPID").val();
                        http.httpRequest({
                            url: '/reg/client/yr/ent/forinvestment/edit_show',
                            serializable: false,
                            data: {'outinvid':outinvid,'priPID':priPID},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                    //给表单设置值
                                    $("#outinvid").val(data.data.outinvid);//
                                    $("#uniCode").val(data.data.uniCode);//对外投资企业统一社会信用代码（或注册号）
                                    $("#entName").val(data.data.entName).prop("readonly",false);//投资设立（或购买股权境内）企业名称

                                    $("#subConProp").val(data.data.subConProp); //认缴投资所占比例(%)
                                    $("#acConAmProp").val(data.data.acConAmProp); //实缴投资所占比例(%)

                                    var subConAm = data.data.subConAm;
                                    var acConAm = data.data.acConAm;
                                    $("#subConAm").val(parseFloat((isNaN(subConAm) ? "0.0000" : subConAm) - 0).toFixed(4));//认缴投资总额 默认保留4有效数字！
                                    $("#acConAm").val(parseFloat((isNaN(acConAm) ? "0.0000" : acConAm) - 0).toFixed(4));//实缴投资总额 默认保留4有效数字！

                                    //判断 实缴外资额 是否是0
                                    if(parseFloat(acConAm)==0){
                                        $("#_czfs").css("background","#E9E8E8");
                                        $("._acConForm").attr("disabled","disabled");
                                    }

                                    if(data.data.subConForm){
                                        var conFormCNArray = (data.data.subConForm).split(",");//出资方式 认缴
                                        //选项回显
                                        $("input:checkbox[name=conForm]").each(function(){
                                            if(util.in_array(conFormCNArray,$(this).val())){
                                                $(this).prop("checked",true);
                                            }
                                        });
                                    }
                                    if(data.data.acConForm){
                                        var acConFormCnArray = (data.data.acConForm).split(",");//出资方式（实缴）
                                        $("input:checkbox[name=_acConForm]").each(function(){
                                            if(util.in_array(acConFormCnArray,$(this).val())){
                                                $(this).prop("checked",true);
                                            }
                                        });
                                    }
                                }else{
                                }
                            }
                        });
                    }else if(batch_arr.length>1){
                        layer.msg("当前操作<em style='color: red;'>【只能选择一条】</em>进行操作!", {icon: 7,time: 3000});
                    }else{
                        layer.msg("请您<em style='color: red;'>【至少选中一项】</em>进行修改操作!", {icon: 7,time: 3000});
                    }
                }
            },
            {
                el: '.btn-delete',  //批量删除
                event: 'click',
                handler: function () {
                    var year = $("#_year").val();
                    var batch_arr = [];
                    $("input:checkbox[name='_checkbox']:checked").each(function () {
                        batch_arr.push($(this).val());
                    });
                    if (batch_arr.length > 0) {
                        layer.confirm('您确定要删除选中的<em style="color: red;">'+batch_arr.length+'</em>条数据吗？', {icon: 2, title: '提示'}, function (index) {
                            layer.close(index);//关闭窗口
                            var outinvid = batch_arr.toString();
                            http.httpRequest({
                                url: '/reg/client/yr/ent/forinvestment/batch_delete',
                                serializable: false,
                                data: {'outinvid': outinvid,'year':year},
                                type: 'post',
                                success: function (data) {
                                    if(data.status=='success'){
                                        layer.msg("删除成功", {icon: 1,time: 1000},function(){
                                            $("#_checkAll").prop("checked",false);
                                            init_table_tody();//重新排列
                                        });

                                    }
                                }
                            });

                        });
                    }else {
                        layer.msg("请您<em style='color: red;'>【选中一项】</em>进行删除操作!", {icon: 7,time: 3000});
                    }
                }
            },
            /**点击三角形排序**/
            {
                el: '.order_by',  // 升序降序排序方式
                event: 'click',
                handler: function () {
                    $(".order_by").removeClass("cur");
                    $(this).addClass('cur');//添加样式并且去掉兄弟节点样式
                    var orderStr = $(this).data("order");
                    $("#_orderStr").val(orderStr);
                    loadData_tody(0,5);//根据排序条件重新排列
                }
            },
            {
                el: '.js-ui-show',  // 收起 展开
                event: 'click',
                handler: function () {
                    var $span = $(this).find("span");
                    $span.text($span.text() == '收起' ? '展开' : '收起');
                    $(this).toggleClass('drop-on');
                    $(".js-table").slideToggle("slow");
                }
            },
            {
                el: '.btn-add',  // 新增的时候 展开
                event: 'click',
                handler: function () {
                    _flag = true ; //新增的时候设置为true
                    var $span = $(this).find("span");
                    $span.text($span.text() == '收起' ? '展开' : '收起');
                    $(this).toggleClass('drop-on');
                    $(".js-editUI").slideDown("slow");
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
                el: '#js-save',  // 保存
                event: 'click',
                handler: function () {

                    var touzhi = $('input[type="radio"][name="touzhi"]:checked').val();
                    if(!touzhi){   //判断当前对外投资是否进行选中状态
                        layer.tips('请选择有无对外投资','input[type="radio"][name="touzhi"]',{tips:3, tipsMore:true, ltype:0,time:4000});
                        return;
                    }
                    var total = $("#tody_total").text(); //获取数据总数
                    if(touzhi=='1'){
                        if(!(total>0)){
                            layer.alert("请添加对外投资数据", {icon: 7, title: '提示'});return;
                        }
                    }else if(touzhi=='0'){
                        if((total>0)){
                            layer.alert("您选择的是无对外投资,但是表格中存在数据,请仔细确认!", {icon: 7, title: '提示'});return;
                        }
                    }
                    var year = $("#_year").val();//年份
                    var priPID = $("#_priPID").val();//身份主体代码
                    http.httpRequest({
                        url: '/reg/client/yr/ent/forinvestment/updateForm',
                        serializable: false,
                        data: {'year': year,'priPID':priPID},
                        type: 'post',
                        success: function (data) {
                            if(data.status=='success'){
                                layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                    window.location.reload(); //重新加载页面
                                });

                            }
                        }
                    });
                }
            }
        ])
    }
});


