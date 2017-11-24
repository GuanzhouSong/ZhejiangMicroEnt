require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

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
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/yr/questionnairesearch/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: "id"},
                {data: null},
                {data: 'year'},
                {data: 'regNO'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'telNum'},
                {data: 'setTime'},
                {data: 'setName'},
                {data: 'auditState'},
                {data: 'mobTel'},
                {data: 'auditName'},
                {data: 'auditDate'},
                {data: 'dom'},
                {data: 'regOrgName'},
                {data: 'checkDepDesc'},
                {data: 'localAdmName'},
                {data: 'sliceNOName'}
            ],
             columnDefs : [
							{
								targets : 9,
								render : function(data, type, row, meta) {
									if (row.auditState == '2') {
										return "已提交";
									}else if (row.auditState == '3') {
										return "已修正";
									}else{
										return "未提交";
									}
								}
							}, {
								targets: 1,
			                    render: function (data, type, row, meta) {
			                    return "<a class='commit look'>查看</a>";
			                    }
			                }]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 

    function bind() {
        util.bindEvents([{
            el: '.look',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	console.log(data);
                layer.dialog({
                    title: '个转企调查表查看',
                    area: ['90%', '90%'],
                    content: '/reg/server/yr/questionnairesearch/view?pripid='+data.priPID+'&year='+data.year,
                    callback: function (data) {
                        //重新加载列表数据
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
            el: '#chosecheckDep',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择抽查机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#checkDep").val(returncode);
                    	$("#checkDepName").val(data.returnname);  
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
                    content: '/commom/server/sliceno/slicenomutiselect',
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#checkDep").val("");
            	$("#sliceNO").val("");
            }
        }])
    }

})
