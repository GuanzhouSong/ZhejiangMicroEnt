require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'ztree', 
    'ztreeCheck'
], function (layer, util, http,handlebars) {
    init();

    /**
     * 初始化函数集合
     */

    function init() {
        initRoles();
        formValid();
        bind();
        intUserInfo();
    }
    
    var treeObj = null;
    var treeSetting = {
        check: {
            enable: true,
            chkboxType:{ "Y" : "s", "N" : "ps" }    //被勾选时：不关联父
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            //beforeClick: beforeClick,
        }
    };
    
    
    //初始化用户信息 避免谷歌浏览器自动填充密码导致回显不正确
    function intUserInfo(){ 
    	var  userId=$("#userId").val();
        if(userId==null||userId==""){ 
       	$("#password").val(null);
        $("#username").val(null);
        //新增时默认本部门
        var adminGuideDocTypeTemArr=$('input[name="searchRangeLevel"]'); 
		$.each(adminGuideDocTypeTemArr, function(c,d) { 
			if(d.value=="2"){
				$(this).attr("checked",'true');
			}
	    }); 
       }else{
    	   var  username=$.trim($("#username").val());
           var  _username=window._CONFIG._username;
           if(_username!=username){
           	$("#username").val(_username);
           }
           $("#password").val(null);
       }
    }

    function initRoles(){
        $(document).on('click','#js-item-add',function () {
            $('#js-select-add').append($('#js-select-del option:selected'));
        })
        $(document).on('click','#js-item-del',function () {
            $('#js-select-del').append($('#js-select-add option:selected'));
        })
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#sysUserForm').validate({
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            rules: {
                realName: {     //姓名
                    required:true
                },
                orgName: {     //所属部门
                    required:true
                },
                telPhone: {     // 手机
                    required:false,
                    checkMobile:true
                },
                deptName: {     //科室
                    required:false
                },
                phone: {     //座机
                    required:false,
                    isTel:true
                },
                post: {     //职务
                    required:false
                },
               phoneExt: {     //工作电话
                    required:false,
                    isTel:true
                },
                jurUnit: {     //单位
                    required:false
                },
                email: {     //电子邮箱
                    required:false,
                    email:true
                },
                desc: {     //办公地址
                    required:false
                },
                username: {     //用户名
                    checkMobile: $("#userId").val()=="",
                    required:true
                },
                password:{
                    required:$("#userId").val()==""
                },
                status: {     //账户状态
                    required:true
                },
                password: {     //密码
                    required:false
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#sysUserForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            messages: {
                status:"请选择一项"
            },
            submitHandler: function () {

            }
        })
    }

    // 部门单选
    function doSelectSynDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择部门',
            area: ['35%', '90%'],
            content: select_dept_url,
            callback: function (data) {
                if(data.orgCode!=null&&data.orgName!=null){
                    $("#s_deptName").val(data.orgName);
                    $("#deptCode").val(data.orgCode);
                    // switchSearchLevel(data.adCode);
                }else  if(data.orgNamesExcParent!=null&&data.orgCodesExcParent!=null){
                    $("#s_deptName").val(data.orgNamesExcParent);
                    $("#deptCode").val(data.orgCodesExcParent);
                    // switchSearchLevel(data.adCode);
                }
            }
        })
    }
    
    
    /**
     * 根据角色ID获取角色
     */
    function getRoleByRoleId(roleId){
    	 http.httpRequest({
    	        type: 'get',
    	        url: '/reg/server/sysrole/getRoleByRoleId',
    	        data: {roleId: roleId},
    	        success: function (data) {
    	        	 
    	             if(data.status=="success"){
    	            	 $("#roleRemark").text(data.data.desc==null?"":data.data.desc);
    	             }
    	        }
    	    })
    }
    
    /**
     * 根据角色ID加载权限资源菜单
     */
    function ztreeInitRoleId(roleId) { 
	        //获取角色权限
	        http.httpRequest({
	            type: 'post',
	            url:  '/syn/server/syspermision/list4roleIds.json',
	            data: {roleIds: roleId},
	            success: function (data) { 
	            	var treeData = data.data;
	                 $.each(treeData, function (i, nodeData) {
	                     treeData[i].open = true;
	                     treeData[i].checked = true; 
	                 })
	                //初始化权限树
	                treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
	            }
	        }) 
    } 

    function switchSearchLevel(adCode){
        if(adCode==""){
            return;
        }
    //1：单位; 2：本局;3：全市;4：全省
        if(adCode.substring(4,6)!="00"){//分局部门
            $("#levelCity").hide();
            $("#levelProv").hide();
        }
        if(adCode.substring(4,6)=="00"&&adCode.substring(2,4)!="00"){//市局部门
            $("#levelCity").show();
            $("#levelProv").hide();
        }
        if(adCode.substring(0,9)=="330000000"){//省局
            $("#levelProv").show();
            $("#levelCity").hide();
        }
    }
    function bind() {
        util.bindEvents([
            {
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
            },
            {
                el: '#save',
                event: 'click',
                handler: function () {
                    if($("#sysUserForm").valid()){

                        if($("#userId").val()==""&& $.trim($("#password").val())==""){
                            layer.tips("请输入密码",$('#password'),{
                                tips:3,
                                tipsMore:true,
                                ltype:0
                            });
                            return;
                        }

                        var options=$('#js-select-add option');
                        if(options==undefined||options.length==0){
                            layer.tips("请选择角色",$('#roleLabel'),{
                                tips:3,
                                tipsMore:true,
                                ltype:0
                            });
                            return;
                        }
                        for(var i=0; i<options.length; i++){
                            options[i].selected = true;
                        }
                        $("#roles").val($("#js-select-add").val());

                        if($("#deptCode").val()==""){
                            layer.tips("请选择部门",$('#s_deptName'),{
                                tips:3,
                                tipsMore:true,
                                ltype:0
                            });
                            return;
                        }

                        var formParam = $('#sysUserForm').serializeObject();
                        http.httpRequest({
                            url: '/syn/system/sysuser/save',
                            serializable: true,
                            data: formParam,
                            type: 'post',
                            success: function (data) {
                                layer.msg(data.msg, {time: 1000}, function () {

                                });
                                if(data.status=='success'){
                                    layer.close({reload: true});
                                }
                            }
                        })
                    }

                }
            },
            {
                el: '#selectDept',
                event: 'click',
                handler: function () {
                    doSelectSynDept();
                }
            },
            {
                el: '#selectAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[class='entTypes']").prop("checked", flag);
                }
            },
            {
                el: '#js-select-del',
                event: 'click',
                handler: function (event) { 
                   var role_idArr=$("#js-select-del").val();
                   //加载权限树
                   ztreeInitRoleId(role_idArr[0]);
                   //加载权限说明
                   getRoleByRoleId(role_idArr[0]);
                }
            },
            {
                el: '#js-select-add',
                event: 'click',
                handler: function (event) { 
                    var role_idArr=$("#js-select-add").val(); 
                    //加载权限树
                    ztreeInitRoleId(role_idArr[0]);
                    //加载权限说明
                    getRoleByRoleId(role_idArr[0]);
                }
            }
        ])
    }

})