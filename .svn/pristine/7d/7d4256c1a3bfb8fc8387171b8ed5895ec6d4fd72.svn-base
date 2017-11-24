require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    //时间控件初始化
    //laydate.skin('molv');//初始化皮肤 (墨绿)
    var start = {
        elem: '#startCogDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
        end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#endCogDate',
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
    
    var startNorDate = {
            elem: '#startNorDate', //选择ID为START的input
            format: 'YYYY-MM-DD', //自动生成的时间格式
            min: '1970-01-01', //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true, //必须填入时间
            istoday: false,  //是否是当天
            start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
            choose: function(datas){
            	endNorDate.min = datas; //开始日选好后，重置结束日的最小日期
            	endNorDate.start = datas //将结束日的初始值设定为开始日
            }
        };
        var endNorDate = {
            elem: '#endNorDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: '2099-06-16',
            istime: true,
            istoday: false,
            startNorDate: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
            	startNorDate.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        
        
        var startExtDate = {
                elem: '#startExtDate', //选择ID为START的input
                format: 'YYYY-MM-DD', //自动生成的时间格式
                min: '1970-01-01', //设定最小日期为当前日期
                max: '2099-06-16', //最大日期
                istime: true, //必须填入时间
                istoday: false,  //是否是当天
                start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
                choose: function(datas){
                endExtDate.min = datas; //开始日选好后，重置结束日的最小日期
                endExtDate.start = datas //将结束日的初始值设定为开始日
                }
            };
	     var endExtDate = {
	         elem: '#endExtDate',
	         format: 'YYYY-MM-DD',
	         min: '1970-01-01',
	         max: '2099-06-16',
	         istime: true,
	         istoday: false,
	         startExtDate: laydate.now(0,"YYYY-MM-DD"),
	         choose: function(datas){
	         startExtDate.max = datas; //结束日选好后，重置开始日的最大日期
	         }
	     };
    
    //开始时间和结束时间
    $("#startCogDate").click(function(){laydate(start);});
    $("#endCogDate").click(function(){laydate(end);}); 

    $("#startNorDate").click(function(){laydate(startNorDate);});
    $("#endNorDate").click(function(){laydate(endNorDate);});
    
    $("#startExtDate").click(function(){laydate(startExtDate);});
    $("#endExtDate").click(function(){laydate(endExtDate);});
    
    
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
        }


    var searchParams={};//查询参数声明!
    var table;

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
                url:'/reg/server/orderreformset/selectOrderReformSetListJSON.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [ 
                    {data: null,'defaultContent':'11'}, 
                  	{data: null, width:"100px" ,defaultContent:'id' },
    				{data: 'auditState',cut: {length: 20,mark:'...'}},
    				{data: 'efftStatus',cut: {length: 20,mark:'...'}},
    				{data: 'uniSCID',cut: {length: 20,mark:'...'}},
    				{data: 'regNo',cut: {length: 20,mark:'...'}},
    				{data: 'entName',cut: {length: 20,mark:'...'}},
    				{data: 'adminGuideType',cut: {length: 20,mark:'...'}},
    				{data: 'staDate',cut: {length: 20,mark:'...'}},
     				{data: 'endDate',cut: {length: 20,mark:'...'}},
    				{data: 'applyMan',cut: {length: 20,mark:'...'}},
    				{data: 'applyDate',cut: {length: 20,mark:'...'}},
    				{data: 'auditName',cut: {length: 20,mark:'...'}},
    				{data: 'auditDate',cut: {length: 20,mark:'...'}} 
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	 
                             	  if(row.auditState=='0'||row.auditState=='2'){
                                      return '<a href="javascript:void(0);" class="js-edit" id='+row.uid+' name='+row.entName+'>修改</a>'+
                                                    '&nbsp;<a href="javascript:void(0);" class="js-delete" id='+row.uid+'>删除</a>';
                                    }
                                    else if(row.auditState=='1'){
                                      return '<a href="javascript:void(0);" class="js-view" id='+row.uid+' >查看</a>'+
                                              '<a href="javascript:void(0);" class="js-sus" id='+row.uid+' >  中止</a>';
                                    }
                                    else{
                                      return '<a href="javascript:void(0);" class="js-view" id='+row.uid+' >查看</a>';
                                    }
                             }
                        },
                       	{   targets:2,
                    		render:function(data,type,row,meta){
	                    		if(row.auditState==''||isNaN(row.auditState))
	                    		{
	                    			return '';
	                    		}
	                    		else{
		                    		var txt = ['未审核','同意责令整改','退回修改','取消责令整改','中止'];
		                            return txt[row.auditState];
	                    		}
                    		}
                    	},
                       	{   targets:3,
                    		render:function(data,type,row,meta){
	                    	    if(data=='0'){
	                    		    return "无效";
	                    		}
	                    		else if(data=='1'){
	                                return '有效';
	                            }else if(data=='2'){
	                                return '流程中';
	                            }else {
	                            	return '';
	                            }
                    		}
                    	},
                       	{   targets:7,
                    		render:function(data,type,row,meta){
	                    	    if(data=='0'){
	                    		    return '其他';
	                    		}else if(data=='1'){
	                                return '逾期出资';
	                            }else if(data=='2'){
	                                return '法定代表人任职资格';
	                            }else if(data=='3'){
	                                return '许可证到期、被吊销、被撤销';
	                            }else if(data=='4'){
	                                return '经营期限到期';
	                            }else if(data=='5'){
	                                return '登记事项变更或备案';
	                            }
                    		}
                    	}
            ]
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '#orderReformSetApplyPage',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/orderreformset/orderReformSetApplyPage';
            }
        },{
            el: '.js-view',
            event: 'click',
            handler: function () {
            	var uid=this.id;
            	layer.dialog({
                    title: '查看',
                    area: ['80%', '88%'],
                    content: '/reg/server/orderreformset/orderReformSetAuditEditPage?uid='+uid+'&viewFlag=2',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.js-edit',
            event: 'click',
            handler: function () {
            	var uid=this.id;
            	var name=this.name;
            	layer.dialog({
                    title: '修改',
                    area: ['80%', '73%'],
                    content: '/reg/server/orderreformset/showOrderReformSetApplyEditPage?uid='+uid+'&viewFlag=1',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.js-sus',
            event: 'click',
            handler: function () {
            	var uid=this.id;
            	var name=this.name;
            	layer.dialog({
                    title: '中止',
                    area: ['80%', '73%'],
                    content: '/reg/server/orderreformset/orderReformSetAuditEditPage?uid='+uid+'&viewFlag=5',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '.js-delete',
            event: 'click',
            handler: function () { 
            	var uid=this.id;
            	layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: '/reg/server/orderreformset/deleteOrderReformSet',
	                    data: {uid: uid},
	                    success: function (data) {
	                        if (data.status == 'success') {  
	                                layer.msg("删除成功", {time: 1000}, function () {
	                                	table.ajax.reload();
	                                }); 
	                        }else{
	                        	layer.msg("删除失败", {ltype: 0,time:2000});
	                        } 
	                    }
	                });
                })
            }
        },{
            el: '.printsptable',
            event: 'click',
            handler: function () {
            	var busExcList=this.id;
            	 var _id = "_doPrint_"+new Date().getTime();
                 var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoMalyPrintspTable?busExcList="+busExcList;
                 try{
                     window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                 }catch(e){
                     alert("打印错误!");
                 } 
            }
        },{
            el: '.printspbook',
            event: 'click',
            handler: function () {
             	var busExcList=this.id;
           	    var _id = "_doPrint_"+new Date().getTime();
                var url = "/reg/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+busExcList;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () {  
                 layer.dialog({
                     title: '选择登记机关',
                     area: ['25%', '60%'],
                     content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                     callback: function (data) {
                    	var returncode=data.returncodes;
                     	var returnname=data.returnname;
                     	$("#regOrg").val(returncode);
                     	$("#regOrgName").val(returnname);
                     }
                 })
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['25%', '60%'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;	 
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(returnname);
                    }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val(""); 
            	$("#localAdm").val(""); 
            }
        }
        ]);
    }

})
