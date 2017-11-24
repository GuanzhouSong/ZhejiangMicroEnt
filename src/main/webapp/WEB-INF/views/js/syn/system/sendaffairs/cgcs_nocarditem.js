require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'common/validateRules'], function (layer, dataTable, util, http, handlebars) {

    var searchParam = "";
    var licType = "";
    var data = new Object();
    var _urlHead = window._CONFIG._urlHead;

    init();

    function init() {
        bind();
        getIllegalList();
    }


    function getIllegalList() {
        searchParam = $("#searchparam").val();
        licType = $("#licType input[type='radio']:checked").val();
        http.httpRequest({
            url: _urlHead + 'doGetNoCardItemList',
            serializable: false,
            data: {"licType": licType, "searchParam": searchParam},
            type: 'post',
            success: function (json) {
                if (json.status == "success") {
                    $("#real").remove();
                    if (json.data == "") {
                        layer.msg("没有符合要求的违法事项，请重新查询！", {time: 1500}, function () {
                        });
                        return false;
                    }
                    ;
                    var page = "<div id='real'>";
                    $.each(json.data, function (i, item) {
                        page += "<div class='option-item'><label><input type='checkbox' name='illegalitem'><span class='name'>" + item.licName + "</span></label></div>";
                    });
                    page += "</div>";
                    $("#illegalList").append(page);
                }
                $("#real input:checkbox").click(function () {
                    $("#real input:checkbox").not($(this)).removeAttr("checked");
                });
            }
        });
    }

    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                data.flag = true;
                data.text = $("#real input[type='checkbox']:checked + span").text();
                if (data.text == "") {
                    layer.msg("请选择违法事项！", {time: 1500}, function () {
                    });
                    return false;
                }
                layer.close(data);
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function () {
                data.flag = false;
                layer.msg("已关闭！", {time: 1500}, function () {
                });
                layer.close(data);
            }
        }, {
            el: '.btn-search',
            event: 'click',
            handler: function () {
                searchParam = $("#searchparam").val();
                if (searchParam == "") {
                    layer.msg("请输入搜索条件！", {time: 1500}, function () {
                    });
                    return false;
                }
                getIllegalList();
            }
        }, {
            el: '#front',
            event: 'click',
            handler: function () {
                getIllegalList();
            }
        }, {
            el: '#back',
            event: 'click',
            handler: function () {
                getIllegalList();
            }
        }])
    }
})
