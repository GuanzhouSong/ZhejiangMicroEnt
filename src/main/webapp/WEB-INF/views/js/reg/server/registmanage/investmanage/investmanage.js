require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	
	var searchParams={};
	var table;
	
	 init();
	 
	 function init(){
		 bind();
		 initDataTable();
	 }
	 
	 
	    /**
	     * 初始化dataTable
	     */
	    function initDataTable() {
	        var tpl = $('#tpl').html();
	        var template = handlebars.compile(tpl);
	        searchParams = $("#searchForm").serializeObject();
	        table = dataTable.load({
	            //需要初始化dataTable的dom元素
	            el: '#qua-table',
	            scrollX:true,	
	            showIndex: true,
	            ajax : {
	                //type : "get",
					url :  '/reg/server/registmanage/panoQueryPage',
	                //url :  '/syn/panoramasearch/panoQueryPage',
	                data : function(d){
                		d.params = searchParams;
	                }

	            },
	            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	            //className不要写成class
	            columns: [                
                {data: '_idx', className: 'center'},
                {data: 'id', className: 'center'},
                {data: 'regNO', className: 'center'},
                {data: 'entName', className: 'center'},
                {data: 'leRep', className: 'center'},
                {data: 'dom', className: 'center'},
                {data: 'opFrom',  className: 'center'},
                {data: 'opTo',  className: 'center'},
                {data: null, defaultContent:'priPID',  className: 'center'},
                {data: 'regOrgName',  className: 'center'},
                {data: 'localAdmName',  className: 'center'}
	            ],
	            columnDefs: [
				 {
				      targets: 1,
				      render: function (data, type, row, meta) {
				    	  return "<input value='" + row.priPID + "' name = 'checkboxlist' class='chb checkbox mycheck' type='checkbox' />";
				  }
				},{
				      targets: 8,
				      render: function (data, type, row, meta) {
				    	  var old = new Date(row.opTo).getTime();
				    	  var now = new Date().getTime();
				    	  var date = DateDiff(old,now);
				    	  
				    	  if(0<=date&&date<=30 )
				    		  return "经营期限即将到期";
				    	  if(date<0 )
				    		  return "经营期限到期";
				    	  return "";
				  }
				}
				]
	        })
	    }
	 
	  //计算两个日期天数差的函数，通用
	  function DateDiff(sDate1, sDate2) {  //sDate1和sDate2是毫秒数
	      iDays = parseInt((sDate1 - sDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
	      return iDays;  //返回相差天数
	  }
	    
	    
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#qua-search',
	            event: 'click',
	            handler: function() {
	            	searchParams = $("#searchForm").serializeObject();
	            		table.ajax.reload();
	            }
	        }, {
	            el: '#choseregUnit',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择管辖单位',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regunit/regunitmutiselect',
	                    callback: function (data) { 
	                    	
	                    	var returncode=data.returncode;
	                    	var returnname=data.returnname;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1);
	                     	} 	 
	                      	$("#localAdm").val(returncode);
	                      	$("#localAdmName").val(returnname); 
	                    }
	                })
	            }
	        },{
	            el: '#choseorgReg',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择登记机关',
	                    area: ['400px', '600px'],
	                    content: '/commom/server/regorg/regorgmutiselect',
	                    callback: function (data) { 
	                    	
	                    	var returncode=data.returncode;
	                    	var returnname=data.returnname;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#regOrg").val(returncode);
	                    	$("#regOrgName").val(returnname);
	                    }
	                })
	            }
	}, {
        el: '.mycheck',
        event: 'click',
        handler: function() {
        	$(".mycheck").not($(this)).removeAttr("checked");
        }
    }, {
        el: '#reset',
        event: 'click',
        handler: function() {
        	$(".clear").val("");
        	$("#opTip option:first").prop('selected','selected');
        }
    }, {
        el: '#adminguide',
        event: 'click',
        handler: function() {
        	var pripid = $(":checkbox[name=checkboxlist]:checked").val();
        	if(pripid ==undefined){
        		layer.msg("请您选择一条数据进行行政指导!", {icon: 7,time: 1000});
        		return false;
        	}
        	layer.dialog({
                title: '行政指导',
                area: ['80%', '90%'],
                content: '/reg/server/govguide/govguide/toAdd?fromtype=add&uid=&pripid=' + pripid,
                callback: function (data) {
                	if(data.type == 'save'){
                		layer.msg("行政指导成功!", {icon: 7,time: 1000});	
                	}else{
                		layer.msg("已取消!", {icon: 7,time: 1000});
                	}
                	
                }
            })
        }
    }, {
        el: '#reform',
        event: 'click',
        handler: function() {
        	var pripid = $(":checkbox[name=checkboxlist]:checked").val();
        	if(pripid ==undefined){
        		layer.msg("请您选择一条数据进行责令整改!", {icon: 7,time: 1000});
        		return false;
        	}
        	
        	layer.dialog({
                title: '责令整改',
                area: ['80%', '90%'],
                content: '/reg/server/orderreformset/orderReformSetApplyEditPage?pripid='+pripid+"&viewFlag=1"+"&adminGuideType=4",
                callback: function (data) { 
                		//功能还没做好
                	if(data.type == 'save'){
                		layer.msg("责令整改成功!", {icon: 7,time: 1000});	
                	}else{
                		layer.msg("已取消!", {icon: 7,time: 1000});
                	}
                }
            })
        }
    }
			])
	    }

})



