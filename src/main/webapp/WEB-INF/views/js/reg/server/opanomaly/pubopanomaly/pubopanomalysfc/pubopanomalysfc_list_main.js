require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

  
    var table;
	var $searchForm=$("#searchForm");
  	 
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
       }
    var params = {};//查询参数
    
    
  //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startCogDate', //选择ID为START的input
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
        elem: '#endCogDate',
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
    
    var startNorDate = {
            elem: '#startNorDate', //选择ID为START的input
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
            elem: '#endNorDate',
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
        
        
        var startExtDate = {
                elem: '#startExtDate', //选择ID为START的input
                format: 'YYYY-MM-DD', //自动生成的时间格式
                min: '1970-01-01', //设定最小日期为当前日期
                max: '2099-06-16', //最大日期
                istime: true, //必须填入时间
                istoday: false,  //是否是当天
                start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
                choose: function(datas){
                endExtDate.min = datas; //开始日选好后，重置结束日的最小日期
                endExtDate.start = datas //将结束日的初始值设定为开始日
                }
            };
	     var endExtDate = {
	         elem: '#endExtDate',
	         format: 'YYYY-MM-DD',
	         min: '1970-01-01',
	         max: '2099-06-16',
	         istime: true,
	         istoday: false,
	         startExtDate: laydate.now(0,"YYYY-MM-DD"),
	         choose: function(datas){
	         startExtDate.max = datas; //结束日选好后，重置开始日的最大日期
	         }
	     };
    
    //开始时间和结束时间
    $("#startCogDate").click(function(){laydate(start);});
    $("#endCogDate").click(function(){laydate(end);}); 

    $("#startNorDate").click(function(){laydate(startNorDate);});
    $("#endNorDate").click(function(){laydate(endNorDate);});
    
    $("#startExtDate").click(function(){laydate(startExtDate);});
    $("#endExtDate").click(function(){laydate(endExtDate);});
    
    
    //加载表格列表
    function initDataTable(){
    	table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: "#ent_table",
            scrollX: true,
            ajax : {
                type : "POST",
                url :  '/reg/server/opanomaly/pubopanomaly/pubOpanoMalySfcListJSON.json',
                data : function(d) {
                	d.params = $searchForm.serializeObject();
                }
            },
            showIndex: true,
            columns: [
              	    {data: null,'defaultContent':'11'}, 
                  	{data: null, width:"250px",defaultContent:'id'  },
                  	{data: 'uniSCID',cut: {length: 20,mark:'...'}},
//    				{data: 'regNO',cut: {length: 20,mark:'...'}},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
//    				{data: 'leRep',cut: {length: 20,mark:'...'}},
//    				{data: 'estDate',cut: {length: 20,mark:'...'}},
    				{data: 'auditState',cut: {length: 20,mark:'...'}},
    				{data: 'penDecNo',cut: {length: 20,mark:'...'}},
    				{data: 'speCauseCN',cut: {length: 20,mark:'...'}},
     				{data: 'abnTime',cut: {length: 20,mark:'...'}},
    				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
    				{data: 'firstName',cut: {length: 20,mark:'...'}},
    				{data: 'firstdate',cut: {length: 20,mark:'...'}},
    				{data: 'auditName',cut: {length: 20,mark:'...'}},
    				{data: 'auditDate',cut: {length: 20,mark:'...'}},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}}
              	
            ],
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 var auditState= row.auditState;
                            	  if("0"==auditState){
                            		  return   '<a href="javascript:void(0);" id="'+row.busExcList+'"  priPID="'+row.priPID+'" year="'+row.year+'" class="moddifty">修改</a>'+
  							    	'&nbsp<a href="javascript:void(0);" id="'+row.busExcList+'" pripid="'+row.priPID+'" year="'+row.year+'" class="del">删除</a>';
                              	  }else if("1"==auditState){ 
                              		 return   '<a href="javascript:void(0);" id="'+row.busExcList+'"  priPID="'+row.priPID+'" year="'+row.year+'" class="view">查看</a>'+
   							    	'&nbsp<a href="javascript:void(0);" id="'+row.busExcList+'" pripid="'+row.priPID+'" year="'+row.year+'" class="printsptable">打印审批表</a>'+
   							    	'&nbsp<a href="javascript:void(0);" id="'+row.busExcList+'" pripid="'+row.priPID+'" year="'+row.year+'" class="printspbook">打印决定书</a>'; 
                            	  }else{
                            		  return   '<a href="javascript:void(0);" id="'+row.busExcList+'"  priPID="'+row.priPID+'" year="'+row.year+'" class="view">查看</a>'+
     							    	'&nbsp<a href="javascript:void(0);" id="'+row.busExcList+'" pripid="'+row.priPID+'" year="'+row.year+'" class="printsptable">打印审批表</a>'; 
                              	  }
                             }
                       },
                       {
                           targets: 4,
                           render: function (data, type, row, meta) {
                          	  if("0"==data){ 
                          		  return "待审核";
                          	  }else if("1"==data){ 
                          		  return "予以列入";
                          	  }else if("2"==data){ 
                          		  return "不予列入";
                          	  }else{
                          		  return "";
                          	  }
                           }
                     },
                     {
                         targets: 2,
                         render: function (data, type, row, meta) {
                        	  if(data == null || data == ""){ 
                        		  return row.regNO;
                        	  }else{
                        		  return data;
                        	  }
                         }
                   }
            ]
        })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
     	params=$searchForm.serializeObject();
     	table.ajax.reload();
    });
    $("#rest").click(function() {
    	$searchForm[0].reset(); 
	});
    
    

    function bind() {
        util.bindEvents([{
            el: '#showpubOpanoMalySfcList',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/opanomaly/pubopanomaly/pubOpanoMalySfcapplyList';
            }
        },{
            el: '#rest',
            event: 'click',
            handler: function () {
            	$("#regOrg").val(window._CONFIG._regOrg); 
            	$("#localAdm").val("");
            	$("#speCause").val("");
             }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '经营异常名录设置 - 查看',
                    area: ['80%', '88%'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAuditEdit?busExcList='+busExcList+"&viewFlag=1",
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.moddifty',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '修改经营异常名录',
                    area: ['80%', '73%'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAddSign?busExcList='+busExcList,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.del',
            event: 'click',
            handler: function () { 
            	var busExcListId=this.id;
            	var data = table.row($(this).closest('td')).data();
            	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: '/reg/server/opanomaly/pubopanomaly/deletePubOpanoMaly',
	                    data: {busExcList: busExcListId,priPID:data.priPID},
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
            el: '.printsptable',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	 var _id = "_doPrint_"+new Date().getTime();
                 var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoMalyPrintspTable?busExcList="+busExcList;
                 try{
                     window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                 }catch(e){
                     alert("打印错误!");
                 }
            	
            	/*layer.dialog({
                    title: '打印审批表',
                    area: ['1024px', '500px'],
                    content: '/reg/server/yr/pubopanomaly/pubOpanoMalyPrintspTable?busExcList='+busExcList,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                }) */
            }
        },{
            el: '.printspbook',
            event: 'click',
            handler: function () {
             	var busExcList=this.id;
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+busExcList;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择登记机关',
                    area: ['25%', '60%'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) {
                   	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
                    }
                })
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择管辖单位',
                    area: ['25%', '60%'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;	 
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(returnname);
                    }
                })
            }
        }, {
            el: '#select-intercept_in',
            event: 'click',
            handler: function () {
//            	var codeList;
//            	var entType = $("input[type ='radio']:checked").val();
//            	if(entType == '01'){
//            		codeList = 'inCodeForEntList';
//            	}else if(entType == '02'){
//            		codeList = 'inCodeForSfcList';
//            	}else if(entType == '03'){
//            		codeList = 'inCodeForPbList';
//            	}
                layer.dialog({
                    title: '列入原因',
                    area: ['600px', '350px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=+inCodeForSfcList',
                    callback: function (data) {
                        if(data){
                            $("#speCause").val(data.id);
                            $("#speCauseText").val(data.text);
                        }
                    }
                })   	
//            	layer.dialog({
//                    title: '列入原因',
//                    area: ['600px', '350px'],
//                    content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
//                    callback: function (data) {
//                        if(data){
//                            $("#speCause").val(data.id);
//                            $("#speCauseText").val(data.text);
//                        }
//                    }
//                })
            }
        }
        ]);
    }

})
