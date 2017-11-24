require(['component/iframeLayer', 'component/dataTable',
    'common/util', 'common/http', 'handlebars', 'jquery.validate', 'jquery.serialize', 'laydate', 'ztree', 'ztreeCheck'], function
    (layer, dataTable, util, http, handlebars) {


    init();
    /**
     * 初始化函数集合
     */

    function init() {
        bind();
        initCheckContent();
    }

    function initCheckContent() {
        var iDCode_rr = $('#iDCode').val().split(',');
        if (iDCode_rr.length > 0) {
            $('input[name="_checkbox"]').each(function () {
                for (var i = 0; i < iDCode_rr.length; i++) {
                    if ($(this).val() == iDCode_rr[i]) {
                        $(this).prop("checked", 'true');
                    }
                }
            });
        }
    }

    function checkTxt() {
        var allChecked = '';
        var allCheckedVal = '';
        $(':checkbox[name="_checkbox"]').each(function () {
            var checkFlag = $(this).prop("checked");
            var text = $(this).next().html();
            var val = $(this).val();
            if (checkFlag) {
                allChecked += "," + text;
                allCheckedVal += "," + val;
            }
        });
        $('#iDNamep').html(allChecked.substr(1));
        $('#iDName').val(allChecked.substr(1));
        $('#iDCode').val(allCheckedVal.substr(1));
    }

    function bind() {
        util.bindEvents([
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    layer.close();
                }
            },
            {
                el: '#save',
                event: 'click',
                handler: function () {
                    layer.close({
                        names: $('#iDName').val(),
                        codes: $('#iDCode').val()
                    });
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                    checkTxt();
                }
            },
            {
                el: 'input[name="_checkbox"]',
                event: 'click',
                handler: function () {
                    checkTxt();
                }
            }, {
                el: '#qry',
                event: 'click',
                handler: function () {
                    var _key = $('#_key').val();
                    util.searchCheckbox(_key, $('.option-item'), layer);
                }
            }
        ])
    }

})