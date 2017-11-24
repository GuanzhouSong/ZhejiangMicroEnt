require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	var searchParams=$("#myForm").serializeObject();
	var table;
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	bind();
    	initTable();
    }
	function initTable() {
		table = dataTable.load({
			el : '#user-table',
			showIndex: true,
			scrollX: true,
			lengthMenu: [10, 20, 30,50, 100],
			ajax : {
				type : "post",
				url : '/reg/server/other/pubohterlicence/licenceinvalidjson',
				data : function(d) {
					d.params = searchParams;
				}
			},
	    columns : [
		           {data: '_idx'},
		           {data : 'licState'},
		           {data : "licNameCN"},
		           {data : "licNO"},
		           {data : "licValFrom"},
		           {data : "licValTo"},
		           {data : "licAnth"},
		           {data : null}
		           
			],
		columnDefs : [
					{
			           	 targets:7,
			           	 render:function (data, type, row, meta) {
			           		 return "专项检查主体库";
			           	 }
		             },{
			           	 targets:1,
			           	 render:function (data, type, row, meta) {
			           		 if(row.licState=='1'){
			           			 return "有效";
			           		 }else if(row.licState=='0'){
			           			return "无效";
			           		 }else{
			           			 return "-";
			           		 }
			           	 }
		             }
					],
				  "fnDrawCallback": function (oSettings) {
					  $("#licence").text(oSettings._iRecordsTotal);
		    		}
		  });
	}
	
	 function bind() {
	        util.bindEvents([
	        	{
		            el: '#search',
		            event: 'click',
		            handler: function() {
		        		searchParams = $("#myForm").serializeObject();
	            		table.ajax.reload();
		            }
		        },
	            {
	                el: '.js-fold',
	                event: 'click',
	                handler: function () {
	                    if ($(this).hasClass('reverse')) {
	                        $(this).html('收起详情<i></i>');
	                        $(this).removeClass("reverse");
	                        $(this).addClass("more");
	                        $(".js-table-horizontal").show();
	                    } else {
	                        $(this).html('展开详情<i></i>');
	                        $(this).addClass("reverse");
	                        $(this).addClass("more");
	                        $(".js-table-horizontal").hide();
	                    }
	                }
	            }
	        ]);
	    }
});
