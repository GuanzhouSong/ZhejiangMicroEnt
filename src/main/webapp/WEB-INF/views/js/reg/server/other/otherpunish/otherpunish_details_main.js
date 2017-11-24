require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.validate', 'jquery.serialize'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
    	var viewType = $("#viewType").val();
    	$("."+viewType).show();
    	
    	//初始处罚类型
    	var penType = $("#penType").val();
    	$("#penTypeShow").text(switchPunishInfoForm(penType));
    	
    	//事件绑定
        bind();
    }
    
    function switchPunishInfoForm(val){
    	if(val != ""){
    		var punishForm = [];
    		var tempVal = "";
    		punishForm = val.split(",");
    		for(var i=0;i<=punishForm.length;i++){
    			for(var j in punishTypeList){
    	    		if (punishTypeList[j].id == punishForm[i]) {
    	    			if(punishForm[i] == '2'){
    	    				$(".penAm").show();//显示罚款金额
    	    			}
    	    			if(punishForm[i] == '3'){
    	    				$(".forfAm").show();//显示没收金额
    	    			}
    	    			tempVal += punishTypeList[j].text +"，";
    	    			}
    				};
    			}
    		val = tempVal.substring(0,tempVal.length-1);
    	}
       return val;
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }])
    }

});

//处罚类型
var punishTypeList=[
{id: "1", text: "警告"},
{id: "2", text: "罚款"},
{id: "3", text: "没收违法所得和非法财物"},
{id: "4", text: "责令停产停业"},
{id: "5", text: "暂扣许可证"},
{id: "6", text: "暂扣执照(登记证)"},
{id: "7", text: "吊销许可证"},
{id: "8", text: "吊销执照(登记证)"},
{id: "9", text: "法律、法规规定的其他行政处罚方式"}
];



