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
    	$("#statArea").multipleSelect({
    		selectAllText: '全省',
    		allSelected: '全省',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
    	});
    	$('#statArea').multipleSelect('checkAll');
        initDataTable();
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
                url:window._CONFIG.chooseUrl+'/server/drcheck/pubscagent/countsynlist.json',
                data:function(d){
                	var statArea = $('#statArea').val();
                	d.params = $.extend({}, searchParams, {"statArea":statArea.toString()});          		
                }
            },
            columns: [
                {data: '_idx'},
                {data: 'areaCode'}, 
                {data: 'slicenNOName'},
                {data: 'deptCatgCount',className: 'right'},
                {data: 'deptCatg1',className: 'right'},
                {data: 'deptCatg2',className: 'right'},
                {data: 'deptCatg3',className: 'right'},
                {data: 'deptCatg5',className: 'right'},
                {data: 'deptCatg6',className: 'right'},
                {data: 'deptCatg7',className: 'right'},
                {data: 'expertCount',className: 'right'}
           ],
            columnDefs: [{
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
						    	  var statLevel = $("#statLevel").val();
						    	  if(statLevel == "area"){
                                      return areacodeList(row.areaCode);
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
						}
            ],
            "footerCallback": function ( row, data, start, end, display ) {
                var dataArr=[3,4,5,6,7,8,9,10];
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
                	searchParams = $("#taskForm").serializeObject();
                    table.ajax.reload(); 
            	}
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
         	    $('#statArea').multipleSelect('checkAll');
            }
        }
        ])
    }
})
