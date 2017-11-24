require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, dataTable, util, http) {
	
	init();
	var $tb;
	var $searchForm=$("#searchForm");
	/**
     * 初始化函数集合
     */
    function init() {
    	bind();
    	createTb();
    }
    var params = {};//查询参数
    
    function createTb(){
    	$tb = dataTable.load({
            //需要初始化dataTable的dom元素
            el: "#con_activity_tb",
            scrollX: true,
            ajax : {
                url :  '/syn/con/csconcernactivity/list.json',
                data : function(d) {
                	d.params = params;
                }
            },
            showIndex: true,
            columns: [
              	{data: '_idx', width:"70px", className: 'center'},
                {data: null, width:"75px", className: 'center'},
                {data: 'id'},
                {data: 'theme', width:"150px"},
                {data: 'markName', width:"150px"},
                {data: 'actFormat', width:"150px"},
                {data: 'amount', width:"150px"},
                {data: 'dateBegin', width:"160px"},
                {data: 'lauDeptName', width:"130px"},
                {data: 'operDeptName', width:"130px"},
                {data: 'operName', width:"130px"}
            ],
            columnDefs: [{
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	var url="/syn/con/csconcernactivity/show?deal=0&id="+row.id;
                    	var url1="/syn/con/csconcernactivity/show?deal=1&id="+row.id;
	                	return '<a href="'+url+'">修改</a> <a href="'+url1+'">查看</a>';
                    }
                },{
                	targets: 2,
                    visible: false
                },{
                    targets: 6,
                    render: function(data, type, row, meta) {
                    	if(data==null) {
                    		data="-";
                    	}
                    	return data+" 万元";
                    }
                },{
                    targets: 7,
                    render: function (data, type, row, meta) {
                    	if(row.dateBegin != null && row.dateEnd !=null){
                    		return row.dateBegin+"至"+row.dateEnd;
                    	}else
                    		return "-"
                    }
                }]
        })
    }
    
    $("#search").click(function(){
    	params=$searchForm.serializeObject();
    	$tb.ajax.reload();
    });
    $("#rest").click(function() {
    	$searchForm[0].reset();
    	$("#lauDeptCode").val("");
    	$("#markNo").val("");
	});
    
    // 部门单选
    function selectLauDeptCode() {
        var supCode='';
        layer.dialog({
            title: '选择开展部门',
            area: ['350px', '666px'],
            content: '/common/system/sysdepart/alldeptradiotreeselect',
            callback: function(data) {
            	if(data.orgCode!=null&&data.orgName!=null){
                    $("#lauDeptName").val(data.orgName);
                    $("#lauDeptCode").val(data.orgCode);
                }
            }
        })
    }
    
    //弹出选择框
    function selectMarkDialog() {
    	layer.dialog({
    		title: '选择服务对象',
    		area: ['700px', '480px'],
    		content: '/syn/con/csconcernactivity/selectMark',
    		callback: function(data) {
    			$("#markName").val(data.markName);
    			$("#markNo").val(data.markNo);
    		}
		});
    }
    
    function bind() {
        util.bindEvents([{
            el: '#selectMark',
            event: 'click',
            handler: function() {
            	selectMarkDialog();
            }
        }, {
            el: '#add',
            event: 'click',
            handler: function() {
            	window.location.href='/syn/con/csconcernactivity/show';
            }
        }, {
            el: '#selectLauDeptCode',
            event: 'click',
            handler: function() {
            	selectLauDeptCode();
            }
        }])
    }

});