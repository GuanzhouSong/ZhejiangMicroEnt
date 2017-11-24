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
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/registinfo/unlicensedinfo/list.json',
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center'},
                {data: null, 'className': 'center'},
                {data: 'name'},
                {data: 'cerNO'},
                {data: 'uniCode'},
                {data: 'regNO'},
                {data: 'mgrName'},
                {data: 'proLoc'},
                {data: 'mobTel'},
                {data: 'unlicType'},
                {data: 'unlicState'}
            ],
            columnDefs: [
            	{   targets:1,
            		render:function(data,type,row,meta){
                    return  '<input type="checkbox" name="_checkbox"  value='+row.uid+'>';
            		}
            	},
      {
      targets:"unlicType",render:function(data,type,row,meta){
            if(data =='1'){return '无照';}
            else if(data =='2'){ return '无照无证';}
            else if(data =='3'){return '有照无证';}
            else if(data =='4'){ return '执照过期';}
            else if(data =='5'){ return '吊销未注销';}
            else return '';
       }
      },
     {
     targets:"unlicState",render:function(data,type,row,meta){
           if(data =='1'){return '未销户';}
           else if(data =='2'){ return '已销户';}
           else return '';
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
         {el: '.js-regist',
            event: 'click',
            handler: function () {
                     var ItemIds = new Array();
                     var index = 0;
                     var trueFlag=true;
                     $(":checkbox[name=_checkbox]:checked").each(function() {
                         ItemIds[index++] = $(this).val();
                         if(!($(this).data("uid")==null||$(this).data("uid").length<1))
                               trueFlag=false;

                     });
                     if(ItemIds.length!=1){
                    	  layer.msg("只能选择一项进行操作", {ltype: 0,time:500});
                         return false;
                     }

                layer.dialog({
                    title: '无证无照建档',
                    area: ['628px', '500px'],
                    content: '/reg/server/registinfo/unlicensedinfo/toUnllicensedShow?UID='+ItemIds[0],
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
    }, { el: '#qry',
            event: 'click',
            handler: function () {
                 searchParams=$("#qryForm").serializeObject();
                  table.ajax.reload(function(){
                  if(table.data().length<1){
                    layer.confirm('比对结果无相关信息，是否对此无证无照信息进行建档?',
                    {icon: 3, title: '提示'}, function (index) {
                    layer.close(index);
                    layer.dialog({
                    title: '无证无照建档',
                    area: ['628px', '500px'],
                    content: '/reg/server/registinfo/unlicensedinfo/toUnllicensedShow',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
               });
               }
             });
          }
       },
 {
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                     $('#qryForm')[0].reset();
                     }
                 },
 {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                 var flag=$(this).prop("checked");
                 $("input:checkbox[name='_checkbox']").prop("checked", flag);
                 }
   }
])
    }

})
