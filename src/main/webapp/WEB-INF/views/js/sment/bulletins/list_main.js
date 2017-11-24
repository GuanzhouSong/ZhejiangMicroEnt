require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
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
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            lengthMenu: [ 5, 10, 20, 50],
            ajax: {
                url:'/sment/bulletins/list.json',
                data:function(d){
                	d.params = $("#taskForm").serializeObject();	
                }
            },
            buttons:[],
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
				{data: null, defaultContent:'id',className: 'center'},
				{data: null},
				{data: 'title'},
				{data: 'setTime'}				
            ],
            columnDefs: [
				{
				    targets: 1,
				    render: function (data, type, row, meta) {
				    	return '<a class="js-see" uid="'+row.uid+'" href="javascript:void(0);" >查看</a>\
				    	<a class="js-edit" uid="'+row.uid+'" href="javascript:void(0);" >编辑</a>\
							<a class="js-delete" uid="'+row.uid+'" href="javascript:void(0);" >删除</a>';
				    }
				}
            ]
        });
    }
    function bind(){
    	util.bindEvents([
    	  {
			  el: '#addPage',
	          event: 'click',
	          handler: function () {
	              layer.dialog({
	                  title: '新增公告',
	                  area: ['800px', '600px'],
	                  content:'/sment/bulletins/toInsert',
	                  callback: function(data){
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
              	 layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index)  {
                      http.httpRequest({
                          url: '/sment/bulletins/delete',
                          type: 'post',
                          data: {uid:data.uid},
                          success: function (data) {
                              if (data.status == 'success') {
                                  //重新加载列表数据
                                  if (data.msg) {
                                      layer.msg(data.msg, {time: 500}, function () {
                                          table.ajax.reload();
                                      });
                                  }
                              }
                          }
                      });
                  });
              }
          }, {
              el: '.js-edit',
              event: 'click',
              handler: function () {
            	  var data = table.row($(this).closest('td')).data();
                  layer.dialog({
                      title: '编辑公告',
                      area: ['810px', '600px'],
                      content: '/sment/bulletins/toUpdate?uid=' + data.uid,
                      callback: function (data) {
                    	  if (data.reload) {
                              table.ajax.reload();
                          }
                      }
                  });
              }
          }, {
              el: '.js-see',
              event: 'click',
              handler: function () {
            	  var data = table.row($(this).closest('td')).data();
                  layer.dialog({
                      title: '查看公告',
                      area: ['810px', '600px'],
                      content: '/sment/bulletins/tosee?uid=' + data.uid,
                      callback: function (data) {
                    	  table.ajax.reload();
                      }
                  });
              }
          } 
        ])
    }
    

})