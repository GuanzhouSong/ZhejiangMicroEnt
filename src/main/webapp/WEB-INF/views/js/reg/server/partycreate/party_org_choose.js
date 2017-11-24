require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','laydate','handlebars', 'layer1', 'ztree'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	ztreeInit();
        bind();
    }

    var table;
        
    // 部门树对象
    var treeObj = null;
    // 当前部门
    var dept = null ;
    // 管辖单位编码
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
                $(".bmgl").html("" + treeNode.name);
                $(".col-xs-9").show();
                id = treeNode.id;
                table.ajax.reload();
            }
        }
    };
  
    /**
     * 初始化权限树
     */
    function ztreeInit() {
        http.httpRequest({
            type: 'post',
            url: '/commom/server/regunit/chooseOrg',
            success: function (data) {
                if (data.status == 'success') {
                    treeObj = $.fn.zTree.init($('#ztree'), treeSetting, data.data);
                    treeObj.expandNode(treeObj.getNodes()[0], true, false, true);
                    $(".col-xs-9").show();
                    initDataTable();
                }
            }
        });
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {   		
    	table = dataTable.load({
            el: '#user-table', 
            showIndex: false,
			scrollX:true,
            ajax: {
                url:'/reg/server/party/organize/list.json',
                data:function(d){
                	if(clickFlag){
                		 d.params = {"localAdm":id};
                	}else{
                		 d.params = {"queryAll":"true","partyOrgName":$(".tree-box-searcher").val()};
                	}
                }
            },
            columns: [
                {data: null,defaultContent:'uid', width: "50px", className: 'center'},
                {data: 'partyOrgName', width: "80px",cut: {length: 15,mark:'...'}},
                {data: 'localAdmName', width: "80px",cut: {length: 15,mark:'...'}}
            ],
            columnDefs: [{
         					targets:0,
         					render:function(data,type,row,meta){
                                return "<input value='"+row.partyOrgName+"' orgCode='"+row.uid+"' class='chb choosed' type='radio' />";
         				}
         		  }]
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
            el: '.choosed',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		var data = new Object();
            		data.orgCode = $(this).attr("orgCode").toString();
            		data.orgName = $(this).val().toString();
            		data.returnCode = "success";
            		layer.close(data);
            	}
            }
        },{
            el: '#tree-box-searcher',
            event: 'click',
            handler: function () {
            	clickFlag = false;
            	table.ajax.reload();
            }
        }])
    }

})
