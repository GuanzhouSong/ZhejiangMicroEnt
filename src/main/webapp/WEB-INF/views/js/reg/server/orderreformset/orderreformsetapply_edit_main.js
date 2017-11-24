require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {

	
	 //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#staDateTem', //选择ID为START的input
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
        elem: '#endDateTem',
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
    
    
  //开始时间和结束时间
    $("#staDateTem").click(function(){laydate(start);});
    $("#endDateTem").click(function(){laydate(end);}); 

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
		
		//整改项目
		var _adminGuideType=window._CONFIG._adminGuideType;
		
		var _uid=window._CONFIG._uid; 
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
		//修改
		if(_uid!=null&&_uid!=""){
			//回显期限 
			if(_adminGuideType=="0"){
				$("#chooseDayohter").val(_chooseDay);
	        }else if(_adminGuideType=="1"){
	        	$("#chooseDayoutMoney").val(_chooseDay);
	        }else if(_adminGuideType=="2"){
	        	$("#chooseDaylegzg").val(_chooseDay);
	        }else if(_adminGuideType=="3"){
	        	$("#chooseDaylicenseexpire").val(_chooseDay)
	        }else if(_adminGuideType=="4"){
	        	$("#chooseDayjyexpire").val(_chooseDay);
	        }else if(_adminGuideType=="5"){
	        	$("#chooseDaylicensemod").val(_chooseDay);
	        }
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
        var uid=window._CONFIG._uid; 
        if(adminGuideType=="0" ||(adminGuideType==null||adminGuideType=="")){
        	  $(".ohter").removeClass("hide");
        	  $(".outMoney").addClass("hide");
        	  $(".licenseexpire").addClass("hide");
        	  $(".legzg").addClass("hide");
        	  $(".jyexpire").addClass("hide");
        	  $(".licensemod").addClass("hide"); 
        	  if(uid!=null&&uid!=""){
        		  var otherLawOneText=$("#otherLawOneText").text();
        		  if(otherLawOneText==null||otherLawOneText==""){
        			  $("#otherLawOneText").addClass("pdlr");
        		  } 
        		  var illegaloneText=$("#illegaloneText").text();
        		  if(illegaloneText==null||illegaloneText==""){
        			  $("#illegaloneText").addClass("pdlr");
        		  } 
        		  var otherLawTwoText=$("#otherLawTwoText").text();
        		  if(otherLawTwoText==null||otherLawTwoText==""){
        			  $("#otherLawTwoText").addClass("pdlr");
        		  }
        		  var orderreformseText=$("#orderreformseText").text();
        		  if(orderreformseText==null||orderreformseText==""){
        			  $("#orderreformseText").addClass("pdlr");
        		  }
        	  }
        	  //填写的内容加上红色
        	  $(".ohter input").addClass("light");
        	  $(".ohter span").addClass("light");
        }else if(adminGuideType=="1"){
	          $(".ohter").addClass("hide");
	      	  $(".outMoney").removeClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").addClass("hide"); 
	      	  //填写的内容加上红色
        	  $(".outMoney input").addClass("light");
        	  $(".outMoney span").addClass("light");
        }else if(adminGuideType=="2"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").removeClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").addClass("hide");
		      if(uid!=null&&uid!=""){
		      		  var leReppunishOneText=$("#leReppunishOneText").text();
		      		  if(leReppunishOneText==null||leReppunishOneText==""){
		      			  $("#leReppunishOneText").addClass("pdlr");
		      		  } 
		      }
		      //填写的内容加上红色
		      $(".legzg input").addClass("light");
        	  $(".legzg span").addClass("light");
        }else if(adminGuideType=="3"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").removeClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").addClass("hide");
	      	  if(uid!=null&&uid!=""){
	      		  var chooseLicenceOneText=$("#chooseLicenceOneText").text();
	      		  if(chooseLicenceOneText==null||chooseLicenceOneText==""){
	      			  $("#chooseLicenceOneText").addClass("pdlr");
	      		  } 
	      	    }
	      	  //填写的内容加上红色
		      $(".licenseexpire input").addClass("light");
        	  $(".licenseexpire span").addClass("light");
        }else if(adminGuideType=="4"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").removeClass("hide");
	      	  $(".licensemod").addClass("hide");
	      	 //填写的内容加上红色
		      $(".jyexpire input").addClass("light");
        	  $(".jyexpire span").addClass("light");
        }else if(adminGuideType=="5"){
        	  $(".ohter").addClass("hide");
	      	  $(".outMoney").addClass("hide");
	      	  $(".licenseexpire").addClass("hide");
	      	  $(".legzg").addClass("hide");
	      	  $(".jyexpire").addClass("hide");
	      	  $(".licensemod").removeClass("hide");
	      	  //填写的内容加上红色
		      $(".licensemod input").addClass("light");
        	  $(".licensemod span").addClass("light");
	      	 if(uid!=null&&uid!=""){
	      		  //修改时给显示法律条文的span加上默认宽度
	      		  var chooseregistrationOneText=$("#chooseregistrationOneText").text();
	      		  if(chooseregistrationOneText==null||chooseregistrationOneText==""){
	      			  $("#chooseregistrationOneText").addClass("pdlr");
	      		  } 
	      	 }
        }
    }
	
  


    var searchParams={};//查询参数声明!
    var table;
    
    
    function sss(){
    	 /**
         * 电话号码/手机号验证规则
         */ 
            
        

    }
    
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close({type:'cancel'});
            }
        },{
            el: '#adminGuideTypeTem',
            event: 'change',
            handler: function () {
            	doChange();
            }
        },{
            el: '.otherLawOne',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '选择法律法规',
                    area: ['35%', '70%'],
                    content: '/reg/server/orderreformset/commonDictree',
                    callback: function (data) { 
                    	if(data.type!="cancel"){
                    		$("#otherLawOne").val(data.name);
                            $("#otherLawOneText").text(data.name); 
                            var otherLawOneText= $("#otherLawOneText").text();
                            if(otherLawOneText!=null&&otherLawOneText!==""){
                            	$("#otherLawOneText").removeClass("pdlr");
                            }
                    	}
                    }
                })  
            }
        },{
            el: '.otherLawTwo',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '选择法律法规',
                    area: ['35%', '70%'],
                    content: '/reg/server/orderreformset/commonDictree',
                    callback: function (data) {
                    	if(data.type!="cancel"){
                    		$("#otherLawTwo").val(data.name);
                            $("#otherLawTwoText").text(data.name);
                            var otherLawTwoText=$("#otherLawTwoText").text();
                            if(otherLawTwoText!=null&&otherLawTwoText!=""){
                            	 $("#otherLawTwoText").removeClass("pdlr");
                            }
                    	}
                    }
                })  
            }
        },{
            el: '.leReppunishOne',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '选择法人处罚',
                    area: ['25%', '70%'],
                    content: '/reg/server/orderreformset/leReppunishtree',
                    callback: function (data) {
                    	
                    	if(data.type!="cancel"){
                    		var nameStr="";
                    		var nameArr=data.name.split("、");
                    	    if(nameArr.length!=0){ 
                    			  $.each(nameArr, function(c,d) { 
                    				  nameStr+= (c+1)+"、"+d;
                  			      });
                    			  $("#leReppunishOne").val(nameStr);
                                  $("#leReppunishOneText").text(nameStr);
                    		} 
                            var leReppunishOneText=$("#leReppunishOneText").text();
                            if(leReppunishOneText!=null&&leReppunishOneText!=""){
                            	$("#leReppunishOneText").removeClass("pdlr");
                            }
                    	}
                    }
                })  
            }
        },
        {
            el: '.chooseLicenceOne',
            event: 'click',
            handler: function () {
            layer.dialog({
                title: '选择许可证',
                area: ['25%', '70%'],
                content: '/reg/server/govguide/govguide/toLicence',
                callback: function (data) {
                	 
                	  var nameStr="";
	           		  var nameArr=data.name.split(",");
	           		  if(nameArr.length!=0){ 
	           			  $.each(nameArr, function(c,d) { 
	           				  nameStr+= (c+1)+"、"+d;
	         			      });
           			     $("#chooseLicenceOne").val(nameStr);
                         $("#chooseLicenceOneText").text(nameStr);
	           		  } 
                     var chooseLicenceOneText=$('#chooseLicenceOneText').text();
                     var chooseLicenceOne=$('#chooseLicenceOne').text();
                     if((chooseLicenceOneText!=null&&chooseLicenceOneText!="")||(chooseLicenceOne!=null&&chooseLicenceOne!="") ){
                    	 $("#chooseLicenceOneText").removeClass("pdlr");
                     }
                }
            });
                        }
      },{
          el: '.illegalone',
          event: 'click',
          handler: function () {
          	var busExcList=this.id;
          	layer.dialog({
                  title: '选择违法行为',
                  area: ['25%', '70%'],
                  content: 'reg/server/orderreformset/illegaltree',
                  callback: function (data) {
                	  
                	  if(data.type!="cancel"){
                		  var nameStr="";
                		  var nameArr=data.name.split("、");
                		  if(nameArr.length!=0){ 
                			  $.each(nameArr, function(c,d) { 
                				  nameStr+= (c+1)+"、"+d;
              			      });
                			  $("#illegalone").val(nameStr);
                              $("#illegaloneText").text(nameStr);
                		  }  
                          var  illegaloneText=$("#illegaloneText").text();
                          if(illegaloneText!=null&&illegaloneText!=""){
                        	  $("#illegaloneText").removeClass("pdlr");
                          }
                	  }
                  }
              })  
          }
      },{
          el: '#printorderreformset',
          event: 'click',
          handler: function () {
        	  
    	     var _id = "_doPrint_"+new Date().getTime();
    	     var adminGuideTypeTem=$("#adminGuideTypeTem").val();
    	     // var pripid=$("#priPID").val(); 
    	     //加密后的主体身份代码
    	     var pripid=window._CONFIG._encodeCorpid;
    	     if(adminGuideTypeTem==null||adminGuideTypeTem==""){ 
                	 layer.msg("请选择责令整改项目", {ltype: 0,time:2000});
         			 return false; 
    	     }
             var url = "/reg/server/orderreformset/orderreFormsetApplyPrint?adminGuideType="+adminGuideTypeTem+"&pripid="+pripid;
             try{
                 window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
             }catch(e){
                 alert("打印错误!");
             }
            
          }
      },{
          el: '#printorderreformsetedit',
          event: 'click',
          handler: function () {
        	  
    	     var _id = "_doPrint_"+new Date().getTime();
//    	     var adminGuideTypeTem=$("#adminGuideTypeTem").val();
    	     var uid=$("#uid").val();
    	     if(adminGuideTypeTem==null||adminGuideTypeTem==""){ 
                	 layer.msg("请选择责令整改项目", {ltype: 0,time:2000});
         			 return false; 
    	     }
             var url = "/reg/server/orderreformset/orderreFormsetApplyPrint?uid="+uid+"&viewFlag=2";
             try{
                 window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
             }catch(e){
                 alert("打印错误!");
             }
            
          }
      },{
          el: '.chooseregistrationOne',
          event: 'click',
          handler: function () {
          	var busExcList=this.id;
          	layer.dialog({
                  title: '选择登记事项',
                  area: ['25%', '70%'],
                  content: 'reg/server/orderreformset/registrationtree',
                  callback: function (data) {
                	  
                	  if(data.type!="cancel"){
                		  var nameStr="";
                		  var nameArr=data.name.split("、");
                		  if(nameArr.length!=0){ 
                			  $.each(nameArr, function(c,d) { 
                				  nameStr+= (c+1)+"、"+d;
              			      });
                			  $("#chooseregistrationOne").val(nameStr);
                              $("#chooseregistrationOneText").text(nameStr);
                		  } 
                          var chooseregistrationOneText=$("#chooseregistrationOneText").text();
                          if(chooseregistrationOneText!=null&&chooseregistrationOneText!=""){
                        	  $("#chooseregistrationOneText").removeClass("pdlr");
                          }
                	  }
                  }
              })  
          }
      },{
            el: '.orderreformsetree',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '选择责令整改事项',
                    area: ['25%', '70%'],
                    content: '/reg/server/orderreformset/orderreformsetree',
                    callback: function (data) {
                    	
                    	if(data.type!="cancel"){
	                		  var nameStr="";
	                		  var nameArr=data.name.split("、");
	                  		  if(nameArr.length!=0){ 
	                  			    $.each(nameArr, function(c,d) { 
	                  				  nameStr+= (c+1)+"、"+d;
	                			      });
	                  			    $("#orderreformse").val(nameStr);
	                                $("#orderreformseText").text(nameStr);
	                  		  } 
	                          var orderreformseText=$("#orderreformseText").text();
	                          if(orderreformseText!=null&&orderreformseText!=""){
	                            	$("#orderreformseText").removeClass("pdlr");
	                          }
                    	}
                    }
                })  
            }
        },{
            el: '#saveorderreformset',
            event: 'click',
            handler: function () { 
            	
            	 var flag=false;
            	 //开始日期
            	 var staDateTem=$("#staDateTem").val(); 
            	 //结束日期
            	 var endDateTem=$("#endDateTem").val(); 
            	 //联系人
            	 var linkManTem="";
            	 //联系电话
            	 var telTem="";
            	 var regOrgNameTem="";
            	 var localAdmNameTem=""; 
            	 //出具日期
            	 var assignDateTem=""; 
            	 var assignDateTemArr=$('input[name="assignDateTem"]'); 
            	 var telTemArr=$('input[name="telTem"]'); 
            	 var regOrgNameTemArr=$('input[name="regOrgNameTem"]');
            	 var localAdmNameTemArr=$('input[name="localAdmNameTem"]');
            	 var linkManTemArr=$('input[name="linkManTem"]'); 
            	 if(staDateTem==null||staDateTem==""){
                	 layer.msg("请选择开始日期", {ltype: 0,time:2000});
         			 return false;
                 }
            	 if(endDateTem==null||endDateTem==""){
                	 layer.msg("请选择结束日期", {ltype: 0,time:2000});
         			 return false;
                 }
            	
            	//责令整改项目
                 var adminGuideTypeTem=$("#adminGuideTypeTem").val();
                 if(adminGuideTypeTem==null||adminGuideTypeTem==""){
                	 layer.msg("请选择责令整改项目", {ltype: 0,time:2000});
         			 return false;
                 }
                
                 var adminGuideStr="";
                 var adminGuideDocTypeTemArr=$('input[name="adminGuideDocTypeTem"]:checked');
                 if(adminGuideDocTypeTemArr.length==0){
                	 layer.msg("请选择通知书送达方式", {ltype: 0,time:2000});
         			 return false;
                 }else{
                	 $.each(adminGuideDocTypeTemArr, function(a,b) { 
                		 if(a==adminGuideDocTypeTemArr.length-1){
                			 adminGuideStr+=b.value;
                		 }else{
                			 adminGuideStr+=b.value+",";
                		 }
      		         });
                  }
                 
                 var adminGuideCerContentStr="";
                 var chooseDayStr="";
                 var ohterArr=[]; 
              	   //责令整改项目 
                 if(adminGuideTypeTem=="0"){
                	 telTem=telTemArr[0].value;
                	 linkManTem=linkManTemArr[0].value;
                	 localAdmNameTem=localAdmNameTemArr[0].value;
                     regOrgNameTem=regOrgNameTemArr[0].value;
                     assignDateTem=assignDateTemArr[0].value;
                	 chooseDayStr=$("#chooseDayohter").val();
                	 ohterArr=$(".ohter input"); 
                	 $.each(ohterArr, function(i, n) { 
            	    	var inputValue=n.value;
      		            if(inputValue==null||inputValue==""){ 
     		            	flag=true;
     	         			return false;
     		            }
      		            if(i<7){
      		            	adminGuideCerContentStr+=inputValue+"&";
      		            }
     		         });
                 }else if(adminGuideTypeTem=="1"){
                	 telTem=telTemArr[1].value;
                	 linkManTem=linkManTemArr[1].value;
                	 localAdmNameTem=localAdmNameTemArr[1].value;
                     regOrgNameTem=regOrgNameTemArr[1].value;
                     assignDateTem=assignDateTemArr[1].value;
                	 chooseDayStr=$("#chooseDayoutMoney").val();
                	 ohterArr=$(".outMoney input"); 
                	 $.each(ohterArr, function(i, n) { 
            	    	var inputValue=n.value;
            	    	//alert(inputValue)
     		            if(inputValue==null||inputValue==""){ 
     		            	flag=true;
     	         			return false;
     		            }
     		           if(i<6){
     		            	adminGuideCerContentStr+=inputValue+"&";
     		            }
     		         });
                 }else if(adminGuideTypeTem=="2"){
                	 telTem=telTemArr[2].value;
                	 linkManTem=linkManTemArr[2].value;
                	 localAdmNameTem=localAdmNameTemArr[2].value;
                     regOrgNameTem=regOrgNameTemArr[2].value;
                     assignDateTem=assignDateTemArr[2].value;
                	 chooseDayStr=$("#chooseDaylegzg").val();
                	 ohterArr=$(".legzg input"); 
                	 $.each(ohterArr, function(i, n) { 
            	    	var inputValue=n.value;
      		            if(inputValue==null||inputValue==""){ 
     		            	flag=true;
     	         			return false;
     		            }
            	    	if(i<7){
     		            	adminGuideCerContentStr+=inputValue+"&";
     		            }
     		         });
                 }else if(adminGuideTypeTem=="3"){
                	 telTem=telTemArr[3].value;
                	 linkManTem=linkManTemArr[3].value;
                	 localAdmNameTem=localAdmNameTemArr[3].value;
                     regOrgNameTem=regOrgNameTemArr[3].value;
                     assignDateTem=assignDateTemArr[3].value;
                	 chooseDayStr=$("#chooseDaylicenseexpire").val();
                	 ohterArr=$(".licenseexpire input"); 
                	 $.each(ohterArr, function(i, n) { 
            	    	var inputValue=n.value;
      		            if(inputValue==null||inputValue==""){ 
     		            	flag=true;
     	         			return false;
     		            }
      		          if(i<3){
   		            	adminGuideCerContentStr+=inputValue+"&";
   		               }
     		         });
                 }else if(adminGuideTypeTem=="4"){
                	 telTem=telTemArr[4].value;
                	 linkManTem=linkManTemArr[4].value;
                	 localAdmNameTem=localAdmNameTemArr[4].value;
                     regOrgNameTem=regOrgNameTemArr[4].value;
                     assignDateTem=assignDateTemArr[4].value;
                	 chooseDayStr=$("#chooseDayjyexpire").val();
                	 ohterArr=$(".jyexpire input"); 
                	 $.each(ohterArr, function(i, n) { 
            	    	var inputValue=n.value;
      		            if(inputValue==null||inputValue==""){ 
     		            	flag=true;
     	         			return false;
     		            }
      		            if(i<3){
     		            	adminGuideCerContentStr+=inputValue+"&";
     		            }
     		         });
                 }else if(adminGuideTypeTem=="5"){
                	 telTem=telTemArr[5].value;
                	 linkManTem=linkManTemArr[5].value;
                	 localAdmNameTem=localAdmNameTemArr[5].value;
                     regOrgNameTem=regOrgNameTemArr[5].value;
                     assignDateTem=assignDateTemArr[5].value;
                	 chooseDayStr=$("#chooseDaylicensemod").val();
                	 ohterArr=$(".licensemod input"); 
                	 $.each(ohterArr, function(i, n) { 
            	    	var inputValue=n.value;
      		            if(inputValue==null||inputValue==""){ 
     		            	flag=true;
      	         			return false;
     		            }
      		          if(i<3){
   		            	adminGuideCerContentStr+=inputValue+"&";
   		               }
     		         });
                 } 
                 if(linkManTem==null||linkManTem==""){
                	 layer.msg("请填写联系人", {ltype: 0,time:2000});
         			 return false;
                 }
            	 if(telTem==null||telTem==""){
                	 layer.msg("请填写联系电话", {ltype: 0,time:2000});
         			 return false;
                 }
            	 var length = telTem.length;
                 var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;//手机
                 var telnumber =  /^\d{4}-?\d{7,8}$|^\d{7,8}$|^\d{3}-?\d{3}-?\d{4}$/; //电话
                  if(!((length == 11 && mobile.test(telTem)) || telnumber.test(telTem)) ){
                	  layer.msg("请填写正确的联系电话", {ltype: 0,time:2000});
          			  return false; 
                  }  
            	 
            	 if(assignDateTem==null||assignDateTem==""){
                	 layer.msg("请选择出具日期", {ltype: 0,time:2000});
         			 return false;
                 }
                 if(regOrgNameTem==null||regOrgNameTem==""){
                	 layer.msg("请填写登记机关", {ltype: 0,time:2000});
         			 return false;
                 }
                 if(localAdmNameTem==null||localAdmNameTem==""){
                	 layer.msg("填写管辖单位", {ltype: 0,time:2000});
         			 return false;
                 }
                 if(chooseDayStr==null||chooseDayStr==""){
                	 flag=true;
                 } 
            	 if(flag){
            		 layer.msg("请填写完整责令整改书", {ltype: 0,time:2000});
            		 return false;
            	 }
            	 
            	 
            	 $("#staDate").val(staDateTem);
            	 $("#endDate").val(endDateTem);
            	 $("#adminGuideType").val(adminGuideTypeTem);
            	 $("#adminGuideDocType").val(adminGuideStr);
            	 $("#adminGuideCerContent").val(adminGuideCerContentStr+=chooseDayStr); 
            	 $("#linkMan").val(linkManTem);
            	 $("#tel").val(telTem);
            	 $("#assignDate").val(assignDateTem);
            	 $("#localAdmName").val(localAdmNameTem);
            	 $("#regOrgName").val(regOrgNameTem);
            	 var formParam=$('#orderreformsetform').serializeObject(); 
            	 http.httpRequest({
                     url: '/reg/server/orderreformset/commitOrderReformSet',
                     serializable: true,
                     data:formParam,
                     type: 'post',
                     success: function (data) {  
                    	 if(data.status == 'success'){ 
                    		 layer.msg("保存成功", {time: 1000}, function () {
                    			 layer.close({type: 'save'});
                    		 }); 
                    	 }else{
                    		 layer.msg("保存失败", {ltype: 0,time:2000});
                    		 layer.close({type: 'error'});
                    	 }
                     }
                 });
            }
        }]);
    }
})

  
