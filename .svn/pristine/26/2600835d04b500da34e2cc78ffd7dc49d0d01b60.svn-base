require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http, handlebars) {
	
	var searchParams={};//查询参数声明!
    var table;
    var searchFlag = "0";
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initRegState();
    	initPubType();
        bind();
    }
    
    function initRegState(){
    	$("#regState").append("<option value='K,A,B,X,Q'>存续</option>");
  		$("#regState").append("<option value='C'>撤销</option>");
  		$("#regState").append("<option value='D,DA'>吊销</option>");
  		$("#regState").append("<option value='XX,DX'>注销</option>"); 
       	$("#regState").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
    	//全选
       	$('#regState').multipleSelect('checkAll');
    }
    
    function initPubType(){
    	$("#pubType").append("<option value='1,2,3'>异常名录</option>");
    	$("#pubType").append("<option value='6,7,17'>双随机一公开公告</option>");
    	$("#pubType").append("<option value='4,5'>严重违法失信名单公告</option>");
    	$("#pubType").append("<option value='9,10'>司法协助公告</option>"); 
    	$("#pubType").append("<option value='13,14,15'>其它公告</option>"); 
    	$("#pubType").append("<option value='8'>行政处罚公告</option>"); 
    	$("#pubType").append("<option value='12'>简易注销公告</option>"); 
    	$("#pubType").multipleSelect({
    		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
    	});
    	//全选
    	$('#pubType').multipleSelect('checkAll');
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = "1";
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
			scrollX:true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/yr/bulletins/search.json',
                data:function(d){
                	d.params = searchParams;   	
                }
            },
            columns: [
				{data: null, defaultContent:'id',width:'60px'},
//				{data: null,className: 'center',width:'60px'},
				{data: 'pubTitle',cut: {length: 20,mark:'...'}},
				{data: null,className: 'center',cut: {length: 15,mark:'...'},width:'80px'},
				{data: null,className: 'center',width:'80px'},
				{data: null,className: 'center'},
				{data: 'auditDate',className: 'center'},
				{data: 'uniCode',className: 'center'},
				{data: 'entName',className: 'center'},				
				{data: 'entTypeCatg',className: 'center'},				
				{data: 'regState',className: 'center'},				
				{data: 'setName',className: 'center'},
				{data: 'auditDeptName',className: 'center'},
				{data: 'regOrgName',className: 'center'}
            ],
            fnDrawCallback:function(nRow){
            	initSearchTotal(nRow._iRecordsTotal);
            },
            columnDefs: [
//				{
//				    targets: 1,
//				    render: function (data, type, row, meta) {
//				    	return '<a class="js-see" uid="'+row.uid+'" href="javascript:void(0);" >详情</a>';
//				    }
//				},
				{
				    targets: 2,
				    render: function (data, type, row, meta) {
				    	if(row.pubType == '1' || row.pubType == '2' || row.pubType == '3'){
				    		return "异常名录";
				    	}
				    	if(row.pubType == '6' || row.pubType == '7' || row.pubType == '17'){
				    		return "双随机一公开公告";
				    	}
				    	if(row.pubType == '4' || row.pubType == '5'){
				    		return "严重违法失信名单公告";
				    	}
				    	if(row.pubType == '9' || row.pubType == '10'){
				    		return "司法协助公告";
				    	}
				    	if(row.pubType == '13' || row.pubType == '14' || row.pubType == '15'){
				    		return "其它公告";
				    	}
				    	if(row.pubType == '8'){
				    		return "行政处罚公告";
				    	}
				    	if(row.pubType == '12'){
				    		return "简易注销公告";
				    	}
				    }
				},{
				    targets: 6,
				    render: function (data, type, row, meta) {
				    	if(row.uniCode != null && row.uniCode != ''){
				    		return row.uniCode;
				    	}else{
				    		return row.regNO;
				    	}
				    }
				},{
				    targets: 3,
				    render: function (data, type, row, meta) {
				    	if(row.bulletinWay == '0'){
				    		return '手动发布';
				    	}else{
				    		return '自动发布';
				    	}
				    }
				},{
				    targets: 4,
				    render: function (data, type, row, meta) {
				    	if(row.pubState == '0'){
				    		return '公示';
				    	}else{
				    		return '不公示';
				    	}
				    }
				},{
				    targets: 8,
				    render: function (data, type, row, meta) {
				    	if("11,13,31,33,12,14,32,34,21,27,24,22,28".indexOf(row.entTypeCatg) != -1){
				    		return "企业";
				    	}else if(row.entTypeCatg == '17' || row.entTypeCatg == '16'){
				    		return "农专社";
				    	}else if(row.entTypeCatg == '50'){
				    		return "个体户";
				    	}else{
				    		return "-";
				    	}
				    }
				},{
					targets : 9,
					render : function(data, type, row, meta) {
						 if(row.regState ==null || row.regState =="")return "";
						 if(row.regState=='A' || row.regState=='B' || row.regState=='K' 
							 ||row.regState=='X' || row.regState=='Q')
	            			 return "存续";
	            		 if(row.regState=='XX' || row.regState=='DX') return "注销";
	            		 if(row.regState=='C') return "撤销";
	            		 if(row.regState=='D' || row.regState=='DA') return "吊销";
					}
	           }
            ]
        });
    }
    
    function initSearchTotal(initTotal){
    	$("#distinctTotal,#allTotal").html("").text("加载中...");
    	http.httpRequest({
            url: window._CONFIG.chooseUrl+'/yr/bulletins/searchCount',
            serializable: false,
            data: null,
            type: 'get',
            success: function (data) {
            	if(data != null){
            		$("#distinctTotal").text(data.data);
            		$("#allTotal").text(initTotal);
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

    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	var entCatgArry = new Array();
    	var regState = $('#regState').val();
    	var pubType = $("#pubType").val();
    	$("#taskForm input[name ='entCatg']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	if($("input[name = 'bulletinWay']:checked").length == 2){
    		searchParams.bulletinWay = '';
    	}
    	searchParams.entCatg = (entCatgArry !=null && entCatgArry !='11,13,31,33,12,14,32,34,21,27,24,22,28,16,17,50')?entCatgArry.toString():'';
    	searchParams.regState = (regState !=null && regState!= 'K,A,B,X,Q,C,D,DA,XX,DX')?regState.toString():'';
    	searchParams.pubType = (pubType!=null && pubType !='1,2,3,6,7,17,4,5,9,10,13,14,15,8,12')?pubType.toString():'';
    	console.log(searchParams);
     	if(searchFlag == "0"){
    		initDataTable();
    	}else{
    	    table.ajax.reload();
    	}
    });
    
    function bind() {
    	  util.bindEvents([{
              el: '#choseorgReg',
              event: 'click',
              handler: function () { 
                  layer.dialog({
                      title: '选择登记机关',
                      area: ['400px', '600px'],
                      content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
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
          },{
              el: '#cancel',
              event: 'click',
              handler: function () { 
            	  $("#regOrg").val("");
            	  $('#regState').multipleSelect('checkAll');
            	  $('#pubType').multipleSelect('checkAll');
               }
	      }]);
    }

});
