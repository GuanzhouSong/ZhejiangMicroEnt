require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        formValidate()
        bind();
    }

    
    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#ent-check-edit',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/risk/csentwarn/list.json',
                data:function(d){
                	if(clickFlag){
                		d.params = searchParams;
                	}else{
                		 d.params = {"batchNo":$('#batchNo').val()};
                	}
                }
            },
            columns: [
                    {data: null,width:'60px',className: 'center'},
                    {data : 'uniscid',width:'120px', className: 'center'}, 
          			{data : 'regNO',width:'100px', className: 'center'}, 
          			{data : 'entName',width:'120px', className: 'center'},
          			{data : 'leRep',width:'80px', className: 'center'}, 
          			{data : 'entType',width:'100px', className: 'center'}, 
          			{data : 'industryCo',width:'100px', className: 'center'}, 
          			{data : 'dom',width:'150px', className: 'center'}, 
          			{data : 'regOrg',width:'100px', className: 'center'}, 
          			{data : 'localAdm',width:'150px', className: 'center'}, 
          			{data : null, width:'80px',className: 'center'}
            ],
             columnDefs : [
							{
								targets:10,
			                    render: function (data, type, row, meta) {
			                    	 if(row.isWarnHis=='1')
			                  		   return "<a href='javascript:void(0)' class='mr10 lookhis' id='"+row.priPID+"'>有</a>"; 
			                  	     else 
			                 	       return "无";
			                    }
			                }
					  ]
        })
    }
    
    function formValidate(){
    	$('#checkForm').validate({
    		rules: {
    			checkView: {
                    required: true,
                    maxlength:200
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
            		layer.tips(errorMap[i],$('#checkView'),{
            			tips:3,
            			tipsMore:true,
            			ltype:0
            		}
            		);
                }
            },
            submitHandler: function () {
                var formParam = $('#checkForm').serializeObject();
                http.httpRequest({
                    url: '/syn/risk/csentwarn/savecheck',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	window.location.href='/syn/risk/csentwarn/enchecklist';
                        });
                    }
                });
            }
        });
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	clickFlag = true;
    	searchParams = $("#searchForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.cancel',
            event: 'click',
            handler: function () {
            	if(this.id=='0')
            		window.location.href='/syn/risk/csentwarn/applylist';
            	else
            		window.location.href='/syn/risk/csentwarn/enchecklist';
            		
            }
        },{
            el: '.lookhis',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '查看预警历史',
                    area: ['70%', '60%'],
                    content: '/syn/risk/csentwarn/getentwarnhis?priPID='+this.id,
                    callback: function (data) {
                    }
                })
            }
        }
        ])
    }
    
})
