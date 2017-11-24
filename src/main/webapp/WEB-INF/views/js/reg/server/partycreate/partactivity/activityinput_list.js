require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
        bind();
    }

    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
//    	initFlag = false;
        table = dataTable.load({
            el: '#user_table',
			showIndex: true,
			scrollX:true,
//			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/party/partyactivityinfo/inputlist.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: null,width:'85px'},
                {data: 'activityType',width:'90px'},
                {data: 'activityName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'requireEndDate',width:'85px'},
                {data: 'publishDeptName',width:'85px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'publishDate',width:'110px'},
                {data: 'inputName',width:'75px'},
                {data: 'inputDate',width:'90px'}
            ],
            columnDefs : [
							{
								targets : 1,
								render : function(data, type, row, meta) {
//									if(row.inputState == '0'){
										return "<a class='commit view'>详情</a>";
//									}
								}
							},{
								targets : 2,
								render : function(data, type, row, meta) {
									if(data == null){
										return "";
									}else if(data == '1'){
										return '重点常规活动'
									}else if(data == '2'){
										return '党员日常活动';
									}else{
									    return data;
									}
								}
							}]
           })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	var entCatgArry = new Array();
    	$("#taskForm input[name ='partyOrgType']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	searchParams.partyOrgType = entCatgArry.toString();
//    	if(initFlag){
//    		initDataTable();
//    	}else{
    		table.ajax.reload();
//    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '#add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '党建活动-新增',
                    area: ['75%', '60%'],
                    content: '/reg/server/party/partyactivityinfo/addPartyActivityInfo?inputState=0',
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
            	var str = data.inputState == '0' ? ['75%', '50%'] : ['75%', '90%'];
                layer.dialog({
                	title: '党建活动详情',
                	area: str,
                    content: '/reg/server/party/partyactivityinfo/partyActivityResult?uid='+data.uid+"&inputState="+data.inputState+"&viewFlag=2",
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
        },
        {
            el: '#choseSpecial',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择发布部门',
                    area: ['68%', '80%'],
                    content: '/reg/server/party/organize/chooseOrg',
                    callback: function (data) {
                    	if(data.returnCode == 'success'){
                        	$("#specialCode").val(data.orgCode);
                        	$("#specialName").val(data.orgName);  
                    	}
                    }
                })
            }
        }
        ,{
              el: '#reset',
              event: 'click',
              handler: function () { 
            	  $("#localAdm").val("");
            	  $("#specialCode").val("");
               }
	    }])
    }

})
