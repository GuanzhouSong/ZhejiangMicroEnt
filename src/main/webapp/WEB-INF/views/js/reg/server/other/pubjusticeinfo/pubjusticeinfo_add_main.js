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
    	  var userType= $("#userType").val(); 
          
    	
        table = dataTable.load({
            el: '#user-table',
			scrollX:true, //支持滚动
            ajax: {
                url:'/reg/other/pubjusticeinfo/panoQueryPage',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'5%', className: 'center'},
                {data: 'uniscid',width:'20px'},
                {data: 'regNO',width:'20px'},
                {data: 'entName',width:'20px'},
                {data: 'leRep',width:'20px'},
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
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                		window.location.href="/syn/other/pubjusticeinfo/list";
                 }else{ 
                	 	window.location.href="/reg/other/pubjusticeinfo/list";
                 }
            }
        },{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	var checkFlag = false;
            	var priPID;
            	 var userType= $("#userType").val(); 
                 var typeUrl="";
                 if(userType=="2"){
                	 typeUrl="/syn";
                 }else{
                	 typeUrl="/reg";
                 }
            	
            	$(".radioClass").each(function(){
            		if($(this).prop("checked")){
            			checkFlag = true;
            			priPID = $(this).val();
            		}
            	})
            	if(checkFlag){
	                layer.dialog({
	                    title: '添加',
	                    area: ['60%', '95%'],
	                    content: typeUrl+'/other/pubjusticeinfo/addOrEditView?pripid='+priPID,
	                    callback: function (data) {
	                        if (data.reload) {
	                        	window.location.href=typeUrl+"/other/pubjusticeinfo/list";
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNO").val("");
            }
        }])
    }

})
