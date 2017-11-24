require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {

	var params=$("#entSearchForm").serializeObject();//查询参数声明!
	
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
			{data : 'localAdmName', className: 'center'},
			{data : 'isIndRegObj', className: 'center'}
		],
		columnDefs : [
		      {
			   targets: 1,
		        render: function (data, type, row, meta) {
		    	    return "<input type='checkbox' class='chb' name='chb'>";
		        }
			  } , {
			 	   targets: 10,
			       render: function (data, type, row, meta) {
			    	   if(row.isIndRegObj==null) return "否";
			    	   if(row.isIndRegObj=="Y") return "是";
			    	   if(row.isIndRegObj=="N") return "否";
			       }
			   }            
		  ],
          "drawCallback": function( settings ) {
            	$('.chbAll').attr("checked", false);
            }
	  })
	}
	
    
    //企业计数
    var entNum = 0;
    $('#entNum').text(entNum);
    //去重复
    var priPIDStr=[];
    $('#getData').click(function(){
      	 $(".chb").each(function(){ 
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
          	        $('#enttbody').append("<tr><td><a href='javascript:void(0)' class='remove' style='white-space: nowrap;' id='"+data.priPID+"'>删除</td>" +
          	        		"<td style='white-space: nowrap;'>"+data.entName+"</td><td>"
          	   	    +(data.uniscid==null?'':data.uniscid)+"</td><td>"
          	   	    +data.regNO+"</td><td>"+data.entTypeName+"</td><td>"
          	     	+data.industryCoName+"</td><td>"+data.regOrgName+"</td><td>"+data.localAdmName+"</td></tr>");	  
          		 }
      		 }
   		 });
      	 $('#entNum').text(entNum);
      });
    
    
   
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
        	el:'#reset',
        	event:'click',
        	handler:function(){
        		$('.clx').val('');
        	}
        },{
            el: '#goback',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/supervise/doEnSupApplyList';
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
            	var arr='';
            	if(entNum==0){layer.msg("请选择企业！");return;}
            	http.httpRequest({
                    url: '/syn/risk/cswarnmark/doselectmymark',
                    serializable: false,
                    data: {'markFunc':'jg'},
                    type: 'post',
                    success: function (data) {
                    	if(data.msg=='false'){
                    		layer.msg("无可用标识！");
                    	}else{
                    		for(var i=0;i<priPIDStr.length;i++){
                    			if(priPIDStr[i] !=''){
                    				arr = arr + priPIDStr[i] +';'; 
                    			}
                     		 }
                    		console.log(arr);
                    		layer.dialog({title: '添加企业标识',area: ['70%', '60%'],content: '/syn/supervise/doEnSupApplyMarkList?priPIDStr='+arr,
                                callback: function (data) {
                                    //重新加载列表数据
                                    if (data.reload) {
                                    	window.location.href='/syn/supervise/doEnSupApplyList';
                                    }
                                }
                            })
                    	}
                    }
                });
            	
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
