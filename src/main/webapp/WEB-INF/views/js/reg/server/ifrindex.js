/**
 * Created by Administrator on 2017-07-24.
 */
require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'echarts',
    'jquery.serialize'
], function (layer, util, http,echarts) {

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
            $myChart.showLoading({ text: '加载中...', color: '#c23531', textColor: '#000', maskColor: 'rgba(255, 255, 255, 0.2)', zlevel: 0,　effect : 'whirling' });
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

//############################################# tab1 ################################################################



//############################################# tab3 ################################################################
    //模块结构图封装：
    var tab3_model = (function CoolModel() {
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
                                    position: 'inner',//位置
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
                                    show: false
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
                        borderWidth: 0,
                        top: 110,
                        bottom: 95
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
                        borderWidth: 0,
                        top: 110,
                        bottom: 95
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
        tab3_0:{params:tab3_params,url:'/reg/server/echartsindexrpt/getEntReportJsonData'}, //非图表

        tab3_1:{id:'chart3_1',params:tab3_params,url:'/reg/server/echartsindexrpt/getThreeYearJsonData'},
        tab3_2:{id:'chart3_2',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportBsfsJsonData'},
        tab3_3:{id:'chart3_3',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportTrendJsonData'},
        tab3_4:{id:'chart3_4',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportJsonDataByArea'},
        tab3_5:{id:'chart3_5',params:tab3_params,url:'/reg/server/echartsindexrpt/getYearReportIndustryphyJsonData'}
    };

    function _tab3(){
        page_loading(); //调用加载层
        tab3_yearReportSum(tab3_params);//年报数
        ajaxRequest(tab3_options.tab3_1.id, tab3_options.tab3_1.params, tab3_options.tab3_1.url, tab3_model.myChart3_1);
        ajaxRequest(tab3_options.tab3_2.id, tab3_options.tab3_2.params, tab3_options.tab3_2.url, tab3_model.myChart3_2);
        ajaxRequest(tab3_options.tab3_3.id, tab3_options.tab3_3.params, tab3_options.tab3_3.url, tab3_model.myChart3_3);
        ajaxRequest(tab3_options.tab3_4.id, tab3_options.tab3_4.params, tab3_options.tab3_4.url, tab3_model.myChart3_4);
        ajaxRequest(tab3_options.tab3_5.id, tab3_options.tab3_5.params, tab3_options.tab3_5.url, tab3_model.myChart3_5);
    }

    //年报数
    function tab3_yearReportSum(tab3_params){
        $('#js-tab-sum1').text("获取中...");$('#js-tab-sum2').text("获取中...");$('#js-tab-sum3').text("获取中...");
        if (tab3_params) {
            ajaxRequest('', tab3_params, tab3_options.tab3_0.url, dataSum)
        }
        function dataSum(data){
            if(data.data){
                var sum1 = data.data[0].yrAmountSure;
                var sum2 = data.data[0].isreported;
                var sum3 = data.data[0].usualreportRay;
                $('#js-tab-sum1').text(!isNaN(sum1)?sum1:'');
                $('#js-tab-sum2').text(!isNaN(sum2)?sum2:'');
                $('#js-tab-sum3').text(!isNaN(sum3)?sum3+"%":'');
            }
        }
    }

    //事件
    function tab3_bind() {
        util.bindEvents([
            {
                el: '#js-tab3-serarch',  //查询
                event: 'click',
                handler: function () {

                    var $yearValue = $('#js-tab3-year').val();//获取选择的年份
                    var $entTypeCatg = $("#js-tab3-type").find('.cur').data('value');

                    var $areaCode = $("#js-select-city").val(); //判断是否是省局登录 省局登录可以进行选择地级市
                    if($areaCode){tab3_params['areaCode'] =$areaCode;}

                    if(!($yearValue && $entTypeCatg)){layer.msg("查询参数为空,请联系系统管理员进行处理!");return ;}

                    //改变参数传值
                    tab3_params['year'] =$yearValue;//可变参数
                    tab3_params['entTypeCatg'] =$entTypeCatg;//可变参数

                    tab3_yearReportSum(tab3_params);
                    ajaxRequest(tab3_options.tab3_2.id,tab3_options.tab3_2.params,tab3_options.tab3_2.url,tab3_model.myChart3_2);
                    ajaxRequest(tab3_options.tab3_3.id,tab3_options.tab3_3.params,tab3_options.tab3_3.url,tab3_model.myChart3_3);
                    ajaxRequest(tab3_options.tab3_4.id,tab3_options.tab3_4.params,tab3_options.tab3_4.url,tab3_model.myChart3_4);
                    ajaxRequest(tab3_options.tab3_5.id,tab3_options.tab3_5.params,tab3_options.tab3_5.url,tab3_model.myChart3_5);


                }
            },
            {
                el: '.js-tab-entTypeCatg',  //主体类型切换
                event: 'click',
                handler: function () {
                    $('#js-tab3-type > .type-sele').removeClass('cur'); $(this).addClass('cur');
                    var $entTypeCatg = $("#js-tab3-type").find('.cur').data('value');
                    tab3_params['entTypeCatg'] =$entTypeCatg;//可变参数
                    ajaxRequest(tab3_options.tab3_1.id,tab3_options.tab3_1.params,tab3_options.tab3_1.url,tab3_model.myChart3_1);
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
//############################################# tab4 ################################################################



    //页面初始化：
    init();
    function init(){
        _tab3();
        openBind();
    }
    //触发事件
    function openBind(){
        tab3_bind(); //tab3事件
    }



    //页面加载层  公共调用部分
    function page_loading(){
        // 延迟加载初始化
        layer.msg("努力加载中,请稍等......",{shade: [0.8, '#393D49'],icon: 6,time:0});
        var timer = null;clearTimeout(timer);
        timer = setTimeout(function(){layer.closeAll();}, 2000);  //2秒后执行
    }








});