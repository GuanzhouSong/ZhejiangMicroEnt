require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination'], function (layer, dataTable, util, http,handlebars) {

	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
    init();
    
    /**
     * 初始化函数集合
     */
    
    function init() {
        bind();
    }
    
    function initDataInvsraTable() {
        http.httpRequest({
            url: _sysUrl+'/sccheck/scplantask/selectPubSccheckTypeJSON.json',
            serializable: false,
            data:{start: 0,length: 9999,pageNum: 0},
            success: function (data) {
	        	 if (data.data == "" || data.data == null) {//如果没有
	                  $('#invsraltplPage').html("<td valign='top' colspan='5' class='dataTables_empty'>无</td>");
	                 // $("#invsralTotal").text(0); 
	                  return false;
	             }
                /*var showPage = data.recordsTotal;
                if(showPage==null||showPage==""){
                	showPage=0;
                }
                $("#invsralTotal").text(showPage); */
                /*$('#paginvsral').pagination(showPage, {//分页工具
                    callback: pageInvsraCallback,
                    items_per_page: 5,
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页'
                });*/
                /*$("#invsralCount").text(data.recordsTotal);
                var totalPages = Math.ceil(data.recordsTotal / 5);
                $("#invsralPageCount").text(totalPages);*/
                var handleHelper = handlebars.registerHelper("addOne",
                    function (index) {
                            return index + 1;
                    });
                
                handlebars.registerHelper("transType",
                        function(value) { 
                	     return  '<a href="javascript:void(0)" class="js-yrinfo">删除</a>';
                         }
                     );
                var myTemplate = handlebars.compile($("#invsral-template").html());
                if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0) $('#invsral').html(myTemplate(data.data));
            }
        })
    }
    
     
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
       },
       {
           el: '#btn_save',
           event: 'click',
           handler: function() { 
        	   
        	  var  checkName=$.trim($("#checkName").val());
        	  if(checkName==null||checkName==""){
        		  layer.msg("检查事项名称不能为空", {ltype: 0,time:3000});
  	    		  return false;
        	  } 
        	  var  remark=$.trim($("#remark").val());
        	  if(remark!=null&&remark!=""&&remark.length>300){
        		  layer.msg("说明项字符长度已经超过限制", {ltype: 0,time:3000});
  	    		  return false;
        	  }
        	  var checkObj=new Object();
        	  checkObj.checkName=checkName;
        	  checkObj.remark=remark;
        	  checkObj.flag="1";
        	  layer.close(checkObj);
           }
      }
       ])
    }

})