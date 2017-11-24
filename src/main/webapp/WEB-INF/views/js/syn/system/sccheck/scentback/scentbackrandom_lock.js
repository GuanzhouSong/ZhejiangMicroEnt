

require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
    /**
	 * 初始化函数集合
	 */
    function init() {
        bind();
    }
    var step = 1;
    var timer;
    function bind() {
        util.bindEvents([{
        	 el: '#restart',
             event: 'click',
             handler: function () {
            	layer.close({flag:true});
             }
        },{
       	 el: '#lock',
         event: 'click',
         handler: function () {
        	 var taskUid = $("#taskUid").val();
        	 var formParam = {
					taskUid:taskUid
			};
			var userType = $("#userType").val();
         	var url = '/reg/pub/server/sccheck/entback/lockEnt';
         	if(userType == '2'){
         		url = '/syn/pub/server/sccheck/entback/lockEnt';
         	}
         	layer.confirm('锁定名单后将分派检查任务到各相关检查部门，您确定要继续吗？', {icon: 2, title: '提示'}, function (index) {
				http.httpRequest({
					url: url+"?taskUid="+taskUid,
					dataType:"json",  
					serializable: true,
					type:"post",
					success: function (data) {
						layer.msg(data.msg, {time: 1000}, function () {
							if(data.status == 'success'){
								$("#restart").hide();
								$("#lock").hide();
								$("#look").removeClass("check-btn-dis");
								$("#look").addClass("check-btn");
							}
						});
					}
				});
         	});
         }
        },{
	      	 el: '#look',
	         event: 'click',
	         handler: function () {
	        	 var userType = $("#userType").val();
	          	var url = '/reg/pub/server/sccheck/entback/look';
	          	if(userType == '2'){
	          		url = '/syn/pub/server/sccheck/entback/look';
	          	}
	          	var taskUid = $("#taskUid").val();
	        	 layer.dialog({
                    title: '查看抽取结果',
                    area: ['100%', '100%'],
                    content: url+'?taskUid='+taskUid,
                    callback: function (data) {
                    	if(data.lockFlag){
                    		$("#restart").hide();
							$("#lock").hide();
                    	}
                    }
                });
	         }
        }]);
    }
});
