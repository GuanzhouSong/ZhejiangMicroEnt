require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	var regStateList = [];
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initRegState();
        getRegStateList();
    }
    
    function initRegState(){
       	$("#regStateM").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
       	});
       	$('#regStateM').multipleSelect('checkAll');
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
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
            	type : "POST",
                url:'/reg/server/party/member/partymaintain.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: null,width:'85px'},
                {data: 'memberName',width:'100px'},
                {data: 'identityInfo',width:'100px'},
                {data: 'memberType',width:'100px'},
                {data: 'regNO',width:'100px'},
                {data: 'entName',width:'100px'},
                {data: 'regState',width:'100px'},
                {data: 'partyOrgName',width:'100px'},
                {data: 'orgRelationLoc',width:'100px'},
                {data: 'belongMarket',width:'100px'},
                {data: 'regOrgName',width:'100px'},
                {data: 'localAdmName',width:'100px'},
                {data: 'auditName',width:'100px'},
                {data: 'modifyTime',width:'100px'},
                {data: 'createTime',width:'100px'}
            ],
            columnDefs : [ 
							{
								targets : 1,
								render : function(data, type, row, meta) {
								    return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
								}
							},{
								targets : 2,
								render : function(data, type, row, meta) {
									if("A,B,K,Q,X".indexOf(row.regState) == -1){
										return "<span class='yellow-bg'>"+row.memberName+"</span>";
									}else{
										return row.memberName;
									}
								}
							},{
								targets : 5,
								render : function(data, type, row, meta) {
									if(row.uniCode != '' && row.uniCode != null){
										return row.uniCode;
									}else{
									    return row.regNO;
									}
								}
							},{
								targets : 4,
								render : function(data, type, row, meta) {
									if(row.memberType == '1' || row.memberType == null || row.memberType == ''){
										return "业主";
									}else if(row.memberType == '2'){
										return "从业人员";
									}else{
									    return "";
									}
								}
							},{
								targets : 7,
								render : function(data, type, row, meta) {
									return switchRegStateList(data);
								}
							},{
								targets : 9,
								render : function(data, type, row, meta) {
									if(row.orgRelationLoc == '1'){
								    	return "街道社区";
								    }else if(row.orgRelationLoc == '2'){
								    	return "辖区协会";
								    }else if(row.orgRelationLoc == '3'){
								    	return "市场";
								    }else if(row.orgRelationLoc == '4'){
								    	return "流动党员";
								    }else{
								    	return "";
								    }
								}
							}
					 ]
           })
    }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regStateM option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	//登记状态
		var regStateM = $("#regStateM").val();
		if(regStateM != 'A,B,K,Q,X,C,D,DA,QX,XX,DX'){
			$("#regState").val(regStateM);
		}else{
			$("#regState").val('');
		}
		
    	searchParams = $("#taskForm").serializeObject();
    	var entCatgArry = new Array();
    	$("#taskForm input[name ='entCatg']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	if($("#taskForm input[name ='entCatg']:checked").length == 0){
    		searchParams.entCatg = "1,2";
    	}else{
    		searchParams.entCatg = entCatgArry.toString();
    	}
    	if(initFlag){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
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
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '党员户口维护',
                    area: ['100%', '100%'],
                    content: '/reg/server/party/member/addOrModifyView?priPID='+data.priPID+"&memberUid="+data.uid+"&viewFlag=2"+"&businessType=3",
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
                	title: '党员户口维护',
                	area: ['100%', '100%'],
                    content: '/reg/server/party/member/addOrModifyView?priPID='+data.priPID+"&memberUid="+data.uid+"&viewFlag=3"+"&businessType=3",
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
            el: '#choseOrg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择党组织',
                    area: ['75%', '80%'],
                    content: '/reg/server/party/organize/chooseOrg',
                    callback: function (data) {
                    	if(data.returnCode == 'success'){
                        	$("#partyOrgID").val(data.orgCode);
                        	$("#partyOrgName").val(data.orgName);  
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
              el: '#cancel',
              event: 'click',
              handler: function () { 
            	  $("#localAdm").val("");
            	  $("#regOrg").val("");
            	  $("#partyOrgID").val("");
            	  $('#regStateM').multipleSelect('checkAll');
               }
	    }])
    }

})
