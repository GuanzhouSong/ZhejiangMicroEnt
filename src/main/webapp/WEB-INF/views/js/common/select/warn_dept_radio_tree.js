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

	var selectedCode=new Object();

	var treeType = window._CONFIG.treeType;
	if(treeType=="")treeType="radio";
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
			chkStyle: treeType,
			radioType: "all"
		},
		callback: {
			onCheck: function (event, treeId, treeNode) {
				getSelectedDeptCode(treeNode);
			}
		}
	};
	/**
	 * 部门树
	 */
	function ztreeInit() {
		var treeUrl = window._CONFIG.treeUrl;
		var treeType = window._CONFIG.treeType;
		if(treeType=="checkbox"){
			treeUrl+="?isNoCheck=false";
		}else{
			treeUrl+="?isNoCheck=true";
		}
		//加载部门树
		http.httpRequest({
			type: 'post',
			url: treeUrl,
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
					var treeObj = $.fn.zTree.getZTreeObj("departmentTree");
					var nodes = treeObj.getCheckedNodes(true);
					if(selectedCode.deptCode==""||selectedCode.deptCode==undefined){
						alert("请选择部门");
					}
					else{
						var orgNameStr = "";
						var orgCodeStr = "";
						var orgNameStrExcParent = "";
						var orgCodeStrExcParent = "";
						var deptDIDStrExcParent="";
						for (var a = 0; a < nodes.length; a++) {
							orgNameStr += nodes[a].name + ",";
							orgCodeStr += nodes[a].code + ","
							if(nodes[a].code.length>6){
								orgNameStrExcParent += nodes[a].name + ",";
								orgCodeStrExcParent += nodes[a].code + ","
								deptDIDStrExcParent+= nodes[a].id + ","
							}
						}
						if (orgNameStr != "") {
							orgNameStr = orgNameStr.substr(0, orgNameStr.length - 1);
							orgCodeStr = orgCodeStr.substr(0, orgCodeStr.length - 1);

						}
						if ( orgNameStrExcParent != "") {
							orgNameStrExcParent = orgNameStrExcParent.substr(0, orgNameStrExcParent.length - 1);
							orgCodeStrExcParent = orgCodeStrExcParent.substr(0, orgCodeStrExcParent.length - 1);
							deptDIDStrExcParent = deptDIDStrExcParent.substr(0, deptDIDStrExcParent.length - 1);

						}
						var data = new Object();
						data.orgNames = orgNameStr;
						data.orgCodes = orgCodeStr;
						data.orgNamesExcParent = orgNameStrExcParent;
						data.orgCodesExcParent = orgCodeStrExcParent;
						data.deptName = orgNameStrExcParent;
						data.deptCode = orgCodeStrExcParent;

						data.deptId = deptDIDStrExcParent;
						layer.close(data);
					}
				}
			}
		])
	}

})
