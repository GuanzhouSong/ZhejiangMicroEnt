/**
 * Created by Administrator on 2017-07-24.
 */
require(['component/iframeLayer','common/util','common/http','echarts','jquery.serialize'], function (layer, util, http,echarts) {

    /**
     * ajax同步获取数据 公共请求
     * @param id  对象id
     * @param params  //查询参数值
     * @param url     //请求路径
     * @param callback
     * @param tab_params  //可变参数 一般用于修改文字和颜色
     */
    function ajaxRequest(id,params,url,callback){
        var $myChart = null;
        if(id){
            $myChart = echarts.init(document.getElementById(id));
            $myChart.showLoading({ text: '加载中...', color: '#c23531', textColor: '#000', maskColor: 'rgba(255, 255, 255, 0.2)', zlevel: 0,effect : 'whirling' });
        }
        http.httpRequest({
            url: url,
            serializable: false,
            data:{params:params},
            type: 'post',
            async:true, //异步
            beforeSend: function () { //覆盖阴影层
                //layer.msg('年报提交时数据处理可能比较慢,请您耐心等待,请勿关闭浏览器!', {icon: 16, time: -1, shade: [0.4, '#CCC']});
            },
            success: function (data) {
                if (data.status == "success") {
                    if($myChart){$myChart.hideLoading();}  //隐藏加载层
                    if(callback)callback.call(this,data,$myChart,params,id);
                }
            },
            error:function(){layer.msg("系统异常,请联系管理人员!")}
        });
    }
    
    function areacodeList(str) {
        if (str == "3300") {
            return "省局";
        } else if (str == "3301") {
            return "杭州";
        } else if (str == "3302") {
            return "宁波";
        } else if (str == "3303") {
            return "温州";
        } else if (str == "3304") {
            return "嘉兴";
        } else if (str == "3305") {
            return "湖州";
        } else if (str == "3306") {
            return "绍兴";
        } else if (str == "3307") {
            return "金华";
        } else if (str == "3308") {
            return "衢州";
        } else if (str == "3309") {
            return "舟山";
        } else if (str == "3310") {
            return "台州";
        } else if (str == "3325") {
            return "丽水";
        } else {
            return "";
        }
    }


//############################################# tab1 主体发展情况 ################################################################

    //模块结构图封装：
    var tab1_model = (function CoolModel() {
        //在册总数
        function totalNum (jsonData,$myChart,params,id){
            try{
                var $jsonData = jsonData.data;
                if(!$jsonData){ return; }
                for(var i=0;i<$jsonData.length;i++){
                    $('#tab1_num').find('span').eq(i).text($jsonData[i]);
                }
            }catch (err){
                window.console && console.log(err);
            }
        }
        // tab1_0 饼图
        function myChart1_0(jsonData,$myChart,params,id) {
            var $jsonData = jsonData.data;
            if(!$jsonData){return;}

            //数据转换
            var qy = '企业：'+$jsonData.entNormal+'户';
            var nz = '农专：'+$jsonData.fcNormal+'户';
            var gt = '个体：'+$jsonData.pbNormal+'户';
            //数据封装
            var jsonData = {
                legend_data:[qy,nz,gt],
                datas:[
                    {value: $jsonData.entNormalRate, name: qy},
                    {value: $jsonData.fcNormalRate, name: nz},
                    {value: $jsonData.pbNormalRate, name:gt}]
            };
            try {
                var option1_0 = {
                    tooltip: {
                        trigger: 'item',  //鼠标移入触发的浮动层
                        formatter: "{b} 所占比例：{d}%"
                    },

                    legend: {
                        orient: 'vertical',
                        left:'left',
                        top: 'middle',
                        data:jsonData.legend_data,
                        selectedMode:false //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                    },
                    color:['#5B9CD5','#70AD46','#ED7D31'],//默认显示的颜色
                    series: [
                        {
                            backgroundColor: '#fff',
                            name:'年报在册情况',
                            type:'pie',
                            radius: ['30%', '80%'],
                            //selectedMode: 'single',//单列
                            avoidLabelOverlap: false,

                            label: {
                                normal: {
                                    show:true,//是否显示
                                    position: 'right',//位置  文字描述显示的位置    inner : 在内部
                                    formatter:'{d}%'//获取值 模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。

                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',//字体大小  鼠标移入显示的
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: true, //是否显示线
                                    length:5
                                }
                            },
                            data:jsonData.datas
                        }
                    ]
                };
                $myChart.setOption(option1_0);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab1_1 主体年增长情况
        function myChart1_1(jsonData,$myChart,params,id) {
            try {

                var $datas = jsonData.data;
                if(!$datas){ return; }
                var $jsonData = { xdata: [], valueData: [], rate: [] /*增长率*/};
                //年份
                for(var i in $datas){$jsonData.xdata.push($datas[i].year);}
                for(var i in $datas){$jsonData.valueData.push($datas[i].normal);}

                $jsonData.rate.push(0);
                var _leng = $datas.length;
                for (var i = 0; i < _leng - 1; i++) {
                    var a = $datas[i].normal;
                    var b = $datas[(i + 1)].normal;
                    var rate = (Math.round((b - a) / a * 10000) / 100.00);
                    $jsonData.rate.push(rate);
                }

                var option1_2 = {
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    legend: {
                        x: '76%',
                        top: '2%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: ['户数', '增长率']
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        top: 80,
                        bottom: 95
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示年份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show:true,
                            lineStyle: {
                                color: '#90979c' // x 轴线最下面的横坐标线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: true //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0,
                            formatter:function (value) {
                                return  value> 0 ? value : '';
                            }
                            //rotate:40  //倾斜显示*/
                        },
                        data:$jsonData.xdata
                    }],
                    yAxis: [
                        {
                            name: '单位：户',
                            type: "value",
                            splitLine: {
                                show: true   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            axisLine: {
                                show: false, // y 轴竖线   false：不显示 true：显示
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLabel: {
                                interval: 0

                            },
                            splitArea: {
                                show: false
                            },
                            splitNumber: 10  //分段数目 竖向
                        },
                        {
                            type: 'value',
                            name: '增长率',
                            position: 'right',
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLine: {    // y 轴竖线   false：不显示 true：显示
                                show:false,
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            splitLine: {
                                show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                            },
                            axisLabel: {
                                formatter: '{value}%'
                            }
                        }


                    ],
                    series: [
                        {
                            name: "户数",
                            type: "bar",
                            symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            symbolSize:12,
                            barMaxWidth: 20,
                            barWidth : 12,//柱图宽度
                            //barGap:'-100%',
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: $jsonData.valueData
                        },
                        {
                            name: "增长率",
                            type: "line",
                            barMaxWidth: 20,
                            barWidth : 12,//柱图宽度
                            yAxisIndex: 1,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    //barBorderRadius: 10,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: '{c}%'
                                    }
                                }
                            },
                            //z:-12,//显示的层级
                            data:$jsonData.rate
                        }
                    ]
                };
                $myChart.setOption(option1_2);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab1_2 在册主体分部 地图
        function myChart1_2(jsonData,$myChart,params,id) {
            try {
                var $datas = jsonData.data;
                if(!$datas)return;
                //给表格中赋值
                for(var i=0;i<$datas.length;i++){$('#tab1-city-num').find('.city').eq(i).text($datas[i].normal);}

                var numValue = [];
                for(var i=1;i<$datas.length;i++){ numValue.push($datas[i].normal); }

                //数据的封装
                var $jsonData = {
                    cityData: [
                        {name: '杭州市', value: $datas[1].normal}, { name: '宁波市', value: $datas[2].normal}, {name: '温州市', value: $datas[3].normal},
                        {name: '嘉兴市', value: $datas[4].normal}, { name: '湖州市', value: $datas[5].normal}, {name: '绍兴市', value: $datas[6].normal},
                        {name: '金华市', value: $datas[7].normal}, { name: '衢州市', value: $datas[8].normal}, {name: '舟山市', value: $datas[9].normal},
                        {name: '台州市', value: $datas[10].normal},{ name:'丽水市',  value: $datas[11].normal}
                    ],
                    max:Math.max.apply(null, numValue),
                    min:Math.min.apply(null, numValue)
                };
                var uploadedDataURL = "/js/reg/server/charts/json/zhejiang.json";  //json 格式数据
                // 基于准备好的dom，初始化echarts实例
                var $myChart = echarts.init(document.getElementById('chart1_2'));
                $.get(uploadedDataURL, function(chinaJson) {
                    echarts.registerMap('浙江', chinaJson);
                    $myChart.setOption({
                        tooltip: {
                            trigger: 'item',  //鼠标移入触发的浮动层
                            formatter: "{b},{c}"
                        },
                        legend: {
                            show:true,
                            orient: 'vertical',
                            left: 'left',
                            data:[]
                        },
                        visualMap: {
                            show:true, //默认显示
                            x:'20%',
                            min: $jsonData.min,
                            max: $jsonData.max,
                            text:['多','少'],
                            realtime: false, //拖拽时，是否实时更新。
                            calculable: false, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。true  默认显示
                            align:'left', // 针对的是calculable的拖拽图标的位置
                            inverse:false,  //是否反转 visualMap 组件。  当inverse为false时，数据大小的位置规则，和直角坐标系相同，即：当 visualMap.orient 为'vertical'时，数据上大下小。当 visualMap.orient 为'horizontal'时，数据右大左小。当inverse为true时，相反。
                            orient: 'horizontal', //横向显示
                            inRange: {
                                /*color: ['lightskyblue','yellow', 'orangered']*/
                                color : [ '#FFF800','#FEC200']
                            }
                        },
                        series: [{
                            type: 'map',
                            map: '浙江',
                            selectedMode:'single',
                            itemStyle:{
                                normal:{
                                    label:{
                                        show:true
                                    }
                                },
                                emphasis:{
                                    areaColor: 'yellow',
                                    label:{
                                        show:true
                                    }
                                }
                            },
                            data:$jsonData.cityData
                        }]
                    });
                });
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab1_3 企业年增长情况
        function myChart1_3(jsonData,$myChart,params,id) {
            try {

                var $datas = jsonData.data;
                if(!$datas){ return; }
                var $jsonData = { xdata: [], valueData: [], rate: [] /*增长率*/};

                //年份
                for(var i in $datas){$jsonData.xdata.push($datas[i].year);}
                for(var i in $datas){$jsonData.valueData.push($datas[i].normal);}

                $jsonData.rate.push(0);
                var _leng = $datas.length;
                for (var i = 0; i < _leng - 1; i++) {
                    var a = $datas[i].normal;
                    var b = $datas[(i + 1)].normal;
                    var rate = (Math.round((b - a) / a * 10000) / 100.00);
                    $jsonData.rate.push(rate);
                }

                var option1_3 = {

                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        top: 110,
                        bottom: 95

                    },
                    legend: {
                        x: '76%',
                        top: '6%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: ['户数', '增长率']
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示年份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show:true,
                            lineStyle: {
                                color: '#90979c' // x 轴线最下面的横坐标线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: true //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0,
                            formatter:function (value) {
                                return  value> 0 ? value : '';
                            }
                            //rotate:40  //倾斜显示*/
                        },
                        data:$jsonData.xdata
                    }],
                    yAxis: [
                        {
                            name: '单位：户',
                            type: "value",
                            splitLine: {
                                show: true   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            axisLine: {
                                show: false, // y 轴竖线   false：不显示 true：显示
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLabel: {
                                interval: 0

                            },
                            splitArea: {
                                show: false
                            },
                            splitNumber: 10  //分段数目 竖向
                        },
                        {
                            type: 'value',
                            name: '增长率',
                            position: 'right',
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLine: {    // y 轴竖线   false：不显示 true：显示
                                show:false,
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            splitLine: {
                                show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                            },
                            axisLabel: {
                                formatter: '{value}%'
                            }
                        }
                    ],
                    series: [
                        {
                            name: "户数",
                            type: "line",
                            symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            symbolSize:12,
                            barMaxWidth: 20,
                            barWidth : 12,//柱图宽度
                            //barGap:'-100%',
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: $jsonData.valueData
                        },
                        {
                            name: "增长率",
                            type: "line",
                            barMaxWidth: 20,
                            barWidth : 12,//柱图宽度
                            symbol:'circle',
                            symbolSize:12,
                            yAxisIndex: 1,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    //barBorderRadius: 10,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: '{c}%'
                                    }
                                }
                            },
                            //z:-12,//显示的层级
                            data:$jsonData.rate
                        }
                    ]
                };
                $myChart.setOption(option1_3);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab1_4 主体“新设/注销”趋势
        function myChart1_4(jsonData,$myChart,params,id) {
            try {
                /* 年份: monthCode  新设：normal  消亡:cancel */
                var $datas = jsonData.data;
                if(!$datas){return;}
                var $jsonData = {
                    xData:[],
                    newSetData: [] , //新设企业
                    dieOutData: []    //消亡企业
                };
                $.each($datas,function(i){
                    var t = $datas[i].monthCode;
                    if(t){
                        $jsonData.xData.push(t.substring(0,4)+'年'+ t.substring(4, t.length)+'月');
                        $jsonData.newSetData.push($datas[i].normal);
                        $jsonData.dieOutData.push($datas[i].cancel);
                    }
                });

                var option1_4 = {
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        top: 110,
                        bottom: 95

                    },
                    legend: {
                        x: '60%',
                        top: '11%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: ['新设企业', '消亡企业']
                    },

                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示月份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            lineStyle: {
                                color: '#90979c' // x 轴线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: true, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: false //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0

                        },
                        data: $jsonData.xData
                    }],
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true
                        },
                        axisLine: {
                            show: false, //不显示 y 轴竖线
                            lineStyle: {
                                color: '#90979c'
                            }
                        },
                        axisTick: {
                            show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                        },
                        axisLabel: {
                            interval: 0
                        },
                        splitArea: {
                            show: false
                        }

                    }],
                    dataZoom: [
                        {
                            show: true,
                            height: 30,
                            xAxisIndex: [0],
                            bottom: 30,
                            startValue:$jsonData.xData[$jsonData.xData.length-5],
                            endValue:$jsonData.xData[$jsonData.xData.length-1],
                            start: 10,  //这里可以动态设置
                            end:20,    //这里可以动态设置
                            handleSize: '100%',
                            handleStyle: {
                                color: "#d3dee5"
                            },
                            textStyle: {
                                color: "red"
                            },
                            borderColor: "#90979c",
                            orient: 'horizontal'// 布局方式，可选为：'horizontal' ,'vertical'(竖线)
                        }, {
                            type: "inside",
                            show: true,
                            height: 30,
                            startValue:$jsonData.xData[$jsonData.xData.length-5],
                            endValue:$jsonData.xData[$jsonData.xData.length-1],
                            start: 10,  //这里可以动态设置
                            end: 20    //这里可以动态设置
                        }
                    ],
                    series: [
                        {
                            name: "新设企业",
                            type: "line",
                            symbol:'circle',
                            //symbolSize:2,
                            barMaxWidth: 35,
                            barGap: "10%",
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: $jsonData.newSetData
                        },
                        {
                            name: "消亡企业",
                            type: "line",
                            //symbol:'circle',
                            symbolSize:2,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data:$jsonData.dieOutData
                        }
                    ]
                };
                $myChart.setOption(option1_4);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab1_5 主体“新设/注销”趋势
        function myChart1_5(jsonData,$myChart,params,id) {
            try {

                /* cancel : 13 industryphyName : "交通运输、仓储和邮政业" monthCode : "201708" normal : 24 */
                var $datas = jsonData.data;

                if(!$datas)return;
                var $jsonData = {
                    xData:[],
                    newSetData: [] , //新设企业
                    dieOutData: []    //消亡企业
                };
                for (var i = 0; i < $datas.length; i++) {
                    $jsonData.xData.push($datas[i].industryphyName);
                    $jsonData.newSetData.push($datas[i].normal);
                    $jsonData.dieOutData.push($datas[i].cancel);
                }
                var option1_5 = {
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        top: 80,
                        bottom: 120

                    },
                    legend: {
                        x:'80%',
                        //top: '11%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: ['新设企业', '消亡企业']
                    },

                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示企业类型的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            lineStyle: {
                                color: '#90979c' // x 轴线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: true, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: false //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0,
                            formatter: function (value) {
                                var ret = "";//拼接加\n返回的类目项
                                var maxLength = 2; //每项显示文字个数
                                var valLength = value.length;//X轴类目项的文字个数
                                var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
                                if (rowN > 1) {  //如果类目项的文字大于3,
                                    for (var i = 0; i < rowN; i++) {
                                        var temp = "";//每次截取的字符串
                                        var start = i * maxLength;//开始截取的位置
                                        var end = start + maxLength;//结束截取的位置
                                        //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                                        temp = value.substring(start, end) + "\n";
                                        ret += temp; //凭借最终的字符串
                                    }
                                    return ret;
                                }
                                else {
                                    return value;
                                }
                            }

                        },
                        data: $jsonData.xData
                    }],
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true
                        },
                        axisLine: {
                            show: false, //不显示 y 轴竖线
                            lineStyle: {
                                color: '#90979c'
                            }
                        },
                        axisTick: {
                            show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                        },
                        axisLabel: {
                            interval: 0
                        },
                        splitArea: {
                            show: false
                        }

                    }],
                    series: [
                        {
                            name: "新设企业",
                            type: "bar",
                            symbol:'circle',
                            symbolSize:12,
                            barWidth : 12,//柱图宽度
                            barMaxWidth: 35,
                            barGap: "8%",
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: $jsonData.newSetData
                        },
                        {
                            name: "消亡企业",
                            type: "bar",
                            symbol:'circle',
                            barWidth : 12,//柱图宽度
                            symbolSize:12,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data:$jsonData.dieOutData
                        }
                    ]
                };
                $myChart.setOption(option1_5);
            }
            catch (err) {
                window.console && console.log(err);
            }
        };

        return {
            totalNum :totalNum,
            myChart1_0: myChart1_0,
            myChart1_1: myChart1_1,
            myChart1_2: myChart1_2,
            myChart1_3: myChart1_3,
            myChart1_4: myChart1_4,
            myChart1_5: myChart1_5
        }
    })();


    //变化参数
    var tab1_0_params = { //默认参数值
        areaCode:''
    };
    var tab1_1_params = { //默认参数值
        entTypeCatg:'0' //企业类型：(全部：0) (企业：1) (农专：2) (个体户：3);
    };
    var tab1_2_params = { //默认参数值
        entTypeCatg:'1' //企业类型：(全部：0) (企业：1) (农专：2) (个体户：3);
    };
    var tab1_3_params = { //默认参数值
        qytype:'4' ////企业（内、外资 4） (内资企业 5) (外资企业 6) (新设企业 7) (小微企业 8) (私营企业 9)
    };
    var tab1_4_params = { //默认参数值
        entTypeCatg:'0' //企业类型：(全部：0) (企业：1) (农专：2) (个体户：3);
    };
    var tab1_5_params = { //默认参数值
        areaCode:'33',   //默认全省
        monthCode:window._config.yearAndMonth //默认获取当前系统年份和月份
    };

    //配置参数
    var tab1_options = {
        //总数
        tab1_num:{id:'',params:{},url:'/reg/server/echartssubjectdisrpt/getEntRegStateKTotal'},
        tab1_0:{id:'chart1_0',params:tab1_0_params,url:'/reg/server/echartssubjectdisrpt/getEntCatgCodeTotal'},
        tab1_1:{id:'chart1_1',params:tab1_1_params,url:'/reg/server/echartssubjectdisrpt/getZTEntIncrease'},
        tab1_2:{id:'chart1_2',params:tab1_2_params,url:'/reg/server/echartssubjectdisrpt/getEntAreaDistribution'},
        tab1_3:{id:'chart1_3',params:tab1_3_params,url:'/reg/server/echartssubjectdisrpt/getEntIncrease'},
        tab1_4:{id:'chart1_4',params:tab1_4_params,url:'/reg/server/echartssubjectdisrpt/getEntCXCancel'},
        tab1_5:{id:'chart1_5',params:tab1_5_params,url:'/reg/server/echartssubjectdisrpt/getEntIndustryphy'}
    };

    //事件
    function tab1_bind() {
        util.bindEvents([
            {
                el: '.tab1_1',  //  主体年增长情况
                event: 'click',
                handler: function () {
                    $('#js-tab1-1').find('span').removeClass('cur');$(this).addClass('cur');
                    var entTypeCatgValue = $(this).data('value');
                    tab1_1_params['entTypeCatg'] = entTypeCatgValue; //可变参数
                    ajaxRequest(tab1_options.tab1_1.id, tab1_options.tab1_1.params, tab1_options.tab1_1.url, tab1_model.myChart1_1);

                }
            },
            {
                el: '.tab1_2',  //在册主体分布
                event: 'click',
                handler: function () {
                    $('#js-tab1-2').find('span').removeClass('cur');$(this).addClass('cur');
                    tab1_2_params['entTypeCatg'] = $(this).data('value'); //可变参数
                    ajaxRequest(tab1_options.tab1_2.id, tab1_options.tab1_2.params, tab1_options.tab1_2.url, tab1_model.myChart1_2);

                }
            },
            {
                el: '.tab1_3',  //企业年增长情况
                event: 'click',
                handler: function () {
                    $('#js-tab1-3').find('span').removeClass('cur');$(this).addClass('cur');
                    tab1_3_params['qytype'] = $(this).data('value');
                    ajaxRequest(tab1_options.tab1_3.id, tab1_options.tab1_3.params, tab1_options.tab1_3.url, tab1_model.myChart1_3);
                }
            },
            {
                el: '.tab1_4',  //主体“新设/注销”趋势
                event: 'click',
                handler: function () {
                    $('#js-tab1-4').find('span').removeClass('cur');$(this).addClass('cur');
                    tab1_4_params['entTypeCatg'] = $(this).data('value'); //可变参数
                    ajaxRequest(tab1_options.tab1_4.id, tab1_options.tab1_4.params, tab1_options.tab1_4.url, tab1_model.myChart1_4);
                }
            },
            {
                el: '#js-tab1-serarch', //查询
                event: 'click',
                handler: function () {
                /*    $('#js-tab1-city').val();//city $('#js-tab1-year').val();//year $('#js-tab1-month').val();//month*/
                    tab1_5_params['areaCode'] = $('#js-tab1-city').val();
                    tab1_5_params['monthCode'] = $('#js-tab1-year').val()+$('#js-tab1-month').val();
                    ajaxRequest(tab1_options.tab1_5.id, tab1_options.tab1_5.params, tab1_options.tab1_5.url, tab1_model.myChart1_5);
                }
            }
        ])
    }

    //初始化执行方法
    function _tab1(){
        //总数
        ajaxRequest(tab1_options.tab1_num.id, tab1_options.tab1_num.params, tab1_options.tab1_num.url, tab1_model.totalNum);
        ////饼图
        ajaxRequest(tab1_options.tab1_0.id, tab1_options.tab1_0.params, tab1_options.tab1_0.url, tab1_model.myChart1_0);
        ajaxRequest(tab1_options.tab1_1.id, tab1_options.tab1_1.params, tab1_options.tab1_1.url, tab1_model.myChart1_1);
        ajaxRequest(tab1_options.tab1_2.id, tab1_options.tab1_2.params, tab1_options.tab1_2.url, tab1_model.myChart1_2);
        ajaxRequest(tab1_options.tab1_3.id, tab1_options.tab1_3.params, tab1_options.tab1_3.url, tab1_model.myChart1_3);
        ajaxRequest(tab1_options.tab1_4.id, tab1_options.tab1_4.params, tab1_options.tab1_4.url, tab1_model.myChart1_4);
        ajaxRequest(tab1_options.tab1_5.id, tab1_options.tab1_5.params, tab1_options.tab1_5.url, tab1_model.myChart1_5);


    }

