/**
 * Created by wangjin on 2017-06-13.
 */
require([
    'component/iframeLayer',
    'component/dataTable',
    'common/util',
    'common/http',
    'laydate',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize'
], function (layer,dataTable, util, http) {

    init();//初始化

    function init(){
        bind();
    }



    //触发事件
    function bind() {
        util.bindEvents([
            {
                el: '#writ_list',  //选中文书的类别
                event: 'change',
                handler: function () {
                    var writ_uuid = $(this).val();
                    http.httpRequest({
                        url: '/reg/server/writ/getWritData',
                        serializable: false,
                        data: {'uuid':writ_uuid},
                        type: 'post',
                        success: function (data) {
                            var jsonData = data.data;
                            if(jsonData){
                                $("#js-wh").text(jsonData.writNo);
                                $("#js-wslb").text(jsonData.writType);
                                $("#js-wsmc").text(jsonData.writName);
                                $("#js-tzdx").text(jsonData.noticePeople);
                                jsonData.writReceiveStatue=='1'? $(".js-wszt").text('已回执').css('color','green'):$(".js-wszt").text('未回执').css('color','red');
                                $("#js-view-details").attr("uuid",jsonData.uuid);//uuid
                            }
                        }
                    });
                }
            },
            {
              el:'#js-view-details', //查看详情
              event:'click',
                handler:function(){
                    var uuid = $(this).attr('uuid');
                    var pripid = $(this).attr('pripid');
                    var url = "uuid="+uuid+"&priPID="+pripid;
                    //window.open ("/reg/server/writ/promptly_writ?"+url);
                    layer.dialog({
                        title: '',
                        area: ['90%', '90%'],
                        content:"/reg/server/writ/promptly_writ?"+ url
                    });
                }
            }

        ]);
    }
});