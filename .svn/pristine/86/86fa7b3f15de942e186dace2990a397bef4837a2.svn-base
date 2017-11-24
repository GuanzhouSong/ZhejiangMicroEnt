require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','pagination'],
function(layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
        initDataTable(0,10); 
         bind();
       }  
    
    
    function initDataTable(page,length,callback) { 
    	var params={"year":window._CONFIG._year,
        		"priPID":window._CONFIG._pripid,
        		"pageNum":page};
        http.httpRequest({
            url: '/reg/client/yr/ent/pubprint/list.json',
            serializable: false,
            showIndex: true, 
            data: {start: page*length,length: length,params:params},
            success: function(data) { 
                if(data.data==""||data.data==null){//如果没有
                	  $('#tplPage').html("<td valign='top' colspan='4' class='dataTables_empty'>无</td>"); 
                	return false;
                }
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_one').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    pageSize:10,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                   	 initDataTable(page,10);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
                var myTemplate = handlebars.compile($('#table-template').html());
                $('#tplPage').html(myTemplate(data));
                $("#itemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#pageCount").text(pageNum);//共多少页
            }
        })
    }
   function pageCallback(page,jq){//翻页事件  
	   initDataTable(page+1); 
   }
   
   function bind() {
       util.bindEvents([ 
       {
           el: '.printHisReport',
           event: 'click',
           handler: function () { 
               var _id = "_doPrint_"+new Date().getTime();
                var url = "/reg/client/yr/ent/pubprint/readHisReportPage?reportNo="+this.id+"&anCheID="+this.title+"&printFalg=2";
               try{
                   window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
               }catch(e){
                   alert("打印错误!");
               }
           }
       },
       {
           el: '.viewHisReport',
           event: 'click',
           handler: function () { 
               var _id = "_doPrint_"+new Date().getTime();
               var url = "/reg/client/yr/ent/pubprint/readHisReportPage?reportNo="+this.id+"&anCheID="+this.title+"&printFalg=1";
               layer.dialog({
                   title: '查看年度报告',
                   area: ['100%', '100%'],
                   content: url,
                   callback: function (data) {
                       
                   }
                })
           }
       }
       ])
   }
})
 