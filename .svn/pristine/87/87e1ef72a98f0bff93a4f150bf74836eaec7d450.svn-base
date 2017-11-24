require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
        
        var taskUID = $("#taskUid").val();
        if(taskUID == 'D1F4D797EFDC480E9B77A4A9B5B01CD5' || taskUID == '4C41AB5D21DC41238A51F4CD3C03D0AA' 
        	|| taskUID == 'BF98C3ED240A4F1D823EE20A1A374A51' || taskUID == 'EE49977C87A248F496E86076D48B231A'){
        	$("#export").show();
        }else{
        	$("#export").hide();
        }
    }
    
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#paramForm").serializeObject();
        table = dataTable.load({
            el: '#info-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url : window._CONFIG.chooseUrl + '/server/sccheck/pubscent/entlist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            		  {data: "_idx"},
            		  {data: null},
            		  {data: 'entName'},
            		  {data: null},
            		  {data: null},
                      {data: 'checkDeptName'},
                      {data: 'checkDeptPerson'},
                      {data: 'checkDate'},
                      {data: null},
                      {data: 'regOrgName',className: 'left'},
                      {data: 'localAdmName',className: 'left'}
            ],
            columnDefs: [{
 					targets:1,
 					render:function(data,type,row,meta){
 						if(row.uniCode){
 							return row.uniCode;
 						}else{
 							return row.regNO;
 						}
 					}
 				 },{
 					targets:3,
 					render:function(data,type,row,meta){
 						if(row.auditState == '2'){
 							return "待审核";
 						}else if(row.auditState == '4'){
 							return "审核不通过";
 						}else if(row.auditState == '5'){
 							return "已公示";
 						}else{
 							return "待录入";
 						}
 					}
 				 },{
 					targets:4,
 					render:function(data,type,row,meta){
 						if(row.auditState == '5' && row.disposeState == '1'){
 							return "未完结";
 						}else if(row.auditState == '5' && row.disposeState == '2'){
 							return "已完结"
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:5,
 					render:function(data,type,row,meta){
 						if(row.checkDeptName){
 							return row.checkDeptName;
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:7,
 					render:function(data,type,row,meta){
 						if(row.checkDate){
 							return row.checkDate;
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:6,
 					render:function(data,type,row,meta){
 						if(row.checkDeptPerson){
 							return row.checkDeptPerson;
 						}else{
 							return "-";
 						}
 					}
 				 },{
 					targets:8,
 					render:function(data,type,row,meta){
 						if(row.checkResult){
							var checkResult = row.checkResult;
							checkResult = checkResult.replace("10","被吊销");
							checkResult = checkResult.replace("11","被撤销");
							checkResult = checkResult.replace("12","迁出");
							checkResult = checkResult.replace("1","未发现违法行为");
							checkResult = checkResult.replace("2","违反工商行政管理相关规定");
							checkResult = checkResult.replace("3","违反食品药品管理相关规定");
							checkResult = checkResult.replace("4","违反质量技术监督相关规定");
							checkResult = checkResult.replace("5","违反其他部门相关规定");
							checkResult = checkResult.replace("6","查无下落");
							checkResult = checkResult.replace("7","已关闭停业或正在清算");
							checkResult = checkResult.replace("8","不予配合情节严重");
							checkResult = checkResult.replace("9","注销");
							return checkResult;
						}else{
							return "-";
						}
 					}
 				 }
             ],
             "fnDrawCallback": function (oSettings) {
             	http.httpRequest({ 
                     url:  window._CONFIG.chooseUrl + '/server/sccheck/pubscent/scEntCountTask',
                     serializable: false,
                     type:'post',
                     data: {params:searchParams} ,
                     success: function (data) {
                     	var pubScentDto = data.data;
                         if (data.status == 'success') {  
     						$("#notinput").text(pubScentDto.writeNum);
     						$("#tocheck").text(pubScentDto.auditNum);
     						$("#checkreturn").text(pubScentDto.backNum);
     						$("#alreadypub").text(pubScentDto.publicNum);
     						$("#notover").text(pubScentDto.unDisposeNum);
                         }else{
                         	$("#notinput").text("0");
     						$("#tocheck").text("0");
     						$("#checkreturn").text("0");
     						$("#alreadypub").text("0");
     						$("#notover").text("0");
                         } 
                     }
                 });
             }
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
		table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([{
	            el: '#close',
	            event: 'click',
	            handler: function () { 
	            	layer.close();
	            }
	        },{
	            el: '#export',
	            event: 'click',
	            handler: function () {
	            	var taskUid = $("#taskUid").val();
	            	window.location.href = '/syn/server/drcheck/specialcheck/downExcel?taskUid='+ taskUid;
	            }
	        }
        ])
    }
})
