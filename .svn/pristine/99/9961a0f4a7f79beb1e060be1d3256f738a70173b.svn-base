require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
    init(); 
    /**
     * 初始化函数集合
     */
    function init() {
        //initDataTable();
        bind();
        var _deptCode=window._CONFIG._deptCode;
    	$("#area").val(_deptCode);
        }
    
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startCheckPushDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
        }
    };
    
    var end = {
            elem: '#endCheckPushDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
    
    //开始时间和结束时间
    $("#startCheckPushDate").click(function(){laydate(start);});
    $("#endCheckPushDate").click(function(){laydate(end);}); 
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	var _sysUrl=window._CONFIG._sysUrl; 
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
        	 //需要初始化dataTable的dom元素
            el: '#user-table',
            "bPaginate" : false,
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/foodstoragebase/foodstorageCount.json',
                //async: false,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'area',cut: {length: 20,mark:'...'}},
                {data: 'fsDeclareAmount'},
                {data: 'fsDeclaredAmount'},
                {data: 'fsDeclarePerCent'},
                {data: 'fsStorageAmount'},
                {data: 'fsProductAmount'},
                {data: 'fsRunAmount'},
                {data: 'fsServiceAmount'},
                {data: 'farmerProductAmount'},
                {data: 'fproductLicence'} ,
                {data: 'fdistributionLicense'} ,
                {data: 'warehouseAmount'}
           ],
            columnDefs: [
                         
						{
							targets: 2,
						    render: function (data, type, row, meta) {
						    	 return util.toThousands(data);
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
						},
						{
							targets: 12,
						    render: function (data, type, row, meta) {
						    	 return util.toThousands(data); 
						    }
						}	
                         
            ],
            "footerCallback": function ( row, data, start, end, display ) { 
                //合计项在表格索引
                var dataArr=[2,3,4,5,6,7,8,9,10,11,12];
                var api = this.api(); 
                //应报户数总和
                var fsDeclareAmountCount=0;
                //已报户数总和
                var fsDeclaredAmountCount=0;
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
                       
                       
                       if(c==0){
                    	   fsDeclareAmountCount=total;
                       }
                       if(c==1){
                    	   fsDeclaredAmountCount=total;
                       }
                       if(c!=2){
                    	   $( api.column( dataArr[c] ).footer() ).html(util.toThousands(total));
                       }else{
                    	   if(fsDeclareAmountCount==null||fsDeclareAmountCount==""||fsDeclareAmountCount==0||fsDeclareAmountCount=="0"){
                    		   $( api.column(4).footer() ).html("0.00")
                    	   }else{
                    		   var sumYrAmountPer = (fsDeclaredAmountCount / fsDeclareAmountCount) * 100;
        	                	 //申报率
        	                   $( api.column(4).footer() ).html(sumYrAmountPer.toFixed(2)) 
                    	   }
                       }
                   }
                 /*   $( api.column(2).footer() ).html("0");
                    $( api.column(3).footer() ).html("0");
                    $( api.column(4).footer() ).html("0");*/
                }else{
                	for(var c=1;c<dataArr.length+6;c++){ 
                		$( api.column(c).footer() ).html("-");
                	}
                }
            } 
        }) 
     }
    
    //表格之外的查询按钮事件
    $("#ssearch").click(function(){
    	searchParams = $("#taskForm").serializeObject(); 
    	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		 table.ajax.reload(); 
    	}
    });
   
    
    function bind() {
        util.bindEvents([ 
        {
            el: '#selectDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	
                    /*	var orgCodeArr= data.reload.orgCode.split(",");
                    	var idArr=data.reload.id.split(",");
                    	var deptNameArr=data.reload.deptName.split(",");
                    	if(orgCodeArr.length>0){
                    		for(var i=0;i<orgCodeArr.length;i++){
                    			if(orgCodeArr[i].length!=18){
                    				orgCodeArr.splice(i,1); 
                    				deptNameArr.splice(i,1); 
                    				idArr.splice(i,1);
                    				i--;
                    			}
                    		}
                    	} */
                    	$("#checkDep").val(data.adCodes);
                    	$("#checkDepName").val(data.orgNames);
                   }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
                $("#checkDep").val("");
                $("#startCheckPushDate").val(window._CONFIG._startSetdate);
                $("#endCheckPushDate").val(window._CONFIG._endSetdate);
            }
        }
        ])
    }
})
