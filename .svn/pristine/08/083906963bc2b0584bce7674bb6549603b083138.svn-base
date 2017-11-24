require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {
    
	var table;
    var params = {};//查询参数声明!
	
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
    	var userType = $("#userType").val();
    	var url = "";
    	if(userType=="1"){
    		url = "/reg/server/sysuser/listdeptuser.json";
    	}else{
    		url = "/syn/system/sysuser/listdeptuser.json";
    	}
        table = dataTable.load({
            el: '#user-table',
            ajax : {
                type : "get",
                url :  url,
                data : function(d) {
                    d.params = $("#entSearchForm").serializeObject();
                }
            },
            columns: [
                {data: 'username', width: '100px'},
                {data: 'realName'},
                {data: 'dept'},
                {data: 'email'},
                {data: 'status'},
                {data: 'createTime', width: '150px'},
                {data: 'lastLoginTime', width: '150px'},
                {data: null, width: '120px', className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 4,
                    render: function (data, type, row, meta) {
                        if(row.status=='1')return "有效";
                        if(row.status=='0')return "无效";
                        return "未知状态";
                    }
                },
                {
                    targets: 7,
                    render: function (data, type, row, meta) {
                        return "<a href = 'javascript:void(0);' class='js-choosed'>选择</a> ";
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#search',
                event: 'click',
                handler: function () {
                    params = $("#entSearchForm").serializeObject();
                    table.ajax.reload();
                }
          },{
            el: '.js-choosed',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.close({reload:true,userid:data.id,username:data.username});
            }
        }])
    }

})
