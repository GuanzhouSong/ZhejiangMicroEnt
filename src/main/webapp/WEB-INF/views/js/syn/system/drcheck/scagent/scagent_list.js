require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

	var searchParams={};
	var table;
	
    init();
    
    /**
     * 初始化函数集合
     */
    function init() { 
        initDataTable();
        bind();
    }
    
    $("#deptCatgM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#expertFlagM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#stationTermM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#unitLevelM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#studyLevelM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#lawTypeM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#agentPositionM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#agentAreaM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 15
    });

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#scstack-table',
            showIndex: true,
            scrollX:true,
            ajax: {
                url:'/syn/server/drcheck/pubscagent/listJSON',
                data:function(d){
	               		 d.params = $("#qryForm").serializeObject();
                }
            },
            columns: [
                {data: '_idx', 'className': 'center'},
                {data: null, 'className': 'center'},
                {data: 'agentName', 'className': 'center'},
                {data: 'agentSex'},
                {data: 'employeeNO'},
                {data: 'agentNO'},
                {data: 'mobile'},
                {data: 'studyLevel'},
                {data: 'agentAge'},
                {data: 'deptCatg'},
                {data: 'expertFlag'},
                {data: 'agentState'},
                {data: 'agentArea'},
                {data: 'unitLevel'},
                {data: 'unitName'},
                {data: 'agentPosition'},
                {data: 'slicenNOName'},
                {data: 'lawNO'},
                {data: 'lawEndDate'},
                {data: 'govLawNO'},
                {data: 'govLawEndDate'},
                {data: 'setUserName'},
                {data: 'setTime'}
            ],
            columnDefs: [
			 {
				targets: 1,
			    render: function (data, type, row, meta) {
			      	return "<a class='commit js_update'>修改</a><a class='commit js_show'>详情</a>";
			    	   	 
			   }
		    },{
				targets: 3,
			    render: function (data, type, row, meta) {
			    	if(row.agentSex =='1'){
			    		return "男";
			    	}else if(row.agentSex =='2'){
			    		return "女";
			    	}else{
			    		return "";
			    	}
			   }
		    },{
				targets: 7,
			    render: function (data, type, row, meta) {
			    	if(row.studyLevel =='8'){return "小学";}
			       else if(row.studyLevel =='4'){return "初中";}
				   else if(row.studyLevel =='5'){return "高中";}
				   else if(row.studyLevel =='1'){return "大专";}
				   else	if(row.studyLevel =='2'){return "本科";}
				   else	if(row.studyLevel =='3'){return "研究生";}
				   else if(row.studyLevel =='6'){return "硕士";}
				   else if(row.studyLevel =='7'){return "博士";}
				   else if(row.studyLevel =='9'){return "博士后";}
				   else{ return "";}
			   }
	        },{
				targets: 9,
			    render: function (data, type, row, meta) {
			    	var deptCatg = row.deptCatg;
		    		if(deptCatg == null || deptCatg == "" || deptCatg == "undefined"){
		    			return "";
		    		}else{
		    			var deptCatgArr = deptCatg.split(",");
		    			var html = "";
		    			for(var i=0;i<deptCatgArr.length;i++){
		    				var textV = $("#codePositionTypeList option[value='" + deptCatgArr[i] + "']").text();
		    				if(html == ""){
		    					html = textV;
		    				}else{
		    					html += ","+textV;
		    				}
		    			}
		    			return html;
		    		}
			   }
	        },{
				targets: 10,
			    render: function (data, type, row, meta) {
			    	var expertFlag = row.expertFlag;
			    	if(expertFlag =='N'){
			    		return "<span style='color:red;'>否</span>";
			    	}else if(expertFlag !='N'){
			    		if(expertFlag == null || expertFlag == "" || expertFlag == "undefined"){
			    			return "";
			    		}else{
			    			var expertFlagArr = expertFlag.split(",");
			    			var html = "";
			    			for(var i=0;i<expertFlagArr.length;i++){
			    				var textV = $("#codeExpertTypeList option[value='" + expertFlagArr[i] + "']").text();
			    				if(html == ""){
			    					html = textV;
			    				}else{
			    					html += ","+textV;
			    				}
			    			}
			    			return html;
			    		}
			       }
			   }
	        },{
				targets: 11,
			    render: function (data, type, row, meta) {
			    	if(row.agentState =='1'){return "有效";}
			       else if(row.agentState =='2'){return "<span style='color:red;'>失效</span>";}
				   else{ return "";}
			   }
	        },{
				targets: 12,
			    render: function (data, type, row, meta) {
			    	if(row.agentArea =='ZJ'){return "省本级";}
			       else if(row.agentArea =='H'){return "杭州";}
				   else if(row.agentArea =='N'){return "宁波";}
				   else if(row.agentArea =='W'){return "温州";}
				   else	if(row.agentArea =='Jx'){return "嘉兴";}
				   else	if(row.agentArea =='Hu'){return "湖州";}
				   else if(row.agentArea =='S'){return "绍兴";}
				   else if(row.agentArea =='J'){return "金华";}
				   else if(row.agentArea =='Q'){return "衢州";}
				   else if(row.agentArea =='Z'){return "舟山";}
				   else if(row.agentArea =='T'){return "台州";}
				   else if(row.agentArea =='L'){return "丽水";}
				   else{ return "";}
			   }
	        },{ 
				targets:13,
				render:function(data,type,row,meta){
					if(row.unitLevel!=null&&row.unitLevel!=""){
					 if(row.unitLevel=="1"){
						 return "市级";
					 } else if(row.unitLevel=="2"){
						 return "县级";
					 }else if(row.unitLevel=="3"){
						 return "省级";
					 }else if(row.unitLevel=="4"){
						 return "所级";
					 }else{
						 return "";
					 }
				   }
				}
			},{ 
				targets:15,
				render:function(data,type,row,meta){
					 if(row.agentPosition=="1"){
						 return "局领导";
					 } else if(row.agentPosition=="2"){
						 return "科室（处、办、中心）负责人（正职）";
					 }else if(row.agentPosition=="3"){
						 return "科室（处、办、中心）负责人（副职）";
					 }else if(row.agentPosition=="4"){
						 return "所（站、分局）长（正职）";
					 }else if(row.agentPosition=="5"){
						 return "所（站、分局）长（副职）";
					 }else if(row.agentPosition=="6"){
						 return "一般干部";
					 }else{
						 return "";
					 }
				   }
			}]})
   }

   

    function bind() {
        util.bindEvents([
				{
				    el: '#toAddExcel',
				    event: 'click',
				    handler: function () {
				    layer.dialog({
				            title: 'excel导入执法人员',
				            area: ['40%', '30%'],
				            content:"/syn/server/drcheck/pubscagent/addexcel",
				            callback: function (data) {
				            	if (data.reload) { 
				                	table.ajax.reload();
				                } 
				            }
				        })  
		    	    }
				},{
				    el: '#toAdd',
				    event: 'click',
				    handler: function () {
				    layer.dialog({
				            title: '添加执法人员',
				            area: ['90%', '90%'],
				            content:"/syn/server/drcheck/pubscagent/show?uid=",
				            callback: function (data) {
				            	if (data.reload) { 
				                	table.ajax.reload();
				                } 
				            }
				        })  
		    	    }
				},{
				    el: '.js_update',
				    event: 'click',
				    handler: function () {
				    	var data = table.row($(this).closest('td')).data();
				    	var uid=data.uid;
				    	layer.dialog({
				            title: '修改执法人员',
				            area: ['90%', '90%'],
				            content:'/syn/server/drcheck/pubscagent/show?uid='+uid,
				            callback: function (data) {
				                if (data.reload) { 
				                	table.ajax.reload();
				                }
				            }
				        })
				   }
		     },{
				    el: '.js_show',
				    event: 'click',
				    handler: function () {
				    	var data = table.row($(this).closest('td')).data();
				    	var uid=data.uid;
				    	layer.dialog({
				            title: '详情',
				            area: ['90%', '90%'],
				            content:'/syn/server/drcheck/pubscagent/showDetail?uid='+uid,
				            callback: function (data) {
				                if (data.reload) { 
				                	table.ajax.reload();
				                }
				            }
				        })
				    }
	         },{
	            el: '#choseregUnit',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择岗位管辖片区',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regunit/regunitmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncodes;
	                      	$("#localAdm").val(returncode);
	                      	$("#localAdmName").val(data.returnname); 
	                    }
	                })
	            }
            },{
                    el: '#qry',
                    event: 'click',
                    handler: function () {
                    	var deptCatgM = $("#deptCatgM").next("div").find("span").html();
                    	if(deptCatgM != "全部"){
                    		$("#deptCatg").val($("#deptCatgM").val());
                    	}else{
                    		$("#deptCatg").val("");
                    	}
                    	var expertFlagM = $("#expertFlagM").next("div").find("span").html();
                    	if(expertFlagM != "全部"){
                    		$("#expertFlag").val($("#expertFlagM").val());
                    	}else{
                    		$("#deptCatg").val("");
                    	}
                    	var stationTermM = $("#stationTermM").next("div").find("span").html();
                    	if(stationTermM != "全部"){
                    		$("#stationTerm").val($("#stationTermM").val());
                    	}else{
                    		$("#stationTerm").val("");
                    	}
                    	var unitLevelM = $("#unitLevelM").next("div").find("span").html();
                    	if(unitLevelM != "全部"){
                    		$("#unitLevel").val($("#unitLevelM").val());
                    	}else{
                    		$("#unitLevel").val("");
                    	}
                    	var studyLevelM = $("#studyLevelM").next("div").find("span").html();
                    	if(studyLevelM != "全部"){
                    		$("#studyLevel").val($("#studyLevelM").val());
                    	}else{
                    		$("#studyLevel").val("");
                    	}
                    	var lawTypeM = $("#lawTypeM").next("div").find("span").html();
                    	if(lawTypeM != "全部"){
                    		$("#lawType").val($("#lawTypeM").val());
                    	}else{
                    		$("#lawType").val("");
                    	}
                    	var agentPositionM = $("#agentPositionM").next("div").find("span").html();
                    	if(agentPositionM != "全部"){
                    		$("#agentPosition").val($("#agentPositionM").val());
                    	}else{
                    		$("#agentPosition").val("");
                    	}
                    	var agentAreaM = $("#agentAreaM").next("div").find("span").html();
                    	if(agentAreaM != "全部"){
                    		$("#agentArea").val($("#agentAreaM").val());
                    	}else{
                    		$("#agentArea").val("");
                    	}
                    	searchParams = $("#qryForm").serializeObject();
                    	table.ajax.reload();
                         
                    }
           },{
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                     $('#qryForm')[0].reset();
                     $("#deptCatg").val("");
                     $("#expertFlag").val("");
                     $("#stationTerm").val("");
                     $("#unitLevel").val("");
                     $("#studyLevel").val("");
                     $("#deptCodeArr").val("");
                     $("#lawType").val("");
                     $("#agentPosition").val("");
                     $("#agentRange").val("");
                     $('#deptCatgM').multipleSelect('setSelects',['']);
                     $('#expertFlagM').multipleSelect('setSelects',['']);
                     $('#stationTermM').multipleSelect('setSelects',['']);
                     $('#unitLevelM').multipleSelect('setSelects',['']);
                     $('#studyLevelM').multipleSelect('setSelects',['']);
                     $('#lawTypeM').multipleSelect('setSelects',['']);
                     $('#agentPositionM').multipleSelect('setSelects',['']);
                     $('#agentAreaM').multipleSelect('setSelects',['']);
                 }
           },{
               el: '.js-more-query',
               event: 'click',
               handler: function () {
               	if($('.more-show').css("display")=="none"){
               		$('.js-more-query').attr('value','收起');
               		$('.more-show').css("display","block");
               	}else{
               		$('.js-more-query').attr('value','更多查询');
               		$('.more-show').css("display","none");
               	}
               }
           },{
	            el: '#deptChoose',
	            event: 'click',
	            handler: function () {
//	           		var deptLink='/syn/system/sysdepart/alldeptcheckboxtreeselect'; 
//	            	layer.dialog({
//	                    title: '选择工作单位',
//	                    area: ['328px', '600px'],
//	                    content: deptLink,
//	                    callback: function (data) {
//	                    	if (data) { 
//	                           	$("#deptCodeArr").val(data.orgCodesExcParent);
//	                           	$("#deptName").val(data.orgNamesExcParent);
//	                    	}
//	                    }
//	                });
	            	var dutyDeptCode = $("#dutyDeptCode").val();
	            	if(dutyDeptCode == "A058"){
	            		layer.dialog({
	            			title: '选择工作单位',
	            			area: ['400px', '600px'],
	            			content: '/commom/server/regunit/regunitmutiselect',
	            			callback: function (data) { 
	            				var returncode=data.returncodes;
	            				$("#deptCodeArr").val(returncode);
	            				$("#deptName").val(data.returnname); 
	            			}
	            		})
	            	}else{
	            		layer.dialog({
	            			title: '选择工作单位',
	            			area: ['400px', '600px'],
	            			content: '/common/system/sysdepart/deptSelectByDuty?treeType=checkbox&dutyDeptCodes='+dutyDeptCode+"&isNoCheck=true",
	            			callback: function (data) {
	            				if(data.adCodes){
	            					var adCodes = data.adCodes;
	            					var adCodeArr = adCodes.split(",");
	            					var codes = "";
            						for(var i = 0;i<adCodeArr.length;i++){
            							var adCode = adCodeArr[i];
            							if(adCode.length > 8){
            								adCode = adCode.substring(0,8);
            							}
            							if(codes == ""){
            								codes = adCode;
            							}else{
            								codes = codes+","+adCode;
            							}
            						}
	            					$("#deptCodeArr").val(codes);
	            					$("#deptName").val(data.orgNames);
	            				}
	            			}
	            		})
	            	}
		     }
		  },{
	          el: '#agentRangeChoose',
	          event: 'click',
	          handler: function () { 
	              layer.dialog({
	                  title: '选择检查事项范围',
	                  area: ['400px', '600px'],
	                  content: '/syn/server/drcheck/pubscagent/scChecktypeSelect?isPermissionCheck=true',
	                  callback: function (data) { 
	                  	var returncode=data.returncode;
	                  	if(returncode!=null&&returncode!=""){
	                  		returncode=returncode.substr(0,returncode.length-1); 
	                  	}
	                  	$("#agentRange").val(returncode);
	                  	$("#agentRangeName").val(data.returnname);  
	                  }
	              })
	          }
	      }])
    }

})
