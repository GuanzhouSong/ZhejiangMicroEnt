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
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/orderreformset/panoQueryPage',
                data:function(d){
	               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null,'defaultContent':'11'},
                {data: null,'defaultContent':'11'},
                {data: 'uniscid',cut: {length: 20,mark:'...'}},
                {data: 'entName',cut: {length: 20,mark:'...'}},
                {data: 'leRep',cut: {length: 20,mark:'...'}},
                {data: 'entTypeName',cut: {length: 20,mark:'...'}},
                {data: 'industryCoName',cut: {length: 20,mark:'...'}},
                {data: 'dom',cut: {length: 20,mark:'...'}},
                {data: 'regOrgName',cut: {length: 20,mark:'...'}},
                {data: 'localAdmName',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
	         {   targets:1,
            		render:function(data,type,row,meta){
                    return  '<input type="radio" name="_radio"  title='+row.entName+'  value='+row.priPID+'>';
            		}
            	},
	         {   targets:2,

            		render:function(data,type,row,meta){
                    if(data==null||data=='')return row.regNO;
                    else return data;
            		}
            	}
            ]
        })
    }

    /**
     * 初始化dataTable
     */
   /* function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#midbasepubopanomalylist_table',
			showIndex: true,
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/opanomaly/pubopanomaly/midBasePubOpanoMalyListJSON.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                  	{data: 'id',width:"24px"}, 
                  	{data: null, width: "50px"},
    				{data: 'regNO',width:"150px"},
    				{data: 'entName',width:"200px"},
    				{data: 'leRep',width:"80px"},
    				{data: 'estDate',width:"80px"},
    				{data: 'regOrgName',width:"200px"},
    				{data: 'localAdmName',width:"200px"}  
            ] ,
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) { 
                           		      return '<input type="radio" name="_radio" title='+row.entName+'  value='+row.priPID+'>';
                             }
                       } 
            ]
         })
    }*/
    
    
    //表格之外的查询按钮事件
    $("#qry").click(function(){
    	searchParams = $("#qryForm").serializeObject();
        table.ajax.reload();
    }); 
    

    function bind() {
        util.bindEvents([{
            el: '#backOrderReformSet',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/orderreformset/orderReformSetListPage';
            }
        },{
            el: '#orderReformSetapply',
            event: 'click',
            handler: function () {
            	
            	var radioArr= $(":radio[name=_radio]:checked");
            	if(radioArr==null||radioArr.length==0){
            		 layer.msg("请选择企业再操作", {ltype: 0,time:500});
                     return false;
            	}
            	var entName=radioArr[0].title;
            	layer.dialog({
                    title: '添加',
                    area: ['80%', '88%'],
                    content: '/reg/server/orderreformset/orderReformSetApplyEditPage?pripid='+radioArr[0].value+"&viewFlag=1",
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$(':input', '#qryForm')
                .not(':button, :submit, :reset')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
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
            el: '#choseEntType',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择企业类型',
                    area: ['25%', '70%'],
                    content: '/commom/server/entcatg/entcatgmutiselectnocheck',
                    callback: function (data) {
                        //重新加载列表数据
                        $("#entType").val(data.returncode);
                        var name = data.returnname;
                        $("#entTypeName").val(name);
                    }
                })
            }
        }
        ,
        {
            el: '#choseIndustryCo',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '选择行业',
                    area: ['25%', '70%'],
                    content: '/commom/server/industry/toIndustryPhyTree',
                    callback: function (data) {
                        //重新加载列表数据
                        $("#industryCo").val(data.returncode);
                        $("#industryCoName").val(data.returnname);
                    }
                })
            }
        },
        {
            el: '#more',
            event: 'click',
            handler: function () { 
                var isHideOrShow = $("#hideorshow").is(":hidden");
            	if(isHideOrShow){
            		 $("#more").val("收起");
            		 $("#hideorshow").css("display","block");
					//$("#hideorshow").toggle();

				}else{
					$("#more").val("更多查询条件");
            		$("#hideorshow").css("display","none");
				}
            }
        }
        ]);
    }

})
