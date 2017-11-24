require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect','jquery.formautofill','ystep'], function (layer, dataTable, util, http,handlebars) {
	//获取url中的参数
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r != null) return unescape(r[2]); return null; //返回参数值
	} 
	var sendDate = getUrlParam("sendDate"); 
	
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
    	$(".span_sendDate").text(sendDate.substring(0,4)+"年"+sendDate.substring(4,6)+"月"+sendDate.substring(6,8)+"日");
    } 
})
