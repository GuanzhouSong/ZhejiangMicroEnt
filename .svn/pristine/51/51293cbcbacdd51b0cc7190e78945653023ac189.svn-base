require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
   //警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
  
    init();
  
    
    var startNorDate = {
            elem: '#startInfaustlDate', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
            	endNorDate.min = datas; //开始日选好后，重置结束日的最小日期
            	endNorDate.start = datas //将结束日的初始值设定为开始日
            }
        };
        var endNorDate = {
            elem: '#endInfaustlDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            startNorDate: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            	startNorDate.max = datas; //结束日选好后，重置开始日的最大日期
            }
        }; 
    
    
    $("#startInfaustlDate").click(function(){laydate(startNorDate);});
    $("#endInfaustlDate").click(function(){laydate(endNorDate);});
    
    
    
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
                url:_sysUrl+'/sccheck/scplantask/selectPubScPlanTaskJSON.json',
                data:function(d){ 
                	d.params = searchParams;
                }
            },
            columns: [ 
					{data: '_idx','defaultContent':'11'},
					{data: null,width:"100px"},
					{data: 'taskCode',cut: {length: 20,mark:'...'}},
					{data: 'taskName',cut: {length: 20,mark:'...'}},
					{data: 'taskState'},
					{data: 'taskObject',cut: {length: 20,mark:'...'}},
					{data: 'randomTotal'},
					{data: 'taskType',cut: {length: 20,mark:'...'}},
					{data: 'taskStartTime',cut: {length: 20,mark:'...'}},
					{data: 'taskEndTime',cut: {length: 20,mark:'...'}},
					{data: 'taskLeadDeptName'},
					{data: 'setUserName'},
					{data: 'setTime'}
    				
            ] ,
            columnDefs: [
                          {
                             targets: 1,
                             render: function (data, type, row, meta) { 
                            	 var taskState=row.taskState;
                            	 if("02"==taskState || "03"==taskState){
                            		 return '<a class="view link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">详情</a>'; 
	                           	 }else if("01"==taskState){
	                           		 return  '<a class="editdata link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">抽取名单</a>'; 
	                           	 }
                             }
                          } ,
                          {
                              targets: 7,
                              render: function (data, type, row, meta) { 
                             	 if("1"==data){
                             		return "定向";
                             	 }else if("2"==data){
                             		return "不定向";
                             	 }else {
                             		return "";
                             	 } 
                              }
                           } ,
                           {
                               targets: 5,
                               render: function (data, type, row, meta) { 
                            	   var conStr="";
                              	   if(data!=null&&data!=""&&typeof data!="undefined"){
                              		    var dataArr=$.trim(data).split(",");
                              		    if(dataArr.length>0){
                              		    	for(var i=0;i<dataArr.length;i++){
                              		    		if("1"==dataArr[i]){
                              		    			conStr+="企业"+"、";
                              		    		}else if("2"==dataArr[i]){
                              		    			conStr+="农专社"+"、";
                              		    		}else if("3"==dataArr[i]){
                              		    			conStr+="个体户"+"、";
                              		    		}else if("4"==dataArr[i]){
                              		    			conStr+="外企代表机构"+"、";
                              		    		}
                              		    	}
                              		    	if(conStr!=""){
                          		    			conStr=conStr.substring(0,conStr.length-1);
                          		    		}
                              		    }
                              	   }
                              	   return conStr;
                               }
                            } ,
                           {
                               targets: 4,
                               render: function (data, type, row, meta) {
                            	   if("01"==data){
                              			return "待抽取"; 
	                              	 }else if("02"==data){
	                              		 return "已抽取";
	                              	 }else if("03"==data){
	                              		 return "已完成";
	                              	 }else {
	                              		 return "";
	                              	 } 
                               }
                            },
                            {
                                targets: 6,
                                render: function (data, type, row, meta) {
                                	if("01" == row.taskState){
                              			return ""; 
	                              	 }else{
	                              		 return data;
	                              	 }
                                }
                             }
            ]
         })
    } 
     
    
    function bind() {
        util.bindEvents([
      {
            el: '.editdata',
            event: 'click',
            handler: function () { 
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entback/randompage';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entback/randompage';
            	}
            	var data = table.row($(this).closest('td')).data();
           	 	var uid=data.uid;
            	layer.dialog({
                    title: '抽取名单',
                    area: ['100%', '100%'],
                    content:url+'?taskUid='+uid,
                    callback: function(data) {
                    	if(data.reload){
                    		table.ajax.reload(); 
                    	}
                    }
                })
            }
        },
        {
            el: '.view',
            event: 'click',
            handler: function () { 
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entback/viewrandompage';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entback/viewrandompage';
            	}
            	var data = table.row($(this).closest('td')).data();
           	 	var uid=data.uid;
            	layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content:url+'?taskUid='+uid,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },{
        	el: '#search',
            event: 'click',
            handler: function () { 
            	
            	var ivalStr="";
            	$(":checkbox[name=taskObjectStr]:checked").each(function(k,v){
                	ivalStr+=this.value+",";
                });
            	$("#taskObject").val(ivalStr);
            	searchParams = $("#taskForm").serializeObject();
             	if(searchFlag=="0"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        }]);
    }

})
