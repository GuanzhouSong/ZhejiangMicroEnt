require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate'], function (layer, util, http) {


    init();
     
    /**
     * 初始化函数集合
     */
    function init() { 
         bind();
       }

    

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: "#printpubopadetailbook", //打印异常移出/撤销决定书
            event: 'click',
            handler: function () { 
            	var _pubOpaDetail_busExcList=window._CONFIG._pubOpaDetail_busExcList;
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = window._CONFIG.chooseUrl+"/server/opadetail/pubopadetail/opadetailBookPrint?busExcList="+_pubOpaDetail_busExcList;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },{
            el: "#printpubopanomalyentbook",//打印列入异常决定书
            event: 'click',
            handler: function () {
             	  var _pubOpanoMaly_busExcList=window._CONFIG._pubOpanoMaly_busExcList; 
             	  var _id = "_doPrint_"+new Date().getTime();
                  var url = window._CONFIG.chooseUrl+"/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+_pubOpanoMaly_busExcList;
                  try{
                      window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                  }catch(e){
                      alert("打印错误!");
                  }
            }
        }
        ]);
    } 
})
