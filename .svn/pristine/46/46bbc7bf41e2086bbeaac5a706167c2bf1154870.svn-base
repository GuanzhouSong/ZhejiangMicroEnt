require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    
    function init() { 
        bind();
        
        //默认选择
        var checkItemList = [];
        $(".checkClass").each(function(){
        	var checkedVal  = $(this).val();
        	checkItemList.push(checkedVal);
        	$(".allItemClass").each(function(){
        		if(checkedVal == $(this).val()){
        			$(this).attr("checked","checked");
        		}
        	})
        })
    }
    
    function bind() {
        util.bindEvents([{
            el: '.export',
            event: 'click',
            handler: function () {
            	var nofindCode = "A04,A06,A09,B05,C02,C05,C09,C14,D01";
            	var checkCode = $(this).attr("checkCode");
            	var downLoadFlag = $("#downLoadFlag").val();
            	$("#itemCode").val(checkCode);
            	if(nofindCode.indexOf(checkCode) != -1){
            		alert("该检查事项暂不能提供下载！");
            		return false;
            	}
				if(downLoadFlag == '1'){
				   window.location.href = "/reg/sccheck/pubscentresult/sccheck_down?checkCode="+checkCode;      		
				}else{
				   //导出
	               $("#exportform").submit();         		
            	}
            }
        }]);
    }
});
