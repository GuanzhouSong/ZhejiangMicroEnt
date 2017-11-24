require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
       // initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
            async: false,
            ajax: {
                url: window._CONFIG.chooseUrl+'/pubdtinfo/searchlist.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                      {data: null,defaultContent:'id',width:'5%', className: 'center'},
                      {data: 'exaName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'entName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'regOrgName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'checkPushDate',width:'20px'},
                      {data: 'checkDeptType',width:'20px'},
                      {data: 'deptName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'checkDepName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'dutyDeptName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'uniSCID',width:'20px'},
                      {data: 'regNO',width:'20px'},
                      {data: 'claimState',width:'20px'},
                      {data: 'receiveState',width:'20px'},
                      {data: 'dom',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'opScope',width:'200px',cut: {length: 20,mark:'...'}},
                      {data: 'apprDate',width:'20px'},
                      {data: 'claimDate',width:'20px'},
                      {data: 'acceptDate',width:'20px'},
                      {data: 'checkPushType',width:'20px'},
                      {data: 'checkStopState',width:'20px'},
                      {data: 'checkRegType',width:'20px'},
                      {data: 'leRep',width:'20px'},
                      {data: 'tel',width:'20px',cut: {length: 20,mark:'...'}}
                      
            ],
             columnDefs : [
							{
								targets : 5,
								render : function(data, type, row, meta) {
									if (row.checkDeptType == '1') {
										return "审批机关";
									}else if (row.checkDeptType == '2') {
										return "属地机关";
									}else if (row.checkDeptType == '3'){
										return "同级机关";
									}else{
										return "";
									}
								}
							},
							{
								targets : 11 ,
								render : function(data, type, row, meta) {
										if(row.claimState == '0'){
											return "未认领";
										}else if(row.claimState == '1'){
											return "已认领";
										}else{
											return "";	
										}
								}
							},
							{
								targets : 12,
								render : function(data, type, row, meta) {
										if(row.receiveState == '0'){
											return "未接收";
										}else if(row.receiveState == '1'){
											return "已接收";
										}else{
											return "";	
										}
								}
							},
							{
								targets : 18,
								render : function(data, type, row, meta) {
//									debugger
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
								targets : 19,
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
								targets : 20,
								render : function(data, type, row, meta) {
									if (row.checkRegType == '1') {
										return "新增许可事项";
									}else if (row.checkRegType == '2') {
										return "变更许可事项";
									}else{
										return "";
									}
								}
							}],
		    "fnDrawCallback": function (oSettings) {
			http.httpRequest({ 
                url: window._CONFIG.chooseUrl+'/pubdtinfo/searchCount',
                serializable: false,
                type:'post',
                data: {params:searchParams} ,
                success: function (data) {
                	var list = data.data;
                    if (data.status == 'success') {  
                    	//推送成功条数 
						$("#sendSuccessCount").text(list[0]);
						//推送失败条数 
						$("#sendFail").text(list[1]);
						//退回待推送条数 
						$("#rebackCount").text(list[2]);
						//终止推送条数 
						$("#pushStopCount").text(list[3]);
						//推送企业条数  
						$("#sendBusinessCount").text(list[4]);
						//推送审批部门条数  
						$("#sendDeptCount").text(list[5]);
                    }else{
                    	$("#sendSuccessCount").text("0");
						$("#sendFail").text("0");
						$("#rebackCount").text("0");
						$("#sendBusinessCount").text("0");
						$("#sendDeptCount").text("0");
						$("#pushStopCount").text("0");
                    } 
                }
            });
		},
		"fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {//设置推送失败或退回待推送企业背景色为黄色
             if(aData.checkPushType=='0'|| aData.checkPushType=='3'){
            	 nRow.style.backgroundColor="yellow";
             } 
          }

        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject(); 
        if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		 table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([{
        	  el: '#user-table tr',
              event: 'click',
              handler: function () {
              	var data = table.row($(this)).data();
                  layer.dialog({
                      title: '',
                      area: ['65%', '68%'],
                      content: window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailInfo?priPId='+data.priPID+'&uid='+data.uid,
                      callback: function (data) {
                          //重新加载列表数据
                          if (data.reload) {
                              table.ajax.reload();
                          }
                      }
                  })
              }
        },
        {
            el: '#yccodetree',  //后置审批事项
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择后置审批事项',
                    area: ['500px', '600px'],
                    content: window._CONFIG.chooseUrl+'/pubdtinfo/codeLicenseCheckboxTreePage',
                    callback: function (data) { 
                    	if(typeof data.reload.code=="undefined"){
                    		$("#exaCode").val("");
                         	$("#exaName").val("");
                    	}else{
                    		 $("#exaCode").val(data.reload.code);
                         	 $("#exaName").val(data.reload.content);
                    	} 
                    }
                })
            }
        },
        {
            el: '#qzcodetree',  //前置审批事项
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择前置审批事项',
                    area: ['500px', '600px'],
                    content: window._CONFIG.chooseUrl+'/pubdtinfo/licenseListCheckboxTreePage',
                    callback: function (data) { 
                    	if(typeof data.reload.code=="undefined"){
                    		$("#qzCode").val("");
                         	$("#qzName").val("");
                    	}else{
                    		 $("#qzCode").val(data.reload.code);
                         	 $("#qzName").val(data.reload.content);
                    	} 
                    }
                })
            }
        },
        {
            el: '#selectDept', //审批部门
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	var adcodes = data.adCodes;
                    	var orgNames = data.orgNames;
                    	$("#checkDep").val(data.adCodesExcParent);
                    	$("#checkDepName").val(data.orgNamesExcParent);
                   }
                })
            }
        },
        {
            el: '#industryCotree', //行业类型
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择行业',
                    area: ['400px', '600px'],
                    content: '/commom/server/industry/toIndustryPhyTree',
                    callback: function (data) {
//                    	console.log(data);
                    	$("#industryCo").val(data.returncodes);
                    	$("#industryCoName").val(data.returnname);
                   }
                })
            }
        },
        {
            el: '#choseorgReg', //登记机关
            event: 'click',
            handler: function () { 
          	  layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect',
                    callback: function (data) { 
//                    	console.log(data);
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
                    }
                })
            }
        },{
            el: '#reset', //重置
            event: 'click',
            handler: function () {
            	$('.hidden_input').val('');//重置隐藏域
            }
        }
        ])
    }

})
