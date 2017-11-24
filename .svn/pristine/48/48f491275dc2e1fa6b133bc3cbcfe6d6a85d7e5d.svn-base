require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize', 'common/ajaxfileupload'], function(layer, dataTable, util, http) {
	
	var urlHead=window._CONFIG.urlHead;
	var contentArr=[]; 
	init();
	
	//用于防止重复添加表格内容
	var contentjson={};
	//
	var $tb_ent=$("#tb_ent_bd"), $tb_man=$("#tb_man_bd");
	//类型（企业，自然人）
    var type=$("#punType").val();
    var $cause=$("#punCause");
	var $field=$("#punField");
    //loading
    var load=undefined;
    
	/**
     * 初始化函数集合
     */
    function init() {
        //formValid();
        bind();  
    } 
    
    // 部门单选
    function doSelectExeDeptCode() {
        layer.dialog({
            title: '选择惩戒执行部门',
            area: ['350px', '666px'],
            content: window._CONFIG.select_dept_url,
            callback: function (data) {
                if(data.orgNamesExcParent!=undefined&&data.adCodesExcParent!=undefined){
                	//adCodesExcParent
                    $("#punExeDept_s").html(data.orgNamesExcParent);
                    $("#punExeDept").val(data.orgNamesExcParent);
                    $("#punExeDeptCode").val(data.adCodesExcParent);
                }
            }
        })
    }
    
    
    function isPhone(value) {
    	 var length = value.length;
         var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;//手机
         var tel =  /^\d{4}-?\d{7,8}$|^\d{7,8}$|^\d{3}-?\d{3}-?\d{4}$/; //电话
         return ((length == 11 && mobile.test(value)) || tel.test(value));
	}
    
    
    function isEmail(value) {
		var val=value;
		if (val.replace(/(^\s*)|(\s*$)/g, "") == "") {
			return false;
		}
	    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    if (filter.test(val)) {
	    	return true;
	    } else {
	    	return false;
	    }
	} 
    
    //根据领域加载事由
    function ruleCauseLoad() {
		$cause.html("");
    	$.ajax({
    		type : "POST",
			url : urlHead+'/noCreditPunish/rule/getCauseByField',
			datatype : 'JSON',
			data: {"punField": $field.val()},
			async : true,
			success : function(json) {
				$cause.append("<option value='' selected='selected'>请选择..</option>")
				for(var i=0; i<json.length; i++) {
					$cause.append("<option value='"+json[i].punCause+"'>"+json[i].punCause+"</option>")
				}
			}
    	});
    }
    
    //加载规则
    function ruleInfoLoad() {
    	if ($field.val() !="" && $cause.val() !="") {
	    	$.ajax({
	    		type : "POST",
	    		url : urlHead+'/noCreditPunish/rule/getRuleByFieldAndCause',
				datatype : 'JSON',
				data: {"punField": $field.val(), "punCause": $cause.val()},
				async : true,
				success : function(json) {
					if(json !=null && json != "" && json !=undefined) {
						$("#legBasis_s").text(json.legBasis);
						$("#legBasis").val(json.legBasis);
						
						$("#punRule_s").text(json.punRule);
						$("#punRule").val(json.punRule);
						
						$("#punMea_s").text(json.punMea);
						$("#punMea").val(json.punMea);
						
//						$("#punExeDept_s").text(json.punExeDept);
//						$("#punExeDept").val(json.punExeDept);
//						$("#punExeDeptCode").val("");
					} else
						layer.msg("当前【领域】跟【事由】形成的组合无对应规则。请重新选择", {time: 4000}, function() {});
				}
	    	})
    	}
    }
    
    //明细操作事件
    $tb_ent.delegate('a','click',function(){
    	var tag=$(this).attr("tag");
    	if(tag=="del"){
	    	var priPID=$(this).attr("priPID");
	    	delete contentjson[priPID];
	    	$(this).parent().parent().remove();
	    	if(contentArr!=null&&contentArr.length>0){
	    		for(var b=0;b<contentArr.length;b++){
	    			if(contentArr[b].priPID==priPID){
	    				contentArr.splice(b,1);
	    				break;
	    			}
	    		}
	    	}
	    	
	    	contentArr=createJsonStr(); 
	    	$tb_ent.html("");
			$tb_ent.append("<tr><th>序号</th>"+
					"<th>企业名称</th>"+
					"<th>统一信用代码/注册号</th>"+
					"<th>惩戒时的法定代表人(负责人)</th>"+
					"<th>身份证号</th>"+
					"<th>失信惩戒记录</th>"+
					"<th>操作</th>"+
					"</tr>");
			if(contentArr!=null&&contentArr.length>0){
				var count=1; 
				for(var a=0;a<contentArr.length;a++){
					var dataObj=contentArr[a];
					var line="<td value='0'>0</td>";
    				if(dataObj.recordCount>0) {
    					line="<td value='"+dataObj.recordCount+"'><a href='javascript:void(0);' tag='view' priPID='"+dataObj.priPID+"'>"+dataObj.recordCount+"</a></td>"
    				}
    				var ht="<tr><td>"+count+"</td>"+ 
					"<td>"+dataObj.entName+"</td>"+
					"<td style='display:none'>"+dataObj.priPID+"</td>"+
					"<td style='display:none'>"+dataObj.regNo+"</td>"+ 
					"<td>"+filterNull(dataObj.reguniCode)+"</td>"+
					"<td>"+filterNull(dataObj.leRep)+"</td>"+  
					"<td>"+filterNull(dataObj.cardNo)+"</td>"+line+
					"<td style='display:none'>"+dataObj.cerType+"</td>"+
					"<td style='display:none'>"+dataObj.uniCode+"</td>"+
					"<td class='last-col'><a href='javascript:void(0)' tag='del' priPID='"+dataObj.priPID+"'>删除</a></td>"+
					"</tr>";
    				$tb_ent.append(ht);
    				count++;
				}
			} 
	    	
    	}else if(tag=="view"){
    		var priPID=$(this).attr("priPID");
    		recordDialog(priPID, "ent");
    	}
    });
    
    //明细操作事件
    $tb_man.delegate('a','click',function(){
    	var tag=$(this).attr("tag");
    	if(tag=="del"){
	    	var cardNo=$(this).attr("cardNo");
	    	delete contentjson[cardNo];
	    	if(contentArr!=null&&contentArr.length>0){
	    		for(var b=0;b<contentArr.length;b++){
	    			if(contentArr[b].cardNo==cardNo){
	    				contentArr.splice(b,1);
	    				break;
	    			}
	    		}
	    	}
	    	$(this).parent().parent().remove();
	    	
	    	contentArr=createJsonStr(); 
	    	$tb_man.html("");
			$tb_man.append("<tr><th>序号</th>"+
					"<th>当事人姓名</th>"+
					"<th>身份证号</th>"+
					"<th>联系电话</th>"+
					"<th>失信惩戒记录</th>"+
					"<th>操作</th>"+
					"</tr>"); 
			if(contentArr!=null&&contentArr.length>0){
				var count=1; 
				for(var c=0;c<contentArr.length;c++){
					var dataObj=contentArr[c];
					var line="<td value='0'>0</td>";
    				if(dataObj.recordCount>0) {
    					line="<td value='"+dataObj.recordCount+"'><a href='javascript:void(0)' tag='view' cardNo='"+dataObj.cardNo+"'>"+dataObj.recordCount+"</a></td>"
    				}
    				$tb_man.append("<tr><td>"+count+"</td>"+
    						"<td>"+filterNull(dataObj.litiName)+"</td>"+
    						"<td>"+filterNull(dataObj.cardNo)+"</td>"+
    						"<td>"+filterNull(dataObj.phone)+"</td>"+line+
							"<td style='display:none'>"+dataObj.cerType+"</td>"+
							"<td class='last-col'><a href='javascript:void(0)' tag='del' cardNo='"+dataObj.cardNo+"'>删除</a></td>"+
							"</tr>");
    				count++
				}
			}
    	}else if(tag=="view"){
    		var cardNo=$(this).attr("cardNo");
    		recordDialog(cardNo, "man");
    	}
    });
    
    //弹出惩戒记录框
    function recordDialog(key, type) {
    	layer.dialog({
    		title: '惩戒记录',
    		area: ['1000px', '600px'],
    		content: urlHead+'/noCreditPunish/info/recordlist?type='+type+'&key='+key,
    		callback: function(data) { }
    	})
    }
    
    //弹出选择框
    function selectEntDialog() {
    	layer.dialog({
    		title: '选择惩戒企业',
    		area: ['100%', '100%'],
    		content: urlHead+'/noCreditPunish/info/selectDig?type=ent',
    		callback: function(data) {
    			contentArr=createJsonStr(); 
    			//防止重复添加
    			if(data.entName!=undefined && contentjson[data.priPID]==undefined){ 
    				$tb_ent.html("");
    				$tb_ent.append("<tr><th>序号</th>"+
    						"<th>企业名称</th>"+
    						"<th>统一信用代码/注册号</th>"+
    						"<th>惩戒时的法定代表人(负责人)</th>"+
    						"<th>身份证号</th>"+
    						"<th>失信惩戒记录</th>"+
    						"<th>操作</th>"+
    						"</tr>");
    				
	    			contentjson[data.priPID]="1"; 
	    			data.type="ent";
	    			contentArr.push(data); 
	    			if(contentArr!=null&&contentArr.length>0){
	    				var count=1; 
	    				for(var a=0;a<contentArr.length;a++){
	    					var dataObj=contentArr[a];
	    					var line="<td value='0'>0</td>";
	        				if(dataObj.recordCount>0) {
	        					line="<td value='"+dataObj.recordCount+"'><a href='javascript:void(0);' tag='view' priPID='"+dataObj.priPID+"'>"+dataObj.recordCount+"</a></td>"
	        				}
	        				var ht="<tr><td>"+count+"</td>"+ 
	    					"<td>"+dataObj.entName+"</td>"+
	    					"<td style='display:none'>"+dataObj.priPID+"</td>"+
	    					"<td style='display:none'>"+dataObj.regNo+"</td>"+ 
	    					"<td>"+filterNull(dataObj.reguniCode)+"</td>"+
	    					"<td>"+filterNull(dataObj.leRep)+"</td>"+  
	    					"<td>"+filterNull(dataObj.cardNo)+"</td>"+line+
	    					"<td style='display:none'>"+dataObj.cerType+"</td>"+
	    					"<td style='display:none'>"+dataObj.uniCode+"</td>"+
	    					"<td class='last-col'><a href='javascript:void(0)' tag='del' priPID='"+dataObj.priPID+"'>删除</a></td>"+
	    					"</tr>";
	        				$tb_ent.append(ht);
	        				count++;
	    				}
	    			} 
    			}/*else{
    				layer.msg("该企业已经在惩戒列表中，无需重复添加", {time: 3000}, function() {});
    			}*/
    		}
		});
    }
    
    //弹出选择框
    function selectManDialog() {
    	layer.dialog({
    		title: '添加惩戒自然人',
    		area: ['100%', '100%'],
    		content: urlHead+'/noCreditPunish/info/selectDig?type=man',
    		callback: function(data) {
    			contentArr=createJsonStr(); 
    			//防止重复添加
    			if(data.cardNo!=undefined && contentjson[data.cardNo]==undefined){ 
    				$tb_man.html("");
        			$tb_man.append("<tr><th>序号</th>"+
    						"<th>当事人姓名</th>"+
    						"<th>身份证号</th>"+
    						"<th>联系电话</th>"+
    						"<th>失信惩戒记录</th>"+
    						"<th>操作</th>"+
    						"</tr>"); 
    				data.type="man";
	    			contentArr.push(data);
	    			contentjson[data.cardNo]="1";
	    			if(contentArr!=null&&contentArr.length>0){
	    				var count=1; 
	    				for(var c=0;c<contentArr.length;c++){
	    					var dataObj=contentArr[c];
	    					var line="<td value='0'>0</td>";
	        				if(dataObj.recordCount>0) {
	        					line="<td value='"+dataObj.recordCount+"'><a href='javascript:void(0)' tag='view' cardNo='"+dataObj.cardNo+"'>"+dataObj.recordCount+"</a></td>"
	        				}
	        				$tb_man.append("<tr><td>"+count+"</td>"+
	        						"<td>"+filterNull(dataObj.litiName)+"</td>"+
	        						"<td>"+filterNull(dataObj.cardNo)+"</td>"+
	        						"<td>"+filterNull(dataObj.phone)+"</td>"+line+
	    							"<td style='display:none'>"+dataObj.cerType+"</td>"+
	    							"<td class='last-col'><a href='javascript:void(0)' tag='del' cardNo='"+dataObj.cardNo+"'>删除</a></td>"+
	    							"</tr>");
	        				count++
	    				}
	    			}
    			}/*else{
    				layer.msg("该当事人已经在惩戒列表中，无需重复添加", {time: 3000}, function() {});
    			}*/
    		}
		});
    }
    
    function filterNull(str){
    	if(str==null||str=="null"){
    		return "";
    	} else
    		return str;
    }
    
    //遍历表格，生成json结构
    function createJsonStr(){
    	var tableJsonStr=[];
    	contentjson=[];
    	if(type=="ent"){
    		$("#tb_ent_bd tr:gt(0)").each(function(i){
    	    	var json={};
    	    	var jsonObj={};
    	    	$(this).children("td").each(function(i){ 
  	    	    	if(i==1){
  	    	    		json.entName=filterNull($(this).text());
  	    	    	} else if(i==2){
  	    	    		json.priPID=filterNull($(this).text());
  	    	    		contentjson[json.priPID]="1"; 
  	    	    	} else if(i==3){
  	    	    		json.regNo=filterNull($(this).text());
  	    	    	} else if(i==9){
  	    	    		json.uniCode=filterNull($(this).text());
  	    	    		json.reguniCode=json.uniCode;
  	    	    	} else if(i==5){
  	    	    		json.leRep=filterNull($(this).text());
  	    	    	} else if(i==8){
  	    	    		json.cerType=filterNull($(this).text());
  	    	    	} else if(i==6){
  	    	    		json.cardNo=filterNull($(this).text());
  	    	    	} else if(i==7){
  	    	    		json.recordCount=$(this).attr("value");
  	    	    	}
  	    	    });
    	    	if(filterNull(json.uniCode)==""){
    	    		json.reguniCode=json.regNo;
    	    	}
    	    	tableJsonStr.push(json);
    	    	contentArr.push(json);
	    	});
    	}else{
    		$("#tb_man_bd tr:gt(0)").each(function(i){
    	    	var json={};
    	    	var jsonObj={};
	    	    $(this).children("td").each(function(i){
	    	    	if(i==1){
	    	    		json.litiName= filterNull($(this).text());
	    	    	} else if(i==2){
	    	    		json.cardNo=filterNull($(this).text());
	    	    		contentjson[json.cardNo]="1";
	    	    	} else if(i==3){
	    	    		json.phone=filterNull($(this).text()); 
	    	    	} else if(i==4){
	    	    		json.recordCount=filterNull($(this).attr("value"));
	    	    	} else if(i==5){
	    	    		json.cerType=filterNull($(this).text());
	    	    	}
	    	    });
    	    	tableJsonStr.push(json);
    	    	contentArr.push(json);
	    	});
    	}
    	return tableJsonStr;
    }
    
    var isum=0;
    var i=0;
    //保存单据
    function save(){ 
    	var punField=$("#punField").val();
    	if(punField==null||punField==""){
    		layer.msg("请选择惩戒领域", {ltype: 0,time:3000}); 
        	return false;
    	}
    	var punCause=$("#punCause").val();
    	if(punCause==null||punCause==""){
    		layer.msg("请选择惩戒事由", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var punExeDept_s=$("#punExeDept").val();
    	var punExeDeptCode=$("#punExeDeptCode").val();
    	if(punExeDept_s==null||punExeDept_s==""||punExeDeptCode==""||punExeDeptCode==null){
    		layer.msg("请选择惩戒执行部门", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var exeBegin=$("#exeBegin").val();
    	var exeEnd=$("#exeEnd").val();
    	if(($(":checkbox[name=isLife]:checked").length==0)&&(filterNull(exeBegin)==""||filterNull(exeEnd)=="")){
    		layer.msg("请选择执行有效期", {ltype: 0,time:3000}); 
        	return false;
    	}  
    	if(($(":checkbox[name=isLife]:checked").length==0)){
    		 var d1 = new Date(exeBegin.replace(/\-/g, "\/"));  
    	   	 var d2 = new Date(exeEnd.replace(/\-/g, "\/")); 
    	   	 if(d1 >=d2)  
    	   	 {   
    	   	  layer.msg("开始日期不能大于结束日期", {ltype: 0,time:3000}); 
    	   	  return false;  
    	   	 }
    	}
    	
    	var legNo=$.trim($("#legNo").val());
    	if(legNo==null||legNo==""){
    		layer.msg("请填写法律文书编号", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var legDate=$.trim($("#legDate").val());
    	if(legDate==null||legDate==""){
    		layer.msg("请选择文书出具日期", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var illegalProperty=$.trim($("#illegalProperty").val());
    	if(illegalProperty==null||illegalProperty==""){
    		layer.msg("请填写违法性质", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var illegalFact=$.trim($("#illegalFact").val());
    	if(illegalFact==null||illegalFact==""){
    		layer.msg("请填写违法事实", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var punHandleRes=$.trim($("#punHandleRes").val());
    	if(punHandleRes==null||punHandleRes==""){
    		layer.msg("请填写处理结果", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var contact=$.trim($("#contact").val());
    	if(contact==null||contact==""){
    		layer.msg("请填写提请部门联系人", {ltype: 0,time:3000}); 
        	return false;
    	} 
    	
    	var phone=$.trim($("#phone").val());
    	if(phone==null||phone==""){
    		layer.msg("请填写联系电话", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	if(!isPhone(phone)){
    		layer.msg("联系电话格式错误", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var email=$.trim($("#email").val());
    	if(email!=null||email!=""){
    		if(!isEmail(email)){
        		layer.msg("电子邮箱格式错误", {ltype: 0,time:3000}); 
            	return false;
        	} 
    	}  
    	
    	var tabDataArr=createJsonStr();
    	if(tabDataArr==null||tabDataArr==""||tabDataArr.length==0){
    		if(type=="ent"){
    			layer.msg("请添加被惩戒企业", {ltype: 0,time:3000}); 
    		}else{
    			layer.msg("请添加被惩戒当事人", {ltype: 0,time:3000}); 
    		} 
        	return false;
    	}
    	var str= JSON.stringify(tabDataArr);
    	$("#detailJson").val(str);
    	if(isum==1){
    		layer.msg("您已经执行了提交操作无需重复提交", {ltype: 0,time:3000});
    		return false;
    	} 
    	$("#savebutton").attr("disabled",true);
    	load=layer.load();
    	$.ajax({
    		type : "POST",
			url : urlHead+'/noCreditPunish/info/update',
			data : $('#content_form').serialize(),
			datatype : 'JSON',
			async : true,
			success : function(json) {
				layer.close(load);
				if(json.status=="success"){
					isum=1;
					layer.msg(json.msg, {time: 1500}, function() {
						window.history.back(-1);
					});
				}else
					layer.msg(json.msg, {time: 4500}, function() {
						$("#savebutton").attr("disabled",false);
					});
			}
    	});
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
    var $files=$("#files"), filesArr=[], $upstate=$("#uploadState");
    if($files.val() !=""){
    	var val=$files.val().substring(0,$files.val().length-1);
        filesArr=val.split("|");
    }
    function upload(e){
    	
    	var batchNo=$("#batchNo").val(), file=$("#file").val();
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	if(contains_(filesArr, file)){
    		return false;
    	}
    	e.hide();$upstate.show();
    	$.ajaxFileUpload({
    		url: urlHead+'/noCreditPunish/info/uploadFile',
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
					$("#filelabel").append("<p> <span path='"+data+"' style='color:blue;cursor:pointer' title='点击下载' ><i class='xbt-icon file-icon'></i>"+text
							+"</span> &nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"'>删除</a></p>");
					//$("#filelabel").append("<p class='file-upload-out'><i class='xbt-icon file-icon'></i><label>"+text+"</label> &nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"'>删除</a></p>");
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
    $("#btnFile").delegate('input','change',function(){
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
    
    /*****ui******/
    $("#filelabel").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        window.open(urlHead+"/noCreditPunish/info/download?fileName=" + path);
    });
    var exeBegin = $("#exeBegin");
    var exeEnd = $("#exeEnd");
    var begin = exeBegin.val(), end = exeEnd.val();
    $("#isLife").click(function () {
        if ($(this).is(':checked')) {
            exeBegin.val("").attr("disabled", "disabled");
            exeEnd.val("").attr("disabled", "disabled");
        } else {
            exeBegin.val(begin).removeAttr("disabled");
            exeEnd.val(end).removeAttr("disabled");
        }
    })
    //打印
    $("#print").click(function () {
        window.open(urlHead+"/noCreditPunish/info/edit?deal=4&batchNo=${info.batchNo}");
    })
    
    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#selectPunReqDept',
            event: 'click',
            handler: function() {
            	doSelectReqDeptCode();
            }
        }, 
         {
            el: '#btnFile',
            event: 'change',
            handler: function() {
            	var text=$(this).val();
        		var index = text.lastIndexOf("\\");
        		text = text.substring(index + 1, text.length);
        		$("#file").val(text);
            	upload($(this));
            }
        }, {
            el: '#selectPunExeDept',
            event: 'click',
            handler: function() {
            	doSelectExeDeptCode();
            }
        }, {
            el: '#update',
            event: 'click',
            handler: function() {
            	$("#update").attr("disabled",true);
            	load=layer.load();
            	save();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	window.history.back(-1);
            }
        }, {
            el: '#savebutton',
            event: 'click',
            handler: function() { 
            	save();
            }
        }, {
            el: '#punField',
            event: 'change',
            handler: function() {
            	ruleCauseLoad();
            }
        }, {
            el: '#punCause',
            event: 'change',
            handler: function() {
            	ruleInfoLoad();
            }
        }, {
            el: '#adddetail',
            event: 'click',
            handler: function() {
            	if(type=="ent"){
                	selectEntDialog();
            	}else
            		selectManDialog();
            }
        }])
    }

});