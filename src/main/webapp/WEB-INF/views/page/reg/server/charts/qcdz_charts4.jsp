<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>大屏全程电子化可视化</title>
    <link rel="stylesheet" href="/css/bigscreen.css">
</head>
<body onload="startTime()">
<div class="zjs-wrap">
    <div class="zjs-bs-top">
        <div class="zjs-bs-title"></div>
        <p class="zjs-bs-date">
            <i class="zjs-bs-date-icon"></i>
            <span class="mr40" id="time">2017年8月25日  9:00:34  星期二</span>
            <span>每10秒钟自动刷新</span>
        </p>
    </div>

    <div class="zjs-bs-content clearfix">
        <%--左部区域--%>
        <div class="zjs-bs-left">
            <%--主体概览--%>
            <div class="main-view mb20">
                <p class="three-line-title">主体概览</p>
                <div class="chart-border">
                    <i class="bd-left-top"></i>
                    <i class="bd-left-bottom"></i>
                    <i class="bd-right-top"></i>
                    <i class="bd-right-bottom"></i>
                    <%--主体概览图表--%>
                    <div class="main-view-con">

                        <div class="mvc-top clearfix">
                            <div class="mvc-top-left">
                                <p class="mvc-top-title">在册主体总数（户）</p>
                                <div class="mvc-top-num js-all clearfix">
                                    <%--<span id="ztCount">0</span>--%>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="up">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                            <div class="down">
                                                <div class="shadow"></div>
                                                <div class="inn">0</div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                                <p class="mvc-top-add">同比增长<span id="yearAddRoate">0.00%</span></p>
                            </div>
                            <%--在册企业总数 圆环 图表--%>
                            <div class="mvc-top-right" id="chart1_0">

                            </div>
                        </div>

                        <%--主体”新设/注销“趋势 图表--%>
                        <div class="mvc-bot" id="chart1_1">

                        </div>
                    </div>
                </div>
            </div>

            <%--主体年增长情况--%>
            <div class="main-add">
                <p class="three-line-title">主体年增长情况</p>
                <div class="chart-border">
                    <i class="bd-left-top"></i>
                    <i class="bd-left-bottom"></i>
                    <i class="bd-right-top"></i>
                    <i class="bd-right-bottom"></i>
                    <div class="main-add-con">
                        <div class="mac-top">
                            <p class="mvc-top-title">近3年主体增长情况</p>
                            <ul id="zt_add" class="clearfix">
                                <li class="mac-line">
                                    <p class="year-add"><em><font id="js-year0">2014</font>年度</em><span
                                            id="js-addroate0">5.00%</span></p>
                                    <p class="year-num" id="js-addnum0">6500000</p>
                                </li>
                                <li class="mac-line">
                                    <p class="year-add"><em><font id="js-year1">2015</font>年度</em><span
                                            id="js-addroate1">5.00%</span></p>
                                    <p class="year-num" id="js-addnum1">4500000</p>
                                </li>
                                <li class="mac-li-last">
                                    <p class="year-add"><em><font id="js-year2">2016</font>年度</em><span
                                            id="js-addroate2">5.00%</span></p>
                                    <p class="year-num" id="js-addnum2">6500000</p>
                                </li>
                            </ul>
                        </div>
                        <%--主体年增长情况 图表--%>
                        <div class="mac-bot" id="chart1_4">

                        </div>
                    </div>
                </div>
            </div>


        </div>

        <%--中部区域--%>
        <div class="zjs-bs-mid">
            <%----%>
            <!--             <p class="data-map-legend">迁入</p> -->
            <div id="zjs-data-map" class="zjs-data-map">

            </div>
            <%--监管动态--%>
            <div class="tzfb">
                <p class="three-line-title">监管动态</p>
                <div class="chart-border">
                    <i class="bd-left-top"></i>
                    <i class="bd-left-bottom"></i>
                    <i class="bd-right-top"></i>
                    <i class="bd-right-bottom"></i>
                    <div class="supervise-dynamic">
                        <%--监管动态图表--%>
                        <div class="sdy-chart" id="chart1_6">

                        </div>
                    </div>
                </div>
            </div>

        </div>

        <%--右部区域--%>
        <div class="zjs-bs-right">
            <%--主体动态--%>
            <div class="main-dynamic">
                <p class="three-line-title-right">主体动态</p>
                <div class="chart-border cb-new">
                    <i class="line-top"></i>
                    <i class="line-bot"></i>
                    <i class="bd-right-top"></i>
                    <i class="bd-right-bottom"></i>
                    <div class="mdy-con clearfix">
                        <div>
                            <div class="mdy-left">
                                <p class="mdy-tit">今日新设立</p>
                                <p><span class="mdy-l">企业</span><span class="mdy-r big-timer" id="dxs0">0</span></p>
                                <p><span class="mdy-l">个体户</span><span class="mdy-r big-timer" id="dxs1">0</span></p>
                                <p><span class="mdy-l">农专社</span><span class="mdy-r big-timer" id="dxs2">0</span></p>
                            </div>
                            <div class="mdy-right">
                                <p class="mdy-tit">今日注销</p>
                                <p><span class="mdy-r big-timer" id="dzx0">0</span></p>
                                <p><span class="mdy-r big-timer" id="dzx1">0</span></p>
                                <p><span class="mdy-r big-timer" id="dzx2">0</span></p>
                            </div>
                        </div>
                        <%----%>
                        <div class="mdy-chart" id="chart1_3">

                        </div>
                    </div>
                </div>
            </div>
            <%--投资分布--%>
            <div>
                <p class="three-line-title-right">投资分布</p>

                <div class="chart-border">
                    <i class="bd-left-top"></i>
                    <i class="bd-left-bottom"></i>
                    <i class="bd-right-top"></i>
                    <i class="bd-right-bottom"></i>
                    <div class="investment-spread">
                        <div class="spread-top clearfix mb5">
                            <div class="spread-pic1">
                                <p class="shareholder">法人股东（个）</p>
                                <p class="shareholder-num" id="js_entCount">124,345</p>
                            </div>
                            <div class="spread-pic2">
                                <p class="shareholder">自然人股东（个）</p>
                                <p class="shareholder-num" id="js_percount">68,123</p>
                            </div>
                            <div class="spread-pic3">
                                <span class="one" id="js_entrate">36%</span>
                                <span class="two" id="js_perrate">64%</span>
                            </div>
                        </div>
                        <%--区域分布图表--%>
                        <div class="spread-bot" id="chart1_5">

                        </div>
                        <div class="clearfix">
                            <div class="spread-left" id="chart1_5_1">

                            </div>
                            <div class="spread-right" id="chart1_5_2">

                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/echarts/echarts-all.js"></script>
