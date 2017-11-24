require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
	
    /**
	 * 初始化函数集合
	 */
    function init() {
		initDataTable();
    	bind();
    }
    
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#scgroupTable',
            showIndex: true,
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/randomlist.json',
            },
            columns: [
                {data: "_idx", "className": "center"},
                {data: "agentDeptName", "className": "center"}, 
                {data: "agentName", "className": "center"},
                {data: null, "className": "center"},
                {data: null, "className": "center"},
                {data: null, "className": "center"}
            ],
            columnDefs: [{
            	targets:5,
    	        render:function(data,type,row,meta){
    	           return "<a class='delete' value='"+row.uid+"' >删除</a>";
    	       }
	        },{
            	targets:3,
    	        render:function(data,type,row,meta){
    	           return "<input type='radio' id='"+row.uid+"' name='leaderFlag' />";
    	       }
	        },{
            	targets:4,
    	        render:function(data,type,row,meta){
    	           return "<input type='checkbox' class='expertFlag' name='expertFlag' leaderFlag='"+row.leaderFlag+"' uid='"+row.uid+"' agentName='"+row.agentName+"'/>";
    	       }
	        }]
        });
    }
    
    function initPubScGroupMember(uid, leaderFlag, expertFlag,agentName){
    	 this.uid=uid;
   	  	 this.leaderFlag=leaderFlag;
   	  	 this.expertFlag=expertFlag;
   	  	 this.agentName=agentName;
    }
    
    function bind() {
        util.bindEvents([{
            el: '.addGroup',
            event: 'click',
            handler: function () {
            	var groupUid = $("#groupUid").val();
        		layer.dialog({
        			title:"添加检查小组",
        			area:['98%','98%'],
        			content:window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/randomaagent?groupUid='+groupUid,
        			callback:function(data){
        				if(data.reload){
        					table.ajax.reload();
        				}
        			}
        		});
            }
        },{
        	el: '.delete',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
                 layer.confirm('是否确认删除该执法人员？', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/delmember',
                        serializable: false,
                        data: {uid : data.uid},
                        type: 'post',
                        success: function (data) {
                           layer.msg(data.msg, {time: 1500}, function () {});
                           if(data.status=='success'){
                        	   table.ajax.reload();
                           }
                        }
                    })
                    layer.close(index);
                });
            }
        },{
        	el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
        	el: '#save',
            event: 'click',
            handler: function () {
            	var groupUid = $("#groupUid").val();
            	var pubScGroupMemberList = new Array();
            	var count = 0;
            	$(".expertFlag").each(function(){
            		count ++;
            		var uid = $(this).attr("uid");
            		var agentName = $(this).attr("agentName");
            		var leaderFlag = "0";
            		var expertFlag = "0";
            		if($(this).prop("checked")){
            			expertFlag = "1";
            		}
            		if($("#"+uid).prop("checked")){
            			leaderFlag = "1";
            		}
            		var pubScGroupMember = new initPubScGroupMember(uid, leaderFlag, expertFlag,agentName);
            		pubScGroupMemberList.push(pubScGroupMember);
            	});
            	if(count < 2){
            		layer.msg("请添加两个以上小组成员", {time: 1000}, function () {});
            		return false;
            	}
           	 	var pubScGroupMemberDto={};
           	 	pubScGroupMemberDto.groupUid = groupUid;
           	 	pubScGroupMemberDto.pubScGroupMemberList = pubScGroupMemberList;
            	layer.confirm('确定要添加小组吗？', {icon: 2, title: '提示'}, function (index) {
            		http.httpRequest({
            			url:  window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/addmemberbatch',
            			dataType:"json",  
            			contentType : 'application/json;charset=utf-8',
            			data: JSON.stringify(pubScGroupMemberDto),
            			type:"post",
            			success: function (data) {
            				layer.msg(data.msg, {time: 1000}, function () {
            					if(data.status == 'success'){
            						layer.close({reload: true});
            					}
            				});
            			}
            		});
                    layer.close(index);
                });
            }
        }]);
    }
});
