require(['common/util', 'component/iframeLayer','layer1','common/http','component/dataTable', 'jquery'], function (util, layer,layer1, http, dataTable) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }
    
    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	var pripid = $("#pripid").val();
        table = dataTable.load({
            el: '#permit-table',
            showIndex: true,
            scrollX:true, 
            ajax: {
                url:'/reg/server/login/phoneapply/list_his.json',
                data:function(d){
                    d.params = {"pripid":pripid};
                }
            },
            columns: [
                {data: null},
                {data: 'pasid'},
                {data: 'lerep'},
                {data: 'lerepphone'},
                {data: 'lianame'},
                {data: 'tel'},
                {data: 'liaidtype'},
                {data: 'liaidnum'},
                {data: 'applytime'},
                {data: null},
                {data: 'username'},
                {data: 'apprevieworg'}
            ],
            columnDefs: [
                           {
                               targets: 6,
                               render: function (data, type, row, meta) {
                            	   if(row.liaidtype == "10") {
                  	    			     return "居民身份证";
	                  				}else if(row.liaidtype == "20") {
	                  	    			 return "军官证";
	                  				}else if(row.liaidtype == "30") {
	                  					return "警官证";
	                  				}else if(row.liaidtype == "40") {
	                  					return "外国地区护照";
	                  				}else if(row.liaidtype == "52") {
	                  					return "香港身份证";
	                  				}else if(row.liaidtype == "54") {
	                  					return "澳门身份证";
	                  				}else if(row.liaidtype == "56") {
	                  					return "台湾身份证";
	                  				}else {
                  					   return "其他有效身份证件";
                  					}
                  	    		}
                            },

                            {
                                targets: 9,
                                render: function (data, type, row, meta) {
                                	if(row.username != null && row.username != ""){
                                		return "书式备案"; 
                                	}else{
                                		return "在线备案"; 
                                	}
                   	    		}
                             }
                       ]
          })
     }  
    
    //按钮事件
    function bind() {
        util.bindEvents([
		{
		    el: '.save',
		    event: 'click',
		    handler: function () {
		    	var pasid = $("#pasid").val();
		    	http.httpRequest({
		            url: '/reg/server/login/phoneapply/doAccept',
		            data:{'pasid':pasid},
		            type: 'post',
		            serializable: false,
		            success: function (data) {
	            	if(data.status =='success'){
		            	layer.msg(data.msg, {time: 1000}, function (){
		            		layer1.open({
		                        shade: [0.5,'#000'],
		                        type: 1,
		                        content: $('#send-message-layer'),
		                        title: false,
		                        area: ['700px','400px']
		                    })
                        });
	            	  }else{
	            		  layer.msg(data.msg);
	            	  }
                    }
		        })
		    }
		},
		{
		    el: '#print',
		    event: 'click',
		    handler: function () {
		    	var pasid = $("#pasid").val();//流水号
		    	var regno = $("#regno").val();
		    	var _id = "_doPrint_"+new Date().getTime();
		    	var url = "/reg/server/login/phoneapply/print?pasid="+pasid+"&regno="+encodeURIComponent(regno)+'&_id='+_id;
				try{
					window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
				}catch(e){
					alert("打印错误!");
				}
		    }
		},
		{
		    el: '#send',
		    event: 'click',
		    handler: function () {
		    	var entname = $("#entname").val();
		    	var lianame = $("#lianame").val();
		    	var priPID = $("#pripid").val();
		    	var tel = $("#tel").val();
		    	if($(".sendMsg").prop("checked")){
	    		 http.httpRequest({
			            url: '/reg/server/login/phoneapply/doSendMsg',
			            data:{'entname':entname,'lianame':lianame,'tel':tel,'priPID':priPID},
	            		success: function (data) {
	            			if(data.status =='success'){
		            			layer.msg(data.msg, {time: 1000}, function (){
		            				 layer1.closeAll();
		            				 layer.close({reload: true});
		                        });
	            			}else{
	            				layer.msg(data.msg);
	            			}
	                    }
			        })
		    	}else{
		    		layer1.closeAll();
		    		layer.close({reload: true});
		    	}
		      }
		}])
    }
});
