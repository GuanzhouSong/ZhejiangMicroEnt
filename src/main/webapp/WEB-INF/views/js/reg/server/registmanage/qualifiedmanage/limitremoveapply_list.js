require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	var params=$("#entSearchForm").serializeObject();//查询参数声明!
	var initFlag = '1';
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
//    	initDataTable();
        bind();
    }
    
    $("#limitTypeM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#freeStateM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    //设置限制原因类别为全部
	$('#limitTypeM').multipleSelect('checkAll');
	//限制解除状态
	$('#freeStateM').multipleSelect('checkAll');

	function initDataTable() {
		initFlag = '0';
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : '/reg/server/registmanage/limitRemoveApplyListJSON.json',
			data : function(d) {
        		d.params = $.extend({}, params, {"removelimitflag":"1","removelimitsearchflag":"1"});               		
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
          	{data: null,defaultContent:'priPID', width: '100px', className: 'center'},
		    {data : 'clientName', className: 'center'},
		    {data : 'certNO', className: 'left'},
		    {data : 'limitTypeName', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'regNO', className: 'center'},
		    {data : 'limitReason', className: 'center',cut: {length: 30,mark:'...'}},
		    {data : 'limitNO', className: 'center'},
		    {data : 'limitDepartName', className: 'center'},		    
		    {data : 'auditState', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'limitDateStart', className: 'center'},
		    {data : 'limitDateEnd', className: 'center'},
		    {data : 'removeDate', className: 'center'},
		    {data : 'removeAppLyName', className: 'center'},
		    {data : 'removeAppLyDate', className: 'center'},
		    {data : 'removeAuditName', className: 'center'},
		    {data : 'removeAuditDate', className: 'center'},
		    {data : 'removeAuditDept', className: 'center'}
		],
		columnDefs : [{
		       	 targets:1,
		    	 render:function (data, type, row, meta) {
                  var auditState= row.auditState;
               	  if("0"==auditState){
               		  return '<a class="mod" id="'+row.uid+'" priPID="'+row.priPID+'" href="javascript:void(0);" >修改</a>\
              			<a class="del" id="'+row.uid+'" priPID="'+row.priPID+'" href="javascript:void(0);" >删除</a>';
               	  }else if("2"==auditState){
                   	   return '<a class="view" id="'+row.uid+'" priPID="'+row.priPID+'" href="javascript:void(0);" >详情</a>';   
               	  }else if("1"==auditState){
               		  return '<a class="print" id="'+row.uid+'" priPID="'+row.priPID+'" href="javascript:void(0);" >打印</a>\
               		   <a class="view" id="'+row.uid+'" priPID="'+row.priPID+'" href="javascript:void(0);" >详情</a>'; 
         		  }else{
         			  return "";
         		  } 
		    	 }
		    	  
		      },{
		       	 targets:5,
		    	 render:function (data, type, row, meta) {
		    		 if(row.entName == "" || row.entName == null || row.entName == "undefined"){
		    			 return '-';
		    		 }else{
		    			 return row.entName;
		    		 }
		    	 }
		      },{
				targets:6,
				render:function(data,type,row,meta){
					if(row.uniscid){
						return row.uniscid;
					}else if(row.regNO){
						return row.regNO;
					}else{
						return '-';
					}
				}
			 },{
					targets:10,
					render:function(data,type,row,meta){
						if(row.auditState == "0"){
							return '待审核';
						}else if(row.auditState == "1"){
						    return '审核通过';	
						}else if(row.auditState == "2"){
							return '审核不通过';
						}else{
							return '';
						}
					}
				 },{
				targets:11,
				render:function(data,type,row,meta){
					if(row.limitDateEnd){
						 var sysdate=$("#sysdate").val();  
						 var limitDateEnd=row.limitDateEnd;  
						 if(sysdate!=""&&limitDateEnd!=""){  
							 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
							 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
//							 if(d1 > d2){
//								 return "已解除";
//							 }else{
//								 return "未解除"
//							 }
							 if(row.auditState == "1"){
								 return "已解除";
							 }else{
								 return "未解除";
							 }
						 }
					}
					return '';
				}
			 }],
		    "fnDrawCallback": function (oSettings) {
		    	var searchMap = $.extend({}, params, {"removelimitflag":"1","removelimitsearchflag":"1"});
		    	http.httpRequest({ 
	                url: '/reg/server/registmanage/DataCountList',
	                serializable: false,
	                type:'post',
	                data: {params:searchMap} ,
	                success: function (data) {
	                	var list = data.data;
	                    if (data.status == 'success') {  
	                    	//限制对象数量
							$("#clientNameCount").text(list[0]);
							//限制原因数量
							$("#pripidCount").text(list[1]);
	                    }else{
	                    	$("#clientNameCount").text("0");
							$("#pripidCount").text("0");
	                    } 
	                }
	            });
			}
	  });
	}
	
    
    
   
    function bind() {
        util.bindEvents([
        {
            el: '#search',
            event: 'click',
            handler: function () {
        		var limitType = $("#limitTypeM").val();
        		$("#limitType").val(limitType);
        		
        		var freeState = $("#freeStateM").val();
        		$("#freeState").val(freeState);
        		
        		params = $("#entSearchForm").serializeObject();
        		if(initFlag=="1"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        },
        {
        	el:'#cancle',
        	event:'click',
        	handler:function(){
        	    //设置限制原因类别为全部
        		$('#limitTypeM').multipleSelect('checkAll');
        		//限制解除状态
        		$('#freeStateM').multipleSelect('checkAll');
        		//限制执行部门
        		$("#activeDep").val("");
        		$("#removeDept").val("");
        	}
        },{
            el: '#addReMove',//进入新增限制移出申请
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/registmanage/limitRemoveAddApplyList';
            }
        },
        {
            el: '.mod',//修改
            event: 'click',
            handler: function () {
            	var uid = this.id;
            	if(uid!=null && uid != ''){
            		layer.dialog({
                        title: '登记事项管理 - 任职资格限制管理-提前解除申请修改',
                        area: ['70%', '60%'],
                    	content: '/reg/server/registmanage/limitRemoveAddApply?uid='+uid+'&operate=1',
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
            	}
            }
        },{
            el: '.del',//删除
            event: 'click',
            handler: function () {
//            	var uid = $(this).attr("uid");
            	var uid=this.id;
            	var data = table.row($(this).closest('td')).data();
            	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: '/reg/server/registmanage/deleteRemoveApply',
	                    data: {uid: uid,priPID:data.priPID },
	                    success: function (data) {
	                        if (data.status == 'success') {  
	                                layer.msg("删除成功", {time: 1000}, function () {
	                                	table.ajax.reload();
	                                }); 
	                        }else{
	                        	layer.msg("删除失败", {ltype: 0,time:2000});
	                        } 
	                    }
	                });
                })
            }
        },{
            el: '.view',//详情
            event: 'click',
            handler: function () {
            	var uid = this.id;
            	if(uid!=null && uid != ''){
            		layer.dialog({
                        title: '登记事项管理 - 任职资格限制管理-提前解除详情',
                        area: ['70%', '70%'],
                    	content: '/reg/server/registmanage/limitRemoveAddApply?uid='+uid+'&operate=2',
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
            	}
            }
        },{ 
            el: '.print',//打印
            event: 'click',
            handler: function () {
            var uid = this.id;
            if(uid!=null && uid != ''){
        		layer.dialog({
                    title: '生成任职资格限制解除证明',
                    area: ['70%', '80%'],
                	content: '/reg/server/registmanage/limitRemoveBookEdit?uid='+uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
        	} 	
//             var uid = this.id;
//       	     var _id = "_doPrint_"+new Date().getTime();
//             var url = "/reg/server/registmanage/limitRemoveBookEdit?uid="+uid;
//             try{
//                 window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
//             }catch(e){
//                 alert("打印错误!");
//             }
            }
        },
        {
            el: '.js-more-query',
            event: 'click',
            handler: function () {
            	if($('.more-show').css("display")=="none"){
            		$('.js-more-query').attr('value','收起');
            		$('.more-show').css("display","block");
            	}else{
            		$('.js-more-query').attr('value','更多查询');
            		$('.more-show').css("display","none");
            	}
            }
        },{
            el: '#chooseFreeDepName',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '选择组织部门',
                    area: ['328px', '600px'],
                    content: '/syn/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	if (data) { 
                           	$("#freeDep").val(data.orgCodesExcParent);
                           	$("#freeDepName").val(data.orgNamesExcParent);
                    	}
                    }
            	});
            }
        },{
            el: '#chooseActiveDep',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '选择组织部门',
                    area: ['328px', '600px'],
                    content: '/syn/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	if (data) { 
                           	$("#activeDep").val(data.orgCodesExcParent);
                           	$("#activeDepName").val(data.orgNamesExcParent);
                    	}
                    }
            	});
            }
        }
        ]);
    }
});
