require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initform();
        bind();
    }

    //初始化
    function initform() {
        if ($("#receiveState").val() == '1' || $("#claimState").val() == '1') {//已认领或者已接收
            $("#btnDiv").hide();
        } else {
            $("#btnDiv").show();
        }
    }

    function bind() {
        util.bindEvents([
            {
                el: '#claim',
                event: 'click',
                handler: function () {
                    var formParam = $('#claimForm').serializeObject();
                    layer.confirm('确定认领吗?', {icon: 2, title: '提示'}, function () {
                        http.httpRequest({
                            url: window._CONFIG.chooseUrl + '/pubdtinfo/doreceive',
                            serializable: true,
                            data: formParam,
                            type: 'post',
                            success: function (data) {
                                if (data.status == 'success') {
                                    layer.alert('您本次认领/接收到涉证企业信息<em style="color: red;">' + 1 + '</em>条,本年度累计认领/接收<em style="color: red;">' + data.data + '</em>条', {closeBtn: 0},
                                        function (index) {
                                            layer.close(index);
                                            layer.close({reload: true});
                                        });
                                } else {
                                    layer.msg(data.msg, {ltype: 0, time: 2000});
                                }
                            }
                        });
                    })
                }
            },
            {
                el: '#receive',
                event: 'click',
                handler: function () {
                    var formParam = $('#receiveForm').serializeObject();
                    layer.confirm('确定接收吗?', {icon: 2, title: '提示'}, function () {
                        http.httpRequest({
                            url: window._CONFIG.chooseUrl + '/pubdtinfo/doreceive',
                            serializable: true,
                            data: formParam,
                            type: 'post',
                            success: function (data) {
                                if (data.status == 'success') {
                                    layer.alert('您本次认领/接收到涉证企业信息<em style="color: red;">' + 1 + '</em>条,本年度累计认领/接收<em style="color: red;">' + data.data + '</em>条', {closeBtn: 0},
                                            function (index) {
                                                layer.close(index);
                                                layer.close({reload: true});
                                            });
                                } else {
                                    layer.msg(data.msg, {ltype: 0, time: 2000});
                                }
                            }
                        });
                    })
                }
            },
            {
                el: '#reback', //回退
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '',
                        area: ['640px', '400px'],
                        content: window._CONFIG.chooseUrl + '/pubdtinfo/reback?priPId=' + window._CONFIG._priPID + '&uid=' + window._CONFIG._uid,
                        callback: function (data) {
                            //重新加载列表数据
                            if (data.reload) {
                                layer.close({reload: true});
                            }
                        }
                    })
                }
            }
        ])
    }

})
