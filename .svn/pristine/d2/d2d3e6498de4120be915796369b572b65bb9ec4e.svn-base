require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
 	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
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
     	 var url=_sysUrl+'/pubdtinfo/pubdtinfoFailReBackListJSON.json';
         table = dataTable.load({
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
                {data: null,width:"50px",'defaultContent':'11'},
                {data: 'exaName',cut: {length: 20,mark:'...'}}, 
                {data: 'entName',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',cut: {length: 20,mark:'...'}},
                {data: 'checkPushDate',cut: {length: 20,mark:'...'}},
                {data: 'checkDeptType',cut: {length: 20,mark:'...'}}, 
                {data: 'deptName',cut: {length: 20,mark:'...'}},
                {data: 'checkDepName',cut: {length: 20,mark:'...'}},
                {data: 'dutyDeptName',cut: {length: 20,mark:'...'}}, 
                {data: 'reassignDeptName',cut: {length: 20,mark:'...'}},
                {data: 'reassignDate',cut: {length: 20,mark:'...'}},
                {data: 'reassignCode',cut: {length: 20,mark:'...'}},
                {data: 'uniSCID',cut: {length: 20,mark:'...'}},
                {data: 'regNO',cut: {length: 20,mark:'...'}},
                {data: 'checkPushType',cut: {length: 20,mark:'...'}},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'opScope',cut: {length: 20,mark:'...'}},
                {data: 'apprDate','defaultContent':'11'},
                {data: 'checkRegType',cut: {length: 20,mark:'...'}},
                {data: 'leRep','defaultContent':'11'},
                {data: 'tel',width:'20px',cut: {length: 20,mark:'...'}}
            ],
             columnDefs : [
							{
								targets: 1,
							    render: function (data, type, row, meta) {
							    	  return '<input type="radio" name="_radio"  value='+row.uid+'>';
							    }
							},
							{
								targets: 6,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return "审批机关";
									}else  if (row.checkDeptType == '2') {
										return "属地机关";
									} else  if (row.checkDeptType == '3') {
										return "同级机关";
									} else{
										return "";
									}
							    }
							},
							{
								targets: 12,
							    render: function (data, type, row, meta) { 
							    	if(row.checkPushType=="0"){
							    		if (row.reassignCode == '0') {
											return "经营范围内无此审批事项";
										}else  if (row.reassignCode == '1') {
											return "经营范围不在本部门的管辖范围内";
										} else  if (row.reassignCode == '2') {
											return "地址不在本部门的管辖范围内";
										} else{
											return "";
										}
							    	}else{
										return "";
									}
							    }
							},
							{
								targets : 15,
								render : function(data, type, row, meta) {
									if (row.checkPushType == '0') {
										return "退回待推送";
									}else if (row.checkPushType == '1') {
										return "自动推送";
									}else  if (row.checkPushType == '2') {
										return "手动推送";
									} else  if (row.checkPushType == '3') {
										return "推送失败";
									} else{
										return "";
									}
								}
							}, {
								targets : 19,
								render : function(data, type, row, meta) {
									if (row.checkRegType == '1') {
										return "新增许可事项";
									}else if (row.checkRegType == '2') {
										return "变更许可事项";
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
    	searchParams = $("#taskForm").serializeObject(); 
    	table.ajax.reload(); 
    }); 

    function bind() {
        util.bindEvents([{
            el: '#pubdtinfohandpushlist',
            event: 'click',
            handler: function () {
            	
            	var radioArr= $(":radio[name=_radio]:checked");
            	if(radioArr==null||radioArr.length==0){
            		 layer.msg("请选择企业再操作", {ltype: 0,time:2000});
                     return false;
            	}
                layer.dialog({
                    title: '涉证企业分流',
                    area: ['90%', '90%'],
                    content: _sysUrl+'/pubdtinfo/pubdtinfoHandPush?uid='+radioArr[0].value,
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
            el: "#pubDtInfoPush",
            event: 'click',
            handler: function () { 
            	 layer.dialog({
                     title: '手动触发分流',
                     area: ['50%', '40%'],
                     content: '/quartz/pubDtInfoPush/pubdtinfoMaintainPush',
                     callback: function (data) { 
                    	 if(typeof data.status!="undefined"){
                    		 if(data.status=="success"){ 
                        		 layer.msg(data.msg, {time: 3000}, function () {
                                  	layer.close({reload: false});
                                  });
                        	 }else{
                        		 layer.msg("分流失败", {ltype: 0,time:3000});
                        	 } 
                    	 }
                     }
                 })
            }
        },
        {
            el: "#pubDtInfoFailPush",
            event: 'click',
            handler: function () {
            	 http.httpRequest({
                     url: '/quartz/pubDtInfoPush/pubFailPush',
                     serializable: false,
                     data: null,
                     type: 'post',
                     success: function (data) { 
                    	 if(data.status=="success"){
                    		 layer.msg(data.msg, {ltype: 0,time:2000});
                    	 }else{
                    		 layer.msg("分流失败", {ltype: 0,time:2000});
                    	 } 
                     }
                 });
            }
        },
        {
            el: '#yccodetree',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择后置审批事项',
                    area: ['400px', '600px'],
                    content: _sysUrl+'/pubdtinfo/codeLicenseCheckboxTreePage',
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
            	$("#exaCode").val(""); 
            }
        }
        ])
    }

})
