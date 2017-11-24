require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchFlag="0";
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        //initDataTable();
    }
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/syn/panoramasearch/smsQueryPage',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: null,width:'40px'},
                      {data: 'regNO'},
                      {data: 'entName',width:'200px',className: 'left'},
                      {data: 'estDate',width:'80px'},
                      {data: "entTypeName",width:'150px',className: 'left'},
                      {data: 'leRep',width:'50px'},
                      {data: 'tel',width:'80px'},
                      {data: 'liaName',width:'80px'},
                      {data: 'liaTel',width:'80px'},
                      {data: 'regOrgName',width:'180px',className: 'left'},
                      {data: 'localAdmName',width:'180px',className: 'left'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
                        return "<input type='checkbox' name='_checkbox' data-pripid='"+row.priPID+"' data-entname='"+row.entName+"' data-regno='"+row.regNO+"' data-uniscid='"+row.uniscid+"'>";
 					}
 				 },
            	{
 					targets:2,
 					render:function(data,type,row,meta){
 						if(row.uniscid){return row.uniscid;}else{return row.regNO;}
 					}
 				 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
		searchParams = $("#taskForm").serializeObject();
		if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    });

    //添加申请
    $('#js-add-ui').on('click',function(){
        var batch_arr = [];
        $("input:checkbox[name='_checkbox']:checked").each(function () {batch_arr.push($(this).val());});
        if (batch_arr.length > 0 && batch_arr.length == 1) {
            var $this = $("input:checkbox[name='_checkbox']:checked");
            var pripid = $this.data();
            var regNo = $this.data();
            var unicode = $this.data();
            layer.dialog({
                title: '提请数据信息修正',
                area: ['600px', '600px'],
                content: '/commom/server/regunit/regunitmutiselect',
                callback: function (data) {

                }
            })




        } else if (batch_arr.length > 1) {
            layer.msg("只能请选择一项进行操作");
        } else {
            layer.msg("请选择一项");
        }


    });




    function bind() {
        util.bindEvents([
            {
                el: '#_checkAll',  // 选项 操作
                event: 'click',
                handler: function () {
                    var flag=$(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            },
             {
            	el: '#chooseEntType',
                event: 'click',
                handler: function () { 
                	var categCode=$("input[name='entTypeCatg']:checked").val();
                    
                    layer.dialog({
                        title: '选择企业类型',
                        area: ['400px', '600px'],
                        content: '/commom/server/entcatg/entcatgmutiselectCom?type='+categCode,
                        callback: function (data) { 
                        	var returncode=data.returncode;
                        	if(returncode!=null&&returncode!=""){
                        		returncode=returncode.substr(0,returncode.length-1); 
                        	}
                        	$("#entType").val(returncode);
                        	$("#entTypeName").val(data.returnname);  
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
                    area: ['400px', '600px'],
                    content: '/commom/server/regunit/regunitmutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                      	$("#localAdm").val(returncode);
                      	$("#localAdmName").val(data.returnname); 
                    }
                })
            }
        }, {
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
        }, {
        	el: '#chooseSliceNo',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择片区',
                    area: ['400px', '600px'],
                    content: '/commom/server/sliceno/slicenomutiselect',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    	}
                    	$("#sliceNo").val(returncode);
                    	$("#sliceNoName").val(data.returnname);  
                    }
                })
            }
        }, {
        	el: '#chooseYearMode',
            event: 'click',
            handler: function () { 
            	var categCode=new Array();
                $(":checkbox[name=chooseEntCatg]:checked").each(function(k,v){
              	   categCode[k]= this.value;
                });
                
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
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#checkDep").val("");
            	$("#sliceNo").val("");
            	$("#entType").val("");
            	$('#yearMode').val("");
            }
        }])
    }


})
