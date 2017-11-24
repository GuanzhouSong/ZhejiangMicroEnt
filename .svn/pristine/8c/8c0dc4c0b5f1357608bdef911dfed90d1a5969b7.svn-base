require(['component/iframeLayer', 'layer1','component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, layer1,dataTable, util, http) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
    	var entTypeCatg = $("#entTypeCatg").val();
    	if(entTypeCatg =='16' || entTypeCatg =='17'){
	    	 //农专行政许可信息
	       	 initSfcLisenceTable();
	       	 //农专网站信息
	    	 initSfcWebTable();
	    	 //分支机构信息
	    	 initSfcBranchTable();
	    	 //敏感词信息
		     initforbidWordTable();
	    	 //修改记录信息
	    	 initSfcModTable();
    	}else if(entTypeCatg =='50'){
	    	 //个体行政许可信息
	    	 initPbLisenceTable();
	    	 //个体网站信息
	         initPbPubWebTable();
	         //敏感词信息
		     initforbidWordTable();
	         //修改记录信息
	         initPbModTable();
    	}else{
	        //网站信息
	    	 initPubWebTable();
	    	//对外担保信息
	     	initPubGuranteeTable();
	     	//投资人及出资信息
	     	initSubcapTalTable();
	     	//股权转让信息
	     	initalterStockTable();
	     	//对外投资信息
	     	initforinvestMentTable();
	     	//敏感词信息
	     	initforbidWordTable();
	     	//修改信息表
	     	initmodHisTable();
    	}
        //事件绑定
        bind();
    }
    
    //行政许可信息
    function initPbLisenceTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubLicenceTable',
                showIndex: true,
                ajax: {
                	url:'/pub/pblicenceinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%',className: 'center'},
                    {data: 'licNameCN',className: 'center'},
                    {data: 'valTo',className: 'center'}
                ]
          })
    }
    
    function initSfcLisenceTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubLicenceTable',
                showIndex: true,
                ajax: {
                	url:'/pub/sfclicenceinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%',className: 'center'},
                    {data: 'licNameCN',className: 'center'},
                    {data: 'valTo',className: 'center'}
                ]
          })
    }
    
    //农专分支机构信息
    function initSfcBranchTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#sfcBranchtable',
                showIndex: true,
                ajax: {
                	url:'/pub/sfcbranchinfo/forbid.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%',className: 'center'},
                    {data: 'uniCode',width: '45%',className: 'center'},
                    {data: 'brName',width: '45%',className: 'center'}
                ]
          })
    }
    
    //网站信息
    function initPubWebTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubwebTable',
                showIndex: true,
                ajax: {
                	url:'/pub/WebsiteInfo/list.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                //回调
        	    fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isWebInfo").text(_length > 0?"是":"否");
        	    },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'webSitName', width: '20%',className: 'center'},
                    {data: 'webType', width: '20%',className: 'center'},
                    {data: 'webSite', width: '20%',className: 'center'}
                ],
                columnDefs : [
  							   {
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if (row.webType == '1') {
  										return "网站";
  									}else{
  										return "网店";
  								    }
  					            }
  				          }]
                    })
             }
    
    function initPbPubWebTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubwebTable',
                showIndex: true,
                ajax: {
                	url:'/pub/pbwebsiteinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'webSitName', width: '20%',className: 'center'},
                    {data: 'webType', width: '20%',className: 'center'},
                    {data: 'webSite', width: '20%',className: 'center'}
                ],
                columnDefs : [
  							   {
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if (row.webType == '1') {
  										return "网站";
  									}else{
  										return "网店";
  								    }
  					            }
  				           }]
                      })
                }
    
    function initSfcWebTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubwebTable',
                showIndex: true,
                ajax: {
                	url:'/pub/sfcwebsiteinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'webSitName', width: '20%',className: 'center'},
                    {data: 'webType', width: '20%',className: 'center'},
                    {data: 'webSite', width: '20%',className: 'center'}
                ],
                columnDefs : [
  							   {
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if (row.webType == '1') {
  										return "网站";
  									}else{
  										return "网店";
  								    }
  					            }
  				           }]
                      })
                }
    
   //对外担保信息
    function initPubGuranteeTable(){
    	var anCheID = $("#anCheID").val();
    	var  table2 = dataTable.load({
                el: '#guranteeTable',
                showIndex: true,
                ajax: {
                	url:'/pub/GuaranteeInfo/list.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'more', width: '15%',className: 'center'},
                    {data: 'mortgagor', width: '15%',className: 'center'},
                    {data: 'priClaSecKind', width: '15%',className: 'center'},
                    {data: 'priClaSecAm', width: '15%',className: 'center'},
                    {data: 'isPubFlag', width: '15%',className: 'center'},
                    {data: 'gaType', width: '15%',className: 'center'}
                ],
              //回调
        	    fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isForguarantee").text(_length > 0?"是":"否");
        	    },
                columnDefs : [
 							   {
 								targets : 5,
 								render : function(data, type, row, meta) {
 									if (row.isPubFlag == '0') {
 										return "不公示";
 									}else{
 										return "公示";
 								    }
 					           }
 				             },{
								targets : 6,
									render : function(data, type, row, meta) {
										if (row.gaType == '1') {
											return "一般保证";
										}else if(row.gaType == '2'){
											return "连带保证";
									    }else{
									    	return "未约定";
									    }
						          }
				             },{
								targets : 3,
									render : function(data, type, row, meta) {
										if (row.priClaSecKind == '1') {
											return "合同";
										}else if(row.priClaSecKind == '2'){
											return "其它";
									    }
						          }
				             }]
                       })
               }
    
    //投资人及出资信息
    function initSubcapTalTable (){
    	var anCheID = $("#anCheID").val();
    	var  table3 = dataTable.load({
                el: '#subcaptalTable',
                showIndex: true,
                ajax: {
                	 url:'/pub/subcapitalInfo/list.json',
                	 data:function(d){
     	                d.params = {"anCheID":anCheID};
                     }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'inv', width: '10%',className: 'center'},
                    {data: 'invRegNO', width: '10%',className: 'center'},
                    {data: 'lisubconam', width: '10%',className: 'center'},
                    {data: 'conFormCN', width: '10%',className: 'center'},
                    {data: 'subConDate', width: '15%',className: 'center'},
                    {data: 'liacconam', width: '10%',className: 'center'},
                    {data: 'acConFormCn', width: '10%',className: 'center'},
                    {data: 'acConDate', width: '15%',className: 'center'}
                ]
            })
    }
    
   //股权转让信息
    function initalterStockTable (){
    	var anCheID = $("#anCheID").val();
    	var  table4 = dataTable.load({
                el: '#alterStockTable',
                showIndex: true,
                ajax: {
                	url:'/pub/alterStockInfo/list.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isStockInfo").text(_length > 0?"是":"否");
        	    },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'inv', width: '20%',className: 'center'},
                    {data: 'beTransAmPr', width: '20%',className: 'center'},
                    {data: 'afTransAmPr', width: '20%',className: 'center'},
                    {data: 'altDate', width: '25%',className: 'center'}
                ]
            })
    }
    
   //对外投资信息
    function initforinvestMentTable (){
    	var anCheID = $("#anCheID").val();
    	var  table5 = dataTable.load({
                el: '#forinvestMentTable',
                showIndex: true,
                ajax: {
                	 url:'/pub/forinvestMentInfo/list.json',
                	 data:function(d){
     	                d.params = {"anCheID":anCheID};
                     }
                },
                fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isInvestInfo").text(_length > 0?"是":"否");
        	    },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'uniCode', width: '45%',className: 'center'},
                    {data: 'entName', width: '45%',className: 'center'}
                ]
            })
    }
    
    //敏感词信息
    function initforbidWordTable (){
    	var priPID = $("#priPID").val();
    	var year = $("#year").val();
    	var  table6 = dataTable.load({
    		el: '#forbidWordTable',
    		showIndex: true,
    		ajax: {
    			url:'/reg/server/yr/forbidresult/forbidlist.json',
    			data:function(d){
    				d.params = {"priPID":priPID,"year":year};
    			}
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'forbidContent', width: '45%',className: 'center'},
    		          {data: 'forbidDate', width: '45%',className: 'center'}
    		         ]
    	      })
    }
    
    //修改记录表
    function initmodHisTable(){
    	var anCheID = $("#anCheID").val();
    	var  table7 = dataTable.load({
    		el: '#modHisTable',
    		showIndex: true,
    		ajax: {
    			url:'/pub/updateinfo/list.json',
    			data:function(d){
	                d.params = {"anCheID":anCheID};
                }
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'altItem', width: '24%',className: 'center'},
    		          {data: 'altBe', width: '22%',className: 'center'},
    		          {data: 'altAf', width: '22%',className: 'center'},
    		          {data: 'altDate', width: '22%',className: 'center'}
    		    ],
		    columnDefs : [
		              {
						targets : 2,
						render : function(data, type, row, meta) {
							return doHandleDataForshow(row.dicValue,row.altBe);
			            }
		           },{
						targets : 3,
						render : function(data, type, row, meta) {
							return doHandleDataForshow(row.dicValue,row.altAf);
			           }
		           }]
    	      })
       }
    
    function initPbModTable(){
    	var anCheID = $("#anCheID").val();
    	var  table7 = dataTable.load({
    		el: '#modHisTable',
    		showIndex: true,
    		ajax: {
    			url:'/pub/pbupdateinfo/forbidword.json',
    			data:function(d){
	                d.params = {"anCheID":anCheID};
                }
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'altItem', width: '24%',className: 'center'},
    		          {data: 'altBe', width: '22%',className: 'center'},
    		          {data: 'altAf', width: '22%',className: 'center'},
    		          {data: 'altDate', width: '22%',className: 'center'}
    		],
	        columnDefs : [
						   {
							targets : 2,
							render : function(data, type, row, meta) {
								return doHandleDataForshow(row.dicValue,row.altBe);
				           }
			           },{
							targets : 3,
							render : function(data, type, row, meta) {
								return doHandleDataForshow(row.dicValue,row.altAf);
				           }
			           }]
    	          })
            }
    
    function initSfcModTable(){
    	var anCheID = $("#anCheID").val();
    	var  table7 = dataTable.load({
    		el: '#modHisTable',
    		showIndex: true,
    		ajax: {
    			url:'/pub/sfcupdateinfo/forbidword.json',
    			data:function(d){
	                d.params = {"anCheID":anCheID};
                }
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'altItem', width: '24%',className: 'center'},
    		          {data: 'altBe', width: '22%',className: 'center'},
    		          {data: 'altAf', width: '22%',className: 'center'},
    		          {data: 'altDate', width: '22%',className: 'center'}
    		],
            columnDefs :[
						   {
							targets : 2,
							render : function(data, type, row, meta) {
								return doHandleDataForshow(row.dicValue,row.altBe);
				           }
			           },{
							targets : 3,
							render : function(data, type, row, meta) {
								return doHandleDataForshow(row.dicValue,row.altAf);
				           }
			          }]
    	      })
         }
    
    //修改记录显示处理
    function doHandleDataForshow(dicValue,altBeOrAf){
    	if(altBeOrAf =="undefined" || altBeOrAf == null ){
    		return "";
    	}
    	if(dicValue.indexOf('IsPub') != -1 || dicValue.indexOf('isPub') != -1 || dicValue == 'empNumDis'){
			if(altBeOrAf == '1'){return '是';}
			else{return '否';}
		}
    	else if(dicValue == 'webType'){
			if(altBeOrAf == '1'){return '网站';}
			else{return '网店';}
		}
    	else if(dicValue == 'priClaSecKind'){
			if(altBeOrAf == '1'){return '合同';}
			else{return '其它';}
		}
    	else if(dicValue =='gaType'){
			if(altBeOrAf == '1'){return '一般保证';}
			else if(altBeOrAf == '2'){return '连带保证';}
			else{return '未约定';}
		}else{
			return doStrToDate(altBeOrAf);
		}
    }
    
    //修改记录时间处理
    function doStrToDate(altBeOrAf){
		if (altBeOrAf.indexOf("CST") > -1 || altBeOrAf.indexOf("GMT") > -1) {
				var time = new Date(altBeOrAf);
				var y = time.getFullYear();  
			    var m = time.getMonth() + 1;  
			    m = m < 10 ? ('0' + m) : m;  
			    var d = time.getDate();  
			    d = d < 10 ? ('0' + d) : d;  
				return y + '-' + m + '-' + d;
			} else {
				return altBeOrAf;
			}
      }
    

    function bind() {
    	var entName = $("#entName").val();
    	var regNo = $("#regNO").val();
    	var uniCode = $("#uniCode").val();
        util.bindEvents([{
        	el: '#success',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		if(uniCode != null && uniCode != ''){
            			$("#auditOpinion").val(entName+'('+uniCode+')'+'\n'+'企业年报异常字词经审核符合公示要求，予以正常公示。');
            		}else{
            			$("#auditOpinion").val(entName+'('+regNo+')'+'\n'+'企业年报异常字词经审核符合公示要求，予以正常公示。');
            		}
            	}
            }
        },{
        	el: '#fail',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		if(uniCode != null && uniCode != ''){
            			$("#auditOpinion").val(entName+'('+uniCode+')'+'\n'+'企业年报异常字词经审核不符合公示要求，不予正常公示，请修改后重新报送。');
            		}else{
            			$("#auditOpinion").val(entName+'('+regNo+')'+'\n'+'企业年报异常字词经审核不符合公示要求，不予正常公示，请修改后重新报送。');
            		}
            	}
            }
        },{
        	el: '#commit',
            event: 'click',
            handler: function () {
            	var _Flag = false;
            	$("input[name ='auditState']").each(function(){
            		if($(this).prop("checked")){
            			_Flag = true;
            		}
            	})
            	if(_Flag){
            		var auditState = $("input[name ='auditState']:checked").val();//获取审核状态
            		var formParam = $('#forbidCheckForm').serializeObject();
                    http.httpRequest({
                      url: '/reg/server/yr/forbidresult/commit',
                      serializable: false,
                      data: formParam,
                      type: 'post',
                      success: function (data) { 
        	            	if(data.status =='success'){
        	            		if(auditState == "0"){ //审核不通过时，才发送短信
            		            	layer.msg(data.msg, {time: 1000}, function (){
            		            		layer1.open({
            		                        shade: [0.5,'#000'],
            		                        type: 1,
            		                        content: $('#send-message-layer'),
            		                        title: false,
            		                        area: ['700px','400px'],
            		                        cancel:function(){ //重写打开的layer关闭方法
            		        		    		layer1.closeAll();
                                                layer.close({reload: true});
            		                        }
            		                    })
                                    });
        	            		}else{
                              	  layer.msg(data.msg, {time: 1000}, function () {
                                      layer.close({reload: true});
                                  });
        	            		}
        	            	  }else{
                            	  layer.msg(data.msg, {time: 1000}, function () {
                                      layer.close({reload: true});
                                  });
                              }
                      }
                  })
            	}else{
            		alert("请先选择审核结果！");
            		return false;
            	}
             }
        },{
        	el: '#close',
            event: 'click',
            handler: function () {
            	layer.close();
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
        },
//        {
//            el: '.dy-report-bg',  //打印年报年度报告
//            event: 'click',
//            handler: function () {
//                //获取选中的年份：
////            	var yearValue = $("#year").val();
////                var yearValue = $("#year_list").val();
////                $('.js-year').each(function(){
////                    if($(this).val()==yearValue){
////                        layer.msg("打印年度报告加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
////                        var year = $(this).data('year');
////                        var pripid= $("#js-pripid").val();
////                        var url = $('.js-reprot-year').val();
////                        url = url+"?year="+year+"&priPID="+pripid+"&printFalg=2";
////                        window.open(url);
////                    }
////                });
////                layer.msg("打印年度报告加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
//            	var priPID = $("#enPriPid").val();
//            	var year = $("#enYear").val();
//                var url = $('.js-reprot-year').val();
//                url = url+"?year="+year+"&priPID="+priPID+"&printFalg=2"; 
//                window.open(url);
//            }
//        },
//        {
//            el: '.dy-reprot-zm', //打印年度报告证明
//            event: 'click',
//            handler: function () {
//                //获取选中的年份：
////                var yearValue = $("#year_list").val();
////                $('.js-year').each(function(){
////                    if($(this).val()==yearValue){
////                        layer.msg("打印年度报告证明加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
////                        var year = $(this).data('year');
////                        var pripid= $("#js-pripid").val();
////                        var url = $('.js-reprot-zm').val();
////                        url = url+"?year="+year+"&priPID="+pripid;
////                        window.open(url);
////                    }
////                });
////                layer.msg("打印年度报告证明加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
//            	var priPID = $("#enPriPid").val();
//            	var year = $("#enYear").val();
//                var url = $('.js-reprot-zm').val();
//                url = url+"?year="+year+"&priPID="+priPID+"&printFalg=2"; 
//                window.open(url);	
//            	
//            }
//        },
		{
		    el: '#send', //发送短信
		    event: 'click',
		    handler: function () {
		    	var tel = $("#liaTel").val();
		    	var msg = $("#entName").val()+"你企业"+$("#year").val()+"年度年报公示内容于"+$("#curDate").val()+"日经审核不符合相关法规要求，不予正常公示，请修改后重新报送。";
		    	var district = $("#district").val();
		    	if($(".sendMsg").prop("checked") && tel != null && tel != "" && tel.length == 11){
	    		 http.httpRequest({
			            url: '/reg/server/yr/forbidresult/sendMsg',
			            data:{'msg':msg,'tel':tel,'district':district},
	            		success: function (data) {
	            			if(data.status =='success'){
		            			layer.msg(data.msg, {time: 1000}, function (){
		            				 layer1.closeAll();
		            				 layer.close({reload: true});
		                        });
	            			}else{
	            				layer1.closeAll();
	            				layer.msg(data.msg);
	            				layer.close({reload: true});
	            			}
	                    }
			        })
		    	}else{
		    		layer1.closeAll();
		    		layer.close({reload: true});
		    	}
		      }
		},
		{
		    el: '#cancel', //发送短信按钮的取消按钮
		    event: 'click',
		    handler: function () {
		    		layer1.closeAll();
		    		layer.close({reload: true});
		      }
		},
        {
            el: '.js-fold-pubinfo',
            event: 'click',
            handler: function () {
                if ($(this).hasClass('reverse')) {
                    $(this).html('收起公示详情<i></i>');
                    $(this).removeClass("reverse");
                    $(this).addClass("more");
                    $(".js-pubinfo").show();
                    //强制重新计算datatable列宽
                    $.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
                } else {
                    $(this).html('展开公示详情<i></i>');
                    $(this).addClass("reverse");
                    $(this).addClass("more");
                    $(".js-pubinfo").hide();
                }
            }
        }
        ])
    }

})