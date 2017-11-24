require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	 var table;
	 var searchParams={};
	 var _urlHead = window._CONFIG._urlHead;
	 
	 init();
	 
	 function init(){
		 bind();
		 initDataTable();
	 }
	 
	 function initDataTable(){
		 var tpl = $('#tpl').html();
	     var template = handlebars.compile(tpl);
		 searchParams = $("#sendSearchForm").serializeObject();
		 table = dataTable.load({
			 el: '#cgcs-illegalitems-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                //type : "get",
	                url :  _urlHead+'doGetIllegalItemWeiHuList',
	                data : function(d){
            		d.params = searchParams;
	                }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [                
            {data: null, className: 'center',defaultContent:"1"},
            {data: null, className: 'center'},
            {data: 'unitLevel', className: 'center'},
//            {data: 'unitCode', className: 'center'},
            {data: 'deptCodeName', className: 'center'},
            {data: 'illegalItems', className: 'center'},
            {data: 'setUserName',  className: 'center'},
            {data: 'setTime',  className: 'center'},
	         ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  return "<a href='javascript:void(0)' class='edit'>修改</a><a href='javascript:void(0)' class='delete'>删除</a>";
				  }
				}, 
//				{
//				      targets: 8,
//				      render: function (data, type, row, meta) {
//				      if(row.feedbackNeed=="0")
//				      return "是";
//				      if(row.feedbackNeed=="1")
//				      return "否";
//				      return "";
//				 }
//				}
				]
		 });
	 }
	 
	 //部门树
	    function selectDepartTree(){
         layer.dialog({
             title: '抄告接收部门',
             area: ['400px', '600px'],
             content: '/common/system/sysdepart/alldeptradiotreeselect',
             callback: function (data) {
             	var adCode = data.adCode;
             	var orgName = data.orgName;
                     $("#departName").val(orgName);
                     $("#departCode").val(adCode);
             }
         })
	    }
	function bind(){
		util.bindEvents([
		{
            el: '#codetree',
            event: 'click',
            handler: function() {
            	selectDepartTree();
            }
        },
        {
            el: '#send-search',
            event: 'click',
            handler: function() {
            	searchParams = $("#sendSearchForm").serializeObject();
            	table.ajax.reload();
            }
        },
        {
            el: '#reset',
            event: 'click',
            handler: function() {
                $(".clearall").val("");
            }
        },
        {
            el: '#add',
            event: 'click',
            handler: function() {
            	layer.dialog({title: '添加涉嫌违法事项',area: ['43%', '43%'],
            		content: _urlHead+'doAddAndEditCopySendIllegalItems',
                    callback: function (data) {
                    	table.ajax.reload();
                    }
                })
            }
        },
        {
            el: '.edit',
            event: 'click',
            handler: function() {
            	var data = table.row($(this).closest('td')).data();
            	var id = data.id;
            	layer.dialog({title: '修改涉嫌违法事项',area: ['50%', '50%'],
            		content: _urlHead+'doAddAndEditCopySendIllegalItems?id='+id,
                    callback: function (data) {
                    	table.ajax.reload();
                    }
                })
            }
        },
        {
            el: '.delete',
            event: 'click',
            handler: function() {
            	var data = table.row($(this).closest('td')).data();
            	var id = data.id;
            	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'},function(){
	            	http.httpRequest({
	            		url: _urlHead+'delete?id='+id,
	                    serializable: true,
	                    type: 'post',
	                    success: function (json) {
	                    	if(json.status=="success"){
	    						layer.msg(json.msg, {time: 800}, function() {
	    							table.ajax.reload();
	    						});
	    					}else{
	    						$("#save").attr("disabled",false);
	    						layer.msg(json.msg, {time: 800}, function() {});
	    					}
	                    }
	            	})
            	});
            }
        }
		])
	}
})