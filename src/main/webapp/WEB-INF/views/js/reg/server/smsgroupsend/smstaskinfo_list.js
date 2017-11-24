require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams;//查询参数声明!
	var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        //initDataTable();
    }
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/smstaskinfo/smsTaskTnfoList.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: 'taskid'},
                      {data: 'taskName',width:'100px',className: 'left'},
                      {data: 'regNO',width:'80px'},
                      {data: 'entName',width:'100px'},
                      {data: 'estDate',width:'40px'},
                      {data: 'entTypeCatg',width:'40px'},
                      {data: 'smsType',width:'40px'},
                      {data: 'sendObjType',width:'80px'},
                      {data: 'sendObjName',width:'80px'},
                      {data: 'sendObjTel',width:'80px'},
                      {data: "sendTime",width:'80px'},
                      {data: 'regOrgName',width:'100px',className: 'left'},
                      {data: 'localAdmName',width:'100px',className: 'left'}
            ],
            columnDefs: [
 				{
 					targets:3,
 					render:function(data,type,row,meta){
 						if(row.uniSCID&&row.uniSCID!="null"){
 							return row.uniSCID;
 						}else{
 							return row.regNO;
 						}
 					}
 				 },{
 					targets:7,
 					render:function(data,type,row,meta){
 						if(row.smsType=="1"){
 							return "年报提醒（适用企业、农专社）";
 						}else if(row.smsType=="2"){
 							return "年报提醒（适用个体户）";
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:6,
 					render:function(data,type,row,meta){
 						if(row.entTypeCatg=="50"){
 							return "个体户";
 						}else if(row.entTypeCatg=="16"||row.entTypeCatg=="17"){
 							return "农专社";
 						}else{
 							return "企业";
 						}
 					}
 				 }
             ],
            "fnDrawCallback": function (oSettings) {
            	http.httpRequest({ 
                    url: '/reg/server/smstaskinfo/searchCountSuccess',
                    serializable: false,
                    type:'post',
                    data: {params:searchParams} ,
                    success: function (data) {
                    	var list = data.data;
                        if (data.status == 'success') {  
    						$("#sendEntSuccess").text(list[0]);
    						$("#sendTelSuccess").text(list[1]);
    						$("#sendLerepTelSuccess").text(list[2]);
    						$("#sendLiaTelSuccess").text(list[3]);
                        }else{
                        	$("#sendEntSuccess").text("0");
    						$("#sendTelSuccess").text("0");
    						$("#sendLerepTelSuccess").text("0");
    						$("#sendLiaTelSuccess").text("0");
                        } 
                    }
                });
            }
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	var categCode=new Array();
    	$(":checkbox[name=type]:checked").each(function(k,v){
			categCode[k]= this.value;
		});
		$("#entTypeCatg").val(categCode);
    	searchParams = $("#taskForm").serializeObject();
    	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    });
    
    function bind() {
        util.bindEvents([
	        {
	            el: '#more',
	            event: 'click',
	            handler: function () { 
	            	var isHideOrShow = $("#hideorshow").is(":hidden");
	            	if(isHideOrShow){
	            		 $("#more").val("收起");
	            		 $("#hideorshow").css("display","block");
						//$("#hideorshow").toggle();
	
					}else{
						$("#more").val("更多查询条件");
	            		$("#hideorshow").css("display","none");
					}
	            }
	        },
            {
	        	el: '#choseregUnit',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择管辖单位',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regunit/regunitmutiselect',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                      	$("#localAdm").val(returncode);
	                      	$("#localAdmName").val(data.returnname); 
	                    }
	                })
	            }
	        },{
	            el: '#cancel',
	            event: 'click',
	            handler: function () { 
	            	$("#regOrg").val("");
	            	$("#localAdm").val("");
	            	$("#dept").val("");
	            }
	        }, {
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
	        },
            {
	        	el: '#chosedept',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择部门',
	                    area: ['400px', '600px'],
	                    content: '/reg/system/dept/tree/select?treeType=checkbox',
	                    callback: function (data) { 
	                    	var deptId=data.deptId;
	                    	var deptName=data.deptName;
	                      	$("#dept").val(deptId);
	                      	$("#deptName").val(deptName); 
	                    }
	                })
	            }
	        }
        ])
    }
})
