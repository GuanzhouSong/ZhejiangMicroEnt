require(['component/iframeLayer', 'common/util' , 'common/http', 'jquery.validate', 'jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, util, http) {
	 $('input, textarea').placeholder(); 

    init();

    /**
     * 初始化函数集合
     */

    function init() {
    	 $.extend($.validator.messages, {
      		required: "请输入文本值", 
      		number: "请输入有效的数字",
      		digits: "只能输入数字",
      	    maxlength: $.validator.format("最多可以输入 {0} 个字符"),
      		minlength: $.validator.format("最少要输入 {0} 个字符"),
      	    range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
      		 
      	});  
     	
    	
        bind(); 
        
    }
    
    
    laydate.skin('molv');//初始化皮肤
    var start = {
        elem: '#change1', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        max: "2099-12-31", //设定最小日期为当前日期
        max: laydate.now(0,"YYYY-MM-DD"), //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#change2',
        format: 'YYYY-MM-DD ',
        min: '1970-01-01',
        max: "2099-12-31",
        istime: true,
        istoday: false,
        start: laydate.now(0,"YYYY-MM-DD"),
        choose: function(datas){
         
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    
    var altDate={
    		elem:"#altDate",
    		format: 'YYYY-MM-DD ',
            min: '1970-01-01',
            max: "2099-12-31",
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
    		
    		
    };
    
    var canDate={
    		elem:"#canDate",
    		format: 'YYYY-MM-DD ',
            min: '1970-01-01',
            max: laydate.now(0,"YYYY-MM-DD"),
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
    };
    var revDate={
    		elem:"#revDate",
    		format: 'YYYY-MM-DD ',
            min: '1970-01-01',
            max: "2099-12-31",
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
    		
    };
    
    var invAlidDate={
    		elem:"#invAlidDate",
    		format: 'YYYY-MM-DD ',
            min: '1970-01-01',
            max: "2099-12-31",
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
    		
    };
    
    
    //开始时间和结束时间
    $("#change1").click(function(){laydate(start);});
    $("#change2").click(function(){laydate(end);});
    $("#altDate").click(function(){laydate(altDate)});
    $("#canDate").click(function(){laydate(canDate)});
    $("#revDate").click(function(){laydate(revDate)});
    $("#invAlidDate").click(function(){laydate(invAlidDate)});
     
    
    /**
     * 表单验证
     */
    function change(){//变更行政许可信息方法
    	 $("#changeForm").empty();
    	 var change=new Object();
    	 var name;
    	 var value;
    	 var index=0;
    	 var names=new Array();
    	 var values=new Array();
    	 var orvalues=new Array();
    	 var ids=new Array();
    	 $(":checkbox[name=change]:checked").each(function(k,v){
    		 var id=this.title;
    		 name=$("#"+id).attr("name");
    	      ids[k]=id;
    		 value=$("#"+id).val();
    		 orvalue=$("#"+id+"T").text();
    		 names[k]=  this.value;
    	    values[k]=value;//去掉去除空格函数
    		 orvalues[k]=orvalue;
    		 $("#changeForm").append('<input type="hidden" name='+name+' value='+value+'>');
    		 index++;

    	 });
    	 var licID=$("#licID").val();
    	 var altDate=$("#altDate").val();
    	 if(index==0){
    		 layer.msg("请选择变更内容", {time: 1000}, function () {
            	 
             });
    		 return false;
    	 }
    	 if(altDate==null||altDate==""){
    		 //layer.msg("", {time: 1000});
    		 layer.tips('请选择变更时间',$("#altDate"),{tips:3, tipsMore:true, ltype:0});
    		 $("#altDate").focus();
    		 return false;
    	 }
    	 
    	 $("#changeForm").append('<input type="hidden" name="names" id="names" value='+names.toString()+'>');
    	 $("#changeForm").append('<input type="hidden" name="changevalues" id="changeValues" value='+values.toString()+'>');
    	 $("#changeForm").append('<input type="hidden" name="originalValues" value='+orvalues.toString()+'>');
    	 $("#changeForm").append('<input type="hidden" name="altDate" value='+altDate+'>');
    	 $("#changeForm").append('<input type="hidden" name="licID" value='+licID+'>');
    	 
        var changeValues=$("#changeValues").val();
        var changeValues=$("#changeValues").val().split(",");
        var namesArray=$("#names").val().split(",");
        for(var i=0;i<changeValues.length;i++){
        	 if(changeValues[i]==""||changeValues[i]==null){ 
        		 layer.tips("请输入"+namesArray[i],$("#"+ids[i]),{tips:3, tipsMore:true, ltype:0});
        		 $("#"+ids[i]).focus();
        		 return false;
        	 }
         }

        if(changeValues==null||changeValues==""){
        	layer.msg("请输入变更内容",{time:1000});
        	return false;
        	
        } 
    	 var formParam = $('#changeForm').serializeObject(); 
     $("#savechange").attr("disabled", true);
	 $("#savechange").val("提交中...."); 
    	 var _index;
      http.httpRequest({
             url: '/reg/client/im/ent/permit/change',
             beforeSend:function(){
             	_index=layer.load(2,{shade:0.5});
             },
             serializable: false,
             data:  formParam,
             type: 'post',
             success: function (data) {
            	  layer.close(_index);
            	  
            	  if(data.status=="success"){
            	 layer.msg(data.msg, {time: 1000}, function () {
                	 location.href="/reg/client/im/ent/permit/list";
                 });
             }else{
            	 layer.msg(data.msg, {time: 2000}, function () {
                	 location.href="/reg/client/im/ent/permit/list";
                 });
            	 
             }
             }
         });
    	
    }
    function cancle(){//注销方法 
         var licID=$("#licID").val();
         var canDate=$("#canDate").val();
         var equPleCanRea=$("#equPleCanRea").val(); 
         if(canDate==null||canDate==""){
        	 //layer.msg("",{time:1000});
        	 layer.tips('请选择注销时间',$("#canDate"),{tips:3, tipsMore:true, ltype:0});
        	 $("#canDate").focus();
        	 return false;
         }
         if(equPleCanRea==null||equPleCanRea==""){
        	 //layer.msg("请输入注销原因",{time:1000});
        	 layer.tips('请选择注销原因',$("#equPleCanRea"),{tips:3, tipsMore:true, ltype:0});
        	 $("#equPleCanRea").focus();
        	 return false;
         }
        $("#savechange").attr("disabled", true);
    	 $("#savechange").val("提交中...."); 
    	 var _index;
    	 var mPermit=new Object();
    	 mPermit.licID=licID;
    	 mPermit.equPleCanRea=equPleCanRea;
    	 mPermit.canDate=canDate;
    	 
       http.httpRequest({
               url: '/reg/client/im/ent/permit/beCancle',
               beforeSend:function(){
               	_index=layer.load(2,{shade:0.5});
               },
               serializable: false,
               contentType : 'application/json;charset=utf-8', //设置请求头信息
               dataType:"json",
               data:JSON.stringify(mPermit),
               type: 'post',
               success: function (data) {
            	   layer.close(_index);
                   layer.msg(data.msg, {time: 1000}, function () {
                    location.href="/reg/client/im/ent/permit/list";
                   });
               }
           });  
    }
    
    function beRevoked(){//被吊销方法
    	var licID=$("#licID").val();
        var revDate=$("#revDate").val();
        var sugRevReason=$("#sugRevReason").val();
        if(revDate==null||revDate==""){
        	//layer.msg("请输入被注销时间",{time:1000});
        	 layer.tips('请选择被注销时间',$("#revDate"),{tips:3, tipsMore:true, ltype:0});
        	 $("#revDate").focus();
        	return false;
        }
        if(sugRevReason==null||sugRevReason==""){
        	//layer.msg("请输入被注销原因",{time:1000});
        	 layer.tips('请输入被注销原因',$("#sugRevReason"),{tips:3, tipsMore:true, ltype:0});
        	 $("#sugRevReason").focus();
        	return false;
        }
        
        
        $("#savechange").attr("disabled", true);
   	 $("#savechange").val("提交中...."); 
        var _index;
        var mPermit=new Object();
        mPermit.licID=licID;
        mPermit.sugRevReason=sugRevReason;
        mPermit.revDate=revDate;
      http.httpRequest({
              url: '/reg/client/im/ent/permit/beRevoked',
              beforeSend:function(){
              	_index=layer.load(2,{shade:0.5});
              },
              serializable: false,
              contentType : 'application/json;charset=utf-8', //设置请求头信息
              dataType:"json",
              data:JSON.stringify(mPermit),
              type: 'post',
              success: function (data) {
            	  layer.close(_index);
            	  layer.msg(data.msg, {time: 1000}, function () {
                 	   location.href="/reg/client/im/ent/permit/list";
                  });
              }
          });  
    }
    function invalidReason(){//其他无效原因
    	var licID=$("#licID").val();
        var invAlidDate=$("#invAlidDate").val();
        var invAliDRea=$("#invAliDRea").val(); 
        if(invAlidDate==null||invAlidDate==""){
        	//layer.msg("请输入其他无效时间",{time:1000});
        	layer.tips('请选择其他无效时间',$("#invAlidDate"),{tips:3, tipsMore:true, ltype:0});
        	 $("#invAlidDate").focus();
        	return false;
        }
        if(invAliDRea==null||invAliDRea==""){
        	//layer.msg("请输入其他无效原因",{time:1000});
        	layer.tips('请输入其他无效原因',$("#invAliDRea"),{tips:3, tipsMore:true, ltype:0});
       	  $("#invAliDRea").focus();
        	return false;
        }

       $("#savechange").attr("disabled", true);
      	 $("#savechange").val("提交中...."); 
        var _index;
        var mPermit=new Object();
        mPermit.licID=licID;
        mPermit.invAliDRea=invAliDRea;
        mPermit.invAlidDate=invAlidDate;
      http.httpRequest({
              url: '/reg/client/im/ent/permit/invalidReason',
              beforeSend:function(){
              	_index=layer.load(2,{shade:0.5});
              },
              serializable: false,
              contentType : 'application/json;charset=utf-8', //设置请求头信息
              dataType:"json",
              data:JSON.stringify(mPermit),
              type: 'post',
              success: function (data) {
            	   layer.close(_index);
                  layer.msg(data.msg, {time: 1000}, function () {
                	   location.href="/reg/client/im/ent/permit/list";
                  });
              }
          });  
    }
    

    function bind() {
        util.bindEvents([{
            el: '#cancle',
            event: 'click',
            handler: function () {
            	 location.href="/reg/client/im/ent/permit/list";
            }
        },
            { el: '#longTime', //无有效期或长期有效事件触发
                event: 'click',
                handler: function () {
                    if($(this).prop("checked")){
                        $("#change2").val("9999-09-09");
                    }else{
                        $("#change2").val("");
                    }
                }
            },
        {
         el:'#savechange',
         event:'click',
         handler:function(){
        	  
          var type=$("input[type='radio']:checked").val();
        	 if(type=="change"){
        		 change(); 
        	 }
        	 if(type=="invalidReason"){
        		 invalidReason();
        	 }
        	 if(type=="beRevoked"){
        		 beRevoked();
        	 } 
        	 if(type=="cancle"){
        		 cancle();
        	 }
         }
        	
        }
        
        ])
    }

})