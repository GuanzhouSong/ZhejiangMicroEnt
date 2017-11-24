require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    var table;
    /**	
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
        bind();
    }
    
    
	function initDataTable() {
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		aLengthMenu: [10, 20,30,40,50],
		ajax : {
			type : "post",
			url : '/sment/rptsmBaseinfo/doGetEntarchivesHisList.json',
			data : function(d) {
				d.params =  $("#entSearchForm").serializeObject();
			}
		},
		buttons:[],
		columns : [
	        {data: null, defaultContent: 1, className: 'center'},
		    {data: null, className: 'center'},
		    {data : 'removeTypeCode', className: 'center'},
		    {data : 'removeTime', className: 'center'},
		    {data : 'regNO', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'industryCoName', className: 'center'}, 
		    {data : 'estDate', className: 'center'},
		    {data : 'entTypeName', className: 'center'}, 
		    {data : 'regCap', className: 'center'},
		    {data : 'regOrgName',className: 'center'}, 
		    {data : 'localAdmName', className: 'center'},
		    {data : 'empNum',className: 'center'},
		    {data : 'vendInc', className: 'center'}
		],
		columnDefs : [
			{
                targets: 1,
                render: function (data, type, row, meta) {
                    return '<a href="javascript:void(0);" class="js-claim list-view">查看</a>'  ;
                }
            },
            {
	          	  targets: 2,
			      render: function (data, type, row, meta) {
			    	  if(row.removeTypeCode == '1'){
			    		  return '企业注销';
			    	  }else if(row.removeTypeCode == '2'){
			    		  return '升规';
			    	  }else if(row.removeTypeCode == '3'){
			    		  return '经营异常';
			    	  }else if(row.removeTypeCode == '4'){
			    		  return '严重违法违规';
			    	  }else if(row.removeTypeCode == '5'){
			    		  return '其他';
			    	  } else {
			    		  return '';
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
            	}else{
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
            el: '.list-view',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                sessionStorage.setItem("priPID",data.priPID);
                layer.dialog({
                    title: '查看',
                    area: ['100%', '100%'],
                    content: '/sment/entarchives/toEntarchivesView'
                })
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
        }, {
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
        	el:'#selectareaTypeCode',
        	event:'click',
        	handler:function(){showAreaTypeTree()}
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
        	el:'#selecthelpTypeCode',
        	event:'click',
        	handler:function(){showHelpTypeTree()}
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
                            title: '分类标签标注申请-批量编辑',
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
            				title: '分类标签标注申请-编辑',
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
