require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, dataTable, util, http, handlebars) {
	var initFlag = '1';
    var searchParams={};//查询参数声明!
    var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() { 
       //initDataTable();
        bind();
      //initCount();
    }
   function initCount(){
	   var userType= $("#userType").val(); 
       var typeUrl="";
       if(userType=="2"){
    	   typeUrl='/syn/server/other/pubohterlicence/count';
       }else{
    	   typeUrl='/reg/server/other/pubohterlicence/count';
       }
	   
	   http.httpRequest({
            url: typeUrl,
            serializable: false,
            data:  searchParams,
            type: 'post',
            success: function (data) {
            	if(data.data!=null&&data.data!=""){ 
            	var data=data.data; 
            	if(data.licenceDistinct!=null && data.licence!=null ){
            	  if($("#licResouce").val() !='1'){
            		  $("#allDept").text(data.licenceDistinct);
                	  $("#allDeptNum").text(data.licence);
            	   }else{
            		   data.licence = 0;
            		   data.licenceDistinct = 0;
            		   $("#allDept,#allDeptNum").text("0");
            	   }
            	}
            	 var perMItDistinct ="";
            	 var perMit="";
            	 if(data.perMItDistinct==""||data.perMItDistinct==null){
            		 perMItDistinct="0";
            	 }else{
            		 perMItDistinct=data.perMItDistinct;
            	 }
            	 if(data.perMit==""||data.perMit==null){
            		 perMit="0";
            	 }else{
            		 perMit=data.perMit;
            	 }
            	 
            	 if($("#licResouce").val() !='0'){
            		 $("#allBusines").text(perMItDistinct);
                	 $("#allBusinesNum").text(perMit);
            	 }else{
            		 data.perMItDistinct = 0;
            		 data.perMit = 0;
            		 $("#allBusines,#allBusinesNum").text("0");
            	 }
            	 var t1=data.licence;
            	 var t2=data.perMit;
            	 $("#allNumber").text(t1+t2);
            	 var t3=data.licenceDistinct;
            	 var t4=data.perMItDistinct;
            	 $("#allCount").text(t3+t4);
            	}
          }
       }) 
   }
    

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	var initFlag = '1';
    	var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
        	typeUrl='/syn/server/other/pubohterlicence/searchListJSON';
        }else{
        	typeUrl='/reg/server/other/pubohterlicence/searchListJSON';
        }
        
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
                {data: 'regNO'},
                {data: 'entName'}
                 
              
            ],
            columnDefs: [
  
{
	targets: 1,
    render: function (data, type, row, meta) {
    	 
    		return "<a class='commit js_view'>详情</a>";
    }
},

 {
	targets: 8,
    render: function (data, type, row, meta) {
    	
    	if(row.licState!=null&&row.licState!=""){
    	if(row.licState=="1"){
    		  return "有效"; 
    	  }else{
    		  return "无效";
    	  } 
    	}else{
    		 if(row.pubType!=null&&row.pubType!=""){
    			 if(row.pubType=="1"){
    				 return "有效";
    			 }else if(row.pubType=="2"){
    				 return "无效"; 
    			 }else if(row.pubType=="3"){
    				 return "无效";
    			 }else if(row.pubType=="4"){
    				 return "无效";
    			 }else{
    				 return "有效";
    			 }
    		 }else{
    			 return "";
    		 }
    		
    		 
    	}	
    	  
    	
    	
    }
},{
	targets: 9,
    render: function (data, type, row, meta) {
    	  if(row.pubFlag=="1"){
    		  return "已公示"; 
    	  } else{
    		  return "未公示";
    	  } 
    		 
    }
},{
	targets: 10,
    render: function (data, type, row, meta) {
    	if(row.source!=null&&row.source!=""){
    	  if(row.source.indexOf("部门公示")>0){
    		  return "部门公示"; 
    	  } else{
    		  return "企业公示";
    	  }  
      }else{
    	  return "企业公示";
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
            title: '行政许可详情',
            area: ['628px', '600px'],
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
    el: '.js_view',
    event: 'click',
    handler: function () {
    	var data = table.row($(this).closest('td')).data();
    	var licID=data.licID;
    	var priPID=data.priPID;
    	var type=data.source;
    	if(type!=null&&type!=""){
    	 if(type.indexOf("部门公示")>0){
    	   
    		type="other";
    	}else{
    		type="enterprise";
    	   } 
    	}else{
    		type="enterprise";
    	}
    	 var userType= $("#userType").val(); 
         var typeUrl="";
         if(userType=="2"){
        	 typeUrl='/syn/server/other/pubohterlicence/showDetails?licID='+licID+"&priPID="+priPID+"&type="+type;
         }else{
        	 typeUrl='/reg/server/other/pubohterlicence/showDetails?licID='+licID+"&priPID="+priPID+"&type="+type;
         }
    	
   layer.dialog({
            title: '行政许可详情',
            area: ['1000px', '660px'],
            content:typeUrl,
            callback: function (data) {
                //重新加载列表数据
              /*  if (data.reload) { 
                	alert(JSON.stringify(data));
                	$("#regOrg").val(data.reload.retruncode);
                	$("#regOrgName").val(data.reload.returnname);
                    
                }*/
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
      {
                        el: '.js-batchregist',
                        event: 'click',
                        handler: function () {
                	 var ItemIds = new Array();
                     var index = 0;
                     var trueFlag=true;
                     $(":checkbox[name=_checkbox]:checked").each(function() {
                         ItemIds[index++] = $(this).val();
                         if(!($(this).data("uid")==null||$(this).data("uid").length<1))
                               trueFlag=false;

                     });
                     if(ItemIds.length==0){
                    	  layer.msg("请选择一项进行操作", {ltype: 0,time:500});
                         return false;
                     }
                     if(!trueFlag){
                        layer.msg("只能选择未建档的数据进行建档！", {time:1000});
                     }
                     else{
                   layer.dialog({
                                title: '批量建档',
                                area: ['628px', '500px'],
                                content: '/reg/server/registinfo/registinfo/toShow?fromtype=batch&priPID='+ItemIds,
                                callback: function (data) {
                                    //重新加载列表数据
                                    if (data.reload) {
                                        table.ajax.reload();
                                    }
                                }
                            })
                     }
                 }
              }, {      el: '.js-edit',
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
                     		initCount();
                     	}
                         initCount();
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
