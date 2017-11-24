require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    var searchParams={};//查询参数声明!
    var table;
  
    init();
    
    /**
     * 初始化函数集合
     */
    function init() {
    	if($("#entTypeCatg").val() == '50'){
    		initPbDaTable();
    	}else{
    		initDataTable();
    	}
        bind();
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
     	searchParams = $("#hx-form").serializeObject();
        table = dataTable.load({
            el: '#table_qyjyqcxx',
            "aLengthMenu": [10, 25, 50, 100,1000,2000],
 			scrollX:true,
            showIndex: true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/server/opanomaly/search/opasearch.json',
                data:function(d){
                   d.params = $.extend({}, searchParams, {"removePermit":"1"});
                }
            },
            columns: [ 
                    {data: null,'defaultContent':'11'}, 
    				{data: 'speCauseCN',cut: {length: 20,mark:'...'}},
    				{data: 'abnTime',cut: {length: 20,mark:'...'}},
    				{data: 'penDecNo',cut: {length: 20,mark:'...'}},
     				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
    				{data: 'remExcpresCN',cut: {length: 20,mark:'...'}},
    				{data: 'remDate',cut: {length: 20,mark:'...'}},
    				{data: 'canOutPenDecNo',cut: {length: 20,mark:'...'}},
    				{data: 'reDecOrgCN',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
                         // 需要异常名录决定书打印 放开此注释
                        /* {
						    targets: 3,
						    render: function (data, type, row, meta) {
						    	return  '<a class="printspbook link" id="'+row.busExcList+'" priPID="'+row.priPID+'" href="javascript:void(0);" style="color:blue;">'+row.penDecNo+'</a>';
						    }
						 },{
                        	 targets: 7,
                        	 render: function (data, type, row, meta) {
                        		 return  '<a class="printspbook link printspbook2" id="'+row.busExcList+'" priPID="'+row.priPID+'" href="javascript:void(0);" style="color:blue;">'+row.penDecNo+'</a>';
                        	 }
                         }   */
	                 ]
         })
    }
    
    function initPbDaTable() {
    	searchParams = $("#hx-form").serializeObject();
    	table = dataTable.load({
    		el: '#table_qyjyqcxx',
    		"aLengthMenu": [10, 25, 50, 100,1000,2000],
    		scrollX:true,
    		showIndex: true,
    		ajax: {
    			url:window._CONFIG.chooseUrl+'/server/opanomaly/search/opasearch.json',
    			data:function(d){
    				d.params = $.extend({}, searchParams, {"removePermit":"1"});
    			}
    		},
    		columns: [ 
    		          {data: null,'defaultContent':'11'}, 
    		          {data: 'speCauseCN',cut: {length: 20,mark:'...'}},
    		          {data: 'abnTime',cut: {length: 20,mark:'...'}},
    		          {data: 'decorgCN',cut: {length: 20,mark:'...'}},
    		          {data: 'remExcpresCN',cut: {length: 20,mark:'...'}},
    		          {data: 'remDate',cut: {length: 20,mark:'...'}},
    		          {data: 'reDecOrgCN',cut: {length: 20,mark:'...'}}
    		],
    		columnDefs: [
    		                       
    		]
    	})
    }
    

    function bind() {
        util.bindEvents([{
            el: '.printspbook',
            event: 'click',
            handler: function () {
             	var busExcList=this.id;
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = window._CONFIG.chooseUrl+"/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+busExcList;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=yes,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
          },{
              el: ".printspbook2",
              event: 'click',
              handler: function () { 
            	  var busExcList=this.id;
             	  var _id = "_doPrint_"+new Date().getTime();
                  var url = window._CONFIG.chooseUrl+"/server/opadetail/pubopadetail/opadetailBookPrint?busExcList="+busExcList;
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
