require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.validate', 'jquery.serialize'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
    	$(".commonType").hide();
    	var obj = $("#executeItemHid").val();
    	if(obj == "1" || obj == "2"){
    		$(".froType").show();
    	}else if(obj == "3"){
    		$(".thawType").show();
    	}else if(obj == "4"){
    		$(".alienType").show();
    	}

    	//事件绑定
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
            el: '#doView',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	var modUID = $(this).attr("modUID");
            	var hisNO = $(this).attr("hisNO");
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                	 typeUrl="/syn";
                 }else{
                	 typeUrl="/reg";
                 }
            	
            	
            	layer.dialog({
                    area: ['65%', '100%'],
                    content: typeUrl+'/other/pubjusticeinfo/hisView?pripid='+priPID+'&modUID='+modUID+'&hisNO='+hisNO,
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
