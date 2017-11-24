require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	var regStateList = [];
	var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
   //警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
  
    init();
    //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startRegDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#endRegDate',
        format: 'YYYY-MM-DD',
        min: '1970-01-01',
        max: '2099-06-16',
        istime: true,
        istoday: false,
        start: laydate.now(0,"YYYY-MM-DD"),
        choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    
    var startNorDate = {
            elem: '#startInfaustlDate', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
            	endNorDate.min = datas; //开始日选好后，重置结束日的最小日期
            	endNorDate.start = datas //将结束日的初始值设定为开始日
            }
        };
        var endNorDate = {
            elem: '#endInfaustlDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            startNorDate: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            	startNorDate.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        
        
        var startExtDate = {
                elem: '#regFrom', //选择ID为START的input
                format: 'YYYY-MM-DD', //自动生成的时间格式
                min: '1970-01-01', //设定最小日期为当前日期
                max: '2099-06-16', //最大日期
                istime: true, //必须填入时间
                istoday: false,  //是否是当天
                start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
                choose: function(datas){
                endExtDate.min = datas; //开始日选好后，重置结束日的最小日期
                endExtDate.start = datas //将结束日的初始值设定为开始日
                }
            };
	     var endExtDate = {
	         elem: '#regTo',
	         format: 'YYYY-MM-DD',
	         min: '1970-01-01',
	         max: '2099-06-16',
	         istime: true,
	         istoday: false,
	         startExtDate: laydate.now(0,"YYYY-MM-DD"),
	         choose: function(datas){
	         startExtDate.max = datas; //结束日选好后，重置开始日的最大日期
	         }
	     };
    
    //开始时间和结束时间
    $("#startRegDate").click(function(){laydate(start);});
    $("#endRegDate").click(function(){laydate(end);}); 

    $("#startInfaustlDate").click(function(){laydate(startNorDate);});
    $("#endInfaustlDate").click(function(){laydate(endNorDate);});
    
    $("#regFrom").click(function(){laydate(startExtDate);});
    $("#regTo").click(function(){laydate(endExtDate);});
    
    
    /**
     * 初始化函数集合
     */
    function init() {
        //initDataTable();
    	initFavType();
    	initLicZone();
    	initRegState();
    	initInfaustlType();
        bind();
        getRegStateList();
        }
    
    //初始化良好信息类别
    function initFavType(){ 
  		$("#favType").append("<option value='0'>百强民营企业</option>");
  		$("#favType").append("<option value='1'>驰名商标</option>");
  		$("#favType").append("<option value='2'>知名商号</option>");
  		$("#favType").append("<option value='3'>著名商标</option>");
  		$("#favType").append("<option value='4'>守合同重信用企业</option>");
  		$("#favType").append("<option value='5'>信用示范管理企业</option>");
  		$("#favType").append("<option value='6'>小微企业成长之星</option>"); 
       	$("#favType").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
       	//全选
        $('#favType').multipleSelect('checkAll'); 
   }
    
     
    
    //初始化级别
    function initLicZone(){ 
  		$("#licZone").append("<option value='0'>全国</option>");
  		$("#licZone").append("<option value='1'>省级</option>");
  		$("#licZone").append("<option value='2'>市级</option>");
  		$("#licZone").append("<option value='3'>县级</option>"); 
  		$("#licZone").append("<option value='4'>AAA</option>"); 
  		$("#licZone").append("<option value='5'>AA</option>"); 
  		$("#licZone").append("<option value='6'>A</option>"); 
       	$("#licZone").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
       	//全选
        $('#licZone').multipleSelect('checkAll'); 
   }
    
   function initRegState(){ 
       	$("#regState").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
   }
   
 //获取登记状态
   function getRegStateList() {
   	$('#regState option').each(function(){
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
   
   
   function initInfaustlType(){ 
 		$("#infaustlType").append("<option value='0'>列入经营异常</option>");
 		$("#infaustlType").append("<option value='1'>列入严重违法</option>");
 		$("#infaustlType").append("<option value='2'>行政处罚</option>");
 		$("#infaustlType").append("<option value='3'>司法协助</option>"); 
 		$("#infaustlType").append("<option value='4'>任职资格限制</option>"); 
 		$("#infaustlType").append("<option value='5'>其它不良信息</option>"); 
      	$("#infaustlType").multipleSelect({
      		selectAllText: '全部',
   		allSelected: '全部',
   		selectAllDelimiter: '',
   		minimumCountSelected: 20
      	});
      	//全选
       $('#infaustlType').multipleSelect('checkAll'); 
  }



    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
     	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:_sysUrl+'/favorable/favorAbleInfoListJSON.json',
                data:function(d){ 
                     var regState = $('#regState').val(); 
                	 var favType = $('#favType').val(); 
                	 var licZone = $('#licZone').val(); 
                	 var infaustlType = $('#infaustlType').val(); 
                   d.params = $.extend({}, searchParams, {"regState":regState==null?"":regState.toString()
                		   ,"favType":favType==null?"":favType.toString()
                		   ,"licZone":licZone==null?"":licZone.toString() 
                		   ,"infaustlType":infaustlType==null?"":infaustlType.toString() 
                         });
                }
            },
            columns: [ 
                    {data: null,'defaultContent':'11'}, 
                  	{data: null, width:"250px" ,defaultContent:'id' },
                 	{data: 'uniSCID',cut: {length: 20,mark:'...'}},
    				{data: 'entName',cut: {length: 20,mark:'...'},className: 'left'},
    				{data: 'favName',cut: {length: 20,mark:'...'}},
    				{data: 'favType',cut: {length: 20,mark:'...'}},
    				{data: 'licZone',cut: {length: 20,mark:'...'}},
    				{data: 'regYear',cut: {length: 20,mark:'...'}},
    				{data: 'regType',cut: {length: 20,mark:'...'}},
    				{data: 'regFrom',cut: {length: 20,mark:'...'}},
     				{data: 'regTo',cut: {length: 20,mark:'...'}},
     				{data: 'regDate',cut: {length: 20,mark:'...'}},
    				{data: 'regDocNo',cut: {length: 20,mark:'...'}},
    				{data: 'regDeptCn',cut: {length: 20,mark:'...'},className: 'left'},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'},className: 'left'},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'},className: 'left'},
    				{data: 'regState',cut: {length: 20,mark:'...'}}
    				
            ] ,
            columnDefs: [
                          {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 
                            	 var opanomaly= row.opanomaly;
                            	 var expSeriousCrime=row.expSeriousCrime;
                            	 //同时被列入严重违法和异常
                            	 if("1"==expSeriousCrime&&"1"==opanomaly){
                            		 return "<i class='bulb red-b'></i>";
                            	 }else if("1"==expSeriousCrime){//严重违法
                            		 return "<i class='bulb orange-b'></i> ";
                            	 }else if("1"==opanomaly){//异常
                            		 return "<i class='bulb yellow-b'></i>";
                            	 }else {
                            		 return "";
                            	 }
                             }
                          },
                          {
								targets: 2,
							    render: function (data, type, row, meta) { 
							    	 if(data!=null&&data!=""){
							    		 return data;
							    	 }else{
							    		 return row.regNO;
							    	 }
							    }
						  },
                          {
								targets: 5,
							    render: function (data, type, row, meta) { 
							    	 if(data=="0"){
							    		 return "百强民营企业";
							    	 }else if(data=="1"){
							    		 return "驰名商标";
							    	 }else if(data=="2"){
							    		 return "知名商号";
							    	 }else if(data=="3"){
							    		 return "著名商标";
							    	 }else if(data=="4"){
							    		 return "守合同重信用企业";
							    	 }else if(data=="5"){
							    		 return "信用示范管理企业";
							    	 }else if(data=="6"){
							    		 return "小微企业成长之星";
							    	 }else{
							    		 return "";
							    	 }
							    }
						  },
                          {
								targets: 6,
							    render: function (data, type, row, meta) { 
						    		if(data=="0"){
							    		 return "全国";
							    	 }else if(data=="1"){
							    		 return "省级";
							    	 }else if(data=="2"){
							    		 return "市级";
							    	 }else if(data=="3"){
							    		 return "县级";
							    	 }else if(data=="4"){
							    		 return "AAA";
							    	 }else if(data=="5"){
							    		 return "AA";
							    	 }else if(data=="6"){
							    		 return "A";
							    	 }else {
							    		 return "";
							    	 }
							    }
						  },
						  {
								targets: 16,
							    render: function (data, type, row, meta) {
							    	return switchRegStateList(data);
							    }
						  } 
            ]
         })
    } 
    
    $('#infaustlKind').on('change',function(){
    	debugger
    	var infaustlKind=$("#infaustlKind").val();
    	if(infaustlKind=="0"){
    		$("#infaustlTypeDiv button").attr("disabled",true);
     	}else {
    		 $("#infaustlTypeDiv button").attr("disabled",false);
    		 //$('#infaustlType').multipleSelect('checkAll'); 
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val(""); 
                $('#favType').multipleSelect('checkAll');
                $('#licZone').multipleSelect('checkAll');
                $('#regState').multipleSelect('setSelects',[$('#regState option[title="CUNXU"]').val()]);
                $('#infaustlType').multipleSelect('checkAll');
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择管辖单位',
                    area: ['25%', '60%'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;	 
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
                     area: ['25%', '60%'],
                     content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                     callback: function (data) {
                    	var returncode=data.returncodes;
                     	var returnname=data.returnname;
                     	$("#regOrg").val(returncode);
                     	$("#regOrgName").val(returnname);
                     }
                 })
            }
        },{
        	el: '#search',
            event: 'click',
            handler: function () {
            	//查询结果显示区域
            	searchParams = $("#taskForm").serializeObject();
             	if(searchFlag=="0"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        },
        {
            el: '#pubopanomalylist_table td',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();  
                 layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content: _sysUrl+'/favorable/favorAbleInfoDetail?uid='+data.uid+"&type=1",
                    callback: function (data) {
                    	 
                    }
                })
            }
        } 
        ]);
    }

})
