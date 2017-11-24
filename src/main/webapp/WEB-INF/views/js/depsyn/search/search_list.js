require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'component/paginationPage',
    'jquery','jquery.serialize', 'pagination'], function (layer, dataTable, util, http, paginationPage) {

    
    var currpage=0, length=10, $list=$("#ent-list"), $history=$("#history"), $params=$("#params");
	init();

    /**
     * 初始化集合
     */
    function init() {
    	params();
    	history();
        bind();
    }
    
    //查询
    function search(currpage, length) {
    	var keyword=$("#key").val().replace(/(^\s*)|(\s*$)/g, "");
    	$("#keyword").val(keyword);
    	var params=$("#search-from").serializeObject();
	    http.httpRequest({
	        url: '/depsyn/search/appsearchlist.json',
	        type: 'post',
	        data: {start: length*currpage, length: length, params: params},
	        success: function(json) {
	        	var itemCount = json.data.recordsTotal; //获取查询出来的总数
	        	$("#totalPage").html(itemCount);
                $('#pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 1,//边缘页数
                    items_per_page:10,
                    current_page: currpage,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(currpage, jq){
                    	search(currpage, length);
                    }
                });
                draw(json.data.data, keyword);
                if(itemCount>50){
                	$("#total").text(50);
                	$("#costtime").text(json.costtime);
                	$("#title").show();
                }else
                	$("#title").hide();
	        }
	    });
    }
    
    function draw(json, keyword){
    	$list.html("");
    	for(var i=0; i<json.length; i++){
    		$list.append('<li>'+
					        	'<a href="javascript:void(0)" pid='+json[i].priPIDDesc+'>'+
					                '<span class="name">'+keyWord(json[i].entName, keyword)+'</span>'+
					                '<i class="icon-rectangle" style="display:inline">'+regState(json[i])+'</i>'+
					            '</a>'+
					            '<div class="item-text">'+
					                '<span class="code"><i class="book-icon"></i>统一社会信用代码/注册号: '+regNo(json[i])+'</span>'+
					                '<span class="person"><i class="person-icon"></i>法定代表人: '+json[i].leRep+'</span>'+
					                '<span><i class="date-icon"></i>成立日期: '+json[i].estDate+'</span>'+
					            '</div>'+
					        '</li>');
    	}
    }
    
    function regNo(json){
    	if(json.uniscid==null){
    		return json.regNO;
    	}else
    		return json.uniscid;
    }
    
    function regState(json){
    	if(json.regState=='K' || json.regState=='A' || json.regState=='B' || json.regState=='DA'){
    		return '存续（在营、开业、在册）';
    	}else if(json.regState=='X'){
    		return '注销';
    	}else if(json.regState=='C'){
    		return '撤销';
    	}else if(json.regState=='D'){
    		return '吊销';
    	}else if(json.regState=='Q'){
    		return '迁出';
    	}
    }
    
    //关键字标亮
    function keyWord(name, keyword){
    	if(keyword !=""){
	        var fen=name.split(keyword);
	        return fen.join('<span style="color:#F00;">'+keyword +'</span>');
    	}
    	return name;
    }
    
    //历史记录
    function history() {
    	$.ajax({
    		type : "POST",
			url : '/depsyn/search/historyList',
			datatype : 'JSON',
			data: {},
			async : true,
			success : function(json) {
				if(json != null && json !=undefined && json.length>0){
					for(var i=0; i<json.length; i++){
						$history.append('<li>'+
	                            					'<a href="javascript:void(0)">'+json[i].hisEntName+'</a>'+
	                        						'<p class="time"><i class="icon-time"></i>'+json[i].fromNow+'</p>'+
	                    						  '</li>');
					}
				}else
					$history.append('<li><a href="javascript:void(0)">无记录</a><p class="time"></p></li>');
			}
    	})
    }
    
    //委托注册条目点击事件
    $list.delegate('a','click',function(){
    	window.location.href="/depsyn/search/baseinfosyn?encryPriPID="+$(this).attr("pid");
    });
    
    var k=0;
    $("#ind-more").click(function(){
    	if(k==0){
    		$(this).html("收起<i></i>")
			k=1;
    		$(".ind-more").show();
		}else{
			$(this).html("展开<i></i>")
			k=0;
			$(".ind-more").hide();
		}
    })
    
    //企业分类
    $("#p-entType a").click(function(){
    	$(this).addClass("selected").siblings().removeClass("selected");
    	$("#entType").val($(this).attr("data"));
    	search(0, length);
    });
    
    //企业状态
    $("#p-regState a").click(function(){
    	$(this).addClass("selected").siblings().removeClass("selected");
    	$("#regState").val($(this).attr("data"));
    	search(0, length);
    });
    
    //注册资本
    $("#p-regCap a").click(function(){
    	$(this).addClass("selected").siblings().removeClass("selected");
    	var val=$(this).attr("data");
    	if(val==100){
    		$("#regCapStart").val(0);
    		$("#regCapEnd").val(100);
    	}else if(val==200){
    		$("#regCapStart").val(100);
    		$("#regCapEnd").val(200);
    	}else if(val==500){
    		$("#regCapStart").val(200);
    		$("#regCapEnd").val(500);
    	}else if(val==1000){
    		$("#regCapStart").val(500);
    		$("#regCapEnd").val(1000);
    	}else if(val=="more"){
    		$("#regCapStart").val(1000);
    		$("#regCapEnd").val(999999);
    	}else if(val==""){
    		$("#regCapStart").val("");
    		$("#regCapEnd").val("");
    	}
    	search(0, length);
    })
    
    //成立时间
    var date = new Date();
    var time={};
    time.year=date.getFullYear();
    time.month=date.getMonth()+1;
    time.day=date.getDate();
    $("#p-estDate a").click(function(){
    	$(this).addClass("selected").siblings().removeClass("selected");
    	var val=$(this).attr("data");
    	if(val==1){
    		$("#estDateStart").val(time.year-1+"-"+time.month+"-"+time.day);
    		$("#estDateEnd").val(time.year+"-"+time.month+"-"+time.day);
    	}else if(val==5){
    		$("#estDateStart").val(time.year-5+"-"+time.month+"-"+time.day);
    		$("#estDateEnd").val(time.year-1+"-"+time.month+"-"+time.day);
    	}else if(val==10){
    		$("#estDateStart").val(time.year-10+"-"+time.month+"-"+time.day);
    		$("#estDateEnd").val(time.year-5+"-"+time.month+"-"+time.day);
    	}else if(val==15){
    		$("#estDateStart").val(time.year-15+"-"+time.month+"-"+time.day);
    		$("#estDateEnd").val(time.year-10+"-"+time.month+"-"+time.day);
    	}else if(val==""){
    		$("#estDateStart").val("");
    		$("#estDateEnd").val("");
    	}
    	search(0, length);
    })
    
    //行业条件
    $("#p-industryCo a").click(function(){
    	$(this).addClass("selected").siblings().removeClass("selected");
    	$("#industryCo").val($(this).attr("data"));
    	search(0, length);
    })
    
    //保存筛选条件
    function savekeys() {
    	var p1=$("#p-topic .selected").html();
    	var p2=$("#p-entType .selected").html();
    	var p3=$("#p-regState .selected").html();
    	var p4=$("#p-regCap .selected").html();
    	var p5=$("#p-estDate .selected").html();
    	var p6=$("#p-industryCo .selected").html();
    	$.ajax({
            url: '/depsyn/search/saveParams',
            data: {params: p1+"+"+p2+"+"+p3+"+"+p4+"+"+p5+"+"+p6},
            type: 'post',
            success: function(data) {
        		layer.msg(data.msg, {time: 1500}, function() {
        			params();
                });
            }
        })
    }
    
    //筛选记录
    function params() {
    	$params.html("");
    	$.ajax({
    		type: "POST",
			url: '/depsyn/search/paramsList',
			datatype: 'JSON',
			data: {},
			async: true,
			success: function(json) {
				if(json != null && json !=undefined && json.length>0){
					for(var i=0; i<json.length; i++){
						$params.append('<li><a href="javascript:void(0)">'+json[i].params+'</a></li>');
					}
				}else
					$params.append('<li><a href="javascript:void(0)">无记录</a></li>');
			}
    	})
    }
    
    var index=0, olddex=0, $key=$("#key");
	$("#search_tab li").click(function(){
		index=$(this).index();
		$(this).addClass("selected").siblings().removeClass("selected");
		if(index != olddex){
			$("#title").hide();
			$("#ent-list").html("");
			$("#totalPage").html("-");
			$("#pagination").html("");
		}
		if(index==0){
			$key.attr("placeholder", "企业名称  统一信用代码/注册号  法定代表人");
		}else if(index==1){
			$key.attr("placeholder", "企业名称");
		}else if(index==2){
			$key.attr("placeholder", "统一社会信用代码/注册号");
		}else if(index==3){
			$key.attr("placeholder", "法定代表人");
		}else if(index==4){
			$key.attr("placeholder", "经营范围");
		}
		$("#type").val(index);
	})
    
    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function() {
        		search(0, length);
            }
        },{
            el: '#savekeys',
            event: 'click',
            handler: function() {
            	savekeys();
            }
        }])
    }
    
});
