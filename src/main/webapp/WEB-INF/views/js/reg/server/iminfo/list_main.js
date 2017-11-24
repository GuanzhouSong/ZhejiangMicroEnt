require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchParams;//查询参数声明!
	var regStateList = [];
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	$("#regStateM").multipleSelect({
			selectAllText: '全部',
			allSelected: '全部',
			selectAllDelimiter: '',
			minimumCountSelected: 10
		});
    	
        bind();
        getRegStateList();
    }
    
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
                url:'/reg/server/iminfo/comPanoQueryPage',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: null,width:'40px'},
//                      {data: null,width:'40px'},
                      {data: 'regNO'},
                      {data: 'entName',width:'200px',className: 'left'},
                      {data: 'estDate',width:'80px'}, 
                      {data: null},
                      {data: null},
                      {data: 'imPubDate',width:'80px'}, 
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
                      {data: 'regState',width:'60px'}
            ],
            columnDefs: [
 				{
 					targets:1,
 					render:function(data,type,row,meta){
 						var isOpan = row.isOpan;
 						
 						var ifPub=false;
 						if(row.imCase=='Y'||row.imInvest=='Y'||row.imPermit=='Y'||row.imIppldg=='Y'||row.imInvsra=='Y'){
 							ifPub=true;
 						} 
 						  
 						//列入经营异常名录（红色警示）
 						if(isOpan=='Y' && !ifPub ){
 							return "<img src='/img/reg/server/year-status3.png' width='20' height='20'/> <img src='/img/reg/server/year-status0.png' width='20' height='20'/>";
 						}else if(isOpan=='Y'){//红色标
 							return "<img src='/img/reg/server/year-status3.png' width='20' height='20'/>"
 						}else if(!ifPub){
 							return "<img src='/img/reg/server/year-status0.png' width='20' height='20'/>"
 						}else{
 							return "";
 						}
 					}
 				 },{
 				  targets:5,//即时信息公示	
 				  render:function(data,type,row,meta){
 					 var ifPub=false;
						if(row.imCase=='Y'||row.imInvest=='Y'||row.imPermit=='Y'||row.imIppldg=='Y'||row.imInvsra=='Y'){
							ifPub=true;
						} 
						if(ifPub){
							return "有";
						}else{
							return "无";
						}  
						
 				  }
 				 },{
 					targets:19,
 					render:function(data,type,row,meta){
 						return switchRegStateList(row.regState);
 					}
 				 },{
 					targets:2,
 					render:function(data,type,row,meta){
 						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
 				 }, {
  					targets:6,
  					render:function(data,type,row,meta){
  						var year = $('#yrYear').val();
  						if (row.yrRecRepTime2020!=null&&row.yrRecRepTime2020!='-'){
  							return row.yrRecRepTime2020;
  						}else if(row.yrRecRepTime2019!=null&&row.yrRecRepTime2019!='-'){
  							return row.yrRecRepTime2019;
  						}else if(row.yrRecRepTime2018!=null&&row.yrRecRepTime2018!='-'){
  							return row.yrRecRepTime2018;
  						}else if(row.yrRecRepTime2017!=null&&row.yrRecRepTime2017!='-'){
  							return row.yrRecRepTime2017;
  						}else if(row.yrRecRepTime2016!=null&&row.yrRecRepTime2016!='-'){
  							return row.yrRecRepTime2016;
  						}else if(row.yrRecRepTime2015!=null&&row.yrRecRepTime2015!='-'){
  							return row.yrRecRepTime2015;
  						}else if(row.yrRecRepTime2014!=null&&row.yrRecRepTime2014!='-'){
  							return row.yrRecRepTime2014;
  						}else if(row.yrRecRepTime2013!=null&&row.yrRecRepTime2013!='-'){
  							return row.yrRecRepTime2013;
  						}else{
  							return "";
  						}
  					} 
  				 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    		
    		var yrRepStateM = $("#yrRepStateM").val();
    		$("#yrRepState").val(yrRepStateM);
    		
    		var regStateM = $("#regStateM").val();
    		$("#regState").val(regStateM);
    		
    		searchParams = $("#taskForm").serializeObject();
    		initDataTable();
    		var regCapStart = $("#regCapStart").val();
    		var regCapEnd = $("#regCapEnd").val();
    		if(!isNaN(regCapStart)&&!isNaN(regCapEnd)){
    			table.ajax.reload();
    		}else{
    			alert("注册资本格式不正确");
    		}
    });
    
    function bind() {
        util.bindEvents([
            {
                el: '#user-table tr',                      //查看年报信息
                event: 'click',
                handler: function () {
                    var year = $(this).find("td:eq(2)").text();//获取选中的年份;
                    var yrRepModeCN = $(this).find("td:eq(7)").text();
                    var data = table.row($(this)).data();  //获取当前选中的数据
                    var priPID = data.priPID;
                    var entType = data.entType; //企业类型
                    var entTypeCatg = data.entTypeCatg; //企业大类
                    var regNO = data.regNO; //注册号
                    var entName = data.entName;  //企业名称
                    var uniscid = data.uniscid;//统一代码
					var estDate = $(this).find("td:eq(5)").text().substring(0,4);//获取成立日期的年份
					//模拟数据：
				/*	var year ="2013";
					var priPID = "3301810000011968";
					var entType = "1152";
					var entTypeCatg ="11";
					var regNO = "330181000191252";
					var entName = "杭州绿都湖滨花园物业服务有限公司";*/

                 
                    	layer.dialog({
                    		title:'即时信息详情',
                    		area: ['100%', '100%'],
                    		maxmin: true, //开启最大化最小化按钮
                    		content: '/reg/server/iminfo/todetail?priPID='+priPID+'&leRep='+data.leRep+'&tel='+data.tel
                    		+'&liaName='+data.liaName+'&liaTel='+data.liaTel+'&imPubDate='+data.imPubDate,
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
        },
        {
        	el:"#choseItem",
        	event:'click',
        	handler:function(){
        		$("#imitem").empty();//
        		layer.dialog({
                    title: '选择即时选项',
                    area: ['400px', '300px'],
                    content: '/reg/server/iminfo/tochoseitem',
                    callback: function (data) { 
                    	var returncode=data.returncodes; 
                    	 for(var i=0;i<returncode.length;i++){
                    		 if(returncode[i]==1){ $("#imitem").append("<input type='hidden' name='imPermit' value='Y' >"); }
                    		 if(returncode[i]==2){ $("#imitem").append("<input type='hidden' name='imInvest' value='Y' >"); }
                    		 if(returncode[i]==3){ $("#imitem").append("<input type='hidden' name='imIppldg' value='Y' >"); }
                    		 if(returncode[i]==4){ $("#imitem").append("<input type='hidden' name='imInvsra' value='Y' >"); }
                    		 if(returncode[i]==5){ $("#imitem").append("<input type='hidden' name='imCase' value='Y' >"); }
                    		 
                    		 if(returncode[i]=='23'){ $("#imitem").append("<input type='hidden' name='imConNo' value='Y' >"); }
                    		 
                    	}
                    	$("#itemName").val(data.returnname);  
                    }
                })
        	}
        },
        
        {
            el: '#reset',
            event: 'click',
            handler: function () { 
            	$(".clx").val("");
            	$("#imitem").html('');
            	$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
            }
        },{
            el: '#more',
            event: 'click',
            handler: function () { 
            	if($('.hideorshow').css("display")=="none"){
            		$('#more').attr('value','收起');
            		$('.hideorshow').css("display","block");
            	}else{
            		$('#more').attr('value','更多查询条件');
            		$('.hideorshow').css("display","none");
            	}
            }
        }])
    }

})
