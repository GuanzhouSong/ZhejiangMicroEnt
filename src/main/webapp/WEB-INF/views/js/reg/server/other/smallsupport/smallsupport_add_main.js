require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, dataTable, util, http,handlebars) {
	  $('input, textarea').placeholder();
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
     
    	var userType=$("#userType").val();
    	var url="/reg/server/other/pubSmallSupport/panoQueryPage";
    	if(userType=="2"){
    		url="/syn/server/other/pubSmallSupport/panoQueryPage";
    	}
        table = dataTable.load({
            el: '#user-table',
			scrollX:true, //支持滚动
			 showIndex: true,
            ajax: {
                url:url,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
               {data: null,'defaultContent':'11'},
                {data: '_idx',width:'5%', className: 'center'},
                {data: 'regNO',width:'20px'},
                {data: 'entName',width:'20px'},
                {data: 'leRep',width:'20px'},
//                {data: 'tel',width:'20px'},
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
	             	         targets:1,
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
                 if(userType=="2"){
                	 window.location.href="/syn/server/other/pubSmallSupport/searchlist";
                 }else{
                	 window.location.href="/reg/server/other/pubSmallSupport/searchlist";
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
	                    area: ['60%', '80%'],
	                    content: typeUrl+'/server/other/pubSmallSupport/showToAdd?priPID='+priPID,
	                    callback: function (data) {
	                        if (data.reload) {
	                        	window.location.href=typeUrl+"/server/other/pubSmallSupport/searchlist";
	                        }
	                    }
	                })
                }else{
                	layer.msg("请先选择一条记录！",{time:1000});
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
                    content: '/commom/server/regunit/regunitmutiselectnocheck',
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
                    content: '/commom/server/regorg/regorgmutiselectnocheck',
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
                    content: '/commom/server/sliceno/slicenomutiselectnocheck',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	 
                    	$("#sliceNO").val(returncodes);
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
