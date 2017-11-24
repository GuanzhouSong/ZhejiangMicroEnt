require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery', 'jquery.serialize', 'laydate', 'tab'], function (layer,dataTable, util, http) {
	
	var params = {};//查询参数
	var table;
	
	 init();
	 
	 function init(){
		 bind();
		 initDataTable();
	 }
	 
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	    	params = $("#searchForm").serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                url :  '/reg/server/seriouspunish/doGetExpSecApplyAuditList',
	                data : function(d){
                		d.params = params;
	                }
	            },
	            columns: [
	                {data: '_idx', className: 'center', width:"50px"},
	                {data: null, className: 'center', width:"80px"},
	                {data: 'uniSCID', className: 'center'},
	                {data: 'entName', className: 'center'},
	                {data: 'leRep', className: 'center'},
	                {data: 'businessTypeDesc', className: 'center'},
	                {data: 'businessStatus', className: 'center'},
	                {data: 'secDishonestyType', className: 'center'},
	                {data: 'addSecTerm', className: 'center'},
	                {data: 'addSecCause', className: 'center'}
	            ],
	            columnDefs: [{
				      targets: 1,
				      render: function(data, type, row, meta) {
				    	  if(row.businessStatus=='3'){
				    		  return '<a class="audit" href="javascript:void(0)">审核</a>';
				    	  }else{
				    		  return '<a class="view" href="javascript:void(0)">详情</a>';
				    	  }
                      }
				 },{
				      targets: 2,
				      render: function(data, type, row, meta) {
				    	  if(row.uniSCID != null && row.uniSCID != ""){
				    		  return row.uniSCID;
				    	  }
				    	  if(row.regNO !=null|| row.regNO!=""){
				    		  return row.regNO;
				    	  }
				    	  return "";
                      }
				 },{
				      targets: 6,
				      render: function(data, type, row, meta) {
				    	  if(data=="3"){
				    		  return "待审核";
				    	  }else if(data=="4"){
				    		  return "审核通过";
				    	  }else if(data=="5"){
				    		  return "审核不通过";
				    	  }else{
				    		  return data;
				    	  }
                      }
				 },{
				      targets: 7,
				      render: function(data, type, row, meta) {
						  if(row.secDishonestyType!=null&&row.secDishonestyType.trim()!="")
							  return row.secDishonestyType;
						  return "-";
                      }
				 }]
	        })
	    }
	    
	    //统计
	    function getTotals(){
	    	$.ajax({
	    		type : "POST",
	    		url : '/reg/server/seriouspunish/auditTotal',
				datatype : 'JSON',
				data: {},
				async : true,
				success : function(json) {
					$("#auditTotal").text(json.auditTotal);
					$("#auditNotTotal").text(json.auditNotTotal);
					$("#passTotal").text(json.passTotal);
				}
	    	});
	    }
	    getTotals();
	 
	    
	   //事件绑定
	    function bind() {
	        util.bindEvents([{
	            el: '#search',
	            event: 'click',
	            handler: function() {
	            	params=$("#searchForm").serializeObject();
	            	table.ajax.reload();
	            	getTotals();
	            }
	        }, {
                el: '#choseregUnit',
                event: 'click',
                handler: function() {
                    layer.dialog({
                        title: '请选择企业管理部门',
                        area: ['25%', '60%'],
                        content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#localAdm").val(data.returncodes);
                            $("#localAdmName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '.audit',
                event: 'click',
                handler: function() {
                	var data=table.row($(this).closest('td')).data();
                	layer.dialog({
                        title: '列入审核', 	
                        area: ['98%', '99%'],
                        content: "/reg/server/seriouspunish/doApplyAudit?uid="+data.uid,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                                getTotals();
                            }
                        }
                    })
                }
            }, {
                el: '.view',
                event: 'click',
                handler: function() {
                	var data=table.row($(this).closest('td')).data();
                	layer.dialog({
                        title: '审核查看',
                        area: ['98%', '99%'],
                        content: "/reg/server/seriouspunish/doApplyAuditView?uid="+data.uid,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            },{
            	el:'#reset',
            	event:'click',
            	handler:function(){
            		$("#localAdm").val("");
            	}
            }])
	    }

})