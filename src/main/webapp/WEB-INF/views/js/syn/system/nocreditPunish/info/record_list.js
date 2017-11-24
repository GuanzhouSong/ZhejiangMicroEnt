require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {
	
	var urlHead=window._CONFIG.urlHead;
	var list_tb;
	var punType=$("#type").val();
	var key=$("#key").val();
	init();
	/**
     * 初始化函数集合
     */
    function init() {
        //bind();
        createList();
    }
	
	//惩戒单列表
    function createList(){ 
    	
    	searchParams = $("#taskForm").serializeObject();
    	list_tb = dataTable.load({
            //需要初始化dataTable的dom元素
            el: "#record_table",
            scrollX: true,
            ajax : {
                url : urlHead+'/noCreditPunish/info/recordlist.json',
                data:function(d){
                    d.params = searchParams;
                 }
            },
            showIndex: true,
            columns: [
				{data: '_idx', width:"80px", className: 'center'},
				{data: 'legNo', width:"80px", className: 'center'},
				{data: 'legDate', width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'punField', width:"120px",cut: {length: 20,mark:'...'}},
				{data: 'punCause', width:"90px", className: 'center',cut: {length: 20,mark:'...'}},
				{data: 'punMea', width:"140px",cut: {length: 20,mark:'...'}},
				{data: 'exeBegin', width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'punExeDept', width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'punReqDept', width:"150px",cut: {length: 20,mark:'...'}},
				{data: 'punReqUser', width:"130px",cut: {length: 20,mark:'...'}},
				{data: 'createTime', width:"150px", className: 'center',cut: {length: 20,mark:'...'}},
				{data: 'auditor', width:"130px",cut: {length: 20,mark:'...'}},
				{data: 'auditTime', width:"150px",cut: {length: 20,mark:'...'}} 
            ],
            columnDefs: [{
	                targets: 6,
	                render: function (data, type, row, meta) {
	                	if(row.isLife != null && row.isLife !=""&&row.isLife=="1"){
                    		return "终身有效";
                    	}else  if(row.exeBegin != null && row.exeEnd!=null){
                    		return row.exeBegin+"至"+row.exeEnd;
                    	}else{
                    		return "-"
                    	}	
	                }
	            }
            ]
        })
    }
    
    function bind() {
        util.bindEvents([{
        	el: '#cancel',
            event: 'click',
            handler: function() {
            	window.location.href=urlHead+'/noCreditPunish/info/goToRecordInfo?type='+punType+'&key='+key;
            }
        }]);
    }
    
});