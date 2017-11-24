require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

    var recoParams={};//查询参数声明!
    var table;
	init();
    //时间控件初始化
    // laydate.skin('molv');//初始化皮肤 (墨绿)
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数

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
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/reg/server/opanomaly/pbopanomaly/pbopanomalySearchRecoverList.json',
                data:function(d){
                   d.params = recoParams;
                }
            },
            columns: [
				{data: null,defaultContent:'id',width:'24px',className: 'center'},
				{data: null,defaultContent:'priPID',width:'70px',className: 'center'},
				{data: 'regNO',width:'200px'},
				{data: 'entName',cut: {length: 20,mark:'...'}},
				{data: 'leRep'},
				{data: 'excpStaResCN',cut: {length: 20,mark:'...'}},
				{data: 'cogDate'},
				{data: 'setName'},
				{data: 'regOrgName',cut: {length: 20,mark:'...'}},
				{data: 'localAdmName',cut: {length: 20,mark:'...'}} 
            ], 
            columnDefs: [
                            {
                                targets: 1,
                                render: function (data, type, row, meta) {
                          		  return '<a class="js-reco" priPID="'+row.priPID+'" year="'+row.year+'" href="javascript:void(0);" >异常恢复</a>';
                                }
                            }
                        ],
         })
    }
    
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	recoParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    }); 
    
   

    function bind() {
        util.bindEvents([{
            el: '.js-reco',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                 layer.dialog({
                    title: '经营异常状态恢复查询详情',
                    area: ['1024px', '500px'],
                    content: '/reg/server/opanomaly/pbopanomaly/pbopanomalyRecoPage?busExcList='+data.busExcList+'&priPid='+data.priPID,
                    callback: function (data) {
                    	if(data.reload){
                    		table.ajax.reload();
                    	}
                    }
                });
            }
        },{
            el: '#recoBtn',
            event: 'click',
            handler: function () {
            	if ($.trim($("#recoverRea").val()) == "") {
                    layer.msg("请输入事实和理由");
                     return false;
                 } 
            	if ($("#recoverRea").val().length >500) {
                    layer.msg("长度不能超过500字");
                     return false;
                 } 
           	 recoParams = $("#pboRecoform").serializeObject();
           	 if(recoParams.norReaCN == ''){
                 layer.msg("移出原因显示失败，不属于本操作范围");
                 return false;
           	 }
//           	 console.log(recoParams);
           	  http.httpRequest({
                     url: '/reg/server/opanomaly/pbopanomaly/recoSign.json',
                     type: 'post',
                     data: recoParams,
                     success: function (data) {
                         if (data.status == 'success') {
                             if (data.msg) {
                                 layer.msg(data.msg, {time: 500}, function () {
                               	   layer.close({reload:true});
                                 });
                             }
                         }
                     }
                 });
            }
        },
   	 {
            el: '#cancel',
            event: 'click',
            handler: function () {
           	  layer.close();
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
        },
        {
            el: '#select-intercept-out', //个体户移出原因
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
        },{
            el: '#select-intercept-in',//个体户移入原因
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '列入原因',
                    area: ['580px', '300px'],
                    content: '/commom/server/intercept/interceptselect?selecttype=indiInReaCodes',
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
        }
        ]);
    }
})
