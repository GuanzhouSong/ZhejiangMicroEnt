require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchParams={};//查询参数声明!
    var table;
    var initFlag = "0";
  
    init();
  
    
    /**
     * 初始化函数集合
     */
    function init() {
	     bind();
    } 

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = "1";
     	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#specialrec_table',
 			scrollX:true,
            showIndex: true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/server/casesource/list.json',
                data:function(d){ 
                	d.params = searchParams;
                }
            },
            columns: [ 
					{data: null,'defaultContent':'11'},
					{data: null,width:"100px"},
					{data: 'caseName',cut: {length: 20,mark:'...'}},
					{data: 'regNO',cut: {length: 20,mark:'...'}},
					{data: 'entName'},
					{data: 'reporterName'},
					{data: 'reportContent',cut: {length: 20,mark:'...'}},
					{data: 'reporterTel',width:"100px"},
					{data: 'reporterCard'},
					{data: 'reportTime'},
					{data: 'setName'},
					{data: 'setTime'}
            ] ,
            columnDefs: [{
                             targets: 1,
                             render: function (data, type, row, meta) { 
                            	 return  '<a class="view link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">详情</a>';
                             }
                          },{
                              targets: 3,
                              render: function (data, type, row, meta) { 
                             	 if(row.uniCode!= "" && row.uniCode!= null){
                             		return row.uniCode;
                             	 }else {
                             		return row.regNO;
                             	 } 
                              }
                          }
                  ]
         })
    } 
     
    
    function bind() {
        util.bindEvents([
      {
            el: '.view',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '查看案源详情',
                    area: ['63%', '90%'],
                    content:window._CONFIG.chooseUrl+'/server/casesource/addOrEditView?pageflag=3'+'&uid='+data.uid+'&priPID='+data.priPID,
                    callback: function(data) {
	              		 if(data.reload){ 
	              			 table.ajax.reload(); 
	                  	 }
                    }
                })
            }
        },{
        	el: '#search',
            event: 'click',
            handler: function () { 
            	searchParams = $("#taskForm").serializeObject();
            	if(initFlag =='0'){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        }
      ]);
   }
})
