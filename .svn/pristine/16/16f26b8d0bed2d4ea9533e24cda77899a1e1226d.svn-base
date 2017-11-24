require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    
    $("#modelExcel").click(function(){
    	alert("暂不支持模板下载！");
    })

    function bind() {
        util.bindEvents([{
          el: '.js-import', 
          event: 'click',
          handler: function () {
                  var _file = $("#js-file").val(); 
                  if (!_file) {
                      layer.msg("请上传Excel模板文件!", {icon: 7, time: 3000});
                      return;
                  } else {
                	  //判断是否是Excel文件
                      var ext = _file.toLowerCase().substr(_file.lastIndexOf("."));
                      if (!(ext == ".xls" || ext == ".xlsx" || ext == ".xlsm")) {
                          layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                          return;
                      }
                  }
                  if($("input[name ='districtType']:checked").length < 1){
                	  alert("请先选择导入的地区");
                	  return false;
                  }
                  var index;
                  index = layer.msg('导入中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                  $("#file_import").ajaxSubmit({
                      type: 'post',
                      url: '/hz/pubdtinfo/addbatch',
                      data: $("#file_import").serialize(),
                      dataType: 'json',
                      cache: false,
                      success: function (data) {
                          if (data.status == 'success') {
                        	  if(data.errorInfo == "" || data.errorInfo == null){
                        		  layer.msg("导入成功", {time: 1500}, function () {
                                	  $("#js-file").val("");
                                  });
                        	  }else{  
                    		      var returnInfo = data.errorInfo.split("，");
                    		      var errorInfo = "";
                    		      for(var i=0;i<returnInfo.length;i++){
                    		    	  errorInfo = errorInfo +(i+1)+'.'+returnInfo[i]+'</br>'
                    		      }
                    		      layer.alert("一共有"+returnInfo.length+"条数据导入失败，详细信息：</br><span style='color:red'>"+errorInfo+"</span>&nbsp;");
                            	  $("#js-file").val("");
                        	  }
                          }else{
                        	  layer.msg("导入失败", {time: 1000}, function () {});
                          }
                          layer.close(index);
                          $("#search").click()
                      }
                  });
	           }
	      }])
    }

})
