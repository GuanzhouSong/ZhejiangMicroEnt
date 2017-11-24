require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
      
    //时间控件初始化
    laydate.skin('molv');//初始化皮肤 (墨绿) 
    /**
     * 初始化函数集合
     */
    function init() { 
    	initInfo();
        bind();
       }

    function initInfo(){ 
    	var _remExcpres = window._CONFIG._remExcpres;//移出原因
    	var _auditState = window._CONFIG._auditState;//审核状态
		var _batchEntType = window._CONFIG._batchEntType;//类型
    	var outCodeForEntList = [
    	                     	{id: "1", text: "【已补报年度报告】列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出"},
    	                     	{id: "2", text: "【已履行公示义务】列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第七条规定被列入经营异常名录的企业履行公示义务后，申请移出"},
    	                     	{id: "3", text: "【已更正公示信息】列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第八条规定被列入经营异常名录的企业更正其公示的信息后，申请移出"},
    	                     	{id: "4", text: "【已变更登记住所】列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第九条规定被列入经营异常名录的企业，依法办理住所或者经营场所变更登记后，申请移出"},
    	                     	{id: "5", text: "【已重新取得联系】列入经营异常名录3年内且依照《企业经营异常名录管理暂行办法》第九条规定被列入经营异常名录的企业，提出通过登记的住所或者经营场所可以重新取得联系，申请移出"},
    	                     	{id: "6", text: "【列入异常届满】列入经营异常名录届满3年仍未履行相关义务的，列入严重违法企业名单，自动移出"},
    	                     	{id: "7", text: "企业注（吊）销，不再列入"}                   
    	                     ]
    	
    	/*农专移出原因*/
    	var outCodeForSfcList = [
    		{id: "1", text: "【已补报年度报告】依照《农民专业合作社年度报告公示暂行办法》第十条规定被列入经营异常名录的农民专业合作社，可以在补报未报年份的年度报告并公示后，申请移出"},
    		{id: "3", text: "【已更正年度报告（】依照《农民专业合作社年度报告公示暂行办法》第十一条规定被列入经营异常名录的农民专业合作社，更正其公示的年度报告信息后，申请移出"},
    		{id: "4", text: "【已变更登记住所】依照《农民专业合作社年度报告公示暂行办法》第十二条规定被列入经营异常名录的农民专业合作社，依法办理住所变更登记，申请移出"},
    		{id: "5", text: "【已重新取得联系】依照《农民专业合作社年度报告公示暂行办法》第十二条规定被列入经营异常名录的农民专业合作社，提出通过登记的住所可以重新取得联系，申请移出"},
    		{id: "7", text: "农民专业合作社注（吊）销，不再列入"}                          
    	]
    	
    	if(_batchEntType == '2'){//农专社
        	$.each(outCodeForSfcList, function(_remExcpres, n) { 
    	        $("#remExcpres").append("<option value='" + n.id + "'>" + n.text + "</option>");
    	    });
    	}else{
        	$.each(outCodeForEntList, function(_remExcpres, n) { 
    	        $("#remExcpres").append("<option value='" + n.id + "'>" + n.text + "</option>");
    	    });
    	}
    	if(_remExcpres!=null){
        	$("#remExcpres").val(_remExcpres);
        }
    	if(_auditState =="1"){//已审核且同意移出，查看
    		$("#save").hide();//保存框隐藏
    		$(".view-opadetail").attr("disabled","disabled");
    	}
    	
	} 

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: '#yes',
            event: 'click',
            handler: function () {
            	 $("#decisionBook").show();
                 $("#auditState").val("1");
                 if($("#isMove").val()== "1"){//移出
                     $("#auditOpin").val("予以移出经营异常名录"); 
                 }else{
                     $("#auditOpin").val("予以更正（撤销）异常名录信息"); 
                 }
                
            }
        },{
            el: '#no',
            event: 'click',
            handler: function () {
            	 $("#decisionBook").hide();
            	 $("#auditState").val("2");
            	 if($("#isMove").val()== "1"){//移出
                     $("#auditOpin").val("不予移除经营异常名录"); 
                 }else{
                     $("#auditOpin").val("不予更正（撤销）异常名录信息"); 
                 }
            }
        },{
            el: '#doEnDecisionBook',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '生成决定书',
                    area: ['1024px', '600px'],
                    content: '/reg/server/opadetail/pubopadetail/opadetailBook?busExcList='+$("#busExcList").val()+"&priPID="+$("#priPID").val(),
                    callback: function (data) {
                        
                    }
                })
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	var flag=true;
            	var busExcList=$("#busExcList").val();
            	var auditState=$("#auditState").val();
            	var auditOpin=$.trim($("#auditOpin").val());
            	var remDate=$("#remDate").val();
            	 if(remDate==null||remDate==""){
            		layer.msg("请选择作出决定日期", {ltype: 0,time:2000});
                    return false;
            	 } 
            	 
            	 if (new Date(remDate.replace(/-/g, "/")) < new Date($("#abnTime").html().replace(/-/g, "/"))) {
	                 layer.msg("作出决定日期不能早于列入做出决定日期", {ltype: 0,time:2000});
	                 return false;
	             }            	 
            	
            	 if (new Date(remDate.replace(/-/g, "/")) > new Date($("#auditDate").html().replace(/-/g, "/"))) {
	                 layer.msg("作出决定日期不能晚于审核日期", {ltype: 0,time:2000});
	                 return false;
	             }
            	
            	 if(auditState==null||auditState==""){
             		layer.msg("请选择是否予以移出异常名录", {ltype: 0,time:2000});
                     return false;
             	 }
            	
            	if(auditOpin==null||auditOpin==""){
            		layer.msg("请填写审核意见", {ltype: 0,time:2000});
                    return false;
            	} 
            	if(auditOpin.length>250){
            		layer.msg("审核意见不能超过250字", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	 //当予以列入异常时检验是否生成决定书
            	 if("1"==auditState){
            		 //校验异常列入决定书
                	 http.httpRequest({
                         url:'/reg/server/opadetail/pubopadetail/existopadetailBook',
                         serializable: false,
                         data: {"busExcList":busExcList,"priPID":$("#priPID").val()},
                         type: 'post',
                         async:false,
                         success: function (data) { 
                      	    if(data.status != 'success'){
                      	    	 layer.msg("请先生成移出经营异常名录决定书再提交", {ltype: 0,time:2000});
                      	    	 flag= false;
                      	    	 return false;
                      	    }
                         }
                     });
            	 } 
            	 if(flag){
            		 var formParam=$('#pubauditosaveform').serializeObject();
                	 http.httpRequest({
                         url: '/reg/server/opadetail/pubopadetail/opadetailAuditCommit',
                         serializable: false,
                         data:formParam,
                         type: 'post',
                         success: function (data) {
                        	 if(data.status == 'success'){
                        		 layer.msg("审核成功", {time: 1000}, function () {
      								layer.close({reload: true});
                         		 });  
                      	      }else{
                      	    	 layer.msg("审核失败", {ltype: 0,time:1000});
                      	      }
                         }
                     });
            	 }
            }
        }]);
    } 
})
