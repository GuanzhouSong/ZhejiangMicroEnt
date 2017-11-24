require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'ztree','ztreeCheck'], function (layer, dataTable, util, http, handlebars) {

	init();
	/**
	 * 初始化函数集合
	 */
	function init() {
		bind();
		ztreeInit();
	}
	//树对象
	var treeObj = null;
	//初始化部门显示
	var viewTemplate = handlebars.compile($('#viewTemplate').html());

	var selectedCode=new Object();

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
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "all"
		},
		callback: {
			//onClick: function (event, treeId, treeNode) {
			//	getSelectedDeptCode(treeNode);
			//},
			onCheck: function (event, treeId, treeNode) {
				getSelectedDeptCode(treeNode);
			}
		}
	};
	/**
	 * 部门树
	 */
	function ztreeInit() {
		//加载部门树
		http.httpRequest({
			type: 'post',
			url: '/reg/server/yr/department/list.json',
			success: function (data) {
				if (data.status == 'success') {
					//初始化权限树
					treeObj = $.fn.zTree.init($('#departmentTree'), treeSetting, data.data);
				}
			}
		});
	}


	function getSelectedDeptCode(treeNode){
		if (treeNode) {
			selectedCode=new Object();
			selectedCode.deptName=treeNode.name;
			selectedCode.deptCode=treeNode.code;
		}
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
				el: '#ok',
				event: 'click',
				handler: function () {
					if(selectedCode.deptCode==""||selectedCode.deptCode==undefined){
						alert("请选择部门");
					}
					else{
						layer.close(selectedCode);
					}
				}
			}
		])
	}

})
