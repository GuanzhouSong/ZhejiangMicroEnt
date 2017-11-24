require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var searchFlag = 0;
    init();
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
      }


    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = 1;
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/opanomaly/pbopadetail/pbopanomalyRecoveryApp.json',
                data:function(d){
                    d.params = searchParams;
                }
            },
            columns: [
				{data: null,defaultContent:'id',width:'24px', className: 'center'},
				{data: null},
				{data: 'regNO'},
				{data: 'entName',className: 'left',cut: {length: 20,mark:'...'}},
				{data: 'leRep'},
				{data: 'auditState'},
				{data: 'norReaCN',cut: {length: 20,mark:'...'}},
				{data: 'norDate'},
				{data: 'norDecOrgCN',cut: {length: 20,mark:'...'}},
				{data: 'firstName'},
				{data: 'firstDate'},
				{data: 'auditName'},
				{data: 'auditDate'},
				{data: 'regOrgName',className: 'left',cut: {length: 20,mark:'...'}},
				{data: 'localAdmName',className: 'left',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
 						if(row.regState=='DX'||row.regState=='XX'){
 							return "";
 						}
 						if(row.auditState){
 							if(row.auditState=='0'){
 								return "<a href='javascript:void(0)' class='js-edit'>修改</a> <a href='javascript:void(0)' class='js-delete'>删除</a>"
 							}
 						}
						return "<a href='javascript:void(0)' class='js-detail'>查看</a> <a href='javascript:void(0)' class='js-print'>打印审批表</a>"
 					}
 				 },
            	 {
 					targets:2,
 					render:function(data,type,row,meta){
						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
 				 },
            	 {
  					targets:5,
  					render:function(data,type,row,meta){
 						if(row.auditState){
 							if(row.auditState=='0'){
 								return "待审核";
 							}else if(row.auditState=='1'){
 								return "予以恢复正常";
 							}else if(row.auditState=='2'){
 								return "不予恢复正常";
 							}else if(row.auditState=='3'){
 								return "予以更正恢复";
 							}else if(row.auditState=='4'){
 								return "不予更正恢复";
 							}else{
 								return "-";
 							}
  						}else{
  							return "-";
  						}
  					}
  				 }
             ]
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	var recoveryType=new Array();
		$(":checkbox[name=recoveryTypeM]:checked").each(function(k,v){
			recoveryType[k]= this.value;
		});
		$("#recoveryType").val(recoveryType);
		
    	searchParams = $("#taskForm").serializeObject();
    	if(searchFlag == 0){
    		initDataTable();
    	}else{
            table.ajax.reload();
    	}
    }); 
    
    function bind() {
        util.bindEvents([
        	{
	            el: '.js-detail',
	            event: 'click',
	            handler: function () {
	            	var data = table.row($(this).closest('td')).data();
	                 layer.dialog({
	                    title: '恢复正常记载状态查询详情',
	                    area: ['90%', '80%'],
	                    content: '/reg/server/opanomaly/pbopadetail/opadetail?busExcList='+data.busExcList,
	                    callback: function (data) {
	                         
	                    }
	                })
	            }
        	},{
                el: '.js-print', //打印审批表
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                    var busExcList=data.busExcList;
               	    var _id = "_doPrint_"+new Date().getTime();
               	 var url = '/reg/server/opanomaly/pbopadetail/pbopanomalyRecoveryTablePrint?busExcList='+data.busExcList;
                    try{
                        window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                    }catch(e){
                        alert("打印错误!");
                    }
                }
            },{
                el: '.js-edit',
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                	var busExcList = data.busExcList;
            		layer.dialog({
                        title: '修改恢复正常记载记录',
                        area: ['80%', '80%'],
                        content:'/reg/server/opanomaly/pbopadetail/editPbOpadetail?busExcList='+busExcList,
                        callback: function (data) {
                            if (data.reload) { 
                            	 table.ajax.reload();  
                            }
                        }
                    })
                }
            },{
                el: '.js-delete',
                event: 'click',
                handler: function () { 
                	var data = table.row($(this).closest('td')).data();
                	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function () { 
    	                http.httpRequest({
    	                    type: 'post',
    	                    url: '/reg/server/opanomaly/pbopadetail/deletePbOpadetail?busExcList='+data.busExcList,
    	                    success: function (data) {
    	                        if (data.status == 'success') {  
    	                                layer.msg("删除成功", {time: 1000}, function () {
    	                                	table.ajax.reload();
    	                                }); 
    	                        }else{
    	                        	layer.msg("删除失败", {ltype: 0,time:2000});
    	                        } 
    	                    }
    	                });
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
                        	var returnname=data.returnname;	 
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(returnname);
                        }
                    })
                }
            },{
                el: '#add',
                event: 'click',
                handler: function () {
                	window.location.href='/reg/server/opanomaly/pbopadetail/addPbopanomalyRecoveryList';
                }
            },{
                el: '#select-intercept-out',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '恢复原因',
                        area: ['580px', '300px'],
                        content: '/commom/server/intercept/interceptselectmuti?selecttype=indiOutReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#norRea").val(data.id);
                                $("#norReaText").val(data.text);
                            }
                        }
                    })
                }
            },
            {
                el: '#reset', //重置
                event: 'click',
                handler: function () {
                	$('.hidden_input').val('');//重置隐藏域
                	$('#regOrg').val($('#rocode').val());
                	$("#regOrgName").val($('#rocontent').val());
                }
        }])
    }

})
