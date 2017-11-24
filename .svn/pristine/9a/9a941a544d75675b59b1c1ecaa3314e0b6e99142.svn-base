require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'jquery','laydate','jquery.serialize','common/validateRules'], function (layer, dataTable, util, http){

	var editor1;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    
	 function docheck(){
		 if ($.trim($("#entName").val()) == "") {
             layer.alert("源数据的企业名称不能为空！");
             $("#title").focus();
             return false;
         } 
         var formParam = $('#form').serializeObject();
		   http.httpRequest({
               url: '/sment/smEntAbovescale/smEntAbovescaleditCommit',
               type: 'post',
               data: formParam,
               success: function (data) {
               	 layer.msg(data.msg, {time: 1000}, function () {
                     layer.close({reload: true});
                    });
               }
           });
	 }
	
    
    function bind() {
    	  util.bindEvents([{
              el: '#submit',
              event: 'click',
              handler: function() {
            	  docheck();
              }
          },
          {
               el: '#cancel',
               event: 'click',
               handler: function () {
                 layer.close();
            }
          }
    	  ]);
    }
});
