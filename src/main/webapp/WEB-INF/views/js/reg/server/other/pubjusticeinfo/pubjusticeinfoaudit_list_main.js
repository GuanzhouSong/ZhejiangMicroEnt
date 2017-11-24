require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    var initFlag = true;
    var searchParams={};
    
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
	    	 typeUrl="/syn/other/pubjusticeinfo/list.json";
	    }else{
	    	 typeUrl="/reg/other/pubjusticeinfo/list.json";
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
                {data: 'froAm',width:'100px'},
                {data: 'executionCourt',width:'100px'},
                {data: 'auditState',width:'100px'},
                {data: 'setName',width:'100px'},
                {data: 'setDate',width:'100px'},
                {data: 'auditName',width:'80px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regOrgName',width:'120px'},
                {data: 'localAdmName',width:'120px'},
                {data: 'sliceNOName',width:'120px'}
            ],
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
								targets : 10,
								render : function(data, type, row, meta) {
									if(row.auditState =='0') {
					            		return "待审核";
					            	}else if(row.auditState == '1'){
					            		return "审核通过";
					            	}else if(row.auditState == '2'){
					            		return "审核不通过";
					            	}else{
					            		return "";
					            	}
								}
							}, {
								targets: 1,
			                    render: function (data, type, row, meta) { 
			                    	var deptCode=$("#deptCode").val(); 
			                    	var userType= $("#userType").val();
			                      	if(userType=="1"){
			                      		//警示不判断 
				                    	if (row.auditState == '0') {
				                    	    return "<a class='commit audit'>审核</a>";
				                    	}else{
				                    		return "<a class='commit view'>详情</a>";
				                    	}
			                      }else{
			                    	 //协同判断
			                    	 if(deptCode==row.deptCode){
			                    		 if (row.auditState == '0') {
					                    	    return "<a class='commit audit'>审核</a>";
					                    	}else{
					                    		return "<a class='commit view'>详情</a>";
					                    	} 
			                    	 }else{
			                    			return "<a class='commit view'>详情</a>";
			                    	 }
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
								targets : 8,
								render : function(data, type, row, meta) {
									if(row.froAm=="null" || row.froAm == null){
										return "";
									}else{
										return row.froAm+'('+row.froAuth +')';
									}
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
            el: '.view',
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
                    area: ['68%', '100%'],
                    content: typeUrl+'/other/pubjusticeinfo/detailsView?pripid='+data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
            }
        },{
            el: '.audit',
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
                    area: ['68%', '100%'],
                    content: typeUrl+'/other/pubjusticeinfoaudit/auditView?pripid='+data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
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
