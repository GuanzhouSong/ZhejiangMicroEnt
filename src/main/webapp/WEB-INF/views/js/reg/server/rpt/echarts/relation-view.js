/**
 * Created by Administrator on 2017-07-12.
 */
require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'echarts3',
    'jquery.serialize'
], function (layer, util, http,echarts) {

    var myChart = echarts.init(document.getElementById('main_rel'));
    myChart.showLoading({text: "加载中，请稍后..."});
    var option = {
        baseOption: {
            legend: {
                data: ['个人', '企业'], left: 10, top: 0, show: false
            },
            toolbox: {
                show: true,
                left: 10,
                top: 1,
                feature: {
                    restore : {show: true}
                }
            },
            tooltip : {  // 提示语  就是鼠标移动上去就会显示文本内容
                trigger: 'item',
                formatter: function (params,ticket,callback) {
                    if(params.data.nodeName){return params.data.nodeName;}
                }
            },
            series: [{
                type: 'graph',
                layout: 'force',
                circular: {
                    rotateLabel: true
                },
                top: '10%',
                left: 'center',
                width: '72%',
                roam: true,
                scaleLimit: {max: 2.8, min: 0.6},
                categories: [{
                    "name": '关系'
                }, {
                    "name": '个人'
                }, {
                    "name": '企业'
                }],
                force: {
                    repulsion: 110,
                    edgeLength: 110,
                    gravity: 0.1
                },
                symbolSize: 13,
                edgeSymbol: ['circle', 'arrow'],
                edgeSymbolSize: [1, 6],
                draggable: true,
                focusNodeAdjacency: true,
                animationDuration: 500,
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        rotate: 90,
                        formatter: function (params, ticket, callback) {
                            if (typeof(params.data.label) == 'undefined') {
                                return params.data.relation;
                            } else {
                                return params.data.label;
                            }
                        },
                        textStyle: {
                            color: '#333'
                        }
                    }
                },
                lineStyle: {
                    normal: {
                        curveness: 0.1,
                        color: '#03B26E',
                        width: 1
                    }
                }
            }]
        },
        //适应性动态布局设置
        media: [{
            query: {
                maxWidth: 800,
                maxAspectRatio: 1
            },
            option: {
                legend: {
                    data: ['个人', '企业'], left: 10, top: 0
                },
                series: [
                    {
                        top: -160,
                        width: '72%',
                        left: 'center'
                    }
                ]
            }
        }
        ]
    };


    var jsonData =getJsonData();
    //默认加载
    draw(jsonData);

    //异步获取数据
    function getJsonData(){
        var params = $('#js-params').serializeObject();//查询参数
        var datas;
        //同步请求
        http.httpRequest({
            url: '/reg/server/rptyr/relationnetall/getJsonData',
            serializable: false,
            data:{params:params},
            type: 'post',
            async:false,
            success: function (data) {
                if(data.status=='success') {
                    datas = data.data;
                }else if(data.status=='fail'){}
            },
            error:function(){
                layer.msg('系统异常，请重新登录尝试!');
            }
        });
        return datas;
    }

    //层级选择
    $('#js-cengji').on('change',function(){
        var $this = $(this);
        if($(this).val()){
            if($this.val()=='1'){
                $("#isGxcsSlt").val('1');
                drawView();
            }else{
                $("#isGxcsSlt").val('2');
                drawView();
            }
        }
    });
    //关系类型
    $('#js-people-type').on('change',function(){
        var $this = $(this);
        if($(this).val()){
            if($this.val()=='1'){
                $("#js-nodeType").val('1');drawView();
            }else if($this.val()=='2'){
                $("#js-nodeType").val('2');drawView();
            }else if($this.val()=='3'){
                $("#js-nodeType").val('3');drawView();
            }
        }
    });
    //执行方法
    function drawView(){
        jsonData = getJsonData();
        draw(jsonData);
    }

    //切换关系圈图
    $(".js-relation").on('click',function(){
        var $this  = $(this);
        $this.data('layout')=='circular'? option.baseOption.series[0].layout='circular':option.baseOption.series[0].layout='force';
        draw(jsonData);
    });


    //加载解析数据
    function draw(data) {
        option.baseOption.series[0].data = doGetNodesJson(data[0]);
        option.baseOption.series[0].links = doGetWrapLinksJson(data[1]);
        if (data[0].length <= 30) {
            option.baseOption.series[0].symbolSize = 18;
        }
        myChart.hideLoading();
        myChart.setOption(option);
    };

    //去除name为空或者重复的节点
    function doGetNodesJson(nodes){
        var tempNodes=[], obj={}, key="";
        $.each(nodes,function(i,n){
            if(n.name!=""){
                key=n.name;
                if(obj[key]==undefined){
                    tempNodes.push(n);
                    obj[key]="1";
                }
            }
        });
        return tempNodes;
    }

    //根据优先级设置线条颜色
    function doGetWrapLinksJson(links){
        var tempLinks = [];
        var flag =true, name="";
        $.each(links,function(i,n){
            if(n.target==""){
                return true;
            }
            $.each(tempLinks,function(j,m){
                if(n.source==m.source && n.target==m.target){
                    flag = false;
                    name=n.relation;
                    //为""说明之前有读到法人关系
                    if(m.lineStyle==""){
                        return false;
                    }
                    //现在读到法人关系
                    if(name=='法定代表人关系'){
                        m.lineStyle="";
                        return false;
                        //股东并且之前没有读到过法人关系
                    }else if(name.substring(0,2)=='股东'&&m.relation!='法定代表人关系'){
                        m.lineStyle.normal.color="red";
                        return false;
                    }
                }else{
                    flag =true;
                }
            });
            if (flag && i>0) {
                tempLinks.push(n);
            }
            if(i==0) tempLinks.push(n);
        });
        return tempLinks;
    }

});