<script src="/js/common/maparea.js"></script>
<script>
  $.ajax({
    url: "/qcdz/rptQcdzMap.json",
    type: 'post',
    data: {},
    success: function(data, status){
   	     mycharts(data.data);
    }
   });

    function mycharts(jsonData){
    	var myChart2 = echarts.init(document.getElementById('zjs-data-map'));

        var xSdatas= jsonData.xsData;
        var zxData = jsonData.zxNum;
        var totalData = jsonData.totalData;
        var zxCountList = jsonData.zxCountList;
        var count = 0;

    	var options={
    	    legend: {
    	        orient: 'vertical',
    	        x:'80%',
    	        y:'80%',
    	        itemWidth: 10,
    	        itemHeight: 10,
    	        data:['注销','新设'],
    	        textStyle: {color: '#8287a5'},
				selectedMode:false
    	    },
    	    itemStyle: {
    	        normal: {
    	            borderWidth: "2px",
    	            borderColor: "#191a4b",
    	            color: "#08568f"
    	        }
    	    },
    	    series: [
    	        {
    	            name: '浙江',
    	            type: 'map',
    	            mapType: 'ZJ',
    	            hoverable:false,
    	            itemStyle:{
    	                normal:{
    	                    borderColor:'rgba(10,21,62,.6)',
    	                    borderWidth:1,
    	                    areaStyle:{
    	                        color: 'rgba(0,180,255,.4)'
    	                    }
    	                }
    	            },
    	            data: [],
    	            markPoint: {
//     	                symbol: 'image:///img/bigscreen/trans-dot.png',
//     	                symbolSize: 0,
    	                symbol:'emptyCircle',
    	                symbolSize :14,
//     	                large: true,
    	                effect : {
    	                    show: true
    	                },
                        effect : {
                            show: true
                        },
                        itemStyle: {
                            normal: {
                                backgroundColor: 'rgba(0,0,0,.6)',
                                borderColor: '#00b4ff',
                                borderWidth: 1,
                            }
                        },
                        data : [
                        ]

                    },
                    geoCoord: coords
    	        },
    	        {
    	            name: '浙江',
    	            type: 'map',
    	            mapType: 'ZJ',
    	            hoverable:false,
    	            itemStyle:{
    	                normal:{
    	                    borderColor:'rgba(10,21,62,.6)',
    	                    borderWidth:1,
    	                    areaStyle:{
    	                        color: 'rgba(0,180,255,.4)'
    	                    }
    	                }
    	            },
    	            data: [],
    	            markPoint: {
                        symbol: 'image:///img/bigscreen/label-icon.png',
                        symbolSize: [115,58],
    	                data : [
    	                     ]
    	                
    	            },
    	            geoCoord: coords
    	        },
                {
                    name: '浙江',
                    type: 'map',
                    mapType: 'ZJ',
                    hoverable:false,
                    itemStyle:{
                        normal:{
                            borderColor:'rgba(10,21,62,.6)',
                            borderWidth:1,
                            areaStyle:{
                                color: 'rgba(0,180,255,.4)'
                            }
                        }
                    },
                    data: [],
                    markPoint: {
                        symbol: 'image:///img/bigscreen/trans-dot.png',
                        symbolSize: [10,16],
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true,
                                    position:'top',
                                    formatter: function (obj) {
                                        return obj.name+" : "+"新设 "+obj.value+" "+"注销 "+count;
                                    },
                                    textStyle: {
                                        color: '#fff',
                                        fontSize: 14
                                    }
                                }

                            },
                            emphasis: {
                                label: {
                                    show: false
                                }
                            }
                        },
                        data : [
                        ]

                    },
                    geoCoord: coords
                },

    	        {
    	            name: '新设',//新设 蓝色
    	            type: 'map',
    	            mapType: 'ZJ',
    	            hoverable:false,
    	            data : [],
    	            markPoint : {
    	                symbol:'circle',
    	                symbolSize : 8,
    	                large: true,
    	                effect : {
    	                    show: true
    	                },
    	                itemStyle: {
    	                    normal: {
    	                        borderColor: 'rgba(1,130,250,0.7)',
    	                        borderWidth: 1,            // 标注边线线宽，单位px，默认为1
    	                        color:'rgba(1,130,250,0.7)',
    	                        label: {
    	                            show: true,
    	                            position:'top',
    	                            formatter: function (obj) {
    	                                return obj.name+":"+obj.value;
    	                            },
    	                            textStyle:{
    	                                color:'#fff',
    	                                fontSize:12
    	                            }
    	                        }
    	                    },
    	                    emphasis: {
    	                        borderColor: 'rgba(1,130,250,0.7)',
    	                        label: {
    	                            show: true
    	                        }
    	                    }
    	                },
    	                data : xSdatas
    	            },
    	            geoCoord: coords
    	        },
    	        {
    	            name: '注销',//注销 红色
    	            type: 'map',
    	            mapType: 'ZJ',
    	            hoverable:false,
    	            data : [],
    	            markPoint : {
    	                symbol:'circle',
    	                symbolSize: 8,
    	                large: true,
    	                effect : {
    	                    show: true
    	                },
    	                itemStyle: {
    	                    normal: {
    	                        borderColor: 'rgba(231,66,66,0.7)',
    	                        borderWidth: 1,            // 标注边线线宽，单位px，默认为1
    	                        color:'rgba(231,66,66,0.7)',
    	                        label: {
    	                            show: true
    	                        }
    	                    },
    	                    emphasis: {
    	                        label: {
    	                            show: true
    	                        }
    	                    }
    	                },
    	                data : zxData
    	            },
    	            geoCoord: coords
    	        }
    	    ]
    	};
   		var index=0;
   		var zxIndex =0; 		
