require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','jquery.formautofill','ystep'], function (layer, dataTable, util, http,handlebars) {
	//获取url中的参数
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r != null) return unescape(r[2]); return null; //返回参数值
	}
	
	var msgUid = getUrlParam("msgUid");
	var msgSource = getUrlParam("msgSource");
	var msgReadId = getUrlParam("msgReadId");
	var msgReadName =getUrlParam("msgReadName");
	var msgReadTel = getUrlParam("msgReadTel");
	
	init();
	
    /**	
     * 初始化函数集合
     */
    function init() {
    	initData();
        bind();
    }
    
    function autofillForSpan(data){
    	$.each( data, function(k, v) {
			$("span[id='"+k+"']").html(v ?v:"");
		});
    	
    }

    
    
    /**
     * 初始化数据
     * @returns
     */
    function initData(){
    	
    	
    	getView(msgUid);
    	
    	if(msgSource && msgSource == "wx"){//如果是微信访问,则不分页，显示全部关联企业信息
    		$("#tab_wx").show();
    		queryMessagListByMsgUid(msgUid);
    		updateMessageByMsgUid(msgUid);
    	}else{
    		$("#div_export").show();
    		$("#div_pageTable").show();
    		initDataTable(msgUid);
    	}
    	
    }
    
    function updateMessageByMsgUid(msgUid){
    	$.ajax({
            url: '/reg/message/updateMessageByMsgUid.json',
            data:{msgUid:msgUid,msgPcReadId:msgReadId,msgPcReadName:msgReadName,msgPcReadTel:msgReadTel},
            cache:false,
            type: 'post',
            success: function(data) {
            	autofillForSpan(data.data);
            }
        })
    }
    
    function getView(msgUid){
    	http.httpRequest({
            url: '/reg/message/querycsMessageByMsgUid.json',
            data:{msgUid:msgUid},
            type: 'post',
            success: function(data) {
            	autofillForSpan(data.data);
            }
        })
    }
    
    function queryMessagListByMsgUid(msgUid){
    	http.httpRequest({
            url: '/reg/message/queryMessagListByMsgUid.json',
            data:{msgUid:msgUid},
            type: 'post',
            success: function(data) {
            	if(data && data.status == "success"){
            		var tpl_entListHtml = $("#tpl_entList").html();
            	    var tpl_entList = handlebars.compile(tpl_entListHtml);
            	    handlebars.registerHelper("tableNum",function(index,options){
            	    	return (parseInt(index)+1) ;
            		});
            		$('#tbody_entList').html(tpl_entList(data.data));
            	}
            }
        })
    }
    
    function initDataTable(msgUid) {
        dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#permit-table',
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                type: "POST",
                url: '/reg/message/queryMessagPageListByMsgUid.json',
                data: function(d) {
                        d.params =  $.extend({}, $("#taskForm").serializeObject(), {"msgUid":msgUid});
                    }
            },
            columns : [
                {data: '_idx', className: 'center'},
                {data: 'entName', className: 'center'}
    		]
        })
    }
    
    function bind() {
    	util.bindEvents([
    		{
                el: '#btn_excelExport',
                event: 'click',
                handler: function () {
                  $("#msgUid").val(msgUid);
                  $("#excelExportForm").attr("action","/reg/message/excelExportByMsgUid");
                  $("#excelExportForm")[0].submit();
                }
           }
    	]);
    }
    
})
