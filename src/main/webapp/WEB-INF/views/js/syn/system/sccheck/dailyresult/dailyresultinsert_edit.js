require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	var entName = $("#entName").val();
            	var checkObjType = $('input:radio[name="checkObjType"]:checked').val();
            	if(entName){
            		layer.dialog({
            			title: '检查对象录入',
            			area: ['95%', '95%'],
            			content: '/reg/dailycheck/dailyinspectresult/insertcheckobj?entName='+entName+"&checkObjType="+checkObjType+"&flag=1",
            			callback: function (data) { 
            				layer.close({reload: true});
            			}
            		})
            	}else{
            		layer.msg("被检查对象是必填项", {time: 2000}, function() {});
            	}
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        },{
            el: '#ent',
            event: 'click',
            handler: function () {
            	$("#entName").val("");
            	$("#entName").attr("readonly",true);
            	$("#queryselect").attr("disabled",false);
            }
        },{
            el: '#notlic',
            event: 'click',
            handler: function () {
            	$("#entName").attr("readonly",false);
            	$("#queryselect").attr("disabled",true);
            }
        },{
            el: '#notent',
            event: 'click',
            handler: function () {
            	$("#entName").attr("readonly",false);
            	$("#queryselect").attr("disabled",true);
            }
        },{
            el: '#queryselect',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '检查对象选入',
                    area: ['40%', '70%'],
                    content: '/reg/dailycheck/dailyinspectresult/selectcheckobj?flag=2',
                    callback: function (data) { 
                    	layer.close({reload: true});
                    }
                })
            }
        }]);
    }
});
