require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
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
        
        var startSetDate = {
                elem: '#startSetDate', //选择ID为START的input
                format: 'YYYY-MM-DD', //自动生成的时间格式
                min: '1970-01-01', //设定最小日期为当前日期
                max: '2099-06-16', //最大日期
                istime: true, //必须填入时间
                istoday: false,  //是否是当天
                start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
                choose: function(datas){
                	endSetDate.min = datas; //开始日选好后，重置结束日的最小日期
                	endSetDate.start = datas //将结束日的初始值设定为开始日
                }
            };
            var endSetDate = {
                elem: '#endSetDate',
                format: 'YYYY-MM-DD',
                min: '1970-01-01',
                max: '2099-06-16',
                istime: true,
                istoday: false,
                startNorDate: laydate.now(0,"YYYY-MM-DD"),
                choose: function(datas){
                	startSetDate.max = datas; //结束日选好后，重置开始日的最大日期
                }
            }; 
    
    
    $("#startInfaustlDate").click(function(){laydate(startNorDate);});
    $("#endInfaustlDate").click(function(){laydate(endNorDate);});
    $("#startSetDate").click(function(){laydate(startSetDate);});
    $("#endSetDate").click(function(){laydate(endSetDate);});
    
    
    
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
     	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:_sysUrl+'/sccheck/pubscworkplan/selectPubScWorkPlanJSON.json',
                data:function(d){ 
                	d.params = searchParams;
                }
            },
            columns: [ 
					{data: null,'defaultContent':'11'},
					{data: null,width:"100px"},
					{data: 'planYear'}, 
					{data: 'planCode',cut: {length: 20,mark:'...'}},
					{data: 'planName',cut: {length: 20,mark:'...'}},
					{data: 'crossDepartFlag'},
					{data: null},
					{data: null},
					{data: 'planType'},
					{data: 'entNum'},
					{data: 'planStartTime'},
					{data: 'planEndTime'},
					{data: 'planRange',cut: {length: 20,mark:'...'}},
					{data: 'planLeadDeptName',cut: {length: 20,mark:'...'}},
					{data: 'setDeptName'},
					{data: 'setUserName'},
					{data: 'setTime'}
    				
            ] ,
            columnDefs: [
                          {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 
                            	 var planState=row.planState;
                            	 if("01"==planState){
                            		 return  '<a class="editdata link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">修改</a>'+
                              	    '<a class="delete link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">删除</a>'; 
	                           	 }else if("02"==planState||"03"==planState){
	                           		 return '<a class="view link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">详情</a>'; 
	                           	 }
                             }
                          },{
                              targets: 5,
                              render: function (data, type, row, meta) { 
                             	 if("1"==data){
                             		return "本部门";
                             	 }else if("2"==data){
                             		return "跨部门";
                             	 }else {
                             		return "-";
                             	 } 
                              }
                           },{
                               targets: 6,
                               render: function (data, type, row, meta) {
                              	 if("01"==row.planState){
                              			return '<span style="color:red">待执行</span>'; 
                              	 }else if("02"==row.planState){
                              		 return '执行中';
                              	 }else if("03"==row.planState){
                              		 return "已完成";
                              	 }else {
                              		 return "";
                              	 } 
                               }
                            },{
                                targets: 7,
                                render: function (data, type, row, meta) {
                               	 if("01"==row.planState){
                               			return '未公告'; 
                               	 }else{
                               		 return "已公告";
                               	 } 
                                }
                             },{
                                 targets: 8,
                                 render: function (data, type, row, meta) { 
                                	 if("1"==data){
                                		return "定向";
                                	 }else if("2"==data){
                                		return "不定向";
                                	 }else {
                                		return "";
                                	 } 
                                 }
                              },{
                                  targets: 9,
                                  render: function (data, type, row, meta) { 
                                 	 if("01"==row.planState){
                                 		return "";
                                 	 }else{
                                 		return data;
                                 	 } 
                                  }
                               }
            ],
            "fnDrawCallback": function (oSettings) {
            	http.httpRequest({ 
                    url: _sysUrl+'/sccheck/pubscworkplan/planCount',
                    serializable: false,
                    type:'post',
                    data: {params:searchParams} ,
                    success: function (data) {
                    	var pubScWorkPlanDto = data.data;
                        if (data.status == 'success') {  
    						$("#totalWork").text(pubScWorkPlanDto.totalWork == null?0:pubScWorkPlanDto.totalWork);
    						$("#ownNum").text(pubScWorkPlanDto.ownNum == null?0:pubScWorkPlanDto.ownNum);
    						$("#crossNum").text(pubScWorkPlanDto.crossNum == null?0:pubScWorkPlanDto.crossNum);
    						$("#entNum").text(pubScWorkPlanDto.entNum == null?0:pubScWorkPlanDto.entNum);
                        }else{
                        	$("#totalWork").text("0");
    						$("#ownNum").text("0");
    						$("#crossNum").text("0");
    						$("#entNum").text("0");
                        } 
                    }
                });
            }
         })
    } 
     
    
    function bind() {
        util.bindEvents([
      {
            el: '.editdata',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
           	 	var uid=data.uid;
            	layer.dialog({
                    title: '修改抽查工作计划',
                    area: ['80%', '80%'],
                    content:_sysUrl+'/sccheck/pubscworkplan/addOrEditView?flag=2&uid='+uid,
                    callback: function(data) {
                    	if(typeof data.status!="undefined"){
                      		 if(data.status=="success"){ 
                          		 layer.msg("修改成功", {time: 2000}, function () {
                          			        table.ajax.reload(); 
                                    });
                          	 } 
                      	 }
                    }
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
                    title: '查看抽查工作计划详情',
                    area: ['80%', '80%'],
                    content:_sysUrl+'/sccheck/pubscworkplan/addOrEditView?flag=3&uid='+uid,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },
        {
            el: '#add',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '添加抽查工作计划',
                    area: ['80%', '80%'],
                    content:_sysUrl+'/sccheck/pubscworkplan/addOrEditView?flag=1',
                    callback: function(data) {
                    	if(typeof data.status!="undefined"){
                      		 if(data.status=="success"){ 
                          		 layer.msg("添加成功", {time: 2000}, function () {
                          			        table.ajax.reload(); 
                                    });
                          	 } 
                      	 }
                    }
                })
            }
        },
        {
        	el: '#search',
            event: 'click',
            handler: function () { 
             	$("#searchFlag").val("1");
            	searchParams = $("#taskForm").serializeObject();
            	table.ajax.reload();
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
	                    url: _sysUrl+'/sccheck/pubscworkplan/delete.json',
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
        },{
            el: '#more',
            event: 'click',
            handler: function () { 
            	var isHideOrShow = $("#hideorshow").is(":hidden");
            	if(isHideOrShow){
            		 $("#more").val("收起");
            		 $("#hideorshow").css("display","block");
					//$("#hideorshow").toggle();

				}else{
					$("#more").val("更多查询条件");
            		$("#hideorshow").css("display","none");
				}
            }
        }]);
    }

})
