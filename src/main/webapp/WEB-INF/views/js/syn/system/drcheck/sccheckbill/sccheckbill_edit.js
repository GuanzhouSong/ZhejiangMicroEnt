require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */

    function init() {
        bind();
    }
    
    function formvalid(){
    	var checkCode = $("#checkCode").val();
    	if(checkCode == ""){
    		layer.tips("请选择类别",$("#checkCode"),{tips:3, tipsMore:true, ltype:0});
			return false;
    	}
    	var checkItemDesc = $("#checkItemDesc").val();
    	if(checkItemDesc != "" && checkItemDesc.length > 100){
    		layer.tips("检查事项名称不能超过50个中文字",$("#checkItemDesc"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkLittleItemDesc = $("#checkLittleItemDesc").val();
    	if(checkLittleItemDesc != "" && checkLittleItemDesc.length > 100){
    		layer.tips("检查子项名称不能超过50个中文字",$("#checkLittleItemDesc"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkReason = $("#checkReason").val();
    	if(checkReason == "" || checkReason.length > 1000){
    		layer.tips("请输入500个中文字以内的检查依据",$("#checkReason"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkObject = $("#checkObject").val();
    	if(checkObject == "" || checkObject.length > 100){
    		layer.tips("请输入500个中文字以内的检查对象",$("#checkObject"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkScale = $("#checkScale").val();
    	if(checkScale == "" || checkScale.length > 1000){
    		layer.tips("请输入500个中文字以内的比例",$("#checkScale"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkFrequent = $("#checkFrequent").val();
    	if(checkFrequent == "" || checkFrequent.length > 1000){
    		layer.tips("请输入500个中文字以内的检查频次",$("#checkFrequent"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkWay = "";
    	$(".checkWayV").each(function(){
			if($(this).prop("checked")){
				var value = $(this).val();
				if(checkWay == ""){
					checkWay = value;
				}else{
					checkWay += ","+value;
				}
			}
		});
    	if(checkWay == ""){
    		layer.tips("请选择检查方式",$("#checkWay1"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	$("#checkWay").val(checkWay);
    	var checkContent = $("#checkContent").val();
    	if(checkContent == "" || checkContent.length > 1000){
    		layer.tips("请输入500个中文字以内的检查内容及要求",$("#checkContent"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var checkManFlag = $("#checkManFlagDiv input[name='checkManFlag']:checked").val();
    	if(checkManFlag == "" || checkManFlag == null || checkManFlag == "undefined"){
    		layer.tips("请选择检查人员要求",$("#checkManFlag1"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var remark = $("#remark").val();
    	if(remark != "" && remark.length > 100){
    		layer.tips("备注不能超过500个中文字",$("#remark"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var responsibleOffices = $("#responsibleOffices").val();
    	if(responsibleOffices != "" && responsibleOffices.length > 100){
    		layer.tips("责任处室不能超过50个中文字",$("#responsibleOffices"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	var isScVlid = $("#isScVlidDiv input[name='isScVlid']:checked").val();
    	if(isScVlid == "" || isScVlid == null || isScVlid == "undefined"){
    		layer.tips("请选择状态",$("#isScVlid1"),{tips:3, tipsMore:true, ltype:0});
    		return false;
    	}
    	return true;
    }

    function bind() {
       util.bindEvents([{
            el: '#close',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
        	el: '#save',
        	event: 'click',
        	handler: function () {
        		if(formvalid()){
        			var formParam = $('#pubSccheckBillForm').serializeObject();
        			http.httpRequest({
        				url: '/syn/server/drcheck/pubsccheckbill/save',
        				data: formParam,
        				type: 'post',
        				success: function (data) {
        					layer.msg(data.msg, {time: 1000}, function () {
        						layer.close({reload: true});
        					});
        				}
        			})
        		}
        	}
        }])
    }

})