require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    
    function bind() {
        util.bindEvents([
	        {
	            el: '#ok',
	            event: 'click',
	            handler: function () { 
	            	var uids = $("#uids").val();
	            	var appointLocalAdm = $("#appointLocalAdm").val();
	            	if(appointLocalAdm == ""){
	            		layer.msg("请先选择检查机关", {time: 2000}, function() {});
	            		return false;
	            	}else if (appointLocalAdm.length == 2){
	            		appointLocalAdm = appointLocalAdm + "000000";
	            	}if (appointLocalAdm.length == 4){
	            		appointLocalAdm = appointLocalAdm + "0000";
	            	}if (appointLocalAdm.length == 6){
	            		appointLocalAdm = appointLocalAdm + "00";
	            	}
        			http.httpRequest({
        				url: window._CONFIG.chooseUrl + '/server/specialrec/result/appoint',
        				data: {
        					uids : uids,
        					appointLocalAdm : appointLocalAdm
        				},
        				type: 'post',
        				success: function (data) {
        					layer.msg(data.msg, {time: 1000}, function () {
        						if(data.status == 'success'){
        							layer.close({reload: true});
        						}
        					});
        				}
        			})
	            }
	        },{
	            el: '#close',
	            event: 'click',
	            handler: function () { 
	            	layer.close();
	            }
	        },{
	        	el: '#choseregUnit',
	            event: 'click',
	            handler: function () { 
	            	layer.dialog({
	                    title: '选择检查机关',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regunit/regunitsingselect?isPermissionCheck=false',
	                    callback: function (data) { 
	                		var returncode=data.returncode;
	                      	$("#appointLocalAdm").val(returncode);
	                      	$("#localAdmName").val(data.returname); 
	                    }
	                })
	            }
	        },{
                el: '#choseDept',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择部门',
                        area: ['400px', '600px'],
                        content: window._CONFIG.select_detp_tree_url,
                        callback: function (data) {
                            if(data.orgCodes){
                                $("#appointLocalAdm").val(data.orgCodes);
                                $("#regOrgName").val(data.orgNames);
                            }
                            if(data.orgCode){
                                $("#appointLocalAdm").val(data.orgCode);
                                $("#regOrgName").val(data.orgName);
                            }
                        }
                    })
                }
            }
        ])
    }
})
