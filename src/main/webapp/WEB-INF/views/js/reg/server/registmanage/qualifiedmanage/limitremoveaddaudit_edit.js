require(['component/iframeLayer', 'common/util',
    'common/http', 'jquery', 'select2', 'jquery.serialize', 'laydate', 'common/validateRules',
    'jquery.validate'], function (layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	//设置为年报状态为已审核时
    	if(window._CONFIG._auditState !='0'){
    		$(":radio").attr("disabled","disabled");
    		$(":checkbox").attr("disabled","disabled");
            $("input,textarea").attr("disabled","disabled");
            $("#cancel").removeAttr("disabled");
    		$(".add-icon").hide();
    	}
        bind();
        formValid();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#infoForm').validate({
            onkeyup: false,
           onfocusout: function (el) {
            },
            rules: {
            	removeReasonCheck:{//选择解除原因
            		required: true,
                    },
                removeOtherReason:{//解除其他原因
                	required:function(){
                        //其他被选中
                        if($("#removeReasonCheck7").prop("checked")){
                        	return true;
                        }else{
                        	return false;
                        }
                    },
                	maxlength: 200
                },
                removeDeptName:{//解除机关名称
                	required: true,
                	maxlength: 100
                },
                auditState:{//审核结果
                	required: true
                },
                removeAuditOpin:{//审核意见
                	required: true
                }
            },
            messages: {
            	removeReasonCheck: {
                    required: "请选择解除原因"
                },
                removeOtherReason: {
                	required: "请填写其他原因的具体内容"
                },
                removeDeptName: {
                    required: "请选择解除机关"
                },
                auditState: {
                	required: "请选择审核结果"
                },
                removeAuditOpin: {
                	required: "请填写审核意见"
                }   
            },
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#infoForm input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });

                    layer.tips(errorMap[i], $('#infoForm textarea[name=' + i + ']'), {  // textarea
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });
                }
            },
            submitHandler: function () {
            	//设置解除限制原因
            	var icArray = [];
            	 $("input:checkbox[name=removeReasonCheck]:checked").each(function(){
            		 icArray.push($(this).val());
                 });
                 $("#removeReason").val(icArray.toString());
                var formParam = $('#infoForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/registmanage/limitRemoveAuditCommit',
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                   	 if(data.status == 'success'){
                		 layer.msg(data.msg, {time: 1000}, function () {
								layer.close({reload: true});
                		 }); 
                	 }else{
                		 layer.msg(data.msg, {ltype: 0,time:2000});
                	 }
                    }
                })
            }
        })
    };
    function bind() {
        util.bindEvents([
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    layer.close({type: 'cancel'});
                }
            },{
                el: '#chooseActiveDep',
                event: 'click',
                handler: function () {
                	layer.dialog({
                        title: '选择解除机关',
                        area: ['328px', '600px'],
                        content: '/common/system/dept/tree/selectAll?treeType=radio',
                        callback: function (data) {
                        	if (data) { 
//                               	$("#activeDep").val(data.orgCodesExcParent);alldeptcheckboxtreeselect
                               	$("#removeDept").val(data.orgCodesExcParent);
                               	$("#removeDeptName").val(data.orgNamesExcParent);
                        	}
                        }
                	});
                }
            },{ el: '#removeReasonCheck7', //其他工商服务选中情况
                event: 'click',
                handler: function () {
             	   if($(this).prop("checked")){
             			$("#removeOtherReason").show();
             		}else{
             			$("#removeOtherReason").hide();
             			$("#removeOtherReason").val("");
             		}
                }	   
            }
        ])
    }

})
