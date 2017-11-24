require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
    	var entTypeCatg = $("#entTypeCatg").val();
    	if(entTypeCatg =='16' || entTypeCatg =='17'){
	    	 //农专行政许可信息
	       	 initSfcLisenceTable();
	       	 //农专网站信息
	    	 initSfcWebTable();
	    	 //修改记录信息
	    	 initSfcModTable();
    	}else if(entTypeCatg =='50'){
	    	 //个体行政许可信息
	    	 initPbLisenceTable();
	    	 //个体网站信息
	         initPbPubWebTable();
	         //修改记录信息
	         initPbModTable();
    	}else{
	        //网站信息
	    	 initPubWebTable();
	    	//对外担保信息
	     	initPubGuranteeTable();
	     	//投资人及出资信息
	     	initSubcapTalTable();
	     	//股权转让信息
	     	initalterStockTable();
	     	//对外投资信息
	     	initforinvestMentTable();
	     	//修改信息表
	     	initmodHisTable();
    	}
        //事件绑定
        bind();
    }
    
    //行政许可信息
    function initPbLisenceTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubLicenceTable',
                showIndex: true,
                ajax: {
                	url:'/pub/pblicenceinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%',className: 'center'},
                    {data: 'licNameCN',className: 'center'},
                    {data: 'valTo',className: 'center'}
                ]
          })
    }
    
    function initSfcLisenceTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubLicenceTable',
                showIndex: true,
                ajax: {
                	url:'/pub/sfclicenceinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%',className: 'center'},
                    {data: 'licNameCN',className: 'center'},
                    {data: 'valTo',className: 'center'}
                ]
          })
    }
    
    //网站信息
    function initPubWebTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubwebTable',
                showIndex: true,
                ajax: {
                	url:'/pub/WebsiteInfo/list.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                //回调
        	    fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isWebInfo").text(_length > 0?"是":"否");
        	    },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'webSitName', width: '20%',className: 'center'},
                    {data: 'webType', width: '20%',className: 'center'},
                    {data: 'webSite', width: '20%',className: 'center'}
                ],
                columnDefs : [
  							   {
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if (row.webType == '0') {
  										return "网站";
  									}else{
  										return "网店";
  								    }
  					            }
  				          }]
                    })
             }
    
    function initPbPubWebTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubwebTable',
                showIndex: true,
                ajax: {
                	url:'/pub/pbwebsiteinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'webSitName', width: '20%',className: 'center'},
                    {data: 'webType', width: '20%',className: 'center'},
                    {data: 'webSite', width: '20%',className: 'center'}
                ],
                columnDefs : [
  							   {
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if (row.webType == '0') {
  										return "网站";
  									}else{
  										return "网店";
  								    }
  					            }
  				           }]
                      })
                }
    
    function initSfcWebTable(){
    	var anCheID = $("#anCheID").val();
    	var  table1 = dataTable.load({
                el: '#pubwebTable',
                showIndex: true,
                ajax: {
                	url:'/pub/sfcwebsiteinfo/list',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'webSitName', width: '20%',className: 'center'},
                    {data: 'webType', width: '20%',className: 'center'},
                    {data: 'webSite', width: '20%',className: 'center'}
                ],
                columnDefs : [
  							   {
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if (row.webType == '0') {
  										return "网站";
  									}else{
  										return "网店";
  								    }
  					            }
  				           }]
                      })
                }
    
   //对外担保信息
    function initPubGuranteeTable(){
    	var anCheID = $("#anCheID").val();
    	var  table2 = dataTable.load({
                el: '#guranteeTable',
                showIndex: true,
                ajax: {
                	url:'/pub/GuaranteeInfo/list.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'more', width: '15%',className: 'center'},
                    {data: 'mortgagor', width: '15%',className: 'center'},
                    {data: 'priClaSecKind', width: '15%',className: 'center'},
                    {data: 'priClaSecAm', width: '15%',className: 'center'},
                    {data: 'isPubFlag', width: '15%',className: 'center'},
                    {data: 'gaType', width: '15%',className: 'center'}
                ],
                columnDefs : [
 							   {
 								targets : 5,
 								render : function(data, type, row, meta) {
 									if (row.isPubFlag == '0') {
 										return "不公示";
 									}else{
 										return "公示";
 								    }
 					           }
 				             },{
								targets : 6,
									render : function(data, type, row, meta) {
										if (row.gaType == '1') {
											return "一般保证";
										}else if(row.gaType == '2'){
											return "连带保证";
									    }else{
									    	return "未约定";
									    }
						          }
				             },{
								targets : 3,
									render : function(data, type, row, meta) {
										if (row.priClaSecKind == '1') {
											return "合同";
										}else if(row.priClaSecKind == '2'){
											return "其它";
									    }
						          }
				             }]
                       })
               }
    
    //投资人及出资信息
    function initSubcapTalTable (){
    	var anCheID = $("#anCheID").val();
    	var  table3 = dataTable.load({
                el: '#subcaptalTable',
                showIndex: true,
                ajax: {
                	 url:'/pub/subcapitalInfo/list.json',
                	 data:function(d){
     	                d.params = {"anCheID":anCheID};
                     }
                },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'inv', width: '10%',className: 'center'},
                    {data: 'invRegNO', width: '10%',className: 'center'},
                    {data: 'lisubconam', width: '10%',className: 'center'},
                    {data: 'conFormCN', width: '10%',className: 'center'},
                    {data: 'subConDate', width: '15%',className: 'center'},
                    {data: 'liacconam', width: '10%',className: 'center'},
                    {data: 'acConFormCn', width: '10%',className: 'center'},
                    {data: 'acConDate', width: '15%',className: 'center'}
                ]
            })
    }
    
   //股权转让信息
    function initalterStockTable (){
    	var anCheID = $("#anCheID").val();
    	var  table4 = dataTable.load({
                el: '#alterStockTable',
                showIndex: true,
                ajax: {
                	url:'/pub/alterStockInfo/list.json',
                	data:function(d){
    	                d.params = {"anCheID":anCheID};
                    }
                },
                fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isStockInfo").text(_length > 0?"是":"否");
        	    },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'inv', width: '20%',className: 'center'},
                    {data: 'beTransAmPr', width: '20%',className: 'center'},
                    {data: 'afTransAmPr', width: '20%',className: 'center'},
                    {data: 'altDate', width: '25%',className: 'center'}
                ]
            })
    }
    
   //对外投资信息
    function initforinvestMentTable (){
    	var anCheID = $("#anCheID").val();
    	var  table5 = dataTable.load({
                el: '#forinvestMentTable',
                showIndex: true,
                ajax: {
                	 url:'/pub/forinvestMentInfo/list.json',
                	 data:function(d){
     	                d.params = {"anCheID":anCheID};
                     }
                },
                fnInitComplete: function(oSettings, json) {
        	    	var _length = json.data.length ;
        	    	$("#isInvestInfo").text(_length > 0?"是":"否");
        	    },
                columns: [
                    {data: null, width: '10%', className: 'center'},
                    {data: 'uniCode', width: '45%',className: 'center'},
                    {data: 'entName', width: '45%',className: 'center'}
                ]
            })
    }
    
    //修改记录表
    function initmodHisTable(){
    	var anCheID = $("#anCheID").val();
    	var  table7 = dataTable.load({
    		el: '#modHisTable',
    		showIndex: true,
    		ajax: {
    			url:'/pub/updateinfo/list.json',
    			data:function(d){
	                d.params = {"anCheID":anCheID};
                }
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'altItem', width: '24%',className: 'center'},
    		          {data: 'altBe', width: '22%',className: 'center'},
    		          {data: 'altAf', width: '22%',className: 'center'},
    		          {data: 'altDate', width: '22%',className: 'center'}
    		    ]
    	    })
       }
    
    function initPbModTable(){
    	var anCheID = $("#anCheID").val();
    	var  table7 = dataTable.load({
    		el: '#modHisTable',
    		showIndex: true,
    		ajax: {
    			url:'/pub/pbupdateinfo/forbidword.json',
    			data:function(d){
	                d.params = {"anCheID":anCheID};
                }
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'altItem', width: '24%',className: 'center'},
    		          {data: 'altBe', width: '22%',className: 'center'},
    		          {data: 'altAf', width: '22%',className: 'center'},
    		          {data: 'altDate', width: '22%',className: 'center'}
    		        ]
    	      })
       }
    
    function initSfcModTable(){
    	var anCheID = $("#anCheID").val();
    	var  table7 = dataTable.load({
    		el: '#modHisTable',
    		showIndex: true,
    		ajax: {
    			url:'/pub/sfcupdateinfo/forbidword.json',
    			data:function(d){
	                d.params = {"anCheID":anCheID};
                }
    		},
    		columns: [
    		          {data: null, width: '10%', className: 'center'},
    		          {data: 'altItem', width: '24%',className: 'center'},
    		          {data: 'altBe', width: '22%',className: 'center'},
    		          {data: 'altAf', width: '22%',className: 'center'},
    		          {data: 'altDate', width: '22%',className: 'center'}
    		         ]
    	      })
        }
    
})