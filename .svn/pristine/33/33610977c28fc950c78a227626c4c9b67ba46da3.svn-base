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
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#registInfoForm').validate({
            rules: {
            	lcalAdm: {
                    required: true
                }
            },

            submitHandler: function () {

               if($('#superNo').val().trim()==''){
               layer.msg("请选择监管项目！",{time:1000});
               return false;
               }
               layer.close({
               superNoNames: $('#superName').val(),
               superNos: $('#superNo').val()
               });
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
        {          el: '#checkAll',
                    event: 'click',
                    handler: function () {
                  var flag=$(this).prop("checked");
                  $("input:checkbox[name='_checkbox']").prop("checked", flag);
                    }
        },
       {
           el: 'input[name="_unlicensed"]',
           event: 'click',
           handler: function () {
           var allChecked='';
           var allCheckedVal='';
           $(':checkbox[name="_unlicensed"]').each(function(){
           var checkFlag = $(this).prop("checked");
           var text = $(this).next().html();
           var val = $(this).val();
           if(checkFlag){
           allChecked+=","+text;
           allCheckedVal+=","+val;
           }
           });

           $('#superName').val(allChecked.substr(1));
           $('#superNo').val(allCheckedVal.substr(1));
         }
        }
        ])
    }

})