require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	 init();
	    /**
	     * 初始化函数集合
	     */
	    function init() {
	        initDataTable();
	        bind();
	    }

	    var table;
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	        table = dataTable.load({
	            el: '#foodstoragebase-table',
	            showIndex: true,
	            scrollX:true, //支持滚动
	            ajax: {
	                url:'/reg/server/yr/foodstoragebase/list.json',
	                data:function(d){
	                	d.params = $("#taskForm").serializeObject();
	                }
	            },
	            columns: [
					{data: '_idx',width : '5%',className: 'center'},
					{data: null},
					{data: null,width : '20px',className: 'center'},
					{data: 'entName',width : '20px'},
					{data: 'leRep',width : '20px'},
					{data: 'tel',width : '20px'},
					{data: 'estDate',width : '20px'},
					{data: 'entTypeDesc',width : '20px'},
					{data: 'industryCoDesc',width : '20px'},
//					{data: 'opScope',width : '20px'},
					{data: 'fsScope',width : '20px'},
					{data: 'setTime',width : '20px'},
					{data: 'regOrgDesc',width : '20px'},
					{data: 'checkDepDesc',width : '20px'},
					{data: 'localAdmDesc',width : '20px'},
					{data: 'sliceNoDesc',width : '20px'}
	            ],
	            columnDefs: [{
	    	         targets:2,
	     	         render:function(data,type,row,meta){
	     	        	if(data.uniSCID != null && data.uniSCID != ""){
	    					return data.uniSCID;
	    				}else{
	    					return data.regNO;
	    				}
	     	       }
		          },{
	    	         targets:9,
	     	         render:function(data,type,row,meta){
	     	        	var fsScope = row.fsScope;
	     	        	if(fsScope != null){
	     	        		fsScope = fsScope.replace("1","食品生产");
	     	        		fsScope = fsScope.replace("2","食品经营");
	     	        		fsScope = fsScope.replace("3","食品仓储服务");
	     	        		fsScope = fsScope.replace("4","都不涉及");
	     	        		fsScope = fsScope.replace("5","食用农产品");
	     	        		return fsScope;
	     	        	}else{
	     	        		return "";
	     	        	}
	     	       }
	          },{
                  targets: 1,
                  render: function (data, type, row, meta) {
                  	return "<a class='commit'>查看</a>";
                  }
              }]
	        });
	    }
	    
	  //按钮事件
	    function bind() {
	        util.bindEvents([{
	        	el: '.commit',
	            event: 'click',
	            handler: function () {
	            	 var data = table.row($(this).closest('td')).data();
	                layer.dialog({
	                    title: '食品仓储信息',
	                    area: ['80%', '40%'],
	                    content: '/reg/server/yr/foodstoragebase/show?foodstorageBaseId='+encodeURIComponent(data.id),
	                    scrollbar: true,
	                    callback: function (data) {
	                    	if(data.reload == true){
	                    		table.ajax.reload();
	                    	}
	                    }
	                });
	            }
	        },{
	        	el: '#addIndustry',
	            event: 'click',
	            handler: function () {
	            	alert("正在建设中");
	            }
	        },{
	        	el: '#search',
	            event: 'click',
	            handler: function () {
	            	table.ajax.reload();
	            }
	        },{
	        	el: '#fsscope_1',
	            event: 'click',
	            handler: function () {
	            	if($("#fsscope_4").prop("checked")){
	            		$("#fsscope_4").attr("checked",false);
	            		$("#fsScopeValue").val("");
	            	}
	            	var fsScopeValue = "";
	            	$("input[name='fsscopename']").each(function(){
	            		if($(this).prop("checked")){
	            			var value = $(this).val();
	            			if(fsScopeValue == ""){
	            				fsScopeValue = value;
	            			}else{
	            				fsScopeValue += ","+value; 
	            			}
	            		}
	            	});
	            	$("#fsScopeValue").val(fsScopeValue);
	            }
	        },{
	        	el: '#fsscope_2',
	            event: 'click',
	            handler: function () {
	            	if($("#fsscope_4").prop("checked")){
	            		$("#fsscope_4").attr("checked",false);
	            		$("#fsScopeValue").val("");
	            	}
	            	var fsScopeValue = "";
	            	$("input[name='fsscopename']").each(function(){
	            		if($(this).prop("checked")){
	            			var value = $(this).val();
	            			if(fsScopeValue == ""){
	            				fsScopeValue = value;
	            			}else{
	            				fsScopeValue += ","+value; 
	            			}
	            		}
	            	});
	            	$("#fsScopeValue").val(fsScopeValue);
	            }
	        },{
	        	el: '#fsscope_3',
	            event: 'click',
	            handler: function () {
	            	if($("#fsscope_4").prop("checked")){
	            		$("#fsscope_4").attr("checked",false);
	            		$("#fsScopeValue").val("");
	            	}
	            	var fsScopeValue = "";
	            	$("input[name='fsscopename']").each(function(){
	            		if($(this).prop("checked")){
	            			var value = $(this).val();
	            			if(fsScopeValue == ""){
	            				fsScopeValue = value;
	            			}else{
	            				fsScopeValue += ","+value; 
	            			}
	            		}
	            	});
	            	$("#fsScopeValue").val(fsScopeValue);
	            }
	        },{
	        	el: '#fsscope_4',
	            event: 'click',
	            handler: function () {
	            	if($(this).prop("checked")){
	            		var fsScopeValue = "";
	            		$("input[name='fsscopename']").each(function(){
	            			var value = $(this).val();
	            			if(value != "4"){
	            				$(this).attr("checked",false);
	            			}
	            		});
	            		$("#fsScopeValue").val("4");
	            	}else{
	            		$("#fsScopeValue").val("");
	            	}
	            }
	        },{
	        	el: '#fsscope_5',
	            event: 'click',
	            handler: function () {
	            	if($("#fsscope_4").prop("checked")){
	            		$("#fsscope_4").attr("checked",false);
	            		$("#fsScopeValue").val("");
	            	}
	            	var fsScopeValue = "";
	            	$("input[name='fsscopename']").each(function(){
	            		if($(this).prop("checked")){
	            			var value = $(this).val();
	            			if(fsScopeValue == ""){
	            				fsScopeValue = value;
	            			}else{
	            				fsScopeValue += ","+value; 
	            			}
	            		}
	            	});
	            	$("#fsScopeValue").val(fsScopeValue);
	            }
	        },{
	            el: '#choseregUnit',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择管辖单位',
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
	            el: '#choseorgReg',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择登记机关',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regorg/regorgmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#regOrg").val(returncode);
	                    	$("#regOrgName").val(data.returnname);  
	                    }
	                })
	            }
	        },{
	            el: '#chosesliceNo',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择责任区',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/sliceno/slicenomutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#sliceNO").val(returncode);
	                    	$("#sliceNOName").val(data.returnname);  
	                    }
	                })
	            }
	        },{
	            el: '#choseEntType',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择企业类型',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/entcatg/entcatgmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#entTypeCode").val(returncode);
	                    	$("#entTypeName").val(data.returnname);  
	                    }
	                })
	            }
	        },{
	            el: '#chooseindustry',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择行业类型',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/industry/toIndustryPhyTree',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#industryCo").val(returncode);
	                    	$("#industryName").val(data.returnname);  
	                    }
	                })
	            }
	        },{
	            el: '#chosecheckDep',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择抽查机关',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regorg/regorgmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#checkDep").val(returncode);
	                    	$("#checkDepName").val(data.returnname);  
	                    }
	                })
	            }
	        },{
	            el: '#cancel',
	            event: 'click',
	            handler: function () { 
	            	$("#regOrg").val("");
	            	$("#localAdm").val("");
	            	$("#sliceNO").val("");
	            	$("#entTypeCode").val("");
	            	$("#industryCo").val("");
	            	$("#checkDep").val("");
	            	$("#fsScopeValue").val("");
	            }
	        }]);
	    }
});
