require([
	'component/iframeLayer',
	'component/dataTable',
	'common/util',
	'common/http',
	'handlebars',
    'jquery',
	'jquery.serialize',
	'laydate',
	'jquery.multiselect'
], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    init();
    
	$("#setTimeEnd").click(function(){
		laydate({
			elem: '#setTimeEnd',
			format: 'YYYY-MM-DD',
			min: '1900-01-01', //设定最小日期为当前日期
			max: laydate.now(-1,"YYYY-MM-DD"), //最大日期
			istime: true,
			istoday: false,
			start: laydate.now(-1,"YYYY-MM-DD"),
			choose: function(datas){

			}
		});
	});
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
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
                url:'/reg/sccheck/pubscentresult/countWorklist.json',
                data:function(d){
                	d.params = searchParams;       
                }
            },
            columns: [
                {data: '_idx'},
                {data: 'taskName'}, 
                {data: 'taskType'},
                {data: 'taskObject'},
                {data: 'entTotal',className: 'right'},
                {data: 'randomPercent',className: 'right'},
                {data: 'totalNum',className: 'right'},
                {data: 'endNum',className: 'right'},
                {data: 'unendNum',className: 'right'},
                {data: null,className: 'right'},//完成率
                {data: 'result1',className: 'right'},
                {data: 'resultE',className: 'right'},
                {data: 'resultF',className: 'right'},
                {data: 'result7',className: 'right'},
                {data: 'result8',className: 'right'},
                {data: 'result9',className: 'right'},
                {data: 'resultA',className: 'right'},
                {data: 'result2',className: 'right'},
                {data: 'resultB',className: 'right'},
                {data: 'resultC',className: 'right'},
                {data: 'result6',className: 'right'},
                {data: 'resultD',className: 'right'},
                {data: 'result3',className: 'right'},
                {data: 'result4',className: 'right'},
                {data: 'result5',className: 'right'},
                {data: 'dispose1',className: 'right'},
                {data: 'dispose2',className: 'right'},
                {data: 'dispose3',className: 'right'},
                {data: 'dispose4',className: 'right'},
                {data: 'dispose5',className: 'right'},
                {data: 'dispose6',className: 'right'},
                {data: 'disposeNum',className: 'right'},
                {data: null,className: 'right'}
           ],
           columnDefs: [{
			               targets: 1,
			               render: function (data, type, row, meta) { 
			            	   return row.taskCode+"<br/>"+row.taskName;
			               }
			            },{
                            targets: 2,
                            render: function (data, type, row, meta) { 
                           	 if("1"== row.taskType){
                           		return "定向";
                           	 }else if("2"== row.taskType){
                           		return "不定向";
                           	 }else {
                           		return "";
                           	 } 
                            }
                         },{
                             targets: 3,
                             render: function (data, type, row, meta) { 
                          	   var conStr="";
                        	   if(data!=null&&data!=""&&typeof data!="undefined"){
                        		    var dataArr=$.trim(data).split(",");
                        		    if(dataArr.length>0){
                        		    	for(var i=0;i<dataArr.length;i++){
                        		    		if("1"==dataArr[i]){
                        		    			conStr+="企业"+"<br/>";
                        		    		}else if("2"==dataArr[i]){
                        		    			conStr+="农专社"+"<br/>";
                        		    		}else if("3"==dataArr[i]){
                        		    			conStr+="个体户"+"<br/>";
                        		    		}else if("4"==dataArr[i]){
                        		    			conStr+="外企代表机构"+"<br/>";
                        		    		}
                        		    	}
                        		    	if(conStr!=""){
                    		    			conStr=conStr.substring(0,conStr.length-1);
                    		    		}
                        		    }
                        	   }
                        	   return conStr;
                             }
                          },{
							targets: 4,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 5,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 6,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 7,
						    render: function (data, type, row, meta) {
						    	return util.toThousands(data); 
						   }
					    },{
							targets: 8,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 9,
						    render: function (data, type, row, meta) { 
						       if(row.totalNum !=0 && row.totalNum != null){
						    	   return ((row.endNum/row.totalNum)*100).toFixed(2)+"%";   
						       }
						   }
					    },{
							targets: 10,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 11,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 12,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 13,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 14,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 15,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 16,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 17,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 18,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 19,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 20,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 21,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 22,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 23,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 24,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 25,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 26,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 27,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 28,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 29,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 30,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 31,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 32,
						    render: function (data, type, row, meta) { 
					    	 if(row.endNum !=0 && row.endNum != null){
					    		 return ((row.disposeNum/row.endNum)*100).toFixed(2)+"%";   
						     }else{
						    	 return "0.00%";
						     }
						   }
					    }],
           "footerCallback": function ( row, data, start, end, display ) {
               var dataArr=[4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32];
               var api = this.api(); 
               if(data!=null&&data.length!=0){
                   for(var c=0;c<dataArr.length;c++){ 
                  	var intVal = function ( i ) {
                          return typeof i === 'string' ? i.replace(/[\$,]/g, '')*1 : typeof i === 'number' ? i : 0;
                      };
                      var total = api
                      .column( dataArr[c] )
                      .data()
                      .reduce( function (a, b) {
                          return intVal(a) + intVal(b);
                      } );
                      if(c == 3){
                    	  var finishedNum = $(api.column(dataArr[2]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  var totalEnt = $(api.column(dataArr[0]).footer()).html();
                    	  if(totalEnt != null){
                    		  totalEnt = totalEnt.replace(/,/g,"");
                    	  }
                    	  if(totalEnt != 0){
                    		  var finishPerCount = ((finishedNum/totalEnt)*100).toFixed(2)+"%";
                    		  $(api.column(dataArr[1]).footer()).html(finishPerCount); 
                    	  }else{
                    		  $(api.column(dataArr[1]).footer()).html("0.00%"); 
                    	  }
                    	  $(api.column(dataArr[c]).footer()).html(util.toThousands(total));
                      }else if(c ==5){
                    	  var finishedNum = $(api.column(dataArr[3]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  var totalNum = $(api.column(dataArr[2]).footer()).html();
                    	  if(totalNum != null){
                    		  totalNum = totalNum.replace(/,/g,"");
                    	  }
                    	  if(totalNum != 0){
                    		  var finishPerCount = ((finishedNum/totalNum)*100).toFixed(2)+"%";
                    		  $(api.column(dataArr[5]).footer()).html(finishPerCount); 
                    	  }else{
                    		  $(api.column(dataArr[5]).footer()).html("0.00%"); 
                    	  }
                      }else if(c == 28){
                    	  var disposeNum = $(api.column(dataArr[27]).footer()).html();
                    	  if(disposeNum != ""){
                    		  disposeNum = disposeNum.replace(/,/g,"");
                    	  }
                    	  var finishedNum = $(api.column(dataArr[3]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  if(finishedNum != 0){
                    		  var finishPerCount = ((disposeNum/finishedNum)*100).toFixed(2)+"%";
                    		  $(api.column(dataArr[28]).footer()).html(finishPerCount); 
                    	  }else{
                    		  $(api.column(dataArr[28]).footer()).html("0.00%"); 
                    	  }
                      }else{
                    	  $(api.column(dataArr[c]).footer()).html(util.toThousands(total));
                      }
                  }
               }else{
               		for(var c=0;c<dataArr.length;c++){ 
                      $(api.column(dataArr[c]).footer()).html("0"); 
                    }
               } 
           }
        })
     }
    
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function () {
            	if(table == null){
            		initDataTable();
            	}else{
            		searchParams = $("#taskForm").serializeObject();
            		table.ajax.reload(); 
            	}
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
                $("#appointLocalAdm").val("");
            }
        },{
        	el: '#choseregUnit',
            event: 'click',
            handler: function () { 
//            	var deptFlag = $("#deptFlag").val();
//            	if(deptFlag == "Y"){
            		layer.dialog({
            			title: '选择抽查任务组织部门',
            			area: ['400px', '600px'],
            			content: '/commom/server/regunit/regunitsingselect?isPermissionCheck=false',
            			callback: function (data) { 
            				var returncode=data.returncode;
            				$("#appointLocalAdm").val(returncode);
            				$("#localAdmName").val(data.returname); 
            			}
            		})
//            	}else{
//            		var dutyDeptCode = $("#dutyDeptCode").val();
//                    layer.dialog({
//                        title: '选择检查机关',
//                        area: ['400px', '600px'],
//                        content: '/common/system/sysdepart/deptSelectByDuty?treeType=radio&dutyDeptCodes='+dutyDeptCode+"&isNoCheck=true",
//                        callback: function (data) {
//                            if(data.adCodes){
//                                $("#appointLocalAdm").val(data.adCodes);
//                                $("#localAdmName").val(data.orgNames);
//                            }
//                        }
//                    })
//            	}
            }
        }])
    }
})
