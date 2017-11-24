require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','jquery.formautofill'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	initData();
        bind();
    }
    
    
    /**
     * 初始化数据
     * @returns
     */
    function initData(){
    	debugger;
    	var helpData = sessionStorage.getItem("helpData");
    	if(helpData){
    		helpData = JSON.parse(helpData);
    		var options = {
    				findbyname: false
    		}
    		$("#webForm").autofill( helpData, options );
    		sessionStorage.removeItem("helpData");
    	}
    }
    
    function showHelpTypeTree(){
    	layer.dialog({
            title: '选择企业需求类别',
            area: ['400px', '600px'],
            content: '/sment/entarchives/toEntarchivesHelpTypeTree',
            callback: function (data) {
            	debugger;
            	$("#helpTypeCode").val('');
            	$("#helpTypeName").val('');
            	$("#helpTypeCode").val(data.returncodes);
            	$("#helpTypeName").val(data.returnname);
            }
        })
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
    			if(!docheck())return;
    			var returnData= $('#webForm').serializeObject();
				layer.close(returnData);
    		}
    	},{
        	el:'#a_entarchivesHelpList',
        	event:'click',
        	handler:function(){showHelpTypeTree()}
        }
    	
    	]);
    }
    function docheck(){
    	if($.trim($("#helpTypeName").val())==""){
    		layer.msg("需求类型未选择",{time:1000},function(){
    		});
    		return false;
    	}
    	/*if($.trim($("#helpText").val())==""){
    		layer.msg("需求内容不能为空",{time:1000},function(){
    			$("#helpText").focus()
    		});
    		return false;
    	}
    	if($.trim($("#helpTime").val())==""){
    		layer.msg("帮扶时间未选择",{time:1000},function(){
    		})
    		return false;
    	}
    	if($.trim($("#helpContent").val())==""){
    		layer.msg("服务内容不能为空",{time:1000},function(){
    			$("#helpContent").focus()
    		});
    		return false;
    	}*/
    	return true;
    }
})
