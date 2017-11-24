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
    
    //日期控件初始化
    $("#setTimeStart").click(function(){
		laydate({
			elem: '#setTimeStart',
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
    	inityear();
//        initDataTable();
        bind();
        var rptYear = window._CONFIG.year;
        for (; 2013 <= rptYear; rptYear--) {
      		$("#rptyear").append("<option value='" + rptYear + "'>" + rptYear + "</option>");
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
	
	//计算某年份下某月的天数
	function getDaysInOneMonth(year, month){  
		  month = parseInt(month, 10);  
		  var d= new Date(year, month, 0);  
		  return d.getDate();  
	}
	
	//初始化年份
    function inityear(){
        var deptcode = window._CONFIG.deptCode;
       	if(deptcode == '3300' || window._CONFIG.isAdmin == '1' || window._CONFIG.isAdmin == '2' || window._CONFIG.searchRangeLevel == '4' ){
       		$("#statArea").append("<option value='3300'>省局</option>");
       		$("#statArea").append("<option value='3301'>杭州</option>");
       		$("#statArea").append("<option value='3302'>宁波</option>");
       		$("#statArea").append("<option value='3303'>温州</option>");
       		$("#statArea").append("<option value='3304'>嘉兴</option>");
       		$("#statArea").append("<option value='3305'>湖州</option>");
       		$("#statArea").append("<option value='3306'>绍兴</option>");
       		$("#statArea").append("<option value='3307'>金华</option>");
       		$("#statArea").append("<option value='3308'>衢州</option>");
       		$("#statArea").append("<option value='3309'>舟山</option>");
       		$("#statArea").append("<option value='3310'>台州</option>");
       		$("#statArea").append("<option value='3325'>丽水</option>");
       	}else if(deptcode == '3301'){
       		$("#statArea").append("<option value='3301'>杭州</option>");
       	}else if(deptcode == '3302'){
       		$("#statArea").append("<option value='3302'>宁波</option>");
       	}else if(deptcode == '3303'){
       		$("#statArea").append("<option value='3303'>温州</option>");
       	}else if(deptcode == '3304'){
       		$("#statArea").append("<option value='3304'>嘉兴</option>");
       	}else if(deptcode == '3305'){
       		$("#statArea").append("<option value='3305'>湖州</option>");
       	}else if(deptcode == '3306'){
       		$("#statArea").append("<option value='3306'>绍兴</option>");
       	}else if(deptcode == '3307'){
       		$("#statArea").append("<option value='3307'>金华</option>");
       	}else if(deptcode == '3308'){
       		$("#statArea").append("<option value='3308'>衢州</option>");
       	}else if(deptcode == '3309'){
       		$("#statArea").append("<option value='3309'>舟山</option>");
       	}else if(deptcode == '3310'){
       		$("#statArea").append("<option value='3310'>台州</option>");
       	}else if(deptcode == '3325'){
       		$("#statArea").append("<option value='3325'>丽水</option>");
       	}
     	if(deptcode == '3300'){ 
           	$("#statArea").multipleSelect({
        		selectAllText: '全省',
        		allSelected: '全省',
        		selectAllDelimiter: '',
        		minimumCountSelected: 20
        	});
       	}else{
           	$("#statArea").multipleSelect({
           		selectAllText: '',
           		allSelected: '',
           		selectAll: false
        	});
       	}

     	if(deptcode == '3300'){
     	    $('#statArea').multipleSelect('checkAll');
     	}else{
        	$('#statArea').multipleSelect('setSelects',[deptcode]);
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
                url:'/reg/sccheck/pubscentresult/countlist.json',
                data:function(d){
                	var statArea = $('#statArea').val();
                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});       
                }
            },
            columns: [
                {data: '_idx'},
                {data: 'areaName'}, 
                {data: 'deptName'},
                {data: 'totalNum',className: 'right'},
                {data: 'editNum',className: 'right'},
                {data: 'auditNum',className: 'right'},
                {data: 'endNum',className: 'right'},
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
           columnDefs: [
						{
							targets: 1,
						    render: function (data, type, row, meta) {
					    	if(row.areaName != null && row.areaName != ""){
                                return areacodeList(row.areaName);
					    	  }else{
					    		  return ""; 
					    	  }
						   }
						},{
							targets: 2,
						    render: function (data, type, row, meta) {
						    	if(row.deptName != null && row.deptName != ""){
						    		return row.deptName;
						    	}else{
						    		return areacodeList(row.areaName);
						    	}
						    }
						},{
							targets: 3,
						    render: function (data, type, row, meta) {
						       return util.toThousands(data); 
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
						       if(row.totalNum !=0 && row.totalNum != null){
						    	   return ((row.endNum/row.totalNum)*100).toFixed(2)+"%";   
						       }
						   }
					    },{
							targets: 8,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 9,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
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
					    	 if(row.endNum !=0 && row.endNum != null){
					    		 return ((row.disposeNum/row.endNum)*100).toFixed(2)+"%";   
						     }else{
						    	 return "0.00%";
						     }
						   }
					    }],
           "footerCallback": function ( row, data, start, end, display ) {
               var dataArr=[3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30];
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
                      if(c ==4){
                    	  var finishedNum = $(api.column(dataArr[3]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  var totalNum = $(api.column(dataArr[0]).footer()).html();
                    	  if(totalNum != null){
                    		  totalNum = totalNum.replace(/,/g,"");
                    	  }
                    	  if(totalNum != 0){
                    		  var finishPerCount = ((finishedNum/totalNum)*100).toFixed(2)+"%";
                    		  $(api.column(dataArr[4]).footer()).html(finishPerCount); 
                    	  }else{
                    		  $(api.column(dataArr[4]).footer()).html("0.00%"); 
                    	  }
                      }else if(c == 27){
                    	  var disposeNum = $(api.column(dataArr[26]).footer()).html();
                    	  if(disposeNum != ""){
                    		  disposeNum = disposeNum.replace(/,/g,"");
                    	  }
                    	  var finishedNum = $(api.column(dataArr[3]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  if(finishedNum != 0){
                    		  var finishPerCount = ((disposeNum/finishedNum)*100).toFixed(2)+"%";
                    		  $(api.column(dataArr[27]).footer()).html(finishPerCount); 
                    	  }else{
                    		  $(api.column(dataArr[27]).footer()).html("0.00%"); 
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
    
    function getDateByYearAndMonth(year,month){
    	if(year == "" || month == ""){
    		return "";
    	}
    	if(month.length == 1){
    		month = "0" + month;
    	}
    	return year+"-"+month;
    }
    
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function () {
            	var statArea = $('#statArea').val();
            	if(statArea == null || statArea == ''){
                    layer.msg("请选择统计范围", {ltype: 0, time: 3000});
            	}else{
            		var countType = $("#countType").val();
            		if(countType == "00"){
            			var monthStart = $("#monthStart").val();
            			var monthEnd = $("#monthEnd").val();
            			var rptyear = $("#rptyear").val();
            			var setTimeMonthStart = getDateByYearAndMonth(rptyear,monthStart);
            			var setTimeMonthEnd = getDateByYearAndMonth(rptyear,monthEnd);
            			if(monthStart != "" && monthEnd != "" && parseInt(monthStart) > parseInt(monthEnd)){
        					$("#setTimeMonthStart").val(setTimeMonthEnd);
        					$("#setTimeMonthEnd").val(setTimeMonthStart);
            			}else{
        					$("#setTimeMonthStart").val(setTimeMonthStart);
        					$("#setTimeMonthEnd").val(setTimeMonthEnd);
        				}
            		}
                	searchParams = $("#taskForm").serializeObject();
                	if(table == null){
                		initDataTable();
                	}else{
                		table.ajax.reload(); 
                	}
            	}
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
                var deptcode = window._CONFIG.deptCode;
             	if(deptcode == '3300'){
             	    $('#statArea').multipleSelect('checkAll');
             	}else{
                	$('#statArea').multipleSelect('setSelects',[deptcode]);
             	}
            }
        },{
            el: '#countType',
            event: 'change',
            handler: function () { 
                var type = $(this).val();
                if(type == '00'){
                	$("#yearDiv").show();
                	$("#monthDiv").show();
                	$("#dateDiv").hide();
                }else if(type == '01'){
                	$("#yearDiv").hide();
                	$("#monthDiv").hide();
                	$("#dateDiv").show();
                }
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#yearDiv").show();
            	$("#monthDiv").show();
            	$("#dateDiv").hide();
            	$("#setTimeMonthStart").val("");
            	$("#setTimeMonthEnd").val("");
            }
        }])
    }
})
