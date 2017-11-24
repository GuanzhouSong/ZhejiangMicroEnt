require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
           scrollX:true, //支持滚动
           //是否加索引值
           showIndex: true,
            ajax: {
                // url:'/reg/server/registinfo/unlicensedinfo/listYetLogoff.json',
                url:'/reg/server/registinfo/unlicensedinfo/panoQueryPage',
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null,  'defaultContent': '11'},
                {data: 'altDate'},
                {data: 'regState'},
                {data: 'uniCode'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'dom'},
                {data: 'estDate'},
                {data: 'localAdmName'},
                {data: 'regOrgName'}
            ],
            columnDefs: [
				 {  targets:2,
                    render:function(data,type,row,meta){
                    if(data =='X'){
                    return '注销';
                    }else if(data =='D'){
                     return '吊销';
                    }else if(data =='C'){
                     return '撤销';
                    }else if(data =='Q'){
                      return '迁出';
                     }else return '';

              }
              },
				{
					targets:3,
					render:function(data,type,row,meta){
                     if(data==null||data=='')return row.regNO;
                     else return data;
					}
				 }
            ]
        })
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    });

    function bind() {
        util.bindEvents([

      {el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['1028px', '700px'],
                    content: '/reg/server/registinfo/registinfo/toShow?priPID=' + data.priPID+'&UID='+data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },
        {
                    el: '#qry',
                    event: 'click',
                    handler: function () {
                         searchParams=$("#qryForm").serializeObject();
                          table.ajax.reload();
                    }
     },
 {
         el: '#cancel',
         event: 'click',
         handler: function () {
                     $(':input','#qryForm')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked')
                        .removeAttr('selected');
         }
    }
,{
            el: '#choseorgReg',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
                    }
                })
            }
        },

        {
            el: '#choseregUnit',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;	 
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(returnname);
                    }
                })
            }
        },
        {
            el: '#choseEntType',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselectnocheck',
                    callback: function(data) {
                        //重新加载列表数据
                            $("#entType").val(data.returncodes);
                            var name = data.returnname;
                            $("#entTypeName").val(name);
                    }
                })
            }
        },
        {
            el: '#choseSilceno',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择责任区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNoName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#choseStreet',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择街道',
                    area: ['25%', '60%'],
                    content: '/commom/server/codestreet/streetmutiselectnocheck',
                    callback: function(data) {
                        //重新加载列表数据
                            $("#street").val(data.returncodes);
                            $("#streetName").val(data.returnname);
                    }
                })
            }
        }
])
    }

})
