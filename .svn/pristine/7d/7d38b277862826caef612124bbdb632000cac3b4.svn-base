require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    
  	//列入原因
	
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
        initdecisionBookInfo();
        } 
    
    function initdecisionBookInfo(){
    	
    	$(".dept").html(window._CONFIG._deptName);
    	
    	var _batchEntType=window._CONFIG._batchEntType;
    	var _speCause=window._CONFIG._speCause;
    	
    	var appInReaCodeDecisionList = [
    	                            	{id: "1", text: "未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告",sfcText:""},
    	                            	{id: "2", text: "未按照工商行政管理部门责令的期限公示有关企业信息",sfcText:""},
    	                            	{id: "3", text: "公示企业信息隐瞒真实情况、弄虚作假 ",sfcText:"年度报告公示信息隐瞒真实情况、弄虚作假 "},
    	                            	{id: "4", text: "通过登记的住所或者经营场所无法联系 ",sfcText:"通过登记的住所无法联系"}
    	];
    	if(_batchEntType=="2"){
    		//农专社判断
    			$.each(appInReaCodeDecisionList, function(i,n){
    				if(_speCause == n.id){
    					$("#farmReaCode").text(n.sfcText);
    				}
    			});
    			if(_speCause == "1"){
    				$("#farmReaNo").text("十");
    			}else if(_speCause == "3"){
    				$("#farmReaNo").text("十一");
    			}else if(_speCause == "4"){
    				$("#farmReaNo").text("十二");
    			} 
    	}else{
        	$.each(appInReaCodeDecisionList, function(i,n){
    			if(_speCause == n.id){
    				$("#entReaCode").text(n.text);
    			}
    		});
        	
        	if(_speCause == "1"){
    			$("#entReaNo").text("六");
    		}else if(_speCause == "2"){
    			$("#entReaNo").text("七");
    		}else if(_speCause == "3"){
    			$("#entReaNo").text("八");
    		}else if(_speCause == "4"){
    			$("#entReaNo").text("九");
    		}
    	}
    }
    
     function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: '#savedecisionbookbtn',
            event: 'click',
            handler: function () {
            	var deptUpName=$("#deptUpName").val();
            	var deptName=$("#deptName").val();
            	var deptSameGov=$("#deptSameGov").val();
            	var deptSameCourt=$("#deptSameCourt").val();
            	if((deptUpName==null||deptUpName=="")){
            		layer.msg("保存失败!上级部门名称不能为空,请检查配置", {ltype: 0,time:2000});
                    return false;
            	}
            	if(deptName==null||deptName==""){
            		layer.msg("保存失败!部门名称不能为空,请检查配置", {ltype: 0,time:2000});
                    return false;
            	}
            	if(deptSameGov==null||deptSameGov==""){
            		layer.msg("保存失败!同级人民政府不能为空,请检查配置", {ltype: 0,time:2000});
                    return false;
            	}
            	if(deptSameCourt==null||deptSameCourt==""){
            		layer.msg("保存失败!同级人民法院不能为空,请检查配置", {ltype: 0,time:2000});
                    return false;
            	} 
            	var formParam=$('#decisionbookform').serializeObject();
            	 http.httpRequest({
                     url: '/reg/server/opanomaly/pubopanomaly/commitPubOpanoMaly',
                     serializable: true,
                     data:formParam,
                     type: 'post',
                     success: function (data) { 
                    	 if(data.status=="success"){
                    		 layer.msg("操作成功", {time: 1000}, function () {
   								layer.close({reload: true});
                      		 }); 
                    	 }else{
                    		 layer.msg("操作失败", {ltype: 0,time:500});
                    	 }
                     }
                 });
            }
        }]);
    }

})
