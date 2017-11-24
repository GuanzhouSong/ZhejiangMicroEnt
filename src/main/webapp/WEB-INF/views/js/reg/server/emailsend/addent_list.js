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
                url:'/syn/panoramasearch/emailQueryPage',
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
                      {data: 'email',width:'80px'},
                      {data: 'regOrgName',width:'180px',className: 'left'},
                      {data: 'localAdmName',width:'180px',className: 'left'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
 						return "<input value='" + row.priPID+"_"+row.uniscid+"_"+row.sliceNOName+"_"+row.entName+"_"+row.estDate+"_"+row.regOrgName+"_"+row.localAdmName+"_"+row.regNO+"_"+row.entTypeCatg + "_"+row.email + "' name = 'checkboxlist' class='chb checkbox' type='checkbox' />";
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
    
    $("#selectAll").click(function(){
		searchParams = $("#taskForm").serializeObject();
		$("#map").val(JSON.stringify(searchParams));
		document.form2.submit();
    });
    
    function bind() {
        util.bindEvents([
        	{
                el: '#return',
                event: 'click',
                handler: function () {
                	window.location.href='/reg/server/emailtask/emailtasklist';
                }
            },
            {
            	  el: '#checkAll',  //全选
                  event: 'click',
                  handler: function () {
                  	var allChecked= $("#checkAll").prop("checked");   
                  	$(".chb").prop("checked", allChecked);
                  }
            }, {
        	el: '#emailSend',
            event: 'click',
            handler: function () { 
            	 var objs="";
                 $(":checkbox[name=checkboxlist]:checked").each(function(k,v){
                	 objs=objs + this.value+"。"; 
                 });
                 objs = objs.substring(0,objs.length-1);
                 if(objs[0]==""||objs[0]==null){
                     layer.msg("请您<em style='color: red;'>【至少选择一家】</em>企业!", {icon: 7,time: 1000});
                 }else{
                	 $("#params").val(objs);
                	 document.form1.submit();
                 }
            }
        }])
    }

})
