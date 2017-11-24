require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
    	
        bind();
        var  _licZone=window._CONFIG._licZone;
     	var  _licZoneArr=_licZone.split(",");
     	var licZone="";
 		$.each(_licZoneArr, function(a,b) { 
			 if(_licZoneArr[a]=="0"){
				 licZone+="国家级"+",";
			 }else if(_licZoneArr[a]=="1"){
				 licZone+="省级"+",";
			 }else if(_licZoneArr[a]=="2"){
				 licZone+="市级"+",";
			 }else if(_licZoneArr[a]=="3"){
				 licZone+="县级"+",";
			 } 
			 if(a==_licZoneArr.length-1){
				 licZone=licZone.substring(0,licZone.length-1);
			 }
	    }); 
 		$("#licZoneTem").text(licZone);
      } 

    function bind() {
        util.bindEvents([
        {
            el: '#cancelcodelicense',
            event: 'click',
            handler: function () {
                layer.close();
            }
        } 
        ])
    }

})
