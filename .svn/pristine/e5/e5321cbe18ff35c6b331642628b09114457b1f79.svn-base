require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars',
        'jquery.validate', 'jquery.serialize', 'laydate', 'ztree', 'ztreeCheck'],
    function(layer, dataTable, util, http, handlebars) {

	var _sysUrl=window._CONFIG._sysUrl;
    var _node = null;
    //部门树对象
    var treeObj = null;
    //树数据
    var zNodes = [];
	
    /**
     * 异步加载子节点时触发这个过滤器<br/>
     * 这个过滤器的目的是，根据父节点是否选中，来给子节点相应地设置是否选中属性
     * @param treeId
     * @param parentNode
     * @param responseData
     * @returns {*}
     */
    function ajaxDataFilter(treeId, parentNode, responseData) {
        if (responseData) {
            if(parentNode&&parentNode.checked){
                for(var i =0; i < responseData.length; i++) {
                    responseData[i].checked = true;
                }
            }
        }
        return responseData;
    }
	
	
        init();
        /**
         * 初始化函数集合
         */

        function init() {
        	loadTree();
            bind();
            //initShow();
        }

        /**
         *户口建档页面 初始化管辖人员显示
         */
        function initShow() {
            if (_sliceMan.length < 1) return;

            var man = _sliceMan.split(",");
            var tel = _sliceTel.split(",");
            var show = '';
            for (var i = 0; i < man.length; i++) {
                show += ';' + man[i] + '  电话：' + tel[i];
            }
            $('#sliceManp').html(show.substr(1)); 
        } 

        //加载部门树
        function loadTree() {
            var treeUrl ="/common/system/sysdepart/treeWithAllDept?isNoCheck=";
            //部门树配置
            var setting = {
                async: {
                    enable: true,
                    url: treeUrl + '&t=' + new Date().getTime(),
                    autoParam: ["orgCoding=porgCoding"],
                    dataFilter: ajaxDataFilter
                },
                check: {
                    enable: false,
                    chkStyle: "checkbox",
                    autoCheckTrigger: true,
                    radioType: "level"
                },
                data: {
                    key: {
                        name: "orgName",
                        title: "orgName"
                    },
                    simpleData: {
                        enable: true,
                        idKey: "orgCoding",
                        pIdKey: "porgCoding"

                    }
                },
                callback: {
                	onClick: function (event, treeId, treeNode) {
                        httpClick(treeNode);
                    }
                }
            };
            treeObj = $.fn.zTree.init($("#permisionTree"), setting, zNodes);
        }
        
        

        //部门树节点点击事件
        function zTreeOnMouseUp(event, treeId, treeNode) {
            $("#success").slideUp();
            _node = {
                parentNode: treeNode.getParentNode(treeNode),
                treeNode: treeNode,
                treeId: treeId
            };
        }

        //部门树展开时事件
        function beforeExpand(treeId, treeNode) {
            if (!treeNode.isAjaxing) {
                treeNode.times = 1;
                if(treeNode.children==null){//如果部门节点下存在数据，则不进行异步加载
                    ajaxGetNodes(treeNode, "refresh");
                }
                return true;
            } else {
                layer.msg("zTree 正在下载数据中，请稍后展开节点。。。", {ltype: 0, time: 2000});
                return false;
            }
        }

        //异步加载树节点
        function ajaxGetNodes(treeNode, reloadType) {
            var zTree = $.fn.zTree.getZTreeObj("permisionTree");
            if (reloadType == "refresh") {
                zTree.updateNode(treeNode,true);
            }
            zTree.reAsyncChildNodes(treeNode, reloadType, true);
        }

        //根据点击树的node，加载下面的数据
        function httpClick(treeNode) {
             
            if(treeNode.isParent==false){
            	 http.httpRequest({
                     url: _sysUrl+'/sysuserareamanage/getsliceManByDept',
                     data: {
                         deptCode: treeNode.orgCoding
                     },
                     success: function(data) {
                    	 
                         var liData = data.data;
                         var lis = ''; 
                         var sliceMan_ = $('#allCheckedVal').val().split(',');
                         if (liData == null) return; 
                         for (var i = 0; i < liData.length; i++) {
                             /*var check = '';
                             for (var j = 0; j < sliceMan_.length; j++){
                                 if (sliceMan_[j] == liData[i].realName) {check = 'checked';
                                     break;
                                 }

                             }*/
                        	 
                        	 if(liData[i].status=="1"){
                        		    var name = '';
                                    if (liData[i].realName != null) name = liData[i].realName; 
                                    lis += '<label><input type="checkbox" class="codesliceno"  value="' + liData[i].id + '"><span class="name">' + name + '</span></input></label></br>';
                              }
                          }
                         $('#optionlist').html(lis);
                     }
                 });
            }
        }

 
         

        function bind() {
            util.bindEvents([{
                el: '#cancel',
                event: 'click',
                handler: function() {
                    layer.close();
                }
            },
                {
                    el: '#checkAll',
                    event: 'click',
                    handler: function() {
                        var flag = $(this).prop("checked");
                        $(".codesliceno").prop("checked", flag);
                        checkTxt();
                    }
                },
                {
                    el: '.codesliceno',
                    event: 'click',
                    handler: function() {
                        checkTxt();
                    }
                },
                {
                    el: '#save',
                    event: 'click',
                    handler: function() {
                         var allCheckedVal=$("#allCheckedVal").val();
                         if(allCheckedVal==null||allCheckedVal==""){
                        	 layer.msg("请选择人员", {ltype: 0,time:2000});
                         }else{
                    		http.httpRequest({
                                url: _sysUrl+'/sysuserareamanage/saveSysUserAreaManage',
                                serializable: false,
                                data: {"uid":$("#uid").val(),"allCheckedVal":$("#allCheckedVal").val()},
                                type: 'get',
            	                success: function (data) { 
            	                	
            	                	layer.close(data);
                                }
                            });
                         }
                    }
                },
                {
                    el: '#qry',
                    event: 'click',
                    handler: function() {
                        var _key = $('#_key').val(); 
                        util.searchNode($('#_key').val(),"name",treeObj,layer);
                    }
                }

            ])
        }

        //根据checkbox的值展示已选择的内容
        function checkTxt() {
            var allChecked = '';
            var allCheckedVal = '';
            var manTelForShow = '';
            $('.codesliceno:checked').each(function() {
                var sliceMan = $(this).next().html();
                allCheckedVal+=","+this.value;
                allChecked += "," + sliceMan;
                manTelForShow += ';' + sliceMan;
            });
            $('#sliceManp').html(manTelForShow.substr(1));
            $('#allCheckedVal').val(allCheckedVal.substr(1));
        }
    })