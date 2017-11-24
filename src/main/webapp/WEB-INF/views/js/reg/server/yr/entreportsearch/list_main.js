require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchFlag="0";
	var searchParams;//查询参数声明!
	var regStateList = [];
	function timeOut(){
    	$("#js-download").prop('disabled',false);
    }
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        getRegStateList();
    }

    $("#badInfoM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});

	$("#yrRepStateM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
	$("#regStateM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
	$('#yrRepStateM').multipleSelect('checkAll');
	//取值  $("#yrRepStateM").multipleSelect('getSelects');
	//获取登记状态
    function getRegStateList() {
    	$('#regStateM option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }
	
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	var currentDate = new Date();
    	var currentYear = currentDate.getFullYear();//当前年份
		var currentReportYear = currentDate.getFullYear()-1;//当前应报年度
		var currentMounth = currentDate.getMonth()+1;//当前月份
    	
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/syn/panoramasearch/comPanoQueryPage',
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
                      {data: null,width:'40px'},
                      {data: 'yrIsRep'+$('#yrYear').val(),width:'80px'},
                      {data: 'yrRepMode'+$('#yrYear').val(),width:'80px'},
                      {data: 'yrFirRepTime'+$('#yrYear').val(),width:'80px'},
                      {data: "yrRecRepTime"+$('#yrYear').val(),width:'80px'},
                      {data: 'yrRepState'+$('#yrYear').val(),width:'100px'},
                      {data: 'leRep',width:'100px'},
                      {data: 'tel',width:'130px'},
                      {data: 'liaName',width:'100px'},
                      {data: 'liaTel',width:'130px'},
                      {data: 'regCap',width:'80px'},
                      {data: 'entTypeName',width:'140px',className: 'left'},
                      {data: 'industryCoName',width:'180px',className: 'left'},
                      {data: 'dom',width:'200px',className: 'left'},
                      {data: 'regOrgName',width:'180px',className: 'left'},
                      {data: 'localAdmName',width:'180px',className: 'left'},
                      {data: 'sliceNOName',width:'180px',className: 'left'},
                      {data: 'regState',width:'60px'},
                      {data: null,width:'60px'},
                      {data: null,width:'60px'},
                      {data: null,width:'60px'}
            ],
            columnDefs: [
 				{
 					targets:1,
 					render:function(data,type,row,meta){
 						
 						var year = $('#yrYear').val();
 						var _isrep = 'yrIsRep' + year; //是否年报
 						var _yrRepState='yrRepState' + year;//年报状态
 						
 						var isOpan = row.isOpan;
 						var isSerVio = row.isSerVio;
 						//列入经营异常名录（黄色警示）
 						if(isOpan){
							return "<i class='bulb yellow-b'></i>";
 						}
 						if(isSerVio=="Y"){
 							return "<i class='bulb orange-b'></i>";
 						}
 						if(isSerVio=="Y"&&isOpan){
 							return "<i class='bulb red-b'></i>";
 						}
 						return "";
 					}
 				 },{
 					targets:5,
 					render:function(data,type,row,meta){
 						return $('#yrYear').val();
 					}
 				 },{
 					targets:23,
 					render:function(data,type,row,meta){
 						var isOpan = row.isOpan;
 						if(isOpan){
 							return "是";
 						}else{
 							return "否";
 						}
 					}
 				 },{
 					targets:24,
 					render:function(data,type,row,meta){
 						var isSerVio = row.isSerVio;
 						if(isSerVio=="Y"){
 							return "是";
 						}else if(isSerVio=="N"){
 							return "否";
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:25,
 					render:function(data,type,row,meta){
 						var isSim = row.isSim;
 						if(isSim=="Y"){
 							return "是";
 						}else if(isSim=="N"){
 							return "否";
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:12,
 					render:function(data,type,row,meta){
 						var year =  $('#yrYear').val();
 						var _yrRepMode = 'yrRepMode' + year; //年报方式
 						var _yrLiaTel = "yrLiaTel" + year;//个体户纸质接收的负责人电话
 						if(row[_yrRepMode]=='6'){//个体户纸质接收
 							return row[_yrLiaTel];
 						}else{
 							return row.tel;
 						}
 					}
 				 },{
 					targets:22,
 					render:function(data,type,row,meta){
 						return switchRegStateList(row.regState);
 					}
 				 },{
 					targets:2,
 					render:function(data,type,row,meta){
 						var isSim = row.isSim;
 						if(isSim=="Y"){
 							if(row.uniscid){
	 							return "<span class='yellow-bg'>"+row.uniscid+"</span>";
	 						}else{
	 							return "<span class='yellow-bg'>"+row.regNO+"</span>";
	 						}
 						}else{
 							if(row.uniscid){
	 							return row.uniscid;
	 						}else{
	 							return row.regNO;
	 						}
 						}
 					}
 				 },{
 					targets:8,
 					render:function(data,type,row,meta){
 						var year = $('#yrYear').val();
 						var _yrFirRepTime = 'yrFirRepTime' + year;
 						return row[_yrFirRepTime];
 					}
 				 },{
 					targets:9,
 					render:function(data,type,row,meta){
 						var year = $('#yrYear').val();
 						var _yrRecRepTime = 'yrRecRepTime' + year;
 						return row[_yrRecRepTime];
 					}
 				 },{
 					targets:6,
 					render:function(data,type,row,meta){
 						var year = $('#yrYear').val();
 						var _yrIsRep = 'yrIsRep' + year;
						if(row[_yrIsRep]==1){
							return "已年报";
						}else if (row[_yrIsRep]==2){
							return "已年报(逾期)";
						}else if (row[_yrIsRep]==0){
							return "未年报";
						}else{
							return "-";
						}
 					}
 				 },{
 					targets:7,
 					render:function(data,type,row,meta){
 						var year = $('#yrYear').val();
 						var _yrRepMode = 'yrRepMode' + year;
						if(row[_yrRepMode]==2){
							return "联络员";
						}else if (row[_yrRepMode]==4){
							return "手机APP";
						}else if (row[_yrRepMode]==6){
							return "纸质报告";
						}else if (row[_yrRepMode]==5){
							return "数字证书";
						}else{
							return "-";
						}
 					}
 				 },{
 					targets:10,
 					render:function(data,type,row,meta){
 						var year = $('#yrYear').val();
 						var _yrRepState = 'yrRepState' + year;
						if(row[_yrRepState]=="00"){
							return "未公示";
						}else if (row[_yrRepState]=="10"){
							return "已公示";
						}else if (row[_yrRepState]=="12"){
							return "已公示(敏感词待审核)";
						}else if (row[_yrRepState]=="13"){
							return "已公示(敏感词不通过)";
						}else if (row[_yrRepState]=="11"){
							return "已公示(敏感词通过)";
						}else if (row[_yrRepState]=="20"){
							return "待修改";
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
    	if(chooseLength<=0){
    		alert("年报主体为必选项");
    	}else if(isNaN(regCapStart)||isNaN(regCapEnd)){
    		alert("注册资本格式不正确");
    	}else{
    		var categCode=new Array();
    		$(":checkbox[name=entCatg]:checked").each(function(k,v){
    			categCode[k]= this.value;
    		});
    		$("#entTypeCatg").val(categCode);
    		
    		var yrRepStateM = $("#yrRepStateM").val();
    		$("#yrRepState").val(yrRepStateM);
    		
    		var regStateM = $("#regStateM").val();
    		$("#regState").val(regStateM);
    		
    		var badInfoM = $("#badInfoM").val();
    		$("#badInfo").val(badInfoM);
    		
    		searchParams = $("#taskForm").serializeObject();
    		if(searchFlag=="0"){
        		initDataTable();
        	}else{
        		table.ajax.reload();
        	}
    	}
    });
    
    $("#js-download").click(function(){
    	$(this).attr("disabled",true);
    	var chooseLength = $(":checkbox[name=entCatg]:checked").length;
    	var regCapStart = $("#regCapStart").val();
		var regCapEnd = $("#regCapEnd").val();
    	if(chooseLength<=0){
    		alert("年报主体为必选项");
    	}else if(isNaN(regCapStart)||isNaN(regCapEnd)){
    		alert("注册资本格式不正确");
    	}else{
    		var categCode=new Array();
    		$(":checkbox[name=entCatg]:checked").each(function(k,v){
    			categCode[k]= this.value;
    		});
    		$("#entTypeCatg").val(categCode);
    		
    		var yrRepStateM = $("#yrRepStateM").val();
    		$("#yrRepState").val(yrRepStateM);
    		
    		var regStateM = $("#regStateM").val();
    		$("#regState").val(regStateM);
    		
    		searchParams = $("#taskForm").serializeObject();
    		$("#map").val(JSON.stringify(searchParams));
    		$.ajax({
                url: "/reg/server/panoramasearch/comPanoQueryPageDownLoadCount",
                type: 'post',
                data: JSON.stringify(searchParams),
                contentType:"application/json",
                success: function(data, status){
                	if(data>20000){
//                		layer.confirm("查询出"+data+"条数据，超过系统最大限制，无法完整导出，确认继续吗?", {icon: 3, title: '提示'}, function () { 
//                			setTimeout(timeOut,15000);
//               	    	 	document._form.submit();
//                		})

                		 if(confirm("查询出"+data+"条数据，超过系统最大限制，无法完整导出，确认继续吗?")){
                			 setTimeout(timeOut,30000);
                	    	 document._form.submit();
                	      }else{
                	    	  $("#js-download").prop('disabled',false);
                	      }
                	}else{
                		setTimeout(timeOut,15000);
           	    	 	document._form.submit();
                	}
                },
                error: function(data, status){
                	alert("查询失败");
                }
            });
    	}
    });
    
    function bind() {
        util.bindEvents([                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
            {
                el: '#user-table tr',                      //查看年报信息
                event: 'click',
                handler: function () {
					$('#praramContent')[0].reset();//重置为空字符串
					var year = $(this).find("td:eq(5)").text();//获取选中的年份;
					var yrRepModeCN = $(this).find("td:eq(7)").text();
					var data = table.row($(this)).data();  //获取当前选中的数据
					var priPID = data.priPID;
					var entType = data.entType; //企业类型
					var entTypeCatg = data.entTypeCatg; //企业大类
					var regNO = data.regNO; //注册号
					var entName = data.entName;  //企业名称
					var uniscid = data.uniscid;//统一代码
					var estDate = $(this).find("td:eq(4)").text().substring(0,4);//获取成立日期的年份
					var liaName = data.liaName; //工商联络员
					var liaTel = data.liaTel;   //联络员电话
					var leRep = data.leRep;   //法人姓名
					var leRepTel = data.tel;  //法人联系方式

					$("#_entTypeCatg").val(entTypeCatg);
					$("#entType1").val(entType);
					$("#priPID").val(priPID);
					$("#year").val(year);
					$("#regNO").val(regNO);
					$("#entName").val(entName);
					$("#uniscid").val(uniscid);
					$("#estDate").val(estDate);
					$("#liaName").val(liaName);
					$("#liaTel").val(liaTel);
					$("#js_isIndivid").val(data.isIndivid);
					$("#altDate").val(data.altDate);
					$("#leRep").val(leRep);
					$("#leRepTel").val(leRepTel);
					//模拟数据：
					if(yrRepModeCN!='纸质报告'){
						layer.dialog({
							title:'年报详情',
							area: ['100%', '100%'],
							content: '/server/yr_view/tab?'+$("#praramContent").serialize(),
							callback: function (data) {}
						})
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
            	$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
            	$('#yrRepStateM').multipleSelect('checkAll');
            }
        },{
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
        }])
    }

})
