require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', , 'jquery', 'handlebars', 'jquery.placeholder', 'jquery.icinfo'],
    function (layer, dataTable, util, http, handlebars) {
        init();
        /**
         * 初始化函数集合
         */
        function init() {
            bind();
        }

        function bind() {
            util.bindEvents([
                {
                    el: '#save',
                    event: 'click',
                    handler: function () {
                        var data=new Object();
                        var $this = $("input:radio[name=midInvIds]:checked");
                        if(!$this.val()){
                            $("#msg-info").html("请选择一项!");
                            return;
                        }
                        var regNo;
                        var inv =     $this.data("inv");             //股东名或发起人名
                        var invType = $this.data("invtype");  //投资人类型  1：企业名称 2：自然人姓名
                        var bLicNO =  $this.data("blicno");    //证照编号 ---> 企业名称
                        var cerNO =   $this.data("cerno");        //证件号码 ---> 自然人
                        if(invType){
                            regNo = invType=='1'?bLicNO:cerNO;
                        }
                        data.inv=inv;
                        data.invTypd = invType;
                        data.regNo = regNo;
                        layer.close(data);
                    }
                },
                {
                    el: 'input:radio[name=midInvIds]',  //点击选项 去掉错误提示
                    event: 'click',
                    handler: function () {
                       if($(this).val()){
                           $("#msg-info").html("");
                       }
                    }
                },
                {
                    el: '#input_search',  //检索
                    event: 'click',
                    handler: function () {
                      var inputValue = $.trim($("#input_text").val());  //输入框中的文字
                        if(inputValue){
                            $(".textContent").parent().show();
                            $(".textContent").show();
                            $(".textContent").next("span").show().css("color","");
                            //显示或隐藏
                            $("#radioContent").find(".textContent").each(function(){
                                var currentValue = $(this).next("span").html();
                                if(currentValue.indexOf(inputValue)!=-1){
                                    if(inputValue==currentValue){
                                        $(this).next("span").css("color","red");
                                    }
                                    $(this).parent().show();
                                    $(this).show();
                                }else{
                                    $(this).next("span").hide();
                                    $(this).hide();
                                    $(this).parent().hide();
                                }
                            })

                         /* 高亮显示
                          $("#radioContent").find(".textContent").each(function(){

                                var em = $(this).next("span").find(".red-show");
                                if(em){
                                    $(this).next("span").find(".red-show").remove();
                                    $(this).next("span").html($(this).data("inv"));
                                }
                                var currentValue = $(this).next("span").html();
                                var _html = currentValue.split(inputValue);
                                _html = _html.join('<em style="color:#FF0000;" class="red-show">'+inputValue+'</em> ');
                                $(this).next("span").html(_html);
                            });*/

                        }else{
                            $(".textContent").parent().show();
                            $(".textContent").show();
                            $(".textContent").next("span").show().css("color","");
                        }
                    }
                },

                {
                    el: '#cancel',
                    event: 'click',
                    handler: function () {
                        var data=new Object();
                        data.cancel="true";
                        layer.close(data);
                    }
                }
            ])
        }

    });