/*  	 	setInterval(function(){
		 $.ajax({
			    url: "/qcdz/rptQcdzMap.json",
			    type: 'post',
			    data: {},
			    success: function(data, status){

			    	 if(data.status == "success" && data.data){
			    	     xSdatas= data.data.xsData;
			    	     zxData = data.data.zxNum;
			    	     totalData = data.data.totalData;
			    	     zxCountList = data.data.zxCountList;
			    		 options.series[3].markPoint.data=xSdatas;
			    		 options.series[4].markPoint.data=zxData;
			    		 index = 0;
			    		 zxIndex = 0;
			    		 myChart2.setOption(options); 
			    	 }
			    }
			   });
	   },60000);*/
  	 
   		setInterval(function(){
   		    var myData = [];
   		    if(totalData.length >0){
   		       myData.push(totalData[index++]);
   		       count = zxCountList[zxIndex++];
   		       if(index == totalData.length){
   		        index = 0;
   		        zxIndex = 0;
   		       }
   		    }
   		    options.series[0].markPoint.data=myData;    		    
   		    options.series[1].markPoint.data=myData;
            options.series[2].markPoint.data=myData;
            myChart2.setOption(options);
   		},2000);
   		
   		
	  echarts.util.mapData.params.params.ZJ = {
		    getGeoJson: function (callback) {
		        $.getJSON('/js/lib/echarts/map/zhejiang.json', function (data) {
		            // 压缩后的地图数据必须使用 decode 函数转换
		            callback(echarts.util.mapData.params.decode(data));
		        });
		    }
	  };
      myChart2.setOption(options);
    }
</script>
<script>
    //数字时钟
    function startTime() {
        var today = new Date();
        var y = today.getFullYear();
        var m = today.getMonth() + 1;
        var d = today.getDate();
        var h = today.getHours();
        var mn = today.getMinutes();
        var s = today.getSeconds();
        var day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[today.getDay()];
        mn = checkTime(mn)
        s = checkTime(s)
        document.getElementById('time').innerHTML = y + "年" + m + "月" + d + "日 "
                + h + ":" + mn + ":" + s + " " + day
        t = setTimeout('startTime()', 500)
    }

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i
        }
        return i
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/charts/qcdz_charts.js"></script>
</body>
</html>