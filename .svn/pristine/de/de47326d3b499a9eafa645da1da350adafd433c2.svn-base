require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    laydate.skin('molv');//初始化皮肤 (墨绿)

    
  	//列入原因
	
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
        initdecisionBookInfo();
        } 
    
    function initdecisionBookInfo(){
    	$(".dept").html(window._CONFIG._deptName);    	
		//设置文号 
		$(".docNo").html(window._CONFIG.docNo);
		//设置日期 
		$(".date").html(window._CONFIG.remDate);
    	
    	//审核移出原因code
    	var remExcpres = window._CONFIG._remExcpres;
    	//获取企业类型
    	var entCatg = window._CONFIG._entTypeCatg;
    	//此处的数据字典根据决定书的数据完成
    	var remExcpresList = [
                        	{id: "1", text: "列入经营异常名录3年内且已补报未报年份的年度报告并公示",sfctext:"列入经营异常名录3年内且已补报未报年度的年度报告并公示"},
                        	{id: "2", text: "列入经营异常名录3年内且已履行公示义务",sfctext:""},
                        	{id: "3", text: "列入经营异常名录3年内且已更正其公示的信息",sfctext:"列入经营异常名录3年内且已更正其公示的年度报告信息"},
                        	{id: "4", text: "列入经营异常名录3年内且已依法办理住所或者经营场所变更登记",sfctext:"列入经营异常名录3年内且已依法办理住所变更登记"},
                        	{id: "5", text: "列入经营异常名录3年内且通过登记的住所或者经营场所可以重新取得联系",sfctext:"列入经营异常名录3年内且通过登记的住所可以重新取得联系"}
                        ];
    		//企业判断
    		if(entCatg != "16" && entCatg != "17"){
//     			$("#entDate").hide();
//         		$("#entDocNo").hide();
    			$.each(remExcpresList, function(i,n){
    				if(remExcpres == n.id){
    					if(remExcpres == "1"){
        					$("#entReaCode").text("列入经营异常名录3年内且已补报未报年度（"+window._CONFIG.abnYear+"年度）的年度报告并公示");
    					}else{
        					$("#entReaCode").text(n.text);
    					}
    				}
    			});
    			if(remExcpres == "1"){
    				$("#entReaNo").text("十一");
    			}else if(remExcpres == "2"){
    				$("#entReaNo").text("十二");
    			}else if(remExcpres == "3"){
    				$("#entReaNo").text("十三");
    			}else if(remExcpres == "4"){
    				$("#entReaNo").text("十四");
    			}else if(remExcpres == "5"){
    				$("#entReaNo").text("十四");
    			}
    		}
    		//农专社判断
    		if(entCatg == "16" || entCatg == "17"){
//     			$("#farmDate").hide();
//         		$("#farmDocNo").hide();
    			$.each(remExcpresList, function(i,n){
    				if(remExcpres == n.id){
    					if(remExcpres == "1"){
        					$("#farmReaCode").text("列入经营异常名录3年内且已补报未报年度（"+window._CONFIG.abnYear+"年度）的年度报告并公示");
    					}else{
        					$("#farmReaCode").text(n.sfctext);
    					}	
    				}
    			});
    			if(remExcpres == "1"){
    				$("#farmReaNo").text("十三");
    			}else if(remExcpres == "3"){
    				$("#farmReaNo").text("十四");
    			}else if(remExcpres == "4"){
    				$("#farmReaNo").text("十五");
    			}else if(remExcpres == "5"){
    				$("#farmReaNo").text("十五");
    			}
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
            el: '#save',
            event: 'click',
            handler: function () {
            	var formParam=$('#decisionbookform').serializeObject();
            	 http.httpRequest({
                     url: '/reg/server/opadetail/pubopadetail/descbookCommit',
                     serializable: false,
                     data:formParam,
                     type: 'post',
                     success: function (data) { 
                    	 if(data.status=="success"){
                    		 layer.msg("决定书保存成功", {time: 1000}, function () {
   								layer.close({reload: true});
                      		 }); 
                    	 }else{
                    		 layer.msg("决定书保存失败", {ltype: 0,time:500});
                    	 }
                     }
                 });
            }
        }]);
    }

})
