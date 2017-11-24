require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 
         'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

	Date.prototype.format = function(fmt) {
        var o = {
            "M+": this.getMonth() + 1,
            // 月份
            "d+": this.getDate(),
            // 日
            "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
            // 小时
            "H+": this.getHours(),
            // 小时
            "m+": this.getMinutes(),
            // 分
            "s+": this.getSeconds(),
            // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3),
            // 季度
            "S": this.getMilliseconds()
                // 毫秒
        };
        var week = {
            "0": "/u65e5",
            "1": "/u4e00",
            "2": "/u4e8c",
            "3": "/u4e09",
            "4": "/u56db",
            "5": "/u4e94",
            "6": "/u516d"
        };
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
        }
        if (/(E+)/.test(fmt)) {
            fmt = fmt
                .replace(
                    RegExp.$1,
                    ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt = fmt.replace(RegExp.$1,
                    (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                        .substr(("" + o[k]).length)));
            }
        }
        return fmt;
    };
    
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
    	 var rptYear = window._CONFIG.year;
         for (; 2014 <= rptYear; rptYear--) {
       		$("#rptyear").append("<option value='" + rptYear + "'>" + rptYear + "</option>");
          };
    }
	
	
	
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	//企业类型
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
        	 //需要初始化dataTable的dom元素
            el: '#user-table',
            "bPaginate" : false,
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/pubsearchlogrpt/list.json',
                //async: false,
                data:function(d){
                	d.params = $.extend({}, searchParams);   
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'year'},
                {data: 'pubTime'},
                {data: 'count'}
           ],
            columnDefs: [                     
				{
                    targets: 2,
                    render: function(data, type, row, meta) {
                        return new Date(data).format("yyyy-MM-dd"); 
                    }
                },{
					targets: 3,
				    render: function (data, type, row, meta) {
				    	 return util.toThousands(data); 
				    }
				}	
            ],
            "footerCallback": function ( row, data, start, end, display ) { 
                //合计项在表格索引
                var dataArr=[3];
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
        });
     }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){ 
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload(); 
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
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
                    $("#endCheckPushDate").val(endCheckPushDate);
                }else {
                	if((rptyear > year || rptyear == year)&& rptmounth > month){
                        $("#endCheckPushDate").val('');
                	}else{
                		if(rptyear == year && rptmounth == month){
                            $("#endCheckPushDate").val(endCheckPushDate);
                		}else{
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
                    $("#endCheckPushDate").val(endCheckPushDate);
                }else {
                	if((rptyear > year || rptyear == year)&& rptmounth > month){
                        $("#endCheckPushDate").val('');
                	}else{
                		if(rptyear == year && rptmounth == month){
                            $("#endCheckPushDate").val(endCheckPushDate);
                		}else{
                            $("#endCheckPushDate").val(rptyear+"-"+rptmounth+"-"+getLastDayByYearAndMonth(rptyear,rptmounth));
                        }
                	}
                }
            	if(rptyear == 2014){
              		$(".rm").attr("disabled",true);
              		if (month < 10) {
              			$("#rptmouth").val(10);
              			$("#endCheckPushDate").val(rptyear+"-10-31");
              		}
              	}else{
              		$(".rm").removeAttr("disabled");
              	}
            }
        }
        ])
    }
})
