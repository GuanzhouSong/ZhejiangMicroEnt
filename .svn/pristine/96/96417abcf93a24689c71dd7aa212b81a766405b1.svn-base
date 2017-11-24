require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.serialize'], function(layer, util, http) {
	
	var urlHead=window._CONFIG.urlHead;
	init();
	var $tb_ent=$("#tb_ent_bd"), $tb_man=$("#tb_man_bd");
	var type=$("#punType").val();
	/**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    //审核单据
    function audit(){
    	var res=$('input[name="auditRes"]:checked').val();
    	var auditView=$('#auditView').val(); 
    	if(res==null||res==""){
    		layer.msg("请选择审核结果", {time: 3000}, function() {});
    		return false;
    	}
    	if(auditView==null||auditView==""){
    		layer.msg("请填写审核意见", {time: 3000}, function() {});
    		return false;
    	}
    	if(auditView.length>200){
    		layer.msg("审核意见不能大于200个字符", {time: 3000}, function() {});
    		return false;
    	}
    	
    	$.ajax({
    		type : "POST",
			url : urlHead+'/noCreditPunish/info/audit',
			data : {"auditView": $("#auditView").val(), "auditRes": res, "batchNo": $("#batchNo").val(), "feedBack": $("#feedBack").val(), "isLife": $("#isLife").val()},
			datatype : 'JSON',
			async : true,
			success : function(json) {
				if(json.status=="success"){
					$("#audit").hide();
					layer.msg(json.msg, {time: 1500}, function() {
						window.history.back(-1);
					});
				} else
					layer.msg(json.msg, {time: 3000}, function() {});
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
    
    $("#filelabel").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        window.open(urlHead+"/noCreditPunish/info/download?fileName=" + path);
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
            el: '#savebutton',
            event: 'click',
            handler: function() {
            	audit();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	window.history.back(-1);
            }
        },{
            el: '#auditStateSpanY',
            event: 'click',
            handler: function () {
                 $("#auditView").val("同意发出"); 
                
            }
        },{
            el: '#auditStateSpanN',
            event: 'click',
            handler: function () {
            	 $("#auditView").val("退回修改");
            }
        },
        {
            el: '#print',
            event: 'click',
            handler: function() {
                window.open(urlHead+"/noCreditPunish/info/edit?deal=4&batchNo="+$("#batchNo").val());
            }
        }
        ])
    }
    
});