require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','common/validateRules'],
         function (layer, dataTable, util, http,handlebars) {
	
	init();
    
	function init() {
		
		$('#markName').val(window.opener.document.getElementById('markName').value);
		$('#markClass').val(markClassFom(window.opener.document.getElementById('markClass').value));
		$('#markStartDate').val(window.opener.document.getElementById('markStartDate').value);
		$('#markEndDate').val(window.opener.document.getElementById('markEndDate').value);
		$('#markContent').val(window.opener.document.getElementById('markContent').value);
		$('#markUseArea').val(window.opener.document.getElementById('markUseArea').value);
		
		$('#markState').val(markStateFom(window.opener.document.getElementById('markState').value));
		$('#markUseArea').val(window.opener.document.getElementById('markUseArea').value);
		$('#markAppointWay').val(markAppointWayFom(window.opener.document.getElementById('markAppointWay').value));
		$('#markSetDept').val(window.opener.document.getElementById('markSetDept').value);
		$('#markAppointDept').val(window.opener.document.getElementById('markAppointDept').value);
		
		
		$('#markSetDate').val(window.opener.document.getElementById('markSetDate').value);
		$('#setDeptContact').val(window.opener.document.getElementById('setDeptContact').value);
		$('#tel').val(window.opener.document.getElementById('tel').value);
		$('#fax').val(window.opener.document.getElementById('fax').value);
		$('#email').val(window.opener.document.getElementById('email').value);
		
		
    }
	
	function markClassFom(e){
		if(e == null || e == '') return ''; 
		if('0'==e) return '关注';
		if('1'==e) return '警示';
		if('2'==e) return '限制';
	}
	
	function markStateFom(e){
		if(e == null || e == '') return ''; 
		if('0'==e) return '无效';
		if('1'==e) return '有效';
	}
	
	function markAppointWayFom(e){
		if(e == null || e == '') return ''; 
		if('0'==e) return '对内提示';
		if('1'==e) return '部门共享';
		if('2'==e) return '公开发布';
	}
	
    
})
