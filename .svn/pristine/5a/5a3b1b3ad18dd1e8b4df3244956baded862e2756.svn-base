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
    var searchParams = {};

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
                url: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/randomlist.json',
                data:function(d){
                    d.params = $.extend({},searchParams,{"relatedUid":$("#groupUid").val(),"groupType":$("#groupType").val()});
                 }
            },
            columns: [
                {data: "_idx", "className": "center",width:'50px'},
                {data: "agentDeptName", "className": "center",width:'140px'}, 
                {data: "agentName", "className": "center",width:'65px'},
                {data: null, "className": "center",width:'55px'},
                {data: null, "className": "center",width:'55px'},
                {data: "agentSex", "className": "center",width:'55px'},
                {data: "agentAge", "className": "center",width:'55px'},
                {data: "deptCatg", "className": "center",width:'130px'},
                {data: "agentExpertFlag", "className": "center",width:'55px'},
                {data: "agentExpertFlag", "className": "center",width:'130px'},
                {data: "agentState", "className": "center",width:'50px'},
                {data: "unitName", "className": "center",width:'120px'},
                {data: "slicenNOName", "className": "center",width:'130px'},
                {data: "unitLevel", "className": "center",width:'55px'},
                {data: null, "className": "center",width:'50px'}
            ],
            columnDefs: [{
            	targets:14,
    	        render:function(data,type,row,meta){
    	           var viewFlag = $("#viewFlag").val();
    	           if(viewFlag != '1'){
    	        	   return "<a class='delete' value='"+row.uid+"' >删除</a>";
    	           }else{
    	        	   return  '-';
    	           }
    	       }
	        },{
            	targets:3,
    	        render:function(data,type,row,meta){
    	           if(row.leaderFlag == '1'){
    	        	   return  "<input type='radio' id='"+row.uid+"' name='leaderFlag' checked='checked'/>";
    	           }
    	           return "<input type='radio' id='"+row.uid+"' name='leaderFlag' />";
    	       }
	        },{
            	targets:4,
    	        render:function(data,type,row,meta){
    	           if(row.expertFlag == '1'){
    	        	   return "<input type='checkbox' class='expertFlag' name='expertFlag' leaderFlag='"+row.leaderFlag+"' uid='"+row.uid+"' agentName='"+row.agentName+"' checked='checked'/>";
    	           }
    	           return "<input type='checkbox' class='expertFlag' name='expertFlag' leaderFlag='"+row.leaderFlag+"' uid='"+row.uid+"' agentName='"+row.agentName+"'/>";
    	       }
	        },{
            	targets:10,
    	        render:function(data,type,row,meta){
    	           if(row.agentState == '1'){
    	        	   return "有效";
    	           }else{
    	        	   return  "<span style='color:red'>无效</span>";
    	           }
    	       }
	        },{
				targets: 5,
			    render: function (data, type, row, meta) {
			    	if(row.agentSex =='1'){
			    		return "男";
			    	}else if(row.agentSex =='2'){
			    		return "女";
			    	}else{
			    		return "";
			    	}
			   }
		    },{
            	targets:13,
    	        render:function(data,type,row,meta){
    	           if(row.unitLevel == '3'){
    	        	   return "省级";
    	           }else if(row.unitLevel == '1'){
    	        	   return  "市级";
    	           }else if(row.unitLevel == '2'){
    	        	   return "县级";
    	           }else if(row.unitLevel == '4'){
    	        	   return "所级";
    	           }else{
    	        	   return "";
    	           }
    	       }
	        },{
				targets: 7,
			    render: function (data, type, row, meta) {
			    	var deptCatg = row.deptCatg;
		    		if(deptCatg == null || deptCatg == "" || deptCatg == "undefined"){
		    			return "";
		    		}else{
		    			var deptCatgArr = deptCatg.split(",");
		    			var html = "";
		    			for(var i=0;i<deptCatgArr.length;i++){
		    				var textV = $("#codePositionTypeList option[value='" + deptCatgArr[i] + "']").text();
		    				if(html == ""){
		    					html = textV;
		    				}else{
		    					html += ","+textV;
		    				}
		    			}
		    			return html;
		    		}
			   }
	        },{
				targets: 8,
			    render: function (data, type, row, meta) {
			    	var expertFlag = row.agentExpertFlag;
			    	if(expertFlag =='N'){
			    		return "否";
			    	}else if(expertFlag !='N'){
			    		if(expertFlag == null || expertFlag == "" || expertFlag == "undefined"){
			    			return "否";
			    		}else{
			    			return "<span style='color:red'>是</span>";
			    		}
			       }
			   }
	        },{
				targets: 9,
			    render: function (data, type, row, meta) {
			    	var expertFlag = row.agentExpertFlag;
			    	if(expertFlag =='N'){
			    		return "";
			    	}else if(expertFlag !='N'){
			    		if(expertFlag == null || expertFlag == "" || expertFlag == "undefined"){
			    			return "";
			    		}else{
			    			var expertFlagArr = expertFlag.split(",");
			    			var html = "";
			    			for(var i=0;i<expertFlagArr.length;i++){
			    				var textV = $("#codeExpertTypeList option[value='" + expertFlagArr[i] + "']").text();
			    				if(html == ""){
			    					html = textV;
			    				}else{
			    					html += ","+textV;
			    				}
			    			}
			    			return html;
			    		}
			       }
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
            	var groupType = $("#groupType").val();
        		layer.dialog({
        			title:"添加检查小组",
        			area:['98%','98%'],
        			content:window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/randomaagent?groupUid='+groupUid+'&groupType='+groupType,
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
            	 var groupType = $("#groupType").val();
                 layer.confirm('是否确认删除该执法人员？', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/delmember',
                        serializable: false,
                        data: {uid : data.uid,groupType:groupType},
                        type: 'post',
                        success: function (data) {
                           layer.msg(data.msg, {time: 1500}, function () {});
                           if(data.status=='success'){
                        	   if(groupType == '3'){
                        		   searchParams.hasDeleteFlag = '1';
                        	   }
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
            			url:  window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/addmemberbatch',
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
