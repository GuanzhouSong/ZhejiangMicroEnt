require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
    	bind();
     }  
    
    function check(){
    	//重新指派类型的选中值
    	var reassignType  = $("input:radio[name='reassignType'][checked]").val();
    	var deptCode = window._CONFIG.deptCode;  //当前登录指派部门code
    	var orgCodes = $("#orgCodes").val();;  //当前登录指派部门code
    	
    	if(reassignType == '1'){  //重新指派 验证重新指派机关
    		var deptname = $("#checkDep").val();
    		if(deptname == ""){
                layer.msg("请您选择重新指派备案机关!", {icon: 7,time: 1000});
    			return false;
    		}
    		if(deptCode == orgCodes){
                layer.msg("选择的重新指派机关不能为当前部门!", {icon: 7,time: 1000});
    			return false;
    		}
    	}else{   //回退验证退回理由  
        	if($.trim($("#reassignCode").val()) == ""||$.trim($("#reassignCode").val()) == null){
                layer.msg("请您选择退回理由!", {icon: 7,time: 1000});
        		return false;
        	}
    	}
    	
    	var remark=$.trim($("#remark").val()); 
//    	//验证备注  
//    	if(remark==""||remark == null){
//            layer.msg("请填写备注信息!", {icon: 7,time: 1000});
//    		return false;
//    	}
    	if(remark.length>500){
            layer.msg("备注只能输入500个字符!", {icon: 7,time: 1000});
            return false;
    	}
    	return true;
    }
    

    function bind() {
        util.bindEvents([
        {
            el: '#save',
            event: 'click',
            handler: function () {
            	if(check()){
            		var msg = "确定重新指派吗?";
            		var successmsg = "重新指派成功";
            		if($("input:radio[name='reassignType'][checked]").val()=='2'){
            			msg = "确定回退吗?";
            			successmsg = "回退成功";
            		}
            		layer.confirm(msg, {icon: 2, title: '提示'}, function () {
            			$("#cancel").attr("disabled","disabled");
            			var formParam=$('#form').serializeObject(); 
        	    		if($("input:radio[name='reassignType'][checked]").val()=='2'){//如果是回退操作提交  ，移除备案部门编码和部门名称的赋值
        	    			delete formParam.checkDep;
        	    			delete formParam.checkDepName;
        	    			delete formParam.dutyDeptCode;
        	    			delete formParam.dutyDeptName;
        	    		}
//        	    		console.log(formParam);
//        	    		debugger
    	                http.httpRequest({ 
    	                    url: window._CONFIG.chooseUrl+'/pubdzdtinfo/doreback',
    	                    serializable: true,
    	                    data: formParam  ,
    	                    type: 'post',
    	                    success: function (data) {
    	                        if (data.status == 'success') {  
    	                                layer.msg(successmsg, {time: 2000}, function () {
    	                                	layer.close({reload: true});
    	                                }); 
    	                        }else{
    	                        	layer.msg(data.msg, {ltype: 0,time:2000});
    	                        }
//                      		$("#cancel").removeAttr("disabled");
    	                    }
    	                });
                    }) 
            	}else{
            		return;
            	}
        	    	
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
            el: '#selectDept',
            event: 'click',
            handler: function () {
//            	console.log(window._CONFIG.adcode);
            	layer.dialog({
                    title: '选择备案部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/deptSelectByDuty?treeType=radio&isNoCheck=true&dutyDeptCodes='+window._CONFIG.adcode,
                    callback: function (data) {
//                    	console.log(data);
//                    	debugger
                    	$("#checkDep").val(data.adCodes);
                    	$("#checkDepName").val(data.orgNames);
                    	$("#dutyDeptCode").val(data.dutyDeptCodes);
                    	$("#dutyDeptName").val(data.dutyDeptNameStr);
                    	$("#orgCodes").val(data.orgCodes);
                    }
                })
            }
        },{
        	el: '#radio1',  //选择操作类型为重新指派（退回理由清空）
            event: 'click',
            handler: function () {
            	$("#radio1").attr("checked","checked");
            	$("#radio2").removeAttr("checked");
        		$("#recheck").show();
        		$("#reback").hide();
        		$("#reassignCode").val("");	
            }
        },{
        	el: '#radio2', //选择操作类型为回退（备案机关清空）
            event: 'click',
            handler: function () {
            	$("#radio2").attr("checked","checked");
            	$("#radio1").removeAttr("checked");
            	$("#recheck").hide();
        		$("#reback").show();
            	$("#checkDep").val("");
            	$("#checkDepName").val("");
            	$("#dutyDeptCode").val("");
            	$("#dutyDeptName").val("");
            	$("#orgCodes").val("");
            }
        }
        ])
    }

})
