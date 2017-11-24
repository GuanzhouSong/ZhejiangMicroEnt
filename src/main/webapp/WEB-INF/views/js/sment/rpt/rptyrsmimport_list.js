require(['component/iframeLayer', 'layer1','component/dataTable', 'common/util', 'common/http', 'handlebars', 
         'jquery','jquery.serialize','laydate','jquery.multiselect','dataTableShow'], function (layer, layer1,dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    init(); 
    /**
     * 初始化函数集合
     */
    function init() {
    	inityear();
        initDataTable();
        bind();
		tableReload(table);
        }
	
	function inityear(){
        //自动生成年度
        var _thisYear =  window._CONFIG.year-1;
        for (; 2013 <= _thisYear; _thisYear--) {
     		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
        };
	}
	
	function areacodeList(str){
		if(str == "3300"){
			return "省局";
		}else if(str == "3301"){
			return "杭州";
		}else if(str == "3302"){
			return "宁波";
		}else if(str == "3303"){
			return "温州";
		}else if(str == "3304"){
			return "嘉兴";
		}else if(str == "3305"){
			return "湖州";
		}else if(str == "3306"){
			return "绍兴";
		}else if(str == "3307"){
			return "金华";
		}else if(str == "3308"){
			return "衢州";
		}else if(str == "3309"){
			return "舟山";
		}else if(str == "3310"){
			return "台州";
		}else if(str == "3325"){
			return "丽水";
		}else{
			return "";
		}
	}
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
        	 //需要初始化dataTable的dom元素
            el: '#user-table',
            "bPaginate" : false,
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/sment/rptsmBaseinfo/rptYrSmImportCount.json',
                //async: false,
                data:function(d){
                	d.params = searchParams;               		
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'year'}, 
                {data: 'industryCoName',className: 'right'},
//                {data: 'entTypeCatgName',className: 'right'},
                {data: 'entTypeName',className: 'right'},
                {data: 'regOrgName',className: 'right'},
                {data: 'isRptCount',className: 'right'},
                {data: 'yreportRay',className: 'right'},
                {data: 'busstatus',className: 'right'},
                {data: 'busstatusRay',className: 'right'},
                {data: 'vendInc',className: 'right'},
                {data: 'assGro',className: 'right'},
                {data: 'fixAssets',className: 'right'},
                {data: 'liaGro',className: 'right'}, 
                {data: 'assliaRay',className: 'right'}, 
                {data: 'proGro',className: 'right'}, 
                {data: 'netInc',className: 'right'}, 
                {data: 'addProCount',className: 'right'}, 
                {data: 'minuProCount',className: 'right'}, 
                {data: 'ratGro',className: 'right'}, 
                {data: 'empNum',className: 'right'}, 
                {data: 'rptCount',className: 'right'} 
           ],
            columnDefs: [                     
						{
							targets: 1,
						    render: function (data, type, row, meta) {
						    	  if(data!=null&&data!=""){
                                      return data;
						    	  }else{
						    		  return ""; 
						    	  }
						    }
						},
						{
							targets: 2,
						    render: function (data, type, row, meta) {
						    	  if(data!=null&&data!=""){
						    		  if(data == '0'){
						    			  return "全部";
						    		  }
						    		  else if(data == '1'){
						    			  return "信息产业";
						    		  }else if(data == '2'){
						    			  return "环保产业";
						    		  }
							    	  else if(data == '3'){
							    		  return "旅游产业";
							    	  }
							    	  else if(data == '4'){
							    		  return "金融产业";
							    	  }
							    	  else if(data == '5'){
							    		  return "健康产业";
							    	  }
							    	  else if(data == '6'){
							    		  return "时尚产业";
							    	  }
							    	  else if(data == '7'){
							    		  return "高端制造业";
							    	  }
						    		  else if(data == '8'){
						    			  return "文化产业 ";
						    		  }else{
	                                      return data; 
						    		  }
						    	  }else{
						    		  return ""; 
						    	  }
						    }
						},
//						{
//							targets: 3,
//							render: function (data, type, row, meta) {
//								if(data!=null&&data!=""){
//									var str = data.replace("1","上市");
//									str = str.replace("2","股份有限公司");
//									str = str.replace("3","国有");
//									str = str.replace("4","控股");
//									str = str.replace("5","独资");
//									str = str.replace("6","内资");
//									str = str.replace("7","外资");
//									str = str.replace("8","港澳台资");
//									return str;
//								}else{
//									return ""; 
//								}
//							}
//						},
						{
							targets: 3,
							render: function (data, type, row, meta) {
								if(data!=null&&data!=""){
			                    	 if(data && (data.length > 15)){
		                                    $(table.cell( meta.row, meta.col ).node()).attr('title',data);
		                                    return (data.substr( 0, 15 )+'....');
		                              }
									return data;
								}else{
									return ""; 
								}
							}
						},
						{
							targets: 4,
							render: function (data, type, row, meta) {
								 if(data && (data.length == 4) && data.substring(0,2) == "33"){
										return areacodeList(data);
									 }
								if(data!=null&&data!=""){
			                    	 if(data && (data.length > 15)){
		                                    $(table.cell( meta.row, meta.col ).node()).attr('title',data);
		                                    return (data.substr( 0, 15 )+'....');
		                              }
									return data;
								}else{
									return ""; 
								}
							}
						},
						{
							targets: 5,
							render: function (data, type, row, meta) {
					    		  return util.toThousands(data); 
							}
						},
						{
							targets: 6,
							render: function (data, type, row, meta) {
					    		  return util.toThousands(data); 
							}
						},
						{
							targets: 7,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 8,
							render: function (data, type, row, meta) {
								return util.toThousands(data); 
							}
						},
						{
							targets: 9,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 10,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 11,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 12,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 13,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 14,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 15,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 16,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},
						{
							targets: 17,
						    render: function (data, type, row, meta) {
						    		  return util.toThousands(data); 
						    }
						},      
						{
							targets: 18,
							render: function (data, type, row, meta) {
								return util.toThousands(data); 
							}
						},      
						{
							targets: 19,
							render: function (data, type, row, meta) {
								return util.toThousands(data); 
							}
						},      
						{
							targets: 20,
							"visible": false
						}      
            ],
            "footerCallback": function ( row, data, start, end, display ) {
                
                //应年报数
                var rptCount=0; 
                // 已年报数总和
                var isRptCount=0;
                // 开业数总和
                var busstatus=0;
                // 资产总额总和
                var assGroSum=0;
                // 负债总额总和
                var liaGroSum=0;
                //合计项在表格索引
                var dataArr=[5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];
                var api = this.api(); 
                if(data!=null&&data.length!=0){
                    for(var c=0;c<dataArr.length;c++){ 
                   	var intVal = function ( i ) {
                           return typeof i === 'string' ?
                               i.replace(/[\$,]/g, '')*1 :
                               typeof i === 'number' ?
                                   i : 0;
                       };
                       var total = api
                       .column( dataArr[c] )
                       .data()
                       .reduce( function (a, b) {
                           return intVal(a) + intVal(b);
                       } );
                       // 应年报数之和
                       if(c==15){
                    	   rptCount=total;
                       }
                       //已年报数总和
                       if(c==0){
                    	   isRptCount=total;
                       }
                       //开业数
                       if(c==2){ 
                    	   busstatus=total
                       }
                       if(c==5){ //资产总额
                    	   assGroSum=total
                       }
                       if(c==7){ //负债总额
                    	   liaGroSum=total
                       }
                       if(c!=1&&c!=3&&c!=8){
                    	   if(c==0||c==2||c==11||c==12||c==14){
                             	$( api.column( dataArr[c] ).footer() ).html(util.toThousands(total)); 
                   	   }else{
                            	$( api.column( dataArr[c] ).footer() ).html(util.toThousands(total.toFixed(4))); 
                   	   }
                       }
                   }
	                //当除数为0时直接赋值为0
	                if(rptCount==0||rptCount=="0"){
	                	$( api.column( 6).footer() ).html("0.00");
	                }else{
	                	 var sumYrAmountPer = (isRptCount / rptCount) * 100;
	                	 //年报率
	                     $( api.column( 6).footer() ).html(sumYrAmountPer.toFixed(2))
	                }
	                if(isRptCount==0||isRptCount=="0"){
	                	$( api.column( 8).footer() ).html("0.00");
	                }else{
	                	var sumbusstatusPer = (busstatus / isRptCount) * 100;
	                	//开业率
	                	$( api.column( 8).footer() ).html(sumbusstatusPer.toFixed(2))
	                }
	                if(assGroSum==0||assGroSum=="0"){
	                	$( api.column( 13).footer() ).html("0.00");
	                }else{
	                	var liaGroSumPer = (liaGroSum / assGroSum) * 100;
	                	//资产负债率
	                	$( api.column( 13).footer() ).html(liaGroSumPer.toFixed(2))
	                }
                }else{
                	for(var c=1;c<20;c++){ 
                		$( api.column(c).footer() ).html("-");
                	}
                }
            } ,
            "drawCallback": function(settings, json) {
            	drawTable();
            }
        }) 
     }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    	drawTable();
    });
    
    function drawTable(){
    	table.column( 2 ).visible(true, false);
//    	table.column( 3 ).visible(true, false);
    	table.column( 3 ).visible(true, false);
    	if($('#industryCode').val() == ''){
    		table.column( 2 ).visible(false, false);
    	}
//    	if($('#entyTypeCatg').val() == ''){
//    		table.column( 3 ).visible(false, false);
//    	}
    	if($('#entType').val() == ''){
    		table.column( 3 ).visible(false, false);
    	}
//		table.columns.adjust().draw( false );
//    	zxcount = zxcount + 1;
    }
    
    //指标项事件
	function tableReload(table) {
		tableInit('.zbxchoose', '#save', table);
	}
    
    function bind() {
        util.bindEvents([ 
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$('.hidden_input').val('');//重置隐藏域
            }
        },
        {
        	el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        }, {
        	el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#chooseEntType',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=entCatg]:checked").each(function(k,v){
              	   categCode[k]= this.value;
                });
                
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselectCom?type='+categCode+'&indType='+$('#entyTypeCatg').val(),
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#entType").val(returncode);
                    	$("#entTypeName").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#choseindustry',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择行业',
                    area: ['400px', '600px'],
                    content: '/commom/server/industry/toIndustryPhyTree?smFlag=1',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#industryCo").val(returncode);
                    	$("#industryCoName").val(data.returnname);  
                    }
                })
            }
        },
        {
        	el: '#choose',
            event: 'click',
            handler: function () {
				$("#save,#re").css("background","#1087eb");
            	layer1.open({
                    content: $(".designator-con"),
                    type: 1,
                    shade: [.1, '#fff'],
                    title: false,
                    closeBtn:false,
                    area: ['900px','220px']
                });
            }
        },
        {
        	el: '#re',
            event: 'click',
            handler: function () {
            	$("#zbxchooseAll").prop('checked',true);
            	$(".zbxchoose-ususal").prop('checked',true);
//            	$(".zbxchoose-ususal").removeAttr("checked");
            	layer1.closeAll();
        	}
        },
        {
        	el: '#save',
            event: 'click',
            handler: function () {
            	layer1.closeAll();
            	drawTable();
        	}
        },
		{
			el: '#save,#re',
			event: 'mouseenter',
			handler: function () {
				$(this).css("background","#0a5493")
			}
		},
		{
			el: '#save,#re',
			event: 'mouseleave',
			handler: function () {
				$(this).css("background","#1087eb")
			}
		},
		{
            el: '.js-more-query',
            event: 'click',
            handler: function () {
            	if($('.more-show').css("display")=="none"){
            		$('.js-more-query').attr('value','收起');
            		$('.more-show').css("display","block");
            	}else{
            		$('.js-more-query').attr('value','更多查询');
            		$('.more-show').css("display","none");
            	}
            }
        },
        {
            el: '.js-more-choose',
            event: 'click',
            handler: function () {
            	if($('.choose-n').css("display")=="none"){
            		$('.js-more-choose').attr('value','收起');
            		$('.choose-n').css("display","block");
            	}else{
            		$('.js-more-choose').attr('value','更多指标项');
            		$('.choose-n').css("display","none");
            	}
            }
        },
        {
        	el: '#zbxchooseAll',//全选或者反选
            event: 'click',
            handler: function () {
            	var allChecked= $("#zbxchooseAll").prop("checked");   
            	$(".zbxchoose-ususal").prop('checked',allChecked);
            	layer1.closeAll();
        	}
        }
        ])
    }
})