//############################################# tab2 信用信息公示情况 ################################################################
    //模块结构图封装：
    var tab2_model = (function CoolModel() {
        //系统公示主体总数
        function totalNum (jsonData,$myChart,params,id){
            try{
                var $jsonData = jsonData.data;
                if(!$jsonData){ return; }
                for(var i=0;i<$jsonData.length;i++){
                    $('#tab2_num').find('span').eq(i).text($jsonData[i]);
                }
            }catch (err){
                window.console && console.log(err);
            }
        }
        // tab2_1 企业信用信息公示概览
        function myChart2_1(jsonData,$myChart,params,id) {
            try {

                var $datas = jsonData.data;
                var total = $datas.total; //总数
                var cunxu = $datas.cunxu;  //存续
                var zhuxiao = $datas.zhuxiao;//注销
                var diaoxiao = $datas.diaoxiao; //吊销
                var chexiao = $datas.chexiao; //撤销
                var qianchu = $datas.qianchu;//迁出

                var text1 = '存续主体'+cunxu+'户,占'+(Math.round(cunxu / total * 10000) / 100.00)+'%';
                var text2 = '注销主体'+zhuxiao+'户,占'+(Math.round(zhuxiao / total * 10000) / 100.00)+'%';
                var text3 = '吊销主体'+diaoxiao+'户,占'+(Math.round(diaoxiao / total * 10000) / 100.00)+'%';

                var text45 = '撤销、迁出主体'+(chexiao+qianchu)+'户,占'+(Math.round((chexiao+qianchu) / total * 10000) / 100.00)+'%';

                /* var text4 = '撤销主体'+chexiao+'户,占'+(Math.round(chexiao / total * 10000) / 100.00)+'%';
                 var text5 = '迁出主体'+qianchu+'户,占'+(Math.round(qianchu / total * 10000) / 100.00)+'%';*/

                var $jsonData = {
                    legend_data:[text1,text2,text3,text45],
                    datas: [
                        {value: (Math.round(cunxu / total * 10000) / 100.00), name: text1},
                        {value: (Math.round(zhuxiao / total * 10000) / 100.00), name: text2},
                        {value: (Math.round(diaoxiao / total * 10000) / 100.00), name: text3},
                        {value: (Math.round((chexiao+qianchu) / total * 10000) / 100.00), name: text45}
                        /*     {value: (Math.round(qianchu / total * 10000) / 100.00),name: text5}*/
                    ]
                };

                var  option2_1 = {
                    tooltip : {
                        show:false,
                        trigger: 'item',
                        formatter: "{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        top: 'middle',
                        data:$jsonData.legend_data
                    },
                    color:['#5B9CD5','#ED7C30','#70AD46','#FFC201','#4472C5'],//默认显示的颜色
                    series : [
                        {
                            name: '',
                            type: 'pie',
                            radius : '56%',
                            center: ['60%', '50%'],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            },
                            label: {
                                normal: {
                                    show:true,//是否显示
                                    position: 'right',//位置  文字描述显示的位置    inner : 在内部
                                    formatter:'{c}%'//获取值 模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。

                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',//字体大小  鼠标移入显示的
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            data:$jsonData.datas
                        }
                    ]
                };
                $myChart.setOption(option2_1);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab2_2 企业信用信息公示
        function myChart2_2(jsonData,$myChart,params,id) {
            try {

                var $datas = jsonData.data;

                if(!$datas){ return; }
                $('#js-tab2-xzcf').text(($datas.xingzhengchufa.disCount)+'户/'+($datas.xingzhengchufa.count)+'条');
                $('#js-tab2-xzxk').text(($datas.xingzhengxuke.disCount)+'户/'+($datas.xingzhengxuke.count)+'条');//行政许可
                $('#js-tab2-lrjyyc').text(($datas.yichang.disCount)+'户/'+($datas.yichang.count)+'条');  //列入经营异常
                $('#js-tab2-lryzwfsx').text(($datas.yanzhongweifa.disCount)+'户/'+($datas.yanzhongweifa.count)+'条'); //列入严重违反失信

                var gsbm_hs_num = $datas.xingzhengchufa.gongshang.disCount; //工商部门户数
                var gsbm_ts_num = $datas.xingzhengchufa.gongshang.count;    //工商部门条数

                var qt_hs_num = $datas.xingzhengchufa.otherDept.disCount; //其他部门户数
                var qt_ts_num = $datas.xingzhengchufa.otherDept.count;    //其它部门条数

                var $jsonData = {
                    legend_data:['工商部门'+gsbm_hs_num+'户,'+gsbm_ts_num+'条', '其他部门'+qt_hs_num+'户,'+qt_ts_num+'条'],
                    xdata:['户数','条数'],
                    hs_data:[gsbm_hs_num,gsbm_ts_num],
                    ts_data:[qt_hs_num,qt_ts_num]
                };

                var option2_2 = {
                    title: {
                        x:'40%',
                        textStyle: {
                            color: '#90979c',
                            fontSize: '22'
                        },
                        subtextStyle: {
                            color: '#90979c',
                            fontSize: '16'
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        left:'15%',
                        top: 40,
                        bottom: 60

                    },
                    legend: {
                        orient:'horizontal',
                        top:'bottom',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: $jsonData.legend_data
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示月份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show:true,
                            lineStyle: {
                                color: '#90979c' // x 轴线最下面的横坐标线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: true //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0
                        },
                        data:$jsonData.xdata
                    }],
                    yAxis: [
                        {
                            name: '',
                            type: "value",
                            splitLine: {
                                show: true   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            axisLine: {
                                show: false, // y 轴竖线   false：不显示 true：显示
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLabel: {
                                interval: 0 //强制设置坐标轴分割间隔。  例如：123  如何设置interval:1 那么横坐标就显示 1 3 坐标

                            },
                            splitArea: {
                                show: false
                            },
                            splitNumber: 4  //分段数目 竖向
                        }
                    ],
                    series: [
                        {
                            name: $jsonData.legend_data[0],
                            type: "bar",
                            stack: "数量",
                            barWith:80,
                            barMaxWidth: 80,
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: true,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: $jsonData.hs_data
                        },
                        {
                            name: $jsonData.legend_data[1],
                            type: "bar",
                            stack: "数量",
                            barWith:80,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: true,
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data:$jsonData.ts_data
                        }
                    ]
                };
                $myChart.setOption(option2_2);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab2_3 企业基本信息公示
        function myChart2_3(jsonData,$myChart,params,id) {
            try {

                var $datas =jsonData.data;

                if(!$datas){return};

                var xData = ['股东及出资','主要人员','分支机构','清算信息','变更信息','动产抵押登记信息','股权出质登记信息',
                    '知识产权出质登记信息',
                    '抽查检查结果','商标注册信息','司法协助信息'];

                var $jsonData = {
                    xData:xData,
                    houseData: [
                        $datas.gudongjichuzi.disCount||0,
                        $datas.zhuyaorenyuan.disCount||0,
                        $datas.fenzhijigou.disCount||0,
                        $datas.qingsuanxinxi.disCount||0,
                        $datas.biangengxinxi.disCount||0,
                        $datas.dongchandiya.disCount||0,
                        $datas.guquanchuzi.disCount||0,
                        $datas.zhishichanquan.disCount||0,
                        $datas.chouchajiancha.disCount||0,
                        $datas.shangbiaozhuche.disCount||0,
                        $datas.sifaxiezhu.disCount||0

                    ] ,
                    numberData: [
                        $datas.gudongjichuzi.count||0,
                        $datas.zhuyaorenyuan.count||0,
                        $datas.fenzhijigou.count||0,
                        $datas.qingsuanxinxi.count||0,
                        $datas.biangengxinxi.count||0,
                        $datas.dongchandiya.count||0,
                        $datas.guquanchuzi.count||0,
                        $datas.zhishichanquan.count||0,
                        $datas.chouchajiancha.count||0,
                        $datas.shangbiaozhuche.count||0,
                        $datas.sifaxiezhu.count||0
                    ]
                };


                var option2_3 = {
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        top: 100,
                        bottom: 100
                    },
                    legend: {
                        x:'70%',
                        top: '11%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: ['主体户数', '信息条数']
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示企业类型的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            lineStyle: {
                                color: '#90979c' // x 轴线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: true, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: false //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0,
                            formatter: function (value) {
                                var ret = "";//拼接加\n返回的类目项
                                var maxLength = 2; //每项显示文字个数
                                var valLength = value.length;//X轴类目项的文字个数
                                var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
                                if (rowN > 1) {  //如果类目项的文字大于3,
                                    for (var i = 0; i < rowN; i++) {
                                        var temp = "";//每次截取的字符串
                                        var start = i * maxLength;//开始截取的位置
                                        var end = start + maxLength;//结束截取的位置
                                        //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                                        temp = value.substring(start, end) + "\n";
                                        ret += temp; //凭借最终的字符串
                                    }
                                    return ret;
                                }
                                else {
                                    return value;
                                }
                            }

                        },
                        data: $jsonData.xData
                    }],
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true
                        },
                        axisLine: {
                            show: false, //不显示 y 轴竖线
                            lineStyle: {
                                color: '#90979c'
                            }
                        },
                        axisTick: {
                            show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                        },
                        axisLabel: {
                            interval: 0
                        },
                        splitArea: {
                            show: false
                        }

                    }],
                    series: [
                        {
                            name: "主体户数",
                            type: "bar",
                            symbol:'circle',
                            symbolSize:12,
                            barWidth : 12,//柱图宽度
                            barMaxWidth: 35,
                            barGap: "8%",
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: $jsonData.houseData
                        },
                        {
                            name: "信息条数",
                            type: "bar",
                            symbol:'circle',
                            barWidth : 12,//柱图宽度
                            symbolSize:12,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data:$jsonData.numberData
                        }
                    ]
                };
                $myChart.setOption(option2_3);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab2_4 信息公告统计
        function myChart2_4(jsonData,$myChart,params,id) {
            try {

                var $datas = jsonData.data;
                if(!$datas){return;}

                var yichang = $datas.yichang.count;
                var yanzhongweifa = $datas.yanzhongweifa.count;
                var chouchajiancha = $datas.chouchajiancha.count;
                var xingzhengchufa = $datas.xingzhengchufa.count;
                var sifaxiezhu = $datas.sifaxiezhu.count;
                var jianyizhuxiao = $datas.jianyizhuxiao.count;
                var other = $datas.other.count;
                var $jsonData = {
                    legend_data:[
                        '经营异常名录公告【'+yichang+'】条','严重违反失信企业名单公告【'+yanzhongweifa+'】条',
                        '抽查检查公告【'+chouchajiancha+'】条', '行政处罚公告【'+xingzhengchufa+'】条',
                        '司法协助公告【'+sifaxiezhu+'】条','简易注销公告【'+jianyizhuxiao+'】条','其他公告【'+other+'】条'
                    ],
                    tab1:[{name:'经营异常名录公告'+yichang+'条',value:yichang}],
                    tab2:[{name:'严重违反失信企业名单公告'+yanzhongweifa+'条',value:yanzhongweifa}],
                    tab3:[{name:'抽查检查公告'+chouchajiancha+'条',value:chouchajiancha}],
                    tab4:[{name:'行政处罚公告'+xingzhengchufa+'条',value:xingzhengchufa}],
                    tab5:[{name:'司法协助公告'+sifaxiezhu+'条',value:sifaxiezhu}],
                    tab6:[{name:'简易注销公告'+jianyizhuxiao+'条',value:jianyizhuxiao}],
                    tab7:[{name:'其他公告'+other+'条',value:other}]
                };
                var option2_4 = {
                    legend: {
                        orient:'horizontal',
                        top:'bottom',
                        data: $jsonData.legend_data
                    },
                    tooltip: {
                        formatter: function(params) {
                            return  params.name;
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '10%',
                        containLabel: true
                    },
                    xAxis: {
                        axisLine: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        axisLabel: {
                            show: false
                        },
                        splitLine: {
                            show: false
                        }
                    },
                    yAxis: {
                        type: 'category',
                        axisLine: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        data: ['']
                    },
                    series: [
                        {
                            name: $jsonData.legend_data[0],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    //formatter: '{c}'+'条' //如果不同意这种这份就改成{b}
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#4a94d8'
                                }
                            },
                            data: $jsonData.tab1
                        },
                        {
                            name: $jsonData.legend_data[1],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#2bb2ad'
                                }
                            },
                            data: $jsonData.tab2
                        },
                        {
                            name: $jsonData.legend_data[2],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#8b59ea'
                                }
                            },
                            data: $jsonData.tab3
                        },
                        {
                            name: $jsonData.legend_data[3],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#f4b227'
                                }
                            },
                            data: $jsonData.tab4
                        },
                        {
                            name: $jsonData.legend_data[4],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#3ba8da'
                                }
                            },
                            data: $jsonData.tab5
                        },
                        {
                            name: $jsonData.legend_data[5],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#6bb33a'
                                }
                            },
                            data: $jsonData.tab6
                        },
                        {
                            name: $jsonData.legend_data[6],
                            type: 'bar',
                            stack: '数量',
                            barWidth: '90%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    //拼接
                                    formatter:function(p){
                                        return "";
                                        //return p.value > 0 ? (p.value)+"条" : '';
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#f67d43'
                                }
                            },
                            data: $jsonData.tab7
                        }


                    ]
                };
                $myChart.setOption(option2_4);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab2_5 信息公告分类统计
        function myChart2_5(jsonData,$myChart,params,id) {
            try {
                var $datas = jsonData.data;
                if(!$datas){return;}
                //判断类型：
                var typeName = params.kindFlag;
                //数据封装
                var $jsonData = {legend_data:[], data:[]};
                //经营异常名录公告
                if(typeName=='1'){
                    var _total = $datas.total;
                    var lieru = $datas.lieru;
                    var yichu = $datas.yichu;
                    var qimansannian =$datas.qimansannian ;
                    var lieruText = '列入公告'+lieru+'条,占'+((Math.round(lieru / _total * 10000) / 100.00)||0)+'%';
                    var yichuText = '移出公告'+yichu+'条,占'+((Math.round(yichu / _total * 10000) / 100.00)||0)+'%';
                    var qimansannianText = '期满三年提醒公告'+qimansannian+'条,占'+(Math.round(qimansannian / _total * 10000) / 100.00)+'%';
                    $jsonData.legend_data=[lieruText,yichuText,qimansannianText];
                    $jsonData.data=[{value: lieru, name: lieruText},{value: yichu, name: yichuText},{value: qimansannian, name: qimansannianText}];
                };
                //严重违法失信企业公告
                if(typeName=='2'){
                    var _total = $datas.total;
                    var lieru = $datas.lieru;
                    var yichu = $datas.yichu;
                    var lieruText = '列入公告'+lieru+'条,占'+((Math.round(lieru / _total * 10000) / 100.00)||0)+'%';
                    var yichuText = '移出公告'+yichu+'条,占'+((Math.round(yichu / _total * 10000) / 100.00)||0)+'%';
                    $jsonData.legend_data=[lieruText,yichuText];
                    $jsonData.data=[{value: lieru, name: lieruText},{value: yichu, name: yichuText}];
                };
                //抽查检查公告
                if(typeName=='3'){
                    var _total = $datas.total;
                    var choucha = $datas.choucha;
                    var jiancha = $datas.jiancha;
                    var chouchajihua = $datas.chouchajihua;
                    var choucharenwu = $datas.choucharenwu;

                    var chouchaText = '抽查公告'+choucha+'条,占'+((Math.round(choucha / _total * 10000) / 100.00)||0)+'%';
                    var jianchaText = '检查公告'+jiancha+'条,占'+((Math.round(jiancha / _total * 10000) / 100.00)||0)+'%';
                    var chouchajihuaText = '抽查计划'+chouchajihua+'条,占'+((Math.round(chouchajihua / _total * 10000) / 100.00)||0)+'%';
                    var choucharenwuText = '抽查任务公告'+choucharenwu+'条,占'+((Math.round(choucharenwu / _total * 10000) / 100.00)||0)+'%';

                    $jsonData.legend_data=[chouchaText,jianchaText,chouchajihuaText,choucharenwuText];
                    $jsonData.data=[
                        {value: choucha, name: chouchaText},
                        {value: jiancha, name: jianchaText},
                        {value: chouchajihua , name:chouchajihuaText },
                        {value: choucharenwu , name:choucharenwuText }
                    ];
                };
                //行政处罚公告
                if(typeName=='4'){
                    var _total = $datas.total;
                    var xingzhengchufa = $datas.xingzhengchufa;
                    var xingzhengchufaText = '行政处罚公告'+xingzhengchufa+'条,占'+((Math.round(xingzhengchufa / _total * 10000) / 100.00)||0)+'%';
                    $jsonData.legend_data=[xingzhengchufaText];
                    $jsonData.data=[{value: xingzhengchufa, name:xingzhengchufaText }];

                };
                //司法协助公告
                if(typeName=='5'){
                    var _total = $datas.total;
                    var guquandongjie = $datas.guquandongjie;
                    var gudongbiangeng = $datas.gudongbiangeng;
                    var guquandongjieText = '司法股权冻结公告'+guquandongjie+'条,占'+((Math.round(guquandongjie / _total * 10000) / 100.00)||0)+'%';
                    var gudongbiangengText ='司法股东变更公告'+gudongbiangeng+'条,占'+((Math.round(gudongbiangeng / _total * 10000) / 100.00)||0)+'%';
                    $jsonData.legend_data=[guquandongjieText,gudongbiangengText];
                    $jsonData.data=[
                        {value: guquandongjie, name:guquandongjieText},
                        {value: gudongbiangeng, name:gudongbiangengText}
                    ];
                };
                //简易注销公告
                if(typeName=='6'){
                    var _total = $datas.total;
                    var  jianyizhuxiao= $datas.jianyizhuxiao;
                    var jianyizhuxiaoText = '简易注销公告'+jianyizhuxiao+'条,占'+((Math.round(jianyizhuxiao / _total * 10000) / 100.00)||0)+'%';
                    $jsonData.legend_data=[jianyizhuxiaoText];
                    $jsonData.data=[{value: jianyizhuxiao, name:jianyizhuxiaoText }];
                };
                //其他公告
                if(typeName=='7'){
                    var _total = $datas.total;
                    var tingzheng = $datas.tingzheng;
                    var diaoxiao = $datas.diaoxiao;
                    var zhuxiao = $datas.zhuxiao;
                    var tingzhengText = '拟吊销企业营业执照听证公告'+tingzheng+'条,占'+((Math.round(tingzheng / _total * 10000) / 100.00)||0)+'%';
                    var diaoxiaoText = '吊销企业营业执照公告'+diaoxiao+'条,占'+((Math.round(diaoxiao / _total * 10000) / 100.00)||0)+'%';
                    var zhuxiaoText = '企业登记机关注销公告'+zhuxiao+'条,占'+((Math.round(zhuxiao / _total * 10000) / 100.00)||0)+'%';

                    $jsonData.legend_data=[tingzhengText,diaoxiaoText,zhuxiaoText];
                    $jsonData.data=[
                        {value: tingzheng, name:tingzhengText },
                        {value: diaoxiao, name:diaoxiaoText },
                        {value: zhuxiao, name:zhuxiaoText }
                    ];
                };
                var option2_5 = {
                    tooltip: {
                        trigger: 'item',  //鼠标移入触发的浮动层
                        formatter: "{b}"
                    },
                    legend: {
                        orient: 'vertical',
                        left:'left',
                        top: 'middle',
                        textStyle:{
                            color:'#A5A5A5'
                        },
                        data:$jsonData.legend_data,
                        selectedMode:true //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                    },
                    color:['#5B9CD6','#ED7D31','#A5A5A5','#A0522D'],//默认显示的颜色
                    series: [
                        {
                            backgroundColor: '#fff',
                            name:'',
                            type:'pie',
                            center: ['65%', '50%'],
                            radius: ['30%', '50%'],
                            //selectedMode: 'single',//单列
                            avoidLabelOverlap: false,
                            label: {
                                normal: {
                                    show:true,//是否显示
                                    position: 'right',//位置  文字描述显示的位置    inner : 在内部
                                    formatter:'{d}%'//获取值 模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',//字体大小  鼠标移入显示的
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: true, //是否显示线
                                    length:5
                                }
                            },
                            data:$jsonData.data
                        }
                    ]
                };
                $myChart.setOption(option2_5);
            }
            catch (err) {
                window.console && console.log(err);
            }
        };
        return {
            totalNum: totalNum,
            myChart2_1: myChart2_1,
            myChart2_2: myChart2_2,
            myChart2_3: myChart2_3,
            myChart2_4: myChart2_4,
            myChart2_5: myChart2_5
        }
    })();

    //变化参数
    var tab2_totalNum = {areaCode: window._config.areaCode};
    var tab2_1_params = {areaCode: window._config.areaCode};
    var tab2_2_params = {areaCode: window._config.areaCode};
    var tab2_3_params = {areaCode: window._config.areaCode};
    var tab2_4_params = {areaCode: window._config.areaCode};
    var tab2_5_params = {areaCode: window._config.areaCode, kindFlag: '1'};

    //配置参数
    var tab2_options = {

        tab2_num:{id:'',params:tab2_totalNum,url:'/reg/server/echartspubsituationrpt/getPubEntRegStateKTotal'}, //总数
        tab2_1:{id:'chart2_1',params:tab2_1_params,url:'/reg/server/echartspubsituationrpt/getPubEntSituation'},
        tab2_2:{id:'chart2_2',params:tab2_2_params,url:'/reg/server/echartspubsituationrpt/getPubEntSituationInfo'},
        tab2_3:{id:'chart2_3',params:tab2_3_params,url:'/reg/server/echartspubsituationrpt/getPubEntSituationBaseInfo'},
        tab2_4:{id:'chart2_4',params:tab2_4_params,url:'/reg/server/echartspubsituationrpt/getPubNoticeInfo'},
        tab2_5:{id:'chart2_5',params:tab2_5_params,url:'/reg/server/echartspubsituationrpt/getPubKindNoticeInfo'}
    };

    //事件
    function tab2_bind() {
        util.bindEvents([
            {
                el: '#js-tab2-city',
                event: 'change',
                handler: function () {
                    var selectValue = $(this).val();
                    if(!selectValue){return;}
                    tab2_totalNum['areaCode'] = selectValue;
                    tab2_1_params['areaCode'] = selectValue;
                    tab2_2_params['areaCode'] = selectValue;
                    tab2_3_params['areaCode'] = selectValue;
                    tab2_4_params['areaCode'] = selectValue;
                    tab2_5_params['areaCode'] = selectValue;
                    ajaxRequest(tab2_options.tab2_num.id,tab2_options.tab2_num.params, tab2_options.tab2_num.url, tab2_model.totalNum);
                    ajaxRequest(tab2_options.tab2_1.id, tab2_options.tab2_1.params, tab2_options.tab2_1.url, tab2_model.myChart2_1);
                    ajaxRequest(tab2_options.tab2_2.id, tab2_options.tab2_2.params, tab2_options.tab2_2.url, tab2_model.myChart2_2);
                    ajaxRequest(tab2_options.tab2_3.id, tab2_options.tab2_3.params, tab2_options.tab2_3.url, tab2_model.myChart2_3);
                    ajaxRequest(tab2_options.tab2_4.id, tab2_options.tab2_4.params, tab2_options.tab2_4.url, tab2_model.myChart2_4);
                    ajaxRequest(tab2_options.tab2_5.id, tab2_options.tab2_5.params, tab2_options.tab2_5.url, tab2_model.myChart2_5);
                }
            },
            {
                el: '#js-tab2-notice',
                event: 'change',
                handler: function () {
                    var noticeValue = $('#js-tab2-notice').val();
                    tab2_5_params['kindFlag'] = noticeValue;
                    ajaxRequest(tab2_options.tab2_5.id, tab2_options.tab2_5.params, tab2_options.tab2_5.url, tab2_model.myChart2_5);
                }
            }
        ])
    }

    //初始化执行方法
    function _tab2(){
        ajaxRequest(tab2_options.tab2_num.id,tab2_options.tab2_num.params, tab2_options.tab2_num.url, tab2_model.totalNum);
        ajaxRequest(tab2_options.tab2_1.id, tab2_options.tab2_1.params, tab2_options.tab2_1.url, tab2_model.myChart2_1);
        ajaxRequest(tab2_options.tab2_2.id, tab2_options.tab2_2.params, tab2_options.tab2_2.url, tab2_model.myChart2_2);
        ajaxRequest(tab2_options.tab2_3.id, tab2_options.tab2_3.params, tab2_options.tab2_3.url, tab2_model.myChart2_3);
        ajaxRequest(tab2_options.tab2_4.id, tab2_options.tab2_4.params, tab2_options.tab2_4.url, tab2_model.myChart2_4);
        ajaxRequest(tab2_options.tab2_5.id, tab2_options.tab2_5.params, tab2_options.tab2_5.url, tab2_model.myChart2_5);
    }
