require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','jquery.formautofill','ystep'], function (layer, dataTable, util, http,handlebars) {
    
	var tpl_entarchivesHelpList = $("#tpl_entarchivesHelpList").html();
    var entarchivesHelpListTemplate = handlebars.compile(tpl_entarchivesHelpList);
    handlebars.registerHelper("tableNum",function(index,options){
    	return parseInt(index);
	});
    
    var mydate = new Date();
	var nowYear = mydate.getFullYear(); //获取完整的年份
	var opeYear = nowYear-1;
	
	var  priPIDs = sessionStorage.getItem("priPIDs");
	var  priPID = sessionStorage.getItem("priPID");
    
	init();
	
    /**	
     * 初始化函数集合
     */
    function init() {
    	initData();
        bind();
    }
    
    function getYearArr(){
    	var mydate = new Date();
        var year = mydate.getFullYear();
        var yearArr = [];
        for (var i = year; i > year-3; i--) {
        	yearArr.push(i);
		}
        return yearArr;
    }
    
    function autofillForSpan(data){
    	$.each( data, function(k, v) {
			$("span[id='"+k+"']").text(v ?v:"");
		});
    	
    }
    
    function autofillByBeanName(beanName,data){
    	$.each( data, function(k, v) {
			$("input[id='"+beanName+"."+k+"']").val(v ?v:"");
		});
    	
    }
    
    function autofillTextByBeanName(beanName,data){
    	$.each( data, function(k, v) {
			$("*[id='"+beanName+"."+k+"']").text(v ?v:"");
		});
    	
    }
    
    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
    
    
    /**
     * 初始化数据
     * @returns
     */
    function initData(){
      	$("#div_entarchivesOperate").val("经营状况（"+opeYear+"年度）");
    	$("#add_help").text("需求及帮扶记录（"+nowYear+"年度）");
    	$("input[id='entarchivesOperate.year']").val(opeYear);
    	
    	if(priPID){
    		$("#priPID").val(priPID);
    		$("input[id='entarchivesOperate.priPID']").val(priPID);
    		$("input[id='entarchivesAdjust.priPID']").val(priPID);
    	}
    	$("#priPIDs").val(priPIDs);
    	
    	getEntinfo(priPID);
    	
    	queryLoginUserInfo();
    	
    	
		$("#tbody_entarchivesAdjust").show();
		queryByPriPID(priPID);
		queryEntarchivesOperateByPriPIDAndYear(priPID,opeYear);
		queryEntarchivesHelpListByByPriPIDAndYear(priPID,nowYear);
		queryEntarchivesAdjustListByPriPID(priPID);
		getYearReportInfo(priPID,opeYear);
    		
    	var steps =[];
    		
    	  var showYearList = getYearArr();
    	  for (var i = 0; i < showYearList.length; i++) {
    		  steps.push({title:showYearList[i]+"年度"});
		  }
    	 
		  $(".ystep4").loadStep({
			    size: "large",
			    color: "blue",
			    steps:steps 
			});
    		
    }
    
    function queryLoginUserInfo(){
    	http.httpRequest({
            url: '/sment/entarchives/queryLoginUserInfo.json',
            type: 'post',
            success: function(data) {
	            	if(data && data.status == "success"){
	            		var userId = data.data.id;
	            		var realName = data.data.realName;
	            		var deptDID = data.data.departMent.deptDID;
	            		var deptName = data.data.departMent.deptName;
	            		
	            		$("input[id='entarchivesAdjust.adjustUserId']").val(userId);
	            		$("input[id='entarchivesAdjust.adjustDeptId']").val(deptDID);
	            		$("input[id='entarchivesAdjust.adjustDeptName']").val(deptName);
	            		$("input[id='entarchivesAdjust.adjustUserName']").val(realName);
	            		
	            	}
	            }
            })
    }
    
    function queryEntarchivesAdjustListByPriPID(priPID){
    	http.httpRequest({
            url: '/sment/entarchives/queryEntarchivesAdjustListByPriPID.json',
            data:{priPID:priPID},
            type: 'post',
            success: function(data) {
	            	if(data && data.status == "success"){
	            		var tpl_entarchivesAdjustList = $("#tpl_entarchivesAdjustList").html();
					    var entarchivesAdjustListTemplate = handlebars.compile(tpl_entarchivesAdjustList);
					    handlebars.registerHelper("adjustReason",function(){
					    	var typeName = "";
				    		var adjustReason = this.adjustReason == null ? "" :"_"+this.adjustReason;
					    	if(this.adjustState == "0"){//移除
					    		typeName = '<font color="red">移除_'+this.adjustTypeName+adjustReason+'</font>';
					    	}else{//调整
					    		typeName = '调整'+adjustReason;
					    	}
					    	typeName = new handlebars.SafeString(typeName);
	            	    	return typeName;
	            		});
						var tmpHtml = entarchivesAdjustListTemplate(data.data);
						tmpHtml='<tr><td class="center ft14"><span class="table-sp"></span>部门</td><td class="center ft14">调整人</td><td class="center  ft14">调整原因</td><td class="center  ft14">调整时间</td></tr>'+tmpHtml;
	    				$('#tbody_entarchivesAdjustList').html(tmpHtml);
	            	}
	            }
            })
    }
    
    function queryEntarchivesOperateByPriPIDAndYear(priPID,year){
    	http.httpRequest({
            url: '/sment/entarchives/queryEntarchivesOperateByPriPIDAndYear.json',
            data:{priPID:priPID,year:year},
            type: 'post',
            success: function(data) {
	            	if(data && data.status == "success"){
	            		autofillTextByBeanName("entarchivesOperate",data.data);
	            	}
	            }
            })
    }
    
    function queryEntarchivesHelpListByByPriPIDAndYear(priPID,year){
    	http.httpRequest({
            url: '/sment/entarchives/queryEntarchivesHelpListByByPriPIDAndYear.json',
            data:{priPID:priPID,year:year},
            type: 'post',
            success: function(data) {
            	debugger;
	            	if(data && data.status == "success"){
	            		$('#tbody_entarchivesHelpList').html(entarchivesHelpListTemplate(data.data));
	            	}
            	
            	}	
            })
    }
    
    function queryByPriPID(priPID){
    	http.httpRequest({
            url: '/sment/entarchives/queryByPriPID.json',
            data:{priPID:priPID},
            type: 'post',
            success: function(data) {
            	if(data && data.status == "success"){
            		autofillForSpan(data.data);
            		if(data.data.entCrowdText){
            			$("#entCrowdText").attr("disabled",false);
            		}
            		
            		if(data.data.industryType){
            			var  industryTypeArr = data.data.industryType.split(",");
            			$("input[name='industryType']").each(function (){
            				var thisObj = $(this);
            				for (var i = 0; i < industryTypeArr.length; i++) {
            					if(thisObj.val() == industryTypeArr[i]){
            						this.checked = true;
            						return;
            					}
            				}
            				
            			})
            		}
            		
            		if(data.data.entCrowdCode){
            			var  entCrowdCodeArr = data.data.entCrowdCode.split(",");
            			$("input[name='entCrowdCode']").each(function (){
            				var thisObj = $(this);
            				for (var i = 0; i < entCrowdCodeArr.length; i++) {
            					if(thisObj.val() == entCrowdCodeArr[i]){
            						this.checked = true;
            						return;
            					}
            				}
            				
            			})
            		}
            	}
            }
        })
    }
    
    function getEntinfo(priPID){
    	http.httpRequest({
            url: '/sment/rptsmBaseinfo/queryEntInfoByPriPID.json',
            data:{pripid:priPID},
            type: 'post',
            success: function(data) {
            	autofillForSpan(data.data);
            }
        })
    }
    
    function getYearReportInfo(priPID,opeYear){
    	http.httpRequest({
            url: '/sment/entarchives/queryYrAssetByPriPIDAndYear.json',
            data:{pripid:priPID,year:opeYear},
            type: 'post',
            success: function(data) {
            	if(data && data.status == "success"){
            		if(data.data){
            			$("#vendInc").text((data.data.vendInc == null || data.data.vendInc == '') ? 0 : data.data.vendInc);
            			$("#proGro").text((data.data.proGro == null || data.data.proGro == '' ) ? 0 : data.data.proGro);
            			$("#ratGro").text((data.data.ratGro == null || data.data.ratGro == '') ? 0 : data.data.ratGro);
            		}else{
            			$("#vendInc").text("-");
            			$("#proGro").text("-");
            			$("#ratGro").text("-");
            		}
            	}
            }
        })
    }
    
    function showAreaTypeTree(areaPcode,id,name){
    	layer.dialog({
            title: '选择区域类型',
            area: ['400px', '600px'],
            content: '/sment/entarchives/toEntarchivesAreaSingleTree?areaPcode='+areaPcode,
            callback: function (data) {
            	debugger;
            	$("#"+id).val('');
            	$("#"+name).val('');
            	$("#"+id).val(data.returncodes);
            	$("#"+name).val(data.returnname);
            }
        })
    }
    
    function showHelpTypeTree(index){
    	layer.dialog({
            title: '选择企业需求类别',
            area: ['400px', '600px'],
            content: '/sment/entarchives/toEntarchivesHelpTypeTree',
            callback: function (data) {
            	debugger;
            	$("input[id='entarchivesHelpList["+index+"].helpTypeCode']").val('');
            	$("input[id='entarchivesHelpList["+index+"].helpTypeName']").val('');
            	$("input[id='entarchivesHelpList["+index+"].helpTypeCode']").val(data.returncodes);
            	$("input[id='entarchivesHelpList["+index+"].helpTypeName']").val(data.returnname);
            }
        })
    }
    
    function showHelpEdit(helpData,index){
    	debugger;
    	if(helpData){
    		sessionStorage.setItem("helpData",JSON.stringify(helpData));
    	}
    	layer.dialog({
    		title: '添加需求及帮扶记录',
    		area: ['720px', '480px'],
    		content: '/sment/entarchives/toEntarchivesHelpEdit',
    		callback: function(returnData) {
    			
    			if(returnData && returnData.helpTypeCode){
					if(!helpData){
						debugger;
						returnData.priPID = priPID;
						returnData.year = nowYear;
						var returnDataArr = [];
						returnDataArr.push(returnData);
						
						var tpl_entarchivesHelpListAdd = $("#tpl_entarchivesHelpList").html();
					    var entarchivesHelpListTemplateAdd = handlebars.compile(tpl_entarchivesHelpListAdd);
					    handlebars.registerHelper("tableNum",function(tmpIndex,options){
					    	return index;
						});
					    
						var tmpHtml = entarchivesHelpListTemplateAdd(returnDataArr);
	    				$('#tbody_entarchivesHelpList').html($('#tbody_entarchivesHelpList').html()+tmpHtml);
	    			}else{
        				autofillByBeanName("entarchivesHelpList["+index+"]",returnData);
        				autofillTextByBeanName("td_entarchivesHelpList["+index+"]",returnData)
	    			}
    			}
				
    		}
		});
    }
    
    function bind() {
    	util.bindEvents([{
    		el: '#cancel',
    		event: 'click',
    		handler: function () {
    			layer.close();
    		}
    	},{
    		el: '#entCrowdCode_qt',
    		event: 'change',
    		handler: function () {
    			var checked = this.checked;
    			if(checked){
    				$("#entCrowdText").attr("disabled",false);
    			}else{
    				$("#entCrowdText").attr("disabled",true);
    				$("#entCrowdText").val("");
    			}
    		}
    	},{
    		el: '#save',
    		event: 'click',
    		handler: function () {
    			var cultivationTypeCodeText = $('input:radio[name="cultivationTypeCode"]:checked').next().text();
    			var industryNameText = $('input:checkbox[name="industryType"]:checked').next().map(function(){
					return $(this).text();
    			}).get().join(",");
    			var entCrowdCodeText = $('input:checkbox[name="entCrowdCode"]:checked').next().map(function(){
					return $(this).text();
    			}).get().join(",");
    			
    			$("#cultivationTypeName").val(cultivationTypeCodeText);
    			$("#industryName").val(industryNameText);
    			$("#entCrowdName").val(entCrowdCodeText);
    			
    			debugger;
    			var webForm = $('#webForm').serializeArray();
    			http.httpRequest({
    	             url: '/sment/entarchives/saveOrUpdate.json',
    	             data: webForm,
    	             type: 'post',
    	             success: function(data) {
    	            	 layer.msg(data.msg, {time: 3000}, function () {
                             layer.close();
                             return;
                         });
    	             }
    	         })
    		}
    	},{
    		el: '#btn_tsxz',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("TSXZ","tsxz","tsxzName");
    		}
    	},{
    		el: '#btn_zckj',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("ZCKJ","zckj","zckjName");
    		}
    	},{
    		el: '#btn_kjfhy',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("KJFHY","kjfhy","kjfhyName");
    		}
    	},{
    		el: '#btn_kjdsy',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("KJDSY","kjdsy","kjdsyName");
    		}
    	},{
    		el: '#btn_xwqyy',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("XWQYY","xwqyy","xwqyyName");
    		}
    	}
    	,{
    		el: '#btn_qt',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("QT","qt","qtName");
    		}
    	},{
        	el:'.a-entarchivesHelpList',
        	event:'click',
        	handler:function(){showHelpTypeTree($(this).attr("data-index"))}
        },{
        	el:'.list-edit',
        	event:'click',
        	handler:function(){
        		
        		var index = $(this).attr("data-index");
        		
        		var helpData = {};
        		$("input[id^='entarchivesHelpList["+index+"]']").each(function (){
        			debugger;
        			var id = $(this).attr("id");
        			var val = $(this).val();
        			
        			var key = id.replace("entarchivesHelpList["+index+"].","");
        			helpData[key] = val;
        			
        		});
        		showHelpEdit(helpData,index);
        	}
        },{
        	el:'.list-delete',
        	event:'click',
        	handler:function(){
        		$(this).parent().parent().remove();
        	}
        },{
        	
        	el:'.ystep-container-steps li',
        	event:'click',
        	handler:function(){
        		var index = $(this).index();
        		var count = index + 1;
        		$(".ystep4").setStep(count);
        		var selectYear = getYearArr()[index];
        		var selectOpeYear = selectYear -1 ;
        		$("#div_entarchivesOperate").text("经营状况（"+selectOpeYear+"年度）");
            	$("#add_help").text("需求及帮扶记录（"+selectYear+"年度）");
            	$("input[id='entarchivesOperate.year']").val(selectOpeYear);
            	
            	$(".yearReport").text("");
        		$("input[id^='entarchivesOperate").val("");
            	$("#tbody_entarchivesHelpList").html("");
            	queryEntarchivesOperateByPriPIDAndYear(priPID,selectOpeYear);
            	queryEntarchivesHelpListByByPriPIDAndYear(priPID,selectYear);
            	getYearReportInfo(priPID,selectOpeYear);
        		
        	}
        }
    	
    	]);
    }
    
})
