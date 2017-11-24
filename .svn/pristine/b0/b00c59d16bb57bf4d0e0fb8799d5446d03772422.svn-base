require(['component/iframeLayer','layer1', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 
         'jquery','jquery.serialize','laydate','jquery.multiselect','dataTableShow'], function (layer,layer1, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var lerepAgeTotal = 0;
    var zxcount = 0;
    init(); 
    /**
     * 初始化函数集合
     */
    function init() {
        areacodeList(1);
//    	inityear();
        initDataTable();
        bind();
		tableReload(table);
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
        table = dataTable.load({
        	 //需要初始化dataTable的dom元素
            el: '#user-table',
            "bPaginate" : false,
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/sment/server/rptsmentinfoall/rptSmNormalsjCount.json',
                //async: false,
                data:function(d){
//                 	var statArea = $('#statArea').val();
                	d.params = $("#taskForm").serializeObject();             		
//                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});               		
                }
            },
            columns: [
                {data: null,'defaultContent':'11',width:'24px'},
                {data: 'areaTime'}, 
                {data: 'industryCodeName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'industryCoName',className: 'right'},
//                {data: 'entTypeCatgName',className: 'right'},
                {data: 'entTypeName',className: 'right',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'regorgName',className: 'right',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'newEnt',className: 'right'},
                {data: 'canEnt',className: 'right'},
                {data: 'cancelEnt',className: 'right'},
                {data: 'regCapAll',className: 'right'},
                {data: 'newRegCapAll',className: 'right'},
                {data: 'regCapAvg',className: 'right'},
                {data: 'avgAge',className: 'right'}, 
//                {data: 'cer80',className: 'right'}, 
//                {data: 'cer90',className: 'right'}, 
                {data: 'cer33',className: 'right'}, 
                {data: 'invLeg',className: 'right'},
                {data: 'newEntAll',className: 'right'},
                {data: 'canEntAll',className: 'right'},
                {data: 'cancelEntAll',className: 'right'},               
                {data: 'avgAgeCount',className: 'right'} 
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
						    		  if(data == '1'){
						    			  return "第一产业";
						    		  }else if(data == '2'){
						    			  return "第二产业";
						    		  }else if(data == '3'){
						    			  return "第三产业";
						    		  }else{
	                                      return data; 
						    		  }
						    	  }else{
						    		  return ""; 
						    	  }
						    }
						},
						{
							targets: 3,
							render: function (data, type, row, meta) {
								if(data!=null&&data!=""){
									return data;
								}else{
									return ""; 
								}
							}
						},
//						{
//							targets: 4,
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
							targets: 4,
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
							targets: 5,
							render: function (data, type, row, meta) {
								if(data!=null&&data!=""){
									 if(data && (data.length == 4) && data.substring(0,2) == "33"){
										return areacodeList(data);
									 }
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
					    		   return util.toThousands(data.toFixed(4)); 
						    }
						},
						{
							targets: 10,
							render: function (data, type, row, meta) {
								return util.toThousands(data.toFixed(4)); 
							}
						},
						{
							targets: 11,
							render: function (data, type, row, meta) {
								return util.toThousands(data.toFixed(4)); 
							}
						},
						{
							targets: 12,
						    render: function (data, type, row, meta) {
						    	if(data!=null&&data!=""&&data!=0&&data!="0"){
						    		if(zxcount == 0 ){
							    		  lerepAgeTotal = lerepAgeTotal +1;
						    		}
						    		  return util.toThousands(data); 
						    	}else{
						    		return "-";
						    	} 
						    }
						},
//						{
//							targets: 15,
//						    render: function (data, type, row, meta) {
//						    		  return util.toThousands(data); 
//						    }
//						},
//						{
//							targets: 16,
//						    render: function (data, type, row, meta) {
//						    		  return util.toThousands(data); 
//						    }
//						},
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
							"visible": false
						} 
                        
            ],
            "footerCallback": function ( row, data, start, end, display ) {
            	zxcount = zxcount + 1;
                //新设小微企业总数
            	var count = end;
                //新设小微企业注册资本总数
                var avgregCap=0; 
                // 法人代表平均年龄总数
                var avgAgeAll=0;
                // 法人代表总数（符合要求的）
                var avgAgeCount=0;
                //因查无下落列入异常且未年报数
                var notfoundcount=0;
                //合计项在表格索引
                var dataArr=[6,7,8,9,10,11,12,13,14,15,16,17,18];
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
                       //新设小微企业总数
                       if(c==1){
                    	   count=total;  
                       }
                       //新设小微企业注册资本总数
                       if(c==4){
                    	   avgregCap=total;
                       }
                       //法人代表平均年龄总数
                       if(c==6){
                    	   avgAgeAll=total;
                       }
                       if(c==9){ //法人代表总数（符合要求的）
                    	   avgAgeCount=total
                       }
                       //循环到自然年报率、工作年报率不赋值 后面统一计算
                       if(c!=5&&c!=6){
                    	   if(c==3||c==4){//处理万元
                           	$( api.column( dataArr[c] ).footer() ).html(util.toThousands(total.toFixed(4))); 
                    	   }else{
                              	$( api.column( dataArr[c] ).footer() ).html(util.toThousands(total)); 
                    	   }
                       }
                   }
//	                //当除数为0时直接赋值为0
	                if(count==0||count=="0"){ //新设企业平均注册资本
	                	$( api.column( 11).footer() ).html("0.00");
	                }else{
	                	 var regcapPer = (avgregCap / count);
	                	 //新设平均注册资本
	                     $( api.column( 11).footer() ).html(regcapPer.toFixed(4))
	             }
	                if(lerepAgeTotal==0 || lerepAgeTotal=="0"){
	                	$( api.column( 12).footer() ).html("-");
	                }else{
	                     //平均年龄
	                     var avgAgePer = (avgAgeAll / lerepAgeTotal); 
		                 $( api.column(12).footer() ).html(avgAgePer.toFixed(0));
	                }
                }else{
                	for(var c=1;c<18;c++){ 
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
            lerepAgeTotal = 0;
            zxcount = 0 ;
            table.ajax.reload(); 
            drawTable();
    });
    
    function drawTable(){
    	table.column( 2 ).visible(true, false);
    	table.column( 3 ).visible(true, false);
//    	table.column( 4 ).visible(true, false);
    	table.column( 4 ).visible(true, false);
    	if($('#thrIndustry').val() == ''){
    		table.column( 2 ).visible(false, false);
    	}
    	if($('#industryCo').val() == ''){
    		table.column( 3 ).visible(false, false);
    	}
//    	if($('#entyTypeCatg').val() == ''){
//    		table.column( 4 ).visible(false, false);
//    	}
    	if($('#entType').val() == ''){
    		table.column( 4 ).visible(false, false);
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
            	var indType = '';
            	var choose = $("#thrIndustry option:selected").text();
            	if(choose == '第一产业'){indType = 'one';}
            	else if(choose == '第二产业'){ indType = 'two';}
            	else if(choose == '第三产业'){ indType = 'three'; }
            	
                layer.dialog({
                    title: '选择行业',
                    area: ['400px', '600px'],
                    content: '/commom/server/industry/toIndustryPhyTree?smFlag=1&indType='+indType,
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
                    area: ['900px','200px']
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
