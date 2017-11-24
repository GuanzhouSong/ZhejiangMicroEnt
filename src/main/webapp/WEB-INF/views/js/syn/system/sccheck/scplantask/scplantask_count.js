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
                url:window._CONFIG.chooseUrl+'/server/sccheck/scplantask/countlist.json',
                data:function(d){
                	var statArea = $('#statArea').val();
                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});       
                }
            },
            columns: [
                {data: '_idx'},
                {data: 'areaCode'}, 
                {data: 'deptName'},
                {data: 'totalWork',className: 'right'},
                {data: 'planOwnNum',className: 'right'},
                {data: 'planCrossNum',className: 'right'},
                {data: 'planState01',className: 'right'},
                {data: 'planState02',className: 'right'},
                {data: 'planState03',className: 'right'},
                {data: null,className: 'right'},//完成率
                {data: 'totalTask',className: 'right'},
                {data: 'taskResource1',className: 'right'},
                {data: 'taskResource2',className: 'right'},
                {data: 'ownNum',className: 'right'},
                {data: 'crossNum',className: 'right'},
                {data: 'taskState01',className: 'right'},
                {data: 'taskState02',className: 'right'},
                {data: 'taskState03',className: 'right'},
                {data: null,className: 'right'},
                {data: 'entTotal',className: 'right'},
                {data: 'finishedNum',className: 'right'},
                {data: null,className: 'right'},
                {data: 'disposeNum',className: 'right'},
                {data: null,className: 'right'}
           ],
           columnDefs: [
						{
							targets: 1,
						    render: function (data, type, row, meta) {
					    	if(data != null && data != ""){
                                return areacodeList(data);
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
						    		return areacodeList(row.areaCode);
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
						       if(row.planState03 !=0 && row.planState03 != null){
						    	   return ((row.planState03/row.totalWork)*100).toFixed(2)+"%";   
						       }else{
						    	   return '0.00%';
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
						       if(row.taskState03 !=0 && row.taskState03 != null){
						    	   return ((row.taskState03/row.totalTask)*100).toFixed(2)+"%";   
						       }else{
						    	   return '0.00%';
						       }
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
						       if(row.finishedNum !=0 && row.finishedNum != null){
						    	   return ((row.finishedNum/row.entTotal)*100).toFixed(2)+"%";   
						       }else{
						    	   return '0.00%';
						       }
						   }
					    },{
							targets: 22,
						    render: function (data, type, row, meta) { 
						       return util.toThousands(data); 
						   }
					    },{
							targets: 23,
						    render: function (data, type, row, meta) {
						       if(row.disposeNum !=0 && row.disposeNum != null){
						    	   return ((row.disposeNum/row.finishedNum)*100).toFixed(2)+"%";   
						       }else{
						    	   return '0.00%';
						       }
						   }
					    }],
           "footerCallback": function ( row, data, start, end, display ) {
               var dataArr=[3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23];
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
                      if(c ==6){
                    	  var finishedNum = $(api.column(dataArr[3]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  var totalNum = $(api.column(dataArr[0]).footer()).html();
                    	  if(totalNum != ""){
                    		  totalNum = totalNum.replace(/,/g,"");
                    	  }
                    	  if(totalNum != 0){
                    		  var finishPerCount = ((finishedNum/totalNum)*100).toFixed(2);
                    		  $(api.column(dataArr[6]).footer()).html(finishPerCount+"%"); 
                    	  }else{
                    		  $(api.column(dataArr[6]).footer()).html("0.00%"); 
                    	  }
                      }else if(c == 15){
                    	  var disposeNum = $(api.column(dataArr[14]).footer()).html();
                    	  if(disposeNum != ""){
                    		  disposeNum = disposeNum.replace(/,/g,"");
                    	  }
                    	  var finishedNum = $(api.column(dataArr[10]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  if(finishedNum != 0){
                    		  var finishPerCount = ((disposeNum/finishedNum)*100).toFixed(2);
                    		  $(api.column(dataArr[15]).footer()).html(finishPerCount+"%"); 
                    	  }else{
                    		  $(api.column(dataArr[15]).footer()).html("0.00%"); 
                    	  }
                      }else if(c == 18){
                    	  var disposeNum = $(api.column(dataArr[17]).footer()).html();
                    	  if(disposeNum != ""){
                    		  disposeNum = disposeNum.replace(/,/g,"");
                    	  }
                    	  var finishedNum = $(api.column(dataArr[16]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  if(finishedNum != 0){
                    		  var finishPerCount = ((disposeNum/finishedNum)*100).toFixed(2);
                    		  $(api.column(dataArr[18]).footer()).html(finishPerCount+"%"); 
                    	  }else{
                    		  $(api.column(dataArr[18]).footer()).html("0.00%"); 
                    	  }
                      }else if(c == 20){
                    	  var disposeNum = $(api.column(dataArr[19]).footer()).html();
                    	  if(disposeNum != ""){
                    		  disposeNum = disposeNum.replace(/,/g,"");
                    	  }
                    	  var finishedNum = $(api.column(dataArr[17]).footer()).html();
                    	  if(finishedNum != ""){
                    		  finishedNum = finishedNum.replace(/,/g,"");
                    	  }
                    	  if(finishedNum != 0){
                    		  var finishPerCount = ((disposeNum/finishedNum)*100).toFixed(2);
                    		  $(api.column(dataArr[20]).footer()).html(finishPerCount+"%"); 
                    	  }else{
                    		  $(api.column(dataArr[20]).footer()).html("0.00%"); 
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
            	var statArea = $('#statArea').val();
            	if(statArea == null || statArea == ''){
                    layer.msg("请选择统计范围", {ltype: 0, time: 3000});
            	}else{
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
        }
        ])
    }
})
