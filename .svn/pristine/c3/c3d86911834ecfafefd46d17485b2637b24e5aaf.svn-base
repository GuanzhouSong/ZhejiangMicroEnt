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
    	//恢复正常记载原因
    	var indiOutReaCodeList = [
    		{id: "1", text: "依照《个体工商户年度报告办法》第十四条规定被标记为经营异常状态的个体工商户，向工商行政管理部门报送更正后的纸质年度报告并申请恢复正常记载状态"},
    		{id: "2", text: "依照《个体工商户年度报告办法》第十五条规定被标记为经营异常状态的个体工商户，依法办理经营场所、经营者住所变更登记，申请恢复正常记载状态"},
    		{id: "4", text: "依照《个体工商户年度报告暂行办法》第十五条规定被标记为经营异常状态的个体工商户，提出通过登记的经营场所或者经营者住所可以重新取得联系，申请恢复正常记载状态"}
    	];
        $(function() {
            $.each(indiOutReaCodeList, function(i, n) {
        		$("#norRea").append("<option value='" + n.id + "'>" + n.text + "</option>");
            });
        });
        
    }
    
    var searchParams={};//查询参数声明!
    function bind() {
    	 util.bindEvents([{
             el: '#save',
             event: 'click',
             handler: function () {
            	 var recoveryType = $('input:radio[name="recoveryType"]:checked').val();
            	 if(recoveryType=='1'){
            		 if ($("#norRea").val() == "") {
            			 layer.msg("请选择恢复原因");
            			 return false;
            		 }  
            	 }
            	 if ($.trim($("#recoverRea").val()) == "") {
                    layer.msg("请输入事实和理由");
                     return false;
                 } 
            	 if ($("#recoverRea").val().length >500) {
                    layer.msg("事实和理由长度不能超过500字");
                     return false;
                 }
            	 if ($.trim($("#firstOpin").val()) == "") {
                     layer.msg("请输入初审意见");
                      return false;
                  } 
             	 if ($("#firstOpin").val().length >500) {
                     layer.msg("初审意见长度不能超过500字");
                      return false;
                 }
                 if ($("#norDate").val() == "") {
                     layer.msg("请填写做出决定日期");
                      return false;
                  } 
                 
                 if($("#norRea").find("option:selected").text()!='请选择'){
                	 $("#norReaCN").val($("#norRea").find("option:selected").text());
                 }
            	 searchParams = $("#pbosaveform").serializeObject();
            	  http.httpRequest({
                      url: '/reg/server/opanomaly/pbopadetail/savePbOpadetail',
                      type: 'post',
                      data: searchParams,
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
         },
         {
             el: '#move',
             event: 'click',
             handler: function () {
         		$("#td-remExcpres").show();
         		$("#norRea").val('');
         		$("#norReaCN").val('');
             }
         },
         {
         	el: '#notMove',//更正撤销
         	event: 'click',
         	handler: function () {
         		$("#td-remExcpres").hide();
         		$("#norRea").val('');
         		$("#norReaCN").val('');
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
