require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
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
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
            	type : "POST",
                url:'/reg/server/party/organize/partyorg.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: null,width:'85px'},
                {data: 'modifyTime',width:'90px'},
                {data: 'partyOrgName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'inputState',width:'85px'},
                {data: 'localAdmName',width:'85px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'partyOrgDistributed',width:'110px'},
                {data: 'partyOrgType',width:'75px'},
                {data: 'partyOrgBuildDate',width:'90px'},
                {data: 'createTime',width:'90px'},
                {data: 'inputName',width:'75px'}
            ],
            columnDefs : [ 
							{
								targets : 1,
								render : function(data, type, row, meta) {
									if(row.inputState == '0'){
										return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
									}else if(row.inputState == '1'){
										return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
									}else if(row.inputState == '2'){
										return "<a class='commit edit'>修改</a>&nbsp;<a class='commit delete'>删除</a>&nbsp;<a class='commit create'>入库</a>";
									}else{
									    return "";
									}
								}
							},{
								targets : 4,
								render : function(data, type, row, meta) {
									if(row.inputState == '0'){
										return '无效'
									}else if(row.inputState == '1'){
										return '有效';
									}else if(row.inputState == '2'){
										return '待入库';
									}else{
									    return "";
									}
								}
							},{
								targets : 6,
								render : function(data, type, row, meta) {
									if(row.partyOrgDistributed == '1'){
										return "个体户党组织";
									}else if(row.partyOrgDistributed == '2'){
										return "企业党组织";
									}else if(row.partyOrgDistributed == '3'){
										return "农贸市场党组织";
									}else if(row.partyOrgDistributed == '4'){
										return "商品交易市场党组织";
									}else{
									    return "";
									}
								}
							},{
								targets : 7,
								render : function(data, type, row, meta) {
									if(row.partyOrgType == '1'){
										return '党委';
									}else if(row.partyOrgType == '2'){
										return '党总支';
									}else if(row.partyOrgType == '3'){
										return '党支部';
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
    	var entCatgArry = new Array();
    	$("#taskForm input[name ='partyOrgType']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	searchParams.partyOrgType = entCatgArry.toString();
    	if(initFlag){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '党组织建档-新增',
                    area: ['55%', '64%'],
                    content: '/reg/server/party/organize/addOrModifyView?viewFlag=0',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '党组织建档-修改',
                    area: ['55%', '66%'],
                    content: '/reg/server/party/organize/addOrModifyView?uid='+data.uid+"&viewFlag=1",
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
                	title: '党组织建档-详情',
                	area: ['55%', '66%'],
                    content: '/reg/server/party/organize/addOrModifyView?uid='+data.uid+"&viewFlag=2",
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
            }
        },{
            el: '.delete',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
	        	 layer.confirm('确定要删除吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url:'/reg/server/party/organize/delete',
                         data:{UID : data.uid},
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 layer.msg(data.msg, {time: 1000}, function () {
                            		 table.ajax.reload(); 
                            	 })
                             }
                         }
                     });
	        		 layer.close(index);
	             });
             }
        },{
            el: '.create',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
	        	 layer.confirm('请确认录入的党组织信息是否入库？入库后即为建档信息只能修改不能删除。', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url:'/reg/server/party/organize/saveOrEdit',
                         data:{UID : data.uid,inputState:'1'},
                         serializable: false,
                         type: 'post',
                         success: function (data) {
                        	 layer.msg(data.msg, {time: 1000}, function () {
                        		 table.ajax.reload(); 
                        	 })
                         }
                     });
	        		 layer.close(index);
	             });
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
              el: '#cancel',
              event: 'click',
              handler: function () { 
            	  $("#localAdm").val("");
               }
	    }])
    }

})
