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
    	var excpStaRes = $("#excpStaRes2").val();
    	//标记原因
        var indiInReaCodeList = [
                             	{id: "1", text: "个体工商户年度报告隐瞒真实情况、弄虚作假的"},
                             	{id: "2", text: "通过登记的经营场所或者经营者住所无法与个体工商户取得联系的"},
                             	{id: "3", text: "未按照规定报送年度报告的"}
         ];
        $(function() {
            $.each(indiInReaCodeList, function(i, n) {
            	if(n.id != 3) {
            		$("#excpStaRes").append("<option value='" + n.id + "'>" + n.text + "</option>");
            	}
            });
        });
        
        setTimeout(function(){
        	$("#excpStaRes").val(excpStaRes);}
        ,0); 
    }
    
    
    var searchParams={};//查询参数声明!
    function bind() {
    	 util.bindEvents([{
             el: '#saveBtn',
             event: 'click',
             handler: function () {
            	 if ($("#excpStaRes").val() == "") {
                    layer.msg("请选择标记异常原因");
                     return false;
                 }  
            	 if ($.trim($("#signRea").val()) == "") {
                    layer.msg("请输入事实和理由");
                     return false;
                 } 
            	 if ($("#signRea").val().length >500) {
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
                 
            	 $("#excpStaResCN").val($("#excpStaRes").find("option:selected").text());
            	 searchParams = $("#pbosaveform").serializeObject();
            	  http.httpRequest({
                      url: '/reg/server/opanomaly/pbopanomaly/saveEditPbopanomaly',
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
             el: '.toDetail',
             event: 'click',
             handler: function () {
            	 var busExcList = $(this).attr("value");
            	 layer.dialog({
                     title: '异常标记详情',
                     area: ['1024px', '400px'],
                     content: '/reg/server/opanomaly/pbopanomaly/toDetail?busExcList='+busExcList,
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
