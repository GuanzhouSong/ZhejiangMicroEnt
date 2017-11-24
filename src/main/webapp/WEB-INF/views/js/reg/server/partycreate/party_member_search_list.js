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
                {data: 'modifyTime',width:'100px'},
                {data: 'memberName',width:'100px'},
                {data: 'identityInfo',width:'100px'},
                {data: 'sex',width:'80px'},
                {data: 'memberAge',width:'80px'},
                {data: 'qualifications',width:'80px'},
                {data: 'nationality',width:'80px'},
                {data: 'joinPartyTime',width:'80px'},
                {data: 'memberType',width:'100px'},
                {data: 'isSecretary',width:'100px'},
                {data: 'originLoc',width:'100px'},
                {data: 'orgRelationLoc',width:'100px'},
                {data: 'belongMarket',width:'100px'},
                {data: 'partyOrgName',width:'100px'},
                {data: 'regNO',width:'100px'},
                {data: 'entName',width:'100px'},
                {data: 'entType',width:'100px'},
                {data: 'regOrgName',width:'100px'},
                {data: 'localAdmName',width:'100px'},
                {data: 'regState',width:'100px'},
                {data: 'createTime',width:'100px'},
                {data: 'auditName',width:'100px'}
            ],
            fnDrawCallback:function(nRow){
            	initSearchTotal();
            },
            columnDefs : [ 
							{
								targets : 1,
								render : function(data, type, row, meta) {
								    return "<a class='commit view'>详情</a>";
								}
							},{
								targets : 3,
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
									if(row.sex == '1'){
								    	return "男";
								    }else if(row.sex == '2'){
								    	return "女";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 7,
								render : function(data, type, row, meta) {
								    if(row.qualifications == '1'){
								    	return "小学";
								    }else if(row.qualifications == '2'){
								    	return "初中";
								    }else if(row.qualifications == '3'){
								    	return "高中";
								    }else if(row.qualifications == '4'){
								    	return "大专";
								    }else if(row.qualifications == '5'){
								    	return "本科";
								    }else if(row.qualifications == '6'){
								    	return "研究生";
								    }else if(row.qualifications == '7'){
								    	return "硕士";
								    }else if(row.qualifications == '8'){
								    	return "博士";
								    }else if(row.qualifications == '9'){
								    	return "博士后";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 8,
								render : function(data, type, row, meta) {
								    if(row.nationality == '1'){
								    	return "汉族";
								    }else if(row.nationality == '2'){
								    	return "其它";
								    }else{
								    	return "";
								    }
								}
							},{
								targets : 11,
								render : function(data, type, row, meta) {
								    if(row.isSecretary == '1'){
								    	return "是";
								    }else{
								    	return "否";
								    }
								}
							},{
								targets : 16,
								render : function(data, type, row, meta) {
									if(row.uniCode != '' && row.uniCode != null){
										return row.uniCode;
									}else{
									    return row.regNO;
									}
								}
							},{
								targets : 18,
								render : function(data, type, row, meta) {
									if(row.entType == '1'){
										return "企业";
									}else{
									    return "个体";
									}
								}
							},{
								targets : 10,
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
								targets : 21,
								render : function(data, type, row, meta) {
									return switchRegStateList(data);
								}
							},{
								targets : 13,
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
    
    function initSearchTotal(){
    	$("#membercount,#yzcount,#cyrycount,#sjcount,#zsdycount,#ybcount").text("加载中...");
    	http.httpRequest({
            url: '/reg/server/party/member/searchCount',
            serializable: false,
            data: null,
            type: 'get',
            success: function (data) {
            	if(data != null){
            		var countInfo = data.data;
            		if(countInfo !=null && countInfo != ""){
            			$("#membercount").text(countInfo.membercount ==null?'0':countInfo.membercount);
            			$("#yzcount").text(countInfo.yzcount == null?'0':countInfo.yzcount);
            			$("#cyrycount").text(countInfo.cyrycount == null?'0':countInfo.cyrycount);
            			$("#sjcount").text(countInfo.sjcount == null ?'0':countInfo.sjcount);
            			$("#zsdycount").text(countInfo.zsdycount ==null?'0':countInfo.zsdycount);
            			$("#ybcount").text(countInfo.ybcount ==null?'0':countInfo.ybcount);
            		}
            	}
            },
            error:function (jqXHR, textStatus, errorThrown) {
     		   if (unAuthError(jqXHR, textStatus, errorThrown)) {
                    return;
                }
                if (options.error) {
                    options.error();
                } else {
                }
     	   }
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
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                	title: '党员户口维护',
                	area: ['100%', '100%'],
                    content: '/reg/server/party/member/addOrModifyView?priPID='+data.priPID+"&memberUid="+data.uid+"&viewFlag=3"+"&businessType=4",
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
