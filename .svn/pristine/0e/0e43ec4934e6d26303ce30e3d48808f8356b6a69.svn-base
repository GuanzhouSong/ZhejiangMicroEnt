require([ 'component/iframeLayer', 'component/dataTable', 'common/util',
		'common/http', 'handlebars', 'jquery'], function(layer, dataTable,
		util, http, handlebars) {

	init();
	/**
	 * 初始化函数集合
	 */
	function init() {
		initDataTable();
		$("#permit-table_info").hide();
		bind();
	}

	var table;

	/**
	 * 初始化dataTable
	 */
	function initDataTable() {
		var tpl = $('#tpl').html();
		var template = handlebars.compile(tpl);
		table = dataTable.load({
			// 需要初始化dataTable的dom元素
			el : '#permit-table',
		    
		    bPaginate : false, 
			ajax : '/reg/client/im/ent/permit/list.json',
			buttons:[],
			// 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
			// className不要写成class
			columns : [ {
				data : 'licNO',
				width : '115px'
			}, {
				data : 'licNameCN',
				width:'170'
			}, {
				data : null,width:'235'
			}, {
				data : 'licAnth'
			},
			{
				data : null
				 
			},

			{
				data : 'pubFlag'
				 
			}, {
				data : null,
				width : '80px',
				className : 'center'
			} ],
			columnDefs : [ 
			               
			               
			               {
				targets : 2,
				render : function(data, type, row, meta) {
					if(row.valFrom!=null&&row.valFrom!=""&&row.valTo!=null&&row.valTo!=""){
					var to=row.valTo.split("-");
					var valTo=to[0]+"年"+to[1]+"月"+to[2]+"日";
					var from=row.valFrom.split("-");
					var valFrom=from[0]+"年"+from[1]+"月"+from[2]+"日";
					return valFrom+"-"+valTo;
					}else{
						return "";
					}
					
				}
			},
			{
				targets:4,
				render:function(data,type,row,meta){
                    //判断有效期是否到期
                    var to=row.valTo.split("-");
                    var valTo=to[0]+to[1]+to[2];
					var now=util.dateFormat(new Date(),"yymmdd");
					if(valTo<now){
                        return "无效";
					}else{
                        if(row.pubType=="1"){
                            //1：变更
                            return  "有效";
                        }else if(row.pubType=="2"||row.pubType=="3"||row.pubType=="4"){
                            //2 注销、被吊销、撤销
                            return "无效";
                        } else{
                            return "有效";
                        }
					}
				}
			},
			
			{
				targets : 5,
				render : function(data, type, row, meta) {
					if (row.pubFlag == "2") {
						return "未公示";
					} else {
						return "已公示";
					}
				}
			}, {
				targets : 6,
				render : function(data, type, row, meta) {
					var context;
					if (row.pubFlag == "2") {

						context = {
							func : [ {
								'text' : '修改',
								'class' : 'js-edit'
							}, {
								'text' : '删除',
								'class' : 'js-delete'
							} ]
						};
					} else {
						context = {
							func : [ {
								'text' : '修改',
								'class' : 'btn btn-xs btn-primary js-edit'
							} ]
						};
					}
					return template(context);
				}
			} ]
		})
		
	}

	function bind() {
		util.bindEvents([
				{
					el : '.js-add',
					event : 'click',
					handler : function() {
						window.location.href="/reg/client/im/ent/permit/show";
						/*layer.dialog({
							title : '新增行政许可信息',
							area : [ '1000px', '600px' ],
							content : '/reg/client/im/permit/show',
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
					el:'#pubAll',
					event:'click',
					handler:function(){
						http.httpRequest({
				              url: '/reg/client/im/ent/permit/pubAll',
				              serializable: false, 
				              type: 'post',
				              success: function (data) {
				                  layer.msg(data.msg, {time: 1000}, function () {
				                	  table.ajax.reload();
				                  });
				              }
				          });  
					}
				
				 },
				 {
					 el:'#close',
					 event:'click',
					 handler:function(){ 
						 javascript:window.opener=null;window.close();
					 }
				 },
				{
					el : '.js-edit',
					event : 'click',
					handler : function() {
						var data = table.row($(this).closest('td')).data();
					   window.location.href="/reg/client/im/ent/permit/show?id="+data.licID+"&pubFlag="+data.pubFlag;
						/*layer.dialog({
							title : '编辑用户',
							area : [ '628px', '500px' ],
							content : '/reg/client/im/permit/show?id='
									+ data.licID + "&pubFlag=" + data.pubFlag,
							callback : function(data) {
								if (data.reload) {
									table.ajax.reload();
								}
							}
						})*/
					}
				},
				{
		            el: '#print',
		            event: 'click',
		            handler: function () {
		                var _id = "_doPrint_"+new Date().getTime();
		                var priPID="";
		                var url = "/reg/client/im/ent/permit/print?priPID="+priPID;
		                try{
		                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
		                }catch(e){
		                    alert("打印错误!");
		                }
		            }
		        },
				
				{
					el : '.js-delete',
					event : 'click',
					handler : function() {
						var data = table.row($(this).closest('td')).data();
						layer.confirm('确定要删除吗?', {
							icon : 2,
							title : '提示'
						}, function(index) {
							http.httpRequest({
								url : '/reg/client/im/ent/permit/delete',
								data : {
									licId : data.licID
								},
								success : function(data) {
									if (data.status == 'success') {
										// 重新加载列表数据
										if (data.msg) {
											layer.msg(data.msg, {
												time : 500
											}, function() {
												table.ajax.reload();
											});
										}
									} else if (data.status == "fail") {
										if (data.msg) {
											layer.msg(data.msg, {
												time : 500
											}, function() {
												table.ajax.reload();
											});
										}
									}
								}
							});

						});
					}
				} ])
	}

})
