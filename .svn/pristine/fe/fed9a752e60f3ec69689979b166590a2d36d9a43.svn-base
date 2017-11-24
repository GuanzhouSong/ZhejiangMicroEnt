require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    
  	//企业列入原因
	var codeList ={
		 id_1: "1", text_1: "未按照《企业信息公示暂行条例》第八条规定的期限公示年度报告的",sfctext_1:"未按照《农民专业合作社年度报告公示办法》规定报送年度报告并公示的",
		 id_2: "2", text_2: "未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息的",sfctext_2:"",
		 id_3: "3", text_3: "公示企业信息隐瞒真实情况、弄虚作假的",sfctext_3:"农民专业合作社年度报告公示信息隐瞒真实情况、弄虚作假的",
		 id_4: "4", text_4: "通过登记的住所或者经营场所无法联系的",sfctext_4:"通过登记的住所无法与农民专业合作社取得联系的",
		 }; 
	//农专社列入原因
	var sfccodeList ={
			id_1: "1", text_1: "未按照《农民专业合作社年度报告公示办法》规定报送年度报告并公示的",
			id_3: "3", text_3: "农民专业合作社年度报告公示信息隐瞒真实情况、弄虚作假的",
			id_4: "4", text_4: "通过登记的住所无法与农民专业合作社取得联系的"
	}; 
	
	
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
		var batchEntType = $("#batchEntType").val(); 
		if(batchEntType == "1"){ //企业
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
		 
		 
		 var beginYear = new Date().getFullYear().toString();
         var beginMonth = (new Date().getMonth() + 1).toString();
         var beginDay = new Date().getDate().toString();
         var beginDate = beginYear +"-"+ beginMonth +"-" + beginDay;
         //结束时间
			var endYear = new Date().getFullYear().toString();
         var endMonth = "6";
         var endDay = "30";
         var endDate = endYear + "-" + endMonth + "-" + endDay;
         var d1 = new Date(beginDate.replace(/\-/g, "\/"));  
         var d2 = new Date(endDate.replace(/\-/g, "\/")); 
         //6月30日前列入原因选项中不显示未按期年报这条原因。
         if(d1 < d2){
         	$("#speCause option[value='1']").remove();
         }
         //新增的时候默认初审意见
         if(_speCause==null||_speCause==""){
        	 $("#firstOpin").val("拟列入经营异常名录。");
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
        },{
            el: '.pubOpanoMalyDetail',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	layer.dialog({
                    title: '经营异常名录设置 - 查看详情',
                    area: ['80%', '88%'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAuditEdit?busExcList='+busExcList+"&viewFlag=2",
                    callback: function (data) {
                        
                    }
                })  
            }
        },{
            el: '#savepubOpanoBtn',
            event: 'click',
            handler: function () {
            	var speCause=$("#speCause").val(); 
            	var anomalyRea=$.trim($("#anomalyRea").val());
            	var firstOpin=$.trim($("#firstOpin").val());
            	var abnTime=$.trim($("#abnTime").val()); 
            	if(speCause==null||speCause==""){
            		layer.msg("请选择列入原因", {ltype: 0,time:2000});
                    return false;
            	}
            	
            	//不允许同一个企业同一个年度未按时年报原因重复列入异常名录。
            	//不允许同一个企业因查无下落重复列入异常名录。
            	if(speCause=="1"||speCause=="4"){
            		var flag=true;
            		$(".appInReaCodeExist").each(function(){
            			if(speCause=="1"){
            				if($(this).html() == speCause && $(this).attr("year") == $("#year").val()){
                        		flag=false;
                         		if(!flag){
                        			layer.msg("不允许同一个企业同一个年度未按时年报原因重复列入异常名录。", {ltype: 0,time:2000});
                         			return false;
                         		}
                        	} 
            			}else{
                        	if($(this).html() == speCause){
                        		flag=false; 
                        		if(!flag){
                        			layer.msg("不允许同一个企业因查无下落重复列入异常名录。", {ltype: 0,time:2000});
                        			return false;
                        		}
                        	}
            			}
                    });
            	if(!flag){
        			return false;
        		} 
            	}
            	if(anomalyRea==null||anomalyRea==""){
            		layer.msg("请输入事实和理由", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	if(anomalyRea.length>500){
            		layer.msg("事实和理由不能超过500个字", {ltype: 0,time:2000});
                    return false;
            	} 
            	
            	if(firstOpin==null||firstOpin==""){
            		layer.msg("请输入初审意见", {ltype: 0,time:2000});
                    return false;
            	} 
            	if(firstOpin.length>500){
            		layer.msg("初审意见不能超过500个字", {ltype: 0,time:2000});
                    return false;
            	}
            	if(abnTime!=null&&abnTime!=""){
            		if (new Date(abnTime.replace(/-/g, "/")) > new Date($("#firstdate").val().replace(/-/g, "/"))) {
   	                 layer.msg("作出决定日期不能晚于初审日期", {ltype: 0,time:2000});
   	                 return false;
   	                }
            	} 
	        	if($("#batchEntType").val() == "1"){
	            	if("1"==speCause){
	            		$("#speCauseCN").val(codeList.text_1) ;
	            	}else if("2"==speCause){
	            		$("#speCauseCN").val(codeList.text_2) 
	            	}else if("3"==speCause){
	            		$("#speCauseCN").val(codeList.text_3) 
	            	}else if("4"==speCause){
	            		$("#speCauseCN").val(codeList.text_4) 
	            	}
	        	}else{
	            	if("1"==speCause){
	            		$("#speCauseCN").val(codeList.sfctext_1) ;
	            	}else if("3"==speCause){
	            		$("#speCauseCN").val(codeList.sfctext_3) 
	            	}else if("4"==speCause){
	            		$("#speCauseCN").val(codeList.sfctext_4) 
	            	}
	        	}
            	

            	var formParam=$('#pubosaveform').serializeObject();
            	if(speCause!="1"){
            		delete formParam.year
            	}
            	 http.httpRequest({
                     url: '/reg/server/opanomaly/pubopanomaly/commitPubOpanoMaly',
                     serializable: true,
                     data:formParam,
                     type: 'post',
                     success: function (data) {  
                    	 if(data.status == 'success'){
                    		 layer.msg("保存成功", {time: 1000}, function () {
 								layer.close({reload: true});
                    		 }); 
                    	 }else{
                    		 layer.msg("保存失败", {ltype: 0,time:2000});
                    	 }
                     }
                 });
            }
        }]);
    }

})
