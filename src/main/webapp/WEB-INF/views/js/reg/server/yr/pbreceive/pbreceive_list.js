require(['component/iframeLayer', 'layer1','component/dataTable', 'common/util', 'common/http','handlebars', 'jquery','jquery.serialize','laydate'], function (layer,layer1, dataTable, util, http, handlebars) {
    var table;
    var searchFlag = 0 ;
    init();
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
    /**
     * 初始化函数集合
     */
    function init() {
        inityear();
//    	initDataTable();
        bind();
    }
    var msg = "";
    var tel = "";
    var year ="";
    var district = "";

    //初始化年份
    function inityear(){
         //自动生成年度
         var _thisYear =  window._CONFIG.year;
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
            //是否加索引值
            showIndex: true,
			scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/yr/pbreceive/pblist.json',
                data:function(d){
            		d.params = $.extend({}, $("#taskForm").serializeObject(), {"entTypeCatg":50,"regState":"K,B,A,DA,X"});               		              		
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, defaultContent:'id', width: "40px",className:"center"},
                {data: null, defaultContent:'priPID', width: "40px"},
                {data: 'uniscid'},
                {data: 'entName',className:"left"},
                {data: 'leRep'},
                {data: 'tel'},
                {data: 'acceptDate'},
                {data: 'acceptName'},
                {data: 'acceptDept',className:"left"},
                {data: 'dom',className:"left"},
                {data: 'regOrgName',className:"left"},
                {data: 'localAdmName',className:"left"},
                {data: 'sliceNOName',className:"left"}
            ], 
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                            	var year = $("#year").val();
                            	var _isrep = 'yrIsRep' + year; //是否年报
                            	var _yrRepMode = 'yrRepMode'+year; //报送方式
                            	var _yrFirRepTime = 'yrFirRepTime'+year; //首次报送时间
                            	 
//                            	console.log(data);
//                            	debugger
                               	 if(row.isReported == '1' || row.isReported == '2' ){  //已年报
                              		if(row.reportType == '6' ){ //纸质报送
                              			if(row.addRecState == '2'){ //已补录，显示详情
                                  			return '<a class="js-print" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >打印收讫通知书</a>\
                                  			<a class="js-sendsems" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >短信通知经营者</a>\
                                  			<a class="js-see" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >修改</a>';
                              			}else{
                                  			return '<a class="js-print" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >打印收讫通知书</a>\
                                  			<a class="js-sendsems" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >短信通知经营者</a>\
                                  			<a class="js-addrec" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >补录</a>';
                              			}
                              		}else{
                              			return '<a class="js-sendsems" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >短信通知经营者</a>';
                              		}
                              	}else{                             		
                          			return '<a class="js-receive" id="'+year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >接收</a>';
                              	}
                             }
                         },
                         {
                             targets: 2,
                             render: function (data, type, row, meta) {
                            	 if(row.uniscid == null || row.uniscid == ''){
                            		 return row.regNO;
                            	 }else{
                            		 return row.uniscid;
                            	 }

                             }
                         }
                     ]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	if(searchFlag==0){
            initDataTable();
    	}else{
            table.ajax.reload();
    	}
    }); 

    function bind() {
        util.bindEvents([{
            el: '.js-receive',
            event: 'click',
            handler: function () {
            	var year = this.id;
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '',
                    area: ['500px', '270px'],
                    content: '/reg/server/yr/pbreceive/view?priPID=' + data.priPID+'&year='+year,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })                    	
            }
        },{
        	el: '.js-sendsems',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                var firstReportTime=$(this).attr("yrFirRepTime");
            	var date = data.acceptDate == null ? firstReportTime : data.acceptDate ;
            	$("#regNo").html(data.regNO);
            	$("#sendDate").html(date);
            	$("#sendYear").html(this.id);
                layer1.open({
                    shade: [0.1,'#fff'],
                    type: 1,
                    content: $('#send-message-layer'),
                    title: false,
                    area: ['350px','210px']
                })
                msg = "注册号为："+data.regNO+"的个体户，于"+firstReportTime+"完成"+this.id+"年度报告报送";
            	tel = data.tel;
            	year = this.id;
            	district = data.regOrg;
         }},
           {
            	el: '#send',
                event: 'click',
                handler: function () {
                	http.httpRequest({
                        url: '/reg/server/yr/pbreceive/sendMsg',
                        data: {"tel": tel, "msg": msg,"district":district},
                        success: function (data) {
                            if (data.status == 'success') {
                                    layer.msg(data.msg, {time: 500}, function () {
                                    	layer1.closeAll();
                                        table.ajax.reload();
                                    });
                            }
                        }
                    });
           }
        },
        {//弹出框取消按钮
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer1.closeAll();
            }
        },
        {
        	el: '.js-print',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	var _id = "_doPrint_"+new Date().getTime();
         	    var checkRegNo = encodeURIComponent($.trim(data.regNO.replace(/(^\s*)|(\s*$)/g, "")));
         	    var checkLegRep = encodeURIComponent($.trim(data.leRep.replace(/(^\s*)|(\s*$)/g, "")));
         	    var checkOperDate = data.acceptDate;
         	    var checkOperUserName = encodeURIComponent($.trim(data.acceptName.replace(/(^\s*)|(\s*$)/g, "")));
         	    var checkOperUserDeptName = encodeURIComponent($.trim(data.acceptDept.replace(/(^\s*)|(\s*$)/g, "")));
         	   	var year = $.trim(this.id);
                var url = "/reg/server/yr/pbreceive/print?checkRegNo=" + encodeURI(checkRegNo) + "&checkLegRep=" + encodeURI(checkLegRep)+ "&checkOperDate=" + checkOperDate +"&checkOperUserName="+encodeURI(checkOperUserName) +"&checkOperUserDeptName="+encodeURI(checkOperUserDeptName) + "&year=" + year + "&_id=" + _id;
         	    var printGuideWindow; 
         	    try{
         	        printGuideWindow = window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no"); 
         	    }catch(e){
         	    	showError("发生错误:\n"+e);
         	    }                  	
            }	
        },{
            el: '.js-addrec',
            event: 'click',
            handler: function () {
            	var year = this.id;
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '个体户纸质补录',
            		area: ['95%', '80%'],
            		maxmin: true, //开启最大化最小化按钮
                    content: '/reg/server/yr/pbaddrec/view?priPID=' + data.priPID+'&year='+year,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })                    	
            }
        },
        {
            el: '.js-see',
            event: 'click',
            handler: function () {
            	var year = this.id;
            	var data = table.row($(this).closest('td')).data();
            	layer.dialog({
                    title: '个体户纸质补录详情',
            		area: ['95%', '80%'],
            		maxmin: true, //开启最大化最小化按钮
                    content: '/reg/server/yr/pbaddrec/view?priPID=' + data.priPID+'&year='+year,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })                    	
            }
        }
       ])
    }

})
