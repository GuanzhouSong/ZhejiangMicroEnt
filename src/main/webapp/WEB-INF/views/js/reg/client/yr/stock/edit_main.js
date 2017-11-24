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
    laydate.skin('molv');//初始化皮肤
    init();

    //********时间校验特殊处理 start *************
    $("#altDate").click(function(){
        laydate({elem: '#altDate', istime: true, format: 'YYYY-MM-DD',
            choose:function(){
                var $this = $('#altDate');var cls = 'error-tips';
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

        init_table_tody();//初始化表 当前年份*/
        formValid();
        reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
        bind();
    }


    //年报状态判断
    function reportStateFrom(){
        var _value = $("#_reportState").val();
        if(_value!='00'&&_value!=='20'&&_value!='13'){
            //$("input").attr("disabled","disabled");
            $(".subcapital-tips, .btn-add, .btn-box").hide();
        }
    }

    var _flag = false; //用于判断是新增还是修改的标记字符  true：表示新增  false:修改

    /**
     *  对外投资信息表单验证 并保存
     */
    function formValid() {
        $('#alterStockForm').validate({
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

              /*  if(el.name!='altDate'){ //时间的特殊处理
                    $(el).valid();
                }*/
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#alterStockForm input[name='+i+']'), index, parentEle, cls;
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
                inv: { //股东
                    required: true,
                    maxlength:200
                },
                beTransAmPr:{ //变更前股权比例
                    required: true,
                    percentTwo:true
                },
                altDate:{ //股权变更日期
                    required:true
                },
                afTransAmPr:{ //变更后股权比例
                    required:true,
                    percentTwo:true
                }
            },
            messages:{
                altDate:"请选择日期"
            },
            submitHandler: function () {
                /*序列化表单 并过滤不必传递的name属性值*/
                var formParam = $('#alterStockForm').serializeObject();

                $(".js-submit").attr("disabled", true);  //防止表单重复提交
                $(".js-submit").val("提交中...");
                http.httpRequest({
                    url: '/reg/client/yr/ent/alterstock/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                $("#invAltID").val('');//主键设置为空
                                $('#alterStockForm input[type="text"]').val('');
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
     * 初始化表 当前年份
     */
    function init_table_tody(){
        loadData_tody(0,5);

    };
    function loadData_tody(page, length, callback) {
        var _params = $('#tody_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/alterstock/list_json_tody',
            serializable: false,
            data: {start: page*length,length: length,params:_params},
            type: 'post',
            success: function (data) {
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
                                $("#inv").val(inv).blur(); //追加失去焦点事件
                            }
                        }
                    })
                }
            },
            {
                el: '.js-cancel',  // 表单填写中的 取消操作
                event: 'click',
                handler: function () {
                    clearform.clearTips('alterStockForm'); //清除表单验证校验
                    layer.closeAll('tips'); //关闭所有的tips层
                    $('#alterStockForm input[type="text"]').val('');
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
                    clearform.clearTips('alterStockForm'); //清除表单验证校验
                    //解决下一页的修改的问题
                    $('#alterStockForm input[type="text"]').val('');

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

                        var invAltID = batch_arr.toString();
                        var priPID = $("#_priPID").val();
                        http.httpRequest({
                            url: '/reg/client/yr/ent/alterstock/edit_show',
                            serializable: false,
                            data: {'invAltID':invAltID,'priPID':priPID},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                    //给表单设置值
                                    $("#invAltID").val(data.data.invAltID);
                                    $("#inv").val(data.data.inv);//股东
                                    $("#beTransAmPr").val(data.data.beTransAmPr);//变更前股权比例
                                    $("#altDate").val(data.data.altDate);//股权变更日期
                                    $("#afTransAmPr").val(data.data.afTransAmPr); //变更后股权比例
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
                            var invAltID = batch_arr.toString();
                            http.httpRequest({
                                url: '/reg/client/yr/ent/alterstock/batch_delete',
                                serializable: false,
                                data: {'invAltID': invAltID,'year':year},
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
                    var year = $("#_year").val();//年份
                    var priPID = $("#_priPID").val();//身份主体代码
                    http.httpRequest({
                        url: '/reg/client/yr/ent/alterstock/updateForm',
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


