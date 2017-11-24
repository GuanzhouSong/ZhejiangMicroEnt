require(
		[ 'component/iframeLayer', 'component/dataTable', 'common/util',
				'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'jquery.form',
				'laydate', 'jquery.placeholder','jquery.icinfo'],
		function(layer, dataTable, util, http, handlebars) {
			 $('input, textarea').placeholder();
			init();
			/**
			 * 初始化函数集合
			 */
			function init() {

				initDataTable();
				bind();
			}

			var searchParams = {};// 查询参数声明!
			var table;

			/**
			 * 初始化dataTable
			 */
			function initDataTable() {
				var tpl = $('#tpl').html();
				var userType = $("#userType").val();
				var typeUrl = "";
				if (userType == "2") {
					typeUrl = "/syn/server/other/pubSmallSupport/listJSON";
				} else {
					typeUrl = "/reg/server/other/pubSmallSupport/listJSON";
				}
				var template = handlebars.compile(tpl);
				table = dataTable.load({
					// 需要初始化dataTable的dom元素
					el : '#user-table',
					// 是否加索引值
					showIndex : true,
					ajax : {
						url : typeUrl,
						data : function(d) {
							d.params = searchParams;
						}
					},
					// 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
					// 'className'不要写成class
					columns : [ {
						data : null,
						'className' : 'center'
					}, 
					{
						data:null,
						'className':'center'
					},
					{
						data : 'entName'
					}, {
						data : 'regNO'
					}, {
						data : 'deptName'
					}, {
						data : 'helpContent',cut:{length:20,markZ:'...'}
					}, {
						data : 'helpDate'
					}

					],
					columnDefs : [ 
                       {
                    	targets:1,
                    	render:function(data,type,row,meta){
                    	    var deptCode = $("#deptCode").val();
                            var userType = $("#userType").val();
                            if (userType == "1") {//警示不判断
                                if (row.auditState == '0') {
                                    return "<a class='commit js_edit'>修改</a>&nbsp;&nbsp;<a class='commit js_delete'>删除</a>";
                                } else {
                                    return "<a class='commit js_view'>详情</a>";
                                }
                            } else {//协同判断
                                if (deptCode == row.deptID) {
                                    if (row.auditState == '0') {
                                    	   return "<a class='commit js_edit'>修改</a>&nbsp;&nbsp;<a class='commit js_delete'>删除</a>";
                                    } else {
                                        return "<a class='commit js_view'>详情</a>";
                                    }
                                } else {
                                    return "<a class='commit js_view'>详情</a>";
                                }

                            } 
                         }
                      } 
					]
				})
			}

			function bind() {
				util
						.bindEvents([

								{
									el : '#addBtn',
									event : 'click',
									handler : function() {
										var data = table.row(
												$(this).closest('td')).data();
									 
										var userType = $("#userType").val();
										var typeUrl = "";
										if (userType == "2") {
											typeUrl = '/syn/server/other/pubSmallSupport/addView';
										} else {
											typeUrl = '/reg/server/other/pubSmallSupport/addView';
										}
										window.location.href=typeUrl;
										/*layer.dialog({
											title : '行政许可审核',
											area : [ '1000px', '600px' ],
											content : typeUrl,
											callback : function(data) {

												// 重新加载列表数据
												if (data.reload) {
													table.ajax.reload();
												}
											}
										})*/

									}
								},
								{
									el : '.js_view',
									event : 'click',
									handler : function() {
										var data = table.row(
												$(this).closest('td')).data();
										var licID = data.uid;
										var userType = $("#userType").val();
										var typeUrl = "";
										if (userType == "2") {
											typeUrl = '/syn/server/other/pubSmallSupport/showDetails?uid='
													+ licID;
										} else {
											typeUrl = '/reg/server/other/pubSmallSupport/showDetails?uid='
													+ licID;
										}
										layer.dialog({
											title : '行政许可详情',
											area : [ '1000px', '660px' ],
											content : typeUrl,
											callback : function(data) {
												// 重新加载列表数据
												if (data.reload) {

													/*
													 * $("#regOrg").val(data.reload.retruncode);
													 * $("#regOrgName").val(data.reload.returnname);
													 */

												}
											}
										})

									}
								},
								
								{
				                    el: '.js_edit',
				                    event: 'click',
				                    handler: function () {
				                        var data = table.row(
				                            $(this).closest('td')).data();
				                        var licID = data.uid;
				                        var userType = $("#userType").val();
				                        var typeUrl = "";
				                        if (userType == "2") {
				                            typeUrl = '/syn/server/other/pubSmallSupport/show?uid='
				                                + licID;
				                        } else {
				                            typeUrl = '/reg/server/other/pubSmallSupport/show?uid='
				                                + licID;
				                        }
				                        layer.dialog({
				                            title: '扶持信息',
				                            area: ['1000px', '600px'],
				                            content: typeUrl,
				                            callback: function (data) {

				                                // 重新加载列表数据
				                                if (data.reload) {
				                                    table.ajax.reload();
				                                }
				                            }
				                        })

				                    }
				                },
				                {
				                    el: '.js_delete',
				                    event: 'click',
				                    handler: function () {
				                    	   var data = table.row($(this).closest('td')).data();
				                        var userType = $("#userType").val();
				                        var typeUrl = "";
				                        if (userType == "2") {
				                            typeUrl = "/syn/server/other/pubSmallSupport/deleteBatch";
				                        } else {
				                            typeUrl = "/reg/server/other/pubSmallSupport/deleteBatch";
				                        }
				                         
				                        http.httpRequest({
				                            url: typeUrl,
				                            data: {"uid":data.uid},
				                            success: function (data) {
				                                if (data.status == 'success') {
				                                    layer.msg(data.msg, {time: 1000}, function () {
				                                        table.ajax.reload();
				                                    })

				                                }

				                            }
				                        });

				                    }

				                },
								
								{
									el : '#choseorgReg',
									event : 'click',
									handler : function() {

										layer
												.dialog({
													title : '选择登记机关',
													area : [ '328px', '600px' ],
													content : '/commom/server/regorg/regorgmutiselect',
													callback : function(data) {
														// 重新加载列表数据
														if (data) {
															$("#regOrg")
																	.val(
																			data.returncode);
															$("#regOrgName")
																	.val(
																			data.returnname);

														}
													}
												})

									}
								},

								{
									el : '#choseregUnit',
									event : 'click',
									handler : function() {

										layer
												.dialog({
													title : '选择管辖单位',
													area : [ '328px', '600px' ],
													content : '/commom/server/regunit/regunitmutiselect',
													callback : function(data) {
														// 重新加载列表数据
														if (data) {
															$("#localAdm")
																	.val(
																			data.returncode);
															$("#localAdmName")
																	.val(
																			data.returnname);

														}
													}
												})

									}
								},

								{
									el : '#choseEntcatg',
									event : 'click',
									handler : function() {

										layer
												.dialog({
													title : '选择企业类型',
													area : [ '328px', '600px' ],
													content : '/commom/server/entcatg/entcatgmutiselect',
													callback : function(data) {
														// 重新加载列表数据
														if (data) {

															$("#entType")
																	.val(
																			data.returncode);
															var name = data.returnname;
															$("#entTypeName")
																	.val(name);

														}
													}
												})

									}
								},

								{
									el : '#choseSilceno',
									event : 'click',
									handler : function() {

										layer
												.dialog({
													title : '选择责任区',
													area : [ '328px', '600px' ],
													content : '/commom/server/sliceno/slicenomutiselect',
													callback : function(data) {
														// 重新加载列表数据
														if (data) {

															$("#sliceNO")
																	.val(
																			data.returncode);
															$("#sliceNoName")
																	.val(
																			data.returnname);
															table.ajax.reload();
														}
													}
												})

									}
								},
								{
									el : '.js-edit',
									event : 'click',
									handler : function() {
										var data = table.row(
												$(this).closest('td')).data();
										layer
												.dialog({
													title : '修改',
													area : [ '728px', '500px' ],
													content : '/reg/server/registinfo/registinfo/toShow?priPID='
															+ data.priPID
															+ '&UID='
															+ data.uid,
													callback : function(data) {
														if (data.reload) {
															table.ajax.reload();
														}
													}
												})
									}
								},
								{
									el : '#qry',
									event : 'click',
									handler : function() {
										searchParams = $("#qryForm")
												.serializeObject();
										table.ajax.reload();
									}
								},
								{
									el : '#cancel',
									event : 'click',
									handler : function() {
										$('#qryForm')[0].reset();
										$("#regOrg").val("");
										$("#localAdm").val("");
										$("#entType").val("");
										$("#sliceNO").val("");
									}
								},
								{
					            	  el:"#importExcel",
					            	  event:'click',
					            	  handler:function(){ 
					            		  $("#loadFile").show();
					            	  }
					            	  
					              },
					              {
					            	  el:".btnCancel",
					            	  event:'click',
					            	  handler:function(){
					            		 
					            		  $("#loadFile").hide();
					            	  }
					              },
					              
					              {
					                  el: '.js-import',  // 对外担保 导入Excel
					                  event: 'click',
					                  handler: function () {
					                	 
					                     // layer.confirm('<em style="color: red">导入信息时将同时清空之前已填录的信息，请确定是否继续导入操作!</em>', {btn: ['确定', '取消'], icon: 7, title: '温馨提示'}, function () {
					                          var _file = $("#js-file").val(); 
					                          if (!_file) {
					                              layer.msg("请上传Excel模板文件!", {icon: 7, time: 3000});
					                              return;
					                          } else {
					                              var ext = _file.toLowerCase().substr(_file.lastIndexOf(".")); //获取文件后缀
					                              if (!(ext == ".xls" || ext == ".xlsx")) {   //判断是否是Excel文件
					                                  layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
					                                  return;
					                              }
					                          }
					                          var userType = $("#userType").val();
												var typeUrl = "";
												if (userType == "2") {
													typeUrl="/syn/server/other/pubSmallSupport/importExcel";
												}else{
													typeUrl="/reg/server/other/pubSmallSupport/importExcel";
												}
					                          
					                          $("#file_import").ajaxSubmit({
					                              type: 'post',
					                              url:typeUrl,
					                              data: $("#file_import").serialize(),
					                              dataType: 'json',  //不填写默认是 字符串格式
					                              cache: false,
					                              success: function (data) {
					                                  if (data.status == 'success') {
					                                      layer.msg("导入成功", {icon: 1, time: 1000}, function () {
					                                    	  table.ajax.reload(); //重新加载列表
					                                         $("#js-file").val("");
					                                    	  $("#loadFile").hide();
					                                      });
					                                  }
					                                  if (data.status == 'fail') {
					                                      layer.msg(data.msg, {icon: 2, time: 3000});
					                                  }
					                              },
					                              error: function (data) {
					                              }
					                          });  
					                  }
					              }
								 
					        
					            
								])
			}

		})
