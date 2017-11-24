/**
 * Created by Administrator on 2017-07-24.
 */
require(['component/iframeLayer', 'common/util', 'common/http', 'echarts',
    'jquery.serialize', 'countUp'], function (layer, util, http, echarts) {

    var $myChart1_0;
    var $myChart1_1;
    var $myChart1_3;
    var $myChart1_4;
    var $myChart1_5;
    var $myChart1_5_1;
    var $myChart1_5_2;
    var $myChart1_6;
    var $myChart;

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

    /**
     * ajax同步获取数据 公共请求
     * @param id  对象id
     * @param params  //查询参数值
     * @param url     //请求路径
     * @param callback
     * @param tab_params  //可变参数 一般用于修改文字和颜色
     */
    function ajaxRequest(index, id, params, url, callback) {
        http.httpRequest({
            url: url,
            serializable: false,
            data: params,
            type: 'post',
            async: true, //异步
            beforeSend: function () { //覆盖阴影层
            },
            success: function (data) {
                if (data.status == "success") {
                    if (callback)callback.call(this, data, params, id);
                }
            },
            error: function () {
                layer.msg("系统异常,请联系管理人员!")
            }
        });

    }

    //模块结构图封装：
    var tab1_model = (function CoolModel() {
        //图一 直接查询部分  在册总数
        function totalNum(jsonData, params, id) {
            try {
                var $jsonData = jsonData.data;
                if (!$jsonData) {
                    return;
                }

                var ztCount = (Array(8).join('0') + $jsonData.ztCount).slice(-8);

                var numinit = function (num) {
                    $.each(ztCount.split(''), function (i, v) {
                        $('.js-all ul').eq(i).find('.inn').text(v);
                    });
                };
                var getnumChange = function (bnum, num) {
                    // num=(Math.random()+'').slice(-8);
                    var bnumarr = bnum.split('').reverse();
                    $('.js-all ul').find('li').removeClass('before');
                    $.each(num.split('').reverse(), function (i, v) {
                        if (v != bnumarr[i]) {
                            $('.js-all ul').eq(7 - i).find('li:last .inn').text(v);
                            $('.js-all ul').eq(7 - i).find('li:first').addClass('before');
                            $('.js-all ul').eq(7 - i).find('li:last').prependTo($('.js-all ul').eq(7 - i));
                        }
                    });
                };

                $('.js-all').data('allnum') ? getnumChange($('.js-all').data('allnum'), ztCount) : numinit(ztCount);
                $('.js-all').data('allnum', ztCount);


                $("#yearAddRoate").text($jsonData.yearAddRoate + "%");
            } catch (err) {
                window.console && console.log(err);
            }
        }

        // 图一 右 主体情况 饼图
        function myChart1_0(jsonData, params, id) {
            $myChart1_0 = echarts.init(document.getElementById(id));
            var $jsonData = jsonData.data;
            if (!$jsonData) {
                return;
            }
            var total = $jsonData.qyCount + $jsonData.gtCount + $jsonData.nzCount;
            //数据转换
            var qy = '企业' + Math.round(($jsonData.qyCount) * 100 / total) + '%';
            var gt = '个体' + Math.round(($jsonData.gtCount) * 100 / total) + '%';
            var nz = '农专' + (100 - (Math.round(($jsonData.qyCount) * 100 / total) + Math.round(($jsonData.gtCount) * 100 / total))) + '%';
            //数据封装
            var jsonData = {
                legend_data: [qy, gt, nz],
                datas: [
                    {value: $jsonData.qyCount, name: qy},
                    {value: $jsonData.gtCount, name: gt},
                    {value: $jsonData.nzCount, name: nz}]
            };
            try {
                var option1_0 = {
                    tooltip: { //提示框组件。全局
                        trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
                    },
                    legend: {
                        show: true,
                        orient: 'vertical',
                        x: '65%',
                        top: 'middle',
                        itemWidth: 10,
                        itemHeight: 10,
                        textStyle: {color: '#8287a5'},
                        data: jsonData.legend_data,
                        selectedMode: false //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                    },
                    color: ['#00b4ff', '#e84141', '#2dffd2'],//默认显示的颜色
                    series: [
                        {
                            name: '主体在册情况',
                            type: 'pie',
                            center: ['35%', '55%'],//设置图形坐标位置，横纵坐标
                            radius: ['50%', '71%'],
                            label: {
                                normal: {
                                    show: false,
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false,
                                }
                            },
                            data: jsonData.datas
                        }
                    ]
                };
                $myChart1_0.setOption(option1_0);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }

        // 图一 下 主体当年月份新设消亡图
        function myChart1_1(jsonData, params, id) {
            $myChart1_1 = echarts.init(document.getElementById(id));
            try {
                var $datas = jsonData.data;
                if (!$datas) {
                    return;
                }
                var mounths = $datas.mounths;
                var xsList = $datas.xsList;
                var xwList = $datas.xwList;

                var option1_2 = {
                    title: {
                        text: '主体“新设/注销”趋势',
                        x: '20',
                        textStyle: {
                            color: '#0099cc', //文字的颜色
                            fontWeight: 'normal',
                            fontSize: 16,
                            lineHeight: 30
                        }
                    },
                    legend: {
                        x: '76%',
                        textStyle: {
                            color: '#8287a5' //文字的颜色
                        },
                        data: ['新设', '消亡']
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
                    tooltip: {
                        trigger: "axis",
                    },
                    xAxis: [{
                        type: "category",
                        boundaryGap: false, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        splitLine: {show: false},//网格x轴上的 竖线 |  true 显示   false 不显示
//                      axisTick: {show: false},//坐标轴刻度
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5',//坐标值得具体的颜色

                            }
                        },
                        data: mounths
                    }],
                    yAxis: [
                        {
//                            name: '单位：户',
                            type: "value",
                            splitLine: {
                                show: true,   // 坐标轴上的 横线    true:显示  false:不显示
                                lineStyle: {
                                    color: '#232d53',
                                    width: '1'//坐标线的宽度
                                }
                            },
                            axisLine: {
                                show: false,
                                lineStyle: {
                                    type: 'solid',
                                    color: '#8287a5',//坐标线的颜色
                                    width: '1'//坐标线的宽度
                                }
                            },
                            axisLabel: {
                                interval: 0,
                                textStyle: {
                                    color: '#8287a5',//坐标值得具体的颜色

                                }
                            },
                        }
                    ],
                    series: [
                        {
                            name: '新设',
                            type: 'line',
                            smooth: true, //是否平滑曲线显示
                            symbolSize: '5',//标记大小：默认为4，即折线拐点处标记
                            symbol: 'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            itemStyle: {normal: {color: '#00b4ff', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
                            data: xsList,
                            areaStyle: {
                                normal: {
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 0.5, [{
                                        offset: 0,
                                        color: 'rgba(0, 180, 255, 0.5)'
                                    }, {
                                        offset: 1,
                                        color: 'rgba(0, 180, 255,0.001)'
                                    }])
                                }
                            }
                        },
                        {
                            name: '消亡',
                            type: 'line',
                            smooth: true, //是否平滑曲线显示
                            symbolSize: '5',//标记大小：默认为4，即折线拐点处标记
                            symbol: 'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            itemStyle: {normal: {color: '#e84141', lineStyle: {color: '#e84141'}}},//color设置图例颜色，lineStyle设置边框线
                            data: xwList,
                            areaStyle: {
                                normal: {
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 0.8, [{
                                        offset: 0,
                                        color: 'rgba(232, 65, 65, 0.5)'
                                    }, {
                                        offset: 1,
                                        color: 'rgba(232, 65, 65,0.001)'
                                    }])
                                }
                            }
                        }
                    ]
                };
                $myChart1_1.setOption(option1_2);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }

        //图3  主体动态 直接查询部分
        function tab3_num(jsonData, params, id) {
            try {
                var $jsonData = jsonData.data;
                if (!$jsonData) {
                    return;
                }
                var xslist = $jsonData.xsList;
                var xwlist = $jsonData.xwList;
                var length = xslist.length;
                for (var i = 0; i < length; i++) {
                    $("#dxs" + i).text(xslist[i]);
                    $("#dzx" + i).text(xwlist[i]);
                }
                jQuery(function ($) {
                    $(".big-timer").countTo({
                        lastSymbol: "", //显示在最后的字符
                        from: 0,  // 开始时的数字
                        speed: 1000,  // 总时间
                        refreshInterval: 100,  // 刷新一次的时间
                        beforeSize: 0, //小数点前最小显示位数，不足的话用0代替
                        decimals: 0,  // 小数点后的位数，小数做四舍五入
                        onUpdate: function () {
                        },  // 更新时回调函数
                        onComplete: function () {
                            for (i in arguments) {
                                //console.log(arguments[i]);
                            }
                        }
                    });
                });
            } catch (err) {
                window.console && console.log(err);
            }
        }

        // tab1_3 主体动态 图3下 当日各地市新设注销数据
        function myChart1_3(jsonData, params, id) {
            $myChart1_3 = echarts.init(document.getElementById(id));
            try {
                var $datas = jsonData.data;
                if (!$datas) {
                    return;
                }
                var xdata = [];

                var names = $datas.names;
                var xslist = $datas.xsList;
                var xwlist = $datas.xwList;
                var length = names.length;
                var alllist = xslist.concat(xwlist);
                var xarisMax = arrMax(alllist);

                function arrMax(arr) {
                    var max = arr[0];
                    var len = arr.length;
                    for (var i = 1; i < len; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                    }
                    return max;
                }

                xslist.forEach(function (item, index, arr) {
                    arr[index] = -item;
                });
                for (var i = 0; i < length; i++) {
                    xdata.push(areacodeList(names[i]));
                }

                var option1_3 = {
                    grid: {
                        show: true,
                        containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                        width: '90%',
                        height: '90%',
                        left: '2.4%',
                        top: '15',
                        borderWidth: 0
                    },
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        },
                        formatter: function (v) {
                            return v[0].axisValue + '<br/>' + v[0].seriesName + ': ' + -v[0].value + '<br/>' + v[1].seriesName + ': ' + v[1].value;
                        },
                    },

                    yAxis: [{
                        type: "category",
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        axisLine: {
                            show: true,
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisTick: {
                            show: false
                        },
                        splitLine: {show: false},//网格x轴上的 竖线 |  true 显示   false 不显示
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5',//坐标值得具体的颜色

                            }
                        },
                        data: xdata
                    }],
                    xAxis: [
                        {
                            type: "value",
                            position: 'bottom',
                            min: -(Math.round(xarisMax / 5) * 6),
                            max: (Math.round(xarisMax / 5) * 6),
                            interval: Math.round(xarisMax / 5),
                            splitLine: {
                                show: true,   // 坐标轴上的 横线    true:显示  false:不显示
                                lineStyle: {
                                    color: '#232d53',
                                    width: '1'//坐标线的宽度
                                }
                            },
                            axisLine: {
                                show: false,
                                lineStyle: {
                                    type: 'solid',
                                    color: '#8287a5',//坐标线的颜色
                                    width: '1'//坐标线的宽度
                                }
                            },
                            axisLabel: {
                                interval: 0,
                                formatter: function (value) {
                                    if (value < 0) {
                                        value = Math.abs(value);
                                    }
                                    return value;
                                },
                                textStyle: {
                                    color: '#8287a5',//坐标值得具体的颜色

                                }
                            }
                        }
                    ],
                    series: [
                        {
                            "name": "新设立",
                            "type": "bar",
                            itemStyle: {normal: {color: '#00b4ff', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
                            barWidth: '5',
                            "barCategoryGap": 20, //类目柱体间间距
                            "data": xslist,
                            stack: true
                        },
                        {
                            "name": "注销",
                            "type": "bar",
                            itemStyle: {normal: {color: '#e84141', lineStyle: {color: '#e84141'}}},//color设置图例颜色，lineStyle设置边框线
                            barWidth: '5', //柱体宽度（）  div大小确定之后，与barCategoryGap两者设置只有一者有效
                            "barCategoryGap": 20, //类目柱体间间距
                            "data": xwlist,
                            stack: true
                        }

                    ]
                };
                $myChart1_3.setOption(option1_3);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }

        //图4 直接查询部分  近3年主体增长情况
        function tab4_num(jsonData, params, id) {
            try {
                var $jsonData = jsonData.data;
                if (!$jsonData) {
                    return;
                }
                var years = $jsonData.years;
                var addCountList = $jsonData.addCountList;
                var addRoateList = $jsonData.addRoateList;
                var length = years.length;
                for (var i = 0; i < length; i++) {
                    $("#js-year" + i).text(years[i]);
                    $("#js-addroate" + i).text(addRoateList[i] + "%");
                    $("#js-addnum" + i).text(addCountList[i]);
                }
            } catch (err) {
                window.console && console.log(err);
            }
        }

        // tab1_4 主体近6年增长情况
        function myChart1_4(jsonData, params, id) {
            $myChart1_4 = echarts.init(document.getElementById(id));
            try {
                var $jsonData = jsonData.data;
                if (!$jsonData) {
                    return;
                }
                var years = $jsonData.years;
                var addCountList = $jsonData.addCountList;
                var addRoateList = $jsonData.addRoateList;
                var option1_4 = {
                    grid: {
                        show: true,
                        containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                        width: '90%',
                        height: '80%',
                        left: '20',
                        top: '30',
                        borderWidth: 0
                    },
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
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
                        data: ['增长户数', '增长率']
                    },
                    calculable: true,
                    xAxis: [{
                        type: "category",
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        splitLine: {
                            show: false,   // 坐标轴上的 横线    true:显示  false:不显示
                            lineStyle: {
                                color: '#8287a5',
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLine: {
                            show: false,
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5',//坐标值得具体的颜色

                            }
                        },
                        data: years
                    }],
                    yAxis: [{
                        type: "value",
                        position: 'left',
                        splitLine: {
                            show: true,   // 坐标轴上的 横线    true:显示  false:不显示
                            lineStyle: {
                                color: '#232d53',
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLine: {
                            show: false,
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5',//坐标值得具体的颜色

                            }
                        }
                    },
                        {
                            type: "value",
                            position: 'right',
                            splitLine: {
                                show: false,   // 坐标轴上的 横线    true:显示  false:不显示
                                lineStyle: {
                                    color: '#232d53',
                                    width: '1'//坐标线的宽度
                                }
                            },
                            axisLine: {
                                show: false,
                                lineStyle: {
                                    type: 'solid',
                                    color: '#8287a5',//坐标线的颜色
                                    width: '1'//坐标线的宽度
                                }
                            },
                            axisLabel: {
                                interval: 0,
                                textStyle: {
                                    color: '#8287a5',//坐标值得具体的颜色

                                },
                                formatter: function (value) {
                                    return value + '%'
                                }
                            }
                        }
                    ],
                    series: [
                        {
                            name: "增长户数",
                            type: "bar",
                            yAxis: 1,
                            itemStyle: {normal: {color: '#00b4ff', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
                            "barCategoryGap": "40", //类目柱体间间距
                            "data": addCountList
                        },
                        {
                            name: "增长率",
                            type: "line",
                            yAxisIndex: 1,
                            smooth: true,
                            symbolSize: '0',
                            symbol: 'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
                            itemStyle: {normal: {color: '#e84141', lineStyle: {color: '#e84141'}}},//color设置图例颜色，lineStyle设置边框线
                            data: addRoateList
                        }
                    ]
                };
                $myChart1_4.setOption(option1_4);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }

        //图5 直接查询部分  整体股东分布
        function tab5_num(jsonData, params, id) {
            try {
                var $jsonData = jsonData.data;
                if (!$jsonData) {
                    return;
                }
                $("#js_entCount").text($jsonData.entcount);
                $("#js_percount").text($jsonData.percount);
                $("#js_entrate").text(Math.round($jsonData.entrate) + "%");
                $("#js_perrate").text((100 - Math.round($jsonData.entrate)) + "%");
            } catch (err) {
                window.console && console.log(err);
            }
        }


        // 图5-1  投资分布  中部  区域分布
        function myChart1_5(jsonData, params, id) {
            $myChart1_5 = echarts.init(document.getElementById(id));
            try {
                var $datas = jsonData.data;
                if (!$datas)return;
                var xdata = [];
                var names = $datas.names;
                var entCountList = $datas.entCountList;
                var perCountList = $datas.perCountList;
                var entRateList = $datas.entRateList;
                var perRateList = $datas.perRateList;
                var length = names.length;
                //处理x轴显示
                for (var i = 0; i < length; i++) {
                    xdata.push(areacodeList(names[i]));
                }

                var option1_5 = {
                    title: {
                        text: '区域分布',
                        x: 'left',
                        top: 3,
                        textStyle: {
                            color: '#0099cc', //文字的颜色
                            fontWeight: 'normal',
                            fontSize: 16,
                            lineHeight: 18
                        }
                    },
                    grid: {
                        show: true,
                        containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                        width: '98%',
                        height: '65%',
                        left: '5',
                        top: '40',
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
                        data: ['法人股东', '自然人股东']
                    },
                    xAxis: [{
                        type: "category",
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        splitLine: {
                            show: false,   // 坐标轴上的 横线    true:显示  false:不显示
                            lineStyle: {
                                color: '#8287a5',
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLine: {
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
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
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true,   // 坐标轴上的 横线    true:显示  false:不显示
                            lineStyle: {
                                color: '#232d53',
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLine: {
                            show: false,
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5',//坐标值具体的颜色

                            },
                            formatter: function (value) {
                                return value + '%'
                            }
                        }
                    }],
                    series: [
                        {
                            name: "法人股东",
                            type: "bar",
                            symbol: 'circle',
                            symbolSize: 12,
                            barWidth: 12,//柱图宽度
                            barMaxWidth: 35,
                            barGap: "8%",
                            itemStyle: {normal: {color: '#00b4ff', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
                            data: entRateList
                        },
                        {
                            name: "自然人股东",
                            type: "bar",
                            symbol: 'circle',
                            barWidth: 12,//柱图宽度
                            symbolSize: 12,
                            itemStyle: {normal: {color: '#2dffd2', lineStyle: {color: '#2dffd2'}}},//color设置图例颜色，lineStyle设置边框线,
                            data: perRateList
                        }
                    ]
                };
                $myChart1_5.setOption(option1_5);
            }
            catch (err) {
                window.console && console.log(err);
            }
        };

        // 图5 下左1 投资分布 法人行业占比
        function myChart1_5_1(jsonData, params, id) {
            $myChart1_5_1 = echarts.init(document.getElementById(id));
            var $jsonData = jsonData.data;
            if (!$jsonData) {
                return;
            }
            var datas = [];
            var ledatas = [];
            var list = $jsonData;
            for (var i = 0; i < list.length; i++) {
                ledatas.push(list[i].hymc);
                datas.push({value: list[i].hyrate, name: list[i].hymc});
            }
            try {
                var option1_0 = {
                    title: {
                        text: '法人股东\n行业占比',
                        x: 'center',
                        y: 'middle',
                        textStyle: {
                            color: '#fff', //文字的颜色
                            fontSize: '14',
                            align: 'center',
                            fontWeight: 'normal',
                            lineHeight: 18
                        }
                    },
                    tooltip: { //提示框组件。全局
                        trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
                    },
                    legend: {
                        show: false,
                        orient: 'vertical',
                        x: '70%',
                        itemWidth: 10,
                        itemHeight: 10,
                        textStyle: {color: '#8287a5'},
                        selectedMode: false, //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                        data: ledatas
                    },
                    color: ['#0070c0', '#e84141', '#a5a5a5', '#ffc000', '#00b4ff', '#2dffd2'],//默认显示的颜色
                    series: [
                        {
                            name: '法人股东行业占比',
                            type: 'pie',
                            center: ['50%', '50%'],//设置图形坐标位置，横纵坐标
                            radius: ['65%', '84%'],
                            label: {
                                normal: {
                                    show: false,
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false,
                                }
                            },
                            data: datas
                        }
                    ]
                };
                $myChart1_5_1.setOption(option1_0);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }

        // 图5 下右 投资分布 自然人行业占比
        function myChart1_5_2(jsonData, params, id) {
            $myChart1_5_2 = echarts.init(document.getElementById(id));
            var $jsonData = jsonData.data;
            if (!$jsonData) {
                return;
            }
            var datas = [];
            var ledatas = [];
            var list = $jsonData;
            for (var i = 0; i < list.length; i++) {
                ledatas.push(list[i].hymc);
                datas.push({value: list[i].hyrate, name: list[i].hymc});
            }
            try {
                var option1_0 = {
                    title: {
                        text: '自然人股东\n行业占比',
                        x: '10%',
                        y: 'middle',
                        textStyle: {
                            color: '#fff', //文字的颜色
                            fontSize: '14',
                            align: 'center',
                            fontWeight: 'normal',
                            fontHeight: 18,
                        }
                    },
                    tooltip: { //提示框组件。全局
                        trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
                    },
                    legend: {
                        show: true,
                        orient: 'vertical',
                        right: 10,
                        top: 'middle',
                        itemWidth: 10,
                        itemHeight: 10,
                        textStyle: {color: '#8287a5'},
                        selectedMode: false, //图例选择的模式，控制是否可以通过点击图例改变系列的显示状态。默认开启图例选择，可以设成 false 关闭。
                        itemGap: 7,
                        data: ledatas
                    },
                    color: ['#0070c0', '#e84141', '#a5a5a5', '#ffc000', '#00b4ff', '#2dffd2'],//默认显示的颜色
                    series: [
                        {
                            name: '自然人股东行业占比',
                            type: 'pie',
                            center: ['20%', '50%'],//设置图形坐标位置，横纵坐标
                            radius: ['65%', '84%'],
                            label: {
                                normal: {
                                    show: false
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data: datas
                        }
                    ]
                };
                $myChart1_5_2.setOption(option1_0);
            }
            catch (err) {
                window.console && console.log(err);
            }
        }

        // 图6-1  监管动态
        function myChart1_6(jsonData, params, id) {
            $myChart1_6 = echarts.init(document.getElementById(id));
            try {
                var $datas = jsonData.data;
                if (!$datas)return;
                var xdata = ['异常名录', '严重违法', '行政处罚', '抽查检查'];
                var xdata0 = ['户数 条数', '户数  条数', '户数  条数', '户数  条数'];
                var gsHCountList = $datas.gsHCountList;
                var gsTCountList = $datas.gsTCountList;
                var otherHCountList = $datas.otherHCountList;
                var otherTCountList = $datas.otherTCountList;


                function renderType(param, api) {

                    var point = api.coord([api.value(0), 0]);

                    var style = api.style();
                    var size = api.size([1, 0])[0];
                    style.textFill = '#8287a5';
                    return {
                        type: 'rect',
                        shape: {
                            x: point[0] - size / 2,
                            y: 45,
                            width: size - 1,
                            height: 24
                        },
                        style: style

                    };
                }

                var option1_6 = {
                    grid: {
                        show: true,
                        containLabel: true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
                        width: '91%',
                        height: '70%',
                        left: 'center',
                        top: '70',
                        borderWidth: 0
                    },
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "shadow" //指示器类型。  'line' 直线指示器   'shadow' 阴影指示器  'cross' 十字准星指示器。其实是种简写，表示启用两个正交的轴的 axisPointer。
                        }
                    },
                    legend: {
                        right: '20',
                        top: '17',
                        itemWidth: 10,
                        itemHeight: 10,
                        textStyle: {
                            color: '#8287a5' //文字的颜色
                        },
                        data: ['来自工商', '来自其他']
                    },
                    yAxis: [{
                        type: "value",
                        splitLine: {
                            show: true,   // 坐标轴上的 横线    true:显示  false:不显示
                            lineStyle: {
                                color: '#232d53',
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLine: {
                            show: false,
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5',//坐标值具体的颜色

                            }
                        }
                    }],
                    xAxis: [{
                        type: "category",
                        boundaryGap: true, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                        splitLine: {
                            show: false,   // 坐标轴上的 横线    true:显示  false:不显示
                            lineStyle: {
                                color: '#8287a5',
                                width: '1'//坐标线的宽度
                            }
                        },
                        axisLine: {
                            lineStyle: {
                                type: 'solid',
                                color: '#8287a5',//坐标线的颜色
                                width: '1'//坐标线的宽度
                            }
                        },
                        // splitLine: {
                        //     show: true,   // 坐标轴上的 横线    true:显示  false:不显示
                        //     lineStyle: {
                        //         color: 'rgba(56,63,94,0.2)',
                        //         width: '1'//坐标线的宽度
                        //     }
                        // },
                        axisLabel: {
                            interval: 0,
                            textStyle: {
                                color: '#8287a5'//坐标值得具体的颜色

                            }
                        },
                        data: xdata0
                    }],
                    series: [
                        {
                            name: "来自工商",
                            type: "bar",
                            barWidth: 24,//柱图宽度
                            barMaxWidth: 35,
                            // barGap: "8%",
                            stack: '条数堆叠',
                            itemStyle: {normal: {color: '#00b4ff', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
//        				        	 label: {
//        				                 normal: {
//        				                     show: true,
//        				                     position: 'right',
//        				                     formatter:'{c}'+'条'
//        				                 }
//        				             },
                            data: gsTCountList
                        },
                        {
                            name: "来自工商户数",
                            type: "bar",
                            barWidth: 24,//柱图宽度
                            barMaxWidth: 35,
                            // barGap: "8%",
                            stack: '户数堆叠',
                            itemStyle: {normal: {color: '#00b4ff', lineStyle: {color: '#00b4ff'}}},//color设置图例颜色，lineStyle设置边框线
//        				        	 label: {
//        				                 normal: {
//        				                     show: true,
//        				                     position: 'right',
//        				                     formatter:'{c}'+'户'
//        				                 }
//        				             },
                            data: gsHCountList
                        },
                        {
                            name: "来自其他",
                            type: "bar",
                            barWidth: 24,//柱图宽度
                            stack: '条数堆叠',
                            itemStyle: {normal: {color: '#2dffd2', lineStyle: {color: '#2dffd2'}}},//color设置图例颜色，lineStyle设置边框线,
                            data: otherTCountList
                        },
                        {
                            name: "来自其他户数",
                            type: "bar",
                            barWidth: 24,//柱图宽度
                            barMaxWidth: 35,
                            // barGap: "8%",
                            stack: '户数堆叠',
                            itemStyle: {normal: {color: '#2dffd2', lineStyle: {color: '#2dffd2'}}},//color设置图例颜色，lineStyle设置边框线
                            data: otherHCountList
                        },
                        {
                            type: 'custom',
                            renderItem: renderType,
                            data: [500000, 440000, 500000, 500000],
                            itemStyle: {normal: {color: '#383f5e'}},
                            label: {
                                normal: {
                                    show: true,
                                    position: 'inside',
                                    formatter: function (i) {
                                        return xdata[i.dataIndex]
                                    }
                                }
                            },
                            encode: {
                                x: 0,
                                y: 1,
                                itemName: 1
                            },
                            tooltip: {
                                show:false
                            }
                        }
                    ]
                };
                $myChart1_6.setOption(option1_6);
            }
            catch (err) {
                window.console && console.log(err);
            }
        };

        return {
            totalNum: totalNum,
            myChart1_0: myChart1_0,
            myChart1_1: myChart1_1,
            tab3_num: tab3_num,
//            myChart1_2: myChart1_2,
            myChart1_3: myChart1_3,
            tab4_num: tab4_num,
            myChart1_4: myChart1_4,
            tab5_num: tab5_num,
            myChart1_5: myChart1_5,
            myChart1_5_1: myChart1_5_1,
            myChart1_5_2: myChart1_5_2,
            myChart1_6: myChart1_6
        }
    })();


    //配置参数
    var tab1_options = {
        tab1_0: {id: 'chart1_0', params: {}, url: '/qcdz/rptQcdzZtcount.json'},
        tab1_1: {id: 'chart1_1', params: {}, url: '/qcdz/rptQcdzMouthXsxwcount.json'},
//        tab1_2: {id: 'chart1_2', params: {}, url: '/qcdz/echartssubjectdisrpt/getEntAreaDistribution'},
        tab1_3: {id: 'chart1_3', params: {type: '2'}, url: '/qcdz/rptQcdzTodayXsxwcount.json'},
        tab1_4: {id: 'chart1_4', params: {length: 6}, url: '/qcdz/rptQcdzYearXsxwcount.json'},
        tab1_5: {id: 'chart1_5', params: {type: '2'}, url: '/qcdz/rptQcdzInvcount.json'},
        tab1_5_1: {id: 'chart1_5_1', params: {invtype: '1'}, url: '/qcdz/rptQcdzIndustry.json'},
        tab1_5_2: {id: 'chart1_5_2', params: {invtype: '2'}, url: '/qcdz/rptQcdzIndustry.json'},
        tab1_6: {id: 'chart1_6', url: '/qcdz/rptPublicInfocount.json'}
    };
    var loading = false;

    //初始化执行方法
    function _tab1() {

        //图一直接查询部分（主体总数）
        ajaxRequest(1, '', {}, '/qcdz/rptQcdzZtcount.json', tab1_model.totalNum);
        //图一  各主体分布饼图
        ajaxRequest(2, tab1_options.tab1_0.id, tab1_options.tab1_0.params, tab1_options.tab1_0.url, tab1_model.myChart1_0);
        //图一 主体新设消亡月趋势（折线图）
        ajaxRequest(3, tab1_options.tab1_1.id, tab1_options.tab1_1.params, tab1_options.tab1_1.url, tab1_model.myChart1_1);
        //图三 直接查询部分（当日各主体新设消亡数量）
        ajaxRequest(4, '', {type: '1'}, '/qcdz/rptQcdzTodayXsxwcount.json', tab1_model.tab3_num);
        //图三 当日地市新设消亡数量（柱状图）
        ajaxRequest(5, tab1_options.tab1_3.id, tab1_options.tab1_3.params, tab1_options.tab1_3.url, tab1_model.myChart1_3);
        //图四  直接查询部分（近3年主体增长情况）
        ajaxRequest(6, '', {length: 3}, '/qcdz/rptQcdzYearXsxwcount.json', tab1_model.tab4_num);
        //图四 近6年主体增长情况（双y轴 柱状图 、折线图）
        ajaxRequest(7, tab1_options.tab1_4.id, tab1_options.tab1_4.params, tab1_options.tab1_4.url, tab1_model.myChart1_4);
        //图五 直接查询部分（总体投资分布）
        ajaxRequest(8, '', {type: '1'}, '/qcdz/rptQcdzInvcount.json', tab1_model.tab5_num);
        //图五 区域分布
        ajaxRequest(9, tab1_options.tab1_5.id, tab1_options.tab1_5.params, tab1_options.tab1_5.url, tab1_model.myChart1_5);
        ajaxRequest(10, tab1_options.tab1_5_1.id, tab1_options.tab1_5_1.params, tab1_options.tab1_5_1.url, tab1_model.myChart1_5_1);

        ajaxRequest(11, tab1_options.tab1_5_2.id, tab1_options.tab1_5_2.params, tab1_options.tab1_5_2.url, tab1_model.myChart1_5_2);
        //图六 监管动态（堆叠柱状图）
        ajaxRequest(12, tab1_options.tab1_6.id, {}, tab1_options.tab1_6.url, tab1_model.myChart1_6);

    }


    //页面初始化：
    init();

    function init() {
        _tab1();
//        mycharts2();
        setInterval(refresh, 10000)
    }

    //10秒自动刷新直接查询部分
    function refresh() {
        if (!loading) {
            loading = true;
            $.when(
                //图一直接查询部分（主体总数）
                ajaxRequest(1, '', {}, '/qcdz/rptQcdzZtcount.json', tab1_model.totalNum),
                //图三 直接查询部分（当日各主体新设消亡数量）
                ajaxRequest(4, '', {type: '1'}, '/qcdz/rptQcdzTodayXsxwcount.json', tab1_model.tab3_num),
                //图四  直接查询部分（近3年主体增长情况）
                ajaxRequest(6, '', {length: 3}, '/qcdz/rptQcdzYearXsxwcount.json', tab1_model.tab4_num),
                //图五 直接查询部分（总体投资分布）
                ajaxRequest(8, '', {type: '1'}, '/qcdz/rptQcdzInvcount.json', tab1_model.tab5_num))
                .then(function () {
                    loading = false;
                })
        }
    }

    function request(url, params, id, mycharts) {
        http.httpRequest({
            url: url,
            serializable: false,
            data: params,
            type: 'post',
            async: true, //异步
            beforeSend: function () { //覆盖阴影层
            },
            success: function (data) {
                if (data.status == "success") {
                    var data = data.data;
                    if (!data) {
                        return
                    }
                    refreshData(mycharts, data, id);
                }
            },
            error: function () {
                layer.msg("系统异常,请联系管理人员!")
            }
        });
    }

    //直接刷新图形数据
    window.setInterval(function () {
        request('/qcdz/rptQcdzZtcount.json', {}, 'chart1_0', $myChart1_0);
        request('/qcdz/rptQcdzMouthXsxwcount.json', {}, 'chart1_1', $myChart1_1);
        request('/qcdz/rptQcdzTodayXsxwcount.json', {type: '2'}, 'chart1_3', $myChart1_3);
        request('/qcdz/rptQcdzYearXsxwcount.json', {length: 6}, 'chart1_4', $myChart1_4);
        request('/qcdz/rptQcdzInvcount.json', {type: '2'}, 'chart1_5', $myChart1_5);
        request('/qcdz/rptQcdzIndustry.json', {invtype: '1'}, 'chart1_5_1', $myChart1_5_1);
        request('/qcdz/rptQcdzIndustry.json', {invtype: '2'}, 'chart1_5_2', $myChart1_5_2);
        request('/qcdz/rptPublicInfocount.json', {}, 'chart1_6', $myChart1_6);
    }, 10000);


    function refreshData(myChart, $jsonData, id) {
        if (!myChart) {
            return;
        }
        if (id == "chart1_0") {//图一饼图
            myChart = $myChart1_0;
            //更新数据-
            var option = myChart.getOption();
            var total = $jsonData.qyCount + $jsonData.gtCount + $jsonData.nzCount;
            //数据转换
            var qy = '企业' + Math.round(($jsonData.qyCount) * 100 / total) + '%';
            var gt = '个体' + Math.round(($jsonData.gtCount) * 100 / total) + '%';
            var nz = '农专' + (100 - (Math.round(($jsonData.qyCount) * 100 / total) + Math.round(($jsonData.gtCount) * 100 / total))) + '%';
            //数据封装
            var jsonData = {
                legend_data: [qy, gt, nz],
                datas: [
                    {value: $jsonData.qyCount, name: qy},
                    {value: $jsonData.gtCount, name: gt},
                    {value: $jsonData.nzCount, name: nz}]
            };
            option.legend[0].data = jsonData.legend_data;
            option.series[0].data = jsonData.datas;
            myChart.setOption(option);
        }
        if (id == "chart1_1") {//图一下主体趋势图
            myChart = $myChart1_1;
            //更新数据
            var option = myChart.getOption();
            var mounths = $jsonData.mounths;
            var xsList = $jsonData.xsList;
            var xwList = $jsonData.xwList;
            option.xAxis[0].data = mounths;
            option.series[0].data = xsList;
            option.series[1].data = xwList;
            myChart.setOption(option);
        }
        if (id == "chart1_3") {//图三当日各地市新设注销数 柱状图
            myChart = $myChart1_3;
            //更新数据
            var option = myChart.getOption();
            var xdata = [];

            var names = $jsonData.names;
            var xslist = $jsonData.xsList;
            var xwlist = $jsonData.xwList;
            var length = names.length;
            var alllist = xslist.concat(xwlist);
            var xarisMax = arrMax(alllist);

            function arrMax(arr) {
                var max = arr[0];
                var len = arr.length;
                for (var i = 1; i < len; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
                return max;
            }

            xslist.forEach(function (item, index, arr) {
                arr[index] = -item;
            });
            for (var i = 0; i < length; i++) {
                xdata.push(areacodeList(names[i]));
            } 
            option.xAxis[0].min = -(Math.round(xarisMax / 5) * 6);
            option.xAxis[0].max = (Math.round(xarisMax / 5) * 6);
            option.xAxis[0].interval =  Math.round(xarisMax / 5);
            option.yAxis[0].data = xdata;
            option.series[0].data = xslist;
            option.series[1].data = xwlist;
            myChart.setOption(option);
        }
        if (id == "chart1_4") {//图四近6年主体增长数量
            myChart = $myChart1_4;
            //更新数据
            var option = myChart.getOption();
            var years = $jsonData.years;
            var addCountList = $jsonData.addCountList;
            var addRoateList = $jsonData.addRoateList;
            option.xAxis[0].data = years;
            option.series[0].data = addCountList;
            option.series[1].data = addRoateList;
            myChart.setOption(option);
        }
        if (id == "chart1_5") {//图5区域分布
            myChart = $myChart1_5;
            //更新数据
            var option = myChart.getOption();
            var xdata = [];
            var names = $jsonData.names;
            var entRateList = $jsonData.entRateList;
            var perRateList = $jsonData.perRateList;
            var length = names.length;
            //处理x轴显示
            for (var i = 0; i < length; i++) {
                xdata.push(areacodeList(names[i]));
            }
            option.xAxis[0].data = xdata;
            option.series[0].data = entRateList;
            option.series[1].data = perRateList;
            myChart.setOption(option);
        }
        if (id == "chart1_5_1") {//图5-1法人股东行业占比
            myChart = $myChart1_5_1;
            //更新数据
            var option = myChart.getOption();
            var datas = [];
            var ledatas = [];
            var list = $jsonData;
            for (var i = 0; i < list.length; i++) {
                ledatas.push(list[i].hymc);
                datas.push({value: list[i].hyrate, name: list[i].hymc});
            }
            option.legend[0].data = ledatas;
            option.series[0].data = datas;
            myChart.setOption(option);
        }
        if (id == "chart1_5_2") {//图5-2自然人股东行业占比
            myChart = $myChart1_5_2;
            var option = myChart.getOption();
            //更新数据
            var datas = [];
            var ledatas = [];
            var list = $jsonData;
            for (var i = 0; i < list.length; i++) {
                ledatas.push(list[i].hymc);
                datas.push({value: list[i].hyrate, name: list[i].hymc});
            }
            option.legend[0].data = ledatas;
            option.series[0].data = datas;
            myChart.setOption(option);
        }
        if (id == "chart1_6") {//图6监管动态
            myChart = $myChart1_6;
            var option = myChart.getOption();
            //更新数据
            var xdata = ['异常名录', '严重违法', '行政处罚', '抽查检查'];
            var gsHCountList = $jsonData.gsHCountList;
            var gsTCountList = $jsonData.gsTCountList;
            var otherHCountList = $jsonData.otherHCountList;
            var otherTCountList = $jsonData.otherTCountList;
            option.yAxis[0].data = xdata;
            option.series[0].data = gsTCountList;
            option.series[1].data = gsHCountList;
            option.series[2].data = otherTCountList;
            option.series[3].data = otherHCountList;
            myChart.setOption(option);
        }
    }


});