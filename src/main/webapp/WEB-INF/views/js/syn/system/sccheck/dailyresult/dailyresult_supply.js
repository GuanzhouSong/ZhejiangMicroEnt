require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    var disposeS = $("input[name='disposeState']:checked").val();
    if(disposeS=='1'){
    	$(".sp").hide();
    }else{
    	$(".sp").show();
    }
    
    function save(){
    	var disposeState = $("input[name='disposeState']:checked").val();
		var disposeFinishDate = $("#disposeFinishDate").val();
		if(disposeState=='1'){
			layer.msg("后续处置措施是否完结必须选择已完结!", {time: 2000}, function() {});
		}else if(disposeState=='2'&&disposeFinishDate==""){
			layer.msg("完结日期是必填项", {time: 2000}, function() {});
		}else{
			var searchParams = $("#taskForm").serializeObject();
			http.httpRequest({
				url: '/reg/dailycheck/dailyinspectresult/dosupplycheckobj',
				dataType:"json",  
				contentType : 'application/json',
				data: JSON.stringify(searchParams),
				type:"post",
				success: function (data) {
					layer.msg(data.msg, {time: 1000}, function () {
						if(data.status == 'success'){
							layer.close({reload: true});
						}
					});
				}
			});
		}
   }
    
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	save();
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        },{
            el: '.dis',
            event: 'click',
            handler: function () {
            	var auditState = $("input[name='disposeState']:checked").val();
            	if(auditState=="1"){
            		$(".sp").hide();
            	}else{
            		$(".sp").show();
            	}
            }
        },{
            el: '.crt',
            event: 'click',
            handler: function () {
            	var isChk = $(this).prop("checked");
            	var value = $(this).val();
            	if(isChk){
            		if(value=='1'){
            			$(".crt").prop("checked", false);
            			$('.crt').attr("disabled","disabled");
            			$(this).prop("checked", true);
            			$(this).attr("disabled",false);
            		}
            	}else{
            		$('.crt').attr("disabled",false);
            	}
            }
        }]);
    }
});
