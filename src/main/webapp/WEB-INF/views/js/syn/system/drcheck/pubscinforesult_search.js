require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    var scStackState={"00":"任务创建中","01":"待抽取对象","02":"实施中","03":"实施中","04":"实施中","05":"实施中","06":"已完成"}
    /**
     * 初始化函数集合
     */
    function init() { 
        bind();
        autoRowSpan(document.getElementById("checkItemTable"), 1, 1);
        initDataTable();
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#resulthis-table',
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:'/syn/server/drcheck/pubscresult/resultlist.json',
                data:function(d){
	               	d.params = $("#resulthis-form").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, "className": "center"},
                {data: "taskCode","className": "center"}, 
                {data: "leaderDeptDesc", "className": "center"}, 
                {data: "inspectDesc", "className": "center"}, 
                {data: null,"className": "center"},
                {data: "scDetail","className": "center"}
            ],
            columnDefs: [{
				targets:4,
				render:function(data,type,row,meta){
					if(row.taskState == '01' || row.taskState == '06'){
						return scStackState[row.taskState];
					}else if(row.taskState == '02' || row.taskState == '03' || row.taskState == '04' || row.taskState == '05'){
						if(row.resultFlag == null || row.resultFlag == "" || row.resultFlag == "undefined" || row.resultFlag == '0'){
							return "待录入结果";
						}else{
							if(row.auditState != null && ( row.auditState == "0" || row.auditState == "1")){
								return "待审核";
							}else{
								if(row.auditState != null && row.auditState == "2"){
									return "审核通过";
								}else if(row.auditState != null && row.auditState == "3"){
									return "审核不通过";
								}else if(row.auditState != null && row.auditState == "5"){
									return "退回修改";
								}
							}
							return scStackState[row.taskState];
						}
					}
				}
			}]
        });
    }
    
  //合并第一列单元格
	function autoRowSpan(tb,row,col){ 
		var lastValue=""; 
		var value=""; 
		var pos=1; 
		for(var i=row;i<tb.rows.length;i++){ 
			value = tb.rows[i].cells[col].innerText; 
			if(lastValue == value){ 
				tb.rows[i].deleteCell(col); 
				tb.rows[i-pos].cells[col].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1; 
				pos++; 
			}else{ 
				lastValue = value; 
				pos=1; 
			} 
		} 
	} 
    
    function bind() {
        util.bindEvents([{
            el: '#tab_ul_li li',
            event: 'click',
            handler: function () {
            	 var flag = $(this).attr("flag");
            	 $("#tab_ul_li li").removeClass("tab-selected");
            	 $(this).addClass("tab-selected");
            	 if(flag == "N"){
            		 $("#itemPanelDivId").hide();
            		 $("#itemPanelOtherDivId").show();
            		 var deptCode = $(this).attr("deptCode");
            		 var deptDesc = $("#checkDesc").val();
            		 var lichooseid = $(this).attr("lichooseid");
            		 $("#checkOrgDesc_other").html(deptDesc);
            		 loadOtherPanel($("#taskNO").val(),lichooseid,deptCode);
            	 }else{
            		 $("#itemPanelDivId").show();
            		 $("#itemPanelOtherDivId").hide();
            	 }
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: false});
            }
        }]);
    }
    
    function loadOtherPanel(taskNO,lichooseid,inspectDept){
    	http.httpRequest({
			url: '/syn/pub/server/drcheck/pubscinfo/detail',
			dataType:"json",  
			contentType : 'application/json;charset=utf-8',
			data: {taskNO:taskNO,deptTaskNO:lichooseid,priPID:$("#priPID").val(),inspectDept:inspectDept},
			type:"get",
			success: function (result) {
				if(result.data){
					var pubScitemResultList = result.data.pubScitemResultList;
					var pubScresultOpinionHisList = result.data.pubScresultOpinionHiList;
					var pubScresult = result.data.pubScresult;
					var pubScdispose = result.data.pubScdispose;
					var agentNames = result.data.agentNames;
					var inspectDateDesc = result.data.inspectDateDesc;
					if(inspectDateDesc != null && inspectDateDesc != "" && inspectDateDesc != "undefined"){
						$("#inspectDate_other").val(inspectDateDesc);
					}else{
						$("#inspectDate_other").val("");
					}
					if(agentNames != null && agentNames != "" && agentNames != "undefined"){
						$("#checkAgent_other").html(agentNames);
					}else{
						$("#checkAgent_other").html("");
					}
					if(pubScresult != null && pubScresult != "" && pubScresult != "undefined"){
						var scResult = pubScresult.scResult;
						if(scResult.length > 1){
							var str = scResult.split(",");
							for(var i = 0;i<str.length;i++){
								$("#scResult_other_"+str[i]).prop("checked",true);
							}
						}else{
							$("#scResult_other_"+scResult).prop("checked",true);
						}
						if(pubScresult.scDetail != null && pubScresult.scDetail != "" && pubScresult.scDetail != "undefined"){
							$("#resultDetail_other").val(pubScresult.scDetail);
						}else{
							$("#resultDetail_other").val("");
						}
						if(pubScresult.remark != null && pubScresult.remark != "" && pubScresult.remark != "undefined"){
							$("#remark_other").val(pubScresult.remark);
						}else{
							$("#remark_other").val("");
						}
						if(pubScresult.setUserName != null && pubScresult.setUserName != "" && pubScresult.setUserName != "undefined"){
							$("#setOtherName").html(pubScresult.setUserName);
						}else{
							$("#setOtherName").html("");
						}
						if(pubScresult.setTime != null && pubScresult.setTime != "" && pubScresult.setTime != "undefined"){
							$("#setOtherTime").html(pubScresult.setTime);
						}else{
							$("#setOtherTime").html("");
						}
						if(pubScresult.auditState != null && pubScresult.auditState == "2"){
							$("#auditStateDiv_other2").prop("checked",true);
						}else{
							$("#auditStateDiv_other2").prop("checked",false);
						}
						if(pubScresult.auditState != null && pubScresult.auditState == "3"){
							$("#auditStateDiv_other3").prop("checked",true);
						}else{
							$("#auditStateDiv_other3").prop("checked",false);
						}
						if(pubScresult.auditName != null && pubScresult.auditName != "" && pubScresult.auditName != "undefined"){
							$("#auditNameOther").html(pubScresult.auditName);
						}else{
							$("#auditNameOther").html("");
						}
						if(pubScresult.auditDate != null && pubScresult.auditDate != "" && pubScresult.auditDate != "undefined"){
							$("#auditDateOther").html(pubScresult.auditDate);
						}else{
							$("#auditDateOther").html("");
						}
						if(pubScresult.auditOpin != null && pubScresult.auditOpin != "" && pubScresult.auditOpin != "undefined"){
							$("#auditOpin_other").val(pubScresult.auditOpin);
						}else{
							$("#auditOpin_other").val("");
						}
					}else{
						$(".scResult_other").each(function(){
							$(this).prop("checked",false);
						});
						$("#resultDetail_other").val("");
						$("#remark_other").val("");
						$("#setOtherName").html("");
						$("#setOtherTime").html("");
						$("#auditStateDiv_other2").prop("checked",false);
						$("#auditStateDiv_other3").prop("checked",false);
						$("#auditNameOther").html("");
						$("#auditDateOther").html("");
					}
					if(pubScdispose != null && pubScdispose != "" && pubScdispose != "undefined"){
						var scDisposeResult = pubScdispose.scResult;
						if(scDisposeResult.length > 1){
							var str = scDisposeResult.split(",");
							for(var i = 0;i<str.length;i++){
								$("#scdispose_other_"+str[i]).prop("checked",true);
							}
						}else{
							$("#scdispose_other_"+scDisposeResult).prop("checked",true);
						}
						$("#disposeDetail_other").val(pubScdispose.scDetail);
					}else{
						$(".scdispose_other").each(function(){
							$(this).prop("checked",false);
						});
						$("#disposeDetail_other").val("");
					}
					if(pubScitemResultList != null && pubScitemResultList.length >0){
						var html = "";
						for(var i = 0;i<pubScitemResultList.length;i++){
							var scName = pubScitemResultList[i].scName;
							var itemName = pubScitemResultList[i].itemName;
							var sameFlag = pubScitemResultList[i].sameFlag;
							var pubFlag = pubScitemResultList[i].pubFlag;
							var itemscResult = pubScitemResultList[i].scResult;
							if(itemscResult == null || itemscResult == "" || itemscResult == "undefined"){
								itemscResult = "";
							}
							var sameHtml = '';
							if(sameFlag == "1"){
								sameHtml = 'checked="checked"';
							}
							var pubHtml = '';
							if(pubFlag == "1"){
								pubHtml = 'checked="checked"';
							}
							html += '<tr><td>'+(i+1)+'</td><td class="left pd3">'+scName+'</td><td class="center pd3">'+itemName+'</td>'
							+'<td class="pd3"><div class="ipt-box"><input type="checkbox" '+sameHtml+' disabled="disabled"/>是否一致 <input type="checkbox" '+pubHtml+' disabled="disabled"/>是否公示&nbsp;<input type="text" class="ipt-txt" style="width:170px" value="'+itemscResult+'" disabled="disabled"/></div></td></tr>';
						}
						$("#checkItemOtherTbody").empty().append(html);
					}
					//历史审核意见
					if(pubScresultOpinionHisList != null && pubScresultOpinionHisList.length >0){
						var opinionHtml = "";
						for(var i = 0;i<pubScresultOpinionHisList.length;i++){
							var auditFlag = pubScresultOpinionHisList[i].auditFlag;
							if(auditFlag == '2'){auditFlag = '通过';}
							if(auditFlag == '3'){auditFlag = '不通过';}
							if(auditFlag == '5'){auditFlag = '退回修改';}
							var auditOpin = pubScresultOpinionHisList[i].auditOpin;
							var auditUserName = pubScresultOpinionHisList[i].auditUserName;
							var auditDate = pubScresultOpinionHisList[i].auditDate;
							opinionHtml +='<tr><td class="center">'+(i+1)+'</td><td class="center">'+auditFlag+'</td><td class="center">'+auditOpin+'</td>'
							+'<td class="center">'+auditUserName+'</td><td class="center">'+auditDate+'</td></tr>'
						}
						$("#pubOpinionHisList").empty().append(opinionHtml);
					}else{
						$("#pubOpinionHisList").empty().append('<tr><td colspan="5" class="center">暂无历史意见</td></tr>');
					}
					autoRowSpan(document.getElementById("checkItemOtherTable"), 1, 1);
				}
			}
		});
    }
});
