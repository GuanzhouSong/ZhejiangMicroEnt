require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	var accepttable;
	var acceptsearchParams={};
	var _urlHead = window._CONFIG._urlHead;
	
	 init();
	 
	 function init(){
		 initAcceptTable();
		 acceptbind();
	 }
	 
	    /**
	     * 初始化dataTable
	     */
	    function initAcceptTable() {
	        var accept_tpl = $('#accept_tpl').html();
	        var template = handlebars.compile(accept_tpl);
	        acceptsearchParams = $("#acceptSearchForm").serializeObject();
	        accepttable = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#accept-cgcs-table',
	            scrollX:true,
	            showIndex: true,
	            ajax : {
	                //type : "get",
	                url :  _urlHead+'accept/list.json',
	                data : function(d){
	                	d.params = acceptsearchParams;
		            }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [
                {data: '_idx', width:'50px',className: 'center'},
                {data: 'id', width:'50px',className: 'center'},
                {data: 'fkState',width:'50px',className: 'center'},
                {data: 'copyTypeName',width:'80px',className: 'center'},
                {data: 'acceptDeptNames',width:'50px',className: 'center'},
                {data: 'illegalItem', width: '150px',className: 'center'},
                {data: 'copyFormNo',  width:'50px',className: 'center'},
                {data: 'copyInfoFromName', width:'150px', className: 'center'},
                {data: 'feedbackNeed', width:'150px',className: 'center'},
                {data: 'copyDate',  width:'150px',className: 'center'},
                {data: 'copyOptDate',  width:'150px',className: 'center'},
                {data: 'copyDepartName', width:'150px', className: 'center'},
                {data: 'copyDepartPerson',  width:'150px',className: 'center'},
                {data: 'copyDepartTel',  width:'150px',className: 'center'},
                {data: 'copyDepartFax', width:'150px', className: 'center'},
                {data: 'copyDepartMail', width:'150px', className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  if(row.fkState==0&&row.feedbackNeed==0){
				    		  return "<a href='javascript:void(0)' class='feedback'>处理</a>";
				    	  }
				    	  else{
				    		  return "<a href='javascript:void(0)' class='acceptrefer'>查看</a>";
				    	  }
				      return template(context);
				  }
				}, 
				{
				      targets: 2,
				      render: function (data, type, row, meta) {
				    	  if(row.fkState==0&&row.feedbackNeed==1)
				    		  return "已接收";
				    	  if(row.fkState==0&&row.feedbackNeed==0)
				    		  return "待反馈";
				    	  if(row.fkState==1)
				    		  return "已反馈";
				      return template(context);
				  }
				},
				{
				      targets: 8,
				      render: function (data, type, row, meta) {
				      if(row.feedbackNeed=="0")
				      return "是";
				      if(row.feedbackNeed=="1")
				      return "否";
				      else
				    	  return "";
				 }
				}
				]
	        })
	    }
	 
	 
	    //部门树
	    function acceptSelectDepartTree(){
            layer.dialog({
                title: '抄告发起部门',
                area: ['400px', '600px'],
                content: '/common/system/sysdepart/alldeptradiotreeselect',
                callback: function (data) {
                	var adCode = data.adCode;
                	var orgName = data.orgName;
                	var dutyCodes = data.dutyCodes;
                   	if(dutyCodes.indexOf("A058")>=0){
                   		dutyCodes = "A058";
                   	}else{
                   		dutyCodes = "1234";
                   	}
                        $("#acceptCopyDepartName").val(orgName);
                        $("#acceptCopyDepart").val(adCode);
                        $("#dutyCodes").val(dutyCodes);
                }
            })
	    }
	    
	 //事件绑定
	    function acceptbind() {
	        util.bindEvents([{
	            el: '#accept-search',
	            event: 'click',
	            handler: function() {
	            	clickFlag = true;
	    	    	acceptsearchParams = $("#acceptSearchForm").serializeObject();
	    		    accepttable.ajax.reload();
	            }
	        }, {
	            el: '.feedback',
	            event: 'click',
	            handler: function() {
	            	 var data = accepttable.row($(this).closest('td')).data();
		             window.open(_urlHead+"doEnFeedback?copyFormNo="+ encodeURIComponent(data.copyFormNo),"_self");
	            }
	        }, {
	            el: '.acceptrefer',
	            event: 'click',
	            handler: function() {
	                var data = accepttable.row($(this).closest('td')).data();
	                window.open(_urlHead+"doEnRefer?copyFormNo="+ encodeURIComponent(data.copyFormNo),"_self");
	            }
	        }, {
	            el: '#acceptreset',
	            event: 'click',
	            handler: function() {
	                $(".acceptclearall").val("");
	            }
	        }, {
	            el: '#acceptcodetree',
	            event: 'click',
	            handler: function() {
	            	acceptSelectDepartTree();
	            }
	        }])
	    }

})
