require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	var regStateList = [];
	var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
  
    init();
    //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startCogDate', //选择ID为START的input
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
        elem: '#endCogDate',
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
            elem: '#startNorDate', //选择ID为START的input
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
            elem: '#endNorDate',
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
                elem: '#startExtDate', //选择ID为START的input
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
	         elem: '#endExtDate',
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
    $("#startCogDate").click(function(){laydate(start);});
    $("#endCogDate").click(function(){laydate(end);}); 

    $("#startNorDate").click(function(){laydate(startNorDate);});
    $("#endNorDate").click(function(){laydate(endNorDate);});
    
    $("#startExtDate").click(function(){laydate(startExtDate);});
    $("#endExtDate").click(function(){laydate(endExtDate);});
    
    /**
     * 初始化函数集合
     */
    function init() {
    	// 初始化登记状态
    	initRegState();
    	
        bind();
        getRegStateList();
    }
    
    
    function initRegState(){
       	$("#regStateM").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
    	//全选
       	$('#regStateM').multipleSelect('checkAll');
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

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
            "aLengthMenu": [10, 25, 50, 100,1000,2000],
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
            	type : "POST",
                url:window._CONFIG.chooseUrl+'/server/opanomaly/search/hisopasearch.json',
                data:function(d){
                   d.params = $.extend({}, searchParams, {"removePermit":"1","isOpaManageSearchFlag":"01"});
                }
            },
            columns: [ 
                    {data: null,'defaultContent':'11'}, 
                    {data: null,'defaultContent':'11'}, 
                  	{data: 'regState', cut: {length: 20,mark:'...'}},
                 	{data: 'uniSCID',cut: {length: 20,mark:'...'}},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'leRep',cut: {length: 20,mark:'...'}},
    				{data: 'isMove',cut: {length: 20,mark:'...'}},
    				{data: null, width:"250px" ,defaultContent:'id' },
    				{data: 'speCauseCN',cut: {length: 20,mark:'...'}},
    				{data: 'abnTime',cut: {length: 20,mark:'...'}},
     				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
     				{data: null, width:"250px" ,defaultContent:'id' },
    				{data: 'remExcpresCN',cut: {length: 20,mark:'...'}},
    				{data: 'remDate',cut: {length: 20,mark:'...'}},
    				{data: 'reDecOrgCN',cut: {length: 20,mark:'...'}},
    				{data: 'estDate',cut: {length: 20,mark:'...'}},
    				{data: 'dom',cut: {length: 20,mark:'...'}},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}},
    				{data: 'sliceNOName',cut: {length: 20,mark:'...'}}
            ],
            fnDrawCallback:function(nRow){
            	initSearchTotalHtml();
            },
            columnDefs: [   
                         
	                        {
	                             targets: 1,
	                             render: function (data, type, row, meta) {
	                            	return '<a class="viewDetails" entCatgFlag='+row.entCatgFlag+' isMove='+row.isMove+'  busExcList='+row.busExcList+'>详情</a>';
	                             }
	                        },{
	                             targets: 3,
	                             render: function (data, type, row, meta) {
	                            	if(row.uniSCID != null && row.uniSCID != ''){
	                            		return row.uniSCID;
	                            	}else{
	                            		return  row.regNO;
	                            	}
	                             }
	                        },{
								targets :2,
								render : function(data, type, row, meta) {
									return switchRegStateList(row.regState);
								}
				           },{
	                             targets: 4,
	                             render: function (data, type, row, meta) {
	                            	if(row.isErEscApp == '1'){
	                            		return "<span class='yellow-bg'>"+row.entName+"</span>";;
	                            	}else{
	                            		return  row.entName;
	                            	}
	                             }
	                        },{
	                              targets: 6,
	                              render: function (data, type, row, meta) {
	                            	  var entType = $("input[type ='radio']:checked").val();
	                            	  var auditState=row.auditState;
	                                   if (data == null || data == "") {
		                                    return "未移出";
		                               }
	                                   if (data == "1") {
		                                  	if(auditState=="1"){ 
		                                  		 return "已移出";
		                                  	}else{
		                                  		 return "未移出";
		                                  	} 
		                               }
	                                   if (data == "2") {
	                                	  if(entType == "03"){
	                                		if(auditState=="3"){
	                                			return "已更正";
	                                		}else{
	                                			return "未移出";
	                                		} 
	                                	  }else{
                                			if(auditState=="1"){ 
		                                         return "已撤销";
		                                  	}else{
		                                  		 return "未撤销";
		                                    } 
	                                	} 
		                             }
	                             }
	                           },{
	                               targets: 7,
	                               render: function (data, type, row, meta) {
	                            	   if(row.penDecNo == null || row.penDecNo ==""){
	                            		   return "-";
	                            	   }
	                            	   return  '<a class="printspbook link" id="'+row.busExcList+'" priPID="'+row.priPID+'" href="javascript:void(0);" style="color:blue;">'+row.penDecNo+'</a>';
	                               }
	                            },{
	                               targets: 11,
	                               render: function (data, type, row, meta) {
	                            	   if(row.canOutPenDecNo == null || row.canOutPenDecNo ==""){
	                            		   return "-";
	                            	   }
	                            	   return  '<a class="printspbook2 link" id="'+row.busExcList+'" priPID="'+row.priPID+'" href="javascript:void(0);" style="color:blue;">'+row.canOutPenDecNo+'</a>';
	                               }
	                            }
	                 ]
         })
    }
    
    $("#moresearch").click(function(){
    	var entType = $("input[type ='radio']:checked").val();
    	if($(this).attr("status") == '0'){
    		if(entType == '03'){
    			$(".yearhis").hide();
    		}else{
    			$(".yearhis").show();
    		}
    		$(".moresearch_oth").show();
    		$(this).val("收起").attr("status",'1');
    	}else{
    		$(".moresearch_oth").hide();
    		$(this).val("更多查询条件").attr("status",'0');
    	}
    })
    $("input[type ='radio']").click(function(){
    	if($(this).prop('checked')){
    		if($(this).val() == '03'){
    			$(".yearhis").hide();
    		}else{
    			$(".yearhis").show();
    		}
    	}
    })
    
        // 结果统计
    $("#countResult").click(function(){
    	initSearchTotal();
    })
    
    function initSearchTotal(){
    	var entType = $("input[type ='radio']:checked").val();
    	$("#countAll,#disCountAllTotal,#noShiftOutAll,#disNoShiftOutTotal" +
		",#shiftOutCount,#disShiftOutTotal,#changeOutCount,#disChangeOutTotal").html("").text("加载中...");
    	http.httpRequest({
            url: window._CONFIG.chooseUrl+'/server/opanomaly/search/searchCount',
            serializable: false,
            data: null,
            type: 'get',
            success: function (data) {
            	if(data != null){
            		$("#countAll").text(data.data[0].countAll);
                	$("#disCountAllTotal").text(data.data[0].disCountAllTotal);
                	$("#noShiftOutAll").text(data.data[1].countAll==null?"0":data.data[1].countAll);
                	$("#disNoShiftOutTotal").text(data.data[1].disCountAllTotal==null?"0":data.data[1].disCountAllTotal);
                	$("#shiftOutCount").text(data.data[2].countAll==null?"0":data.data[2].countAll);
                	$("#disShiftOutTotal").text(data.data[2].disCountAllTotal==null?"0":data.data[2].disCountAllTotal);
            		$("#changeOutCount").text(data.data[3].countAll==null?"0":data.data[3].countAll);
                	$("#disChangeOutTotal").text(data.data[3].disCountAllTotal==null?"0":data.data[3].disCountAllTotal);
            	}
            },
    	   error:function (jqXHR, textStatus, errorThrown) {
    		   if (unAuthError(jqXHR, textStatus, errorThrown)) {
                   return;
               }
               if (options.error) {
                   options.error();
               } else {
               }
    	   }
        })
    }
    
    function initSearchTotalHtml(){
    	$("#countAll,#disCountAllTotal,#noShiftOutAll,#disNoShiftOutTotal" +
		",#shiftOutCount,#disShiftOutTotal,#changeOutCount,#disChangeOutTotal").html("").text("0");
    }
    
    function bind() {
        util.bindEvents([{
            el: '.printspbook',
            event: 'click',
            handler: function () {
             	var busExcList=this.id;
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = window._CONFIG.chooseUrl+"/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+busExcList;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },{
            el: ".printspbook2",
            event: 'click',
            handler: function () { 
          	  var busExcList=this.id;
           	  var _id = "_doPrint_"+new Date().getTime();
                var url = window._CONFIG.chooseUrl+"/server/opadetail/pubopadetail/opadetailBookPrint?busExcList="+busExcList;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },{
            el: '.viewDetails',
            event: 'click',
            handler: function () {
            	 var busExcList = $(this).attr("busExcList");
            	 var entCatgFlag = $(this).attr("entCatgFlag");
            	 var isMove = $(this).attr("isMove");
            	 var width,height;
            	 var url;
            	 if(entCatgFlag == '1'){
            		 url = window._CONFIG.chooseUrl+"/server/opanomaly/pubopanomaly/pubOpanoMalySearchViewPage?busExcList="+busExcList;
            		 width = '80%';
            		 height = '88%';
            	 }else{
            		 width = '80%';
            		 height = '85%';
            		 url = '/reg/server/opanomaly/pbopanomaly/pbopanomalyDetail?busExcList='+busExcList;
            		 if(isMove == '1' || isMove == '2'){
            			 url = '/reg/server/opanomaly/pbopadetail/opadetail?busExcList='+busExcList;
            			 height = '98%';
            		 } 
            	 }
             	 layer.dialog({
                    title: '经营异常状态查询详情',
                    area: [width, height],
                    content: url,
                    callback: function (data) {
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#remExcpres").val("");
                $("#speCause").val("");
                $("#entTypeCode").val("");
                $("#sliceNO").val("");
                $("#industryCo").val("");
                $('#regStateM').multipleSelect('checkAll');
            }
        } ,{
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
        	el: '#chooseSliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择责任区',
                    area: ['25%', '60%'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNoName").val(data.returnname);  
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
            el: '#select-intercept',
            event: 'click',
            handler: function () {
            	var codeList;
            	var entType = $("input[type ='radio']:checked").val();
            	if(entType == '01'){
            		codeList = 'outCodeForEntList';
            	}else if(entType == '02'){
            		codeList = 'outCodeForSfcList';
            	}else if(entType == '03'){
            		codeList = 'outCodeForPbList';
            	}
                layer.dialog({
                    title: '移出原因',
                    area: ['600px', '350px'],
                    content: '/commom/server/intercept/interceptselect?selecttype='+codeList,
                    callback: function (data) {
                        if(data){
                            $("#remExcpres").val(data.id);
                            $("#remExcpresText").val(data.text);
                        }
                    }
                })
            }
        }, {
            el: '#select-intercept_in',
            event: 'click',
            handler: function () {
            	var codeList;
            	var entType = $("input[type ='radio']:checked").val();
            	if(entType == '01'){
            		codeList = 'inCodeForEntList';
            	}else if(entType == '02'){
            		codeList = 'inCodeForSfcList';
            	}else if(entType == '03'){
            		codeList = 'inCodeForPbList';
            	}
                layer.dialog({
                    title: '列入原因',
                    area: ['600px', '350px'],
                    content: '/commom/server/intercept/interceptselect?selecttype='+codeList,
                    callback: function (data) {
                        if(data){
                            $("#speCause").val(data.id);
                            $("#speCauseText").val(data.text);
                        }
                    }
                })
            }
        },{
        	el: '#search',
            event: 'click',
            handler: function () { 
            	//登记状态
        		var regStateM = $("#regStateM").val();
        		if(regStateM.toString() != 'A,B,K,Q,X,C,D,DA,QX,XX,DX'){
        			$("#regState").val(regStateM);
        		}
            	//查询结果显示区域
            	searchParams = $("#taskForm").serializeObject();
            	var checkArry=new Array();
            	if($("#remType input[type='checkbox']:checked").length == 2){
            		searchParams.shiftOutType = '2';
            	}
             	if(searchFlag=="0"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        }
        ]);
    }

})
