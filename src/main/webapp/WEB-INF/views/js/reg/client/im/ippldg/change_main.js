require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules','laydate','jquery.placeholder','jquery.icinfo'], function (layer, util, http) {
	 $('input, textarea').placeholder(); 

    init();

    /**
     * 初始化函数集合
     */

    function init() {
        
        bind();
    }
  $(":checkbox[name=change]").click(function(){
	  //alert(this.checked);
      if(this.checked==true){
    	  $("#"+this.title).removeAttr("readonly");
      }else{
    	  $("#"+this.title).attr("readonly","readonly");
      }
  });
    
  laydate.skin('molv');//初始化皮肤
  var start = {
      elem: '#change4', //选择ID为START的input
      format: 'YYYY-MM-DD', //自动生成的时间格式
      min: '1900-01-01', //设定最小日期为当前日期
      max: "2299-12-31", //最大日期//最大日期
      istime: true, //必须填入时间
      istoday: false,  //是否是当天
      start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
      choose: function(datas){
          end.min = datas; //开始日选好后，重置结束日的最小日期
          end.start = datas //将结束日的初始值设定为开始日
      }
  };
  var end = {
      elem: '#change5',
      format: 'YYYY-MM-DD',
      min: '1900-01-01', //设定最小日期为当前日期
      max: "2299-12-31", //最大日期//最大日期
      istime: true,
      istoday: false,
      start: laydate.now(0,"YYYY-MM-DD"),
      choose: function(datas){
          start.max = datas; //结束日选好后，重置开始日的最大日期
      }
  };
  var  altDate={
		  elem: '#altDate',
	      format: 'YYYY-MM-DD',
	      min: '1900-01-01',
	      max: "2299-12-31",
	      istime: true,
	      istoday: false,
	      start: laydate.now(0,"YYYY-MM-DD"),
	      choose: function(datas){
	          start.max = datas; //结束日选好后，重置开始日的最大日期
	      }
  };
  
  var canDate={
		  elem: '#canDate',
	      format: 'YYYY-MM-DD',
	      min: '1900-01-01',
	      max: "2299-12-31",
	      istime: true,
	      istoday: false,
	      start: laydate.now(0,"YYYY-MM-DD"),
	      choose: function(datas){
	          start.max = datas; //结束日选好后，重置开始日的最大日期
	      }
  };
  var invAlidDate={
		  elem: '#invAlidDate',
	      format: 'YYYY-MM-DD',
	      min: '1900-01-01',
	      max: "2299-12-31", //最大日期//最大日期
	      istime: true,
	      istoday: false,
	      start: laydate.now(0,"YYYY-MM-DD"),
	      choose: function(datas){
	          start.max = datas; //结束日选好后，重置开始日的最大日期
	      }
  }
  
  //开始时间和结束时间
  $("#change4").click(function(){laydate(start);});
  $("#change5").click(function(){laydate(end);}); 
  $("#altDate").click(function(){laydate(altDate);});
  $("#canDate").click(function(){laydate(canDate);});
  $("#invAlidDate").click(function(){laydate(invAlidDate);}); 
     
   function change(){//变更方法 
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
  		orvalue=$("#"+id+"T").text().replace(/(^\s*)|(\s*$)/g, "");
  		 names[k]=this.value;
  		 values[k]=value;
  		 orvalues[k]=orvalue;
  		 $("#changeForm").append('<input type="hidden" name='+name+' value='+value+'>');
  		 index++;
  		 
  	 });
  	 var licID=$("#pleID").val();
  	 var altDate=$("#altDate").val();
  	 $("#changeForm").append('<input type="hidden" name="names" id="names" value='+names.toString()+'>');
  	 $("#changeForm").append('<input type="hidden" name="changevalues" id="changevalues" value='+values.toString()+'>');
  	 $("#changeForm").append('<input type="hidden" name="originalValues" value='+orvalues.toString()+'>');
  	 $("#changeForm").append('<input type="hidden" name="altDate" value='+altDate+'>');
  	 $("#changeForm").append('<input type="hidden" name="pleID" value='+licID+'>');
  	if(index==0){
		 layer.msg("请选择变更内容 ", {time: 1000}, function () {
       	 
        });
		 return false;
	 }
	 if(altDate==null||altDate==""){ 
		 layer.tips('请选择变更时间',$("#altDate"),{tips:3, tipsMore:true, ltype:0});
		 $("#altDate").focus();
		 return false;
	 }
	   
	 
   var formParam = $('#changeForm').serializeObject();
  
   var changeArray=$("#changevalues").val().split(",");
   var namesArray=$("#names").val().split(",");
   for(var i=0;i<changeArray.length;i++){
   	 if(changeArray[i]==""||changeArray[i]==null){
   		 //layer.msg("请输入"+namesArray[i],{time:1000});
   		layer.tips("请输入"+namesArray[i],$("#"+ids[i]),{tips:3, tipsMore:true, ltype:0});
   		$("#"+ids[i]).focus();
   		return false;
   	 }
    }  
 
   $("#savechange").attr("disabled", true);
	 $("#savechange").val("提交中...."); 
   var _index;
    http.httpRequest({
           url: '/reg/client/im/ent/ippldg/change',
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
                  location.href="/reg/client/im/ent/ippldg/list";
               });
           }else{
        	   layer.msg(data.msg, {time: 2000}, function () {
                   location.href="/reg/client/im/ent/ippldg/list";
                });
           
           }
           }
       });    
   }
   function cancle(){//注销方法 
       var pleID=$("#pleID").val();
       var canDate=$("#canDate").val();
       var equPleCanRea=$("#equPleCanRea").val(); 
       if(canDate==null||canDate==""){
    	   //layer.msg("请输入注销时间",{time:1000});
    	   layer.tips('请选择注销时间',$("#canDate"),{tips:3, tipsMore:true, ltype:0});
    	   $("#altDate").foucs();
    	   return false;
       }
       if(equPleCanRea==null||equPleCanRea==""){
    	  // layer.msg("请输入注销原因",{time:1000});
    	   layer.tips('请输入注销原因',$("#equPleCanRea"),{tips:3, tipsMore:true, ltype:0});
    	   $("#equPleCanRea").foucs();
    	   return false;
       }
        
     var _index;
     var imIppldg=new Object();
     imIppldg.pleID=pleID;
     imIppldg.equPleCanRea=equPleCanRea;
     imIppldg.canDate=canDate;
     http.httpRequest({
             url: '/reg/client/im/ent/ippldg/beCancle',
             beforeSend:function(){
             	_index=layer.load(2,{shade:0.5});
             },
             serializable: false,
             contentType : 'application/json;charset=utf-8', //设置请求头信息
             dataType:"json",
             data:JSON.stringify(imIppldg),
             type: 'post',
             success: function (data) {
            	    layer.close(_index);
                 layer.msg(data.msg, {time: 1000}, function () {
                 location.href="/reg/client/im/ent/ippldg/list";
                 });
             }
         });  
  }
  
   function invalidReason(){//其他无效原因
   	var pleID=$("#pleID").val();
       var invAlidDate=$("#invAlidDate").val();
       var invAliDRea=$("#invAliDRea").val();  
       
       if(invAlidDate==null||invAlidDate==""){
    	  // layer.msg("请输入其他无效时间",{time:1000});
    	    layer.tips('请选择其他无效时间',$("#invAlidDate"),{tips:3, tipsMore:true, ltype:0});
    	   $("#invAlidDate").foucs();
    	   return false;
       }
       if(invAliDRea==null||invAliDRea==""){
    	    //layer.msg("请输入其他无效原因",{time:1000});
    	   layer.tips('请输入其他无效原因',$("#invAliDRea"),{tips:3, tipsMore:true, ltype:0});
    	   $("#invAliDRea").foucs();
    	   return false;
       }
       
       
      var _index;
      var imIppldg=new Object();
      imIppldg.pleID=pleID;
      imIppldg.invAliDRea=invAliDRea;
      imIppldg.invAlidDate=invAlidDate;
     http.httpRequest({
             url: '/reg/client/im/ent/ippldg/invalidReason',
             beforeSend:function(){
             	_index=layer.load(2,{shade:0.5});
             },
             serializable: false,
             contentType : 'application/json;charset=utf-8', //设置请求头信息
             dataType:"json",
             data:JSON.stringify(imIppldg),
             type: 'post',
             success: function (data) {
            	    layer.close(_index);
                 layer.msg(data.msg, {time: 1000}, function () {
               	   location.href="/reg/client/im/ent/ippldg/list";
                 });
             }
         });  
   }
   
   
   

    function bind() {
        util.bindEvents([{
            el: '#cancle',
            event: 'click',
            handler: function () {
                location.href="/reg/client/im/ent/ippldg/list";
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
         	 if(type=="cancle"){
         		cancle();
         	 } 
         }
        	
        }
        
        ])
    }

})