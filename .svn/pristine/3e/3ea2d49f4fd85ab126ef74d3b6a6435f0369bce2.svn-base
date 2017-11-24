require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchParams;//查询参数声明!
	var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/syn/sccheck/pubscentresult/preParelist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            		  {data: "_idx",width:'20px'},
                      {data: null},
                      {data: null},
                      {data: 'checkTableFlag'},
                      {data: 'admissionFlag'},
                      {data: 'regNO'},
                      {data: 'entName',className: 'left'},
                      {data: 'taskCode'},
                      {data: 'taskName',className: 'left'},
                      {data: 'taskEndTime'},
                      {data: 'checkDeptPerson'},
                      {data: "dom",cut: {length: 40,mark:'...'},className: 'left'},
                      {data: 'regOrgName',className: 'left'},
                      {data: 'localAdmName',className: 'left'},
                      {data: 'sliceNOName',className: 'left'},
                      {data: 'setUserName'},
                      {data: 'setTime'}
            ],
            columnDefs: [
            	{
	   		     	targets: 1,
				    render: function (data, type, row, meta) {
				    	return '<input type="radio" taskUid='+row.taskUid+' admissionFlag='+row.admissionFlag+' checkTableFlag='+row.checkTableFlag+' priPID='+row.priPID+' name="_radio" uid='+row.uid+'>';
				    }
   		        },
            	{
 					targets:2,
 					render:function(data,type,row,meta){
 						var ret = "";
 						if(row.auditState == '1'){
// 							if(row.checkTableFlag=='1'&&row.auditState!='1'){
 							ret = "<a href='javascript:void(0)' class='js_check'>汇总表</a>";
 						}else{
 							ret = "<a href='javascript:void(0)' taskUid="+row.taskUid+" uid="+row.uid+" priPID="+row.priPID+" name='js-record' class='js-record'>打印汇总表</a>";
 						}
 						if(row.auditState == '1' || row.admissionFlag != '1'){
// 							if(row.admissionFlag=='1'){
 							ret = ret+"<a href='javascript:void(0)' class='js_admission'>通知书</a>";
 						}else{
 							ret = ret+"<a href='javascript:void(0)' uid="+row.uid+" priPID="+row.priPID+" name='js-checkbook' class='js-checkbook'>打印检查通知书</a>";
 						}
 						return ret;
 					}
 				 },{
 					targets:3,
 					render:function(data,type,row,meta){
 						if(row.checkTableFlag == '0' || row.checkTableFlag == null){
 							return '<span style="color:red;">未设置</span>';
 						}else if(row.checkTableFlag == '1'){
 							return "已设置";
 						}
 					}
 				 },{
 					targets:4,
 					render:function(data,type,row,meta){
 						if(row.admissionFlag == '0' || row.admissionFlag == null){
 							return '<span style="color:red;">未设置</span>';
 						}else if(row.admissionFlag == '1'){
 							return "已设置";
 						}
 					}
 				 },{
 					targets:5,
 					render:function(data,type,row,meta){
 						if(row.uniCode){
 							return row.uniCode;
 						}else{
 							return row.regNO;
 						}
 					}
 				 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    });
    
    function bind() {
        util.bindEvents([
	        {
	            el: '#more',
	            event: 'click',
	            handler: function () { 
	            	var isHideOrShow = $("#hideorshow").is(":hidden");
	            	if(isHideOrShow){
	            		 $("#more").val("收起");
	            		 $("#hideorshow").css("display","block");
	
					}else{
						$("#more").val("更多查询条件");
	            		$("#hideorshow").css("display","none");
					}
	            }
	        },{
	            el: '.js_check',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	                layer.dialog({
	                    title: '',
	                    area: ['95%', '95%'],
	                    content: '/syn/sccheck/pubscentresult/checkpage?taskUid='+data.taskUid+"&priPID="+data.priPID+"&uid="+data.uid,
	                    callback: function (data) {
	                        //重新加载列表数据
	                        if (data.reload) {
	                            table.ajax.reload();
	                        }
	                    }
	                })
	            }
	        },{
	            el: '.js_admission',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	                layer.dialog({
	                    title: '',
	                    area: ['95%', '95%'],
	                    content: '/syn/sccheck/pubscentresult/noticepage?taskUid='+data.taskUid+"&priPID="+data.priPID+"&uid="+data.uid,
	                    callback: function (data) {
	                        //重新加载列表数据
                            table.ajax.reload();
	                    }
	                })
	            }
	        },{
	        	el: '#choseregUnit',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择管辖单位',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regunit/regunitmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                      	$("#localAdm").val(returncode);
	                      	$("#localAdmName").val(data.returnname); 
	                    }
	                })
	            }
	        },{
	            el: '#js-record',
	            event: 'click',
	            handler: function () {
	            	var radio = document.getElementsByName("_radio"); 
	            	var record;
	            	for (i=0; i<radio.length; i++) {  
	                    if (radio[i].checked) {  
	                    	record = document.getElementsByName("_radio")[i];
	                    }  
	                }
	            	if(record==undefined){
	            		layer.msg("必须选择一项进行打印！", {time: 2000}, function() {});
	            	}else{
	            		var checkTableFlag = record.getAttribute('checkTableFlag');
	            		var priPID = record.getAttribute('priPID');
	            		var uid = record.getAttribute('uid');
	            		var taskUid = record.getAttribute('taskUid');
	            		var _id = "_doPrint_"+new Date().getTime();
	            		if(checkTableFlag=='1'){
	            			var url = "/syn/sccheck/pubscentresult/checkprint?taskUid="+taskUid+"&priPID="+priPID+"&uid="+uid;
	            			try{
	            				window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
	            			}catch(e){
	            				alert("打印错误!");
	            			}
	            		}else{
	            			layer.msg("检查表必须已经设置才能打印！", {time: 2000}, function() {});
	            		}
	            	}
	            }
	        },{
	            el: '#js-checkbook',
	            event: 'click',
	            handler: function () {
	            	var radio = document.getElementsByName("_radio"); 
	            	var record;
	            	for (i=0; i<radio.length; i++) {  
	                    if (radio[i].checked) {  
	                    	record = document.getElementsByName("_radio")[i];
	                    }  
	                }
	            	if(record==undefined){
	            		layer.msg("必须选择一项进行打印！", {time: 2000}, function() {});
	            	}else{
	            		var admissionFlag = record.getAttribute('admissionFlag');
	            		var priPID = record.getAttribute('priPID');
	            		var uid = record.getAttribute('uid');
	            		var _id = "_doPrint_"+new Date().getTime();
	            		if(admissionFlag=='1'){
	            			var url = "/syn/sccheck/pubscentresult/noticeprint?resultUid="+uid+"&priPID="+priPID;
	    		            try{
	    		                window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
	    		            }catch(e){
	    		                alert("打印错误!");
	    		            }
	            		}else{
	            			layer.msg("通知书必须已经设置才能打印！", {time: 2000}, function() {});
	            		}
	            	}
	            }
	        },{
	            el: '#js-export',
	            event: 'click',
	            handler: function () {
	            	var radio = document.getElementsByName("_radio"); 
	            	var record;
	            	for (i=0; i<radio.length; i++) {  
	                    if (radio[i].checked) {  
	                    	record = document.getElementsByName("_radio")[i];
	                    }  
	                }
	            	if(record==undefined){
	            		layer.msg("请先选中一项！", {time: 2000}, function() {});
	            	}else{
	            		var checkTableFlag = record.getAttribute('checkTableFlag');
	            		var priPID = record.getAttribute('priPID');
	            		var uid = record.getAttribute('uid');
	            		var taskUid = record.getAttribute('taskUid');
	            		var _id = "_doPrint_"+new Date().getTime();
	            		if(checkTableFlag=='1'){
	            			var url = "/syn/sccheck/pubscentresult/doEnExportExcelView?taskUid="+taskUid+"&priPID="+priPID+"&uid="+uid;
	            			layer.dialog({
	    	                    title: '导出专项检查表',
	    	                    area: ['65%', '95%'],
	    	                    content: url,
	    	                    callback: function (data) {
	    	                    	
	    	                    }
	    	                })
	            		}else{
	            			layer.msg("检查表必须设置后才能导出！", {time: 2000}, function() {});
	            		}
	            	}
	            }
	        },{
	            el: '#js-download',
	            event: 'click',
	            handler: function () {
        			var url = "/syn/sccheck/pubscentresult/doEnDownLoadExcelView?downLoadFlag=1";
        			layer.dialog({
	                    title: '空检查表',
	                    area: ['65%', '95%'],
	                    content: url,
	                    callback: function (data) {
	                    	
	                    }
	                })
	            }
	        },{
	            el: '.js-record',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	            	var priPID = data.priPID;
            		var uid = data.uid;
            		var taskUid = data.taskUid;
            		var _id = "_doPrint_"+new Date().getTime();
        			var url = "/syn/sccheck/pubscentresult/checkprint?taskUid="+taskUid+"&priPID="+priPID+"&uid="+uid;
        			try{
        				window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
        			}catch(e){
        				alert("打印错误!");
        			}
	            }
	        },{
	            el: '.js-checkbook',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	            	var priPID = data.priPID;
            		var uid = data.uid;
	            	var _id = "_doPrint_"+new Date().getTime();
		            var url = "/syn/sccheck/pubscentresult/noticeprint?resultUid="+uid+"&priPID="+priPID;
		            try{
		                window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
		            }catch(e){
		                alert("打印错误!");
		            }
	            }
	        },{
	            el: '#cancel',
	            event: 'click',
	            handler: function () { 
	            	$("#regOrg").val("");
	            	$("#localAdm").val("");
	            	$("#sliceNo").val("");
	            }
	        }, {
	        	el: '#choseorgReg',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择登记机关',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regorg/regorgmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#regOrg").val(returncode);
	                    	$("#regOrgName").val(data.returnname);  
	                    }
	                })
	            }
	        }, {
	        	el: '#chooseSliceNo',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择片区',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/sliceno/slicenomutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#sliceNo").val(returncode);
	                    	$("#sliceNoName").val(data.returnname);  
	                    }
	                })
	            }
	        }
        ])
    }
})
