require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {
	  init();
	    /**
	     * 初始化函数集合
	     */
	    function init() {
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
	            el: '#proAmountId',
	            event: 'click',
	            handler: function () {
	            	var year = $("#year").val();
	            	layer.dialog({
	                    title: '食品生成许可证列表',
	                    area: ['80%', '60%'],
	                    content: '/reg/server/yr/foodstoragelicense/list?priPID='+encodeURIComponent($("#priPID").val())+"&licType=1"+"&year="+year,
	                    scrollbar: true,
	                    callback: function (data) {
	                    	if(data.reload == true){
	                    		table.ajax.reload();
	                    	}
	                    }
	                })
	            }
	        },{
	            el: '#disAmountId',
	            event: 'click',
	            handler: function () {
	            	var year = $("#year").val();
	            	layer.dialog({
	                    title: '食品流通(经营)许可证列表',
	                    area: ['80%', '60%'],
	                    content: '/reg/server/yr/foodstoragelicense/list?priPID='+encodeURIComponent($("#priPID").val())+"&licType=2"+"&year="+year,
	                    scrollbar: true,
	                    callback: function (data) {
	                    	if(data.reload == true){
	                    		table.ajax.reload();
	                    	}
	                    }
	                })
	            }
	        },{
	            el: '#wareAmountId',
	            event: 'click',
	            handler: function () {
	            	var year = $("#year").val();
	            	layer.dialog({
	                    title: '仓库列表',
	                    area: ['80%', '60%'],
	                    content: '/reg/server/yr/foodstorageinfo/list?priPID='+encodeURIComponent($("#priPID").val())+"&year="+year,
	                    scrollbar: true,
	                    callback: function (data) {
	                    	if(data.reload == true){
	                    		table.ajax.reload();
	                    	}
	                    }
	                })
	            }
	        }]);
	    }
});
