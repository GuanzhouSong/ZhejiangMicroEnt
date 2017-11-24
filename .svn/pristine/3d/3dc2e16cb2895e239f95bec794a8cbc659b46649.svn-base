require(['component/iframeLayer', 'component/dataTable',
 'common/util', 'common/http','handlebars', 'jquery.validate', 'jquery.serialize', 'laydate'], function
(layer, dataTable, util, http, handlebars) {


    init();
    var record_table;
    var manage_table;
    var find_table;
    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        initDataTable();
        bind();
        dataFormat();
    }

/**
*日期格式化
*/
function dataFormat(){
Date.prototype.format = function(format){
var o = {
"M+" : this.getMonth()+1, //month
"d+" : this.getDate(), //day
"h+" : this.getHours(), //hour
"m+" : this.getMinutes(), //minute
"s+" : this.getSeconds(), //second
"q+" : Math.floor((this.getMonth()+3)/3), //quarter
"S" : this.getMilliseconds() //millisecond
}

if(/(y+)/.test(format)) {
format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
}

for(var k in o) {
if(new RegExp("("+ k +")").test(format)) {
format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
}
}
return format;
}}
// end 日期格式化
    /**
     * 表单验证
     */
    function formValid() {
        $('#registInfoForm').validate({
//            rules: {
//            	codeSliceno: {
//                    required: true
//                }
//            },
            submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/registinfo/unlicensedinfo/unlicensedRegist',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
            }
        })
    }
  /**
     * 初始化dataTable
     */
    function initDataTable() {
         initManageTable();
         initFindTable();
         initRecordTable();

    }
