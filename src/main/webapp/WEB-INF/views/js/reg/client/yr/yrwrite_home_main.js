require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.validate', 'jquery.serialize','component/backToTop'], function (layer, dataTable, util, http, handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        //浏览器滚动事件
      /*  $(window).scroll(function() {
            setIframeHeight(document.getElementById('_frame'));
        });*/

        if(document.addEventListener){
            document.addEventListener('DOMMouseScroll',rolling,false);
        }
        window.onmousewheel=document.onmousewheel=rolling;//IE/Opera/Chrome/Safari
        function rolling(){
            setIframeHeight(document.getElementById('_frame'));
        }

        initTabs();//初始化Tab
        bind();
    }

    /**
     * 初始化  选项tab切换报表填报
     */
    function initTabs(){
        //初始化的时候默认 获取列表第一个选项卡并添加上 calss = active 选中样式 和 src的值
        $(".tabs-nav").children(":first").addClass("active");
        var frist_url = $(".tabs-nav").children(":first").data("url");
        var iframe_url = frist_url;
        $("#_frame").attr("src",iframe_url);
        setIframeHeight(document.getElementById('_frame'));
        //点击选项触发事件
        $(".tabs-nav").find("._items").click(function(){
            //setIframeHeight(document.getElementById('_frame'));//每次点击的时候触发一次设置高度
            var $this = $(this);
            var currentClass = $this.attr("class");//当前选项值
            if(currentClass.indexOf('active')>0){ //表示当前选中的还是当前选项没有做变化
                //setIframeHeight(document.getElementById('_frame'));
                return;
            }
            //获取当前报表的状态文本值
            var text = $(".active").children("a").children("strong").text();
            if(text=='待填报'){
                layer.confirm('当前操作未进行提交保存会导致填写的数据丢失,是否继续？', {icon: 2, title: '提示'}, function (index) {
                    $this.addClass("active").siblings().removeClass("active");
                    var iframe_url = $this.data("url");
                    $("#_frame").attr("src",iframe_url);
                    setIframeHeight(document.getElementById('_frame'));
                    layer.close(index);
                });
                return;
            }else{
                $this.addClass("active").siblings().removeClass("active");
                var iframe_url = $this.data("url");
                $("#_frame").attr("src",iframe_url);
                setIframeHeight(document.getElementById('_frame'));
            }
        });
        /*延迟0.5秒进行执行 自适应ifream的高度*/
      /*  var timer = null;
        clearTimeout(timer);
        timer = setTimeout(function(){
            //setIframeHeight(document.getElementById('_frame'));
        },1000);*/
    };

    /*获取iframe自适应的高度和宽度 同时给 iframe设置高度和宽度*/
    function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };

    //触发事件 预览并提交年报
    function bind() {
        util.bindEvents([
            {
            el: '.btn-report',
            event: 'click',
            handler: function () {
                /*获取填报状态对象*/
                var arr= $(".tabs-nav").find("._items").children("a").children("strong");
                var num = 0;
                $.each(arr,function(i){if($(arr[i]).text()=='待填报'){num++;};});
                if(num>0) {
                    //layer.alert("您当前还有"+num+"未进行填报!",{icon:7});
                    layer.msg("您当前还有<font style='color: red;font-weight: bold'>"+num+"</font>个选项未进行填报!",{icon: 7,time: 1500});return;
                }
                //打开预览页面
                var url = window._CONFIG.preview_url + "?year=" + window._CONFIG.year + "&pripid=" + window._CONFIG.pripid;
                window.open(url);

                /**刷新首页 并关闭当前窗口操作 */
//                window.opener.location.reload();//刷新首页
//                var timer = null;
//                clearTimeout(timer);
//                timer = setTimeout(function(){
//                    window.close();//延迟0.5秒进行关闭
//                },500);
            }
           },{
           	 // 申请修改年报（6月30日后 或者 之前年度）
           	 el: '#modapply',
             event: 'click',
             handler: function () {
                var url = window._CONFIG.mod_url + "?year=" + window._CONFIG.year + "&pripid=" + window._CONFIG.pripid;
                window.open(url);
             }
           },{
          	// 修改年报（6月30日前）
          	el: '#mod',
            event: 'click',
            handler: function () {
            	http.httpRequest({
                    url: '/reg/client/yr/yrcommit/ent/modreport',
                    data: {year: window._CONFIG.year, pripid: window._CONFIG.pripid},
                    success: function (data) {
                        if (data.status == 'success') {
                        	layer.msg(data.msg, {time: 1000}, function () {
                            	location.assign('/reg/client/yr/yrwritehomepage/write_homepage?year=' + window._CONFIG.year + "&pripid=" + window._CONFIG.pripid);
                                return;
                            });
                        }else {
                        	layer.msg(data.msg, {time: 1000}, function () {
                                return;
                            });
                        }
                    }
                });
            }
          },
          {
              el: '#printReportProve',
              event: 'click',
              handler: function () {
                  var _id = "_doPrint_"+new Date().getTime();
                   var url = "/reg/client/yr/ent/pubprint/showEnAnnualReportProve?year="+window._CONFIG.year+"&pripid="+window._CONFIG.pripid;
                  try{
                      window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                  }catch(e){
                      alert("打印错误!");
                  } 
                  /*layer.dialog({
                      title: '打印年度报告证明',
                      area: ['100%', '100%'],
                      content: url,
                      callback: function (data) {
                          //重新加载列表数据
                          if (data.reload) {
                              table.ajax.reload();
                          }
                      }
                   })*/
              }
          },
          {
              el: '#printsfcReportProve',
              event: 'click',
              handler: function () {
                  var _id = "_doPrint_"+new Date().getTime();
                  // var url = "/reg/client/yr/sfc/yrprint?year="+window._CONFIG.year+"&pripid="+window._CONFIG.pripid;
                  var url = "/reg/client/yr/sfc/yrprint/printPubSfcPrintProve?year=2015&pripid=3301850000123981";
                  try{
                      window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                  }catch(e){
                      alert("打印错误!");
                  } 
                  /*layer.dialog({
                      title: '打印年度报告证明',
                      area: ['100%', '100%'],
                      content: url,
                      callback: function (data) {
                          //重新加载列表数据
                          if (data.reload) {
                              table.ajax.reload();
                          }
                      }
                   })*/
              }
          }
        ]);
    };

    //TODO 未能实现 另一种方案 在主页面进行confirm()确认框提示是否刷新操作
    //关闭窗口打叉 触发事件
  /* window.onbeforeunload = function(){
       //window.opener.location.reload();//刷新首页
       event.returnValue = function(){
           if(confirm("确定要清空数据吗？")) {
               return "true";
           }else{
               return "false";
           }
       }
    };*/

   /* window.onbeforeunload = function(){
            window.opener.location.reload();
            return "确定关闭!";
    };*/

    /*
     jQuery的写法：
        $(window).onbeforeunload(function (evt) {
             // 要执行的代码
        });
   */


});




