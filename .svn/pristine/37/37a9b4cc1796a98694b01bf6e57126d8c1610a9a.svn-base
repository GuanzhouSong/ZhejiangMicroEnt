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
    
    //设置限制原因类别为全部
	$('#limitTypeM').multipleSelect('checkAll');
	//限制解除状态

	function initDataTable() {
		initFlag = '0';
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : '/reg/server/registmanage/limitRemoveAddApplyListJSON.json',
			data : function(d) {
             	var limitTypeM = $('#limitTypeM').val();
             	limitTypeM = limitTypeM == null ? null :limitTypeM.toString();
        		d.params = $.extend({}, params, {"removelimitflag":"1","addremoveflag":"1","limitType":limitTypeM});               		
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
          	{data: null,defaultContent:'priPID', width: '100px', className: 'center'},
		    {data : 'clientName', className: 'center'},
		    {data : 'certNO', className: 'left'},
		    {data : 'limitTypeName', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'regNO', className: 'center'},
		    {data : 'limitReason', className: 'center',cut: {length: 30,mark:'...'}},
		    {data : 'limitNO', className: 'center'},
		    {data : 'limitDepartName', className: 'center'},		    
		    {data : 'limitDateStart', className: 'center'},
		    {data : 'limitDateEnd', className: 'center'}
		],
		columnDefs : [{
		       	 targets:1,
		    	 render:function (data, type, row, meta) {
          		      return '<input type="radio" name="_radio"  value='+row.uid+'>';
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
			 }],
		    "fnDrawCallback": function (oSettings) {
             	var limitTypeM = $('#limitTypeM').val();
             	limitTypeM = limitTypeM == null ? null :limitTypeM.toString();
		    	var searchMap = $.extend({}, params, {"removelimitflag":"1","addremoveflag":"1","limitType":limitTypeM});
		    	http.httpRequest({ 
	                url: '/reg/server/registmanage/DataCountList',
	                serializable: false,
	                type:'post',
	                data: {params:searchMap} ,
	                success: function (data) {
	                	var list = data.data;
	                    if (data.status == 'success') {  
	                    	//限制对象数量
							$("#clientNameCount").text(list[0]);
							//限制原因数量
							$("#pripidCount").text(list[1]);
	                    }else{
	                    	$("#clientNameCount").text("0");
							$("#pripidCount").text("0");
	                    } 
	                }
	            });
			}
	  });
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '#search',
            event: 'click',
            handler: function () {       		
        		params = $("#entSearchForm").serializeObject();
        		if(initFlag=="1"){
            		initDataTable();
            	}else{
            		table.ajax.reload();
            	}
            }
        },{
            el: '#back',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/registmanage/limitRemoveApplyList';
            }
        },{
            el: '#removeApply',
            event: 'click',
            handler: function () { 
            	var uid= $(":radio[name=_radio]:checked").val();
            	if(uid==null||uid==''){
            		 layer.msg("请选择一条限制记录再操作", {ltype: 0,time:500});
                     return false;
            	}
            	layer.dialog({
                    title: '登记事项管理 - 任职资格限制管理-提前解除申请添加',
                    area: ['70%', '60%'],
                	content: '/reg/server/registmanage/limitRemoveAddApply?uid='+uid+'&operate=1',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },
        {
        	el:'#cancle',
        	event:'click',
        	handler:function(){
        	    //设置限制原因类别为全部
        		$('#limitTypeM').multipleSelect('checkAll');
        		//限制解除状态
        		$('#freeStateM').multipleSelect('checkAll');
        		$('#activeDep').val('');
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
