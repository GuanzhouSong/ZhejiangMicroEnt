require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchFlag="0";
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/syn/panoramasearch/yearsPanoQueryPage',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: null,width:'40px'},
                      {data: null,width:'40px'},
                      {data: 'regNO'},
                      {data: 'entName',width:'200px',className: 'left'},
                      {data: 'estDate',width:'80px'},
                      {data: 'leRep',width:'100px'},
                      {data: 'tel',width:'130px'},
                      {data: 'liaName',width:'80px'},
                      {data: 'liaTel',width:'100px'},
                      {data: 'regCap',width:'80px'},
                      {data: 'entTypeName',width:'140px',className: 'left'},
                      {data: 'industryCoName',width:'180px',className: 'left'},
                      {data: 'dom',width:'200px',className: 'left'},
                      {data: 'regOrgName',width:'180px',className: 'left'},
                      {data: 'localAdmName',width:'180px',className: 'left'},
                      {data: 'sliceNOName',width:'180px',className: 'left'},
                      {data: 'regState',width:'60px'}
            ],
            columnDefs: [{
			                targets: 1,
			                render: function (data, type, row, meta) {
			                    return '<input type="checkbox" name="_checkbox"  value=' + row.priPID + ' data-entName='+row.entName+'>';
			             }
	            },{
 					targets:2,
 					render:function(data,type,row,meta){
 						var isOpan = row.isOpan;
 						//列入经营异常名录（红色警示）
 						if(isOpan=="Y"){
 							return "<img src='/img/reg/server/year-status3.png' width='20' height='20'/> ";
 						} else{
 							return "";
 						}
 					}
 				 },{
 					targets:3,
 					render:function(data,type,row,meta){
 						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
 				 },{
 					targets:17,
 					render:function(data,type,row,meta){
 						var regState = row.regState;
 						if(regState=="K"||regState=="B"||regState=="A"||regState=="DA"||regState=="X"){
 							return "存续";
 						}else if(regState=="C"){
 							return "撤销";
 						}else if(regState=="D"){
 							return "吊销";
 						}else if(regState=="Q"){
 							return "迁出";
 						}else if(regState=="XX"||regState=="DX"){
 							return "注销";
 						}else{
 							return "-";
 						}
 					}
 				 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	var chooseLength = $(":checkbox[name=entCatg]:checked").length;
    	var regCapStart = $("#regCapStart").val();
		var regCapEnd = $("#regCapEnd").val();
		var yearMode = $("#yearMode").val();
    	if(chooseLength<=0){
    		alert("年报主体为必选项");
    	}else if(yearMode==""){
    		alert("年度年报与状态是必选项");
    	}else if(isNaN(regCapStart)||isNaN(regCapEnd)){
    		alert("注册资本格式不正确");
    	}else{
    		var categCode=new Array();
    		$(":checkbox[name=entCatg]:checked").each(function(k,v){
    			categCode[k]= this.value;
    		});
    		$("#entTypeCatg").val(categCode);
    		
    		var regStateM = $("#regStateM").val();
    		$("#regState").val(regStateM);
    		
    		searchParams = $("#taskForm").serializeObject();
    		if(searchFlag=="0"){
        		initDataTable();
        	}else{
        		table.ajax.reload();
        	}
    	}
    });
    
    function bind() {
        util.bindEvents([
        	{
                el: '#user-table tr',                      //查看年报信息
                event: 'click',
                handler: function () {
                	var date=new Date;
                	var year=date.getFullYear()-1;
                    var data = table.row($(this)).data();  //获取当前选中的数据
                    var priPID = data.priPID;
                    var entType = data.entType; //企业类型
                    var entTypeCatg = data.entTypeCatg; //企业大类
                    var regNO = data.regNO; //注册号
                    var entName = data.entName;  //企业名称
                    var uniscid = data.uniscid;//统一代码
					var estDate = $(this).find("td:eq(4)").text().substring(0,4);//获取成立日期的年份
					layer.dialog({
                		title:'年报详情',
                		area: ['95%', '80%'],
                		maxmin: true, //开启最大化最小化按钮
                		content: '/server/yr_view/tab?priPID='+priPID+'&year='+year+'&entType='+entType+"&entTypeCatg="+entTypeCatg+"&regNO="+regNO+"&entName="+entName+"&uniscid="+uniscid+"&estDate="+estDate,
                		callback: function (data) {}
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
        	el: '#chooseEntType',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=chooseEntCatg]:checked").each(function(k,v){
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
        }, {
        	el: '#choseindustry',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择行业',
                    area: ['400px', '600px'],
                    content: '/commom/server/industry/toIndustryPhyTree',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#industryCo").val(returncode);
                    	$("#industryCoName").val(data.returnname);  
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
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#checkDep").val("");
            	$("#sliceNo").val("");
            	$("#entType").val("");
            	$("#industryCo").val("");
            	$('#yearMode').val("");
            	$('#regStateM').multipleSelect('setSelects',['K,B,A,DA,X']);
            	
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
            	//$("#hideorshow").toggle();
				$("#regStateM").multipleSelect({
					selectAllText: '全部',
					allSelected: '全部',
					selectAllDelimiter: '',
					minimumCountSelected: 10
				});
            }
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
        		
        		if($("#checkAllEnt")[0].checked){//全部企业
        			var chooseLength = $(":checkbox[name=entCatg]:checked").length;
        	    	var regCapStart = $("#regCapStart").val();
        			var regCapEnd = $("#regCapEnd").val();
        			var yearMode = $("#yearMode").val();
        	    	if(chooseLength<=0){
        	    		alert("年报主体为必选项");
        	    	}else if(yearMode==""){
        	    		alert("年度年报与状态是必选项");
        	    	}else if(isNaN(regCapStart)||isNaN(regCapEnd)){
        	    		alert("注册资本格式不正确");
        	    	}else{
        	    		var categCode=new Array();
        	    		$(":checkbox[name=entCatg]:checked").each(function(k,v){
        	    			categCode[k]= this.value;
        	    		});
        	    		$("#entTypeCatg").val(categCode);
        	    		
        	    		var regStateM = $("#regStateM").val();
        	    		$("#regState").val(regStateM);
        	    		
        	    		sessionStorage.setItem("searchParams",JSON.stringify($("#taskForm").serializeObject()) );
            			layer.dialog({
                            title: '设置消息内容',
                            area: ['100%', '100%'],
                            content: '/reg/message/toMessageEdit?checkAllEnt=true',
                            callback: function (data) { 
                            	 if (data.reload) { //close是否有传递此参数
        	                         table.ajax.reload();
        	                     }
                            }
                        })
        	    	}
        			
        		}else{
        			var priPIDs = "";
        			var entNames = "";
            		var count = 0;
            		$("input:checkbox[name='_checkbox']:checked").each(function (index){
            			priPIDs += (index >0?",":"")+$(this).val();
            			entNames += $(this).attr("data-entName");
            			count++;
            		});
            		if(priPIDs){
            			sessionStorage.setItem("priPIDs",priPIDs);
            			sessionStorage.setItem("entNames",entNames);
            			layer.dialog({
                            title: '设置消息内容',
                            area: ['100%', '100%'],
                            content: '/reg/message/toMessageEdit',
                            callback: function (data) { 
                            	 if (data.reload) { //close是否有传递此参数
        	                         table.ajax.reload();
        	                     }
                            }
                        })
            		}else{
            			layer.msg("至少选择一家企业！",
            		            function() {
            		                layer.close();
            		            });
            		}
        		}
        		
        	}
        },{
        	el:'#btn_back',
        	event:'click',
        	handler:function(){
        		window.location="/reg/message/toMessagelist";
        	}
        }])
    }
})
