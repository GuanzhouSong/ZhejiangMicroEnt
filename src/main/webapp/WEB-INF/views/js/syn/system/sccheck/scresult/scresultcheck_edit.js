require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    function init() { 
        bind();
    }
    
    function prefixInteger(num, length) {
	  return (num/Math.pow(10,length)).toFixed(length).substr(2);
	}
    
    function save(){
		//检查事项情况
		var flag=true;
		var arr = new Array();
		var arrA = new Array();
		for(var i = 1;i <= 12; i++) {
			var num = "A"+prefixInteger(i,2);
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrA.push(disposeState);
			}
		}
		var arrB = new Array();
		for(var i = 13;i <= 22; i++) {
			var num = "B"+prefixInteger(i-12,2);
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrB.push(disposeState);
			}
		}
		var arrC = new Array();
		for(var i = 23;i <= 36; i++) {
			var num = "C"+prefixInteger(i-22,2);
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrC.push(disposeState);
			}
		}
		var arrOther = new Array();
		for(var i = 1;i <= 1000; i++) {
			var num = "OTHER"+i;
			var disposeState = $("input[name='chk_"+num+"']:checked").val();
			if(disposeState==undefined){
			}else{
				arrOther.push(disposeState);
			}
		}
		arr=arrA.concat(arrB).concat(arrC).concat(arrOther);
		//A01,A02,A03,A04
		for(var i=0;i<arr.length;i++){
			var problem = $.trim($("#problem_"+arr[i]).val());
			var dispose = $.trim($("#dispose_"+arr[i]).val());
			if(problem==""||dispose==""){
				flag=false;
				break;
			}
		}
		
		if(arr.length<=0){
			layer.msg("请至少选择一项检查事项", {time: 2000}, function() {});
		}else{
			var searchParams = $("#taskForm").serializeObject();
	    	http.httpRequest({
				url: '/syn/sccheck/pubscentresult/doCommitCheckTable',
				dataType:"json",  
				contentType : 'application/json',
				data: JSON.stringify(searchParams),
				type:"post",
				success: function (data) {
					layer.msg(data.msg, {time: 1000}, function () {
						if(data.status == 'success'){
							$("#save").hide();
							$("#print").show();
    						$("#save").prop("disabled",true);
						}
					});
				}
			});
		}
    }
    
    function bind() {
    	var num=$("#maxNum").val();
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	$("#print").show();
            	save();
            }
        },{
            el: '#print',
            event: 'click',
            handler: function () {
            	var taskUid = $("#taskUid").val();
            	var priPID = $("#priPID").val();
            	var uid = $("#uid").val();
            	var _id = "_doPrint_"+new Date().getTime();
	            var url = "/syn/sccheck/pubscentresult/checkprint?taskUid="+taskUid+"&priPID="+priPID+"&uid="+uid;
	            try{
	                window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
	            }catch(e){
	                alert("打印错误!");
	            }
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: true});
            }
        },{
            el: '.addOtherSccheckType',
            event: 'click',
            handler: function () {
            	num++;
            	if(num==1){
            		var trHTML = "<tr>"
            			+ "<td class='center'><a class='del'>删除</a></td>"
            			+ "<td>其他:<input type='text' id='checkName_OTHER"+num+"' name='checkName_OTHER"+num+"'></td>"
            			+ "<td class='center'><input style='display:none' checked type='checkbox' value='OTHER"+num+"' name='chk_OTHER"+num+"'></td>"
            			+ "<td></td>"
            			+ "<td></td>"
            			+ "</tr>"
            		 $("#table2").append(trHTML);
            	}else{
            		if($.trim($("#checkName_OTHER"+(num-1)).val())!=""){
            			var trHTML = "<tr>"
            				+ "<td class='center'><a class='del'>删除</a></td>"
            				+ "<td>其他:<input type='text' id='checkName_OTHER"+num+"' name='checkName_OTHER"+num+"'></td>"
            				+ "<td class='center'><input style='display:none' checked type='checkbox' value='OTHER"+num+"' name='chk_OTHER"+num+"'></td>"
            				+ "<td></td>"
            				+ "<td></td>"
            				+ "</tr>"
            				$("#table2").append(trHTML);
            		}else{
            			num--;
            			layer.msg("请先填写其他检查项！", {time: 2000}, function() {});
            		}
            	}
            	
            }
        },{
            el: '.del',
            event: 'click',
            handler: function () {
            	$(this).parent().parent().remove();
            }
        },{
            el: '.addSccheckType',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '添加检查事项',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/pubscagent/scChecktypeSelect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var arr = " ";
                    	$("#table2 input:checkbox").each(function(){
                    		arr = arr+","+$(this).val();
                    	});
                    	if(data){
                    		var msg=""; 
                    		var returncodesArr= data.returncodes.split(","); 
                    		var returnnameArr=data.returnname.split(",");
                    		var pcodesArr=data.pcodes.split(",");
                    		var pnamesArr=data.pnames.split(",");
                    		if(returncodesArr.length>0){
                    			for(var i=0;i<returncodesArr.length;i++){
                    				var tCode=returncodesArr[i];
                    				var tName=returnnameArr[i];
                    				if(arr.indexOf(tCode)>=0){
                    					continue;
                    				}
                    				if(tCode=='A'||tCode=='B'||tCode=='C'){
                    					continue;
                    				}
                    				var trHTML = "<tr>"
                    					+ "<td class='center'><a class='del'>删除</a></td>"
                    					+ "<td>"+tName+"</td>"
                    					+ "<td class='center'>"
	                                	+ "<input style='display:none' type='checkbox' checked class='chk' value="+tCode+" name='chk_"+tCode+"'>"
	                                	+ "</td>"
                    					+ "<td></td>"
                    					+ "<td></td>"
                    					+ "</tr>"
                    					$("#table2").append(trHTML);
                    			}
                    		}   
                    	}
                   }
                })
            }
        }]);
    }
});
