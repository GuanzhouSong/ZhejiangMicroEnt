require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    var table;
    
    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
    
    
    /**	
     * 初始化函数集合
     */
    function init() {
    	initData();
        bind();
        initDataTable();
    }
    
    function initData(){
    	initYearList();
    }
    
    function initYearList(){
    	var mydate = new Date();
        var year = mydate.getFullYear();
        for (var i = year-1; i > year-5; i--) {
			$("#year").append('<option value="'+i+'">'+i+'</option>');
		}
    }
    
	function initDataTable() {
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		aLengthMenu: [10, 20,30,40,50],
		ajax : {
			type : "post",
			url : '/sment/rptsmBaseinfo/queryEntAndEntarchivesPageList.json',
			data : function(d) {
				d.params =  $("#entSearchForm").serializeObject();
			}
		},
		buttons:[],
		columns : [
		    {data: '_idx', className: 'center'},
		    {data: null, className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'industryCoName', className: 'center'}, 
		    {data : 'estDate', className: 'center'},
		    {data : 'entTypeName', className: 'center'}, 
		    {data : 'regCap', className: 'center'},
		    {data : 'regOrgName',className: 'center'}, 
		    {data : 'localAdmName', className: 'center'},
		    {data : 'empNum',className: 'center'},
		    {data : 'vendInc', className: 'center'},
		    {data : 'helpState',className: 'center'},
		    {data : 'cultivationTypeName',className: 'center'},
		    {data : 'helpTypeNum',className: 'center'}
		],
		columnDefs : [
			{
                targets: 1,
                render: function (data, type, row, meta) {
                	    var onlyView = getUrlParam("onlyView");
                	    if(onlyView){
                	    	return '<a href="javascript:void(0);" class="list-view">查看</a>';
                	    }else{
                	    	return '<a href="javascript:void(0);" class="list-edit">修改</a><a href="javascript:void(0);" class="list-remove">移除</a><a href="javascript:void(0);" class="list-view">查看</a>'  ;
                	    }
                }
            },
            {
	          	  targets: 2,
			      render: function (data, type, row, meta) {
			    	  if(data.uniCode && $.trim(data.uniCode) != "null"){
			    		  return data.uniCode;
			    	  }else if(data.regNO && $.trim(data.regNO) != "null"){
			    		  return data.regNO;
			    	  }
			      }
	          },{
	        	  targets: 12,
			      render: function (data, type, row, meta) {
			    	  if("1" == row.helpState){
			    		  return "无需求";
			    	  }else if("2" == row.helpState){
			    		  return "未帮扶";
			    	  }else if("3" == row.helpState){
			    		  return "部分帮扶";
			    	  }else if("4" == row.helpState){
			    		  return "已帮扶";
			    	  }
			      }
	          }]

	  })
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '#search',
            event: 'click',
            handler: function () {
            	var regCapStart = $("#regCapStart").val();
        		var regCapEnd = $("#regCapEnd").val();
        		var vendIncStart = $("#vendIncStart").val();
        		var vendIncEnd = $("#vendIncEnd").val();
        		var empNumStart = $("#empNumStart").val();
        		var empNumEnd = $("#empNumEnd").val();
        		var year = $("#year").val();
        		var ex = /^[0-9]+$/;
        		
        		if(isNaN(regCapStart)||isNaN(regCapEnd)){
               		 layer.msg("注册资本格式不正确", {time: 1000},function(){
                  		});
               	}else if(isNaN(vendIncStart)||isNaN(vendIncEnd)){
               		layer.msg("营业收入格式不正确", {time: 1000},function(){
                  		});
               	}else if((empNumStart && $.trim(empNumStart) && !ex.test(empNumStart))||(empNumEnd && $.trim(empNumEnd) && !ex.test(empNumEnd))){
               		layer.msg("从业人数格式不正确", {time: 1000},function(){
                  		});
            	}else if("" == year && ((vendIncStart && $.trim(vendIncStart)) || (vendIncEnd && $.trim(vendIncEnd)))){
            		layer.msg("填写了营业收入后需要选择年报年份", {time: 1000},function(){
               		});
            	}else if("" == year && ((empNumStart && $.trim(empNumStart)) || (empNumEnd && $.trim(empNumEnd)))){
            		layer.msg("填写了从业人数后需要选择年报年份", {time: 1000},function(){
               		});
            	}
               	else{
            		if(table){
	           	    	 table.ajax.reload();
	           	     }else{
	           	    	 initDataTable()
	           	     }
            	}
            }
        },{
        	el:'#cancle',
        	event:'click',
        	handler:function(){
        		$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNo").val("");
            	$("#entType").val("");
            	$("#industryCo").val("");
            	
            	$("#areaTypeCode").val("");
            	$("#helpTypeCode").val("");
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
        	el:'#selectIndustry',
        	event:'click',
        	handler:function(){showIndustryTree()}//行业树
        },{
        	el:'#selecthelpTypeCode',
        	event:'click',
        	handler:function(){showHelpTypeTree()}
        },{
        	el:'#selectareaTypeCode',
        	event:'click',
        	handler:function(){showAreaTypeTree()}
        },{
        	el: '#chooseEntType',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=entCatg]:checked").each(function(k,v){
              	   categCode[k]= this.value;
                });
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselectCom?type='+categCode,
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#entType").val(returncode);
                    	$("#entTypeName").val(data.returnname);  
                    }
                })
            }
        },{
        	el:'#selectLocalAdm',
        	event:'click',
        	handler:function(){showLocalAdmTree()}//管辖单位
        }, {
        	el: '#chooseSliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择片区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNo").val(returncode);
                    	$("#sliceNoName").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#chooseYearMode',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=chooseEntCatg]:checked").each(function(k,v){
              	   categCode[k]= this.value;
                });
                
                layer.dialog({
                    title: '选择年度年报状态',
                    area: ['400px', '600px'],
                    content: '/syn/panoramasearch/yearStatusTree',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#yearMode").val(returncode);
                    	$("#yearModeName").val(data.returnname);  
                    }
                })
            }
        },{
        	el:'#selectRegOrg',
        	event:'click',
        	handler:function(){showRegOrgTree()}//登记机关
        },{
            el: '#checkAll',
            event: 'click',
            handler: function () {
                var flag = $(this).prop("checked");
                $("input:checkbox[name='_checkbox']").prop("checked", flag);
            }
        },{
        	el:'#btn_add',
        	event:'click',
        	handler:function(){
        		var priPIDs = "";
        		var count = 0;
        		$("input:checkbox[name='_checkbox']:checked").each(function (index){
        			priPIDs += (index >0?",":"")+$(this).val();
        			count++;
        		});
        		if(priPIDs){
        			sessionStorage.setItem("priPIDs",priPIDs);
        			if(count >1){
        				layer.dialog({
                            title: '培育库-批量新增',
                            area: ['100%', '100%'],
                            content: '/sment/entarchives/toEntarchivesBatchAdd',
                            callback: function (data) {
           	                   	 if (data.reload) { //close是否有传递此参数
           	                         table.ajax.reload();
           	                     }
               				}
                        });
        			}else{
        				sessionStorage.setItem("priPID",priPIDs);
        				layer.dialog({
            				title: '培育库-新增',
            				area: ['100%', '100%'],
            				content: '/sment/entarchives/toEntarchivesEdit',
            				callback: function (data) {
        	                   	 if (data.reload) { //close是否有传递此参数
        	                         table.ajax.reload();
        	                     }
            				}
            			})
        			}
        			
        		}else{
        			layer.msg("至少选择一家企业！",
        		            function() {
        		                layer.close();
        		            });
        		}
        	}
        },{
        	el:'#btn_back',
        	event:'click',
        	handler:function(){
        		window.location = '/reg/server/mainmark/toMainmarkapplyList';
        	}
        },{
            el: '.list-remove',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                sessionStorage.setItem("priPID",data.priPID);
                layer.dialog({
                    title: '培育库-移除',
                    area: ['100%', '100%'],
                    content: '/sment/entarchives/toEntarchivesRemove',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.list-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                sessionStorage.setItem("priPID",data.priPID);
                layer.dialog({
                    title: '培育库-修改',
                    area: ['100%', '100%'],
                    content: '/sment/entarchives/toEntarchivesEdit?isEdit=true',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.list-view',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                sessionStorage.setItem("priPID",data.priPID);
                layer.dialog({
                    title: '培育库-查看',
                    area: ['100%', '100%'],
                    content: '/sment/entarchives/toEntarchivesView'
                })
            }
        },{
            el: '.list-follow',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                sessionStorage.setItem("priPID",data.priPID);
                layer.dialog({
                    title: '培育库-帮扶',
                    area: ['100%', '100%'],
                    content: '/sment/entarchives/toEntarchivesFollow',
                    callback: function (data) {
  	                   	 if (data.reload) { //close是否有传递此参数
  	                         table.ajax.reload();
  	                     }
      				}
                })
            }
        }
        ]);
    }
    
    function showIndustryTree(){
    	layer.dialog({
            title: '选择行业',
            area: ['400px', '600px'],
            content: '/commom/server/industryall/toIndustryAllTree',
            callback: function (data) {
            	$("#industryCo").val('');
            	$("#industryName").val('');
            	$("#industryCo").val(data.returncodes);
            	$("#industryName").val(data.returnname);
            }
        })
    }
    
    function showHelpTypeTree(){
    	layer.dialog({
            title: '选择企业需求类别',
            area: ['400px', '600px'],
            content: '/sment/entarchives/toEntarchivesHelpTypeTree',
            callback: function (data) {
            	debugger;
            	$("#helpTypeCode").val('');
            	$("#helpTypeName").val('');
            	$("#helpTypeCode").val(data.returncodes);
            	$("#helpTypeName").val(data.returnname);
            }
        })
    }
    
    function showAreaTypeTree(){
    	layer.dialog({
            title: '选择区域类型',
            area: ['400px', '600px'],
            content: '/sment/entarchives/toEntarchivesAreaTree',
            callback: function (data) {
            	debugger;
            	$("#areaTypeCode").val('');
            	$("#areaTypeName").val('');
            	$("#areaTypeCode").val(data.returncodes);
            	$("#areaTypeName").val(data.returnname);
            }
        })
    }
    
    
    function showLocalAdmTree(){
    	layer.dialog({
            title: '选择管辖单位',
            area: ['400px', '600px'],
            content: '/commom/server/regunit/regunitmutiselectnocheck',
            callback: function (data) {
            	$("#localAdm").val('');
            	$("#localAdmName").val('');
            	$("#localAdm").val(data.returncodes);
            	$("#localAdmName").val(data.returnname);
            }
        })
    }
    
    function showRegOrgTree(){
    	layer.dialog({
            title: '选择登记机关',
            area: ['400px', '600px'],
            content: '/commom/server/regorg/regorgmutiselectnocheck',
            callback: function (data) {
            	$("#regOrg").val('');
            	$("#regOrgName").val('');
            	$("#regOrg").val(data.returncodes);
            	$("#regOrgName").val(data.returnname);
            }
        })
    }
    
    
})
