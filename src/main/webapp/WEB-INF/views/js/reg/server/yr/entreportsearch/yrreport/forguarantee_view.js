require([
        'component/iframeLayer',
        'common/util',
        'common/http',
        'handlebars',
        'component/paginationPages',
        'jquery',
        'jquery.validate',
        'common/validateRules',
        'jquery.serialize',
        'pagination',
        'common/hbsHelper'
    ],
    function(layer, util, http, handlebars,paginationPages) {
        init();
        /**
         * 初始化函数集合
         */
        function init() {

            bind();
            registerHelper();  //handlebars 格式化

            var year = parseInt(($("#_year").val()-1),10);//获取当前年份-1 判断是否等于2012
            if(!(parseInt(year)==parseInt(2012))) {  //如果当前年份的上一年不等于2012年怎进行加载数据
                int_table_last();//初始化上一年的数据
            }
            init_table_tody();//初始化表当前年份的数据


        }

        //初始化上一年的数据
        function int_table_last(){
            var options = {
                page:0,                                                              //开始页
                length:5,                                                           //长度
                items_per_page:5,                                                   //每页显示几条             默认10条
                params:$('#last_params').serializeObject(),                          //查询参数,                必填项
                url:'/reg/server/yr/forguarantee_server/list_json_last',             //url 访问路径             必填项
                type:'post',                                                         //请求方式
                pagination:'#last_pagination',                                       //分页显示的位置            必填项
                myTemplate:'#last-table-template',                                   //script:模板路径           必填项
                html:'#last_list',                                                   //需要渲染的html            必填项
                total:'#last_total',                                                  //显示页面总数的位置        必填项
                pageNmber:'#last_pageNum'                                              //显示多少页的位置         必填项
            };
            paginationPages.loadData(options,"num1");
            var year = parseInt(($("#_year").val()-1),10);
            var priPID = $("#_priPID").val();
            var msg = "last";
            _money(year,priPID,msg); //重新计算金额值

        }

        //初始化表当前年份的数据
        function init_table_tody(){
            var options = {
                page:0,                                                              //开始页
                length:5,                                                           //长度
                items_per_page:5,                                                   //每页显示几条               默认10条
                params:$('#tody_params').serializeObject(),                          //查询参数,                  必填项
                url:'/reg/server/yr/forguarantee_server/list_json_tody',             //url 访问路径               必填项
                type:'post',                                                         //请求方式
                pagination:'#tody_pagination',                                       //分页显示的位置              必填项
                myTemplate:'#tody-table-template',                                   //script:模板路径            必填项
                html:'#tody_list',                                                   //需要渲染的html             必填项
                total:'#tody_total',                                                 //显示页面总数的位置          必填项
                pageNmber:'#tody_pageNum'                                             //显示多少页的位置           必填项
            };
            paginationPages.loadData(options,"num2");
            var year = $("#_year").val();
            var priPID = $("#_priPID").val();
            var msg = "tody";
            _money(year,priPID,msg); //重新计算金额值
        };


        //设置 主债额的 合计值
        function _money(year,priPID,msg){
            http.httpRequest({
                url: '/reg/server/yr/forguarantee_server/countMoney',
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
        };


        /**
         * 数据转换文本
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
            })

            handlebars.registerHelper("textFour",function(isPubFlag){  //是否公示
                var text = "";
                if(isPubFlag=='1'){
                    text = "公示";
                }else{
                    text = "不公示";
                }
                return text;
            });
        };


        //按钮事件
        function bind() {
            util.bindEvents([
            /**点击三角形排序**/
                {
                    el: '.order_by',  // 升序降序排序方式
                    event: 'click',
                    handler: function () {
                        $(".order_by").removeClass("cur");
                        $(this).addClass('cur');//添加样式并且去掉兄弟节点样式
                        var orderStr = $(this).data("order");
                        $("#_orderStr").val(orderStr);
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

                }
            ])
        }

    });

