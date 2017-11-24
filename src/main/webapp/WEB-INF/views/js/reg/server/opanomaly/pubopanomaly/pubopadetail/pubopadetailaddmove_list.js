require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
    var searchFlag = 0 ;
	
    init(); 
//    laydate.skin('molv');//初始化皮肤 (墨绿)
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数

    /**
     * 初始化函数集合
     */
    function init() {
//        initDataTable();
        bind();
      }


    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = 1;
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#addmove_table',
			showIndex: true,
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/opadetail/pubopadetail/OpadetailAddMoveListJSON.json',
                data:function(d){
                		d.params = $.extend({}, $("#taskForm").serializeObject(), {"systemType":window._CONFIG._systemType,"isMove":"1"});               		
                }
            },
            columns: [
                  	{data: null,defaultContent:'id',width:'24px', className: 'center'}, 
                  	{data: null,defaultContent:'priPID', width: '100px', className: 'center'},
    				{data: 'uniSCID',width:'200px'},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'penDecNo'},
    				{data: 'speCauseCN',cut: {length: 30,mark:'...'}},
    				{data: 'abnTime'},
    				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}}  
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) { 
                           		      return '<input type="radio" name="_radio"  value='+row.busExcList+'>';
                             }
                       },
                       {
                           targets: 2,
                           render: function (data, type, row, meta) {
                          	  if(data == null || data == ""){ 
                          		  return row.regNO;
                          	  }else{
                          		  return data;
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
    	if(searchFlag==0){
            initDataTable();
    	}
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '#back',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/opadetail/pubopadetail/opadetailMoveSearchList?moveFlag=1&systemType='+window._CONFIG._systemType;
            }
        },{
            el: '#moveApply',
            event: 'click',
            handler: function () { 
            	var busExcList= $(":radio[name=_radio]:checked").val();
            	if(busExcList==null||busExcList==''){
            		 layer.msg("请选择企业再操作", {ltype: 0,time:500});
                     return false;
            	}
            	layer.dialog({
                    title: '经营异常名录移出申请 - 添加',
                    area: ['1024px', '700px'],
                	content: '/reg/server/opadetail/pubopadetail/opadetailAddMove?busExcList='+busExcList+'&operate=0',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
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
        }, {
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
            	var codeList;
            	var entType = window._CONFIG._systemType;
            	if(entType == '1'){
            		codeList = 'inCodeForEntList';
            	}else if(entType == '2'){
            		codeList = 'inCodeForSfcList';
            	}
                layer.dialog({
                    title: '列入原因',
                    area: ['600px', '350px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=+inCodeForEntList',
                    callback: function (data) {
                        if(data){
                            $("#speCause").val(data.id);
                            $("#speCauseText").val(data.text);
                        }
                    }
                })                 
            	
            	
            	
//            	layer.dialog({
//                    title: '列入原因',
//                    area: ['580px', '300px'],
//                    content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
//                    callback: function (data) {
//                        if(data){
//                            $("#speCause").val(data.id);
//                            $("#speCauseText").val(data.text);
//                        }
//                    }
//                })
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
