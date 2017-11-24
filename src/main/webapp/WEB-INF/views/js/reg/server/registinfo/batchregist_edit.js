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
if(_sliceMan.length<1) return;
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
               //表单验证begin
                if($('#superNoNames').val()==''){
                 layer.msg('请选择监管项目！', {time: 1000});
                 return false;
               }
                if($('#streetd').text()==''){
                 layer.msg('请选择乡镇街道！', {time: 1000});
                 return false;
               }
                if($('#sliceNOName').val()==''){
                 layer.msg('请选择片区商圈！', {time: 1000});
                 return false;
               }
                if($('#sliceManp').text()==''){
                 layer.msg('请选择管辖人员！', {time: 1000});
                 return false;
               }
               //表单验证end
                http.httpRequest({
                    url: '/reg/server/registinfo/registinfo/batchModi',
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
          var _id = "_doPrint_"+new Date().getTime();
          var url='/reg/server/registinfo/registinfo/toShow?fromtype=print&priPID=' + $('#priPID').val()+'&uid='+$('#uid').val();
          try{
               window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
          }
          catch(e){
               alert("打印错误!");
          }
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
             $(":checkbox[name=_checkbox]:checked").each(function() {
                 ItemIds[index++] = $(this).val();
                 uid= $(this).data('uid');
                 priPID= $(this).data('pripid');

             });
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
    {//1乡镇街道编辑
            el: '#streetAdd',
            event: 'click',
            handler: function () {
            layer.dialog({
                 title: '乡镇街道编辑',
                 area: ['628px', '600px'],
                 content: '/reg/server/registinfo/registinfo/tostreetAdd?supCode='+$('#localAdm').val()+'&content=' + $('#streetd').html()+'&code='+ $('#street').val(),
                 callback: function (data) {
                 if(data.names==null||data.names=='') return;
                   $('#streetd').html(data.names);
                   $('#street').val(data.codes);
                 }
             });
             }
           },
         {//2片区商圈编辑
            el: '#sliceNOAdd',
            event: 'click',
            handler: function () {
            layer.dialog({
                 title: '片区商圈编辑',
                 area: ['580px', '600px'],
                 content: '/reg/server/registinfo/registinfo/tosliceNOAdd?supCode='+$('#localAdm').val()+'&sliceNOName=' + $('input[name="sliceNOName"]').val()+'&sliceNO='+ $('input[name="sliceNO"]').val(),
                 callback: function (data) {
                 if(data.names==null||data.names=='') return;
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
            var priPID= $('input[name="priPID"]').val();
            var localAdm = $('#localAdm').val();
            var sliceMan=$('#sliceMan').val();
            var sliceTel=$('#sliceTel').val();
            layer.dialog({
                title: '请选择管辖人员',
                area: ['628px', '600px'],
                content: '/reg/server/registinfo/registinfo/toBatchDistribute?fromtype=sliceman&priPID='+priPID+'&localAdm='+localAdm+
                '&sliceMan='+sliceMan+'&sliceTel='+sliceTel,
                callback: function (data) {
                 if(data.sliceManShow==null||data.sliceManShow=='') return;
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
            layer.dialog({
                title: '编辑监管项目',
                area: ['30%', '600px'],
                content: '/reg/server/registinfo/registinfo/toSuperAdd?superNoNames='+$('#superNoNames').val()+
                '&superNos='+$('#superNos').val()+'&superType='+$('#superType').val(),
                callback: function (data) {
                if(data.names==null||data.names=='') return;
                //回显选择的数据
                 $('#superNoNamesDiv').html(data.names);
                 $('#superNoNames').val(data.names);
                 $('#superNos').val(data.codes);
                 $('#superType').val('');
                }
            })
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
                 area: ['30%', '600px'],
                 content: '/reg/server/registinfo/registinfo/toMarkAdd?iDTypename='+typename+'&iDType='+idtype+'&iDName=' +idname+'&iDCode='+idcode,
                 callback: function (data) {
                 if(data.names==null||data.names=='') return;
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
           $('.isInvestigateDiv').show();
           }else{
           $('.isInvestigateDiv').hide();
           }

            }
          }
,
        { //7勘察不一致显示
           el: 'input[name="isSameAddr"]',
           event: 'click',
           handler: function () {
           if($('input[name="isSameAddr"]:checked').val()=='0'){
           $('.isSameAddrDiv').show();
           }else{
           $('.isSameAddrDiv').hide();
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
          },
        { //9个转企日期显示
           el: 'input[name="changeArchState"]',
           event: 'click',
           handler: function () {
           if($('input[name="changeArchState"]:checked').val()=='3'||$('input[name="changeArchState"]:checked').val()=='4'){
           $('#changeArchState_span').attr('style','display:inline-block');
           }else{
           $('#changeArchState_span').attr('style','display:none');
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