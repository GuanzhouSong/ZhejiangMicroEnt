require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }

    var searchParams={};//查询参数声明!
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
			scrollX:true, //支持滚动
            ajax: {
                url:window._CONFIG.chooseUrl+'/yr/bulletins/list.json',
                data:function(d){
                	d.params =$.extend({}, $("#taskForm").serializeObject(), {"bulType":window._CONFIG.bulType});   	
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
				{data: null, defaultContent:'id',className: 'center'},
				{data: 'setId',width: '150px', className: 'center'},
				{data: 'title',cut: {length: 25,mark:'...'}},
				{data: 'isValid'},
//				{data: 'bulType'},
				{data: 'bulScope'},
				{data: 'setTime'},				
				{data: 'modTime'},				
				{data: 'setName'}, 
				{data: 'setDeptname'}
            ],
            columnDefs: [
				{
				    targets: 1,
				    render: function (data, type, row, meta) {
				    	return '<a class="js-edit" uid="'+row.uid+'" href="javascript:void(0);" >修改</a>\
				    	<a class="js-see" uid="'+row.uid+'" href="javascript:void(0);" >详情</a>';
				    }
				},
				{
					targets:3,
					render:function(data,type,row,meta){   
						if(row.isValid=="0"){
							return "<span style='color:red;'>无效</span>";
						}else if(row.isValid=="1"){
							return "有效";
						}else{
							return data;
						}
					}
				 },{
						targets:4,
						render:function(data,type,row,meta){   
							if(row.bulScope=="1"){
								return "全省";
							}else if(row.bulScope=="2"){
								return "本局";
							}else if(row.bulScope=="3"){
							    return "本市";
						    }else if(row.bulScope=="4"){
							    return "拟吊销营业执照听证公告";
						    }else if(row.bulScope=="5"){
							    return "吊销营业执照公告";
						    }else if(row.bulScope=="6"){
							    return "企业登记机关注销公告";
						    }else if(row.bulScope=="7"){
						    	return "年度抽查工作计划公告";
						    }else{
						    	return data;
						    }
						}
					 }
            ]
        });
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();   	
        table.ajax.reload();
    });
    
    function bind() {
    	  util.bindEvents([{
              el: '#addPage',
              event: 'click',
              handler: function () {
                  layer.dialog({
                      title: '新增公告',
                      area: ['820px', '650px'],
                      content: window._CONFIG.chooseUrl+'/yr/bulletins/toInsert?bulType='+window._CONFIG.bulType,
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
                          url: window._CONFIG.chooseUrl+'/yr/bulletins/delete',
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
                      area: ['830px', '650px'],
                      content: window._CONFIG.chooseUrl+'/yr/bulletins/toupdate?uid=' + data.uid+'&bulType='+window._CONFIG.bulType,
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
                      area: ['830px', '650px'],
                      content: window._CONFIG.chooseUrl+'/yr/bulletins/tosee?uid=' + data.uid+'&bulType='+window._CONFIG.bulType,
                      callback: function (data) {
//                    	  table.ajax.reload();
                      }
                  });
              }
          }]);
    }

});
