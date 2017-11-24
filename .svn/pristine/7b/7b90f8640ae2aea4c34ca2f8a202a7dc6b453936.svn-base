require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function(layer, dataTable, util, http) {
	var list_tb;
	var urlHead=window._CONFIG.urlHead;
	var searchParams = $("#taskForm").serializeObject();//查询参数声明!
	var isSearch="1";
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
    function searchEnt() {
    	var name=$("#keyword").val();
    	if (name.replace(/(^\s*)|(\s*$)/g, "") != "") {
    		$.ajax({
	    		type : "POST",
				url : urlHead+'/noCreditPunish/info/getEnt',
				datatype : 'JSON',
				data : {"entName":name},
				async : true,
				success : function(json) {
					
					
					if(json != ""&&json != null){
						infojson= json;
						if(json.uniCode!=null&&json.uniCode!=""){
							json.reguniCode=json.uniCode;
						}else{
							json.reguniCode=json.regNo;
						}
						$("#uniCode").val(json.uniCode);
						$("#leRep").val(json.leRep);
						$("#cerType").val(json.cerType);
						$("#cerTypeDesc").val(cardTrans(json.cerType));
						$("#cardNo").val(json.cardNo);
						$("#priPID").val(json.priPID);
						$("#entName").val(json.entName);
						//detailEntExist(json.priPID, "ent"); 
						createList(json.priPID,"ent");
						//$("#confirm").show();
					}else{
						$("#uniCode").val("");
						$("#leRep").val("");
						$("#cerType").val("");
						$("#cerTypeDesc").val("");
						$("#cardNo").val("");
						$("#priPID").val("");
						$("#entName").val("");
						layer.msg("没有查询到结果", {time: 1500}, function() {});
					}
						
				}
    		});
    	}
    }
    
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
    
    
    function cardTrans(code) {
    	if(code=="10"){
    		return "居民身份证";
    	}else if(code=="20"){
    		return "军官证";
    	}else if(code=="30"){
    		return "警官证";
    	}else if(code=="40"){
    		return "外国(地区)护照";
    	}else if(code=="52"){
    		return "香港身份证";
    	}else if(code=="54"){
    		return "澳门身份证";
    	}else if(code=="56"){
    		return "台湾身份证";
    	}else if(code=="90"){
    		return "其他有效身份证件";
    	}
    }
    
    //查询是否有惩戒记录
    function detailEntExist(key, type) {
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
    
    //监听text内容改变事件
    /*$("#keyword").bind('change paste keyup',function(){
    	$("#confirm").hide();
	});*/
    
    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#searchEnt',
            event: 'click',
            handler: function() {
            	searchEnt();
            }
        }, {
            el: '#confirm',
            event: 'click',
            handler: function() {
            	var priPID=$("#priPID").val();
            	var entName=$.trim($("#entName").val());
            	if(priPID==null||priPID==""||entName==null||entName==""){
            		layer.msg("请先查询出您要执行惩戒的企业再提交!", {ltype: 0,time:3000}); 
                	return false;
            	} 
            	
            	var uniCode=$.trim($("#uniCode").val());
            	var leRep=$.trim($("#leRep").val());
            	var cardNo=$.trim($("#cardNo").val());
            	
            	infojson.uniCode=uniCode;
            	infojson.entName=entName;
            	infojson.leRep=leRep;
            	infojson.cardNo=cardNo;
            	if(infojson.uniCode!=null&&infojson.uniCode!=""){
            		infojson.reguniCode=infojson.uniCode;
				}else{
					infojson.reguniCode=infojson.regNo;
				}
            	//身份证号替换星号
            	//infojson.switchCardNo=switchCardNo(cardNo);
            	infojson.recordCount=$("#totalCount").text(); 
            	layer.close(infojson);
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