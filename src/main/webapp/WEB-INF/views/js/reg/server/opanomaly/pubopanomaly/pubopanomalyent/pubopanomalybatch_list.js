require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
	
    init();
    //时间控件初始化
    // laydate.skin('molv');//初始化皮肤 (墨绿)
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
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
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/opanomaly/pubopanomaly/selectBatchInListJson.json',
                data:function(d){
                		d.params =  $("#taskForm").serializeObject();               		
                }
            },
            columns: [
                  	{data: null,defaultContent:'id',width:'24px', className: 'center'}, 
                  	{data: null,defaultContent:'priPID', width: '100px', className: 'center'},
    				{data: 'year',width: '50px',},
    				{data: 'batchEntType',cut: {length: 20,mark:'...'}},
    				{data: 'initBatchNum'},
    				{data: 'initBatchNum'},
    				{data: 'batchRemoveNum'},
    				{data: 'abnTime',cut: {length: 30,mark:'...'}},
     				{data: 'penDecNo'},
    				{data: 'speCauseCN',cut: {length: 20,mark:'...'}},
    				{data: 'decorgCN'},
    				{data: 'firstName'},
    				{data: 'firstdate'},
    				{data: 'auditName'},
    				{data: 'auditDate'} 
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                                		  return '<a class="view" id="'+row.penDecNo+'" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >详情</a>\
                               			<a class="printtable" id="'+row.busExcList+'" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >打印审批表</a>\
                               			<a class="printbook" id="'+row.busExcList+'" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >打印决定书</a>'; 
                             }
                       },
                       {
                             targets: 3,
                             render: function (data, type, row, meta) {
                            	  if("1"==data){ 
                            		  return "内资企业";
                            	  }else if("2"==data){ 
                            		  return "农专社";
                            	  }else if("3"==data){
                            		  return "外资企业";
                            	  }else{
                            		  return "";
                            	  }
                             }
                       },
                       {
                           targets: 5,
                           render: function (data, type, row, meta) {
                          	  return (row.initBatchNum-row.batchRemoveNum < 0 ? 0 : row.initBatchNum-row.batchRemoveNum);
                           }
                     }
            ]
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	clickFlag = true;
     	var ivalStr="";
    	$(":checkbox[name=entCatg]:checked").each(function(k,v){
        	ivalStr+=this.value+",";
        });
    	$("#batchEntTypes").val(ivalStr.substr(0,ivalStr.length-1));
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '#addBatchIn',//进入批量添加页面
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/opanomaly/pubopanomaly/selectBatchInAddList';
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '经营异常管理 - 批量列入 - 查看',
                    area: ['1024px', '80%'],
                    content: '/reg/server/opanomaly/pubopanomaly/showDetail?penDecNo='+data.penDecNo+"&initBatchNum="+data.initBatchNum,
                    callback: function (data) {
                    }
                })
            }
        },{
            el: '.printtable',//打印审批表
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
             	var data = table.row($(this).closest('td')).data();
            	 var _id = "_doPrint_"+new Date().getTime();
                 var url = "/reg/server/opanomaly/pubopanomaly/printBatchTable?penDecNo="+data.penDecNo+"&initBatchNum="+data.initBatchNum;
                 try{
                     window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                 }catch(e){
                     alert("打印错误!");
                 }
            }
        },{
            el: '.printbook', //打印决定书
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
             	var data = table.row($(this).closest('td')).data();
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = "/reg/server/opanomaly/pubopanomaly/printBatchBook?penDecNo="+data.penDecNo+"&initBatchNum="+data.initBatchNum;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
                    }
                })
            }
        },{
            el: '#choseCheckDep',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽检机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#checkDep").val(returncode);
                    	$("#checkDepName").val(returnname);
                    }
                })
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
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
            el: '#chosesliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择责任区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNOName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#select-intercept',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '移出原因',
                    area: ['580px', '300px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=canOutReaCodeList',
                    callback: function (data) {
                        if(data){
                            $("#remExcpres").val(data.id);
                            $("#remExcpresText").val(data.text);
                        }
                    }
                })
            }
        }, {
            el: '#select-intercept_in',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '列入原因',
                    area: ['580px', '300px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
                    callback: function (data) {
                        if(data){
                            $("#speCause").val(data.id);
                            $("#speCauseText").val(data.text);
                        }
                    }
                })
            }
        },
        {
            el: '#reset', //重置
            event: 'click',
            handler: function () {
            	//重置隐藏域
            	$("#batchEntTypes").val('1,2,3');
            	$("#decOrg").val(window._CONFIG._decOrg);
            }
        }
        ]);
    }

})
