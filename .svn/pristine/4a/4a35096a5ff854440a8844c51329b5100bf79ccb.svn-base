require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
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
    
   // laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startSetTime', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
        }
    };
    
    var end = {
            elem: '#endSetTime',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
    
    //开始时间和结束时间
    $("#startSetTime").click(function(){laydate(start);});
    $("#endSetTime").click(function(){laydate(end);}); 


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:_sysUrl+'/licdzdept/licDeptListJSON.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: null,width:"100px"},
                {data: 'exaCode'}, 
                {data: 'exaName',cut: {length: 20,mark:'...'}},
                {data: 'licDept',cut: {length: 20,mark:'...'}},
                {data: 'deptName',cut: {length: 20,mark:'...'}},
                {data: 'orgName',cut: {length: 20,mark:'...'}},
                {data: 'dutyDeptName',cut: {length: 20,mark:'...'}},
                {data: 'areaName',cut: {length: 20,mark:'...'}},
                {data: 'licZone'},
                {data: 'isValid'},
                {data: 'setName'} 
            ],
             columnDefs : [
							{
								targets: 1,
							    render: function (data, type, row, meta) {
							    	return '<a href="javascript:void(0);" class="moddifty" uid="'+row.exaName+'">修改</a>'+
							    	'&nbsp<a href="javascript:void(0);" class="delete">删除</a>'+
							    	'&nbsp<a href="javascript:void(0);" class="view">查看</a>'
							    }
							},
							{
								targets: 9,
							    render: function (data, type, row, meta) {
							    	 if(row.licZone=="0"){
							    		  return "国家级";
							    	  }else if(row.licZone=="1"){
							    		  return "省级";
							    	  }else if(row.licZone=="2"){
							    		  return "市级";
							    	  }else if(row.licZone=="3"){
							    		  return "县级";
							    	  }else {
							    		  return "混合";
							    	  } 
							    }
							},
							{
								targets: 10,
							    render: function (data, type, row, meta) {
							    	 if(row.isValid=="1"){
							    		  return "有效";
							    	  }else if(row.isValid=="0"){
							    		  return "无效";
							    	  }else{
							    		  return "";
							    	  }
							    }
							}
							]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '#pubdtinfohandpushlist',
            event: 'click',
            handler: function () {
            	 layer.dialog({
                     title: '新增',
                     area: ['65%', '70%'],
                     content: _sysUrl+'/licdzdept/licdeptEditPage?flag=1',
                     callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                     }
                 })
            }
        },
        {
            el: "#transferExaCode",
            event: 'click',
            handler: function () { 
            	 layer.dialog({
                     title: '数据下放',
                     area: ['50%', '40%'],
                     content: _sysUrl+'/licdzdept/transferExaCodePage',
                     callback: function (data) { 
                    	 if(typeof data.status!="undefined"){
                    		 if(data.status=="success"){ 
                        		 layer.msg("操作成功", {time: 3000}, function () {
                                  	layer.close({reload: false});
                                  });
                        	 }else{
                        		 layer.msg("操作失败", {ltype: 0,time:3000});
                        	 } 
                    	 }
                     }
                 })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () {
            	$("#adCode").val("");
            	$("#orgNameText").val(""); 
            	$("#yiedistrict").val(""); 
         		$("#areaNameText").val(""); 
         		$("#deptCode").val("");
            	$("#deptNameText").val(""); 
            }
        },
        {
            el: '.moddifty',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var uid=data.uid;
                 layer.dialog({
                    title: '修改',
                    area: ['65%', '70%'],
                    content: _sysUrl+'/licdzdept/licdeptEditPage?uid='+uid+"&flag=2",
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        },
        {
            el: '.delete',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
            	
            	var uid=data.uid;
            	layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: _sysUrl+'/licdzdept/delete',
	                    data: {uid: uid},
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
        },
        {
            el: '.view',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
            	var uid=data.uid;
                 layer.dialog({
                    title: '查看',
                    area: ['65%', '70%'],
                    content: _sysUrl+'/licdzdept/licdeptEditPage?uid='+uid+"&flag=3",
                    callback: function (data) {
                    }
                })
            }
        },
        {
            el: '#executeLicDeptData',
            event: 'click',
            handler: function () {
            	 http.httpRequest({
                     url: _sysUrl+'/licdzdept/executeLicDeptDataByLicZone',
                     serializable: false,
                     data: null,
                     type: 'post',
                     success: function (data) { 
                  	    alert("执行成功")
                     }
                 });
            }
        },
        {
            el: '#selctDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择对应备案部门',
                    area: ['25%', '65%'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {  
                    	    if(typeof data.adCodesExcParent!="undefined"&&data.adCodesExcParent!=null&&data.adCodesExcParent!=""){
                    	    	$("#deptCode").val(data.adCodesExcParent);
                            	$("#deptNameText").val(data.orgNamesExcParent); 
                    	    }
                   }
                })
            }
        },
        {
            el: '#selectAdDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择实际备案部门',
                    area: ['25%', '65%'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	if(typeof data.adCodesExcParent!="undefined"&&data.adCodesExcParent!=null&&data.adCodesExcParent!=""){
                    	 	$("#adCode").val(data.adCodesExcParent);
                        	$("#orgNameText").val(data.orgNamesExcParent); 
                    	}
                   }
                })
            }
        },
        {
            el: '#selectcity',
            event: 'click',
            handler: function () {  
                layer.dialog({
                    title: '选择行政区划',
                    area: ['25%', '65%'],
                    content: '/common/system/sysdepart/deptSelectCtity?treeType=checkbox',
                    callback: function (data) {
                    	if(typeof data.adCodes!="undefined"&&data.adCodes!=""&&data.adCodes!=null){
                    		$("#yiedistrict").val(data.adCodes); 
                     		$("#areaNameText").val(data.orgNames); 
                     	}
                   }
                })
            }
        }
        ])
    }

})
