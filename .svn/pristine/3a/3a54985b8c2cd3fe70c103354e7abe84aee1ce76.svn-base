require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams={};
    var initFlag = true;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }


    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
    	var userType= $("#userType").val(); 
        var typeUrl="";
        if(userType=="2"){
       	   typeUrl="/syn/other/pubjusticeinfosearch/list.json";
        }else{
       	   typeUrl="/reg/other/pubjusticeinfosearch/list.json";
        }
        table = dataTable.load({
            el: '#justiceInfo_table',
			showIndex: true,
			scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:typeUrl,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: 'id',width:'55px'},
                {data: null,width:'85px'},
                {data: 'uniCode',width:'130px'},
                {data: 'regNO',width:'120px'},
                {data: 'entName',width:'120px'},
                {data: 'justiceType',width:'100px'},
                {data: 'executeItem',width:'120px'},
                {data: 'inv',width:'100px'},
                {data: 'cerNO',width:'120px'},
                {data: 'froAm',width:'100px'},
                {data: 'executionCourt',width:'100px'},
                {data: 'frozState',width:'100px'},
                {data: 'assInv',width:'100px'},
                {data: 'publicDate',width:'100px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regOrgName',width:'120px'},
                {data: 'localAdmName',width:'120px'},
                {data: 'sliceNOName',width:'120px'}
            ],
            fnDrawCallback:function(nRow){
            	var dataObj = nRow.json.data[0];
            	var length = nRow.json.data.length
            	$("#oneCount").html("").text(length ==0?'0':dataObj.oneCount);
            	$("#twoCount").html("").text(length ==0?'0':dataObj.twoCount);
            	$("#totalAll").html("").text(length ==0?'0':dataObj.total);
            	$("#amountAll").html("").text(length ==0?'0':dataObj.amount);
            }, 
             columnDefs : [{
								targets : 2,
								render : function(data, type, row, meta) {
									if(row.uniCode =='' || row.uniCode == null){
										return '-'
									}else{
										return row.uniCode;
									}
								}
							},{
								targets : 5,
								render : function(data, type, row, meta) {
									if(row.justiceType == '1'){
		                            	return "股权冻结信息";
		                            }else if(row.justiceType == '2'){
		                            	return "股东强制变更信息";
		                            }else{
		                            	return "-";
		                            }
								}
							},{
								targets : 6,
								render : function(data, type, row, meta) {
									if(row.executeItem == '1'){
		                            	return "公示冻结股权、其他投资权益";
		                            }else if(row.executeItem == '2'){
		                            	return "续行冻结股权、其他投资权益";
		                            }else if(row.executeItem == '3'){
		                            	return "解除冻结股权、其他投资权益";
		                            }else if(row.executeItem == '4'){
		                            	return "强制转让被执行人股权，办理有限责任公司股东变更登记";
		                            }else{
		                            	return "";
		                            }
								}
							},{
								targets : 11,
								render : function(data, type, row, meta) {
									if(row.frozState == '1'){
		                            	return "冻结";
		                            }else if(row.frozState == '2'){
		                            	return "解除冻结";
		                            }else if(row.frozState == '3'){
		                            	return "失效";
		                            }else{
		                            	return "-";
		                            }
								}
							},{
								targets: 1,
			                    render: function (data, type, row, meta) {
			                      return "<a class='commit'>查看</a>";
			                    }
			                },{
								targets : 9,
								render : function(data, type, row, meta) {
		                            	return row.froAm+'('+row.froAuth +')';
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	if(initFlag)initDataTable();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.commit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                	 typeUrl="/syn";
                 }else{
                	 typeUrl="/reg";
                 }
                layer.dialog({
                    area: ['68%', '55%'],
                    content: typeUrl+'/other/pubjusticeinfosearch/view?pripid='+data.priPID,
                    callback: function (data) {
                        if (data.reload) {
                        }
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
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
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
            el: '#chosesliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择责任区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNOName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNO").val("");
            }
        }])
    }

})
