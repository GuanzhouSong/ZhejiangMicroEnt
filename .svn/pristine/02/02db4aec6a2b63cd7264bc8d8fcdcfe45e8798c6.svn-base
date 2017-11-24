require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    laydate.skin('molv');//初始化皮肤 (墨绿)

    
  	//移出原因
	var codeList ={
		 id_1: "1", text_1: "列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出",
		 id_2: "2", text_2: "列入经营异常名录3年内且依照《经营异常名录管理办法》第七条规定被列入经营异常名录的企业履行公示义务后，申请移出",
		 id_3: "3", text_3: "列入经营异常名录3年内且依照《经营异常名录管理办法》第八条规定被列入经营异常名录的企业更正其公示的信息后，申请移出",
		 id_4: "4", text_4: "列入经营异常名录3年内且依照《经营异常名录管理办法》第九条规定被列入经营异常名录的企业，依法办理住所或者经营场所变更登记后，申请移出",
		 id_5: "5", text_5: "列入经营异常名录3年内且依照《经营异常名录管理办法》第九条规定被列入经营异常名录的企业，提出通过登记的住所或者经营场所可以重新取得联系，申请移出"
		 }; 
	
	
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        initspeCauseInfo();
       }
    
	
	
	function initspeCauseInfo(){ 
		var code =$("#speCause").val(); //列入原因
		var _remExcpres = window._CONFIG._remExcpres;//移出原因已存在时
		var _batchEntType = window._CONFIG._batchEntType;//类型
    	//移出原因
    	var codeList ={
    		 id_1: "1", text_1: "【已补报年度报告】（列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出）",sfcText_1:"【已补报年度报告】（依照《农民专业合作社年度报告公示暂行办法》第十条规定被列入经营异常名录的农民专业合作社，可以在补报未报年份的年度报告并公示后，申请移出）",
    		 id_2: "2", text_2: "【已履行公示义务】（列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第七条规定被列入经营异常名录的企业履行公示义务后，申请移出）",sfcText_2:"",
    		 id_3: "3", text_3: "【已更正公示信息】列入经营异常名录3年内且依照《经营异常名录管理办法》第八条规定被列入经营异常名录的企业更正其公示的信息后，申请移出",sfcText_3:"【已更正年度报告】（依照《农民专业合作社年度报告公示暂行办法》第十一条规定被列入经营异常名录的农民专业合作社，更正其公示的年度报告信息后，申请移出）",
    		 id_4: "4", text_4: "【已变更登记住所】列入经营异常名录3年内且依照《经营异常名录管理办法》第九条规定被列入经营异常名录的企业，依法办理住所或者经营场所变更登记后，申请移出",sfcText_4:"【已变更登记住所】（依照《农民专业合作社年度报告公示暂行办法》第十二条规定被列入经营异常名录的农民专业合作社，依法办理住所变更登记，申请移出）",
    		 id_5: "5", text_5: "【已重新取得联系】列入经营异常名录3年内且依照《经营异常名录管理办法》第九条规定被列入经营异常名录的企业，提出通过登记的住所或者经营场所可以重新取得联系，申请移出",sfcText_5:"【已重新取得联系】（依照《农民专业合作社年度报告公示暂行办法》第十二条规定被列入经营异常名录的农民专业合作社，提出通过登记的住所可以重新取得联系，申请移出）",
    		 id_6: "6", text_6: "【列入异常届满】列入经营异常名录3年内且依照《经营异常名录管理办法》第九条规定被列入经营异常名录的企业，提出通过登记的住所或者经营场所可以重新取得联系，申请移出",sfcText_6:"",
    		 id_7: "7", text_7: "企业注（吊）销，不再列入",sfcText_7:"农民专业合作社注（吊）销，不再列入"
    		 };
    	//根据列入原因选择对应的移出原因
    	if(code == "1"){
    		if(_batchEntType == '2'){
        		$("#remExcpres").append("<option value='" + codeList.id_1 + "'>" + codeList.sfcText_1 + "</option>");
    		}else{
        		$("#remExcpres").append("<option value='" + codeList.id_1 + "'>" + codeList.text_1 + "</option>");
    		}
    	}
    	if(code == "2"){
        		$("#remExcpres").append("<option value='" + codeList.id_2 + "'>" + codeList.text_2 + "</option>");
    	}
    	if(code == "3"){
    		if(_batchEntType == '2'){
        		$("#remExcpres").append("<option value='" + codeList.id_3 + "'>" + codeList.sfcText_3 + "</option>");
    		}else{
    		    $("#remExcpres").append("<option value='" + codeList.id_3 + "'>" + codeList.text_3 + "</option>");
    		}
    	}
    	if(code == "4"){
    		if(_batchEntType == '2'){
        		$("#remExcpres").append("<option value='" + codeList.id_4 + "'>" + codeList.sfcText_4 + "</option>");
        		$("#remExcpres").append("<option value='" + codeList.id_5 + "'>" + codeList.sfcText_5 + "</option>");
        	}else{
    		    $("#remExcpres").append("<option value='" + codeList.id_4 + "'>" + codeList.text_4 + "</option>");
    		    $("#remExcpres").append("<option value='" + codeList.id_5 + "'>" + codeList.text_5 + "</option>");
    		}
    	}
        if(_remExcpres!=null){
        	$("#remExcpres").val(_remExcpres);
        }
	} 


    var searchParams={};//查询参数声明!
    var table; 
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },
        {
            el: '#move',
            event: 'click',
            handler: function () {
//            	if(window._CONFIG._impFlag == '0' && $("#speCause").val() == '1'){ //批量导入且原因为未年报列入，申请移出 只能为更正撤销
//            		layer.msg("未按时年报批量导入时，只能更正移出", {ltype: 0,time:2000});
//            		return false;
//            	}else{
            		$("#td-remExcpres").show();
            		$("#remExcpres").val('');
//            	}
            }
        },
        {
        	el: '#notMove',//更正撤销
        	event: 'click',
        	handler: function () {
        		$("#td-remExcpres").hide();
        		$("#remExcpres").val('');
        	}
        },
        {
            el: '#save',
            event: 'click',
            handler: function () {
            	/* 校验开始 */
            	var remExcpres=$("#remExcpres").val(); 
            	var removeRea=$.trim($("#removeRea").val());
            	var firstOpin=$.trim($("#firstOpin").val());
            	var remDate=$.trim($("#remDate").val());
            	
	       		 if ($.trim($("input[name='isMove']:checked").val()) == "") {
	            	 layer.msg("请选择移出操作类型", {ltype: 0,time:2000});
	                 return false;
	             }
            	
            	if(($("#move").prop("checked")) && (remExcpres==null||remExcpres=="")){
            		layer.msg("请选择移出原因", {ltype: 0,time:2000});
                    return false;
            	}  	 
            	
            	if(removeRea==null||removeRea==""){
            		layer.msg("请输入事实和理由", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	if(removeRea.length>250){
            		layer.msg("事实和理由不能超过250个字", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	if(firstOpin==null||firstOpin==""){
            		layer.msg("请输入初审意见", {ltype: 0,time:2000});
                    return false;
            	} 
            	if(firstOpin.length>250){
            		layer.msg("初审意见不能超过250个字", {ltype: 0,time:2000});
                    return false;
            	}
//            	if(remDate==null||remDate==""){
//            		layer.msg("请选择作出决定日期", {ltype: 0,time:2000});
//                    return false;
//            	}
            	if(remDate!=null&&remDate!=""){
            		if (new Date(remDate.replace(/-/g, "/")) > new Date($("#firstdate").html().replace(/-/g, "/"))) {
   	                 layer.msg("作出决定日期不能晚于初审日期", {ltype: 0,time:2000});
   	                 return false;
   	                }
            	} 
            	if("1"==remExcpres){
            		$("#remExcpresCN").val(codeList.text_1) ;
            	}else if("2"==remExcpres){
            		$("#remExcpresCN").val(codeList.text_2) 
            	}else if("3"==remExcpres){
            		$("#remExcpresCN").val(codeList.text_3) 
            	}else if("4"==remExcpres){
            		$("#remExcpresCN").val(codeList.text_4) 
            	}else if("5"==remExcpres){
            		$("#remExcpresCN").val(codeList.text_5) 
            	}
            	$("#sendabnTime").val($("#abnTime").html());
            	var formParam=$('#pubopadetailform').serializeObject();
//            	console.log(formParam);
        	    http.httpRequest({
                     url: '/reg/server/opadetail/pubopadetail/opadetailcommit',
                     serializable: false,
                     data:formParam,
                     type: 'post',
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 layer.msg("保存成功", {time: 1000}, function () {
 								layer.close({reload: true});
                    		 }); 
                    	 }else{
                    		 layer.msg(data.msg, {ltype: 0,time:2000});
                    	 }
                     }
                 });
            }
        }]);
    }

})
