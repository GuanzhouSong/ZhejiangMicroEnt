require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function(layer, dataTable, util, http) {
	
	var urlHead=window._CONFIG.urlHead;
	var isSearch="1";
	var searchParams = $("#taskForm").serializeObject();//查询参数声明!
	init();
	
	/**
     * 初始化函数集合
     */
    function init() {
        //formValid();
        bind();
    }
    
    //类型（企业，自然人）
    var type=$("#type").val();
    
    //信息json，以便确定后给dialog外部使用
    var infojson={};
    
    //查询
    function searchMan() {
    	var keyword=$("#keyword").val();
    	if (keyword.replace(/(^\s*)|(\s*$)/g, "") != "") {
    		$.ajax({
	    		type : "POST",
				url : urlHead+'/noCreditPunish/info/getMan',
				datatype : 'JSON',
				data : {"keyword":keyword},
				async : true,
				success : function(json) { 
					if(json != ""&&json != null){
						$("#litiName").val(json.litiName);
						//cardTrans(json.cerType);
						$("#phone").val(json.phone);
						$("#cardNo").val(json.cardNo);
						//detailManExist(json.cardNo, "man"); 
						createList(json.cardNo,"man");
					}else{
						$("#litiName").val(""); 
						$("#phone").val("");
						$("#cardNo").val("");
						layer.msg("没有查询到结果", {time: 1500}, function() {});
					} 	
				}
    		});
    	}
    }
    
    function cardTrans(code) {
    	$("#"+code).attr("selected","selected");
    }
    
  //监听text内容改变事件
    /*$("#keyword").bind('blur',function(){
    	detailManExist($("#keyword").val().replace(/(^\s*)|(\s*$)/g, ""), "man");
	});*/
    
    
    //惩戒单列表
    function createList(pripid,punType){  
    	$("#key").val(pripid);
    	$("#type").val(punType); 
    	searchParams = $("#taskForm").serializeObject();
    	if("0"==isSearch){
    		list_tb.ajax.reload();
    	}else{
    		isSearch="0";
    		list_tb = dataTable.load({
                //需要初始化dataTable的dom元素
                el: "#record_table",
                "paging": false,
                scrollX: true,
                ajax : {
                    url : urlHead+'/noCreditPunish/info/recordlist.json',
                    data:function(d){
                        d.params = searchParams;
                     }
                },
                showIndex: true,
                columns: [
                  	{data: '_idx', width:"80px", className: 'center'},
                    {data: 'legNo', width:"80px", className: 'center'},
                    {data: 'legDate', width:"150px"},
                    {data: 'punField', width:"120px"},
                    {data: 'punCause', width:"90px", className: 'center'},
                    {data: 'punMea', width:"140px"},
                    {data: 'exeBegin', width:"150px"},
                    {data: 'punExeDept', width:"150px"},
                    {data: 'punReqDept', width:"150px"},
                    {data: 'punReqUser', width:"130px"},
                    {data: 'createTime', width:"150px", className: 'center'},
                    {data: 'auditor', width:"130px"},
                    {data: 'auditTime', width:"150px"} 
                ],
                columnDefs: [{
                        targets: 6,
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
            list_tb.on('xhr.dt',function(e,settings,json,xhr){
    		$('#record_table_wrapper .bottom').hide();
    		$("#totalCount").text(json.recordsTotal); 
            })
    	}
    }
    
    //查询是否有惩戒记录
    function detailManExist(key, type) {
    	$.ajax({
    		type : "POST",
			url : urlHead+'/noCreditPunish/info/detailExist',
			datatype : 'JSON',
			data : {"key":key, "type":type},
			async : true,
			success : function(json) {
				if(json=="exist"){
					infojson.record="有";
					$("#record").val("有")
				}else {
					$("#record").val("无");
					infojson.record="无";
				}
			}
    	});
    }
    
    //提交
    function submit(){
    	var card=$.trim($("#keyword").val()); 
    	var name=$.trim($("#litiName").val());
    	if(card==""||name==""){ 
    		layer.msg("请先查询出您要执行惩戒的自然人再提交!", {ltype: 0,time:3000}); 
        	return false;
    	}  
    	var cerType=$.trim($("#cerType").val());
    	var phone=$.trim($("#phone").val());
    	infojson.litiName=name ;
    	infojson.cardNo=card;
    	infojson.cerType=cerType;
    	infojson.phone=phone; 
    	infojson.recordCount=$("#totalCount").text(); 
    	layer.close(infojson);
    }
    
    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#searchMan',
            event: 'click',
            handler: function() {
            	searchMan();
            }
        }, {
            el: '#confirm',
            event: 'click',
            handler: function() {
            	submit();
            }
        }, {
            el: '#close',
            event: 'click',
            handler: function() {
            	layer.close();
            }
        }])
    }
   
});