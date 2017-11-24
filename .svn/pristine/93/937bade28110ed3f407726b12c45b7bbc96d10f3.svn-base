require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	 init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }
    var backtable;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	backtable = dataTable.load({
            el: '#foodstorageback-table',
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/foodstorageback/list.json',
                data:function(d){
                	d.params = $("#taskForm").serializeObject();
                }
            },
            columns: [
				{data: '_idx',width:'5%',className: 'center'},
				{data: null,width:'10%'},
				{data: 'entName',width:'20%'},
				{data: 'backTime',width:'10%'},
				{data: 'backReason',width:'15%'},
				{data: 'backName',width:'10%'},
				{data: 'regORgDesc',width:'20%'},
				{data: 'localAdmDesc',width:'10%'}
            ],
            columnDefs: [{
				targets:1,
				render:function(data,type,row,meta){
					if(data.uniSCID != null && data.uniSCID != ""){
						return data.uniSCID;
					}else{
						return data.regNO;
					}
				}
			 }]
        });
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	backtable.ajax.reload();
    }); 
//    
    function bind() {
        util.bindEvents([{
            el: '#showBaseList',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/yr/foodstorageback/basebacklist';
            }
        },{
            el: '#choseregUnit',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择管辖单位',
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncodes;
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
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
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#regOrg").val(returncode);
                    	$("#regOrgName").val(data.returnname);  
                    }
                })
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            }
        }]);
    }

});
