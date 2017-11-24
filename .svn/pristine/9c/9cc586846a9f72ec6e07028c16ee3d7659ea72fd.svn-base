require(['component/iframeLayer','layer1','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,layer1,dataTable, util, http,handlebars) {
	var table;
	var searchParams={};
	
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
	        searchParams = $("#searchForm").serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                //type : "get",
	                url :  '/reg/server/registmanage/doGetQualifiedLimitList',
	                data : function(d){
                		d.params = searchParams;
	                }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [                
                {data: '_idx', className: 'center'},
                {data: 'id', className: 'center'},
                {data: 'clientName', className: 'center'},
                {data: 'certTypeName', className: 'center'},
                {data: 'certNO', className: 'center'},
                {data: 'limitTypeName', width: '150px', className: 'center'},
                {data: 'limitDateStart',  className: 'center'},
                {data: 'limitDateEnd',  className: 'center'},
                {data: 'changeTime',  className: 'center'},
                {data: 'changePerson',  className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  return "<input value='" + row.uid + "' limitDateStart = '"+ row.limitDateStart +"' name = 'checkboxlist' class='chb checkbox mycheck' type='checkbox' />";
				  }
				}
				]
	        })
	        
	    }
	 
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#qua-search',
	            event: 'click',
	            handler: function() {
	            	searchParams = $("#searchForm").serializeObject();
	            	if(table==undefined){
	            		 initDataTable();
	            	}else{
	            		table.ajax.reload();
	            	}
	            }
	        }, {
	            el: '#limitremove',
	            event: 'click',
	            handler: function() {
	            	var ids= $(":checkbox[name=checkboxlist]:checked").val();
	                if(ids ==""||ids ==null){
	                    layer.msg("<em style='color: red;'>请选择解除限制的企业！</em>", {icon: 7,time: 1000});
	               	 return false;
	                }
	                $("#uid").val(ids);
	                layer1.open({
	                    shade: [0.1,'#fff'],
	                    type: 1,
	                    content: $('#aheadremove'),
	                    title: false,
	                    area: ['350px','210px']
	                })
	                
	            }
	        }, {
	            el: '#save',
	            event: 'click',
	            handler: function() {
	            	var limitDateStart = $(":checkbox[name=checkboxlist]:checked").attr("limitDateStart");
	            	if($("#endtime").val()==""){
	            		layer.msg("请选择解除日期！", {time: 1000}, function () {});
	            		return false;
	            	}
	            	if(new Date(limitDateStart).getTime()>new Date($("#endtime").val()).getTime()){
	            		layer.msg("限制解除日期小于限制开始日期！", {time: 1000}, function () {});
	            		return false;
	            	}
	            	searchParams = $("#ahead_form").serializeObject();
	            	http.httpRequest({
                        url: '/reg/server/registmanage/doUpdateQualificationLimit',
                        data: searchParams,
                        success: function (data) {
                            if (data.status == 'success') {
                            	layer1.closeAll();
                            	$(".needclear").val("");
                            	 table.ajax.reload();
                            }
                            layer.msg(data.msg, {time: 1000}, function () {});
                        }
                    });
	            }
	        }, {
	            el: '#cancle',
	            event: 'click',
	            handler: function() {
		            	$(".needclear").val("");
	            	layer1.closeAll();
	            }
	        }, {
	            el: '.mycheck',
	            event: 'click',
	            handler: function() {
	            	$(".mycheck").not($(this)).removeAttr("checked");
	            }
	        }
			])
	    }

})

