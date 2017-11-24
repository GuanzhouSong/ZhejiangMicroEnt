require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }
    var i = 0;
    //加索引,使索引从第二列开始
    table.on('draw.dt', function () {
        table.column(1, {
            search: 'applied',
            order: 'applied'
        }).nodes().each(function (cell, i) {
            i = i + 1;
            var page = table.page.info();
            var pageno = page.page;
            var length = page.length;
            var columnIndex = (i + pageno * length);
            cell.innerHTML = columnIndex;
        });
    })


    var searchParams={};
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#deptNameTable',
            scrollX:true,
            ajax: {
                url:'/reg/server/yr/departname/list.json',
                data:function(d){
	               	d.params = searchParams;
                }
            },
            columns: [
                {data: null,width:'50px','defaultContent': '111'},   
                {data: null,width:'50px','defaultContent': '111'},
                {data: 'deptCode',width:'100px',className: 'center'},
                {data: 'deptName',width:'120px',className: 'center'},
                {data: 'deptShortName',width:'100px',className: 'center'},
                {data: 'docShortName',width:'80px',className: 'center'},
                {data: 'sameGov',width:'100px',className: 'center'},
                {data: 'sameCourt',width:'100px',className: 'center'},
                {data: 'setName',width:'80px',className: 'center'},
                {data: 'setTime',width:'80px',className: 'center'}
            ],
            columnDefs: [
                          {
	             	         targets:0,
	             	         render:function(data,type,row,meta){
	             		     return  '<input type="radio" class="radioClass" name="_checkresult"  value='+row.deptDID+'>';
	             	       }
	                  }
              ]
        })
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#searchForm").serializeObject();
        table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([{
            el: '.js-edit',
            event: 'click',
            handler: function () {
            	var checkFlag = false;
            	var deptDID;
            	$(".radioClass").each(function(){
            		if($(this).prop("checked")){
            			checkFlag = true;
            			deptDID = $(this).val();
            		}
            	})
            	if(checkFlag){
	                layer.dialog({
	                    title: '修改',
	                    area: ['60%', '50%'],
	                    content: '/reg/server/yr/departname/view?deptDID='+deptDID,
	                    callback: function (data) {
	                        if (data.reload) {
	                            table.ajax.reload();
	                        }
	                    }
	                })
                }else{
                	alert("请先选择一条记录！");
                	return false;
                }
            }
        },{
            el: '#choseorgReg',
            event: 'click',
            handler: function () { 
                layer.dialog({
                    title: '选择登记机关',
                    area: ['400px', '600px'],
                    content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck='+true,
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
            el: '#cancel',
            event: 'click',
            handler: function () { 
            	$("#regOrg").val("");
            }
        }])
    }

})
