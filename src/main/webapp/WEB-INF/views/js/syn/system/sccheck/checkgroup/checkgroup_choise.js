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
                {data: 'memberNum'},
                {data: 'showFiled'},
                {data: 'teamLeader',cut: {length: 20,mark:'...'}},
                {data: 'expertNames',cut: {length: 20,mark:'...'}},
                {data: 'setUserName'},
                {data: 'setTime'},
                {data: 'setDeptCode'}
            ],
            columnDefs : [{
				targets : 1,
				render : function(data, type, row, meta) {
					return "<input type='radio' name='choiceUid' groupUid="+row.uid+" class='check' />";
				}
			},{
				targets : 8,
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
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload:false});
            }
        },{
            el: '#commit',
            event: 'click',
            handler: function () {
            	 var groupUids;
            	 var groupArry = new Array(); 
            	 
            	 if($(".check:checked").length == 0){
            		 alert("前先选择一项！");
            		 return false;
            	 } 
            	 
            	 $.each($('.check'),function(i,item){
            		 if($(this).prop('checked')){
            			 groupArry.push($(this).attr('groupUid'));
            		 }
            	 })
            	 groupUids = groupArry.toString();
        		 http.httpRequest({
                     url: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/choiceData',
                     data:{groupUids : groupUids},
                     serializable: false,
                     type: 'get',
                     success: function (data) {
                         if(data.status=='success'){
                        	 layer.msg(data.msg, {time: 1000}, function () {
                        		 layer.close({reload:true});
                        	 })
                         }
                     }
                 });
             }
        }])
    }

})
