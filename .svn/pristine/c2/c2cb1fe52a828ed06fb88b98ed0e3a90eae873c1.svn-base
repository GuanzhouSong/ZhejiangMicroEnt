require(['component/iframeLayer', 'component/dataTable','common/util',
'common/http', 'handlebars', 'jquery', 'select2','jquery.serialize','laydate', 'jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        formValid();

    }
    /**
     * 表单验证
     */
    function formValid() {
        $('#infoForm').validate({
            submitHandler: function () {
                var formParam = $('#infoForm').serializeObject();
                formParam.adminguidecercontent=sumContent(formParam.adminguideitem);
                //更改各种审核状态和其他送达方式
                formParam=changeState(formParam);
                http.httpRequest({
                    url: '/reg/server/govguide/govguide/modi',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
            }
        })
        };
    function bind() {
        util.bindEvents([
//        {
//                    el: '.printspbook',
//                    event: 'click',
//                    handler: function () {
//                     	var busExcList=this.id;
//                   	    var _id = "_doPrint_"+new Date().getTime();
//                        var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+busExcList;
//                        try{
//                            window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
//                        }catch(e){
//                            alert("打印错误!");
//                        }
//                    }
//                },
{
    el: '#print',
    event: 'click',
    handler: function () {
      var fromtype='print';
      var _id = "_doPrint_"+new Date().getTime();
      var url='/reg/server/govguide/govguide/toAdd?fromtype='+fromtype+'&uid='+$('input[name="uid"]').val()+'&pripid=&entname=';
      try{
           window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
      }
      catch(e){
           alert("打印错误!");
      }

  }
},
{
                    el: '#choose',
                    event: 'click',
                    handler: function () {
                    layer.dialog({
                        title: '选择许可证',
                        area: ['428px', '400px'],
                        content: '/reg/server/govguide/govguide/toLicence',
                        callback: function (data) {
                        $('#adminguidecercontent-3-name').val(data.name);
                        $('#adminguidecercontent-3-code').val(data.code);
                        }
                    });
                    }
},
 {
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                       layer.close();
                     }
                 },
 {
        el: '#adminguideitem',
        event: 'change',
        handler: function () {
        var item = $('#adminguideitem option:selected').val();
        $('#adminguidecercontent-'+item).attr('style','display:block');
        for(var i=1;i<7;i++){
         if(item!=i){
         $('#adminguidecercontent-'+i).attr('style','display:none');
         }
        }
    }
 }
])
    }

//计算内容
function sumContent(item){
        var txt='';
        $('.adminguidecercontent-'+item).each(function(){
        txt+=$(this).val()+"&";
        });
        return txt;
}

function changeState(formParam){
    //如果是退回修改保存后提交，把审核状态改成未审核
    if(_fromtype=='backmodi'){
     formParam.auditstate='0';
    }
    //保存送达方式
    var type='';
    $('input[name="othernoticetype"]:checked').each(function(){
    type+=','+$(this).val();
    });
    formParam.othernoticetype=type.substr(1);
    return formParam;
     }
})
