require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	
	var searchParams={};
	var table;
	
	 init();
	 
	 function init(){
		 bind();
		 doCountByBussinessType();
		 initDataTable();
	 }
	 
	 
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	        var tpl = $('#tpl').html();
	        var template = handlebars.compile(tpl);
	        searchParams = $("#searchForm").serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                //type : "get",
	                url :  '/reg/server/seriouscrime/doGetExpSecFirstReviewList',
	                data : function(d){
                		d.params = searchParams;
	                }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [                
                {data: '_idx', className: 'center'},
                {data: 'id', className: 'center'},
                {data: 'regNO', className: 'center'},
                {data: 'entName', className: 'center'},
                {data: 'leRep', className: 'center'},
                {data: 'businessType', className: 'center'},
                {data: 'businessStatusName', className: 'center'},
                {data: 'addSecCause',  className: 'center'},
                {data: 'addSecTerm',  className: 'center'},
//                {data: 'publicState',  className: 'center'},
                {data: 'regState',  className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
			    		  if(row.businessStatus == '1')
				    		  return "<a href='javascript:void(0)' class='review'>审核</a>";
				    		  return "<a href='javascript:void(0)' class='detail'>详情</a>";
				  }
				},{
				      targets: 2,
				      render: function (data, type, row, meta) {
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
				      render: function (data, type, row, meta) {
			    		  if(row.businessType == '1')
			    			  return "提醒公告";
			    		  if(row.businessType == '2')
			    			  return "列入";
		    			  if(row.businessType == '3')
		    				  return "届满移出";
			    		  if(row.businessType == '4')
			    			  return "届满延期";
		    			  if(row.businessType == '5')
		    				  return "更正移出";
				  }
				}, {
				      targets: 9,
				      render: function (data, type, row, meta) {
				    	  if(row.regState == null)
				    		  return "";
			    		  if(row.regState == 'K' ||row.regState == 'A' ||row.regState == 'B' ||row.regState == 'DA')
				    		  return "存续";
			    		  if(row.regState == 'X')
			    			  return "注销";
			    		  if(row.regState == 'C')
			    			  return "撤销";
			    		  if(row.regState == 'D')
			    			  return "吊销";
			    		  if(row.regState == 'Q')
			    			  return "迁出";
				  }
				}
				]
	        })
	    }
	 
	    
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#search',
	            event: 'click',
	            handler: function() {
	            	searchParams = $("#searchForm").serializeObject();
	            		table.ajax.reload();
	            		doCountByBussinessType();
	            }
	        }, {
                el: '#choseregUnit',
                event: 'click',
                handler: function () {
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
                el: '#chosespeCause',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '列入原因',
                        area: ['600px', '350px'],
                        content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#speCause").val(data.id);
                                $("#SpeCauseCN").val(data.text);
                            }
                        }
                    })
                }
            }, {
                el: '.apply',
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '申请列入',
                        area: ['98%', '99%'],
                        content: '/reg/server/seriouscrime/doEnExpApplyAdd?priPID='+data.priPID+"&uID="+data.uid,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                                doCountByBussinessType();
                            }
                        }
                    })
                }
            }, {
                el: '.edit',
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '修改',
                        area: ['98%', '99%'],
                        content: '/reg/server/seriouscrime/doEnExpInApplyEdit?priPID='+data.priPID+"&uID="+data.sourceId,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                                doCountByBussinessType();
                            }
                        }
                    })
                }
            }, {
                el: '.delete',
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/reg/server/seriouscrime/doExpInApplyDelete',
                            data: {sourceId:data.sourceId},
                            success: function (data) {
                                if (data.status == 'success') {
                                    //重新加载列表数据
                                        layer.msg(data.msg, {time: 1000}, function () {
                                            table.ajax.reload();
                                            doCountByBussinessType();
                                        });
                                }else{
                                	layer.msg(data.msg, {time: 1000}, function () { });
                                }
                            }
                        });

                    });
                }
            }, {
                el: '.detail',
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                	console.log(data);
                	   layer.dialog({
                           title: '详情',
                           area: ['98%', '99%'],
                           content: '/reg/server/seriouscrime/doEnExpInApplyDetail?priPID='+data.priPID+"&uID="+data.sourceId,
                           callback: function (data) {
                                   
                           }
                       })
                }
            }, {
                el: '.review',
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '初审',
                        area: ['98%', '99%'],
                        content: '/reg/server/seriouscrime/doEnExpFirstReview?priPID='+data.priPID+"&uID="+data.sourceId,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                                doCountByBussinessType();
                            }
                        }
                    })
                }
            }, {
                el: '#reset',
                event: 'click',
                handler: function () {
                	$(".clearall").val("");
                }
            }
			])
	    }
	    function doCountByBussinessType(){
	    	http.httpRequest({
	    		type:'post',
	    		url:'/reg/server/seriouscrime/doCountByBussinessType',
	    		success:function(data){
	    			console.log(data)
	    			$("#dcsNum").html(data.dcsNum);
	    			$("#csbtgNum").html(data.csbtgNum);
	    			$("#dshNum").html(data.dshNum);
	    		}
	    	})
	    }
})



