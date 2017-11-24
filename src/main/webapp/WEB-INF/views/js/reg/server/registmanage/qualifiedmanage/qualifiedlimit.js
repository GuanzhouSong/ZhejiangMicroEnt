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
                {data: 'limitDateEnd',  className: 'center'}
//                {data: '案件详情',  className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  return "<input priPID='"+row.priPID+"' certType='"+row.certType+"' value='" + row.certNO + "' name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
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
	            el: '#limitmanage',
	            event: 'click',
	            handler: function() {
	            	var ids=new Array();
	            	var priPIDs=new Array();
	                $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
	                	var me = $(this);
	                	var certType = me.attr("certType");
	                	if(certType == 0)
	                		priPIDs.push(me.attr("priPID"));
	                	if(certType != 0)
	                		ids.push(this.value);
//	                		ids.push('"'+this.value+'"');
	                });
	                if(!ids[0]&&!priPIDs[0]){
	                    layer.msg("请您至少选择一条进行限制管理!", {icon: 7,time: 1000});
	               	 return false;
	                }
	                window.open("/reg/server/registmanage/doEnLimitManage?ids="+ids.toString()+"&priPIDs="+priPIDs.toString(),"_self");
	                
	            }
	        }
			])
	    }

})
