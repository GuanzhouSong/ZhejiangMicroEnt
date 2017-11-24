require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var initFlag = true;
    var searchParams={};
	var table; 
	var regStateList = [];
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        getRegStateList();
    }
    
  //获取登记状态
    function getRegStateList() {
    	$('#regState option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
    }

    //处罚类型
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
    	var userType= $("#userType").val(); 
        var typeUrl = "";
        if(userType == "2"){
      	  typeUrl ="/syn/server/pubotherpunishsearch/list.json";
        }else{
      	  typeUrl ="/pub/server/pubotherpunishsearch/list.json";
        }
        table = dataTable.load({
            el: '#user-table',
			scrollX:true, //支持滚动
			aLengthMenu: [10, 25, 50, 100,1000,2000],
            showIndex: true,
            ajax: {
                url:typeUrl,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: null,width:'85px'},
                {data: 'penDecNo',width:'120px'},
                {data: 'illegActType',width:'120px'},
                {data: 'judAuth',width:'120px',cut: {length: 20,mark:'...'}},
                {data: 'penDecIssDate',width:'100px'},
                {data: 'punIsAlter',width:'80px'},
                {data: 'punSource',width:'80px'},
                {data: 'auditDate',width:'100px'},
                {data: 'regNO',width:'120px'},
                {data: 'entName',width:'120px'},
                {data: 'regState',width:'80px'},
                {data: 'dom',width:'120px',cut: {length: 20,mark:'...'}},
                {data: 'regOrgDesc',width:'120px',cut: {length: 15,mark:'...'}},
                {data: 'localAdmName',width:'120px',cut: {length: 15,mark:'...'}},
                {data: 'sliceNOName',width:'120px',cut: {length: 15,mark:'...'}}
            ],
            fnDrawCallback:function(nRow){
            	initpunishtotal();
            }, 
             columnDefs : [
                       		{
								targets: 7,
			                    render: function (data, type, row, meta) {
			                    	if(row.punSource =='1') {
			                    		return "其它部门公示";
			                    	}else if(row.punSource == '2'){
			                    		return "工商部门公示";
			                    	}else if(row.punSource == '3'){
			                    		return "企业公示";
			                    	}else{
			                    		return "-";
			                    	}
			                    }
			                },{
								targets: 11,
			                    render: function (data, type, row, meta) {
			                    	return switchRegStateList(row.regState);
			                    }
			                },{
	                             targets: 1,
	                             render: function (data, type, row, meta) {
	                             	return "<a class='commit view'>查看</a>";
	                             }
	                         },{
								targets: 3,
			                    render: function (data, type, row, meta) {
			                    	 var data = row.illegActType;
			                    	 if(data && (data.length > 20)){
		                                    $(table.cell( meta.row, meta.col ).node()).attr('title',data);
		                                    return (data.substr( 0, 20 )+'....');
		                              }
			                    	 return row.illegActType;
			                    }
				           }]
        })
    }
    
    //行政处罚计数个数
    function initpunishtotal(){
    	var userType= $("#userType").val(); 
        var typeUrl = "";
        if(userType == "2"){
      	  typeUrl="/syn/server/pubotherpunishsearch/total.json";
        }else{
      	  typeUrl="/pub/server/pubotherpunishsearch/total.json";
        }
    	var totalParams = $("#taskForm").serializeObject();
        http.httpRequest({
            url: typeUrl,
            serializable: true,
            data: totalParams,
            type: 'post',
            success: function (data) {
            	$("#otherTotal,#otherAmount,#businessTotal,#businessAmount,#comTotal,#comAmount").html("").text("0");
            	for(var i=0;i<data.length;i++){
            		if(data[i].punSource == '1'){
            			$("#otherTotal").html("").text(data[i].total);
                    	$("#otherAmount").html("").text(data[i].amount);
            		}
            		if(data[i].punSource == '2'){
            			$("#businessTotal").html("").text(data[i].total);
                    	$("#businessAmount").html("").text(data[i].amount);
            		}
            		if(data[i].punSource == '3'){
            			$("#comTotal").html("").text(data[i].total);
                    	$("#comAmount").html("").text(data[i].amount);
            		}
            	}
            	var totalAll =parseInt($("#businessTotal").text()) + parseInt($("#otherTotal").text()) + parseInt($("#comTotal").text());
            	var amountAll = parseInt($("#businessAmount").text()) + parseInt($("#otherAmount").text()) + parseInt($("#comAmount").text());
            	$("#totalAll").html("").text(totalAll);
            	$("#amountAll").html("").text(amountAll);
            }
        })
    }
    
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	if(initFlag)initDataTable();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	var userType= $("#userType").val(); 
                var typeUrl="";
                if(userType=="2"){
                    typeUrl="/syn";
                }else{
                	typeUrl="/pub";
                }
                layer.dialog({
                    area: ['68%', '100%'],
                    content: typeUrl+'/server/pubotherpunishsearch/view?pripid='+data.priPID+'&caseNO='+data.caseNO+'&punSource='+data.punSource,
                    callback: function (data) {
                        if (data.reload) {
                        }
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
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#chosesliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择责任区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNO").val(returncode);
                    	$("#sliceNOName").val(data.returnname);  
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
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNO").val("");
            }
        }])
    }

})
