require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }

    var table;
    var params = {};//查询参数声明!
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        table = dataTable.load({
            showIndex: true,
            //需要初始化dataTable的dom元素
            el: '#user-table',
            ajax : {
                type : "get",
                url :  window._CONFIG.namespace+'/sysuser/list.json',
                data : function(d) {
                    d.params = $.extend({}, $("#entSearchForm").serializeObject(),{status:'1'});
                }
            },

            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null,width: '8%'},//序号0
                {data: null,defaultContent:'id',width:'8%', className: 'center'}, //复选1
                {data: 'username', width: '15%'},//用户名2
                {data: 'realName', width: '15%'},//姓名3
                {data: 'dept', width: '15%'},//所属部门4
                {data: 'deptName', width: '9%'},//科室5
                {data: 'post', width: '10%'},//职务6
                {data: 'userSetPerson', width: '10%'},//设置人13
                {data: 'setDate', width: '10%'}//设置日期14
            ],
            columnDefs: [
                {
                    targets : 1,
                    render : function(data, type, row, meta) {
                        return "<input value='" + row.id + "' username='"+row.username+"'"+" name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#choseDept',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择部门',
                        area: ['400px', '600px'],
                        content: window._CONFIG.select_detp_tree_url,
                        callback: function (data) {
                            $("#deptCode").val(data.deptId);
                            $("#deptName").val(data.deptName);
                        }
                    })
                }
            },
            {
                el: '#search',
                event: 'click',
                handler: function () {
                    params = $("#entSearchForm").serializeObject();
                    table.ajax.reload();
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var allChecked = $("#checkAll").prop("checked");
                    $(".chb").prop("checked", allChecked);
                }
            },
            {
                el: '#reset',
                event: 'click',
                handler: function () {
                    $("#deptCode").val("");
                    $("#deptName").val("");
                }
            },
            {
                el: '.js-add',
                event: 'click',
                handler: function () {
                    var ids = new Array();
                    var userNames=new Array();
                    $(":checkbox[name=checkboxlist]:checked").each(function (k, v) {
                        ids[k] = this.value;
                        userNames[k] = $(this).attr("username");
                    });

                    if (ids[0] == "" || ids[0] == null) {
                        layer.msg("请您<em style='color: red;'>【至少选择一条】</em>进行设置!", {icon: 7, time: 1000});
                        return false;
                    }
                    layer.dialog({
                        title: '请选择要添加的岗位角色',
                        area: ['98%', '90%'],
                        content: window._CONFIG.namespace+'/sysuser/toBathSetRole?userIds=' + ids.toString()+"&type=add&userNames="+userNames.toString(),
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            },
            {
                el: '.js-remove',
                event: 'click',
                handler: function () {
                    var ids = new Array();
                    var userNames=new Array();
                    $(":checkbox[name=checkboxlist]:checked").each(function (k, v) {
                        ids[k] = this.value;
                        userNames[k] = $(this).attr("username");
                    });

                    if (ids[0] == "" || ids[0] == null) {
                        layer.msg("请您<em style='color: red;'>【至少选择一条】</em>进行设置!", {icon: 7, time: 1000});
                        return false;
                    }
                    layer.dialog({
                        title: '请选择要删减的岗位角色',
                        area: ['98%', '90%'],
                        content: window._CONFIG.namespace+'/sysuser/toBathSetRole?userIds=' + ids.toString()+"&type=del&userNames="+userNames.toString(),
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })

                }
            }
        ])
    }

})
