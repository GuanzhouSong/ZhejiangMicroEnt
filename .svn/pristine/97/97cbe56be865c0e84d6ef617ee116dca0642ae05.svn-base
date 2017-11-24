require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {

	var searchParams={};
	var table;
	
    init();
    
    /**
     * 初始化函数集合
     */
    function init() { 
        initDataTable();
        bind();
    }
    
    $("#checkManFlags").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });
    
    $("#checkWays").multipleSelect({
    	selectAllText: '全部',
    	allSelected: '全部',
    	selectAllDelimiter: '',
    	minimumCountSelected: 10
    });

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#sccheckbill-table',
            showIndex: true,
            scrollX:true,
            ajax: {
                url:'/syn/server/drcheck/pubsccheckbill/listJSON',
                data:function(d){
               		 d.params = $("#qryForm").serializeObject();
                }
            },
            columns: [
                {data: '_idx', 'className': 'center'},
                {data: null, 'className': 'center'},
                {data: 'checkDesc', 'className': 'center'},
                {data: 'checkItemDesc'},
                {data: 'checkWay'},
                {data: 'checkManFlag'},
                {data: 'isScVlid'},
                {data: 'setUserName'},
                {data: 'setTime'},
                {data: 'setDeptName'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) {
			      	return "<a class='commit js_update'>修改</a>";
			   }
		    },{
				targets: 4,
			    render: function (data, type, row, meta) {
			    	if(row.checkWay){
			    		var checkWay = row.checkWay;
			    		checkWay = checkWay.replace("1","现场检查");
			    		checkWay = checkWay.replace("2","书式检查");
			    		checkWay = checkWay.replace("3","检验检测");
			    		checkWay = checkWay.replace("4","行政部门检查结果或专业意见");
			    		checkWay = checkWay.replace("5","审计、验资、评估等第三方验证");
			    		checkWay = checkWay.replace("6","网络监测");
			    		return checkWay;
			    	}else{
			    		return "";
			    	}
			   }
		    },{
				targets: 5,
			    render: function (data, type, row, meta) {
			    	if(row.checkManFlag=="Y"){
						 return "需要专业岗资格";
					}else{
						 return "无需专业岗资格";
					}
			   }
		    },{
				targets: 6,
			    render: function (data, type, row, meta) {
			    	if(row.isScVlid == "Y"){
						 return "有效";
					}else{
						 return "<span style='color:red;'>失效</span>";
					}
			   }
		    }]
       })
   }

   

    function bind() {
        util.bindEvents([{
            el: '#qry',
            event: 'click',
            handler: function () {
            	var checkManFlag = $("#checkManFlags").val();
            	$("#checkManFlag").val(checkManFlag);
            	var checkWay = $("#checkWays").val();
            	$("#checkWay").val(checkWay);
            	searchParams = $("#qryForm").serializeObject();
            	table.ajax.reload();
            }
       },{
		    el: '#toAdd',
		    event: 'click',
		    handler: function () {
		    layer.dialog({
		            title: '添加检查事项清单',
		            area: ['80%', '95%'],
		            content:"/syn/server/drcheck/pubsccheckbill/show?uid=",
		            callback: function (data) {
		            	if (data.reload) { 
		                	table.ajax.reload();
		                } 
		            }
		        })  
    	    }
		},{
		    el: '.js_update',
		    event: 'click',
		    handler: function () {
		    	var data = table.row($(this).closest('td')).data();
		    	var uid=data.uid;
		    	layer.dialog({
		            title: '修改检查事项清单',
		            area: ['80%', '95%'],
		            content:'/syn/server/drcheck/pubsccheckbill/show?uid='+uid,
		            callback: function (data) {
		                if (data.reload) { 
		                	table.ajax.reload();
		                }
		            }
		        })
		   }
		},{
            el: '#cancel',
            event: 'click',
            handler: function () {
	            $('#qryForm')[0].reset();
	            $("#checkManFlag").val("");
	            $("#checkWay").val("");
	            $('#checkManFlags').multipleSelect('setSelects',['']);
	            $('#checkWays').multipleSelect('setSelects',['']);
            }
		}])
    }

})
