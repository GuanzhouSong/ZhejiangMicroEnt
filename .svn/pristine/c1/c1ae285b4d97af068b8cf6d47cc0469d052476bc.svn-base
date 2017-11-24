require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.validate', 'jquery.serialize'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
    	//事件绑定
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '#doViewOne',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	var frozState = $(this).attr("frozState");
            	var justiceConNO = $(this).attr("justiceConNO");
            	  var userType= $("#userType").val(); 
                  var typeUrl="";
                  if(userType=="2"){
                	  typeUrl="/syn";
                  }else{
                	  typeUrl="/reg";
                  }
            	
            	var UID = $(this).attr("UID");
            	layer.dialog({
                    area: ['60%', '80%'],
                    content: typeUrl+'/other/pubjusticeinfosearch/frozView?pripid='+priPID+'&frozState='+frozState+'&justiceConNO='+justiceConNO+'&UID='+UID,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        }
                    }
                })
            }
        },{
            el: '#doViewTwo',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	var UID = $(this).attr("UID");
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
               	  typeUrl="/syn";
                 }else{
               	  typeUrl="/reg";
                 }
            	layer.dialog({
                    area: ['60%', '80%'],
                    content: typeUrl+'/other/pubjusticeinfosearch/changeView?pripid='+priPID+'&UID='+UID,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        }
                    }
                })
            }
        }])
    }

});
