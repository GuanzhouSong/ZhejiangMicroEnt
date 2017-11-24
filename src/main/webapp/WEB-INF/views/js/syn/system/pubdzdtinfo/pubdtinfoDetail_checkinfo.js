require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/pubdzdtinfo/searchlist.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                      {data: null,width:'5%', className: 'center'},
                      {data: 'exaName',width:'20px'},
                      {data: 'entName',width:'20px' },
                      {data: 'regOrgName',width:'20px'},
                      {data: 'checkPushDate',width:'20px'},
                      {data: 'checkDeptType',width:'20px'},
                      {data: 'uniSCID',width:'20px'},
                      {data: 'regNO',width:'20px'},
                      {data: 'checkDeptName',width:'20px'},
                      {data: 'claimState',width:'20px'},
                      {data: 'receiveState',width:'20px'},
                      {data: 'dom',width:'20px'},
                      {data: 'opScope',width:'200px'},
                      {data: 'domDistrictName',width:'20px'},
                      {data: 'apprDate',width:'20px'},
                      {data: 'claimDate',width:'20px'},
                      {data: 'acceptDate',width:'20px'},
                      {data: 'checkPushType',width:'20px'},
                      {data: 'checkStopState',width:'20px'},
                      {data: 'checkRegType',width:'20px'},
                      {data: 'leRep',width:'20px'}
            ],
             columnDefs : [
							{
								targets : 5,
								render : function(data, type, row, meta) {
									if (row.checkDeptType == '1') {
										return "审批机关";
									}else if (row.auditState == '2') {
										return "属地机关";
									}else if (row.auditState == '3'){
										return "同级机关";
									}else{
										return "";
									}
								}
							},
							{
								targets : 9 ,
								render : function(data, type, row, meta) {
									if (row.checkDeptType == '1') {
										if(row.claimState == '0'){
											return "未认领";
										}else if(row.claimState == '1'){
											return "已认领";
										}else{
											return "";	
										}
									}else{
										return "";
									}
								}
							},
							{
								targets : 10,
								render : function(data, type, row, meta) {
									if (row.checkDeptType != '2') {
										if(row.receiveState == '0'){
											return "未接收";
										}else if(row.receiveState == '1'){
											return "已接收";
										}else{
											return "";	
										}
									}else{
										return "";
									}
								}
							},
							{
								targets : 17,
								render : function(data, type, row, meta) {
									if (row.checkPushType == '0') {
										return "退回待推送";
									}else if (row.checkPushType == '1') {
										return "自动推送";
									}else if (row.checkPushType == '2') {
										return "手动推送";
									}else if (row.checkPushType == '3') {
										return "推送失败";
									}else{
										return "";
									}
								}
							},
							{
								targets : 18,
								render : function(data, type, row, meta) {
									if (row.checkStopState == '0') {
										return "未终止推送";
									}else if (row.checkStopState == '1') {
										return "已终止推送";
									}else{
										return "";
									}
								}
							},
							{
								targets : 19,
								render : function(data, type, row, meta) {
									if (row.checkRegType == '1') {
										return "新设";
									}else if (row.checkRegType == '2') {
										return "变更";
									}else{
										return "";
									}
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
        	  el: '#user-table tr',
              event: 'click',
              handler: function () {
              	var data = table.row($(this)).data();
                  layer.dialog({
                      title: '',
                      area: ['65%', '65%'],
                      content: '/syn/pubdzdtinfo/searchDetailTab?priPId='+data.priPID+'&uid='+data.uid,
                      callback: function (data) {
                          //重新加载列表数据
                          if (data.reload) {
                              table.ajax.reload();
                          }
                      }
                  })
              }
        }
        ])
    }

})
