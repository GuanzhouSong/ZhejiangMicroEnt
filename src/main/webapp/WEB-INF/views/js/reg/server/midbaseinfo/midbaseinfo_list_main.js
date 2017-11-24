require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var regStateList = [];
	var searchFlag="0";
	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
       // initDataTable();
       // bind();
    	getRegStateList();
      }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regStateM').hide();
    	$('#regStateM option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	 searchFlag="1";
     	 var url=_sysUrl+'/midbaseinfo/midbaseinfoListJSON.json';
         table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:url,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'priPID',cut: {length: 20,mark:'...'}},
                {data: 'uniCode',cut: {length: 20,mark:'...'}},
                {data: 'regNO',cut: {length: 20,mark:'...'}},
                {data: 'entName'},
                {data: 'regState',cut: {length: 20,mark:'...'}},
                {data: 'estDate',cut: {length: 20,mark:'...'}},
                {data: 'leRep',cut: {length: 20,mark:'...'}},
                {data: 'cerNO',cut: {length: 30,mark:'...'}},
                {data: 'hzApprCode',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',cut: {length: 20,mark:'...'}},
                {data: 'localAdmName',cut: {length: 20,mark:'...'}}, 
                {data: 'sliceNOName',cut: {length: 20,mark:'...'}}, 
                {data: 'checkDepName',cut: {length: 20,mark:'...'}},
                {data: 'updateTime',cut: {length: 20,mark:'...'}}
            ],
             columnDefs : [ 
							{
								targets: 5,
							    render: function (data, type, row, meta) {
							    	 
							    	 if(data=="K"||data=="A"||data=="B"||data=="DA"||data=="X"){
							    		 return "存续";
							    	 }else if(data=="XX"||data=="DX"){
							    		 return "注销";
							    	 } else if(data=="C"){
							    		 return "撤销";
							    	 } else if(data=="Q"){
							    		 return "迁出";
							    	 } else if(data=="D"){
							    		 return "吊销";
							    	 } 
							    }
							}
							]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	var uniCode_regNO=$("#uniCode_regNO").val();
    	var entname=$("#entname").val();
    	if(uniCode_regNO==""&&entname==""){
    		layer.msg("请输入查询条件", {ltype: 0,time:2000});
            return false;
    	} 
    	searchParams = $("#taskForm").serializeObject(); 
      	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([
       
        ])
    }

})
