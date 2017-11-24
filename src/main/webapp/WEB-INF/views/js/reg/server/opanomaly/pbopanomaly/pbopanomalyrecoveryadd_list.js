require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
    var searchFlag = 0;
    init();
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
      }


    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = 1;
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/opanomaly/pbopadetail/addPbopanomalyRecoveryList.json',
                data:function(d){
                    d.params = searchParams;
                }
            },
            columns: [
				{data: null,defaultContent:'id',width:'24px', className: 'center'},
				{data: null},
				{data: 'regNO'},
				{data: 'entName',className: 'left',cut: {length: 20,mark:'...'}},
				{data: 'leRep'},
				{data: 'excpStaResCN',cut: {length: 20,mark:'...'}},
				{data: 'cogDate'},
				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
				{data: 'regOrgName',className: 'left',cut: {length: 20,mark:'...'}},
				{data: 'localAdmName',className: 'left',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
						return "<input type='radio' busExcList="+row.busExcList+" class='_radio' name='_radio'>";
 					}
 				 },
 				{
 					targets:2,
 					render:function(data,type,row,meta){
						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
  				 }
             ]
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	clickFlag = true;
    	searchParams = $("#taskForm").serializeObject();
    	if(searchFlag == 0){
    		initDataTable();
    	}else{
            table.ajax.reload();
    	}
    }); 
    
    function bind() {
        util.bindEvents([
        	{
                el: '#ret',
                event: 'click',
                handler: function () {
                	window.location.href='/reg/server/opanomaly/pbopadetail/pbopanomalyRecoveryApp';
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
                        	var returnname=data.returnname;	 
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(returnname);
                        }
                    })
                }
            },{
                el: '#add',
                event: 'click',
                handler: function () {
                	var _radio = $("input[name='_radio']:checked");
                	if(_radio.length!=0){
                		var busExcList = _radio.attr("busExcList");
                		if(busExcList!=null && busExcList != ''){
    	            		layer.dialog({
    	                        title: '申请恢复正常记载',
    	                        area: ['80%', '80%'],
    	                        content:'/reg/server/opanomaly/pbopadetail/recoveryPbOpadetail?busExcList='+busExcList,
    	                        callback: function (data) {
    	                            if (data.reload) { 
    	                            	 table.ajax.reload();  
    	                            }
    	                        }
    	                    })
                		}
                	}else{
                		layer.msg("请选择企业再操作", {ltype: 0,time:2000});
                	}
                }
            },{
                el: '#select-intercept-in',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '标记原因',
                        area: ['580px', '300px'],
                        content: '/commom/server/intercept/interceptselectmuti?selecttype=indiInReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#excpStaRes").val(data.id);
                                $("#excpStaResText").val(data.text);
                            }
                        }
                    })
                }
            },
            {
                el: '#reset', //重置
                event: 'click',
                handler: function () {
                	$('.hidden_input').val('');//重置隐藏域
                	$('#regOrg').val($('#rocode').val());
                	$("#regOrgName").val($('#rocontent').val());
                }
        }])
    }

})
