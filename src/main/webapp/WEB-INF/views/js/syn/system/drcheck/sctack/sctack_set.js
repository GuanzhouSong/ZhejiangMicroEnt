require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.validate','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
    	$.extend($.validator.messages, {
    		required: "这是必填字段",
    		digits: "只能输入数字",
    		min: $.validator.format("请输入不小于 {0} 的数值"),
    		maxlength: $.validator.format("最多可以输入 {0} 个字符")
    	});

     
        bind();
        formValid();
        
       
        
    }
    var start = {
            elem: '#startDate', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas; //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#endDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
    $("#startDate").click(function(){laydate(start);});
    $("#endDate").click(function(){laydate(end);});

    var searchParams={};//查询参数声明!
    var table;
    
 function initdeptTable(data){
	 var string="";
	 $.each(data,function(k,v){
		 var d=k+1;
		 string+="<tr><td>"+d+"</td><td>"+v.inspectDesc+"</td><td class='left'><div class='display-table'><span class='table-cell vm implDept' id="+v.inspectDept+" value="+v.inspectDesc+">"+v.inspectType+"</span><span class='table-cell right vm'><input type='button' class='btn btn-xs choseItem' title='"+v.inspectDept+"'  value='选择'></span></div></td></tr>"
	 });
	  
     $("#tableList").html(string);
 }
    /**
     * 实施部门构造函数
     */
	function initDept(inspectDept,inspectDesc,inspectType, inspectTypeDesc){
    	  this.inspectDept=inspectDept;
    	  this.inspectDesc=inspectDesc;
    	  this.inspectType=inspectType;
    	  this. inspectTypeDesc= inspectTypeDesc;
    }
    
    function  formValid(){
     
    	$("#sctickForm").validate({
    		onkeyup:false,
    		rules:{
    			taskName:{
    				maxlength:60
    			},
    			checkContent:{
    				maxlength:2000
    			}
    		},
    		showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#sctickForm input[name='+i+'],#sctickForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler:function(){
            	var impArray=new Array(); 
                var result;
              if($("#sctickForm input[name = 'catgCode']:checked").length == 0){
            	  layer.tips("请选择主体范围",$("#0"),{tips:3, tipsMore:true, ltype:0});
            	  return false;
              }
              $(".implDept").each(function(k,v){ 
            	  if(v.title==null||v.title==""){
            		  layer.tips("请选择检查事项",$("#"+v.id),{tips:3, tipsMore:true, ltype:0});
            		  result=0;
            	  }
            	 var deptl =new initDept(v.id,$("#"+v.id).attr("value"),v.title,$("#"+v.id).text());
            	   impArray.push(deptl);
              });
              if(result==0){
            	  return false;
              }
              
              var sctack={};
              var categCode=new Array();
              var categDesc=new Array();
              $(":checkbox[name=catgCode]:checked").each(function(k,v){
            	  categCode[k]= this.id;
            	  categDesc[k]=this.value;
               });
              
              sctack.taskName=$("#taskName").val();
              sctack.taskCode=$("#taskCode").val();
              sctack.leaderDeptCode=$("#leaderDeptCode").val();
              sctack.leaderDeptDesc=$("#leaderDeptDesc").val();
              sctack.taskEntCatgCode=categCode.toString();
               
              sctack.startDate=$("#startDate").val();
              sctack.endDate=$("#endDate").val();
              sctack.checkContent=$("#checkContent").val();
              sctack.deptNumber=$("#deptNumber").val();
              sctack.implDeptCode=$("#implDeptCode").val();
              sctack.implDeptDesc=$("#implDeptDesc").val();
              sctack.speckWay=$("#sctickForm input[name = 'speckWay']:checked").val();
              sctack.taskEntCatgDesc= categDesc.toString();
              sctack.implList=impArray;
	            http.httpRequest({
	            	url:"/syn/server/drcheck/scstack/toSet",
	            	dataType:"json",  
	                contentType : 'application/json;charset=utf-8',
	            	data: JSON.stringify(sctack),
	            	type:"post",
	            	success:function(data){ 
	            		layer.msg(data.msg, {time: 1000}, function () {
	 						if(data.status == 'success'){
	 							var  taskUid=data.data.taskUid;
	 							layer.close({reload: true,taskUid:taskUid});
	 						}
	 					});
	            	}
	            });
            },
    	});
    }
    
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            el: '#scstack-table',
            showIndex: true,
            ajax: {
                url:'/syn/server/drcheck/scstack/listJSON',
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            columns: [
                {data: null, 'className': 'center'},
                {data: null, 'className': 'center'}, 
                {data: 'taskName'},
                {data: 'taskName'},
                {data: 'taskName'},
                {data: 'taskName'},
                {data: 'taskName'},
                {data: 'taskName'},
                {data: 'taskName'},
                {data: 'taskName'}
            ],
            columnDefs: [ 
            ]
        })
    }

   

    function bind() {
        util.bindEvents([ 

      
      {
          el: '#choseImplDept',
          event: 'click',
          handler: function () { 
        	  var userType = $("#userType").val();
//        	  var deptLink = '/common/system/dept/tree/select?treeType='+'checkbox'; 
//        	  if(userType == '2'){
        		var  deptLink='/syn/system/sysdepart/alldeptcheckboxtreeselect'; 
//        	  }
              layer.dialog({
                  title: '选择任务实施部门',
                  area: ['328px', '600px'],
                  content: deptLink,
                  callback: function (data) {
                      if (data) {  
                      	$("#inspectDepts").val(data.orgCodesExcParent);
                      	$("#inspectDeptDescs").val(data.orgNamesExcParent); 
                      	$("#implDeptCode").val(data.orgCodesExcParent);
                      	$("#implDeptDesc").val(data.orgNamesExcParent);
                        var codes= data.orgCodesExcParent.split(",");
                      	var deptNames= data.orgNamesExcParent.split(",");
                    	var  arrays=new Array();  
                        for(var i=0;i<deptNames.length;i++){
                           var dept=new initDept(codes[i],deptNames[i],"未选择","");
                           arrays.push(dept);
                        }  
                          initdeptTable(arrays);  
                      }
                  }
              })
         }
     },{
                     el: '#cancel',
                     event: 'click',
                     handler: function () {
                     $('#sctickForm')[0].reset();
                     $("#tableList").html("");
                     }
           },{
                	 el:"#cancleEdit",
                	 event:'click',
                	 handler:function(){
                		 layer.close({reload:false});
                	 }
          },{
                el: '.choseItem',
                event: 'click',
                handler: function () {
                   var dptId= $(this).attr("title");
                   layer.dialog({
                       title: '选择检查项',
                       area: ['80%', '80%'],
                       content: '/syn/drcheck/syn/server/sctype/toTreePage?dptId='+dptId,
                       callback: function (data) {
                           var data=data.reload; 
                           $("#"+data.returnId).text(data.returnname);
                           $("#"+data.returnId).attr("title",data.retruncode);
                       }
                   })
                 }
              }
        ])}
    
    $(":radio[name=_checkobx]").click(function(){
   	 var type=new Array();
   	$(":radio[name=_checkobx]:checked").each(function(k,v) {
           type[k]=$(this).val();
       }); 
   	http.httpRequest({
			url: '/commom/server/entcatg/selectEntcatgByCation',
			serializable: false, 
			 contentType : 'application/json;charset=utf-8', //设置请求头信息
            dataType:"json",
			data:JSON.stringify(type),
			type:"post",
			success: function (data) { 
            var data=data.data;
            var string="";
            $.each(data,function(k,v){
           	 string+="<option value="+v.code+">"+v.content+"</option>"
           	 
            });
            $("#taskEntCatgCode").html(string);
            
			}
		}); 
   	
   });
    

})
