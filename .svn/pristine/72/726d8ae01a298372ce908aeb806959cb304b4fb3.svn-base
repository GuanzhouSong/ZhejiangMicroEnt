/**
 * Created by Administrator on 2016/9/30.
 */
define(['component/iframeLayer','common/http'],function(layer,http){
//tab 切换
    function _SfcTabs(obj){
        var $this = $(obj);
        //获取当前对象父节点并获取父节点的class属性值
        var currentClass = $this.parent().attr("class");
        if(currentClass.indexOf('active')>0){ //表示当前选中的还是当前选项没有做变化
            return;
        }

        //获取当前页面选中的表单填报状态是 【待填报】 还是 【已填报】
        var text = $(".active").children("a").children("strong").text();
        if(text=='待填报'){
            layer.confirm('离开当前页面将导致未保存情况下填写的数据丢失，是否确定要继续离开', {icon: 7, title: '提示'}, function (index) {
                //本页面跳转
                window.location = $this.data("url");
                layer.close(index);
            });
        }else{
            // 本页面跳转
            window.location = $this.data("url");
        }
    }

    //提交年报
    function sfc_report(obj){

        layer.confirm('您确定进行上报?', { btn: ['确定', '取消'],icon: 7, title: '温馨提示'}, function (index) {
            /*获取填报状态对象*/
            var arr= $(".tabs-nav").find("._items").children("a").children("strong");
            var num = 0;
            $.each(arr,function(i){if($(arr[i]).text()=='待填报'){num++;};});
            if(num>0) {
                layer.msg("您当前还有<font style='color: red;font-weight: bold'>"+num+"</font>个选项未进行填报!",{icon: 7,time: 1500});
                return;
            }
            var $this = $(obj); //获取当前选中的对象
            var year = $this.data("year");//获取年份
            var priPID = $this.data("pripid");//获取主体身份代码
            http.httpRequest({
                url: '/reg/client/yr/yrcommit/sfc/declStatus',
                serializable: false,
                data: {'year':year,'priPID':priPID},
                type: 'post',
                success: function (data) {
                    if(data.status=='success'){
                        layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                            window.location.reload();//延迟重新刷新页面
                        });
                    }else if(data.status=='fail'){
                        layer.msg(data.msg, {icon: 2,time: 1000});
                    }

                }
            });
            layer.close(index);
        });





    }
    window._SfcTabs = _SfcTabs;
    window.sfc_report = sfc_report;

});







