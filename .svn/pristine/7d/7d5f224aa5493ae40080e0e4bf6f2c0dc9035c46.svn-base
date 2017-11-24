require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {

	var params={};//查询参数声明!
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
    }
    
	function initDataTable() {
		table = dataTable.load({
		el : '#search-table',
		showIndex: false,
		scrollX: true,
		lengthMenu: [ 5, 10, 20, 50, 100 ],
		ajax : {
			type : "post",
			url : '/syn/risk/csentwarn/panosearchlist.json',
			data : function(d) {
				d.params = params;
			}
		},
		columns : [
		    {data: null,width:'60px',className: 'center'},
		    {data : 'uniscid',width:'120px', className: 'center'},
			{data : 'regNO',width:'100px', className: 'center'}, 
			{data : 'entName',width:'130px', className: 'center'},
			{data : 'leRep',width:'100px', className: 'center'}, 
			{data : 'entTypeName',width:'100px', className: 'center'}, 
			{data : 'industryCoName',width:'100px', className: 'center'}, 
			{data : 'dom',width:'150px', className: 'center'}, 
			{data : 'regOrgName',width:'150px', className: 'center'}, 
			{data : 'localAdmName',width:'100px', className: 'center'}, 
			{data : null, width:'80px',className: 'center'}
		],
		columnDefs : [
      {
	   targets: 0,
        render: function (data, type, row, meta) {
    	    return "<input type='checkbox' class='chb' >";
        }
    } , {
 	   targets: 10,
       render: function (data, type, row, meta) {
    	   if(row.isRiskWarn=='Y')
    		   return "<a href='javascript:void(0)' class='mr10 lookhis' id='"+row.priPID+"'>有</a>"; 
    	   else 
   	           return "无";
       }
   }            
		  ],
          "drawCallback": function( settings ) {
            	$('.chbAll').attr("checked", false);
            }
	  })
	}
    $('#search').click(function(){
    	params = $("#entSearchForm").serializeObject();
    	table.ajax.reload();
    });
    var arr="";
    $('#getData').click(function(){
      	 $('.chb').each(function(){ 
      		var data = table.row($(this).closest('td')).data();
          	 if($(this).is(':checked')){
          		    arr = arr +data.priPID+',';
      		 }
   		 });
      	 if(arr==''){
      		 layer.msg("请选择企业！");return;
      	 }
         http.httpRequest({
             url: '/syn/risk/csentwarn/addent',
             serializable: false,
             data: {'priPIDStr':(arr.substring(0,arr.length-1)),'batchNo':$('#batchNo').val(),'markNo':$('#markNo').val(),'checkState':$('#checkState').val()},
             type: 'post',
             success: function (data) {
                 layer.msg(data.msg, {time: 1000}, function () {
                 	if(data.status=='success')
                 	  layer.close({reload: true});
                 });
             }
         });
      });
    
    
   
    function bind() {
        util.bindEvents([
                         {
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
            el: '.js-more-query',
            event: 'click',
            handler: function () {
            	if($('.js-show').css('display')=='none'){
            		$('.js-more-query').attr('value','收起');
            		$('.js-show').css('display','block');
            	}else{
            		$('.js-more-query').attr('value','更多查询');
            		$('.js-show').css('display','none');
            	}
            }
        },{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            }
        },{
        	el:'.chbAll',
        	event:'click',
        	handler:function(){
        		var check = $(this).prop('checked');
        	      $('.chb').prop('checked', check);

        	}
        },{
            el: '#selectLocalAdm',
            event: 'click',
            handler: function () {
            	doSelectLocalAdm();
            }
        },{
            el: '#selectRegOrg',
            event: 'click',
            handler: function () {
            	doSelectRegOrg();
            }
        },{
            el: '#selectEntType',
            event: 'click',
            handler: function () {
            	doSelectEntType();
            }
        },{
            el: '#selectIndustryCo',
            event: 'click',
            handler: function () {
            	doSelectIndustryCo();
            }
        },{
            el: '.lookhis',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '查看预警历史',
                    area: ['70%', '60%'],
                    content: '/syn/risk/csentwarn/getentwarnhis?priPID='+this.id,
                    callback: function (data) {
                    }
                })
            }
        }
        ]);
    }
   
    function doSelectLocalAdm(){
          var select_localAdm_url=window._CONFIG.select_localAdm_url;
          layer.dialog({
              title: '选择管辖单位',
              area: ['350px', '666px'],
              content: select_localAdm_url,
              callback: function (data) {
                   $("#localAdm").val('');
                   $("#localAdm").val(data.returnname);
                   $("#localAdmCode").val('');
                   $("#localAdmCode").val(data.returncodes);
              }
          })
        }
      function doSelectRegOrg(){
           var select_regOrg_url=window._CONFIG.select_regOrg_url;
           layer.dialog({
               title: '选择登记机关',
               area: ['350px', '666px'],
               content: select_regOrg_url,
               callback: function (data) {
                    $("#regOrg").val('');
                    $("#regOrg").val(data.returnname);
                    $("#regOrgCode").val('');
                    $("#regOrgCode").val(data.returncodes);
               }
           })
       }
      
      function doSelectEntType(){
          var select_entType_url=window._CONFIG.select_entType_url;
          layer.dialog({
              title: '选择企业类型',
              area: ['350px', '666px'],
              content: select_entType_url,
              callback: function (data) {
                   $("#entType").val('');
                   $("#entType").val(data.returnname);
                   $("#entTypeCode").val('');
                   $("#entTypeCode").val(data.returncodes);
              }
          })
      }
      
      function doSelectIndustryCo(){
             var select_industryCo_url=window._CONFIG.select_industryCo_url;
             layer.dialog({
                 title: '选择行业',
                 area: ['350px', '666px'],
                 content: select_industryCo_url,
                 callback: function (data) {
                      $("#industryCoName").val('');
                      $("#industryCoName").val(data.returnname);
                      $("#industryCo").val('');
                      $("#industryCo").val(data.returncodes);
                 }
             })
         }
})
