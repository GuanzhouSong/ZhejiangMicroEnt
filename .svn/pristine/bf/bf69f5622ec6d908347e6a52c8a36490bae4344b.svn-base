require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
	var searchParams={};//查询参数声明!
    var comInfotable;
    var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
       // initDataTable();
        bind();
      }


    

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	 searchFlag="1";
    	 var url=_sysUrl+'/cominfocheck/comInfoCheckDtoListJSON.json';
    	 searchParams = $("#taskForm").serializeObject();
    	 comInfotable = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:url,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'uniCode',cut: {length: 20,mark:'...'}},
                {data: 'regNO',cut: {length: 20,mark:'...'}}, 
                {data: 'entName',cut: {length: 20,mark:'...'}},
                {data: 'year'},
                {data: 'leRep',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',cut: {length: 20,mark:'...'}},
                {data: 'localAdmName',cut: {length: 20,mark:'...'}},
                {data: 'declStatus'},
                {data: 'checkOpinSfc',cut: {length: 20,mark:'...'}},
                {data: 'checkOpinBur',cut: {length: 20,mark:'...'}},
                {data: 'checkOpinBank',cut: {length: 20,mark:'...'}},
                {data: 'dom',cut: {length: 20,mark:'...'}}
             ],
             columnDefs : [ 
							{
								targets: 8,
							    render: function (data, type, row, meta) {
							    	if (row.declStatus == '0') {
										return "未申报";
									}else  if (row.declStatus == '1') {
										return "申报待核实";
									} else  if (row.declStatus == '2') {
										return "已核实";
									} else  if (row.declStatus == '3') {
										return "已退回";
									} else  if (row.declStatus == '4') {
										return "申请修改";
									} else{
										return "";
									}
							    }
							}
							]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject(); 
    	if(searchFlag=="0"){
     		initDataTable();
     	}else{
     		comInfotable.ajax.reload();
     	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '#user-table tr',
            event: 'click',
            handler: function () {
            	 
	             var data = comInfotable.row($(this)).data();
	             //主体身份代码
	             var priPID= data.priPID;
	             //年报年度
	             var year=data.year; 
	             //部门类型  0 农业 1 工商 2 农信
	             var deptType=$("#deptType").val();  
	             var msg="审核";
	             if(deptType!="0"){
	            	 msg="意见录入"; 
	             }
	             layer.dialog({
	                title: '农专报表'+msg,
	                area: ['100%', '100%'],
	                content: _sysUrl+'/cominfocheck/sfcassetliaTabEdit?priPID='+priPID+"&year="+year+"&deptType="+deptType,
	                callback: function (data) {
	                	if(typeof data.reload!="undefined" &&data.reload==true){
	                		comInfotable.ajax.reload();
	                	}
	                }
	            })
            }
        },
        {
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
            	 layer.dialog({
                     title: '选择登记机关',
                     area: ['25%', '60%'],
                     content: '/commom/server/regorg/regorgmutiselectnocheck',
                     callback: function (data) {
                         //重新加载列表数据
                         $("#regOrg").val(data.returncodes);
                         $("#regOrgName").val(data.returnname);
                     }
                 })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            }
        }
        ])
    }

})
