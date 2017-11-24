require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 
        'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }
    var table;

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
            	type : "POST",
                url:'/reg/server/yr/individquestionnaire/surQuantity.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
            	{data: '_idx'},
            	{data : 'regOrgName'},
            	{data : 'count'},
            	{data : 'taxpayerTypeCommTotal'},
    		    {data : 'taxpayerTypeSmallscaleTotal'},
    		    {data : 'hasQueFaith'},
    		    {data : 'noQueFaith'},
    		    {data : 'notSure'},
    		    {data : 'quePolicyAllTotal'},
    		    {data : 'quePolicyPartTotal'},
    		    {data: 'quePolicySocTotal'}
            ],
            columnDefs: [
            ],
            "footerCallback": function ( row, data, start, end, display ) {
                
                //接收条数总和
                var toReportReceiveCountSum=0;
                //同级属地推送总条数 不包括推送失败和回退
                var peerCount=0
                //审批推送总条数 不包括推送失败和回退
                var checkCount=0;
                //审批认领条数
                var claimCount=0; 
                //合计项在表格索引
                var dataArr=[2,3,4,5,6,7,8,9,10];
                var api = this.api(); 
                if(data!=null&&data.length!=0){
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
                	for(var c=2;c<11;c++){ 
                		$( api.column(c).footer() ).html("0");
                	}
                }
            } 
        })
    }

    $("#js-search-1").click(function(){
    	var countType = $("input[type='radio']:checked").val();
    	if(countType=="1"){
    		$("#taskForm").attr("action", "individCount");
    		$("#taskForm").submit();
    	}else{
    		searchParams = $("#taskForm").serializeObject();
    		table.ajax.reload();
    	}
    });
    
    function bind() {
        util.bindEvents([
        	{
        	el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?areaFlag=1',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#year").val("");
            	$("#setDateStart").val("");
            	$("#setDateEnd").val("");
        		$("#area").val("");
        		$("#regOrgName").val("");
        		$("#regOrg").val("");
            }
        },{
            el: '#riseRate',
            event: 'click',
            handler: function () { 
        		$("#div1").css("display","block");
        		$("#div2").css("display","none");
            }
        },{
            el: '#investMethod',
            event: 'click',
            handler: function () { 
            	$("#div2").css("display","block");
        		$("#div1").css("display","none");
        		initDataTable();
            }
        }])
    }

})
