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
    	var _auditState = window._CONFIG._auditState;//审核状态    	
    	if(_auditState=="1"){//已审核且同意更正（撤销），查看
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
                 $("#auditState").val("1");
                 $("#auditOpin").val("予以更正（撤销）异常名录信息。"); 
                
            }
        },{
            el: '#no',
            event: 'click',
            handler: function () {
            	 $("#auditState").val("2");
            	 $("#auditOpin").val("不予更正（撤销）异常名录信息。");
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	debugger
            	var flag=true;
            	var busExcList=$("#busExcList").val();
            	var auditState=$("#auditState").val();
            	var auditOpin=$.trim($("#auditOpin").val());
            	
            	var remDate=$("#remDate").val();
            	 if(remDate==null||remDate==""){
            		layer.msg("请填输入作出决定日期", {ltype: 0,time:2000});
                    return false;
            	 } 
            	 if (new Date(remDate.replace(/-/g, "/")) < new Date($("#abnTime").html().replace(/-/g, "/"))) {
	                 layer.msg("作出决定日期不能早于列入作出决定日期", {ltype: 0,time:2000});
	                 return false;
	             }            	
            	 
            	 if (new Date(remDate.replace(/-/g, "/")) > new Date($("#auditDate").html().replace(/-/g, "/"))) {
	                 layer.msg("作出决定日期不能晚于审核日期", {ltype: 0,time:2000});
	                 return false;
	             }
            	
            	 if(auditState==null||auditState==""){
             		layer.msg("请选择是否予以更正（撤销）", {ltype: 0,time:2000});
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

        		 var formParam=$('#pubauditosaveform').serializeObject();
            	 http.httpRequest({
                     url: '/reg/server/opadetail/pubopadetail/opadetailAuditCommit',
                     serializable: false,
                     data:formParam,
                     type: 'post',
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 layer.msg(data.msg, {time: 1000}, function () {
  								layer.close({reload: true});
                     		 });  
                  	      }else{
                  	    	 layer.msg(data.msg, {ltype: 0,time:1000});
                  	      }
                     }
                 });
        	 }
        }]);
    } 
})
