require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initexcpStaRes();
    	bind();
     }
  
    function initexcpStaRes(){
    	var norRea = $("#norRea2").val();
    	//恢复原因
    	var indiOutReaCodeList = [
    		{id: "1", text: "依照《个体工商户年度报告办法》第十四条规定被标记为经营异常状态的个体工商户，向工商行政管理部门报送更正后的纸质年度报告并申请恢复正常记载状态"},
    		{id: "2", text: "依照《个体工商户年度报告办法》第十五条规定被标记为经营异常状态的个体工商户，依法办理经营场所、经营者住所变更登记，申请恢复正常记载状态"}
    	];
        $(function() {
            $.each(indiOutReaCodeList, function(i, n) {
        		$("#norRea").append("<option value='" + n.id + "'>" + n.text + "</option>");
            });
        });
        
        setTimeout(function(){
        	$("#norRea").val(norRea);}
        ,0); 
    }
    
    
    var searchParams={};//查询参数声明!
    function bind() {
    	 util.bindEvents([{
             el: '#saveBtn',
             event: 'click',
             handler: function () {
                var auditState = $('input:radio[name="auditState"]:checked').val();
            	var auditOpin = $.trim($("#auditOpin").val());
             	if(auditOpin==""||auditState==undefined){
             		layer.msg("审核意见为必填项!", {ltype: 0,time:2000});
             	}else if(auditOpin.length>500){
             		layer.msg("审核意见不多于500字!", {ltype: 0,time:2000});
             	}else{
             		var formParam=$('#pubauditosaveform').serializeObject();
 	               	http.httpRequest({
                         url: '/reg/server/opanomaly/pbopadetail/doCheckOpadetail',
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
         },{
             el: '#yes',
             event: 'click',
             handler: function () {
                  $("#auditOpin").val("予以恢复正常"); 
                 
             }
         },{
             el: '#no',
             event: 'click',
             handler: function () {
             	 $("#auditOpin").val("不予恢复正常");
             }
         },{
             el: '#yes2',
             event: 'click',
             handler: function () {
                  $("#auditOpin").val("予以更正恢复"); 
                 
             }
         },{
             el: '#no2',
             event: 'click',
             handler: function () {
             	 $("#auditOpin").val("不予更正恢复");
             }
         },
    	 {
             el: '.toDetail',
             event: 'click',
             handler: function () {
            	 var busExcList = $(this).attr("value");
            	 layer.dialog({
                     title: '异常标记详情',
                     area: ['1024px', '400px'],
                     content: '/reg/server/opanomaly/pbopanomaly/toDetail?busExcList='+busExcList+'&priPID='+$("#priPID").val(),
                     callback: function(data){
                   	  
                     }
                 });
             }
         },
    	 {
             el: '#cancel',
             event: 'click',
             handler: function () {
            	  layer.close();
             }
         }]);
    }

});
