require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        initDataTable();
        bind();
       // initCount();
    }
    var table;
    var togetherTable;
    var searchParams;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	var userType = $("#userType").val();
    	var url = '/reg/pub/server/sccheck/entback/list.json';
    	if(userType == '2'){
    		url = '/syn/pub/server/sccheck/entback/list.json';
    	}
    	var randomType = $("#randomType").val();
    	if(randomType == '1'){
    		table = dataTable.load({
    			//需要初始化dataTable的dom元素
    			el: '#scentback-table',
    			//是否加索引值
    			showIndex: true,
    			scrollX: true,
    			ajax: {
    				url:url,
    				data:function(d){
    					d.params = $("#qryForm").serializeObject();;
    				}
    			},
    			//需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
    			//'className'不要写成class
    			columns: [
    			          {data: '_idx', 'className': 'center'},
    			          {data: 'regNO'},
    			          {data: 'entName'},
    			          {data: 'estDate'},
    			          {data: 'entTypeCatg'},
    			          {data: 'lastCheckTime'},
    			          {data: 'regOrgName'},
    			          {data: 'localAdmName'}
    			          ],
    			          columnDefs: [{
    			        	  targets:1,
    			        	  render:function(data,type,row,meta){
    			        		  if(row.uniCode&&row.uniCode!="null"){
    			        			  return row.uniCode;
    			        		  }else{
    			        			  return row.regNO;
    			        		  }
    			        	  }
    			          },{
    			        	  targets:4,
    			        	  render:function(data,type,row,meta){
    			        		  if(row.entTypeCatg == "50"){
    			        			  return "个体户";
    			        		  }else if(row.entType == "16" || row.entType == "17"){
    			        			  return "农专社";
    			        		  }else if(row.entType == "23"){
    			        			  return "外企代表机构";
    			        		  }else{
    			        			  return "企业";
    			        		  }
    			        	  }
    			          }]
    		})
    	}
        
        var userType = $("#userType").val();
    	var turl = '/reg/pub/server/sccheck/entcondition/list.json';
    	if(userType == '2'){
    		turl = '/syn/pub/server/sccheck/entcondition/list.json';
    	}
        togetherTable = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scentcondition-table',
            "bPaginate" : false,
            //是否加索引值
            showIndex: true,
            scrollX: true,
            ajax: {
                url:turl,
                data:function(d){
	               		 d.params = $("#qryForm").serializeObject();;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: '_idx', 'className': 'center'},
                {data: 'checkName',cut: {length: 20,mark:'...'}},
                {data: 'specialName'},
                {data: 'specialNum'},
                {data: null}
            ],
            columnDefs: [{
				targets:4,
				render:function(data,type,row,meta){
					if(data.randomNum){
						return '<span id="count_'+data.uid+'">'+data.randomNum+'</span>';
					}else{
						return '<span id="count_'+data.uid+'"></span>';
					}
				}
			}]
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancleEdit',
            event: 'click',
            handler: function () {
            	layer.close({reload:false});
            }
        },{
            el: '#qry',
            event: 'click',
            handler: function () {
            	 table.ajax.reload();
            	 $("#checkboxallid").prop("checked",false);
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	$("#regNO").val("");
            	$("#entName").val("");
            }
        },{
            el: '#taskDetail',
            event: 'click',
            handler: function () {
            	var taskUid = $("#taskUid").val();
            	var userType = $("#userType").val();
            	var url = '/reg/server/sccheck/scplantask/addOrEditView?flag=3&uid='+taskUid;
            	if(userType == '2'){
            		url = '/syn/sccheck/scplantask/addOrEditView?flag=3&uid='+taskUid;
            	}
            	layer.dialog({
                    title: '查看详情',
                    area: ['100%', '100%'],
                    content:url,
                    callback: function(data) {
                    	 
                    }
                })
            }
        },{
            el: '#viewEnt',
            event: 'click',
            handler: function () {
            	var taskUid = $("#taskUid").val();
            	var userType = $("#userType").val();
            	var url = '/reg/server/sccheck/pubscent/entlistpage?taskUid='+taskUid;
            	if(userType == '2'){
            		url = '/syn/server/sccheck/pubscent/entlistpage?taskUid='+taskUid;
            	}
            	layer.dialog({
                    title: '查看已抽取企业列表',
                    area: ['90%', '90%'],
                    content:url,
                    callback: function(data) {
                    	 
                    }
                })
            }
        }])
    }
})
