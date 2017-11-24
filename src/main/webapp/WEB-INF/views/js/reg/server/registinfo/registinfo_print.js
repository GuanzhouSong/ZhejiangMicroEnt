require(['component/iframeLayer', 'component/dataTable',
 'common/util', 'common/http','handlebars', 'jquery.validate', 'jquery.serialize', 'laydate'], function
(layer, dataTable, util, http, handlebars) {


    init();
    var table;
    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        initDataTable();
        bind();
        initShow();
    }
    /**
     * 初始化管辖人员显示
     */
function initShow(){
var man = _sliceMan.split(",");
var tel = _sliceTel.split(",");
var show='';
for (var i=0 ; i< man.length ; i++)
{
show+=';'+man[i]+'  电话：'+tel[i];
}
$('#sliceManp').html(show.substr(1));
}
    /**
     * 表单验证
     */
    function formValid() {
        $('#registInfoForm').validate({
            submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                //拼接其他字符
                 formParam = addParam(formParam);
                //拼接管辖人员字符串
                //formParam.sliceMan = sliceMantoStr();

                http.httpRequest({
                    url: '/reg/server/registinfo/registinfo/modi',
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

        //拼接管辖人员字符串
        function sliceMantoStr(){
        var sliceMan='';
        if( $('input[name="sliceMan"]').length<1)return "";
        $('input[name="sliceMan"]').each(function(item){
        sliceMan+=","+$(this).val();
        });
        return sliceMan.substr(1);
        }
        //拼接管辖人员联系电话字符串
        function sliceMantoStr(){
        var sliceMan='';
        if( $('input[name="sliceMan"]').length<1)return "";
        $('input[name="sliceMan"]').each(function(item){
        sliceMan+=","+$(this).val();
        });
        return sliceMan.substr(1);
        }
    }
  /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#logoff-table',
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/registinfo/unlicensedinfo/listForLogoff.json',
                data:function(d){
//todo 查询条件先注掉，以后加上
//	               		 d.params = {
//                         name:leRep,
//                         cerNO:cerNO,
//                         entName:entName,
//                         proLoc:dom
//	               		 }
	               	}
                },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center'},
//                {data: null, 'className': 'center'},
                {data: 'name'},
                {data: 'cerNO'},
                {data: 'mgrName'},
                {data: 'sliceNoName'},
                {data: 'setName'},
                {data: 'setTime'}

            ],
            columnDefs: [
	{               targets:1,
					render:function(data,type,row,meta){
                     return  '<input type="checkbox" data-unlicstate="'+row.unlicState+'" data-uid="'+row.uid+'" data-pripid="'+row.priPID+'" name="_checkbox" value='+row.uid+'>';
					}
				 }
/*,
       {
       targets:"unlicState",render:function(data,type,row,meta){
             if(data =='1'){return '未销户';}
             else if(data =='2'){ return '已销户';}
             else return '';
        }
       }*/
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
        },
     {
         el: '#print',
         event: 'click',
         handler: function () {
         layer.dialog({
             title: '预览打印',
             area: ['1028px', '700px'],
             content: '/reg/server/registinfo/registinfo/toShow?fromtype=view&priPID=' + $('#priPID').val()+'&uid='+$('#uid').val(),
             callback: function (data) {

             }
         })
         }
     },
      {
            el: '.js-logoff',
            event: 'click',
            handler: function () {
             var ItemIds = new Array();
             var index = 0;
             var uid = '';
             var priPID='';
//             var noneLogoffedFlag=true;
             $(":checkbox[name=_checkbox]:checked").each(function() {
                 ItemIds[index++] = $(this).val();
                 uid= $(this).data('uid');
                 priPID= $(this).data('pripid');
//                 if($(this).data('unlicstate')=='2'){
//                 noneLogoffedFlag=false;
//                 }
             });
//             if(!noneLogoffedFlag){
//               layer.msg("请选择未销户的进行销户操作", {ltype: 0,time:1000});
//               return;
//             }
             if(ItemIds.length!=1){
                  layer.msg("只能选择一项进行操作", {ltype: 0,time:500});
                  return;
             }

            layer.dialog({
            title: '编辑销户信息',
            area: ['900px', '800px'],
            content: '/reg/server/registinfo/unlicensedinfo/toLogoffShow?uid='+uid+'&priPid='+priPID,
            callback: function (data) {
                //重新加载列表数据
                if (data.reload) {
                    table.ajax.reload();
                }
            }
        })
            }
        },
        {          el: '#checkAll',
                    event: 'click',
                    handler: function () {
                  var flag=$(this).prop("checked");
                  $("input:checkbox[name='_checkbox']").prop("checked", flag);
                    }
        },
     {     el: '.js-fold',
            event: 'click',
            handler: function () {
            if($(this).hasClass('fold-on')){
                $(this).text('展开企业信息');
                $(this).removeClass("fold-on");
            }else{
                $(this).text('隐藏企业信息');
                $(this).addClass("fold-on");
            }

            $(this).parent().prev('.table-horizontal').toggle();
            $('.detail-brief').toggleClass('border-bottom');
         }
        },
     {  el: '#superNoNames',
        event: 'click',
        handler: function () {
        layer.dialog({
            title: '编辑监管项目',
            area: ['500px', '300px'],
            content: '/reg/server/registinfo/registinfo/toUnlicensedShow?superName='+$('#superNoNames').val()+
            '&superNo='+$('#superNos').val(),
            callback: function (data) {
            //回显选择的数据
             $('#superNoNames').val(data.superNoNames);
             $('#superNos').val(data.superNos);

            }
        })

        }
    },
    {//1乡镇街道编辑
            el: '#streetAdd',
            event: 'click',
            handler: function () {
            alert("等待完善");
             }
           },
         {//2片区商圈编辑
            el: '#sliceNOAdd',
            event: 'click',
            handler: function () {
            layer.dialog({
                 title: '片区商圈编辑',
                 area: ['628px', '600px'],
                 content: '/reg/server/registinfo/registinfo/tosliceNOAdd?supCode='+$('#supCode').val()+'&sliceNOName=' + $('input[name="sliceNOName"]').val()+'&sliceNO='+ $('input[name="sliceNO"]').val(),
                 callback: function (data) {
                   $('#sliceNONameDiv').html(data.names);
                   $('input[name="sliceNOName"]').val(data.names);
                   $('input[name="sliceNO"]').val(data.codes);
                 }
             });
             }
           },
         {//3管辖人员编辑
            el: '#sliceManAdd',
            event: 'click',
            handler: function () {
            layer.dialog({
                title: '请选择管辖人员',
                area: ['628px', '600px'],
                content: '/reg/server/registinfo/registinfo/toBatchDistribute?fromtype=sliceman&priPID=' + $('input[name="priPID"]').val(),
                callback: function (data) {
                  $('#sliceManp').html(data.sliceManShow);
                  $('#sliceMan').val(data.sliceMan);
                  $('#sliceTel').val(data.sliceTel);
                }
            });
             }
           },
         { //4监管对象编辑
            el: '#supAdd',
            event: 'click',
            handler: function () {
            alert("等待完善");
//            layer.dialog({
//                 title: '监管对象编辑',
//                 area: ['628px', '600px'],
//                 content: '/reg/server/registinfo/registinfo/toSupAdd?priPID=' + data.priPID+'&UID='+data.uid,
//                 callback: function (data) {
//                   $('#superNoNamesDiv').html(data.names);
//                   $('#superNoNames').html(data.names);
//                   $('#iDCodes').html(data.codes);
//                 }
//             });
             }
           },
        { //5主体标签--重点监管对象--编辑
           el: '._markfocusAdd',
           event: 'click',
           handler: function () {
           var idtype=$(this).data("marktype");
           var idname=$('.IDName'+idtype).val();
           var idcode=$('.IDCode'+idtype).val();
           var typename=$(this).data("typename");
            layer.dialog({
                 title: "编辑"+typename+"标签",
                 area: ['628px', '600px'],
                 content: '/reg/server/registinfo/registinfo/toMarkAdd?iDTypename='+typename+'&iDType='+idtype+'&iDName=' +idname+'&iDCode='+idcode,
                 callback: function (data) {
                   $('.IDName'+idtype).val(data.names);
                   $('.IDCode'+idtype).val(data.codes);
                   $('#markDiv'+idtype).html(data.names);
                 }
             });


            }
          },
        { //6是否进行实地勘察显示
           el: 'input[name="isInvestigate"]',
           event: 'click',
           handler: function () {
           if($('input[name="isInvestigate"]:checked').val()=='1'){
           $('.isInvestigateDiv').attr('style','display:inline-block');
           }else{
           $('.isInvestigateDiv').attr('style','display:none');
           }

            }
          }
,
        { //7勘察不一致显示
           el: 'input[name="isSameAddr"]',
           event: 'click',
           handler: function () {
           if($('input[name="isSameAddr"]:checked').val()=='0'){
           $('.isSameAddrDiv').attr('style','display:inline-block');
           }else{
           $('.isSameAddrDiv').attr('style','display:none');
           }

            }
          }
,
        { //8异地经营显示
           el: 'input[name="diffAddrReason"]',
           event: 'click',
           handler: function () {
           if($('input[name="diffAddrReason"]:checked').val()=='2'){
           $('.diffAddrReasonDiv').attr('style','display:inline-block');
           }else{
           $('.diffAddrReasonDiv').attr('style','display:none');
           }
            }
          }
        ])
    }

    /**拼接各种字主体标签和监管项目管辖人员字符串传到后台解析
    */
    function addParam(formParam){
    //主体标签
    var iDType='';
    var iDCodeNames='';
    var iDCodes='';
    $('._markfocusAdd').each(function(){
    var type = $(this).data('marktype');
    iDType+=','+type;
    iDCodes+='&'+$('.IDCode'+type).val();
    iDCodeNames+='&'+$('.IDName'+type).val();

    });
    formParam.iDType=iDType.substr(1);
    formParam.iDCodeNames=iDCodeNames.substr(1);
    formParam.iDCodes=iDCodes.substr(1);
    return formParam;

    }
})