require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http) {
	var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
        table = dataTable.load({
            el: '#user-table',
            showIndex:true,
			scrollX:true, //支持滚动
            ajax: {
            	type : "POST",
                url:'/reg/server/yr/forbidresult/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx'},
                {data: null},
                {data: 'year'},
                {data: 'regNO'},
                {data: 'entName',className: 'left'},
                {data: 'leRep'},
                {data: 'entTypeCatg'},
                {data: 'lastReportTime'},
                {data: 'reportState'},
                {data: 'auditDate'},
                {data: 'auditUser'},
                {data: 'dom',className: 'left'},
                {data: 'regOrgName',className: 'left'},
                {data: 'localAdmName',className: 'left'}
            ],
            columnDefs: [{
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 if(row.reportState=="12"){
                            		 return "<a class='commit'>审核</a>";
                            	 }else if(row.reportState=="11"||row.reportState=="13"){
                            		 return "<a class='commit'>详情</a>";
                            	 }else{
                            		 return "-";
                            	 }
                             }
                         },
                         {
                             targets: 6,
                             render: function (data, type, row, meta) {
                            	 if(row.entTypeCatg=='50'){
                            		 return "个体户";
                            	 }else if(row.entTypeCatg=="16"||row.entTypeCatg=="17"){
                            		 return "农专社";
                            	 }else{
                            		 return "企业";
                            	 }
                             }
                         },{
                             targets: 3,
                             render: function (data, type, row, meta) {
                            	 var reportState = row.reportState;
	 			             	 var yellow = new Date(row.yellowDate.replace("-", "/").replace("-", "/"));
                            	 var red = new Date(row.redDate.replace("-", "/").replace("-", "/"));
                            	 var beginYear = new Date().getFullYear().toString();
					             var beginMonth = (new Date().getMonth() + 1).toString();
					             var beginDay = new Date().getDate().toString();
					             var now = new Date((beginYear +"-"+ beginMonth +"-" + beginDay).replace(/\-/g, "\/"));
                            	 
					             if(reportState=='12'){
					            	 if(now < yellow){
					            		 if(row.uniCode !=null && row.uniCode !=""){
					            			 return row.uniCode;
					            		 }else{
					            			 return row.regNO;
					            		 }
					            	 }else if(now >=yellow && now < red ){
					            		 if(row.uniCode !=null && row.uniCode !=""){
					            			 return "<span class='yellow-bg'>"+row.uniCode+"</span>";
					            		 }else{
					            			 return "<span class='yellow-bg'>"+row.regNO+"</span>";
					            		 }
					            	 }else{
					            		 if(row.uniCode !=null && row.uniCode !=""){
					            			 return "<span class='red-bg'>"+row.uniCode+"</span>";
					            		 }else{
					            			 return "<span class='red-bg'>"+row.regNO+"</span>";
					            		 }
					            	 }
					             }else{
					            	 if(row.uniCode !=null && row.uniCode !=""){
				            			 return row.uniCode;
				            		 }else{
				            			 return row.regNO;
				            		 }
					             }
                             }
                         },{
							targets: 11,
		                    render: function (data, type, row, meta) {
		                    	 var data = row.dom;
		                    	 if(data && (data.length > 25)){
                                     $(table.cell( meta.row, meta.col ).node()).attr('title',data);
                                     return (data.substr( 0, 25 )+'....');
	                              }
		                    	 return row.dom;
		                    }
				         },{
								targets: 8,
			                    render: function (data, type, row, meta) {
			                    	 var data = row.reportState;
			                    	 if(data=='12'){
	                                     return '待审核';
		                             }else if(data=='11'){
		                            	 return '审核通过';
		                             }else if(data=='13'){
		                            	 return '审核不通过';
		                             }else{
		                            	 return '-';
		                             }
			                    	 
			                    }
					         }
                   ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	var categCode=new Array();
		$(":checkbox[name=entCatg]:checked").each(function(k,v){
			categCode[k]= this.value;
		});
		$("#entTypeCatg").val(categCode);
    	searchParams = $("#taskForm").serializeObject();
    	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '.commit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '敏感词审核',
                    area: ['100%', '100%'],
                    content: '/reg/server/yr/forbidresult/view?priPID='+data.priPID+'&year='+data.year+'&entTypeCatg='+data.entTypeCatg,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },
        {
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#chosecheckDep',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽查机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#checkDep").val(returncode);
                    	$("#checkDepName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#more',
            event: 'click',
            handler: function () { 
            	var isHideOrShow = $("#hideorshow").is(":hidden");
            	if(isHideOrShow){
            		 $("#more").val("收起");
            		 $("#hideorshow").css("display","block");
				}else{
					$("#more").val("更多查询条件");
            		$("#hideorshow").css("display","none");
				}
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#checkDep").val("");
            }
        }
        ])
    }

})
