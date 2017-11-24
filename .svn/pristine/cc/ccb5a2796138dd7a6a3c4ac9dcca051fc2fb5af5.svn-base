require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	var params=$("#entSearchForm").serializeObject();//查询参数声明!
	var initFlag = '1';
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
//    	initDataTable();
        bind();
    }
    
    $("#limitTypeM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#freeStateM").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
	function initDataTable() {
		initFlag = '0';
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : window._CONFIG.chooseUrl+'/server/other/blacklist/rightbackList',
			data : function(d) {
				d.params = params;
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data : 'clientName', className: 'center'},
		    {data : 'certTypeName', className: 'center'},
		    {data : 'certNO', className: 'left'},
		    {data : 'limitTypeName', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : null, className: 'center'},
		    {data : 'limitReason', className: 'center',cut:{length:"20",mark:"..."}},
		    {data : 'limitNO', className: 'center'},
		    {data : 'limitDepartName', className: 'center'},
		    {data : 'limitDateStart', className: 'center'},
		    {data : 'limitDateEnd', className: 'center'},
		    {data : null, className: 'center'},
		    {data : null, className: 'center'},
		    {data : null, className: 'center'}
		],
		columnDefs : [{
		       	 targets:1,
		    	 render:function (data, type, row, meta) {
		    		 return "<a href='javascript:void(0)' class='mr10 look' uid='"+row.uid+"'>"+ row.clientName+"</a>";
		    	 }
		    	  
		      },{
		       	 targets:3,
		    	 render:function (data, type, row, meta) {
		    		 if(row.certNO != "" && row.certNO != null && row.certNO != "undefined"){
		    			 var certNO = row.certNO;
		    			 if(certNO.length > 4){
		    				 var certNO = certNO.substring(0,certNO.length-4)+"****";
		    				 return certNO;
		    			 }
		    		 }
		    	 }
		      },{
		       	 targets:5,
		    	 render:function (data, type, row, meta) {
		    		 if(row.entName == "" || row.entName == null || row.entName == "undefined"){
		    			 return '-';
		    		 }else{
		    			 return row.entName;
		    		 }
		    	 }
		      },{
				targets:6,
				render:function(data,type,row,meta){
					if(row.uniscid){
						return row.uniscid;
					}else if(row.regNO){
						return row.regNO;
					}else{
						return '-';
					}
				}
			 },{
				targets:12,
				render:function(data,type,row,meta){
					if(row.limitDateEnd){
						 var sysdate=$("#sysdate").val();  
						 var limitDateEnd=row.limitDateEnd;  
						 if(sysdate!=""&&limitDateEnd!=""){  
							 var d1 = new Date(sysdate.replace(/\-/g, "\/"));  
							 var d2 = new Date(limitDateEnd.replace(/\-/g, "\/"));  
							 if(d1 > d2){
								 return "已解除";
							 }else{
								 return "未解除"
							 }
						 }
					}
					if(row.limitType == "1" ){
						 return "未解除";
					}
					return '';
				}
			 },{
				targets:13,
				render:function(data,type,row,meta){
					return '';
				}
			 },{
				targets:14,
				render:function(data,type,row,meta){
					return '';
				}
			 }]
	  });
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '#search',
            event: 'click',
            handler: function () {
        		var limitType = $("#limitTypeM").val();
        		$("#limitType").val(limitType);
        		
        		var freeState = $("#freeStateM").val();
        		$("#freeState").val(freeState);
        		
        		params = $("#entSearchForm").serializeObject();
        		if(initFlag=="1"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        },{
        	el:'#cancle',
        	event:'click',
        	handler:function(){
        		$("#limitType").val("");
        		$('#limitTypeM').multipleSelect('setSelects',['']);
        		$("#freeState").val("");
            	$('#freeStateM').multipleSelect('setSelects',['1']);
        		$("#activeDep").val("");
        		$("#freeDep").val("");
        	}
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var uid = $(this).attr("uid");
            	if(uid!=null && uid != ''){
            		layer.dialog({
                        title: '详情',
                        area: ['100%', '100%'],
                        content:window._CONFIG.chooseUrl+'/server/other/blacklist/detail?uid='+uid,
                        callback: function (data) {
                        	 
                            //重新加载列表数据
                            if (data.reload) { 
                            	 table.ajax.reload();  
                            }
                        }
                    })
            	}
            }
        },{
            el: '.js-more-query',
            event: 'click',
            handler: function () {
            	if($('.more-show').css("display")=="none"){
            		$('.js-more-query').attr('value','收起');
            		$('.more-show').css("display","block");
            	}else{
            		$('.js-more-query').attr('value','更多查询');
            		$('.more-show').css("display","none");
            	}
            }
        },{
            el: '#chooseFreeDepName',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '选择组织部门',
                    area: ['328px', '600px'],
                    content: '/syn/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	if (data) { 
                           	$("#freeDep").val(data.orgCodesExcParent);
                           	$("#freeDepName").val(data.orgNamesExcParent);
                    	}
                    }
            	});
            }
        },{
            el: '#chooseActiveDep',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '选择组织部门',
                    area: ['328px', '600px'],
                    content: '/syn/system/sysdepart/alldeptcheckboxtreeselect',
                    callback: function (data) {
                    	if (data) { 
                           	$("#activeDep").val(data.orgCodesExcParent);
                           	$("#activeDepName").val(data.orgNamesExcParent);
                    	}
                    }
            	});
            }
        }
        ]);
    }
});
