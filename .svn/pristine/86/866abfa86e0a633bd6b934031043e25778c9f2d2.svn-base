require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	
	 init();
	 
	 function init(){
		 bind();
		 initDataTable();
	 }
	 
	 var table;
	 var searchParams={};
	 
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	        var tpl = $('#tpl').html();
	        var template = handlebars.compile(tpl);
	        searchParams = $("#searchForm").serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                //type : "get",
	                url :  '/reg/server/registmanage/doGetLimitManageList',
	                data : function(d){
                		d.params = searchParams;
	                }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [                
                {data: '_idx', className: 'center'},
                {data: 'id', className: 'center'},
                {data: 'name', className: 'center'},
                {data: 'linkType', className: 'center'},
                {data: 'regNo', className: 'center'},
                {data: 'entName', width: '150px', className: 'center'},
                {data: 'name',  className: 'center'},
                {data: 'houseAdd',  className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  return "<input value='" + row.priPID + "' name = 'checkboxlist' class='chb checkbox mycheck' type='checkbox' />";
				  }
				}
				]
	        })
	    }
	 
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#search',
	            event: 'click',
	            handler: function() {
	            	searchParams = $("#searchForm").serializeObject();
	            		table.ajax.reload();
	            }
	        }, {
	            el: '.mycheck',
	            event: 'click',
	            handler: function() {
	            	$(".mycheck").not($(this)).removeAttr("checked");
	            }
	        }, {
	            el: '#cancel',
	            event: 'click',
	            handler: function() {
	            	window.history.go(-1);
	            }
	        }, {
	            el: '#adminguide',
	            event: 'click',
	            handler: function() {
	            	var pripid = $(":checkbox[name=checkboxlist]:checked").val();
	            	if(pripid ==undefined){
	            		layer.msg("请您选择一条数据进行行政指导!", {icon: 7,time: 1000});
	            		return false;
	            	}
	            	layer.dialog({
	                    title: '行政指导',
	                    area: ['80%', '90%'],
	                    content: '/reg/server/govguide/govguide/toAdd?fromtype=add&uid=&pripid=' + pripid,
	                    callback: function (data) {
	                    	if(data.type == 'save'){
	                    		layer.msg("行政指导成功!", {icon: 7,time: 1000});	
	                    	}else{
	                    		layer.msg("已取消!", {icon: 7,time: 1000});
	                    	}
	                    	
	                    }
	                })
	            }
	        }, {
	            el: '#reform',
	            event: 'click',
	            handler: function() {
	            	var pripid = $(":checkbox[name=checkboxlist]:checked").val();
	            	if(pripid ==undefined){
	            		layer.msg("请您选择一条数据进行责令整改!", {icon: 7,time: 1000});
	            		return false;
	            	}
	            	
	            	layer.dialog({
	                    title: '责令整改',
	                    area: ['80%', '90%'],
	                    content: '/reg/server/orderreformset/orderReformSetApplyEditPage?pripid='+pripid+"&viewFlag=1"+"&adminGuideType=2",
	                    callback: function (data) { 
	                    	if(data.type == 'save'){
	                    		layer.msg("责令整改成功!", {icon: 7,time: 1000});	
	                    	}else{
	                    		layer.msg("已取消!", {icon: 7,time: 1000});
	                    	}
	                    	
	                    	
	                    }
	                })
	            }
	        }
			])
	    }

})
