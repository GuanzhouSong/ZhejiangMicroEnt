require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab','jquery.multiselect'], function (layer,dataTable, util, http,handlebars) {
	var searchFlag="0";
	var searchParams={};
	var table;
	
	 init();
	 
	 function init(){
		 bind();
	 }
	 
	 $("#invPlaceM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
	 $('#invPlaceM').multipleSelect('checkAll');
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
	                url:'/reg/server/invmanager/invexpirejson',
	                data:function(d){
	                	d.params = searchParams;
	                }
	            },
	            columns: [                
	                {data: '_idx',width:'30px'},
	                {data: 'regNO'},
	                {data: 'entName',className: 'left'},
	                {data: 'estDate'},
	                {data: 'regCap'},
	                {data: 'currencyCn'},
	                {data: 'paidPubTotal'},
	                {data: 'isInvStages'},
	                {data: 'invPlace'},
	                {data: 'lastTermInvDate'},
	                {data: 'endTermInvDate'},
	                {data: 'entTypeName'},
	                {data: 'regOrgName',className: 'left'},
	                {data: 'localAdmName',className: 'left'},
	                {data: 'leRep'},
	                {data: 'tel'},
	                {data: 'liaName'},
	                {data: 'liaTel'},
	                {data: 'dom',className: 'left'},
	                {data: 'setName'},
	                {data: 'setDate'}
	            ],
	            columnDefs: [
	            	{
	  					targets:7,
	 					render:function(data,type,row,meta){
	 						var isInvStages = row.isInvStages;
	 						if(isInvStages=="1"){
	 							return "是";
	 						}else if(isInvStages=="0"){
	 							return "否";
	 						}else{
	 							return "-";
	 						}
	 					}
	 				 },{
	  					targets:8,
	 					render:function(data,type,row,meta){
	 						var invPlace = row.invPlace;
	 						if(invPlace=="1"){
	 							return "零出资";
	 						}else if(invPlace=="2"){
	 							return "部分出资";
	 						}else if(invPlace=="3"){
	 							return "全额出资";
	 						}else{
	 							return "-";
	 						}
	 					}
	 				 },
	            	 {
	  					targets:1,
	 					render:function(data,type,row,meta){
	 						var isSim = row.isSim;
	 						if(isSim=="1"){
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
	 				 }
				],
	            "fnDrawCallback": function (oSettings) {
	            	http.httpRequest({ 
	                    url: '/reg/server/invmanager/invexpirecount',
	                    serializable: false,
	                    type:'post',
	                    data: {params:searchParams} ,
	                    success: function (data) {
	                    	var list = data.data;
	                        if (data.status == 'success') {  
	    						$("#ent").text(list[0]);
	    						$("#zereoinv").text(list[1]);
	    						$("#partinv").text(list[2]);
	    						$("#allinv").text(list[3]);
	    						$("#partinvexpire").text(list[4]);
	    						$("#alreadyexpire").text(list[5]);
	                        }else{
	                        	$("#ent").text("0");
	                        	$("#zereoinv").text("0");
	    						$("#partinv").text("0");
	    						$("#allinv").text("0");
	    						$("#partinvexpire").text("0");
	    						$("#alreadyexpire").text("0");
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
	        		var invPlaceM = $("#invPlaceM").val();
	        		$("#invPlace").val(invPlaceM);
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
                			title:'公司出资监控到期详情',
                			area: ['100%', '100%'],
                			content: '/reg/server/invmanager/invexpiredetail?priPID='+priPID,
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
	            	$("#entType").val("");
	            	$('#invPlaceM').multipleSelect('checkAll');
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
    	el: '#chooseEntType',
        event: 'click',
        handler: function () { 
        	var entTypeCatg=$("#entTypeCatg").val();
            layer.dialog({
                title: '选择企业类型',
                area: ['400px', '600px'],
                content: '/commom/server/entcatg/entcatgmutiselectCom?type='+entTypeCatg,
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



