require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	init();
	
	$("#auditState").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
	
    /**
	 * 初始化函数集合
	 */
    function init() { 
//    	initDataTable();
    	bind();
    }
    
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#agent-table',
            showIndex: true,
            scrollX:true, //支持滚动
            aLengthMenu: [10, 25, 50, 100,1000,2000],
			bScrollInfinite:true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/searchListJSON',
                data:function(d){
	               	d.params = $("#chooseagentform").serializeObject();
                }
            },
            columns: [
                {data: "_idx"},
                {data: "taskCode"}, 
                {data: "taskName"},
                {data: null},
                {data: null},
                {data: "entName"}, 
                {data: "randomDate"},
                {data: "checkDeptPerson"},
                {data: "expertNames"},
                {data: "estDate"},
                {data: "lerep"},
                {data: "mobTel"},
                {data: "liaName"},
                {data: "tel"},
                {data: "entTypeCatgDesc"},//企业类型
                {data: "industryCoDesc"},//行业类型
                {data: "opScope"},
                {data: "dom"},
                {data: "checkDeptName"},
                {data: "deptOrgName"},
                {data: "regOrgName"},
                {data: "localAdmName"},
                {data: "sliceNOName"}
            ],
            columnDefs: [{
            	targets:3,
    	        render:function(data,type,row,meta){
    	        	if(data.deptState == "1"){
    	        		return "待抽取人员";
    	        	}else{
    	        		if(data.auditState == "1"){
    	        			return "待录入结果";
    	        		}else if(data.auditState == "2"){
    	        			return "待审核结果";
    	        		}else if(data.auditState == "4"){
    	        			return "结果审核退回";
    	        		}else if(data.auditState == "5"){
    	        			return "已公示结果";
    	        		}else{
    	        			return "-";
    	        		}
    	        	}
//    	        	if(row.teamLeader && row.teamLeader != "null"){
//    	        		return row.teamLeader;
//    	        	}else{
//    	        		return "-";
//    	        	}
    	       }
	        },{
            	targets:4,
    	        render:function(data,type,row,meta){
    	        	if(row.uniCode&&row.uniCode != "null"){
						return row.uniCode;
					}else{
						return row.regNO;
					}
    	        	
    	       }
	        }
//	        ,{
//	        	targets:5,
//	        	render:function(data,type,row,meta){
//	        		if(row.expertNames && row.expertNames != "null"){
//    	        		return row.expertNames;
//    	        	}else{
//    	        		return "-";
//    	        	}
//	        	}
//        	},{
//	        	targets:7,
//	        	render:function(data,type,row,meta){
//	        		if(data.auditState == "1"){
//    	        		return "待录入";
//    	        	}else if(data.auditState == "2"){
//    	        		return "待审核";
//    	        	}else if(data.auditState == "4"){
//    	        		return "审核不通过";
//    	        	}else if(data.auditState == "5"){
//    	        		return "已公示";
//    	        	}else{
//    	        		return "-";
//    	        	}
//	        	}
//	          }
           ]
        });
    }
    
    $("#search").click(function(){
    	var taskUid = $("#taskUid").val();
    	var auditState = $("#auditState").next("div").find("span").html();
    	if(auditState != "全部"){
    		var auditStateValue = $("#auditState").val();
    		var deptStates = "";
			if(auditStateValue == "R"){
				deptStates = "1";
				$("#auditStates").val("");
			}else{
				$("#auditStates").val(auditStateValue);
			}
    		$("#deptStates").val(deptStates);
    	}else{
    		$("#auditStates").val("");
    		$("#deptStates").val("");
    	}
    	if(taskUid == "" || taskUid == null || taskUid == undefined || taskUid == "undefined"){
    		layer.tips("请选择抽查任务",$("#taskUid"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}else{
    		if(table == null){
    			initDataTable();
    		}else{
    			table.ajax.reload();
    		}
    	}
    }); 
    
    function bind() {
        util.bindEvents([{
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
        	el: '#choseDeptUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽查部门',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                      	$("#unitDeptCodes").val(returncode);
                      	$("#unitDeptNames").val(data.returnname); 
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
                 $("#entType").val("");
                 $("#industryCo").val("");
                 $("#unitDeptCodes").val("");
                 $('#auditState').multipleSelect('setSelects',['']);
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
        	el: '#chosedeptReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '抽查机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#deptCodeArr").val(returncode);
                    	$("#deptCodeName").val(data.returnname);  
                    }
                })
            }
        }, {
            el: '#selectIndustry',
            event: 'click',
            handler: function () {
            	 layer.dialog({
                     title: '选择行业',
                     area: ['400px', '600px'],
                     content: '/commom/server/industry/toIndustryPhyTree',
                     callback: function (data) {
                         $("#industryCo").val('');
                         $("#industryName").val('');
                         $("#industryCo").val(data.returncodes);
                         $("#industryName").val(data.returnname);
                     }
                 })
            }//行业树
        }, {
            el: '#chooseEntType',
            event: 'click',
            handler: function () {
                var categCode = new Array();
                $(":checkbox[name=entCatg]:checked").each(function (k, v) {
                    categCode[k] = this.value;
                });
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselectCom?type=' + categCode,
                    callback: function (data) {
                        var returncode = data.returncode;
                        if (returncode != null && returncode != "") {
                            returncode = returncode.substr(0, returncode.length - 1);
                        }
                        $("#entType").val(returncode);
                        $("#entTypeName").val(data.returnname);
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
                        var returncode = data.returncode;
                        if (returncode != null && returncode != "") {
                            returncode = returncode.substr(0, returncode.length - 1);
                        }
                        $("#sliceNo").val(returncode);
                        $("#sliceNoName").val(data.returnname);
                    }
                })
            }
        },{
        	el:'#year',
        	event:'change',
        	handler:function (){
        		http.httpRequest({ 
                    url: window._CONFIG.chooseOtherUrl+'/sccheck/scplantask/searchByYear',
                    serializable: false,
                    type:'post',
                    data: {params:$("#chooseagentform").serializeObject()} ,
                    success: function (data) {
                    	var list = data.data;
                    	html = '<option value=""></option>';
                        if (data.status == 'success') {  
    						for(var i = 0;i<list.length;i++){
    							html += '<option value="'+list[i].uid+'">【'+list[i].taskCode+'】'+list[i].taskName +'</option>';
    						}
                        }
                        $("#taskUid").empty().append(html);
                    }
                });
        	}
        }]);
    }
});
