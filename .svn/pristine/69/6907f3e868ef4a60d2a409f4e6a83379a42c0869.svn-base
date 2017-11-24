require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initlicence();//初始化许可证
        bind();
    }

    function initlicence(){
   	 loadData_one(0,5);
   };
   
   function loadData_one(page, length, callback) {
   	   var priPID = $('#priPID').val();//查询参数
       http.httpRequest({
           url: '/syn/pubdzdtinfo/searchDetailLic.json',
           serializable: false,
           data: {start: page*length,length: length,params:{"priPID":priPID}},
           type: 'post',
           success: function (data) {
               var itemCount = data.recordsTotal; //获取查询出来的总数
               $('#pagination').pagination(itemCount, {
                   prev_text: '<i class="icon-triangle-left"></i>上一页',
                   next_text: '下一页<i class="icon-triangle-right"></i>',
                   num_display_entries: 3,//主体页数
                   num_edge_entries: 2,//边缘页数
                   items_per_page:5,  //每页条数
                   current_page: page,
                   link_to: 'javascript:void(0)',
                   ellipse_text: '...',
                   first_text: '首页',
                   last_text: '末页',
                   callback:function(page,jq){
                       loadData_one(page,5);
                   }
               });
               var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
               var myTemplate = handlebars.compile($('#table-template-one').html());
               $('#dbao_page_one').html(myTemplate(data));
               $("#_total").text(itemCount);//总数
               var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
               $("#_pageNum").text(pageNum);//共多少页
           }
       });
   };
   
    

    function bind() {
        util.bindEvents([{
//        	  el: '#user-table tr',
//              event: 'click',
//              handler: function () {
//              	var data = table.row($(this)).data();
//                  layer.dialog({
//                      title: '',
//                      area: ['65%', '65%'],
//                      content: '/syn/pubdtinfo/searchDetailTab?priPId='+data.priPID+'&uid='+data.uid,
//                      callback: function (data) {
//                          //重新加载列表数据
//                          if (data.reload) {
//                              table.ajax.reload();
//                          }
//                      }
//                  })
//              }
        }
        ])
    }

})
