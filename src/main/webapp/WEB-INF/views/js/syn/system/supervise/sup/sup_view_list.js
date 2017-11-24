require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var sysDate = getNowFormatDate();
	var searchParams=$("#hx-form").serializeObject();//查询参数声明!
	var table;
	
    init();
    
    //获取当前时间
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }
    
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
            el: '#apply_table',
			scrollX:true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/syn/supervise/doQueryForViewList',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx', className: 'center'},
                {data: 'supCheckState', className: 'center'},
                {data: 'supState',className: 'center' },
                {data: 'batchNO',className: 'center'},
                {data: 'markName', className: 'center'},
                {data: 'markUseArea', className: 'center'},
                {data: 'markStartDateDesc',className: 'center'},
                {data: 'markEndDateDesc',className: 'center'},
                {data: 'entName',className: 'center'},
                {data: 'uniscid',className: 'center'},
                {data: 'regNO',className: 'center'},
                {data: 'inputPer',className: 'center'},
                {data: 'inputDateDesc', className: 'center'},
                {data: 'checkPer',className: 'center'},
                {data: 'checkDateDesc', className: 'center'}
            ],
             columnDefs : [
			                {
								targets:1,
			                    render: function (data, type, row, meta) {
			                    	if(row.supCheckState=='0') return "未通过";
			                    	else if(row.supCheckState=='1') return "通过";
			                    	else if(row.supCheckState=='2') return "未审核";
			                    	else if(row.supCheckState=='3') return "审核退回";
			                    }
			                },
			                {
								targets:2,
			                    render: function (data, type, row, meta) {
			                    	if(row.supState=='1'&& row.markState=='1'&&(!(Date.parse(sysDate) > Date.parse(row.markEndDate)))&&(!(Date.parse(sysDate) < Date.parse(row.markStartDate)))) 
			                    		return "有效";
			                    	else return "无效";
			                    }
			                }
					  ]
        })
    }
    

    function bind() {
	    util.bindEvents([{
	        el: '#selectRegOrg',//管辖单位
	        event: 'click',
	        handler: function () {
	        	selectRegOrg();
	        }
	    },{
	        el: '#selectRegUnit',//管辖单位
	        event: 'click',
	        handler: function () {
	        	selectRegUnit();
	        }
	    },{
	        el: '#reset',//重置
	        event: 'click',
	        handler: function () {
	        	$('.clx').val('');
	        }
	    },{
	    	el:'#search',
	    	event:'click',
	    	handler:function(){
	    		searchParams = $("#hx-form").serializeObject();
                table.ajax.reload();
	    	}
	    }
	    ])
    }
    
    
  //选择管辖单位
    function selectRegOrg() {
        layer.dialog({
            title: '选择登记机关',
            area: ['350px', '666px'],
            content: '/commom/server/regorg/regorgmutiselect',
            callback: function (data) {
            	$("#regOrgDeptCode").val('');
            	var returncode = data.returncode;
            	if(returncode!=null&&returncode!=""){
            		returncode=returncode.substr(0,returncode.length-1); 
            	}
            	$("#regOrgDeptCode").val(returncode);
            	$("#regOrgDeptName").val('');
            	$("#regOrgDeptName").val(data.returnname);
            }
        })
    }
    
    
    
    //选择登记机关
    function selectRegUnit() {
        layer.dialog({
            title: '选择管辖单位',
            area: ['350px', '666px'],
            content: '/commom/server/regunit/regunitmutiselect',
            callback: function (data) {
            	$("#regUnitDetpCode").val('');
            	var returncode = data.returncode;
            	if(returncode!=null&&returncode!=""){
            		returncode=returncode.substr(0,returncode.length-1); 
            	}
            	$("#regUnitDetpCode").val(returncode);
            	$("#regUnitDetpName").val('');
            	$("#regUnitDetpName").val(data.returnname);
            }
        })
    }
    
})
