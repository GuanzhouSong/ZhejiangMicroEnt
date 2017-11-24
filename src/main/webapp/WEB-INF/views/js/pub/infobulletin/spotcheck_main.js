require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	//初始化展示
    	if($("#pubType").val() == '6'){
    		loadListData(0,10)
    	}else{
    		loadListDataForCheck(0,10)
    	}
    	bind();
    }

	
	 function loadListData(page, length,callback) {
		    var uid = $("#uid").val(); 
	    	var params = {uid:uid};
	        http.httpRequest({
	            url: '/pub/infobulletin/spotcheck',
	            data: {start: page*length,length: length,params:params},
	            type: 'post',
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	                $('.pagination').pagination(itemCount, {
	                    prev_text: '<i class="icon-triangle-left"></i>上一页',
	                    next_text: '下一页<i class="icon-triangle-right"></i>',
	                    num_display_entries: 3,
	                    num_edge_entries: 2,
	                    current_page: page,
	                    items_per_page:10,
	                    link_to: 'javascript:void(0)',
	                    ellipse_text: '...',
	                    first_text: '首页',
	                    last_text: '末页',
	                    callback:function(page,jq){
	                    	loadListData(page,10);
	                    }
	                });
	                var handleHelper = handlebars.registerHelper("xh",
	                		function(index) {return index+1+(page*10);
	                });
	                var dataList = data.data;
	                for(var i=0;i < dataList.length;i++){
	                	var scResult = dataList[i].scResult;
	                	var scType = dataList[i].scType;
	                	dataList[i].scResult= switchScResult(scResult,scType);
	                	if(dataList[i].inspectDate !=null && dataList[i].inspectDate !='undefined'){
	                		dataList[i].inspectDate = dataList[i].inspectDate.split(' ')[0];
	                	}
	                }
	                var myTemplate = handlebars.compile($("#noticelist").html());
	                $('#pageList').html(myTemplate(data));
	                $("#info_total").text(itemCount);
	                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
	                $("#info_pageNum").text(pageNum);
	            }
	        });
	    }
	 
	 function loadListDataForCheck(page, length,callback) {
		    var uid = $("#uid").val(); 
	    	var params = {uid:uid};
	        http.httpRequest({
	            url: '/pub/infobulletin/scentCheck',
	            data: {start: page*length,length: length,params:params},
	            type: 'post',
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	                $('.pagination').pagination(itemCount, {
	                    prev_text: '<i class="icon-triangle-left"></i>上一页',
	                    next_text: '下一页<i class="icon-triangle-right"></i>',
	                    num_display_entries: 3,
	                    num_edge_entries: 2,
	                    current_page: page,
	                    items_per_page:10,
	                    link_to: 'javascript:void(0)',
	                    ellipse_text: '...',
	                    first_text: '首页',
	                    last_text: '末页',
	                    callback:function(page,jq){
	                    	loadListData(page,10);
	                    }
	                });
	                var handleHelper = handlebars.registerHelper("xh",
	                		function(index) {return index+1+(page*10);
	                });
	                var myTemplate = handlebars.compile($("#noticelist").html());
	                $('#pageList').html(myTemplate(data));
	                $("#info_total").text(itemCount);
	                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
	                $("#info_pageNum").text(pageNum);
	            }
	        });
	    }
	 
	 function switchScResult(val,scType){
		 if(val != "" && val != null){
	    		var scResultArry = [];
	    		var resultInfoList;
	    		var tempVal = "";
	    		if(scType == 1){
	    			resultInfoList = scResultList;
	    		}else{
	    			resultInfoList = scNewResultList;
	    		}
	    		scResultArry = val.split(",");
	    		for(var i=0;i<=scResultArry.length;i++){
	    			for(var j in resultInfoList){
	    	    		if (resultInfoList[j].id == scResultArry[i]) {
	    	    			tempVal += resultInfoList[j].text +"，";
	    	    			}
	    				};
	    			}
	    		val = tempVal.substring(0,tempVal.length-1);
	    	}
	       return val;
	 }
	 
	 function bind(){
		 
	 }
})

  var scResultList = [
		{id: "1", text: "正常（符合信息公示相关规定）"},
		{id: "2", text: "未按规定公示即时信息"},
		{id: "3", text: "未按规定公示年报信息"},
		{id: "4", text: "通过登记的住所（经营场所）无法联系"},
		{id: "5", text: "公示信息隐瞒真实情况、弄虚作假"},
		{id: "6", text: "不予配合情节严重"},
		{id: "7", text: "已办理营业执照注销"},
		{id: "8", text: "被吊销营业执照"},
		{id: "9", text: "被撤销登记"}
     ];

var scNewResultList = [
        {id: "1", text: "未发现问题"},
        {id: "2", text: ""},
        {id: "3", text: "违反食品药品管理相关规定"},
        {id: "4", text: "违反质量技术监督相关规定"},
        {id: "5", text: "违反其他部门相关规定"},
        {id: "6", text: "通过登记的住所（经营场所）无法联系"},
        {id: "7", text: "已关闭停业或正在组织清算"},
        {id: "8", text: "不配合检查情节严重"},
        {id: "9", text: "注销"},
        {id: "10", text: "被吊销"},
        {id: "11", text: "被撤销"},
        {id: "12", text: "迁出"},
        {id: "B", text: "未按规定公示应当公示的信息"},
        {id: "C", text: "公示信息隐瞒真实情况弄虚作假"},
        {id: "D", text: "违反其他工商行政管理规定行为"},
        {id: "E", text: "发现问题经责令已改正"},
        {id: "F", text: "未发现开展本次抽查涉及的经营活动"},
        {id: "G", text: "违反公安部门相关规定"}
     ];
