require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    
  	//列入原因
	var codeList ={
		 id_1: "1", text_1: "未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的",
		 id_2: "2", text_2: "未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的",
		 id_3: "3", text_3: "公示企业信息隐瞒真实情况、弄虚作假的",
		 id_4: "4", text_4: "通过登记的住所或者经营场所无法联系的"
		 };
    
    
    //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿) 
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        initspeCauseInfo();
       }
    
    
	function initspeCauseInfo(){ 
		var _speCause=window._CONFIG._speCause;
 		var appInReaCodeList = [
	                        	{id: "1", text: "【未按时年报】未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告"},
	                        	{id: "2", text: "【未在责令期限内公示】未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息"},
	                        	{id: "3", text: "【公示信息虚假】公示企业信息隐瞒真实情况、弄虚作假"},
	                        	{id: "4", text: "【查无下落】通过登记的住所或者经营场所无法联系"}
	        ]; 
 		var appSfcInReaCodeList = [
 		                        {id: "1", text: "【未按时年报】未按照《农民专业合作社年度报告公示办法》规定报送年度报告并公示的"},
 		                        {id: "3", text: "【公示信息虚假】农民专业合作社年度报告公示信息隐瞒真实情况、弄虚作假的"},
 		                        {id: "4", text: "【查无下落】通过登记的住所无法与农民专业合作社取得联系的"}
 		                        ]; 
		var batchEntType = window._CONFIG._batchEntType; 
		if(batchEntType == "1" || batchEntType == "3"){ //企业
	 		$.each(appInReaCodeList, function(i, n) { 
		        $("#speCause").append("<option value='" + n.id + "'>" + n.text + "</option>");
		 });
		}else{//农专社
	 		$.each(appSfcInReaCodeList, function(i, n) { 
		        $("#speCause").append("<option value='" + n.id + "'>" + n.text + "</option>");
		 });
		}
		 setTimeout(function(){
		    	$("#speCause").val(_speCause);}
		    ,0);  
	} 


    var searchParams={};//查询参数声明!
    var table; 
    function bind() {
        util.bindEvents([{
            el: '#backpubOpanoMalyList',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/opanomaly/pubopanomaly/pubOpanoMalyListPage';
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: '#pubOpanoMalyapply',
            event: 'click',
            handler: function () { 
            	var radioArr= $(":radio[name=_radio]:checked");
            	if(radioArr==null||radioArr.length==0){
            		 layer.msg("请选择企业再操作", {ltype: 0,time:2000});
                     return false;
            	}
             	
            	layer.dialog({
                    title: '经营异常名录列入申请',
                    area: ['1024px', '500px'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAddSign?priPID='+radioArr[0].value,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#auditStateSpanY',
            event: 'click',
            handler: function () {
             	 $("#decisiontr").show();
                 $("#auditState").val("1");
                 $("#auditOpin").val("予以列入经营异常名录"); 
                
            }
        },{
            el: '#auditStateSpanN',
            event: 'click',
            handler: function () {
             	 $("#decisiontr").hide();
            	 $("#auditState").val("2");
            	 $("#auditOpin").val("不予以列入经营异常名录");
            }
        },{
            el: '.pubOpanoJDS',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '生成决定书',
                    area: ['1024px', '500px'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoJDBook?busExcList='+busExcList+"&viewFlag=2",
                    callback: function (data) {
                        
                    }
                })
            }
        },{
            el: '.printspbook',
            event: 'click',
            handler: function () {
                
            }
        },{
            el: '.pubOpanoMalyDetail',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '经营异常名录设置 - 查看详情',
                    area: ['1024px', '500px'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAuditEdit?busExcList='+busExcList+"&viewFlag=2",
                    callback: function (data) {
                        
                    }
                })
            }
        },{
            el: '#savepubOpanoBtn',
            event: 'click',
            handler: function () {
            	
            	var flag=true;
            	var busExcList=$("#busExcList").val();
            	var auditState=$("#auditState").val();
            	var auditOpin=$.trim($("#auditOpin").val());
            	var abnTime=$("#abnTime").val();
            	 if(abnTime==null||abnTime==""){
            		layer.msg("请选择作出决定日期", {ltype: 0,time:2000});
                    return false;
            	 } 
            	
            	 if (new Date(abnTime.replace(/-/g, "/")) > new Date($("#auditDate").val().replace(/-/g, "/"))) {
	                 layer.msg("作出决定日期不能晚于审核日期", {ltype: 0,time:2000});
	                 return false;
	             }
            	
            	 if(auditState==null||auditState==""){
             		layer.msg("请选择是否予以列入异常名录", {ltype: 0,time:2000});
                     return false;
             	 }
            	
            	if(auditOpin==null||auditOpin==""){
            		layer.msg("请填写审核意见", {ltype: 0,time:2000});
                    return false;
            	} 
            	if(auditOpin.length>500){
            		layer.msg("审核意见不能超过500字", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	
            	
            	 //当予以列入异常时检验是否生成决定书
            	 if("1"==auditState){
            		 //校验异常列入决定书
                	 http.httpRequest({
                         url:'/reg/server/opanomaly/pubopanomaly/existPubOpanoJDBook',
                         serializable: false,
                         data: {"busExcList":busExcList},
                         type: 'post',
                         async:false,
                         success: function (data) { 
                        	 
                      	    if(data.status != 'success'){
                      	    	 layer.msg("请先生成列入经营异常名录决定书再提交", {ltype: 0,time:2000});
                      	    	 flag= false;
                      	    }
                         }
                     });
            	 } 
            	 if(flag){
            		 var formParam=$('#pubauditosaveform').serializeObject();
                	 http.httpRequest({
                         url: '/reg/server/opanomaly/pubopanomaly/commitAuditPubOpanoMaly',
                         serializable: true,
                         data:formParam,
                         type: 'post',
                         success: function (data) {
                        	 
                        	 if(data.status == 'success'){
                        		 layer.msg("保存成功", {time: 2000}, function () {
      								layer.close({reload: true});
                         		 });  
                      	      }else{
                      	    	 layer.msg(data.msg, {ltype: 0,time:2000});
                      	      }
                         }
                     });
            	 }
            }
        }]);
    } 
})
