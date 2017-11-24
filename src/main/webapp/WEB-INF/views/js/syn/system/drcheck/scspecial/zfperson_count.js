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
        initDataTable();
        bind();
    }
    
    //初始化年份
    function inityear(){
//        var rptYear = window._CONFIG.year;
//        for (; 2013 <= rptYear; rptYear--) {
//      		$("#rptyear").append("<option value='" + rptYear + "'>" + rptYear + "</option>");
//         };
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
                url:window._CONFIG.chooseUrl+'/server/drcheck/pubscagent/countlist.json',
                data:function(d){
                 	var statArea = $('#statArea').val();
                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});            		
                }
            },
            columns: [
                {data: '_idx'},
                {data: 'areaCode'}, 
                {data: 'deptName'},
                {data: 'deptCatgCount',className: 'right'},
                {data: 'deptCatgGs',className: 'right'},
                {data: 'deptCatgSp',className: 'right'},
                {data: 'deptCatgZl',className: 'right'},
                {data: 'deptCatgAq',className: 'right'},
                {data: 'deptCatgWj',className: 'right'},
                {data: 'expertCount',className: 'right'},
                {data: 'expertBh',className: 'right'},
                {data: 'expertYpGSP',className: 'right'},
                {data: 'expertYpGMP',className: 'right'},
                {data: 'expertYlGSP',className: 'right'},
                {data: 'expertYlGMP',className: 'right'}
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
						    		  return util.toThousands(data); 
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
                var dataArr=[3,4,5,6,7,8,9,10,11,12,13,14];
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
                       $(api.column(dataArr[c]).footer()).html(util.toThousands(total)); 
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
//                	var categCode=new Array();
//            		$(":checkbox[name=entTypeCode]:checked").each(function(k,v){
//            			categCode[k]= this.value;
//            		});
//            		$("#entType").val(categCode);
                	searchParams = $("#taskForm").serializeObject();
                    table.ajax.reload(); 
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
