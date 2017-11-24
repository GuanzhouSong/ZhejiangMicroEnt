require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {


    var searchParams={};//查询参数声明!
    var table;
    var clickFlag = false;
    var searchFlag = 0;
    init();
    //时间控件初始化
//    laydate.skin('molv');//初始化皮肤 (墨绿)
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
    /**
     * 初始化函数集合
     */
    function init() {
    	inityear();
//        initDataTable();
        bind();
      }

    //初始化年份
    function inityear(){
         //自动生成年度
         var _thisYear = window._CONFIG.year;
         for (; 2013 <= _thisYear; _thisYear--) {
     		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
         };
    }


    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = 1;
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/reg/server/opanomaly/pbopanomaly/pbopanomalySearchList.json',
                data:function(d){
                        d.params = searchParams;
                }
            },
            columns: [
				{data: null,defaultContent:'id',width:'24px', className: 'center'},
				{data: 'regNO',width:'200px'},
				{data: 'entName',cut: {length: 20,mark:'...'}},
				{data: 'leRep'},
				{data: 'estDate'},
				{data: 'dom',cut: {length: 20,mark:'...'}},
				{data: 'excpStaResCN',cut: {length: 20,mark:'...'}},
				{data: 'cogDate'},
				{data: 'norReaCN',cut: {length: 20,mark:'...'}},
				{data: 'norDate'},
				{data: 'decorgCN',cut: {length: 20,mark:'...'}},
				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
				{data: 'localAdmName',cut: {length: 20,mark:'...'}},
				{data: 'sliceNOName',cut: {length: 20,mark:'...'}}
            ],
            columnDefs: [
                         {
                             targets: 4,
                             render: function (data, type, row, meta) {
									if( row.estDate == null){
   						        		return "";
   									}else{
   										return row.estDate;
   									}
                             }
                         }
                     ],
            fnDrawCallback:function( nRow){
           	 //统计查询结果
           	 getEntCount();
            } 
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	clickFlag = true;
    	searchParams = $("#taskForm").serializeObject();
    	if(searchFlag == 0){
    		initDataTable();
    	}else{
            table.ajax.reload();
    	}
    }); 
    
    //统计查询结果
    function  getEntCount(){ 
        http.httpRequest({
            url: '/reg/server/opanomaly/pbopanomaly/getEntCount',
            serializable: false,
            data: null,
            type: 'post',
            success: function (data) { 
         	    $("#entCount").text(data.data.EntCount);
         	    $("#markEntCount").text(data.data.MarkEntCount);
         	    $("#renewEntCount").text(data.data.RenewEntCount);
            }
        });
     }

    function bind() {
        util.bindEvents([{
            el: '#user-table tr',
            event: 'click',
            handler: function () {
            	var data = table.row($(this)).data();
                 layer.dialog({
                    title: '经营异常状态查询详情',
                    area: ['1024px', '500px'],
                    content: '/reg/server/opanomaly/pbopanomaly/pbopanomalySearchViewPage?busExcList='+data.busExcList,
                    callback: function (data) {
                         
                    }
                })
            }},{
                el: '#choseorgReg',
                event: 'click',
                handler: function () { 
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['400px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	var returnname=data.returnname;
                        	$("#regOrg").val(returncode);
                        	$("#regOrgName").val(returnname);
                        }
                    })
                }
            },{
                el: '#choseCheckDep',
                event: 'click',
                handler: function () { 
                    layer.dialog({
                        title: '选择抽检机关',
                        area: ['400px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	var returnname=data.returnname;
                        	$("#checkDep").val(returncode);
                        	$("#checkDepName").val(returnname);
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
                        	var returnname=data.returnname;	 
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(returnname);
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
                        	var returncode=data.returncodes;
                        	$("#sliceNO").val(returncode);
                        	$("#sliceNOName").val(data.returnname);  
                        }
                    })
                }
            },{
                el: '#select-intercept-out',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '移出原因',
                        area: ['580px', '300px'],
                        content: '/commom/server/intercept/interceptselect?selecttype=indiOutReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#norRea").val(data.id);
                                $("#norReaText").val(data.text);
                            }
                        }
                    })
                }
            }, {
                el: '#select-intercept-in',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '列入原因',
                        area: ['580px', '300px'],
                        content: '/commom/server/intercept/interceptselect?selecttype=indiInReaCodeList',
                        callback: function (data) {
                            if(data){
                                $("#excpStaRes").val(data.id);
                                $("#excpStaResText").val(data.text);
                            }
                        }
                    })
                }
            },
            {
                el: '#reset', //重置
                event: 'click',
                handler: function () {
                	$('.hidden_input').val('');//重置隐藏域
                }
            
        }])
    }

})
