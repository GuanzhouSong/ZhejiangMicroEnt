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
    	var params={
    		"searchFlag":"1", 
    		"state":$("#state").val(), 
    		"title_content":$.trim($("#title_content").val()), 
    		"priPID":window._CONFIG._pripid,
    		"pageNum":page};
        http.httpRequest({
            url: '/reg/client/yr/ent/consult/selectConsultInfoDtoSearchListJSON.json',
            serializable: false,
            showIndex: true, 
            data: {start: page*length,length: length,params:params},
            success: function(data) { 
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
                 handlebars.registerHelper("stateFormat",function(state){ 
                     var text="";
                     if(state=='0'){
                         text = "未反馈";
                     }else{
                         text = "已反馈";
                     }
                     return text;
                 });
                 
                 handlebars.registerHelper("stateXDEFormat",function(rowObj){ 
                     var text="";
                     //未反馈
                     if(rowObj.state=='0'){
                         text = "<a href='javascript:void(0);' id='"+rowObj.uid+"' class='editConsult'>修改</a>&nbsp;&nbsp;<a href='javascript:void(0);' id='"+rowObj.uid+"' class='deleteConsult'>删除</a> ";
                     }else{
                    	 text = "<a href='javascript:void(0);' id='"+rowObj.uid+"' class='viewConsult'>详情</a>";
                     }
                     return text;
                 });
                 
                 handlebars.registerHelper("consultContentFormat",function(rowObj){ 
                	if(rowObj.consultContent.length>8){
							var newBanExp=rowObj.consultContent.substring(0,8)+"...";
							return "<span title='"+rowObj.consultContent+"'>"+newBanExp+"</span>";
					}else{
							return rowObj.consultTitle;
					}
                 });
                 
                 
                 handlebars.registerHelper("consultTitleFormat",function(rowObj){  
                    if(rowObj.consultTitle.length>8){
							var newBanExp=rowObj.consultTitle.substring(0,8)+"...";
							return "<span title='"+rowObj.consultTitle+"'>"+newBanExp+"</span>";
					}else{
							return rowObj.consultTitle;
					}
                 });
                 
                 handlebars.registerHelper("backContentFormat",function(rowObj){  
                     if(rowObj.backContent!=null&&rowObj.backContent.length>8){
 							var newBanExp=rowObj.backContent.substring(0,8)+"...";
 							return "<span title='"+rowObj.backContent+"'>"+newBanExp+"</span>";
 					}else{
 							return rowObj.backContent;
 					}
                  });
                 
                 handlebars.registerHelper("backDeptFormat",function(rowObj){  
                     if(rowObj.backDept!=null&&rowObj.backDept.length>8){
 							var newBanExp=rowObj.backDept.substring(0,8)+"...";
 							return "<span title='"+rowObj.backDept+"'>"+newBanExp+"</span>";
 					}else{
 							return rowObj.backDept;
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
            el: '.deleteConsult',
            event: 'click',
            handler: function () { 
            	var uid=this.id;
            	layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: '/reg/client/yr/ent/consult/delete',
	                    data: {uid: uid},
	                    success: function (data) {
	                        if (data.status == 'success') {  
	                                layer.msg("删除成功", {time: 1000}, function () {
	                                	initDataTable(0,10);
	                                }); 
	                        }else{
	                        	layer.msg("删除失败", {ltype: 0,time:2000});
	                        } 
	                    }
	                });
                }) 
            }
        },
       {
           el: '.viewConsult',
           event: 'click',
           handler: function () {  
               layer.dialog({
                   title: '详情',
                   area: ['100%', '100%'],
                   content: '/reg/client/yr/ent/consult/toClientConsultEditPage?uid='+this.id+"&flag=2",
                   callback: function (data) {
                        
                   }
                })
           }
       },
       {
           el: '.editConsult',
           event: 'click',
           handler: function () {  
               layer.dialog({
                   title: '修改',
                   area: ['100%', '100%'],
                   content: '/reg/client/yr/ent/consult/toClientConsultEditPage?uid='+this.id+"&flag=3",
                   callback: function (data) {
                       //重新加载列表数据
                       if (data.reload) {
                          initDataTable(0,10);
                       }
                   }
                })
           }
       },
       {
           el: '.searchConsult',
           event: 'click',
           handler: function () { 
        	   initDataTable(0,10);
           }
       },
       {
           el: '.addConsult',
           event: 'click',
           handler: function () {  
               layer.dialog({
                   title: '新增',
                   area: ['100%', '100%'],
                   content: '/reg/client/yr/ent/consult/toClientConsultEditPage?flag=1',
                   callback: function (data) {
                       //重新加载列表数据
                       if (data.reload) {
                          initDataTable(0,10);
                       }
                   }
                })
           }
       }
       
       ])
   }
})
 