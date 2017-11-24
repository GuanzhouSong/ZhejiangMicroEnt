require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars','jquery.form', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http,handlebars) {
	
	var regStateList = [];
	var initFlag = true;
	var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	// 配备专家组长
    	inttLeadFlag();
    	// 专业资质资格
    	intRightFlag();
    	initRegState();
    	getRegStateList();
        bind();
    }
    
    function inttLeadFlag(){
    	$("#leadFlag").append("<option value='N'>否</option>");
    	$("#leadFlag").append("<option value='1'>保化组长</option>");
    	$("#leadFlag").append("<option value='2'>药品GSP</option>");
    	$("#leadFlag").append("<option value='3'>药品GMP</option>");
    	$("#leadFlag").append("<option value='4'>医疗器械GSP</option>");
    	$("#leadFlag").append("<option value='5'>医疗器械GMP</option>");
    	$("#leadFlag").multipleSelect({
    		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
    	});
    	$('#leadFlag').multipleSelect('checkAll');
    }
    
    function intRightFlag(){
    	$("#rightFlag").append("<option value='N'>无</option>");
    	$("#rightFlag").append("<option value='1'>保化检查员</option>");
    	$("#rightFlag").append("<option value='2'>药品检查员</option>");
    	$("#rightFlag").append("<option value='3'>医疗器械检查员</option>");
    	$("#rightFlag").append("<option value='4'>特种设备安全监察员</option>");
    	$("#rightFlag").multipleSelect({
    		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
    		minimumCountSelected: 20
    	});
    	$('#rightFlag').multipleSelect('checkAll');
    }
    
    function initRegState(){
       	$("#regStateM").multipleSelect({
       		selectAllText: '全部',
    		allSelected: '全部',
    		selectAllDelimiter: '',
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

    var table;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	initFlag = false;
        table = dataTable.load({
            el: '#user-table',
			showIndex: true,
			scrollX:true,
			"aLengthMenu": [10, 25, 50, 100,1000,2000],
            ajax: {
                url:'/syn/server/drcheck/specialcheck/list.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: '_idx',width:'55px'},
                {data: null,width:'85px'},
                {data: 'specialName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'markName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: null,width:'85px'},
                {data: null,width:'85px'},
                {data: 'entName',width:'120px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: null,width:'85px'},
                {data: 'licName',width:'85px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'licNO',width:'85px'},
                {data: 'licApprDate',width:'85px'},
                {data: 'licSaveEndDate',width:'85px'},
                {data: 'licSendDept',width:'85px'},
                {data: null,width:'85px'},
                {data: null,width:'85px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: null,width:'85px',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'regOrgName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: 'localAdmName',cut: {length: 20,mark:'...'},className: 'left'},
                {data: null,width:'100px'}
            ],
            fnDrawCallback:function(nRow){
            	initScSpecialTotal();
            },
            columnDefs : [ 
							{
								targets : 4,
								render : function(data, type, row, meta) {
									if(row.isScVlid =='1') {
							    		return "有效";
							    	}else if(row.isScVlid =='0'){
							    		return "<span class='light'>无效</span>";
							    	}else{
							    		return "-";
							    	}
								}
							},{
								targets : 5,
								render : function(data, type, row, meta) {
									if(row.uniCode !="" && row.uniCode !=null) {
							    		return row.uniCode;
							    	}else{
							    		return row.regNO;
							    	}
								}
							},{
								targets : 1,
								render : function(data, type, row, meta) {
									return "<a class='commit edit'>修改</a>&nbsp;<a class='commit view'>详情</a>";
								}
							},{
								targets : 13,
								render : function(data, type, row, meta) {
									if(row.superviseFlag =='1') {
							    		return '是';
							    	}else if(row.superviseFlag =='0'){
							    		return '否';
							    	}else{
							    		return '';
							    	}
								}
							},{
								targets : 14,
								render : function(data, type, row, meta) {
									if(row.rightFlag =='N'){
										return "无"
									}else if(row.rightFlag != "" && row.rightFlag != null){
										return rightFlagInfoOpt(row.rightFlag);
									}else{
										return "";
									}
								}
							},{
								targets : 15,
								render : function(data, type, row, meta) {
									if(row.leadFlag =='N'){
										return "无"
									}else if(row.leadFlag != "" && row.leadFlag != null){
										return leadFlagInfoOpt(row.leadFlag);
									}else{
										return "";
									}
								}
							},{
								targets : 7,
								render : function(data, type, row, meta) {
									if("11,13,31,33,12,14,32,34,21,27,24,22,28".indexOf(row.entType) != -1) {
							    		return "企业";
							    	}else if("16,17".indexOf(row.entType)!= -1){
							    		return "农专社";
							    	}else if(row.entType == '50'){
							    		return "个体户";
							    	}else if(row.entType == '23'){
							    		return "外企代表机构";
							    	}else{
							    		return "-";
							    	}
								}
							},{
								targets : 18,
								render : function(data, type, row, meta) {
									return switchRegStateList(row.regState);
								}
				           }]
        })
    }
    
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	//登记状态
		var regStateM = $("#regStateM").val();
		$("#regState").val(regStateM);
    	searchParams = $("#taskForm").serializeObject();
    	var leadFlag = $("#leadFlag").val();
    	var rightFlag = $("#rightFlag").val();
    	var entCatgArry = new Array();
    	$("#taskForm input[name ='entCatg']").each(function(){
    		if($(this).prop("checked")){
    			entCatgArry.push($(this).val());
    		}
    	})
    	searchParams.leadFlag = (leadFlag!=null&&leadFlag!='N,1,2,3,4,5')?leadFlag.toString():'';
    	searchParams.rightFlag = (rightFlag!=null&&rightFlag!='N,1,2,3,4')?rightFlag.toString():'';
    	searchParams.entCatg = entCatgArry.toString();
    	
    	if(initFlag)initDataTable();
        table.ajax.reload();
    }); 
    
    $("#moresearch").click(function(){
    	if($(this).attr("status") == '0'){
    		$(".moresearch_oth").show();
    		$(this).val("收起").attr("status",'1');
    	}else{
    		$(".moresearch_oth").hide();
    		$(this).val("更多查询条件").attr("status",'0');
    	}
    })
    
    // 初始化个数统计
    function initScSpecialTotal(){
        http.httpRequest({
            url: '/syn/server/drcheck/specialcheck/optcount.json',
            serializable: true,
            data: searchParams,
            type: 'post',
            success: function (data) {
                $("#entCount,#markCount,#licCount").html("").text("0");
            	if(data !=null){
            		$("#entCount").text(data[0].count);
            		$("#markCount").text(data[1].count);
            		$("#licCount").text(data[2].count);
            	}
            }
        })
    }
    
    // 专业资质资格
    function rightFlagInfoOpt(obj) {
    	var rightFlag = "";
    	if(obj.indexOf("1") !=-1){rightFlag = "保化检查员";}
    	if(obj.indexOf("2") !=-1){rightFlag = (rightFlag==""?'':rightFlag+',') +"药品检查员";}
    	if(obj.indexOf("3") !=-1){rightFlag = (rightFlag==""?'':rightFlag+',') +"医疗器械检查员";}
    	if(obj.indexOf("4") !=-1){rightFlag = (rightFlag==""?'':rightFlag+',') +"特种设备安全监察员";}
    	return rightFlag;
    }
    
    // 配备专家组
    function leadFlagInfoOpt(obj){
    	var leadFlag = "";
    	if(obj.indexOf("1") !=-1){leadFlag = "保化组长";}
    	if(obj.indexOf("2") !=-1){leadFlag = (leadFlag==""?'':leadFlag+',') +"药品GSP";}
    	if(obj.indexOf("3") !=-1){leadFlag = (leadFlag==""?'':leadFlag+',') +"药品GMP";}
    	if(obj.indexOf("4") !=-1){leadFlag = (leadFlag==""?'':leadFlag+',') +"医疗器械GSP";}
    	if(obj.indexOf("5") !=-1){leadFlag = (leadFlag==""?'':leadFlag+',') +"医疗器械GMP";}
    	return leadFlag;
    }

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
            	window.location.href = '/syn/server/drcheck/specialcheck/addview';
            }
        },{
            el: '.edit',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['63%', '90%'],
                    content: '/syn/server/drcheck/specialcheck/addOrEditView?priPID='+data.priPID+'&uid='+data.uid+'&viewFlag=1',
                    callback: function (data) {
                        if (data.reload) {
                        	table.ajax.reload();
                        }
                    }
                })
             }
        },{
            el: '.view',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
                layer.dialog({
                	area: ['63%', '83%'],
                    content: '/syn/server/drcheck/specialcheck/addOrEditView?priPID='+data.priPID+'&uid='+data.uid+'&viewFlag=2',
                    callback: function (data) {
                        if (data.reload) {
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
                    content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
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
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
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
            el: '#choseSpecial',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择专项库',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/scSpecialSelect?isPermissionCheck=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!="" && returncode!='undifine'){
                    		returncode=returncode.substr(0,returncode.length-1); 
                    		$("#specialCode").val(returncode);
                        	$("#specialName").val(data.returnname);  
                    	}
                    }
                })
            }
        },{
            el: '#choseMark',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择监管标签',
                    area: ['400px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/markTreeView?isMarkFlag=true',
                    callback: function (data) { 
                    	var returncode=data.returncode;
                    	if(returncode!=null&&returncode!=""){
                    		returncode=returncode.substr(0,returncode.length-1);
                    		$("#markCode").val(returncode);
                        	$("#markName").val(data.returnname);  
                    	}
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
            el: '#qzcodetree',
            event: 'click',
            handler: function () { 
            	layer.dialog({
                    title: '选择许可证',
                    area: ['500px', '600px'],
                    content: '/syn/server/drcheck/specialcheck/licenseListCheckboxTreePage',
                    callback: function (data) { 
                    	if(typeof data.reload.code=="undefined"){
                    		$("#qzCode").val("");
                         	$("#qzName").val("");
                    	}else{
                    		 var content = data.reload.content;
                    		 if(content != "" && content!=null){
                    			var nameArry = content.split(',');
                    			var licStr="";
                    			for(var i=0;i<nameArry.length;i++){
                    				var strArry = nameArry[i].split('-');
                    				licStr += strArry[1]+',';
                    			}
                    			$("#qzName").val(licStr.substring(0, licStr.length-1));
                    		 }
                    	} 
                    }
                })
            }
        },{
          el: '.js-import', 
          event: 'click',
          handler: function () {
                  var _file = $("#js-file").val(); 
                  if (!_file) {
                      layer.msg("请上传Excel模板文件!", {icon: 7, time: 3000});
                      return;
                  } else {
                	  //判断是否是Excel文件
                      var ext = _file.toLowerCase().substr(_file.lastIndexOf("."));
                      if (!(ext == ".xls" || ext == ".xlsx" || ext == ".xlsm")) {
                          layer.msg("请选择Excel模板文件!", {icon: 7, time: 3000});
                          return;
                      }
                  }
                  var index;
                  index = layer.msg('导入中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                  $("#file_import").ajaxSubmit({
                      type: 'post',
                      url: '/syn/server/drcheck/specialcheck/addbatch',
                      data: $("#file_import").serialize(),
                      dataType: 'json',
                      cache: false,
                      success: function (data) {
                          if (data.status == 'success') {
                        	  if(data.errorInfo == "" || data.errorInfo == null){
                        		  layer.msg("导入成功", {time: 1500}, function () {
                                	  $("#js-file").val("");
                                	  $("#loadFile").hide();
                                      $("#search").click();
                                  });
                        	  }else{  
                    		      var returnInfo = data.errorInfo.split("，");
                    		      var errorInfo = "";
                    		      for(var i=0;i<returnInfo.length;i++){
                    		    	  errorInfo = errorInfo +(i+1)+'.'+returnInfo[i]+'</br>'
                    		      }
                    		      layer.alert("一共有"+returnInfo.length+"条数据导入失败，详细信息：</br><span style='color:red'>"+errorInfo+"</span>&nbsp;");
                            	  $("#js-file").val("");
                            	  $("#loadFile").hide();
                        	  }
                          }else{
                        	  layer.msg("导入失败", {time: 1000}, function () {});
                          }
                          layer.close(index);
                      }
                  });
	           }
	      },{
              el: '#cancel',
              event: 'click',
              handler: function () { 
            	  $("#regOrg").val("");
            	  $("#localAdm").val("");
            	  $("#sliceNO").val("");
            	  $("#specialCode").val("");
            	  $("#qzName").val("");
            	  $("#markCode").val("");
            	  $('#leadFlag').multipleSelect('checkAll');
            	  $('#rightFlag').multipleSelect('checkAll');
            	  $("#regState").val("");
              	  $('#regStateM').multipleSelect('setSelects',[$('#regStateM option[title="CUNXU"]').val()]);
               }
	      },{
	      	  el:"#importExcel",
	    	  event:'click',
	    	  handler:function(){ 
	    		  $("#loadFile").show();
	    	  }
	      },{
	      	  el:".btnCancel",
	      	  event:'click',
	      	  handler:function(){
	      		  $("#loadFile").hide();
	      	  }
	      }])
    }

})
