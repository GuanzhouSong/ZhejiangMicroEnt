require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

	var regStateList = [];
	var searchParams=$("#hx-form").serializeObject();//查询参数声明!
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	getRegStateList();
        initDataTable();
        bind();
    }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regState option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#search-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/secnocreditsearch/searchlist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                {data: null,defaultContent:1,width:'80px', className: 'center'},
                {data: null,defaultContent:1,width:'80px', className: 'center'},
                {data: 'uniSCID',width:'100px', className: 'center'},
                {data: 'regNO',width:'100px', className: 'center'},
                {data: 'entName',width:'100px', className: 'center'},
                {data: 'leRep',width:'100px', className: 'center'},
                {data: 'addSecState',width:'150px', className: 'center' },
                {data: 'secDishonestyType',width:'100px', className: 'center'},
                {data: 'addSecCause',width:'120px', className: 'center'},
                {data: 'addSecDate',width:'100px', className: 'center'},
                {data: 'addSecNo',width:'200px', className: 'center'},
                {data: 'addSecOrg',width:'100px', className: 'center'},
                {data: 'regState',width:'100px', className: 'center'},
                {data: 'localAdm',width:'100px', className: 'center'},
                {data: 'speCauseCN',width:'100px', className: 'center'}
            ],
             columnDefs : [
                           {
					targets:1,
                    render: function (data, type, row, meta) {
                    	return '<a class="detail">详情</a>';
                    }
                },{
					targets:12,
                    render: function (data, type, row, meta) {
                    	return switchRegStateList(row.regState);
                    }
                }
             ]
        })
    }
    
    function bind() {
    	 util.bindEvents([{
             el: '#search',
             event: 'click',
             handler: function () {
             	searchParams = $("#hx-form").serializeObject();
                table.ajax.reload();             }
         },{
             el: '#reset',
             event: 'click',
             handler: function () {
             	$('.clx').val('');
             }
         }, {
             el: '#choseregUnit',
             event: 'click',
             handler: function () {
                 layer.dialog({
                     title: '请选择企业管理部门',
                     area: ['25%', '60%'],
                     content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                     callback: function (data) {
                         //重新加载列表数据
                         $("#localAdm").val(data.returncodes);
                         $("#localAdmName").val(data.returnname);
                     }
                 })
             }
         }, {
             el: '.detail',
             event: 'click',
             handler: function () {
             	var data = table.row($(this).closest('td')).data();
             	   layer.dialog({
                        title: '详情',
                        area: ['98%', '99%'],
                        content: '/reg/server/seriouscrime/doEnExpInApplyDetail?priPID='+data.priPID+"&uID="+data.sourceId,
                        callback: function (data) {
                        	if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                 }
             },{
             el: '#chosespeCause',
             event: 'click',
             handler: function () {
                 layer.dialog({
                     title: '列入原因',
                     area: ['600px', '350px'],
                     content: '/commom/server/intercept/interceptselect?selecttype=appInReaCodeList',
                     callback: function (data) {
                         if(data){
                             $("#speCause").val(data.id);
                             $("#SpeCauseCN").val(data.text);
                         }
                     }
                 })
             }
         }
         ])
    }
   
})
