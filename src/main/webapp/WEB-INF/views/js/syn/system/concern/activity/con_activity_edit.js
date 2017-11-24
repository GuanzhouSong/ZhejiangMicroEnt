require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, dataTable, util, http) {
	
	init();
	/**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }
    
	//弹出选择框
    function selectMarkDialog() {
    	layer.dialog({
    		title: '选择服务对象',
    		area: ['700px', '480px'],
    		content: '/syn/con/csconcernactivity/selectMark',
    		callback: function(data) {
    			$("#markName").val(data.markName);
    			$("#markNo").val(data.markNo);
    		}
		});
    }
    
    function save(){
    	$.ajax({
    		type : "POST",
			url : '/syn/con/csconcernactivity/update',
			data : $('#activityForm').serialize(),
			datatype : 'JSON',
			async : true,
			success : function(json) {
				if(json.status=="success"){
					$("#save").hide();
					$("#cancel").val("返回");
					layer.msg(json.msg, {time: 1500}, function() {});
				}else
					layer.msg(json.msg, {time: 5000}, function() {});
			}
    	});
    }
    
    function selectLauDept(){
        layer.dialog({
        	title: '选择开展部门',
            area: ['400px', '600px'],
            content: '/syn/system/sysdepart/alldeptcheckboxtreeselect',
            callback: function (data) {
                if(data.orgCodesExcParent!=undefined&&data.orgNamesExcParent!=undefined){
                    $("#lauDeptName").val(data.orgNamesExcParent);
                    $("#lauDeptCode").val(data.orgCodesExcParent);
                }
            }
        })
    }
    
    function bind() {
        util.bindEvents([{
            el: '#selectmark',
            event: 'click',
            handler: function() {
            	selectMarkDialog();
            }
        },{
            el: '#save',
            event: 'click',
            handler: function() {
            	save();
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function() {
            	window.location.href='/syn/con/csconcernactivity/list';
            }
        }, {
            el: '#selectLauDept',
            event: 'click',
            handler: function () {
            	selectLauDept();
            }
        },{
            el: '#print',
            event: 'click',
            handler: function() {
            	window.open("/syn/con/csconcernactivity/show?deal=2&id="+$("#id").val());
            }
        }])
    }
    
});