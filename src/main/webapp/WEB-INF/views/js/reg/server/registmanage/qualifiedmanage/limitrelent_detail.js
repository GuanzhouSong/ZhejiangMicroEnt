require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	bind();
    	initRelateDataTable();//本企业受限对象
    	initReasonDataTable();//受限对象受限原因
    	initMgrRecTable();//本企业管理记录
    }
	function initReasonDataTable() {
		dataTable.load({
		el : '#reason-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : '/reg/server/registmanage/limitObjList',
			data : function(d) {
				d.params = $("#entSearchForm").serializeObject();
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data : 'certNO', className: 'center'},
		    {data : 'limitTypeName', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'limitNO', className: 'center'},
		    {data : "limitDepartName", className: 'center'},
		    {data : 'limitReason', className: 'center'},
		    {data : "limitDateStart", className: 'center'},
		    {data : "limitDateEnd", className: 'center'},
		    {data : "auditState", className: 'center'},
		    {data : "removeAuditName", className: 'center'},
		    {data : "removeAuditDate", className: 'center'},
		    {data : "removeAuditDept", className: 'center'}
		], 
		columnDefs : [
					{
						targets : 4,
						render : function(data, type, row, meta) {
							if(row.regNO != "" && row.regNO != null){
							    return row.regNO;
							}else{
								return row.uniCode;
							}
						}
					},{
						targets : 10,
						render : function(data, type, row, meta) {
							if(row.limitDateEnd){
								 var sysdate=$("#sysdate").val();  
								 var limitDateEnd=row.limitDateEnd;  
								 if(sysdate!=""&&limitDateEnd!=""){  
									 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
									 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
									 if(d1 > d2){
										 return "已解除";
									 }else{
										 return "未解除"
									 }
								 }
							}
							return '';
						}
					}],
					"fnDrawCallback": function (oSettings) {
		    			 $("#reason").text(oSettings._iRecordsTotal);
		    		}
	  });
	}
	function initRelateDataTable() {
		dataTable.load({
			el : '#relate-table',
			showIndex: true,
			scrollX: true,
			lengthMenu: [10, 20, 30,50, 100 ],
			ajax : {
				type : "post",
				url : '/reg/server/registmanage/limitRelEntObj',
				data : function(d) {
					d.params = $("#entSearchForm").serializeObject();
				}
			},
	    columns : [
		           {data: null, className: 'center'},
		           {data: 'limitName', className: 'center'},
		           {data : 'cerType', className: 'center'},
		           {data : "cerNO", className: 'center'},
		           {data : "positionName"}
			],
		columnDefs : [
					{
						targets : 2,
						render : function(data, type, row, meta) {
							if(row.cerType == "10"){
							    return '居民身份证';
							}else{
								return '其他';
							}
						}
				  }],
				  "fnDrawCallback": function (oSettings) {
		    			 $("#relate").text(oSettings._iRecordsTotal);
		    		}
		  });
	}
	
	function initMgrRecTable() {
		dataTable.load({
			el : '#mgr-table',
			showIndex: true,
			scrollX: true,
			lengthMenu: [10, 20, 30,50, 100 ],
			ajax : {
				type : "post",
				url : '/reg/server/registmanage/limitObjManageRecordList',
				data : function(d) {
					d.params = $("#mgrForm").serializeObject();
				}
			},
	    columns : [
		           {data: '_idx', className: 'center'},
		           {data : 'item', className: 'center'},
		           {data : "limitNO", className: 'center'},
		           {data : "clientName", className: 'left'},
		           {data : "createTime", className: 'center'},
		           {data : "operator", className: 'center'},
		           {data : "department", className: 'center'}
			],
		columnDefs : [
					],
				  "fnDrawCallback": function (oSettings) {
		    			 $("#mgr").text(oSettings._iRecordsTotal);
		    		}
		  });
	}
	
	 function bind() {
	        util.bindEvents([{
	        	el: '.js-fold',
	            event: 'click',
	            handler: function () { 
	            	var isHideOrShow = $("#hideorshow").is(":hidden");
	            	if(isHideOrShow){
	            		 $(this).html("收起详情<i></i>");
	            		 $("#hideorshow").css("display","block");
					}else{
						$(this).html("展开详情<i></i>");
	            		$("#hideorshow").css("display","none");
					}
	            }
	        }]);
	    }
});
