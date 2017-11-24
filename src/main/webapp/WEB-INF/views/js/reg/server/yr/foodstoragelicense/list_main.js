require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	 init();
	    /**
	     * 初始化函数集合
	     */
	    function init() {
	        initDataTable();
	        bind();
	    }
	    
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	        dataTable.load({
	            el: '#foodstoragelicense-table',
	            showIndex: true,
	            ajax: {
	                url:'/reg/server/yr/foodstoragelicense/list.json',
	                data:function(d){
	                	d.params = $("#taskForm").serializeObject();
	                }
	            },
	            columns: [
					{data: null,width:'10%',className: 'center'},
					{data: 'year',width:'10%',className: 'center'},
					{data: 'licNO',width:'10%'},
					{data: 'licValFrom',width:'10%'},
					{data: 'licValTo',width:'10%'},
					{data: 'licAnth',width:'10%'},
					{data: 'licScope',width:'40%'}
	            ],
	            columnDefs: []
	        });
	    }
	    
	  //按钮事件
	    function bind() {
	        util.bindEvents([
	        {
	        	el: '#cancel',
	            event: 'click',
	            handler: function () {
	            	 layer.close();
	            }
	        }]);
	    }
});
