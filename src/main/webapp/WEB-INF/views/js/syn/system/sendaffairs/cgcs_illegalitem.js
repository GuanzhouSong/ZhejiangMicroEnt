require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','common/validateRules'], function(layer, dataTable, util, http, handlebars) {
	
	var deptcode = $("#deptcode").val();
	var searchParam = "";
	var data = new Object();
	var _illegalitemUrlHead = window._CONFIG._illegalitemUrlHead;
	init();
	
	   function init() {
	        bind();
	        getIllegalList();
	    }
		
	   
	   function getIllegalList(){
		   http.httpRequest({
               url: _illegalitemUrlHead+'doGetIllegalItemList',
               serializable: false,
               data: {"deptCode":deptcode,"illegalItems":searchParam},
               type: 'post',
               success: function (json) {
               	if(json.status=="success"){
               		$("#real").remove();
               		var page = "<div id='real'>";
               		$.each(json.data,function(i, item){
               			page += "<div class='option-item'><label><input type='checkbox' name='illegalitem'><span class='name'>"+item.illegalItems+"</span></label></div>"; 
               		});
               		page += "</div>";
               		$("#illegalList").append(page);
					}
               	
            	$("#real input:checkbox").click(function(){
            		$("#real input:checkbox").not($(this)).removeAttr("checked");
            		});
               }
           });
	   }
	   
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#save',
	            event: 'click',
	            handler: function() {
	            	data.flag = true;
	            	data.text = $("#real input[type='checkbox']:checked + span").text();
	            	if(data.text == ""){
	            		layer.msg("请选择违法事项！", {time: 1500}, function() {});
	            		return false;
	            	}
	            	layer.close(data);
	            }
	        }, {
	            el: '#cancel',
	            event: 'click',
	            handler: function() {
	            	data.flag = false;
	            	layer.msg("已关闭！", {time: 1500}, function() {});
	            	layer.close(data);
	            }
	        }, {
	            el: '.btn-search',
	            event: 'click',
	            handler: function() {
	            	searchParam = $("#searchparam").val();
	            	if(searchParam=="") {
	            		layer.msg("请输入搜索条件！", {time: 1500}, function() {});
	            		return false;
	            	}
	            	getIllegalList();
	            }
	        }])
	    }
})
