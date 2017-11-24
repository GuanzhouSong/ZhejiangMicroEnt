require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchFlag="0";
    var searchParams={};//查询参数声明!
    var table;
   //警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
  
    init();
  
    
    var startNorDate = {
            elem: '#startInfaustlDate', //选择ID为START的input
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
            elem: '#endInfaustlDate',
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
    
    
    $("#startInfaustlDate").click(function(){laydate(startNorDate);});
    $("#endInfaustlDate").click(function(){laydate(endNorDate);});
    
    
    
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
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:_sysUrl+'/creditproveinfo/selectCreditProveInfoJSON.json',
                data:function(d){ 
                	d.params = searchParams;
                }
            },
            columns: [ 
					{data: null,'defaultContent':'11'},
					{data: null,width:"100px"},
					{data: 'uniSCID'}, 
					{data: 'entName',cut: {length: 20,mark:'...'}},
					{data: 'proveType',cut: {length: 20,mark:'...'}},
					{data: 'setDate',cut: {length: 20,mark:'...'}},
					{data: 'proveNo',cut: {length: 20,mark:'...'}},
					{data: 'setName',cut: {length: 20,mark:'...'}},
					{data: 'setDept',cut: {length: 20,mark:'...'}},
					{data: 'printCount'}
    				
            ] ,
            columnDefs: [
                          {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 return  '<a class="printprove link" id="'+row.proveNo+'"  href="javascript:void(0);" style="color:blue;">打印查证单</a>'+
                            	   '<a class="view link" id="'+row.proveNo+'"  href="javascript:void(0);" style="color:blue;">详情</a>';
                            	 ;
                             }
                          } ,
                          {
                              targets: 2,
                              render: function (data, type, row, meta) {
                            	  
                             	 var proveType= row.proveType; 
                             	 if("1"==proveType){//企业
                             		 if(row.uniSCID!=null&&row.uniSCID!=""){
                             			return row.uniSCID;
                             		 }else{
                             			return row.regNO;
                             		 }
                             	 }else if("2"==proveType){//严重违法
                             		 return row.cerNO;
                             	 }else {
                             		 return "";
                             	 } 
                              }
                           } ,
                           {
                               targets: 3,
                               render: function (data, type, row, meta) {
                              	 var proveType= row.proveType; 
                              	 if("1"==proveType){//企业 
                              			return row.entName; 
                              	 }else if("2"==proveType){//个人
                              		 return row.name;
                              	 }else {
                              		 return "";
                              	 } 
                               }
                            },
                           {
                               targets: 4,
                               render: function (data, type, row, meta) { 
                              	 var proveType= row.proveType; 
                              	 if("1"==proveType){//企业
                              		 return "企业";
                              	 }else if("2"==proveType){//严重违法
                              		 return "个人";
                              	 }else {
                              		 return "";
                              	 } 
                               }
                            }  ,
                            {
                                targets: 9,
                                render: function (data, type, row, meta) { 
                               	 var printCount= row.printCount; 
                               	 if(printCount==null||printCount==""){
                               		 return "0";
                               	 }
                               	 return printCount;
                                }
                             } 
            ],
            fnDrawCallback:function( nRow){
              	 //统计查询结果
              	 getEntCount();
              } 
         })
    } 
    
    
    
    //统计查询结果
    function  getEntCount(){ 
        http.httpRequest({
            url:_sysUrl+'/creditproveinfo/getEntCount',
            serializable: false,
            data: null,
            type: 'post',
            success: function (data) { 
         	    $("#proveInfoCount").text(data.data.proveInfoCount);
         	    $("#entCount").text(data.data.entCount);
         	    $("#manCount").text(data.data.manCount);
            }
        });
     }
    
  
     

    function bind() {
        util.bindEvents([
      {
            el: '#add',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择信用状况查证类别',
                    area: ['350px', '170px'],
                    content: _sysUrl+'/creditproveinfo/entrance',
                    callback: function(data) {
                    	
                    	if(data.url !=undefined){
                    		try {
                            	window.location.href=data.url;
                			} catch (e) {
                				window.open(data.url, "_self");
                			}
                    	}
                    }
                })
            }
        },{
        	el: '#search',
            event: 'click',
            handler: function () {
            	//查询结果显示区域
            	var ivalStr="";
            	$(":checkbox[name=proveTypeStr]:checked").each(function(k,v){
                	var ival=this.value;
                	ivalStr+=ival+",";
                });
            	$("#proveType").val(ivalStr);
            	$("#searchFlag").val(searchFlag);
            	searchParams = $("#taskForm").serializeObject();
             	if(searchFlag=="0"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        },
        {
            el: '.view',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var proveNo=data.proveNo;
                 layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content: _sysUrl+'/creditprovelist/viewDetail?proveNo='+proveNo,
                    callback: function (data) {
                    	 
                    }
                })
            }
        },
        {
            el: '.printprove',
            event: 'click',
            handler: function () { 
            	 var data = table.row($(this).closest('td')).data();
            	 var proveNo=data.proveNo;
            	 var _id = "_doPrint_"+new Date().getTime();
                 var url = _sysUrl+'/creditprovelist/print?proveNo='+proveNo;
                  try{
                      window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                  }catch(e){
                      alert("打印错误!");
                  }
            }
        } 
        ]);
    }

})
