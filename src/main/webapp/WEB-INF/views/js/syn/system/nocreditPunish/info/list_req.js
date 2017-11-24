require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

	var urlHead=window._CONFIG.urlHead;
    var myent_tb;
	var $searchForm=$("#searchForm");
	var params =$searchForm.serializeObject();//查询参数
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        createMyEntList();
    }
    
    //我的惩戒单列表
    function createMyEntList(){
    	myent_tb = dataTable.load({
            //需要初始化dataTable的dom元素
            el: "#myent_table",
            scrollX: true,
            ajax : {
                url: urlHead+'/noCreditPunish/info/mylist.json',
                data : function(d) {
                	d.params = params;
                }
            },
            showIndex: true,
            columns: [
              	{data: '_idx', width:"80px", className: 'center'},
                {data: null, width:"80px", className: 'center'},
                {data: 'state', width:"60px",cut: {length: 20,mark:'...'}},
                {data: 'punType', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'entName', width:"120px",cut: {length: 20,mark:'...'}},
                {data: 'uniCode', width:"140px",cut: {length: 20,mark:'...'}},
                {data: 'legNo', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'punField', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'punCause', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'punMea', width:"130px",cut: {length: 20,mark:'...'}},
                {data: 'exeBegin', width:"160px", className: 'center',cut: {length: 20,mark:'...'}},
                {data: 'punExeDept', width:"130px",cut: {length: 20,mark:'...'}},
                {data: 'punReqDept', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'punReqUser', width:"110px",cut: {length: 20,mark:'...'}},
                {data: 'createTime', width:"110px",cut: {length: 20,mark:'...'}},
                {data: 'auditor', width:"110px",cut: {length: 20,mark:'...'}},
                {data: 'auditTime', width:"130px",cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [{
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	if(row.auditRes=="-"||row.auditRes==null||row.auditRes==""||row.auditRes=="-1"){
                    		var url=urlHead+"/noCreditPunish/info/editpage?batchNo="+row.batchNo;
	                		var htmlStr= '<a href="'+url+'" style="color:#003399">修改</a>';
	                		htmlStr+='<a href="javascript:void(0);" class="delete" style="color:#003399">删除</a>'
	                		return htmlStr;
                    	}else  if(row.auditRes=="2"){
	                		var url=urlHead+"/noCreditPunish/info/editpage?batchNo="+row.batchNo;
	                		return '<a href="'+url+'" style="color:#003399">修改</a>';
	                    }else if(row.auditRes=="0"){
	                    	var url=urlHead+"/noCreditPunish/info/edit?deal=5&batchNo="+row.batchNo;
	                    	return '<a href="'+url+'">详情</a>'; 
	                    }
                    }
                },
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                    	if(data=="ent"){ 
                    		return "企业";
                    	}else if(data=="man") {
                    		return "自然人";
                    	}else{
                    		return "";
                    	}
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                    	var auditRes=row.auditRes;
                    	if (auditRes==null||auditRes=="-"||auditRes==""||auditRes=="-1") {
                    		return "待审核";
                    	}else if(auditRes=="0"){
                    		return "审核通过";
                    	}else if(auditRes=="2"){
                    		return "审核退回";
                    	}else{
                    		return "";
                    	}
                    }
                },
                /*{
                    targets: 4,
                    render: function (data, type, row, meta) {
                    	var punType=row.punType;
                    	if (punType=="ent") {
                    		return row.entName;
                    	}else if(punType=="man"){
                    		return row.litiName;
                    	}else{
                    		return "";
                    	}
                    }
                },*/
                {
                    targets: 5,
                    render: function (data, type, row, meta) {
                    	var punType=row.punType;
                    	var c="";
                    	if (punType=="ent") {
                    		c=row.uniCode;
                    		if(c!=null&&c.length>20){
                    			c=c.substring(0,20) ;
                    			var ht="<span title='"+row.uniCode+"'> "+c+" </span>" ;
                    			return ht;
                    		} 
                    		return c;
                    	}else if(punType=="man"){ 
                    		var c=row.cardNo;
                    		if(c!=null&&c.length>20){
                    			c=c.substring(0,20) ;
                    			var ht="<span title='"+row.cardNo+"'> "+c+" </span>" ;
                    			return ht;
                    		} 
                    		return c;
                    	}else{
                    		return "";
                    	}
                    }
                },{
                    targets: 10,
                    render: function (data, type, row, meta) {
                    	if(row.isLife != null && row.isLife !=""&&row.isLife=="1"){
                    		return "终身有效";
                    	}else  if(row.exeBegin != null && row.exeEnd!=null){
                    		return row.exeBegin+"至"+row.exeEnd;
                    	}else{
                    		return "-"
                    	}
                    }
                }
            ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	var ivalStr="";
    	$(":checkbox[name=punTypeStr]:checked").each(function(k,v){
        	var ival=this.value;
        	ivalStr+=ival+",";
        });
    	$("#proveType").val(ivalStr); 
    	params=$searchForm.serializeObject();
    	myent_tb.ajax.reload();
    });
    $("#rest").click(function() {
    	$searchForm[0].reset();
    	$("#punReqDeptCode").val("");
    	$("#punExeDeptCode").val("");
	});
    
    // 部门单选
    function doSelectExeDeptCode() {
        layer.dialog({
            title: '选择惩戒执行部门',
            area: ['350px', '666px'],
            content: window._CONFIG.select_dept_url,
            callback: function(data) {
            	if(data.adCode!=null&&data.orgName!=null){
                    $("#punExeDept").val(data.orgName);
                    $("#punExeDeptCode").val(data.adCode);
                }
            }
        })
    }
    
    // 添加
    function entrance() {
        layer.dialog({
            title: '选择惩戒对象型',
            area: ['350px', '170px'],
            content: urlHead+'/noCreditPunish/info/entrance',
            callback: function(data) {
            	if(data.url !=undefined){
            		try {
                    	window.location.href=data.url;
        			} catch (e) {
        				window.open(data.url, "_self");
        			}
            	}
            }
        })
    }
    
    function doSelectReqDeptCode() {
        layer.dialog({
            title: '选择惩戒提请部门',
            area: ['350px', '666px'],
            content: window._CONFIG.select_dept_url,
            callback: function(data) {
            	if(data.adCode!=null&&data.orgName!=null){
                    $("#punReqDept").val(data.orgName);
                    $("#punReqDeptCode").val(data.adCode);
                }
            }
        })
    }
    
    $("#selectRule").click(function(){
    	layer.dialog({
            title: '选择事由..',
            area: ['900px', '600px'],
            content: urlHead+'/noCreditPunish/rule/selectrule',
            callback: function(data) {
            	if(data.punCause !=undefined){
                	$("#punCause").val(data.punCause);
            	}
            }
        })
    })
    $("#selectMea").click(function(){
    	layer.dialog({
            title: '选择措施..',
            area: ['900px', '600px'],
            content: urlHead+'/noCreditPunish/rule/selectrule',
            callback: function(data) {
            	if(data.punMea !=undefined){
                	$("#punMea").val(data.punMea);
            	}
            }
        })
    })

    function bind() {
        util.bindEvents([{
            el: '#add',
            event: 'click',
            handler: function() {
            	entrance();
            }
        }, {
            el: '#selectPunReqDept',
            event: 'click',
            handler: function() {
            	doSelectReqDeptCode();
            }
        }, {
            el: '#selectPunExeDept',
            event: 'click',
            handler: function() {
            	doSelectExeDeptCode();
            }
        },
        {
            el: '#more',
            event: 'click',
            handler: function () { 
                var isHideOrShow = $("#hideorshow").is(":hidden");
            	if(isHideOrShow){
            		 $("#more").val("收起");
            		 $("#hideorshow").css("display","block");
				}else{
					$("#more").val("更多查询条件");
            		$("#hideorshow").css("display","none");
				}
            }
        },
        {
            el: '.delete',
            event: 'click',
            handler: function () { 
            	
            	var data = myent_tb.row($(this).closest('td')).data(); 
            	var batchNo=data.batchNo;
            	layer.confirm('确定要删除吗?', {icon: 3, title: '提示'}, function () { 
	                http.httpRequest({
	                    type: 'post',
	                    url: urlHead+'/noCreditPunish/info/delete',
	                    data: {batchNo: batchNo},
	                    success: function (data) {
	                        if (data.status == 'success') {  
	                                layer.msg("删除成功", {time: 1000}, function () {
	                                	myent_tb.ajax.reload();
	                                }); 
	                        }else{
	                        	layer.msg("删除失败", {ltype: 0,time:2000});
	                        } 
	                    }
	                });
                })
            }
        }
        ])
    }

})
