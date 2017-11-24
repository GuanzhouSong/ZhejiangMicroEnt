require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var searchFlag="0";
	var searchParams;//查询参数声明!
	function timeOut(){
    	$("#js-download").prop('disabled',false);
    }
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    $("#badInfoM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});

	$("#yrRepStateM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
	$("#regStateM").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
	$('#yrRepStateM').multipleSelect('checkAll');
	//取值  $("#yrRepStateM").multipleSelect('getSelects');
	
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
    	var currentDate = new Date();
    	var currentYear = currentDate.getFullYear();//当前年份
		var currentReportYear = currentDate.getFullYear()-1;//当前应报年度
		var currentMounth = currentDate.getMonth()+1;//当前月份
    	
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/opanomaly/pbopanomaly/addPbopanomalyList.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: null,width:'40px'},
                      {data: 'regNO'},
                      {data: 'entName',className: 'left'},
                      {data: 'leRep'},
                      {data: 'regOrgName',className: 'left'},
                      {data: 'localAdmName',className: 'left'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
						return "<input type='radio' priPID="+row.priPID+" class='_radio' name='_radio'>";
 					}
 				 },
 				{
 					targets:2,
 					render:function(data,type,row,meta){
						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
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
    
    function bind() {
        util.bindEvents([  
        	{
                el: '#ret',
                event: 'click',
                handler: function () {
                	window.location.href='/reg/server/opanomaly/pbopanomaly/pbopanomalyApp';
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
                        	var returnname=data.returnname;	 
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(returnname);
                        }
                    })
                }
            },{
            el: '#add',
            event: 'click',
            handler: function () {
            	var _radio = $("input[name='_radio']:checked");
            	if(_radio.length!=0){
            		var priPID = _radio.attr("priPID");
            		if(priPID!=null && priPID != ''){
	            		layer.dialog({
	                        title: '新增标记异常记录',
	                        area: ['80%', '80%'],
	                        content:'/reg/server/opanomaly/pbopanomaly/addPbopanomaly?priPID='+priPID,
	                        callback: function (data) {
	                            if (data.reload) { 
	                            	 table.ajax.reload();  
	                            }
	                        }
	                    })
            		}
            	}else{
            		layer.msg("请选择企业再操作", {ltype: 0,time:2000});
            	}
            }
        },{
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$('#regOrg').val($('#rocode').val());
            	$("#regOrgName").val($('#rocontent').val());
            }
        }])
    }
})
