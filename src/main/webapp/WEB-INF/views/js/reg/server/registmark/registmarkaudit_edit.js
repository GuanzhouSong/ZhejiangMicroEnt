require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams;//查询参数声明!
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
        initData();
    }
    
    
    function initData(){
    	var _IDType=window._CONFIG._IDType;
    	if("1"==_IDType){
    		$("#IDTypeTem").val("大类(执法领域)");
    	}else if("2"==_IDType){
    		$("#IDTypeTem").val("中类(行业)");
    	}else if("3"==_IDType){
    		$("#IDTypeTem").val("小类(许可监管项目)");
    	}
    }
   

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
                url:'/reg/server/registmark/selectRegistMarkAuditHisJSON',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx"},
                      {data: 'idcode',cut: {length: 20,mark:'...'},width:'150px'},
                      {data: 'idname',cut: {length: 20,mark:'...'},width:'150px'},
                      {data: 'idtype',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'iddesc',cut: {length: 20,mark:'...'},width:'40px'},
                      {data: 'setName',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'setTime',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'setDeptname',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'auditorName',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'auditTime',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'auditDeptName',cut: {length: 20,mark:'...'},width:'80px'},
                      {data: "auditState",cut: {length: 20,mark:'...'},width:'80px'},
                      {data: "auditorDesc",cut: {length: 20,mark:'...'},width:'80px'},
                      {data: 'applicationScopeName',cut: {length: 20,mark:'...'},width:'100px'},
                      {data: 'auditTime',cut: {length: 20,mark:'...'},width:'100px'}
            ],
            columnDefs: [
 				{
 					targets:3,
 					render:function(data,type,row,meta){
 						if(row.idtype=='1'){
 							return '大类';
 						}else if(row.idtype=='2'){
 							return '中类';
 						}else if(row.idtype=='3'){
 							return '小类';
 						}else{
 							return '';
 						}
 					}
 				 },
	 			 {
	                     targets: 11,
	                     render: function (data, type, row, meta) { 
	                    	  //未审核
	                    	  if("1"==data){ 
	                    		  return  "待审核"; 
	                        }else if("2"==data){
	                      	  return  "审核通过"; 
	                        }else if("3"==data){
	                      	  return "审核不通过";
	                        }else {
	                      	  return "";
	                        }
	                     }
	                 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
		table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([
                         {
                             el: '#cancel',
                             event: 'click',
                             handler: function () {
                                 layer.close();
                             }
                         },
                         {
                             el: '#save',
                             event: 'click',
                             handler: function () {
                            	var auditStateTemArr=$('input[name="auditStateTem"]:checked');
                      			if(auditStateTemArr.length==0){
                      				    layer.msg("请选择审核结果", {ltype: 0,time:2000});
                            		    return false;
                      			}
                      			
                      			var auditorDescTem = $.trim($("#auditorDescTem").val());
                      			if(auditorDescTem==null||auditorDescTem==""){
                      				layer.msg("请输入审核意见", {ltype: 0,time:2000});
                        		    return false;
                      			}
                      			if(auditorDescTem.length>300){
                      				layer.msg("最多只能输入300个字符", {ltype: 0,time:2000});
                        		    return false;
                      			}
                      			$("#auditorDesc").val(auditorDescTem);
                      			$("#auditState").val(auditStateTemArr[0].value);
                            	 var formParam=$('#taskForm').serializeObject();
                            	 
                            	 http.httpRequest({
                                     url: '/reg/server/registmark/commitRegistMarkAudit',
                                     serializable: true,
                                     data:formParam,
                                     type: 'post',
                                     success: function (data) { 
                                    	 if(data.status == 'success'){
                                    		 layer.msg("保存成功", {time: 2000}, function () {
                  								layer.close({reload: true});
                                     		 });  
                                  	      }else{
                                  	    	 layer.msg("保存失败", {ltype: 0,time:2000});
                                  	      }
                                     }
                                 });
                             }
                         },{
                             el: 'input[name="auditStateTem"]',
                             event: 'click',
                             handler: function () {
                                 var thisVal = $(this).val();
                                 if("2" == thisVal){
                                	 $("#auditorDescTem").val("同意");
                                 }else{
                                	 $("#auditorDescTem").val("");
                                 }
                             }
                         }
        ])
    }
})
