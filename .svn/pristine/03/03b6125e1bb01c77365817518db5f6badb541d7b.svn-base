require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	bind();
    	initReasonDataTable();
    	initRelateDataTable();
    }
	function initReasonDataTable() {
		dataTable.load({
		el : '#reason-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : window._CONFIG.chooseUrl+'/server/other/blacklist/rightbackList',
			data : function(d) {
				d.params = $("#entSearchForm").serializeObject();
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data : 'limitTypeName', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'limitNO', className: 'center'},
		    {data : "limitDepartName", className: 'center'},
		    {data : 'limitReason', className: 'center',cut:{length:"20",mark:"..."}},
		    {data : "limitDateStart", className: 'center'},
		    {data : "limitDateEnd", className: 'center'},
		    {data : null, className: 'center'},
		    {data : null, className: 'center'},
		    {data : null, className: 'center'},
		    {data : null, className: 'center'}
		], 
		columnDefs : [
					{
						targets : 2,
						render : function(data, type, row, meta) {
							if(row.entName){
								return "<a href='javascript:void(0)' class='mr10 look' priPID='"+row.priPIDDesc+"'>"+ row.entName+"</a>";
							}else{
								return '-';
							}
						}
					},{
						targets : 3,
						render : function(data, type, row, meta) {
							if(row.uniscid){
								return row.uniscid;
							}else if(row.regNO){
								return row.regNO;
							}else{
								return '-';
							}
						}
					},{
						targets : 9,
						render : function(data, type, row, meta) {
							if(row.limitDateEnd){
								 var sysdate=$("#sysdate").val();  
								 var limitDateEnd=row.limitDateEnd;  
								 if(sysdate!=""&&limitDateEnd!=""){  
									 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
									 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
									 if(d1 > d2){
										 return "已解除";
									 }else{
										 return "未解除"
									 }
								 }
							}
							return '';
						}
					},{
						targets : 10,
						render : function(data, type, row, meta) {
							return "";
						}
					},{
						targets : 11,
						render : function(data, type, row, meta) {
							return "";
						}
					},{
						targets : 12,
						render : function(data, type, row, meta) {
							return "";
						}
					}],
					"fnDrawCallback": function (oSettings) {
		    			 $("#reason").text(oSettings._iRecordsTotal);
		    		}
	  });
	}
	function initRelateDataTable() {
		dataTable.load({
			el : '#relate-table',
			showIndex: true,
			scrollX: true,
			lengthMenu: [10, 20, 30,50, 100 ],
			ajax : {
				type : "post",
				url : window._CONFIG.chooseUrl+'/server/other/blacklist/midbackList',
				data : function(d) {
					d.params = $("#entSearchForm").serializeObject();
				}
			},
	    columns : [
		           {data: '_idx', className: 'center'},
		           {data : null, className: 'center'},
		           {data : "entName", className: 'center'},
		           {data : "leRep", className: 'left'},
		           {data : "estDate", className: 'center'},
		           {data : "positionName", className: 'center'},
		           {data : "regOrgName", className: 'center'},
		           {data : "localAdmName", className: 'center'},
		           {data : "regState", className: 'center'}
			],
		columnDefs : [
					{
						targets : 1,
						render : function(data, type, row, meta) {
							if(row.regNO != "" && row.regNO != null){
							    return row.regNO;
							}else{
								return row.uniCode;
							}
						}
				  },{
						targets : 2,
						render : function(data, type, row, meta) {
							return "<a href='javascript:void(0)' class='mr10 look' priPID='"+row.priPIDDesc+"'>"+ row.entName+"</a>";
						}
				  },{
					targets : 8,
					render : function(data, type, row, meta) {
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
			  	}],
				  "fnDrawCallback": function (oSettings) {
		    			 $("#relate").text(oSettings._iRecordsTotal);
		    		}
		  });
	}
	
	 function bind() {
	        util.bindEvents([{
	            el: '.look',
	            event: 'click',
	            handler: function () {
	            	var priPID = $(this).attr("priPID");
	            	if(priPID!=null && priPID != ''){
	            		window.open('/syn/panoramasearch/doEnAppSearchDetails/' + priPID,'_blank');
	            	}
	            }
	        }]);
	    }
});
