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
                url:'/reg/server/rptOptoInfo/rptOptoWillExpiredlist.json',
                data:function(d){
            		d.params = $.extend({}, $("#search-form").serializeObject(), {"expiredFlag":$("#expiredFlag").val()});               		              		
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, defaultContent:'id', width: "40px",className:"center"},
                {data: 'uniCode'},
                {data: 'entName',className:"left"},
                {data: 'opFrom'},
                {data: 'leRep'},
                {data: 'tel'},
                {data: 'liaName'},
                {data: 'liaTel',className:"left"},
                {data: 'dom',className:"left"},
                {data: 'regOrgName',className:"left"},
                {data: 'localAdmName',className:"left"},
                {data: 'sliceNOName',className:"left"}
            ], 
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 if(row.uniCode == null || row.uniCode == ''){
                            		 return row.regno;
                            	 }else{
                            		 return row.uniCode;
                            	 }

                             }
                         },
                         {
                             targets: 3,
                             render: function (data, type, row, meta) {
                            	 var str;
                            	 if(data != null && data != ''){
                            		 str = data+"至";
                            	 }else{
                            		 str = "--至";
                            	 }
                            	 if(row.opTo != null && row.opTo != ''){
                            		str = str + row.opTo;
                            	 }else{
                            		 str = str+"--";
                            	 }
                            	 if((data == null || data == '')&&(row.opTo == null || row.opTo == '')){
                            		 str = "--";
                            	 }
                            	 return str;
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
