require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.serialize'], function(layer, util, http) {
	
	var urlHead=window._CONFIG.urlHead;
	init();
	var $tb_ent=$("#tb_ent_bd"), $tb_man=$("#tb_man_bd");
	var tab=$("#tab").val();
	/**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    //审核单据
    function save(){
    	$.ajax({
    		type : "POST",
			url : urlHead+'/noCreditPunish/back/save',
			data : {"backContent": $("#backContent").val(), "batchNo": $("#batchNo").val()},
			datatype : 'JSON',
			async : true,
			success : function(json) {
				if(json.status=="success"){
					$("#subback").hide();
					layer.msg(json.msg, {time: 1500}, function() {});
				} else
					layer.msg(json.msg, {time: 5000}, function() {});
			}
    	});
    }
    
    //明细操作事件
    $tb_ent.delegate('a','click',function(){
    	var tag=$(this).attr("tag");
    	if(tag=="del"){
	    	var priPID=$(this).attr("priPID");
	    	delete contentjson[priPID];
	    	$(this).parent().parent().remove();
    	}else if(tag=="view"){
    		var priPID=$(this).attr("priPID");
    		recordDialog(priPID, "ent");
    	}
    });
    
    //明细操作事件
    $tb_man.delegate('a','click',function(){
    	var tag=$(this).attr("tag");
    	if(tag=="del"){
	    	var cardNo=$(this).attr("cardNo");
	    	delete contentjson[cardNo];
	    	$(this).parent().parent().remove();
    	}else if(tag=="view"){
    		var cardNo=$(this).attr("cardNo");
    		recordDialog(cardNo, "man");
    	}
    });
    
    //弹出惩戒记录框
    function recordDialog(key, type) {
    	layer.dialog({
    		title: '惩戒记录',
    		area: ['1000px', '600px'],
    		content: urlHead+'/noCreditPunish/info/recordlist?type='+type+'&key='+key,
    		callback: function(data) { }
    	})
    }
	
	//事件绑定
    function bind() {
        util.bindEvents([{
            el: '#subback',
            event: 'click',
            handler: function() {
            	save();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	window.history.back(-1);
            }
        }])
    }
    
});