require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    $("#checkResultM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 20
	});
    
    $('#checkResultM').multipleSelect('checkAll');
    
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
                url : window._CONFIG.chooseUrl + '/server/specialrec/result/assign.json',
                data:function(d){
                	d.params = searchParams;
                }
            }, 
            columns: [
            		  {data: "_idx",width:'20px'},
            		  {data: null,width:'20px'},
            		  {data: null},
            		  {data: 'entName'},
            		  {data: 'dom',className: 'left',cut: {length: 20,mark:'...'}},
                      {data: 'checkDeptName',className: 'left'},
                      {data: 'regOrgName',className: 'left'},
                      {data: 'localAdmName',className: 'left'},
                      {data: 'taskCode'},
                      {data: 'taskName',className: 'left'},
                      {data: 'orgDeptName'},
                      {data: 'assignName'},
                      {data: 'assignDate'}
            ],
            columnDefs: [{
 					targets:1,
 					render:function(data,type,row,meta){
 						return '<input type="checkbox" class="appointent" taskCode="'+row.taskCode+'" value="'+row.uid+'">';
 					}
 				 },{
 					targets:2,
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
    	var entTypeCatg = "";
    	var flag = false;
    	$(".entCatg").each(function(){
    		if($(this).prop("checked")){
    			if(entTypeCatg == ""){
    				entTypeCatg = $(this).val();
    			}else{
    				entTypeCatg += ","+$(this).val();
    			}
    		}else{
    			flag = true;
    		}
    	});
    	if(flag){
    		$("#entTypeCatg").val(entTypeCatg);
    	}else{
    		$("#entTypeCatg").val("");
    	}
    	searchParams = $("#taskForm").serializeObject();
    	if(table == null){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
		$("#checkall").prop("checked",false);
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
	            	$("#entTypeCatg").val("");
	            	$("#unitDeptCodes").val("");
	            	$("#checkDep").val();
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
	        	el: '#checkall',
	            event: 'click',
	            handler: function () { 
	            	if($(this).prop("checked")){
	            		$(".appointent").prop("checked",true);
	            	}else{
	            		$(".appointent").prop("checked",false);
	            	}
	            }
	        }, {
	        	el: '#js-appoint',
	            event: 'click',
	            handler: function () { 
	            	var uids = '';
	            	var taskCode = '';
	            	var taskCodeM = '';
	            	var flag = true;
	            	$(".appointent").each(function(){
	            		if($(this).prop("checked")){
	            			if(uids == ''){
	            				uids = $(this).val();
	            			}else{
	            				uids += ","+$(this).val();
	            			}
	            			if(taskCode == ''){
	            				taskCode = $(this).attr("taskCode");
	            			}else{
	            				taskCodeM = $(this).attr("taskCode");
	            				if(taskCode != taskCodeM){
	            					flag = false;
	            				}
	            			}
	            		}
	            	});
	            	if(uids==""){
	            		layer.msg("请先选择一条记录", {time: 2000}, function() {});
	            		return false;
	            	}
	            	if(!flag){
	            		layer.msg("批量指派的名单必须为同一任务内名单", {time: 2000}, function() {});
	            		return false;
	            	}
	            	layer.dialog({
	                    title: '抽查任务指派名单',
	                    area: ['40%', '30%'],
	                    content:window._CONFIG.chooseUrl+'/server/specialrec/result/appointpage?uids='+uids,
	                    callback: function (data) {
	                        //重新加载列表数据
	                        if (data.reload) {
	                            table.ajax.reload();
	                        }
	                    }
	                })
	            }
	        },{
	            el: '#choseregUnitDept',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择检查部门',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regunit/regunitsingnewselect?isPermissionCheck=true',
	                    callback: function (data) { 
	                		var returncode=data.codes;
	                      	$("#unitDeptCodes").val(returncode);
	                      	$("#unitDeptNames").val(data.names); 
	                    }
	                })
	            }
	        },{
	            el: '#selectDept', //审批部门
	            event: 'click',
	            handler: function () { 
	            	layer.dialog({
	                    title: '选择部门',
	                    area: ['400px', '600px'],
	                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
	                    callback: function (data) {
	                    	$("#checkDep").val(data.orgCodesExcParent);
	                    	$("#checkDepName").val(data.orgNamesExcParent);
	                   }
	                })
	            }
	        }
        ])
    }
})
