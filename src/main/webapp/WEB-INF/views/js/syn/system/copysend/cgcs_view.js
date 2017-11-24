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
				    	  return "<a href='javascript:void(0)' class='refer'>查看</a>";
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
                title: '抄告接收部门',
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
