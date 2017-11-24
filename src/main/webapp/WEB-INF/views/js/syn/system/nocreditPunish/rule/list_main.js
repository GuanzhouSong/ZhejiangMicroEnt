require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

	var urlHead=window._CONFIG.urlHead;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;
    var params = {};//查询参数声明!
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#rule-table',
            scrollX: true,
            ajax : {
                type : "get",
                url :  urlHead+'/noCreditPunish/rule/list.json',
                data : function(d) {
                    d.params = params;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, width: '120px', className: 'center', width:"150px"},
                {data: 'punField', width:"170px"},
                {data: 'legBasis', width:"170px"},
                {data: 'punCause', width:"170px"},
                {data: 'limitTime', width:"130px"},
                {data: 'punRule', width:"170px"},
                {data: 'punMea', width:"170px"},
                {data: 'punReqDept', width:"150px"},
                {data: 'punExeDept', width:"150px"}
            ],
            columnDefs: [
                {
                    targets: 0,
                    render: function (data, type, row, meta) {
                        var context = {
                            func: [
                                {
                                    'text': '编辑',
                                    'class': 'js-edit'
                                },
                                {
                                    'text': '删除',
                                    'class': 'js-delete'
                                }
                            ]
                        };
                        return template(context);
                    }
                },{
                	targets: 2,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>20){
                    		return data.substring(0,20)+"...";
                    	}else
                    		return data;
                    }
                },{
                	targets: 3,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>20){
                    		return data.substring(0,20)+"...";
                    	}else
                    		return data;
                    }
                },{
                	targets: 4,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>20){
                    		return data.substring(0,20)+"...";
                    	}else
                    		return data;
                    }
                },{
                	targets: 5,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>20){
                    		return data.substring(0,20)+"...";
                    	}else
                    		return data;
                    }
                },{
                	targets: 6,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>20){
                    		return data.substring(0,20)+"...";
                    	}else
                    		return data;
                    }
                },{
                	targets: 7,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>100){
                    		return data.substring(0,100)+"...";
                    	}else
                    		return data;
                    }
                },{
                	targets: 8,
                    render: function (data, type, row, meta) {
                    	if(data != null && data.length>100){
                    		return data.substring(0,100)+"...";
                    	}else
                    		return data;
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
        {
            el: '#add',
            event: 'click',
            handler: function () {
            	window.location.href=urlHead+'/noCreditPunish/rule/show';
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                window.location.href=urlHead+'/noCreditPunish/rule/show?id='+data.id;
            }
        }, {
        	el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function(index) {
                    http.httpRequest({
                        url: urlHead+'/noCreditPunish/rule/delete',
                        type: 'post',
                        data: {id: data.id},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 1500}, function () {
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
