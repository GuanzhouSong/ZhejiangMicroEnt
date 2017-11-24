require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules','common/ajaxfileupload'],
function(layer, util, http) {
	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
	var _viewFalg=window._CONFIG._viewFalg;
 
	
    init();
    
    
    var startNorDate = {
            elem: '#planStartTime', //选择ID为START的input
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
            elem: '#planEndTime',
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
    
    
    $("#planStartTime").click(function(){laydate(startNorDate);});
    $("#planEndTime").click(function(){laydate(endNorDate);});
    
    
    /**
     * 初始化函数集合
     */
    
    function init() {
        bind();
        initParm();
    }
    
    
    function initParm(){
    	
    	if(_viewFalg=="2"){
    		var fileUrl=$("#fileUrl").val();
    		var fileName=$("#fileName").val();
    		if(fileUrl!=null&&fileUrl!=""&&fileName!=null&&fileName!=""){
    			$("#dowFile").show();
    			$("#uploadFileName").text(fileName); 
    			$("#dowFile").attr("href", _sysUrl+"/sccheck/pubscworkplan/getLetter.json?fileUrl="+$("#fileUrl").val()+"&fName="+$("#fileName").val());
    		}else{
    			$("#dowFile").hide();
    		}
    	}else{
    		$("#dowFile").hide();
    	}
    }
     
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
       },
       {
           el: '#save',
           event: 'click',
           handler: function() {
        	  var dutyDeptCode = $("#dutyDeptCode").val();
         	  if(dutyDeptCode == "" || dutyDeptCode == null){
         		  layer.msg("您的账号未设置对应的职能部门，请先设置职能部门！", {ltype: 0,time:2000});
 	    		  return false;
         	  }
         	  var dutyDeptName = $("#dutyDeptCode").find("option:selected").text();
         	  $("#dutyDeptName").val(dutyDeptName);
        	  var  planName=$.trim($("#planName").val());
        	  if(planName==null||planName==""){
        		  layer.msg("抽查计划名称不能为空", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var planType=$("input[name='planType']:checked").val();
        	  if(typeof planType=="undefined"||planType==null||planType==""){
        		  layer.msg("请选择抽查类型", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var  planStartTime=$.trim($("#planStartTime").val());
        	  var  planEndTime=$.trim($("#planEndTime").val());
        	  if((planStartTime==null||planStartTime=="")||(planEndTime==null||planEndTime=="")  ){
        		  layer.msg("请选择计划活动期限", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var  planLeadDeptName=$.trim($("#planLeadDeptName").val());
        	  if(planLeadDeptName==null||planLeadDeptName==""){
        		  layer.msg("请选择责任单位（牵头处室）", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var  planRange=$.trim($("#planRange").val());
        	  if(planRange==null||planRange==""){
        		  layer.msg("请输入抽查范围及数量比例（地区）", {ltype: 0,time:2000});
  	    		  return false;
        	  }
        	  var file=$("#btnFile_4").val();
        	  var fileUrl=$("#fileUrl").val();
          	  if((file!=null&&file!="")&& (fileUrl==null||fileUrl=="") ){
          		layer.msg("请先上传附件", {time: 3000}, function() {});
          		return false;
          	  }
        	  var formParam=$('#favorableForm').serializeObject();
        	  http.httpRequest({ 
                   url: _sysUrl+'/sccheck/pubscworkplan/commitPubScWorkPlan', 
                   serializable: true,
                    data: formParam,
                    type: 'post',
                   success: function (data) {
                	   if(data.status!=="success"){ 
                		   layer.msg(data.msg, {ltype: 0,time:3000});
                	   }else{
                		   layer.close(data);
                	   }
                   }
             });
           }
      },
      {
          el: '#btnUpload_4',
          event: 'click',
          handler: function() {
          	var faceprefix = new Date().getTime()+"_";
          	var file=$("#btnFile_4").val();
        	if(file==null||file==""){
        		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
        		return false;
        	}
        	var pos=file.lastIndexOf("\\");
        	file = file.substring(pos+1); 
        	var suffixArr = file.split(".");
        	var suffix = suffixArr[suffixArr.length-1];
        	var tp ="doc,docx";
        	var rs=1;//tp.indexOf(suffix);
        	if(rs>=0){
        		 var filePath = faceprefix+file;
        		 $("#fileUrl").val("sccheck/pubscworkplan/"+filePath);
        		 $("#fileName").val(file);
        		// e.hide();
        		 $("#btnUpload_4").val("上传中");
        		 
        		 $("#dowFile").attr("href", _sysUrl+"/sccheck/pubscworkplan/getLetter.json?fileUrl="+$("#fileUrl").val()+"&fName="+$("#fileName").val());
        		 $.ajaxFileUpload({
        			 url:  _sysUrl+'/sccheck/pubscworkplan/upload',
        			 type: 'post',
        			 data: {"prefix":faceprefix},
        			 secureuri: false,
        			 fileElementId: 'btnFile_4',
        			 dataType: 'text',
        			 success: function(data, status){        
        				 if(data !="error") {
        					 layer.msg("上传成功", {time: 1200}, function() {});
        				 }else {
        					 layer.msg("上传失败", {time: 2000}, function() {});
        				 }
        				 $("#uploadFileName").text(file); 
        				 $("#btnUpload_4").val("上传");
        				 $("#dowFile").show();
        			 },error: function(data, status){
        				 $("#btnUpload_4").val("上传");
        				 layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
        			 }
        		 });
        	}else{
        		 layer.msg("您选择正确格式的文档！", {time: 3000}, function() {});
        	}
          }
      	}
       ])
    }

})