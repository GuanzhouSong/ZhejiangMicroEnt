require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

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
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scinforesult-table',
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/pub/server/drcheck/pubscinfo/list.json',
                data:function(d){
	               	d.params = $("#scinforesultform").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null,"className": "center",defaultContent:'111'},
                {data: null,"className": "center",defaultContent:'111'}, 
                {data: null,"className": "center",defaultContent:'111'}, 
                {data: "taskCode", "className": "center"}, 
                {data: "taskName", "className": "center"},
                {data: "endDate","className": "center"},
                {data: null, "className": "center",defaultContent:'111'},
                {data: "entName","className": "center"},
                {data: "agentName", "className": "center"},
                {data: "leRep","className": "center"},
                {data: "estDate","className": "center"},
                {data: "dom","className": "center"}
            ],
            columnDefs: [{
            	targets:1,
    	        render:function(data,type,row,meta){
	        		return "<a class='commit js_view' href='javascript:void(0)'>审核</a>";
    	       }
	        },{
            	targets:2,
    	        render:function(data,type,row,meta){
    	        	if(data.auditState == null || data.auditState == "" || data.auditState == "0"){
    	        		return "待填写";
    	        	}else if(data.auditState == "1"){
    	        		return "待审核";
    	        	}else if(data.auditState == "2"){
    	        		return "同意";
    	        	}else if(data.auditState == "3"){
    	        		return "不同意";
    	        	}
    	       }
	        },{
            	targets:6,
    	        render:function(data,type,row,meta){
    	        	if(data.uniCode != null && data.uniCode != ""){
	   					return data.uniCode;
	   				}else{
	   					return data.regNO;
	   				}
    	       }
	        }]
        });
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
        table.ajax.reload();
    }); 
    
    function bind() {
        util.bindEvents([{
            el: '.js_view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '',
                    area: ['95%', '95%'],
                    content: '/syn/pub/server/drcheck/pubscinfo/audit?taskNO='+data.taskNO+"&priPID="+data.priPID,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#leaderDeptChoose',
            event: 'click',
            handler: function () {
           		var deptLink='/syn/system/sysdepart/alldeptcheckboxtreeselect'; 
            	layer.dialog({
	                    title: '选择组织部门',
	                    area: ['328px', '600px'],
	                    content: deptLink,
	                    callback: function (data) {
	                    	if (data) { 
	                           	$("#leaderDept").val(data.orgCodesExcParent);
	                           	$("#leaderDeptName").val(data.orgNamesExcParent);
	                    	}
	                    }
                });
	     }
	  },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect',
                    callback: function (data) { 
                    	$("#regOrg").val(data.returncode);
                    	$("#regOrgName").val(data.returnname);  
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
                    content: '/commom/server/regunit/regunitmutiselect',
                    callback: function (data) { 
                    	 //重新加载列表数据
                      	$("#localAdm").val(data.returncode);
                       	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#leaderDept").val("");
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            }
        }]);
    }
});
