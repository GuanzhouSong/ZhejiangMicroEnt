require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab','jquery.multiselect'], function (layer,dataTable, util, http,handlebars) {
	var searchFlag="0";
	var searchParams={};
	var table;
	
	 init();
	 
	 function init(){
		 bind();
	 }
	 
	 $("#licTypeM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	    	searchFlag="1";
	        table = dataTable.load({
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax: {
	            	type : "POST",
	                url:'/reg/server/other/pubohterlicence/licenceinvalidjson',
	                data:function(d){
	                	d.params = searchParams;
	                }
	            },
	            columns: [                
	                {data: '_idx',width:'30px'},
	                {data: 'regNO',width:'60px'},
	                {data: 'entName',className: 'left',width:'100px'},
	                {data: 'entTypeCatg',width:'30px'},
	                {data: 'licNameCN',width:'80px'},
	                {data: 'licNO',width:'80px'},
	                {data: 'licValFrom',width:'50px'},
	                {data: 'licValTo',width:'50px'},
	                {data: 'licAnth',width:'50px'},
	                {data: 'licType',width:'30px'},
	                {data: null,width:'50px'},
	                {data: 'regOrgName',className: 'left',width:'100px'},
	                {data: 'localAdmName',className: 'left',width:'100px'},
	                {data: 'leRep',width:'50px'},
	                {data: 'tel',width:'50px'},
	                {data: 'liaName',width:'50px'},
	                {data: 'liaTel',width:'50px'},
	                {data: 'dom',className: 'left',width:'100px'},
	                {data: 'setName',width:'50px'},
	                {data: 'setDate',width:'50px'}
	            ],
	            columnDefs: [
	            	 {
	 					targets:10,
	 					render:function(data,type,row,meta){
	 						return '专项检查主体库';
	 					}
	 				 },{
		 					targets:9,
		 					render:function(data,type,row,meta){
		 						return '不限';
		 					}
		 				 },{
	  					targets:1,
	 					render:function(data,type,row,meta){
	 						var isSimpleCancle = row.isSimpleCancle;
	 						if(isSimpleCancle=="1"){
	 							if(row.unicode){
		 							return "<span class='yellow-bg'>"+row.unicode+"</span>";
		 						}else{
		 							return "<span class='yellow-bg'>"+row.regNO+"</span>";
		 						}
	 						}else{
	 							if(row.unicode){
		 							return row.unicode;
		 						}else{
		 							return row.regNO;
		 						}
	 						}
	 					}
	 				 },{
	 					targets:3,
	 					render:function(data,type,row,meta){
	 						if(row.entTypeCatg=='50'){
	 							return "个体户";
	 						}else if(row.entTypeCatg=='16'||row.entTypeCatg=='17'){
	 							return "农专社";
	 						}else{
	 							return '企业';
	 						}
	 					}
	 				 }
				],
	            "fnDrawCallback": function (oSettings) {
	            	http.httpRequest({ 
	                    url: '/reg/server/other/pubohterlicence/licenceinvalidcount',
	                    serializable: false,
	                    type:'post',
	                    data: {params:searchParams} ,
	                    success: function (data) {
	                    	var list = data.data;
	                        if (data.status == 'success') {  
	    						$("#ent").text(list[0]);
	    						$("#licence").text(list[1]);
	                        }else{
	                        	$("#ent").text("0");
	    						$("#licence").text("0");
	                        } 
	                    }
	                });
	            }
	        })
	    }
	 
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#qua-search',
	            event: 'click',
	            handler: function() {
	            	var categCode=new Array();
	        		$(":checkbox[name=entType]:checked").each(function(k,v){
	        			categCode[k]= this.value;
	        		});
	        		$("#entTypeCatg").val(categCode);
	        		var licTypeM = $("#licTypeM").val();
	        		$("#licType").val(licTypeM);
	        		searchParams = $("#searchForm").serializeObject();
	            	if(searchFlag=="0"){
	            		initDataTable();
	            	}else{
	            		table.ajax.reload();
	            	}
	            }
	        },{
	                el: '#qua-table tr',  
	                event: 'click',
	                handler: function () {
	                	var data = table.row($(this)).data();
	                	var priPID = data.priPID;
	                	if(priPID){
	                		layer.dialog({
	                			title:'许可证失效到期详情',
	                			area: ['100%', '100%'],
	                			content: '/reg/server/other/pubohterlicence/licenceinvaliddetail?priPID='+priPID,
	                			callback: function (data) {}
	                		})
	                	}
	                }
            },{
	            el: '#cancel',
	            event: 'click',
	            handler: function () { 
	            	$("#regOrg").val("");
	            	$("#localAdm").val("");
	            	$('#licTypeM').multipleSelect('checkAll');
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
	                    	
	                    	var returncode=data.returncode;
	                    	var returnname=data.returnname;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1);
	                     	} 	 
	                      	$("#localAdm").val(returncode);
	                      	$("#localAdmName").val(returnname); 
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
	                    	var returnname=data.returnname;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#regOrg").val(returncode);
	                    	$("#regOrgName").val(returnname);
	                    }
	                })
	            }
	}, {
        el: '#reset',
        event: 'click',
        handler: function() {
        	$(".clear").val("");
        	$("#opTip option:first").prop('selected','selected');
        }
    },{
        el: '#more',
        event: 'click',
        handler: function () { 
        	var isHideOrShow = $("#hideorshow").is(":hidden");
        	if(isHideOrShow){
        		 $("#more").val("收起");
        		 $("#hideorshow").css("display","block");
			}else{
				$("#more").val("更多查询条件");
        		$("#hideorshow").css("display","none");
			}
        }
    }
			])
	    }

})



