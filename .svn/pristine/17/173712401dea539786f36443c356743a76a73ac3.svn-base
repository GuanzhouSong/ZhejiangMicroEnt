require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	var initItem = $("#executeItem").val();
    	//公示股权冻结信息记录
        initFrozTable();
        //强制变更信息记录
        if(initItem !='2' && initItem !='3'){
        	initAlterTable();        	
        }
        
        bind();
    }


    var tableOne;
    
    var tableTwo;

    /**
     * 初始化dataTable
     */
    function initFrozTable() {
    	var priPID = $("#priPID").val();
    	var executeItem = $("#executeItem").val();
    	  var userType= $("#userType").val(); 
          var typeUrl="";
          if(userType=="2"){
        	  typeUrl="/syn/other/pubjusticeinfo/include.json";
          }else{
        	  typeUrl="/reg/other/pubjusticeinfo/include.json";
          } 
    	tableOne = dataTable.load({
            el: '#FrozTable',
            type:'post',
            ajax: {
                url:typeUrl,
                data:function(d){
                    d.params = {
	                    		"priPID":priPID,
	            				"auditState":1,//审核通过
	            				"justiceType":1,//冻结
	            				"frozState":1,//股权冻结状态：冻结
	            				"flag":executeItem == "2" || executeItem == "3" ? 1 : ""
                               }
                 }
            },
            columns: [
                {data: null,width:'5%', className: 'center'},
                {data: 'inv',width:'20px'},
                {data: 'exeRulNum',width:'20px'},
                {data: 'cerType',width:'20px'},
                {data: 'cerNO',width:'20px'},
                {data: 'froAm',width:'20px'},
                {data: 'frozState',width:'20px'}
            ],
            columnDefs : [
							{
	             	         targets:0,
	             	         render:function(data,type,row,meta){
	             		     return  '<input type="radio"  class="radioClass" priPID='+row.priPID+' inv='+row.inv+' cerType='+row.cerType+' cerNO='+row.cerNO+' froAm='+row.froAm+' froAuth='+row.froAuth+' UID='+row.uid+' name="_checkResult">';
	             	         }
	                     },{
			            	targets:6,
			            	render:function(data,type,row,meta){
			            		if(row.frozState == "1"){
	                        		return "冻结";
	                        	}else if(row.frozState == "2"){
	                        		return "解除冻结";
	                        	}else if(row.frozState == "3"){
	                        		return "失效";
	                        	}
			             }},{
	             	         targets:3,
	             	         render:function(data,type,row,meta){
	             	        	if(row.cerType == "10") {
             	    			     return "居民身份证";
                 				}else if(row.cerType == "20") {
                 	    			 return "军官证";
                 				}else if(row.cerType == "30") {
                 					return "警官证";
                 				}else if(row.cerType == "40") {
                 					return "外国地区护照";
                 				}else if(row.cerType == "52") {
                 					return "香港身份证";
                 				}else if(row.cerType == "54") {
                 					return "澳门身份证";
                 				}else if(row.cerType == "56") {
                 					return "台湾身份证";
                 				}else {
             					   return "其他有效身份证件";
             					}
	             	         }
	                     },{
								targets : 5,
								render : function(data, type, row, meta) {
		                            	return row.froAm+'('+row.froAuth +')';
								}
							}]
            })
    }
    
    function initAlterTable() {
    	$("#viewGridAlter").show();
    	var priPID = $("#priPID").val();
    	  var userType= $("#userType").val(); 
          var typeUrl="";
          if(userType=="2"){
        	  typeUrl="/syn/other/pubjusticeinfo/include.json"
          }else{
        	  typeUrl="/reg/other/pubjusticeinfo/include.json";
          }
    	
    	tableTwo = dataTable.load({
            el: '#AlterTable',
            type:'post',
            ajax: {
                url:typeUrl,
                data:function(d){
                    d.params = {
	                    		"priPID":priPID,
	            				"auditState":1,//审核通过
	            				"justiceType":2//冻结
                               }
                 }
            },
            columns: [
                {data: null,width:'5%', className: 'center'},
                {data: 'inv',width:'20px'},
                {data: 'exeRulNum',width:'20px'},
                {data: 'cerType',width:'20px'},
                {data: 'cerNO',width:'20px'},
                {data: 'froAm',width:'20px'},
                {data: 'assInv',width:'20px'}
            ],
            columnDefs : [
							{
	             	         targets:0,
	             	         render:function(data,type,row,meta){
	             	        	return  '<input type="radio"  class="radioClass" priPID='+row.priPID+' inv='+row.inv+' cerType='+row.cerType+' cerNO='+row.cerNO+' froAm='+row.froAm+' froAuth='+row.froAuth+' name="_checkResult">';
	             	        }
	                     },{
	             	         targets:3,
	             	         render:function(data,type,row,meta){
	             	        	if(row.cerType == "10") {
            	    			     return "居民身份证";
                				}else if(row.cerType == "20") {
                	    			 return "军官证";
                				}else if(row.cerType == "30") {
                					return "警官证";
                				}else if(row.cerType == "40") {
                					return "外国地区护照";
                				}else if(row.cerType == "52") {
                					return "香港身份证";
                				}else if(row.cerType == "54") {
                					return "澳门身份证";
                				}else if(row.cerType == "56") {
                					return "台湾身份证";
                				}else {
            					   return "其他有效身份证件";
            					}
	             	         }
                       },{
							targets : 5,
							render : function(data, type, row, meta) {
	                            	return row.froAm+'('+row.froAuth +')';
							}
						}]
             })
    }
    
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	var checkFlag = false;
            	$(".radioClass").each(function(){
            		if($(this).prop("checked")){
            			checkFlag = true;
            		}
            	})
            	if(checkFlag){
            		var $data = $(".radioClass:checked");
            		layer.close({reload:true,
            			         inv:$data.attr("inv"),
            			         cerType:$data.attr("cerType"),
            			         cerNO:$data.attr("cerNO"),
            			         froAm:$data.attr("froAm"),
            			         froAuth:$data.attr("froAuth"),
            			         UID:$data.attr("UID")});
                }else{
                	layer.msg("请先选择一条记录！",{time:1000});
                	return false;
                }
            }
        }])
    }

})
