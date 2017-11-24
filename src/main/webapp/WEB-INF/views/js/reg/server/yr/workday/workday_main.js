require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, util, http) {
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }


    /**
     * 初始化dataTable
     */

    function bind() {
    	util.bindEvents([{
        	el: '.btn',
            event: 'click',
            handler: function () {
            	var arr = new Array();
            	//新增节假日
            	$.each($("._addClass"),function(k,v){
            		var calendar = v.id;
            		var isHoliday = v.value;
            		arr.push({calendar:calendar,isHoliday:isHoliday});
            	})
            	//取消节假日
            	$.each($("._cancelClass"),function(k,v){
            		var calendar = v.id;
            		var isHoliday = v.value;
            		arr.push({calendar:calendar,isHoliday:isHoliday});
            	})
            	 http.httpRequest({
                     url: '/admin/system/workday/commit',
                     serializable: true,
                     data: arr,
                     type: 'post',
                     success: function (data) {
                         layer.msg(data.msg, {time: 1000}, function () {
                             layer.close({reload: true});
                         });
                     }
                })
            }
        }])
    }

})
