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
        file = $('#js-file-btn').val();
        if(file == '') {
            layer.tips("请先选择要上传的文件!",$("#js-file-btn"),{tips:3, tipsMore:true, ltype:0});
            return;
        }
        if(file.indexOf('.xlsx') != -1 || file.indexOf('.xls') != -1){
        	var taskUid = $("#taskUid").val();
        	var userType = $("#userType").val();
        	var url = '/reg/server/specialrec/ent/export';
        	if(userType == '2'){
        		url = '/syn/server/specialrec/ent/export';
        	}
        	var indexLayer = layer.msg('导入中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
        	$.ajaxFileUpload({
        		url: url,
        		type: 'post',
        		data: {"fileName":file,"taskUid":taskUid},
        		secureuri: false,
        		fileElementId: 'js-file-btn',
        		dataType: 'json',
        		success: function(data){
        			if(data.status == 'success') {
    					layer.msg("导入成功", {time: 1000}, function () {});
        			}else{
        				layer.alert(data.message);
        			}
        			layer.close({reload: true,reTaskUid:data.reTaskUid});
        			indexLayer.close(index);
        		}
        	});
        }else{
        	layer.msg('只能导入excel文件!', {time: 800});
        	$('#js-file-btn').val("");
        	$('#js-excel-file').val("");
        }
    }
});
