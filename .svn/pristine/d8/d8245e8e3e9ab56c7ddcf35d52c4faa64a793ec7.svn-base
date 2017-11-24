require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	bind();
    	initReasonDataTable();//受限原因列表
    	initRelateDataTable();//关联企业列表
    	initMgrRecTable();//管理记录列表
    }
	function initReasonDataTable() {
		dataTable.load({
		el : '#reason-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : '/reg/server/registmanage/limitObjDetailList',
			data : function(d) {
				d.params = $("#entSearchForm").serializeObject();
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data: null, className: 'center'},
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
		columnDefs : [{
		     	targets: 1,
				    render: function (data, type, row, meta) {
				    	return '<input type="radio" auditState='+row.auditState+' limitTypeName='+row.limitTypeName+' can='+row.limitDateEnd+' name="_radio"  value='+row.uid+'>';
				    }
		        },
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
							if(row.auditState=='1'){
								return "已解除";
							}
							if(row.limitDateEnd){
								 var sysdate=$("#sysdate").val();  
								 var limitDateEnd=row.limitDateEnd;  
								 if(sysdate!=""&&limitDateEnd!=""){  
									 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
									 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
									 if(d1 > d2&&limitDateEnd!=""){
										 return "已解除";
									 }else{
										 return "未解除"
									 }
								 }
							}
							return '未解除';
						}
					},{
						targets : 11,
						render : function(data, type, row, meta) {
							return "";
						}
					},{
						targets : 12,
						render : function(data, type, row, meta) {
							return "";
						}
					},{
						targets : 13,
						render : function(data, type, row, meta) {
							return "";
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
				url : '/reg/server/registmanage/limitObjRelEnt',
				data : function(d) {
					d.params = $("#entSearchForm").serializeObject();
				}
			},
	    columns : [
		           {data: '_idx', className: 'center'},
		           {data : null, className: 'center'},
		           {data : "entName", className: 'center'},
		           {data : "leRep", className: 'left'},
		           {data : "estDate", className: 'center'},
		           {data : "positionName", className: 'center'},
		           {data : "regOrgName", className: 'center'},
		           {data : "localAdmName", className: 'center'},
		           {data : "regState", className: 'center'}
			],
		columnDefs : [
					{
						targets : 1,
						render : function(data, type, row, meta) {
							if(row.regNO != "" && row.regNO != null){
							    return row.regNO;
							}else{
								return row.uniCode;
							}
						}
				  },{
						targets : 2,
						render : function(data, type, row, meta) {
							return "<a href='javascript:void(0)' class='mr10 look' priPID='"+row.priPIDDesc+"'>"+ row.entName+"</a>";
						}
				  },{
					targets : 8,
					render : function(data, type, row, meta) {
						var regState = row.regState;
 						if(regState=="K"||regState=="B"||regState=="A"||regState=="DA"||regState=="X"){
 							return "存续";
 						}else if(regState=="C"){
 							return "撤销";
 						}else if(regState=="D"){
 							return "吊销";
 						}else if(regState=="Q"){
 							return "迁出";
 						}else if(regState=="XX"||regState=="DX"){
 							return "注销";
 						}else{
 							return "-";
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
                el: '#js-liq',
                event: 'click',
                handler: function () {
                	var limitObj = document.getElementsByName("_radio")[0];
                	if(limitObj!=undefined){
                		var limitType = document.getElementsByName("_radio")[0].getAttribute('limitTypeName');
                	}
                	var radioObj= $(":radio[name=_radio]:checked");
                	if(radioObj==null||radioObj.length==0){
                		 layer.msg("请选择失信受限企业的限制对象再操作", {ltype: 0,time:2000});
                	}else if(limitType&&limitType!="吊销企业"){
                		layer.msg("请选择原因类别为吊销企业再操作", {ltype: 0,time:2000});
                	}else{
                		layer.dialog({
                            title: '打印清算通知书',
                            area: ['800px', '600px'],
                            content: '/reg/server/registmanage/printLiq?uid='+$(radioObj).val(),
                            callback: function (data) { 
                            }
                        })
                	}
                }
            },{
                el: '#js-can',
                event: 'click',
                handler: function () {
                	var limitObj = document.getElementsByName("_radio")[0];
                	var limitDateEnd;
                	var auditState;
                	if(limitObj!=undefined){
                		limitDateEnd = document.getElementsByName("_radio")[0].getAttribute('can');
                		auditState = document.getElementsByName("_radio")[0].getAttribute('auditState');
                	}
                	var sysdate=$("#sysdate").val();  
                	var can;
                	if(auditState&&auditState=='1'){
                		can="已解除";
                	}else{
                		if(sysdate!=""&&limitDateEnd!=""&&limitDateEnd){  
                			var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
                			var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
                			if(d1 > d2){
                				can = "已解除";
                			}else{
                				can = "未解除";
                			}
                		}else{
                			can = "未解除";
                		}
                	}
                	var radioObj= $(":radio[name=_radio]:checked");
                	if(radioObj==null||radioObj.length==0||limitObj==undefined){
                		 layer.msg("请选择失信受限企业的限制对象再操作", {ltype: 0,time:2000});
                	}else if(can=="未解除"){
                		layer.msg("请选择限制解除状态为已解除再操作", {ltype: 0,time:2000});
                	}else{
                		layer.dialog({
                            title: '打印解除证明',
                            area: ['800px', '600px'],
                            content: '/reg/server/registmanage/printCan?uid='+$(radioObj).val(),
                            callback: function (data) { 
                            }
                        })
                	}
                }
            },{
	            el: '.look',
	            event: 'click',
	            handler: function () {
	            	var priPID = $(this).attr("priPID");
	            	if(priPID!=null && priPID != ''){
	            		window.open('/syn/panoramasearch/doEnAppSearchDetails/' + priPID,'_blank');
	            	}
	            }
	        }]);
	    }
});
