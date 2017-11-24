require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 
         'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate',
         'pagination','sment-contabs'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        loadBulletins();
        loadRptOptoInfo();
        loadRptWarnInfo();
        bind();
    }

    function loadBulletins(){
        //加载存放在redis中的缓存数据
        http.httpRequest({
            type: 'post',
            url: '/reg/countlist.json',
            data: {params:{"refreshFlag":$("#refreshFlag").val()}} ,
            success: function (data) {
            	var list = data.data;
                if (data.status == 'success') {
                	//敏感词审核条数
					$("#dbgz0").text("["+list[0]+"]");
					//修改申请条数
					$("#dbgz1").text("["+list[1]+"]");
					//企业异常列入待审核+移出待审核+撤销待审核
					$("#dbgz11").text("["+list[2]+"]");
					//农专异常列入待审核+移出待审核+撤销待审核
					$("#dbgz12").text("["+list[3]+"]");
					//个体户待审核
					$("#dbgz13").text("["+list[4]+"]");
					//抽查检查
					$("#dbgz2").text("["+list[17]+"]");
					$("#dbgz3").text("["+list[18]+"]");
					$("#dbgz4").text("["+list[19]+"]");
				    //户口管理
					$("#dbgz5").text("["+list[5]+"]");
					$("#dbgz6").text("["+list[6]+"]");
					$("#dbgz7").text("["+list[7]+"]");
					//跟踪管理
					$("#dbgz8").text("["+list[11]+"]");
					$("#dbgz9").text("["+list[12]+"]");
					$("#dbgz10").text("["+list[13]+"]");
					//严重违法
					$("#dbgz14").text("["+list[14]+"]");
					$("#dbgz15").text("["+list[15]+"]");
					$("#dbgz16").text("["+list[16]+"]");
					$("#refreshFlag").val("1");
                }else{
                	//敏感词审核条数
					$("#dbgz0").text("[0]");
					//修改申请条数
					$("#dbgz1").text("[0]");
					//企业异常列入待审核+移出待审核+撤销待审核
					$("#dbgz11").text("[0]");
					//农专异常列入待审核+移出待审核+撤销待审核
					$("#dbgz12").text("[0]");
					//个体户待审核
					$("#dbgz13").text("[0]");
					//抽查检查
					$("#dbgz2").text("[0]");
					$("#dbgz3").text("[0]");
					$("#dbgz4").text("[0]");
				    //户口管理
					$("#dbgz5").text("[0]");
					$("#dbgz6").text("[0]");
					$("#dbgz7").text("[0]");
					//跟踪管理
					$("#dbgz8").text("[0]");
					$("#dbgz9").text("[0]");
					$("#dbgz10").text("[0]");
					//严重违法
					$("#dbgz14").text("[0]");
					$("#dbgz15").text("[0]");
					$("#dbgz16").text("[0]");
                } 
            }
        });
    }
    
    function loadRptOptoInfo(){
        //加载经营期限统计数据
        http.httpRequest({
            type: 'post',
            url: '/reg/server/rptOptoInfo/rptOptoInfoCount.json',
			data:{"selectCode":$("#selectCode").val()},
            success: function (data) {
            	var rptOptoInfo = data.data;
                if (data.status == 'success' && rptOptoInfo != null ) {
                	//经营期限即将到期
					$("#opCome").text("["+rptOptoInfo.willexpired+"]");
					//经营期限已经到期
					$("#opOver").text("["+rptOptoInfo.expired+"]");
                }else{
                	$("#opCome").text("[0]");
					$("#opOver").text("[0]");
                } 
            }
        });
    }
    function loadRptWarnInfo(){
    	//加载经营期限统计数据
    	http.httpRequest({
    		type: 'post',
    		url: '/reg/server/rptWarningInfo/rptWarningInfoCount.json',
			data:{"selectCode":$("#selectCode").val()},
    		success: function (data) {
    			var rptWarningInfoDto = data.data;
    			if (data.status == 'success' && rptWarningInfoDto != null ) {
    				$("#djsx1").text("["+rptWarningInfoDto.foodexpired+"]");
    				$("#djsx2").text("["+rptWarningInfoDto.drugexpired+"]");
    				$("#djsx5").text("["+rptWarningInfoDto.qualifilimit+"]");
    				$("#gsxx1").text("["+rptWarningInfoDto.reporteover+"]");
    				$("#gsxx2").text("["+rptWarningInfoDto.reporteabnormal+"]");
    				$("#rcjj3").text("["+rptWarningInfoDto.num+"]");
    				$("#sxmd1").text("["+rptWarningInfoDto.notopanomaly+"]");
    				$("#sxmd2").text("["+rptWarningInfoDto.notremove+"]");
    				$("#sxmd3").text("["+rptWarningInfoDto.notfoundalter+"]");
    				$("#sxmd4").text("["+rptWarningInfoDto.notfoundreported+"]");
    				$("#sxmd5").text("["+rptWarningInfoDto.illdisdetail+"]");
    			}else{
    				$("#djsx1").text("["+0+"]");
    				$("#djsx2").text("["+0+"]");
    				$("#djsx5").text("["+0+"]");
    				$("#gsxx1").text("["+0+"]");
    				$("#gsxx2").text("["+0+"]");
    				$("#rcjj3").text("[0]");
    				$("#sxmd1").text("["+0+"]");
    				$("#sxmd2").text("["+0+"]");
    				$("#sxmd3").text("["+0+"]");
    				$("#sxmd4").text("["+0+"]");
    				$("#sxmd5").text("["+0+"]");
    			} 
    		}
    	});
    }
    
    function bind() {
        util.bindEvents([{
            el: '#selectCode',//进入撤销申请添加list页面
            event: 'change',
            handler: function () {
            	loadRptOptoInfo();
            	loadRptWarnInfo();
            	}
        },
        {
	    	 el:'.fastLink',
	    	 event:'click',
	    	 handler:function(){
	    		 debugger
	    		 var url = $('#fastLink'+$(this).attr('data-idx')).attr("href")+"?selectCode="+$("#selectCode").val();
                 window.open(url);
	    	 }
	     }
        ]);
    }

})
