require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

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
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            scrollX:true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/party/member/selectMembersByPartyOrgID.json',
                data:function(d){
	               		 d.params = $("#qryForm").serializeObject();
                }
            },
            columns: [
                {data: '_idx', 'className': 'center',},
                {data: null, 'className': 'center'},
                {data: 'memberName', 'className': 'center'}
            ],
            columnDefs: [
			 {
				targets: 1,
			    render: function (data, type, row, meta) {
			    	return '<input type="checkbox" class="check" memberName="'+row.memberName+'" value="'+row.uid+'">';
			   }
		    }]})
   }

   

    function bind() {
        util.bindEvents([{
	        	el: '#checkall',
	            event: 'click',
	            handler: function () { 
	            	if($(this).prop("checked")){
	            		$(".check").prop("checked",true);
	            	}else{
	            		$(".check").prop("checked",false);
	            	}
	            }
	        },{
	        	el: '#ok',
	            event: 'click',
	            handler: function () {
	            	var operateType = $("#operateType").val(); //单选 1   多选2
	                var uids = new Array();
	                var index = 0;
	            	var memberNames = new Array();
	            	var memberindex = 0;
	            	$(".check").each(function(){
	            		if($(this).prop("checked")){
	            			uids[index++] = $(this).val();
	            			memberNames[memberindex++] = $(this).attr("memberName");	
//	            			if(uids == ''){
//	            				uids = $(this).val();
//	            				memberNames = $(this).attr("memberName");
//	            			}else{
//	            				uids += ","+$(this).val();
//	            				memberNames = ","+$(this).attr("memberName");
//	            			}
	            		}
	            	});
	            	if(uids.length == 0){
	            		layer.msg("请先选择一条记录", {time: 2000}, function() {});
	            		return false;
	            	}else if(operateType == '1' && uids.length != 1){
	            		layer.msg("发起人有且只能有一个", {time: 2000}, function() {});
	            		return false;
	            	}else{
	            		var data = new Object();
	            		data.uids = uids.toString();
	            		data.memberNames = memberNames.toString();
	            		data.num = uids.length;
	                    layer.close(data);
	            	}	
	            }
	        },{
	        	el: '#close',
	            event: 'click',
	            handler: function () { 
            		layer.close({reload:false});
	            }
	        }])
    }

})
