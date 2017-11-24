require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, util, http) {

	 $('input, textarea').placeholder();
    init();

    /**
     * 初始化函数集合
     */

    function init() {
        
        bind();
        initTbl();
    }
    
    function initTbl(){
    	 $(".assetItemText").each(function() {
    	    	var v = $.trim($(this).text()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
    	        if(v != "" && v != null){
    	        	$(this).text(parseFloat((isNaN(v) ? "0.00" : v) - 0).toFixed(4));
    	        } 
    	    });  
    	
    	
      	 $(".assetItem").each(function() {
   	    	var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
   	        if(v != "" && v != null){
   	        	$(this).val(parseFloat((isNaN(v) ? "0.00" : v) - 0).toFixed(4));
   	        } 
   	    }); 
   	
      	
      	$(".assetItem").focus(function() {
              var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
             
          }).blur(function() {
          	var v = $.trim($(this).val());
              if(v != "" && v != null){
              	v = v.replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
              	$(this).val(parseFloat((v == "" || isNaN(v) ? "0.00" : v) - 0).toFixed(4));
                var reg = /^[\-\+]?\d+(\.\d{1,4})?$/;  
              	if (!reg.test(v)) {
                  	 layer.tips('请重新输入!例1.23',$(this),{tips:3, tipsMore:true, ltype:0});
                      $(this).focus().addClass("warn");
                      return false;
                  }

                  $(this).val(parseFloat(v).toFixed(4));
                  if (v == "") {
                      $(this).val(0.00);
                  } 
              } 
          });  
      	  
      } 
    
    laydate.skin('molv');//初始化皮肤
    
    var end = {
            elem: '#change3',
            format: 'YYYY-MM-DD',
            min: '1900-01-01',
            max: "2299-12-31",
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             //结束日选好后，重置开始日的最大日期
            }
        };

        //开始时间和结束时间
        $("#change3").click(function(){
      
         laydate(end);
        });
        
        
        var alt = {
                elem: '#altDate',
                format: 'YYYY-MM-DD',
                min: '1900-01-01',
                max:"2299-12-31",
                istime: true,
                istoday: false,
                start: laydate.now(0,"YYYY-MM-DD"),
                choose: function(datas){
                 //结束日选好后，重置开始日的最大日期
                }
            };

            //开始时间和结束时间
            $("#altDate").click(function(){laydate(alt);});
        
        
    
        
    
    
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	location.href= "/reg/client/im/ent/investment/show?id="+$("#invID").val();
            }
        },
        { 
             	el:'#change1',
             	event:'change',
             	handler:function(){ 
             	 	$("#acConFormCn").val($(this).children('option:selected').text());
             	} 
             
        }, 
        
        {
         el:'#savechange',//保存方法
         event:'click',
         handler:function(){
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
        		 names[k]=this.value;
        		 values[k]=value;
        		 orvalues[k]=orvalue;
        		 $("#changeForm").append('<input type="hidden" name='+name+' value='+value+'>');
        		 index++;
        		 
        	 });
        	  var licID=$("#paidID").val();
        	 var invID=$("#invID").val();
        	 var altDate=$("#altDate").val();
        	 var acConFormCn=$("#acConFormCn").val();
        	 if(index==0){
        		 layer.msg("请选择变更内容", {time: 1000}, function () {
                	 
                 });
        		 return false;
        	 }
        	 if(altDate==null||altDate==""){
        		/* layer.msg("请选择变更时间", {time: 1000}, function () {
                	 
                 });*/
        		 layer.tips("请输入变更时间",$("#altDate"),{tips:3, tipsMore:true, ltype:0});
        		 $("#altDate").focus();
        		 return false;
        	 }
        	 $("#changeForm").append('<input type="hidden" name="names" id="names" value='+names.toString()+'>');
        	 $("#changeForm").append('<input type="hidden" name="changevalues" id="changeValues" value='+values.toString()+'>');
        	 $("#changeForm").append('<input type="hidden" name="originalValues" value='+orvalues.toString()+'>');
        	 $("#changeForm").append('<input type="hidden" name="altDate" value='+altDate+'>');
        	 $("#changeForm").append('<input type="hidden" name="paidID" value='+licID+'>');
        	 $("#changeForm").append('<input type="hidden" name="invID" value='+invID+'>');
        	 $("#changeForm").append('<input type="hidden" name="acConFormCn" value='+acConFormCn+'>');
        
        	 var changeValues=$("#changeValues").val().split(",");
             var namesArray=$("#names").val().split(",");
             for(var i=0;i<changeValues.length;i++){
             	 if(changeValues[i]==""||changeValues[i]==null){
             		 //layer.msg("请输入"+namesArray[i],{time:1000});
             		 layer.tips("请输入"+namesArray[i],$("#"+ids[i]),{tips:3, tipsMore:true, ltype:0});
             		$("#"+ids[i]).focus();
             		 return false;
             	 }
              }
        	 var change=$("#change2").val();
        	 if(change!=null&&change!=""&&change>999999999999){
        		 layer.tips("请输入0.001-99999999999的数值",$("#change2"),{tips:3,tipsMore:true,ltype:0});
        	     return false;
        	 }
             
             
        	 var formParam = $('#changeForm').serializeObject();
         $("#savechange").attr("disabled", true);
   		 $("#savechange").val("提交中...."); 
        var _index;
        http.httpRequest({
                 url: '/reg/client/im/ent/invactdetail/change',
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
                    	 location.href= "/reg/client/im/ent/investment/show?id="+invID;
                      });
                 }else{
                	  layer.msg(data.msg, {time: 2000}, function () {
                     	 location.href= "/reg/client/im/ent/investment/show?id="+invID;
                       }); 
                 }
                 }
             });  
        	 
         }
        	
        }
        
        ])
    }

})