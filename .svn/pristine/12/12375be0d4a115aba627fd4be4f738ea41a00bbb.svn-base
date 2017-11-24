require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars','laydate' ,'jquery.validate', 'common/validateRules','jquery.serialize','ztree'], function (layer,util, http,handlebars) {


    init();
    var viewTemplate = handlebars.compile($('#tpl').html());

    /**
     * 初始化函数集合
     */

    function init() {
    	// 初始化
    	if($("#viewFlag").val() == '2'){
    		$("#sysUserForm input[type = 'text']").each(function(){
    			$(this).attr("readonly",true);
    		})
    	}
        formValid();
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
    	 $('#sysUserForm').validate({
             showErrors:function(errorMap,errorList){
                 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#sysUserForm input[name='+i+'],#sysUserForm select[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
             },
             submitHandler: function () {
            	 if($("#sysUserForm input[name='partyOrgType']:checked").length == 0){
            		 layer.tips("请选择党组织类型",$('#partyOrgType'),{tips:3,tipsMore:true,ltype:0});
            		 return false;
            	 }
            	 var comAddrCity = $("#locCity option:selected").text();
                 var comAddrRegion = $("#locCounty option:selected").text();
                 var comAddrStreet = $("#locStreet option:selected").text();
            	 $("#partyOrgLoc").val(comAddrCity + comAddrRegion + comAddrStreet);
            	 
                 var formParam = $('#sysUserForm').serializeObject();
                 http.httpRequest({
                  	  url: '/reg/server/party/organize/saveOrEdit',
                      serializable: false,
                      data: formParam,
                      type: 'post',
                      success: function (data) {
                          layer.msg(data.msg, {time: 1000}, function () {
                        	  if(data.status == 'success') {
                        		 layer.close({reload: true});
                        	  }
                          });
                      }
                  })
              }
         })
    } 
    
    function bind() {
        util.bindEvents([
            {
	            el: '#cancel',
	            event: 'click',
	            handler: function () {
	                layer.close();
	              }
            },{
                el: '#partyOrgName',
                event: 'keyup',
                handler: function () {
                	var reg = /^[\u4E00-\u9FA5]+$/; 
                	if(reg.test($(this).val())){
                		getSearchList();
                	}
                }
            },{
                el: '.search-result-list li',
                event: 'click',
                handler: function () {
                	$("#partyOrgName").val($(this).text());
                	$("#rltMenuItem").hide();
                }
            },{
            	el: '#choseregUnit',
                event: 'click',
                handler: function () { 
                    layer.dialog({
                        title: '选择管辖单位',
                        area: ['400px', '600px'],
                        content: '/commom/server/regunit/regunitsingselect?isPermissionCheck=true',
                        callback: function (data) {
                        	var returncode=data.returncode;
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(data.returname); 
                        }
                    })
                }
            },{
                el: '#locCity',
                event: 'change',
                handler: function () {
                	if($(this).val() == ''){
                		$("#locCounty").html("");
                		$("#locStreet").html("");
                		return;
                	}
                    http.httpRequest({
                     	 url: '/reg/server/party/member/chooseOriginLoc',
                         serializable: false,
                         data: {cityCode:$("#locCity").val()},
                         type: 'get',
                         success: function (data) {
                        	 if(data.status == 'success'){
                        		 var list = data.data;
                                 var html = '';
                                 for(var i=0; i<list.length; i++){
                                     html +='<option value="'+list[i].code+'" >'+list[i].addressName+'</option>';
                                     $("#locCounty").html(" ").append("<option></option>"+html);
                                 }
                         	}
                         }
                     })
                 }
            },{
                el: '#locCounty',
                event: 'change',
                handler: function () {
                	if($(this).val() == ''){
                		$("#locStreet").html("");
                		return;
                	}
                    http.httpRequest({
                     	 url: '/reg/server/party/member/chooseOriginLocStreet',
                         serializable: false,
                         data: {countyCode:$("#locCounty").val()},
                         type: 'get',
                         success: function (data) {
                        	 if(data.status == 'success'){
                        		 var list = data.data;
                                 var html = '';
                                 for(var i=0; i<list.length; i++){
                                     html +='<option value="'+list[i].code+'" >'+list[i].addressName+'</option>';
                                     $("#locStreet").html(" ").append("<option></option>"+html);
                                 }
                         	}
                         }
                     })
                 }
            }])
       }
    
    $('.js-search-result-list').on('mouseenter','li',function(){
        $('.js-search-result-list li').removeClass('cur');
        $(this).addClass('cur');
    });
    
    /**
     * 匹配相似信息
     */
    function getSearchList() {
        var txt=$("#partyOrgName").val();
        if(txt==""){
            $("#rltMenuItem").hide();
            return;
        }
        http.httpRequest({
             type:'get',
             url: '/reg/server/party/organize/similarinfo',
             data: {keyWords:$("#partyOrgName").val(),inputState:"1"},
             success: function(data){
                 if (data.status == 'success') {
                	 $("#rltMenuItem").show();
                     var context=new Object();
                     context["menus"]=data.data;
                     $('#rltMenuItem').html(viewTemplate(context));
                     if(data.data.length == 0){
                    	 $("#rltMenuItem").removeClass('search-result-list');
                     }else{
                    	 $("#rltMenuItem").addClass('search-result-list');
                     }
                 }else{
                	 $("#rltMenuItem").hide();
                 }
             }
        })
    }

})