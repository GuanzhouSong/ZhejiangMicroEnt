require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {
	var _urlHead = window._CONFIG._urlHead;
	var _urlEnd;
	init();
	
	function init(){
		bind();
		formValid();
	}
	
	 function formValid(){
		 $("#sendSearchForm").validate({
			 rules:{
				 
			 },
			 messages: {},
			 onkeyup:false,
			 submitHandler: function () {
             	var formParam = $('#sendSearchForm').serializeObject();
                 http.httpRequest({
                     url: _urlHead+_urlEnd,
                     serializable: true,
                     data: formParam,
                     type: 'post',
                     success: function (json) {
                     	if(json.status=="success"){
     						layer.msg(json.msg, {time: 800}, function() {
     							layer.close({reload: true});
     						});
     					}else{
     						$("#save").attr("disabled",false);
     						layer.msg(json.msg, {time: 800}, function() {});
     					}
                     }
                 });
         }
		 })
	 }
	function bind(){
		util.bindEvents([
		{
            el: '#save',
            event: 'click',
            handler: function() {
            	_urlEnd = "save";
            	$("#sendSearchForm").submit();
            }
        },
        {
            el: '#codetree',
            event: 'click',
            handler: function() {
            	selectDepartTree();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
        },
        {
            el: '#edit',
            event: 'click',
            handler: function() {
            	_urlEnd = "edit";
            	$("#sendSearchForm").submit();
            }
        }
		])
	}
	
	//部门树
    function selectDepartTree(){
     layer.dialog({
         title: '抄告接收部门',
         area: ['400px', '600px'],
         content: '/common/system/sysdepart/alldeptradiotreeselect',
         callback: function (data) {
         	var orgName = data.orgName;
         	var adCode = data.adCode;
                 $("#departName").val(orgName);
                 $("#departCode").val(adCode);
                 $("#unitLevel").val(adCode);
         }
     })
    }
})