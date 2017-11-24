require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	
    /**
	 * 初始化函数集合
	 */
    function init() { 
    	initDataTable();
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
			bScrollInfinite:true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/adjustListJSON',
                data:function(d){
	               	d.params = $("#chooseagentform").serializeObject();
                }
            },
            columns: [
                {data: "_idx", "className": "center"},
                {data: null, "className": "center"}, 
                {data: null, "className": "center"},
                {data: null, "className": "center"},
                {data: null, "className": "center"},
                {data: null, "className": "center"}, 
                {data: "entName", "className": "center"}, 
                {data: null, "className": "center"},
                {data: "taskCode", "className": "center"},
                {data: "taskName", "className": "center"},
                {data: "regOrgName", "className": "center"},
                {data: "localAdmName", "className": "center"},
                {data: "adjustUserName", "className": "center"},
                {data: "adjustTime", "className": "center"}
            ],
            columnDefs: [{
            	targets:1,
    	        render:function(data,type,row,meta){
    	        	if(data.auditState == "1"){
    	        		return "<input type='checkbox' value='"+data.uid+"'/>";
    	        	}else{
    	        		return "-";
    	        	}
    	       }
	        },{
            	targets:2,
    	        render:function(data,type,row,meta){
    	        	if(row.checkDeptPerson && row.checkDeptPerson != "null"){
    	        		return row.checkDeptPerson;
    	        	}else{
    	        		return "-";
    	        	}
    	       }
	        },{
            	targets:3,
    	        render:function(data,type,row,meta){
    	        	if(row.teamLeader && row.teamLeader != "null"){
    	        		return row.teamLeader;
    	        	}else{
    	        		return "-";
    	        	}
    	       }
	        },{
            	targets:4,
    	        render:function(data,type,row,meta){
    	        	if(row.expertNames && row.expertNames != "null"){
    	        		return row.expertNames;
    	        	}else{
    	        		return "-";
    	        	}
    	       }
	        },{
	        	targets:5,
	        	render:function(data,type,row,meta){
	        		if(row.uniCode&&row.uniCode != "null"){
						return row.uniCode;
					}else{
						return row.regNO;
					}
	        	}
        	},{
	        	targets:7,
	        	render:function(data,type,row,meta){
	        		if(data.auditState == "1"){
    	        		return "待录入";
    	        	}else if(data.auditState == "2"){
    	        		return "待审核";
    	        	}else if(data.auditState == "4"){
    	        		return "审核不通过";
    	        	}else if(data.auditState == "5"){
    	        		return "已公示";
    	        	}else{
    	        		return "-";
    	        	}
	        	}
	          }
           ]
        });
    }
    
    $("#search").click(function(){
        table.ajax.reload();
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
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
        },{
            el: '#chooseAll',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
					 $("#agent-table input").prop("checked",true);
				 }else{
					 $("#agent-table input").prop("checked",false);
				 }
            }
        },{
            el: '#adjust',
            event: 'click',
            handler: function () {
            	var checkFlag = false;
            	var uidArray = new Array();
            	$("#agent-table input").each(function(){
            		if($(this).prop("checked")){
            			checkFlag = true;
            			uidArray.push($(this).val());
            		}
            	});
            	var resultUids = uidArray.toString();
            	if(checkFlag){
            		layer.dialog({
            			title:"调整检查小组",
            			area:['88%','62%'],
            			content:window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/entermemberpage?resultUids='+resultUids,
            			callback:function(data){
            				if(data.reload){
            					table.ajax.reload();
            				}
            			}
            		});
                }else{
                	layer.msg("请先选择一条需要调整的记录！", {icon: 7,time: 1000});
                	return false;
                }	
            }
        }]);
    }
});
