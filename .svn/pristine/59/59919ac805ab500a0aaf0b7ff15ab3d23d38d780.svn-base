require([ 'component/iframeLayer', 'common/util', 'common/http', 'echarts',
		'jquery.serialize' ], function(layer, util, http, echarts) { 
	var myEchart =null;
	init();
	
	function init() {
		bind(); 
	}

	function getJsonData() {
		 myEchart = echarts.init(document.getElementById('relationChart'));
		 var entNameStrs="";
		 var flag=false;
		 $("input:text").each(function(a,b){ 
			 if(b.value!=null&&b.value!=""){
				 entNameStrs+=$.trim(b.value)+",";
			 }else{
				 flag=true;
				 return;
			 } 
		 });
		 if(flag){
			 layer.msg("您还有企业名称未输入,请输入企业名称");
			 return false;
		 }
		 
		myEchart.showLoading({ text : "加载中，请稍后..." });
		 
		// 同步请求
		http.httpRequest({
			url : '/reg/server/relation/getIRelationInfo',
			serializable : false,
			data : { entNameStrs  : entNameStrs},
			type : 'post',
			async : false,
			success : function(data) {
				
				if (data.status == 'success') {
					var relationDatas = data.data;
					myEchartShow(relationDatas);
				} else if (data.status == 'fail') {
					myEchart.hideLoading();
					layer.msg(data.msg);
					return;
				}
			},
			error : function() {
				myEchart.hideLoading();
				layer.msg('系统异常，请重新登录尝试!');
			}
		});
	}

	// 页面展示：
	function myEchartShow(relationDatas) { 
		var categories = [  		{
  			name : '0'  			
  		},{ 			name : '1',
  			itemStyle : {
  				normal : {
  					color : '#3897C5'
  				}
  			}
  		},{
  			name : '2',
  			itemStyle : {
  				normal : {
  					color : '#B6A2DE'
  				}
  			}
  		}
  		];
		var option = {
			tooltip : {
				trigger : 'item',
				formatter :  
                	 function (params,ticket,callback) {
						  if(params.dataType==='node'){
							  var res = params.data['longName'];	                      
		                      return res;
						  }

                  }  
			},			
			animation : true,
			animationDurationUpdate : 1500,
			animationEasingUpdate : 'quinticInOut',
			
			series : [ {
				name : '法人关系',
				type : 'graph',
				layout : 'force',
				symbolSize : 30,
				roam : true,
				draggable : true,
				label : {
					normal : {
						show : true,
						position : 'right'
					}
				},
				
				data : relationDatas.nodes,
				links : buildLinks(relationDatas.links),
				categories : categories,
				edgeSymbol: ['circle', 'arrow'],
                edgeSymbolSize: [1, 6],
				lineStyle : {
					
				},
				force: {
	                	repulsion: 250,
	                	edgeLength:100,
	                    gravity: 0.1
//                    repulsion: opt.repulsion
                }
			} ]
		};

		myEchart.hideLoading();
		myEchart.setOption(option);
		
		myEchart.on('click', function (params) {
     	    if (params.componentType === 'markPoint') {
     	        // 点击到了 markPoint 上
     	        if (params.seriesIndex === 5) {
     	            // 点击到了 index 为 5 的 series 的 markPoint 上。
     	        }
     	    }
     	    else if (params.componentType === 'series') {
     	        if (params.seriesType === 'graph') { 
     	        	return;
     	            if (params.dataType === 'edge') {
     	                // 点击到了 graph 的 edge（边）上。
     	            }
     	            else {
     	            	if(params.data.category == '2'){
     	            		window.location.href = "/data/frdetail/zrrQuery?keyWord="+params.data.name+"%2B"+params.data.key;
     	            		return;
     	            	};
     	            	if(params.data.key != null && params.data.key != ""){
     	            		window.location.href = "/data/frdetail/djjbxx/"+params.data.key;
     	            	}
     	            }
     	        }
     	    }

     	});
	}

	/**
	 * 事件绑定
	 * @private
	 */
	function bind() {
		util.bindEvents([ {
			el : '#searchEnt',
			event : 'click',
			handler : function() {
				getJsonData();				
			}
		}
		])
	}

}); 


//删除关系企业
function removeCompany(kk) {
	var inputLength = $("input:text").length;
	if (inputLength == 4) {
		$("#companyName_4").remove();
	} else if (inputLength == 3) {
		$("#companyName_3").remove();
	} else {
		layer.msg("至少保留2个关系企业！");
	}
}

// 设置线条颜色
function buildLinks(links){
	var tempLinks = [];
	var tempStr = '{source:"",target:"",lineStyle:{normal:{color:"red",type:"solid",width:"2",curveness:"0",opacity:"0.8"}}}'; 	
	
	$.each(links,function(i,n){
		var tempObj =  eval('(' + tempStr + ')');
		tempObj['source'] = n['source'];
		tempObj['target'] = n['target'];
		//flag:1代表法定代表人 ，2代表股东关系（投资方）
		if(n.flag == '1'){//红
			tempObj.lineStyle.normal.color = '#ff8182';
		}else if(n.flag == '2'){//褐
			tempObj.lineStyle.normal.color = '#984746';
		}else if(n.flag == '3'){//蓝
			tempObj.lineStyle.normal.color = '#7188ff';
		}
        tempLinks.push(tempObj);
    });
	
    return tempLinks;
}


// 新增关系企业
function addCompany() {
	var wrapper = $("#js-params");
	var inputLength = $("input:text").length;

	var i = '';
	if (inputLength == '2') {
		i = 3;
	} else if (inputLength == '3') {
		i = 4;
	}

	if (inputLength < 4) {
		wrapper
				.prepend('<input class="rs-input" type="text" name="companyName_'
						+ i
						+ '" id="companyName_'
						+ i
						+ '"  placeholder="请输入企业名称或身份证号" style="width: 180px;">');
	} else {
		layer.msg("最多新增4个关系企业！");
		return;
	}
}

// 删除关系企业
function removeCompany(kk) {
	var inputLength = $("input:text").length;
	if (inputLength == 4) {
		$("#companyName_4").remove();
	} else if (inputLength == 3) {
		$("#companyName_3").remove();
	} else {
		layer.msg("至少保留2个关系企业！");
	}
}
