require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {

	var params={};//查询参数声明!
	
    init();
    /**	
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
        bind();
    }
    
	function initDataTable() {
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [ 5, 10, 20, 50, 100 ],
		ajax : {
			type : "post",
			url : '/syn/panoramasearch/panoQueryPage',
			data : function(d) {
				d.params = params;
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data: 'regNO', className: 'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'uniscid', className: 'center'},
		    {data : 'regNO', className: 'center'},
			{data : 'leRep', className: 'center'}, 
			{data : 'entTypeName', className: 'center'}, 
			{data : 'industryCoName', className: 'center'}, 
			{data : 'regOrgName',className: 'center'}, 
			{data : 'localAdmName', className: 'center'}
		],
		columnDefs : [
		      {
			   targets: 1,
		        render: function (data, type, row, meta) {
		    	    return "<input type='checkbox' class='chb' >";
		        }
			  }           
		  ],
          "drawCallback": function( settings ) {
            	$('.chbAll').attr("checked", false);
            }
	  })
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '#search',
            event: 'click',
            handler: function () {
            	params = $("#entSearchForm").serializeObject();
            	table.ajax.reload();
            }
        },{
        	el:'#cancel',
        	event:'click',
        	handler:function(){
        		layer.close();
        	}
        },{
        	el:'#getData',
        	event:'click',
        	handler:function(){
        		var supState=$(this).attr('supState'), markCode=$(this).attr('markCode'),
        			batchNO=$(this).attr('batchNO'),supCheckState=$(this).attr('supCheckState');
        		var priPIDStr = '';
        		$('.chb').each(function(){
        			if($(this).is(':checked')){
        				var data = table.row($(this).closest('td')).data();
        				priPIDStr = priPIDStr + data.priPID + ';';
        			}
        		});
        		if(priPIDStr == ''|| $(this).attr('batchNO')==null) {layer.msg('请先勾选需要添加的企业',{time: 1000});return;}
        			
        		http.httpRequest({
        			url: '/syn/supervise/doBatchModAdd',
                    serializable:false,
                    data: {"batchNO":batchNO,"supState":supState,"markCode":markCode,
                    	"supCheckState":supCheckState,"priPIDStr":priPIDStr},
                    success: function (data) {
                    if(data.status=='success'){
                    	layer.msg(data.msg, {time: 1000}, function () {
                        	layer.close({reload: true});
                        });
                    }
                    }
                });
        		
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
        	el:'#selectIndustry',
        	event:'click',
        	handler:function(){showIndustryTree()}//行业树
        },{
        	el:'#selectEntType',
        	event:'click',
        	handler:function(){showEntTypeTree()}//企业类型
        },{
        	el:'#selectLocalAdm',
        	event:'click',
        	handler:function(){showLocalAdmTree()}//管辖单位
        },{
        	el:'#selectRegOrg',
        	event:'click',
        	handler:function(){showRegOrgTree()}//登记机关
        },{
        	el:'.chbAll',
        	event:'click',
        	handler:function(){
        		var check = $(this).prop("checked");
        	      $(".chb").prop("checked", check);

        	}
        }
        ]);
    }
    
    function showIndustryTree(){
    	layer.dialog({
            title: '选择行业',
            area: ['350px', '666px'],
            content: '/commom/server/industry/toIndustryPhyTree',
            callback: function (data) {
            	$("#industryCo").val('');
            	$("#industryName").val('');
            	$("#industryCo").val(data.returncodes);
            	$("#industryName").val(data.returnname);
            }
        })
    }
    
    function showEntTypeTree(){
    	layer.dialog({
            title: '选择企业类型',
            area: ['350px', '666px'],
            content: '/commom/server/entcatg/entcatgmutiselect',
            callback: function (data) {
            	$("#entType").val('');
            	$("#entTypeName").val('');
            	$("#entType").val(data.returncodes);
            	$("#entTypeName").val(data.returnname);
            }
        })
    }
    
    function showLocalAdmTree(){
    	layer.dialog({
            title: '选择管辖单位',
            area: ['350px', '666px'],
            content: '/commom/server/regunit/regunitmutiselectnocheck',
            callback: function (data) {
            	$("#localAdm").val('');
            	$("#localAdmName").val('');
            	$("#localAdm").val(data.returncodes);
            	$("#localAdmName").val(data.returnname);
            }
        })
    }
    
    function showRegOrgTree(){
    	layer.dialog({
            title: '选择登记机关',
            area: ['350px', '666px'],
            content: '/commom/server/regorg/regorgmutiselectnocheck',
            callback: function (data) {
            	$("#regOrg").val('');
            	$("#regOrgName").val('');
            	$("#regOrg").val(data.returncodes);
            	$("#regOrgName").val(data.returnname);
            }
        })
    }
    
    
})
