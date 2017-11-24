require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
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
    var clickFlag = false ;
    
    /**
     * 初始化dataTable
     */
    function initDataTable() { 
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:window._CONFIG.chooseUrl+'/pubdtinfo/searchlist.json',
                data:function(d){
                	if(clickFlag){
                		d.params = $.extend({}, searchParams, {"claimFlag" : 1});               		
                	}else{
                		d.params = {"claimFlag" : 1};
                	}
                }
            },
            columns: [
                      {data: null,defaultContent:'id',width:'20px', className: 'center'},
                      {data: null,defaultContent:'priPID',width:'20px', className: 'center'},
                      {data: null,defaultContent:'id',width:'20px', className: 'center'},//警示图标
                      {data: null,defaultContent:'id',width:'20px', className: 'center'},//操作：认领、接收、详情
                      {data: 'exaName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'entName',width:'20px',cut: {length: 15,mark:'...'}},
                      {data: 'leRep',width:'20px',cut: {length: 15,mark:'...'}},
                      {data: 'regOrgName',width:'20px',cut: {length: 15,mark:'...'}},
                      {data: 'checkPushDate',width:'20px'},
                      {data: 'checkRegType',width:'20px'},
                      {data: 'claimDate',width:'20px'},
                      {data: 'acceptDate',width:'20px'},                      
                      {data: 'checkDeptType',width:'20px'},
                      {data: 'deptName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'checkDepName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'dutyDeptName',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'uniSCID',width:'20px'},
                      {data: 'regNO',width:'20px'},
                      {data: 'claimCode',width:'20px'},
                      {data: 'acceptUser',width:'20px'},
                      {data: 'reassignAccount',width:'20px'},
                      {data: 'reassignDate',width:'20px'},
                      {data: 'reassignRemark',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'tel',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'opScope',width:'200px',cut: {length: 20,mark:'...'}},
                      {data: 'dom',width:'20px',cut: {length: 20,mark:'...'}},
                      {data: 'domDistrictName',width:'20px',cut: {length: 20,mark:'...'}} 
            ],
             columnDefs : [
							{
								targets : 1,
								render : function(data, type, row, meta) {
									if( row.claimState == '1' || row.receiveState == '1' ){
						        		return "<input value='" + row.uid + "' name = 'checkboxlist' disabled='disabled' type='checkbox' />";
									}else{
									    return "<input value='" + row.uid + "' name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
									}	
								}
							},
							{
								targets : 2,
								render : function(data, type, row, meta) {
									//已经认领和接收了的审批事项警示图标显示 “勾”
					            	if(row.claimState == '1'|| row.receiveState == '1'){
					            		return '<i class="xbt-icon right-icon lamp"></i>';
					            	}else{
		 			            	var greenDate = row.greenDate;
//		 			            	console.log(greenDate)
		 			             	var green = new Date(greenDate.replace("-", "/").replace("-", "/"));
		 			            	var yellowDate = row.yellowDate;
//		 			            	console.log(yellowDate)
		 			             	var yellow = new Date(yellowDate.replace("-", "/").replace("-", "/"));
//		 			            	console.log(yellow)
		 			            	var beginYear = new Date().getFullYear().toString();
					                var beginMonth = (new Date().getMonth() + 1).toString();
					                var beginDay = new Date().getDate().toString();
					                var now = new Date((beginYear +"-"+ beginMonth +"-" + beginDay).replace(/\-/g, "\/"));
//		 			            	console.log(now)
					                if( row.claimState == '1' || row.checkDeptType != '1'){
										return '<i class="xbt-icon blue-lamp lamp"></i>'; 
									}else {
										if(now < green ){
											return '<i class="xbt-icon blue-lamp lamp"></i>'; 
										}else if(( now = green && now < yellow ) ||(now >green && now < yellow )){
											return "<i class='xbt-icon yellow-lamp lamp'></i>"; 
										}else{
											return "<i class='xbt-icon red-lamp lamp'></i>";
										}
									} 
								}
								}
							},
							{
								targets : 3 ,
								render : function(data, type, row, meta) {
									if(row.checkDeptType == '1' && row.claimState == '0'){
					            		return '<a class="mod " uid="'+row.uid+'" priPID="'+ row.priPID +'" href="javascript:void(0);"  style="color:red">认领</a>' ;
									}else if(row.checkDeptType != '1' && row.receiveState == '0'){
					            		return '<a class="mod" uid="'+row.uid+'" priPID="'+ row.priPID +'" href="javascript:void(0);"  style="color:red">接收</a>';
									}else{
					            		return '<a class="view" uid="'+row.uid+'" priPID="'+ row.priPID +'" href="javascript:void(0);"  style="color:red">详情</a>'; 
									}	
								}
							},
							{
								targets : 12,
								render : function(data, type, row, meta) {
									if (row.checkDeptType == '1') {
										return "审批机关";
									}else if (row.checkDeptType == '2') {
										return "属地机关";
									}else if (row.checkDeptType == '3'){
										return "同级机关";
									}else{
										return "";
									}
								}
							},
							{
								targets : 9,
								render : function(data, type, row, meta) {
									if (row.checkRegType == '1') {
										return "新增许可事项";
									}else if (row.checkRegType == '2') {
										return "变更许可事项";
									}else{
										return "";
									}
								}
							}]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	clickFlag = true;  
        table.ajax.reload(); 
    }); 

    function bind() {
        util.bindEvents([{//查看
        	  el: '.view',
              event: 'click',
              handler: function () {
              	var data = table.row($(this).closest('td')).data();
                  layer.dialog({
                      title: '',
                      area: ['65%', '68%'],
                      content: window._CONFIG.chooseUrl+'/pubdtinfo/searchDetailInfo?priPId='+data.priPID+'&uid='+data.uid,
                      callback: function (data) {
                      }
                  })
              }
        },
        {
      	  el: '#checkAll',  //全选
            event: 'click',
            handler: function () {
            	var allChecked= $("#checkAll").prop("checked");   
            	$(".chb").prop("checked", allChecked);
            }
      },
      {
      	  el: '#selectLocalAdm',  //全选
            event: 'click',
            handler: function () {
            	 layer.dialog({
                     title: '选择管辖单位',
                     area: ['400px', '600px'],
                     content: '/commom/server/regunit/regunitmutiselectnocheck',
                     callback: function (data) {
                         $("#localAdm").val('');
                         $("#localAdmName").val('');
                         $("#localAdm").val(data.returncodes);
                         $("#localAdmName").val(data.returnname);
                     }
                 })
            }
      },
      {
    	  el: '.mod',  //单个认领或接收
          event: 'click',
          handler: function () {
            var data = table.row($(this).closest('td')).data();
              layer.dialog({
                  title: '',
                  area: ['65%', '70%'],
                  content: window._CONFIG.chooseUrl+'/pubdtinfo/receive?priPId='+data.priPID+'&uid='+data.uid,
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
  	  el: '#receiveAll',//批量认领或接收
        event: 'click',
        handler: function () {
            var ids=new Array();
            $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
           	ids[k]=this.value; 
            });
            
            if(ids[0]==""||ids[0]==null){
                layer.msg("请您<em style='color: red;'>【至少选择一条】</em>进行认领或接收!", {icon: 7,time: 1000});
           	 return false;
            }
          
           layer.confirm('确定认领或接收选中的<em style="color: red;">'+ids.length+'</em>数据吗？', {
               icon: 2,
               title: '提示'
           },
           function(index) {
        	   http.httpRequest({
                   url: window._CONFIG.chooseUrl+'/pubdtinfo/doreceiveRtn',
                   data: {
                   	uids:ids.toString()
                   },
                   type: 'post',
                   success: function(data) {  
                	   if (data.status == 'success') {
                           //重新加载列表数据
                           if (data.msg) {
                               layer.alert('您本次认领/接收到涉证企业信息<em style="color: red;">' + ids.length + '</em>条,本年度累计认领/接收<em style="color: red;">' + data.data + '</em>条', {closeBtn: 0},
                               function (index) {
                                   layer.close(index);
                                   table.ajax.reload();
                               });
                           }
                       } else {
                           if (data.msg) {
                               layer.msg(data.msg, {
                                   time: 500
                               },
                               function() {
                                   table.ajax.reload();
                               });
                           }
                       }
                   }
               });

           });
        }
  },
  {
      el: '#yccodetree',
      event: 'click',
      handler: function () { 
          layer.dialog({
              title: '选择后置审批事项',
              area: ['500px', '600px'],
              content: window._CONFIG.chooseUrl+'/pubdtinfo/codeLicenseCheckboxTreePage',
              callback: function (data) { 
              	if(typeof data.reload.code=="undefined"){
            		$("#exaCode").val("");
                 	$("#exaName").val("");
            	}else{
            		 $("#exaCode").val(data.reload.code);
                 	 $("#exaName").val(data.reload.content);
            	}
              }
          })
      }
  },{
      el: '#choseorgReg', //登记机关
      event: 'click',
      handler: function () { 
    	  layer.dialog({
              title: '选择登记机关',
              area: ['400px', '600px'],
              content: '/commom/server/regorg/regorgmutiselect',
              callback: function (data) { 
              	
              	var returncode=data.returncode;
              	var returnname=data.returnname;
              	if(returncode!=null&&returncode!=""){
              		returncode=returncode.substr(0,returncode.length-1); 
              	}
              	$("#regOrg").val(returncode);
              	$("#regOrgName").val(returnname);
              }
          })
      }
  },{
      el: '#reset', //重置
      event: 'click',
      handler: function () { 
      	$('.hidden_input').val('');//重置隐藏域
      }
  }
        ])
    }

})
