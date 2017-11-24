require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
   //警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
  
    init(); 
    
    
    /**
     * 初始化函数集合
     */
    function init() {
    	 
      initDataTable();
      bind();
        } 

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
     	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:_sysUrl+'/sysuserareamanage/selectSysUserAreaManageListPageJSON.json',
                data:function(d){ 
                	d.params = searchParams;
                }
            },
            columns: [ 
					{data: null,'defaultContent':'11'},
					{data: null,width:"100px"},
					{data: 'username'}, 
					{data: 'realName',cut: {length: 20,mark:'...'}},
					{data: 'orgName',cut: {length: 20,mark:'...'}},
					{data: 'jurUnit',cut: {length: 20,mark:'...'}},
					{data: 'post',cut: {length: 20,mark:'...'}},
					{data: 'telPhone',cut: {length: 20,mark:'...'}},
					{data: 'phone',cut: {length: 20,mark:'...'}},
					{data: 'deptCode',cut: {length: 20,mark:'...'}},
					{data: 'userStatus',cut: {length: 20,mark:'...'}},
					{data: 'setName',cut: {length: 20,mark:'...'}},
					{data: 'setDate',cut: {length: 20,mark:'...'}}
    				
            ] ,
            columnDefs: [
                          {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	var status=row.userStatus;
                            	var htmlTem='<a class="view link js-edit" id="'+row.uid+'"  href="javascript:void(0);">详情</a>'; 
                            	if(status=="1"){
                            		htmlTem+='<a class="jy link js-edit" id="'+row.uid+'"  href="javascript:void(0);">禁用</a>';
                            	}else{
                            		htmlTem+='<a class="qy link js-edit" id="'+row.uid+'"  href="javascript:void(0);">启用</a>';
                            		htmlTem+='<a class="deleteuid link js-edit" id="'+row.uid+'"  href="javascript:void(0);">删除</a>';
                            	}
                            	return htmlTem;
                             }
                          } ,
                          {
                              targets: 9,
                              render: function (data, type, row, meta) {
                            	  
                            	var  licZone="";  
                                if(data!=null&&data!=""&&data.length>=8){
                                	licZone=data.substring(0,8).substring(2,8);
                                	if(licZone=="000000"){
                                		return "省级";
                                	}else  if(licZone.substring(2,8)=="0000"){
                                		return "市级";
                                	}else{
                                		return "县级";
                                	}
                                }else{
                                	return "无效";
                                }
                              }
                           }  ,
                           {
                               targets: 10,
                               render: function (data, type, row, meta) {
                              	var status=row.userStatus;
                                 if(status=="1"){
                                 	return "有效";
                                 }
                              	return "无效";
                               }
                            } 
            ] 
         })
    } 
  
     

    function bind() {
        util.bindEvents([
      {
            el: '#add',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '添加区域管理员',
                    area: ['100%', '100%'],
                    content: _sysUrl+'/sysuserareamanage/userAreaManagEdit',
                    callback: function(data) {
                    	
                    	if(typeof data.status!="undefined"){
                      		 if(data.status=="success"){ 
                          		 layer.msg("操作成功!"+data.data, {time: 3000}, function () {
                          			        table.ajax.reload(); 
                                    });
                          	 }else{
                          		 layer.msg("操作失败", {ltype: 0,time:2000});
                          	 } 
                      	 }
                    }
                })
            }
        },{
        	el: '#search',
            event: 'click',
            handler: function () {
            	searchParams = $("#taskForm").serializeObject();
             	if(searchFlag=="0"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        },
        {
            el: '.view',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var uid=data.uid;
                 layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content: _sysUrl+'/sysuserareamanage/viewDetail?uid='+uid,
                    callback: function (data) {
                    	 
                    }
                })
            }
        },
        {
            el: '.jy',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data(); 
            	 var uid=data.uid;
            	 layer.confirm('确定要禁用吗?', {icon: 3, title: '提示'}, function () { 
 	                http.httpRequest({
 	                    type: 'get',
 	                    url: _sysUrl+'/sysuserareamanage/updateUserAreaManageStatus?uid='+uid+"&status=0",
 	                    success: function (data) {
 	                        if (data.status == 'success') {  
 	                                layer.msg("操作成功", {time: 2000}, function () {
 	                                	table.ajax.reload();
 	                                }); 
 	                        }else{
 	                        	layer.msg("操作失败", {ltype: 0,time:2000});
 	                        } 
 	                    }
 	                });
                 })
            }
        },
        {
            el: '.deleteuid',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data(); 
            	 var uid=data.uid;
            	 layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () { 
 	                http.httpRequest({
 	                    type: 'get',
 	                    url: _sysUrl+'/sysuserareamanage/delete?uid='+uid+"&status=0",
 	                    success: function (data) {
 	                        if (data.status == 'success') {  
 	                                layer.msg("删除成功", {time: 2000}, function () {
 	                                	table.ajax.reload();
 	                                }); 
 	                        }else{
 	                        	layer.msg("删除失败", {ltype: 0,time:2000});
 	                        } 
 	                    }
 	                });
                 })
            }
        },
        {
            el: '.qy',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var uid=data.uid;
            	 layer.confirm('确定要启用吗?', {icon: 3, title: '提示'}, function () { 
 	                http.httpRequest({
 	                    type: 'get',
 	                    url: _sysUrl+'/sysuserareamanage/updateUserAreaManageStatus?uid='+uid+"&status=1",
 	                    success: function (data) {
 	                        if (data.status == 'success') {  
 	                                layer.msg("操作成功", {time: 2000}, function () {
 	                                	table.ajax.reload();
 	                                }); 
 	                        }else{
 	                        	layer.msg("操作失败", {ltype: 0,time:2000});
 	                        } 
 	                    }
 	                });
                 })
            }
        },
        {
            el: '#choseDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) { 
                    	$("#checkDep").val(data.adCodes);
                    	$("#checkDepName").val(data.orgNames);
                   }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#checkDep").val("");
            }
        }
        ]);
    }

})
