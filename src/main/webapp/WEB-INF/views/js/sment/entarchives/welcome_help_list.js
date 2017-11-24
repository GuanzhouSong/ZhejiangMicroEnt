require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

	init();
    var table;
    

    
    /**	
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
    }
    

	function initDataTable() {
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		aLengthMenu: [10, 20,30,40,50],
		ajax : {
			type : "post",
			url : '/sment/rptsmBaseinfo/queryEntAndEntarchivesPageList.json',
			data : function(d) {
				d.params =  $("#entSearchForm").serializeObject();
			}
		},
		buttons:[],
		columns : [
		    {data: '_idx', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'industryCoName', className: 'center'}, 
		    {data : 'estDate', className: 'center'},
		    {data : 'entTypeName', className: 'center'}, 
		    {data : 'regCap', className: 'center'},
		    {data : 'regOrgName',className: 'center'}, 
		    {data : 'localAdmName', className: 'center'},
		    {data : 'empNum',className: 'center'},
		    {data : 'vendInc', className: 'center'},
		    {data : 'helpState',className: 'center'},
		    {data : 'cultivationTypeName',className: 'center'},
		    {data : 'helpTypeNum',className: 'center'}
		],
		columnDefs : [
            {
	          	  targets: 1,
			      render: function (data, type, row, meta) {
			    	  if(data.uniCode && $.trim(data.uniCode) != "null"){
			    		  return data.uniCode;
			    	  }else if(data.regNO && $.trim(data.regNO) != "null"){
			    		  return data.regNO;
			    	  }
			      }
	          },{
	        	  targets: 12,
			      render: function (data, type, row, meta) {
			    	  if("1" == row.helpState){
			    		  return "无需求";
			    	  }else if("2" == row.helpState){
			    		  return "未帮扶";
			    	  }else if("3" == row.helpState){
			    		  return "部分帮扶";
			    	  }else if("4" == row.helpState){
			    		  return "已帮扶";
			    	  }
			      }
	          }]

	  })
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '.look',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	if(priPID!=null && priPID != ''){
            		window.open('/syn/panoramasearch/doEnAppSearchDetails/' + priPID,'_blank');
            	}
            }
        }
        ]);
    }
    

})
