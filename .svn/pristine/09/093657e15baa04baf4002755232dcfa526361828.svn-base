require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	 init();
	    /**
	     * 初始化函数集合
	     */
	    function init() {
	        initDataTable();
	        bind();
	    }
	    
	    var foodstorageinfoTable;
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	    	foodstorageinfoTable = dataTable.load({
	            el: '#foodstorageinfo-table',
	            showIndex: true,
	            ajax: {
	                url:'/reg/server/yr/foodstorageinfo/list.json',
	                data:function(d){
	                	d.params = $("#taskForm").serializeObject();
	                }
	            },
	            columns: [
					{data: null,className: 'center'},
					{data: null},
					{data: 'year',className: 'center'},
					{data: 'leRep'},
					{data: 'tel'},
					{data: 'wareAddr'},
					{data: 'linkman'},
					{data: 'linktel'},
					{data: 'empNum'}
	            ],
	            columnDefs: [
								{
								    targets: 1,
								    render: function (data, type, row, meta) {
								    	return "<a class='view pointer'>查看</a>";
								    }
								}
	                        ]
	        });
	    }
	    
	  //按钮事件
	    function bind() {
	        util.bindEvents([{
	        	el: '.view',
	            event: 'click',
	            handler: function () {
	            	var data = foodstorageinfoTable.row($(this).closest('td')).data();
	                layer.dialog({
	                    title: '仓库信息',
	                    area: ['80%', '80%'],
	                    content: '/reg/server/yr/foodstorageinfo/show?fsInfoId='+data.fsinfoID,
	                    scrollbar: true,
	                    callback: function (data) {
	                    }
	                });
	            }
	        },{
	        	el: '#cancel',
	            event: 'click',
	            handler: function () {
	            	 layer.close();
	            }
	        }]);
	    }
});
