require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {
	var table;
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
    	formValidate();
        bind();
        
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#hx-table',
			scrollX:true, //支持滚动
            showIndex: false,
            ajax: {
                url:'/syn/con/csconcernobj/applylist.json',
                data:function(d){
                	d.params = $("#search-form").serializeObject();
                }
            },
            columns: [
                      {data: null, width:'60px',className: 'center'},
                      {data : 'uniscid',width:'120px', className: 'center'},
                      {data : 'regNO',width:'100px', className: 'center'}, 
                      {data : 'entName',width:'150px', className: 'center'},
                      {data : 'industryCo',width:'100px', className: 'center'}, 
                      {data : 'dom',width:'150px', className: 'center'}, 
                      {data : 'regOrg',width:'100px', className: 'center'}, 
                      {data : 'localAdm',width:'80px', className: 'center'}, 
                      {data : null,width:'80px',className: 'center'}
            ],
             columnDefs : [
					{
					  targets: 0,
					  render: function (data, type, row, meta) {
						  return "<input type='checkbox' class='chb'>";
					  }
					}, {
					 	   targets: 8,
					       render: function (data, type, row, meta) {
					    	   if(row.isConHis=='1')
					    		   return "<a href='javascript:void(0)' class='mr10 lookhis' id='"+row.priPID+"'>有</a>"; 
					    	   else 
					   	           return "无";
					       }
					} 
					]
        })
    }
    
    function formValidate(){
    	$('#hx-form').validate({
    		rules: { },
            showErrors:function(errorMap,errorList){},
            submitHandler: function () {
                var formParam = $('#hx-form').serializeObject();
                http.httpRequest({
                    url: '/syn/con/csconcernobj/doSaveAppBatchMod',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	layer.close({reload: true});
                        });
                    }
                });
            }
        });
    }
    
    
    function bind() {
        util.bindEvents([
                         {
            el: '#addEnt',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '添加申请企业企业',
                    area: ['80%', '85%'],
                    content: '/syn/con/csconcernobj/enaddent?batchNO='+$('#batchNO').val()+'&markNo='+$('#markNo').val()+'&checkState='+$('#checkState').val(),
                    callback: function (data) {
                        //重新加载列表数据
                    	if(data.reload == true){
                		table.ajax.reload();
                	 }
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close({reload: true});
            }
        },{
        	el:'.markRadio',
        	event:'click',
        	handler:function(){
        		$('.markTable').hide();
        		$('#'+$(this).val()).show();
        	}
        },{
        	el:'#save',
        	event:'click',
        	handler:function(){
        		$('#hx-form').submit();
        	}
        },{
            el: '.lookhis',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '查看历史',
                    area: ['70%', '60%'],
                    content: '/syn/con/csconcernobj/getentwarnhis?priPID='+this.id,
                    callback: function (data) {
                    }
                })
            }
        },{
        	el:'#delete',
        	event:'click',
        	handler:function(){
        		var priPIDStr = "";
        		var batchNO = "";
        		$('.chb').each(function(n,i){
        			 if($(this).is(':checked')){
        				 var data = table.row($(this).closest('td')).data();
        				 priPIDStr = priPIDStr + data.priPID + ',';
        				 batchNO = data.batchNO;
        			 }
        		});
        		if(priPIDStr==''||batchNO=='') {layer.msg('请先勾选需要删除的企业',{time: 1000});return;}
        			
        		layer.confirm('确定要删除选中企业吗?', {icon: 3, title: '提示'}, function (index) {
                    layer.close(index);
        			http.httpRequest({
                        url: '/syn/con/csconcernobj/doBatchDel',
                        serializable:false,
                        data: {"batchNO":batchNO,"priPIDStr":priPIDStr},
                        success: function (data) {
                        	if(data.status=='success'){
                        		table.ajax.reload();
                        	}
                        }
                    });
        		});
        	}
        }
        ]);
    }
    
    
})
