require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
    }
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/smstaskinfo/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: 'regNO'},
                      {data: 'entName',width:'200px',className: 'left'},
                      {data: 'estDate',width:'80px'},
                      {data: null,width:'40px'},
                      {data: 'sendObjType',width:'80px'},
                      {data: 'sendObjName',width:'80px'},
                      {data: 'sendObjTel',width:'80px'},
                      {data: "sendTime",width:'80px'},
                      {data: "sendStatus",width:'80px'},
                      {data: 'regOrgName',width:'100px'},
                      {data: 'localAdmName',width:'100px'}
            ],
            columnDefs: [
 				{
 					targets:1,
 					render:function(data,type,row,meta){
 						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
 				 },{
 					targets:4,
 					render:function(data,type,row,meta){
 						if(row.entTypeCatg=="50"){
 							return "个体户";
 						}else if(row.entTypeCatg=="16"||row.entTypeCatg=="17"){
 							return "农专社";
 						}else{
 							return "企业";
 						}
 					}
 				 },{
 					targets:9,
 					render:function(data,type,row,meta){
 						if(row.sendStatus=="0"){
 							return "发送失败";
 						}else if(row.sendStatus=="1"){
 							return "发送成功";
 						}else{
 							return "未发送";
 						}
 					}
 				 }
             ],
            "fnDrawCallback": function (oSettings) {
            	http.httpRequest({ 
                    url: '/reg/server/smstaskinfo/searchCount',
                    serializable: false,
                    type:'post',
                    data: {params:searchParams} ,
                    success: function (data) {
                    	var list = data.data;
                        if (data.status == 'success') {  
    						$("#sendEntSuccess").text(list[0]);
    						$("#sendTelSuccess").text(list[1]);
    						$("#sendLerepTelSuccess").text(list[2]);
    						$("#sendLiaTelSuccess").text(list[3]);
                        }else{
                        	$("#sendEntSuccess").text("0");
    						$("#sendTelSuccess").text("0");
    						$("#sendLerepTelSuccess").text("0");
    						$("#sendLiaTelSuccess").text("0");
                        } 
                    }
                });
            }
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
		table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([
        ])
    }
})
