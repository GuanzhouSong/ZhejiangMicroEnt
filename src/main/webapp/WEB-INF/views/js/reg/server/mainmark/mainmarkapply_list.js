require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchParams={};//查询参数声明!
    var table;
    init();
    //时间控件初始化
    
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
        initAuditState();
       }
    
    //初始化审核状态
    function initAuditState(){ 
  	 	$("#auditState").multipleSelect({
       		selectAllText: '全部',
       		allSelected: '全部',
       		selectAllDelimiter: '',
       		minimumCountSelected: 20
       	});
  	 	$('#auditState').multipleSelect('checkAll');
   }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	table = dataTable.load({
    		//需要初始化dataTable的dom元素
    		el: '#pubopanomalylist_table',
    		showIndex: true,
    		scrollX:true, //支持滚动
    		//是否加索引值
    		showIndex: true,
    		ajax: {
    			url:'/reg/server/mainmark/mainmarkapplyList.json',
    			data:function(d){
    				 var auditState= $("#auditState").val();
                   	 d.params = $.extend({}, $("#webForm").serializeObject(), {"auditState":null != auditState?auditState.toString():""}); 
    			}
    		},
    		columns: [ 
    			{data: null,'defaultContent':'11'}, 
    			{data: null, width:"180px",defaultContent:'id' },
    			{data: null,cut: {length: 20,mark:'...'}},
    			{data: 'entName',cut: {length: 20,mark:'...'}},
    			{data: 'markName1',cut: {length: 20,mark:'...'}},
    			{data: 'markName4',cut: {length: 20,mark:'...'}},
    			{data: 'markName3',cut: {length: 20,mark:'...'}},
    			{data: 'auditState',cut: {length: 20,mark:'...'}},
    			{data: 'setName',cut: {length: 20,mark:'...'}},
    			{data: 'setTime',cut: {length: 20,mark:'...'}},
    			{data: 'setDeptname',cut: {length: 20,mark:'...'}},
    			{data: 'auditorName',cut: {length: 20,mark:'...'}},
    			{data: 'auditTime',cut: {length: 20,mark:'...'}},
    			{data: 'auditDeptName',cut: {length: 20,mark:'...'}}
    			] ,
    			columnDefs: [
    				{
    					targets: 1,
    					render: function (data, type, row, meta) {
    						var auditState= row.auditState;
    						if("1"==auditState){
    							return   '<a href="javascript:void(0);" id="'+row.markUuid+'" data-priPID="'+row.priPID+'" class="moddifty">修改</a>'+
    							'&nbsp<a href="javascript:void(0);" id="'+row.markUuid+'" class="del">删除</a>';
    						}else{
    							return '<a href="javascript:void(0);" id="'+row.markUuid+'" data-priPID="'+row.priPID+'" class="view">详情</a>'
    						}
    					}
    				},{
    					targets: 2,
    					render: function (data, type, row, meta) {
    						if(data.uniCode && $.trim(data.uniCode) != "null"){
  				    		  return data.uniCode;
  				    	  }else if(data.regNO && $.trim(data.regNO) != "null"){
  				    		  return data.regNO;
  				    	  }
    					}
    				},{
    					targets: 7,
    					render: function (data, type, row, meta) {
    						var auditState= row.auditState;
    						if("1"==auditState){
    							return '待审核';
    						}else if("2"==auditState){ 
    							return '审核通过';
    						}else if("3"==auditState){ 
    							return '审核不通过';
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
    		el: '#btn_add',
    		event: 'click',
    		handler: function () {
    			window.location = '/reg/server/mainmark/toAppsearch';
    			/*layer.dialog({
    				title: '分类标签标注申请-新增',
    				area: ['800px', '550px'],
    				content: '/reg/server/registmark/registmarkapply_add',
    				callback: function (data) {
	                   	 if (data.reload) { //close是否有传递此参数
	                         table.ajax.reload();
	                     }
    				}
    			})*/
    		}
    	} ,{
    		el: '.moddifty',
    		event: 'click',
    		handler: function () {
    			var id = $(this).attr("id");
    			var priPID = $(this).attr("data-priPID");
    			layer.dialog({
    				title: '分类标签标注申请-修改',
    				area: ['80%', '95%'],
    				content: '/reg/server/mainmark/toMainmarkapplyEdit?markUuid='+id+"&priPID="+priPID,
    				callback: function (data) {
	                   	 if (data.reload) { //close是否有传递此参数
	                         table.ajax.reload();
	                     }
    				}
    			})
    		}
    	} ,
    	{
    		el: '.del',
    		event: 'click',
    		handler: function () {
    			var id = $(this).attr("id");
    			layer.confirm('确定要删除选中记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
    	             layer.close(index);
    	             http.httpRequest({
    	                 url: '/reg/server/mainmark/deleteByMarkUuid.json',
    	                 data: {markUuid:id},
    	                 type: 'post',
    	                 success: function (data) {
    	                     layer.msg("删除成功！", {time: 1000}, function () {
    	                     	if(data.status=='success'){
    	                     		table.ajax.reload();
    	                     	}
    	                     });
    	                 }
    	             });
    	      	  }); 
    		}
    	},{
    		el: '#cancel',
    		event: 'click',
    		handler: function () {
    			$('#auditState').multipleSelect('checkAll');
    		}
    	},{
    		el: '.view',
    		event: 'click',
    		handler: function () {
    			var id = $(this).attr("id");
    			var priPID = $(this).attr("data-priPID");
    			layer.dialog({
    				title: '分类标签标注申请-详情',
    				area: ['80%', '95%'],
    				content: '/reg/server/mainmark/toMainmarkapplyView?markUuid='+id+"&priPID="+priPID
    			})
    		}
    	} 
    	]);
    }

})