//无证表
    function initRecordTable() {
            record_table = dataTable.load({
                //需要初始化dataTable的dom元素
                el: '#record-table',
                //是否加索引值
                showIndex: true,
                ajax: {
                    url:'/reg/server/registinfo/ulrecordinfo/recordList.json',
                    data:function(d){
    	               		 d.params = {
                             uid:uid
    	               		 }
    	               	}
                    },
                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                columns: [
                    {data: null, 'className': 'center'},
                    {data: null, 'className': 'center'},
                    {data: 'licName'},
                    {data: 'remark'}
                ],
                columnDefs: [
    	{               targets:1,
    					render:function(data,type,row,meta){
                         return  '<input type="checkbox" name="_checkbox_record"  value='+row.id+'>';
    					}
    				 }
                ]
            })

    }
    //管理表
    function initManageTable() {
            manage_table = dataTable.load({
                //需要初始化dataTable的dom元素
                el: '#manage-table',
                //是否加索引值
                showIndex: true,
                ajax: {
                    url:'/reg/server/registinfo/ulmanageinfo/manageList.json',
                    data:function(d){
    	               		 d.params = {
                             uid:uid
    	               		 }
    	               	}
                    },
                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                columns: [
                    {data: null, 'className': 'center'},
                    {data: null, 'className': 'center'},
                    {data: 'disposeDate'},
                    {data: 'disposeWay'},
                    {data: 'disposeName'},
                    {data: 'remark'}
                ],
                columnDefs: [
    	{               targets:1,
    					render:function(data,type,row,meta){
                         return  '<input type="checkbox" name="_checkbox_manage"  value='+row.id+'>';
    					}
    				 },
    	{               targets:3,
    					render:function(data,type,row,meta){
    					if(data=='1')return"行政告诫"
    					else if (data=='2')return"行政指导"
    					else if (data=='3')return"责令整改"
    					else if (data=='4')return"列入案源信息"
    					else if (data=='5')return"部门抄告抄送"
    					else if (data=='6')return"销户"
    					else return "";
    					}
    				 }
                ]
            })

    }
    //发现表
    function initFindTable() {
            find_table = dataTable.load({
                //需要初始化dataTable的dom元素
                el: '#find-table',
                //是否加索引值
                showIndex: true,
                ajax: {
                    url:'/reg/server/registinfo/ulfindinfo/findList.json',
                    data:function(d){
    	               		 d.params = {
                             uid:uid
    	               		 }
    	               	}
                    },
                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                columns: [
                    {data: null, 'className': 'center'},
                    {data: null, 'className': 'center'},
                    {data: 'findDate'},
                    {data: 'findName'},
                    {data: 'findWay'},
                    {data: 'remark'}
                ],
                columnDefs: [
    	{               targets:1,
    					render:function(data,type,row,meta){
                         return  '<input type="checkbox" name="_checkbox_find" value='+row.id+'>';
    					}
    				 },
    	{               targets:4,
    					render:function(data,type,row,meta){
    					if(data=='1')return"日常巡查"
    					else if (data=='2')return"上级督办"
    					else if (data=='3')return"投诉举报"
    					else if (data=='4')return"部门移交"
    					else if (data=='5')return"其他来源"
    					else return "";
    					}
    				 }
                ]
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
        },{
          el: '.js-find',
          event: 'click',
          handler: function () {
         var ItemIds = new Array();
         var index = 0;
         $(":checkbox[name=_checkbox_find]:checked").each(function() {
             ItemIds[index++] = $(this).val();
         });
         if(ItemIds.length!=1){
              layer.msg("请选择一项进行操作", {ltype: 0,time:500});
             return false;
         }
       layer.dialog({
                    title: '编辑发现记录',
                    area: ['628px', '500px'],
                    content: '/reg/server/registinfo/unlicensedinfo/toFindShow?id='+ItemIds[0]
                    +'&uid='+$('input[name="uid"]').val()+'&priPid='+$('input[name="priPID"]').val(),
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            find_table.ajax.reload();
                        }
                    }
                })
          }
      },{
                 el: '.js-record',
                 event: 'click',
                 handler: function () {
                var ItemIds = new Array();
                var index = 0;
                $(":checkbox[name=_checkbox_record]:checked").each(function() {
                    ItemIds[index++] = $(this).val();
                });
                if(ItemIds.length!=1){
                     layer.msg("请选择一项进行操作", {ltype: 0,time:500});
                    return false;
                }
              layer.dialog({
                           title: '编辑无证记录',
                           area: ['500px', '300px'],
                           content: '/reg/server/registinfo/unlicensedinfo/toRecordShow?id='+ItemIds[0]
                           +'&uid='+$('input[name="uid"]').val()+'&priPid='+$('input[name="priPID"]').val(),
                           callback: function (data) {
                               //重新加载列表数据
                               if (data.reload) {
                                   record_table.ajax.reload();
                               }
                           }
                       })
                 }
             },{
         el: '.js-manage',
         event: 'click',
         handler: function () {
         var ItemIds = new Array();
         var index = 0;
         $(":checkbox[name=_checkbox_manage]:checked").each(function() {
             ItemIds[index++] = $(this).val();
         });
         if(ItemIds.length!=1){
              layer.msg("请选择一项进行操作", {ltype: 0,time:500});
             return false;
         }
       layer.dialog({
                    title: '编辑管理记录',
                    area: ['500px', '300px'],
                    content: '/reg/server/registinfo/unlicensedinfo/toManageShow?id='+ItemIds[0]
                    +'&uid='+$('input[name="uid"]').val()+'&priPid='+$('input[name="priPID"]').val(),
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            manage_table.ajax.reload();
                        }
                    }
                })
         }
     },{
        el: '.js-find-add',
        event: 'click',
        handler: function () {
        layer.dialog({
                  title: '新增发现记录',
                  area: ['628px', '500px'],
                  content: '/reg/server/registinfo/unlicensedinfo/toFindShow?uid='+$('input[name="uid"]').val()+'&priPid='+$('input[name="priPID"]').val(),
                  callback: function (data) {
                      //重新加载列表数据
                      if (data.reload) {
                          find_table.ajax.reload();
                      }
                  }
              })
        }
},{        el: '.js-record-add',
           event: 'click',
           handler: function () {
           layer.dialog({
                     title: '新增无证记录',
                     area: ['500px', '300px'],
                     content: '/reg/server/registinfo/unlicensedinfo/toRecordShow?uid='+$('input[name="uid"]').val()+'&priPid='+$('input[name="priPID"]').val(),
                     callback: function (data) {
                         //重新加载列表数据
                         if (data.reload) {
                             record_table.ajax.reload();
                         }
                     }
                 })
           }
      },{
   el: '.js-manage-add',
   event: 'click',
   handler: function () {
   layer.dialog({
              title: '新增管理记录',
              area: ['500px', '300px'],
              content: '/reg/server/registinfo/unlicensedinfo/toManageShow?uid='+$('input[name="uid"]').val()+'&priPid='+$('input[name="priPID"]').val(),
              callback: function (data) {
                  //重新加载列表数据
                  if (data.reload) {
                      manage_table.ajax.reload();
                  }
              }
          })
   }
           },
   {   el: '#regNO',
       event: 'change',
       handler: function () {
       var regNO=$(this).val();
       if(regNO.trim()!=''){
       $('input[name="mgrScope"]').attr("readonly",'true');
       $('input[name="mgrName"]').attr("readonly",'true');
       http.httpRequest({
        url: '/reg/server/registinfo/unlicensedinfo/getMidBaseinfoByregNO?regNO='+regNO,
        serializable: true,
        data: {},
        type: 'post',
        success: function (data) {
        var data=data.data;
             //自动显示法定代表人、登记状态、opto,经营内容，经营时使用的名称
          $('input[name="opTo"]').val(data.opTo==null?'':new Date(data.opTo).format("yyyy-MM-dd"));
          $('input[name="regState"]').val(data.regState);
          $('input[name="leRep"]').val(data.leRep);
          $('input[name="mgrScope"]').val(data.mgrScope);
          $('input[name="mgrName"]').val(data.mgrName);
        }
      })
     }else{
       $('input[name="mgrScope"]').removeAttr("readonly");
       $('input[name="mgrName"]').removeAttr("readonly");
     }
    }
   },
       {
          el: '#find_checkAll',
         event: 'click',
         handler: function () {
       var flag=$(this).prop("checked");
       $("input:checkbox[name='_checkbox_find']").prop("checked", flag);
         }
         },
       {
          el: '#record_checkAll',
         event: 'click',
         handler: function () {
       var flag=$(this).prop("checked");
       $("input:checkbox[name='_checkbox_record']").prop("checked", flag);
         }
         },
    {   el: '#manage_checkAll',
        event: 'click',
        handler: function () {
         var flag=$(this).prop("checked");
         $("input:checkbox[name='_checkbox_manage']").prop("checked", flag);
        }
    }

        ])
    }

})