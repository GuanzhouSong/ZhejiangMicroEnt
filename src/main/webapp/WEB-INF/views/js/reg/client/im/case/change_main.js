require(['component/iframeLayer', 'component/dataTable', 'common/util' ,'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate','jquery.placeholder','jquery.icinfo'],
function(layer, dataTable, util, http, handlebars) {
	  $('input, textarea').placeholder();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	
        initDataTable();
        var caseNO = $("#caseNO").val(); 
        bind();
      
    }
    
    laydate.skin('molv');//初始化皮肤
    var end = {
            elem: '#altDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: "2099-12-31", //最大日期 //最大日期
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             //结束日选好后，重置开始日的最大日期
            }
        }; 
   
  

    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var caseNO = $("#caseNO").val();
        http.httpRequest({
            url: '/reg/client/im/ent/casalt/list.json',
            serializable: false,
            data: {
                "caseNO": caseNO
            },
            success: function(data) {
                var handleHelper = handlebars.registerHelper("addOne",
                function(index) {
                    //返回+1之后的结果
                    return index + 1;
                });

                handlebars.registerHelper("dataFormat",
                function(value) {
                    var myDate = new Date(value);
                    var month=myDate.getMonth()+1;
                    return myDate.getFullYear() + "年" + month+ "月" + myDate.getDate() + "日";
                });

                var myTemplate = handlebars.compile($("#table-template").html());
                $('#tplPage').html(myTemplate(data));
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function() {
            	if($("#altDate").val()==""||$("#altDate").val()==null){
            		  
            		
            		 layer.tips("请选择变更时间",$("#altDate"),{tips:3, tipsMore:true, ltype:0});
            		 $("#altDate").focus();
            		return false;
            	}
            	if($("#penAuth").val()==""||$("#penAuth").val()==null){
            		 
            		 layer.tips("请输入变更决定做成机关",$("#penAuth"),{tips:3, tipsMore:true, ltype:0});
            		 $("#penAuth").focus();
            		 return false;
            		
            	}
            	if($("#penContent").val()==""||$("#penContent").val()==null){
            		 
            		 
            		 layer.tips("请输入变更内容",$("#penContent"),{tips:3, tipsMore:true, ltype:0});
            		 $("#penContent").focus();
            		 return false;
            	}
            	if($("#remark").val()==""||$("#remark").val()==null){
            	 
            		 layer.tips("请输入备注",$("#remark"),{tips:3, tipsMore:true, ltype:0});
            		 $("#remark").focus();
            		 return false;
            	}
            	
            	
            	
            	
                var formParam = $('#casaltForm').serializeObject();

                 $("#save").attr("disabled", true);
       		 $("#save").val("提交中...."); 
               var _index;
                http.httpRequest({
                    url: '/reg/client/im/ent/casalt/save',
                    beforeSend:function(){
                    	_index=layer.load(2,{shade:0.5});
                    },
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function(data) {
                        layer.close(_index);
                        $("#save").attr("disabled",false);
                  		 $("#save").val("确定"); 
                  		 if(data.status=="success"){
                    	layer.msg(data.msg, {
                            time: 1000
                        },
                        function() { 
                        	 
                            initDataTable();
                        });
                    }else{
                    	layer.msg(data.msg, {
                            time: 2000
                        },
                        function() { 
                        	 
                            initDataTable();
                        });
                    }
                    }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
                location.href = "/reg/client/im/ent/case/list";
            }
        },

        {
            el: '.js-edit',
            event: 'click',
            handler: function() {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '编辑用户',
                    area: ['628px', '500px'],
                    content: '/reg/client/im/ent/case/show?caseNO=' + data.caseNO + "&pubFlag=" + data.pubFlag,
                    callback: function(data) {
                        if (data.reload) {
                            initDataTable();
                        }
                    }
                })
            }
        },
        
        {
            el: '.js-delete',
            event: 'click',
            handler: function() {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {
                    icon: 2,
                    title: '提示'
                },
                function(index) {
                    http.httpRequest({
                        url: '/reg/client/im/ent/caseNO/delete',
                        data: {
                            caseNO: data.caseNO
                        },
                        success: function(data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {
                                        time: 500
                                    },
                                    function() {
                                        table.ajax.reload();
                                    });
                                }
                            } else if (data.status == "fail") {
                                if (data.msg) {
                                    layer.msg(data.msg, {
                                        time: 500
                                    },
                                    function() {
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