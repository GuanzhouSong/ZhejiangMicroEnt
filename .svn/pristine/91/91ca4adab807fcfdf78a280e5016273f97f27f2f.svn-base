require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    //按钮事件
    function bind() {
        util.bindEvents([
         {//弹出框取消按钮
             el: '#confirmCancel',
             event: 'click',
             handler: function () {
            	 layer.close();
             }
         },
         {
        	//提交
            el: '#commit',
            event: 'click',
            handler: function () {
            	$("#commit").attr("disabled","disabled");
            	var params = $('#_params').serializeObject();//查询参数
//            	var _index;
            	http.httpRequest({
                    url: '/reg/server/yr/pbaddrec/addrec',
                    data: {year: params['year'], priPID: params['priPID']},
                    type: "post",
    		        beforeSend:function(){ //发送前执
                        layer.msg('补录提交时数据处理可能比较慢,请您耐心等待,请勿关闭浏览器!', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                    },
                    success: function (data) {
                        if (data.status == 'success') {
                        	layer.msg(data.msg, {icon: 6,time: 2000}, function () {
                            	layer.close({reload: true});                  		
                            });
                        }else {
                        	layer.msg(data.msg, {icon: 5,time: 2000}, function () {
                                return;
                            });
                        }
                    }
                });
            }
	    }
      ])
    }
});
