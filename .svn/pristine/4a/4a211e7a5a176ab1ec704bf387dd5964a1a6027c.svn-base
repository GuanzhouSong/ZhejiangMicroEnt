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
    laydate.skin('molv');//初始化皮肤

    //********时间校验特殊处理 start *************
    $("#subConDate").click(function(){
        laydate({elem: '#subConDate', istime: true, format: 'YYYY-MM-DD', max: '2299-06-16',
            choose:function(){
                var $this = $('#subConDate');var cls = 'error-tips';
                if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                    if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
                }
            }
        });
    });
    $("#acConDate").click(function(){
        laydate({elem: '#acConDate', istime: true, format: 'YYYY-MM-DD', max: '2299-06-16',
            choose:function(){
                var $this = $('#acConDate');var cls = 'error-tips';
                if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                    if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
                }
            }
        });
    });
    //********时间校验特殊处理 end *************

    /**
     * 初始化函数集合
     */

    function init() {

        /**
         * 判断实缴出资日期是否大于当前年份
         */
        var todyYear =parseInt($("#_year").val(),10);
        $.validator.addMethod("todyYear", function(value, element) {
            var thisDate = value.substr(0,4);
            var flag = true;
            if(parseInt(thisDate,10)>todyYear){
                flag = false;
            }
            return this.optional(element) || flag;
        }, '实缴出资日期不得晚于填报年度<em style="color: red">'+todyYear+'</em>年');

        registerHelper();//出资方式初始化
        int_table_last();//初始化表 前一年的数据
        init_table_tody();//初始化表 当前年份
        formValid();
        bind();
        reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
        init_liacconam(); //实缴出资额 逻辑判断初始化
        _hover();  //逻辑关系提示初始化
    }

    //提示初始化
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


    // 判断 实缴出资额 是否为 0
    function init_liacconam(){
        $("#_acConDate").hide();
        $("#liacconam").blur(function() {
            var _v = $(this).val().replace(/(^\s*)|(\s*$)/g, "");
            _v =  parseFloat(_v);
            if(_v==0){
                $("#acConDate").hide();
                $("#_acConDate").show();
                //清除校验红色边框和 感叹号
                clearform.clearSelect($('#acConDate'));
                clearform.clearTips('_czfs');

                //出资方式：
                $("#_czfs").css("background","#E9E8E8");
                $("._acConForm").attr("disabled","disabled");

            }else{
                $("#acConDate").show();
                $("#_acConDate").hide();
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
            $(".subcapital-tips, .btn-add, .btn-box, .js-search_subcaptial").hide();
        }
    }


    function registerHelper(){
        //出资方式(格式化为中文显示)
        var handleHelper = handlebars.registerHelper("textFormat", function(value) {
            if(!value){return;} //如果没有值则 不进行转换
            var valueArrays = value.split(",");//每一行的数组值
            var text = [];//页面返回值数组
            var _obj = new Object();
            $("input:checkbox[name=conForm]").each(function(){
                var key = $(this).val();
                var _value = $(this).data("text");
                _obj[key] = _value;
            });
            for(var i=0;i<valueArrays.length;i++){
                text.push(_obj[valueArrays[i]]);
            }
            return text.toString();
        });
    }

    var _flag = false; //用于判断是新增还是修改的标记字符  true：表示新增  false:修改

    /**
     *  出资信息表单验证 并保存
     */
    function formValid() {
        $('#subcapitalForm').validate({
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
              /*  if(el.name!='subConDate'&&el.name!='acConDate'){ //时间的特殊处理
                    $(el).valid();
                }*/
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#subcapitalForm input[name='+i+']'), index, parentEle, cls;
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
                inv: { //股东（发起人姓名）
                    required: true,
                    maxlength:200
                },
                invRegNO:{ //注册号（或身份证号）
                    required: true,
                    maxlength:50
                },
                subConDate:{ //出资日期（认缴）
                    required:true
                },
                acConDate:{ //出资日期（实缴）
                    required:function(){
                        var _v = $("#liacconam").val().replace(/(^\s*)|(\s*$)/g, "");//判断实缴出资额是否是0
                        _v =  parseFloat(_v);
                        if(_v==0){
                            return false;
                        }
                        return true;
                    },
                    todyYear:true
                },
                lisubconam:{ //认缴出资额
                    required:true,
                    millionUnits:true,
                    checkMoney:true,
                    maxlength:16
                },
                liacconam:{ //实缴出资额
                    required:true,
                    millionUnits:true,
                    maxlength:16
                },
                conForm:{ //出资方式（认缴）
                    required:true
                },
                _acConForm:{ //出资方式（实缴）
                    required:function(){
                        var _v = $("#liacconam").val().replace(/(^\s*)|(\s*$)/g, "");//判断实缴出资额是否是0
                        _v =  parseFloat(_v);
                        if(_v==0){
                            return false;
                        }
                        return true;
                    }
                }
            },
            messages: {
                subConDate:"请选择日期",
                acConDate:{
                    required:"请选择日期"
                }
             /*   conForm:"请勾选出资方式",
                _acConForm:"请勾选出资方式"*/

            },
            submitHandler: function () {

                //保存前 去掉 注册号(或身份证号) 前后空格
                var invRegNO = $("#invRegNO").val().replace(/(^\s*)|(\s*$)/g, "");
                $("#invRegNO").val();

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
                var formParam = $('#subcapitalForm').serializeObject();
                //移出不需要提交的name值
                delete formParam.conForm;
                delete formParam._acConForm;
                $(".js-submit").attr("disabled", true);  //防止表单重复提交
                $(".js-submit").val("提交中...");
                http.httpRequest({
                    url: '/reg/client/yr/ent/subcapital/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                $("#invID").val("");//将主键设置为空
                                $("#select_subConForm").val("");
                                $("#select_conFormCN").val("");
                                $("#select_acConForm").val("");
                                $("#select_acConFormCn").val("");
                                $('#subcapitalForm')[0].reset();//重置为空字符串
                                $('#subcapitalForm input[type="text"]').val('');
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
             year = parseInt((year-1),10);
            var priPID = $("#_priPID").val();
            var msg = "last";
            _money(year,priPID,msg); //重新计算金额值
        }
    };

    function loadData_last(page, length, callback) {
        var params = $('#last_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/subcapital/list_json_last',
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
            url: '/reg/client/yr/ent/subcapital/countMoney',
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
            url: '/reg/client/yr/ent/subcapital/list_json_tody',
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
            }
        });
    };


    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '#search_subcaptial',  // 检索
                event: 'click',
                handler: function () {
                    var keyValue = $.trim($("#subcapita_value").val());
                    if(keyValue){
                        $("#key_value").val(keyValue);
                    }else{
                        $("#key_value").val('');
                    }
                    init_table_tody();   //重新加载列表
                }
            },
            {
                el: '#inv',  // 键盘监听事件  股东（发起人）是否有数据  主要针对手动输入的
                event: 'keyup',
                handler: function () {
                    var currentValue =  $(this).val();
                    if(!currentValue){
                        $("#invRegNO").val('').prop("readonly",true)
                    }else{
                        $("#invRegNO").prop("readonly",false)
                    }
                }
            },
            {
                el: '.js-inv-list',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '股东列表选择',
                        area: ['400px', '500px'],
                        content: '/reg/client/im/ent/investment/inv_select?priPID=' + $("#_priPID").val(),
                        callback: function (data) {
                            if(data){
                                if(data.cancel=="true"){return;}//点击的是取消操作
                                var inv=data.inv;       //股东姓名
                                var regNo = data.regNo; //证件号码
                                $("#inv").val(inv).blur();
                                if(inv){
                                    if(regNo){
                                        $("#invRegNO").val(regNo).prop("readonly",false).blur();
                                    }else{
                                        $("#invRegNO").prop("readonly",false)
                                    }
                                }
                            }
                        }
                    })
                }
            },
            {
                el: '.js-cancel',  // 表单填写中的 取消操作
                event: 'click',
                handler: function () {
                    clearform.clearTips('subcapitalForm'); //清除表单验证校验
                    layer.closeAll('tips'); //关闭所有的tips层
                    $("#invRegNO").prop("readonly",true);//设置为只读
                    $("#invID").val("");//将主键设置为空
                    $("#select_acConForm").val("");
                    $("#select_acConFormCn").val("");
                    $('#subcapitalForm')[0].reset();//重置为空字符串
                    $('#subcapitalForm input[type="text"]').val('');
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
                    clearform.clearTips('subcapitalForm'); //清除表单验证校验
                    //解决下一页的修改的问题
                    $('#subcapitalForm')[0].reset();//重置为空字符串
                    $('#subcapitalForm input[type="text"]').val('');

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

                        var invID = batch_arr.toString();
                        var priPID = $("#_priPID").val();
                        http.httpRequest({
                            url: '/reg/client/yr/ent/subcapital/edit_show',
                            serializable: false,
                            data: {'invID':invID,'priPID':priPID},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                    //给表单设置值
                                    $("#invID").val(data.data.invID);//
                                    $("#priPID").val(data.data.priPID);//身份主体priPID代码
                                    $("#year").val(data.data.year); //年份
                                    $("#inv").val(data.data.inv);//股东（发起人姓名）
                                    $("#invRegNO").val(data.data.invRegNO).prop("readonly",false);//注册号（或身份证号）
                                    $("#subConDate").val(data.data.subConDate);//出资日期（认缴）
                                    $("#acConDate").val(data.data.acConDate);//出资日期（实缴）

                                    var _lisubconam = data.data.lisubconam;
                                    var _liacconam = data.data.liacconam;
                                    $("#lisubconam").val(parseFloat((isNaN(_lisubconam) ? "0.0000" : _lisubconam) - 0).toFixed(4));//认缴出资额 默认保留4有效数字！
                                    $("#liacconam").val(parseFloat((isNaN(_liacconam) ? "0.0000" : _liacconam) - 0).toFixed(4));//实缴出资额 默认保留4有效数字！


                                    //判断 实缴出资额 是否是0
                                    if(parseFloat(_liacconam)==0){
                                        $("#acConDate").hide();
                                        $("#_acConDate").show();
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
                                    //
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
                            var invID = batch_arr.toString();
                            http.httpRequest({
                                url: '/reg/client/yr/ent/subcapital/batch_delete',
                                serializable: false,
                                data: {'invID': invID,'year':year},
                                type: 'post',
                                success: function (data) {
                                    if(data.status=='success'){
                                        layer.msg("删除成功", {icon: 1,time: 1000},function(){
                                            $("#_checkAll").prop("checked",false);
                                            //重新加载列表：
                                            init_table_tody();
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
                el: '.js-btn-add',  // 新增的时候 展开
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
                    var rj_money =parseFloat($("#tody_money_rj").text()); //认缴出资额的合计值
                    if(rj_money==0){layer.alert("认缴出资额合计值不能为<em style='color: red'>0</em>", {icon: 7, title: '提示'});return;}
                    var year = $("#_year").val();//年份
                    var priPID = $("#_priPID").val();//身份主体代码
                    var regCap = $("#RegCap").val();//注册资本
                    //判断认缴出资总和是否与注册资本(金)折万美元 相等
                    var falg = true;
                    http.httpRequest({
                        url: '/reg/client/yr/ent/subcapital/checkMoney',
                        serializable: false,
                        data: {'year': year,'priPID':priPID},
                        type: 'post',
                        async: false,// 同步
                        success: function (data) {
                            if(data.status=='fail'){
                                if(data.msg=='error'){
                                    layer.msg('传递的参数为空,保存失败!', {icon: 7,time: 3000});
                                    return;
                                }
                                layer.confirm('你企业的认缴出资总额与企业注册资本额不符，是否确定要继续保存？', { btn: ['确定', '取消'],icon: 3, title: '提示'}, function (index) {
                                    http.httpRequest({
                                        url: '/reg/client/yr/ent/subcapital/updateForm',
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
                                    layer.close(index);
                                });
                            }else if(data.status=='success'){
                                http.httpRequest({
                                    url: '/reg/client/yr/ent/subcapital/updateForm',
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
                    });

                }
            }
        ])
    }
});


