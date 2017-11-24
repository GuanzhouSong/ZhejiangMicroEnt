require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	//初始处罚类型
    	var penType = $("#penType").val();
    	$("#penTypeShow").text(switchPunishInfoForm(penType));
    	
        initDataTable();
        
        bind();
    }


    var table;
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	  var userType= $("#userType").val(); 
          var typeUrl="";
          if(userType=="2"){
        	  typeUrl="/syn/server/pubotherpunish/modlist.json";
          }else{
        	  typeUrl="/pub/server/pubotherpunish/modlist.json";
          }
    	
        table = dataTable.load({
            el: '#punishHisTable',
            //是否加索引值
            showIndex: true,
            ajax: {
                url:typeUrl,
                data:function(d){
                    d.params = {
                    		    priPID:$("#priPID").val(),
                    		    caseNO:$("#caseNO").val(),
                    		    altTable:"cs_pub_otherpunish"
                    		   };
                  }
            },
            columns: [
                {data: null,width:'10%', className: 'center'},
                {data: 'altDate',width:'20%', className: 'center'},
                {data: 'altName',width:'15%', className: 'center'},
                {data: 'auditState',width:'10%', className: 'center'},
                {data: 'auditName',width:'15%', className: 'center'},
                {data: 'auditDate',width:'20%', className: 'center'},
                {data: null,width:'10%',className: 'center'}
            ],
            columnDefs : [
							{
								targets: 6,
			                    render: function (data, type, row, meta) {
			                      return "<a class='details pointer'>详情</a>";
			                    }
			                },{
								targets: 3,
			                    render: function (data, type, row, meta) {
			                    	if(row.auditState == '1'){
	                            		return "审核通过";
	                            	}else if(row.auditState == '2'){
	                            		return "审核不通过";
	                            	}else{
	                            		return "-";
	                            	}
			                    }
			                }]
           })
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
            el: '.details',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                	 typeUrl="/syn";
                 }else{
                	 typeUrl="/pub";
                 }
                layer.dialog({
                    title: '详情',
                    area: ['68%', '72%'],
                    content: typeUrl+'/server/pubotherpunish/doDetails?pripid='+data.priPID+'&hisNO='+data.hisNO+'&auditState='+data.auditState+'&modUID='+data.modUID,
                    callback: function (data) {
                    }
                })
            }
        }])
    }

})

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
