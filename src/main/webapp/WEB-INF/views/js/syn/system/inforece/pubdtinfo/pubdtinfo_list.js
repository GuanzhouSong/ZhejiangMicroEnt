require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {
	
	var searchParams = $("#taskForm").serializeObject();//查询参数声明!
    var table;
    
    init();
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
            selectExport:true,
            showIndex: true,
            scrollX: true, //支持滚动
            async: false,
            ajax: {
                url: '/syn/inforece/pubdtinfoforrece/pubdtinfolist.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            columns: [
                {data: null, defaultContent: 1, width: '20px', className: 'center'},
                {data: null, defaultContent: 1, width: '20px', className: 'center'},
                {data: 'entName', width: '20px', cut: {length: 20, mark: '...'}},
                {data: 'uniSCID', width: '20px'},
                {data: 'regNO', width: '20px'},
                {data: 'opScope', width: '200px', cut: {length: 20, mark: '...'}},
                {data: 'dom', width: '20px', cut: {length: 20, mark: '...'}},
                {data: 'estDate', width: '20px'},
                {data: 'regOrgName', width: '20px', cut: {length: 20, mark: '...'}},
                {data: null, defaultContent: 1, width: '5%', className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return "<input type='checkbox' class='chb' >";
                    }
                },
                {
                    targets: 9,
                    render: function (data, type, row, meta) {
                    	if(row.downState=='1')
                    		return "已下载";
                    	else
                            return "<a class='down'>未下载</a>";
                    }
                }
            ],
            "drawCallback": function( settings ) {
            	$('.chbAll').attr("checked", false);
                count_downinfo(searchParams);
            }

        })
    }

    //表格之外的查询按钮事件
    $("#search").click(function () {
        searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    });

    //draw事件，统计下载信息
    function count_downinfo(searchParams) {
        var total=0;var downed=0;var nondown=0;
        var tinfo = $('#user-table_info').html();
        total=$.trim(tinfo.substring(tinfo.indexOf('共')+1,tinfo.lastIndexOf('项'))).replace(/,/g,'');
        http.httpRequest({
            url: '/syn/inforece/pubdtinfoforrece/downlist',
            serializable: true,
            data: searchParams,
            type: 'post',
            success: function (data) {
                downed=data.length;
                nondown=total-downed;
                var info = '共 '+total+' 条，已下载 '+downed+' 条，未下载 '+nondown+' 条';
                $('#downinfo').html(info);
            }
        });

    }
    function down(priPID,id){
    	http.httpRequest({
            url: '/syn/infomange/inforecestat/save',
            serializable: false,
            data: {'priPID':priPID,'type':'1','id':id},
            type: 'post',
            success: function (data) {
                layer.msg(data.msg, {time: 1000}, function () {
                	if(data.status=='success'){
                		table.ajax.reload();
                	}
                });
            }
        });
    }
    
    
    $('.js-batchdownload').click(function(){
    	var priArr="";
    	var idArr="";
      	 $('.chb').each(function(){ 
      		var data = table.row($(this).closest('td')).data();
          	 if($(this).is(':checked')){
          		    if(data.downState != '1'){
          		    	priArr = priArr +data.priPID+',';
              		    idArr = idArr +data.id+',';
          		    }
      		 }
   		 });
      	 if(idArr==''){
      		 layer.msg("操作失败！");return;
      	 }
      	 down(priArr.substring(0,priArr.length-1),idArr.substring(0,idArr.length-1));
      });
    function bind() {
        util.bindEvents([{
            el: '#user-table tr',
            event: 'click',
            handler: function (e) {
                var target = e.target || e.srcElement;
                if ($(target).closest('td').index() == 1)return;
                if ($(target).closest('td').index() == 9)return;
                var data = table.row($(this)).data();
                layer.dialog({
                    title: '照面信息',
                    area: ['65%', '65%'],
                    content: '/syn/anonpunish/anonpunish/toedit?pripid=' + data.priPID,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },
            {
                el: '#reset', //重置
                event: 'click',
                handler: function () {
                    $('.clx').val('');//重置隐藏域
                }
            }, {
                el: '.down', //下载
                event: 'click',
                handler: function () {
                	var data = table.row($(this).closest('td')).data();
                	down(data.priPID,data.id);
                	table.row($(this).closest('td')).select();
                	$('.buttons-excel ').trigger('click');
                }
            },{
                el: '.js-export',
                event: 'click',
                handler: function(){
                	$('.buttons-excel ').trigger('click'); 
                }
            },{
            	el:'.chbAll',
            	event:'click',
            	handler:function(){
            		var check = $(this).prop('checked');
            	      $('.chb').prop('checked', check);
            	      if(check){
                          table.rows( 'tr' ).select();
                      }else{
                          table.rows( 'tr' ).deselect();
                      }
            	}
            }
        ])
    }

})
