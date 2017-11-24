require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate', 'common/ajaxfileupload'], function (layer, dataTable, util, http,handlebars) {
    var file;

    init();

	function init() {
        _bind();
    }

    function _bind() {
        util.bindEvents([{
            el: '#js-upload',
            event: 'click',
            handler: function () {
                _upload();
            }
        },{
            el: '#js-file-btn',
            event: 'change',
            handler: function () {
                var filename=$('#js-file-btn').val()
                $('#js-excel-file').val(filename);
            }
        },{
            el: '.js-ipt-btn',
            event: 'click',
            handler: function () {
               $('#js-file-btn').trigger('click')
            }
        },{
            el: '#js-cancel',
            event: 'click',
            handler: function() {
                window.location.href = '/depsyn/excel/template';
            }
        }]);
    }

    function _upload() {
        layer.msg('处理中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
        file = $('#js-file-btn').val();
        if(file == '') {
            layer.msg('请先选择要上传的文件!', {time: 800});
            return;
        }
        $.ajaxFileUpload({
            url: '/depsyn/excel/license/upload',
            type: 'post',
            data: {"fileName":file},
            secureuri: false,
            fileElementId: 'js-file-btn',
            dataType: 'json',
            success: function(data){
                layer.closeAll();
                if(data.status == 'success') {
                    layer.alert('上传成功', {icon: 1, closeBtn: false}, function(){
                        window.location.href = '/depsyn/excel/license/toaddbatch';
                    });
                }
            },
            error: function(data, status){
                layer.alert('上传失败', {icon: 2, closeBtn: false});
            }
        });
    }
});
