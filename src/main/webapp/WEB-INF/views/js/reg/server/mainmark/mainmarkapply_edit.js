require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','ztree','ztreeCheck'], function (layer, dataTable, util, http,handlebars) {

	var params = $("#hx-form").serializeObject();
	var table_ggryxx,table_gdjczxx,table_qyxkspxx,table_qyxzcfxx,table_qyjyqcxx,
	table_sxlhcjxx,table_qygqczxx,table_ccjcxx,table_qydcdyxx,table_qygqdjxx,table_qysbxx,
	table_yzwfsxxx,table_qyzlxx,table_qybdccfxx,table_qybdcdyxx,table_forguaranteeinfo;
	
	var table_fzjgxx,table_qsxx,table_bgxx;
	var table_dwtzxx;
	
	//即时信息tab中的表初始化
	var table_jsgdyczxx,table_gqbgxx,table_jsxzxkxx,table_zscqczdjxx,table_jsxzcfxx;
	var _urlHead = window._CONFIG._urlHead;
	// 初始化标志
	var initFlag = true;
	
    
    
    var viewTemplate = handlebars.compile($('#viewTemplate').html());
    
    handlebars.registerHelper("doublyStoStateFormat",function(value,value2,value3,value4){
		 if(value){
			 if(value == "1"){
				 return value2+','+value3+','+value4;
			 }else{
				 return '无';
			 }
		 }else{
			 return '';
		 }
		
	 });
	
	handlebars.registerHelper("validDateFormat",function(value){
		 if(value && value.indexOf("2099") !=-1){
			 return "长期有效";
		 }else{
			 return value;
		 }
	 });
	
	 var ycCodeLicensetreeSetting = {
	    		check: {
					enable: true,
					disable:false,
					chkStyle: "checkbox",
					radioType: "level"
				},
				data: {
					simpleData: {
						enable: true
					}
				},callback: {
		            onClick: function (event, treeId, treeNode) {
		                var id = treeNode.id;
		                if(id.length == 6){
		                	showView(id);
		                }else{
	                        $('#showArea').html(viewTemplate());
		                }
		               
		            }
		        }
			}; 
	 
	 init();
	 
	    function showView(idcode){
	    	http.httpRequest({
	            url: '/reg/server/registmark/queryByIDCode.json',
	            data:{idcode:idcode},
	            type: 'post',
	            success: function(data) {
	            	if (data && data.status == 'success') { 
	            		 var context = data.data;
	                     //展示权限数据
	                     $('#showArea').html(viewTemplate(context));
	                 }else{
	                 	layer.msg(data.msg, {ltype: 0,time:1000});
	                 }
	            }
	        })
	    }
	 
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    	init_djxkxx();
    	initView();
    	$('#showArea').html(viewTemplate());
    }
    
    
    function initView(idname){
   	 	http.httpRequest({
            url: '/reg/server/mainmark/queryValidSubTypeMarkList.json',
            data:{idname:idname,priPID:$("#priPID").val(),isShowCheckOnly:(typeof(isView)!="undefined"&& isView?true:false)},
            type: 'post',
            success: function(data) {
            	if (data && data.status == 'success') { 
                  //初始化权限树
                   treeObj = $.fn.zTree.init($('#ycCodeLicenseTree'), ycCodeLicensetreeSetting, data.data);
                   var treeObj = $.fn.zTree.getZTreeObj("ycCodeLicenseTree");
					  //展开树
				    treeObj.expandAll(true);
                 }else{
                 	layer.msg(data.msg, {ltype: 0,time:1000});
                 }
            }
        })
   }
   
    
    /* 登记许可信息*/
    function init_djxkxx(){
    	initPubotherlicenceTable();
    }
    
    
    //表格收起/展开
    function addflex(yrinfo_li,tableId){
    	 initFlag = false;
    	 //展开
    	 if ($("#"+yrinfo_li).hasClass("flex-icon")&&$("#"+yrinfo_li).hasClass("flexed-icon")) {
    		 /*if(tableId != "table_baseinfo"   && tableId != "table_qsxx" && tableId != "_tab-pubotherlicence" 
    			 && tableId !="ippldg_table"  && tableId != "table_jsxzcfxx" 
    		     && tableId !="yrinfo_table"  && tableId != "table_jsgdyczxx"
                 && tableId != "permit_table" && tableId !="invsral_table"
    		     && tableId !="imcase_table"  && tableId != "er_esc_appinfo_table"){
    			 var table = eval(tableId);
        		 table.ajax.reload(); 
    		 }
    		 if(tableId =="invsral_table"){
    			 table_gqbgxx.ajax.reload(); 
    		 }else if(tableId =="permit_table"){
    			 table_jsxzxkxx.ajax.reload(); 
    		 }else if(tableId =="ippldg_table"){
    			 table_zscqczdjxx.ajax.reload(); 
    		 }*/
    		 $("#"+yrinfo_li).removeClass("flexed-icon");
             $("#"+tableId).show();
             $("#"+tableId+"_wrapper").css("display","");
         }else {//收起
        	 $("#"+yrinfo_li).addClass("flexed-icon");
             $("#"+tableId).hide();
             $("#"+tableId+"_wrapper").css("display","none");
         }
    	 $.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
    }
    
    function initAddflex(yrinfo_li,tableId){
    	 if ($("#"+yrinfo_li).hasClass("flex-icon")&&$("#"+yrinfo_li).hasClass("flexed-icon")) {
    		 $("#"+yrinfo_li).removeClass("flexed-icon");
             $("#"+tableId).show();
             $("#"+tableId+"_wrapper").css("display","");
    	 }else {//收起
        	 $("#"+yrinfo_li).addClass("flexed-icon");
             $("#"+tableId).hide();
             $("#"+tableId+"_wrapper").css("display","none");
         }
    }
    
    /*出资投资信息*/
    function inti_jsxx(){
    	if((table_gdjczxx+'')=='undefined')
    		initDataTable_gdjczxx();
    	if((table_dwtzxx+'')=='undefined')
    		initDataTable_dwtzxx();
    }
    
    /*知识产权*/
    function init_zydyxx(){
    	if((table_qysbxx+'')=='undefined')
		initDataTable_qysbxx();
    	if((table_qyzlxx+'')=='undefined')
		initDataTable_qyzlxx();
    }
    
    /* 许可信息*/
    function init_zczbxx(){
    	if((table_gdjczxx+'')=='undefined')
    		initDataTable_gdjczxx();
    	
    }
    
    /*抽查检测信息*/
    function init_ccjcxx(){
    	
    	if((table_ccjcxx+'')=='undefined')
    		initDataTable_ccjcxx();
    }

    /*判决冻结信息*/
    function init_gdpjxx(){
    	
    	if((table_qygqdjxx+'')=='undefined')
    		initDataTable_qygqdjxx();
    	if((table_qybdccfxx+'')=='undefined')
    		initDataTable_qybdccfxx();
    }

    /*违法失信*/
    function init_wfsxxx(){
    	if((table_qyxzcfxx+'')=='undefined')
    		initDataTable_qyxzcfxx();
    	if((table_qyjyqcxx+'')=='undefined'){
    		initDataTable_qyjyqcxx();
    	}
    	if((table_yzwfsxxx+'')=='undefined'){
    		initDataTable_yzwfsxxx();
    	}
    	if((table_sxlhcjxx+'')=='undefined'){
    		initDataTable_sxlhcjxx();
    	}
    }
    
    
    //企业年度报告
    function loadData_yrinfo() {
        var entTypeCatg = $('#entTypeCatg').val();
        var url;
        if(entTypeCatg==50){//个体户
        	url = "/entinfo/pblist.json";
        }else if(entTypeCatg==16||entTypeCatg==17){//农专
        	url = "/entinfo/sfclist.json";
        }else{
        	url = "/entinfo/list.json";
        }
        http.httpRequest({
            url: url,
            serializable: false,
            data: {start: 0,length: 9999,params:params},
            type: 'post',
            success: function (data) { 
            	
                /*$('#pagination_yrinfo').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadData_midaltitem(page,5);
                    }
                });*/
	        	if(data.data==""||data.data==null){//没有数据
	             	$('#pubtable-yrinfo').html("<td valign='top' colspan='4' class='dataTables_empty'>无</td>"); 
	             	$("#yrinfoTotal").text(0); 
	             	//没有数据时隐藏表格
	             	//addflex("yrinfo_li","yrinfo_table");
	             	$("#yrinfo_table").hide();
               	    //$("#yrinfo_span").hide();
               	    $("#yrinfo_li").addClass("flexed-icon");
	             	return false;
	            } 
	        	var itemCount = data.recordsTotal; //获取查询出来的总数
                var handleHelper = handlebars.registerHelper("addOne", function(index) {return index+1;});//序号
                handlebars.registerHelper("transAncheDate",
                    function(value) {
	                	if(value!=""&&value!=null){
	                		var date=value.substring(0,10).split("-");
	                		return date[0]+"年"+date[1]+"月"+date[2]+"日";
	                	}
                    }
                );

                handlebars.registerHelper("transType",
                   function(value) {
                	  var text;
                      if(value=="6"){
                    	 text = "该个体户已接收纸质年报";
                      }else{
                    	 text = '<a href="javascript:void(0)" class="js-yrinfo">查看</a>';
                      }
                      return text;
                   }
                );
                if(itemCount==null||itemCount==""||itemCount==0){
                	itemCount=0;
                	$("#yrinfo_table").hide();
               	    //$("#yrinfo_span").hide();
               	    $("#yrinfo_li").addClass("flexed-icon");
                }
               $("#yrinfoTotal").text(itemCount); 
                var myTemplate = handlebars.compile($('#table-template-yrinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-yrinfo').html(myTemplate(data));
               // if(typeof itemCount!='undefined' &&itemCount>0) $('#table-yrinfo').html(myTemplate(data));
               // $("#_total_yrinfo").text(itemCount);//总数
                //var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                //$("#_pageNum_yrinfo").text(pageNum);//共多少页
            }
        });
    }
    
    
    //简易注销公告
    function loadData_er_esc_appinfo () { 
        var  url ='/syn/panoramasearch/selectResultByPriPID'; 
        http.httpRequest({
            url: url,
            serializable: false,
            data: {start: 0,length: 9999,params:params},
            type: 'post',
            success: function (data) {
            	 
                var itemCount = data.recordsTotal; //获取查询出来的总数
                /*$('#pagination_yrinfo').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadData_midaltitem(page,5);
                    }
                });*/
	        	if(data.data==""||data.data==null||itemCount.length==0){//没有数据
	             	$('#tr-er_esc_appinfo').html("<td valign='top' colspan='3' class='dataTables_empty'>无</td>"); 
	             	//没有数据时自动隐藏表格
	             	//addflex("er_esc_appinfo_li","er_esc_appinfo_table");
	             	$("#er_esc_appinfoTotal").text(0);
	             	$("#er_esc_appinfo_table").hide();
               	    //$("#er_esc_appinfo_span").hide();
               	    $("#er_esc_appinfo_li").addClass("flexed-icon");
	             	return false;
	            } 
	        	
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1;});//序号
                handlebars.registerHelper("transAncheDate",
                    function(value) {
                	    var entName=this.entName;
                	    var noticeTo=this.noticeTo; 
	                	if(value!=""&&value!=null){
	                		var date=value.substring(0,10).split("-");
	                		var noticeTos=noticeTo.substring(0,10).split("-");
	                		var noticeFrom=date[0]+"年"+date[1]+"月"+date[2]+"日";
	                		var noticeTost=noticeTos[0]+"年"+noticeTos[1]+"月"+noticeTos[2]+"日";
	                		var notice=entName+"简易注销公告信息<br/>"+"公告期:"+noticeFrom+"-"+noticeTost;
	                		return notice;
	                	}
                    }
                );

                handlebars.registerHelper("transNoticeTo",
                   function(value) { 
                     /* return '<a href="javascript:void(0)" class="js-yrinfo">查看</a>';*/
                	return "";
                   }
                );
                if(itemCount==null||itemCount==""||itemCount==0){
                	itemCount=0; 
                	$("#er_esc_appinfo_table").hide();
               	    //$("#er_esc_appinfo_span").hide();
               	    $("#er_esc_appinfo_li").addClass("flexed-icon");
	            }
                $("#er_esc_appinfoTotal").text(itemCount);
                var myTemplate = handlebars.compile($('#table-template-er_esc_appinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-er_esc_appinfo').html(myTemplate(data));
               // $("#_total_yrinfo").text(itemCount);//总数
                //var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                //$("#_pageNum_yrinfo").text(pageNum);//共多少页
            }
        });
    }

    /*第三方信息*/
    function init_dsfxx(){}
    
    //企业不动产查封信息
    function initDataTable_qybdccfxx(){
    	table_qybdccfxx = dataTable.load({
    		el:'#table_qybdccfxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetCsAttachmentEstateList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'attachmenType', className: 'center'}, 
    			{data: 'attachmentNO', className: 'center'},
    			{data: 'estateAddr', className: 'center'},
    			{data: 'attachmentDep', className: 'center'},
    			{data: 'attachmentDate', className: 'center'},
    			{data: 'attachmentCanDate', className: 'center'},
    			{data: 'attachmenStatus', className: 'center'},
    	],			
    		columnDefs : [],
    		"fnDrawCallback": function (oSettings) {
    			 $("#qybdccfxxTotal").text(oSettings._iRecordsTotal);
    			 if(oSettings._iRecordsTotal==0 && initFlag){
    				 initAddflex("qybdccfxx_li","table_qybdccfxx");
    			 }
    		}
    	});
    	table_qybdccfxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qybdccfxx_wrapper .bottom').hide();}else{$('#table_qybdccfxx_wrapper  .bottom').show();}
        })
    }
    
    //即时行政处罚信息
    function initDataTable_jsxzcfxx(){
    	table_jsxzcfxx = dataTable.load({
    		el:'#table_jsxzcfxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/selectPubOtherpunishDtoJSON',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'penDecNo', className: 'center'},
    			{data: 'illegActType', className: 'center'},
    			{data: 'penContent', className: 'center'},
    			{data: 'judAuth', className: 'center'},
    			{data: 'penDecIssDate', className: 'center'},
    			{data: 'publicDateDesc', className: 'center'},
    	],			
    		columnDefs : [
    		   
    		]
    	})
    }
    
    //知识产权出质登记信息
    function initDataTable_zscqczdjxx(){
    	table_zscqczdjxx = dataTable.load({
    		el:'#ippldg_table',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/ippldgListJSON',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'tmregNo', className: 'center'},
    			{data: 'tmname', className: 'center'},
    			{data: 'kinds', className: 'center'},
    			{data: 'pledgor', className: 'center'},
    			{data: 'impOrg', className: 'center'},
    			{data: 'pleRegPerFrom', className: 'center'},
    			{data: 'pubType', className: 'center'},
    			{data: 'publicDate', className: 'center'},
    			{data: null, className: 'center'}
    	],			
    		columnDefs : [
    		    {
    		    	targets: 6,
				      render: function (data, type, row, meta) {
				    	  return row.pleRegPerFrom + ' 至 ' + row.pleRegPerTo;
				      }
    		    },{
    		    	targets: 7,
				      render: function (data, type, row, meta) {
			    		if (data == "1") {
		                    return "变更";
		                } else if (data == "2") {
		                    return "注销";
		                } else if (data == "3") {
		                    return "撤销";
		                } else {
		                    return "有效";
		                }
				} 
  		       },
	  		     {
	   		    	targets: 3,
					      render: function (data, type, row, meta) {
					    	    if(data=="1"){
			                		return "商标";
			                	}else if(data=="2"){
			                		return "版权";
			                	}else if(data=="3"){
			                		return "专利";
			                	}else{
			                		return "";
			                	}
					      }
	   		    },
	   		    {
    		    	targets: 9,
				      render: function (data, type, row, meta) {
				    	  return "";
				      }
    		    }
  		       
    		],
    		"fnDrawCallback": function (oSettings) {
      			 $("#ippldgTotal").text(oSettings._iRecordsTotal);
      			 if(oSettings._iRecordsTotal==0 && initFlag){
      				initAddflex("ippldg_li","ippldg_table");
      			 }
      		}
    	});
    	table_zscqczdjxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#ippldg_table_wrapper .bottom').hide();}else{$('#ippldg_table_wrapper .bottom').show();}
        })
    }
    
    //即时行政许可信息
    function initDataTable_jsxzxkxx(){
    	table_jsxzxkxx = dataTable.load({
    		el:'#permit_table',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/permitListJSON',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'licNO', className: 'center'},
    			{data: 'licNameCN', className: 'center'},
    			{data: 'valFrom', className: 'center'},
    			{data: 'valTo', className: 'center'},
    			{data: 'licAnth', className: 'center'},
    			{data: 'licItem', className: 'center'},
    			{data: 'pubFlag', className: 'center'},
    			{data: null, className: 'center'}
    	],			
    		columnDefs : [
    		    {
    		    	targets: 7,
				      render: function (data, type, row, meta) {
				    	   if (data != null && data != "") {
		                        if (data == "1") {
		                            return "变更";
		                        } else if (data == "2") {
		                            return "注销";
		                        } else if (data == "3") {
		                            return "被吊销";
		                        } else if (data == "4") {
		                            return "撤销";
		                        } else {
		                            return "有效";
		                        }
		                    } else {
		                        return "有效";
		                    }
				      }
    		    },
    		    {
    		    	targets: 8,
				      render: function (data, type, row, meta) {
				    	  return "";
				      }
    		    }
    		],
    		"fnDrawCallback": function (oSettings) {
   			 $("#permittplTotal").text(oSettings._iRecordsTotal);
   			 if(oSettings._iRecordsTotal==0 && initFlag){
   				initAddflex("permit_li","permit_table");
   			 }
   		    }
    	});
    	table_jsxzxkxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#permit_table_wrapper .bottom').hide();}else{$('#permit_table_wrapper .bottom').show();}
        })
    }
    
    //标签历史信息
    function initDataTable_mainmarkHis(){
    	table_jsxzxkxx = dataTable.load({
    		el:'#mainmarkHis_table',
    		showIndex:true,
    		scrollX:true, //支持滚动
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/reg/server/mainmark/mainmarkapplyHisList.json',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'markName2',cut: {length: 20,mark:'...'}},
    			{data: 'markName4',cut: {length: 20,mark:'...'}},
    			{data: 'markName3',cut: {length: 20,mark:'...'}},
    			{data: 'auditState',cut: {length: 20,mark:'...'}},
    			{data: 'setName',cut: {length: 20,mark:'...'}},
    			{data: 'setTime',cut: {length: 20,mark:'...'}},
    			{data: 'setDeptname',cut: {length: 20,mark:'...'}},
    			{data: 'auditorName',cut: {length: 20,mark:'...'}},
    			{data: 'auditTime',cut: {length: 20,mark:'...'}},
    			{data: 'auditDeptName',cut: {length: 20,mark:'...'}}
    	],			
    		columnDefs : [
    			{
					targets: 4,
					render: function (data, type, row, meta) {
						var auditState= row.auditState;
						if("1"==auditState){
							return '待审核';
						}else if("2"==auditState){ 
							return '审核通过';
						}else if("3"==auditState){ 
							return '审核不通过';
						}
					}
				}
    		],
    		"fnDrawCallback": function (oSettings) {
   			 $("#mainmarkHis_table_total").text(oSettings._iRecordsTotal);
   			 if(oSettings._iRecordsTotal==0 && initFlag){
   				initAddflex("permit_li_mainmarkHis_table","mainmarkHis_table");
   			 }
   		    }
    	});
    	table_jsxzxkxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#mainmarkHis_table_wrapper .bottom').hide();}else{$('#mainmarkHis_table_wrapper .bottom').show();}
        })
    }
    
    //即时股权变更信息
    function initDataTable_gqbgxx(){
    	table_gqbgxx = dataTable.load({
    		el:'#invsral_table',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/invsraListJSON',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'inv', className: 'center'},
    			{data: 'beTransAmPr', className: 'center'},
    			{data: 'afTransAmPr', className: 'center'},
    			{data: 'equAltDate', className: 'center'},
    			{data: 'publicDate', className: 'center'},
    	],			
    		columnDefs : [
				{
					targets: 2,
				      render: function (data, type, row, meta) {
				    	  return row.beTransAmPr+"%"
				      }
				},
				{
					targets: 3,
				      render: function (data, type, row, meta) {
				    	  return row.afTransAmPr+"%"
				      }
				}
    	],
    	"fnDrawCallback": function (oSettings) {
  			 $("#invsralTotal").text(oSettings._iRecordsTotal);
  			 if(oSettings._iRecordsTotal==0 && initFlag){
  				initAddflex("invsral_li","invsral_table");
  			 }
  		}
    	});
    	table_gqbgxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#invsral_table_wrapper .bottom').hide();}else{$('#invsral_table_wrapper .bottom').show();}
        })
    	
    }
    
    
    
    //即时股东及出资信息   
    function initDataInvestmentTable() {
    	
        http.httpRequest({
            url: '/syn/panoramasearch/investmentListJSON',
            serializable: false,
            data:  {start: 0,length: 9999,params:params},
            success: function (data) {
                if (data.data == "" || data.data == null) {//如果没有
                    $('#investmenttplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>无</td>");
                    $("#investmentTotal").text(0);
                    //没有数据时自动隐藏表格
                    //addflex("table_jsgdyczxx_li","table_jsgdyczxx");
                    $("#table_jsgdyczxx").hide();
               	    //$("#table_jsgdyczxx_span").hide();
               	    $("#table_jsgdyczxx_li") .addClass("flexed-icon"); 
                    return false;
                }
                var showPage = data.recordsTotal;
                if(showPage==null||showPage==""||showPage==0){
                	showPage=0;
                	$("#table_jsgdyczxx").hide();
               	    //$("#table_jsgdyczxx_span").hide();
               	    $("#table_jsgdyczxx_li") .addClass("flexed-icon"); 
                }
                $("#investmentTotal").text(showPage);
               /* $('#pageinvestment').pagination(showPage, {//分页工具
                    callback: pageInvesMentCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });*/
//
//                $("#investmentCount").text(data.recordsTotal);
//                var totalPages = Math.ceil(data.recordsTotal / 5);
//                $("#investmentPageCount").text(totalPages);

                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) {
                            return index + 1;
                    });
                handlebars.registerHelper("trsPubFlag", 
                    function (value) {
                        if (value == "1") {
                            return "公示";
                        } else {
                            return "未公示";
                        }
                    });
                    var myTemplate = handlebars.compile($("#investment-templates").html());
                    handlebars.registerHelper("transDate",
                        function (value) {
                    	    if(value!=null&&value!=""){
                    	    	var date = value.split("-");
                                return date[0] + "年" + date[1] + "月" + date[2] + "日";
                    	    }else{
                    	    	return "";
                    	    }
                        });
                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#investments').html(myTemplate(data));
             }
        })
    }
    
    //即时行政许可信息
    function initPermitTable() { //行政许可 
        http.httpRequest({
            url: '/syn/panoramasearch/permitListJSON',
            serializable: false,
            data:{start: 0,length: 9999,params:params},
            success: function (data) {
                if (data.data == "" || data.data == null) {//如果没有
                    $('#permittplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>无</td>");
                    $('#permittplTotal').text(0);
                    //没有数据时自动隐藏表格
                    addflex("permit_li","permit_table");
                    return false;
                } 
                var total=data.recordsTotal
                if(total==null||total==""){
                	total=0;
                }
                $('#permittplTotal').text(total);
               /* $('#pagepermit').pagination(showPage, {//分页工具
                    callback: pagePermitCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });
*/
               /* $("#permitCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#permitPageCount").text(totalPages);
*/ 
                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) { 
                            return index + 1; 
                    });
                var myTemplate = handlebars.compile($("#permit-template").html());
                handlebars.registerHelper("transDate",
                    function (value) {
                        var date = value.split("-");
                        return date[0] + "年" + date[1] + "月" + date[2] + "日";
                    });
                handlebars.registerHelper("transPubType", function (value) {
                    if (value != null && value != "") {
                        if (value == "1") {
                            return "变更";
                        } else if (value == "2") {
                            return "注销";
                        } else if (value == "3") {
                            return "被吊销";
                        } else if (value == "4") {
                            return "撤销";
                        } else {
                            return "有效";
                        }
                    } else {
                        return "有效";
                    }
                });

                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#permit').html(myTemplate(data));
            }
        })
    }
    
    //即时知识产权出质登记信息
    function initIppldgTable() { 
        http.httpRequest({
            url: '/syn/panoramasearch/ippldgListJSON',
            serializable: false,
            data:{start: 0,length: 9999,params:params},
            success: function (data) {
               
             /*   $('#pageippldg').pagination(showPage, {//分页工具
                    callback: pageIppldgCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });*/

                /*$("#ippldgCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#ippldgPageCount").text(totalPages);*/
                if (data.data == "" || data.data == null) {//如果没有
                    $('#ippldgtplPage').html("<td valign='top' colspan='10' class='dataTables_empty'>无</td>");
                    $("#ippldgTotal").text(0);
                    //没有数据时自动隐藏表格
                    initAddflex("ippldg_li","ippldg_table");
                    return false;
                }
                var showPage = data.recordsTotal; 
                if(showPage==null||showPage==""){
                	showPage=0;
                }
                $("#ippldgTotal").text(showPage);
                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) { 
                            return index + 1; 
                    });
                var myTemplate = handlebars.compile($("#ippldg-template").html());
                handlebars.registerHelper("transDate",
                    function (value) {
                        var date = value.split("-");
                        return date[0] + "年" + date[1] + "月" + date[2] + "日";
                    });
                handlebars.registerHelper("transType", function (value) {
                    if (value == "1") {
                        return "变更";
                    } else if (value == "2") {
                        return "注销";
                    } else if (value == "3") {
                        return "撤销";
                    } else {
                        return "有效";
                    }
                });
                
                handlebars.registerHelper("transkinds",function(value){
                	
                	if(value=="1"){
                		return "商标";
                	}else if(value=="2"){
                		return "版权";
                	}else if(value=="3"){
                		return "专利";
                	}else{
                		return value;
                	} 
                });

                handlebars.registerHelper("dataFormat",
                    function (value) {
                        var date = value.split("-");
                        return date[0] + "年" + date[1] + "月" + date[2] + "日";
                    });
                handlebars.registerHelper("ifUnicode",
                    function (value) {
                        if (value == null || value == "") {
                            return "display:block";
                        } else {
                            return "display:none";
                        }
                    });
                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#ippldg').html(myTemplate(data));
            }
        })
    }
    
    //即时行政处罚
    function initCaseTable() { //行政处罚
        http.httpRequest({
            url: '/syn/panoramasearch/caseListJSON',
            serializable: false,
            data:{start: 0,length: 9999,params:params},
            success: function (data) {
            	
                if (data.data == "" || data.data == null) {//如果没有
                    $('#imcasetplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>无</td>");
                    $('#imcaseTotal').text(0);
                    //没有数据时自动隐藏表格
                    //addflex("imcase_li","imcase_table");
                    $("#imcase_table").hide();
               	    //$("#imcase_span").hide(); 
               	    $("#imcase_li") .addClass("flexed-icon"); 
                    return false;
                }
                var showPage = data.recordsTotal; 
                if(showPage==null||showPage==""||showPage==0){
                	showPage=0;
                	$("#imcase_table").hide();
               	    //$("#imcase_span").hide(); 
               	    $("#imcase_li") .addClass("flexed-icon"); 
                }
               
                /*$('#pagecase').pagination(showPage, {//分页工具
                    callback: pageCaseCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });*/

               /* $("#caseCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#casePageCount").text(totalPages);
*/
                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) { 
                            return index + 1; 
                    });
                var myTemplate = handlebars.compile($("#imcase-template").html());
                handlebars.registerHelper("transDate",
                    function (value) {
                        if (value != null && value != "") {
                            var date = value.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        }
                    });
                handlebars.registerHelper("dataFormat",
                    function (value) {
                        if (value != null && value != "") {
                            var myDate = new Date(value);
                            var month = myDate.getMonth() + 1;
                            return myDate.getFullYear() + "年" + month + "月" + myDate.getDate() + "日";
                        }
                    });
                handlebars.registerHelper("rowdisplay",
                    function (value) {
                        if (value == null || value == "") {
                            return "1";
                        } else {
                            return "2";
                        }
                    });
                handlebars.registerHelper("dataList",
                    function (value) {
                        if (value == null || value == "") {
                            return "display:none";
                        } else {
                            return "";
                        }
                    });

                handlebars.registerHelper("transType",
                    function (value) {
                        if (value == null && value == "") {
                            if (value == "1") {
                                return "变更";
                            } else if (value == "2") {
                                return "诉讼";
                            } else if (value == "3") {
                                return "复议"
                            } else {
                                return "有效";
                            }
                        } else {
                            return "有效";
                        }
                    });

                $('#imcaseTotal').text(showPage);
                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#imcase').html(myTemplate(data));
            }
        })
    }
    
    
    //即时股权变更信息
    function initDataInvsraTable() {
        http.httpRequest({
            url: '/syn/panoramasearch/invsraListJSON',
            serializable: false,
            data:{start: 0,length: 9999,pageNum: 0,params:params},
            success: function (data) {
	        	 if (data.data == "" || data.data == null) {//如果没有
	                  $('#invsraltplPage').html("<td valign='top' colspan='6' class='dataTables_empty'>无</td>");
	                  $("#invsralTotal").text(0); 
	                  //没有数据时自动隐藏表格
	                  initAddflex("invsral_li","invsral_table");
	                  return false;
	             }
                var showPage = data.recordsTotal;
                if(showPage==null||showPage==""){
                	showPage=0;
                }
                $("#invsralTotal").text(showPage); 
                /*$('#paginvsral').pagination(showPage, {//分页工具
                    callback: pageInvsraCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });*/
                /*$("#invsralCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#invsralPageCount").text(totalPages);*/
                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) {
                            return index + 1;
                    });
                var myTemplate = handlebars.compile($("#invsral-template").html());
                handlebars.registerHelper("inv_trans",
                    function (value) {
                        return value;
                    });
                handlebars.registerHelper("beTransAmPr_trans",
                    function (value) {
                        return value;
                    });
                handlebars.registerHelper("afTransAmPr_trans",
                    function (value) {
                        return value;
                    });

                handlebars.registerHelper("transDate",
                    function (value) {
                        var date = value.split("-");
                        return date[0] + "年" + date[1] + "月" + date[2] + "日";
                    });

                handlebars.registerHelper("dataFormat",
                    function (value) {
                        var date = value.split("-");
                        return date[0] + "年" + date[1] + "月" + date[2] + "日";
                    }); 

                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0) $('#invsral').html(myTemplate(data));
            }
        })
    }
    
    
    //即时股东及出资信息
    function initDataTable_jsgdyczxx(page){
    	
    	http.httpRequest({
            url: '/syn/panoramasearch/investmentListJSON',
            serializable: false,
            data: {
	            "pageNum":page,
	            "priPID":$("#priPID").val(),
	            length:5,
	            params:{ "pageNum":page }
            },
            success: function(data) {
            	
                if(data.data==""||data.data==null){//没有数据
                	$('#tplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>无</td>"); 
                	return false;
                }
            	
                if(page==0){ page=page; }
                else{page=page-1;}
                
            	var showPage= data.recordsTotal;
            	
                $('#pageinvestment').pagination(showPage, {//分页工具
                    callback:pageInvsraCallback,
                    prev_text: '上一页',
                    next_text: '下一页',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    first_text: '首页',
                    last_text: '末页',
                    items_per_page:5,
                });
                
                $("#investmentCount").text(data.recordsTotal);
                if(data.recordsTotal%5==0){//计算页数
                	$("#investmentPageCount").text(data.recordsTotal/5);
                }else{
               	  	$("#investmentPageCount").text(Math.floor(data.recordsTotal/5)+1);
                }
                
              var handleHelper = handlebars.registerHelper("addOne",
              	function(index) {
            	  if(page>=0){//返回+1之后的结果
            		  var toIn=((page)*5);
                      return index + 1+toIn;
                  }else{
                      return index+1;
                  }
              }); 
              handlebars.registerHelper("trsPubFlag",
            		  function(value) {if (value == "1") {return "公示";} else {return "未公示";} });
                var myTemplate = handlebars.compile($("#investment-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });
                $('#investment').html(myTemplate(data)); 
            }
        }) 
    }
    
//行政处罚 包括工商和其他部门的    
function initDataTable_pubOtherpunish(){ 
    	http.httpRequest({
            url: '/syn/panoramasearch/selectPubOtherpunishDtoJSON',
            serializable: false,
            data: {start: 0,length: 9999,params:params},
            success: function(data) {
                if(data.data==""||data.data==null){//没有数据
                	$('#pubOtherpunishPage').html("<td valign='top' colspan='7' class='dataTables_empty'>无</td>"); 
                	initAddflex("jsxzcfxx_li","table_jsxzcfxx");
                	$("#pubOtherpunishTotal").text(0);
                	$("#table_jsxzcfxx").hide();
                	$("#jsxzcfxx_li").addClass("flexed-icon");
                	$("#table_jsxzcfxx").hide();
                    $("#table_jsxzcfxx_wrapper").css("display","none"); 
                	//$("#jsxzcfxx_span").hide();
                	return false;
                }
              var showPage= data.recordsTotal;
              var handleHelper = handlebars.registerHelper("addOne",
              	function(index) { 
                      return index+1; 
              });;
              handlebars.registerHelper("transPenContent", function(data) {
            	  
            	  return data;
			  });
              handlebars.registerHelper("transPubFlag", function(data) { 
            		if("1"==data){
            			return this.auditDate;
            		}else{
            			return "";
            		}
  			  });
              
              if(showPage==null||showPage==""||showPage==0){
            	  
            	  showPage=0;
            	  $("#table_jsxzcfxx").hide();
            	 // $("#jsxzcfxx_span").hide();
              }
              $("#pubOtherpunishTotal").text(showPage);
             var myTemplate = handlebars.compile($("#pubOtherpunish-template").html());
             $('#pubOtherpunish').html(myTemplate(data)); 
            /*  handlebars.registerHelper("trsPubFlag",
            		  function(value) {if (value == "1") {return "公示";} else {return "未公示";} });
                var myTemplate = handlebars.compile($("#investment-template").html());
                handlebars.registerHelper("transDate",
                        function(value) {
                           var date=value.split("-");
                           return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        });
                $('#investment').html(myTemplate(data));*/ 
            }
        }) 
    }



		//企业行政许可信息
		function initPubotherlicenceTable() { //行政许可 
		    http.httpRequest({
		    	url:'/syn/panoramasearch/doGetPubOtherlicenceList',
		        serializable: false,
		        data:{start: 0,length: 9999,params:params},
		        success: function (data) {
		            if (data.data == "" || data.data == null) {//如果没有
		                $('#tr-pubotherlicence').html("<td valign='top' colspan='8' class='dataTables_empty'>无</td>");
		                //总条数
		                $("#pubotherlicTotal").text(0); 
		                $("#_tab-pubotherlicence").hide();
		                $("#licenceinfo") .addClass("flexed-icon"); 
		                return false;
		            }  
		           /* $('#pagepermit').pagination(showPage, {//分页工具
		                callback: pagePermitCallback,
		                items_per_page: 5,
		                prev_text: '<i class="icon-triangle-left"></i>上一页',
		                next_text: '下一页<i class="icon-triangle-right"></i>',
		                num_display_entries: 3,
		                num_edge_entries: 2,
		                current_page: page,
		                link_to: 'javascript:void(0)',
		                ellipse_text: '...',
		                first_text: '首页',
		                last_text: '末页'
		            });
		*/
		           /* $("#permitCount").text(data.recordsTotal);
		            var totalPages = Math.ceil(data.recordsTotal / 5);
		            $("#permitPageCount").text(totalPages);
		*/ 
		            var handleHelper = handlebars.registerHelper("addOne",
		                function (index) { 
		                        return index + 1; 
		                });
		            handlebars.registerHelper("altDate", function(altDate) {
		            	/*if(altDate != null && altDate != "") {
		            		return util.dateFormat(new Date(util.dateTransform(altDate)),"yy年mm月dd日");
		            	}else{
		            		return "";
		            	}*/
		            	return altDate;
		        	});
	                handlebars.registerHelper("translicState", function(licState) {
		            	if("1"==licState){
		            		return "有效";
		            	}else if("0"==licState){
		            		return "无效";
		            	}else{
		            		return "";
		            	}
		        	});
		            handlebars.registerHelper("dataList", function(dataList) {
		                 if(dataList == null || dataList == ""){
		                	 return "display:none";
		                 }else{
		                	 return "";
		                 }
		            });
		            if(data.recordsTotal==null||data.recordsTotal==""||data.recordsTotal==0){
		            	$("#pubotherlicTotal").text(0); 
		            	$("#_tab-pubotherlicence").hide();
		            }else{
		            	$("#pubotherlicTotal").text(data.recordsTotal); 
		            }
		            var myTemplate = handlebars.compile($("#table-template_pubotherlicence").html()); 
		            if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0){
		            	$('#table-pubotherlicence').html(myTemplate(data));
		            }
		        }
		    })
		}
    
    //企业不动产抵押信息
    function initDataTable_qybdcdyxx(){
    	table_qybdcdyxx = dataTable.load({
    		el:'#table_qybdcdyxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetCsMortEstateInfoList',
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
    		            "fnDrawCallback": function (oSettings) {
    		     			 $("#qybdcdyxxTotal").text(oSettings._iRecordsTotal);
    		     			 if(oSettings._iRecordsTotal==0 && initFlag){
    		     				initAddflex("qybdcdyxx_li","table_qybdcdyxx");
    		     			 }
    		        }            
    	});
    	table_qybdcdyxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qybdcdyxx_wrapper .bottom').hide();}else{$('#table_qybdcdyxx_wrapper  .bottom').show();}
        })
    }
    //企业专利信息
    function initDataTable_qyzlxx(){
    	table_qyzlxx = dataTable.load({
    		el:'#table_qyzlxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetCsPatentiInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center',width:'80px'},
    			{data: 'patentNO', className: 'center',width:'150px'},
    			{data: 'patentName', className: 'center',width:'180px'},
    			{data: 'patentType', className: 'center',width:'130px'},
    			{data: 'patenter', className: 'center',width:'180px'},
    	],			
    		columnDefs : [],
		    "fnDrawCallback": function (oSettings) {
 			 $("#qyzlxx").text(oSettings._iRecordsTotal);
 			 if(oSettings._iRecordsTotal == 0 && initFlag){
 				initAddflex("entzlinfo","table_qyzlxx");
			  }
 			}
    	})
    	table_qyzlxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_qyzlxx .dataTables_wrapper .bottom').hide();}else{$('#tab_qyzlxx .dataTables_wrapper .bottom').show();}
        })
    }
    
    //严重违法失信信息
    function initDataTable_yzwfsxxx(){
    	table_yzwfsxxx = dataTable.load({
    		el:'#table_yzwfsxxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetCsPubIlldisDetailList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: "", className: 'center'},
    			{data: 'serillrea_CN', className: 'center'},
    			{data: 'abnTime', className: 'center'},
    			{data: 'deDocNum', className: 'center'},
    			{data: 'deCorg_CN', className: 'center'},
    			{data: 'peMexcPrexs_CN', className: 'center'},
    			{data: 'remDate', className: 'center'},
    			{data: 'reCorgNum', className: 'center'},
    			{data: 'reCorg_CN', className: 'center'}
    	],			
    		columnDefs : [],
    		 "fnDrawCallback": function (oSettings) {
    			 $("#yzwfsxxxTotal").text(oSettings._iRecordsTotal);
    			 if(oSettings._iRecordsTotal==0 && initFlag){
    				 initAddflex("yzwfsxxx_li","table_yzwfsxxx");
    			 }
    		}
    		
    	});
    	table_yzwfsxxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_yzwfsxxx_wrapper .bottom').hide();}else{$('#table_yzwfsxxx_wrapper  .bottom').show();}
        })
    }
    //企业商标信息
    function initDataTable_qysbxx(){
    	table_qysbxx = dataTable.load({
    		el:'#table_qysbxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/brandInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: null, className: 'center'},
    			{data: 'reg_NUM', className: 'center'},
    			{data: 'int_CLS', className: 'center'},
    			{data: null, className: 'center'},
    			{data: 'REG_ANNC_DATE', className: 'center'},
    			{data: 'reg_ANNC_ISSUE', className: 'center'},
    			{data: 'goodsName', className: 'center',width:"400px"}
    	],			
    		columnDefs : [
	              {
	  				targets: 1,
	  			      render: function (data, type, row, meta) {
	  			    	  console.log(row);
	  			    	  return '<img src="data:image/png;base64,'+row.imageString+'"  width="100px">';
	  			      }
      		     },{
 	  				targets: 4,
	  			      render: function (data, type, row, meta) {
	  			    	  var startTime = row.PROPERTY_BGN_DATE;
	  			    	  var endTime = row.PROPERTY_END_DATE;
	  			    	  if(startTime != null && endTime != null){
	  			    		return startTime + '至' + endTime; 
	  			    	  }
	  			    	  return "";
	  			      }
    		     }],
    		     "fnDrawCallback": function (oSettings) {
        			 $("#qysbxx").text(oSettings._iRecordsTotal);
        			 if(oSettings._iRecordsTotal == 0 && initFlag){
        				 initAddflex("tmdetailsinfo","table_qysbxx");
     				 }
        		}
    	})
    	table_qysbxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_qysbxx .dataTables_wrapper .bottom').hide();}else{$('#tab_qysbxx .dataTables_wrapper .bottom').show();}
        })
    }
    
    //企业股权冻结信息
    function initDataTable_qygqdjxx(){
    	table_qygqdjxx = dataTable.load({
    		el:'#table_qygqdjxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetPubJusticeInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'inv', className: 'center'}, 
    			{data: 'froAm', className: 'center'},
    			{data: 'executionCourt', className: 'center'},
    			{data: 'executeNo', className: 'center'},
    			{data: 'justiceType', className: 'center'},
    			{data: 'frozState', className: 'center'}
    	],			
    		columnDefs : [
    		              {
							targets: 5,
						      render: function (data, type, row, meta) {
						    	    if(data=="1"){
						    			return "股权冻结";
						    		}else if(data=="2"){
						    			return "股东变更信息";
						    		}else{
						    			return "";
						    		}
						      }
    		              },
    		              {
  							targets: 6,
  						      render: function (data, type, row, meta) {
  						    	if(data=="1")
  						    		return "冻结";
  						    	if(data=="2")
  					    		  	return "解除冻结";
  						    	if(data=="3"){
  						    		return "失效冻结";
  						    	}else{
  						    		return "";
  						    	}
  						      }
      		              }
    		              ],
    		              "fnDrawCallback": function (oSettings) {
    		     			 $("#qygqdjxxTotal").text(oSettings._iRecordsTotal);
    		     			 if(oSettings._iRecordsTotal==0 && initFlag){
    		     				initAddflex("qygqdjxx_li","table_qygqdjxx");
    		     			 }
    		     		 }
    	});
    	table_qygqdjxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qygqdjxx_wrapper .bottom').hide();}else{$('#table_qygqdjxx_wrapper .bottom').show();}
        })
    }
    //企业动产抵押信息
    function initDataTable_qydcdyxx(){
    	table_qydcdyxx = dataTable.load({
    		el:'#table_qydcdyxx',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
    		ajax:{
    			url:'/syn/panoramasearch/doGetMortRegInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'filingNO', className: 'center'},
    			{data: 'checkDate', className: 'center'},
    			{data: 'departMentName', className: 'center'},
    			{data: 'mortGageAmount', className: 'center'},
    			{data: 'checkStatus', className: 'center'},
    			{data: 'pefPerForm', className: 'center'},
    			{data: null, className: 'center'}
    	],			
    	columnDefs : [
						     {
								targets: 5,
							      render: function (data, type, row, meta) {
							    	if(data=="1")
							    		return "已确认";
							    	if(data=="0"){
							    		return "未确认";
							    	}else{
							    		return "";
							    	}
							      }
						    },
						    {
								targets: 7,
							      render: function (data, type, row, meta) { 
							    		return ""; 
							      }
						    }
    	              ],
	    	"fnDrawCallback": function (oSettings) {
	   			$("#qydcdyxxTotal").text(oSettings._iRecordsTotal);
	   			if(oSettings._iRecordsTotal==0 && initFlag){
	   				initAddflex("qydcdyxx_li","table_qydcdyxx");
	   			}
	   		}
    	});
    	table_qydcdyxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qydcdyxx_wrapper .bottom').hide();}else{$('#table_qydcdyxx_wrapper  .bottom').show();}
        })
    }
	//抽查检查信息
    function initDataTable_ccjcxx(){
    	table_ccjcxx = dataTable.load({
    		el:'#table_ccjcxx',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
    		ajax:{
    			url:'/syn/panoramasearch/doGetPubScitemResultList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    					{data: null, className: 'center'},
    					{data: 'scName', className: 'center'},
    					{data: 'taskNO', className: 'center'},
    					{data: 'inspectDesc', className: 'center'},
    					{data: 'scType', className: 'center'},
    					{data: 'inspectDate', className: 'center'},
    					{data: 'scResult', className: 'center'}
    	]/*,			
    		columnDefs : [
    		         {
						targets: 3,
					      render: function (data, type, row, meta) {
					    	  var scResults = data;
					    	  var scResultArr = scResults.split(",");
					    	  var showResult = "";
					    	  for(var i=0;i<scResultArr.length;i++){
			                		if(parseInt(scResultArr[i]) == 1){
			                			showResult = showResult + '正常（符合信息公示相关规定）;';
			                		}else if(parseInt(scResultArr[i]) == 2){
			                			showResult = showResult + '未按规定公示即时信息;';
			                		}else if(parseInt(scResultArr[i]) == 3){
			                			showResult = showResult + '未按规定公示年报信息;';
			                		}else if(parseInt(scResultArr[i]) == 4){
			                			showResult = showResult + '通过登记的住所（经营场所）无法联系;';
			                		}else if(parseInt(scResultArr[i]) == 5){
			                			showResult = showResult + '公示信息隐瞒真实情况、弄虚作假;';
			                		}else if(parseInt(scResultArr[i]) == 6){
			                			showResult = showResult +  '不予配合情节严重;';
			                		}else if(parseInt(scResultArr[i]) == 7){
			                			showResult = showResult +  '已办理营业执照注销;';
			                		}else if(parseInt(scResultArr[i]) == 8){
			                			showResult = showResult +  '被吊销营业执照;';
			                		}else if(parseInt(scResultArr[i]) == 9){
			                			showResult = showResult +  '被撤销登记;';
			                		}else{
			                			showResult = showResult +  "正常（符合信息公示相关规定）;";
			                		}
			                	}
					    	return showResult;
					      }
					} 
    		]*/
    		,
    		"fnDrawCallback": function (oSettings) {
    			 $("#ccjcxxTotal").text(oSettings._iRecordsTotal);
    			 //没有数据时自动隐藏
    			 if(oSettings._iRecordsTotal==0 && initFlag){
    				 initAddflex("ccjcxx_li","table_ccjcxx");
    			 }
    		}
    	});
    	table_ccjcxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_ccjcxx_wrapper .bottom').hide();}else{$('#table_ccjcxx_wrapper .bottom').show();}
        })
    }
    
    //企业股权出质信息
    function initDataTable_qygqczxx(){
    	table_qygqczxx = dataTable.load({
    		el:'#table_qygqczxx',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetSpPledgeList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    					{data: null, className: 'center'},
    					{data: 'orderNO', className: 'center'},
    					{data: 'pledgor', className: 'center'},
    					{data: 'pleBLicNO', className: 'center'},
    					{data: 'impAm', className: 'center'},
    					{data: 'impOrg', className: 'center'},
    					{data: 'impBLicNO', className: 'center'},
    					{data: 'equPleDate', className: 'center'},
    					{data: 'statusName', className: 'center'},
    					{data: 'recDate', className: 'center'},
    					{data: null, className: 'center'}
    				],
    		columnDefs : [],
    		"fnDrawCallback": function (oSettings) {
   			 $("#qygqczxxTotal").text(oSettings._iRecordsTotal);
   			 if(oSettings._iRecordsTotal==0 && initFlag){
   				initAddflex("qygqczxx_li","table_qygqczxx");
   			 }
    		}
    	});
    	table_qygqczxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qygqczxx_wrapper .bottom').hide();}else{$('#table_qygqczxx_wrapper  .bottom').show();}
        })
    }
    
    
    //对外提供担保信息
    function initDataTable_forguaranteeinfo(){
    	 table_forguaranteeinfo = dataTable.load({
    		el:'#table_forguaranteeinfo',
    		showIndex:true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:'/syn/panoramasearch/doGetforGuaranteeInfoList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    			{data: null, className: 'center'},
    			{data: 'more', className: 'center'}, 
    			{data: 'mortgagor', className: 'center'},
    			{data: 'priClaSecKind', className: 'center'},
    			{data: 'priClaSecAm', className: 'center'},
    			{data: 'pefPerForm', className: 'center'},
    			{data: 'guaPeriod', className: 'center'},
    			{data: 'gaType', className: 'center'}
    	],			
    		columnDefs : [
								{
									targets: 3,
								      render: function (data, type, row, meta) {
								    	  if (data == "1") {
								                return "合同";
								            } else if (data == "2") {
								                return "其他";
								            } else {
								                return "";
								            }
								      }
								},
								{
									targets: 5,
								      render: function (data, type, row, meta) {
								    	  if (data != null&&row.pefPerTo!=null) {
								                return data+"至"+row.pefPerTo;
								            } else {
								                return "";
								            }
								      }
								},
								{
									targets: 6,
								      render: function (data, type, row, meta) {
								    	    if (data == "1") {
								                return "期间";
								            } else if (data == "2") {
								                return "未约定";
								            } else {
								                return "";
								            }
								      }
								},
								{
									targets: 7,
								      render: function (data, type, row, meta) {
								    	    if (data == "1") {
								                return "一般保证";
								            } else if (data == "2") {
								                return "连带保证";
								            }else if (data == "3") {
								                return "未约定";
								            } else {
								                return "";
								            }
								      }
								}
    		              ],
			    		"fnDrawCallback": function (oSettings) {
			    			 $("#forguaranteeinfoTotal").text(oSettings._iRecordsTotal);
			    			 if(oSettings._iRecordsTotal==0 && initFlag){
			    				 initAddflex("forguaranteeinfo_li","table_forguaranteeinfo");
			    			 }
			    		}
    	});
    	 table_forguaranteeinfo.on('xhr.dt',function(e,settings,json,xhr){
     		if(json.recordsTotal <= 5){$('#table_forguaranteeinfo_wrapper .bottom').hide();}else{$('#table_forguaranteeinfo_wrapper  .bottom').show();}
         })
    }
    
   
    
    //高管人员信息
    function initDataTable_ggryxx() {
    	table_ggryxx = dataTable.load({
		el : '#table_ggryxx',
		showIndex: true,
		// scrollX: true,
		lengthMenu: [ 5, 10, 20, 50],
		ajax : {
			url : '/syn/panoramasearch/limitMemberList' ,
			data :function(d){
				d.params = params;
			}
		},
		columns : [
			{data: null, className: 'center'},
			{data: null, className: 'center'},
			{data: null, className: 'center'},
			{data: 'posiContent', className: 'center'}
		],
		columnDefs : [
				 {
					targets : 1,
					render : function(data, type, row, meta) {
						if(row.limitFlag =='1' && row.name !="" && row.name !=null){
							return row.name+"&nbsp;<span class='light'>(受限)</span>";
						}else if(row.limitFlag =='0' && row.name !="" && row.name !=null){
							return row.name;
						}else if((row.limitFlag =="" || row.limitFlag ==null) && row.name !="" && row.name !=null){
							return row.name;
						}else{
							return "";
						}
					}
				},{
					targets : 2,
					render : function(data, type, row, meta) {
						if(row.cerNO != "" && row.cerNO != null){
							var cerNO = row.cerNO;
							cerNO = cerNO.substring(0,cerNO.length-4);
						    return cerNO+"****";
						}else{
							return "";
						}
					}
		        }],
	    	    "fnDrawCallback": function (oSettings) {
	    			 $("#ggryxx").text(oSettings._iRecordsTotal);
	    			 if(oSettings._iRecordsTotal == 0 && initFlag){
	    				 initAddflex("manageinfo","table_ggryxx");
	    			 }
	    		}
	  });
    	table_ggryxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_djxkxx .dataTables_wrapper .bottom').hide();}else{$('#tab_djxkxx .dataTables_wrapper .bottom').show();}
        })
	}
    
    //分支机构信息
    function initDataTable_fzjgxx(){
    	table_fzjgxx = dataTable.load({
    		el : '#table_fzjgxx',
    		showIndex: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax : {
    			url : '/syn/panoramasearch/doGetBranchList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
				{data: null, className: 'center'},
				{data: null, className: 'center'},
				{data: 'entName', className: 'center'},
				{data: 'regOrgName', className: 'center'},
				{data: null, className: 'center'}
    		],
    		columnDefs :[{
							targets : 1,
							render : function(data, type, row, meta) {
								if(row.regNO != "" && row.regNO != null){
								    return row.regNO;
								}else{
									return row.uniCode;
								}
							}
			           },{
							targets : 4,
							render : function(data, type, row, meta) {
								 if(row.regState ==null || row.regState =="")return "";
								 if(row.regState=='A' || row.regState=='B' || row.regState=='K' ||row.regState=='DA' ||row.regState=='X' )
			            			 return "存续";
			            		 if(row.regState=='XX' || row.regState=='DX') return "注销";
			            		 if(row.regState=='C') return "撤销";
			            		 if(row.regState=='D') return "吊销";
			            		 if(row.regState=='Q') return "迁出";
							}
			           }],
			           "fnDrawCallback": function (oSettings) {
			    			 $("#fzjg").text(oSettings._iRecordsTotal);
			    			 if(oSettings._iRecordsTotal == 0 && initFlag){
			    				 initAddflex("branchinfo","table_fzjgxx");
			    			 }
			    		}
    	     })
    	    table_fzjgxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_fzjgxx .dataTables_wrapper .bottom').hide();}else{$('#tab_djxkxx .dataTables_wrapper .bottom').show();}
        })
    }
    
    // 清算信息
    function initDataTable_qsxx(){
    	var priPID = $("#priPID").val();
    	http.httpRequest({
            url: '/midliquidation/get.json',
            serializable: false,
            data: {priPID:priPID},
            type: 'post',
            success: function (data) {
            	if(data.id != null){
            		$("#isShow").hide();
            		$("#ligPrincipal").html(data.ligPrincipal);
                	$("#liqMem").html(data.liqMem);
            	}else
            		$("#qsxx").html("").text(0);
	            	if(!$("#clearInfo").hasClass("flexed-icon")){
	            		initAddflex("clearInfo","table_qsxx");
	            	}
                }
        });
    }
    
    // 变更信息
    function initDataTable_bgxx(){
    	table_bgxx = dataTable.load({
    		el : '#table_bgxx',
    		showIndex: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax : {
    			url : '/syn/panoramasearch/midaltitemList',
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
				{data: null, className: 'center'},
				{data: "altContent", className: 'center',width:'100px'},
				{data: "altBeContent", className: 'center'},
				{data: "altAfContent", className: 'center'},
				{data: "altDate", className: 'center',width:'100px'}
    		],
    		columnDefs : [],
    		"fnDrawCallback": function (oSettings) {
   			 $("#bgxx").text(oSettings._iRecordsTotal);
   			 if(oSettings._iRecordsTotal == 0 && initFlag){
   				initAddflex("changeInfo","table_bgxx");
			 }
   		   }
    	})
    	table_bgxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_bgxx .dataTables_wrapper .bottom').hide();}else{$('#tab_bgxx .dataTables_wrapper .bottom').show();}
        })
    }


    //股东及出资人
    function initDataTable_gdjczxx(){
    	table_gdjczxx = dataTable.load({
    		el : '#table_gdjczxx',
    		showIndex: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax : {
    			url : '/syn/panoramasearch/doGetMidInvList' ,
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
	           	{data: null, className: 'center'},       	
			    {data: 'inv',className: 'center'},
//              {data: 'country',className: 'center'},
                {data: 'invType',className: 'center'},
                {data: 'cerType',className: 'center'},
                {data: null,className: 'center'},
                {data: 'subConAm',className: 'center'},
                {data: 'currency',className: 'center'},
                {data: 'subConProp',className: 'center'},
                {data: 'acConAm',className: 'center'}
    		],
    		columnDefs : [
					 {
						targets : 2,
						render : function(data, type, row, meta) {
							if(row.invType == '1'){
			                   return '企业法人';
		                    } else if(row.invType == '2'){
		                	   return '自然人';
		                    } else if(row.invType == '3'){
		                	   return '其他股东';
		                    } else{
		                    	return "";
		                    }
						}
				   },{
						targets : 3,
						render : function(data, type, row, meta) {
							if(row.invType == '1'){
		                		return "法人营业执照"
		                    }else if(row.invType == '2'){
		                    	return row.cerTypeName;
		                    }else if(row.invType == '3'){
		                    	return "其他";
		                    }else{
		                    	return "";
		                    }
						}
				   },{
						targets : 4,
						render : function(data, type, row, meta) {
							if(data.invType == '1'||data.invType == '3'){
		                  	   return data.bLicNO;
		                    }else if(data.invType == '2'){
		                    	return data.cerNO;
		                    }else{
		                    	return "";
		                    }
						}
				   }],
				   "fnDrawCallback": function (oSettings) {
			   			 $("#gdczxx").text(oSettings._iRecordsTotal);
			   			 if(oSettings._iRecordsTotal == 0 && initFlag){
			   				initAddflex("investinfo","table_gdjczxx");
						 }
			   		} 
    	  });
    	table_gdjczxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_gdczxx .dataTables_wrapper .bottom').hide();}else{$('#tab_gdczxx .dataTables_wrapper .bottom').show();}
        })
    }
    
    //对外投资信息
    function initDataTable_dwtzxx(){
    	table_dwtzxx = dataTable.load({
    		el : '#table_dwtzxx',
    		showIndex: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax : {
    			url : '/syn/panoramasearch/forinvestMentList' ,
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    		           {data: null, className: 'center'},       	
    		           {data: 'uniCode',className: 'center'},
                       {data: 'entName',className: 'center'},
                       {data: 'subConAm',className: 'center'},
                       {data: 'conFormCN',className: 'center'},
                       {data: 'subConProp',className: 'center'},
                       {data: 'acConAm',className: 'center'},
                       {data: 'acConFormCn',className: 'center'},
                       {data: 'acConAmProp',className: 'center'}
    		         ],
    		columnDefs : [],
    		 "fnDrawCallback": function (oSettings) {
	   			 $("#dwtzxx").text(oSettings._iRecordsTotal);
	   			 if(oSettings._iRecordsTotal == 0 && initFlag){
	   				initAddflex("outinverstinfo","table_dwtzxx");
				 }
	   		} 
    	});
    	table_dwtzxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#tab_dwtz .dataTables_wrapper .bottom').hide();}else{$('#tab_dwtz .dataTables_wrapper .bottom').show();}
        })
    }
    
    //企业行政处罚信息

    //企业良好信息
    function initDataTable_qyxzcfxx(){
    	table_qyxzcfxx = dataTable.load({
    		el:'#table_qyxzcfxx',
    		showIndex: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		retrieve: true,
    		ajax:{
    			url:'/syn/panoramasearch/selectFavorAbleInfoJSON',
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
				{data: 'regDeptCn', className: 'center'}
    	   	],
    	   columnDefs : [
				{
					targets: 1,
				      render: function (data, type, row, meta) {
				    	  if (data == "0") {
	                            return "百强民营企业";
	                        } else if (data == "1") {
	                            return "驰名商标";
	                        } else if (data == "2") {
	                            return "知名商号";
	                        }else if (data == "3") {
	                            return "著名商标";
	                        }else if (data == "4") {
	                            return "守合同重信用企业";
	                        }else if (data == "5") {
	                            return "信用示范管理企业";
	                        }else if (data == "6") {
	                            return "小微企业成长之星";
	                        } else {
	                            return "";
	                        }
				      }
				},
				{
					targets: 2,
				      render: function (data, type, row, meta) {
				    	  if (data == "0") {
	                            return "全国";
	                        } else if (data == "1") {
	                            return "省级";
	                        } else if (data == "2") {
	                            return "市级";
	                        }else if (data == "3") {
	                            return "县级";
	                        }else {
	                            return "";
	                        }
				      }
				},
				{
					targets: 7,
				      render: function (data, type, row, meta) {
				    	  if (data == "1") {
	                            return "有效";
	                        } else if (data == "0") {
	                            return "无效";
	                        }else {
	                            return "";
	                        }
				      }
				}
    	    ],
    	    "fnDrawCallback": function (oSettings) {
    	    	 //没有数据时自动隐藏表格
    	    	 if(oSettings._iRecordsTotal==0 && initFlag){
    	    		 initAddflex("qyxzcfxx_li","table_qyxzcfxx");
    	    	 }
    			 $("#wfsxxxTotal").text(oSettings._iRecordsTotal);
    		}
    	});
    	table_qyxzcfxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qyxzcfxx_wrapper .bottom').hide();}else{$('#table_qyxzcfxx_wrapper .bottom').show();}
        })
    }
    
    //企业经营异常名录
    function initDataTable_qyjyqcxx(){ 
    	table_qyjyqcxx = dataTable.load({
    		el:'#table_qyjyqcxx',
    		scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
    		ajax:{
    			url:"/syn/panoramasearch/doGetPubOpanoMalyList",
    			data :function(d){
    				d.params = params;
    			} 
    		},
    		columns : [
    	    	{data: null, className: 'center'},
    	    	{data: 'speCauseCN', className: 'center'},
    	    	{data: 'abnTime', className: 'center'},
    	    	{data: 'penDecNo', className: 'center'},
    	    	{data: 'decorgCN', className: 'center'}, 
    	    	{data: 'remExcpresCN', className: 'center'}, 
    	    	{data: 'remDate', className: 'center'},
    	    	{data: 'canOutPenDecNo', className: 'center'},
    	    	{data: 'reDecOrgCN', className: 'center'}
    	   	],
    	   columnDefs : [],
    	   "fnDrawCallback": function (oSettings) {
  			 $("#qyjyqcxxTotal").text(oSettings._iRecordsTotal);
  			 if(oSettings._iRecordsTotal==0 && initFlag){
  				initAddflex("qyjyqcxx_li","table_qyjyqcxx");
  			 }
  		    }
    	});
    	table_qyjyqcxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qyjyqcxx_wrapper .bottom').hide();}else{$('#table_qyjyqcxx_wrapper .bottom').show();}
        })
    }
    
    //个体户异常
    function initDataTable_pbyc(){
    	table_qyjyqcxx = dataTable.load({
    		el:'#table_qyjyqcxx',
    		scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
    		ajax:{
    			url:"/syn/panoramasearch/doGetPbOpanoMalyList",
    			data :function(d){
    				d.params = params;
    			} 
    		},
    		columns : [
    	    	{data: null, className: 'center'},
    	    	{data: 'excpStaResCN', className: 'center'},
    	    	{data: 'cogDate', className: 'center'},
    	    	{data: 'decorgCN', className: 'center'},
    	    	{data: 'norReaCN', className: 'center'}, 
    	    	{data: 'norDate', className: 'center'}, 
    	    	{data: 'norDecOrgCN', className: 'center'}
    	   	],
    	   columnDefs : [],
    	   "fnDrawCallback": function (oSettings) {
  			 $("#qyjyqcxxTotal").text(oSettings._iRecordsTotal);
  			 if(oSettings._iRecordsTotal==0 && initFlag){
  				initAddflex("qyjyqcxx_li","table_qyjyqcxx"); 
  			 }
  		    }
    	});
    	table_qyjyqcxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_qyjyqcxx_wrapper .bottom').hide();}else{$('#table_qyjyqcxx_wrapper .bottom').show();}
        })
    }
    
    //失信联合惩戒信息
    function initDataTable_sxlhcjxx(){
    	table_sxlhcjxx = dataTable.load({
    		el:"#table_sxlhcjxx",
    		showIndex: true,
    		lengthMenu: [ 5, 10, 20, 50],
    		ajax:{
    			url:"/syn/panoramasearch/doGetNoCreditPunishInfoList",
    			data :function(d){
    				d.params = params;
    			}
    		},
    		columns : [
    		        {data: null, className: 'center'},
    		        {data: 'punField', className: 'center'},
    	    	    {data: 'legBasis', className: 'center'},
    	    	    {data: 'punCause', className: 'center'},
    	    	   	{data: 'punRule', className: 'center'},
    	    	   	{data: 'punReqDept', className: 'center'},
    	    	   	{data: 'exeEnd', className: 'center'},
    	    	   	{data: 'punExeDept', className: 'center'},
    	    	   	{data: 'punMea', className: 'center'},
    	    	   	{data: 'state', className: 'center'}
    	    	],
    	   columnDefs : [
    	    {
				targets: 9,
			      render: function (data, type, row, meta) {
			    	  if(row.state==0)
			    		  return "待审核";
			    	  if(row.state==1)
			    		  return "已审核";
			    	  if(row.state==2)
			    		  return "已反馈";
			    	  if(row.state==3)
			    		  return "审核退回";
			      }
			}
    	    ],
    	    "fnDrawCallback": function (oSettings) {
   			 $("#sxlhcjxxTotal").text(oSettings._iRecordsTotal);
   			 if(oSettings._iRecordsTotal==0 && initFlag){
   				initAddflex("sxlhcjxx_li","table_sxlhcjxx");
   			 }
   		    } 
    	});
    	table_sxlhcjxx.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('#table_sxlhcjxx_wrapper .bottom').hide();}else{$('#table_sxlhcjxx_wrapper .bottom').show();}
        })
    }
    
    
    function bind(){
    	util.bindEvents([
    	{//tab页面加载
            el: '._tab',
            event: 'click',
            handler: function () {
            	tabSwitch($(this).attr('mtab'));
            }
        },
        {//查看年报信息
            el: '.js-yrinfo',
            event: 'click',
            handler: function () {
            	 var year = $(this).closest('tr').attr('data-id');
                 var encryPriPID =window._CONFIG._encryPriPID;
                 var classFlag = '1';
                 window.open('http://zj.gsxt.gov.cn/entinfo/yrinfo?year=' + year + "&encryPriPID=" + encryPriPID + "&classFlag=" + classFlag, 'newwindow');
            }
        },
        {//变更历史信息
            el: '#change_his',
            event: 'click',
            handler: function () {
            	var priPID = $('#priPID').val();
            	layer.dialog({title: '变更历史信息',area: ['86%', '86%'],
            		content: '/midaltitem/doEnEntAltItemHis/'+priPID,
                    callback: function (data) { }
                })
            }
        }
        ,
        {//企业风险标示显示
            el: '#qyfxbs',
            event: 'click',
            handler: function () {
            	var priPID = $('#priPID').val();
            	layer.dialog({title: '企业风险标识',area: ['86%', '86%'],
            		content: _urlHead+'doCsEntWarn/'+priPID,
                    callback: function (data) { }
                })
            }
        },
        {//重点行业标识显示
            el: '#zdhybs',
            event: 'click',
            handler: function () {
            	var priPID = $('#priPID').val();
            	layer.dialog({title: '重点行业标识',area: ['86%', '86%'],
            		content: _urlHead+'doCsSuperviseObj/'+priPID,
                    callback: function (data) { }
                })
            }
        },
        {//关注服务标识显示
            el: '#gzfwbs',
            event: 'click',
            handler: function () {
            	var priPID = $('#priPID').val();
            	layer.dialog({title: '关注服务标识',area: ['86%', '86%'],
            		content: _urlHead+'doCsConcernObj/'+priPID,
                    callback: function (data) { }
                })
            }
        },
        {//企业公示——企业年度报告
            el: '#yrinfo_li',
            event: 'click',
            handler: function () {
            	addflex("yrinfo_li","yrinfo_table");
            }
        },
        {//企业公示——股东及出资信息
            el: '#table_jsgdyczxx_li',
            event: 'click',
            handler: function () {
            	addflex("table_jsgdyczxx_li","table_jsgdyczxx");
            }
        },
        {//企业公示——股权变更信息
            el: '#invsral_li',
            event: 'click',
            handler: function () {
            	addflex("invsral_li","invsral_table");
            }
        },
        {//企业公示——行政许可信息
            el: '#permit_li',
            event: 'click',
            handler: function () {
            	addflex("permit_li","permit_table");
            }
        },
        {//企业公示——知识产权出质登记信息
            el: '#ippldg_li',
            event: 'click',
            handler: function () {
            	addflex("ippldg_li","ippldg_table");
            }
        },
        {//企业公示——行政处罚信息
            el: '#imcase_li',
            event: 'click',
            handler: function () {
            	addflex("imcase_li","imcase_table");
            }
        },
        {//企业公示——简易注销公告信息
            el: '#er_esc_appinfo_li',
            event: 'click',
            handler: function () {
            	addflex("er_esc_appinfo_li","er_esc_appinfo_table");
            }
        },
        {//良好荣誉——良好荣誉信息
            el: '#qyxzcfxx_li',
            event: 'click',
            handler: function () {
            	addflex("qyxzcfxx_li","table_qyxzcfxx");
            }
        },
        {//抽查检查——抽查检查
            el: '#ccjcxx_li',
            event: 'click',
            handler: function () {
            	addflex("ccjcxx_li","table_ccjcxx");
            }
        },
        {//不良失信——列入异常
            el: '#qyjyqcxx_li',
            event: 'click',
            handler: function () {
            	addflex("qyjyqcxx_li","table_qyjyqcxx");
            }
        },
        {//不良失信——严重违法失信
            el: '#yzwfsxxx_li',
            event: 'click',
            handler: function () {
            	addflex("yzwfsxxx_li","table_yzwfsxxx");
            }
        },
        {//不良失信——行政处罚信息
            el: '#jsxzcfxx_li',
            event: 'click',
            handler: function () {
            	addflex("jsxzcfxx_li","table_jsxzcfxx");
            }
        },
        {//不良失信——司法协助
            el: '#qygqdjxx_li',
            event: 'click',
            handler: function () {
            	addflex("qygqdjxx_li","table_qygqdjxx");
            }
        },
        {//不良失信——不动产查封
            el: '#qybdccfxx_li',
            event: 'click',
            handler: function () {
            	addflex("qybdccfxx_li","table_qybdccfxx");
            }
        },
        {//不良失信——失信联合惩戒
            el: '#sxlhcjxx_li',
            event: 'click',
            handler: function () {
            	addflex("sxlhcjxx_li","table_sxlhcjxx");
            }
        },
        {//抵押质押担保——动产抵押信息
            el: '#qydcdyxx_li',
            event: 'click',
            handler: function () {
            	addflex("qydcdyxx_li","table_qydcdyxx");
            }
        },
        {//抵押质押担保——不动产抵押信息 
            el: '#qybdcdyxx_li',
            event: 'click',
            handler: function () {
            	addflex("qybdcdyxx_li","table_qybdcdyxx");
            }
        },
        {//抵押质押担保——股权出资登记信息
            el: '#qygqczxx_li',
            event: 'click',
            handler: function () {
            	addflex("qygqczxx_li","table_qygqczxx");
            }
        },
        {//抵押质押担保——对外担保信息
            el: '#forguaranteeinfo_li',
            event: 'click',
            handler: function () {
            	addflex("forguaranteeinfo_li","table_forguaranteeinfo");
            }
        },{//企业公示——行政许可信息
            el: '#permit_li_mainmarkHis_table',
            event: 'click',
            handler: function () {
            	addflex("permit_li_mainmarkHis_table","mainmarkHis_table");
            }
        },{
            el: '#baseinfo',
            event: 'click',
            handler: function () {
            	addflex("baseinfo","table_baseinfo");
            }
        },
        {
            el: '#manageinfo',
            event: 'click',
            handler: function () {
            	addflex("manageinfo","table_ggryxx");
            }
        },
        {
            el: '#branchinfo',
            event: 'click',
            handler: function () {
            	addflex("branchinfo","table_fzjgxx");
            }
        },
        {
            el: '#clearInfo',
            event: 'click',
            handler: function () {
            	addflex("clearInfo","table_qsxx");
            }
        },
        {
            el: '#changeInfo',
            event: 'click',
            handler: function () {
            	addflex("changeInfo","table_bgxx");
            }
        },
        {
            el: '#investinfo',
            event: 'click',
            handler: function () {
            	addflex("investinfo","table_gdjczxx");
            }
        },
        {
            el: '#outinverstinfo',
            event: 'click',
            handler: function () {
            	addflex("outinverstinfo","table_dwtzxx");
            }
        },
        {
            el: '#licenceinfo',
            event: 'click',
            handler: function () {
            	addflex("licenceinfo","_tab-pubotherlicence");
            }
        },
        {
            el: '#tmdetailsinfo',
            event: 'click',
            handler: function () {
            	addflex("tmdetailsinfo","table_qysbxx");
            }
        },
        {
            el: '#entzlinfo',
            event: 'click',
            handler: function () {
            	addflex("entzlinfo","table_qyzlxx");
            }
        },{
    		el: '#cancel',
    		event: 'click',
    		handler: function () {
    			layer.close();
    		}
    	},{
    		el: '#js-item-add',
    		event: 'click',
    		handler: function () {
    			 $('#js-select-show option:selected').each(function (){
    				 var showObj = $(this);
    				 var showVal = showObj.val();
    				 var state = false;
    				 $('#js-select-add option').each(function (){
    					 var addVal =  $(this).val();
    					 if(showVal == addVal){
    						 state = true;
    						 return;
    					 }
    				 });
    				 if(!state){
    					 $('#js-select-add').append(showObj.prop("outerHTML"));
    				 }
    				
					
    				 
    			 });
    		}
    	},{
    		el: '#js-item-del',
    		event: 'click',
    		handler: function () {
    			$('#js-select-add option:selected').remove();
    		}
    	},{
    		el: '#save',
    		event: 'click',
    		handler: function () {
    			var markCodes = "";
    			var markNames = "";
    			var treeObj = $.fn.zTree.getZTreeObj("ycCodeLicenseTree");
				var nodes = treeObj.getCheckedNodes(true);
				if(nodes.length != 0){
					 for(var a=0;a<nodes.length;a++){ 
						markCodes+=nodes[a].id+",";
						markNames+=nodes[a].name.substr(7)+",";
					}  
					if(markCodes!=""&&markNames!=""){
						markCodes=markCodes.substr(0,markCodes.length-1);
						markNames=markNames.substr(0,markNames.length-1);
					}
				 } 
    			$("#markCodes").val(markCodes);
    			$("#markNames").val(markNames);
    			http.httpRequest({
    	             url: '/reg/server/mainmark/saveOrUpdate.json',
    	             data: $('#hx-form').serializeObject(),
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
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	var idname=$.trim($("#idname").val());
            	initView(idname);
            }
        }])
    }
    
  //翻页事件 
    function pageInvsraCallback(page,jq){
    	initDataTable_jsgdyczxx(page+1);  
    }
    
    function tabSwitch(n){
    	var entTypeCatg = $('#entTypeCatg').val();
    	n = parseInt(n);
    	initFlag = true;
    	switch(n){
	    	case 0:
	    		initPubotherlicenceTable();break;
	    	case 1:
	    		initDataTable_jsxzxkxx();break;
	    	case 2:
	    		initDataTable_mainmarkHis();
	    		break;
	    	default:
    	} 
    }
   
    
    

})
