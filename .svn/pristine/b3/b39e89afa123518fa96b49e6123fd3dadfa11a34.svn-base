require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','common/validateRules'],
         function (layer, dataTable, util, http,handlebars) {
	var my = window.opener.document;
	init();
    
	function init() {
		$("#copyFormNo").text(my.getElementById('copyFormNo').value);
		$("#copyTypeName").text(my.getElementById('copyTypeName').value);
		$("#copyDate").text(my.getElementById('copyDate').value);
		$("#acceptDeptNames").text(my.getElementById('acceptDepartNames').value);
		$("#copyType").text(my.getElementById('copyTypeName').value);
		$("#illegalItem").text(my.getElementById('illegalItem').value);
		$("#copyInfoFrom").text(copyInfoFromDesc(getRadioValue('copyInfoFrom')));
		
		$("#illegal_table").append(my.getElementById('illegal_table').innerHTML);
		$("#illegalCase").text(my.getElementById('illegalCase').value);
		$("#filelabel").append(my.getElementById('filelabel').innerHTML);
		$("#copyDepartName").text(my.getElementById('copyDepartName').value);
		$("#feedbackNeed").text(feedbackNeedDesc(getRadioValue('feedbackNeed')));
		
		$("#copyDepartPerson").text(my.getElementById('copyDepartPerson').value);
		$("#copyDepartTel").text(my.getElementById('copyDepartTel').value);
		$("#copyDepartFax").text(my.getElementById('copyDepartFax').value);
		$("#copyDepartMail").text(my.getElementById('copyDepartMail').value);
		
		if(my.getElementById('checkPerson')&&my.getElementById('checkPerson').value){
			$("#sh_table").show();
			$("#checkResult").text(checkResultDesc(getRadioValue('checkResult')));
			$("#checkPerson").text(my.getElementById('checkPerson').value);
			$("#checkDate").text(my.getElementById('checkDate').value);
			$("#checkOpinion").text(my.getElementById('checkOpinion').value);	
		}
		if(my.getElementById('feedbackPerson')&&my.getElementById('feedbackPerson').value){
			$("#fk_table").show();
			$("#feedbackPerson").text(my.getElementById('feedbackPerson').value);
			$("#feedback").text(my.getElementById('feedback').value);
		}
		if(my.getElementById('fkopt_table')&&my.getElementById('fkopt_table').innerHTML){
			$("#fkopt_table").show();
			$("#fkopt_table").append(my.getElementById('fkopt_table').innerHTML);
		}
		
    }
	
	function copyInfoFromDesc(e){
		if('jcfx'==e) return '检查发现';
		if('qzjb'==e) return '群众举报';
		if('sjjb'==e) return '上级交办';
		if('qt'==e) return '其他';
		return e;
	}
	
	function checkResultDesc(e){
		if('0'==e) return '同意抄送';
		if('1'==e) return '不抄送';
		if('2'==e) return '退回修改';
		return e;
	}
	
	function feedbackNeedDesc(e){
		if('0'==e) return '是';
		if('1'==e) return '否';
		return e;
	}
	
	function getRadioValue(e){
		if(my.getElementById(e)&&my.getElementById(e).value)
			return my.getElementById(e).value;
		var isAutoSend = my.getElementsByName(e);
        for (var i = 0; i < isAutoSend.length; i++) {
            if (isAutoSend[i].checked == true) {
               return isAutoSend[i].value;
            }
        }
	}
	
    
})
