require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
    var searchParams= $("#taskForm").serializeObject();;//查询参数声明!
    var table;
    init(); 
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
        initArea();
        initKinds();
       }


    function showRegOrgTree(){
        layer.dialog({
            title: '选择登记机关',
            area: ['400px', '600px'],
            content: '/commom/server/regorg/regorgmutiselectnocheck',
            callback: function (data) {
                $("#setDeptCode").val('');
                $("#setDeptName").val('');
                $("#setDeptCode").val(data.returncodes);
                $("#setDeptName").val(data.returnname);
            }
        })
    }
    
    //初始化地区
    function initArea(){
       areacodeList(1);
       var deptcode = window._CONFIG.deptCode;
      	if(deptcode == '3300' || window._CONFIG.isAdmin == '1' || window._CONFIG.isAdmin == '2' || window._CONFIG.searchRangeLevel == '4' ){
      		$("#statArea").append("<option value='3300'>省局</option>");
      		$("#statArea").append("<option value='3301'>杭州</option>");
      		$("#statArea").append("<option value='3302'>宁波</option>");
      		$("#statArea").append("<option value='3303'>温州</option>");
      		$("#statArea").append("<option value='3304'>嘉兴</option>");
      		$("#statArea").append("<option value='3305'>湖州</option>");
      		$("#statArea").append("<option value='3306'>绍兴</option>");
      		$("#statArea").append("<option value='3307'>金华</option>");
      		$("#statArea").append("<option value='3308'>衢州</option>");
      		$("#statArea").append("<option value='3309'>舟山</option>");
      		$("#statArea").append("<option value='3310'>台州</option>");
      		$("#statArea").append("<option value='3325'>丽水</option>");
      	}else if(deptcode == '3301'){
      		$("#statArea").append("<option value='3301'>杭州</option>");
      	}else if(deptcode == '3302'){
      		$("#statArea").append("<option value='3302'>宁波</option>");
      	}else if(deptcode == '3303'){
      		$("#statArea").append("<option value='3303'>温州</option>");
      	}else if(deptcode == '3304'){
      		$("#statArea").append("<option value='3304'>嘉兴</option>");
      	}else if(deptcode == '3305'){
      		$("#statArea").append("<option value='3305'>湖州</option>");
      	}else if(deptcode == '3306'){
      		$("#statArea").append("<option value='3306'>绍兴</option>");
      	}else if(deptcode == '3307'){
      		$("#statArea").append("<option value='3307'>金华</option>");
      	}else if(deptcode == '3308'){
      		$("#statArea").append("<option value='3308'>衢州</option>");
      	}else if(deptcode == '3309'){
      		$("#statArea").append("<option value='3309'>舟山</option>");
      	}else if(deptcode == '3310'){
      		$("#statArea").append("<option value='3310'>台州</option>");
      	}else if(deptcode == '3325'){
      		$("#statArea").append("<option value='3325'>丽水</option>");
      	}
    	if(deptcode == '3300'){ 
          	$("#statArea").multipleSelect({
       		selectAllText: '全省',
       		allSelected: '全省',
       		selectAllDelimiter: '',
       		minimumCountSelected: 20
       	});
      	}else{
          	$("#statArea").multipleSelect({
          		selectAllText: '',
          		allSelected: '',
          		selectAll: false
       	});
      	}

    	if(deptcode == '3300'){
    	    $('#statArea').multipleSelect('checkAll');
    	}else{
       	$('#statArea').multipleSelect('setSelects',[deptcode]);
    	}
   }
    
    function areacodeList(str){
		if(str == "3300"){
			return "省局";
		}else if(str == "3301"){
			return "杭州";
		}else if(str == "3302"){
			return "宁波";
		}else if(str == "3303"){
			return "温州";
		}else if(str == "3304"){
			return "嘉兴";
		}else if(str == "3305"){
			return "湖州";
		}else if(str == "3306"){
			return "绍兴";
		}else if(str == "3307"){
			return "金华";
		}else if(str == "3308"){
			return "衢州";
		}else if(str == "3309"){
			return "舟山";
		}else if(str == "3310"){
			return "台州";
		}else if(str == "3325"){
			return "丽水";
		}else{
			return "";
		}
	}
    
    
    
    //初始化标签类别
    function initKinds(){ 
  		$("#IDType").append("<option value='1'>大类</option>");
  		$("#IDType").append("<option value='2'>中类</option>");
  		$("#IDType").append("<option value='3'>小类</option>"); 
  	 	$("#IDType").multipleSelect({
       		selectAllText: '全部',
       		allSelected: '全部',
       		selectAllDelimiter: '',
       		minimumCountSelected: 20
       	});
  	 	$('#IDType').multipleSelect('checkAll');
      // 	$('#IDType').multipleSelect('setSelects',['']); 
   }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#pubopanomalylist_table',
			showIndex: true,
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/registmark/selectRegistMarkAuditJSON.json',
                data:function(d){
                 var IDType = $('#IDType').val(); 
               	 var statArea = $('#statArea').val(); 
               	d.params = $.extend({}, searchParams, {"IDType":IDType==null?"":IDType.toString()
             		   ,"applicationScopeCode":statArea==null?"":statArea.toString()
                      }); 
                }
            },
            columns: [ 
                    {data: null,'defaultContent':'11'}, 
                  	{data: null, width:"180px",defaultContent:'id' },
                  	{data: 'idname',cut: {length: 20,mark:'...'}},
        			{data: 'idtype',cut: {length: 20,mark:'...'}},
        			{data: 'idstateCode',cut: {length: 20,mark:'...'}},
                    {data: 'validDate',cut: {length: 20,mark:'...'}},
                    {data: 'applicationScopeName',cut: {length: 20,mark:'...'}},
                    {data: 'doublyStoFirName',cut: {length: 20,mark:'...'}},
                    {data: 'doublyStoSecName',cut: {length: 20,mark:'...'}},
                    {data: 'doublyStoThiName',cut: {length: 20,mark:'...'}},
        			{data: 'createTime',cut: {length: 20,mark:'...'}},
        			{data: 'updateTime',cut: {length: 20,mark:'...'}},
        			{data: 'auditState',cut: {length: 20,mark:'...'}},
        			{data: 'setName',cut: {length: 20,mark:'...'}},
        			{data: 'setDeptname',cut: {length: 20,mark:'...'}},
        			{data: 'auditorName',cut: {length: 20,mark:'...'}},
        			{data: 'auditDeptName',cut: {length: 20,mark:'...'}}
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	  var auditState= row.auditState; 
                            	  //未审核
                            	  if("1"==auditState){
                            		  return   '<a href="javascript:void(0);" id="'+row.markUuid+'"  class="audit">审核</a>'; 
                              	  }else if("2"==auditState||"3"==auditState){ //审核通过和审核不通过
                              		 return   '<a href="javascript:void(0);" id="'+row.markUuid+'"  class="view">详情</a>';
                              	  }else{
                            		  return   "";
                            	  }
                             }
                       },
                       {
                           targets: 3,
                           render: function (data, type, row, meta) { 
                        	   
                          	  if("1"==data){ 
                          		  return  '大类(执法领域)';
                              }else if("2"==data){
                            	  return  '中类(行业)';
                              }else if("3"==data){
                            	  return  '小类(许可监管项目)';
                              }else {
                            	  return "";
                              }
                           }
                       },
                       {
                           targets: 4,
                           render: function (data, type, row, meta) { 
                          	   
                          	  if("1"==data){ 
                          		  return  "有效"; 
                              }else if("2"==data){
                            	  return  "无效"; 
                              }else {
                            	  return "";
                              }
                           }
                       },
                       {
                           targets: 5,
                           render: function (data, type, row, meta) {
                               var validDate= row.validDate;
                               if(validDate && validDate.indexOf("2099") != -1){
                                   return "长期有效";
                               }else{
                                   return validDate;
   							}
                           }
                       },{
       					targets: 10,
       					render: function (data, type, row, meta) {
       						var createTime= row.createTime;
       						if(createTime){
       							return createTime.substring(0,10);
       						}
       					}
       				},{
       					targets: 12,
       					render: function (data, type, row, meta) {
       						var auditState= row.auditState;
       						if("1"==auditState){
       							return '待审核';
       						}else if("2"==auditState){ 
       							return '审核通过';
       						}else if("3"==auditState){ 
       							return '审核不通过';
       						}
       					}
       				}
            ]
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams= $("#taskForm").serializeObject();;//查询参数声明!
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '.audit',
            event: 'click',
            handler: function () {
            	var data = this.id;
            	
            	layer.dialog({
                    title: '新增审核',
                    area: ['100%', '100%'],
                    content: '/reg/server/registmark/registMarkAuditPage?uid='+data+"&flag=1",
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },
        {
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = this.id;
            	
            	layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content: '/reg/server/registmark/registMarkAuditPage?uid='+data+"&flag=2",
                    callback: function (data) {
                         
                    }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$('#IDType').multipleSelect('checkAll'); 
            	$('#statArea').multipleSelect('checkAll');
            	$('#setDeptCode').val("");
            }
        },{
            el:'#selectRegOrg',
            event:'click',
            handler:function(){showRegOrgTree()}//登记机关
     }
        ]);
    }

})
