require(['layer1', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.validate', 'jquery.serialize', 'laydate', 'pagination'],
    function (layer, dataTable, util, http, handlebars) {

        init();
        /**
         * 初始化函数集合
         */

        function init() {
            var entTypeCatg = $("#entTypeCatg").val();
            //个体户，农专无即时信息
            if (entTypeCatg != 50 && entTypeCatg != 16 && entTypeCatg != 17) {
                var imReportType = window._CONFIG.repType;//修改获取 lijixiang

                if (imReportType.indexOf("investment") != -1) {
                    initDataInvestmentTable(0);
                }
                if (imReportType.indexOf("invsralt") != -1) {
                    initDataInvsraTable(0);
                }

                initPermitTable(0);

                initIppldgTable(0);

                initCaseTable(0);
            }
            bind();
        }


        function transDte(value) {
            var date = value.split("-");
            return date[0] + "年" + date[1] + "月" + date[2] + "日";
        }

        //初始化股东投资信息
        function initDataInvestmentTable(page) {
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            http.httpRequest({
                url: '/im/pub/investalter/investmentListJSON',
                serializable: false,
                data: {
                    "pageNum": page,
                    "priPID": $("#priPID").val(),
                    length: length,
                    params: {"pageNum": page}
                },
                success: function (data) {

                    if (data.data == "" || data.data == null) {//如果没有
                        $('#tplPage').html("<td valign='top' colspan='8' class='dataTables_empty'>没有匹配结果</td>");
                        return false;
                    }

                    if (page == 0) {
                        page = page;
                    } else {
                        page = page - 1;
                    }

                    var showPage = data.recordsTotal;
                    $('#pageinvestment').pagination(showPage, {//分页工具
                        callback: pageInvesMentCallback,
                        items_per_page: 5,
                        prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,
                        num_edge_entries: 2,
                        current_page: page,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页'
                    });

                    $("#investmentCount").text(data.recordsTotal);
                    var totalPages = Math.ceil(data.recordsTotal / 5);
                    $("#investmentPageCount").text(totalPages);

                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) {
                            //返回+1之后的结果
                            if (page >= 0) {
                                var toIn = ((page) * 5);

                                return index + 1 + toIn;
                            } else {
                                return index + 1;
                            }
                        });
                    handlebars.registerHelper("trsPubFlag",
                        function (value) {
                            if (value == "1") {
                                return "公示";
                            } else {
                                return "未公示";
                            }
                        });

                    //打印页面手动拼接表格--------------------------------------------------------------
                    if (window._CONFIG.pageType == 'print') {
                        var data = data.data
                        var t_html = '';
                        //循环data
                        var tr_size=1;
                        for (var i = 0; i < data.length; i++) {
                            var detail_size = data[i].imInvprodetailList.length > data[i].imInvactdetailList.length ?
                                data[i].imInvprodetailList.length : data[i].imInvactdetailList.length;
                            if(detail_size>0){
                                tr_size=detail_size;
                            }
                            //按照实缴认缴明细\总的值最大值拼接td
                            for (var d = 0; d < tr_size; d++) {
                                var liSubConAm = data[i].liSubConAm == null ? '' : data[i].liSubConAm;
                                var liAcConAm = data[i].liAcConAm == null ? '' : data[i].liAcConAm;
                                t_html += '<tr>';
                                //跨行的前3列，只拼接一遍
                                if (d == 0) {
                                    t_html += '<td rowspan="' + tr_size + '">' + data[i].inv + '</td>'
                                        + '<td rowspan="' + tr_size + '">' + liSubConAm + '</td>'
                                        + '<td rowspan="' + tr_size + '">' + liAcConAm + '</td>';
                                }
                                //认缴金额
                                if (d < data[i].imInvprodetailList.length) {
                                    var invp = data[i].imInvprodetailList;
                                    var conDate = invp[d].conDate.split("-");
                                    conDate = conDate[0] + "年" + conDate[1] + "月" + conDate[2] + "日";
                                    var publicDate = invp[d].publicDate.split("-");
                                    publicDate = publicDate[0] + "年" + publicDate[1] + "月" + publicDate[2] + "日";
                                    t_html +=
                                        '<td valign="top">' + invp[d].conFormCN + '</td>'
                                        + '<td valign="top">' + invp[d].subConAm + '</td>'
                                        + '<td valign="top">' + conDate + '</td>'
                                        + '<td valign="top">' + publicDate + '</td>'
                                }else{
                                    t_html +=
                                        '<td valign="top"> </td>'
                                        +'<td valign="top">  </td>'
                                        +'<td valign="top"> </td>'
                                        +'<td valign="top"></td>'
                                }
                                //实缴金额
                                if (d < data[i].imInvactdetailList.length) {
                                    var inva = data[i].imInvactdetailList;
                                    var conDate = inva[d].conDate.split("-");
                                    conDate = conDate[0] + "年" + conDate[1] + "月" + conDate[2] + "日";
                                    var publicDate = inva[d].publicDate.split("-");
                                    publicDate = publicDate[0] + "年" + publicDate[1] + "月" + publicDate[2] + "日";
                                    t_html +=
                                        '<td valign="top">' + inva[d].acConFormCn + '</td>'
                                        + '<td valign="top">' + inva[d].acConAm + '</td>'
                                        + '<td valign="top">' + conDate + '</td>'
                                        + '<td valign="top">' + publicDate + '</td>'
                                }else{
                                    t_html +=
                                    '<td valign="top"></td>'
                                    +'<td valign="top"></td>'
                                    +'<td valign="top"></td>'
                                    +'<td valign="top"></td>'
                                }
                                t_html += '</tr>';
                            }

                        }
                        debugger
                        $('#investment').html(t_html);
                        //打印页面手动拼接表格end--------------------------------------------------

                    } else {
                        var myTemplate = handlebars.compile($("#investment-template").html());
                        handlebars.registerHelper("transDate",
                            function (value) {
                                var date = value.split("-");
                                return date[0] + "年" + date[1] + "月" + date[2] + "日";
                            });
                        if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#investment').html(myTemplate(data));
                    }

                }
            })


        }


        //股权变更信息
        function initDataInvsraTable(page) {
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            var params = $('#params').serializeObject();//查询参数
            http.httpRequest({
                url: '/im/pub/investalter/invsraListJSON',
                serializable: false,
                data: {start: page*length,length: length,params:params},
                success: function (data) {
                    var showPage = data.recordsTotal;
                    $('#paginvsral').pagination(showPage, {//分页工具
                    	prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,//主体页数
                        num_edge_entries: 2,//边缘页数
                        items_per_page:5,
                        current_page: page,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页',
                        callback:function(page,jq){
                        	initDataInvsraTable(page);
                        }
                    });

                    $("#invsralCount").text(data.recordsTotal);
                    var totalPages = Math.ceil(data.recordsTotal / 5);
                    $("#invsralPageCount").text(totalPages);

                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) {
                            //返回+1之后的结果
                            if (page >= 0) {
                                var toIn = ((page) * 5);

                                return index + 1 + toIn;
                            } else {
                                return index + 1;
                            }
                        });
                    var myTemplate = handlebars.compile($("#invsral-template").html());
                    handlebars.registerHelper("inv_trans",
                        function (value) {
                            return value;
                        });
                    handlebars.registerHelper("beTransAmPr_trans",
                        function (value) {
                            return value;
                        });
                    handlebars.registerHelper("afTransAmPr_trans",
                        function (value) {
                            return value;
                        });

                    handlebars.registerHelper("transDate",
                        function (value) {
                            var date = value.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        });

                    handlebars.registerHelper("dataFormat",
                        function (value) {
                            var date = value.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        });


                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0) $('#invsral').html(myTemplate(data));
                }
            })
        }

        function initPermitTable(page) { //行政许可
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            http.httpRequest({
                url: '/im/pub/investalter/permitListJSON',
                serializable: false,
                data: {
                    "pageNum": page,
                    "priPID": $("#priPID").val(),
                    length: length,
                    params: {"pageNum": page}
                },
                success: function (data) {

                    if (page == 0) {
                        page = page;
                    } else {
                        page = page - 1;
                    }

                    var showPage = data.recordsTotal;
                    $('#pagepermit').pagination(showPage, {//分页工具
                        callback: pagePermitCallback,
                        items_per_page: 5,
                        prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,
                        num_edge_entries: 2,
                        current_page: page,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页'
                    });

                    $("#permitCount").text(data.recordsTotal);
                    var totalPages = Math.ceil(data.recordsTotal / 5);
                    $("#permitPageCount").text(totalPages);


                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) {
                            //返回+1之后的结果
                            if (page >= 0) {
                                var toIn = ((page) * 5);

                                return index + 1 + toIn;
                            } else {
                                return index + 1;
                            }
                        });
                    var myTemplate = handlebars.compile($("#permit-template").html());
                    handlebars.registerHelper("transDate",
                        function (value) {
                            var date = value.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        });
                    handlebars.registerHelper("transPubType", function (value) {
                        if (value != null && value != "") {
                            if (value == "1") {
                                return "变更";
                            } else if (value == "2") {
                                return "注销";
                            } else if (value == "3") {
                                return "被吊销";
                            } else if (value == "4") {
                                return "撤销";
                            } else {
                                return "有效";
                            }
                        } else {
                            return "有效";
                        }


                    });

                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#permit').html(myTemplate(data));
                }
            })
        }

        function initIppldgTable(page) { //知识产权
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            http.httpRequest({
                url: '/im/pub/investalter/ippldgListJSON',
                serializable: false,
                data: {
                    "pageNum": page,
                    "priPID": $("#priPID").val(),
                    length: length,
                    params: {"pageNum": page}
                },
                success: function (data) {

                    if (page == 0) {
                        page = page;
                    } else {
                        page = page - 1;
                    }

                    var showPage = data.recordsTotal;
                    $('#pageippldg').pagination(showPage, {//分页工具
                        callback: pageIppldgCallback,
                        items_per_page: 5,
                        prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,
                        num_edge_entries: 2,
                        current_page: page,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页'
                    });

                    $("#ippldgCount").text(data.recordsTotal);
                    var totalPages = Math.ceil(data.recordsTotal / 5);
                    $("#ippldgPageCount").text(totalPages);


                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) {
                            //返回+1之后的结果
                            if (page >= 0) {
                                var toIn = ((page) * 5);

                                return index + 1 + toIn;
                            } else {
                                return index + 1;
                            }
                        });
                    var myTemplate = handlebars.compile($("#ippldg-template").html());
                    handlebars.registerHelper("transDate",
                        function (value) {
                            var date = value.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        });
                    handlebars.registerHelper("transType", function (value) {
                        if (value == "1") {
                            return "变更";
                        } else if (value == "2") {
                            return "注销";
                        } else if (value == "3") {
                            return "撤销";
                        } else {
                            return "有效";
                        }
                    });
                    
                    handlebars.registerHelper("transkinds",function(value){
                    	if(value=="1"){
                    		return "商标";
                    	}else if(value=="2"){
                    		return "版权";
                    	}else if(value=="3"){
                    		return "专利";
                    	}else{
                    		return value;
                    	} 
                    });

                    handlebars.registerHelper("dataFormat",
                        function (value) {
                            var date = value.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        });
                    handlebars.registerHelper("ifUnicode",
                        function (value) {
                            if (value == null || value == "") {
                                return "display:block";
                            } else {
                                return "display:none";
                            }
                        });


                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#ippldg').html(myTemplate(data));
                }
            })
        }

        function initCaseTable(page) { //行政处罚
            var length=5;
            if(window._CONFIG.pageType=='print'){
                length=9999;
            }
            http.httpRequest({
                url: '/im/pub/investalter/caseListJSON',
                serializable: false,
                data: {
                    "pageNum": page,
                    "priPID": $("#priPID").val(),
                    length: length,
                    params: {"pageNum": page}
                },
                success: function (data) {

                    if (page == 0) {
                        page = page;
                    } else {
                        page = page - 1;
                    }

                    var showPage = data.recordsTotal;
                    $('#pagecase').pagination(showPage, {//分页工具
                        callback: pageCaseCallback,
                        items_per_page: 5,
                        prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,
                        num_edge_entries: 2,
                        current_page: page,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页'
                    });

                    $("#caseCount").text(data.recordsTotal);
                    var totalPages = Math.ceil(data.recordsTotal / 5);
                    $("#casePageCount").text(totalPages);

                    var handleHelper = handlebars.registerHelper("addOne",
                        function (index) {
                            if (page >= 0) {
                                var toIn = ((page) * 5);

                                return index + 1 + toIn;
                            } else {
                                return index + 1;
                            }
                        });
                    var myTemplate = handlebars.compile($("#case-template").html());
                    handlebars.registerHelper("transDate",
                        function (value) {
                            if (value != null && value != "") {
                                var date = value.split("-");
                                return date[0] + "年" + date[1] + "月" + date[2] + "日";
                            }
                        });
                    handlebars.registerHelper("dataFormat",
                        function (value) {
                            if (value != null && value != "") {
                                var myDate = new Date(value);
                                var month = myDate.getMonth() + 1;
                                return myDate.getFullYear() + "年" + month + "月" + myDate.getDate() + "日";
                            }
                        });
                    handlebars.registerHelper("rowdisplay",
                        function (value) {
                            if (value == null || value == "") {
                                return "1";
                            } else {
                                return "2";
                            }
                        });
                    handlebars.registerHelper("dataList",
                        function (value) {
                            if (value == null || value == "") {
                                return "display:none";
                            } else {
                                return "";
                            }
                        });

                    handlebars.registerHelper("transType",
                        function (value) {
                            if (value == null && value == "") {
                                if (value == "1") {
                                    return "变更";
                                } else if (value == "2") {
                                    return "诉讼";
                                } else if (value == "3") {
                                    return "复议"
                                } else {
                                    return "有效";
                                }
                            } else {
                                return "有效";
                            }
                        });


                    if (typeof data.recordsTotal != 'undefined' && data.recordsTotal > 0)  $('#case').html(myTemplate(data));
                }
            })
        }


        function pageInvsraCallback(page, jq) {//翻页事件
            initDataInvsraTable(page + 1);
        }

        function pageInvesMentCallback(page, jq) {//翻页事件
            initDataInvestmentTable(page + 1);
        }


        function pagePermitCallback(page, jq) {//翻页事件
            initPermitTable(page + 1);
        }

        function pageIppldgCallback(page, jq) {//翻页事件

            initIppldgTable(page + 1);
        }

        function pageCaseCallback(page, jq) {//翻页事件
            initCaseTable(page + 1);


        }


        function bind() {
            util.bindEvents([
                {
                    el: '#cancle',
                    event: 'click',
                    handler: function () {
                        $('#forinvestForm')[0].reset();
                        $(".js-content-show").hide();
                    }
                },
                {
                    el: ".showIppldg",
                    event: 'click',
                    handler: function () {
                        var priPID = $("#priPID").val();
                        layer.open({
                            isIframeAuto: true,  //如果iframe内容是异步获取不要传此参数
                            type: 2,
                            shadeClose: true,
                            closeBtn: 0,
                            area: ['800px', '400px'],
                            title: false,
                            content: "/im/pub/investalter/showIppldg?pleID=" + this.id + "&priPID=" + priPID
                        });
                    }
                },
                {
                    el: ".showPermit",
                    event: 'click',
                    handler: function () {
                        var priPID = $("#priPID").val();
                        layer.open({
                            isIframeAuto: true,  //如果iframe内容是异步获取不要传此参数
                            type: 2,
                            shadeClose: true,
                            closeBtn: 0,
                            area: ['75%', '30%'],
                            title: false,
                            content: "/im/pub/investalter/showPermit?licID=" + this.id + "&priPID=" + priPID
                        });


                    }
                },
                {
                    el: "#showImvestupdate",
                    event: 'click',
                    handler: function () {
                        var priPID = $("#priPID").val();
                        window.open("/im/pub/investalter/showImvestupdate?priPID=" + priPID);
                    }
                }


            ])
        }

    })