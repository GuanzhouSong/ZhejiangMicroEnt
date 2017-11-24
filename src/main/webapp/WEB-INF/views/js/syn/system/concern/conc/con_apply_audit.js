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
             columnDefs : [{
			 	   targets: 8,
			       render: function (data, type, row, meta) {
			    	   if(row.isConHis=='1')
			    		   return "<a href='javascript:void(0)' class='mr10 lookhis' id='"+row.priPID+"'>有</a>"; 
			    	   else 
			   	           return "无";
			       }
			}]
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
                    url: '/syn/con/csconcernobj/doApplyAudit',
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
            el: '.lookhis',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '查看关注历史',
                    area: ['70%', '60%'],
                    content: '/syn/con/csconcernobj/getentwarnhis?priPID='+this.id,
                    callback: function (data) {
                    }
                })
            }
        }
    ]);
    	
    }
    
    
})
