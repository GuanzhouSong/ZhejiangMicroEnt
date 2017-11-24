require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','pagination'], function (layer, dataTable, util, http,handlebars) {
	var searchParams=$("#myForm").serializeObject();
	var table1;
	var table2;
	var table3;
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	bind();
    	initTable1();
    	initTable2();
    	initTable3(0);
    }
	function initTable1() {
		table1 = dataTable.load({
			el : '#user-table1',
			showIndex: true,
			scrollX: true,
			lengthMenu: [10, 20, 30,50, 100],
			ajax : {
				type : "post",
				url : '/midinv/list.json',
				data : function(d) {
					d.params = searchParams;
				}
			},
	    columns : [
		           {data: '_idx'},
		           {data : 'invType'},
		           {data : "inv"},
		           {data : "cerType"},
		           {data : "cerNO"},
		           {data : null}
		           
			],
		columnDefs : [{
			           	 targets:1,
			           	 render:function (data, type, row, meta) {
			           		if(row.invType == 1){
		                	   return '企业法人';
		                    } else if(row.invType == 2){
		                	   return '自然人';
		                    } else if(row.invType == 3){
		                	   return '其他股东';
		                    } else{
		                    	return "";
		                    }
			           	 }
		             },{
			           	 targets:3,
			           	 render:function (data, type, row, meta) {
			           		if(row.invType == 1){
		                		return "法人营业执照"
		                    }else if(row.invType == 2){
		                    	return row.cerTypeName;
		                    }else if(row.invType == 3){
		                    	return "其他";
		                    }else{
		                    	return "";
		                    }
			           	 }
		             },{
			           	 targets:4,
			           	 render:function (data, type, row, meta) {
			           		if(row.invType == 1){
		                		return row.uniSCID != null ? row.uniSCID : row.bLicNO;
		                    }else if(row.invType == 2){
		                    	return row.cerNO;
		                    }else if(row.invType == 3){
		                    	return row.bLicNO;
		                    }else{
		                    	return "";
		                    }
			           	 }
		             },{
			           	 targets:5,
			           	 render:function (data, type, row, meta) {
			           		return "<a href='javascript:void(0);' id='"+row.id+"' class='js-gudong-view'>查看</a>";
			           	 }
		             }
					],
				  "fnDrawCallback": function (oSettings) {
					  $("#midinv").text(oSettings._iRecordsTotal);
		    		}
		  });
	}
	
	function initTable2() {
		table2 = dataTable.load({
			el : '#user-table2',
			showIndex: true,
			scrollX: true,
			lengthMenu: [10, 20, 30,50, 100],
			ajax : {
				type : "post",
				url : '/reg/server/yr/subcapital_server/list.json',
				data : function(d) {
					d.params = searchParams;
				}
			},
	    columns : [
		           {data: '_idx'},
		           {data : 'inv'},
		           {data : "lisubconam"},
		           {data : "subConDate"},
		           {data : "conFormCN"},
		           {data : "liacconam"},
		           {data : "acConDate"},
		           {data : "acConFormCn"}
		           
			],
		columnDefs : [
					],
				  "fnDrawCallback": function (oSettings) {
					  $("#ycinv").text(oSettings._iRecordsTotal);
					  initTotal();
		    		}
		  });
	}
	
	 function initTotal(){
		 var priPID=$("#priPID").val();
         http.httpRequest({
             url: "/reg/server/invmanager/yrinfo?priPID="+priPID,
             serializable: true,
             type: 'post',
             success: function (data) {
             	if(data!=null){
             		var yrinfo = data.data;
             		$("#year").text(yrinfo.year==null?'':yrinfo.year);
             		$("#ycdate").text(yrinfo.ycdate==null?'':yrinfo.ycdate);
             	}
             }
         });
     }
	
	function initTable3(page) {
        var length=5;
        http.httpRequest({
            url: '/im/pub/investalter/investmentListJSON',
            serializable: false,
            data: {
                "pageNum": page,
                "priPID": $("#priPID").val(),
                length: length,
                params: {"pageNum": page}
            },
            success: function (data) {
                if (data.data == "" || data.data == null) {//如果没有
                    $('#tplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>没有匹配结果</td>");
                    return false;
                }

                if (page == 0) {
                    page = page;
                } else {
                    page = page - 1;
                }

                var showPage = data.recordsTotal;
                $('#pageinvestment').pagination(showPage, {//分页工具
                    callback: pageInvesMentCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });

                $("#investmentCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#investmentPageCount").text(totalPages);

                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) {
                        //返回+1之后的结果
                        if (page >= 0) {
                            var toIn = ((page) * 5);

                            return index + 1 + toIn;
                        } else {
                            return index + 1;
                        }
                    });
                handlebars.registerHelper("trsPubFlag",
                    function (value) {
                        if (value == "1") {
                            return "公示";
                        } else {
                            return "未公示";
                        }
                    });


                var myTemplate = handlebars.compile($("#investment-template").html());
                handlebars.registerHelper("transDate",
                    function (value) {
                		if(value){
                			var date = value.split("-");
                			return date[0] + "年" + date[1] + "月" + date[2] + "日";
                		}
                    });
                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0){
                	  $('#investment').html(myTemplate(data));
                	  $("#iminv").text(data.recordsTotal);
                }

            }
        })


    }
	
	function pageInvsraCallback(page, jq) {//翻页事件
        initDataInvsraTable(page + 1);
    }

    function pageInvesMentCallback(page, jq) {//翻页事件
        initDataInvestmentTable(page + 1);
    }


    function pagePermitCallback(page, jq) {//翻页事件
        initPermitTable(page + 1);
    }

    function pageIppldgCallback(page, jq) {//翻页事件

        initIppldgTable(page + 1);
    }

    function pageCaseCallback(page, jq) {//翻页事件
        initCaseTable(page + 1);
    }
	
	 function bind() {
	        util.bindEvents([
	        	{
		            el: '.js-gudong-view',
		            event: 'click',
		            handler: function() {
		            	var id = $(this).attr("id");
		            	var currencyCn = $("#currencyCn").val();
		            	layer.dialog({
	                        title: '详情',
	                        area: ['60%', '90%'],
	                        content:'/midinv/findMidInvById?midInvId=' + id+'&currencyCn='+currencyCn,
	                        callback: function (data) {
	                            if (data.reload) { 
	                            	 table1.ajax.reload();  
	                            }
	                        }
	                    })
		            }
		        },
                {
                    el: ".showInvesment",
                    event: 'click',
                    handler: function () {
                        var priPID = $("#priPID").val(); 
                        layer.dialog({
                            title: '股东及出资详情',
                            area: ['90%', '60%'],
                            content:"/reg/server/iminfo/showInvestment?invID=" + this.id + "&priPID=" + priPID,
                    
                        }) }
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
