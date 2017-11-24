require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
        bind();
    }
    
    $("#checkResultM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 20
	});
    $('#checkResultM').multipleSelect('checkAll');
    
    $("#taskSourceM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 20
	});
    $('#taskSourceM').multipleSelect('checkAll');
    
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/dailycheck/dailyinspectresult/querylistjson.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            	{data: "_idx",width:'20px'},
                {data: null},
                {data: 'disposeState'},
                {data: 'cidRegNO'},
                {data: 'checkObj',className: 'left'},
                {data: 'taskSource'},
                {data: 'checkDate'},
                {data: 'checkResult',className: 'left'},
                {data: 'checkDeptPerson'},
                {data: "checkDeptName"},
                {data: 'regOrgName',className: 'left'},
                {data: 'localAdmName',className: 'left'},
                {data: 'sliceNOName',className: 'left'},
                {data: 'enterUserName'},
                {data: 'enterDate'},
                {data: 'alterUserName'},
                {data: 'alterDate'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
 						return "<a href='javascript:void(0)' class='js_alter'>修改</a> <a href='javascript:void(0)' class='js_detail'>详情</a>";
 					}
 				 },{
 					targets:5,
 					render:function(data,type,row,meta){
 						if(row.taskSource=='1'){
 							return "交办转办";
 						}else if(row.taskSource=='2'){
 							return "投诉举报";
 						}else if(row.taskSource=='3'){
 							return "日常巡查";
 						}else if(row.taskSource=='4'){
 							return "数据监测";
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:2,
 					render:function(data,type,row,meta){
 						if(row.disposeState=='1'){
 							return "未完结";
 						}else if(row.disposeState=='2'){
 							return "已完结";
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:7,
 					render:function(data,type,row,meta){
 						var checkResult = row.checkResult;
 						if(checkResult==""||checkResult==null){
 							return "";
 						}
 						var checkResults=checkResult.split(",");
 						var redultCN="";
 						for(var i=0;i<checkResults.length;i++){
 							if(checkResults[i]=='1'){
 								redultCN=redultCN+"未发现违法行为;";
 							}else if(checkResults[i]=='2'){
 								redultCN=redultCN+"违反工商行政管理相关规定;";
 							}else if(checkResults[i]=='3'){
 								redultCN=redultCN+"违反食品药品管理相关规定;";
 							}else if(checkResults[i]=='4'){
 								redultCN=redultCN+"违反质量技术监督相关规定;";
 							}else if(checkResults[i]=='5'){
 								redultCN=redultCN+"违反其他部门相关规定;";
 							}else if(checkResults[i]=='6'){
 								redultCN=redultCN+"查无下落 ;";
 							}else if(checkResults[i]=='7'){
 								redultCN=redultCN+"已关闭停业或正在组织清算;";
 							}else if(checkResults[i]=='8'){
 								redultCN=redultCN+"不予配合情节严重;";
 							}else if(checkResults[i]=='9'){
 								redultCN=redultCN+"注销;";
 							}else if(checkResults[i]=='10'){
 								redultCN=redultCN+"被吊销 ;";
 							}else if(checkResults[i]=='11'){
 								redultCN=redultCN+"被撤销;";
 							}else if(checkResults[i]=='12'){
 								redultCN=redultCN+"迁出;";
 							}else if(checkResults[i]=='A'){
 								redultCN=redultCN+"发现问题待后续处理;";
 							}else if(checkResults[i]=='B'){
 								redultCN=redultCN+"未按规定公示应当公示的信息;";
 							}else if(checkResults[i]=='C'){
 								redultCN=redultCN+"公示信息隐瞒真实情况弄虚作假;";
 							}else if(checkResults[i]=='D'){
 								redultCN=redultCN+"违反其他工商行政管理规定行为;";
 							}else if(checkResults[i]=='E'){
 								redultCN=redultCN+"发现问题经责令已改正;";
 							}else if(checkResults[i]=='F'){
 								redultCN=redultCN+"未发现开展本次抽查涉及的经营活动;";
 							}else{
 								redultCN=redultCN+";";
 							}
 						}
 						if(redultCN!=""&&redultCN.length>20){
 							return "<span title='"+redultCN+"'>"+redultCN.substring(0,20)+"...</span>";
 						}else{
 							return redultCN;
 						}
 					}
 				 }
             ],
            "fnDrawCallback": function (oSettings) {
            	http.httpRequest({ 
                    url: '/reg/dailycheck/dailyinspectresult/dailyInspectResultQueryCount',
                    serializable: false,
                    type:'post',
                    data: {params:searchParams} ,
                    success: function (data) {
                    	var list = data.data;
                        if (data.status == 'success') {  
    						$("#alreadyinput").text(list[1]);
    						$("#notover").text(list[2]);
    						$("#alreadyover").text(list[3]);
                        }else{
    						$("#alreadyinput").text("0");
    						$("#notover").text("0");
    						$("#alreadyover").text("0");
                        } 
                    }
                });
            }
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	var checkResultM = $("#checkResultM").val();
		$("#checkResult").val(checkResultM);
		var taskSourceM = $("#taskSourceM").val();
		$("#taskSource").val(taskSourceM);
    	searchParams = $("#taskForm").serializeObject();
		table.ajax.reload();
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
	            el: '.js_alter',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	                layer.dialog({
	                    title: '',
	                    area: ['95%', '95%'],
	                    content: '/reg/dailycheck/dailyinspectresult/altercheckobj?uid='+data.uid,
	                    callback: function (data) {
	                        //重新加载列表数据
	                        if (data.reload) {
	                            table.ajax.reload();
	                        }
	                    }
	                })
	            }
	        },{
	            el: '.js_detail',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	                layer.dialog({
	                    title: '',
	                    area: ['95%', '95%'],
	                    content: '/reg/dailycheck/dailyinspectresult/detailcheckobj?uid='+data.uid,
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
	            el: '#cancel',
	            event: 'click',
	            handler: function () { 
	            	$("#regOrg").val("");
	            	$("#localAdm").val("");
	            	$("#sliceNo").val("");
	            	$('#checkResultM').multipleSelect('checkAll');
	            	$('#taskSourceM').multipleSelect('checkAll');
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
	        },{
	        	el: '#js-add',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '添加检查对象',
	                    area: ['50%', '400px'],
	                    content: '/reg/dailycheck/dailyinspectresult/addcheckobj',
	                    callback: function (data) { 
	                    	if (data.reload) {
	                            table.ajax.reload();
	                        }
	                    }
	                })
	            }
	        }
        ])
    }
})
