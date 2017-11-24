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
    
    //许可备案信息
    function initlicTable(){
    	lictable = dataTable.load({
                el: '#licTable',
                showIndex: true,
    			scrollX:true, //支持滚动
        		lengthMenu: [ 5, 10, 20, 50],
                ajax: {
                	url:window._CONFIG.chooseUrl+'/pubdzdtinfo/searchDetailLic.json',
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
               	url:window._CONFIG.chooseUrl+'/pubdzdtinfo/searchDetailPubscresult.json',
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
  									return "抽查";	
  								}
  							},
  							{
  								targets : 4,
  								render : function(data, type, row, meta) {
  									if(row.scResult == '1'){
  										return "正常（符合信息公示相关规定）";
  									}else if(row.scResult == '5'){
  										return "公示信息隐瞒真实情况、弄虚作假";
  									}else if(row.scResult == '9'){
  										return "被撤销登记";
  									}else if(row.scResult == '2'){
  										return "未按规定公示即时信息";
  									}else if(row.scResult == '3'){
  										return "未按规定公示年报信息";
  									}else if(row.scResult == '6'){
  										return "不予配合情节严重";
  									}else if(row.scResult == '4'){
  										return "通过登记的住所（经营场所）无法联系";
  									}else if(row.scResult == '7'){
  										return "已办理营业执照注销";
  									}else if(row.scResult == '8'){
  										return "被吊销营业执照";
  									}else{
  										return "";
  									}
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
               	url:window._CONFIG.chooseUrl+'/pubdzdtinfo/searchDetailPubopanomaly.json',
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
               	url:window._CONFIG.chooseUrl+'/pubdzdtinfo/searchDetailPubpbopanomaly.json',
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
               	url:window._CONFIG.chooseUrl+'/pubdzdtinfo/searchDetailPunish.json',
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
