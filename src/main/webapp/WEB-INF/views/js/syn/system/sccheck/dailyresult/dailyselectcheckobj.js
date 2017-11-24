require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http','handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        selectEnt();
        bind();
    }

    function selectEnt() {
    	var searchKeyWord = $.trim($("#searchKeyWord").val());
    	$("#content li").remove();
    	if(searchKeyWord!=""){
    		searchKeyWord = encodeURI(encodeURI(searchKeyWord));
    	}
        http.httpRequest({
            url: '/reg/dailycheck/dailyinspectresult/selectcheckobjjson?searchKeyWord='+searchKeyWord,
            success: function (data) {
            	var data = data.data;
            	$("#content li").remove();
            	for(var i=0;i<data.length;i++){
            		var dailyinspectresult = data[i];
            		var unicode = dailyinspectresult.UNICODE;
            		var regNO = dailyinspectresult.regNO;
            		var priPID = dailyinspectresult.priPID;
            		var unireg = "";
            		if(unicode){
            			unireg = unicode;
            		}else{
            			unireg = regNO;
            		}
            		$("#content").append("<li><input name='ent' type='radio' value='"+priPID+"'> <span>"+dailyinspectresult.entName+" "+unireg+"</span></li>");
            	}
            }
        });
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        }, {
            el: '#save',
            event: 'click',
            handler: function () {
            	var priPID = $("input[name='ent']:checked").val();
            	if(priPID){
            		layer.dialog({
            			title: '检查对象录入',
            			area: ['95%', '95%'],
            			content: "/reg/dailycheck/dailyinspectresult/insertcheckobj?checkObjType=1&priPID="+priPID+"&flag=2",
            			callback: function (data) { 
        					layer.close({reload: true});
            			}
            		})
            	}else{
            		layer.msg("检查对象不能为空", {time: 2000}, function() {});
            	}
            }
        },{
             el: '#box-searcher',
             event: 'click',
             handler: function () {
            	selectEnt();
             }
           }
        ])
    }
})