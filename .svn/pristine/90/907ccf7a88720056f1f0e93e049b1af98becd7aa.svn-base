require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery', 'jquery.serialize', 'laydate', 'tab'], function (layer,dataTable, util, http) {

	init();
	 
	 function init(){
		 bind();
	 }
	 
	 //加载严违失信信息
	 function history(){
		 $.ajax({
    		type : "POST",
    		url : '/reg/server/seriouspunish/getSrcList',
			datatype : 'JSON',
			data: {"pid": $("#priPID").val()},
			async : true,
			success : function(json) {
				if(json !=null || json !=undefined){
					var srcList=$("#srcList");
					for(var i=1; i<json.length+1; i++){
						if(i==1){
							$("#lastPunDate").html(json[i-1].decDate);
						}
						srcList.append("<tr><td>"+i+"</td><td><a href='javascript:void(0)' data="+json[i-1].id+" class='look'>详情</a></td><td>行政处罚类</td><td>"+json[i-1].penDecNo+"</td><td>"+json[i-1].decDate+"</td><td>"+json[i-1].decorgCN+"</td></tr>")
					}
				}
			}
    	});
	 }
	 history();
	 
	 //依据校验
	 function check(){
		 var num = $("#secbased option:selected").val();
		 var str = "";
		 var main = "";
		 for(var i=1;i<=num;i++){
			 main = $.trim($(".tr"+i+" input").val());
			 str += main +";";
     		 if(main==null||main==""){
     			 layer.msg("所选依据不能为空！", {time: 3000}, function() {});
     			 return false;
     		 }
     	 }
		 $("#secBasedStr").val(str);
		 return true;
	 }
	 
	 //保存
	 function save(){
		 var formParam = $('#applyForm').serializeObject();
         http.httpRequest({
             url: '/reg/server/seriouspunish/updateApply',
             serializable: false,
             data: formParam,
             type: 'post',
             success: function (json) {
             	if(json.status=="success"){
             		var data=new Object(); 
             		data.reload=true;
             		layer.msg(json.msg, {time: 1000}, function() {});
					layer.close(data);
				}else{
					layer.msg(json.msg, {time: 3500}, function() {});
				}
             }
         });
	 }
	 
 $(".close-box").click(function(){
		 
		 $(this).parent().parent().find(".ipt-txt").val("");
		 
	 })
	    
    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function() {
            	if(check()){
                	save();
            	}
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
        }, {
            el: '#secbased',
            event: 'change',
            handler: function() {
            	var num = $("#secbased option:selected").val();
            	$(".tr").hide();
            	for(var i=1;i<=num;i++){
            		$(".tr"+i).show();
            	}
            }
        },{
        	el:'#packUpOrUnFurled',
        	event:"click",
        	handler:function(){
				//展开收起箭头
				var $i=$(this).find('i');
				if($i.hasClass('tran-icons')){
					$i.removeClass('tran-icons').addClass('downarrow');
				}else{
					$i.removeClass('downarrow').addClass('tran-icons');
				}

        		var text = $("#packUpOrUnFurled_").html();
        		if(text=="收起"){
        			$("#packUpOrUnFurled_").html("展开");
        			$("#sevBreachInforTable").fadeOut();
        			$("#h5").before("<br id='br'/>");
        		}else if(text = "展开"){
        			$("#packUpOrUnFurled_").html("收起");
        			$("#sevBreachInforTable").fadeIn();
        			$("#br").remove();
        		}
        	}
        },{
        	el:'.look',
        	event:'click',
        	handler:function(){
        		var id = $(this).attr("data");
        		layer.dialog({
                    title: '严违失信信息查看',
                    area: ['80%', '80%'],
                    content: "/reg/server/seriouspunish/caseDetail?id="+id,
                    callback: function (data) {
                    }
                })

        	}
        }])
    }

})