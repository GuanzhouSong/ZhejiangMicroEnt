require([
    'component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'handlebars',
    'component/clearform',
    'jquery',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'laydate',
    'pagination',
    'jquery.form',
    'component/report',
    'jquery.placeholder',
    'jquery.icinfo'
],
function(layer, dataTable, util, http, handlebars,clearform) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    init();
     //时间控件初始化
     laydate.skin('molv');//初始化皮肤 (墨绿)
     var start = {
         elem: '#pefPerForm', //选择ID为START的input
         format: 'YYYY-MM-DD', //自动生成的时间格式
         min: '1900-01-01', //设定最小日期为当前日期
         max: '2299-06-16', //最大日期
         istime: true, //必须填入时间
         istoday: false,  //是否是当天
         start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
         choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas; //将结束日的初始值设定为开始日
             var $this = $('#pefPerForm');var cls = 'error-tips';
             if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                 if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
             }
         }
     };
     var end = {
         elem: '#pefPerTo',
         format: 'YYYY-MM-DD',
         min: '1900-01-01', //设定最小日期为当前日期
         max: '2299-06-16', //最大日期
         istime: true,
         istoday: false,
         start: laydate.now(0,"YYYY-MM-DD"),
         choose: function(datas){
         start.max = datas; //结束日选好后，重置开始日的最大日期
             var $this = $('#pefPerTo');var cls = 'error-tips';
             if($this.val()){$this.removeClass(cls);var  parentEle = $this.parent();
                 if (parentEle.has('.js-error-tips').length) {parentEle.find('.js-error-tips').remove();}
             }
         }
     };

     //开始时间和结束时间
     $("#pefPerForm").click(function(){laydate(start);});
     $("#pefPerTo").click(function(){laydate(end);});
    //重置时间开始时间选择 初始化
     function  _intTime(){
        start.min= '1900-01-01';
        start.max='2299-06-16';
        end.min= '1900-01-01';
        end.max= '2299-06-16';
        end.start= laydate.now(0,"YYYY-MM-DD");
     }

    /**
     * 初始化函数集合
     */

    function init() {
        registerHelper();
        int_table_last();//初始化 上一年的数据
        init_table_tody();//初始化表 当前年份的数据
        formValid();
        bind();
        reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
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
     *  出资信息表单验证 并保存
     */
    function formValid() {
        $('#forguaranteeForm').validate({
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
               /* if(el.name!='pefPerForm'&&el.name!='pefPerTo'){ //时间的特殊处理
                    $(el).valid();
                }*/
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#forguaranteeForm input[name='+i+']'), index, parentEle, cls;
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
                more: { //债权人
                    required: true,
                    maxlength:80

                },
                priClaSecKind:{ //主债权种类
                    required: true
                },
                mortgagor:{ //债务人
                    required:true,
                    maxlength:80
                },
                guaPeriod:{ //保证的期间
                    required:true,
                },
                priClaSecAm:{ //主债权数额
                    required:true,
                    millionUnits:true,
                    maxlength:16
                },
                gaType:{ //保证的方式
                    required:true
                },
                pefPerForm:{ //履行债务的期限始
                    required:true
                },
                pefPerTo:{ //履行债务的期限止
                    required:true
                },
                gaRanges:{ //保证担保的范围
                    required:true
                },
                isPubFlag: {//是否公示
                    required:true
                }
            },
            messages:{
                //priClaSecKind:"请选择一项",
                //guaPeriod:"请选择一项",
                //gaType:"请选择一项",
                pefPerForm:"请选择时间",
                pefPerTo:"请选择时间"
                //gaRanges:"请选择一项",
                //isPubFlag:"请选择一项"
            },
            submitHandler: function () {

                /*checkbox 设置值 start*/
                var arr = [];
                $("input:checkbox[name=gaRanges]:checked").each(function(){
                    arr.push($(this).val());
                });
                $("#select_gaRange").val(arr.toString());
                /*checkbox 设置值 end*/

                /*序列化表单 并过滤不必传递的name属性值*/
                var formParam = $('#forguaranteeForm').serializeObject();
                //移出不需要提交的name值
                delete formParam.gaRanges;
                $(".js-submit").attr("disabled",true); //防止表单重复提交
                $(".js-submit").val("提交中...");
                http.httpRequest({
                    url: '/reg/client/yr/ent/forguarantee/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success'){
                            layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                _intTime();//重新初始化时间
                                $("#moreID").val("");//将索引主键设置为空
                                $("#select_gaRange").val("");
                                $('#forguaranteeForm')[0].reset();//重置为空字符串
                                $('#forguaranteeForm input[type="text"]').val('');
                                if(!_flag){ //判断当前是新增还是修改
                                    //收起
                                    var $span = $(this).find("span");
                                    $span.text($span.text() == '收起' ? '展开' : '收起');
                                    $(this).toggleClass('drop-on');
                                    $(".js-editUI").slideUp("slow");
                                }
                                init_table_tody();//重新加载列表
                                $(".js-submit").attr("disabled",false);
                                $(".js-submit").val("确定");
                            });
                        }else if(data.status=='fail'){
                            $(".js-submit").attr("disabled",false);
                            $(".js-submit").val("确定");
                            layer.msg(data.msg, {icon: 2,time: 1000});
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
            url: '/reg/client/yr/ent/forguarantee/list_json_last',
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

    //设置 主债额的 合计值
    function _money(year,priPID,msg){
        http.httpRequest({
            url: '/reg/client/yr/ent/forguarantee/countMoney',
            serializable: false,
            type: 'post',
            data:{'year':year,'priPID':priPID},
            success: function (data) {
                if(data.status=='success'){
                    var money = (data.data);
                    if(msg=='tody'){
                        $("#tody_money").text(money);
                    }else if(msg=='last'){
                        $("#last_money").text(money);
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
        var params = $('#tody_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/client/yr/ent/forguarantee/list_json_tody',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {

                //先执行计算主债权的总额
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
                    $('input[type="radio"][name="danbao"][value="1"]').prop("checked",true);
                }
            }
        });
    };


    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-cancel',  // 表单填写中的 取消操作
                event: 'click',
                handler: function () {
                    clearform.clearTips('forguaranteeForm'); //清除表单验证校验
                    layer.closeAll('tips'); //关闭所有的tips层
                    $("#moreID").val("");//将索引主键设置为空
                    $('#forguaranteeForm')[0].reset();//重置为空字符串
                    $('#forguaranteeForm input[type="text"]').val('');
                    //收起
                    var $span = $(this).find("span");
                    $span.text($span.text() == '收起' ? '展开' : '收起');
                    $(this).toggleClass('drop-on');
                    $(".js-editUI").slideUp("slow");
                }
            },
            {
                el: '.btn-delete',  // 批量删除
                event: 'click',
                handler: function () {
                    var year = $("#_year").val();
                    var batch_arr = [];
                    $("input:checkbox[name='_checkbox']:checked").each(function () {
                        batch_arr.push($(this).val());
                    });
                    if (batch_arr.length > 0) {
                        layer.confirm('您确定要删除选中的<em style="color: red;">'+batch_arr.length+'</em>条数据吗？', {icon: 2, title: '提示'}, function (index) {
                            var moreID = batch_arr.toString();
                            http.httpRequest({
                                url: '/reg/client/yr/ent/forguarantee/batch_delete',
                                serializable: false,
                                data: {'moreID':moreID,'year':year},
                                type: 'post',
                                success: function (data) {
                                    if(data.status=='success'){
                                        layer.msg("删除成功", {icon: 1,time: 1000},function(){
                                            $("#_checkAll").prop("checked",false);
                                            //重新加载列表：
                                            init_table_tody();//重新加载列表
                                        });

                                    }
                                }
                            });
                            layer.close(index);//关闭窗口
                        });
                    }else {
                        layer.msg("请您<em style='color: red;'>【选中一项】</em>进行删除操作!", {icon: 7,time: 3000});
                    }
                }
            },
            {
                el: '.btn-edit',  //修改
                event: 'click',
                handler: function () {
                    clearform.clearTips('forguaranteeForm'); //清除表单验证校验
                    //解决下一页的修改的问题
                    $('#forguaranteeForm')[0].reset();//重置为空字符串
                    $('#forguaranteeForm input[type="text"]').val('');

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

                        var moreID = batch_arr.toString();
                        var priPID = $("#_priPID").val();
                        http.httpRequest({
                            url: '/reg/client/yr/ent/forguarantee/edit_show',
                            serializable: false,
                            data: {'moreID':moreID,'priPID':priPID},
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                    /*数据回显*/
                                    //给表单设置值
                                    $("#moreID").val(data.data.moreID);// 更新主键
                                    $("#year").val(data.data.year); //年份
                                    $("#priPID").val(data.data.priPID);//身份主体priPID代码
                                    $("#more").val(data.data.more);//债权人

                                    //主债权种类
                                    var priClaSecKind = data.data.priClaSecKind;
                                    if(priClaSecKind=="1"){
                                        $('input[type="radio"][name="priClaSecKind"][value="1"]').prop("checked",true);
                                    }else{
                                        $('input[type="radio"][name="priClaSecKind"][value="2"]').prop("checked",true);
                                    }
                                    $("#mortgagor").val(data.data.mortgagor);//债务人
                                    //保证的期间
                                    var guaPeriod = data.data.guaPeriod;
                                    if(guaPeriod=="1"){
                                        $('input[type="radio"][name="guaPeriod"][value="1"]').prop("checked",true);
                                    }else{
                                        $('input[type="radio"][name="guaPeriod"][value="2"]').prop("checked",true);
                                    }
                                    var _priClaSecAm = data.data.priClaSecAm;
                                    $("#priClaSecAm").val(parseFloat((isNaN(_priClaSecAm) ? "0.0000" : _priClaSecAm) - 0).toFixed(4));//主债权数额 默认保留4有效数字！
                                    var gaType = data.data.gaType;//保证的方式
                                    if(gaType=="1"){
                                        $('input[type="radio"][name="gaType"][value="1"]').prop("checked",true);
                                    }else if(gaType=="2"){
                                        $('input[type="radio"][name="gaType"][value="2"]').prop("checked",true);
                                    }else if(gaType=="3"){
                                        $('input[type="radio"][name="gaType"][value="3"]').prop("checked",true);
                                    }
                                    $("#pefPerForm").val(data.data.pefPerForm);//履行债务的期限始
                                    $("#pefPerTo").val(data.data.pefPerTo);//履行债务的期限止
                                    //保证担保的范围 gaRange
                                    var gaRangeArray = data.data.gaRange;
                                    if(gaRangeArray){
                                        $("input:checkbox[name=gaRanges]").each(function(){
                                            if(util.in_array(gaRangeArray,$(this).val())){
                                                $(this).prop("checked",true);
                                            }
                                        });
                                    }
                                    //是否公示 isPubFlag
                                    var isPubFlag = data.data.isPubFlag;
                                    if(isPubFlag=="1"){
                                        $('input[type="radio"][name="isPubFlag"][value="1"]').prop("checked",true);
                                    }else{
                                        $('input[type="radio"][name="isPubFlag"][value="0"]').prop("checked",true);
                                    }
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
                    _intTime();//时间
                    _flag = true ; //新增的时候设置为true
                    var $span = $(this).find("span");
                    $span.text($span.text() == '收起' ? '展开' : '收起');
                    $(this).toggleClass('drop-on');
                    $(".js-editUI").slideDown("slow");
                }
            },
            {
                el: '.links-import',  // 点击批量导入 展开
                event: 'click',
                handler: function () {
                    $(".js-editUI").slideUp("slow");
                    $(this).toggleClass('drop-on');
                    $(".js-upload").slideDown("slow");
                }
            },
            {
                el: '.btnCancel',  // 点击批量导入 关闭
                event: 'click',
                handler: function () {
                    $(this).toggleClass('drop-on');
                    $(".js-upload").slideToggle("slow");
                }
            },
            {
                el: '.js-import',  // 对外担保 导入Excel
                event: 'click',
                handler: function () {
                    layer.confirm('<em style="color: red">导入信息时将同时清空之前已填录的信息，请确定是否继续导入操作!</em>', {btn: ['确定', '取消'], icon: 7, title: '温馨提示'}, function () {
                        var _file = $("#js-file").val();
                        if (!_file) {
                            layer.msg("请上传Excel模板文件!", {icon: 7, time: 3000});
                            return;
                        } else {
                            var ext = _file.toLowerCase().substr(_file.lastIndexOf(".")); //获取文件后缀
                            if (!(ext == ".xls" || ext == ".xlsx")) {   //判断是否是Excel文件
                                layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                                return;
                            }
                        }
                        $("#file_import").ajaxSubmit({
                            type: 'post',
                            url: "/reg/client/yr/ent/forguarantee/importExcel",
                            data: $("#file_import").serialize(),
                            dataType: 'json',  //不填写默认是 字符串格式
                            cache: false,
                            success: function (data) {
                                if (data.status == 'success') {
                                    layer.msg("导入成功", {icon: 1, time: 1000}, function () {
                                        init_table_tody();//重新加载列表
                                        $(this).toggleClass('drop-on');
                                        $(".js-upload").slideToggle("slow");
                                    });
                                }
                                if (data.status == 'fail') {
                                    layer.msg(data.msg, {icon: 2, time: 3000});
                                }
                            },
                            error: function (data) {
                            }
                        });

                    });

                }
            },

            {
                el: '#_checkAll',  //全选操作
                event: 'click',
                handler: function () {
                    var flag=$(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            },
            {
                el: '#save',  //保存
                event: 'click',
                handler: function () {

                   var danbao = $('input[type="radio"][name="danbao"]:checked').val();
                   if(!danbao){   //判断当前对外担保是否进行选中状态
                       layer.tips('请选择有无对外担保','input[type="radio"][name="danbao"]',{tips:3, tipsMore:true, ltype:0,time:4000});
                       return;
                   }
                   var total = $("#tody_total").text(); //获取数据总数
                   if(danbao=='1'){
                       if(!(total>0)){
                           layer.alert("请添加对外担保数据", {icon: 7, title: '提示'});return;
                       }
                   }else if(danbao=='0'){
                       if((total>0)){
                           layer.alert("您选择的是无对外担保,但是表格中存在数据,请仔细确认!", {icon: 7, title: '提示'});return;
                       }
                   }

                    var year = $("#_year").val();//年份
                    var priPID = $("#_priPID").val();//身份主体代码
                    http.httpRequest({
                        url: '/reg/client/yr/ent/forguarantee/updateForm',
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

    /**
     * 担保范围：数据格式化
     */
    function registerHelper(){
        //对外担保(格式化中文显示)
       handlebars.registerHelper("textFormat", function(value) {
            if(!value){return;} //如果没有值则 不进行转换
            var valueArrays = value.split(",");//每一行的数组值
            var text = [];//页面返回值数组
            var _obj = new Object();
            $("input:checkbox[name=gaRanges]").each(function(){
                var key = $(this).val();
                var _value = $(this).data("text");
                _obj[key] = _value;
            });
            for(var i=0;i<valueArrays.length;i++){
                text.push(_obj[valueArrays[i]]);
            }
            return text.toString();

          /* var _text = text.toString();
           var end_character = _text.charAt(_text.length - 1); //获取最后一个字符串
           if(end_character.indexOf(',')!=-1){                 //判断最后一个字符串是否是"," 如果是进行截取到最后一个分号截止
               return _text.substr(0,(_text.length-1));
           }else{
               return _text;
           }*/

        });

        handlebars.registerHelper("textOne",function(priClaSecKind){  //主债权种类
            var text = "";
            if(priClaSecKind=='1'){
                text = "合同";
            }else{
                text = "其他";
            }
            return text;
        });

        handlebars.registerHelper("textTow",function(guaPeriod){  //保证的期间
            var text = "";
            if(guaPeriod=='1'){
                text = "期间";
            }else{
                text = "未约定";
            }
            return text;
        });

        handlebars.registerHelper("textThree",function(gaType){  //保证的方式
            var text = "";
            if(gaType=='1'){
                text = "一般保证";
            }else if(gaType=='2'){
                text = "连带保证";
            }else{
                text = "未约定";
            }
            return text;
        });

        handlebars.registerHelper("textFour",function(isPubFlag){  //是否公示
            var text = "";
            if(isPubFlag=='1'){
                text = "公示";
            }else{
                text = "不公示";
            }
            return text;
        });
    }
});