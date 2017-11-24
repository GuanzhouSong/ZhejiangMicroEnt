require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	/*
	 * 初始化
	 */
	init();
	
	function init(){
		loadBulletins();
		bind();
	}
	

	
	function loadBulletins(){
		http.httpRequest({
			type:'POST',
			url:'/sment/bulletinsRecord/list.json',
			success:function(data){
				$('.more_ul-list').html("");
				if (data.status == 'success') {
					var length = data.data.length;
					var bodyHtml = "";
					if(length>0){
						bodyHtml = bodyHtml + "<ul>"
						for(var i=0;i<length;i++){
							bodyHtml = bodyHtml
								+ "<li class='clearfix' style='padding-bottom:10px;'><a  href='javascript:void(0);' bulletinId='"
								+ data.data[i].bulletinId
								+ "' isRead='"+data.data[i].isRead
								+ "' class='li-red js-read'><i class='li-disc'></i><span class='h-time'>"
								+ data.data[i].setTime + "</span>" +data.data[i].title+
								"[ " +data.data[i].setDeptname+" ]</a></li>";
						}
						bodyHtml = bodyHtml + "</ul>"
					}
					$('.more_ul-list').append(bodyHtml);
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
		     }
		])
	}

})
