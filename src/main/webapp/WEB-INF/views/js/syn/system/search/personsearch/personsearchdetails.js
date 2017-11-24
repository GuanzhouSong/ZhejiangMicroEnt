require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {

	var regStateList = [];
	var params = $("#hx-form").serializeObject();
	var table_rzqyxx,table_dcdyxx,table_gqczxx,table_gqdjxx,table_grsxcjxx,table_dxhmdxx,
	table_yzwfsxxx,table_bdcdyxx,table_bdccfxx,table_tzqyxx;
	
    init();
    
    /**
     * 根据身份证获取生日
     * @param cerNO
     * @returns
     */
    function getBirthdayByCerNO(cerNO){
    	cerNO = $.trim(cerNO);
    	if(cerNO.length==15){//15位身份证
    		return "19"+cerNO.substring(6, 8) + "-" + cerNO.substring(8, 10) + "-" + cerNO.substring(10, 12); 
    	}else if(cerNO.length==18){//18位身份证
    		return cerNO.substring(6, 10) + "-" + cerNO.substring(10, 12) + "-" + cerNO.substring(12, 14); 
    	}else{
    		return "";
    	}
    	
    }
    
    /**
     * 根据身份证获取年龄
     * @param cerNO
     * @returns
     */
    function getAgeByCerNO(cerNO){
    	cerNO = $.trim(cerNO);
    	var myDate = new Date(); 
    	var month = myDate.getMonth() + 1; 
    	var day = myDate.getDate();
    	var age = 0;
    	
    	if(cerNO.length==15){//15位身份证
    		age = myDate.getFullYear() - ("19"+cerNO.substring(6, 8)) - 1; 
    		
    		if (cerNO.substring(8, 10) < month || cerNO.substring(8, 10) == month && cerNO.substring(10, 12) <= day) { 
        		age++; 
        	} 
    		return age;
    	}else if(cerNO.length==18){//18位身份证
    		age = myDate.getFullYear() - cerNO.substring(6, 10) - 1; 

        	if (cerNO.substring(10, 12) < month || cerNO.substring(10, 12) == month && cerNO.substring(12, 14) <= day) { 
        		age++; 
        	} 
        	return age;
    	}else{
    		return "";
    	}
    }
    
    /**
     * 将身份证最后4位变成*号
     * @param cerNO
     * @returns
     */
    function formatCerNO(cerNO){
    	cerNO = $.trim(cerNO);
    	if(cerNO.length==15){//15位身份证
    		 var serNO = cerNO.substr(0,11);
			 return serNO + "****";
    	}else if(cerNO.length==18){//18位身份证
    		 var serNO = cerNO.substr(0,14);
			 return serNO + "****";
    	}else{
    		if(cerNO.length>4){
    			return cerNO.substr(0,cerNO.length-4)+"****";
    		}else{
    			return cerNO;
    		}
    		
    	}
    
    }
    
    /**
     * 初始化函数集合
     */
    function init() {
    	getRegStateList();
    	bind();
    	init_zrrllxx();
    	initView();
    }
    
    //获取登记状态
    function getRegStateList() {
    	$('#rzqyxxRegState option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    	console.log(regStateList);
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }
    
    /**
     * 初始化详情信息
     * @returns
     */
    function initView(){
    	$("#person_birthday").text(getBirthdayByCerNO($("#cerNO").val()));
    	$("#person_age").text(getAgeByCerNO($("#cerNO").val()));
    	$("#cerNODesc").text(formatCerNO($("#cerNO").val()));
    }
    
    /* 自然人履历信息*/
    function init_zrrllxx(){
    	if((table_rzqyxx+'')=='undefined')
    		initDataTable_rzqyxx();
    	if((table_tzqyxx+'')=='undefined')
    		initDataTable_tzqyxx();
    }
    
    /* 任职资格信息*/
    function init_rzzgxx(){
    	if((table_gqdjxx+'')=='undefined')
    		initDataTable_gqdjxx();
    	if((table_bdccfxx+'')=='undefined')
    		initDataTable_bdccfxx();
    	
    	initDataTable_sxbzxrxx();
    	
    }
    
    
    /*抵押质押信息*/
    function init_dyzyxx(){
    	if((table_dcdyxx+'')=='undefined')
    		initDataTable_dcdyxx();
    	if((table_gqczxx+'')=='undefined')
    		initDataTable_gqczxx();
    	if((table_bdcdyxx+'')=='undefined')
    		initDataTable_bdcdyxx();
    	
    	initDataTable_grzscqczdjxx();
    	initDataTable_grdwtgdbxx();
    }

    /*个人行政处罚信息*/
    function init_grxzcfxx(){
    }

    /*查封冻结信息*/
    function init_cfdjxx(){
    	initDataTable_grlhryxx();
    }
    
    /*投资任职企业不良信息*/
    function init_tzrzqyblxx(){
    	initDataTable_tzrzqyblrjyycml();
    	if((table_dxhmdxx+'')=='undefined')
    		initDataTable_dxhmdxx();
    	if((table_grsxcjxx+'')=='undefined')
    		initDataTable_sxcjxx();
    	/*if((table_yzwfsxxx+'')=='undefined')
    		initDataTable_yzwfsxxx();*/
    	
    	initDataTable_tzrzqybxzcf();
    	
    	initDataTable_tzrzqybsxlhcj();
    }
    
    
    /**
     * 表格同步完成后显示表格总数，并根据总数判断是否需要收缩表格
     * @param settings
     * @param json
     * @returns
     */
    function tableInitComplete(settings, json){
    	var tableId = settings.sTableId;
    	$("#"+tableId+"_span").text(json.recordsTotal);
		if(json.recordsTotal != 0){
			$("#"+tableId+"_li").removeClass("flexed-icon");
			$("#"+tableId).show();
			$("#"+tableId+"_wrapper").show();
		}else{
			$("#"+tableId+"_li").addClass("flexed-icon");
			$("#"+tableId).hide();
			$("#"+tableId+"_wrapper").hide();
		}
    }
    
    //投资企业
    function initDataTable_tzqyxx(){
    	table_tzqyxx = dataTable.load({
    		el:'#table_tzqyxx',
    		showIndex:true,
    		scrollX: true,
    		lengthMenu: [ 5, 10, 20, 50],
//    		retrieve: true,
    		ajax:{
    			url:'/syn/personsearch/doGetMidInvList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: null, className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'leRep', className: 'center'},
    			{data: 'estDate', className: 'center'},
    			{data: 'regCap', className: 'center'},
    			{data: 'subConAm', className: 'center'},
    			{data: 'subConProp', className: 'center'},
    			{data: 'entType', className: 'center'},
    			{data: 'industryPhy', className: 'center'},
    			{data: 'regState', className: 'center'},
    			{data: 'dom', className: 'center'},
    			{data: 'regOrgName', className: 'center'},
    			{data: 'localAdmName', className: 'center'},
    	],			
    		columnDefs : [
    			{
		          	  targets: 1,
				      render: function (data, type, row, meta) {
				    	  if(data.uniCode && $.trim(data.uniCode) != "null"){
				    		  return data.uniCode;
				    	  }else if(data.regNO && $.trim(data.regNO) != "null"){
				    		  return data.regNO;
				    	  }
				      }
		          },{
		            	 targets:2,
		            	 render:function (data, type, row, meta) {
		            		 return "<a href='javascript:void(0)' class='mr10 look' priPID='"+row.priPIDDesc+"'>"+ row.entName+"</a>";
		            	 }
		            	  
		              },{
					targets: 7,
				      render: function (data, type, row, meta) {
				    	return row.subConProp+'%';
				      }
				},{
	            	  targets: 10,
				      render: function (data, type, row, meta) {
				    	  return switchRegStateList(row.regState);
				      }
	              }        
    		],
    		"initComplete": tableInitComplete
    	});
    	
    }
    
    //失信被执行人信息
    function initDataTable_sxbzxrxx(){
    	var table_sxbzxrxx = dataTable.load({
    		el:'#table_sxbzxrxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
//    		retrieve: true,
    		ajax:{
    			url:'/syn/dishonestexe/queryListByCardNum',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'caseCode', className: 'center'},
    			{data: 'gistUnit', className: 'center'},
    			{data: 'publishDate', className: 'center'}
    	],			
    		columnDefs : [
    		           
    		],
    		"initComplete": tableInitComplete
    	});
    	/*table_bdccfxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_grzccfdj .dataTables_wrapper .bottom').hide();}else{$('#tab_grzccfdj .dataTables_wrapper .bottom').show();}
        })*/
    }
    
    //个人不动产查封信息
    function initDataTable_bdccfxx(){
    	table_bdccfxx = dataTable.load({
    		el:'#table_bdccfxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
//    		retrieve: true,
    		ajax:{
    			url:'/syn/personsearch/doGetCsAttachmentEstateList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'attachmentNO', className: 'center'},
    			{data: 'estateAddr', className: 'center'},
    			{data: 'attachmentDep', className: 'center'},
    			{data: 'attachmentDate', className: 'center'},
    			{data: 'attachmentCanDate', className: 'center'},
    			{data: 'attachmenStatus', className: 'center'},
    	],			
    		columnDefs : [
    		           
    		],
    		"initComplete": tableInitComplete
    	});
    }
    
    //个人不动产抵押信息
    function initDataTable_bdcdyxx(){
    	table_bdcdyxx = dataTable.load({
    		el:'#table_bdcdyxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetCsMortEstateInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'orderNO', className: 'center'},
    			{data: 'mortGageType', className: 'center'},
    			{data: 'warCov', className: 'center'},
    			{data: 'mortGageeName', className: 'center'},
    			{data: 'mortGageeCertNO', className: 'center'},
    			{data: 'mortGageAmount', className: 'center'},
    			{data: 'pefPerForm', className: 'center'},
    			{data: 'pefPerTo', className: 'center'},
    			{data: 'mortReason', className: 'center'},
    	],			
    		columnDefs : [
    		              {
      		  				targets: 2,
      		  			      render: function (data, type, row, meta) {
      		  			    	if(row.mortGageType='jdht')
      		  			    		return "借贷合同";
      		  			    	if(row.mortGageType='mmht')
    		  			    		return "买卖合同";
      		  			    	if(row.mortGageType='qtht')
    		  			    		return "其他合同";
      		  			    	return null;
      		  			      }
      		  			}        
    		],
    		"initComplete": tableInitComplete
    	});
    
    }
    //工商严重违法失信信息
    function initDataTable_yzwfsxxx(){
    	table_yzwfsxxx = dataTable.load({
    		el:'#table_yzwfsxxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetCsPubIlldisDetailList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'uniscid', className: 'center'},
//    			{data: null, className: 'center'},
    			{data: 'abnTime', className: 'center'},
    			{data: 'serillrea_CN', className: 'center'},
//    			{data: null, className: 'center'},
    			{data: 'deCorg_CN', className: 'center'},
    			{data: 'remDate', className: 'center'},
    			{data: 'peMexcPrexs_CN', className: 'center'},
    			{data: 'reCorg_CN', className: 'center'},
//    			{data: null, className: 'center'}
    	],			
    		columnDefs : [
    		           
    		],
    		"initComplete": tableInitComplete
    	});
    }
    
    //吊销黑名单
    function initDataTable_dxhmdxx(){
    	table_dxhmdxx = dataTable.load({
    		el:'#table_dxhmdxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetCsMidBlackListList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'regNO', className: 'center'},
//    			{data: 'positionName', className: 'center'},
    			{data: 'penDecNo', className: 'center'},
    			{data: 'setDate', className: 'center'},
    			{data: 'deadlineTo', className: 'center'},
//    			{data: 'penForm', className: 'center'},
    			{data: 'revReaType', className: 'center'},
    			{data: 'revRea', className: 'center'},
    			{data: 'limitFlag', className: 'center'}
    	],			
    		columnDefs : [
			{
					targets: 6,
				      render: function (data, type, row, meta) {
				    	if(row.revReaType=='01')	return "未年检";
				    	if(row.revReaType=='02') return "其他原因";
				    	return '-';
				      }
			},{
				targets: 8,
			      render: function (data, type, row, meta) {
			    	if(row.limitFlag=='Y') return "限制";
			    	if(row.limitFlag=='N') return "不限制";
			    	return '-';
			      }
			}
			
			],
			"initComplete": tableInitComplete
    	});
    	
    	/*table_dxhmdxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_sxcjxx .dataTables_wrapper .bottom').hide();}else{$('#tab_sxcjxx .dataTables_wrapper .bottom').show();}
        });*/
    }
    
    //个人失信惩戒黑名单信息
    function initDataTable_sxcjxx(){
    	table_grsxcjxx = dataTable.load({
    		el:'#table_grsxcjxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetNoCreditPunishInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'uniCode', className: 'center'},
//    			{data: null, className: 'center'},
//    			{data: 'uniSCID', className: 'center'},
    			{data: 'legNo', className: 'center'},
    			{data: 'legDate', className: 'center'},
    			{data: 'punCause', className: 'center'},
    			{data: 'legBasis', className: 'center'},
    			{data: 'auditRes', className: 'center'},
    			{data: 'punExeDept', className: 'center'},
    			{data: 'exeEnd', className: 'center'},
//    			{data: null, className: 'center'}
    	],			
    		columnDefs : [
    		           
    		],
    		"initComplete": tableInitComplete
    	});
    }
    //个人股权冻结信息
    function initDataTable_gqdjxx(){
    	table_gqdjxx = dataTable.load({
    		el:'#table_gqdjxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetPubJusticeInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'exeRulNum', className: 'center'},
    			{data: 'executionCourt', className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'uniSCID', className: 'center'},
    			{data: 'frozStateName', className: 'center'},
    			{data: 'froAm', className: 'center'},
    			{data: 'froFrom', className: 'center'},
    			{data: 'froTo', className: 'center'}
    	],"initComplete": tableInitComplete
    	});
    }
    
    //个人股权出质信息
    function initDataTable_gqczxx(){
    	table_gqczxx = dataTable.load({
    		el:'#table_gqczxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetSpPledgeList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: 'orderNO', className: 'center'},
    			{data: 'pledgor', className: 'center'},
    			{data: 'impOrg', className: 'center'},
    			{data: 'impBLicNO', className: 'center'},
    			{data: 'impAm', className: 'center'},
    			{data: 'equPleDate', className: 'center'},
    			{data: 'statusName', className: 'center'}
    	],			
    		columnDefs : [],
    		"initComplete": tableInitComplete
    	});
    }
    
    //个人知识产权出质登记信息
    function initDataTable_grzscqczdjxx(){
    	var table_grzscqczdjxx =dataTable.load({
    		el:'#table_grzscqczdjxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetImIppldgListByCerNO',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'tmname', className: 'center'},
    			{data: 'tmregNo', className: 'center'},
    			{data: 'pledgor', className: 'center'},
    			{data: 'impOrg', className: 'center'},
    			{data: 'pubFlag', className: 'center'},
    			{data: 'publicDate', className: 'center'}
    	],			
    		columnDefs : [
    			{
		          	  targets: 5,
				      render: function (data, type, row, meta) {
				    	  	if(row.pubFlag == "1"){
				    	  		return "公示";
				    	  	}else if (row.pubFlag == "2"){
				    	  		return "暂存";
				    	  	}else if (row.pubFlag == "3"){
				    	  		return "历史";
				    	  	}
				      }
		          }
    		],
    		"initComplete": tableInitComplete
    	});
    }
    
    //个人对外提供担保信息
    function initDataTable_grdwtgdbxx(){
    	var table_grdwtgdbxx = dataTable.load({
    		el:'#table_grdwtgdbxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/client/yr/ent/forguarantee/doGetYrForGuaranteeInfoListByCerNO',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'more', className: 'center'},
    			{data: 'mortgagor', className: 'center'},
    			{data: 'gaRange', className: 'center'},
    			{data: 'priClaSecAm', className: 'center'},
    			{data: 'gaType', className: 'center'},
    			{data: 'guaPeriod', className: 'center'},
    			
    	],			
    		columnDefs : [{
    	          	  targets: 3,
    			      render: function (data, type, row, meta) {
    			    	  return row.gaRange.replace("1","主债权").replace("2","利息").replace("3","违约金").replace("4","损害赔偿金").replace("5","实现债权的费用").replace("6","其他约定");
    			      }
    	          },{
  	          	  targets: 5,
  			      render: function (data, type, row, meta) {
  			    	if(data.gaType == 1){
  	              	   return "一般保证";
  	                 }else if(data.gaType == 2){
  	                 	return "连带保证";
  	                 }else{
  	              	   return "未约定";
  	                 }
  			      }
  	          },{
	          	  targets: 6,
			      render: function (data, type, row, meta) {
			    	  if(row.guaPeriod == "1"){
	                 	   return "期间";
	                    }else{
	                 	   return "未约定";
	                    }
			      }
	          }],
	          "initComplete": tableInitComplete
    	});
    }
    
    //任职企业信息
    function initDataTable_rzqyxx(){
    	//alert();
    	table_rzqyxx = dataTable.load({
    		el:'#table_rzqyxx',
    		showIndex:true,
    		scrollX: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetMidBaseInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: null, className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'leRep', className: 'center'},
    			{data: 'estDate', className: 'center'},
    			{data: 'regCap', className: 'center'},
    			{data: 'entType', className: 'center'},
    			{data: 'industryCoName', className: 'center'},
    			{data: 'positionName', className: 'center'},
    			{data: 'regState', className: 'center'},
    			{data: 'dom', className: 'center'},
    			{data: 'regOrgName', className: 'center'},
    			{data: 'localAdmName', className: 'center'}
    	],			
    		columnDefs : [{
				          	  targets: 1,
						      render: function (data, type, row, meta) {
						    	  if(data.uniCode && $.trim(data.uniCode) != "null"){
						    		  return data.uniCode;
						    	  }else if(data.regNO && $.trim(data.regNO) != "null"){
						    		  return data.regNO;
						    	  }
						      }
				          },{
				            	 targets:2,
				            	 render:function (data, type, row, meta) {
				            		 return "<a href='javascript:void(0)' class='mr10 look' priPID='"+row.priPIDDesc+"'>"+ row.entName+"</a>";
				            	 }
				            	  
				              },{
    		            	  targets: 9,
    					      render: function (data, type, row, meta) {
    					    	  return switchRegStateList(row.regState);
    					      }
    		              }],
    		              "initComplete": tableInitComplete
    	});
    }
    
    //个人动产抵押信息
    function initDataTable_dcdyxx(){
    	table_dcdyxx = dataTable.load({
    		el:'#table_dcdyxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/personsearch/doGetMortRegInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'orderNO', className: 'center'},
    			{data: 'warCov', className: 'center'},
    			{data: 'mortGageeName', className: 'center'},
    			{data: 'mortGageeCertNO', className: 'center'},
    			{data: 'mortGageAmount', className: 'center'},
    			{data: 'pefPerForm', className: 'center'},
    			{data: 'pefPerTo', className: 'center'}
    	],			
    		columnDefs : [],
    		 "initComplete": tableInitComplete
    	});
    }
    
    //个人良好荣誉信息
    function initDataTable_grlhryxx(){
    	var table_grlhryxx = dataTable.load({
    		el:'#table_grlhryxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/favorable/selectListByCerNO',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'favType', className: 'center'},
    			{data: 'licZone', className: 'center'},
    			{data: 'regYear', className: 'center'},
    			{data: 'regType', className: 'center'},
    			{data: 'regFrom', className: 'center'},
    			{data: 'regTo', className: 'center'},
    			{data: 'efftStatus', className: 'center'},
    			{data: 'regDate', className: 'center'},
    			{data: 'regDocNo', className: 'center'},
    			{data: 'regDeptCn', className: 'center'},
    	],			
    		columnDefs : [
    			{
		          	  targets: 1,
				      render: function (data, type, row, meta) {
				    	 if(row.favType == "0"){
				    		 return "百强民营企业";
				    	 }else if(row.favType == "1"){
				    		 return "驰名商标";
				    	 }else if(row.favType == "2"){
				    		 return "知名商号";
				    	 }else if(row.favType == "3"){
				    		 return "著名商标";
				    	 }else if(row.favType == "4"){
				    		 return "守合同重信用企业";
				    	 }else if(row.favType == "5"){
				    		 return "信用示范管理企业";
				    	 }else if(row.favType == "6"){
				    		 return "小微企业成长之星";
				    	 }
				      }
		          },{
		          	  targets: 2,
				      render: function (data, type, row, meta) {
				    	 if(row.licZone == "0"){
				    		 return "国家级";
				    	 }else if(row.licZone == "1"){
				    		 return "省级";
				    	 }else if(row.licZone == "2"){
				    		 return "市级";
				    	 }else if(row.licZone == "3"){
				    		 return "县级";
				    	 }
				      }
		          },{
		          	  targets: 7,
				      render: function (data, type, row, meta) {
				    	 if(row.efftStatus == "0"){
				    		 return "待审核";
				    	 }else if(row.efftStatus == "1"){
				    		 return "同意";
				    	 }else if(row.efftStatus == "2"){
				    		 return "不同意";
				    	 }
				      }
		          }
    		],
    		"initComplete": tableInitComplete
    	});
 
    }
    
    //投资任职企业被列入经营异常名录
    function initDataTable_tzrzqyblrjyycml(){
    	var table_tzrzqyblrjyycml = dataTable.load({
    		el:'#table_tzrzqyblrjyycml',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/server/opanomaly/pubopanomaly/selectListByCerNO',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'leRep', className: 'center'},
    			{data: 'regOrg', className: 'center'},
    			{data: 'localAdm', className: 'center'},
    			{data: 'speCauseCN', className: 'center'},
    			{data: 'decorgCN', className: 'center'},
    			{data: 'auditState', className: 'center'},
    			{data: 'penDecNo', className: 'center'},
    			{data: 'regState', className: 'center'}
    	],			
    		columnDefs : [{
	          	  targets: 7,
			      render: function (data, type, row, meta) {
			    	 if(row.auditState == "0"){
			    		 return "待审核";
			    	 }else if(row.auditState == "1"){
			    		 return "同意列入";
			    	 }else if(row.auditState == "2"){
			    		 return "不予列入";
			    	 }
			      }
	          },{
	          	  targets: 9,
			      render: function (data, type, row, meta) {
			    	  return switchRegStateList(row.regState);
			      }
	          }],
	          "initComplete": tableInitComplete
    	});
    
    }
    
    //投资任职企业被行政处罚
    function initDataTable_tzrzqybxzcf(){
    	var table_tzrzqybxzcf = dataTable.load({
    		el:'#table_tzrzqybxzcf',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/ext/midCaseInfo/selectListByCerNO',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'setDeptname', className: 'center'},
    			{data: 'setName', className: 'center'},
    			{data: 'penAuthName', className: 'center'},
    			{data: 'penDecNo', className: 'center'},
    			{data: 'penType', className: 'center'},
    			{data: 'penAm', className: 'center'},
    			{data: 'unitName', className: 'center'},
    			{data: 'leRep', className: 'center'}
    	],			
    		columnDefs : [],
		   "initComplete": tableInitComplete
    	});
    	
    	
    }
    
    //投资任职企业被失信联合惩戒
    function initDataTable_tzrzqybsxlhcj(){
    	var table_tzrzqybsxlhcj = dataTable.load({
    		el:'#table_tzrzqybsxlhcj',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/noCreditPunish/info/selectListByCerNO',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'batchNo', className: 'center'},
    			{data: 'entName', className: 'center'},
    			{data: 'leRep', className: 'center'},
    			{data: 'litiName', className: 'center'},
    			{data: 'phone', className: 'center'},
    			{data: 'record', className: 'center'},
    			
    	],			
    		columnDefs : [],
    		 "initComplete": tableInitComplete
    	});
    
    }
    
    
    
