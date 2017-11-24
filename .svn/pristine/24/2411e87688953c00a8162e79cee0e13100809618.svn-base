require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {

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
    
	function initDataTable() {
		initFlag = '0';
		table = dataTable.load({
		el : '#search-table',
		showIndex: true,
		scrollX: true,
		lengthMenu: [10, 20, 30,50, 100 ],
		ajax : {
			type : "post",
			url : '/reg/server/yr/yrdatareturn/panoQueryPage',
			data : function(d) {
				d.params = params;
			}
		},
		columns : [
		    {data: '_idx', className: 'center'},
		    {data:null,className:'center'},
		    {data : 'entName', className: 'center'},
		    {data : 'uniscid', className: 'center'},
		    {data : 'regNO', className: 'center'},
		    {data : 'regState', className: 'center'},
		    {data : 'apprDate', className: 'center'},
		    {data : 'estDate', className: 'center'},
		    {data : 'regCap', className: 'center'},
		    {data : 'leRep', className: 'center'},
			{data : 'entTypeName', className: 'center'}, 
			{data : 'industryCoName', className: 'center'}, 
			{data : 'regOrgName',className: 'center'}, 
			{data : 'localAdmName', className: 'center'}
		],
		columnDefs : [
		              {
		            	 targets:1,
		            	 render:function (data, type, row, meta) {
		            		 return "<a href='javascript:void(0)' class='mr10 look' priPID='"+row.priPIDDesc+"'>数据回导</a>";
		            	 }
		            	  
		              },{
			            	 targets:5,
			            	 render:function (data, type, row, meta) {
			            		 if(row.regState=='A' || row.regState=='B' || row.regState=='K' ||row.regState=='DA' )
			            			 return "存续";
			            		 if(row.regState=='X') return "注销";
			            		 if(row.regState=='C') return "撤销";
			            		 if(row.regState=='D') return "吊销";
			            		 if(row.regState=='Q') return "迁出";
			            	 }
			            	  
			              }
		             ]
	  })
	}
	
    
    
   
    function bind() {
        util.bindEvents([
       {
            el: '#search',
            event: 'click',
            handler: function () {
            	params = $("#entSearchForm").serializeObject();
            	if(initFlag == '1'){
            		initDataTable();
            	}
            	table.ajax.reload();
            }
        },{
        	el:'#reset',
        	event:'click',
        	handler:function(){
        		$('.clx').val('');
        	}
        },{
            el: '.look',
            event: 'click',
            handler: function () {
            	var priPID = $(this).attr("priPID");
            	if(priPID!=null && priPID != ''){
            	 layer.dialog({
            		title:'年报信息回导',
            		area:['80%','80%'],
            		content:"reg/server/yr/yrdatareturn/toreturnpage?priPID="+priPID,
            		callback:function(data){
            			if(data.reload){
            				table.ajax.reload
            			}
            		}
            	 });
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
