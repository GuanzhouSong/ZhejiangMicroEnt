require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery','jquery.serialize',
         'laydate','jquery.validate','tab'], function (layer, dataTable, util, http,handlebars) {

	 var priPID = $('#priPID').val();//查询参数
	 var lictable,checkinfotable,catalogtable,pbcatalogtable,punishtable;
 
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
    
    //预警提示信息
    function yjts_Table(){
    	if(window._CONFIG.entTypeCatg == '50' ){
    		if((pbcatalogtable+'')=='undefined')
      		  initpbcatalogTable();
    	}
    	if(window._CONFIG.entTypeCatg != '50'){
//    		alert((catalogtable+'')=='undefined');
    		if((catalogtable+'')=='undefined')
    	  		  initcatalogTable();
//    		alert((catalogtable+'')=='undefined');
    	}
    	if((punishtable+'')=='undefined')
    		  initpunishTable();	
    }
    
    //许可审批信息
    function initlicTable(){
    	lictable = dataTable.load({
                el: '#licTable',
                showIndex: true,
    			scrollX:true, //支持滚动
        		lengthMenu: [ 5, 10, 20, 50],
                ajax: {
                	url:window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailLic.json',
                	data:function(d){
    	                d.params = {"priPID":priPID};
                    }
                },
                columns: [
                    {data: null, defaultContent:'id',width: '10%',className: 'center'},
                    {data: 'licNO',className: 'center',cut: {length: 10,mark:'...'}},
                    {data: 'licNameCN',className: 'center',cut: {length: 10,mark:'...'}},
                    {data: 'licValFrom',className: 'center'},
                    {data: 'licValTo',className: 'center'},
                    {data: 'licAnth',className: 'center',cut: {length: 10,mark:'...'}},
                    {data: 'licScope',className: 'center',cut: {length: 10,mark:'...'}},
                    {data: 'licState',className: 'center'}
                ],
                columnDefs : [
  							{
  								targets : 7,
  								render : function(data, type, row, meta) {
  									if( row.licState == '1'){
  						        		return "有效";
  									}else if(row.licState == '2'){
  									    return "过期";
  									}else if(row.licState == '3'){
  									    return "被撤销";
  									}else if(row.licState == '4'){
  									    return "被吊销";
  									}else if(row.licState == '5'){
  									    return "被注销";
  									}else{
  										return "";
  									}	
  								}
  							}
    	]
          })
    }
    
    //抽查检查信息
    function initcheckInfoTable(){
    checkinfotable = dataTable.load({
               el: '#checkInfoTable',
               showIndex: true,
   			   scrollX:true, //支持滚动
       		   lengthMenu: [ 5, 10, 20, 50],
               ajax: {
               	url:window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailPubscresult.json',
               	data:function(d){
   	                d.params = {"priPID":priPID};
                   }
               },
               columns: [
                   {data: null,defaultContent:'id', width: '10%',className: 'center'},
                   {data: 'inspectDesc',className: 'center',cut: {length: 20,mark:'...'}},
                   {data: 'scType',className: 'center'},
                   {data: 'inspectDate',className: 'center'},
                   {data: 'scResult',className: 'center',cut: {length: 20,mark:'...'}}
              ],
              columnDefs : [
  							{
  								targets : 2,
  								render : function(data, type, row, meta) {
  									if(row.scType == '抽查历史'){
  										return "抽查";
  									}else{
  										return data;
  									}
  								}
  							},
  							{
  								targets : 4,
  								render : function(data, type, row, meta) {
  				                	var scResults = row.scResult;
  				                	var data2 = row.scType;
  				                	if(data==""||data==null){
  				                		return "";
  				                	}
  				                	if(data2=='检查'){
  				                		return data;
  				                	}
  				                	if(data2=="抽查历史"){
  				                		scResults = scResults.replace('1',"未发现违法行为");
  				                		scResults = scResults.replace('2',"违反工商行政管理相关规定");
  				                		scResults = scResults.replace('3',"违反工商行政管理相关规定");
  				                		scResults = scResults.replace('4',"查无下落");
  				                		scResults = scResults.replace('5',"违反工商行政管理相关规定");
  				                		scResults = scResults.replace('6',"不予配合情节严重");
  				                		scResults = scResults.replace('7',"注销");
  				                		scResults = scResults.replace('8',"被吊销");
  				                		scResults = scResults.replace('9',"被撤销");
  				                		 return scResults;
//  				                		var scResultArr = scResults.split(",");
//  				                    	var showResult = "";
//  				                    	for(var i=0;i<scResultArr.length;i++){
//  				                    		if(parseInt(scResultArr[i]) == 1){
//  				                    			showResult = showResult + '未发现违法行为;';
//  				                    		}else if(parseInt(scResultArr[i]) == 2){
//  				                    			showResult = showResult.replace("违反工商行政管理相关规定；","");
//  				                    			showResult = showResult + '违反工商行政管理相关规定；';
//  				                    		}else if(parseInt(scResultArr[i]) == 3){
//  				                    			showResult = showResult.replace("违反工商行政管理相关规定；","");
//  				                    			showResult = showResult + '违反工商行政管理相关规定；';
//  				                    		}else if(parseInt(scResultArr[i]) == 4){
//  				                    			showResult = showResult + '查无下落;';
//  				                    		}else if(parseInt(scResultArr[i]) == 5){
//  				                    			showResult = showResult.replace("违反工商行政管理相关规定；","");
//  				                    			showResult = showResult + '违反工商行政管理相关规定；';
//  				                    		}else if(parseInt(scResultArr[i]) == 6){
//  				                    			showResult = showResult +  '不予配合情节严重；';
//  				                    		}else if(parseInt(scResultArr[i]) == 7){
//  				                    			showResult = showResult +  '注销；';
//  				                    		}else if(parseInt(scResultArr[i]) == 8){
//  				                    			showResult = showResult +  '被吊销；';
//  				                    		}else if(parseInt(scResultArr[i]) == 9){
//  				                    			showResult = showResult +  '被撤销；';
//  				                    		}
//  				                    	}
//  				                    	return showResult;
  				                	}
  				                	scResults = scResults.replace('10',"被吊销");
  				                	scResults = scResults.replace('11',"被撤销");
  				                	scResults =	 scResults.replace('12',"迁出");
  				                	scResults =	 scResults.replace('1',"未发现问题");
  				                	scResults =	 scResults.replace('2,',"");
  				                	scResults =	 scResults.replace('2',"");
  				                	scResults =	 scResults.replace('3',"违反食品药品管理相关规定");
  				                	scResults =	 scResults.replace('4',"违反质量技术监督相关规定");
  				                	scResults =	 scResults.replace('5',"违反其他部门相关规定");
  				                	scResults =	 scResults.replace('6',"通过登记的住所（经营场所）无法联系");
  				                	scResults =	 scResults.replace('7',"已关闭停业或正在组织清算");
  				                	scResults =	 scResults.replace('8',"不配合检查情节严重");
  				                	scResults =	 scResults.replace('9',"注销");
  				                	scResults =	 scResults.replace('A,',"");
  				                	scResults =	 scResults.replace('A',"");
  				                	scResults =	 scResults.replace('B',"未按规定公示应当公示的信息");
  				                	scResults =	 scResults.replace('C',"公示信息隐瞒真实情况弄虚作假");
  				                	scResults =	 scResults.replace('D',"违反其他工商行政管理规定行为");
  				                	scResults =	 scResults.replace('E',"发现问题经责令已改正");
  				                	scResults =	 scResults.replace('F',"未发现开展本次抽查涉及的经营活动");
  				                	scResults =	 scResults.replace('G',"违反公安部门相关规定");
				                		 return scResults;
  				                	
  				                	
  				                	
  				                	
//  				                	var scResultArr = scResults.split(",");
//  				                	var showResult = "";
//  				                	for(var i=0;i<scResultArr.length;i++){
//  				                		if(parseInt(scResultArr[i]) == 1){
////  				                			showResult = showResult + '未发现违法行为;';
//  				                			showResult = showResult + '未发现问题；';
////  				                		}else if(parseInt(scResultArr[i]) == 2){
////  				                			showResult = showResult + '违反工商行政管理相关规定；';
//  				                		}else if(parseInt(scResultArr[i]) == 3){
//  				                			showResult = showResult + '违反食品药品管理相关规定；';
//  				                		}else if(parseInt(scResultArr[i]) == 4){
//  				                			showResult = showResult + '违反质量技术监督相关规定；';
//  				                		}else if(parseInt(scResultArr[i]) == 5){
//  				                			showResult = showResult + '违反其他部门相关规定；';
//  				                		}else if(parseInt(scResultArr[i]) == 6){
//  				                			showResult = showResult +  '通过登记的住所（经营场所）无法联系；';
////  				                			showResult = showResult +  '查无下落;';
//  				                		}else if(parseInt(scResultArr[i]) == 7){
//  				                			showResult = showResult +  '已关闭停业或正在组织清算；';
//  				                		}else if(parseInt(scResultArr[i]) == 8){
//  				                			showResult = showResult +  '不配合检查情节严重；';
////  				                			showResult = showResult +  '不予配合情节严重;';
//  				                		}else if(parseInt(scResultArr[i]) == 9){
//  				                			showResult = showResult +  '注销；';
//  				                		}else if(parseInt(scResultArr[i]) == 10){
//  				                			showResult = showResult +  '被吊销；';
//  				                		}else if(parseInt(scResultArr[i]) == 11){
//  				                			showResult = showResult +  '被撤销；';
//  				                		}else if(parseInt(scResultArr[i]) == 12){
//  				                			showResult = showResult +  '迁出；';
////  				                		}else if(scResultArr[i] == "A"){
////  				                			showResult = showResult +  '发现问题待后续处理；';
//  				                		}else if(scResultArr[i] == "B"){
//  				                			showResult = showResult +  '未按规定公示应当公示的信息；';
//  				                		}else if(scResultArr[i] == "C"){
//  				                			showResult = showResult +  '公示信息隐瞒真实情况弄虚作假；';
//  				                		}else if(scResultArr[i] == "D"){
//  				                			showResult = showResult +  '违反其他工商行政管理规定行为；';
//  				                		}else if(scResultArr[i] == "E"){
//  				                			showResult = showResult +  '发现问题经责令已改正；';
//  				                		}else if(scResultArr[i] == "F"){
//  				                			showResult = showResult +  '未发现开展本次抽查涉及的经营活动；';
//  				                		}
//  				                	}
//  				                	return showResult;
  								}
  							}
    	]
         })
   }
    
    
    //经营异常信息
    function initcatalogTable(){
    catalogtable = dataTable.load({
               el: '#catalogTable',
               showIndex: true,
   			   scrollX:true, //支持滚动
       		   lengthMenu: [ 5, 10, 20, 50],
               ajax: {
               	url:window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailPubopanomaly.json',
               	data:function(d){
   	                d.params = {"priPID":priPID};
                   },
                type: 'post'
               },
               columns: [
                   {data: null, defaultContent:'id',width: '10%',className: 'center'},
                   {data: 'speCauseCN',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'abnTime',className: 'center'},
                   {data: 'decorgCN',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'remExcpresCN',className: 'center',cut: {length: 15,mark:'...'}},
                   {data: 'remDate',className: 'center'},
                   {data: 'reDecOrgCN',className: 'center',cut: {length: 10,mark:'...'}}
               ],
               columnDefs : [
    							{
      								targets : 2,
      								render : function(data, type, row, meta) {
      									if( row.abnTime == null){
      						        		return "";
      									}else{
      										return row.abnTime;
      									}	
      								}
      							}
        	]
         })
   }
    
    //个体户经营异常信息
    function initpbcatalogTable(){
    pbcatalogtable = dataTable.load({
               el: '#pbcatalogTable',
               showIndex: true,
       		   lengthMenu: [ 5, 10, 20, 50],
   			   scrollX:true, //支持滚动
               ajax: {
               	url:window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailPubpbopanomaly.json',
               	data:function(d){
   	                d.params = {"priPID":priPID};
                   },
                type: 'post'
               },
               columns: [
                   {data: null,defaultContent:'id', width: '10%',className: 'center'},
                   {data: 'excpStaResCN',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'cogDate',className: 'center'},
                   {data: 'decorgCN',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'norReaCN',className: 'center',cut: {length: 15,mark:'...'}},
                   {data: 'norDate',className: 'center'},
                   {data: 'norDecOrgCN',className: 'center',cut: {length: 10,mark:'...'}}
               ],
               columnDefs : [
 							{
   								targets : 2,
   								render : function(data, type, row, meta) {
  									if( row.cogDate == null){
  						        		return "";
  									}else{
  										return row.cogDate;
  									}
   								}
   							}
     	]
         })
    }
    
    //行政处罚信息
    function initpunishTable(){
    punishtable = dataTable.load({
               el: '#punishTable',
               showIndex: true,
   			   scrollX:true, //支持滚动
       		   lengthMenu: [ 5, 10, 20, 50],
               ajax: {
               	url:window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailPunish.json',
               	data:function(d){
   	                d.params = {"priPID":priPID};
                   }
               },
               columns: [
                   {data: null,defaultContent:'id', width: '10%',className: 'center'},
                   {data: 'penDecNo',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'illegActType',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'penContent',className: 'center',cut: {length: 15,mark:'...'}},
                   {data: 'judAuth',className: 'center',cut: {length: 10,mark:'...'}},
                   {data: 'penDecIssDate',className: 'center'},
                   {data: 'auditDate',className: 'center'}
               ],
               columnDefs : [
  							{
    								targets : 6,
    								render : function(data, type, row, meta) {
   									if( row.auditDate == null){
   						        		return "";
   									}else{
   										return row.auditDate;
   									}
    								}
    							}
      	]
         })
   }
    
    
    
    
    function bind() {
        util.bindEvents([
		    {
		  	  el: '#menu2',
		      event: 'click',
		      handler: function () {
		    	  if((lictable+'')=='undefined')
		    		  initlicTable();
		    	  }
		      },
		      {
		    	  el: '#menu3',
		          event: 'click',
		          handler: function () {
		        	  if((checkinfotable+'')=='undefined')
		        		  initcheckInfoTable();
		          }
		      },
		      {
		    	  el: '#menu4',
		          event: 'click',
		          handler: function () {
		        	  yjts_Table();
		          }
		      }
        ])
    }
   

})
