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
            	layer.close({reload: false});
            }
        },{
            el: '#js-download',
            event: 'click',
            handler: function() {
            	
            }
        }]);
    }

    function _upload() {
//        layer.msg('处理中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
        file = $('#js-file-btn').val();
        if(file == '') {
            layer.tips("请先选择要上传的文件!",$("#js-file-btn"),{tips:3, tipsMore:true, ltype:0});
            return;
        }
        if(file.indexOf('.xlsx') != -1 || file.indexOf('.xls') != -1){
        	var taskNO = $("#taskNO").val();
        	$.ajaxFileUpload({
        		url: '/syn/pub/server/drcheck/pubscinfoback/addbatch',
        		type: 'post',
        		data: {"fileName":file,"taskNO":taskNO},
        		secureuri: false,
        		fileElementId: 'js-file-btn',
        		dataType: 'json',
        		success: function(data){
        			if(data.status == 'success') {
        				layer.msg("导入成功", {time: 1000}, function () {
        					layer.close({reload: true});
        				});
        			}else{
        				layer.msg("导入失败,请确认excel数据是否正确有效！", {time: 2000}, function () {
        					$('#js-file-btn').val("");
        		        	$('#js-excel-file').val("");
        				});
        			}
        		}
        	});
        }else{
        	layer.msg('只能导入excel文件!', {time: 800});
        	$('#js-file-btn').val("");
        	$('#js-excel-file').val("");
        }
    }
});
