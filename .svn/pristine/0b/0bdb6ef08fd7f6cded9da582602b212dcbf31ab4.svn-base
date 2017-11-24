require(['component/iframeLayer', 'component/dataTable',
    'common/util', 'common/http', 'handlebars', 'jquery.validate', 'jquery.serialize', 'laydate', 'ztree', 'ztreeCheck'], function
    (layer, dataTable, util, http, handlebars) {


    init();
    /**
     * 初始化函数集合
     */

    function init() {

        ztreeInit();
        bind();
    }

    var treeObj = null;
    //权限树配置
    var treeSetting = {
        check: {
            enable: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        view: {
            fontCss: util.setHighlight // 高亮一定要设置，setHighlight是自定义方法
        },
        callback: {
            onClick: onClick
        }
    };

    /**
     * 点击触发事件
     */
    function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("permisionTree");
        var node = zTree.getSelectedNodes()[0];
        if (node.isParent == false) {
            httpClick(node.id);
        }
    }

    function httpClick(supCode) {

        http.httpRequest({
            url: '/reg/server/registinfo/registinfo/getStreetBynode',
            data: {supCode: supCode},
            success: function (data) {
                var liData = data.data;
                var lis = '';
                var check = '';
                if (liData == null) return;
                for (var i = 0; i < liData.length; i++) {
                    if ($('#code').val() == liData[i].code) {
                        check = 'checked';
                    } else {
                        check = '';
                    }
                    lis += '<div class="option-item"><label><input type="radio" name="code" '
                        + check + ' value="'
                        + liData[i].code + '"><span class="name">'
                        + liData[i].content + '</span></label></div>';
                }
                $('#optionlist').html(lis);
            }
        });
    }

    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/commom/server/regunit/treeRegUnitListJSON?isPermissionCheck=true',
            success: function (data) {
                var treeData = data.data;
                treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
                util.searchNode($('#supCode').val(), 'id', treeObj);
                httpClick($('#supCode').val());
            }
        });
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
                    if ($('#sliceNO').val() == '') {
                        layer.msg('请选择街道！', {time: 1000});
                        return false;
                    }
                    layer.close({
                        names: $('#content').val(),
                        codes: $('#code').val()
                    });
                }
            },
            {
                el: 'input[name="code"]',
                event: 'click',
                handler: function () {
                    var text = $(this).next().html();
                    var val = $(this).val();
                    $('#contentdiv').html(text);
                    $('#content').val(text);
                    $('#code').val(val);
                }
            },
            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    var _key = $('#_key').val();
                        util.searchNode($('#_key').val(),"name",treeObj,layer);
                }
            }
        ])
    }

})