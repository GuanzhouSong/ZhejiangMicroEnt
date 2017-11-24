require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
         'jquery','jquery.serialize','laydate','jquery.validate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {
    
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
            showIndex: true,
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
             columnDefs : []
        })
    }
    
    function formValidate(){
    	$('#hx-form').validate({
    		rules: {
    			checkAdv:{required:true,maxlength:200}
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
            	 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#hx-form input[name='+i+'],textarea[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
            },
            submitHandler: function () {
                http.httpRequest({
                    url: '/syn/supervise/doSaveSupCheck',
                    serializable: true,
                    data: $("#hx-form").serializeObject(),
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
    
    
    function bind(){
    	util.bindEvents([
    	{
    		 el: '#back',
             event: 'click',
             handler: function () {
             	layer.close();
             }
        },{
        	el:'.check_adv',
        	event:'click',
        	handler:function(){
        		$('#area_checkAdv').val($(this).attr('txt'));
        	}
        }
    ]);
    	
    }
    
    
})
