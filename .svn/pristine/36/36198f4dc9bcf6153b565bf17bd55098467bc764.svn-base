require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','jquery.formautofill','ztree','ztreeCheck','ztreeHide'], function (layer, dataTable, util, http,handlebars) {

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
    	showAreaTree("tsxzName","TSXZ");
    	showAreaTree("zckjName","ZCKJ");
    	showAreaTree("kjfhyName","KJFHY");
    	showAreaTree("kjdsyName","KJDSY");
    	showAreaTree("xwqyyName","XWQYY");
    	showAreaTree("qtName","QT");
    	$("#div_entarchivesOperate").val("经营状况（"+opeYear+"年度）");
    	$("#add_help").val("添加需求及帮扶记录（"+nowYear+"年度）");
    	$("input[id='entarchivesOperate.year']").val(opeYear);
    	
    	if(priPID){
    		$("#priPID").val(priPID);
    		$("input[id='entarchivesOperate.priPID']").val(priPID);
    		$("input[id='entarchivesAdjust.priPID']").val(priPID);
    	}
    	
    	$("#priPIDs").val(priPIDs);
    	
    	var isEdit = getUrlParam("isEdit");//如何是修改
    	var isAdd = getUrlParam("isAdd");//如何是单条新增

    	if(isAdd || isEdit){
    		
    		getEntinfo(priPID);
        	
        	queryLoginUserInfo();
        	queryEntarchivesOperateByPriPIDAndYear(priPID,opeYear);
        	queryEntarchivesHelpListByByPriPIDAndYear(priPID,nowYear);
        	queryByPriPID(priPID,isAdd);
        	queryEntarchivesAdjustListByPriPID(priPID);
        	getYearReportInfo(priPID,opeYear);
    	}
    
    	if(isEdit){
    		$("#tbody_entarchivesAdjust").show();
    	}
    		
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
					    	if(this.adjustState == "0"){//移除
					    		typeName = '<font color="red">移除_'+this.adjustTypeName+'_'+this.adjustReason+'</font>';
					    	}else{//调整
					    		typeName = '调整_'+this.adjustReason;
					    	}
					    	typeName = new handlebars.SafeString(typeName);
	            	    	return typeName;
	            		});
						var tmpHtml = entarchivesAdjustListTemplate(data.data);
						tmpHtml='<tr><td class="center  ft14"><span class="table-sp"></span>部门</td><td class="center  ft14">调整人</td><td class="center  ft14">调整原因</td><td class="center  ft14">调整时间</td></tr>'+tmpHtml;
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
	            		autofillByBeanName("entarchivesOperate",data.data);
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
	            	if(data && data.status == "success"){
	            		if(data.data.length>0){
	            			var tpl_entarchivesHelpList = $("#tpl_entarchivesHelpList").html();
		            	    var entarchivesHelpListTemplate = handlebars.compile(tpl_entarchivesHelpList);
		            	    handlebars.registerHelper("tableNum",function(index,options){
		            	    	return parseInt(index);
		            		});
		            		$('#tbody_entarchivesHelpList').html(entarchivesHelpListTemplate(data.data));
	            		}else{
	            			showHelpEdit(0);
	            		}
	            		
	            	}
            	
            	}	
            })
    }
    
    function queryByPriPID(priPID,isAdd){
    	http.httpRequest({
            url: '/sment/entarchives/queryByPriPID.json',
            data:{priPID:priPID,isAdd:isAdd},
            type: 'post',
            success: function(data) {
            	if(data && data.status == "success" && data.data){
            		
            		var options = {
            				findbyname: false
            		}
            		$("#webForm").autofill( data.data, options );
            		
            		var isEdit = getUrlParam("isEdit");//如何是修改
                	var isAdd = getUrlParam("isAdd");//如何是单条新增
            		if(isAdd && !isEdit){
            			$("#priPIDs").val(priPID);
                		$("#uid").val("");
                	}
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
            		
            		//回显区域类型选项
            		if(data.data.tsxz){
            			$("#chk_tsxzName").attr("checked","checked");
            		}
            		if(data.data.zckj){
            			$("#chk_zckjName").attr("checked","checked");
            		}
            		if(data.data.kjfhy){
            			$("#chk_kjfhyName").attr("checked","checked");
            		}
            		if(data.data.kjdsy){
            			$("#chk_kjdsyName").attr("checked","checked");
            		}
            		if(data.data.xwqyy){
            			$("#chk_xwqyyName").attr("checked","checked");
            		}
            		if(data.data.qt){
            			$("#chk_qtName").attr("checked","checked");
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
//            			autofillForSpan(data.data);
            			$("#vendInc").text((data.data.vendInc == null || data.data.vendInc == '') ? 0 : data.data.vendInc);
            			$("#proGro").text((data.data.proGro == null || data.data.proGro == '' ) ? 0 : data.data.proGro);
            			$("#ratGro").text((data.data.ratGro == null || data.data.ratGro == '') ? 0 : data.data.ratGro);
            			if(data.data.vendInc > 10000){
            				$("#vendInc").css({color:"red"}); 
            				$("#span_errorText").show();
            			}
            			if(data.data.proGro > 5000){
            				$("#proGro").css({color:"red"}); 
            				$("#span_errorText").show();
            			}
            			if(data.data.ratGro > 2000){
            				$("#ratGro").css({color:"red"});
            				$("#span_errorText").show();
            			}
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
            	$("#"+id).val('');
            	$("#"+name).val('');
            	$("#"+id).val(data.returncodes);
            	$("#"+name).val(data.returnname);
            }
        })
    }
    
    function showHelpEdit(index){
		var returnData = {priPID:priPID,year:nowYear}
		var returnDataArr = [];
		returnDataArr.push(returnData);
		
		var tpl_entarchivesHelpListAdd = $("#tpl_entarchivesHelpList").html();
	    var entarchivesHelpListTemplateAdd = handlebars.compile(tpl_entarchivesHelpListAdd);
	    handlebars.registerHelper("tableNum",function(tmpIndex,options){
	    	return index;
		});
	    
		var tmpHtml = entarchivesHelpListTemplateAdd(returnDataArr);
		$('#tbody_entarchivesHelpList').append(tmpHtml);
    }
    
    function showMenu(jqObj) {
    	hideMenu();
		var cityOffset =jqObj.offset();
		jqObj.parent().next().css({left:cityOffset.left + "px", top:cityOffset.top + jqObj.outerHeight() + "px"}).slideDown("fast");
	}
    
    function showMenuForAdd(jqObj) {
    	hideMenu();
		var cityOffset =jqObj.offset();
		jqObj.parent().next().css({left:cityOffset.left + "px", top:cityOffset.top + jqObj.outerHeight() + "px"}).slideDown("fast");
	}

    function treeClick(e, treeId, treeNode) {
    	var check = (treeNode && !treeNode.isParent);
		if (!check){
			$("#"+treeId).parent().prev().find(".treeName").val("");
			$("#"+treeId).parent().prev().find(".treeCode").val("");
		}else{
			var zTree = $.fn.zTree.getZTreeObj(treeId);
			var nodes = zTree.getSelectedNodes();
			var v = "";
			var c="";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
				c += nodes[i].id + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			
			$("#"+treeId).parent().prev().find(".treeName").val(v);
			$("#"+treeId).parent().prev().find(".treeCode").val(c);
		}
		
		hideMenu();
	}
    
    function treeClickForAdd(e, treeId, treeNode) {
    	var check = (treeNode && !treeNode.isParent);
		if (!check){
			$("#"+treeId).parent().prev().find(".treeName").val("");
			$("#"+treeId).parent().prev().find(".treeCode").val("");
		}else{
			var zTree = $.fn.zTree.getZTreeObj(treeId);
			var nodes = zTree.getSelectedNodes();
			var v = "";
			var c="";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].areaName + ",";
				c += nodes[i].areaCode + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			
			$("#"+treeId).parent().prev().find(".treeName").val(v);
			$("#"+treeId).parent().prev().find(".treeCode").val(c);
		}
		hideMenu();
	}
    
    function hideMenu() {
    	$(".ztree").fadeOut("fast");
	}
    
    function treeOnBodyDown(event) {
    	if (!($(event.target).hasClass(".entarchivesHelpList")  || $(event.target).hasClass(".ztree") || $(event.target).parents(".ztree").length>0)) {
			hideMenu();
		}
	}
    
    function showAreaTree(id,areaPcode){
        //权限树配置
	    var treeSetting = {
	    		view: {
	    			showIcon: false
	    		},
				data: {
					key: {
		                   name: "areaName",
		                   title: "areaName"
		               },
		               simpleData: {
		                   enable: true,
		                   idKey: 'areaCode',
		                   pIdKey: 'areaPcode',
		                   rootPId: null
		               }
		           },
				callback: {
					onClick: treeClickForAdd
				}
	    };
	    
	    //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/sment/areatype/queryListByAreaPcode.json?areaPcode='+areaPcode,
            success: function (data) {
               $.fn.zTree.init($('#ztree_ul_'+id), treeSetting, data.data);
            }
        });
    }
    
    function addAreaTreeNode(id,val,areaPcode){
    	debugger;
    	val = $.trim(val);
    	if("" == val){
    		layer.msg("信息不能为空",{time:1000});
    	}else{
    		var zTree = $.fn.zTree.getZTreeObj("ztree_ul_"+id);
    		var nodeList = zTree.getNodesByParamFuzzy("areaName", val);
			 layer.confirm('确定新增此信息?', {icon: 2, title: '提示'}, function (index) {
	             http.httpRequest({
	                 url: '/sment/areatype/edit',
	                 data: {areaName:val,areaPcode:areaPcode},
	                 success: function (data) {
	                     if (data.status == 'success') {
	                    	 $("#"+id).next().val(data.data.areaCode);
	                    	 showAreaTree(id,areaPcode);
	                     }else{
	                    	 if (data.msg) {
	                             layer.msg(data.msg, {time: 3000});
	                         }
	                     }
	                 }
	             });
	
	         });
    	}
    }
    
    function showHelpTypeTree(jqObj){

	    //权限树配置
	    var treeSetting = {
	    		view: {
	    			showIcon: false
	    		},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onClick: treeClick
				}
	    };
	//需求类别树data
	var HelpTypeCodeData = [ {
		"id" : "GS",
		"pId" : "0",
		"name" : "工商(市场监管)类",
		"nocheck":"true"
	}, {
		"id" : "ZYHFW",
		"pId" : "0",
		"name" : "专业化服务类",
		 "nocheck":"true"
	}, {
		"id" : "QT",
		"pId" : "0",
		"name" : "其他需求",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_CWGL",
		"pId" : "ZYHFW",
		"name" : "财务管理类",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_FLZX",
		"pId" : "ZYHFW",
		"name" : "法律咨询",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_QT",
		"pId" : "ZYHFW",
		"name" : "其他需求",
		 "nocheck":"true"
	}, {
		"id" : "GS_QYZC",
		"pId" : "GS",
		"name" : "企业注册",
		 "nocheck":"true"
	}, {
		"id" : "GS_SBZC",
		"pId" : "GS",
		"name" : "商标注册",
		 "nocheck":"true"
	}, {
		"id" : "GS_DJWQ",
		"pId" : "GS",
		"name" : "打假维权",
		 "nocheck":"true"
	}, {
		"id" : "GS_XYJS",
		"pId" : "GS",
		"name" : "信用建设",
		 "nocheck":"true"
	}, {
		"id" : "GS_QT",
		"pId" : "GS",
		"name" : "其他"
	}, {
		"id" : "ZYHFW_CWGL_GSMS",
		"pId" : "ZYHFW_CWGL",
		"name" : "公司秘书",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_CWGL_KJZX",
		"pId" : "ZYHFW_CWGL",
		"name" : "会计咨询",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_CWGL_SJJZ",
		"pId" : "ZYHFW_CWGL",
		"name" : "审计鉴证",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_CWGL_ZCPG",
		"pId" : "ZYHFW_CWGL",
		"name" : "资产评估"
	}, {
		"id" : "ZYHFW_FLZX_YDYCQBH",
		"pId" : "ZYHFW_FLZX",
		"name" : "一对一知识产权保护",
		 "nocheck":"true"
	}, {
		"id" : "ZYHFW_FLZX_ZSJZ",
		"pId" : "ZYHFW_FLZX",
		"name" : "法律知识讲座"
	}, {
		"id" : "ZYHFW_QT_SSFD",
		"pId" : "ZYHFW_QT",
		"name" : "上市辅导"
	}, {
		"id" : "ZYHFW_QT_GPQYRZPX",
		"pId" : "ZYHFW_QT",
		"name" : "挂牌企业融资培训"
	}, {
		"id" : "ZYHFW_QT_QHCPZX",
		"pId" : "ZYHFW_QT",
		"name" : "期货产品咨询"
	}, {
		"id" : "ZYHFW_QT_JGGLPX",
		"pId" : "ZYHFW_QT",
		"name" : "经管管理培训"
	}, {
		"id" : "ZYHFW_QT_JYJCFW",
		"pId" : "ZYHFW_QT",
		"name" : "检验检测服务"
	}, {
		"id" : "QT_RZQDTK",
		"pId" : "QT",
		"name" : "融资渠道拓宽"
	}, {
		"id" : "QT_SSYHZCZX",
		"pId" : "QT",
		"name" : "税收优惠政策咨询"
	}, {
		"id" : "QT_TDYHZCZX",
		"pId" : "QT",
		"name" : "土地优惠政策咨询"
	}, {
		"id" : "GS_QYZC_GSZCBGDJ",
		"pId" : "GS_QYZC",
		"name" : "工商注册变更登记"
	}, {
		"id" : "GS_SBZC_SBZC",
		"pId" : "GS_SBZC",
		"name" : "商标注册"
	}, {
		"id" : "GS_SBZC_CMZMSBSB",
		"pId" : "GS_SBZC",
		"name" : "驰名著名商标申报"
	}, {
		"id" : "GS_SBZC_CMZMSBYX",
		"pId" : "GS_SBZC",
		"name" : "驰名著名商标延续"
	}, {
		"id" : "GS_DJWQ_SYMMBH",
		"pId" : "GS_DJWQ",
		"name" : "商业秘密保护"
	}, {
		"id" : "GS_DJWQ_SBQBH",
		"pId" : "GS_DJWQ",
		"name" : "商标权保护"
	}, {
		"id" : "GS_DJWQ_SHQBH",
		"pId" : "GS_DJWQ",
		"name" : "商号权保护"
	}, {
		"id" : "GS_DJWQ_SPBZ",
		"pId" : "GS_DJWQ",
		"name" : "商品包装"
	}, {
		"id" : "GS_DJWQ_HQBH",
		"pId" : "GS_DJWQ",
		"name" : "潢权保护"
	}, {
		"id" : "GS_DJWQ_QT",
		"pId" : "GS_DJWQ",
		"name" : "其他"
	}, {
		"id" : "GS_XYJS_SHTZXYQYSQ",
		"pId" : "GS_XYJS",
		"name" : "守合同重信用企业申请"
	}, {
		"id" : "GS_XYJS_XYGLSFQYSQ",
		"pId" : "GS_XYJS",
		"name" : "信用管理示范企业申请"
	}, {
		"id" : "ZYHFW_CWGL_GSMS_DL",
		"pId" : "ZYHFW_CWGL_GSMS",
		"name" : "代理登记、代理记账、代理年度报告申报、代理申办相关法律手续"
	}, {
		"id" : "ZYHFW_CWGL_KJZX_ZXPX",
		"pId" : "ZYHFW_CWGL_KJZX",
		"name" : "会计、税务等咨询和培训服务"
	}, {
		"id" : "ZYHFW_CWGL_SJJZ_SJSYPGFW",
		"pId" : "ZYHFW_CWGL_SJJZ",
		"name" : "审计、审阅、评估服务"
	}, {
		"id" : "ZYHFW_FLZX_YDYCQBH_DHZX",
		"pId" : "ZYHFW_FLZX_YDYCQBH",
		"name" : "电话咨询"
	}, {
		"id" : "ZYHFW_FLZX_YDYCQBH_QYZF",
		"pId" : "ZYHFW_FLZX_YDYCQBH",
		"name" : "企业走访"
	} ];
		
    	showMenu(jqObj);
    	$.fn.zTree.init(jqObj.parent().next().children(), treeSetting, HelpTypeCodeData);
    }
    
    function bind() {
    	$("body").bind("mousedown", treeOnBodyDown);
    	
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
    		el: '#add_help',
    		event: 'click',
    		handler: function () {
    			var  lastTr = $("#tbody_entarchivesHelpList tr:last");
    			var index = 0;
    			if(lastTr && lastTr.length == 1){
    				index = parseInt(lastTr.attr("data-index")) + 1;
    			}
    			showHelpEdit(index);
    		}
    	},{
    		el: '#save',
    		event: 'click',
    		handler: function () {
    			 if(!docheck())return false;
    			var cultivationTypeCodeText = $('input:radio[name="cultivationTypeCode"]:checked').next().text();
    			var industryNameText = $('input:checkbox[name="industryType"]:checked').next().map(function(){
					return $(this).text();
    			}).get().join(",");
    			var entCrowdCodeText = $('input:checkbox[name="entCrowdCode"]:checked').next().map(function(){
					return $(this).text();
    			}).get().join(",");
    			
    			$(".qylx").each(function (){
    				if($.trim($(this).val()) == ""){
    					$(this).next().val("");
    				}
    			});
    			
    			$("#cultivationTypeName").val(cultivationTypeCodeText);
    			$("#industryName").val(industryNameText);
    			$("#entCrowdName").val(entCrowdCodeText);
    			
    			var webForm = $('#webForm').serializeArray();
    			http.httpRequest({
    	             url: '/sment/entarchives/saveOrUpdate.json',
    	             data: webForm,
    	             type: 'post',
    	             success: function(data) {
    	            	 layer.msg(data.msg, {time: 3000}, function () {
                             layer.close({reload: true});
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
    	},
    	{
    		el: '#btn_qt',
    		event: 'click',
    		handler: function () {
    			showAreaTypeTree("QT","qt","qtName");
    		}
    	},{
        	el:'.list-delete',
        	event:'click',
        	handler:function(){
        		$(this).parent().parent().remove();
        	}
        },{
        	el:'#btn_wh',
        	event:'click',
        	handler:function(){
	    		 layer.dialog({
	                 title: '区域类型-维护',
	                 area: ['100%', '100%'],
	                 content: '/sment/areatype/areaTypeManage',
	                 callback: function (data) {
	                   	 if (data.reload) { //close是否有传递此参数
	                         table.ajax.reload();
	                     }
	   				}
	             })
        	}
        },{
        	el:'input:radio[name="cultivationTypeCode"]',
        	event:'click',
        	handler:function(){
        		var isEdit = getUrlParam("isEdit");//如何是修改
        		if(isEdit){
        			var nowCultivationTypeName = $(this).next().text();
            		var cultivationTypeName = $("#cultivationTypeName").val();
            		if (cultivationTypeName && nowCultivationTypeName != cultivationTypeName) {
            			
            			$("textarea[id='entarchivesAdjust.adjustReason']").val("由于规模变化，将"+cultivationTypeName+"调整为"+nowCultivationTypeName);
            		}else{
            			$("textarea[id='entarchivesAdjust.adjustReason']").val("");
            		}
        		}
        		
        	}
        },{
        	el:'.a_entarchivesHelpList',
        	event:'click',
        	handler:function(){showHelpTypeTree($(this))}
        },{
        	el:'#tsxzName,#zckjName,#kjfhyName,#kjdsyName,#xwqyyName,#qtName',
        	event:'click',
        	handler:function(){
	        	var thisObj = $(this);
	        	showMenu(thisObj);
        	}
        },{
        	el:'#tsxzName,#zckjName,#kjfhyName,#kjdsyName,#xwqyyName,#qtName',
        	event:'keyup',
        	handler:function(){
        		debugger;
        		var thisObj = $(this);
        		//showMenu(thisObj);
        		var zTree = $.fn.zTree.getZTreeObj("ztree_ul_"+thisObj.attr("id"));
        		var nodes = zTree.getNodes();
        		if($.trim(thisObj.val()) != ""){
        			var nodeList = zTree.getNodesByParamFuzzy("areaName", thisObj.val());
        			if(nodeList && nodeList.length >=1){
        				zTree.hideNodes(nodes);
        				zTree.showNodes(nodeList);
					}else{
						//zTree.hideNodes(nodes);
						//hideMenu();
					}
        		}else{
        			zTree.showNodes(nodes);
        			showMenu(thisObj);
        		}
        	}
        },{
        	el:'#a_tsxzName,#a_zckjName,#a_kjfhyName,#a_kjdsyName,#a_xwqyyName,#a_qtName',
        	event:'click',
        	handler:function(){
        		var thisObj = $(this);
        		addAreaTreeNode(thisObj.attr("data-id"),thisObj.prev().prev().val(),thisObj.attr("data-pcode"));
        	}
        },{
        	el:'input:radio[name="qylx"]',
        	event:'click',
        	handler:function(){
        		debugger;
        		$('input:radio[name="qylx"]').each(function (){
        			var thisObj = $(this);
            		var txtObj = thisObj.parent().next().children().children();
            		txtObj.attr("disabled",true);
        		});
        		var thisObj = $(this);
        		var txtObj = thisObj.parent().next().children().children();
        		txtObj.attr("disabled",false);
        	}
        }
    	]);
    }
    
    function docheck(){
    	var isEdit = getUrlParam("isEdit");//如何是修改
       /* if ($.trim($("#entPrincipal").val()) == ""&&isEdit) {
    		layer.msg("企业负责人不能为空", {time: 1000},function(){
    			$("#entPrincipal").focus();
    		});
    		return false;
        }
    	if ($.trim($("#entContact").val()) == ""&&isEdit) {
    		layer.msg("企业联络人不能为空", {time: 1000},function(){
    			$("#entContact").focus();
    		});
    		return false;
        }*/
    	if ($.trim($("input[name='cultivationTypeCode']:checked").val()) == "") {
      		 layer.msg("培育库类型不能为空", {time: 1000},function(){
       		});
      		return false;
        }
    	if ($.trim($("input[name='industryType']:checked").val()) == "") {
    		layer.msg("八大重点产业不能为空", {time: 1000},function(){
    		});
    		return false;
    	}
    	if ($.trim($("input[name='qylx']:checked").val()) == "") {
    		layer.msg("区域类型不能为空", {time: 1000},function(){
    		});
    		return false;
    	}
    	if ($.trim($("input[name='entCrowdCode']:checked").val()) == "") {
    		layer.msg("创业人群不能为空", {time: 1000},function(){
    		});
    		return false;
    	}
    	/*if ($.trim($("#entPrincipalTel").val()) == ""&&isEdit) {
      		 layer.msg("企业负责人联系电话不能为空", {time: 1000},function(){
       		});
      		return false;
        }
    	if ($.trim($("#entContactTel").val()) == ""&&isEdit) {
     		 layer.msg("企业联络人联系电话不能为空", {time: 1000},function(){
      		});
     		return false;
       }*/
    	
    	if($.trim($("textarea[id='entarchivesAdjust.adjustReason']").val())==""&&isEdit){
    		layer.msg("调整原因不能为空",{time:1000},function(){
    			$("textarea[id='entarchivesAdjust.adjustReason']").focus();
    		});
    		return false;
    	}
    	if($.trim($("input[id='entarchivesAdjust.adjustTime']").val())==""&&isEdit){
    		layer.msg("调整时间未选择",{time:1000},function(){
    		});
    		return false;
    	}
    	
    	var isNull = false;
    	$(".helpTypeName").each(function (){
    		var thisVal = $(this).val();
    		if(!$.trim(thisVal)){
    			isNull = true;
    			return false;
    		}
    	});
    	if(isNull){
    		layer.msg("需求类型不能为空",{time:1000},function(){
    		});
    		return false;
    	}
    	
    	return true;
    }
})
