require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

	var urlHead=window._CONFIG.urlHead;
    var ent_tb;
	var $searchForm=$("#searchForm");
	//loading
    var load=undefined;
    var params = {};//查询参数
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        createEntList(); 
    }
    
    //我的惩戒单列表
    function createEntList(){
    	ent_tb = dataTable.load({
            //需要初始化dataTable的dom元素
            el: "#ent_table",
            scrollX: true,
            ajax : {
                url :  urlHead+'/noCreditPunish/info/nocreditPunishSearch.json?type=ent',
                data : function(d) {
                	d.params = params;
                }
            },
            showIndex: true,
            columns: [
              	{data: '_idx', width:"80px", className: 'center'},
                {data: null, width:"80px", className: 'center'},
                {data: 'state', width:"80px", className: 'center'},                
                {data: 'auditTime', width:"120px"},
                {data: 'entName', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'uniCode', width:"130px"},
                {data: 'leRep', width:"120px",cut: {length: 20,mark:'...'}},
                {data: 'cardNo', width:"120px"},
                {data: 'legNo', width:"140px"},
                {data: 'legDate', width:"140px"},
                {data: 'punField', width:"150px"},
                {data: 'punCause', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'punMea', width:"150px",cut: {length: 20,mark:'...'}},
                {data: 'exeBegin', width:"160px", className: 'center'},
                {data: 'punExeDept', width:"130px"},
                {data: 'punReqDept', width:"130px"},
                {data: 'contact', width:"110px"},
                {data: 'phone', width:"110px"}
            ],
            columnDefs: [{
                    targets: 1,
                    render:function (data, type, row, meta) { 
                    	
                    	return '<a href="javascript:void(0);" class="viewdetail">详情</a>';
                    }
                },{
                    targets: 2,
                    render: function (data, type, row, meta) {
                      	var sysDate = $("#sysDate").val();
                    	var exeEnd = row.exeEnd == null  ? "" : row.exeEnd ;
                    	var exeBegin = row.exeBegin == null ? "" : row.exeBegin;
                    	var sysDatestr = new Date(sysDate.replace(/\-/g, "\/"));
                		if(exeEnd != null && exeEnd != "" ){
                			exeEnd = new Date(exeEnd.replace(/\-/g, "\/"));
                		}else{
                			
                		}
//                    	console(exeEnd != "" && exeEnd >=sysDatestr);
                    	if(data == "0"){
                    		return "无效";
                    	}else if(data == "2" ||(data == "1" && (exeEnd !="" && exeEnd>=sysDatestr))){
                    		return "有效";
                    	}else {
                    		return "无效";
                    	}
                    }
                },{
                    targets: 5,
                    render: function (data, type, row, meta) {
                    	if(data==""||data==null||data==undefined){
                    		return row.regNo;
                    	} else
                    		return data;
                    }
                },{
                    targets: 7,
                    render: function (data, type, row, meta) { 
                    	return switchCardNo(data); 
                    }
                },
                {
                    targets: 13,
                    render: function (data, type, row, meta) {
                    	if(row.isLife == "1"){ //终身有效
                    		return "终身有效";
                    	}else if(row.exeBegin != null && row.exeEnd !=null){
                    		return row.exeBegin+"至"+row.exeEnd;
                    	}else
                    		return "-"
                    }
                }
            ]
        })
    }
    
    
    //替换身份证号
    function switchCardNo(cardNo){
    	if(cardNo==null||cardNo==""){
    		return "";
    	}
    	var a=cardNo.substring(0,6);
    	var s="";
    	for(var v=0;v<cardNo.length-10;v++){
    		s+="*";
    	}
    	var b=cardNo.substring(cardNo.length-4,cardNo.length);
    	return  a+s+b; 
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){ 
    	params=$searchForm.serializeObject();
    	ent_tb.ajax.reload();
    	layer.close(load);
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
            el: '.js-more-query',
            event: 'click',
            handler: function () {
                if ($('.more-show').css("display") == "none") {
                    $('.js-more-query').attr('value', '收起');
                    $('.more-show').css("display", "block");
                } else {
                    $('.js-more-query').attr('value', '更多查询');
                    $('.more-show').css("display", "none");
                }
            }
        },{
            el: '.viewdetail',
            event: 'click',
            handler: function () {  
            	 var data = ent_tb.row($(this).closest('td')).data();
            	 var batchNo=data.batchNo;
                 layer.dialog({
                    title: '查看',
                    area: ['100%', '100%'],
                    content: urlHead+"/noCreditPunish/info/edit?deal=6&batchNo="+batchNo,
                    callback: function (data) {
                    	 
                    }
                })
            }
        }
        ])
    }

})

