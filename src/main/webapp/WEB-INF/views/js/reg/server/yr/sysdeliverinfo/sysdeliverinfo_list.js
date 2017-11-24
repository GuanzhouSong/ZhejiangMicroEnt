require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','laydate','handlebars', 'layer1', 'ztree'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
    	ztreeInit();
        bind();
    }

    var table;
        
    //部门树对象
    var treeObj = null;
    //当前部门
    var dept = null ;
    //当前部门id
    var id = null;
    
    var clickFlag = false;

    //权限树配置
    var treeSetting = {
        view: {
            dblClickExpand: true,
            showLine: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: 'id',
                pIdKey: 'pId',
                rootPId: ''
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
            	clickFlag =true;
            	dept = treeNode;
                if(treeNode.code.length > 6){
                    $(".bmgl").html("" + treeNode.name);
                    $(".col-xs-9").show();
                    id = treeNode.deptId;
                    table.ajax.reload();
                }else{
                	$(".col-xs-9").hide();
                }
            }
        }
    };

  
    /**
     * 初始化权限树
     */
    function ztreeInit() {
        //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/reg/server/yr/department/list.json',
            success: function (data) {
                if (data.status == 'success') {
                    //初始化权限树
                    treeObj = $.fn.zTree.init($('#ztree'), treeSetting, data.data);
                    $(".col-xs-9").hide();
                }
            }
        });
    }
    
    
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {   		
    	table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table', 
            //是否加索引值
            showIndex: false,
			scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/yr/sysdeliverinfo/list.json',
                data:function(d){
                	if(clickFlag){
                		 d.params = {"deptId":id};
                	}else{
                		 d.params = {"deptId":"-1"};
                	}
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null,defaultContent:'uid', width: "70px", className: 'center'},
                {data: 'deliAddress', width: "70px",cut: {length: 10,mark:'...'}},
                {data: 'deliName'},
                {data: 'postalCode'},
                {data: 'linkman'},
                {data: 'tel'},
                {data: 'isValid'},
                {data: 'deliType'},               
                {data: 'remark',cut: {length: 10,mark:'...'}},
                {data: 'setName'},
                {data: 'setTime'}
            ],
            columnDefs: [
         				{
         					targets:0,
         					render:function(data,type,row,meta){
                                return "<input value='" + row.uid + "' name='viewGridRadio' class='chb checkbox' type='radio' />";
         					}
         				 },
          				{
          					targets:6,
          					render:function(data,type,row,meta){
                                 if(row.isValid == '0'){
                                	 return "无效";
                                 }else if(row.isValid == '1'){
                                	 return "有效";
                                 }else{
                                	 return "";
                                 };
          					}
          				 },
          				{
           					targets:7,
           					render:function(data,type,row,meta){
                                  if(row.deliType == '1'){
                                 	 return "内资";
                                  }else if(row.deliType == '2'){
                                 	 return "外资";
                                  }else if(row.deliType == '3'){
                                 	 return "农专社";
                                  }else{
                                 	 return "";
                                  };
           					}
           				 }
        ]
        })
    }
    
    
    /**
     * 获取选中的权限ID
     * @returns {*}
     */
    function getFirstSelectedId() {
        var uid;
        if (treeObj) {
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                uid = nodes[0].id;
            }
        }
        return uid;
    }
    
    

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                //选中的权限ID
//                var sid = getFirstSelectedId();                
//                console.log(sid);
//                console.log(dept);
//                var code = dept.code;
//                console.log(code);                              
                layer.dialog({
                    title: '送达地址管理  - 新增',
                    area: ['628px', '400px'],
                    content: '/reg/server/yr/sysdeliverinfo/view?deptId=' + dept.deptId +'&deliName='+dept.name+'&deliCode='+dept.code+'&deliType='+1,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '#editBtn',
            event: 'click',
            handler: function () {
            	var uid = $(".chb:checked").val();
                if (!uid) {
                    layer.msg('请选择该部门下要修改的送达地址', {time: 500});
                    return false;
                }
                layer.dialog({
                    title: '送达地址管理  - 修改',
                    area: ['628px', '400px'],
                    content: '/reg/server/yr/sysdeliverinfo/view?uid=' + uid+'&deptId=' + dept.deptId +'&deliName='+dept.name+'&deliCode='+dept.code+'&deliType='+1,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '#delBtn',
            event: 'click',
            handler: function () {
                var uid = $(".chb:checked").val();
//                console.log(uid);
                if (!uid) {
                    layer.msg('请选择该部门下要删除的送达地址', {time: 500});
                    return false;
                }
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                http.httpRequest({
                    type: 'post',
                    url: '/reg/server/yr/sysdeliverinfo/delete',
                    data: {uid: uid},
                    success: function (data) {
                        if (data.status == 'success') {
                            if (data.msg) {
                                layer.msg(data.msg, {time: 1000}, function () {
                                    //删除成功重新加载
                                	 table.ajax.reload();
                                });
                            }
                            return;
                        }
                        var errorMsg = data.msg;
                        var errors = data.errors;
                        if (errors.length > 0) {
                            for (var i = 0; i < errors.length; i++) {
                                errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                            }
                        }
                        layer.msg(errorMsg, {time: 1000});
                    }
                });
            });
            }
        }])
    }

})
