require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var searchParams={};
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
        bind();
    }
  
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100],
            ajax: {
                url: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx'},
                {data: null},
                {data: null},
                {data: 'memberNum'},
                {data: 'showFiled'},
                {data: 'teamLeader',cut: {length: 20,mark:'...'}},
                {data: 'expertNames',cut: {length: 20,mark:'...'}},
                {data: 'setUserName'},
                {data: 'setTime'},
                {data: 'setDeptCode'}
            ],
            columnDefs : [{
				targets : 2,
				render : function(data, type, row, meta) {
					return "<a class='commit view' groupUid="+row.uid+">详情</a>";
				}
			},{
				targets : 1,
				render : function(data, type, row, meta) {
					return "<input type='checkbox' groupUid="+row.uid+" class='check' />";
				}
			},{
				targets : 9,
				render : function(data, type, row, meta) {
					return $("#sysDept").val();
				}
			}]
        })
    }
    
    
    
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function () {
            	searchParams = $("#taskForm").serializeObject();
        		table.ajax.reload();
            }
        },{
            el: '#modifyNewGrouop',
            event: 'click',
            handler: function () {
            	var groupUid;
	           	var groupArry = new Array(); 
	           	
	           	if($(".check:checked").length != 1){
	           		 alert("请选择一项进行修改！");
	           		 return false;
	           	 } 
	           	$.each($('.check'),function(i,item){
	           		 if($(this).prop('checked')){
	           			 groupArry.push($(this).attr('groupUid'));
	           		 }
	           	 })
	           	groupUid = groupArry.toString();
                layer.dialog({
                	title: '查看',
                	area: ['88%', '62%'],
                    content: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/groupedit?groupUid='+groupUid,
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var groupUid = $(this).attr("groupUid");
                layer.dialog({
                	title: '查看',
                	area: ['88%', '62%'],
                    content: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/groupedit?groupUid='+groupUid+'&viewFlag=1',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#selectAll',
            event: 'click',
            handler: function () {
            	if($(this).prop("checked")){
            		$('.check').prop("checked",true);
            	}else{
            		$('.check').prop("checked",false);
            	}
            }
        },{
            el: '#addNewGrouop',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '添加检查小组成员',
                    area: ['88%', '62%'],
                    content: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/groupadd',
                    callback: function (data) {
                    	if(data.reload){
                    		table.ajax.reload();
                    	}
                    }
                });
            }
        },{
            el: '#deleteNewGrouop',
            event: 'click',
            handler: function () {
            	 var groupUids;
            	 var groupArry = new Array(); 
            	 
            	 if($(".check:checked").length == 0){
            		 alert("请至少选中一项！");
            		 return false;
            	 } 
            	 
            	 $.each($('.check'),function(i,item){
            		 if($(this).prop('checked')){
            			 groupArry.push($(this).attr('groupUid'));
            		 }
            	 })
            	 groupUids = groupArry.toString();
	        	 layer.confirm('确定要删除选中的检查小组吗？', {icon: 2, title: '提示'}, function (index) {
	        		 http.httpRequest({
                         url: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/delete',
                         data:{groupUids : groupUids},
                         serializable: false,
                         type: 'get',
                         success: function (data) {
                             if(data.status=='success'){
                            	 layer.msg(data.msg, {time: 1000}, function () {
                            		 table.ajax.reload(); 
                            	 })
                             }
                         }
                     });
	        		 layer.close(index);
	             });
             }
        }])
    }

})
