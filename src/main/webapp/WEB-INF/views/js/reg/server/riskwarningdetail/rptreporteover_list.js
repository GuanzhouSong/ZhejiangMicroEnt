require(['component/iframeLayer', 'layer1','component/dataTable', 'common/util', 'common/http','handlebars', 'jquery','jquery.serialize','laydate'], function (layer,layer1, dataTable, util, http, handlebars) {
    var table;
    var searchFlag = 0 ;
    init();
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
    }

    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = 1;
    	table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
			scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/rptOptoInfo/rptReporteoverlist.json',
                data:function(d){
            		d.params = $("#search-form").serializeObject();               		              		
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, defaultContent:'id', width: "40px",className:"center"},
                {data: 'year'},
                {data: 'reportState'},
                {data: 'entTypeCatg'},
                {data: 'uniscid'},
                {data: 'entName',className:"left"},
                {data: 'leRep'},
                {data: 'tel'},
                {data: 'liaName'},
                {data: 'liaTel',className:"left"},
                {data: 'dom',className:"left"},
                {data: 'regOrgName',className:"left"}
            ], 
            columnDefs: [
						{
						    targets: 2,
						    render: function (data, type, row, meta) {
						   	 if(row.reportState == null || row.reportState == '' || row.reportState == '00'){
						   		 return '未公示';
						   	 }else{
						   		 return '';
						   	 }
						
						    }
						},
						{
						    targets: 3,
						    render: function (data, type, row, meta) {
						   	 if(row.entTypeCatg == null || row.entTypeCatg == ''){
						   		 return '';
						   	 }else if(row.entTypeCatg == '50'){
						   		 return '个体户';
						   	 }else if(row.entTypeCatg == '16' || row.entTypeCatg == '17'){
						   		 return '农专社';
						   	 }else{
						   		return '企业';
						   	 }
						    }
						},
                         {
                             targets: 4,
                             render: function (data, type, row, meta) {
                            	 if(row.uniscid == null || row.uniscid == ''){
                            		 return row.regNO;
                            	 }else{
                            		 return row.uniscid;
                            	 }

                             }
                         }
                     ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#searchBtn").click(function(){
    	if(searchFlag==0){
            initDataTable();
    	}else{
            table.ajax.reload();
    	}
    }); 


})
