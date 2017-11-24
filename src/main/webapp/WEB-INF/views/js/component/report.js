/**
 * Created by Administrator on 2016/9/30.
 */
define(['component/iframeLayer','common/http'],function(layer,http){
//tab 切换
    function _Tabs(obj){
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


    function _report(obj){
        var $this = $(obj);
        var year = $this.data("year");
        var priPID = $this.data("pripid");

        /*获取填报状态对象*/
        var arr= $(".tabs-nav").find("._items").children("a").children("strong");
        var num = 0;
        $.each(arr,function(i){if($(arr[i]).text()=='待填报'){num++;};});
        if(num>0) {
            layer.msg("您当前还有<font style='color: red;font-weight: bold'>"+num+"</font>个选项未进行填报!",{icon: 7,time: 3000});
            return;
        }

        //党员判断
        var _otherinfo = $("#_qt_").val();
        if(_otherinfo=='otherinfo'){
            var dangyuanData = dangyuan(year,priPID); // 党员判断
            if(dangyuanData.status=='fail'){
                layer.alert("<em style='color: red'>"+dangyuanData.msg+"</em>",{icon: 7});
                return;
            }
        }

        //出资情况判断
        var _subcapital = $("#_cz_").val();
        if(_subcapital=='subcapital'){               //判断页面是否有出资情况
            var chuzhiData = chuzhi(year,priPID);     //出资金额的判断
            if(chuzhiData.status=='fail'){
                layer.confirm('你企业的认缴出资总额与企业注册资本额不符,返回【出资情况】修改点击【取消】按钮,继续【预览并提交年报】点击【确认】', { btn: ['确定', '取消'],icon: 7, title: '提示'}, function (index) {
                     _url();//跳转页面
                    layer.close(index);
                });
            }else{
                _url();//跳转页面
            }
        }else{
            _url();
        }
    }
    // 预览并提交年报  跳转方法
    function _url(){
        var _value = $("#_reportState").val();  //获取年报状态
        if(_value=='13'||_value=='20'){         //待修改状态下的时候特殊处理
            layer.confirm('请确认每个填报页面是否都已经进行<em style="color: red">【保存】</em>操作？', {icon: 3, title: '提示'}, function (index) {
                var preview_url = $("#preview_url").val();
                window.open(preview_url);
                layer.close(index);
            });
        }else{
            //年报预览
            var preview_url = $("#preview_url").val();
            window.open(preview_url,"newwindow");
        }
    }

    //判断  党员人数和企业从业人数的大小比对
    function dangyuan(year,priPID){
        var dataObj ;
        http.httpRequest({   //判断  党员人数和企业从业人数的大小比对
            type: "POST",
            url: "/reg/client/yr/ent/yrotherinfo/check",
            data: {'year':year,'priPID':priPID},
            async:false, //同步
            success: function (data) {
                dataObj = data;
            }
        });
        return dataObj
    }

    //出资情况 的金额判断
    function  chuzhi(year,priPID){
        var dataObj ;
        http.httpRequest({   //判断
            type: "POST",
            url: "/reg/client/yr/ent/subcapital/checkMoney",
            data: {'year':year,'priPID':priPID},
            async:false, //同步
            success: function (data) {
                dataObj = data;
            }
        });
        return dataObj
    }


// 修改年报（6月30日前）
    function _mod(obj){
    	var $this = $(obj);
        var year = $this.data("year");
        var pripid = $this.data("pripid");
    	layer.confirm('确定修改年度报告？', {icon: 3, title: '提示'}, function (index) {
            http.httpRequest({
                url: '/reg/client/yr/yrcommit/ent/modreport',
                data: {'year':year,'pripid':pripid},
                success: function (data) {
                    if(data.status=='success'){ //返回值为真
                        layer.msg(data.msg, {icon: 1, time: 1000}, function () {location.reload();}); //重新加载页面
                    }else {
                        layer.msg(data.msg, {icon: 1,time: 1000}, function () {return;});
                    }
                }
            });
            layer.close(index);
        });
    }
    window._Tabs = _Tabs;
    window._report = _report;
    window._mod = _mod;
});







