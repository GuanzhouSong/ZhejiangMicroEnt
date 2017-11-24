require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    var initFlag = true;
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }


    var searchParams={};
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
        table = dataTable.load({
            el: '#user-table',
			scrollX:true, //支持滚动
            ajax: {
            	type : "POST",
                url:'/syn/server/drcheck/specialcheck/panoQueryPage',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'5%', className: 'center'},
                {data: null,width:'20px'},
                {data: 'entName',width:'20px'},
                {data: 'entType',width:'20px'},
                {data: 'leRep',width:'20px'},
                {data: 'localAdmName',width:'20px'},
                {data: null,width:'20px'},
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
	                  },{
	             	         targets:3,
	             	         render:function(data,type,row,meta){
	             	        	 if(data == '9500'){
	             	        		 return "个体户";
	             	        	 }else{
	             	        		 return "企业";
	             	        	 }
	             	       }
	                  },{
	             	         targets:6,
	             	         render:function(data,type,row,meta){
	             	        	return "";
	             	       }
	                  }]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	
    	var entCatgArry = new Array();
    	searchParams = $("#taskForm").serializeObject();
    	$("#taskForm input[name ='entType']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	searchParams.entType = entCatgArry.toString();
    	if(initFlag){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '#back',
            event: 'click',
            handler: function () {
            	 window.location.href = "/reg/server/party/member/addlist";
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
	                    area: ['100%', '100%'],
	                    content: '/reg/server/party/member/addOrModifyView?priPID='+data.priPID+"&viewFlag=1"+"&businessType=2",
	                    callback: function (data) {
	                        if (data.reload) {
	                        	window.location.href = "/reg/server/party/member/addlist";
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#localAdm").val("");
            }
        }])
    }

})
