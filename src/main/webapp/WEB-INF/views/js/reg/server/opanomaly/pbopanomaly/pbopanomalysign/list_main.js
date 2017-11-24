require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
 
    var searchParams={};//查询参数声明!
    var clickFlag = false ;
    var table;
	init();
    //  laydate.skin('molv');//初始化皮肤 (墨绿)
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});    /**
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
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/opanomaly/pbopanomaly/panoQueryPage',
                data:function(d){
                	d.params = $.extend({}, $("#taskForm").serializeObject(), {"entTypeCatg":"50","regState":"A,B,K,DA"});
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                  	{data: null, defaultContent:'id', className: 'center',width: "40px",},
                  	{data: null, defaultContent:'priPID', width: "60px", className: "center"},
    				{data: 'regNO'},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'leRep'},
    				{data: 'tel'},
    				{data: 'dom',cut: {length: 20,mark:'...'}}, 
    				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
    				{data: 'localAdmName',cut: {length: 20,mark:'...'}}
             ],
             columnDefs: [
                          {
                              targets: 1,
                              render: function (data, type, row, meta) {
                          		  return '<a class="js-sign" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >标记异常</a>';
                              }
                          }
                      ]
        });
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	clickFlag =true;
        table.ajax.reload();
    });
    
    function bind() {
    	 util.bindEvents([{
             el: '.js-sign',
             event: 'click',
             handler: function () {
            	  var data = table.row($(this).closest('td')).data();
                 layer.dialog({
                     title: '新增异常标记',
                     area: ['1024px', '500px'],
                     content: '/reg/server/opanomaly/pbopanomaly/tosign?regNO='+data.regNO+'&priPid='+data.priPID,
                     callback: function(data){
                    	 if (data.reload) {
                             table.ajax.reload();
                         }
                     }
                 });
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
//                      	console.log(data);
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
             el: '#select-intercept-out',
             event: 'click',
             handler: function () {
                 layer.dialog({
                     title: '移出原因',
                     area: ['580px', '300px'],
                     content: '/commom/server/intercept/interceptselect?selecttype=indiOutReaCodeList',
                     callback: function (data) {
                         if(data){
                             $("#excpStaRes").val(data.id);
                             $("#excpStaResText").val(data.text);
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
                     content: '/commom/server/intercept/interceptselect?selecttype=indiInReaCodeList',
                     callback: function (data) {
                         if(data){
                             $("#norRea").val(data.id);
                             $("#norReaText").val(data.text);
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

});
