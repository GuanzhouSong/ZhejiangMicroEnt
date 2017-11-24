require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules','common/ajaxfileupload'], function (layer, dataTable, util, http,handlebars) {
	
	//用于防止重复添加表格内容
	var contentjson = {};
	
	//表格数据json
	var tableJsonStr=[];
	var _urlHead = window._CONFIG._urlHead;
	var _illegalitemUrlHead = window._CONFIG._illegalitemUrlHead;
	var copyFormNo = $("#copyFormNo").val();
	init();
	
	   function init() {
		   formValid();
	        bind();
	    }
		
	    //删除一条明细
	   $("#illegal_table").delegate('a','click',function(){
	    	var name=$(this).attr("delVal");
	    	delete contentjson[name];
	    	$(this).parent().parent().remove();
	    });
	   
	  //遍历表格，生成json结构
	    function createJsonStr(){
	    	tableJsonStr=[];
	    		$("#tb_ent_bd tr:gt(0)").each(function(i){
	    	    	var json={};
		    	    $(this).children("td").each(function(i){
		    	    	if(i==0){
		    	    		json.entName=$(this).text();
		    	    	} else if(i==1){
		    	    		json.certType=$(this).attr("cardcode");
		    	    	} else if(i==2){
		    	    		json.certNo=$(this).text();
		    	    	} else if(i==3){
		    	    		json.address=$(this).text();
		    	    	} else if(i==4){
		    	    		json.clientTel=$(this).text();
		    	    	}
		    	    });
	    	    	tableJsonStr.push(json);
		    	});
	    		$("#illegalStr").val(JSON.stringify(tableJsonStr));
	    		
	    		
	    }
	    
	   //添加涉嫌违法当事人
	    function addIllegalList(state) {
	    	layer.dialog({
	    		title: '添加涉嫌违法当事人',
	    		area: ['720px', '480px'],
	    		content: _urlHead+'addIllegal?state='+state,
	    		callback: function(data) {
	    			if(data.entName==undefined){//关闭页面-未添加
	    				layer.msg("已关闭！", {time: 1500}, function() {});
	    				return false;
	    			}
	    			//防止重复添加
	    			if(data.entName!=undefined && contentjson[data.entName]==undefined){
	    				$("#illegal_table").append("<tr><td>"+data.entName+"</td>"+
	    						"<td cardcode='"+data.cardcode+"'>"+data.cardtype+"</td>"+
								"<td>"+data.cardno+"</td>"+
								"<td>"+data.address+"</td>"+
								"<td>"+data.tel+"</td>"+
								"<td class='last-col'><a href='javascript:void(0)' name='"+data.entName+"'>删除</a></td>"+
								"</tr>");
		    			contentjson[data.entName]="1";
	    			}else{
	    				layer.msg("该当事人已添加！", {time: 1500}, function() {});
	    			}
	    		}
			});
	    }
	   
	    //协同事务提请抄送审核
	    function formValid(){
	    	$('#content_form').validate({
	            rules: {
	            	acceptDeptNames: { // 协同事务提请接收部门
	                    required: true
	                },
	                illegalItem: { //涉嫌违法事项
	                    required: true
	                },
	                copyInfoFrom: { //信息来源
	                    required: true
	                },
	                illegalCase: { //具体违法情况
	                    required: true
	                },
	                feedbackNeed: { //是否需要反馈处理结果
	                    required: true
	                },
	                copyDepartPerson: { //协同事务提请发起部门联系人
	                    required: true
	                },
	                copyDepartTel: { // 联系电话（必填）
	                    required: true
	                },
	                checkResult: { //审核结果
	                    required: true
	                },
	                checkPerson: { //审核人
	                    required: true
	                },
	                checkOpinion: { //审核意见
	                    required: true
	                }
	            },
	            messages: {},
	            onkeyup:false,
	            onfocusout:function(el){
	                $(el).valid();
	            },
	            showErrors:function(errorMap,errorList){
	            	$("#save").attr("disabled",false);
	                for(var i in errorMap){
	                    layer.tips(errorMap[i],$('#content_form input[name='+i+'],textarea[name='+i+']'),{
	                        tips:3,
	                        tipsMore:true,
	                        ltype:0
	                    });
	                }
	            },
	            submitHandler: function () {
	            	var index;
	                	var formParam = $('#content_form').serializeObject();
	                    http.httpRequest({
	                        url: _urlHead+'saveReview',
	                        serializable: true,
	                        data: formParam,
	                        type: 'post',
	                        success: function (json) {
	                        	if(json.status=="success"){
		    						layer.msg(json.msg, {time: 800}, function() {window.history.go(-1);});
		    					}else{
		    						$("#save").attr("disabled",false);
		    						layer.msg(json.msg, {time: 800}, function() {});
		    					}
	                        }
	                    });
	            }
	        })
	    	
	    }
	    
	    //协同事务提请抄送接收部门选择树
	    function selectDepartTree(){
	    	 layer.dialog({
	                title: '协同事务提请接收部门',
	                area: ['400px', '600px'],
	                content: '/common/system/sysdepart/alldeptcheckboxtreeselect',
	                callback: function (data) {
	                	var adCode = data.adCodesExcParent;
	                	var deptName = data.orgNamesExcParent;
	                        $("#acceptDepartNames").val(deptName);
	                        $("#acceptDepartCodes").val(adCode);
	                }
	            })
	    }
	    
	    //涉嫌违法事项
	    function selectIllegalItem(){
	    	 layer.dialog({
	                title: '涉嫌违法事项',
	                area: ['600px', '350px'],
	                content: _illegalitemUrlHead+'doEnIllegalItem?deptcode='+$("#copyDepartCode").val(),
	                callback: function (data) {
	                	if(data.flag){
	                		$("#illegalItem").val(data.text);
	                	}
	                }
	            })
	    }
	    
	    //无证无照涉嫌违法事项
	    function selectNocardItem(){
	    	 layer.dialog({
	                title: '涉嫌违法事项',
	                area: ['600px', '350px'],
	                content: _urlHead+'doEnNocardItem',
	                callback: function (data) {
	                	if(data.flag){
	                		$("#illegalItem").val(data.text);
	                	}
	                }
	            })
	    }
	    
	  //判断附件是否已存在
	    function contains_(array, str){
	    	var index, text;
	    	for(var i=0; i<array.length; i++){
	    		index = array[i].indexOf("-");
				text = array[i].substring(index + 1, array[i].length);
	    		if(text==str){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    //上传部分代码
	    var $files=$("#evidenceData"), filesArr=[], $upstate=$("#uploadState");
	    if($files.val() !=""){
	    	var val=$files.val().substring(0,$files.val().length-1);
	        filesArr=val.split("|");
	    }
	    function upload(e){
	    	var batchNo=$("#copyFormNo").val(), file=$("#file").val();
	    	if(file==""){
	    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
	    		return false;
	    	}
	    	if(contains_(filesArr, file)){
	    		layer.msg("抱歉，您已经上传过此文件！", {time: 2000}, function() {});
	    		return false;
	    	}
	    	e.hide();$upstate.show();
	    	$.ajaxFileUpload({
	    		url: _urlHead+'upload',
	            type: 'post',
	            data: {"batchNo":batchNo, "fileName":file},
	            secureuri: false,
	            fileElementId: 'btnFile',
	            dataType: 'text',
	            success: function(data, status){
	            	if(data !="error") {
	            		//放入数组
	            		filesArr.push(data);
		            	var str="";
		            	for(var i=0; i<filesArr.length; i++){
		            		str=str+filesArr[i]+"|";
		            	}
		            	$files.val(str);
						var index = data.indexOf("-");
						var text = data.substring(index + 1, data.length);
						$("#filelabel").append("<p class='file-upload-out'><i class='xbt-icon file-icon'></i><label>"+text+"</label> &nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"'>删除</a></p>");
		            	layer.msg("上传成功", {time: 1200}, function() { });
	            	}else {
	            		layer.msg("上传失败", {time: 2000}, function() {});
	            	}
	            	$("#file").val("");
					//重置file选择
	            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
	    			$upstate.hide();
	            	e.show();
	            },error: function(data, status){
	            	$("#file").val("");
					//重置file选择
	            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
	    			$upstate.hide();
	            	e.show();
	            	layer.msg("上传失败，请检查网络及文件大小", {time: 2000}, function() {});
	            }
	        });
	    }
	    //委托事件
	    $("#fileBox").delegate('input','change',function(){
			var text=$(this).val();
			var index = text.lastIndexOf("\\");
			text = text.substring(index + 1, text.length);
			$("#file").val(text);
		})
	    //上传
	    $("#btnUpload").click(function(){
			upload($(this));
		})
		//删除附件
		$("#filelabel").delegate('a','click',function(){
			var path=$(this).attr("path");
			var str="";
	    	for(var i=0; i<filesArr.length; i++){
	    		if(filesArr[i] !=path){
	        		str=str+filesArr[i]+"|";
	    		}
	    	}
	    	$files.val(str);
	    	var val=$files.val().substring(0,$files.val().length-1);
	        filesArr=val.split("|");
	    	$(this).parent().remove();
		});
	   
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#save',
	            event: 'click',
	            handler: function() {
	            	$("#save").attr("disabled",true);
	            	createJsonStr();
	            	$("#content_form").submit();
	            }
	        }, {
	            el: '#cancel',
	            event: 'click',
	            handler: function() {
	            	layer.msg("您取消了审核！", {time: 1500}, function() {window.history.go(-1);});
	            }
	        }, {
	            el: '#add_detail',
	            event: 'click',
	            handler: function() {
	            	var str = $("#copyCode").val();
	            	var state = "";
	            	if(str=="wzwz") state = "nocard";
	            	if(str=="qywfaj") state = "illegal";
	            	if(str=="qt") state = "other";
	            	addIllegalList(state);
	            }
	        }, {
	            el: '#depart_check',
	            event: 'click',
	            handler: function() {
	            	selectDepartTree();
	            }
	        }, {
	            el: '.illegal_item',
	            event: 'click',
	            handler: function() {
	            	selectIllegalItem();
	            }
	        }, {
	            el: '.nocard_item',
	            event: 'click',
	            handler: function() {
	            	selectNocardItem();
	            }
	        }, {
	            el: '.checkResult',
	            event: 'click',
	            handler: function() {
	            	$("#checkOpinion").val($(this).parents('label').text());
	            }
	        }, {
	            el: '#print',
	            event: 'click',
	            handler: function() {
	            	window.open(_urlHead+"doEnPrint","_blank");
	            }
	        }])
	    }
})
