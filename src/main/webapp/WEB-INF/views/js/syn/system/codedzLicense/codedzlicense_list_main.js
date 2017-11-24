require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

  
	var searchParams={};//查询参数声明!
    var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
      }
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/common/system/codedzlicense/selectCodeLicenseSearchList.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: null,width:"100px",'defaultContent':'11'},
                {data: 'exaCode'}, 
                {data: 'exaName',cut: {length: 20,mark:'...'}},
                {data: 'licDept',cut: {length: 20,mark:'...'}},
                {data: 'licZone'},
                {data: 'licRea',cut: {length: 20,mark:'...'}}
                
            ],
             columnDefs : [
							{
								targets: 1,
							    render: function (data, type, row, meta) {
							    	return '<a href="javascript:void(0);" class="moddifty" id="'+row.exaCode+'">修改</a>'+
							    	'&nbsp<a href="javascript:void(0);" class="del" id="'+row.exaCode+'" >删除</a>'+
							    	'&nbsp<a href="javascript:void(0);" class="view" id="'+row.exaCode+'">查看</a>';
							    }
							},
							{
								targets: 5,
							    render: function (data, type, row, meta) {
							    	 if(row.licZone=="0"){
							    		  return "国家级";
							    	  }else if(row.licZone=="1"){
							    		  return "省级";
							    	  }else if(row.licZone=="2"){
							    		  return "市级";
							    	  }else if(row.licZone=="3"){
							    		  return "县级";
							    	  }else {
							    		  return "混合";
							    	  } 
							    }
							}  
							]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '#pubdtinfohandpushlist',
            event: 'click',
            handler: function () {
            	 layer.dialog({
                     title: '新增',
                     area: ['900px', '400px'],
                     content: '/common/system/codedzlicense/codeLicenseAddPage?exaCode=null',
                     callback: function (data) {
                    	 if (data.reload) {
                             table.ajax.reload();
                         }
                     }
                 })
            }
        },
        {
            el: '.moddifty',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
            	 
                 layer.dialog({
                    title: '修改',
                    area: ['60%', '50%'],
                    content: '/common/system/codedzlicense/codeLicenseViewPage?exaCode='+data.exaCode+'&viewFlag=1'+'&licType='+data.licType,
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        },
        {
            el: '.view',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
                 layer.dialog({
                    title: '查看',
                    area: ['60%', '50%'],
                    content: '/common/system/codedzlicense/codeLicenseViewPage?exaCode='+data.exaCode+'&viewFlag=2'+'&licType='+data.licType,
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        },{
            el: '.del',
            event: 'click',
            handler: function () { 
            	var exaCode=this.id;
            	layer.confirm('后置审批事项需和准入系统保持一致，若非准入系统的后置审批事项有变化，否则请勿执行删除操作,确定要删除吗?', {icon: 2, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: '/common/system/codedzlicense/deleteCodeLicense',
	                    data: {exaCode: exaCode},
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
        }
        ])
    }

})
