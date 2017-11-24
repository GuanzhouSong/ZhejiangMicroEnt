require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchFlag="0";
	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
      }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	 searchFlag="1";
     	 var url=_sysUrl+'/erescscrinfo/list.json';
         table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
 			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:url,
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,'defaultContent':'11'},
                {data: 'entName',cut: {length: 20,mark:'...'}}, 
                {data: 'uniSCID',cut: {length: 20,mark:'...'}},
                {data: 'simplecanReaName',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',cut: {length: 20,mark:'...'}},
                {data: 'localAdmName',cut: {length: 20,mark:'...'}},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'opScope',cut: {length: 20,mark:'...'}},
                {data: 'leRep'}
            ],
             columnDefs : [
								{
								    targets: 2,
								    render: function (data, type, row, meta) {
								   	  if(data!=null&&data!=""){
								   		  return data;
								   	  }else{
								   		  return row.regNO;
								   	  }
								    }
								} 	 
							]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject(); 
    	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload(); 
    	}
    }); 

    function bind() {
        util.bindEvents([
        {
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
            	  layer.dialog({
                      title: '选择登记机关',
                      area: ['25%', '60%'],
                      content: '/commom/server/regorg/regorgmutiselect',
                      callback: function (data) { 
                       	var returncode=data.returncodes;
                      	var returnname=data.returnname;
                      	$("#regOrg").val(returncode);
                      	$("#regOrgName").val(returnname);
                      }
                  })
            }
        },
        {
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择管辖单位',
                    area: ['25%', '60%'],
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                    	var returnname=data.returnname;	 
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(returnname);
                    }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            }
        }
        ])
    }

})
