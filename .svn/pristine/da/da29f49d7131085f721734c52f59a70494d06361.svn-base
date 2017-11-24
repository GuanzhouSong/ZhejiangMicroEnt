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
    var startCheckPushDate = {
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
    
    var endCheckPushDate = {
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
    
    	var startCheckClaimDate = {
            elem: '#startCheckClaimDate', //选择ID为START的input
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
        
        var endCheckClaimDate = {
                elem: '#endCheckClaimDate',
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
    $("#startCheckPushDate").click(function(){laydate(startCheckPushDate);});
    $("#endCheckPushDate").click(function(){laydate(endCheckPushDate);}); 
        
    $("#startCheckClaimDate").click(function(){laydate(startCheckClaimDate);});
    $("#endCheckClaimDate").click(function(){laydate(endCheckClaimDate);}); 
    
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
                url:_sysUrl+'/pubdzdtinfo/pubDtInfoCountListJSON.json',
                //async: false,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'areaName'}, 
                {data: 'deptName',cut: {length: 20,mark:'...'}},
                {data: 'pushDoorCount'},
                {data: 'pushCount'},
                {data: 'claimDoorCount'},
                {data: 'claimCount'},
                {data: 'noClaimCount'},
                {data: 'checkHandleClaimCount'},
                {data: 'backCount'},
                {data: 'claimRate'} /*,
                {data: 'receiveRate'} ,
                {data: 'peerCount'},
                {data: 'checkCount'}*/ 
           ],
            columnDefs: [
                         
						{
							targets: 1,
						    render: function (data, type, row, meta) {
						    	  if(data!=null&&data!=""){
						    		  return data;
						    	  }else{
						    		  return ""; 
						    	  }
						    }
						}/*
                         {
                             targets: 10,
                             "visible": false
                         } ,
                         {
                             targets: 11,
                             "visible": false
                         },
                         {
                             targets: 12,
                             "visible": false
                         } ,
                         {
                             targets: 13,
                             "visible": false
                         } */
                         
            ],
            "footerCallback": function ( row, data, start, end, display ) {
                
                //接收条数总和
                var toReportReceiveCountSum=0;
                //同级属地推送总条数 不包括推送失败和回退
                var peerCount=0
                //备案推送总条数 不包括推送失败和回退
                var checkCount=0;
                //备案认领条数
                var claimCount=0; 
                //合计项在表格索引
                var dataArr=[3,4,5,6,7,8,9,10/*,11,12,13*/];
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
                       //备案认领条数总和
                       if(c==1){
                    	 checkCount=total;
                       } 
                       if(c==5){
                    	 claimCount=total;
                       }
                       //循环到认领率、接收率、备案推送总数、和抄告推送总数时不赋值 后面统一计算
                       if(c!=7&&c!=8&&c!=9&&c!=10){
                       	$( api.column( dataArr[c] ).footer() ).html(total); 
                       }
                   }
	                //当除数为0时直接赋值为0
	                if(checkCount==0||checkCount=="0"){
	                	$( api.column( 10).footer() ).html("0.00");
	                }else{
	                	 var sumYrAmountPer = (claimCount / checkCount) * 100;
	                	 //认领率
	                     $( api.column(10).footer() ).html(sumYrAmountPer.toFixed(2))
	                }/*
	                if(peerCount==0||peerCount=="0"){*/
	                	//$( api.column( 11).footer() ).html("0.00");
	                /*}else{*/
	                    // var sumYrWorkAmountPer = (toReportReceiveCountSum / peerCount) * 100; 
	                     //接收率
	                     //$( api.column( 11).footer() ).html(sumYrWorkAmountPer.toFixed(2));
	                //}
                }else{
                	for(var c=1;c<11;c++){ 
                		$( api.column(c).footer() ).html("-");
                	}
                	//$( api.column(11).footer() ).html("-");
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
                    	debugger
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
                    	$("#checkDep").val(data.adCodesExcParent);
                    	$("#checkDepName").val(data.orgNamesExcParent);
                   }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
                $("#checkDep").val("");
                $("#startCheckPushDate").val("");
                $("#endCheckPushDate").val("");
                $("#startCheckClaimDate").val("");
                $("#endCheckClaimDate").val("");
            }
        }
        ])
    }
})
