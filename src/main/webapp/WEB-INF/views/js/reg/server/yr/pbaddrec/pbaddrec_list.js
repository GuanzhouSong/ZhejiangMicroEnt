require(['component/iframeLayer', 'layer1','component/dataTable', 'common/util', 'common/http',
         'handlebars', 'jquery','jquery.serialize','laydate','jquery.multiselect'], 
         function (layer,layer1, dataTable, util, http, handlebars) {
    var table;
    var searchFlag = 0 ;
    var regStateList = [];
    init();
    $(".laydate-icon").click(function(){laydate({istime: true, format: 'YYYY-MM-DD'})});//给所有日期选项添加函数
    
    /**
     * 初始化函数集合
     */
    function init() {
        inityear();
//    	initDataTable();
        bind();
        getRegStateList();
    }
    var msg = "";
    var tel = "";
    var year ="";
    var district = "";

    //初始化年份
    function inityear(){
         //自动生成年度
         var _thisYear =  window._CONFIG.year;
         for (; 2016 <= _thisYear; _thisYear--) {
     		$("#year").append("<option value='" + _thisYear + "'>" + _thisYear + "</option>");
         };
         
         $("#regStateM").multipleSelect({
        		selectAllText: '',
        		allSelected: '',
        		selectAll: false,
        		minimumCountSelected: 20
     	});

    }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regStateM option').each(function(){
    		var states = [];
    		states = $(this).val().split(",");
    		for(var i in states){
    			regStateList.push({code: states[i] , text : $(this).text()});
    		};
    	});
    }
    
    function switchRegStateList(val) {
        var flag = "-";
        $.each(regStateList, function(i, n) {
            if (n.code.toUpperCase() == val.toUpperCase()) {
                flag = n.text;
            }
        });
        return flag;
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
                url:'/reg/server/yr/pbaddrec/list.json',
                data:function(d){
                	var regStateM = $("#regStateM").val();
            		d.params = $.extend({}, $("#taskForm").serializeObject(), {"regStateM":regStateM.toString()});               		              		
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
                {data: 'year'},
                {data: 'acceptDate'},
                {data: 'acceptName'},
                {data: 'addRecState'},
                {data: 'addRecDate'},
                {data: 'addRecUser'},
                {data: 'addRecDept',className:"left"},
                {data: 'acceptDept',className:"left"},
                {data: 'regOrgName',className:"left"},
                {data: 'localAdmName',className:"left"},
                {data: 'sliceNOName',className:"left"},
                {data: 'regState'}
            ], 
            columnDefs: [
                         {
                             targets: 1,
                             render: function (data, type, row, meta) {
                               	 if(row.addRecState == '2' ){  //已补录
                              		return '<a class="js-see" id="'+row.year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >修改</a>';
                              	}else{
                              		if(row.regState == 'K' || row.regState == 'B' || row.regState == 'A' ||row.regState == 'DA' || row.regState == 'X'){ //未补录，且企业状态合法
                              			return '<a class="js-addrec" id="'+row.year+'" yrFirRepTime="'+ row.firstReportTime +'" href="javascript:void(0);" >补录</a>';
                              		}else{
                              			return '';
                              		}
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
                         },
                         {
                             targets: 8,
                             render: function (data, type, row, meta) {
                            	 if(row.addRecState == '0'){
                            		 return '未补录';
                            	 }else if(row.addRecState == '1'){
                            		 return '录入中';
                            	 }else if(row.addRecState == '2'){
                            		 return '已补录';
                            	 }else{
                            		 return '';
                            	 }

                             }
                         },
                         {
                        	 targets: 15,
                        	 render: function (data, type, row, meta) {
                        		 if(row.sliceNOName == null){
                        			 return '';
                        		 }else{
                        			 return row.sliceNOName;
                        		 }
                        		 
                        	 }
                         },
                         {
                        	 targets: 16,
                        	 render: function (data, type, row, meta) {
                        		 return switchRegStateList(row.regState);
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
        },{
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
        },
        {
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            	$("#localAdm").val("");
            	$("#sliceNo").val("");
            	$('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
            }
        },{
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
       ])
    }

})
