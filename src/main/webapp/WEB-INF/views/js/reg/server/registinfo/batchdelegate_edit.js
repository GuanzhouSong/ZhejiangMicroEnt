require(['component/iframeLayer', 'component/dataTable',
 'common/util', 'common/http','handlebars', 'jquery.validate', 'jquery.serialize',
 'laydate','ztree','ztreeCheck','common/validateRules'], function
(layer, dataTable, util, http, handlebars) {


    init();
    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        ztreeInit();
        bind();
    }

 var treeObj = null;
    //权限树配置
    var treeSetting = {
    			check: {
    				enable: false
    			},
			data: {
				simpleData: {
					enable: true
				}
			},
			view: {
            		fontCss: setHighlight // 高亮一定要设置，setHighlight是自定义方法
            	},
			callback: {
				onClick : onClick
			}
    };

    // 设置高亮字体
    function setHighlight(treeId, treeNode) {
              return (treeNode.highlight) ? {color:"green", "font-weight":"bold", "background-color": "#ddd"} : {color:"#000", "font-weight":"normal"};
       }
    // 模糊搜索name满足条件的节点
    function searchNode(value) {
    	if (value == "") return;

    	// 获取与value匹配的节点，使用的ztreeAPI getNodesByParamFuzzy
    	var nodes = treeObj.getNodesByParam("id", value);

    	// 关闭所有节点的高亮
    	// 使用API transformToArray获取所有的节点，getNodes()只能获得根节点，属性children也只能获取下一级节点
    	var allNodes = treeObj.transformToArray(treeObj.getNodes());

    	for (var i = 0; i < allNodes.length; i ++) {

    		// 关闭高亮是利用节点属性highlight来控制fontCss实现的
    		// 需要配合setting.view中设置的fontCss使用，后面代码会说
    		allNodes[i].highlight = false;

    		// 更新节点，因为hightlight改变了，使用updateNode可以更新节点
    		treeObj.updateNode(allNodes[i]);
    	}
    	// 先关闭所有节点
    	treeObj.expandAll(false);

    	// 展开根节点（如果不展开根节点，下面的节点无法展开，不知道是不是bug）
    	treeObj.expandNode(treeObj.getNodes()[0],true);

    	// 高亮并展开搜索到的节点
    	for (var i = 0; i < nodes.length; i ++) {

    		nodes[i].highlight = true;
    		treeObj.updateNode(nodes[i]); // 更新节点，让高亮生效

    		// 展开搜索到的节点的父节点
    		treeObj.expandNode(nodes[i].getParentNode(),true);
    	}
    }
    /**
     * 点击触发事件
     */
    function onClick(e, treeId, treeNode) {
    	var zTree = $.fn.zTree.getZTreeObj("permisionTree");
    	var node = zTree.getSelectedNodes()[0];
        if(node.isParent==false){
           httpClick(node.id);
        }
    }
//根据点击树的node，加载下面的数据
function httpClick(supCode){
 http.httpRequest({
            url: '/reg/server/registinfo/registinfo/getRegorgByPcode',
            data:{code:supCode},
            success: function (data) {
                var liData = data.data;
                var lis='';
                for(var i=0;i<liData.length;i++){
                 var content = '';if(liData[i].content!=null)content=liData[i].content;
                 var code = '';if(liData[i].code!=null)code=liData[i].code;
                  lis+='<label><input type="radio" name="delegateOrg" value="'
                 +liData[i].code+'"><span class="name">'
                 +content+'</span></input></label></br>';
                }
               $('#optionlist').html(lis);
            }
        });}

    /**
     * 初始化树状结构
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/commom/server/regorg/treeListJSON',
            success: function (data) {
                var treeData = data.data;
                treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
            }
        });
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#registInfoForm').validate({
            onkeyup:false,
            onfocusout:function(el){
              $(el).valid();
             },
             messages:{
                registSource:{
                required:'请选择委托方式'
                }
             },
            showErrors:function(errorMap,errorList){
                   for(var i in errorMap){
                       layer.tips(errorMap[i],$('#registInfoForm input[name='+i+']'),{
                           tips:3,
                           tipsMore:true,
                           ltype:0

                       });
                       layer.tips(errorMap[i],$('#registInfoForm select[name='+i+']'),{  // 解决select的选项
                           tips:3,
                           tipsMore:true,
                           ltype:0
                       });
                   }
               },
            submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                debugger;
                if(($('input[name="registSource"]:checked').val()=='2')||                             //自管不验证登记机关
                    ($('input[name="registSource"]:checked').val()=='1'&&($('input[name="delegateOrg"]:checked').length==0||$('input[name="delegateOrg"]:checked').val() == ""))
                ){
                layer.msg("请选择登记机关！", {time: 1000});return;
                }
                http.httpRequest({
                    url: '/reg/server/registinfo/registinfo/batchDelegate',
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
                    $("input[name='delegateOrg']").prop("checked", flag);
                    checkTxt();
                    }
        },
     {   el: 'input[name="delegateOrg"]',
         event: 'click',
         handler: function () {
         checkTxt();
         }
    },
  {   el: 'input[name="registSource"]',
      event: 'click',
      handler: function () {
      if($(this).val()=='2'){
      $('#registSources').attr('style','display:none');
      }else{
      $('#registSources').attr('style','');
      }
      }
 }


        ])
    }

//根据radio的选择展示已选择的内容
function checkTxt(){
       var allChecked='';
       var allCheckedVal='';
       $('input[name="delegateOrg"]:checked').each(function(){
       var name = $(this).next().html();
       var val = $(this).val();
       allChecked+=","+name;
       allCheckedVal+=","+val;
       });
       $('#delegateOrgNamep').html(allChecked.substr(1));
       $('#delegateOrgName').val(allChecked.substr(1));
//       $('#delegateOrg').val(allCheckedVal.substr(1));
}
})