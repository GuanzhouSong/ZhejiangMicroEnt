require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 
         'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var entType="1";
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
    	 var rptYear = window._CONFIG.year;
         for (; 2013 <= rptYear; rptYear--) {
       		$("#rptyear").append("<option value='" + rptYear + "'>" + rptYear + "</option>");
          };
         areacodeList(1);
        var deptcode = window._CONFIG.deptCode;
       	if(deptcode == '3300'||(window._CONFIG._isAdmin=="1"||window._CONFIG._isAdmin=="2")||window._CONFIG._searchRangeLevel=="4"){
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
	
	
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	//企业类型
    	entType=$('input:radio[name="entCatgCode"]:checked').val();
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
        	 //需要初始化dataTable的dom元素
            el: '#user-table',
            "bPaginate" : false,
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/opanomalyrpt/opanomalyrptJSON.json',
                //async: false,
                data:function(d){
                  	var statArea = $('#statArea').val(); 
                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});               		
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'areaCode'}, 
                {data: 'regOrgName',className: 'left'},
                {data: 'inReason',className: 'right'},
                {data: 'inReasonNum',className: 'right'},
                {data: 'isRevoke',className: 'right'},
                {data: 'isRevokeNum',className: 'right'},
                {data: 'inReason',className: 'right'},
                {data: 'inReasonCoutNum',className: 'right'},
                {data: 'isMove',className: 'right'},
                {data: 'isMoveNum',className: 'right'},
                {data: 'inReason1',className: 'right'},
                {data: 'inReasonNum1',className: 'right'},
                {data: 'inReason2',className: 'right'},
                {data: 'inReasonNum2',className: 'right'},
                {data: 'inReason3',className: 'right'},
                {data: 'inReasonNum3',className: 'right'},
                {data: 'inReason4',className: 'right'},
                {data: 'inReasonNum4',className: 'right'},
                {data: 'outReason1',className: 'right'},
                {data: 'outReasonNum1',className: 'right'},
                {data: 'outReason2',className: 'right'},
                {data: 'outReasonNum2',className: 'right'},
                {data: 'outReason3',className: 'right'},
                {data: 'outReasonNum3',className: 'right'},
                {data: 'outReason4',className: 'right'},
                {data: 'outReasonNum4',className: 'right'},
                {data: 'outReason5',className: 'right'},
                {data: 'outReasonNum5',className: 'right'},
                {data: 'outReason6',className: 'right'},
                {data: 'outReasonNum6',className: 'right'},
                {data: 'outReason7',className: 'right'},
                {data: 'outReasonNum7',className: 'right'}
           ],
            columnDefs: [                     
				{
					targets: 1,
				    render: function (data, type, row, meta) {
				    	  if(data!=null&&data!=""){
				              return areacodeList(data)
				    	  }else{
				    		  return ""; 
				    	  }
				    }
				},
				{
					targets: 2,
				    render: function (data, type, row, meta) {
				    	
				    	  if(data!=null&&data!="" && data.substring(0,2) == "33"){
                              return areacodeList(data);
				    	  }else{
				    		  if(data!=null&&data!=""&&data.length>6){
				    			  data=data.substring(0,6)+"...";
				    		  }
				    		  return data; 
				    	  }
				    }
				},
				{
					targets: 3,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 4,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 5,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 6,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 7,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 8,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 9,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 10,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 11,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 12,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 13,
				    render: function (data, type, row, meta) { 
				    	 if(entType=="3"){
				    		 return "0";
				    	 }
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 14,
				    render: function (data, type, row, meta) {
				    	 if(entType=="3"){
				    		 return "0";
				    	 }
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 15,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 16,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 17,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 18,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 19,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 20,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 21,
				    render: function (data, type, row, meta) {
				    	if(entType=="3"){
				    		 return "0";
				    	 }
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 22,
				    render: function (data, type, row, meta) {
				    	if(entType=="3"){
				    		 return "0";
				    	 }
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 23,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	,
				{
					targets: 24,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 25,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 26,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 27,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 28,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 29,
				    render: function (data, type, row, meta) {
				    	 if(entType=="3"){
				    		 return "0";
				    	 }
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 30,
				    render: function (data, type, row, meta) {
				    	
				    	 if(entType=="3"){
				    		 return "0";
				    	 }
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 31,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
				,
				{
					targets: 32,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}        
            ],
            "footerCallback": function ( row, data, start, end, display ) { 
                //合计项在表格索引
                var dataArr=[3,4,5,6,7,8,9,10,11,12,13,14 ,15,16,17,18,19,20,21,22,23,24
                             ,25,26,27,28,29,30,31,32];
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
                      $( api.column( dataArr[c] ).footer() ).html(util.toThousands(total)); 
                   }
                }else{
                	for(var c=1;c<dataArr.length+3;c++){ 
                		$( api.column(c).footer() ).html("-");
                	}
                }
            } 
        }) 
     }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){ 
    	var statArea = $('#statArea').val();
    	//企业类型
    	entType=$('input:radio[name="entCatgCode"]:checked').val();
    	if(statArea == null || statArea == ''){
            layer.msg("请选择统计范围", {ltype: 0, time: 3000});
     	}else{
        	searchParams = $("#taskForm").serializeObject();
            table.ajax.reload(); 
    	}
    });
    
    //根据年份和月份获取当月的天数
    function getLastDayByYearAndMonth(year,month){ 
    	var  day = new Date(year,month,0); 
	  	  //获取天数：
	  	var daycount = day.getDate();
	  	return daycount;
    }
   
    
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
        	}
        },
        {
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
        },
        {
            el: '#rptmouth',
            event: 'change',
            handler: function () {
            	
                var rptyear = $("#rptyear").val();  //统计日期选中年份
                var endCheckPushDate = window._CONFIG.endCheckPushDate;
                var rptmounth = $("#rptmouth").val();  //统计日期选中月份
                var year = window._CONFIG.year;     //当前年份
                var month = window._CONFIG.month;   //当前月份
            	if (rptmounth== "00") {
                    $("#startCheckPushDate").val(rptyear+"-01-01");
                    $("#endCheckPushDate").val(endCheckPushDate);
                }else {
                	if((rptyear > year || rptyear == year)&& rptmounth > month){
                        $("#startCheckPushDate").val('');
                        $("#endCheckPushDate").val('');
                	}else{
                		if(rptyear == year && rptmounth == month){
                            $("#startCheckPushDate").val(rptyear+"-"+rptmounth+"-01");
                            $("#endCheckPushDate").val(endCheckPushDate);
                		}else{
                            $("#startCheckPushDate").val(rptyear+"-"+rptmounth+"-01");
                            $("#endCheckPushDate").val(rptyear+"-"+rptmounth+"-"+getLastDayByYearAndMonth(rptyear,rptmounth));
                		}
                	}
                }
            }
        },
        {
            el: '#rptyear',
            event: 'change',
            handler: function () {
            	 
                var rptyear = $("#rptyear option:selected").val();  //统计日期选中年份
                var endCheckPushDate = window._CONFIG.endCheckPushDate;
                var rptmounth = $("#rptmouth option:selected").val();  //统计日期选中月份
                var year = window._CONFIG.year;     //当前年份
                var month = window._CONFIG.month;   //当前月份
            	if ($("#rptmouth option:selected").val() == 00) {
                    $("#startCheckPushDate").val(rptyear+"-01-01");
                    $("#endCheckPushDate").val(endCheckPushDate);
                }else {
                	if((rptyear > year || rptyear == year)&& rptmounth > month){
                        $("#startCheckPushDate").val('');
                        $("#endCheckPushDate").val('');
                	}else{
                		if(rptyear == year && rptmounth == month){
                            $("#startCheckPushDate").val(rptyear+"-"+rptmounth+"-01");
                            $("#endCheckPushDate").val(endCheckPushDate);
                		}else{
                            $("#startCheckPushDate").val(rptyear+"-"+rptmounth+"-01");
                            $("#endCheckPushDate").val(rptyear+"-"+rptmounth+"-"+getLastDayByYearAndMonth(rptyear,rptmounth));
                        }
                	}
                }
            }
        },
        {
            el: '#user-table td',
            event: 'mouseover',
            handler: function () {
            	//给第三列部门 加上title
            	 var cellIndex=this.cellIndex;
                 if(cellIndex==2){
                	 var data = table.row($(this)).data();
                	 if(data!=null){
                		 var regOrgName= data.regOrgName;
                		 if(!(regOrgName!=null&&regOrgName!="" && regOrgName.substring(0,2) == "33")){
                			 if(regOrgName.length>6){
                				 $(this)[0].title=regOrgName;
				    		 }
                    	 }
                	 }
                 } 
            }
        }
        ])
    }
})
