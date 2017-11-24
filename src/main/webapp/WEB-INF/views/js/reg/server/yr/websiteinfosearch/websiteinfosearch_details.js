require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
  
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
    	var  table = dataTable.load({
            el: '#webTable',
            showIndex: true,
            ajax: {
            	url:'/reg/server/yr/websiteinfo/details/list.json',
            	data:function(d){
	                d.params = {"year":$("#year_list").val(),"priPID":$("#priPID").val(),"systemType":$("#systemType").val()};
                }
            },
            columns: [
                {data: null, width: '5%', className: 'center'},
                {
                    data: 'webType',//类型
                    width: '20px'
                }, {
                    data: 'webSmallType',//网站类型/网店所属平台
                    width: '20px'
                }, {
                    data: 'webSitName',//网站网店名称
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'webSite',//网址（域名）
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'icpBackNO',//ICP备案号
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'weChatPublicNO',//微信公众号
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'appNames',//手机APP服务
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'sendAddress',//发货地址
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'backAddress',//退货地址
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'webPlatFormType',//网络交易平台运营类型
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'webGoodsType',//网络交易产品类型
                    width: '20px',
                    'className': 'left'
                }, {
                    data: 'ecommerceType',//电商类型
                    width: '20px',
                    'className': 'left'
                }
            ],
            columnDefs : [{
			                    targets: 1,
			                    render: function(data, type, row, meta) {
			                        if (data == '1') {
			                            return "网站";
			                        } else if (data == '2') {
			                            return "网店";
			                        } else {
			                            return "";
			                        }
			                    }
			                },{
			                    targets: 2,
			                    render: function(data, type, row, meta) {
			                    	if (row.webType == '1') {
			                    		if (data == '1') {
			                                return "交易网站";
			                            } else if (data == '2') {
			                                return "信息网站";
			                            } else {
			                                return "";
			                            }
			                        } else if (row.webType == '2') {
			                            return row.belongPlatFormName;
			                        } else {
			                            return "";
			                        }
			                    }
			                }
				          ]
                });
    }
    

    function bind() {
        util.bindEvents([{
            el: '.js-fold',
            event: 'click',
            handler: function () {
                if ($(this).hasClass('reverse')) {
                    $(this).html('收起详情<i></i>');
                    $(this).removeClass("reverse");
                    $(this).addClass("more");
                    $(".js-table-horizontal").show();
                } else {
                    $(this).html('展开详情<i></i>');
                    $(this).addClass("reverse");
                    $(this).addClass("more");
                    $(".js-table-horizontal").hide();
                }
            }
        },{
            el: '#year_list',   //重新选择年份加载数据
            event: 'change',
            handler: function () {
            	var yearValue = $("#year_list").val();
                if(!yearValue){return;};
                //禁用select 选择
                $("#year_list").prop("disabled",true);
                layer.msg("页面加载数据需要点时间,请您耐心等待!", {icon: 6,time: 3000});
                var url ='/reg/server/yr/websiteinfo/details?year=' + yearValue+'&priPID='+$("#priPID").val();
                window.location.href=url;
            }
        },{
            el: '.dy-report-bg',  //打印年报年度报告
            event: 'click',
            handler: function () {
                //获取选中的年份：
                var yearValue = $("#year_list").val();
                $('.js-year').each(function(){
                    if($(this).val()==yearValue){
                        layer.msg("打印年度报告加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
                        var year = $(this).data('year');
                        var pripid= $("#js-pripid").val();
                        var url = $('.js-reprot-year').val();
                        url = url+"?year="+year+"&priPID="+pripid+"&printFalg=2";
                        window.open(url);
                    }
                });
            }
        }, {
            el: '.dy-reprot-zm', //打印年度报告证明
            event: 'click',
            handler: function () {
                //获取选中的年份：
                var yearValue = $("#year_list").val();
                $('.js-year').each(function(){
                    if($(this).val()==yearValue){
                        layer.msg("打印年度报告加载数据需要点时间,请您耐心等待!", {icon: 6,time: 4000});
                        var year = $(this).data('year');
                        var pripid= $("#js-pripid").val();
                        var url = $('.js-reprot-zm').val();
                        url = url+"?year="+year+"&priPID="+pripid;
                        window.open(url);
                    }
                });
            }
        }
       ]);
    }

})
