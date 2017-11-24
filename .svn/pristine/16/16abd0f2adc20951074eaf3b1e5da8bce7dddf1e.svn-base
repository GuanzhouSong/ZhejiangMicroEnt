require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 
         'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

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
        }
    
    //初始化年份
    function inityear(){
         //自动生成年度
         var _thisYear =  window._CONFIG.year-1;
         for (; 2013 <= _thisYear; _thisYear--) {
      		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
         };
         var rptYear = window._CONFIG.year;
         for (; 2014 <= rptYear; rptYear--) {
       		$("#rptyear").append("<option value='" + rptYear + "'>" + rptYear + "</option>");
          };
        areacodeList(1);
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
                url:'/reg/server/pubinfo/pubInfoCount.json',
                //async: false,
                data:function(d){
                 	var statArea = $('#statArea').val();
                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});               		
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'areacode'}, 
                {data: 'regOrgName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'isreport'+$("#year").val(),className: 'right'},
                {data: 'imAllH',className: 'right'},
                {data: 'investmentH',className: 'right'},
                {data: 'investmentT',className: 'right'},
                {data: 'invsraltH',className: 'right'},
                {data: 'invsraltT',className: 'right'},
                {data: 'permitH',className: 'right'},
                {data: 'permitT',className: 'right'},
                {data: 'ippldgH',className: 'right'},
                {data: 'ippldgT',className: 'right'},
                {data: 'caseH',className: 'right'},
                {data: 'caseT',className: 'right'},
                {data: 'escAllH',className: 'right'},
                {data: 'escingH',className: 'right'},
                {data: 'escendH',className: 'right'}
           ],
            columnDefs: [                     
						{
							targets: 1,
						    render: function (data, type, row, meta) {
						    	  if(data!=null&&data!=""){
                                      return areacodeList(data);
						    	  }else{
						    		  return ""; 
						    	  }
						    }
						},
						{
							targets: 2,
						    render: function (data, type, row, meta) {
						    	var areacount = $("#statLevel").val();
						    	if(areacount=="localadm"){
						    		return row.localAdmName;
						    	}
						    	if(data!=null&&data!="" && data.substring(0,2) == "33"){
                                    return areacodeList(data);
						    	}else{
						    		return data; 
						    	}
						    }
						},
						{
							targets: 3,
						    render: function (data, type, row, meta) {
						    	var year = $("#year").val();
		 						var _isreport = 'isreport' + year;
						    	return util.toThousands(row[_isreport]); 
						    }
						},
						{
							targets: 4,
						    render: function (data, type, row, meta) {
				    		    return util.toThousands(data); 
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
						}
						
                         
            ],
            "footerCallback": function ( row, data, start, end, display ) {
            	var dataArr=[3,4,5,6,7,8,9,10,11,12,13,14,15,16,17];
            	var api = this.api(); 
                if(data&&data!=null&&data.length!=0){
                    for(var c=0;c<dataArr.length;c++){ 
                    	var intVal = function ( i ) {
                           return typeof i === 'string' ?
                               i.replace(/[\$,]/g, '')*1 :
                               typeof i === 'number' ?
                                   i : 0;
                       };
                       var total = api.column(dataArr[c]).data().reduce(function (a, b) {
                           return intVal(a) + intVal(b);
                       });
                    	   
                       $(api.column( dataArr[c] ).footer() ).html(total); 
                   }
                }else{
                	for(var c=3;c<=17;c++){ 
                		$( api.column(c).footer() ).html("0");
                	}
                }
            } 
        }) 
     }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	var statArea = $('#statArea').val();
    	if(statArea == null || statArea == ''){
            layer.msg("请选择统计范围", {ltype: 0, time: 3000});
    	}else{
        	searchParams = $("#taskForm").serializeObject();
            table.ajax.reload(); 
    	}
    });
   
    
    function bind() {
        util.bindEvents([ 
        {
            el: '#qy',
            event: 'click',
            handler: function () { 
        		$("#year").empty();
                 //自动生成年度
                 var _thisYear =  window._CONFIG.year-1;
                 for (; 2013 <= _thisYear; _thisYear--) {
              		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
                 };
                 $("#nei").prop("checked",true);
                 $("#wai").prop("checked",true);
            }
        },
        {
        	el: '#nz',
        	event: 'click',
        	handler: function () {
        		//去除所有项
        		$("#year").empty();
        		//自动生成年度
        		var _thisYear =  window._CONFIG.year-1;
        		for (; 2014 <= _thisYear; _thisYear--) {
        			$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
        		};
        		$("#nei").prop("checked",false);
                $("#wai").prop("checked",false);
        	}
        },
        {
        	el: '#wai',
        	event: 'click',
        	handler: function () {
        		$("#year").empty();
                //自动生成年度
                var _thisYear =  window._CONFIG.year-1;
                for (; 2013 <= _thisYear; _thisYear--) {
             		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
                };
        		$("#qy").prop("checked",true);
        	}
        },
        {
        	el: '#nei',
        	event: 'click',
        	handler: function () {
        		$("#year").empty();
                //自动生成年度
                var _thisYear =  window._CONFIG.year-1;
                for (; 2013 <= _thisYear; _thisYear--) {
             		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
                };
        		$("#qy").prop("checked",true);
        	}
        },
        {
        	el: '#gt',
        	event: 'click',
        	handler: function () {
        		$("#year").empty();
        		//自动生成年度
        		var _thisYear =  window._CONFIG.year-1;
        		for (; 2015 <= _thisYear; _thisYear--) {
        			$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
        		};
        		$("#nei").prop("checked",false);
                $("#wai").prop("checked",false);
        	}
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
                var deptcode = window._CONFIG.deptCode;
            	$(".monthchoose").hide();
             	if(deptcode == '3300'){
             	    $('#statArea').multipleSelect('checkAll');
             	}else{
                	$('#statArea').multipleSelect('setSelects',[deptcode]);
             	}
            }
        },
        {
            el: '.rptselect',//
            event: 'change',
            handler: function () {
            	if($("#rptway option:selected").val() == "00"){ //选择当前
                	$(".monthchoose").hide();
                    var rptyear = $("#rptyear option:selected").val();  //统计日期选中年份
                    var endCheckPushDate = window._CONFIG.endCheckPushDate;
                    var year = window._CONFIG.year;     //当前年份
                    $("#startCheckPushDate").val(rptyear+"-01-01");
                    $("#endCheckPushDate").val(endCheckPushDate);
            	}else{
                	$(".monthchoose").show();
                    var rptyear = $("#rptyear option:selected").val();  //统计日期选中年份
                    var endCheckPushDate = window._CONFIG.endCheckPushDate;
                    var rptbeginmounth = $("#rptbeginmouth option:selected").val();  //统计日期选中开始月份
                    var rptendmounth = $("#rptendmouth option:selected").val();  //统计日期选中结束月份
                    var year = window._CONFIG.year;     //当前年份
                    var month = window._CONFIG.month;   //当前月份
                	if(rptbeginmounth > rptendmounth ){
                        layer.msg("统计开始月份不能大于截止月份", {ltype: 0, time: 3000});
                	}else{
                    	if((rptyear > year || rptyear == year)&& (rptbeginmounth > month)){
                            $("#startCheckPushDate").val('');
                            $("#endCheckPushDate").val('');
                    	}else{
                    		if(rptyear == year && (rptendmounth == month || (rptbeginmounth <= month && rptendmounth > month ))){
                                $("#startCheckPushDate").val(rptyear+"-"+rptbeginmounth+"-01");
                                $("#endCheckPushDate").val(endCheckPushDate);
                    		}else{
                                $("#startCheckPushDate").val(rptyear+"-"+rptbeginmounth+"-01");
                                $("#endCheckPushDate").val(rptyear+"-"+rptendmounth+"-"+getDaysInOneMonth(rptyear,rptendmounth));
                    		}
                    	}
                	}
            	}
         }
        }
        ])
    }
})
