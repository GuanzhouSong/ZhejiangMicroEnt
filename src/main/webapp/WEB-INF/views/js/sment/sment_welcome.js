require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','echarts','common/zhejiang', 
         'jquery','jquery.serialize','laydate','sment-contabs'], function (layer, dataTable, util, http, echarts,zhejiang) {
	/*
	 * 初始化
	 */
	init();
	function init(){
		loadBulletins();
//		txtplay();
		initEcharts();
		showEntarchivesCount();
		showgd();
		bind();
	}
	
	function getCountMap(){
		var map = [];
		map["33-1"]= 50000;// 浙江省-初创
        map["33-2"]= 10000;// 浙江省-成长
        map["33-3"]= 5000;// 浙江省-领军

        map["3301-1"]= 12375;// 杭州市-初创
        map["3301-2"]= 3000;// 杭州市-成长
        map["3301-3"]= 1500;// 杭州市-领军

        map["3302-1"]= 8250;// 宁波-初创
        map["3302-2"]= 2000;// 宁波-成长
        map["3302-3"]= 1000;// 宁波-领军

        map["3303-1"]= 6250;// 温州市-初创
        map["3303-2"]= 1500;// 温州市-成长
        map["3303-3"]= 750;// 温州市-领军

        map["3304-1"]= 3850;// 嘉兴市-初创
        map["3304-2"]= 600;// 嘉兴市-成长
        map["3304-3"]= 300;// 嘉兴市-领军

        map["3305-1"]= 3125;// 湖州市-初创
        map["3305-2"]= 500;// 湖州市-成长
        map["3305-3"]= 250;// 湖州市-领军

        map["3306-1"]= 4000;// 绍兴市-初创
        map["3306-2"]= 600;// 绍兴市-成长
        map["3306-3"]= 300;// 绍兴市-领军

        map["3307-1"]= 4500;// 金华市-初创
        map["3307-2"]= 600;// 金华市-成长
        map["3307-3"]= 300;// 金华市-领军

        map["3308-1"]= 900;// 衢州市-初创
        map["3308-2"]= 200;// 衢州市-成长
        map["3308-3"]= 100;// 衢州市-领军

        map["3309-1"]= 750;// 舟山市-初创
        map["3309-2"]= 150;// 舟山市-成长
        map["3309-3"]= 75;// 舟山市-领军

        map["3310-1"]= 5050;// 台州市-初创
        map["3310-2"]= 700;// 台州市-成长
        map["3310-3"]= 350;// 台州市-领军

        map["3325-1"]= 950;// 丽水市-初创
        map["3325-2"]= 150;// 丽水市-成长
        map["3325-3"]= 75;// 丽水市-领军
        return map;
	}
	
	function showEntarchivesCount(){
		var params = {"helpState":1};
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countByHelp.json',
			data:{params:params},
			success:function(json){
				$("#span_help_1").text(json.data)
			}
		});
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countByHelp.json',
			data:{params:{"helpState":2}},
			success:function(json){
				$("#span_help_2").text(json.data)
			}
		});
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countZx.json',
			success:function(json){
				$("#span_rkqyzx").text(json.data)
			}
		});
		
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countWfwgBySetDeptCode.json',
			success:function(json){
				$("#span_wfwg").text(json.data)
			}
		});
		
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countJyycBySetDeptCode.json',
			success:function(json){
				$("#span_jyyc").text(json.data)
			}
		});
		
		http.httpRequest({
			type:'POST',
			url:'/sment/rptsmBaseinfo/countSgsjBySetDeptCode.json',
			success:function(json){
				$("#span_sgsj").text(json.data)
			}
		});
		
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countJyxjBySetDeptCode.json',
			success:function(json){
				$("#span_ysxj").text(json.data)
			}
		});
		
	}
	
	function showgd(){
		//查询统计小微企业总数、规上企业总数、动产抵押总数、国家商标、八大万亿产业小微企业总数
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/countgd.json',
			success:function(json){
				$data = json.data;
				if(!$data){
					return;
				}
				$("#js_entAboveCount").text(json.data.entAbovescalecount == null ? 0 : util.toThousands(json.data.entAbovescalecount));
				$("#js_dcdyCount").text(json.data.mortRegInfocount == null ? 0 : util.toThousands(json.data.mortRegInfocount));
				$("#js_gjsbCount").text(json.data.tmDetailInfocount == null ? 0 : util.toThousands(json.data.tmDetailInfocount));
			}
		});
		http.httpRequest({
			type:'POST',
			url:'/sment/rptsmBaseinfo/countgd.json',
			success:function(json){
				$data = json.data;
				if(!$data){
					return;
				}
				$("#js_baseinfoCount").text(json.data.baseinfocount == null ? 0 : util.toThousands(json.data.baseinfocount));
				$("#js_bdwycount").text(json.data.eightIndutryCount == null ? 0 : util.toThousands(json.data.eightIndutryCount));
			}
		});
		//查询小微年报相关统计
		http.httpRequest({
			type:'POST',
			url:'/sment/rptsmBaseinfo/smbaseinfoNbCount.json',
			success:function(json){
				$data = json.data;
				if(!$data){
					return;
				}
				$("#js_addProCount").text($data.addProCount == null ? 0 : util.toThousands($data.addProCount));
				$("#js_ratGro").text($data.ratGro == null ? 0 : util.toThousands($data.ratGro));
				$("#js_empNum").text($data.empNum == null ? 0 : util.toThousands($data.empNum));
			}
		});
		//查询三次产业比例
		http.httpRequest({
			type:'POST',
			url:'/sment/rptsmBaseinfo/smbaseThreeTypeCount.json',
			success:function(json){
				$data = json.data;
				if(!$data){
					return;
				}
				if($data.ThreeTypeCountAll != null && $data.ThreeTypeCountAll != 0){//分母不为0或者空
					var ThreeTypeCount1 = $data.ThreeTypeCount1 == null || $data.ThreeTypeCount1 ==0  ? 0 : Math.round(($data.ThreeTypeCount1)*100/$data.ThreeTypeCountAll);
					var ThreeTypeCount2 = $data.ThreeTypeCount2 == null || $data.ThreeTypeCount2 ==0  ? 0 : Math.round(($data.ThreeTypeCount2)*100/$data.ThreeTypeCountAll);
					var ThreeTypeCount3 = 100-(ThreeTypeCount1+ThreeTypeCount2);
					$("#js_scbl").text(ThreeTypeCount1+" : "+ThreeTypeCount2+" : "+ThreeTypeCount3);
				}
				
			}
		});
		
		
	}
	
	
	
	
	// 初始化echarts图表
	function initEcharts(){
		initEcharts1_1();
		initEcharts1_2();
		initEcharts2_1();
		initEcharts3_1();
		initEcharts3_2('main3_2','VendInc');
		initEcharts3_2('main3_3','ProGro');
		initEcharts3_2('main3_4','RatGro');
		initEcharts4_1();
		initEcharts5_1();
		initEcharts5_2();
		initEcharts5_3();
		initEcharts5_4();
	}

	// 小微企业地区分布
	function initEcharts1_1(){
		var myChart1_1 = echarts.init(document.getElementById('main1_1'));
		http.httpRequest({
			type:'POST',
			url:'/sment/server/chartscount/mapList.json',
			success:function(json){
				option1_1 = {
			    tooltip : {
			        trigger: 'item'
			    },
			    dataRange: {
			        min: 3000,
			        max: 350000,
			        x: 'left',
			        y: 'bottom',
			        text:['高','低'],  
			        color:['orange','yellow'],
			        calculable : true
			    },
			    series : [
			        {
			            name: '数量',
			            type: 'map',
			            map: 'zhejiang',
			            layoutCenter: ['60%', '50%'],
			            layoutSize: 300,
			            itemStyle:{
			                normal:{borderWidth:0},
			                emphasis:{borderWidth:1,borderColor:'#fff'}
			            },
			            label: {
			                normal: {
			                    show: true
//			                    position:'inside'
			                },
			                emphasis: {
			                    show: true
			                }
			            },
//			            mapLocation: {
//			                x: '25%',
//			                height:'85%'
//			            },
			            data:json.data
			        }
			    ]
			};                   
			myChart1_1.setOption(option1_1); 
			}
		
		});
	}

	// 存续数
	function initEcharts1_2(){
		var myChart1_2 = echarts.init(document.getElementById('main1_2'));
		http.httpRequest({
			type:'POST',
			url:'/sment/server/chartscount/zcList.json',
			success:function(json){
			var arr = json.data['strList'];
	        var option1_2 = {
//	    		title : {
//			        text: '小微企业在册数',
//			        x:'left'
//			    },
			    grid:{
			    	show:true,
			    	containLabel :true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
	                width: '84%',
	                height: '75%',
	                left:'5%',
	                top:'30'
	                
			    },
	            tooltip: {
	                show: true,
	                trigger :'axis'
	            },
	            xAxis : [
	                {
	                	name : '月份',
	                    type : 'category',//类目图，需要自行设置数值
//	                    axisTick :{interval :1},
			        	axisLabel : {interval:0,rotate:60},//interval 设置为0  强制显示所有标签,rotate标签倾斜度
	                    data : json.data['strList']

	                }
	            ],
	            yAxis : [
	                {
	                	name : '数量',
	                    type : 'value',//数值图 连续的数值
//			        	axisLabel : {rotate:60},//interval 设置为0  强制显示所有标签,rotate标签倾斜度
	                }
	            ],
	            series : [
	                {
	                    "name":"在册数",
	                    "type":"bar",
	                    "itemStyle" : {
	                        normal: {
	                            color:'#3399ff', 
	                        },
	                        emphasis: {}
	                    },
//	                    "barWidth":"20", //柱体宽度（）  div大小确定之后，与barCategoryGap两者设置只有一者有效
	                    "barCategoryGap":"20", //类目柱体间间距
	                    "data":json.data['dataList']
	                }
	            ]
	        };
	        myChart1_2.setOption(option1_2); 
			}
		});
	}
	
	// 当月新设数量
	function initEcharts2_1(){
		var myChart2_1 = echarts.init(document.getElementById('main2_1')); 
		http.httpRequest({
			type:'POST',
			url:'/sment/server/chartscount/xsList.json',
			success:function(json){
				var option2_1 = {
//        		title : {
// 			        text: '小微企业新设/注销数（月）',
// 			        x:'center'
// 			    },
			    grid:{
			    	show:true,
			    	containLabel :true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
	                width: '93%',
//	                height: '75%',
	                left:'20',
	                top:'30'
	                
			    },
 			   legend: {
 				     x: 'right',
 			        data:['新设','注销']
 			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    xAxis : [
			        {
			        	name : '月份',
			            type : 'category',
			            boundaryGap : false,
			            axisLabel : {interval:0},
			            data :json.data[0]['strList']
			        }
			    ],
			    yAxis : [
			        {
			        	name : '数量',
			            type : 'value'
			        } 
			    ],
			    series : [
			        {
			            name:'新设',
			            type:'line',
			            smooth:true,
			            symbolSize:'0',
			            itemStyle: {normal: {color:'#ff7f50',lineStyle:{width:4,color:'#ff7f50'}}},//color设置图例颜色，lineStyle设置边框线
			            areaStyle:{normal:{color:'#ffbfa8'}},//设置图形面积
			            data: json.data[0]['dataList']
			        },
			        {
			            name:'注销',
			            type:'line',
			            smooth:true,
			            symbolSize:'0',
			            itemStyle: {normal: {color:'#87cefa',lineStyle:{width:4,color:'#87cefa'}}},
			            areaStyle:{normal:{color:'#c3e7fd'}},
			            data: json.data[1]['dataList']
			        }
			    ]
			};
        	myChart2_1.setOption(option2_1); 
        }});
	}
	
	// 企业成长轨迹
	function initEcharts5_4(){
		var myChart = echarts.init(document.getElementById('main5_4'));
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/vendIncCount.json',
			success:function(json){
				$data = json.data;
				if(!$data){
					return;
				}
				var data0 = $data.years;
				var data1 = $data.vendIncs;
				var data2 = $data.proGros;
				var data3 = $data.ratGros;
				var option = {
 			   legend: {
 				     x: 'right',
 			        data:['营业总收入','利润总额','纳税总额']
 			    },
			    grid:{
			    	show:true,
			    	containLabel :true //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            axisLabel : {interval:0},//设置x轴全部显示
//			            axisLine:{show:false},//坐标轴刻线
//			            axisTick:{show:false},//坐标轴刻度
			            data :data0
			        }
			    ],
			    yAxis : [
			        {
			        	name : '单位：万元',
			            type : 'value',
//			            axisLine:{show:false},//坐标轴刻线
//			            axisTick:{show:false},//坐标轴刻度
//			            splitLine :{show :false}//坐标轴在 grid 区域中的分隔线。
			        } 
			    ],
			    series : [
			        {
			            name:'营业总收入',
			            type:'line',
//			            smooth:true, //是否平滑曲线显示
//			            symbolSize:'0',//标记大小：默认为4，即折线拐点处标记
			            symbol:'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
			            itemStyle: {normal: {color:'#5b9cd5',lineStyle:{color:'#5b9cd5'}}},//color设置图例颜色，lineStyle设置边框线
			            data: data1
			        },
			        {
			            name:'利润总额',
			            type:'line',
//			            smooth:true, //是否平滑曲线显示
//			            symbolSize:'0',//标记大小：默认为4，即折线拐点处标记
			            symbol:'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
			            itemStyle: {normal: {color:'#ED7D31',lineStyle:{color:'#ED7D31'}}},//color设置图例颜色，lineStyle设置边框线
			            data: data2
			        },
			        {
			            name:'纳税总额',
			            type:'line',
//			            smooth:true, //是否平滑曲线显示
//			            symbolSize:'0',//标记大小：默认为4，即折线拐点处标记
			            symbol:'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
			            itemStyle: {normal: {color:'#fff800',lineStyle:{color:'#fff800'}}},//color设置图例颜色，lineStyle设置边框线
			            data: data3
			        }
			    ]
			};
			myChart.setOption(option); 
        }});
	}
	
	
	
	// 限上规上企业成长轨迹
	function initEcharts3_2(id,groupType){
		var myChart3_2 = echarts.init(document.getElementById(id));
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/smEntAbovescaleCount.json',
			data:{"type":groupType},
			success:function(json){
				$data = json.data;
				if(!$data){
					return;
				}
				var data0 = $data.years;
				var data1 = $data.abovescale1s;
				var data2 = $data.abovescale2s;
				var data3 = $data.abovescale3s;
				var option3_2 = {
					    grid:{
					    	show:true,
					    	containLabel :true //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
					    },
					    tooltip: {
					        trigger: 'axis',
					        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					        }
					    },
//					    legend: {
//					        x: 'right',//展示在右边
//					        data:['营业总收入','利润总额','纳税总额']
//				        },
	                    color: ['#9e9e9e','#ED7D31','#5B9CD5' ],//设置显示的颜色
	                    xAxis : [
	                             {
	                                 type : 'category',
	         			        	 axisLabel : {interval:0},//interval 设置为0  强制显示所有标签,rotate标签倾斜度 ,rotate:60
	                                 data : data0
	                             }
	                         ],
	                    yAxis : [
	                             {type : 'value',
	                            	 }
	                         ],     
					    series: [
	                              {
	                                  name : '规上服务业',
	                                  type:'bar',
	                                  data:data1
	                              },
	                              {
	                            	  name : '规上工业 ',
	                            	  type:'bar',
	                            	  data:data2
	                              },
	                              {
	                            	  name : '限上',
	                            	  type:'bar',
	                            	  data:data3
	                              }

					    ]
			};
        	myChart3_2.setOption(option3_2); 
        }});
	}
	
	
	// 信息归集查询
	function initEcharts4_1(){
		var myChart = echarts.init(document.getElementById('main4_1'));
		http.httpRequest({
			type:'POST',
			url:'/sment/server/chartscount/smRptAddcount.json',
			success:function(json){
				$data = json.data;
				if(!$data){
					return ;
				}
				var data0 = $data.rptDates;
				var data1 = $data.tableType1s;
				var data2 = $data.tableType2s;
				var data3 = $data.tableType3s;
				var data4 = $data.tableType4s;
				
				var option = {
 			   legend: {
 				     x: 'right',
 			        data:['登记主表','年报主表','列入经营异常','移出经营异常']
 			    },
			    grid:{
			    	show:true,
			    	containLabel :true, //这常用于『防止标签溢出』的场景，标签溢出指的是，标签长度动态变化时，可能会溢出容器或者覆盖其他组件。grid 区域是否包含坐标轴的刻度标签。默认为false,containLabel 为 true 的时候：决定的是包括了坐标轴标签在内的所有内容所形成的矩形的位置。
	                width: '95%',
//	                height: '75%',
	                left:'20',
	                top:'60'
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    xAxis : [
			        {
//			        	name : '',
			            type : 'category',
			            boundaryGap : false,
			            axisLabel : {interval:0,rotate:20},//设置x轴全部显示
//			            axisLine:{show:false},//坐标轴刻线
//			            axisTick:{show:false},//坐标轴刻度
//			            splitLine :{show :false},//坐标轴在 grid 区域中的分隔线。
			            data :data0
			        }
			    ],
			    yAxis : [
			        {
			        	name : '单位：户',
			            type : 'value',
//			            splitLine :{show :false}//坐标轴在 grid 区域中的分隔线。
			        } 
			    ],
			    series : [
			        {
			            name:'登记主表',
			            type:'line',
//			            smooth:true, //是否平滑曲线显示
//			            symbolSize:'0',//标记大小：默认为4，即折线拐点处标记
			            symbol:'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
			            itemStyle: {normal: {color:'#5b9cd5',lineStyle:{color:'#5b9cd5'}}},//color设置图例颜色，lineStyle设置边框线
			            data: data1
			        },
			        {
			            name:'年报主表',
			            type:'line',
			            itemStyle: {normal: {color:'#ed7d31',lineStyle:{color:'#ed7d31'}}},//color设置图例颜色，lineStyle设置边框线
			            symbol:'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
			            data: data2
			        },
			        {
			            name:'列入经营异常',
			            type:'line',
			            itemStyle: {normal: {color:'#999',lineStyle:{color:'#999'}}},//color设置图例颜色，lineStyle设置边框线
			            symbol:'circle',
			            data: data3
			        },
			        {
			            name:'移出经营异常',
			            type:'line',
			            itemStyle: {normal: {color:'#fff800',lineStyle:{color:'#fff800'}}},
			            symbol:'circle', //标记类型，默认为圆环，可选为 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
			            data: data4
			        }
			    ]
			};
			myChart.setOption(option); 
        }});
	}
	
	// 区域分类
	function initEcharts5_1(){
		var myChart = echarts.init(document.getElementById('main5_1')); 
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/chartcount.json',
			data:{operateType:2},
			success:function(json){
				var $entarchivesDto = json.data;
	            if(!$entarchivesDto){return;}
				var option = {
					    tooltip: { //提示框组件。全局
					        trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
					    },
					    legend: {
					        orient: 'vertical',//图例竖形展示
					        left: '55%',//展示在右边
					        top : 'center',
							itemWidth :10,
							itemHeight:10,
							selectedMode:false,
					        data:['特色小镇','众创空间','科技孵化园','电子商务园','小微企业园','其他']
					    },
	                    color: ['#5B9CD5','#ED7D31','#999999','#fff800','#70AD46','#3399ff'],//默认显示的颜色
					    series: [
					        {
					            name:'区域分类',
					            type:'pie',
					             center:['30%','50%'],//设置图形坐标位置，横纵坐标
					        	 radius: ['30%', '50%'], //圆环半径：内半径、外半径（内半径社大显示成圆环图）内半径为0显示为圆饼
					            label: {
					                normal: {
					                    show: false,
					                }
					            },
					            itemStyle :{
					                normal: {
					                	borderColor: '#fff',
					                	borderWidth : 1
					                },
					            },
					            labelLine: {
					                normal: {
					                    show: false,
					                }
					            },
					            data:[
					                {value:$entarchivesDto.tsxzCount, name:'特色小镇'},
					                {value:$entarchivesDto.zckjCount, name:'众创空间'},
					                {value:$entarchivesDto.kjfhyCount, name:'科技孵化园'},
					                {value:$entarchivesDto.kjdsyCount, name:'电子商务园'},
					                {value:$entarchivesDto.xwqyyCount, name:'小微企业园'},
					                {value:$entarchivesDto.qtCount, name:'其他'}
					            ]
					        }
					    ]
			};
			myChart.setOption(option); 
        }});
	}
	// 八大产业 
	function initEcharts5_2(){
		var myChart = echarts.init(document.getElementById('main5_2'));
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/chartcount.json',
			data:{operateType:3},
			success:function(json){
				var $entarchivesDto = json.data;
	            if(!$entarchivesDto){return;}
				var option = {
//						title : {
//							text: '八大产业',
//							x:'center'
//						},
						tooltip: { //提示框组件。全局
							trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
						},
						legend: {
							orient: 'vertical',//图例竖形展示
							left: '55%',//展示在右边
							top : 'center',
							itemWidth :10,
							itemHeight:10,
							selectedMode:false,//图例选择不开启
							data:['信息经济产业','环保产业','旅游产业','金融产业','健康产业','时尚产业','高端装备制造产业','文化创意产业','其他']
						},
						color: ['#5B9CD5','#ED7D31','#999999','#fff800','#3399ff','#70AD46','#13598a','#c23531','#2f4554'],//默认显示的颜色
						series: [
						         {
						        	 name:'八大产业 ',
						        	 type:'pie',
						        	 center:['30%','50%'],//设置图形坐标位置，横纵坐标
						        	 radius: ['30%', '50%'], //圆环半径：内半径、外半径（内半径社大显示成圆环图）内半径为0显示为圆饼
						        	 label: {
						        		 normal: {
						        			 show: false,
//					                    position: 'outside',
//					                    formatter:'{b}:\n {d}'
						        		 },
//					                emphasis: {
//					                    show: true,
//					                    textStyle: {
//					                        fontWeight: 'bold'
//					                    }
//					                }
						        	 },
						        	 itemStyle :{
						        		 normal: {
						        			 borderColor: '#fff',
						        			 borderWidth : 1
						        		 },
						        	 },
						        	 labelLine: {
						        		 normal: {
						        			 show: false,
						        		 }
						        	 },
						        	 data:[
						        	       {value:$entarchivesDto.industryType1, name:'信息经济产业'},
						        	       {value:$entarchivesDto.industryType2, name:'环保产业'},
						        	       {value:$entarchivesDto.industryType3, name:'旅游产业'},
						        	       {value:$entarchivesDto.industryType4, name:'金融产业'},
						        	       {value:$entarchivesDto.industryType5, name:'健康产业'},
						        	       {value:$entarchivesDto.industryType6, name:'时尚产业'},
						        	       {value:$entarchivesDto.industryType7, name:'高端装备制造产业'},
						        	       {value:$entarchivesDto.industryType8, name:'文化创意产业'},
						        	       {value:$entarchivesDto.industryType9, name:'其他'}
						        	       ]
						         }
						         ]
				};
				myChart.setOption(option);
			}});
	}
	//创业人群
	function initEcharts5_3(){
		var myChart = echarts.init(document.getElementById('main5_3'));
		var copyChart = echarts.init($('.js-last-echarts div')[0]);
//		var myChartadd_first = echarts.init(document.getElementById('js-first')); 
		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/chartcount.json',
			data:{operateType:4},
			success:function(json){
				var $entarchivesDto = json.data;
	            if(!$entarchivesDto){return;}
				var option = {
						tooltip: { //提示框组件。全局
							trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
						},
						legend: {
							orient: 'vertical',//图例竖形展示
							left: '50%',//展示在右边
							top : 'center',
							itemWidth :10,
							itemHeight:10,
							selectedMode:false,//图例选择不开启
							data:['毕业三年内大学生','高校科研院所专业技术人才','海外归国人才','返乡农民工','企业员工辞职创业','退役士兵','其他']
						},
						color: ['#5B9CD5','#ED7D31','#999999','#fff800','#3399ff','#70AD46','#13598a'],//默认显示的颜色
						series: [
						         {
						        	 name:'培育库企业类型',
						        	 type:'pie',
						        	 center:['30%','50%'],//设置图形坐标位置，横纵坐标
						        	 radius: ['30%', '50%'], //圆环半径：内半径、外半径（内半径社大显示成圆环图）内半径为0显示为圆饼
						        	 label: {
						        		 normal: {
						        			 show: false
						        		 },
						        	 },
						        	 itemStyle :{
						        		 normal: {
						        			 borderColor: '#fff',
						        			 borderWidth : 1
						        		 },
						        	 },
						        	 labelLine: {
						        		 normal: {
						        			 show: false,
						        		 }
						        	 },
						        	 data:[
						        	       {value:$entarchivesDto.entCrowdCode1, name:'毕业三年内大学生'},
						        	       {value:$entarchivesDto.entCrowdCode2, name:'高校科研院所专业技术人才'},
						        	       {value:$entarchivesDto.entCrowdCode3, name:'海外归国人才'},
						        	       {value:$entarchivesDto.entCrowdCode4, name:'返乡农民工'},
						        	       {value:$entarchivesDto.entCrowdCode5, name:'企业员工辞职创业'},
						        	       {value:$entarchivesDto.entCrowdCode6, name:'退役士兵'},
						        	       {value:$entarchivesDto.entCrowdCode7, name:'其他'}						        	       ]
						         }
						         ]
				};
				myChart.setOption(option);
				copyChart.setOption(option);
//				myChartadd_first.setOption(option); 
			}});
	}
	
	
	// 培育库企业
	function initEcharts3_1(){
		var myChart3_1 = echarts.init(document.getElementById('main3_1')); 
//		var mychartadd_last = echarts.init(document.getElementById('js-last'));
		var copyChart = echarts.init($('.js-first-echarts div')[0]);

		http.httpRequest({
			type:'POST',
			url:'/sment/entarchives/chartcount.json',
			data:{operateType:1},
			success:function(json){
				var $entarchivesDto = json.data;
	            if(!$entarchivesDto){return;}
				var option3_1 = {
					    tooltip: { //提示框组件。全局
					        trigger: 'item',  //触发类型。'item' 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
					    },
					    legend: {
					        orient: 'vertical',//图例竖形展示
					        left: '55%',//展示在右边
					        top : 'center',
							itemWidth :10,
							itemHeight:10,
							selectedMode:false,
					        data:['初创型企业','成长型企业','领军型企业']
					    },
	                    color: ['#5B9CD5','#ED7D31', '#70AD46'],//默认显示的颜色
					    series: [
					        {
					            name:'培育库企业类型',
					            type:'pie',
					            center:['30%','50%'],//设置图形坐标位置，横纵坐标
					        	radius: ['30%', '50%'], //圆环半径：内半径、外半径（内半径社大显示成圆环图）内半径为0显示为圆饼
					            label: {
					                normal: {
					                    show: false
					                }
					            },
					            itemStyle :{
					                normal: {
					                	borderColor: '#fff',
					                	borderWidth : 1
					                },
					            },
					            labelLine: {
					                normal: {
					                    show: false,
					                }
					            },
					            data:[
					                {value:$entarchivesDto.cultivationTypeCode1, name:'初创型企业'},
					                {value:$entarchivesDto.cultivationTypeCode2, name:'成长型企业'},
					                {value:$entarchivesDto.cultivationTypeCode3, name:'领军型企业'}
					            ]
					        }
					    ]
			};
        	myChart3_1.setOption(option3_1);
//        	mychartadd_last.setOption(option3_1);
			copyChart.setOption(option3_1);
        }});
	}
	
	function loadBulletins(){
		http.httpRequest({
			type:'POST',
			url:'/sment/bulletinsRecord/list.json',
			async:false,
			success:function(data){
				$('#ul-list').html("");
				if (data.status == 'success') {
					var length = data.data.length;
					var bodyHtml = "";
					if(length>0){
						for(var i=0;i<length;i++){
							bodyHtml = bodyHtml
								+ "<li><a  href='javascript:void(0);' bulletinId='"
								+ data.data[i].bulletinId
								+ "' isRead='"+data.data[i].isRead
								+ "' class='js-read'><i>● </i><span class='h-time'>"
								+ data.data[i].setTime + "</span>" +data.data[i].title+
								"[ " +data.data[i].setDeptname+" ]</a></li>";
                    		if(i==1){
                    			break;
                    		}
						}
					}
					$('#ul-list').append(bodyHtml);
				}
			}
		});
	}
	function bind(){
		util.bindEvents([
		     {
		    	 el:'.js-read',
		    	 event:'click',
		    	 handler:function(event){
		    		 var index=$(this).closest('li').index();
	                    var uid=$(this).attr("bulletinId");
	                    var isRead=$(this).attr("isRead");
	                    var parent =$(this).closest('li');//取到当前元素的父元素
	                    var bulletinUrl="";
	                    if(isRead=='1'){
	                        bulletinUrl='/sment/bulletinsRecord/scan?bulletinId=' + uid;
	                    }else{
	                    	bulletinUrl='/sment/bulletinsRecord/read?bulletinId=' + uid;
	                    }
	                    layer.dialog({
	                        title: '查看公告',
	                        area: ['1024px', '600px'],
	                        content: bulletinUrl,
	                        callback: function (data) { }
	                    });
	                    
		    	 }
		     },{
		    	el:'.u-all',
		    	event:'click',
		    	handler:function(event){
		    		layer.dialog({
                        title: '查看更多',
                        area: ['1024px', '600px'],
                        content: '/sment/bulletins/toMoreList',
                        callback: function (data) {
                        }
                    });
		    		//var url = '/sment/bulletins/toMoreList';
	        		//window.open(url,'_blank','');
		    	}
		     },{
				el:'.span_help',
				event:'click',
				handler:function(event){
					var title,helpState;
					if($(this).attr("state")==1){
						title = "待更新需求列表";
						helpState = "1";
					}else{
						title = "待帮扶";
						//helpState = "2,3";实质2,3
						helpState = "2";
					}
					layer.dialog({
						title: title,
						area: ['90%', '80%'],
						content: '/sment/entarchives/toWelcomeHelpList?helpState='+helpState,
						callback: function (data) {


						}
					});
				}
			},{
			el:'.span_txsx',
			event:'click',
				handler:function(event){
					var title,url;
					var state = $(this).attr("state");
					if(state == 1){
						title = "入库企业注销";
					}
					if(state == 2){
						title = "入库企业上规升级";
					}
					if(state == 3){
						title = "入库企业营收下降";
					}
					if(state == 4){
						title = "入库企业经营异常";
					}
					if(state == 5){
						title = "入库企业违法违规";
					}
				layer.dialog({
					title: title,
					area: ['90%', '80%'],
					content: '/sment/entarchives/toWelcomeTxsxList?state='+state,
					callback: function (data) {


					}
				});
			}
		}
		])
	}

	/**
	 * 文字上下滚动函数
	 */
//	function txtplay() {
//		var ulList = document.getElementById('js-ul-list');
//		ulList.innerHTML+=ulList.innerHTML;
//		ulList.style.height = 'auto';
//		var len = ulList.offsetHeight/2-6;
//		document.title = ulList.offsetHeight;
//		ulList.style.height = '20px';
//		//向上滚动
//		var time;
//		ulList.onmouseover=function(){clearInterval(time);}
//		ulList.onmouseout= play
//		function play(){
//			time = setInterval(function(){
//				ulList.scrollTop++;
//				if(ulList.scrollTop>len){
//					ulList.scrollTop = 0;
//				}
//			},50);
//		}
//		play();
//	}

})
