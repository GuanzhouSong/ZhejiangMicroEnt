require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination','common/validateRules'],
		function (layer, dataTable, util, http, handlebars) {
	 init();
    /**
     * 初始化函数集合
     */
    function init() {
    	//初始化展示
    	initShow();
    	//食品生产许可证列表
    	init_pro_license();
		//食品生产许可证信息保存    	
    	pro_license_formValid();
    	//食品流通许可证列表
    	init_cir_license();
		//食品流通许可证信息保存
    	cir_license_formValid();
    	//仓储信息列表
    	init_storage_Info();
    	//仓储信息保存
    	storageInfo_formValid();
    	//提交
    	baseInfo_formValid();
    	
        bind();
    }
        //时间控件初始化
        laydate.skin('molv');
        var start = {
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-12-31',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            end.min = datas;
            end.start = datas;
            }
        };
        var end = {
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-12-31',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            start.max = datas;
            }
        };

        $("#licValFrom").click(function(){laydate(start);});
        $("#licValTo").click(function(){laydate(end);});
        $("#cir_licValFrom").click(function(){laydate(start);});
        $("#cir_licValTo").click(function(){laydate(end);});
        
        function initShow(){
        //初始化显示对应填报表单
        $(".fsScope").each(function(){
        	var tagetId = $(this).attr("id");
        	if($(this).prop("checked")){
        		$('.'+tagetId+'View').show();
        	}else{
        		$('.'+tagetId+'View').hide();
        	}
        })
        //判断不同状态下表单是只读
    	var submitState = $("#submitState").val();
    	if(submitState == '2'){
    		$(".textarea").attr("readonly","readonly");
    		$(".mod input[type ='text']").each(function(){
    			$(this).attr("disabled","disabled");
    		})
    		$(".mod input[type ='checkbox']").each(function(){
    			$(this).attr("disabled","disabled");
    		})
    	}
    }
    
    function init_pro_license(){
        loadProData(0,10);
    };
    function loadProData(page, length, callback) {
    	var params = {licType:'1'};
        http.httpRequest({
            url: '/reg/client/yr/ent/foodstoragelicense/list.json',
            data: {start: page*length,length: length,params:params},
            success: function (data) {
                var itemCount = data.recordsTotal;
                //生产许可证个数
                $("#proCount").text(itemCount);
                $("#proAmount").val(itemCount);
                $('.pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadProData(page,10);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
                var myTemplate = handlebars.compile($("#pro_license_table").html());
                $('#pro_page').html(myTemplate(data));
                $("#pro_total").text(itemCount);
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#pro_pageNum").text(pageNum);
            }
        });
    };
    
    function init_cir_license(){
        loadCirData(0,10);
    };
    function loadCirData(page, length, callback) {
    	var params = {licType:'2'};
        http.httpRequest({
            url: '/reg/client/yr/ent/foodstoragelicense/list.json',
            data: {start: page*length,length: length,params:params},
            success: function (data) {
                var itemCount = data.recordsTotal;
                //流通许可证个数
                $("#cirCount").text(itemCount);
                $("#disAmount").val(itemCount);
                $('.pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadCirData(page,10);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
                var myTemplate = handlebars.compile($("#cir_license_table").html());
                $('#cir_page').html(myTemplate(data));
                $("#cir_total").text(itemCount);
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#cir_pageNum").text(pageNum);
            }
        });
    };
    
    function init_storage_Info(){
        loadStorageData(0,10);
    };
    function loadStorageData(page, length, callback) {
    	var params = {};
        http.httpRequest({
            url: '/reg/client/yr/ent/foodstorageinfo/list.json',
            data: {start: page*length,length: length,params:params},
            success: function (data) {
                var itemCount = data.recordsTotal;
                //生产许可证个数
                $("#storageCount").text(itemCount);
                $("#wareAmount").val(itemCount);
                $('.pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,
                    num_edge_entries: 2,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                    	loadStorageData(page,10);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
                var myTemplate = handlebars.compile($("#storage_table").html());
                var listArry = data.data;
                for(var i=0;i<listArry.length;i++){
                	var foodstorageAuxList = listArry[i].foodstorageAuxList;
                	for(var j=0;j<foodstorageAuxList.length;j++){
                		//设置建筑类型
                		if(foodstorageAuxList[j].supCode =='1'){
                			if(listArry[i].buildType == 'undefined' || listArry[i].buildType == null){
                				listArry[i].buildType = '';
                			}
                    		listArry[i].buildType =(listArry[i].buildType==''?'':(listArry[i].buildType+'，'))+foodstorageAuxList[j].content;
                    	}
                		//设置仓库类型
                    	if(foodstorageAuxList[j].supCode =='2'){
                    		if(listArry[i].storageType == 'undefined' || listArry[i].storageType == null){
                				listArry[i].storageType = '';
                			}
                    		listArry[i].storageType =(listArry[i].storageType==''?'':(listArry[i].storageType+'，'))+foodstorageAuxList[j].content;
                    	}
                	}
                }
                $('#storage_page').html(myTemplate(data));
                $("#info_total").text(itemCount);
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#info_pageNum").text(pageNum);
            }
        });
    };
    
    /*食品生产许可证信息保存*/
    function pro_license_formValid() {
        $('#pro_licenseForm').validate({
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#pro_licenseForm input[name='+i+'],#pro_licenseForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#pro_licenseForm').serializeObject();
                http.httpRequest({
                    url: '/reg/client/yr/ent/foodstoragelicense/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	$("#pro_license").hide("normal");
                        	clearProFormInfo();
                        	loadProData(0,10);
                        });
                    }
                });
            }
        })
    };
    
    /*食品流通许可证信息保存*/
    function cir_license_formValid() {
        $('#cir_licenseForm').validate({
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#cir_licenseForm input[name='+i+'],#cir_licenseForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#cir_licenseForm').serializeObject();
                http.httpRequest({
                    url: '/reg/client/yr/ent/foodstoragelicense/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	$("#cir_license").hide("normal");
                        	clearCirFormInfo();
                        	loadCirData(0,10);
                        });
                    }
                });
            }
        })
    };
    
    /*仓储信息保存*/
    function storageInfo_formValid() {
        $('#storageForm').validate({
            rules: {
            	tel: {
                    checkMobile:true
                },
                linktel: {
                    checkMobile:true
                },
                mobTel: {
                    checkMobile:true
                }
            },
            messages:{
            	tel:{
            	   checkMobile:"请输入正确格式的手机号码"
            	},
            	linktel:{
             	   checkMobile:"请输入正确格式的手机号码"
             	},
             	mobTel:{
             	   checkMobile:"请输入正确格式的手机号码"
             	}
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#storageForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
            	if($(".radio-box input[supCode='1']:checked").length == 0){
            		layer.tips("请选择建筑类型",$('#building'),{tips:3,tipsMore:true,ltype:0});
            		return false;
            	}
            	if($(".radio-box input[supCode='2']:checked").length == 0){
            		layer.tips("请选择仓库类型",$('#storage'),{tips:3,tipsMore:true,ltype:0});
            		return false;
            	}
            	if($(".radio-box input[supCode='3']:checked").length == 0){
            		layer.tips("请选择库存食品主要种类",$('#foodtype'),{tips:3,tipsMore:true,ltype:0});
            		return false;
            	}
            	if($(".radio-box input[supCode='4']:checked").length == 0){
            		layer.tips("请选择运输车辆",$('#cartype'),{tips:3,tipsMore:true,ltype:0});
            		return false;
            	}
            	
                var formParam = $('#storageForm').serializeObject();
                var checkArry = new Array();
                $("#storageForm input[supCode]:checked").each(function(){
                	var code = $(this).val();
                	var typeCode = $(this).attr("supCode");
                	var content = ($(this).parent().text()).replace("()","").replace("(","").replace(/\s+/g,"");
                	if(typeCode == '4'){
                		var ownType = ($(this).parent().next().children().prop("checked"))==true?'1':'';
                		var hireType = ($(this).parent().next().next().children().prop("checked"))==true?'1':'';
                		var otherType = ($(this).parent().next().next().next().children().prop("checked"))==true?'1':'';
                		var remark = "";
                		if(code == '53'){
                			remark = $("#remark").val();
                		}
                		checkArry.push({code:code,supCode:typeCode,content:content,ownType:ownType,hireType:hireType,otherType:otherType,remark:remark});
                	}else{
                		checkArry.push({code:code,supCode:typeCode,content:content});
                	}
                })
                formParam.foodstorageAuxList = checkArry;
                http.httpRequest({
                    url: '/reg/client/yr/ent/foodstorageinfo/save',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	$("#fsstorage").hide("normal");
                        	clearStoFormInfo();
                        	loadStorageData(0,10);
                        });
                    }
                });
            }
        })
    };
    //提交
    function baseInfo_formValid(){
        $('#baseForm').validate({
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#baseForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
	       		if($(".business-scope input[type='checkbox']:checked").length == 0){
	       		    layer.msg("请先选中“企业涉及”选项!", {icon: 7,time: 2000});
	 		    	return false;
		 	    }
            	if($("#typeOne").prop("checked") && $("#typeThree").prop("checked") && $("#wareAmount").val() == '0'){
	    			layer.msg("“企业涉及”选项为【食品生产】和【食品仓储服务】时，仓库数量不能为0!", {icon: 7,time: 3000});
	          		return false;		
            	}
            	var checkedArry = new Array();
            	$(".business-scope input[type='checkbox']:checked").each(function(){
            		checkedArry.push($(this).val());
            	})
            	//涉及类型
            	$("#fsScope").val(checkedArry.toString());
            	if(saveFlag){
            		$("#submitState").val("1");//暂存状态
            	}
            	if(commitFlag){
            		$("#submitState").val("2");//提交状态
            	}
                var formParam = $('#baseForm').serializeObject();
                http.httpRequest({
                    url: '/reg/client/yr/ent/foodstoragebase/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	window.location.reload();
                        });
                    }
                });
            }
        })
    }
    
    //清空dom信息
    function clearProFormInfo(){
    	laydateReset();
    	$(".textarea").val("");
    	$("#pro_licenseForm input[type='text']").each(function(){
    		$(this).val("");
    	})
    }
    function clearCirFormInfo(){
    	laydateReset();
    	$(".textarea").val("");
    	$("#cir_licenseForm input[type='text']").each(function(){
    		$(this).val("");
    	})
    }
    function clearStoFormInfo(){
    	$("#storageForm input[type='text']").each(function(){
    		$(this).val("");
    	})
    	$("#storageForm input[type='checkbox']").each(function(){
    		$(this).prop("checked",false);
    	})
    }
    //时间范围初始化
    function laydateReset(){
    	start.min= '1970-01-01';
        start.max='2099-12-31';
        end.min= '1970-01-01';
        end.max= '2099-12-31';
        end.start= laydate.now(0,"YYYY-MM-DD");
    }
    
    //设置暂存，提交标识
    var saveFlag = false;
    var commitFlag = false;
    $("#saveall").click(function(){saveFlag = true;commitFlag = false;})
    $("#commitall").click(function(){commitFlag = true;saveFlag = false;})
    
    function bind() {
        util.bindEvents([{
            el: '.show-tips',
            event: 'click',
            handler: function () {
            	var $span = $(this).find("span");
                var id = $(this).attr("id");
                $span.text($span.text() == '收起' ? '展开' : '收起');
                $(this).toggleClass('drop-on');
                $("#"+id+"Content").toggle("normal");
            }
        },{//食品生产许可证修改
            el: '#proEdit',
            event: 'click',
            handler: function () {
            	 var length = $("input[name='checkbox1']:checked").length;
            	 if(length == 1){
            		 var checkedId = $("input[name='checkbox1']:checked").val();
                	 http.httpRequest({
                         url: '/reg/client/yr/ent/foodstoragelicense/search',
                         data:{id:checkedId},
                         serializable: false,
                         success: function (data) {
                        	 if(data.status == 'success'){
                        		 $("#pro_license").show("normal");
                        		 $("#licNO").val(data.data.licNO);
                        		 $("#licAnth").val(data.data.licAnth);
                        		 $("#licValFrom").val(data.data.licValFrom);
                        		 $("#licValTo").val(data.data.licValTo);
                        		 $("#licScope").val(data.data.licScope);
                        		 $("#id").val(data.data.id);
                        	 }
                         }
                     });
            	 }else if(length == 0){
            		 layer.msg("请先<em style='color: red;'>【选中一项】</em>进行修改操作!", {icon: 7,time: 1500});
            		 return false;
            	 }else if(length > 1){
            		 layer.msg("修改<em style='color: red;'>【只能选择一条】</em>进行操作!", {icon: 7,time: 1500});
            		 return false;
            	 }
             }
        },{//食品生产许可证删除
        	el: '#proDel',
            event: 'click',
            handler: function () {
                var del_arr = [];
                $("input:checkbox[name='checkbox1']:checked").each(function () {
                	del_arr.push($(this).val());
                });
                if (del_arr.length > 0) {
                    layer.confirm('您确定要删除选中的<em style="color: red;">'+del_arr.length+'</em>条数据吗？', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/reg/client/yr/ent/foodstoragelicense/deleteBatch',
                            serializable: true,
                            data:del_arr,
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                	loadProData(0,10);
                                }
                            }
                        });
                        layer.close(index);
                    });
                }else {
                    layer.msg("请您<em style='color: red;'>【选中一项】</em>进行删除操作!", {icon: 7,time: 1000});
                }
            }
        },{//食品流通许可证修改
            el: '#cirEdit',
            event: 'click',
            handler: function () {
            	 var length = $("input[name='checkbox2']:checked").length;
            	 if(length == 1){
            		 var checkedId = $("input[name='checkbox2']:checked").val();
                	 http.httpRequest({
                         url: '/reg/client/yr/ent/foodstoragelicense/search',
                         data:{id:checkedId},
                         serializable: false,
                         success: function (data) {
                        	 if(data.status == 'success'){
                        		 $("#cir_license").show("normal");
                        		 $("#cir_licNO").val(data.data.licNO);
                        		 $("#cir_licAnth").val(data.data.licAnth);
                        		 $("#cir_licValFrom").val(data.data.licValFrom);
                        		 $("#cir_licValTo").val(data.data.licValTo);
                        		 $("#cir_licScope").val(data.data.licScope);
                        		 $("#cir_id").val(data.data.id);
                        	 }
                         }
                     });
            	 }else if(length == 0){
            		 layer.msg("请先<em style='color: red;'>【选中一项】</em>进行修改操作!", {icon: 7,time: 1500});
            		 return false;
            	 }else if(length > 1){
            		 layer.msg("修改<em style='color: red;'>【只能选择一条】</em>进行操作!", {icon: 7,time: 1500});
            		 return false;
            	 }
             }
        },{//食品流通许可证删除
        	el: '#cirDel', 
            event: 'click',
            handler: function () {
                var del_arr = [];
                $("input:checkbox[name='checkbox2']:checked").each(function () {
                	del_arr.push($(this).val());
                });
                if (del_arr.length > 0) {
                    layer.confirm('您确定要删除选中的<em style="color: red;">'+del_arr.length+'</em>条数据吗？', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/reg/client/yr/ent/foodstoragelicense/deleteBatch',
                            serializable: true,
                            data:del_arr,
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                	loadCirData(0,10);
                                }
                            }
                        });
                        layer.close(index);
                    });
                }else {
                    layer.msg("请您<em style='color: red;'>【选中一项】</em>进行删除操作!", {icon: 7,time: 1000});
                }
            }
        },{//仓库信息修改
            el: '#infoEdit',
            event: 'click',
            handler: function () {
            	 var length = $("input[name='checkbox3']:checked").length;
            	 if(length == 1){
            		 var checkedId = $("input[name='checkbox3']:checked").val();
                	 http.httpRequest({
                         url: '/reg/client/yr/ent/foodstorageinfo/search',
                         data:{fsInfoId:checkedId},
                         serializable: false,
                         success: function (data) {
                        	 if(data.status == 'success'){
                        		 $("#fsstorage").show("normal");
                        		 $("#info_entName").val(data.data.entName);
                        		 $("#info_regNO").val(data.data.regNO);
                        		 $("#info_leRep").val(data.data.leRep);
                        		 $("#info_tel").val(data.data.tel);
                        		 $("#info_addr").val(data.data.addr);
                        		 $("#info_wareAddr").val(data.data.wareAddr);
                        		 $("#info_linkman").val(data.data.linkman);
                        		 $("#info_linktel").val(data.data.linktel);
                        		 $("#info_empNum").val(data.data.empNum);
                        		 $("#info_opSpace").val(data.data.opSpace);
                        		 $("#fsinfoID").val(data.data.fsinfoID);
                        		 $("#info_id").val(data.data.id);
                        		 var foodstorageAuxList = data.data.foodstorageAuxList;
                        		 for(var key in foodstorageAuxList){
                        			 var checkCode = foodstorageAuxList[key].code;
                        			 var checkSupCode = foodstorageAuxList[key].supCode;
                        			 $("#storageForm input[type='checkbox']").each(function(){
                        				 if($(this).val() == checkCode){
                        					 $(this).prop("checked",true);
                        				 }
                        			 })
                    				 if(checkSupCode == '4'){
                    					 if($("#submitState").val() !='2'){
                    						 $(".traffic"+checkCode).each(function(){$(this).removeAttr("disabled")});
                    					 }
                    					 if(checkCode == '53'){
                							 $("#remark").val(foodstorageAuxList[key].remark);
                						 }
                    					 if(foodstorageAuxList[key].ownType =='1')$("#traffic"+checkCode).parent().next().children().prop("checked",true);
                    					 if(foodstorageAuxList[key].hireType =='1')$("#traffic"+checkCode).parent().next().next().children().prop("checked",true);
                    					 if(foodstorageAuxList[key].otherType =='1')$("#traffic"+checkCode).parent().next().next().next().children().prop("checked",true);
                    				 }
                        		 }
                        	 }
                         }
                     });
            	 }else if(length == 0){
            		 layer.msg("请先<em style='color: red;'>【选中一项】</em>进行修改操作!", {icon: 7,time: 1500});
            		 return false;
            	 }else if(length > 1){
            		 layer.msg("修改<em style='color: red;'>【只能选择一条】</em>进行操作!", {icon: 7,time: 1500});
            		 return false;
            	 }
             }
        },{//仓库信息删除
        	el: '#infoDel', 
            event: 'click',
            handler: function () {
                var del_arr = [];
                $("input:checkbox[name='checkbox3']:checked").each(function () {
                	del_arr.push($(this).val());
                });
                if (del_arr.length > 0) {
                    layer.confirm('您确定要删除选中的<em style="color: red;">'+del_arr.length+'</em>条数据吗？', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/reg/client/yr/ent/foodstorageinfo/delete',
                            serializable: true,
                            data:del_arr,
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success'){
                                	loadStorageData(0,10);
                                }
                            }
                        });
                        layer.close(index);//关闭窗口
                    });
                }else {
                    layer.msg("请您<em style='color: red;'>【选中一项】</em>进行删除操作!", {icon: 7,time: 1000});
                }
            }
        },{//食品生产许可证详情
            el: '.pro_details',
            event: 'click',
            handler: function () {
            	 var detailsID = $(this).parent().prevAll().last().children().val();
            	 http.httpRequest({
                     url: '/reg/client/yr/ent/foodstoragelicense/search',
                     data:{id:detailsID},
                     serializable: false,
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 $("#pro_license").show("normal");
                    		 $("#licNO").val(data.data.licNO);
                    		 $("#licAnth").val(data.data.licAnth);
                    		 $("#licValFrom").val(data.data.licValFrom);
                    		 $("#licValTo").val(data.data.licValTo);
                    		 $("#licScope").val(data.data.licScope);
                    		 $("#procommit").hide();
                    	 }
                     }
                 });
             }
        },{//食品流通许可证详情
            el: '.cir_details',
            event: 'click',
            handler: function () {
            	 var detailsID = $(this).parent().prevAll().last().children().val();
            	 http.httpRequest({
                     url: '/reg/client/yr/ent/foodstoragelicense/search',
                     data:{id:detailsID},
                     serializable: false,
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 $("#cir_license").show("normal");
                    		 $("#cir_licNO").val(data.data.licNO);
                    		 $("#cir_licAnth").val(data.data.licAnth);
                    		 $("#cir_licValFrom").val(data.data.licValFrom);
                    		 $("#cir_licValTo").val(data.data.licValTo);
                    		 $("#cir_licScope").val(data.data.licScope);
                    		 $("#circommit").hide();
                    	 }
                     }
                 });
             }
        },{//仓库信息详情
            el: '.sto_details',
            event: 'click',
            handler: function () {
            	 var detailsID = $(this).parent().prevAll().last().children().val();
            	 http.httpRequest({
                     url: '/reg/client/yr/ent/foodstorageinfo/search',
                     data:{fsInfoId:detailsID},
                     serializable: false,
                     success: function (data) {
                    	 if(data.status == 'success'){
                    		 $("#fsstorage").show("normal");
                    		 $("#info_entName").val(data.data.entName);
                    		 $("#info_regNO").val(data.data.regNO);
                    		 $("#info_leRep").val(data.data.leRep);
                    		 $("#info_tel").val(data.data.tel);
                    		 $("#info_addr").val(data.data.addr);
                    		 $("#info_wareAddr").val(data.data.wareAddr);
                    		 $("#info_linkman").val(data.data.linkman);
                    		 $("#info_linktel").val(data.data.linktel);
                    		 $("#info_empNum").val(data.data.empNum);
                    		 $("#info_opSpace").val(data.data.opSpace);
                    		 $("#stocommit").hide();
                    		 var foodstorageAuxList = data.data.foodstorageAuxList;
                    		 for(var key in foodstorageAuxList){
                    			 var checkCode = foodstorageAuxList[key].code;
                    			 var checkSupCode = foodstorageAuxList[key].supCode;
                    			 $("#storageForm input[type='checkbox']").each(function(){
                    				 if($(this).val() == checkCode){
                    					 $(this).prop("checked",true);
                    				 }
                    			 })
                				 if(checkSupCode == '4'){
                					 if($("#submitState").val() !='2'){
                						 $(".traffic"+checkCode).each(function(){$(this).removeAttr("disabled")});
                					 }
                					 if(checkCode == '53'){
            							 $("#remark").val(foodstorageAuxList[key].remark);
            						 }
                					 if(foodstorageAuxList[key].ownType =='1')$("#traffic"+checkCode).parent().next().children().prop("checked",true);
                					 if(foodstorageAuxList[key].hireType =='1')$("#traffic"+checkCode).parent().next().next().children().prop("checked",true);
                					 if(foodstorageAuxList[key].otherType =='1')$("#traffic"+checkCode).parent().next().next().next().children().prop("checked",true);
                				 }
                    		 }
                    	 }
                     }
                 });
             }
        },{//全选
            el: '.checkAll',
            event: 'click',
            handler: function () {
            	var checkType = "checkbox"+$(this).attr('id');
            	if($(this).prop("checked")){
                	$("input[name="+"'"+checkType+"'"+"]").prop("checked",true);
            	}else{
            		$("input[name="+"'"+checkType+"'"+"]").prop("checked",false);
            	}
            }
        },{//选择“都不涉及”
            el: '#typeFour',
            event: 'click',
            handler: function () {
            	if($("#typeFour").prop("checked")){
            		layer.confirm('选择【都不涉及】所填报的数据会丢失，确认继续？', {icon: 2, title: '提示'}, function (index) {
            			http.httpRequest({
                            url: '/reg/client/yr/ent/foodstoragebase/deleteAll',
                            serializable: false,
                            type: 'get',
                            success: function (data) {
                                if(data.status=='success'){
                                	$(".typeOneView,.typeTwoView,.typeThreeView").hide();//隐藏所有填报表单
                            		$(".fsScope").prop("checked",false).attr("disabled",true);
                                }
                            }
                        });
                 	    layer.close(index);
             	    },function(){
                       $("#typeFour").prop("checked",false);
                    });
            	}else{
            	 	$(".fsScope").prop("checked",false).attr("disabled",false);
            	}
            }
        },{//选择“企业涉及选项”显示与隐藏对应表单
            el: '.fsScope',
            event: 'click',
            handler: function () {
            	var attrId = $(this).attr("id");
            	var attrVal = $(this).val();
            	var $this = $(this);
            	if($(this).prop("checked")){
            		$('.'+attrId+'View').show();
            		if(attrVal =='1'){loadProData(0,10);}
            		if(attrVal =='2'){loadCirData(0,10);}
            		if(attrVal =='3'){loadStorageData(0,10);}
            	}else{
            		if(attrVal =='5'){
            			return;
            		}
        			layer.confirm('取消选择所填报的该表单数据会丢失，确认继续？', {icon: 2, title: '提示'}, function (index) {
            			http.httpRequest({
                            url: '/reg/client/yr/ent/foodstoragebase/delete',
                            serializable: false,
                            data:{deleteType : attrVal},
                            type: 'get',
                            success: function (data) {
                                if(data.status=='success'){
                                	$('.'+attrId+'View').hide();
                                }
                            }
                        });
                 	    layer.close(index);
             	    },function(){
             	    	$this.prop("checked",true);
                    });
            	}
            }
        },{//车辆类型
            el: ".radio-box input[supCode='4']",
            event: 'click',
            handler: function () {
            	var $id = $(this).attr("id");
            	if($(this).prop("checked")){
            		$("."+$id).removeAttr("disabled");
            	}else{
            		$("."+$id).attr("disabled","disabled").prop("checked",false);
            		if($id =='traffic53'){
            			$("#remark").val("");
            		}
            	}
            }
        },{//长时间有效
            el: '.isLongterm',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$(this).prev().val("2099-12-31");
            	}else{
            		$(this).prev().val("");
            	}
            }
        },{
            el: '.pro-btn-add',
            event: 'click',
            handler: function () {
            	if(!$("#typeFour").prop("checked")){
            		$("#pro_license").show("normal");
                	$("#id").val("");
            	}else{
            		 layer.msg("“企业涉及”选项选择为【都不涉及】的企业不能填写许可证和仓库信息!", {icon: 7,time: 3000});
            		 return false;
            	}
            }
        },{
            el: '#proCancel',
            event: 'click',
            handler: function () {
            	$("#pro_license").hide("normal");
            	clearProFormInfo();
            	setTimeout(function (){ 
                	$("#procommit").show();
                }, 300);
            	
            }
        },{
            el: '.cir-btn-add',
            event: 'click',
            handler: function () {
              if(!$("#typeFour").prop("checked")){
            	$("#cir_license").show("normal");
            	$("#cir_id").val("");
              }else{
            	 layer.msg("“企业涉及”选项选择为【都不涉及】的企业不能填写许可证和仓库信息!", {icon: 7,time: 3000});
         		 return false;	
              }
            }
        },{
            el: '#cirCancel',
            event: 'click',
            handler: function () {
            	$("#cir_license").hide("normal");
            	clearCirFormInfo();
            	setTimeout(function (){ 
                	$("#circommit").show();
                }, 300);
            }
        },{
            el: '.storage-btn-add',
            event: 'click',
            handler: function () {
              if(!$("#typeFour").prop("checked")){
            	$("#fsstorage").show("normal");
            	$("#info_id").val("");
            	$("#fsinfoID").val("");
            	$(".traffic51,.traffic52,.traffic53").each(function(){
            		$(this).attr("disabled","disabled");
            	})
              }else{
            	layer.msg("“企业涉及”选项选择为【都不涉及】的企业不能填写许可证和仓库信息!", {icon: 7,time: 3000});
          		return false;	 
              }
            }
        },{
            el: '#storageCancel',
            event: 'click',
            handler: function () {
            	$("#fsstorage").hide("normal");
            	clearStoFormInfo();
            	setTimeout(function (){ 
                	$("#stocommit").show();
                }, 300);
            }
        },{
            el: '#closeWindow',
            event: 'click',
            handler: function () {
            	window.close();
            }
        }]);
    }
});
