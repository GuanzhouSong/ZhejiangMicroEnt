require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','jquery.formautofill','ystep'], function (layer, dataTable, util, http,handlebars) {
	//获取url中的参数
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r != null) return unescape(r[2]); return null; //返回参数值
	}
	
	var year = getUrlParam("year");
	var sendDate = getUrlParam("sendDate");
	var isreported = getUrlParam("isreported");
	var msgSource = getUrlParam("msgSource");
	var msgReadTel = getUrlParam("msgReadTel");
	
	init();
	
    /**	
     * 初始化函数集合
     */
    function init() {
    	initData();
    }
    
    
    /**
     * 初始化数据
     * @returns
     */
    function initData(){
    	$(".span_year").text(year);
    	$(".span_nowyear").text(parseInt(year)+1);
    	$(".span_sendDate").text(sendDate.substring(0,4)+"年"+sendDate.substring(4,6)+"月"+sendDate.substring(6,8)+"日");
    	if(msgSource && msgSource == "wx"){//如果是微信访问,则不分页，显示全部关联企业信息
    		$("#tab_wx").show();
    		queryMessagListByMsgUid();
    	}else{
    		$("#div_pageTable").show();
    		initDataTable();
    	}
    	
    }

    function queryMessagListByMsgUid(){
    	http.httpRequest({
            url: '/reg/message/queryEntNameList.json',
            data:{"year":year,"isreported":isreported,"tel":msgReadTel},
            type: 'post',
            success: function(data) {
            	if(data && data.status == "success"){
            		$(".listCount").text(data.data.length);
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
    
    function initDataTable() {
        dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#permit-table',
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                type: "POST",
                url: '/reg/message/queryEntNamePageList.json',
                data: function(d) {
                        d.params =  $.extend({}, $("#taskForm").serializeObject(), {"year":year,"isreported":isreported,"tel":msgReadTel});
                    }
            },
            columns : [
                {data: '_idx', className: 'center'},
                {data: 'entname', className: 'center'}
    		],
            "initComplete":function (settings, json){
            	$(".listCount").text(json.recordsTotal);
            }
        })
    }
    
})
