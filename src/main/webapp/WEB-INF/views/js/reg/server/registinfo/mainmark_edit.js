require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','ztree','ztreeCheck'], function (layer, dataTable, util, http,handlebars) {

	var params = $("#hx-form").serializeObject();
	
	// 初始化标志
	var initFlag = true;
	
    var viewTemplate = handlebars.compile($('#viewTemplate').html());
    
    handlebars.registerHelper("doublyStoStateFormat",function(value,value2,value3,value4){
		 if(value){
			 if(value == "1"){
				 return value2+','+value3+','+value4;
			 }else{
				 return '无';
			 }
		 }else{
			 return '';
		 }
		
	 });
	
	handlebars.registerHelper("validDateFormat",function(value){
		 if(value && value.indexOf("2099") !=-1){
			 return "长期有效";
		 }else{
			 return value;
		 }
	 });
	
	 var ycCodeLicensetreeSetting = {
	    		check: {
					enable: true,
					chkStyle: "checkbox",
					radioType: "level"
				},
				data: {
					simpleData: {
						enable: true
					}
				},callback: {
		            onClick: function (event, treeId, treeNode) {
		                var id = treeNode.id;
		                if(id.length == 6){
		                	showView(id);
		                }else{
	                        $('#showArea').html(viewTemplate());
		                }
		               
		            }
		        }
			}; 
	 
	   init();
	 
	    function showView(idcode){
	    	http.httpRequest({
	            url: '/reg/server/registmark/queryByIDCode.json',
	            data:{idcode:idcode},
	            type: 'post',
	            success: function(data) {
	            	if (data && data.status == 'success') { 
	            		 var context = data.data;
	                     //展示权限数据
	                     $('#showArea').html(viewTemplate(context));
	                 }else{
	                 	layer.msg(data.msg, {ltype: 0,time:1000});
	                 }
	            }
	        })
	    }
	 
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    	initView();
    	$('#showArea').html(viewTemplate());
    }
    
    
    function initView(idname){
   	 	http.httpRequest({
            url: '/reg/server/mainmark/queryValidMarkByUserInfo.json',
            data:{idname:idname,priPID:$("#priPID").val()},
            type: 'post',
            success: function(data) {
            	if (data && data.status == 'success') { 
                  //初始化权限树
                   treeObj = $.fn.zTree.init($('#ycCodeLicenseTree'), ycCodeLicensetreeSetting, data.data);
                   var treeObj = $.fn.zTree.getZTreeObj("ycCodeLicenseTree");
					  //展开树
				    treeObj.expandAll(true);
                 }else{
                 	layer.msg(data.msg, {ltype: 0,time:1000});
                 }
            }
        })
   }
   
    
    function bind(){
    	util.bindEvents([
        {
    		el: '#cancel',
    		event: 'click',
    		handler: function () {
    			layer.close();
    		}
    	},{
    		el: '#save',
    		event: 'click',
    		handler: function () {
    			var markCodes = "";
    			var markNames = "";
    			var treeObj = $.fn.zTree.getZTreeObj("ycCodeLicenseTree");
				var nodes = treeObj.getCheckedNodes(true);
				if(nodes.length > 0 ){
					 for(var a=0;a<nodes.length;a++){ 
						markCodes+=nodes[a].id+",";
						markNames+=nodes[a].name+",";
					}  
					if(markCodes!=""&&markNames!=""){
						markCodes=markCodes.substr(0,markCodes.length-1);
						markNames=markNames.substr(0,markNames.length-1);
					}
					$("#markCodes").val(markCodes);
	    			$("#markNames").val(markNames);
                    layer.close({
                        names: $('#markNames').val(),
                        codes: $('#markCodes').val()
                    });
				 }else{
					layer.msg("请选择一个标签"); 
				 } 

    		}
    	},{
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	var idname=$.trim($("#idname").val());
            	initView(idname);
            }
        }])
    }
    
   
    
    

})
