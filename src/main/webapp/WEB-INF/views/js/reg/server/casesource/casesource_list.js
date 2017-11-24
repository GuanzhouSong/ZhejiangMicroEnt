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
                            	 return  '<a class="editdata link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">修改</a>'+
          	    		 		 '<a class="delete link" id="'+row.uid+'"  href="javascript:void(0);" style="color:blue;">删除</a>'; 
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
            el: '.editdata',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '修改案源信息',
                    area: ['63%', '90%'],
                    content:window._CONFIG.chooseUrl+'/server/casesource/addOrEditView?pageflag=2'+'&uid='+data.uid+'&priPID='+data.priPID,
                    callback: function(data) {
	              		 if(data.reload){ 
	              			 table.ajax.reload(); 
	                  	 }
                    }
                })
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
           	 	var uid=data.uid;
            	layer.dialog({
                    title: '查看详情',
                    area: ['95%', '98%'],
                    content:window._CONFIG.chooseUrl+'/server/specialrec/task/addOrmodify?flag=3'+'&recTaskUid='+data.uid,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },{
            el: '.delete',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data(); 
            	layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: window._CONFIG.chooseUrl+'/server/casesource/delete',
	                    data: {caseUid: data.uid},
	                    success: function (data) {
	                        if (data.status == 'success') {  
				                layer.msg("删除成功", {time: 2000}, function () {
				                	table.ajax.reload();
				                }); 
	                        }else{
	                        	layer.msg(data.msg, {ltype: 0,time:3000});
	                        } 
	                    }
	                });
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
        },{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	window.location.href = window._CONFIG.chooseUrl+'/server/casesource/addlist';
            }
        }
      ]);
   }
})
