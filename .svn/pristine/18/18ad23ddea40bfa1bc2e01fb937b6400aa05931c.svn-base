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


    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user_table',
			showIndex: true,
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/opadetail/pubopadetail/pubOpadetailMoveListJSON.json',
                data:function(d){
                	if(clickFlag){
                		d.params = $.extend({}, searchParams, {"systemType":window._CONFIG._systemType,"isMove":"2"});               		
                	}else{
                		d.params = {"systemType":window._CONFIG._systemType,"isMove":"2"};
                	}
                }
            },
            columns: [
                  	{data: null,defaultContent:'id',width:'24px', className: 'center'}, 
                  	{data: null,defaultContent:'priPID', width: '100px', className: 'center'},
    				{data: 'regNO',width:'200px'},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'leRep'},
    				{data: 'estDate'},
    				{data: 'removeRea',cut: {length: 30,mark:'...'}},
     				{data: 'abnTime'},
    				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
    				{data: 'firstName'},
    				{data: 'firstdate'},
    				{data: 'auditState'},
    				{data: 'auditName'},
    				{data: 'auditDate'},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'checkDepName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}},  
    				{data: 'sliceNOName',cut: {length: 20,mark:'...'}}  
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 var auditState= row.auditState;
                            	  if("0"==auditState || "2"==auditState){
                            		  return '<a class="mod" id="'+row.busExcList+'" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >审核</a>';
                            	  }else{ 
                            		  return '<a class="view" id="'+row.busExcList+'" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >查看</a>\
                             			<a class="printtable" id="'+row.busExcList+'" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >打印审批表</a>';
                            	  }
                             }
                       },
                       {
                             targets: 11,
                             render: function (data, type, row, meta) {
                            	  if("0"==data){ 
                            		  return "待审核";
                            	  }else if("1"==data){ 
                            		  return "予以更正";
                            	  }else if("2"==data){ 
                            		  return "不予更正";
                            	  }else{
                            		  return "";
                            	  }
                             }
                       }
            ]
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	clickFlag = true;
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '.view',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '经营异常名录更正（撤销 ）- 查看',
                    area: ['80%', '70%'],
                    content: '/reg/server/opadetail/pubopadetail/opadetailView?busExcList='+busExcList+"&operate=1",
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.mod',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	var priPID=this.id;
            	layer.dialog({
                    title: '经营异常名录更正（撤销 ） - 审核',
                    area: ['80%', '70%'],
                    content: '/reg/server/opadetail/pubopadetail/opadetailAudit?busExcList='+busExcList+"&operate=1",
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.printtable', //打印审批表
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	 var _id = "_doPrint_"+new Date().getTime();
                 var url = "/reg/server/opadetail/pubopadetail/pubOpadetailPrintTable?busExcList="+busExcList;
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
        },
        {
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
            	$('.hidden_input').val('');//重置隐藏域
            }
        }
        ]);
    }

})
