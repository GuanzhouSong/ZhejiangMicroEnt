require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var searchParams={};
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#user-table',
			scrollX:true, //支持滚动
            ajax: {
                url:'/syn/server/drcheck/specialcheck/panoQueryPage',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'5%', className: 'center'},
                {data: null,width:'20px'},
                {data: 'entName',width:'20px'},
                {data: 'leRep',width:'20px'},
                {data: 'tel',width:'20px'},
                {data: 'estDate',width:'20px'},
                {data: 'entTypeCatgName',width:'20px'},
                {data: 'industryCoName',width:'20px'},
                {data: 'dom',width:'20px'},
                {data: 'regOrgName',width:'20px'},
                {data: 'localAdmName',width:'20px'},
                {data: 'sliceNOName',width:'20px'}
        ],
            columnDefs : [
						   {
	             	         targets:0,
	             	         render:function(data,type,row,meta){
	             		     return  '<input type="radio"  class="radioClass" name="_checkResult"  value='+row.priPID+'>';
	             	       }
						},{
	             	         targets:1,
	             	         render:function(data,type,row,meta){
	             	        	 if(row.uniscid !=null && row.uniscid !=''){
	             	        		 return row.uniscid;
	             	        	 }
	             	        	 return  row.regNO;
	             	       }
	                  }]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '#back',
            event: 'click',
            handler: function () {
            	 var userType = $("#userType").val();
            	 if(userType == "2"){
            		 window.location.href = "/syn/server/sccheck/specialent/specialentlistpage";
            	 }else{
            		 window.location.href = "/syn/server/drcheck/specialcheck/list";
            	 }
              }
        },{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	var data;
            	var checkFlag = false;
            	$(".radioClass").each(function(){
            		if($(this).prop("checked")){
            			checkFlag = true;
            			data = table.row($(this).closest('td')).data();
            		}
            	})
            	if(checkFlag){
	                layer.dialog({
	                    title: '添加',
	                    area: ['63%', '90%'],
	                    content: '/syn/server/drcheck/specialcheck/addOrEditView?priPID='+data.priPID,
	                    callback: function (data) {
	                    	 var userType = $("#userType").val();
	                    	 if(userType == "2"){
	                    		 window.location.href = "/syn/server/sccheck/specialent/specialentlistpage";
	                    	 }else{
	                    		 window.location.href = "/syn/server/drcheck/specialcheck/list";
	                    	 }
	                    }
	                })
                }else{
                	alert("请先选择一条记录！");
                	return false;
                }
            }
        },{
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
                    	var returncode=data.returncodes; 
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#chosesliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择责任区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNOName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#choseEntType',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择企业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/entcatg/entcatgmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#entTypeCode").val(returncode);
                    	$("#entTypeName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#chooseindustry',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择行业类型',
                    area: ['400px', '600px'],
                    content: '/commom/server/industry/toIndustryPhyTree',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#industryCo").val(returncode);
                    	$("#industryName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNO").val("");
            	$("#entTypeCode").val("");
            	$("#industryCo").val("");
            }
        }])
    }

})
