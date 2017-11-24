require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars', 'jquery.validate', 'common/validateRules', 'jquery.serialize','ztree', 'ztreeCheck'], function (layer, util, http,handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
        initRoles();
        formValid();
        bind();
        initSelectAll();
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

    function initSelectAll(){
        var ckbox=$("input:checkbox[class='entTypes']");
        var ckboxSelected=$("input:checkbox[class='entTypes'][checked]");
        if(ckbox.length==ckboxSelected.length){
            $("#selectAll").prop("checked", "true");
        }
    }

/*    jQuery.validator.addMethod("email", function(value, element) {
        var tel =/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        return this.optional(element) || (tel.test(value));
    }, "请正确填写您邮箱！");*/

    /**
     * 表单验证
     */
    function formValid() {
        $('#sysUserForm').validate({
            onkeyup:false,
            rules: {
                username: {
                    checkMobile: $("#userId").val()=="",
                    required: true
                },
                password:{
                    required:$("#userId").val()==""
                },
                realName: {
                    required: true
                },
                email:{
                    email:true
                },
                roles:{
                    required: true
                },
                deptCode:{
                    required: true
                },
                status:{
                    required: true
                } ,
               /* telPhone:{
                    required:true,
                    checkMobile: true
                } ,
                phone:{
                    required:true,
                    isTel: true
                } ,
                phoneExt:{
                    required:true,
                    isTel: true
                } ,*/
                status:{
                    required: true
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
            submitHandler: function () {

            }
        })
    }

    // 部门单选
    function doSelectDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择部门',
            area: ['350px', '666px'],
            content: select_dept_url,
            callback: function (data) {
                if(data.deptCode!=null&&data.deptName!=null){
                    $("#s_deptName").val(data.deptName);
                    $("#deptCode").val(data.deptId);
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
            url:  '/reg/server/syspermision/list4roleIds.json',
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
                            url: '/reg/server/sysuser/save',
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
                    doSelectDept();
                }
            },
            {
                el: '#selectAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[class='entTypes']").prop("checked", flag);
                }
            }
        ])
    }

})