require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	 init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind()
    }
    var backtable;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	backtable = dataTable.load({
            el: '#foodstoragebaseback-table',
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/foodstorageback/basebacklist.json',
                data:function(d){
                	d.params = $("#taskForm").serializeObject();
                }
            },
            columns: [
				{data: null,width:'5%',className: 'center'},
				{data: null,width:'5%'},
				{data: null,width:'10%',className: 'center'},
				{data: 'entName',width:'10%'},
				{data: 'setTime',width:'10%'},
				{data: 'setName',width:'6%'},
				{data: 'tel',width:'10%'},
				{data: 'mobTel',width:'10%'},
				{data: 'regOrgDesc',width:'16%'},
				{data: 'localAdmDesc',width:'8%'}
            ],
            columnDefs: [{
    	         targets:1,
     	         render:function(data,type,row,meta){
     		     return  '<input type="radio" class="radioClass" name="foodStorageId"  value='+row.id+'>';
     	       }
          },{
 	         targets:2,
 	         render:function(data,type,row,meta){
 	        	if(data.uniSCID != null && data.uniSCID != ""){
					return data.uniSCID;
				}else{
					return data.regNO;
				}
 	       }
      }]
        });
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	backtable.ajax.reload();
    }); 
//    
    function bind() {
        util.bindEvents([{
            el: '#returnback',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/yr/foodstorageback/list';
            }
        },{
            el: '#editbaseback',
            event: 'click',
            handler: function () {
            	var foodStorageId = $('input[name="foodStorageId"]:checked').val();
            	if(foodStorageId == null || foodStorageId == ""){
            		alert("请选中一条记录");
            		return false;
            	}
            	 layer.dialog({
                     title: '食品仓储申请退回',
                     area: ['50%', '40%'],
                     content: '/reg/server/yr/foodstorageback/show?foodStorageBaseId='+encodeURIComponent(foodStorageId),
                     scrollbar: true,
                     callback: function (data) {
                     	if(data.reload == true){
                     		backtable.ajax.reload();
                     	}
                     }
                 });
            }
        }]);
    }

});