//############################################# tab2 end #######################################################################





//############################################# tab3 企业年报情况 ################################################################

    //模块结构图封装：
    var tab3_model = (function CoolModel() {
        //应报数,已报数,年报率
        function dataSum(jsonData,$myChart,params,id){
            try{
                if(jsonData.data){
                    var sum1 = jsonData.data[0].yrAmountSure;
                    var sum2 = jsonData.data[0].isreported;
                    var sum3 = jsonData.data[0].usualreportRay;
                    $('#js-tab-sum1').text(!isNaN(sum1)?sum1:'');
                    $('#js-tab-sum2').text(!isNaN(sum2)?sum2:'');
                    $('#js-tab-sum3').text(!isNaN(sum3)?sum3+"%":'');
                }
            }catch (err){
                window.console && console.log(err);
            }
        }

        //近3年年报率
        function myChart3_1(jsonData,$myChart,params,id) {

            try {
                /*yrAmountSure; //实际应报数 (总数) isreported; //已年报数 usualreportRay; //自然年报率 百分比*/

                var $data = jsonData.data;

                $('#'+id).prev().empty();//清空内容

                if(!$data){ $('#' + id).prev().html('暂无数据!'); }

                //年份
                var yearArray = [($data[2].year) + '年', ($data[1].year) + '年', ($data[0].year) + '年']; //默认值
                //三年各自总数
                var $dataToal2 = $data[2].yrAmountSure; //2014
                var $dataToal1 = $data[1].yrAmountSure; //2015
                var $dataToal0 = $data[0].yrAmountSure; //2016
                //三年填报数
                var $wData2 = $data[2].isreported;//2014
                var $wData1 = $data[1].isreported;//2015
                var $wData0 = $data[0].isreported;//2016

                var dataTotal = [$dataToal2, $dataToal1, $dataToal0]; //总数   格式是从 2014  2015  2016
                var wData = [$wData2, $wData1, $wData0];//填报数   格式是从 2014  2015  2016
                var writeData = [{value: wData[0], itemStyle: {normal: {color: '#80D055'}}}, { value: wData[1], itemStyle: {normal: {color: '#8593DE'}}}, {value: wData[2], itemStyle: {normal: {color: '#59C5F6'}}}];

                var option3_1 = {
                    /*  tooltip: {
                     show: true,
                     formatter: "{b} {c}"
                     },*/
                    grid: {
                        //show:true, //显示容器的大小
                        left: '15%',
                        top: '2%',
                        bottom: '0',
                        right: '0',
                        width: '280',
                        height: '180'
                        //borderColor:'red',  //显示容器的边框颜色
                        // backgroundColor:'#ccc' // 容器的背景颜色
                    },
                    xAxis: [{
                        type: 'value',
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            show: false
                        },
                        axisLabel: {
                            show: false
                        },
                        splitLine: {
                            show: false
                        }
                    }],
                    yAxis: [{
                        type: 'category',
                        data: yearArray,
                        nameTextStyle: {
                            color: '#b7ce9e',
                            fontSize: '200px'
                        },
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            show: false
                        }
                    }],
                    series: [
                        {
                            name: '',
                            type: 'bar',
                            barWidth: 16,
                            silent: true,
                            itemStyle: {
                                normal: {
                                    color: '#f2f2f2'
                                }
                            },
                            label: {
                                normal: {
                                    show: true,
                                    textStyle: {
                                        color: '#000',
                                        fontSize: '12', //字体大小
                                        fontWeight: 'normal' //权重
                                    },
                                    position: 'bottom',
                                    formatter: function (p) {
                                        var $nums = wData[p.dataIndex];//填报数
                                        var $total = p.value; //总数
                                        return $nums + "/" + $total;
                                    }
                                }
                            },
                            barGap: '-100%',
                            //barCategoryGap: '10%',// 类目间柱形距离，默认为类目间距的20%，可设固定值
                            data: dataTotal
                        },
                        {
                            name: ' ',
                            type: 'bar',
                            barWidth: 16,
                            label: {
                                normal: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '14', //字体大小
                                        fontWeight: 'normal' //权重
                                    },
                                    position: 'right',
                                    formatter: function (p) {
                                        var total = dataTotal[p.dataIndex];//总数
                                        var num = p.value;  //已填报数
                                        if(num>0){
                                            // parseFloat(a.toFixed(2)); 保留两位有效数字的写法
                                            return Math.round(num / total * 10000) / 100.00 + "%";
                                        }
                                        return '0%';

                                    }
                                }
                            },
                            data: writeData
                        }]
                };

                $myChart.setOption(option3_1);
            }
            catch (err) {
                window.console && console.log(err);
                //$("#chart3_1").html("数据还在收集中...").css({'text-align': 'center', 'font-size': '14px', 'color': 'red'});
            }
        }

        //年报公示状态
        function myChart3_2(jsonData,$myChart,params,id) {

            try {
                var $jsonData = jsonData.data;

                $('#'+id).prev().empty();//清空内容

                if(!$jsonData){ $('#' + id).prev().html('暂无数据!'); }

                //var pubData = { pubValue1: $jsonData[0].keyLogin, pubValue2: $jsonData[0].passwordLogin, pubValue3: $jsonData[0].paper, pubValue4: $jsonData[0].app };
                //var dataValue = [{value: pubData.pubValue1, name: '数字证书'},{value: pubData.pubValue2, name: '联络员'}, {value: pubData.pubValue3, name: '纸质报告'},{value: pubData.pubValue4, name: '手机APP'}];
                //var dataText = ['数字证书', '联络员', '纸质报告','手机APP'];

                var dataValue = [];
                var dataText = [];

                if($jsonData[0].keyLogin!=null&&$jsonData[0].keyLogin!=0){
                    dataText.push('数字证书');
                    dataValue.push({value: $jsonData[0].keyLogin, name: '数字证书'});
                }
                if($jsonData[0].passwordLogin!=null&&$jsonData[0].passwordLogin!=0){
                    dataText.push('联络员');
                    dataValue.push({value: $jsonData[0].passwordLogin, name: '联络员'});
                }
                if($jsonData[0].paper!=null&&$jsonData[0].paper!=0){
                    dataText.push('纸质报告');
                    dataValue.push({value: $jsonData[0].paper, name: '纸质报告'});
                }
                if($jsonData[0].app!=null&&$jsonData[0].app!=0){
                    dataText.push('手机APP');
                    dataValue.push({value: $jsonData[0].app, name: '手机APP'});
                }

                var option3_2 = {
                    tooltip: {
                        trigger: 'item',  //鼠标移入触发的浮动层
                        formatter: "{b}所占比例：{d}%"
                    },
                    legend: {
                        orient: 'horizontal',
                        bottom: '20px',  //距离底部距离的位置
                        data: dataText,
                        selectedMode: false //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                    },
                    color: ['#ED7D31', '#70AD46', '#5B9CD5','#FF0000'],//默认显示的颜色
                    series: [
                        {
                            name: '年报公示情况',
                            type: 'pie',
                            radius: ['30%', '60%'],
                            //selectedMode: 'single',//单列
                            center: ['50%', '40%'],//图形相对于容器的位置 距离
                            avoidLabelOverlap:true,//如果不需要开启该策略，例如圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
                            label: {
                                normal: {
                                    show: true,//是否显示
                                    position: 'left',//位置
                                    formatter: '{d}%'//获取值 模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '12',//字体大小  鼠标移入显示的
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: true
                                }
                            },
                            data: dataValue//[{value: 10, name: '全部不公示'}, {value: 20, name: '全部公示'}, {value: 30, name: '部分公示'}]
                        }
                    ]
                };

                $myChart.setOption(option3_2);

            } catch (err) {
                window.console && console.log(err);
                //$("#chart3_2").html("数据还在收集中...").css({'text-align': 'center', 'font-size': '14px', 'color': 'red'});
            }

        }

        //报送趋势
        function myChart3_3(jsonData,$myChart,params,id) {

            try{

                var $jsonData = jsonData.data;

                $('#'+id).prev().empty();//清空内容

                if(!$jsonData){ $('#' + id).prev().html('暂无数据!'); }

                var reportYear = parseInt(params.year)+1;

                //登录数
                //var loginNum = [101, 1000, 303, 404, 200, 3000, 707, 808, 300, 1000, 2000, 4000];
                //报送数
                //var submitNum = [1011, 100, 20, 800, 512, 100, 8000, 52, 400, 61, 189, 600];
                //月份
                //var monthData = function () { var data = []; for (var i = 1; i < 13; i++) { data.push(i + "月"); } return data; }();

                var monthData = [];//年月份
                var submitNum = [];//报送数
                $.each($jsonData,function(i){
                    var t = $jsonData[i].monthCode;
                    if(t){
                        monthData.push(t.substring(0,4)+'年'+ t.substring(4, t.length)+'月');
                        submitNum[i]=$jsonData[i].isreported;
                    }
                });

                var option3_3 = {
                    title: {
                        //text:reportYear+"年报送趋势",
                        //subtext: "当前年份2017",
                        //left:'left',
                        textStyle: {
                            color: '#90979c',
                            fontSize: '22'
                        },
                        subtextStyle: {
                            color: '#90979c',
                            fontSize: '16'
                        }
                    },
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 0,
                        top: 110,
                        bottom: 95

                    },
                    legend: {
                        x: '60%',
                        top: '11%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        //data: ['登录数', '报送数']
                        data: ['报送数']
                    },

                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示月份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            lineStyle: {
                                color: '#90979c' // x 轴线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: true, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: false //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0

                        },
                        data: monthData
                    }],
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true
                        },
                        axisLine: {
                            show: false, //不显示 y 轴竖线
                            lineStyle: {
                                color: '#90979c'
                            }
                        },
                        axisTick: {
                            show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                        },
                        axisLabel: {
                            interval: 0

                        },
                        splitArea: {
                            show: false
                        }

                    }],
                    dataZoom: [
                        {
                            show: true,
                            height: 25,
                            xAxisIndex: [0],
                            bottom: 30,
                            startValue: monthData[monthData.length-6],
                            endValue: monthData[monthData.length-1],
                            /*  start: 30,
                             end: 80,*/
                            // handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                            handleSize: '100%',
                            handleStyle: {
                                color: "#d3dee5" //滑块的颜色
                            },
                            textStyle: {
                                color: 'red' //滑块中文字的颜色
                            },
                            borderColor: "#90979c",
                            orient: 'horizontal'// 布局方式，可选为：'horizontal' ,'vertical'(竖线)
                        },
                        {
                            type: "inside",
                            show: true,
                            height: 25,
                            startValue: monthData[monthData.length-6],
                            endValue: monthData[monthData.length-1]
                            /*   start: 30,
                             end: 80*/
                        }
                    ],
                    series: [
                        /*  {
                         name: "登录数",
                         type: "line",
                         //stack: "总量",
                         symbol:'circle',
                         symbolSize:12,
                         barMaxWidth: 35,
                         barGap: "10%",
                         itemStyle: {
                         normal: {
                         color: "#5B9CD6",
                         label: {
                         show: true,
                         textStyle: {
                         // color: "#5B9CD6"
                         },
                         position: "top",
                         formatter: function(p) {
                         return p.value > 0 ? (p.value) : '';
                         }
                         }
                         }
                         },
                         data: loginNum
                         },*/
                        {
                            name: "报送数",
                            type: "line",
                            // stack: "总量",
                            symbol:'circle',
                            symbolSize:12,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: true,
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: submitNum
                        }
                    ]
                };

                $myChart.setOption(option3_3);

            } catch (err) {
                window.console && console.log(err);
                //  $("#chart3_3").html("数据还在收集中...").css({'text-align': 'center', 'font-size': '14px', 'color': 'red'});
            }
        }

        //年报主体情况 浙江省
        function myChart3_4(jsonData,$myChart,params,id) {
            try{

                //后台返回数据
                var $jsonData = jsonData.data;

                $('#'+id).prev().empty();//清空内容

                if(!$jsonData){ $('#' + id).prev().html('暂无数据!'); }

                // 获取年份
                var serverYear = parseInt(params.year)+1;

                //已年报
                var alreadyYearReport = [];
                //未年报
                var notYearReport = [];
                //年报率
                var report_percentage = [];
                //'省局','杭州','宁波','温州','嘉兴','湖州','绍兴','金华','衢州','舟山','台州','丽水'
                var addressData = [];
                /* （yrAmountSure; //实际应报数 (总数)） （isreported; //已年报数 ）（notreported//未年报 ） （usualreportRay; //自然年报率 百分比）  */

                //组装数据
                function packageData(num1,num2,num3,text){
                    alreadyYearReport.push(num1);//已年报
                    notYearReport.push(num2);//未年报
                    report_percentage.push(num3);//年报率
                    addressData.push(text);//所属管辖单位名称
                }

                //全省
                if(params.areaCode=='33'||params.areaCode=='3300'){
                    for(var i=0; i<$jsonData.length;i++){
                        if($jsonData[i].regOrgName=="3300"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'省局');}
                        if($jsonData[i].regOrgName=="3301"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'杭州');}
                        if($jsonData[i].regOrgName=="3302"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'宁波');}
                        if($jsonData[i].regOrgName=="3303"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'温州');}
                        if($jsonData[i].regOrgName=="3304"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'嘉兴');}
                        if($jsonData[i].regOrgName=="3305"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'湖州');}
                        if($jsonData[i].regOrgName=="3306"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'绍兴');}
                        if($jsonData[i].regOrgName=="3307"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'金华');}
                        if($jsonData[i].regOrgName=="3308"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'衢州');}
                        if($jsonData[i].regOrgName=="3309"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'舟山');}
                        if($jsonData[i].regOrgName=="3310"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'台州');}
                        if($jsonData[i].regOrgName=="3325"){packageData($jsonData[i].isreported,$jsonData[i].notreported,$jsonData[i].usualreportRay,'丽水');}
                    }
                }else{
                    $.each($jsonData,function(i){
                        alreadyYearReport.push($jsonData[i].isreported);//已年报
                        notYearReport.push($jsonData[i].notreported);//未年报
                        report_percentage.push($jsonData[i].usualreportRay);//年报率
                        addressData.push($jsonData[i].regOrgName);//所属管辖单位名称
                    });
                }
                var option3_4 = {
                    title: {
                        subtext: "汇报时间"+serverYear+"年",
                        x:'40%',
                        textStyle: {
                            color: '#90979c',
                            fontSize: '22'
                        },
                        subtextStyle: {
                            color: '#90979c',
                            fontSize: '16'
                        }
                    },
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 2,
                        top: 100,
                        bottom: 200,
                        borderColor:'red',
                        show:false //不显示
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示月份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show:true,
                            lineStyle: {
                                color: '#90979c' // x 轴线最下面的横坐标线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: true //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0,
                            formatter: function (value) { //竖向显示
                                return value.split("").join("\n");
                            }
                        },
                        data:addressData
                    }],
                    yAxis: [
                        {
                            name: '单位：户',
                            type: "value",
                            splitLine: {
                                show: true   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            axisLine: {
                                show: false, // y 轴竖线   false：不显示 true：显示
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLabel: {
                                interval: 0

                            },
                            splitArea: {
                                show: false
                            },
                            splitNumber: 10  //分段数目 竖向
                        },
                        {
                            type: 'value',
                            name: '百分比',
                            splitLine: {
                                show: false   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            /*
                             如果不写 默认取值对应坐标的data数据进行解析分析生成数据段，  如果设置了就会以设置最大值和最小值为主进行分段
                             min: Math.max.apply(null, [10,60,80,40,26,90,28,59,92]),
                             max:Math.min.apply(null, [10,60,80,40,26,90,28,59,95]),
                             */
                            position: 'right',
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLine: {    // y 轴竖线   false：不显示 true：显示
                                show:false,
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisLabel: {
                                formatter: '{value}%'
                            }
                        }
                    ],
                    series: [
                        {
                            name: "已年报",
                            type: "bar",
                            stack: "数量",
                            symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            symbolSize:12,
                            barWidth : 15,
                            barMaxWidth: 20,
                            barGap: "10%",
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: alreadyYearReport
                        },
                        {
                            name: "未年报",
                            type: "bar",
                            stack: "数量",
                            symbol:'circle',
                            symbolSize:12,
                            barWidth : 15,
                            barMaxWidth: 20,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: notYearReport
                        },
                        {
                            name: "百分比",
                            type: "line",
                            //symbol:'circle',//显示的图形
                            //symbolSize:12, //显示的大小
                            yAxisIndex: 1,
                            itemStyle: {
                                normal: {
                                    color: "#7CB252",
                                    //barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: '{c}%'
                                    }
                                }
                            },
                            data: report_percentage
                        }
                    ]
                };
                $myChart.setOption(option3_4);

            } catch (err) {
                window.console && console.log(err);
                //  $("#chart3_4").html("数据还在收集中...").css({'text-align': 'center', 'font-size': '14px', 'color': 'red'});
            }
        }

        //年报主体情况 行业
        function myChart3_5(jsonData,$myChart,params,id) {
            try{
                var $jsonData = jsonData.data;

                $('#'+id).prev().empty();//清空内容

                if(!$jsonData){ $('#' + id).prev().html('暂无数据!'); }

                // 获取年份
                var serverYear = parseInt(params.year)+1;

                //已年报
                var alreadyYearReport = [];
                //未年报
                var notYearReport = [];
                //年报率
                var report_percentage = [];
                //行业
                var TypeData = [];
                /*  （isreported; //已年报数 ）（notreported//未年报 ） （usualreportRay; //自然年报率 百分比） (regOrgName 行业名称)  */
                $.each($jsonData,function(i){
                    alreadyYearReport[i] = $jsonData[i].isreported;
                    notYearReport[i] = $jsonData[i].notreported;
                    report_percentage[i] = $jsonData[i].usualreportRay;
                    TypeData[i] = $jsonData[i].regOrgName;
                });
                var option3_5 = {
                    title: {
                        subtext: "汇报时间"+serverYear+"年",
                        x:'40%',
                        textStyle: {
                            color: '#90979c',
                            fontSize: '22'
                        },
                        subtextStyle: {
                            color: '#90979c',
                            fontSize: '16'
                        }
                    },
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: { // 查看官网解释  其实就是容器的大小
                        borderWidth: 2,
                        top: 100,
                        bottom: 200,
                        borderColor:'red',
                        show:false //不显示
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示月份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show:true,
                            lineStyle: {
                                color: '#90979c' // x 轴线最下面的横坐标线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: true //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0,
                            formatter: function (value) { //竖向显示
                                return value.split("").join("\n");
                            }
                            //rotate:40  //倾斜显示
                        },
                        data:TypeData
                    }],
                    yAxis: [
                        {
                            name: '单位：户',
                            type: "value",
                            splitLine: {
                                show: true   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            axisLine: {
                                show: false, // y 轴竖线   false：不显示 true：显示
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLabel: {
                                interval: 0

                            },
                            splitArea: {
                                show: false
                            },
                            splitNumber: 10  //分段数目 竖向
                        },
                        {
                            type: 'value',
                            name: '百分比',
                            /*
                             如果不写 默认取值对应坐标的data数据进行解析分析生成数据段，  如果设置了就会以设置最大值和最小值为主进行分段
                             min: Math.max.apply(null, [10,60,80,40,26,90,28,59,92]),
                             max:Math.min.apply(null, [10,60,80,40,26,90,28,59,95]),
                             */
                            splitLine: {
                                show: false   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            position: 'right',
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLine: {    // y 轴竖线   false：不显示 true：显示
                                show:false,
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisLabel: {
                                formatter: '{value}%'
                            }
                        }
                    ],
                    series: [
                        {
                            name: "已年报",
                            type: "bar",
                            stack: "数量",
                            symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            symbolSize:12,
                            barWidth : 15,
                            barMaxWidth: 20,
                            barGap: "10%",
                            itemStyle: {
                                normal: {
                                    color: "#5B9CD6",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "left",//inside
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: alreadyYearReport
                        },
                        {
                            name: "未年报",
                            type: "bar",
                            stack: "数量",
                            symbol:'circle',
                            symbolSize:12,
                            barWidth : 15,
                            barMaxWidth: 20,
                            itemStyle: {
                                normal: {
                                    color: "#EC7E33",
                                    barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "right",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: notYearReport
                        },
                        {
                            name: "百分比",
                            type: "line",
                            //symbol:'circle',//显示的图形
                            //symbolSize:12, //显示的大小
                            yAxisIndex: 1,
                            itemStyle: {
                                normal: {
                                    color: "#7CB252",
                                    //barBorderRadius: 0,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: function(p){
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: report_percentage
                        }
                    ]
                };

                $myChart.setOption(option3_5);
            } catch (err) {
                window.console && console.log(err);
                //$("#chart3_5").html("数据还在收集中...").css({'text-align': 'center', 'font-size': '14px', 'color': 'red'});
            }
        }

        return {
            dataSum:dataSum,
            myChart3_1: myChart3_1,
            myChart3_2: myChart3_2,
            myChart3_3: myChart3_3,
            myChart3_4: myChart3_4,
            myChart3_5: myChart3_5
        }
    })();

    //变化参数
    var tab3_params = { //默认参数值
        year:(window._config.year-1), //当前系统年份,
        monthCode:'00', //月份  默认为0
        serverDate:window._config.serverDate,    //当前系统日期
        serverPreDate:window._config.serverPreDate, //当前系统前一天日期
        entTypeCatg:'1', //企业类型： (企业：1) (农专：2) (个体户：3);
        qytype:'4', ////企业（内、外资 4） (内资企业 5) (外资企业 6) (新设企业 7) (小微企业 8) (私营企业 9)
        areaCode:window._config.areaCode  // //当前用户所属部门编码
    };

    //配置参数
    var tab3_options = {
        tab3_0:{id:'',params:tab3_params,url:'/reg/server/echartsindexrpt/getEntReportJsonData'}, //非图表

        tab3_1:{id:'chart3_1',params:tab3_params,url:'/reg/server/echartsindexrpt/getThreeYearJsonData'},
        tab3_2:{id:'chart3_2',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportBsfsJsonData'},
        tab3_3:{id:'chart3_3',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportTrendJsonData'},
        tab3_4:{id:'chart3_4',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportJsonDataByArea'},
        tab3_5:{id:'chart3_5',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportIndustryphyJsonData'}
    };

    //事件
    function tab3_bind() {
        util.bindEvents([
            {
                el: '#js-tab3-serarch',  //查询
                event: 'click',
                handler: function () {

                    $('#js-tab-sum1').text("获取中...");$('#js-tab-sum2').text("获取中...");$('#js-tab-sum3').text("获取中...");
                    var $yearValue = $('#js-tab3-year').val();//获取选择的年份
                    var $entTypeCatg = $("#js-tab3-type").find('.cur').data('value');

                    var $areaCode = $("#js-tab3-city").val(); //省局登录 省局登录可以进行选择地级市
                    if($areaCode){tab3_params['areaCode'] =$areaCode;}

                    if(!($yearValue && $entTypeCatg)){layer.msg("查询参数为空,请联系系统管理员进行处理!");return ;}

                    //改变参数传值
                    tab3_params['year'] =$yearValue;//可变参数
                    tab3_params['entTypeCatg'] =$entTypeCatg;//可变参数

                    ajaxRequest(tab3_options.tab3_0.id, tab3_options.tab3_0.params, tab3_options.tab3_0.url, tab3_model.dataSum);// 应报数,已报数,年报率
                    ajaxRequest(tab3_options.tab3_1.id,tab3_options.tab3_1.params,tab3_options.tab3_1.url,tab3_model.myChart3_1);
                    ajaxRequest(tab3_options.tab3_2.id,tab3_options.tab3_2.params,tab3_options.tab3_2.url,tab3_model.myChart3_2);
                    ajaxRequest(tab3_options.tab3_3.id,tab3_options.tab3_3.params,tab3_options.tab3_3.url,tab3_model.myChart3_3);
                    ajaxRequest(tab3_options.tab3_4.id,tab3_options.tab3_4.params,tab3_options.tab3_4.url,tab3_model.myChart3_4);
                    ajaxRequest(tab3_options.tab3_5.id,tab3_options.tab3_5.params,tab3_options.tab3_5.url,tab3_model.myChart3_5);


                }
            },
            {
                el: '.js-tab3-entTypeCatg',  //主体类型切换
                event: 'click',
                handler: function () {
                    $('#js-tab3-type > .type-sele').removeClass('cur'); $(this).addClass('cur');

                    var $entTypeCatg = $("#js-tab3-type").find('.cur').data('value');
                    tab3_params['entTypeCatg'] =$entTypeCatg;//可变参数

                    var $areaCode = $("#js-tab3-city").val(); //省局登录 省局登录可以进行选择地级市
                    if($areaCode){tab3_params['areaCode'] =$areaCode;}

                    //ajaxRequest(tab3_options.tab3_1.id,tab3_options.tab3_1.params,tab3_options.tab3_1.url,tab3_model.myChart3_1);
                }
            },
            {
                el: '.js-tab3-qytype',  //企业（内、外资） 内资企业 外资企业 新设企业 小微企业 私营企业
                event: 'click',
                handler: function () {
                    $('#js-tab3-qy-type > .js-tab3-qytype').removeClass('active'); $(this).addClass('active');
                    var dataValue = $(this).data('type');
                    if(dataValue){
                        tab3_params['qytype'] =dataValue;//可变参数
                        ajaxRequest(tab3_options.tab3_4.id,tab3_options.tab3_4.params,tab3_options.tab3_4.url,tab3_model.myChart3_4);
                    }
                }
            }

        ])
    }

    //初始化执行方法
    function _tab3(){
        //page_loading(); //调用加载层
        //$('#js-tab-sum1').text("获取中...");$('#js-tab-sum2').text("获取中...");$('#js-tab-sum3').text("获取中...");
        ajaxRequest(tab3_options.tab3_0.id, tab3_options.tab3_0.params, tab3_options.tab3_0.url, tab3_model.dataSum);// 应报数,已报数,年报率
        ajaxRequest(tab3_options.tab3_1.id, tab3_options.tab3_1.params, tab3_options.tab3_1.url, tab3_model.myChart3_1);
        ajaxRequest(tab3_options.tab3_2.id, tab3_options.tab3_2.params, tab3_options.tab3_2.url, tab3_model.myChart3_2);
        ajaxRequest(tab3_options.tab3_3.id, tab3_options.tab3_3.params, tab3_options.tab3_3.url, tab3_model.myChart3_3);
        ajaxRequest(tab3_options.tab3_4.id, tab3_options.tab3_4.params, tab3_options.tab3_4.url, tab3_model.myChart3_4);
        ajaxRequest(tab3_options.tab3_5.id, tab3_options.tab3_5.params, tab3_options.tab3_5.url, tab3_model.myChart3_5);
    }

//############################################# tab3 end ########################################################################

   //******************************************** tab4 抽查检查“双随机” 开始  *******************************************************************
    
    var tab4_model = (function CoolModel() {
       
        function yearCheckNum (jsonData,$myChart,params,id){
            try{
                var $jsonData = jsonData.data;
                if(!$jsonData){ return; }
                $("#jh1").text($jsonData.totalWork);
                $("#jh2").text("本部门："+$jsonData.planOwnNum);
                $("#jh3").text("跨部门："+$jsonData.planCrossNum);
                $("#rw1").text($jsonData.totalTask);
                $("#rw2").text("本部门："+$jsonData.ownNum);
                $("#rw3").text("跨部门："+$jsonData.crossNum);
                $("#surezt").text($jsonData.entTotal);
                $("#isCheckzt").text($jsonData.finishedNum);
                $("#checkroate").text($jsonData.checkRoate+"%");
            }catch (err){
                window.console && console.log(err);
            }
        }
        
        function checkPersonNum(jsonData,$myChart,params,id){
        	try{
        		var $jsonData = jsonData.data;
        		if(!$jsonData){ return; }
        		$("#checknum").text($jsonData.checkPersonNum);
        		var areaCodes = $jsonData.areaCodes;
        		var checkPersonNums = $jsonData.checkPersonNums;
                for (var i = 0; i < checkPersonNums.length; i++) {
                    var tdArr = $("#checktable").find("tr").eq(i+1).find("td");
                    tdArr.eq(3).text(checkPersonNums[i]);
                }
        	}catch (err){
        		window.console && console.log(err);
        	}
        }
        
        // tab4_0 本年度各地市抽查工作情况
        function myChart4_0(jsonData,$myChart,params,id) {
            try {
            	var $jsonData = jsonData.data;
                if (!$jsonData) {
                    return;
                }
                var areaCodes = $jsonData.areaCodes;
                var sureCheckCountList = $jsonData.sureCheckNums;
                var isCheckedCountList = $jsonData.isCheckTedNums;
                var checkRoateList = $jsonData.checkRoateList;
                var xdata = [];
                for (var i = 0; i < areaCodes.length; i++) {
                    xdata.push(areacodeList(areaCodes[i]));
                    var tdArr = $("#checktable").find("tr").eq(i+1).find("td");
                    tdArr.eq(0).text(xdata[i]);
                    tdArr.eq(1).text(sureCheckCountList[i]);
                    tdArr.eq(2).text(isCheckedCountList[i]);
                    tdArr.eq(4).text(checkRoateList[i]+"%");
                }
                
                var option4_0 = {
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        },
                        formatter:"{a0}: {c0}<br />{a1}: {c1}<br />{a2}: {c2}%"  	
                    },
                    legend: {
                        x: 'right',
//                        top: '1%',
                        textStyle: {
                            color: '#90979c' //文字的颜色
                        },
                        data: ['应检查户次','已检查户次', '检查完成率'],
                        selectedMode: false //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                    },
                    grid: {
                        show: true,
                        containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                        width: '90%',
                        height: '80%',
                        left: '20',
                        top: '60',
                        borderWidth: 0
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示年份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show:true,
                            lineStyle: {
                                color: '#90979c' // x 轴线最下面的横坐标线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: true //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0
                            //rotate:40  //倾斜显示*/
                        },
                        data:xdata
                    }],
                    yAxis: [
                        {
                            name: '单位：户',
                            type: "value",
                            splitLine: {
                                show: true   // 坐标轴上的 横线    true:显示  false:不显示
                            },
                            axisLine: {
                                show: false, // y 轴竖线   false：不显示 true：显示
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLabel: {
                                interval: 0

                            },
                            splitArea: {
                                show: false
                            },
                            splitNumber: 10  //分段数目 竖向
                        },
                        {
                            type: 'value',
                            name: '百分比',
                            position: 'right',
                            axisTick: {
                                show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                            },
                            axisLine: {    // y 轴竖线   false：不显示 true：显示
                                show:false,
                                lineStyle: {
                                    color: '#90979c'
                                }
                            },
                            splitLine: {
                                show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                            },
                            axisLabel: {
                                formatter: '{value}%'
                            }
                        }


                    ],
                    series: [
                        {
                            name: "应检查户次",
                            type: "bar",
                            symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            symbolSize:12,
                            barMaxWidth: 20,
                            barWidth : 12,//柱图宽度
                            //barGap:'-100%',
                            itemStyle: {
                                normal: {
                                    color: "#5b9bd5",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "inside",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: sureCheckCountList
                        },
                        {
                        	name: "已检查户次",
                        	type: "bar",
                        	symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                        	symbolSize:12,
                        	barMaxWidth: 20,
                        	barWidth : 12,//柱图宽度
                        	//barGap:'-100%',
                        	itemStyle: {
                        		normal: {
                        			color: "#ed7d31",
                        			label: {
                        				show: false,
                        				textStyle: {
                        					// color: "#5B9CD6"
                        				},
                        				position: "inside",
                        				formatter: function(p) {
                        					return p.value > 0 ? (p.value) : '';
                        				}
                        			}
                        		}
                        	},
                        	data: isCheckedCountList
                        },
                        {
                            name: "检查完成率",
                            type: "line",
                            barMaxWidth: 20,
                            barWidth : 12,//柱图宽度
                            yAxisIndex: 1,
                            symbolSize: '0',
                            symbol: 'circle',
                            itemStyle: {
                                normal: {
                                    color: "#70ad47",
                                    //barBorderRadius: 10,
                                    label: {
                                        show: false,
                                        position: "top",
                                        formatter: '{c}%'
                                    }
                                }
                            },
                            data:checkRoateList
                        }
                    ]
                };
                $myChart.setOption(option4_0);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
  
        // tab4_1 抽查结果情况1
        function myChart4_1(jsonData,$myChart,params,id) {
            try {
                var $jsonData = jsonData.data;
                if(!$jsonData){ return; }
                var result1 = '未发现问题，'+($jsonData.result1 == null ? 0 : $jsonData.result1) +'户次';
                var resultE = '发现问题经责令已整改，'+($jsonData.resultE == null ? 0 : $jsonData.resultE)+'户次';
                var resultF = '未发现开展本次抽查涉及的经营活动，'+($jsonData.resultF == null ? 0 : $jsonData.resultF) +'户次';
                var result7 = '已关闭停业或正在清算，'+($jsonData.result7 == null ? 0 : $jsonData.result7) +'户次';
                var result8 = '不予配合情节严重，'+($jsonData.result8 == null ? 0 : $jsonData.result8) +'户次';
                var result9 = '注销、吊销、撤销、迁出，'+($jsonData.result9 == null ? 0 : $jsonData.result9) +'户次';
                var resultA = '发现问题待后续处理，'+($jsonData.resultA == null ? 0 : $jsonData.resultA) +'户次';
                
                              
                var lengedData = [result1,resultE,resultF,result7,result8,result9,resultA];
                var pieData = [{value:$jsonData.result1,name:result1},
                               {value:$jsonData.resultE,name:resultE},
                               {value:$jsonData.resultF ,name:resultF},
                               {value:$jsonData.result7 ,name:result7},
                               {value:$jsonData.result8,name:result8},
                               {value:$jsonData.result9,name:result9},
                               {value:$jsonData.resultA,name:resultA}];
                
                var waithandletotal = $jsonData.result2+$jsonData.result3+$jsonData.result4+$jsonData.result5;                           
                var disposeData = [$jsonData.dispose1,$jsonData.dispose2,$jsonData.dispose3,$jsonData.dispose4,$jsonData.dispose5,$jsonData.dispose6];
                //处理完结率(完结数/已公示数)
                var endRoate = ($jsonData.endNum == null || $jsonData.endNum == 0) ? 0 : Math.round(($jsonData.disposeNum) * 100 / $jsonData.endNum) + '%';
                $("#endRoate").text(endRoate);
                $("#endNum").text($jsonData.disposeNum == null ? 0 : $jsonData.disposeNum);
                $("#notEndNum").text($jsonData.endNum-$jsonData.disposeNum);
                if($jsonData.endNum == null || $jsonData.endNum == 0){//已公示数为0
                	$("#endTotal").width("0%");
                }else{
                	$("#endTotal").width("80%");
                }
                $("#endleft").width(endRoate);
                if(waithandletotal != null && waithandletotal != 0){
                    var result3Rate = Math.round(($jsonData.result3) * 100 / waithandletotal);
                    var result4Rate = Math.round(($jsonData.result4) * 100 / waithandletotal);
                    var result5Rate = Math.round(($jsonData.result5) * 100 / waithandletotal);
                    var result2Rate = (100-result3Rate-result4Rate-result5Rate);
                    var waitHandRate = 0;
                }

                var option4_1 = {
                	      title:[
                		        {text:"待后续处理",x: '66%', y: '7%',textStyle:{fontSize:"14",fontWeight:'lighter',fontFamily:'Microsoft YaHei'}},
                		    ],
                		  grid: [
                		        {x: '45%', y: '40px', width: '50%', height: '80%',
//                		        	containLabel :true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。},
                		        }
                		    ],
                		    tooltip: {
                		        formatter: '{b}:{c}'
                		    },
                		    legend: {
                		    	show:true,
                                left: '80',
                                top: 'middle',
                                itemWidth: 10,
                                itemHeight: 10,
                                orient:'vertical',
                                data:lengedData ,
                                selectedMode: false //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                            },
                            xAxis: [
                   		         {  gridIndex: 0,
                   		        	position:'top',
                   		            axisTick: {show:false},//坐标轴刻度
                   		            axisLabel: {show:false,positon:'top'},//坐标轴刻度标签
                   		            splitLine: {show:false},//坐标轴在 grid 区域中的分隔线
                   		            axisLine: {show:false}, //坐标轴轴线
                   		            data:['待后续处理']
                   		        }
                   		    ],
                		    yAxis: [
                		        {gridIndex: 0, 
                		         interval:0,
                		         axisTick: {show:false},
                		         axisLabel: {show:false},
                		         splitLine: {show:false},
                		         axisLine: {show:false }
                		         },
                		    ],
                		    series: [
                		 	        {
                		 	            name: '检查结果情况',
                		 	            type: 'pie',
                                        radius: ['50%', '70%'],
                		 	            center: ['50%', '50%'],
                		 	            color:['#5b9bd5','#ed7d31','#a5a5a5','#ffc000','#3a91d2','#70ad47','#255e91'],
                		 	            labelLine:{normal:{show:true}},
                		 	            data:pieData,
                		 	            itemStyle: {
                		 	            	normal: {
        					                	borderColor: '#fff',
        					                	borderWidth : 1
        					                },
                		 	            },
                		 	           label:{ 
                		 	        	   normal:{
                		 	        		  show: true,
                		 	        		  formatter: '{d}%', 
                     		 	              textStyle:{color:'#B1B9D3'}
                		 	        	   }
                		 	           },
                		 	          tooltip:{
                          		        formatter: '{b}'
                		 	          }
                		 	        },
                		 	        {
                		 	            name: '违反其他部门相关规定',
                		 	            type: 'bar',
                		 	            xAxisIndex: 0,
                		 	            yAxisIndex: 0,
                		 	            barWidth:'20%',
                                        stack: '待后续处理',
                		 	            itemStyle:{
                		 	            	normal:{color:'#6b9bd5',
                		 	            	        borderColor: '#fff',
    					                	        borderWidth : 1}},//color设置图例颜色，lineStyle设置边框线
                		 	            label:{normal:{show:true, position:"right",
                		 	        		formatter:function(params){
                		 	        			if(waithandletotal == null || waithandletotal == 0){
                		 	        				return "";
                		 	        			}else{
                    		 	        			return Math.round((params.value) * 100 / waithandletotal) + '%，'+params.seriesName+'，'+params.value+'户次';
                		 	        			}
                		 	        		},
                		 	            	textStyle:{color:"#9EA7C4"}},
                		 	            	emphasis :{show:true, position:"right",
                    		 	        		formatter:function(params){
                    		 	        			if(waithandletotal == null || waithandletotal == 0){
                    		 	        				return "";
                    		 	        			}else{
                        		 	        			return Math.round((params.value) * 100 / waithandletotal) + '%，'+params.seriesName+'，'+params.value+'户次';
                    		 	        			}
                    		 	        		},
                    		 	            	textStyle:{color:"#9EA7C4"}}
                		 	            	},
                		 	            data: [$jsonData.result5],
                		 	        },
                		 	        {
                		 	            name: '违反质量技术监督相关规定',
                		 	            type: 'bar',
                		 	            xAxisIndex: 0,
                		 	            yAxisIndex: 0,
                		 	            barWidth:'20%',
                                        stack: '待后续处理',
                		 	            itemStyle:{
                		 	            	normal:{color:'#5b9bd5',    //浅蓝
                		 	            	        borderColor: '#fff',
    					                	        borderWidth : 1}},//color设置图例颜色，lineStyle设置边框线
                		 	            label:{normal:{show:true, position:"right",
                		 	        		formatter:function(params){
                		 	        			if(waithandletotal == null || waithandletotal == 0){
                		 	        				return "";
                		 	        			}else{
                    		 	        			return Math.round((params.value) * 100 / waithandletotal) + '%，'+params.seriesName+'，'+params.value+'户次';
                		 	        			}
                		 	        		},
                		 	            	textStyle:{color:"#9EA7C4"}},
                		 	            	emphasis :{show:true, position:"right",
                    		 	        		formatter:function(params){
                    		 	        			if(waithandletotal == null || waithandletotal == 0){
                    		 	        				return "";
                    		 	        			}else{
                        		 	        			return Math.round((params.value) * 100 / waithandletotal) + '%，'+params.seriesName+'，'+params.value+'户次';
                    		 	        			}
                    		 	        		},
                    		 	            	textStyle:{color:"#9EA7C4"}}    					                	        
                		 	            },
                		 	            data: [$jsonData.result4],
                		 	        },
                		 	        {
                		 	        	name: '违反食品药品管理相关规定',
                		 	        	type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'20%',
                		 	        	itemStyle:{normal:{color:'#3a91d2', //中蓝
                		 	        		borderColor: '#fff',
				                	        borderWidth : 1}},
                                        stack: '待后续处理',
                		 	        	label:{normal:{show:true, position:"right",
                		 	        		formatter:function(params){
                		 	        			if(waithandletotal == null || waithandletotal == 0){
                		 	        				return "";
                		 	        			}else{
                    		 	        			return Math.round((params.value) * 100 / waithandletotal) + '%，'+params.seriesName+'，'+params.value+'户次';
                		 	        			}
                		 	        		},
                		 	        		textStyle:{color:"#9EA7C4"}},
                		 	            	emphasis :{show:true, position:"right",
                    		 	        		formatter:function(params){
                    		 	        			if(waithandletotal == null || waithandletotal == 0){
                    		 	        				return "";
                    		 	        			}else{
                        		 	        			return Math.round((params.value) * 100 / waithandletotal) + '%，'+params.seriesName+'，'+params.value+'户次';
                    		 	        			}
                    		 	        		},
                    		 	            	textStyle:{color:"#9EA7C4"}} 
                		 	        	},
                		 	        	data: [$jsonData.result3],
                		 	        }, 
                		 	        {
                		 	        	name: '违反工商行政管理相关规定',
                		 	        	type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'20%',
                                        stack: '待后续处理',
                		 	        	itemStyle:{normal:{color:'#255e91',borderColor: '#fff',//深蓝
				                	        borderWidth : 1}},
                		 	        	label:{normal:{show:true, position:"right",    
                		 	        		formatter:function(params){
                		 	        			if(waithandletotal == null || waithandletotal == 0){
                		 	        				return "";
                		 	        			}else{
                    		 	        			return result2Rate + '%，'+params.seriesName+'，'+params.value+'户次';
                		 	        			}
                		 	        	    },
                		 	        		textStyle:{color:"#9EA7C4"}},
                		 	        		emphasis:{show:true, position:"right",    
                    		 	        		formatter:function(params){
                    		 	        			if(waithandletotal == null || waithandletotal == 0){
                    		 	        				return "";
                    		 	        			}else{
                        		 	        			return result2Rate + '%，'+params.seriesName+'，'+params.value+'户次';
                    		 	        			}
                    		 	        	    },
                    		 	        		textStyle:{color:"#9EA7C4"}}
                		 	        	},
                		 	        	data: [$jsonData.result2],
                		 	        }
                		 	    ]      
                };
                $myChart.setOption(option4_1);
                myChart4_2(disposeData);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }
        // tab4_2 抽查结果情况  2
        function myChart4_2(jsonData) {
            try {
                if(!jsonData){ return; }
                $myChart = echarts.init(document.getElementById('chart4_2'));
                var xdata = ['无需后续处置','停止检查','责令限期整改','发现案件线索','抄告相关部门','其他'];
                var resultData = jsonData;
                var option4_2 = {
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    grid: {
                        show: true,
                        containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                        width: '90%',
                        height: '78%',
                        x: '20',
                        top: '40',
                        borderWidth: 0
                    },
                    calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                    xAxis: [{
                        type: "category",
                        position: 'bottom', //x坐标的位置 显示月份的位置
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            lineStyle: {
                                color: '#90979c' // x 轴线的颜色
                            }
                        },
                        splitLine: {
                            show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                        },
                        axisTick: {
                            show: true, //是否显示x轴坐标刻度 true 显示   false：不显示
                            alignWithLabel: false //文字与刻度是否对齐
                        },
                        splitArea: {
                            show: false
                        },
                        axisLabel: {
                            show: true,
                            interval: 0

                        },
                        data: xdata
                    }],
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true
                        },
                        axisLine: {
                            show: false, //不显示 y 轴竖线
                            lineStyle: {
                                color: '#90979c'
                            }
                        },
                        axisTick: {
                            show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                        },
                        axisLabel: {
                            interval: 0
                        },
                        splitArea: {
                            show: false
                        }

                    }],
                    series: [
                        {
                            name: "后续处置",
                            type: "bar",
                            barMaxWidth: 35,
                            barGap: "10%",
                            itemStyle: {
                                normal: {
                                    color: "#5b9bd5",
                                    label: {
                                        show: false,
                                        textStyle: {
                                            // color: "#5B9CD6"
                                        },
                                        position: "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            data: resultData
                        }
                    ]
                };
                $myChart.setOption(option4_2);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }      

        return {
            yearCheckNum :yearCheckNum,
            checkPersonNum :checkPersonNum,
            myChart4_0: myChart4_0,
            myChart4_1: myChart4_1
        }
    })();


    //变化参数
    var tab4_0_params = { //默认参数值
    	checkRptArea:$("#checkRptArea").val(),
    	rptYear:$("#rptYear").val(),
    	groupFlag:"1"
    };
    var tab4_1_params = { //默认参数值
    	checkRptArea:$("#checkRptArea").val(),
        rptYear:$("#rptYear").val()
    };

    //配置参数
    var tab4_options = {
        //总数
        tab4_num:{id:'',params:{checkRptArea:$("#checkRptArea").val(),rptYear:$("#rptYear").val()},url:'/reg/server/regChartsCheck/getChecktaskTotal'},
        tab4_personNum:{id:'',params:{checkRptArea:$("#checkRptArea").val(),rptYear:$("#rptYear").val(),groupFlag:"1"},url:'/reg/server/regChartsCheck/getCheckPersonTotal'},
        tab4_0:{id:'chart4_0',params:tab4_0_params,url:'/reg/server/regChartsCheck/getChecktaskTotal'},
        tab4_1:{id:'chart4_1',params:tab4_1_params,url:'/reg/server/regChartsCheck/getCheckResultTotal'}
    };

    //事件
    function tab4_bind() {
        util.bindEvents([
			{
			    el: '#checkRptArea,#rptYear', //省份、年份下拉框
			    event: 'change',
			    handler: function () {
			    	_tab4();
			    }
			}            
        ])
    }

    //初始化执行方法
    function _tab4(){
        //头部直接查询部分
        ajaxRequest('', {checkRptArea:$("#checkRptArea").val(),rptYear:$("#rptYear").val()}, tab4_options.tab4_num.url, tab4_model.yearCheckNum);
        ajaxRequest('', {checkRptArea:$("#checkRptArea").val(),rptYear:$("#rptYear").val(),groupFlag:"1"}, tab4_options.tab4_personNum.url, tab4_model.checkPersonNum);
        //中部本年度各地市抽查工作情况
        ajaxRequest('chart4_0', {checkRptArea:$("#checkRptArea").val(),rptYear:$("#rptYear").val(),groupFlag:"1"}, tab4_options.tab4_0.url, tab4_model.myChart4_0);
        //抽查结果情况 4-1
        ajaxRequest('chart4_1', {checkRptArea:$("#checkRptArea").val(),rptYear:$("#rptYear").val()}, tab4_options.tab4_1.url, tab4_model.myChart4_1);
    }
    
    //*************************************tab4  抽查检查“双随机” 结束**************************************************
    
    
    //***************************************tab5  双告知情况   开始**************************************************************
    
    var tab5_model = (function CoolModel() {
    	 function dtCountNum (jsonData,$myChart,params,id){
             try{
            	 var amountObj = jsonData.data;
            	 if(amountObj!= null){
            		 var checkDeptAmount = amountObj.checkDeptAmount==null?0:amountObj.checkDeptAmount;
            		 var pushAmount = amountObj.pushAmount==null?0:amountObj.pushAmount;
            		 var claimAmount = amountObj.claimAmount==null?0:amountObj.claimAmount;
            		 var claimPercent = pushAmount==0?'0':((claimAmount/pushAmount)*100).toFixed(2);
            		 $(".tsbm-item").find("span").text(checkDeptAmount);
            		 $(".yxts-item").find("span").text(pushAmount);
            		 $(".yrl-item").find("span").text(claimAmount);
            		 $(".lyl-item").find("span").text(claimPercent+'%');
            	 }else{
            		 $(".yrl-item,.yxts-item,.yrl-item").find("span").text("0");
            	 }
             }catch (err){
                 window.console && console.log(err);
             }
         }
    	 
    	 // tab5_0 饼图
         function myChart5_0(jsonData,$myChart,params,id) {
             var $jsonData = jsonData.data;
             if(!$jsonData){return;}
            
             //数据转换
             var sjbm = '省级部门：'+$jsonData.proClaimAmount+'条';
             var sbm = '市级部门：'+$jsonData.cityClaimAmount+'条';
             var xjbm = '县级部门：'+$jsonData.countyClaimAmount+'条';
             var totalAll = parseInt($jsonData.proClaimAmount)+
             				parseInt($jsonData.cityClaimAmount)+
             				parseInt($jsonData.countyClaimAmount);
             var sjbmRate = totalAll==0?0:(($jsonData.proClaimAmount/totalAll)*100).toFixed(2);
             var sbmRate = totalAll==0?0:(($jsonData.cityClaimAmount/totalAll)*100).toFixed(2);
             var xjbmRate = totalAll==0?0:(($jsonData.countyClaimAmount/totalAll)*100).toFixed(2);
             //数据封装
             var jsonData = {
                 legend_data:[sjbm,sbm,xjbm],
                 datas:[
                     {value: sjbmRate, name: sjbm},
                     {value: sbmRate, name: sbm},
                     {value: xjbmRate, name:xjbm}]
             };
             try {
                 var option5_0 = {
                     tooltip: {
                         trigger: 'item',  
                         formatter: "{b} 所占比例：{d}%"
                     },
                     
                     legend: {
                         orient: 'vertical',
                         left:'right',
                         top: 'middle',
                         data:jsonData.legend_data,
                         selectedMode:true 
                     },
                     color:['#c1504c','#9bbb58','#8164a3'],
                     series: [
                         {
                             backgroundColor: '#fff',
                             name:'',
                             type:'pie',
                             radius: ['50%', '85%'],
                             center: ['45%', '50%'],
                             avoidLabelOverlap: false,
                             itemStyle: {
     		 	            	normal: {
					                	borderColor: '#fff',
					                	borderWidth : 2
					                },
     		 	             },
                             label: {
                                 normal: {
                                     show:true,//是否显示
                                     position: 'right',//位置  文字描述显示的位置    inner : 在内部
                                     formatter:'{d}%'//获取值 模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。

                                 },
                                 emphasis: {
                                     show: true,
                                     textStyle: {
                                         fontSize: '16',//字体大小  鼠标移入显示的
                                         fontWeight: 'bold'
                                     }
                                 }
                             },
                             labelLine: {
                                 normal: {
                                     show: true, //是否显示线
                                     length:5
                                 }
                             },
                             data:jsonData.datas
                         }
                     ]
                 };
                 $myChart.setOption(option5_0);
             }
             catch (err) {
                 window.console && console.log(err);
             }
         }
         
         function myChart5_1(jsonData,$myChart,params,id) {
             try {
                 var dataList = jsonData.data;
                 var $pushInfo = $("#pushInfo");
                 var xdata = new Array();
                 var pushArrayData = new Array();
                 var claimArrayData = new Array();
                 if (!dataList)return;
                 $pushInfo.empty();
             	 for(var i =0;i<dataList.length;i++){
             		var html = "";
             		html =  "<tr style='height:40px;'>" +
             				"<td>"+dataList[i].dutyDeptName+"</td><td>"+dataList[i].pushCount+"</td>" +
             				"<td>"+dataList[i].claimCount+"</td><td>"+dataList[i].claimRate+"%</td>" +
             			    "</tr>";
             		$pushInfo.append(html);
             	 }
             	 for(var j =dataList.length-1;j>=0;j--){
             		xdata.push(dataList[j].dutyDeptName);
             		pushArrayData.push(dataList[j].pushCount);
             		claimArrayData.push(dataList[j].claimCount);
             	 }
                 var option1_6 = {
                     grid: {
                         show: true,
                         containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                         width: '95%',
                         height: '90%',
                         left: '0',
                         top: '30',
                         borderWidth: 0
                     },
                     tooltip: {
                         trigger: "axis",
                         axisPointer: {
                             type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                         }
                     },
                     legend: {
                         x: 'right',
                         top: '1%',
                         itemWidth: 10,
                         itemHeight: 10,
                         textStyle: {
                             color: '#8287a5' //文字的颜色
                         },
                         data: ['有效推送', '已认领']
                     },
                     yAxis: [{
                    	 name: '单位：条',
                         type: "category",
                         boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                         splitLine: {
                             show: false,   // 坐标轴上的 横线    true:显示  false:不显示
                             lineStyle: {
                                 color: '#8287a5',
                                 width: '0'//坐标线的宽度
                             }
                         },
                         axisLine: {
                             lineStyle: {
                                 type: 'solid',
                                 color: '#8287a5',//坐标线的颜色
                                 width: '0'//坐标线的宽度
                             }
                         },
                         axisLabel: {
                             interval: 0,
                             textStyle: {
                                 color: '#8287a5',//坐标值得具体的颜色
                             }
                         },
                         data: xdata
                     }],
                     xAxis: [{
                         type: "value",
                         splitLine: {
                             show: true   // 坐标轴上的 横线    true:显示  false:不显示
                         },
                         axisLine: {
                             show: false,
                             lineStyle: {
                                 type: 'solid',
                                 color: '#8287a5',//坐标线的颜色
                                 width: '0'//坐标线的宽度
                             }
                         },
                         axisLabel: {
                             interval: 0,
                             textStyle: {
                                 color: '#8287a5',//坐标值具体的颜色

                             }
                         }
                     }],
                     series: [
                         {
                             name: "有效推送",
                             type: "bar",
                             symbol: 'circle',
                             symbolSize: 12,
                             barWidth: 14,//柱图宽度
                             barMaxWidth: 35,
                             barGap: "20%",
                             stack: '条数堆叠',
                             itemStyle: {normal: {color: '#5b9bd5', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
                             data: pushArrayData
                         },
                         {
                             name: "已认领",
                             type: "bar",
                             symbol: 'circle',
                             barWidth: 14,//柱图宽度
                             symbolSize: 12,
                             stack: '条数堆叠',
                             itemStyle: {normal: {color: '#ed7d31', lineStyle: {color: '#2dffd2'}}},//color设置图例颜色，lineStyle设置边框线,
                             data: claimArrayData
                         }
                     ]
                 };
                 $myChart.setOption(option1_6);
             }
             catch (err) {
                 window.console && console.log(err);
             }
         };
         
         // tab5_2 饼图
         function myChart5_2(jsonData,$myChart,params,id) {
             var $jsonData = jsonData.data;
             if(!$jsonData){return;}
             
             //数据转换
             var yclts = '已处理，'+$jsonData.hasHandleCount+'条';
             var yrlts = '已认领，'+$jsonData.claimAmount+'条';
             var wclts = '未处理，'+$jsonData.noClaimCount+'条';
             var ythts = '已退回，'+$jsonData.backCount+'条';
             var jsonData = {
            		 legend_data:[yclts,yrlts,'',wclts,ythts],
                     bigdatas:[
                         {value: $jsonData.hasHandleCount, name: yclts},
                         {value: $jsonData.noClaimCount, name:wclts}],
                     smalldatas:[
                         {value: $jsonData.claimAmount, name: yrlts},
                         {value: $jsonData.backCount, name:ythts}
             ]};
             try {
                 var option5_2 = {
                     tooltip: {
                         trigger: 'item',  //鼠标移入触发的浮动层
                         formatter: "{b} 所占比例：{d}%"
                     },
                     legend: {
                    	 orient:'horizontal',
                         top:'bottom',
                         data:jsonData.legend_data,
                         itemWidth: 15,
                         itemGap:20,
                         selectedMode:true //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                     },
                     color:['#5a9bd5','#8164a3','#9bbb58','#c1504c'],//默认显示的颜色
                     series: [
                         {
                             backgroundColor: '#fff',
                             name:'',
                             type:'pie',
                             radius: ['0%', '65%'],
                             center: ['30%', '40%'],
                             avoidLabelOverlap: false,
                             itemStyle: {
      		 	            	normal: {
 					                	borderColor: '#fff',
 					                	borderWidth : 2
 					                },
      		 	             },
                             label: {
                                 normal: {
                                     show:true,//是否显示
                                     position: 'right',//位置  文字描述显示的位置    inner : 在内部
                                     formatter:'{d}%'//获取值 模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。

                                 },
                                 emphasis: {
                                     show: true,
                                     textStyle: {
                                         fontSize: '16',//字体大小  鼠标移入显示的
                                         fontWeight: 'bold'
                                     }
                                 }
                             },
                             labelLine: {
                                 normal: {
                                     show: true,
                                     length:5
                                 }
                             },
                             data:jsonData.bigdatas
                         },{
                             backgroundColor: '#fff',
                             name:'',
                             type:'pie',
                             radius: ['0%', '50%'],
                             center: ['78%', '40%'],
                             avoidLabelOverlap: false,
                             itemStyle: {
      		 	            	normal: {
 					                	borderColor: '#fff',
 					                	borderWidth : 2
 					                },
      		 	             },
                             label: {
                                 normal: {
                                     show:true,
                                     position: 'right',
                                     formatter:'{d}%'

                                 },
                                 emphasis: {
                                     show: true,
                                     textStyle: {
                                         fontSize: '16',
                                         fontWeight: 'bold'
                                     }
                                 }
                             },
                             labelLine: {
                                 normal: {
                                     show: true,
                                     length:5
                                 }
                             },
                             data:jsonData.smalldatas
                         }
                     ]
                 };
                 $myChart.setOption(option5_2);
             }
             catch (err) {
                 window.console && console.log(err);
             }
         }
         
         // tab5-3 部门认领情况柱状图
         function myChart5_3(jsonData,$myChart,params,id) {
             try {
             	var $jsonData = jsonData.data;
                 if (!$jsonData) {
                     return;
                 }
                 
                 var xdata = new Array();
                 var backCountArray = new Array();
                 var claimCountArray = new Array();
                 var claimRateArray = new Array();
                 for (var i = 0; i < $jsonData.length; i++) {
                     xdata.push(areacodeList($jsonData[i].area));
                     backCountArray.push($jsonData[i].backCount);
                     claimCountArray.push($jsonData[i].claimCount);
                     claimRateArray.push($jsonData[i].claimRate);
                 }
                 
                 var option4_0 = {
                     tooltip: {
                         trigger: "axis",
                         axisPointer: {
                             type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                         },
                         formatter:"{a0}: {c0}<br />{a1}: {c1}<br />{a2}: {c2}%"  	
                     },
                     legend: {
                         x: 'right',
                         textStyle: {
                             color: '#90979c' //文字的颜色
                         },
                         data: ['已退回','已认领', '认领率'],
                         selectedMode: true //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                     },
                     grid: {
                         show: true,
                         containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                         width: '90%',
                         height: '80%',
                         left: '20',
                         top: '60',
                         borderWidth: 0
                     },
                     calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。
                     xAxis: [{
                         type: "category",
                         position: 'bottom', //x坐标的位置 显示年份的位置
                         boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                         axisLine: {
                             show:true,
                             lineStyle: {
                                 color: '#90979c' // x 轴线最下面的横坐标线的颜色
                             }
                         },
                         splitLine: {
                             show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                         },
                         axisTick: {
                             show: false, //是否显示x轴坐标刻度 true 显示   false：不显示
                             alignWithLabel: true //文字与刻度是否对齐
                         },
                         splitArea: {
                             show: false
                         },
                         axisLabel: {
                             show: true,
                             interval: 0
                             //rotate:40  //倾斜显示*/
                         },
                         data:xdata
                     }],
                     yAxis: [
                         {
                             name: '单位：条',
                             type: "value",
                             splitLine: {
                                 show: true   // 坐标轴上的 横线    true:显示  false:不显示
                             },
                             axisLine: {
                                 show: false, // y 轴竖线   false：不显示 true：显示
                                 lineStyle: {
                                     color: '#90979c'
                                 }
                             },
                             axisTick: {
                                 show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                             },
                             axisLabel: {
                                 interval: 0

                             },
                             splitArea: {
                                 show: false
                             },
                             splitNumber: 10  //分段数目 竖向
                         },
                         {
                             type: 'value',
                             name: '百分比',
                             position: 'right',
                             axisTick: {
                                 show: false //是否显示x轴坐标刻度  true 显示   false：不显示
                             },
                             axisLine: {    // y 轴竖线   false：不显示 true：显示
                                 show:false,
                                 lineStyle: {
                                     color: '#90979c'
                                 }
                             },
                             splitLine: {
                                 show: false //网格x轴上的 竖线 |  true 显示   false 不显示
                             },
                             axisLabel: {
                                 formatter: '{value}%'
                             }
                         }
                     ],
                     series: [
                         {
                         	name: "已认领",
                         	type: "bar",
                         	symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                         	symbolSize:12,
                         	barMaxWidth: 20,
                         	barWidth : 12,//柱图宽度
                         	stack: '条数堆叠',
                         	itemStyle: {
                         		normal: {
                         			color: "#5b9bd5",
                         			label: {
                         				show: false,
                         				textStyle: {
                         					// color: "#5B9CD6"
                         				},
                         				position: "inside",
                         				formatter: function(p) {
                         					return p.value > 0 ? (p.value) : '';
                         				}
                         			}
                         		}
                         	},
                         	data: claimCountArray
                         },{
                             name: "已退回",
                             type: "bar",
                             symbol:'circle', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                             symbolSize:12,
                             barMaxWidth: 20,
                             barWidth : 12,//柱图宽度
                             stack: '条数堆叠',
                             itemStyle: {
                                 normal: {
                                     color: "#70ad47",
                                     label: {
                                         show: false,
                                         textStyle: {
                                             // color: "#5B9CD6"
                                         },
                                         position: "inside",
                                         formatter: function(p) {
                                             return p.value > 0 ? (p.value) : '';
                                         }
                                     }
                                 }
                             },
                             data: backCountArray
                         },
                         {
                             name: "认领率",
                             type: "line",
                             smooth:false,
                             barMaxWidth: 20,
                             barWidth : 12,//柱图宽度
                             yAxisIndex: 1,
                             symbolSize: '0',
                             symbol: 'circle',
                             itemStyle: {
                                 normal: {
                                     color: "#f85c5f",
                                     //barBorderRadius: 10,
                                     label: {
                                         show: false,
                                         position: "top",
                                         formatter: '{c}%'
                                     },
                                     lineStyle:{
                                         width:2,
                                         type:'dotted'  //'dotted'虚线 'solid'实线
                                     }
                                 }
                             },
                             data:claimRateArray
                         }
                     ]
                 };
                 $myChart.setOption(option4_0);
             }
             catch (err) {
                 window.console && console.log(err);
             }
         }
         
    	 return {
    		 dtCountNum :dtCountNum,
    		 myChart5_0: myChart5_0,
    		 myChart5_1: myChart5_1,
    		 myChart5_2: myChart5_2,
    		 myChart5_3: myChart5_3
         }
    })();
    
    //配置参数
    var tab5_options = {
        //总数
        tab5_num:{id:'',params:{areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()},url:'/reg/server/dtinfocharts/getDtcommonData'},
        tab5_0:{id:'chart5_0',params:{areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()},url:'/reg/server/dtinfocharts/getDeptClaimData'},
        tab5_1:{id:'chart5_1',params:{areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()},url:'/reg/server/dtinfocharts/getClaimInfoForDutyData'},
        tab5_2:{id:'chart5_2',params:{areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()},url:'/reg/server/dtinfocharts/getDutyClaimOptData'},
        tab5_3:{id:'chart5_3',params:{dutyDeptCode:$("#dutyDeptCode").val()},url:'/reg/server/dtinfocharts/getAreaClaimData'}
    };
    
    //初始化执行方法
    function _tab5(){
        //头部直接查询部分
        ajaxRequest(tab5_options.tab5_num.id, {areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()}, tab5_options.tab5_num.url, tab5_model.dtCountNum);
        ajaxRequest(tab5_options.tab5_0.id, {areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()}, tab5_options.tab5_0.url, tab5_model.myChart5_0);
        ajaxRequest(tab5_options.tab5_1.id, {areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val()}, tab5_options.tab5_1.url, tab5_model.myChart5_1);
        ajaxRequest(tab5_options.tab5_2.id, {areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val(),dutyDeptCode:$("#dutyDeptCode").val()}, tab5_options.tab5_2.url, tab5_model.myChart5_2);
        ajaxRequest(tab5_options.tab5_3.id, {dutyDeptCode:$("#dutyDeptCode").val(),dtyear:$("#selectyear").val()}, tab5_options.tab5_3.url, tab5_model.myChart5_3);
    }
    
    //事件
    function tab5_bind() {
        util.bindEvents([
			{
			    el: '#selectarea,#selectyear', //省份、年份下拉框
			    event: 'change',
			    handler: function () {
			    	 $(".tsbm-item,.yrl-item,.yxts-item,.yrl-item,.lyl-item")
			    	 .find("span").text("获取中...");
			    	_tab5();
			    }
			},{
			    el: '#dutyDeptCode', //省份、年份下拉框
			    event: 'change',
			    handler: function () {
			    	ajaxRequest(tab5_options.tab5_2.id, {areaCode:$("#selectarea").val(),dtyear:$("#selectyear").val(),dutyDeptCode:$("#dutyDeptCode").val()}, tab5_options.tab5_2.url, tab5_model.myChart5_2);
			    	ajaxRequest(tab5_options.tab5_3.id, {dutyDeptCode:$("#dutyDeptCode").val(),dtyear:$("#selectyear").val()}, tab5_options.tab5_3.url, tab5_model.myChart5_3);
			    }
			}            
        ])
    }
    
    
  //***************************************tab5  双告知情况   结束**************************************************************
    

    //页面初始化：
    init();
    //触发事件
    function openBind(){
        tab1_bind(); //tab1事件
        tab2_bind(); //tab2事件
        tab3_bind(); //tab3事件
        tab4_bind(); //tab4事件（抽查检查“双随机”）
        tab5_bind(); //tab5 双告知情况 
    }

    function init(){

        var tabId = window._config.tabId;

        if(tabId=='1'){ var $this = $('.js-sub-tab').find('li[data-tab="_tab1"]'); tabInit($this);}
        if(tabId=='2'){ var $this = $('.js-sub-tab').find('li[data-tab="_tab2"]'); tabInit($this);}
        if(tabId=='3'){ var $this = $('.js-sub-tab').find('li[data-tab="_tab3"]'); tabInit($this);}
        if(tabId=='4'){ var $this = $('.js-sub-tab').find('li[data-tab="_tab4"]'); tabInit($this);}
        if(tabId=='5'){ var $this = $('.js-sub-tab').find('li[data-tab="_tab5"]'); tabInit($this);}

        openBind();
    }



    //tab页面获取的参数展示对应的tab页面进行显示
    function tabInit($this){

        var tabName = $this.data('tab');
        //是否已经初始化
        var _init = $this.attr('init');

        $this.addClass('active').siblings().removeClass('active');

        $('.sub-items .item-box').hide(); $('.sub-items').find('.'+tabName).show();

        if (tabName == '_tab1') { if (_init == '0') { $this.attr('init', '1'); _tab1() } } ;
        if (tabName == '_tab2') { if (_init == '0') { $this.attr('init', '1'); _tab2() } } ;
        if (tabName == '_tab3') { if (_init == '0') { $this.attr('init', '1'); _tab3() } } ;
        if (tabName == '_tab4') { if (_init == '0') { $this.attr('init', '1'); _tab4() } } ;
        if (tabName == '_tab5') { if (_init == '0') { $this.attr('init', '1'); _tab5() } } ;
    }


    //tab页面切换：
    $('.js-sub-tab li').click(function () {

        tabInit($(this));
        //不使用这种方法是怕以后出现下标发生变化而造成切换错误！
        //$('.sub-items .item-box').eq($(this).index()).show().siblings().hide();
    });

    //页面加载层  公共调用部分
    function page_loading(){
        // 延迟加载初始化
        layer.msg("努力加载中,请稍等......",{shade: [0.8, '#393D49'],icon: 6,time:0});
        var timer = null;clearTimeout(timer);
        timer = setTimeout(function(){layer.closeAll();}, 2000);  //2秒后执行
    }








});