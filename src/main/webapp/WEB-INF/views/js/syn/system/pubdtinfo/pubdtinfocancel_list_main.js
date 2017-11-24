require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
	var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        //initDataTable();
        bind();
      }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	 searchFlag="1";
    	 var url=_sysUrl+'/pubdtinfo/pubdtinfoCancelListJSON.json';
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
                {data: 'checkDepName',cut: {length: 20,mark:'...'}},
                {data: 'claimDate',cut: {length: 20,mark:'...'}},
                {data: 'claimName',cut: {length: 20,mark:'...'}},
                {data: 'checkDepName',cut: {length: 20,mark:'...'}},
                {data: 'acceptDate',cut: {length: 20,mark:'...'}},
                {data: 'acceptName',cut: {length: 20,mark:'...'}},
                {data: 'uniSCID',cut: {length: 20,mark:'...'}},
                {data: 'regNO',cut: {length: 20,mark:'...'}},
                {data: 'checkPushType',cut: {length: 20,mark:'...'}},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'opScope',cut: {length: 20,mark:'...'}},
                {data: 'apprDate','defaultContent':'11'},
                {data: 'checkRegType',cut: {length: 20,mark:'...'}},
                {data: 'leRep','defaultContent':'11'}
            ],
             columnDefs : [
							{
								targets: 1,
							    render: function (data, type, row, meta) {
							    	  return '<input type="checkbox" name="_checkbox" class="chb" value='+row.uid+'>';
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
								targets: 7,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return row.checkDepName;
									}else {
										return "";
									} 
							    }
							},
							{
								targets: 8,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return row.claimDate;
									}else {
										return "";
									}
							    }
							},
							{
								targets: 9,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return row.claimName;
									}else {
										return "";
									}
							    }
							},
							{
								targets: 10,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return "";
									}else {
										return row.checkDepName;
									}
							    }
							},
							{
								targets: 11,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return "";
									}else {
										return row.acceptDate;
									}
							    }
							},
							{
								targets: 12,
							    render: function (data, type, row, meta) {
							    	if (row.checkDeptType == '1') {
										return "";
									}else {
										return row.acceptName;
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
        if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '#pubdtinfohandpushlist',
            event: 'click',
            handler: function () { 
            	var radioArr= $(":checkbox[name=_checkbox]:checked");
            	
            	if(radioArr==null||radioArr.length==0){
            		 layer.msg("请选择企业再操作", {ltype: 0,time:2000});
                     return false;
            	}
            	var uid="";
            	for(var i=0;i<radioArr.length;i++){
            		uid+=radioArr[i].value+",";
            	}
             	layer.confirm('撤销后将恢复到待认领或待接收状态,确定撤销吗?', {icon: 3, title: '提示'}, function () { 
	                 http.httpRequest({ 
	                    type: 'post',
	                    url: _sysUrl+'/pubdtinfo/commitCancel',
	                    data: {uid: uid},
	                    success: function (data) {
	                        if (data.status == 'success') {  
	                                layer.msg("操作成功", {time: 2000}, function () {
	                                	table.ajax.reload();
	                                }); 
	                        }else{
	                        	layer.msg("操作失败", {ltype: 0,time:2000});
	                        } 
	                    }
	                });
               })
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
                    content: '/commom/server/regorg/regorgmutiselect',
                    callback: function (data) { 
                     	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
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
            	$("#checkDeps").val("");
            	$("#checkDepName").val("");
            }
        },
        {
            el: '#selectDept',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) { 
                    	$("#checkDeps").val(data.adCodes);
                    	$("#checkDepName").val(data.orgNames);
                   }
                })
            }
        },
        {
        	  el: '#checkAll',  //全选
              event: 'click',
              handler: function () {
              	var allChecked= $("#checkAll").prop("checked");   
              	$(".chb").prop("checked", allChecked);
              }
        }
        ])
    }

})
