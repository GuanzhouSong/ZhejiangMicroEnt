require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	var table;
	var searchParams={};
	var _urlHead = window._CONFIG._urlHead;
 init();
	 
	 function init(){
		 var tabbale = new Tab($('#cgcs-tab'));
		 var tab = $("#realtab").val();
		 	if(tab=="accept"){
				tabbale.showTab(1);
		 		initAcceptTable();
		 		getAcceptCount();
		 	}else{
				tabbale.showTab(0);
		 		 initDataTable();
				 getSendCount();
		 	}
		 	bind();
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
               {data: null, className: 'center',defaultContent:"1"},
               {data: 'id', className: 'center'},
               {data: 'copyStateName', className: 'center'},
               {data: 'copyTypeName', className: 'center'},
               {data: 'acceptDeptNames', className: 'center'},
               {data: 'illegalItem', className: 'center'},
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
				    		  return "<a href='javascript:void(0)' class='refer'>查看</a><a href='javascript:void(0)' class='edit'>修改</a><a href='javascript:void(0)' class='review'>审核</a>";
				    	  if(row.copyState=='yshth')
				    		  return "<a href='javascript:void(0)' class='edit'>修改</a>";
				    	  return "<a href='javascript:void(0)' class='refer'>查看</a>";
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
	 

	    
	    var accepttable;
		 var acceptsearchParams={};
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
	                {data: '_idx',className: 'center'},
	                {data: 'id',className: 'center'},
	                {data: 'fkState',className: 'center'},
	                {data: 'copyTypeName',className: 'center'},
	                {data: 'acceptDeptNames',className: 'center'},
	                {data: 'illegalItem',className: 'center'},
	                {data: 'copyFormNo', className: 'center'},
	                {data: 'copyInfoFromName', className: 'center'},
	                {data: 'feedbackNeed',className: 'center'},
	                {data: 'copyDate', className: 'center'},
	                {data: 'copyOptDate', className: 'center'},
	                {data: 'copyDepartName', className: 'center'},
	                {data: 'copyDepartPerson', className: 'center'},
	                {data: 'copyDepartTel', className: 'center'},
	                {data: 'copyDepartFax', className: 'center'},
	                {data: 'copyDepartMail', className: 'center'}
		            ],
		            columnDefs: [
					 {
					      targets: 1,
					      render: function (data, type, row, meta) {
					    	  if(row.fkState==0&&row.feedbackNeed==0){
					    		  return "<a href='javascript:void(0);' class='feedback'>处理</a>";
					    	  }
					    	  else{
					    		  return "<a href='javascript:void(0);' class='acceptrefer'>查看</a>";
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
		    
		    //获取抄告统计数据
		    function getSendCount(){
		    	  http.httpRequest({
                      url: _urlHead+'doGetSendCount',
                      serializable: false,
                      data: {},
                      type: 'post',
                      success: function (json) {
                      	if(json.status=="success"){
                      		$("#cgcstotal").text(json.data["total"]);
                      		$("#cgcsdshNum").text(json.data["dshNum"]);
                      		$("#cgcsshthNum").text(json.data["shthNum"]);
                      		$("#cgcsycgfkzNum").text(json.data["ycgfkzNum"]);
                      		$("#cgcsycgfkwcNum").text(json.data["ycgfkwcNum"]);
                      		$("#cgcsqxcgNum").text(json.data["qxcgNum"]);
                      		$("#cgcscgwc").text(json.data["cgwc"]);
	    					}
                      }
                  });
		    }
		    
		    //获取抄送统计数据
		    function getAcceptCount(){
		    	 http.httpRequest({
                     url: _urlHead+'doGetAcceptCount',
                     serializable: false,
                     data: {},
                     type: 'post',
                     success: function (json) {
                     	if(json.status=="success"){
                     		$("#cgcsceeptTotal").text(json.data["acceptTotal"]);
                     		$("#cgcsdfkNum").text(json.data["dfkNum"]);
                     		$("#cgcsyfkNum").text(json.data["yfkNum"]);
	    					}
                     }
                 });
		    }

		    
		 //事件绑定
		    function bind() {
		        util.bindEvents([{
		            el: '#send-search',
		            event: 'click',
		            handler: function() {
		            	clickFlag = true;
		       		 searchParams = $("#sendSearchForm").serializeObject();
		       	     table.ajax.reload();
		            }
		        }, {
		            el: '#add',
		            event: 'click',
		            handler: function() {
		            	window.open(_urlHead+"doAddCopySend?_t="+new Date().getTime(),"_self");
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
		            el: '.edit',
		            event: 'click',
		            handler: function() {
		                var data = table.row($(this).closest('td')).data();
		                window.open(_urlHead+"doEnEdit?copyFormNo="+ encodeURIComponent(data.copyFormNo),"_self");
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
		        } , {
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
		        }, {
		            el: '#sendTab',
		            event: 'click',
		            handler: function() {
		            	if(table==undefined){
		            		initDataTable();
		            	}else{
		            		searchParams = $("#sendSearchForm").serializeObject();
		            		 table.ajax.reload();
		            	}
		            	 $(".clearall").val("");
		            	 getSendCount();
		            	
		            }
		        }, {
		            el: '#acceptTab',
		            event: 'click',
		            handler: function() {
		            	if(accepttable==undefined){
		            		initAcceptTable();
		            	}else{
		            		acceptsearchParams = $("#acceptSearchForm").serializeObject();
		            		accepttable.ajax.reload();
		            	}
		            	getAcceptCount();
		            	$(".acceptclearall").val("");
		            }
		        }])
		    }

})
