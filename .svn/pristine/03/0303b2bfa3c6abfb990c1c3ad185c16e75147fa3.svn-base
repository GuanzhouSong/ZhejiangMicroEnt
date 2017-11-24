require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
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
        table = dataTable.load({
            el: '#modapplication-table',
            showIndex: true,
            scrollX:true, 
            ajax: {
                url:'/reg/server/yr/modapplication/list.json',
                data:function(d){
            		 d.params = $("#taskForm").serializeObject();
                }
            },
            columns: [
				{data: '_idx'},
				{data: null},
				{data: 'year'},
				{data: null},
				{data: 'entName'},
				{data: 'reportState'},
				{data: 'modSubmitDate'},
				{data: 'modResult'}, 
				{data: 'audName'},
				{data: 'audDate'},
				{data: 'regOrgName'},
                {data: 'checkDepName'},
                {data: 'localAdmName'}
            ],
            columnDefs: [{
				targets:3, //当前年报状态 91:未报告，1：已报告，90：未确认
				render:function(data,type,row,meta){
					if(data.unicode != null && data.unicode != ""){
						return data.unicode;
					}else{
						return data.regNo;
					}
				}
			 },{
				targets:5, //当前年报状态 91:未报告，1：已报告，90：未确认
				render:function(data,type,row,meta){
					if(row.reportState=="0"){
						return "未年报";
					}else if(row.reportState=="1"){
						return "已年报";
					}else if(row.reportState=="2"){
						return "已年报（逾期）";
					}else if(row.reportState=="00"){
						return "未公示";
					}else if(row.reportState=="10"){
						return "已公示";
					}else if(row.reportState=="11"){
						return "敏感词通过";
					}else if(row.reportState=="12"){
						return "敏感词待审核";
					}else if(row.reportState=="13"){
						return "敏感词不通过";
					}else if(row.reportState=="20"){
						return "待修改";
					}else{
						return "";
					}
				}
			 },{
				targets:7,
				render:function(data,type,row,meta){
					if(row.modResult=="1"){
						return "同意";
					}else if(row.modResult=="2"){
						return "不同意";
					}else{
						return "";
					}
				}
			 },{
                targets: 1,
                render: function (data, type, row, meta) {
                	 if(row.modResult == "0" && row.modResubmit == "0" && (row.reportState=="10" || row.reportState=="11")){
 						return "<a class='accept'>审核</a>";
 					}else{
 						return "";
 					}
                }
            }]
        });
    }
  //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#qryForm").serializeObject();
        table.ajax.reload();
    }); 
    
  //按钮事件
    function bind() {
        util.bindEvents([
        {
            el: '.accept',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '年报修改申请审核页面',
                    area: ['80%', '80%'],
                    content: '/reg/server/yr/modapplication/edit?modApplicationId='+encodeURIComponent(data.id),
                    scrollbar: true,
                    callback: function (data) {
                    	if(data.reload == true){
                    		table.ajax.reload();
                    	}
                    }
                });
            }
        },{
            el: '#chosecheckDep',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽查机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#checkDep").val(returncode);
                    	$("#checkDepName").val(data.returnname);  
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
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#checkDep").val("");
            }
        }])
    }
});
