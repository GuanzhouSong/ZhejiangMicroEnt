require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','common/validateRules', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
//        formValid();
        bind();
    }

    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#modapplicationhis',
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/modapplication/historylist.json',
                data:function(d){
    				d.params = {"priPID":$("#priPID").val()};
    			}
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
				{data: null,width: '8%',className: 'center'},
				{data: 'modSubmitDate',width: '15%', className: 'center'},
				{data: 'modReason',width: '25%'},
				{data: 'modResult',width: '10%'},
				{data: 'modDescription',width: '22%'},
				{data: 'audName',width: '10%'},
				{data: 'audDate',width: '10%'}
            ],
            columnDefs: [{
				targets:3,
				render:function(data,type,row,meta){
					if(row.modResult=="1"){
						return "同意";
					}else if(row.modResult=="2"){
						return "不同意";
					}else{
						return "";
					}
				}
			 }]
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
            el: '#okRadio',
            event: 'click',
            handler: function () {
                $("#modDescription").val("同意你企业的修改申请，请登录后修正相关数据，并重新提交年度报告");
            }
        },{
            el: '#noOkRadio',
            event: 'click',
            handler: function () {
                $("#modDescription").val("");
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	var flag = false;
            	$("input[name='modResult']").each(function(){
            		if($(this).prop("checked"))flag = true;
            	});
            	if(!flag){
            		layer.tips("请选择审核结果",$("#okRadio"),{tips:1, tipsMore:true, ltype:0});
            		return false;
            	}
            	$('#modapplication-form').validate({
                    rules: {
                    	modDescription: {
                            required: true,
                            maxlength:500
                        }
                    },
                    showErrors:function(errorMap,errorList){
                        for(var i in errorMap){
                    		layer.tips(errorMap[i],$('#modDescription'),{
                    			tips:3,
                    			tipsMore:true,
                    			ltype:0
                    		});
                        }
                    },
                    submitHandler: function () {
                        var formParam = $('#modapplication-form').serializeObject();
                        http.httpRequest({
                            url: '/reg/server/yr/modapplication/commit',
                            serializable: false,
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
        }]);
    }
});
