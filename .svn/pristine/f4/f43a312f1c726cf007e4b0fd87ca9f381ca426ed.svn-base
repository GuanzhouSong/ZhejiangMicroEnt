require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {

        $.ajax({
            type:"post",
            url:"/reg/client/im/ent/investment/list.json",
            data:{params:$("#key_parmas").serializeObject()},
            success:function(msg){
                var myTemplate = handlebars.compile($("#inv-template").html());

                var investmetnList=msg.data;
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });
                
                handlebars.registerHelper("transFlag",function(value){
                	if(value=="1"){
                		return "已公示";
                	}else{
                		return "未公示";
                	}
                });
                
                var content = myTemplate(investmetnList);
                $(".print2").html(content);
            }
        })
    }
})
