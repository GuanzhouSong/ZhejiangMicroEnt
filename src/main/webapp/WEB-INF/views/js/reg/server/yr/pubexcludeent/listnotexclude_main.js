require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }

    var searchParams={};//查询参数声明!
    var clickFlag = false ;
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubnotexcludeent-table',
            scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/pubexcludeent/listNotExclude.json',
                data:function(d){
                	if(clickFlag){
	               		 d.params = searchParams;
	               	}else{
	               		
	               	}
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className: 'center'},
                {data: null, className: 'center'},
                {data: 'uniCode', className: 'center'},
                {data: 'entName', className: 'center'},
                {data: 'leRep', className: 'center'},
                {data: 'estDate', className: 'center'},
                {data: 'regState', className: 'center'}, 
                {data: 'regOrgName', className: 'center'},
                {data: 'localAdmName', className: 'center'}
            ],
            columnDefs: [
				{
					targets:6,
					render:function(data,type,row,meta){
						if(row.regState=="A"){
							return "存续";
						}else if(row.regState=="B"){
							return "变更";
						}else if(row.regState=="D"){
							return "吊销";
						}else if(row.regState=="K"){
							return "开业";
						}else if(row.regState=="DA"){
							return "撤销";
						}else if(row.regState=="C"){
							return "吊销未注销";
						}else{
							return "未知";
						}
					}
				 },
				 
				 {
                     targets: 1,
                     render: function (data, type, row, meta) {
                         return  '<input  type="radio" name="_radio" class="_radio" value='+row.priPID+'>';
                     }
				 }
            ]
        })
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	clickFlag =true;
        table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
            	var data = $("input[name='_radio']:checked").val();
            	if(data==undefined){
            		alert("请先选择企业");
            	}else{
            		window.location.href = '/reg/server/yr/pubexcludeent/show?priPID='+data;
            	}
            }
        },{
            el: '._radio',
            event: 'click',
            handler: function () {
            	var data2 = $("input[name='_radio']:checked").val();
            }
        }])
    }

})