//    //企业动产抵押信息
//    function initDataTable_qydcdyxx(){
//    	
//    	table_qydcdyxx = dataTable.load({
//    		el:'#table_qydcdyxx',
//    		showIndex:true,
//    		ajax:{
//    			url:'/syn/panoramasearch/doGetMortRegInfoList',
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    			{data: null, className: 'center'},
//    			{data: 'orderNO', className: 'center'},
//    			{data: 'warCov', className: 'center'},
//    			{data: 'mortGageeName', className: 'center'},
//    			{data: 'mortGageeCertType', className: 'center'},
//    			{data: 'mortGageAmount', className: 'center'},
//    			{data: 'pefPerForm', className: 'center'},
//    			{data: 'pefPerTo', className: 'center'}
//    	],			
//    		columnDefs : []
//    	})
//    }
//	//抽查检查信息
//    function initDataTable_ccjcxx(){
//    	
//    	table_ccjcxx = dataTable.load({
//    		el:'#table_ccjcxx',
//    		showIndex:true,
//    		ajax:{
//    			url:'/syn/panoramasearch/doGetPubScitemResultList',
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    					{data: null, className: 'center'},
//    					{data: 'inspectDept', className: 'center'},
//    					{data: 'inspectDate', className: 'center'},
//    					{data: 'scResult', className: 'center'}
//    	],			
//    		columnDefs : []
//    	})
//    }
//    
//    //企业股权出质信息
//    function initDataTable_qygqczxx(){
//    	table_qygqczxx = dataTable.load({
//    		el:'#table_qygqczxx',
//    		showIndex:true,
//    		ajax:{
//    			url:'/syn/panoramasearch/doGetSpPledgeList',
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    					{data: null, className: 'center'},
//    					{data: 'orderNO', className: 'center'},
//    					{data: 'pledgor', className: 'center'},
//    					{data: 'impOrg', className: 'center'},
//    					{data: 'impBLicNO', className: 'center'},
//    					{data: 'impAm', className: 'center'},
//    					{data: 'equPleDate', className: 'center'},
//    					{data: 'status', className: 'center'}
//    				],
//    		columnDefs : []
//    	})
//    }
//    
//    //企业许可审批信息
//    function initDataTable_qyxkspxx(){
//    	table_qyxkspxx = dataTable.load({
//    		el:'#table_qyxkspxx',
//    		showIndex:true,
//    		ajax:{
//    			url:'/syn/panoramasearch/doGetPubOtherlicenceList',
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    					{data: null, className: 'center'},
//    					{data: 'licNO', className: 'center'},
//    					{data: 'licNameCN', className: 'center'},
//    					{data: 'licValFrom', className: 'center'},
//    					{data: 'licAnth', className: 'center'},
//    					{data: 'licScope', className: 'center'},
//    					{data: 'licValTo', className: 'center'}
//    				],
//    		columnDefs : []
//    	})
//    }
//    
//    //高管人员信息
//    function initDataTable_ggryxx() {
//    	table_ggryxx = dataTable.load({
//		el : '#table_ggryxx',
//		showIndex: true,
//		// scrollX: true,
//		ajax : {
//			url : '/syn/panoramasearch/doGetMemberList' ,
//			data :function(d){
//				d.params = params;
//			}
//		},
//		columns : [
//			{data: null, className: 'center'},
//			{data: 'name', className: 'center'},
//			{data: 'posiContent', className: 'center'}
//		],
//		columnDefs : []
//	  })
//	}
//
//
//    //股东及出资人
//    function initDataTable_gdjczxx(){
//    	table_gdjczxx = dataTable.load({
//    		el : '#table_gdjczxx',
//    		showIndex: true,
//    		ajax : {
//    			url : '/syn/panoramasearch/doGetMidInvList' ,
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    			{data: null, className: 'center'},
//    			{data: 'inv', className: 'center'},
//    			{data: 'subConForm', className: 'center'},
//    			{data: 'subConAm', className: 'center'},
//    			{data: 'subConDate', className: 'center'},
//    			{data: null, className: 'center'},
//    			{data: null, className: 'center'},
//    			{data: null, className: 'center'}
//    		],
//    		columnDefs : []
//    	  })
//    }
//    
//    //企业行政处罚信息
//    function initDataTable_qyxzcfxx(){
//    	table_qyxzcfxx = dataTable.load({
//    		el:'#table_qyxzcfxx',
//    		showIndex: true,
//    		ajax:{
//    			url:"/syn/panoramasearch/doGetMidCaseInfoList",
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    	    	{data: null, className: 'center'},
//    	    	{data: 'penDecNo', className: 'center'},
//    	    	{data: 'setDeptname', className: 'center'},
//    	    	{data: 'caseNO', className: 'center'},
//    	    	{data: 'penContent', className: 'center'},
//    	    	{data: 'penDecIssDate', className: 'center'},
//    	    	{data: 'auditState', className: 'center'},
//    	    	{data: null, className: 'center'}
//    	   	],
//    	   columnDefs : []
//    	})
//    }
//    
//    //企业经营异常名录
//    function initDataTable_qyjyqcxx(){
//    	table_qyjyqcxx = dataTable.load({
//    		el:'#table_qyjyqcxx',
//    		showIndex: true,
//    		ajax:{
//    			url:"/syn/panoramasearch/doGetPubOpanoMalyList",
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    	    	{data: null, className: 'center'},
//    	    	{data: 'speCauseCN', className: 'center'},
//    	    	{data: 'abnTime', className: 'center'},
//    	    	{data: 'remExcpresCN', className: 'center'},
//    	    	{data: 'remDate', className: 'center'},
//    	    	{data: 'reDecOrgCN', className: 'center'}
//    	   	],
//    	   columnDefs : []
//    	})
//    }
//    
//    //失信联合惩戒信息
//    function initDataTable_sxlhcjxx(){
//    	table_sxlhcjxx = dataTable.load({
//    		el:"#table_sxlhcjxx",
//    		showIndex: true,
//    		ajax:{
//    			url:"/syn/panoramasearch/doGetNoCreditPunishInfoList",
//    			data :function(d){
//    				d.params = params;
//    			}
//    		},
//    		columns : [
//    		        {data: null, className: 'center'},
//    		        {data: 'punField', className: 'center'},
//    	    	    {data: 'legBasis', className: 'center'},
//    	    	    {data: 'punCause', className: 'center'},
//    	    	   	{data: 'punRule', className: 'center'},
//    	    	   	{data: 'punReqDept', className: 'center'},
//    	    	   	{data: 'exeBegin', className: 'center'},
//    	    	   	{data: 'punExeDept', className: 'center'},
//    	    	   	{data: 'punMea', className: 'center'},
//    	    	   	{data: 'state', className: 'center'}
//    	    	],
//    	   columnDefs : []
//    	})
//    }
    function bind(){
    	util.bindEvents([
    	{//tab页面加载
            el: '._tab',
            event: 'click',
            handler: function () {
            	tabSwitch($(this).attr('mtab'));
            }
        },{//tab页面加载
            el: '#rzqyxxRegState',
            event: 'change',
            handler: function () {
            	$("#regState").val($(this).val());
            	params = $("#hx-form").serializeObject();
            	table_rzqyxx.ajax.reload();
            }
        },{
        	el: '#tzqyxxRegState',
            event: 'change',
            handler: function () {
            	$("#regState").val($(this).val());
            	params = $("#hx-form").serializeObject();
            	table_tzqyxx.ajax.reload();
            }
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	if(priPID!=null && priPID != ''){
            		window.open('/syn/panoramasearch/doEnAppSearchDetails/' + priPID,'_blank');
            	}
            }
        },{
        	el: 'i.fl',
            event: 'click',
            handler: function () {
            	var className = $(this).attr("class");
            	var id = $(this).attr("id");
            	if(className.indexOf("flexed-icon") != -1){
            		$(this).removeClass("flexed-icon");
            		$("#"+id.replace("_li","")).show();
            		$("#"+id.replace("_li","_wrapper")).show();
        		}else{
        			$(this).addClass("flexed-icon");
        			$("#"+id.replace("_li","")).hide();
        			$("#"+id.replace("_li","_wrapper")).hide();
            	}
            	$.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
            }
        }
    	])
    }
    
    function tabSwitch(n){
    	n = parseInt(n);
    	switch(n){
	    	case 1:
	    		init_rzzgxx();break;
	    	case 2:
	    		init_dyzyxx();break;
	    	case 3:
	    		init_cfdjxx();break;
	    	case 4:
	    		init_tzrzqyblxx();break;
	    	default:
	    		init_zrrllxx();
    		
    	}
    	
    }
    
    

})
