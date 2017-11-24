require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#choseSpecial',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择专项库',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/scSpecialSelect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!="" && returncode!='undifine'){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    		$("#specialCode").val(returncode);
                        	$("#specialName").val(data.returnname);  
                    	}
                    }
                })
            }
        },{
            el: '#choseMark',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择监管标签',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/markTreeView?isMarkFlag=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1);
                    		$("#markCode").val(returncode);
                        	$("#markName").val(data.returnname);  
                    	}
                    }
                })
            }
        },{
            el: '#qzcodetree',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择许可证',
                    area: ['500px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/licenseListCheckboxTreePage',
                    callback: function (data) { 
                    	if(typeof data.reload.code=="undefined"){
                    		$("#qzCode").val("");
                         	$("#qzName").val("");
                    	}else{
                    		 var content = data.reload.content;
                    		 if(content != "" && content!=null){
                    			var nameArry = content.split(',');
                    			var licStr="";
                    			for(var i=0;i<nameArry.length;i++){
                    				var strArry = nameArry[i].split('-');
                    				licStr += strArry[1]+',';
                    			}
                    			$("#qzName").val(licStr.substring(0, licStr.length-1));
                    		 }
                    	} 
                    }
                })
            }
        },{
            el: '#ok',
            event: 'click',
            handler: function () { 
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entback/countSpecial';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entback/countSpecial';
            	}
            	var entCatgArry = new Array();
            	var formParam = $("#taskForm").serializeObject();
            	$("#taskForm input[name ='entCatg']").each(function(){
            		if($(this).prop("checked")){
            			entCatgArry.push($(this).val());
            		}
            	})
            	formParam.entCatg = entCatgArry.toString();
    			http.httpRequest({
    				url: url,
    				data: formParam,
    				type: 'post',
    				success: function (result) {
    					$("#countspe").val(result.data);
    				}
    			})
            }
        },{
            el: '#addAll',
            event: 'click',
            handler: function () { 
            	var userType = $("#userType").val();
            	var url = '/reg/pub/server/sccheck/entback/addSpecial';
            	if(userType == '2'){
            		url = '/syn/pub/server/sccheck/entback/addSpecial';
            	}
            	var entCatgArry = new Array();
            	var formParam = $("#taskForm").serializeObject();
            	$("#taskForm input[name ='entCatg']").each(function(){
            		if($(this).prop("checked")){
            			entCatgArry.push($(this).val());
            		}
            	})
            	formParam.entCatg = entCatgArry.toString();
    			http.httpRequest({
    				url: url,
    				data: formParam,
    				type: 'post',
    				success: function (data) {
    					layer.msg(data.msg, {time: 1000}, function () {
    						layer.close({reload: true});
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#specialCode").val("");
            	$("#markCode").val("");
            	$("#qzCode").val("");
            }
        }])
    }

})
