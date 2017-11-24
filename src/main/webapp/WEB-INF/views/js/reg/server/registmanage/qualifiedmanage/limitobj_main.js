require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchFlag_1="0";
	var searchFlag_2="0";
	var searchFlag_3="0";
	var searchParams;//查询参数声明!
	var radioValue = $('input[name=limit]:checked').val();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	if(radioValue='1'){
    		searchParams = $("#taskForm-1").serializeObject();
    	}else if(radioValue='2'){
    		searchParams = $("#taskForm-2").serializeObject();
    	}else{
    		searchParams = $("#taskForm-3").serializeObject();
    	}
    	bind();
    }
    var table_1;
    var table_2;
    var table_3;
    
    $("#limitTypeM-1").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    $("#limitTypeM-2").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    $("#freeStateM-1").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    $("#freeStateM-2").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    $("#freeStateM-3").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });

    function initDataTable_1() {
    	searchFlag_1="1";
        table_1 = dataTable.load({
            el: '#user-table-1',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/registmanage/limitObjList',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            	{data: '_idx'},
            	{data : null},
    		    {data : 'clientName'},
    		    {data : 'certTypeName'},
    		    {data : 'certNO'},
    		    {data : 'limitTypeName'},
    		    {data : 'entName', className: 'left'},
    		    {data : 'regNO'},
    		    {data : null},
    		    {data : 'mgrRecCount'},
    		    {data : 'limitDateStart'},
    		    {data : 'limitDateEnd'},
    		    {data : null},
    		    {data: 'regOrgName',width:'180px',className: 'left'},
                {data: 'localAdmName',width:'180px',className: 'left'}
            ],
            columnDefs: [
            	{
	   		     	targets: 1,
				    render: function (data, type, row, meta) {
				    	return '<input type="radio" auditState='+row.auditState+' limitTypeName='+row.limitTypeName+' can='+row.limitDateEnd+' class="rad" name="_radio"  value='+row.uid+'>';
				    }
   		        },
            	{
	   		       	targets:2,
	   		    	render:function (data, type, row, meta) {
	   		    		return "<a href='javascript:void(0)' class='mr10 look_1' uid='"+row.uid+"'>"+ row.clientName+"</a>";
	   		    	}
   		        },
            	{
    				targets:7,
    				render:function(data,type,row,meta){
    					if(row.unicode){
    						return row.unicode;
    					}else if(row.regNO){
    						return row.regNO;
    					}else{
    						return '';
    					}
    				}
    			 },{
    				targets:8,
    				render:function(data,type,row,meta){
    					return row.relCount1+row.relCount2+row.relCount3;
    				}
    			 },{
					targets:12,
					render:function(data,type,row,meta){
						if(row.auditState=='1'){
							return "已解除";
						}
						if(row.limitDateEnd){
							 var sysdate=$("#sysdate").val();  
							 var limitDateEnd=row.limitDateEnd;  
							 if(sysdate!=""&&limitDateEnd!=""){  
								 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
								 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
								 if(d1 > d2&&limitDateEnd!=""){
									 return "已解除";
								 }else{
									 return "未解除"
								 }
							 }
						}
						return '未解除';
					}
    			 }
             ],
             "fnDrawCallback": function (oSettings) {
            	http.httpRequest({ 
                    url: '/reg/server/registmanage/limitObjCount',
                    serializable: false,
                    type:'post',
                    data: {params:searchParams} ,
                    success: function (data) {
                    	var list = data.data;
                        if (data.status == 'success') {  
    						$("#limitObj").text(list[0]);
    						$("#relEnt").text(list[1]);
                        }else{
                        	$("#limitObj").text("0");
    						$("#relEnt").text("0");
                        } 
                    }
            	})
             }
        })
    }
    function initDataTable_2() {
    	searchFlag_2="1";
        table_2 = dataTable.load({
            el: '#user-table-2',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/registmanage/limitRelEntList',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            	{data: '_idx'},
            	{data : 'regNO'},
            	{data : 'entName', className: 'left'},
            	{data : 'mgrRecCount'},
    		    {data : 'clientName'},
    		    {data : 'certNO'},
    		    {data : 'limitDateStart'},
    		    {data : 'limitDateEnd'},
    		    {data : null},
    		    {data : 'dom', className: 'left'},
    		    {data: 'regOrgName',width:'180px',className: 'left'},
                {data: 'localAdmName',width:'180px',className: 'left'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
						if(row.uniCode){
 							return row.uniCode;
 						}else{
 							return row.regNO;
 						}
 					}
 				 },
            	{
	   		       	targets:4,
	   		    	render:function (data, type, row, meta) {
	   		    		return "<a href='javascript:void(0)' class='mr10 look_2' uid='"+row.uid+"' priPID='"+row.priPID+"'>"+ row.clientName+"</a>";
	   		    	}
   		        },{
    				targets:1,
    				render:function(data,type,row,meta){
    					if(row.uniscid){
    						return row.uniscid;
    					}else if(row.regNO){
    						return row.regNO;
    					}else{
    						return '';
    					}
    				}
    			 },{
    					targets:8,
    					render:function(data,type,row,meta){
    						if(row.limitDateEnd){
   							 var sysdate=$("#sysdate").val();  
   							 var limitDateEnd=row.limitDateEnd;  
   							 if(sysdate!=""&&limitDateEnd!=""){  
   								 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
   								 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
   								 if(d1 > d2&&limitDateEnd!=""){
   									 return "已解除";
   								 }else{
   									 return "未解除"
   								 }
   							 }
   						}
   						return '未解除';
    					}
    			 }
             ],"fnDrawCallback": function (oSettings) {
            	http.httpRequest({ 
                    url: '/reg/server/registmanage/limitObjCountByEnt',
                    serializable: false,
                    type:'post',
                    data: {params:searchParams} ,
                    success: function (data) {
                    	var list = data.data;
                        if (data.status == 'success') {  
    						$("#limitObj2").text(list[0]);
    						$("#relEnt2").text(list[1]);
                        }else{
                        	$("#limitObj2").text("0");
    						$("#relEnt2").text("0");
                        } 
                    }
            	})
             }
        })
    }
    function initDataTable_3() {
    	searchFlag_3="1";
        table_3 = dataTable.load({
            el: '#user-table-3',
            "bPaginate" : false,
 			scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
            	type : "POST",
                url:'/reg/server/registmanage/limiterRelEntList',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            	{data: '_idx'},
    		    {data : 'clientName'},
    		    {data : 'certType'},
    		    {data : 'certNO'},
    		    {data : 'limitDateStart'},
    		    {data : 'limitDateEnd'},
    		    {data : null}
            ],
            columnDefs: [
            	{
	   		       	targets:1,
	   		    	render:function (data, type, row, meta) {
	   		    		return "<a href='javascript:void(0)' class='mr10 look_1' uid='"+row.uid+"'>"+ row.clientName+"</a>";
	   		    	}
   		        },{
	   		       	targets:2,
	   		    	render:function (data, type, row, meta) {
	   		    		if(row.certType=='0')
	   		    			return "营业执照";
		   		     	if(row.certType=='10')
		   		     		return "居民身份证";
		   		     	if(row.certType=='20')
		   		     		return "军官证";
		   		     	if(row.certType=='30')
		   		     		return "警官证";
		   		     	if(row.certType=='40')
		   		     		return "外国(地区)护照";
		   		     	if(row.certType=='52')
		   		     		return "香港身份证";
		   		     	if(row.certType=='54')
		   		     		return "澳门身份证";
		   		     	if(row.certType=='56')
		   		     		return "台湾身份证";
		   		     	if(row.certType=='90')
		   		     		return "其他有效身份证件";
		   		    	}
   		        },{
					targets:6,
					render:function(data,type,row,meta){
						if(row.limitDateEnd){
						 var sysdate=$("#sysdate").val();  
						 var limitDateEnd=row.limitDateEnd;  
						 if(sysdate!=""&&limitDateEnd!=""){  
							 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
							 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
							 if(d1 > d2&&limitDateEnd!=""){
								 return "已解除";
							 }else{
								 return "未解除"
							 }
						 }
					}
					return '未解除';
					}
    			 }
             ]
        })
    }

    $("#js-search-1").click(function(){
    	var limitTypeM = $("#limitTypeM-1").val();
		$("#limitType-1").val(limitTypeM);
		var freeStateM = $("#freeStateM-1").val();
		$("#freeState-1").val(freeStateM);
    	searchParams = $("#taskForm-1").serializeObject();
    	if(searchFlag_1=="0"){
    		initDataTable_1();
    	}else{
    		table_1.ajax.reload();
    	}
    });
    $("#js-search-2").click(function(){
    	var limitTypeM = $("#limitTypeM-2").val();
		$("#limitType-2").val(limitTypeM);
		var freeStateM = $("#freeStateM-2").val();
		$("#freeState-2").val(freeStateM);
    	searchParams = $("#taskForm-2").serializeObject();
    	if(searchFlag_2=="0"){
    		initDataTable_2();
    	}else{
    		table_2.ajax.reload();
    	}
    });
    $("#js-search-3").click(function(){
		var freeStateM = $("#freeStateM-3").val();
		$("#freeState-3").val(freeStateM);
    	searchParams = $("#taskForm-3").serializeObject();
    	var entName = $.trim($("#entName").val());
    	var regNO = $.trim($("#regNO").val());
    	if(entName!=""||regNO!=""){
    		if(searchFlag_3=="0"){
    			initDataTable_3();
    		}else{
    			table_3.ajax.reload();
    		}
    	}else{
    		layer.msg("关联企业统一代码/注册号或关联企业名称至少一项不为空", {ltype: 0,time:2000});
    	}
    });
    
    function bind() {
        util.bindEvents([
        	{
                el: '#js-liq',
                event: 'click',
                handler: function () {
                	var limitObj;
                	var radio = document.getElementsByName("_radio");  
                    for (i=0; i<radio.length; i++) {  
                        if (radio[i].checked) {  
                            limitObj = document.getElementsByName("_radio")[i];
                        }  
                    }  
                	var limitType;
                	if(limitObj!=undefined){
                		limitType = limitObj.getAttribute('limitTypeName');
                	}
                	var radioObj= $(":radio[name=_radio]:checked");
                	if(radioObj==null||radioObj.length==0){
                		 layer.msg("请选择失信受限企业的限制对象再操作", {ltype: 0,time:2000});
                	}else if(limitType&&limitType!="吊销企业"){
                		layer.msg("请选择原因类别为吊销企业再操作", {ltype: 0,time:2000});
                	}else{
                		layer.dialog({
                            title: '打印清算通知书',
                            area: ['800px', '600px'],
                            content: '/reg/server/registmanage/printLiq?uid='+$(radioObj).val(),
                            callback: function (data) { 
                            }
                        })
                	}
                }
            },{
                el: '#js-can',
                event: 'click',
                handler: function () {
                	var limitObj;
                	var radio = document.getElementsByName("_radio");  
                    for (i=0; i<radio.length; i++) {  
                        if (radio[i].checked) {  
                            limitObj = document.getElementsByName("_radio")[i];
                        }  
                    }  
                	var limitDateEnd;
                	var auditState;
                	if(limitObj!=undefined){
                		limitDateEnd = limitObj.getAttribute('can');
                		auditState = limitObj.getAttribute('auditState');
                	}
                	var sysdate=$("#sysdate").val();  
                	var can;
                	if(auditState&&auditState=='1'){
                		can="已解除";
                	}else{
                		if(sysdate!=""&&limitDateEnd!=""&&limitDateEnd){  
                			var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
                			var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
                			if(d1 > d2){
                				can = "已解除";
                			}else{
                				can = "未解除";
                			}
                		}else{
                			can = "未解除";
                		}
                	}
                	var radioObj= $(":radio[name=_radio]:checked");
                	if(radioObj==null||radioObj.length==0||limitObj==undefined){
                		 layer.msg("请选择失信受限企业的限制对象再操作", {ltype: 0,time:2000});
                	}else if(can=="未解除"){
                		layer.msg("请选择限制解除状态为已解除再操作", {ltype: 0,time:2000});
                	}else{
                		layer.dialog({
                            title: '打印解除证明',
                            area: ['800px', '600px'],
                            content: '/reg/server/registmanage/printCan?uid='+$(radioObj).val(),
                            callback: function (data) { 
                            }
                        })
                	}
                }
            },
            {
        	el: '#choseregUnit-1',
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
                      	$("#localAdm-1").val(returncode);
                      	$("#localAdmName-1").val(data.returnname); 
                    }
                })
            }
        },{
            el: '.look_1',
            event: 'click',
            handler: function () {
            	var uid = $(this).attr("uid");
            	if(uid!=null && uid != ''){
            		layer.dialog({
                        title: '详情',
                        area: ['100%', '100%'],
                        content:'/reg/server/registmanage/limitObjDetail?uid='+uid,
                        callback: function (data) {
                            if (data.reload) { 
                            	 table_1.ajax.reload();  
                            }
                        }
                    })
            	}
            }
        },{
            el: '.look_2',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	var uid = $(this).attr("uid");
            	if(priPID!=null && priPID != ''){
            		layer.dialog({
                        title: '详情',
                        area: ['100%', '100%'],
                        content:'/reg/server/registmanage/limitRelEntDetail?priPID='+priPID+'&uid='+uid,
                        callback: function (data) {
                            if (data.reload) { 
                            	 table_2.ajax.reload();  
                            }
                        }
                    })
            	}
            }
        },{
        	el: '#choseregUnit-2',
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
                      	$("#localAdm-2").val(returncode);
                      	$("#localAdmName-2").val(data.returnname); 
                    }
                })
            }
        },{
        	el: '#choseregUnit-3',
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
                      	$("#localAdm-3").val(returncode);
                      	$("#localAdmName-3").val(data.returnname); 
                    }
                })
            }
        }, {
        	el: '#choseorgReg-1',
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
                    	$("#regOrg-1").val(returncode);
                    	$("#regOrgName-1").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#choseorgReg-2',
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
                    	$("#regOrg-2").val(returncode);
                    	$("#regOrgName-2").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#choseorgReg-3',
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
                    	$("#regOrg-3").val(returncode);
                    	$("#regOrgName-3").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#cancel-1',
            event: 'click',
            handler: function () { 
            	$("#regOrg-1").val("");
            	$("#localAdm-1").val("");
            	$("#limitType-1").val("");
        		$('#limitTypeM-1').multipleSelect('setSelects',['']);
        		$("#freeState-1").val("");
            	$('#freeStateM-1').multipleSelect('setSelects',['1']);
            }
        },{
            el: '#cancel-2',
            event: 'click',
            handler: function () { 
            	$("#regOrg-2").val("");
            	$("#localAdm-2").val("");
            	$("#limitType-2").val("");
        		$('#limitTypeM-2').multipleSelect('setSelects',['']);
        		$("#freeState-2").val("");
            	$('#freeStateM-2').multipleSelect('setSelects',['1']);
            }
        },{
            el: '#cancel-3',
            event: 'click',
            handler: function () { 
            	$("#regOrg-3").val("");
            	$("#localAdm-3").val("");
        		$("#freeState-3").val("");
            	$('#freeStateM-3').multipleSelect('setSelects',['1']);
            }
        },{
            el: '#objRadio',
            event: 'click',
            handler: function () { 
            	$("#taskForm-1").css("display","block");
        		$("#taskForm-2").css("display","none");
        		$("#taskForm-3").css("display","none");
        		$("#obj").css("display","block");
        		$("#ent").css("display","none");
        		$("#limiter").css("display","none");
            }
        },{
            el: '#entRadio',
            event: 'click',
            handler: function () { 
            	$("#taskForm-1").css("display","none");
        		$("#taskForm-2").css("display","block");
        		$("#taskForm-3").css("display","none");
        		$("#obj").css("display","none");
        		$("#ent").css("display","block");
        		$("#limiter").css("display","none");
            }
        },{
            el: '#limiterRadio',
            event: 'click',
            handler: function () { 
            	$("#taskForm-1").css("display","none");
        		$("#taskForm-2").css("display","none");
        		$("#taskForm-3").css("display","block");
        		$("#obj").css("display","none");
        		$("#ent").css("display","none");
        		$("#limiter").css("display","block");
            }
        },{
            el: '#more-1',
            event: 'click',
            handler: function () { 
            	var isHideOrShow = $("#hideorshow-1").is(":hidden");
            	if(isHideOrShow){
            		 $("#more").val("收起");
            		 $("#hideorshow-1").css("display","block");
				}else{
					$("#more-1").val("更多查询条件");
            		$("#hideorshow-1").css("display","none");
				}
            }
        },{
            el: '#more-2',
            event: 'click',
            handler: function () { 
            	var isHideOrShow = $("#hideorshow-2").is(":hidden");
            	if(isHideOrShow){
            		 $("#more").val("收起");
            		 $("#hideorshow-2").css("display","block");
				}else{
					$("#more-2").val("更多查询条件");
            		$("#hideorshow-2").css("display","none");
				}
            }
        }])
    }

})
