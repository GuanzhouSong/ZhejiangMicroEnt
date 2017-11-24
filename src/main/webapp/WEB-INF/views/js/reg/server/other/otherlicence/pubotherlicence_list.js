require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, dataTable, util, http, handlebars) {
	var initFlag = '1';
    init();
    /**
     * 初始化函数集合
     */
    function init() { 
     //initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = '0';
    	var tpl = $('#tpl').html();
        var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
        	typeUrl="/syn/server/other/pubohterlicence/listJSON";
        }else{
        	typeUrl="/reg/server/other/pubohterlicence/listJSON";
        }
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
        	scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:typeUrl,
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                      {data: null,'defaultContent':'11'},
                      {data: null,width:"80px",defaultContent:'id'},
             
                {data: 'licNO'},
                {data: 'licNameCN'},
                {data: 'licValFrom'},
                {data: 'licValTo'},
                {data: 'licAnth'},
                {data: 'licScope',cut:{length:20,markZ:'...'}},
                {data: 'licType'},
                {data: 'pubFlag'},
                {data: 'auditState'},
                {data: 'setName'},
                {data: 'setDate'},
                {data: 'auditName'},
                {data: 'entName'},
                {data: 'regNO'},
                {data:'regOrgName'},
                {data:'localAdmName'},
                {data:'sliceNOName'}
           
              
            ],
            columnDefs: [
                         
{
	targets: 1,
    render: function (data, type, row, meta) {
    	var deptCode=$("#deptCode").val(); 
    	var userType= $("#userType").val();  
    	if(userType=="1"){//警示不判断
    	if(row.auditState!=null){
    	if (row.auditState == '0') {
    	    return "<a class='commit js_audit'>审核</a>";
    	}else{
    		return "<a class='commit js_view'>详情</a>";
    	}
    	}else{
    		return "<a class='commit js_view'>详情</a>";
    	}
       }else{//协同判断
    	   if(deptCode==row.setDeptname){
    		   if(row.auditState!=null){
    		    	if (row.auditState == '0') {
    		    	    return "<a class='commit js_audit'>审核</a>";
    		    	}else{
    		    		return "<a class='commit js_view'>详情</a>";
    		    	}
    		    	}else{
    		    		return "<a class='commit js_view'>详情</a>";
    		    	}
    		   
    	   }else{
    			return "<a class='commit js_view'>详情</a>"; 
    	   }
    	   
    	   
    	   
       }
    }
},
{
	targets: 8,
    render: function (data, type, row, meta) {
    	if(row.licState!=null){
    	if(row.licState=="1"){
    		  return "有效"; 
    	  } else if(row.licState=="0"){
    		  return "无效";
    	  }else{
    		  return "有效";
    	  }
    	}else{
    		return "有效";
    	}
    		 
    }
},{
	targets: 9,
    render: function (data, type, row, meta) {
    	if(row.pubFlag!=null){
    	if(row.pubFlag=="1"){
    		  return "已公示"; 
    	  } else{
    		  return "未公示";
    	  } 
    	} else{
    		return "未公示";
    	} 
    }
},
{
	targets: 10,
    render: function (data, type, row, meta) {
    	if(row.auditState!=null){
    	  if(row.auditState=="0"){
    		  return "待审核"; 
    	  } else if(row.auditState=="1"){
    		  return "已审核";
    	  } else if(row.auditState=="2"){
    		  return "审核通不过";
    	  }else{
    		  return "待审核";
    	  }
    	}else{
    		return "待审核";
    	}
    		 
    }
}



            ]
        })
    }

   

    function bind() {
        util.bindEvents([
 

{
    el: '.js_audit',
    event: 'click',
    handler: function () {
    	var data = table.row($(this).closest('td')).data();
    	var licID=data.licID;
    	 var userType= $("#userType").val(); 
         var typeUrl="";
         if(userType=="2"){
        	 typeUrl='/syn/server/other/pubohterlicence/show?licID='+licID+"&entType=audit";
         }else{
        	 typeUrl='/reg/server/other/pubohterlicence/show?licID='+licID+"&entType=audit";
         }
   layer.dialog({
            title: '行政许可审核',
            area: ['68%', '58%'],
            content:typeUrl,
            callback: function (data) {
            	 
                //重新加载列表数据
                if (data.reload) { 
                	 table.ajax.reload();  
                }
            }
        })

}
}, 
{
    el: '.js_view',
    event: 'click',
    handler: function () {
    	var data = table.row($(this).closest('td')).data();
    	var licID=data.licID;
    	 var userType= $("#userType").val(); 
         var typeUrl="";
         if(userType=="2"){
        	 typeUrl='/syn/server/other/pubohterlicence/show?licID='+licID+"&entType=view";
         }else{
        	 typeUrl='/reg/server/other/pubohterlicence/show?licID='+licID+"&entType=view";
         }
   layer.dialog({
            title: '行政许可详情',
            area: ['1000px', '580px'],
            content:typeUrl,
            callback: function (data) {
                //重新加载列表数据
                if (data.reload) { 
                	 
                	/*$("#regOrg").val(data.reload.retruncode);
                	$("#regOrgName").val(data.reload.returnname);*/
                    
                }
            }
        })

}
},  
                         {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
         
           layer.dialog({
                        title: '选择登记机关',
                        area: ['328px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck='+true,
                        callback: function (data) {
                            //重新加载列表数据
                            if (data) { 
                            	$("#regOrg").val(data.returncode);
                            	$("#regOrgName").val(data.returnname);
                                
                            }
                        }
                    })
            
         }
      }, 
      
      {
          el: '#choseregUnit',
          event: 'click',
          handler: function () {
   
     layer.dialog({
                  title: '选择管辖单位',
                  area: ['328px', '600px'],
                  content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck='+true,
                  callback: function (data) {
                      //重新加载列表数据
                      if (data) {  
                      	$("#localAdm").val(data.returncode);
                      	$("#localAdmName").val(data.returnname);
                        
                      }
                  }
              })
      
   }
},

{
    el: '#choseEntcatg',
    event: 'click',
    handler: function () {

layer.dialog({
            title: '选择企业类型',
            area: ['328px', '600px'],
            content: '/commom/server/entcatg/entcatgmutiselect',
            callback: function (data) {
                //重新加载列表数据
                if (data) { 
                 
                	$("#entType").val(data.returncode);
                	var name=data.returnname;
                	$("#entTypeName").val(name);
                 
                }
            }
        })

}
},

{
    el: '#choseSilceno',
    event: 'click',
    handler: function () {

layer.dialog({
            title: '选择责任区',
            area: ['328px', '600px'],
            content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck='+true,
            callback: function (data) {
                //重新加载列表数据
                if (data) { 
                 
                	$("#sliceNO").val(data.returncode);
                	$("#sliceNoName").val(data.returnname);
                   table.ajax.reload();
                }
            }
        })

}
},
    {      el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['728px', '500px'],
                    content: '/reg/server/registinfo/registinfo/toShow?priPID=' + data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
                    el: '#qry',
                    event: 'click',
                    handler: function () {
                         searchParams=$("#qryForm").serializeObject();
                         if(initFlag == '1'){
                     		initDataTable();
                     	}
                          table.ajax.reload();
                    }
                },
 {
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                     $('#qryForm')[0].reset();
                     $("#regOrg").val("");
                     $("#localAdm").val("");
                     $("#entType").val("");
                     $("#sliceNO").val("");
                     }
                 },
 {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                 var flag=$(this).prop("checked");
                 $("input:checkbox[name='_checkbox']").prop("checked", flag);
                 }
              }
             
])
    }

})
