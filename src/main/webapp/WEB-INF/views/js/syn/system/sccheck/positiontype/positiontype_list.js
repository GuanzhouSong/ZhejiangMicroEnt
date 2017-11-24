require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var searchParams={};
	var table;
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
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100],
            ajax: {
                url:'/syn/server/sccheck/positiontype/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx'},
                {data: null},
                {data: 'positionName',cut: {length: 20,mark:'...'}},
                {data: null,className: 'left'},
                {data: 'remark',cut: {length: 20,mark:'...'}},
                {data: 'dutyDeptName'},
                {data: 'creatTime'},
                {data: 'setUserName'}
            ],
            columnDefs : [{
				targets : 1,
				render : function(data, type, row, meta) {
					return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
				}
			},{
				targets : 3,
				render : function(data, type, row, meta) {
					if(row.isVlid =='1') {
			    		return "有效";
			    	}else if(row.isVlid =='0'){
			    		return "<span class='light'>无效</span>";
			    	}else{
			    		return "-";
			    	}
				}
			}]
        })
    }
    
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function () {
            	searchParams = $("#taskForm").serializeObject();
        		table.ajax.reload();
            }
        },{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '添加',
                    area: ['50%', '60%'],
                    content: '/syn/server/sccheck/positiontype/edit?uid=',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['50%', '60%'],
                    content: '/syn/server/sccheck/positiontype/edit?uid='+data.uid+'&viewFlag=1',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
             }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                	title: '查看',
                	area: ['50%', '60%'],
                    content: '/syn/server/sccheck/positiontype/edit?uid='+data.uid+'&viewFlag=2',
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
            }
        }])
    }

})
