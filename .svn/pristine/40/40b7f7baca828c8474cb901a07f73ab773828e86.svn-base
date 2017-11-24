require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var initFlag = true;
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
        bind();
    }

    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
//    	initFlag = false;
        table = dataTable.load({
            el: '#user_table',
			showIndex: true,
			scrollX:true,
//			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/party/partyactivityinfo/inputlist.json',
                data:function(d){
            	   d.params = $.extend({}, searchParams, {"inputState":'1'});       		
//                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: 'inputState',width:'85px'},
                {data: 'activityType',width:'90px'},
                {data: 'activityName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'joinNum',width:'120px'},
                {data: 'activitybeginDate',width:'85px'},
                {data: 'activityEndDate',width:'85px'},
                {data: 'activityPlace',width:'85px'},
                {data: 'claimDeptName',width:'85px'},
                {data: 'claimLocalAdmName',width:'85px'},
                {data: 'originator',width:'110px'},
                {data: 'joiner',width:'75px'},
                {data: 'publishDeptName',width:'85px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'publishDate',width:'85px'},
                {data: 'requireEndDate',width:'85px'}
            ],
            columnDefs : [
							{
								targets : 1,
								render : function(data, type, row, meta) {
										return "<a class='view'>详情</a>";
								}
							},{
								targets : 2,
								render : function(data, type, row, meta) {
									if(data == null){
										return "";
									}else if(data == '1'){
										return '重点常规活动'
									}else if(data == '2'){
										return '党员日常活动';
									}else{
									    return data;
									}
								}
							}],
		 "fnDrawCallback": function (oSettings) {
			               var activityNum = oSettings._iRecordsTotal;
							http.httpRequest({ 
				                url: '/reg/server/party/partyactivityinfo/searchCount',
				                serializable: false,
				                type:'post',
				                data: {params:$.extend({}, searchParams, {"inputState":'1'})} ,
				                success: function (data){
				                    if (data.status == 'success') {  
				                    	//推送成功条数 
										$("#activityNum").text(activityNum);
										//推送失败条数 
										$("#joinerNum").text(data.data);
				                    }else{
				                    	//推送成功条数 
										$("#activityNum").text(activityNum);
										//推送失败条数 
										$("#joinerNum").text('0');
				                    } 
				                }
				            });
		 }	
         })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	var entCatgArry = new Array();
    	$("#taskForm input[name ='partyOrgType']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	searchParams.partyOrgType = entCatgArry.toString();
//    	if(initFlag){
//    		initDataTable();
//    	}else{
    		table.ajax.reload();
//    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                	title: '党建活动详情',
                	area: ['75%', '90%'],
                    content: '/reg/server/party/partyactivityinfo/partyActivityResult?uid='+data.uid+"&inputState="+data.inputState+"&viewFlag=2",
                    callback: function (data) {
                        if (data.reload) {
                        }
                    }
                })
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        },
        {
            el: '#choseSpecial',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择所在党组织',
                    area: ['68%', '80%'],
                    content: '/reg/server/party/organize/chooseOrg',
                    callback: function (data) {
                    	if(data.returnCode == 'success'){
                        	$("#specialCode").val(data.orgCode);
                        	$("#specialName").val(data.orgName);  
                    	}
                    }
                })
            }
        },
        {
        	el: '#chosePublishDept',
        	event: 'click',
        	handler: function () { 
        		layer.dialog({
        			title: '选择发布部门',
        			area: ['68%', '80%'],
        			content:'/reg/server/party/organize/chooseOrg',
        			callback: function (data) {
        				if(data.returnCode == 'success'){
        					$("#publishDeptUID").val(data.orgCode);
        					$("#publishDeptName").val(data.orgName);  
        				}
        			}
        		})
        	}
        },
        {
        	el: '#chosejoiner',
        	event: 'click',
        	handler: function () { 
        		layer.dialog({
        			title: '选择参与人',
        			area: ['400px', '600px'],
        			content:'/commom/server/party/member/toMemberTreeMap',
        			callback: function (data) {
//        				debugger
        				if(data.returnType == 'success'){
        					$("#joinerId").val(data.returncodes);
        					$("#joiner").val(data.returnname);
        				}
        			}
        		})
        	}
        }
        ,{
              el: '#reset',
              event: 'click',
              handler: function () { 
            	  $("#localAdm").val("");
				  $("#publishDeptUID").val("");
              	  $("#specialCode").val("");
			      $("#joinerId").val("");
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
        }
	    ])
    }

})
