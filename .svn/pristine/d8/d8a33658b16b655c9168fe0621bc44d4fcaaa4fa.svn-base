require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init(); 
	
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        initspeCauseInfo();
        doChange();
         }
    
	
	//初始化信息
	function initspeCauseInfo(){ 
		
		var ohterArr=[];
		var _uid=window._CONFIG._uid;
		//新增打印时给span属性新增宽度
		if(typeof _uid=="undefined"|| _uid==null||_uid==""){
			$("span").addClass("pdlr");
		}
  		//整改项目
		var _adminGuideType=window._CONFIG._adminGuideType;
		//选择的期限
		var _chooseDay=window._CONFIG._chooseDay;
		//其他送达方式 多个逗号隔开
		var _adminGuideDocType=window._CONFIG._adminGuideDocType; 
		if(_adminGuideType==null||_adminGuideType==""){
			$("#adminGuideTypeTem").val("0");
			$("#adminGuideTypeTem").val("0");
		}else{
			$("#adminGuideTypeTem").val(_adminGuideType);
			$("#adminGuideType").val(_adminGuideType);
		}
		if(typeof _chooseDay!="undefined" &&typeof _chooseDay!="undefined" &&typeof _chooseDay!="undefined"){
			//回显期限 
			if(_adminGuideType=="0"){
				$("#chooseDayohter").val(_chooseDay); 
				$("#chooseDayohter").attr("disabled",true);
				ohterArr=$(".ohter input");
	        }else if(_adminGuideType=="1"){
	        	$("#chooseDayoutMoney").val(_chooseDay);
	        	$("#chooseDayoutMoney").attr("disabled",true);
	        	ohterArr=$(".outMoney input");
	        }else if(_adminGuideType=="2"){
	        	$("#chooseDaylegzg").val(_chooseDay);
	        	$("#chooseDaylegzg").attr("disabled",true);
	        	ohterArr=$(".legzg input");
	        }else if(_adminGuideType=="3"){
	        	$("#chooseDaylicenseexpire").val(_chooseDay)
	        	$("#chooseDaylicenseexpire").attr("disabled",true);
	        	ohterArr=$(".licenseexpire input");
	        }else if(_adminGuideType=="4"){
	        	$("#chooseDayjyexpire").val(_chooseDay);
	        	$("#chooseDayjyexpire").attr("disabled",true);
	        	ohterArr=$(".jyexpire input");
	        }else if(_adminGuideType=="5"){
	        	$("#chooseDaylicensemod").val(_chooseDay);
	        	$("#chooseDaylicensemod").attr("disabled",true);
	        	ohterArr=$(".licensemod input");
	        }
			$.each(ohterArr, function(i, n) { 
    	    	 $(this).attr("disabled",true); 
		    });
			//回显 其他送达方式
			var _adminGuideDocTypeArr=_adminGuideDocType.split(",");
			var adminGuideDocTypeTemArr=$('input[name="adminGuideDocTypeTem"]');
			$.each(_adminGuideDocTypeArr, function(a,b) { 
				$.each(adminGuideDocTypeTemArr, function(c,d) { 
					if(_adminGuideDocTypeArr[a]==d.value){
						$(this).attr("checked",'true');
					}
			    });
		    });
		}
	} 
	
	
	
	function doChange(){
    	//责令整改项目
        var adminGuideType=$("#adminGuideTypeTem").val();
     	   //终止时显示终止日期 
        if(adminGuideType=="0" ||(adminGuideType==null||adminGuideType=="")){
        	  $(".ohter").removeClass("hide");
        	  $(".outMoney").addClass("hide");
        	  $(".licenseexpire").addClass("hide");
        	  $(".legzg").addClass("hide");
        	  $(".jyexpire").addClass("hide");
        	  $(".licensemod").addClass("hide");
        }else if(adminGuideType=="1"){
	          $(".ohter").addClass("hide");
	      	  $(".outMoney").removeClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").addClass("hide");
        }else if(adminGuideType=="2"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").removeClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").addClass("hide");
        }else if(adminGuideType=="3"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").removeClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").addClass("hide");
        }else if(adminGuideType=="4"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").removeClass("hide");
	      	  $(".licensemod").addClass("hide");
        }else if(adminGuideType=="5"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").removeClass("hide");
        }
    }
	
  


    var searchParams={};//查询参数声明!
    var table; 
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
            el: '#adminGuideTypeTem',
            event: 'change',
            handler: function () {
            	doChange();
            }
        },{
            el: '.pubOpanoMalyDetail',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '经营异常名录设置 - 查看详情',
                    area: ['1024px', '500px'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAuditEdit?busExcList='+busExcList+"&viewFlag=2",
                    callback: function (data) {
                        
                    }
                })  
            }
        },{
            el: '#saveorderreformset',
            event: 'click',
            handler: function () { 
            	 
            	var _viewFlag=window._CONFIG._viewFlag;
            	//终止
            	if(_viewFlag=="5"){ 
            		var susRemarkTem=$.trim($("#susRemarkTem").val());
            		if(susRemarkTem==null||susRemarkTem==""){
	                	 layer.msg("请填写中止说明", {ltype: 0,time:2000});
	            		 return false;
	                }
            		
            		var susDateTem=$.trim($("#susDateTem").val());
            		if(susDateTem==null||susDateTem==""){
	                	 layer.msg("请填选择中止日期", {ltype: 0,time:2000});
	            		 return false;
	                }
            		//终止日期
            		$("#susDate").val(susDateTem);
            		//终止说明
            		$("#susRemark").val(susRemarkTem);
            		//提示状态设置为无效
            		$("#efftStatus").val("0");
            		//审核状态设置为终止
            		$("#auditState").val("4");
            		//是否终止设置为已终止
            		$("#isAbort").val("1");
            	}else{
            		//审核结果
          			var auditStateTemArr=$('input[name="auditStateTem"]:checked');
         			if(auditStateTemArr.length==0){
         				layer.msg("请选择审核结果", {ltype: 0,time:2000});
               		    return false;
         			}
         			//审核状态
         			var auditState=auditStateTemArr[0].value;
         			//根据审核状态设置提示状态
         			if(auditState=="1"){
         				$("#efftStatus").val("1");
         			}else if(auditState=="2"){
         				$("#efftStatus").val("2");
         			}else if(auditState=="3"){
         				$("#efftStatus").val("0");
         			} 
         			$("#auditState").val(auditState); 
         			//审核意见
         			var auditRemarkTem=$.trim($("#auditRemarkTem").val()); 
	                if(auditRemarkTem==null||auditRemarkTem==""){
	                	 layer.msg("请填写审核意见", {ltype: 0,time:2000});
	            		 return false;
	                } 
                   //审核意见
                   $("#auditRemark").val(auditRemarkTem); 
            	}
            	
             	
                 
            	 var formParam=$('#orderreformsetform').serializeObject(); 
            	 http.httpRequest({
                     url: '/reg/server/orderreformset/commitOrderReformSet',
                     serializable: true,
                     data:formParam,
                     type: 'post',
                     success: function (data) {  
                    	 if(data.status == 'success'){
                    		 layer.msg("保存成功", {time: 1000}, function () {
 								layer.close({reload: true});
                    		 }); 
                    	 }else{
                    		 layer.msg("保存失败", {ltype: 0,time:2000});
                    	 }
                     }
                 });
            }
        }]);
    }
})

  
