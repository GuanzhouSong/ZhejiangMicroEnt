require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize','laydate','jquery.multiselect'], function (layer, dataTable, util, http) {
	var regStateList = [];
	var searchFlag1="0";
	var searchFlag2="0";
	var searchFlag3="0";
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
        getRegStateList();
    }
    
    //获取登记状态
    function getRegStateList() {
    	$('#regState option').each(function(){
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

    $("#zeroAppItemM1").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
    $("#zeroAppItemM2").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});
    $("#zeroAppItemM3").multipleSelect({
		selectAllText: '全部',
		allSelected: '全部',
		selectAllDelimiter: '',
		minimumCountSelected: 10
	});

    var table1;
    var table2;
    var table3;

    function initDataTable1() {
    	searchFlag1="1";
        table1 = dataTable.load({
            el: '#user-table-1',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/yr/yrassetinfo/entlist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
                      {data: "_idx",width:'60px'},
                      {data: 'regNO'},
                      {data: 'entName',className: 'left'},
                      {data: 'leRep'},
                      {data: 'estDate'},
                      {data: 'regCap'},
                      {data: 'currencyCN'},
                      {data: 'isIndivid'},
                      {data: 'year'},
                      {data: 'ancheDate'},
                      {data: 'assGro'},
                      {data: 'liaGro'},
                      {data: 'totEqu'},
                      {data: 'vendInc'},
                      {data: 'maiBusInc'},
                      {data: 'proGro'},
                      {data: 'netInc'},
                      {data: 'ratGro'},
                      {data: 'empNum'},
                      {data: 'femaleEmploye'},
                      {data: 'entControl'},
                      {data: 'busSt'},
                      {data : 'regOrgName',className: 'left'}, 
                      {data : 'localAdmName',className: 'left'}, 
                      {data : 'sliceNOName',className: 'left'}, 
                      {data : 'regState'}
                      ],
					columnDefs : [ {
						targets : 7,
						render : function(data, type, row, meta) {
							if (row.isIndivid=='1') {
								return "是";
							} else {
								return "否";
							}
						}
					},{
						targets : 1,
						render : function(data, type, row, meta) {
							if (row.uniCode) {
								return row.uniCode;
							} else {
								return row.regNO;
							}
						}
					}, {
						targets : 20,
						render : function(data, type, row, meta) {
							if (row.entControl == '1') {
								return "国有控股";
							} else if (row.entControl == '2') {
								return "集体控股";
							} else if (row.entControl == '3') {
								return "私人控股";
							} else if (row.entControl == '4') {
								return "港澳台商控股";
							} else if (row.entControl == '5') {
								return "外商控股";
							} else if (row.entControl == '6') {
								return "其他";
							} else if (row.entControl == '7') {
								return "私营企业";
							} else {
								return "-";
							}
						}
					}, {
						targets : 21,
						render : function(data, type, row, meta) {
							if (row.busSt == '1') {
								return "开业";
							} else if (row.busSt == '2') {
								return "筹建";
							} else if (row.busSt == '3') {
								return "停业";
							} else if (row.busSt == '4') {
								return "歇业";
							} else if (row.busSt == '5') {
								return "清算";
							} else if (row.busSt == '9') {
								return "其他";
							} else {
								return "-";
							}
						}
					}, {
						targets : 25,
						render : function(data, type, row, meta) {
							return switchRegStateList(row.regState);
						}
					} ],
            "footerCallback": function ( row, data, start, end, display ) {
                //合计项在表格索引
                var dataArr=[10,11,12,13,14,15,16,17,18,19];
                var api = this.api(); 
                if(data!=null&&data.length!=0){
                    for(var c=0;c<dataArr.length;c++){ 
                    	var intVal = function ( i ) {
                           return typeof i === 'string' ?
                               i.replace(/[\$,]/g, '')*1 :
                               typeof i === 'number' ?
                                   i : 0;
                       };
                       var total = api.column(dataArr[c]).data().reduce(function (a, b) {
                           return intVal(a) + intVal(b);
                       });
                       if(dataArr[c]==18||dataArr[c]==19){
                    	   $(api.column( dataArr[c] ).footer() ).html(total); 
                       }else{
                    	   if(total!=null){
                    		   $(api.column( dataArr[c] ).footer() ).html(total.toFixed(2)); 
                    	   }else{
                    		   $(api.column( dataArr[c] ).footer() ).html(total);
                    	   }
                       }
                   }
                }else{
                	for(var c=10;c<20;c++){ 
                		$( api.column(c).footer() ).html("0");
                	}
                }
            } 
//            	,
//		             "fnDrawCallback": function (oSettings) {
//		             	http.httpRequest({ 
//		                     url: '/reg/server/yr/yrassetinfo/entlistCount',
//		                     serializable: false,
//		                     type:'post',
//		                     data: {params:searchParams} ,
//		                     success: function (data) {
//		                     	 var list = data.data;
//		                         if (data.status == 'success') {  
//		     						$("#assGroEnt").text(list[0]);
//		     						$("#liaGroEnt").text(list[1]);
//		     						$("#totEquEnt").text(list[2]);
//		     						$("#vendIncEnt").text(list[3]);
//		     						$("#maiBusIncEnt").text(list[4]);
//		     						$("#proGroEnt").text(list[5]);
//		     						$("#netIncEnt").text(list[6]);
//		     						$("#ratGroEnt").text(list[7]);
//		     						$("#empNumEnt").text(list[8]);
//		     						$("#femaleEmployeEnt").text(list[9]);
//		                         }else{
//		                        	$("#assGroEnt").text(0);
//		     						$("#liaGroEnt").text(0);
//		     						$("#totEquEnt").text(0);
//		     						$("#vendIncEnt").text(0);
//		     						$("#maiBusIncEnt").text(0);
//		     						$("#proGroEnt").text(0);
//		     						$("#netIncEnt").text(0);
//		     						$("#ratGroEnt").text(0);
//		     						$("#empNumEnt").text(0);
//		     						$("#femaleEmployeEnt").text(0);
//		                         } 
//		                     }
//		             	})
//		              }
				})
			}
			function initDataTable2() {
				searchFlag2 = "1";
				table2 = dataTable.load({
					el : '#user-table-2',
					showIndex : true,
					aLengthMenu : [ 10, 25, 50, 100, 1000, 2000 ],
					scrollX : true, //支持滚动
					bScrollInfinite : true,
					ajax : {
						type : "POST",
						url : '/reg/server/yr/yrassetinfo/sfclist.json',
						data : function(d) {
							d.params = searchParams;
						}
					},
					columns : [
						  {data: "_idx"},
	                      {data: 'regNO'},
	                      {data: 'entName',className: 'left'},
	                      {data: 'leRep'},
	                      {data: 'estDate'},
	                      {data: 'regCap'},
	                      {data: 'year'},
	                      {data: 'lastReportTime'},
	                      {data: 'vendInc'},
	                      {data: 'priYeaProfit'},
	                      {data: 'ratGro'},
	                      {data: 'priYeaSub'},
	                      {data: 'priYeaLoan'},
	                      {data: 'empNum'},
	                      {data: 'femaleEmploye'},
	                      {data : 'regOrgName',className: 'left'}, 
	                      {data : 'localAdmName',className: 'left'}, 
	                      {data : 'sliceNOName',className: 'left'}, 
	                      {data : 'regState'}
					],
					columnDefs : [ 
						{
							targets : 1,
							render : function(data, type, row, meta) {
								if (row.uniCode) {
									return row.uniCode;
								} else {
									return row.regNO;
								}
							}
						}, {
							targets : 18,
							render : function(data, type, row, meta) {
								return switchRegStateList(row.regState);
							}
						} 
					],
					"footerCallback": function ( row, data, start, end, display ) {
		                //合计项在表格索引
		                var dataArr=[8,9,10,11,12,13,14];
		                var api = this.api(); 
		                if(data!=null&&data.length!=0){
		                    for(var c=0;c<dataArr.length;c++){ 
		                    	var intVal = function ( i ) {
		                           return typeof i === 'string' ?
		                               i.replace(/[\$,]/g, '')*1 :
		                               typeof i === 'number' ?
		                                   i : 0;
		                       };
		                       var total = api.column(dataArr[c]).data().reduce(function (a, b) {
		                           return intVal(a) + intVal(b);
		                       });
		                       if(dataArr[c]==13||dataArr[c]==14){
		                    	   $(api.column( dataArr[c] ).footer() ).html(total); 
		                       }else{
		                    	   if(total!=null){
		                    		   $(api.column( dataArr[c] ).footer() ).html(total.toFixed(2)); 
		                    	   }else{
		                    		   $(api.column( dataArr[c] ).footer() ).html(total);
		                    	   }
		                       }
		                   }
		                }else{
		                	for(var c=8;c<15;c++){ 
		                		$( api.column(c).footer() ).html("0");
		                	}
		                }
		            } 
//					,
//		             "fnDrawCallback": function (oSettings) {
//		             	http.httpRequest({ 
//		                     url: '/reg/server/yr/yrassetinfo/sfclistCount',
//		                     serializable: false,
//		                     type:'post',
//		                     data: {params:searchParams} ,
//		                     success: function (data) {
//		                     	 var list = data.data;
//		                         if (data.status == 'success') {  
//		     						$("#sfcVendInc").text(list[0]);
//		     						$("#sfcPriYeaProfit").text(list[1]);
//		     						$("#sfcRatGro").text(list[2]);
//		     						$("#sfcPriYeaSub").text(list[3]);
//		     						$("#sfcPriYeaLoan").text(list[4]);
//		     						$("#sfcEmpNum").text(list[5]);
//		     						$("#sfcFemaleEmploye").text(list[6]);
//		                         }else{
//		                        	$("#sfcVendInc").text(0);
//		     						$("#sfcPriYeaProfit").text(0);
//		     						$("#sfcRatGro").text(0);
//		     						$("#sfcPriYeaSub").text(0);
//		     						$("#sfcPriYeaLoan").text(0);
//		     						$("#sfcEmpNum").text(0);
//		     						$("#sfcFemaleEmploye").text(0);
//		                         } 
//		                     }
//		             	})
//			           }
				})
			}
			function initDataTable3() {
				searchFlag3 = "1";
				table3 = dataTable.load({
					el : '#user-table-3',
					showIndex : true,
					aLengthMenu : [ 10, 25, 50, 100, 1000, 2000 ],
					scrollX : true, //支持滚动
					bScrollInfinite : true,
					ajax : {
						type : "POST",
						url : '/reg/server/yr/yrassetinfo/pblist.json',
						data : function(d) {
							d.params = searchParams;
						}
					},
					columns : [
						  {data: "_idx"},
	                      {data: 'regNO'},
	                      {data: 'entName',className: 'left'},
	                      {data: 'leRep'},
	                      {data: 'estDate'},
	                      {data: 'year'},
	                      {data: 'ancheDate'},
	                      {data: 'vendInc'},
	                      {data: 'ratGro'},
	                      {data: 'empNum'},
	                      {data : 'regOrgName',className: 'left'}, 
	                      {data : 'localAdmName',className: 'left'}, 
	                      {data : 'sliceNOName',className: 'left'}, 
	                      {data : 'regState'}
	                ],
					columnDefs : [ 
						{
							targets : 1,
							render : function(data, type, row, meta) {
								if (row.uniCode) {
									return row.uniCode;
								} else {
									return row.regNO;
								}
							}
						}, {
							targets : 13,
							render : function(data, type, row, meta) {
								return switchRegStateList(row.regState);
							}
						} 
					],
					"footerCallback": function ( row, data, start, end, display ) {
		                //合计项在表格索引
		                var dataArr=[7,8,9];
		                var api = this.api(); 
		                if(data!=null&&data.length!=0){
		                    for(var c=0;c<dataArr.length;c++){ 
		                    	var intVal = function ( i ) {
		                           return typeof i === 'string' ?
		                               i.replace(/[\$,]/g, '')*1 :
		                               typeof i === 'number' ?
		                                   i : 0;
		                       };
		                       var total = api.column(dataArr[c]).data().reduce(function (a, b) {
		                           return intVal(a) + intVal(b);
		                       });
		                       if(dataArr[c]==9){
		                    	   $(api.column( dataArr[c] ).footer() ).html(total); 
		                       }else{
		                    	   if(total!=null){
		                    		   $(api.column( dataArr[c] ).footer() ).html(total.toFixed(2)); 
		                    	   }else{
		                    		   $(api.column( dataArr[c] ).footer() ).html(total);
		                    	   }
		                       }
		                   }
		                }else{
		                	for(var c=7;c<10;c++){ 
		                		$( api.column(c).footer() ).html("0");
		                	}
		                }
		            } 
//		             ,"fnDrawCallback": function (oSettings) {
//		             	http.httpRequest({ 
//		                     url: '/reg/server/yr/yrassetinfo/pblistCount',
//		                     serializable: false,
//		                     type:'post',
//		                     data: {params:searchParams} ,
//		                     success: function (data) {
//		                     	 var list = data.data;
//		                         if (data.status == 'success') {  
//		     						$("#pbVendInc").text(list[0]);
//		     						$("#pbRatGro").text(list[1]);
//		     						$("#pbEmpNum").text(list[2]);
//		                         }else{
//		                        	$("#pbVendInc").text(0);
//		     						$("#pbRatGro").text(0);
//		     						$("#pbEmpNum").text(0);
//		                         } 
//		                     }
//		             	})
//		             }
				})
			}

			//表格之外的查询按钮事件
			$("#js-search").click(function() {
				var entTypeCatg = $("input[name='entTypeCatg']:checked").val();
				var regCapStart = $("#regCapStart").val();
				var regCapEnd = $("#regCapEnd").val();
				var empNumStart = $("#empNumStart").val();
				var empNumEnd = $("#empNumEnd").val();
				var r = /^\d+$/;//正整数和0
				if (entTypeCatg == "50") {
					if (isNaN(regCapStart) || isNaN(regCapEnd)) {
						layer.msg("注册资本格式不正确！", {time: 2000}, function() {});
					} else if(empNumStart&&!r.test(empNumStart)){
						layer.msg("从业人数必须为正整数！", {time: 2000}, function() {});
					} else if(empNumEnd&&!r.test(empNumEnd)){
						layer.msg("从业人数必须为正整数！", {time: 2000}, function() {});
					} else {
						var zeroAppItemM3 = $("#zeroAppItemM3").val();
			    		$("#zeroAppItem3").val(zeroAppItemM3);
						searchParams = $("#taskForm").serializeObject();
						if (searchFlag3 == "0") {
							initDataTable3();
						} else {
							table3.ajax.reload();
						}
					}
				} else if (entTypeCatg == "16,17") {
					var zeroAppItemM2 = $("#zeroAppItemM2").val();
		    		$("#zeroAppItem2").val(zeroAppItemM2);
					if (isNaN(regCapStart) || isNaN(regCapEnd)) {
						layer.msg("注册资本格式不正确！", {time: 2000}, function() {});
					} else if(empNumStart&&!r.test(empNumStart)){
						layer.msg("从业人数必须为正整数！", {time: 2000}, function() {});
					} else if(empNumEnd&&!r.test(empNumEnd)){
						layer.msg("从业人数必须为正整数！", {time: 2000}, function() {});
					} else {
						searchParams = $("#taskForm").serializeObject();
						if (searchFlag2 == "0") {
							initDataTable2();
						} else {
							table2.ajax.reload();
						}
					}
				} else {
					var zeroAppItemM1 = $("#zeroAppItemM1").val();
		    		$("#zeroAppItem1").val(zeroAppItemM1);
					if (isNaN(regCapStart) || isNaN(regCapEnd)) {
						layer.msg("注册资本格式不正确！", {time: 2000}, function() {});
					} else if(empNumStart&&!r.test(empNumStart)){
						layer.msg("从业人数必须为正整数！", {time: 2000}, function() {});
					} else if(empNumEnd&&!r.test(empNumEnd)){
						layer.msg("从业人数必须为正整数！", {time: 2000}, function() {});
					} else {
						searchParams = $("#taskForm").serializeObject();
						if (searchFlag1 == "0") {
							initDataTable1();
						} else {
							table1.ajax.reload();
						}
					}
				}
			});

			function bind() {
				util.bindEvents([
				{
					el : '#choseregUnit',
					event : 'click',
					handler : function() {
						layer.dialog({
							title : '选择管辖单位',
							area : [ '400px', '600px' ],
							content : '/commom/server/regunit/regunitmutiselect',
							callback : function(data) {
								var returncode = data.returncode;
								if (returncode != null&& returncode != "") {
									returncode = returncode.substr(0,returncode.length - 1);
								}
								$("#localAdm").val(returncode);
								$("#localAdmName").val(data.returnname);
							}
						})
					}
				},
				{
					el : '#choseorgReg',
					event : 'click',
					handler : function() {
						layer.dialog({
							title : '选择登记机关',
							area : [ '400px', '600px' ],
							content : '/commom/server/regorg/regorgmutiselect',
							callback : function(data) {
								var returncode = data.returncode;
								if (returncode != null&& returncode != "") {
									returncode = returncode.substr(0,returncode.length - 1);
								}
								$("#regOrg").val(returncode);
								$("#regOrgName").val(data.returnname);
							}
						})
					}
				},
				{
					el : '#chooseEntType',
					event : 'click',
					handler : function() {
						var categCode = new Array();
						$(":checkbox[name=entCatg]:checked").each(function(k, v) {
							categCode[k] = this.value;
						});

						layer.dialog({
							title : '选择企业类型',
							area : [ '400px', '600px' ],
							content : '/commom/server/entcatg/entcatgmutiselectCom?type='
									+ categCode,
							callback : function(data) {
								var returncode = data.returncode;
								if (returncode != null&& returncode != "") {
									returncode = returncode.substr(0,returncode.length - 1);
								}
								$("#entType").val(returncode);
								$("#entTypeName").val(data.returnname);
							}
						})
					}
				},
				{
					el : '#choseindustry',
					event : 'click',
					handler : function() {
						layer.dialog({
							title : '选择行业',
							area : [ '400px', '600px' ],
							content : '/commom/server/industry/toIndustryPhyTree',
							callback : function(data) {
								var returncode = data.returncode;
								if (returncode != null&& returncode != "") {
									returncode = returncode.substr(0,returncode.length - 1);
								}
								$("#industryCo").val(returncode);
								$("#industryCoName").val(data.returnname);
							}
						})
					}
				},
				{
					el : '#chooseSliceNo',
					event : 'click',
					handler : function() {
						layer.dialog({
							title : '选择片区',
							area : [ '400px', '600px' ],
							content : '/commom/server/sliceno/slicenomutiselect',
							callback : function(data) {
								var returncode = data.returncode;
								if (returncode != null&& returncode != "") {
									returncode = returncode.substr(0,returncode.length - 1);
								}
								$("#sliceNo").val(returncode);
								$("#sliceNoName").val(data.returnname);
							}
						})
					}
				},
				{
					el : '#ent',
					event : 'click',
					handler : function() {
						$("#zero1").show();
						$("#zero2").hide();
						$("#zero3").hide();
						$("#entControl").prop("disabled",false);
						$("#busSt").prop("disabled",false);
						$("#entlist").show();
						$("#sfclist").hide();
						$("#pblist").hide();
					}
				},
				{
					el : '#slf',
					event : 'click',
					handler : function() {
						$("#zero2").show();
						$("#zero1").hide();
						$("#zero3").hide();
						$("#entControl").prop("disabled",true);
						$("#busSt").prop("disabled",true);
						$("#entlist").hide();
						$("#sfclist").show();
						$("#pblist").hide();
					}
				},
				{
					el : '#pb',
					event : 'click',
					handler : function() {
						$("#zero3").show();
						$("#zero2").hide();
						$("#zero1").hide();
						$("#entControl").prop("disabled",true);
						$("#busSt").prop("disabled",true);
						$("#entlist").hide();
						$("#sfclist").hide();
						$("#pblist").show();
					}
				},
				{
					el : '#cancel',
					event : 'click',
					handler : function() {
						$("#regOrg").val("");
						$("#localAdm").val("");
						$("#checkDep").val("");
						$("#sliceNo").val("");
						$("#entType").val("");
						$("#industryCo").val("");
						$('#zeroAppItemM1').multipleSelect(null);
						$('#zeroAppItemM2').multipleSelect(null);
						$('#zeroAppItemM3').multipleSelect(null);
						$("#entControl").prop("disabled",false);
						$("#busSt").prop("disabled",false);
						$("#entlist").show();
						$("#sfclist").hide();
						$("#pblist").hide();
					}
				},
				{
					el : '#more',
					event : 'click',
					handler : function() {
						var isHideOrShow = $("#hideorshow").is(
								":hidden");
						if (isHideOrShow) {
							$("#more").val("收起");
							$("#hideorshow").css("display","block");
						} else {
							$("#more").val("更多查询条件");
							$("#hideorshow").css("display","none");
						}
					}
				} ])
			}

		})
