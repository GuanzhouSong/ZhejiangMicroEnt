require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','common/validateRules'],
		function (layer, dataTable, util, http, handlebars) {
	
	var params=$("#hxForm").serializeObject();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	timeSet();
        initPubdtinfo();
        bind();
    }
    
    function initPubdtinfo(){
    	initPubdtinfoTable(0,5);
    }
    
	function timeSet(){
		$('#selectDate').html('');	
        var d = new Date();
        var year = d.getFullYear();
        for(var a=1;a<=3;a++){
    	$('#selectDate').append("<option value='"+year+"'>"+year+"</option>");
        year--;
      }
	}
    /**
     * 初始化dataTable
     */
    function initPubdtinfoTable(page, length, callback) {
    	http.httpRequest({
            url: '/depsyn/feedbacklist',
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
                handlebars.registerHelper('state', function(realNum) {
                	if(realNum==null) return "录入";
                	else return "修改";
                    });
                var myTemplate = handlebars.compile($("#table_list").html());
                $('#table_page').html(myTemplate(data));
                $("#pro_total").text(itemCount);
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#pro_pageNum").text(pageNum);
            }
        });
    }

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
                el: '.edit', 
                event: 'click',
                handler: function () {
                	layer.dialog({
                        title: false,
                        shadeClose: true,
                        closeBtn:false,
                        area: ['520px', '300px'],
                        content: '/depsyn/editview?id='+this.id,
                        callback: function (data) {
                        	if(data.flag==true){
                        		initPubdtinfoTable(0,5);
                        	}
                        }
                    })
                }
            }
        ])
    }

})
