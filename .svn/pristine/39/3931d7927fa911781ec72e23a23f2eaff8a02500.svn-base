require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize','ztree','ztreeCheck'], function (layer, dataTable, util, http, handlebars) {

	init();
	/**
	 * 初始化函数集合
	 */
	function init() {
		ztreeInit();
		bind();
	}
	//树对象
	var treeObj = null;
	//初始化部门显示
	var viewTemplate = handlebars.compile($('#viewTemplate').html());

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
			onClick: function (event, treeId, treeNode) {
				showUser(treeNode);
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
			url: '/common/system/dept/tree/treeData.json',
			success: function (data) {
				debugger;
				if (data.status == 'success') {
					//初始化权限树
					treeObj = $.fn.zTree.init($('#departmentTree'), treeSetting, data.data);
				}
			}
		});
	}


	function showUser(treeNode){
		$("#deptUserDiv").html("");
		http.httpRequest({
			url: '/reg/server/sysuser/listByDeptCode.json',
			data: {deptCode: treeNode.code},
			success: function (data) {
				if(data.length==0) return;
				var myTemplate = handlebars.compile($("#deptUsersTmp").html());
				var object = new Object();
				object.data = data;
				$("#deptUserDiv").html(myTemplate(object));
			}
		});
	}

	function bind() {
		util.bindEvents([
			{
				el: '#departmentClose',
				event: 'click',
				handler: function () {
					layer.close();
				}
			},
			{
				el: '#departmentSubmit',
				event: 'click',
				handler: function () {
					var userIds="";
					$("input[name='userIds']:checkbox:checked").each(function(index,element){
						userIds=userIds+","+$(element).val();
					});
					var priPIDs=$("#priPIDs").val();

					if(userIds==""){
						layer.alert("请先选择部门，然后再勾选人员！");
					}
					http.httpRequest({
						url: '/reg/server/entdbauth/assign',
						data:{userIds:userIds,priPIDs:priPIDs},
						success: function (data) {
							layer.msg(data.msg, {time: 1000}, function () {
								layer.close({reload: true});
							});
						}
					})
				}
			}
		])
	}
})
