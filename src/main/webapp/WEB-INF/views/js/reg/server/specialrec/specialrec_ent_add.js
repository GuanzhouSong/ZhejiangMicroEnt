require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http, handlebars) {
	var params={};//查询参数声明!
	var clickFlag = false;
	var regStateList = [];
	init();
	    /**
		 * 初始化函数集合
		 */
	    function init() {
	    	initRegState();
	    	//列表加载
	        initDataTable();
	        bind();
	    }
	    
	    var start = {
	            elem: '#estDateStart',
	            format: 'YYYY-MM-DD',
	            min: '1970-01-01',
	            max: '2099-06-16',
	            istime: true,
	            istoday: false, 
	            start: laydate.now(0,"YYYY-MM-DD"),
	            choose: function(datas){
	            end.min = datas; 
	            end.start = datas;
	            }
	        };
	        var end = {
	            elem: '#estDateEnd',
	            format: 'YYYY-MM-DD',
	            min: '1970-01-01',
	            max: '2099-06-16',
	            istime: true,
	            istoday: false,
	            start: laydate.now(0,"YYYY-MM-DD"),
	            choose: function(datas){
	            start.max = datas;
	            }
	        };

	    
	    $("#estDateStart").click(function(){laydate(start);});
	    $("#estDateEnd").click(function(){laydate(end);});
	    
	    
	    var listtable;
	    
	    function initRegState(){
	       	$("#regStateM").multipleSelect({
	       		selectAllText: '全部',
	    		allSelected: '全部',
	    		selectAllDelimiter: '',
	    		minimumCountSelected: 20
	       	});
	        //登记状态
    		var regStateM = $("#regStateM").val();
    		$("#regState").val(regStateM);
	    }
	    
	    /**
		 * 初始化dataTable
		 */
	    function initDataTable() {
	    	listtable = dataTable.load({
	            el: '#list-table',
	            showIndex: true,
	            scrollX: true,
	            "aLengthMenu": [10, 25, 50, 100,1000,2000],
	            ajax: {
	                url:'/syn/server/drcheck/scstack/panoQueryPage',
	                data:function(d){
                		d.params = $("#searchForm").serializeObject();
	                }
	            },
	            columns: [
	                {data: null,"className": "center",defaultContent:'111'},
	                {data: null,"className": "center"}, 
	                {data: null,"className": "center"}, 
	                {data: "entName","className": "center"}, 
	                {data: null,"className": "center"},
	                {data: "dom", "className": "left",cut: {length: 20,mark:'...'}},
	                {data: "checkDepName", "className": "center"}, 
	                {data: "regOrgName", "className": "center"},
	                {data: "localAdmName", "className": "center"}
	            ],
	            columnDefs: [{
	            	targets:1,
	    	        render:function(data,type,row,meta){
	    	        	return "<input type='checkbox' name='pubscinfocheckbox' value='"+data.priPID+"' />";
	    	       }
		        },{
	            	targets:2,
	    	        render:function(data,type,row,meta){
	    	        	if(data.uniscid != null && data.uniscid != ""){
		   					return data.uniscid;
		   				}else{
		   					return data.regNO;
		   				}
	    	       }
		        },{
	            	targets:4,
	    	        render:function(data,type,row,meta){
	    	        	return "企业";
	    	       }
		        }]
	        });
	    }
	    
	    
	    function bind() {
	        util.bindEvents([{
	            el: '#checkboxallid',
	            event: 'click',
	            handler: function () {
	            	if($(this).prop("checked")){
						 $("#list-table input").prop("checked",true);
					 }else{
						 $("#list-table input").prop("checked",false);
					 }
	            }
	        },{
	            el: '#add',
	            event: 'click',
	            handler: function () {
        			var pripIdList = new Array();
        			$("input:checkbox[name='pubscinfocheckbox']:checked").each(function () {
        				pripIdList.push($(this).val());
        			});
        			if (pripIdList.length > 0) {
        				layer.confirm('您确定要导入这批企业名称吗？', {icon: 2, title: '提示'}, function (index) {
        					var formParam = {
        							taskUid:$("#taskUid").val(),
        							priPIDs: pripIdList.toString()
        					};
        					http.httpRequest({
        						url: window._CONFIG.chooseUrl+'/server/specialrec/ent/addSpecialreceEnt',
        						data: formParam,
        						type:"post",
        						success: function (data) {
        							layer.msg(data.msg, {time: 1000}, function () {
        								if(data.status == 'success'){
        									layer.close({reload:true,reBackUid:data.data});
        								}
        							});
        						}
        					});
        				});
        			}else {
        				layer.msg("请您先<em style='color: red;'>【选中一项】</em>进行操作!", {icon: 7,time: 1000});
        			}
	            }
	        },{
	            el: '#addAll',
	            event: 'click',
	            handler: function () {
        			layer.confirm('您确定要导入所有企业吗？', {icon: 2, title: '提示'}, function (index) {
        				var formParam = $('#searchForm').serializeObject();
        				var categCode=new Array();
                		$(":checkbox[name=entCatg]:checked").each(function(k,v){
                			categCode[k]= this.value;
                		});
                		$("#entTypeCatg").val(categCode);
                		var userType = $("#userType").val();
    	            	var url = '/reg/pub/server/sccheck/entback/addAll';
    	            	if(userType == '2'){
    	            		url = '/syn/pub/server/sccheck/entback/addAll';
    	            	}
    					http.httpRequest({
    						url: url,
    						serializable: false,
    						data: $("#searchForm").serializeObject(),
    						type:"post",
    						success: function (data) {
    							layer.msg(data.msg, {time: 1000}, function () {
    								if(data.status == 'success'){
    									layer.close({reload:true});
    								}
    							});
    						}
    					});
    				});
	            }
	        },{
	            el: '#close',
	            event: 'click',
	            handler: function () {
            		layer.close({reload:false});
	            }
	        },{
	        	el:"#selectEntType",
	        	event:'click',
	        	handler:function(){
	        		showEntTypeTree();
	        	}
	        },{
	        	el:'#selectIndustry',
	        	event:'click',
	        	handler:function(){
	        		showIndustryTree();
	        	}
	        },{
		        el:'#selectRegOrg',
		        event:'click',
		        handler:function(){
		        	showRegOrgTree();
		        }
	        }, {
		        el:'#selectLocalAdm',
		        event:'click',
		        handler:function(){
		        	showLocalAdmTree();
		        }
	        },{
	            el: '#search',
	            event: 'click',
	            handler: function () {
	            	//登记状态
	        		var regStateM = $("#regStateM").val();
	        		$("#regState").val(regStateM);
	        		
	            	var categCode=new Array();
            		$(":checkbox[name=entCatg]:checked").each(function(k,v){
            			categCode[k]= this.value;
            		});
            		$("#entTypeCatg").val(categCode);
	            	params = $("#searchForm").serializeObject();
	            	listtable.ajax.reload();
	            	$("#chooseAll").prop("checked",false);
	            	$("#checkboxallid").prop("checked",false);
	            }
	        },
	        {
	        	el:'#cancel',
	        	event:'click',
	        	handler:function(){
	        		$('#searchForm')[0].reset(); 
	        		$("#industryCo").val("");
	        		$("#regOrg").val("");
	        		$("#localAdm").val("");
	        		$("#entType").val('');
	        		$("#yearMode").val('');
	        		$("#checkDep").val('');
	        		$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
	        	}
	        },
	        {
	        	el: '#chooseYearMode',
	            event: 'click',
	            handler: function () { 
	                layer.dialog({
	                    title: '选择年度年报状态',
	                    area: ['400px', '600px'],
	                    content: '/syn/panoramasearch/yearStatusTree',
	                    callback: function (data) { 
	                    	var returncode=data.returncode;
	                    	if(returncode!=null&&returncode!=""){
	                    		returncode=returncode.substr(0,returncode.length-1); 
	                    	}
	                    	$("#yearMode").val(returncode);
	                    	$("#yearModeName").val(data.returnname);  
	                    }
	                })
	            }
	        },
	        {
	        	el: '#selectCheckOrg',
	        	event: 'click',
	        	handler: function () { 
	        		layer.dialog({
	    	            title: '选择检查部门',
	    	            area: ['350px', '666px'],
	    	            content: '/commom/server/regorg/regorgmutiselectnocheck',
	    	            callback: function (data) {
	    	            	$("#checkDep").val(data.returncodes);
	    	            	$("#checkDepName").val(data.returnname);
	    	            }
	    	        })
	        	}
	        }
	        ]);
	    }
	    
	    function showEntTypeTree(){
	    	layer.dialog({
	            title: '选择企业类型',
	            area: ['350px', '666px'],
	            content: '/commom/server/entcatg/entcatgmutiselect',
	            callback: function (data) {
	            	$("#entType").val('');
	            	$("#entTypeName").val('');
	            	$("#entType").val(data.returncodes);
	            	$("#entTypeName").val(data.returnname);
	            }
	        })
	    }
	    function showIndustryTree(){
	    	layer.dialog({
	            title: '选择行业',
	            area: ['350px', '666px'],
	            content: '/commom/server/industry/toIndustryPhyTree',
	            callback: function (data) {
	            	$("#industryCo").val('');
	            	$("#industryName").val('');
	            	$("#industryCo").val(data.returncodes);
	            	$("#industryName").val(data.returnname);
	            }
	        })
	    }
	    
	    function showRegOrgTree(){
	    	layer.dialog({
	            title: '选择登记机关',
	            area: ['350px', '666px'],
	            content: '/commom/server/regorg/regorgmutiselectnocheck',
	            callback: function (data) {
	            	$("#regOrg").val('');
	            	$("#regOrgName").val('');
	            	$("#regOrg").val(data.returncodes);
	            	$("#regOrgName").val(data.returnname);
	            }
	        })
	    }
	    function showLocalAdmTree(){
	    	layer.dialog({
	            title: '选择管辖单位',
	            area: ['350px', '666px'],
	            content: '/commom/server/regunit/regunitmutiselectnocheck',
	            callback: function (data) {
	            	$("#localAdm").val('');
	            	$("#localAdmName").val('');
	            	$("#localAdm").val(data.returncodes);
	            	$("#localAdmName").val(data.returnname);
	            }
	        })
	    }
	    
	    
	    
});
