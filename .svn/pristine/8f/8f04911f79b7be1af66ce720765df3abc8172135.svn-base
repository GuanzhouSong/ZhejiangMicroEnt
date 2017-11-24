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
                url:window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/list.json',
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
    	           return "<a class='delete' value='"+row.uid+"' >删除</a>";
    	       }
	        },{
            	targets:3,
    	        render:function(data,type,row,meta){
    	           var isChecked = row.leaderFlag =='1'?'checked':'';
    	           return "<input type='radio' value='"+row.uid+"' name='leaderFlag' "+isChecked+"></input>";
    	       }
	        },{
            	targets:4,
    	        render:function(data,type,row,meta){
    	           var isChecked = row.expertFlag =='1'?'checked':'';
    	           return "<input type='checkbox' value='"+row.uid+"' name='expertFlag' "+isChecked+"></input>";
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
    
    function bind() {
        util.bindEvents([{
            el: '.addGroup',
            event: 'click',
            handler: function () {
        		layer.dialog({
        			title:"添加检查小组",
        			area:['98%','98%'],
        			content:window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/adjustPage',
        			callback:function(data){
        				if(data.reload){
        					table.ajax.reload();
        				}
        			}
        		});
            }
        },{
            el: '.choiseGroup',
            event: 'click',
            handler: function () {
        		layer.dialog({
        			title:"检查小组库",
        			area:['98%','98%'],
        			content:window._CONFIG.chooseUrl+'/server/sccheck/checkgroup/checkgroupPage',
        			callback:function(data){
        				if(data.reload){
        					table.ajax.reload();
        				}
        			}
        		});
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	var tableData = table.row().data();
            	var resultUids = $("#resultUids").val();
            	var expertArry = []; 
            	var leaderArry = [];
            	$("input[name ='expertFlag']:checked").each(function(){
            		expertArry.push($(this).val());
            	})
            	$("input[name ='leaderFlag']:checked").each(function(){
            		leaderArry.push($(this).val());
            	})
            	if(tableData =='undefinde' || tableData ==null){
            		layer.alert("检查小组成员不能为空！");
            		return false;
            	}
                layer.confirm('是否确认提交？', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/commit',
                        serializable: false,
                        data: {uid : resultUids,expertUid:expertArry.toString(),leaderUid:leaderArry.toString()},
                        type: 'post',
                        success: function (data) {
                           layer.msg(data.msg, {time: 1500}, function () {});
                           if(data.status=='success'){
                        	   layer.close({reload:true});
                           }
                        }
                    })
                    layer.close(index);
                });
            }
        },{
        	el: '.delete',
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
                 layer.confirm('是否确认删除该执法人员？', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/delete',
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
        	el: '.deleteAll',
            event: 'click',
            handler: function () {
                 layer.confirm('是否确认删除检查小组所有成员？', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: window._CONFIG.chooseUrl+'/sccheck/pubsgroupmember/deleteAll',
                        serializable: false,
                        data: null,
                        type: 'get',
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
        }]);
    }
});
