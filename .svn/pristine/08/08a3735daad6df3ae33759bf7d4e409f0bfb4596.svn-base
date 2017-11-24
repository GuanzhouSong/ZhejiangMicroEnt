require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	 var table;
	 var searchParams={};
	 var _urlHead = window._CONFIG._urlHead;
	 init();
	 
	 function init(){
		 bind();
		 initDataTable();
	 }
	 
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	        var tpl = $('#tpl').html();
	        var template = handlebars.compile(tpl);
	        searchParams = $("#sendSearchForm").serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#cgcs-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                //type : "get",
	                url :  _urlHead+'send/list.json',
	                data : function(d){
                		d.params = searchParams;
	                }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [                
                {data: '_idx', className: 'center'},
                {data: 'id', className: 'center'},
                {data: 'copyStateName', className: 'center'},
                {data: 'copyTypeName', className: 'center'},
                {data: 'acceptDeptNames', className: 'center'},
                {data: 'illegalItem', width: '150px', className: 'center'},
                {data: 'copyFormNo',  className: 'center'},
                {data: 'copyInfoFromName',  className: 'center'},
                {data: 'feedbackNeed', className: 'center'},
                {data: 'copyDate',  className: 'center'},
                {data: 'copyOptDate',  className: 'center'},
                {data: 'copyDepartName',  className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  if(row.copyState=='dsh')
				    		  return "<a href='javascript:void(0)' class='refer'>查看</a><a href='javascript:void(0)' class='review'>审核</a>";
				    	  if(row.copyState=='yshth')
				    		  return "<a href='javascript:void(0)' class='edit'>修改</a>";
				    	  return "<a href='javascript:void(0)' class='refer'>查看</a>";
				      return template(context);
				  }
				}, 
				{
				      targets: 2,
				      render: function (data, type, row, meta) {
				    	   
				    	if(row.copyState=='dsh')
				  			return "协同事务提请申请待审核";
				  		if("yshth"==row.copyState)
				  			return "协同事务提请申请被退回";
				  		if("ycgfkz"==row.copyState)
				  			return "协同事务提请待反馈";
				  		if("ycgfkwc"==row.copyState)
				  			return "协同事务提请已反馈";
				  		if("qxcg"==row.copyState)
				  			return "取消协同事务提请";
				  		if("ycgwc"==row.copyState)
				  			return "协同事务提请已完成";
				  		return null; 
				  }
				}, 
				{
				      targets: 8,
				      render: function (data, type, row, meta) {
				      if(row.feedbackNeed=="0")
				      return "是";
				      if(row.feedbackNeed=="1")
				      return "否";
				      return "";
				 }
				}
				]
	        })
	    }
	 
	  //部门树
	    function selectDepartTree(){
            layer.dialog({
                title: '协同事务提请接收部门',
                area: ['400px', '600px'],
                content: '/common/system/sysdepart/alldeptradiotreeselect',
                callback: function (data) {
                	var adCode = data.adCode;
                	var orgName = data.orgName;
                        $("#acceptDepartName").val(orgName);
                        $("#acceptDepartCode").val(adCode);
                }
            })
	    }
	 
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#send-search',
	            event: 'click',
	            handler: function() {
	            	clickFlag = true;
	       		 searchParams = $("#sendSearchForm").serializeObject();
	       	     table.ajax.reload();
	            }
	        }, {
	            el: '.review',
	            event: 'click',
	            handler: function() {
	                var data = table.row($(this).closest('td')).data();
	                window.open(_urlHead+"doReview?copyFormNo="+ encodeURIComponent(data.copyFormNo),"_self");
	            }
	        }, {
	            el: '.refer',
	            event: 'click',
	            handler: function() {
	                var data = table.row($(this).closest('td')).data();
	                window.open(_urlHead+"doEnRefer?copyFormNo="+ encodeURIComponent(data.copyFormNo),"_self");
	            }
	        }, {
	            el: '#reset',
	            event: 'click',
	            handler: function() {
	                $(".clearall").val("");
	            }
	        }, {
	            el: '#codetree',
	            event: 'click',
	            handler: function() {
	            	selectDepartTree();
	            }
	        }
			])
	    }

})
