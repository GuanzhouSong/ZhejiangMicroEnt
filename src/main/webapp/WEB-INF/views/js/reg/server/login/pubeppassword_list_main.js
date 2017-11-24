require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, dataTable, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    var searchParams={};//查询参数声明!
    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#permit-table',
            showIndex: true,
            scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/login/phoneapply/list.json',
                data:function(d){
                    d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx', 'className': 'center',width:'50px'},
                {data: null, 'className': 'center',width:'70px'},
                {data: 'pasid',width:'120px'},
                {data: 'regno',width:'120px'},
                {data: 'entname',width:'120px',cut: {length: 20,mark:'...'}},
                {data: 'lerep',width:'80px'},
                {data: 'liaidnum',width:'120px'},
                {data: 'lianame',width:'80px'},
                {data: 'regOrgName',width:'100px',cut: {length: 15,mark:'...'}},
                {data: 'localAdmName',width:'100px',cut: {length: 15,mark:'...'}}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	return "<a class='accept'>接收</a>";
                    }
                }
            ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	if($("#pasidval").val() == ''){
    		alert("请先输入流水号！");
    	}else{
    		if(table ==null){
        		initDataTable();
        	}else{
        		table.ajax.reload();
        	}
    	}
    }); 
    
    //按钮事件
    function bind() {
        util.bindEvents([{
            el: '.accept',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '联络员备案表接收',
                    area: ['95%', '95%'],
                    content: '/reg/server/login/phoneapply/option?pasid='+data.pasid+'&pripid='+data.pripid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload == true) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }])
    }



});
