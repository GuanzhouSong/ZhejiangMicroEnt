require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
    'component/paginationPage',
    'jquery','jquery.serialize','laydate','pagination','component/backToTop'], function (layer, dataTable, util, http, handlebars,paginationPage) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable_objectionInfo();//异议信息
    	initDataTable_scanResult();//简易注销结果信息
    	//bind();
    }
    
    var table;
    
    //异议信息
    function initDataTable_objectionInfo(){
		loadData_objectionInfo(0,5);
    }
    function loadData_objectionInfo(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/syn/erescobjinfo/list.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_objection').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadData_objectionInfo(page,5);
                    }
                });
				var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
				
				handlebars.registerHelper("transCN", function(data) {
					
                	var showResult = data;
                	/*if(data==""||data==null){
                		return "";
                	}
                	var scResultArr = scResults.split(",");
                	var showResult = "";
                	for(var i=0;i<scResultArr.length;i++){
                		if(parseInt(scResultArr[i]) == 1){
                			showResult = showResult + '有债权债务未结清;';
                		}else if(parseInt(scResultArr[i]) == 2){
                			showResult = showResult + '属于涉及国家规定实施准入特别管理措施的外商投资企业;';
                		}else if(parseInt(scResultArr[i]) == 3){
                			showResult = showResult + '正在被列入企业经营异常名录或严重违法失信企业名单;';
                		}else if(parseInt(scResultArr[i]) == 4){
                			showResult = showResult + '存在股权（投资权益）被冻结，出质或动产抵押等情形;';
                		}else if(parseInt(scResultArr[i]) == 5){
                			showResult = showResult + '有正在被立案调查或采取行政强制，司法协助，被予以行政处罚等情形的;';
                		}else if(parseInt(scResultArr[i]) == 6){
                			showResult = showResult +  '企业所属的非法人分支机构未办理注销登记;';
                		}else if(parseInt(scResultArr[i]) == 7){
                			showResult = showResult +  '曾被终止简易注销程序;';
                		}else if(parseInt(scResultArr[i]) == 8){
                			showResult = showResult +  '属于法律，行政法规或者国务院决定规定在注销登记前需经批准的企业;';
                		}else{
                		}
                	}
                	if(showResult){*/
                		if(showResult!=null&&showResult!=""&&showResult.length>50){
                			return "<span title='"+showResult+"'>"+showResult.substring(0,50)+"..."+"</span>";
                		}
                	//}
                	return showResult;
				})
                var myTemplate = handlebars.compile($('#table-template-objection').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-objection').html(myTemplate(data));
                $("#_total_objection").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_objection").text(pageNum);//共多少页
            }
        });
    }
    
    //简易注销结果信息
    function initDataTable_scanResult(){
		loadData_scanResult(0,5);
    }
    function loadData_scanResult(page, length, callback) {
        var params = $('#params').serializeObject();//查询参数
        http.httpRequest({
            url: '/syn/erescscrinfo/erescList.json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_scrinfo').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page:5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadData_scanResult(page,5);
                    }
                });
				var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*5);});//序号
                
                var myTemplate = handlebars.compile($('#table-template-scrinfo').html());
                if(typeof itemCount!='undefined' &&itemCount>0) $('#table-scrinfo').html(myTemplate(data));
                $("#_total_scrinfo").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#_pageNum_scrinfo").text(pageNum);//共多少页
            }
        });
    }

    function bind() {
        util.bindEvents([
	        {
	            el: '#mainmember',
	            event: 'click',
	            handler: function() {
	            	var encryPriPID=$("#encryPriPID").val();
	        		window.open("/midmember/list?encryPriPID="+encryPriPID);
	            }
	        }
	      //  打印事件
			,
			{
				el: '#print-icon',
				event: 'click',
				handler: function() {
					
					var encryPriPID=$("#encryPriPID").val();
					window.open("/midbranch/toinfoprint?encryPriPID="+encryPriPID);
				}
			},{
	            el: '#entbranch',
	            event: 'click',
	            handler: function() {
	            	var encryPriPID=$("#encryPriPID").val();
	        		window.open("/midbranch/list?encryPriPID="+encryPriPID);
	            }
	        },{
	            el: '#mainbrand',
	            event: 'click',
	            handler: function() {
	            	var encryPriPID=$("#encryPriPID").val();
	        		window.open("/tmDetailInfo/list?encryPriPID="+encryPriPID);
	            }
	        }
        ])
    }

})
