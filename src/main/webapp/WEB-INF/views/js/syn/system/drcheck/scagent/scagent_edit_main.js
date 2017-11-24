require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
        bind();
    }
    
    $("#deptCatgM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    function formvalid(){
    	var employeeNO = $("#employeeNO").val();
    	if(employeeNO != "" && employeeNO.length > 25){
    		layer.tips("单位工号不能超过25个英文字符",$("#employeeNO"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	var localAdmName = $("#localAdmName").val();
    	if(localAdmName == ""){
    		layer.tips("请选择工作单位",$("#localAdmName"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var agentSex = $("#agentSexDiv input[name='agentSex']:checked").val();
    	if(agentSex == "" || agentSex == null || agentSex == "undefined"){
    		layer.tips("请选择性别",$("#agentSex1"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var agentArea = $("#agentArea").val();
    	if(agentArea == ""){
    		layer.tips("请选择单位所属地区",$("#agentArea"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var agentName = $("#agentName").val();
    	if(agentName == "" || agentName.length > 100){
    		layer.tips("请输入50个中文字以内的姓名",$("#agentName"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var unitLevel = $("#unitLevelDiv input[name='unitLevel']:checked").val();
    	if(unitLevel == "" || unitLevel == null || unitLevel == "undefined"){
    		layer.tips("请选择单位层级",$("#unitLevel1"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	if(unitLevel == "1" || unitLevel == "2" || unitLevel == "3"){
    		$("#unitType").val("1");
    	}else if(unitLevel == "4" ){
    		$("#unitType").val("2");
    	}
    	var agentNO = $("#agentNO").val();
    	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
    	if(!reg.test(agentNO)){  
    		layer.tips("请输入有效的身份证件号码",$("#agentNO"),{tips:3, tipsMore:true, ltype:0});
	        return  false;
	    }  
    	var unitName = $("#unitName").val();
    	if(unitName == ""){
    		layer.tips("请输入50个中文字以内的所在业务部门（机构）",$("#unitName"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var agentPosition = $("#agentPosition").val();
    	if(agentPosition == ""){
    		layer.tips("请选择担任职务",$("#agentPosition"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var deptCatgM = $("#deptCatgM").val();
    	if(deptCatgM == "" || deptCatgM == null || deptCatgM == "undefined"){
    		layer.tips("请选择从事岗位（大类）",$("#deptCatgDiv"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	$("#deptCatg").val(deptCatgM);
    	var mobile = $("#mobile").val();
    	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/; 
    	if(!myreg.test($("#mobile").val())){ 
    		layer.tips("请输入有效的手机号码",$("#mobile"),{tips:3, tipsMore:true, ltype:0});
    	    return false; 
    	} 
//    	var studyLevel = $("#studyLevel").val();
//    	if(studyLevel == ""){
//    		layer.tips("请选择最高学历",$("#studyLevel"),{tips:3, tipsMore:true, ltype:0});
//    		return false;
//    	}
//    	var workTime = $("#workTime").val();
//    	if(workTime == "" || workTime == null || workTime == "undefined"){
//    		layer.tips("请选择从事本岗起始日期",$("#workTime"),{tips:3, tipsMore:true, ltype:0});
//    		return false;
//    	}
    	var professionals = $("#professionals").val();
    	if(professionals != "" && professionals.length > 100){
    		layer.tips("请输入50个中文字以内的学历专业",$("#professionals"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var lawNO = $("#lawNO").val();
    	if(lawNO != "" && lawNO.length > 50){
    		layer.tips("工商部门执法证编号不能超过50个英文字符",$("#lawNO"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var technicalTitle = $("#technicalTitle").val();
    	if(technicalTitle != "" && technicalTitle.length > 50){
    		layer.tips("个人专业技术职称不能超过50个中文字",$("#technicalTitle"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var govLawNO = $("#govLawNO").val();
    	if(govLawNO != "" && govLawNO.length > 50){
    		layer.tips("省政府执法证编号不能超过50个英文字符",$("#govLawNO"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var stationTermM = $("#stationTermDiv input[name='stationTermM']:checked").val();
    	if(stationTermM == "" || stationTermM == null || stationTermM == "undefined"){
    		layer.tips("请选择有无获得岗位资格资质",$("#stationTermN"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var stationTerm = stationTermM;
    	if(stationTerm == "Y"){
    		$(".stationTermM").each(function(){
    			if($(this).prop("checked")){
    				var value = $(this).val();
    				stationTerm += ","+value;
    			}
    		});
    	}
    	$("#stationTerm").val(stationTerm);
    	var expertFlagM = $("#expertFlagDiv input[name='expertFlagM']:checked").val();
    	if(expertFlagM == "" || expertFlagM == null || expertFlagM == "undefined"){
    		layer.tips("请选择有无获得岗位资格资质",$("#expertFlagN"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var expertFlag = expertFlagM;
    	if(expertFlag == "Y"){
    		$(".expertFlagK").each(function(){
    			if($(this).prop("checked")){
    				var value = $(this).val();
    				expertFlag += ","+value;
    			}
    		});
    	}
    	$("#expertFlag").val(expertFlag);
    	var agentState = $("#agentStateDiv input[name='agentState']:checked").val();
    	if(agentState == "" || agentState == null || agentState == "undefined"){
    		layer.tips("请选择执法人员状态",$("#agentState1"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	
    	return true;
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
              }
        },{
            el: '#choseSysUser',
            event: 'click',
            handler: function () {
            	layer.dialog({
        			title:"选择关联的账号",
        			area:['90%','80%'],
        			content:'/syn/server/drcheck/pubscagent/viewsys',
        			callback:function(data){
        				if(data.reload){
        					$("#username").val(data.username);
        					$("#relateUserUid").val(data.userid);
        				}
        			}
        		});
            }
        },{
        	el: '#save',
        	event: 'click',
        	handler: function () {
        		if(formvalid()){
        			var formParam = $('#sysUserForm').serializeObject();
        			http.httpRequest({
        				url: '/syn/server/drcheck/pubscagent/save',
        				data: formParam,
        				type: 'post',
        				success: function (data) {
        					layer.msg(data.msg, {time: 1000}, function () {
        						if(data.status == 'success'){
        							layer.close({reload: true});
        						}
        					});
        				}
        			})
        		}
        	}
        },{
        	el: '#choseregUnit',
            event: 'click',
            handler: function () { 
            	var userType = $("#userType").val();
            	var dutyDeptCode = $("#dutyDeptCodes").val();
            	if(userType == "1" || dutyDeptCode == "A058"){
	                  layer.dialog({
		                  title: '选择工作单位',
		                  area: ['350px', '666px'],
		                  content: '/commom/server/regunit/regunitsingselect',
		                  callback: function (data) {
		                  	var returncode=data.returncode;
		                    	$("#localAdm").val(returncode);
		                    	$("#localAdmName").val(data.returname); 
		                  }
		              })
            	}else{
            		layer.dialog({
            			title: '选择工作单位',
            			area: ['400px', '600px'],
            			content: '/common/system/sysdepart/deptSelectByDuty?treeType=radio&dutyDeptCodes='+dutyDeptCode+"&isNoCheck=true",
            			callback: function (data) {
            				if(data.adCodes){
            					var adcodes = data.adCodes
            					$("#localAdm").val(adcodes.substring(0,8));
            					$("#localAdmName").val(data.orgNames);
            				}
            			}
            		})
            	}
            }
        },{
        	el: '#stationTermN',
        	event: 'click',
        	handler: function () {
        		if($(this).prop("checked")){
        			$(".stationTermM").prop("checked",false);
        			$(".stationTermM").attr("disabled","disabled");
        		}
        	}
        },{
        	el: '#stationTermM',
        	event: 'click',
        	handler: function () {
        		if($(this).prop("checked")){
        			$(".stationTermM").removeAttr("disabled");
        		}
        	}
        },{
        	el: '.stationTermM',
        	event: 'click',
        	handler: function () {
        		if($(this).prop("checked")){
        			$("#stationTermM").prop("checked",true);
        		}
        	}
        },{
        	el: '#expertFlagN',
        	event: 'click',
        	handler: function () {
        		if($(this).prop("checked")){
        			$(".expertFlagK").prop("checked",false);
        			$(".expertFlagK").attr("disabled","disabled");
        		}
        	}
        },{
        	el: '#expertFlagM',
        	event: 'click',
        	handler: function () {
        		if($(this).prop("checked")){
        			$(".expertFlagK").removeAttr("disabled");
        		}
        	}
        },{
        	el: '.expertFlagK',
        	event: 'click',
        	handler: function () {
        		if($(this).prop("checked")){
        			$("#expertFlagM").prop("checked",true);
        		}
        	}
        },{
          el: '#agentNO',
          event: 'blur',
          handler: function () {
        	  var birthday = "";  
        	  var idCard = $(this).val();
        	  var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
          	  if(!reg.test(idCard)){  
          		  layer.tips("请输入有效的身份证件号码",$("#agentNO"),{tips:3, tipsMore:true, ltype:0});
      	          return  false;
      	      }
              if(idCard.length == 15){  
                  birthday = "19"+idCard.substr(6,4);  
              }else if(idCard.length == 18){  
                  birthday = idCard.substr(6,6);  
              }  
              birthday = birthday.replace(/(.{4})(.{2})/,"$1年$2月");  
              $("#birthDay").val(birthday);
              var myDate = new Date(); 
              var month = myDate.getMonth() + 1; 
              var day = myDate.getDate(); 
              var age = 0;
              if(idCard.length == 15){ 
            	  var age15 = "19"+idCard.substring(6,8);
            	  age = myDate.getFullYear()-age15; 
              }else if(idCard.length == 18){  
            	  age = myDate.getFullYear()-idCard.substring(6, 10); 
              }
              if (idCard.substring(10,12)<month||idCard.substring(10,12)==month&&idCard.substring(12,14)<=day){ 
            	  age++; 
              } 
              $("#agentAge").val(age);
	     }
	  },{
          el: '#agentRangeA',
          event: 'click',
          handler: function () { 
              layer.dialog({
                  title: '选择执法事项清单',
                  area: ['400px', '600px'],
                  content: '/syn/server/drcheck/pubscagent/scPtypeSelect?isPermissionCheck=true',
                  callback: function (data) { 
                  	$("#agentRangeName").val(data.returnname);  
                  }
              })
          }
      }])
    }

})