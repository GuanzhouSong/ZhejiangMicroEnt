require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination'], function (layer, dataTable, util, http,handlebars) {
	
	var params = $("#hx-form").serializeObject();
	var table;
	init();
	
	function init(){
		initDataTable();
    	bind();
	}
	
	function initDataTable(){
		table = dataTable.load({
			el : '#qyfxbs_table',
			showIndex: true,
			lengthMenu: [ 5, 10, 20, 50],
			ajax : {
				url : '/syn/panoramasearch/doGetCsConcernObjList.json' ,
				data :function(d){
					d.params = params;
				}
			},
			columns : [
				{data: '_idx', className: 'center'},
				{data: 'markName', className: 'center'},
				{data: 'markStartDate', className: 'center'},
				{data: 'markEndDate', className: 'center'},
				{data: 'checkPeople', className: 'center'},
				{data: 'checkDate', className: 'center'},
				{data: 'checkState', className: 'center'}
			],
			columnDefs : [{
		    	targets: 6,
			      render: function (data, type, row, meta) {
			    	  if(row.checkState == 0)
			    		  return "未通过";
			    	  if(row.checkState == 1)
			    		  return "通过";
			    	  if(row.checkState == 2)
			    		  return "未审核";
			    	  if(row.checkState == 3)
			    		  return "审核退回";
			    	  else
			    		  return "";
			      }
		    }]
		  });
		
	}
	
	 function bind(){
	    	util.bindEvents([
	    	{//tab页面加载
	            el: '#cancel',
	            event: 'click',
	            handler: function () {
	            	layer.close();
	            }
	        }
	    	])
	    }
});