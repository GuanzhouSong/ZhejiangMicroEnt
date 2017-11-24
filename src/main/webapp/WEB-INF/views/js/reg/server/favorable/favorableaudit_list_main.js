require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initFavType();
        bind();
    }
    
    //初始化良好信息类别
    function initFavType(){ 
  		$("#favType").append("<option value='0'>百强民营企业</option>");
  		$("#favType").append("<option value='1'>驰名商标</option>");
  		$("#favType").append("<option value='2'>知名商号</option>");
  		$("#favType").append("<option value='3'>著名商标</option>");
  		$("#favType").append("<option value='4'>守合同重信用企业</option>");
  		$("#favType").append("<option value='5'>信用示范管理企业</option>");
  		$("#favType").append("<option value='6'>小微企业成长之星</option>"); 
       	$("#favType").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
       	//全选
        $('#favType').multipleSelect('checkAll'); 
   }

    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true,
            ajax: {
                url:window._CONFIG.url+'/favorableinput/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: 'id',width:'55px'},
                {data: null,width:'55px'},
                {data: null,width:'85px'},
                {data: null,width:'120px'},
                {data: 'entName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'favName',width:'120px'},
                {data: 'favType',width:'120px'},
                {data: 'licZone',width:'80px'},
                {data: 'auditState',width:'80px'},
                {data: 'regYear',width:'120px'},
                {data: 'regType',width:'100px'},
                {data: 'regDate',width:'80px'},
                {data: 'regDocNo',width:'80px'},
                {data: 'regDeptCn',width:'100px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'setName',width:'120px'},
                {data: 'setTime',width:'100px'},
                {data: 'setDept',width:'100px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'auditName',width:'120px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regOrgName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'localAdmName',cut: {length: 20,mark:'...'},className: 'left'}
            ],
             columnDefs : [{
								targets : 1,
								render : function(data, type, row, meta) {
									if(row.auditState =='0'){
									    return '<input class="choose" taskNO = '+row.uid+' type="checkbox"/>';
									}else{
										return "";
									}
								}
							},{
								targets : 3,
								render : function(data, type, row, meta) {
									if(row.uniSCID !="" && row.uniSCID !=null) {
							    		return row.uniSCID;
							    	}else{
							    		return row.regNO;
							    	}
								}
							},{
								targets : 8,
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
							},{
								targets : 2,
								render : function(data, type, row, meta) {
									if(row.auditState =='0') {
					            		return "<a class='commit audit'>审核</a>";
					            	}else{
					            		return "<a class='commit view'>详情</a>";
					            	}
								}
							},{
								targets : 6,
								render : function(data, type, row, meta) {
									if(row.favType == '0'){
										return "百强民营企业";
									}else if(row.favType == '1'){
										return "驰名商标";
									}else if(row.favType == '2'){
										return "知名商号";
									}else if(row.favType == '3'){
										return "著名商标";
									}else if(row.favType == '4'){
										return "守合同重信用企业";
									}else if(row.favType == '5'){
										return "信用示范管理企业";
									}else if(row.favType == '6'){
										return "小微企业成长之星";
									}else{
									   return "";
									}
								}
							},{
								targets : 7,
								render : function(data, type, row, meta) {
									if(row.licZone =='0') {
					            		return "国家级";
					            	}else if(row.licZone == '1'){
					            		return "省级";
					            	}else if(row.licZone == '2'){
					            		return "市级";
					            	}else if(row.licZone == '3'){
					            		return "县级";
					            	}else{
					            		return "";
					            	}
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	var favType = $("#favType").val();
    	searchParams = $("#taskForm").serializeObject();
    	searchParams.favType = favType.toString();
    	if(initFlag)initDataTable();
        table.ajax.reload();
    }); 
    
    $("#moresearch").click(function(){
    	if($(this).attr("status") == '0'){
    		$(".moresearch_oth").show();
    		$(this).val("收起").attr("status",'1');
    	}else{
    		$(".moresearch_oth").hide();
    		$(this).val("更多查询条件").attr("status",'0');
    	}
    })

    function bind() {
        util.bindEvents([{
            el: '.audit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '审核',
                    area: ['65%', '89%'],
                    content: window._CONFIG.url+'/favorableinput/addOrEditView?priPID='+data.priPID+'&uid='+data.uid+'&isAudit='+'1',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#auditBacth',
            event: 'click',
            handler: function () {
            	if($(".choose:checked").length == 0 ){
            		alert("请至少选择一条数据进行审核！");
            		return false;
            	}
            	var checkArry = [];
            	$(".choose:checked").each(function(){
            		checkArry.push($(this).attr("taskNO"));
            	})
            	var uids = checkArry.toString();
                layer.dialog({
                    title: '批量审核',
                    area: ['65%', '40%'],
                    content: window._CONFIG.url+'/favorableaudit/viewBacth?uids='+uids,
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
             }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                	area: ['65%', '90%'],
                    content: window._CONFIG.url +'/favorableaudit/details?uid='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
            }
        },{
            el: '#checkAll',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$(".choose").prop("checked",true);
            	}else{
            		$(".choose").prop("checked",false);
            	}
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
            el: '#choseDept',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: window._CONFIG.select_detp_tree_url,
                    callback: function (data) {
                        $("#regDeptCn").val(data.deptName);
                    }
                })
            }
        },{
            el: '#choseDept2',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择部门',
                    area: ['400px', '600px'],
                    content: window._CONFIG.select_detp_tree_url,
                    callback: function (data) {
                        $("#setDeptCn").val(data.deptName);
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#regDept").val("");
            	$("#setDept").val("");
            	$('#favType').multipleSelect('checkAll');
            }
        }])
    }

})
