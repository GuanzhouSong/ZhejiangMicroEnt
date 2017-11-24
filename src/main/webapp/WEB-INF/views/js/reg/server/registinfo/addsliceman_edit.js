require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
        'jquery.validate', 'jquery.serialize', 'laydate', 'ztree', 'ztreeCheck'],
    function(layer, dataTable, util, http, handlebars) {

        init();
        /**
         * 初始化函数集合
         */

        function init() {
            formValid();
            ztreeInit();
            bind();
            initShow();
        }

        /**
         *户口建档页面 初始化管辖人员显示
         */
        function initShow() {
            if (_sliceMan.length < 1) return;

            var man = _sliceMan.split(",");
            var tel = _sliceTel.split(",");
            var show = '';
            for (var i = 0; i < man.length; i++) {
                show += ';' + man[i] + '  电话：' + tel[i];
            }
            $('#sliceManp').html(show.substr(1));
            //初始化checkbox的选中


        }
        //树对象
        var treeObj = null;

        var selectedCode=new Object();

        var treeSetting = {
            view: {
                dblClickExpand: true,
                fontCss: util.setHighlight // 高亮一定要设置，setHighlight是自定义方法
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: 'deptDID',
                    pIdKey: 'deptPID',
                    rootPId: ''
                }
            },
            check: {
                enable: false
            },
            callback: {
                onClick: function (event, treeId, treeNode) {
                    httpClick(treeNode);
                }
            }
        };
        /**
         * 部门树
         */
        function ztreeInit() {
            //加载部门树
            http.httpRequest({
                type: 'post',
                url: '/common/system/dept/tree/treeData.json',
                success: function (data) {
                    if (data.status == 'success') {
                        //初始化权限树
                        treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, data.data);
                       // util.searchNode($('#supCode').val(),'id',treeObj);
                    }
                }
            });
        }

        //根据点击树的node，加载下面的数据
        function httpClick(treeNode) {
            
            if(treeNode.isParent==false){
                $('#localAdmNamep').html(treeNode.name);
            }
            http.httpRequest({
                url: '/reg/server/registinfo/registinfo/getsliceManByDept',
                data: {
                    deptCode: treeNode.id
                },
                success: function(data) {
                    var liData = data.data;
                    var lis = '';

                    var sliceMan_ = $('#sliceMan').val().split(',');
                    if (liData == null) return;

                    for (var i = 0; i < liData.length; i++) {
                        var check = '';
                        for (var j = 0; j < sliceMan_.length; j++){
                            if (sliceMan_[j] == liData[i].realName) {check = 'checked';
                                break;
                            }

                        }
                        var tel = '';
                        if (liData[i].phoneExt != null) tel = liData[i].phoneExt;
                        var name = '';
                        if (liData[i].realName != null) name = liData[i].realName;

                        lis += '<label><input type="checkbox" class="codesliceno"' + check + ' value="' + liData[i].id + '"><span class="name">' + name + '</span>  电话:<span>' + tel + '</span></input></label></br>';

                    }
                    $('#optionlist').html(lis);
                }
            });
        }



        /**
         * 表单验证
         */
        function formValid() {

            $('#registInfoForm').validate({
                submitHandler: function() {
                    if ($('#sliceMan').val() == "") {
                        layer.msg("请选择管辖人员！", {
                            time: 1000
                        });
                        return false;
                    }
                    if($('#sliceMan').val().length>250||$('#sliceTel').val().length>250){
                        layer.msg("管辖人员不能选择太多！", {
                            time: 1000
                        });
                        return false;
                    }
                    layer.close({
                        sliceManShow: $('#sliceManp').html(),
                        sliceTel: $('#sliceTel').val(),
                        sliceMan: $('#sliceMan').val()
                    });
                }
            })
        }

        function bind() {
            util.bindEvents([{
                el: '#cancel',
                event: 'click',
                handler: function() {
                    layer.close();
                }
            },
                {
                    el: '#checkAll',
                    event: 'click',
                    handler: function() {
                        var flag = $(this).prop("checked");
                        $(".codesliceno").prop("checked", flag);
                        checkTxt();
                    }
                },
                {
                    el: '.codesliceno',
                    event: 'click',
                    handler: function() {
                        checkTxt();
                    }
                },
                {
                    el: '#qry',
                    event: 'click',
                    handler: function() {
                        var _key = $('#_key').val();

                            util.searchNode($('#_key').val(),"name",treeObj,layer);
                    }
                }

            ])
        }

        //根据checkbox的值展示已选择的内容
        function checkTxt() {
            var allChecked = '';
            var allCheckedVal = '';
            var manTelForShow = '';
            $('.codesliceno:checked').each(function() {
                var sliceMan = $(this).next().html();
                var sliceTel = $(this).next().next().html();
                allChecked += "," + sliceMan;
                allCheckedVal += "," + sliceTel;
                manTelForShow += ';' + sliceMan + '  电话：' + sliceTel + '  ';
            });
            $('#sliceManp').html(manTelForShow.substr(1));
            $('#sliceMan').val(allChecked.substr(1));
            $('#sliceTel').val(allCheckedVal.substr(1));
        }
    })