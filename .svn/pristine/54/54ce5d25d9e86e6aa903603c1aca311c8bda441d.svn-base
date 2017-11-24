require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery', 'jquery.serialize', 'laydate', 'tab'], function (layer,dataTable, util, http) {
	
	var params = {};//查询参数
	var table;
	var $form=$("#searchForm");
	
	 init();
	 $(".apply_in").hide();
	 
	// 条件控制
    var status="";
    $("#businessStatus").change(function(){
    	if($(this).val()==status) {
    		$(".regState1").show();
    		$(".regState2").hide();
    		$(".regState1").prop("disabled",false);
    		$(".regState2").prop("disabled",true);
    		return;
    	}
    	if(status=="" && $(this).val() !=""){
        	status=$(this).val();
    		$(".clx").val("");
    		$(".apply_in").show();
    		$(".regState2").show();
    		$(".regState1").hide();
    		$(".regState2").prop("disabled",false);
    		$(".regState1").prop("disabled",true);
    	}else if(status!="" && $(this).val() ==""){
        	status=$(this).val();
        	$(".clx").val("");
    		$(".apply_in").hide();
    		$(".regState1").show();
    		$(".regState2").hide();
    		$(".regState1").prop("disabled",false);
    		$(".regState2").prop("disabled",true);
    	}else if(status!="" && $(this).val() !=""){
    		status=$(this).val();
        	$(".clx").val("");
    	}
    	$(this).val(status);
    })
	 
	 function init(){
		 bind();
		 initDataTable();
	 }
	    
	 
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	    	params = $form.serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                url :  '/reg/server/seriouspunish/doGetExpSecInApplyList',
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
	                {data: 'businessStatus', className: 'center'},
	                {data: 'secDishonestyType', className: 'center'},
	                {data: 'addSecTerm', className: 'center'},
	                {data: 'addSecCause', className: 'center'}
	            ],
	            columnDefs: [{
				      targets: 1,
				      render: function(data, type, row, meta) {
				    	  if(row.uid=='uid'){
				    		  return '<a class="apply" href="javascript:void(0)">申请列入</a>';
				    	  }else{
				    		  if(row.businessStatus == "1")
				    			  return '<a class="view" href="javascript:void(0)">详情</a><a class="edit" href="javascript:void(0)">修改</a><a class="delete" href="javascript:void(0)">删除</a> ';
							  if(row.businessStatus == '2')
								  return "<a class='view' href='javascript:void(0)'>详情</a><a href='javascript:void(0)' class='edit'>修改</a>";
							  if(row.businessStatus == '3')
								  return "<a href='javascript:void(0)' class='view'>详情</a>";
							  if(row.businessStatus == '4')
								  return "<a href='javascript:void(0)' class='view'>详情</a>";
							  if(row.businessStatus == '5')
								  return "<a class='view' href='javascript:void(0)'>详情</a><a href='javascript:void(0)' class='edit'>修改</a>";
							  return "";
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
				      targets: 5,
				      render: function(data, type, row, meta) {
				    	  if(data=="0"){
				    		  return "待列入";
				    	  }else if(data=="1"){
				    		  return "待初审";
				    	  }else if(data=="2"){
				    		  return "初审不通过";
				    	  }else if(data=="3"){
				    		  return "待审核";
				    	  }else if(data=="4"){
				    		  return "审核通过";
				    	  }else if(data=="5"){
				    		  return "审核不通过";
				    	  }else{
				    		  return data;
				    	  }
                      }
				 }],
				"fnDrawCallback" : function(oSettings) {
					var text = $("#businessStatus").find("option:selected").text();
					if(text == '待列入'){
					$("#applySrcTotal").text(oSettings._iRecordsTotal);}
				}

			})
	    }
	    //统计
	    function getTotals(){
	    	$.ajax({
	    		type : "POST",
	    		url : '/reg/server/seriouspunish/applyTotal',
				datatype : 'JSON',
				data: {},
				async : true,
				success : function(json) {
					//$("#applySrcTotal").text(json.applySrcTotal);
					$("#applyFirstTotal").text(json.applyFirstTotal);
					$("#applyAuditTotal").text(json.applyAuditTotal);
					$("#applyExpirTotal").text(json.applyExpirTotal);
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
	            	params=$form.serializeObject();
	            	table.ajax.reload();
	            	getTotals();
	            }
	        },{
	            el: '#reset',
	            event: 'click',
	            handler: function() {
	            	status="";
	            	$(".clx").val("");
	            	$(".apply_in").hide();
	            	$("#localAdm").val("");
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
                el: '.apply',
                event: 'click',
                handler: function() {
                	var data=table.row($(this).closest('td')).data();
                	layer.dialog({
                        title: '申请列入',
                        area: ['98%', '99%'],
                        content: "/reg/server/seriouspunish/doApply?caseID="+data.caseID+"&pid="+data.priPID,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                                getTotals();
                            }
                        }
                    })
                }
            }, {
                el: '.edit',
                event: 'click',
                handler: function() {
                	var data=table.row($(this).closest('td')).data();
                	http.httpRequest({
                		url:'/reg/server/seriouspunish/judgstate',
                		data:{"priPID":data.priPID},
                		dataType:'json',
                		type:'post',
                		async:'false',
                		success:function(json){
                			if(json.status=="fail"){
                				layer.msg("已审核成功，不允许修改，请刷新页面",{time:2000});
                				return false;
                			}else{
                				layer.dialog({
                                    title: '编辑',
                                    area: ['98%', '99%'],
                                    content: "/reg/server/seriouspunish/doApplyEdit?uid="+data.uid,
                                    callback: function (data) {
                                    	if (data.reload) {
                                            table.ajax.reload();
                                            getTotals();
                                        }
                                    }
                                })
                			}
                		}
                	})
                }
            }, {
                el: '.view',
                event: 'click',
                handler: function() {
                	var data=table.row($(this).closest('td')).data();
                	var url="";
                	if(data.businessStatus=='3'){
                		url="/reg/server/seriouspunish/doApplyView?uid="+data.uid;
                	}else
                		url="/reg/server/seriouspunish/doApplyAuditView?uid="+data.uid;
                	layer.dialog({
                        title: '查看',
                        area: ['98%', '99%'],
                        content: url,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            }, {
                el: '.delete',
                event: 'click',
                handler: function() {
                	var data = table.row($(this).closest('td')).data();
                	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function(index) {
                        http.httpRequest({
                            url: "/reg/server/seriouspunish/doExpInApplyDelete?uid="+data.uid,
                            data: {sourceId:data.sourceId},
                            success: function(data) {
                                if (data.status == 'success') {
                                    //重新加载列表数据
                                    layer.msg(data.msg, {time: 2000}, function(){
                                        table.ajax.reload();
                                        getTotals();
                                    });
                                }else{
                                	layer.msg(data.msg, {time: 2500}, function(){});
                                }
                            }
                        });
                    });
                }
            }
            ])
	    }

})