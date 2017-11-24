require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

	var regStateList = [];
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
        getRegStateList();
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

    var searchParams={};//查询参数声明!
    var clickFlag = false ;
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubexcludeent-table',
            scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/pubexcludeent/list.json',
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
				{data: null, width:'50px', className: 'center'},
				{data: null, width:'100px', className: 'center'},
				{data: 'uniCode', width:'150px', className: 'center'},
				{data: 'entName', width:'180px', className: 'center'},
				{data: 'leRep', width:'80px', className: 'center'},
				{data: 'estDate', width:'100px', className: 'center'},
				{data: 'regState', width:'100px', className: 'center'}, 
				{data: 'regOrgName', width:'150px', className: 'center'},
				{data: 'localAdmName', width:'150px', className: 'center'},
				{data: 'excRea', width:'150px', className: 'center'},
                {data: 'excDept', width:'120px', className: 'center'},
                {data: 'isValid', width:'80px', className: 'center'},
                {data: 'setName', width:'100px', className: 'center'},
                {data: 'setTime', width:'150px', className: 'center'}
            ],
            columnDefs: [
				{
					targets:11,
					render:function(data,type,row,meta){
						if(row.isValid=="0"){
							return "无效";
						}else{
							return "有效";
						}
					}
				 },
				 {
						targets:6,
						render:function(data,type,row,meta){
							return switchRegStateList(row.regState);
						}
					 },
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	return "<a href='#' class='mr10 js-edit'>修改</a><a href='#' class='js-delete'>删除</a>";
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
            	window.location.href = '/reg/server/yr/pubexcludeent/listNotExclude';
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                window.location.href = '/reg/server/yr/pubexcludeent/show?priPID=' + data.priPID;
            }
        }, {
        	el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselectnocheck',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            }
        }, {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/server/yr/pubexcludeent/delete',
                        data: {pubExcludeEntId: data.id},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            }
                        }
                    });

                });
            }
        }])
    }

})
