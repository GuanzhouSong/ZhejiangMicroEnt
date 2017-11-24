require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        
        bind();
    }


    var table;
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#punishHisTable',
            //是否加索引值
            showIndex: true,
            ajax: {
                url: window._CONFIG.url + "/favorableaudit/modlist.json",
                data:function(d){
                    d.params = {
                    		    priPID:$("#priPID").val(),
                    		    caseNO:$("#uid").val(),
                    		    altTable:"cs_favorable_info"
                    		   };
                  }
            },
            columns: [
                {data: null,width:'10%', className: 'center'},
                {data: 'altDate',width:'20%', className: 'center'},
                {data: 'altName',width:'15%', className: 'center'},
                {data: 'auditState',width:'10%', className: 'center'},
                {data: 'auditName',width:'15%', className: 'center'},
                {data: 'auditDate',width:'20%', className: 'center'},
                {data: null,width:'10%',className: 'center'}
            ],
            columnDefs : [
							{
								targets: 6,
			                    render: function (data, type, row, meta) {
			                      return "<a class='details pointer'>详情</a>";
			                    }
			                },{
								targets: 3,
			                    render: function (data, type, row, meta) {
			                    	if(row.auditState == '1'){
	                            		return "审核通过";
	                            	}else if(row.auditState == '2'){
	                            		return "审核不通过";
	                            	}else{
	                            		return "-";
	                            	}
			                    }
			                }]
           })
     }
    
    function bind() {
        util.bindEvents([{
            el: '.details',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '详情',
                    area: ['65%', '85%'],
                    content: window._CONFIG.url + "/favorableaudit/sigInfo?hisNO="+data.hisNO,
                    callback: function (data) {
                    }
                })
            }
        }])
    }

})
