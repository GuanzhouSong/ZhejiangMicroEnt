require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars' , 'common/validateRules','jquery.validate', 'jquery.serialize','component/backToTop','pagination'], function (layer, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {
    	initTable();
        formValid();
        bind();
    }

    /**
     * 表单验证 并保存
     */
    function formValid() {
        $('#modapplyForm').validate({
            rules: {
            	modReason:{ //修改原因及内容
                    required: true,
                    maxlength:500
                }
            },
            messages: {
            	modReason: {
                    required: '请输入修改原因及内容!',
                    maxlength: '输入的字数在500个字以内!'
                }
            },
            showErrors:function(errorMap){
            	if(!$.isEmptyObject(errorMap)){
            		layer.tips(errorMap['modReason'],$('textarea'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
            	}
            },
            submitHandler: function () {
                var formParam = $('#modapplyForm').serializeObject();
                var entTypeCatg = $('#entTypeCatg').val();
                var type;
                if(entTypeCatg==50){//个体户
                	type = "pb";
                }else if(entTypeCatg==16||entTypeCatg==17){//农专
                	type = "sfc";
                }else{
                	type = "ent";
                }
                $("#saveButton").attr("disabled", true);
          		 $("#saveButton").val("提交中....");  
                http.httpRequest({
                    url: '/reg/client/yr/modapplication/'+type+'/save',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	if (data.status == 'success') {
                    		layer.msg(data.msg, {time: 1000}, function () {//成功后重新请求申请修改显示申请信息
                            	location.assign('/reg/client/yr/modapplication/'+type+'/show?year=' + $("#encodeYear").val());
                                return;
                            });
                        }else {
                        	layer.msg(data.msg, {time: 3000}, function () {
                                return;
                            });
                        }
                    }
                });
            }
        });
    }
    
    function initTable() {
    	loadData(0,10);
    }
    
    function loadData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        var entTypeCatg = $('#entTypeCatg').val();
        var type;
        if(entTypeCatg==50){//个体户
        	type = "pb";
        }else if(entTypeCatg==16||entTypeCatg==17){//农专
        	type = "sfc";
        }else{
        	type = "ent";
        }
        http.httpRequest({
            url: '/reg/client/yr/modapplication/'+type+'/list_json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination').pagination(itemCount, {
	                prev_text: '<i class="icon-triangle-left"></i>上一页',
	                next_text: '下一页<i class="icon-triangle-right"></i>',
	                num_display_entries: 3,
	                num_edge_entries: 2,
	                current_page: page,
	                link_to: 'javascript:void(0)',
	                ellipse_text: '...',
	                first_text: '首页',
	                last_text: '末页',
	                callback: function () {
	                	loadData(page,10);
	                }
                });
                handlebars.registerHelper("addOne", function(index) {return index + 1;});//序号
                handlebars.registerHelper("modResult", function(modResult) {
                	if(modResult == '1') {
                		return "同意";
            		}else if(modResult == '2') {
            			return "不同意";
        			}else{
        				return "待审核";
        			}
                });
                var myTemplate = handlebars.compile($('#table-template').html());
                $('#modItem').html(myTemplate(data));
                $("#itemCount").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#pageCount").text(pageNum);//共多少页
            }
        });
    };

    function bind() {
        util.bindEvents([{
        	//取消
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.close();
            }
        },{
        	//展开收起
            el: '.show-tips',
            event: 'click',
            handler: function () {
            	var $span = $(this).find("span");
                $span.text($span.text() == '收起' ? '展开' : '收起');
                $(this).toggleClass('drop-on');
                $(".js-content-show").toggle();
            }
        },{
        	//升序降序排序方式
        	el: '.order_by',  
            event: 'click',
            handler: function () {
                var $this = $(this);
                var name = $this.data("name");
                var order = $this.data("order");
                //设置当前排序小箭头
                $(".order_by").removeClass("cur");
                $this.addClass("cur");
                //设置排序参数
                $("#orderby").val(name + " " + order);
                loadData(0,10);//根据排序条件重新排列
            }
        },{
        	//重新申请
        	el: '.reapply',  
            event: 'click',
            handler: function () {
            	var params = $('#_params').serializeObject();//查询参数
            	var entTypeCatg = $('#entTypeCatg').val();
                var type;
                if(entTypeCatg==50){//个体户
                	type = "pb";
                }else if(entTypeCatg==16||entTypeCatg==17){//农专
                	type = "sfc";
                }else{
                	type = "ent";
                }
            	location.assign('/reg/client/yr/modapplication/'+type+'/show?year=' + params['encodeYear'] + '&pripid=' + params['priPID'] + "&reapply=1");
            }
        }]);
    }
});