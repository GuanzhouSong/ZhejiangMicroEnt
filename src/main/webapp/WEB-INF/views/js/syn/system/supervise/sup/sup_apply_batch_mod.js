
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
            lengthMenu: [ 5, 10, 20, 50, 100 ],
            ajax: {
                url:'/syn/supervise/doQueryListPage',
                data:function(d){
                	d.params = $("#search-form").serializeObject();
                }
            },
            columns: [
                {data: null, className: 'center'},
                {data: 'batchNO', className: 'center'},
                {data: 'entName', className: 'center'},
                {data: 'regNO', className: 'center'},
                {data: 'uniscid', className: 'center'},
                {data: 'leRep', className: 'center'},
                {data: 'entType', className: 'center'},
                {data: 'industryCo', className: 'center'},
                {data: 'dom', className: 'center',cut:{length:20,mark:'...'}},
                {data: 'regOrgName', className: 'center'},
                {data: 'localAdmName', className: 'center'}
            ],
             columnDefs : [
					{
					  targets: 0,
					  render: function (data, type, row, meta) {
						  return "<input type='checkbox' class='chb'>";
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
                    url: '/syn/supervise/doSaveAppBatchMod',
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
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
        	el:'#chbAll',
        	event:'click',
        	handler:function(){
        		var check = $(this).prop("checked");
        	    $(".chb").prop("checked", check);
        	}
        },{
            el: '#add',
            event: 'click',
            handler: function () {
            	layer.dialog({title: '添加',
            		area: ['86%', '86%'],
            		content: '/syn/supervise/doEnSupAppBatchModAdd?batchNO='+$(this).attr('batchNO')+'&supState='+$(this).attr('supState')
            			+'&markCode='+$(this).attr('markCode')+'&supCheckState='+$(this).attr('supCheckState'),
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
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
        	el:'#delete',
        	event:'click',
        	handler:function(){
        		var priPIDStr = "";
        		var batchNO = "";
        		$('.chb').each(function(n,i){
        			 if($(this).is(':checked')){
        				 var data = table.row($(this).closest('td')).data();
        				 priPIDStr = priPIDStr + data.priPID + ';';
        				 batchNO = data.batchNO;
        			 }
        		});
        		if(priPIDStr==''||batchNO=='') {layer.msg('请先勾选需要删除的企业',{time: 1000});return;}
        			
        		layer.confirm('确定要删除选中企业吗?', {icon: 3, title: '提示'}, function (index) {
                    layer.close(index);
        			http.httpRequest({
                        url: '/syn/supervise/doBatchDel',
                        serializable:false,
                        data: { "batchNO":batchNO,"priPIDStr":priPIDStr},
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
