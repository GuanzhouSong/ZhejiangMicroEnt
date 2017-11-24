require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

  var searchParams={};//查询参数声明!
    var table;
    init(); 
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
        }


    

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	
        var tpl = $('#tpl').html();
    	searchParams=$("#taskForm").serializeObject();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/opanomaly/pubopanomaly/panoQueryPage',
                data:function(d){
	               		 d.params = $("#taskForm").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                      {data: null,'defaultContent':'11', 'className': 'center'},
                      {data: null,'defaultContent':'11', 'className': 'center'},
                      {data: 'uniscid', 'className': 'center',cut: {length: 20,mark:'...'}},
//                      {data: 'regNO', 'className': 'center',cut: {length: 20,mark:'...'}},
                      {data: 'entName' ,'className': 'center',cut: {length: 20,mark:'...'}},
                      {data: 'leRep', 'className': 'center',cut: {length: 20,mark:'...'}},
//                      {data: 'entTypeName', 'className': 'center',cut: {length: 20,mark:'...'}},
//                      {data: 'industryCoName', 'className': 'center',cut: {length: 20,mark:'...'}},
//                      {data: 'dom', 'className': 'center',cut: {length: 20,mark:'...'}},
                      {data: 'regOrgName', 'className': 'center',cut: {length: 20,mark:'...'}},
                      {data: 'localAdmName', 'className': 'center',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
	         {   targets:1,
            		render:function(data,type,row,meta){
                    return  '<input type="radio" name="_radio"  title='+row.entName+'  value='+row.priPID+'>';
            		}
             },
             {   targets:2,
	        	 render:function(data,type,row,meta){
                 	  if(data == null || data == ""){ 
                  		  return row.regNO;
                  	  }else{
                  		  return data;
                  	  }
	        	 }
	         }
            ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '#backpubOpanoMalySfcList',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/opanomaly/pubopanomaly/pubOpanoMalySfcListPage';
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	$("#regOrg").val(window._CONFIG._regOrg); 
            	$("#localAdm").val("");
            	$("#entTypeCatg").val("16,17");
            	$("#regState").val("A,B,K,DA,X,Q"); 
            }
        },{
            el: '#pubOpanoMalySfcapply',
            event: 'click',
            handler: function () { 
            	var radioArr= $(":radio[name=_radio]:checked");
            	if(radioArr==null||radioArr.length==0){
            		 layer.msg("请选择企业再操作", {ltype: 0,time:2000});
                     return false;
            	}
            	layer.dialog({
                    title: '经营异常名录设置-申请',
                    area: ['80%', '75%'],
                    content: '/reg/server/opanomaly/pubopanomaly/pubOpanoMalyAddSign?priPID='+radioArr[0].value,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
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
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择登记机关',
                    area: ['25%', '60%'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                    callback: function (data) {
                   	var returncode=data.returncodes;
                    	var returnname=data.returnname;
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(returnname);
                    }
                })
            }
        }
        ]);
    }

})
