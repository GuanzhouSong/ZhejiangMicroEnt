require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
    
    
    //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿) 
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
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
            el: '#printbook',//打印决定书
            event: 'click',
            handler: function () {
            	var initBatchNum = $(this).attr("initBatchNum");
            	var penDecNo = $(this).attr("penDecNo");
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = "/reg/server/opanomaly/pubopanomaly/printBatchBook?penDecNo="+penDecNo+"&initBatchNum="+initBatchNum;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },
        {
            el: '#savepubOpanoBtn',
            event: 'click',
            handler: function () {
//       	        var pripid = parent.$("#itemIds").val();
//       	        console.log(pripid);
//       	        $("#priPID").val(pripid);
//            	debugger
            	var deptName=$("#deptName").val();
            	var deptUpName=$("#deptUpName").val();
            	var deptSameCourt=$("#deptSameCourt").val();
            	var deptSameGov=$("#deptSameGov").val();
            	var anomalyRea=$.trim($("#anomalyRea").val());
            	var abnTime=$("#abnTime").val();
            	var seqyear = 0;
            	seqyear = parseInt($('#year').val())+1;
            	if(anomalyRea == null || anomalyRea == ""){
            		layer.msg("请输入事实和理由", {ltype: 0,time:2000});
                    return false;
            	}
            	if(abnTime==null||abnTime==""){
            		layer.msg("请选择作出决定日期", {ltype: 0,time:2000});
                    return false;
            	 } 
//            	 if(new Date(abnTime.replace(/-/g, "/")) < new Date(seqyear.toString()+'-07-01'.replace(/-/g, "/"))){
//            		 layer.msg("作出决定日期不能早于当前年报年度第二年的7月1号", {ltype: 0,time:2000});
//            		 return false;
//            	 } 
            	
            	 if (new Date(abnTime.replace(/-/g, "/")) > new Date($("#auditDate").val().replace(/-/g, "/"))) {
	                 layer.msg("作出决定日期不能晚于审核日期", {ltype: 0,time:2000});
	                 return false;
	             }
            	if(anomalyRea.length>500){
            		layer.msg("事实和理由不能超过500字", {ltype: 0,time:2000});
                    return false;
            	}
            	if(deptName == null || deptName == "" || deptUpName == null || deptUpName == "" || deptSameCourt == null || deptSameCourt == "" || deptSameGov == null || deptSameGov == "" ){
            		layer.msg("请先完善配置您部门的部门名称、部门简称、上级机关名称、同级人民政府、同级人民法院", {ltype: 0,time:2000});
                    return false;
            	}
            	 var type = window._CONFIG._type;
            	 
            	if(type != 'all'){
                 	var itemIds = window.localStorage? localStorage.getItem("itemIds"):"";	
                	if(itemIds == null || itemIds == ""){
                		layer.msg("请使用ie8及其以上版本浏览器或其他主流浏览器重新登录", {ltype: 0,time:2000});
                		return false;
                	}
       	            $("#priPID").val(itemIds);
            	}
       		    var formParam=$('#pubauditosaveform').serializeObject();
            	 if(type == 'all'){//全部列入
                	 http.httpRequest({
                         url: '/reg/server/opanomaly/pubopanomaly/batchInAddAllCommit',
                         serializable: false,
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
            	 }else{
            		 delete formParam.estDateStart;
            		 delete formParam.estDateEnd;
            		 delete formParam.isIndivid;
                	 http.httpRequest({
                         url: '/reg/server/opanomaly/pubopanomaly/batchInAddCommit',
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
