require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchFlag="0";
	var searchParams;//查询参数声明!
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
                url:'/syn/panoramasearch/smsQueryPage',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: null,width:'40px'},
                      {data: 'regNO'},
                      {data: 'entName',width:'200px',className: 'left'},
                      {data: 'estDate',width:'80px'},
                      {data: "entTypeName",width:'150px',className: 'left'},
                      {data: 'leRep',width:'50px'},
                      {data: 'tel',width:'80px'},
                      {data: 'liaName',width:'80px'},
                      {data: 'liaTel',width:'80px'},
                      {data: 'regOrgName',width:'180px',className: 'left'},
                      {data: 'localAdmName',width:'180px',className: 'left'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
 						return "<input value='" + row.priPID+"_"+row.uniscid+"_"+row.sliceNO+"_"+row.entName+"_"+row.estDate+"_"+row.leRep+"_"+row.tel+"_"+row.liaName+"_"+row.liaTel+"_"+row.regOrg+"_"+row.localAdm+"_"+row.regNO+"_"+row.entTypeCatg + "' name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
 					}
 				 },
            	{
 					targets:2,
 					render:function(data,type,row,meta){
 						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
 				 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
		searchParams = $("#taskForm").serializeObject();
		if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    });
    
    $("#selectAll").click(function(){
		searchParams = $("#taskForm").serializeObject();
		$("#map").val(JSON.stringify(searchParams));
		document.form2.submit();
//		$.ajax({
//            url: "/syn/panoramasearch/smsQueryPageAll",
//            type: 'post',
//            data: JSON.stringify(searchParams),
//            contentType:"application/json",
//            success: function(data, status){
//            	alert("成功");
//            },
//            error: function(data, status){
//            	alert("失败");
//            }
//        });
    });
    
    function bind() {
        util.bindEvents([
        	{
                el: '#return',
                event: 'click',
                handler: function () {
                	window.location.href='/reg/server/smstask/list';
                }
            },
            {
            	  el: '#checkAll',  //全选
                  event: 'click',
                  handler: function () {
                  	var allChecked= $("#checkAll").prop("checked");   
                  	$(".chb").prop("checked", allChecked);
                  }
            }, {
            	el: '#chooseEntType',
                event: 'click',
                handler: function () { 
                	var categCode=$("input[name='entTypeCatg']:checked").val();
                    
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
        	el: '#smsGroupSend',
            event: 'click',
            handler: function () { 
            	 var objs="";
                 $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
                	 objs=objs + this.value+"。"; 
                 });
                 objs = objs.substring(0,objs.length-1);
                 if(objs[0]==""||objs[0]==null){
                     layer.msg("请您<em style='color: red;'>【至少选择一家】</em>企业!", {icon: 7,time: 1000});
                 }else{
//                	 http.httpRequest({
//                         url: "/reg/server/smstaskinfo/smsShow",
//                         data: {
//                         	params:objs.toString()
//                         },
//                         type: 'post',
//                         success: function(data) {  
//                      	    
//                         }
//                     });
                	 
//                	 document.write("<form action=/reg/server/smstaskinfo/smsShow method=post name=formx1 style='display:none'>");
//                	 document.write("<input type=hidden name=params value='"+objs.toString()+"'");
//                	 document.write("</form>");
//                	 document.formx1.submit();
                	 
//                	 layer.dialog({
//                		 title: '短信群发',
//                		 area: ['1100px', '600px'],
//                		 content: '/reg/server/smstaskinfo/smsShow?params='+objs,
//                		 callback: function (data) { 
//                			 
//                		 }
//                	 })
                	 $("#params").val(objs);
                	 document.form1.submit();
                	 //window.location.href='/reg/server/smstaskinfo/smsShow?params='+objs;
                 }
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#checkDep").val("");
            	$("#sliceNo").val("");
            	$("#entType").val("");
            	$('#yearMode').val("");
            }
        }])
    }

})
