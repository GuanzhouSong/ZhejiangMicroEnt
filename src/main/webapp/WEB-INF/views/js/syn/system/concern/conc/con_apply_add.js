require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {

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
			url : '/syn/con/csconcernobj/panosearchlist.json',
			data : function(d) {
				d.params = params;
			}
		},
		columns : [
		    {data: null, width:'50px',className: 'center'},
		    {data : 'uniscid',width:'120px', className: 'center'},
			{data : 'regNO',width:'100px', className: 'center'}, 
			{data : 'entName',width:'150px', className: 'center'},
			{data : 'leRep',width:'100px', className: 'center'}, 
			{data : 'entTypeName',width:'100px', className: 'center'}, 
			{data : 'industryCoName',width:'100px', className: 'center'}, 
			{data : 'dom',width:'150px', className: 'center'}, 
			{data : 'regOrgName',width:'100px', className: 'center'}, 
			{data : 'localAdmName',width:'100px', className: 'center'}, 
			{data : null, width:'100px',className: 'center'}
		],
		columnDefs : [
      {
	   targets: 0,
        render: function (data, type, row, meta) {
    	    return "<input type='checkbox' class='chb'>";
        }
    } , {
 	   targets: 10,
       render: function (data, type, row, meta) {
    	   if(row.isFocusObj=='Y')
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
    	params = $("#hx-form").serializeObject();
    	table.ajax.reload();
    });
    //企业计数
    var entNum = 0;
    $('#entNum').text(entNum);
    //去重复
    var priPIDStr = [];
    $('#getData').click(function(){
      	 $('.chb').each(function(){ 
      		var flag =true;
      		var data = table.row($(this).closest('td')).data();
          	 if($(this).is(':checked')){
          		 for(var i=0;i<priPIDStr.length;i++){
          			 if(priPIDStr[i]==data.priPID){
          				 flag = false;
          				 break;
          			 }
          		 }
          		if(flag){
          			entNum++;
          			priPIDStr.push(data.priPID);
          	        $('#enttbody').append("<tr><td><a href='javascript:void(0)' class='remove' id='"+data.priPID+"'>删除</td><td>"+(data.uniscid==null?"":data.uniscid)+"</td><td>"+data.regNO+"</td><td>"
          	   	    +data.entName+"</td><td>"+(data.leRep==null?"":data.leRep)+"</td><td>"+(data.entTypeName==null?"":data.entTypeName)+"</td><td>"
          	     	+(data.industryCoName==null?"":data.industryCoName)+"</td><td>"+data.dom+"</td><td>"+(data.regOrgName==null?"":data.regOrgName)+"</td><td>"+(data.localAdmName==null?"":data.localAdmName)+"</td><td>"+(data.isFocusObj=='Y'?"<a class='mr10 lookhis' id='"+data.priPID+"'>有</a>":"无")+"</td></tr>");	  
          		 }
      		 }
   		 });
      	 $('#entNum').text(entNum);
      });
    
    
   
    function bind() {
        util.bindEvents([
                         {
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/con/csconcernobj/applylist';
            }
        },{
            el: '.js-more-query',
            event: 'click',
            handler: function () {
            	if($('.js-show').css("display")=="none"){
            		$('.js-more-query').attr('value','收起');
            		$('.js-show').css("display","block");
            	}else{
            		$('.js-more-query').attr('value','更多查询');
            		$('.js-show').css("display","none");
            	}
            }
        },{
            el: '.remove',
            event: 'click',
            handler: function () {
            	 for(var i=0;i<priPIDStr.length;i++){
          			 if(priPIDStr[i]==this.id){
          				priPIDStr[i]="";
          			 }
          		 }
            	$(this).parent().parent().remove();
            	entNum--;
            	$('#entNum').text(entNum);
            }
        },{
            el: '#enaddmark',
            event: 'click',
            handler: function () {
            	if(entNum==0){
            		layer.msg("请选择企业！");return;
            	}
            	
            	http.httpRequest({
                    url: '/syn/risk/cswarnmark/doselectmymark',
                    serializable: false,
                    data: {'markFunc':'gz'},
                    type: 'post',
                    success: function (data) {
                    	var arr='';
                    	if(data.msg=='false'){
                    		layer.msg("无可用标识！");
                    	}else{
                    		for(var i=0;i<priPIDStr.length;i++){
                    			if(priPIDStr[i] !=''){
                    				arr = arr + priPIDStr[i] +','; 
                    			}
                     		 }
                    		layer.dialog({
                                title: '添加企业标识',
                                area: ['70%', '60%'],
                                content: '/syn/con/csconcernobj/doenconapplyaddmark?priPIDStr='+arr,
                                callback: function (data) {
                                    //重新加载列表数据
                                    if (data.reload) {
                                	window.location.href='/syn/con/csconcernobj/applylist';
                                    }
                                }
                            })
                    	}
                    }
                });
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
        		var check = $(this).prop("checked");
        	      $(".chb").prop("checked", check);

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
                    title: '查看关注服务历史',
                    area: ['70%', '60%'],
                    content:'/syn/con/csconcernobj/getentwarnhis?priPID='+this.id,
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
