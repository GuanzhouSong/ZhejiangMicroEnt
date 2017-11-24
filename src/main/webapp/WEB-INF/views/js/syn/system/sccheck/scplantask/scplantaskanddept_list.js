require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;
    var deptState={"1":"待选执法人员","2":"已选执法人员","3":"等待录入结果","4":"已录入结果"};
    var scStackState={"00":"任务创建中","01":"待抽取对象","02":"待设置任务计划","03":"实施中","04":"实施中","05":"实施中","06":"已完成"};
    
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var chooseUrl = window._CONFIG.chooseUrl;
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scstack-table',
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:chooseUrl+'/sccheck/scplantask/pubScPlanTaskAndDeptListJSON.json',
                data:function(d){
            		d.params = $.extend({}, searchParams, {"deptCode" : $("#deptCode").val(),"userId":$("#userId").val()});               		
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null,'defaultContent':'11','className': 'center'},
                {data: 'uid', 'className': 'center'}, 
                {data: 'taskCode'},
                {data: 'taskName'},
                {data: 'deptName'},
                {data: 'deptState'},
//                {data: 'checkNum'},
//                {data: 'specialNum'},
                {data: 'taskObject'},
                {data: 'entNum'},
                {data: 'taskType'},
                {data: 'taskStartTime'},
                {data: 'taskEndTime'},
                {data: 'taskLeadDeptName'},
                {data: 'setUserName'},
                {data: 'setTime'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) {
			    	 if(row.deptState=="2" || row.deptState=="3"){
				    		return "<a class='commit  js_view'>查看</a>";
			    	}else{ 
			    		return "<a class='commit js_select'>抽选执法人员</a>";
			    	 }
			    }
			},
			 {
			  targets:5,
			  render:function(data,type,row,meta){
				  if(row.deptState==null||row.deptState==""||row.deptState=="1"){
					  return "待抽取";
				  }else{
				      return "已抽取";
				  }
				  }
			},
			{
				targets:6,
				render:function(data,type,row,meta){
					if(data!=null&&data!=""){
						var str = data.replace("1","企业");
						str = str.replace("2","农专社");
						str = str.replace("3","个体户");
						str = str.replace("4","外企代表机构");
						return str;
					}else{
						return ""; 
					}
				}
			},
			{
				targets:8,
				render:function(data,type,row,meta){
					if(data == "1"){
						return "定向";
					}else if(data == "2"){
						return "不定向"; 
					}else{
						return "";
					}
				}
			}
			]
        })
    }
    
    //表格之外的查询按钮事件
    $("#qry").click(function(){
   	   var categCode=new Array(); 
	   $(":checkbox[name=deptcatgCode]:checked").each(function(k,v){
	   	   categCode[k]= this.id; 
	      });
	   $("#depttaskEntCatgCode").val(categCode.toString());
       searchParams=$("#qryForm").serializeObject();
       table.ajax.reload(); 
    });
    

   
    function bind() {
        util.bindEvents([{
			    el: '.js_view',
			    event: 'click',
			    handler: function () {
			    	
			    	var data = table.row($(this).closest('td')).data();
			    	var uid=data.uid;
			    	layer.dialog({
			            title: '企业和执法人员随机配对结果',
			            area: ['80%', '70%'],
			            content:window._CONFIG.chooseViewUrl+'/pub/server/sccheck/entagent/view?deptTaskUid='+uid,
			            callback: function (data) {
			            	
			            }
			        })
			    }
		}, {
		    el: '.js_select',
		    event: 'click',
		    handler: function () {
		    	var data = table.row($(this).closest('td')).data();
		    	var uid=data.uid;
		    	layer.dialog({
		            title: '抽取人员',
		            area: ['100%', '100%'],
		            content:window._CONFIG.chooseUrl+'/sccheck/scplantask/randomagent?taskNO='+uid,
		            callback: function (data) {
		                //重新加载列表数据
	                	table.ajax.reload();
		            }
		        })
			}
		}, {
            el: '#choseorgReg',
            event: 'click',
            handler: function () {//选择任务组织部门
               var userType = $("#userType").val();
          		var  deptLink='/common/system/sysdepart/alldeptcheckboxtreeselect'; 
	           layer.dialog({
                    title: '选择组织部门',
                    area: ['328px', '600px'],
                    content: deptLink,
                    callback: function (data) {
                    	 if (data) { 
                           	$("#taskLeadDeptCode").val(data.orgCodesExcParent);
                           	$("#taskLeadDeptCodeName").val(data.orgNamesExcParent);
                         }
                     }
                })
			}
		},{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽查部门',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitsingnewselect?isPermissionCheck=true',
                    callback: function (data) { 
                		var returncode=data.codes;
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.names); 
                    }
                })
            }
        },{
             el: '#cancel',
             event: 'click',
             handler: function () {
	             $('#qryForm')[0].reset();
	             $("#taskLeadDeptCode").val("");
	             $("#taskLeadDeptCodeName").val("");
	             $("#depttaskEntCatgCode").val("");
	             $("#localAdm").val("");
             }
         },{
            el: '#checkAll',
            event: 'click',
            handler: function () {
	             var flag=$(this).prop("checked");
	             $("input:checkbox[name='_checkbox']").prop("checked", flag);
             }
          }])
    }

})
