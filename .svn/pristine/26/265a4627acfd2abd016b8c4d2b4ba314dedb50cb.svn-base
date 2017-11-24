require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
       }
    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/common/system/codelicense/selectCodeLicenseSearchList.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'}, 
                {data: 'exaCode'}, 
                {data: 'exaName',cut: {length: 20,mark:'...'}},
                {data: 'licDept',cut: {length: 20,mark:'...'}},
                {data: 'licZone'},
                {data: 'licRea',cut: {length: 20,mark:'...'}}
                
            ],
             columnDefs : [
							
							{
								targets: 4,
							    render: function (data, type, row, meta) {
							    	 if(row.licZone=="0"){
							    		  return "国家级";
							    	  }else if(row.licZone=="1"){
							    		  return "省级";
							    	  }else if(row.licZone=="2"){
							    		  return "市级";
							    	  }else if(row.licZone=="3"){
							    		  return "县级";
							    	  }else {
							    		  return "混合";
							    	  } 
							    }
							}  
							]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([
        {
            el: '#user-table td',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
                 layer.dialog({
                    title: '查看',
                    area: ['40%', '60%'],
                    content: '/common/system/codelicense/codeLicenseViewPage?exaCode='+data.exaCode+'&viewFlag=4'+'&licType='+data.licType,
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        } 
        ])
    }

})
