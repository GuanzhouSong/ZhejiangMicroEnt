require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        formValidate();
        initDataTable();
    }
    
	function initDataTable() {
		table = dataTable.load({
		el : '#ent-apply-edit',
		showIndex: false,
		scrollX: true,
		ajax : {
			type : "post",
			url : '/syn/risk/csentwarn/list.json',
			data : function(d) {
				d.params = {"batchNo":$('#batchNo').val()};
			}
		},
		columns : [
		    {data: null, width:'60px',className: 'center'},
		    {data : 'uniscid',width:'120px', className: 'center'},
			{data : 'regNO',width:'100px', className: 'center'}, 
			{data : 'entName',width:'150px', className: 'center'},
			{data : 'leRep',width:'80px', className: 'center'}, 
			{data : 'entType',width:'100px', className: 'center'}, 
			{data : 'industryCo',width:'100px', className: 'center'}, 
			{data : 'dom',width:'120px', className: 'center'}, 
			{data : 'regOrg',width:'120px', className: 'center'}, 
			{data : 'localAdm',width:'120px', className: 'center'}, 
			{data : null,width:'120px',className: 'center'}
		],
		columnDefs : [
      {
	   targets: 0,
        render: function (data, type, row, meta) {
    	    return "<input type='checkbox' class='chb'>";
        }
    } , {
 	   targets: 10,
       render: function (data, type, row, meta) {
    	   if(row.isWarnHis=='1')
    		   return "<a href='javascript:void(0)' class='mr10 lookhis' id='"+row.priPID+"'>有</a>"; 
    	   else 
   	           return "无";
       }
   }            
		  ]
	  })
	}
	
	
	
	 function formValidate(){
	    	$('#editForm').validate({
	    		rules: {
	    			markName:{required:true,maxlength:20},//重点监管标识名称
	    			markStartDate:{required:true},//重点监管标识有效期
	    			markEndDate:{required:true},//重点监管标识有效期
	    			markContent:{required:true,maxlength:200},//重点监管标识内容
	    			markAppointDept:{
	    				required:{
	    					depends:function(){
	    						 return '1' == $('#markAppointWay').val();
	    					}
	    				}
	    			},
	    			setDeptContact:{required:true,maxlength:10},//设置部门联系人
	    			tel:{required:true,maxlength:15},//联系电话
	    			fax:{maxlength:30},//传真
	    			email:{email:true,maxlength:30}//邮箱
	    		},
	    		onkeyup:false,
	            showErrors:function(errorMap,errorList){
	           	 for(var i in errorMap){
	                 layer.tips(errorMap[i],$('#editForm input[name='+i+'],textarea[name='+i+']'),{
	                     tips:3,
	                     tipsMore:true,
	                     ltype:0
	                 });
	              }
	            },
	            submitHandler: function () {
	                var formParam = $('#editForm').serializeObject();
	                http.httpRequest({
	                    url: '/syn/risk/cswarnmark/save',
	                    serializable: true,
	                    data: formParam,
	                    type: 'post',
	                    success: function (data) {
	                        layer.msg(data.msg, {time: 1000}, function () {
	                        	if(data.status=='success')
	                        	   window.location.href='/syn/risk/csentwarn/applylist';
	                        });
	                    }
	                });
	            }
	        });
	    }
	
	 
	    var markAppointDeptCode='';
	    var markAppointDept='';
	    if($('#markAppointWay').val()=='1'){
	    	markAppointDeptCode = $('#markAppointDeptCode').val();
	    	markAppointDept = $('#markAppointDept').val();
	    	$('.js-show').css('display','block');
	    } 
	    $('#markAppointWay').on('change',function(){
	    	if($(this).val()=='1'){
	    		$('#markAppointDept').val(markAppointDept);
	    		$('#markAppointDeptCode').val(markAppointDeptCode);
	    		$('.js-show').css('display','block');
	    	}else{
	    		$('#markAppointDept').val('');
	    		$('#markAppointDeptCode').val('');
	    		$('.js-show').css('display','none');
	    	}
	    });
	 
	 
	 
    function bind() {
        util.bindEvents([
                         {
            el: '#addEnt',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '添加申请企业企业',
                    area: ['80%', '85%'],
                    content: '/syn/risk/csentwarn/enaddent?batchNo='+$('#batchNo').val()+'&markNo='+$('#markNo').val()+'&checkState='+$('#checkState').val(),
                    callback: function (data) {
                        //重新加载列表数据
                    	if(data.reload == true){
                		table.ajax.reload();
                	  }
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href='/syn/risk/csentwarn/applylist';
            }
        },{
            el: '#delData',
            event: 'click',
            handler: function () {
            	var arr='';
             	 $('.chb').each(function(){ 
             		var flag =true;
             		var data = table.row($(this).closest('td')).data();
                 	 if($(this).is(':checked')){
                 		arr = arr +data.priPID+ ','; 
             		 }
          		 });
             	 if(arr==''){
             		layer.msg('请选择企业！');return;
             	 } 
             layer.confirm('确定要删除选中记录吗?', {icon: 3, title: '温馨提示'}, function (index) {
                layer.close(index);
             	http.httpRequest({
                    url: '/syn/risk/csentwarn/delapplyent',
                    serializable: false,
                    data: {'arr':arr},
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	table.ajax.reload();
                        });
                    }
                });
              });
            }
        },{
            el: '.lookhis',
            event: 'click',
            handler: function () {
            	layer.dialog({
                    title: '查看历史',
                    area: ['70%', '60%'],
                    content: '/syn/risk/csentwarn/getentwarnhis?priPID='+this.id,
                    callback: function (data) {
                    }
                })
            }
        },{
            el: '#selectMarkSetDept',
            event: 'click',
            handler: function () {
            	doSelectWarnMarkSetDept();
            }
        }
        ]);
    }
    
    
    //选择部门
    function doSelectWarnMarkSetDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择设置部门',
            area: ['350px', '666px'],
            content: select_dept_url,
            callback: function (data) {
            	var orgCode = data.orgCodesExcParent;
            	var deptName = data.orgNamesExcParent;
                    $("#markAppointDept").val(deptName);
                    $("#markAppointDeptCode").val(orgCode);
                }
        })
    }
    
    
})
