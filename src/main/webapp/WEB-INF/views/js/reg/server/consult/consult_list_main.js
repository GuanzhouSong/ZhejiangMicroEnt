require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
  
    init();
    //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startBackTime', //选择ID为START的input
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
        elem: '#endBackTime',
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
    
    var startNorDate = {
            elem: '#startConsultTime', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
            	endNorDate.min = datas; //开始日选好后，重置结束日的最小日期
            	endNorDate.start = datas //将结束日的初始值设定为开始日
            }
        };
        var endNorDate = {
            elem: '#endConsultTime',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            startNorDate: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            	startNorDate.max = datas; //结束日选好后，重置开始日的最大日期
            }
        }; 
         
    
    //开始时间和结束时间
    $("#startBackTime").click(function(){laydate(start);});
    $("#endBackTime").click(function(){laydate(end);}); 

    $("#startConsultTime").click(function(){laydate(startNorDate);});
    $("#endConsultTime").click(function(){laydate(endNorDate);});
    
     
    
    
    /**
     * 初始化函数集合
     */
    function init() {
         initDataTable();
        bind();
        }



    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
     	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
            "aLengthMenu": [10, 25, 50, 100],
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/consult/selectConsultInfoDtoSearchListJSON.json',
                data:function(d){
                   d.params = $.extend({}, searchParams, {"removePermit":"1"});
                }
            },
            columns: [ 
                    {data: null,'defaultContent':'11'}, 
                  	{data: null, width:"250px" ,defaultContent:'id' },
                  	{data: 'state',cut: {length: 20,mark:'...'}},
                 	{data: 'uniSCID',cut: {length: 20,mark:'...'}},
    				{data: 'regNO'},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}},
    				{data: 'consultTitle',cut: {length: 20,mark:'...'}},
    				/*{data: 'consultName',cut: {length: 20,mark:'...'}},*/
     				{data: 'consultContent',cut: {length: 20,mark:'...'}},
     				{data: 'consultTime',cut: {length: 20,mark:'...'}},
    				{data: 'backName',cut: {length: 20,mark:'...'}},
    				{data: 'backContent',cut: {length: 20,mark:'...'}},
    				{data: 'backTime',cut: {length: 20,mark:'...'}} 
            ] ,
            columnDefs: [
                          {
                             targets: 1,
                             render: function (data, type, row, meta) { 
                            	var state= row.state;
                            	if(state=="0"){
                            		return  '<a class="back link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">反馈</a>';
                            	}else{
                            		return  '<a class="viewdetail link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">详情</a>';
                            	}
                             }
                          },
                          {
                              targets: 2,
                              render: function (data, type, row, meta) { 
                             	var state= row.state;
                             	if(state=="0"){
                             		return  '未反馈';
                             	}else{
                             		return  '已反馈';
                             	}
                              }
                           } 
            ]
         })
    }    

    function bind() {
        util.bindEvents([ 
        {
            el: '.back',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var uid=data.uid;
                 layer.dialog({
                    title: '异议反馈',
                    area: ['100%', '100%'],
                    content:'/reg/server/consult/toServerConsultEditPage?uid='+uid+"&flag=1",
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        },
        {
            el: '.viewdetail',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var uid=data.uid;
                 layer.dialog({
                    title: '详情',
                    area: ['100%', '100%'],
                    content:'/reg/server/consult/toServerConsultEditPage?uid='+uid+"&flag=2",
                    callback: function (data) {
                    	  
                    }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#remExcpres").val("");
                $("#speCause").val("");
                $("#sliceNO").val("");
            }
        } ,{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择管辖单位',
                    area: ['25%', '60%'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;	 
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(returnname);
                    }
                })
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
            	 layer.dialog({
                     title: '选择登记机关',
                     area: ['25%', '60%'],
                     content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                     callback: function (data) {
                    	var returncode=data.returncodes;
                     	var returnname=data.returnname;
                     	$("#regOrg").val(returncode);
                     	$("#regOrgName").val(returnname);
                     }
                 })
            }
        }, {
        	el: '#search',
            event: 'click',
            handler: function () { 
            	//查询结果显示区域
            	searchParams = $("#taskForm").serializeObject();
             	if(searchFlag=="0"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        }
        ]);
    }

})
