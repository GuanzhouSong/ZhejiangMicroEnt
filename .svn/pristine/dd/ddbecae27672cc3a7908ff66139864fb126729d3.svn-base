require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','common/validateRules'],
		function (layer, dataTable, util, http, handlebars) {
	
	var params=$("#hxForm").serializeObject();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initPubdtinfo();
        bind();
    }
    
    function initPubdtinfo(){
    	initPubdtinfoTable(0,5);
    }
    /**
     * 初始化dataTable
     */
    function initPubdtinfoTable(page, length, callback) {
    	http.httpRequest({
            url: '/depsyn/querylicense',
            data: {length: length,start: page*length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal;
                $('.pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	initPubdtinfoTable(page,5);
                    }
                });
                var infoArry = data.data
                if(infoArry != null){
                	for(var i=0;i<data.data.length;i++){
                    	if(infoArry[i].uniSCID == null){
                    		infoArry[i].uniSCID = infoArry[i].regNO;
                    	}
                	}
                }
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                var myTemplate = handlebars.compile($("#table_list").html());
                $('#table_page').html(myTemplate(data));
                $("#pro_total").text(itemCount);
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pro_pageNum").text(pageNum);
            }
        });
    }
    $('.delete').click(function(){
    	var idArr = "";
      	 $('.chb').each(function(){ 
      		 var id = $(this).val();
          	 if($(this).is(':checked')){
              		    idArr = idArr + id +',';
      		  }
      	 });
      	 if(idArr==''){
      		layer.msg("请选择！");return;
      	 }
      	layer.confirm('确定要删除选中记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
            layer.close(index);
             http.httpRequest({
                 url: '/depsyn/deletelicense',
                 serializable: false,
                 data: {idArr:idArr.substring(0,idArr.length-1)},
                 type: 'post',
                 success: function (data) {
                     layer.msg(data.msg, {time: 1000}, function () {
                     	if(data.status=='success'){
                     		initPubdtinfoTable(0,5);
                     	}
                     });
                 }
             });
      	   });
   		 });
      	 
    function bind() {
        util.bindEvents([
            {
                el: '#search', 
                event: 'click',
                handler: function () {
                params = $("#hxForm").serializeObject();
                initPubdtinfoTable(0,5);
                }
            },{
            	el:'.chbAll',
            	event:'click',
            	handler:function(){
            		var check = $(this).prop('checked');
            	      $('.chb').prop('checked', check);
            	}
            },{
            	el:'.edit',
            	event:'click',
            	handler:function(){
            		layer.dialog({
                        title: '添加行政许可信息',
                        area: ['50%', '50%'],
                        content: '/depsyn/eneditlicense?id='+this.id,
                        callback: function (data) {
                        	 if(data.flag==true)
                        		 initPubdtinfoTable(0,5);
                        }
                    })
            	}
            }
        ])
    }

})
