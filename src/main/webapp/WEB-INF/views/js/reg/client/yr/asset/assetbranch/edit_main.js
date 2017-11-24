require([
	'component/iframeLayer',
	'common/util',
	'common/http',
	'component/clearform',
	'component/dropDown',
	'jquery.validate',
	'common/validateRules',
	'jquery.serialize',
	'component/backToTop',
	'component/report',
	'jquery.placeholder',
	'jquery.icinfo'
], function (layer, util, http,clearform) {
	$('input, textarea').placeholder();
	$('.js-ipt-box').expandInput();

    init();
    /**
     * 初始化函数集合
     */
    function init() {

		//判断输入框中是否有因为 ' 号
		$.validator.addMethod("specials", function(value, element) {
			if(value){
				return  value.indexOf("'")>-1?false:true;
			}
		}, "输入文本中不能有特殊符号 如：（活动 '） 中的 ' 号 ");


		initAssetTbl();//初始化财务输入框 金额计算
		init_busStatusCN();//初始化企业经营
    	formValid();
		bind();
		_entBelong(); //回显判断
		reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
		_hover();  //逻辑关系提示初始化
    }

	function _hover(){
		var index;
		$(".icon-question").hover(function (){
			var id = $(this).data("id");
			var msg = $(this).data("msg");
			index = layer.tips(msg,'#'+id,{tips:1, tipsMore:true, ltype:0,time:1000000});
		},function (){
			layer.close(index);
		});
	}


	//回显 判断 你企业属于 独立核算 还是 非独立核算
	function _entBelong(){
		var _value = $("input:radio[name='entBelong']:checked").val();
		if(_value=='1'){
			$(".units").addClass("required").removeAttr("readonly");
			$(".gongshi").addClass("required").removeAttr("disabled");

		}else{
			$(".units").attr("readonly",true).removeClass("required");
			$(".gongshi").removeClass("required").attr("disabled",true);
			$(".units").val(''); 										//设置值为空
			$("#ratGro").val('');										//设置纳税总额的值为空
		}
	};

	//年报状态判断
	function reportStateFrom(){
		var _value = $("#_reportState").val();
		if(_value!='00'&&_value!=='20'&&_value!='13'){
			$("input,select").attr("disabled","disabled");
			$("textarea").attr("readonly","readonly");
			$(".js_show_tips").hide();
			$(".icon-close,.btn-save").hide();
		}
	}


	//初始化财务输入框 金额计算
	function initAssetTbl() {
		$(".units").focus(function() {
		}).blur(function() {
			doCalAssRatGro();//计算纳税总额
		});
	};

	//纳税总额计算
	function doCalAssRatGro() {
		//增值税 addTax
		//城市维护建设税 cityTax
		//营业税 mngTax
		//印花税 floTax
		//消费税 expenseTax
		//企业所得税 entTax
		//土地增值税 landTax
		//个人所得税 personTax
		//关税 dutyTax
		//房产税  houseTax
		//教育费附加 techTax
		//城镇土地使用税 lanUseTax
		//水利基金 waterTax
		// 其他 otherTax
		var addTax = parseFloat(($("#addTax").val() - 0).toFixed(2)),
			cityTax = parseFloat(($("#cityTax").val() - 0).toFixed(2)),
			mngTax = parseFloat(($("#mngTax").val() - 0).toFixed(2)),
			floTax = parseFloat(($("#floTax").val() - 0).toFixed(2)),
			expenseTax = parseFloat(($("#expenseTax").val() - 0).toFixed(2)),
			entTax = parseFloat(($("#entTax").val() - 0).toFixed(2)),
			landTax = parseFloat(($("#landTax").val() - 0).toFixed(2)),
			personTax = parseFloat(($("#personTax").val() - 0).toFixed(2)),
			dutyTax = parseFloat(($("#dutyTax").val() - 0).toFixed(2)),
			houseTax = parseFloat(($("#houseTax").val() - 0).toFixed(2)),
			techTax = parseFloat(($("#techTax").val() - 0).toFixed(2)),
			lanUseTax = parseFloat(($("#lanUseTax").val() - 0).toFixed(2)),
			waterTax = parseFloat(($("#waterTax").val() - 0).toFixed(2)),
			otherTax = parseFloat(($("#otherTax").val() - 0).toFixed(2));
		//纳税总额   ratGro
		var assRatGro = parseFloat(
			addTax + cityTax + mngTax + floTax + expenseTax +
			entTax + landTax + personTax + dutyTax + houseTax +
			techTax + lanUseTax + waterTax + otherTax).toFixed(2);
		if(!isNaN(assRatGro)){  //判断相加的值是否是数字
			$("#ratGro").val(assRatGro);
		}
		var _value = $("input:radio[name='entBelong']:checked").val();//判断是 独立核算 还是 非独立运算
		if(_value=='2'){
			$("#ratGro").val(''); //设置纳税总额为空
		}
	};

	/***初始化企业当前的经营状态 ： start*/
	function init_busStatusCN(){
		$("input:radio[name='busSt']").bind("click", doSwitchBusSt);
		$("#maiBusInc").bind("change",doSwitchBusSt);//修改营业总数变化触发
		var val = $("input:radio[name='busSt']:checked").val();//获取当前选中的选项

		var falg = ($("#maiBusInc").val() !="" && parseInt(Math.round($("#maiBusInc").val() * 100)) <= 10000);

		if (val == 4 || falg ) {
			$("#_noBusRea").slideDown("fast"); //显示
			$("#noBusRea").addClass("required");
		} else {
			$("#_noBusRea").slideUp("slow");   //隐藏
			$("#noBusRea").removeClass("required").val("");
		}
	}

	//修改主营业务收入总数变化触发 判断出是否显示：无经营活动收入或歇业的原因 输入框
	function doSwitchBusSt(){
		var val  =  $("input:radio[name='busSt']:checked").val();
		var text =  $("input:radio[name='busSt']:checked").data("text"); //获取选中的状态中文
		$("#busStatusCN").val(text);//设置给隐藏域中的值

		var falg = ($("#maiBusInc").val() !="" && parseInt(Math.round($("#maiBusInc").val() * 100)) <= 10000);

		if (val == 4 || falg ) {
			$("#_noBusRea").slideDown("fast"); //显示
			$("#noBusRea").addClass("required");
		} else {
			$("#_noBusRea").slideUp("fast");   //隐藏
			$("#noBusRea").removeClass("required").val("");
		}

	}
	/***初始化企业当前的经营状态 ： end**/





    /**
     * 表单验证 并保存
     */
    function formValid() {
        $('#yrassetbranchForm').validate({
			onkeyup:false,
			onfocusout:function(el){
				var parentEle, cls,ele = $(el);
				if (ele.valid()) {
					if (ele.is('input') && ele.attr('type') != 'text') {
						cls = 'error-tips-radio';
						ele.closest('.radio-box').removeClass(cls);
					} else if (ele.is('select')) {
						cls = 'error-tips';
						ele.removeClass(cls);
					} else {
						cls = 'error-tips';
						ele.removeClass(cls);
						parentEle = ele.parent();
						if (parentEle.has('.js-error-tips').length) {
							parentEle.find('.js-error-tips').remove();
						}
					}
				}
				/*if(el.name!='entBelong'){ //你企业属于 提交的时候再进行判断
					$(el).valid();
				}*/
			},
			showErrors: function (errorMap, errorList) {
				for (var i in errorMap) {
					var ele = $('#yrassetbranchForm input[name='+i+'],#yrassetbranchForm textarea[name='+i+']'), index, parentEle, cls;
					if (ele.is('input') && ele.attr('type') != 'text') {
						cls = 'error-tips-radio';
						ele.closest('.radio-box').addClass(cls);
					} else if (ele.is('select')) {
						cls = 'error-tips';
						ele.addClass(cls);
					} else {
						cls = 'error-tips';
						ele.addClass(cls);
						parentEle = ele.parent();
						if (!parentEle.has('.js-error-tips').length) {
							parentEle.append('<em class="js-error-tips error-tips-icon"></em>');
						}
					}
					(function (i) {
						parentEle && (parentEle.find('.js-error-tips').hover(function () {
							index = layer.tips(errorMap[i], $(this), {tips: 3, time: 0})
						}, function () {
							layer.close(index);
						}))
					})(i);
				}
			},
        	 rules:{
				 entBelong:{
					 required: true //你企业属于
				 },
				 busSt : { //企业当前的经营状态
					 required: true
				 },
				 entMainBusActivity:{ //企业主营业务活动
					 required: true,
					 maxlength:3000,
					 specials:true
				 },
				 noBusRea:{
					 maxlength:100,
					 specials:true
				 },
        		 addTax:{ //增值税
        			 maxlength:16
        		 },
        		 cityTax:{ //城市维护建设税
        			 maxlength:16
        		 },
        		 mngTax:{
        			 maxlength:16
        		 },
        		 floTax:{
        			 maxlength:16
        		 },
        		 expenseTax:{
        			 maxlength:16
        		 },
        		 landTax:{
        			 maxlength:16
        		 },
        		 entTax:{
        			 maxlength:16
        		 },
        		 dutyTax:{
        			 maxlength:16
        		 },
        		 personTax:{
        			 maxlength:16
        		 },
        		 houseTax:{
        			 maxlength:16
        		 },
        		 waterTax:{
        			 maxlength:16
        		 },
        		 lanUseTax:{
        			 maxlength:16
        		 },
        		 otherTax:{
        			 maxlength:16
        		 },
        		 empNum:{
					 maxlength:6
        		 },
				 femaleEmploye:{ // 其中女性从业人数
					 maxlength:6
				 },
        		 uniGradOpers:{
					 maxlength:6
        		 },
        		 exSoldOpers:{
					 maxlength:6
        		 },
        		 disOpers:{
					 maxlength:6
        		 },
        		 unemOpers:{
					 maxlength:6
        		 },
        		 uniGradEmps:{
					 maxlength:6
        		 },
        		 exSoldEmps:{
					 maxlength:6
        		 },
        		 disEmps:{
					 maxlength:6
        		 },
        		 unemEmps:{
					 maxlength:6
        		 }
        	 },
            messages: {
				//femaleEmployeIsPub:"请选择一项",
				//entBelong:"请选择一项",
				//busSt:"请选择一项",
				//ratGroIsPub:"请选择一项",
				//netIncIsPub:"请选择一项",
				//maiBusIncIsPub:"请选择一项",
				//isLegRep:"请选择一项",
				//empNumDis:"请选择一项",
                noBusRea:{
					maxlength:"输入的字数在100个字以内!"
				}
            },
            submitHandler: function () {

				if(!_validate()){ //效验没有通过！！！
					return;
				}
				//如果是非独立核算 公示已选的全部清空处理
				var _v = $("input:radio[name='entBelong']:checked").val();
				if(_v=='2'){
					$(".gongshi").removeAttr("disabled").val("");
				}
				var formParam = $('#yrassetbranchForm').serializeObject();

				formParam['sign'] = "preservation";  //保存标记

				$(".js-save").attr("disabled", true); //防止表单重复提交
				$(".js-temporary").attr("disabled", true);  //防止表单重复提交
				http.httpRequest({
					url: '/reg/client/yr/ent/yrassetbranch/save',
					serializable: false,
					data: formParam,
					type: 'post',
					success: function (data) {
						if(data.status=='success') {
							layer.msg(data.msg, {icon: 1, time: 1000}, function () {
								window.location.reload(); //重新加载页面
							});
						}else if(data.status=='fail'){
							$(".js-save").attr("disabled", false);
							$(".js-temporary").attr("disabled", false);
							layer.msg(data.msg, {icon: 2,time: 1000});
						}
					},
					error:function(){
						$(".js-save").attr("disabled", false);
						$(".js-temporary").attr("disabled", false);
					}
				});


			}
        });
    }



	//效验：
	function _validate() {

		var flag = true;
		var empNum = $("#empNum").val()-0; //企业从业人员数

		//追加：
		var femaleEmploye = $("#femaleEmploye").val()-0;//(其中女性从业人数)

		//【其中女性从业人数】不能大于【企业从业人员数】
		//追加内容：
		if(femaleEmploye>empNum){
			layer.tips('【其中女性从业人数】不能大于【企业从业人员数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#femaleEmploye',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#femaleEmploye").focus();
			return flag==false;
		};

		//从业人员中属于：
		var uniGradOpers = $("#uniGradOpers").val()-0;//高校毕业生
		var exSoldOpers = $("#exSoldOpers").val()-0;//退役士兵
		var unemOpers = $("#unemOpers").val()-0;//失业人员再就业
		var disOpers = $("#disOpers").val()-0;//残疾人

		//从业人员中该 年新雇佣
		var uniGradEmps = $("#uniGradEmps").val()-0;//高校毕业生
		var exSoldEmps = $("#exSoldEmps").val()-0;//退役士兵
		var disEmps = $("#disEmps").val()-0;//残疾人
		var unemEmps = $("#unemEmps").val()-0;//失业人员再就业

		//10)从业人员中属于高校毕业生人数不能大于企业从业人员数
		if(uniGradOpers>empNum){
			layer.tips('【从业人员中属于高校毕业生人数】不能大于【企业从业人员数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#uniGradOpers',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#uniGradOpers").focus();
			return flag==false;
		};
		//12)从业人员中属于退役士兵人数不能大于企业从业人员数
		if(exSoldOpers>empNum){
			layer.tips('【从业人员中属于退役士兵人数】不能大于【企业从业人员数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#exSoldOpers',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#exSoldOpers").focus();
			return flag==false;
		};
		//14)从业人员中属于残疾人人数不能大于企业从业人员数
		if(disOpers>empNum){
			layer.tips('【从业人员中属于残疾人人数】不能大于【企业从业人员数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#disOpers',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#disOpers").focus();
			return flag==false;
		};
		//16)从业人员中属于失业人员再就业人数不能大于企业从业人员数
		if(unemOpers>empNum){
			layer.tips('【从业人员中属于失业人员再就业人数】不能大于【企业从业人员数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#unemOpers',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#unemOpers").focus();
			return flag==false;
		};

		//11)从业人员中当年度新雇佣高校毕业生人数不能大于从业人员中属于高校毕业生人数
		if(uniGradEmps>uniGradOpers){
			layer.tips('【从业人员中当年度新雇佣高校毕业生人数】不能大于【从业人员中属于高校毕业生人数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#uniGradEmps',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#uniGradEmps").focus();
			return flag==false;
		}

		//13)从业人员中当年度新雇佣退役士兵人数 不能大于从业人员中属于退役士兵人数
		if(exSoldEmps>exSoldOpers){
			layer.tips('【从业人员中当年度新雇佣退役士兵人数】不能大于【从业人员中属于退役士兵人数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#exSoldEmps',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#exSoldEmps").focus();
			return flag==false;
		};
		//15)从业人员中当年度新雇佣残疾人人数 不能大于从业人员中属于残疾人人数
		if(disEmps>disOpers){
			layer.tips('【从业人员中当年度新雇佣残疾人人数】不能大于【从业人员中属于残疾人人数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#disEmps',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#disEmps").focus();
			return flag==false;
		};
		//17)从业人员中当年新雇失业人员再就业人数不能大于从业人员中属于失业人员再就业人数
		if(unemEmps>unemOpers){
			layer.tips('【从业人员中当年新雇失业人员再就业人数】不能大于【从业人员中属于失业人员再就业人数】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#unemEmps',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#unemEmps").focus();
			return flag==false;
		};

		//18)各类从业人员人数不能大于企业从业人员数
		var _total=(uniGradOpers+exSoldOpers+disOpers+unemOpers);
		if(_total>empNum){
			layer.tips('【各类从业人员总人数<font style="font-size: 14px;color: red">['+_total+'人]</font>】不能大于【企业从业人员数】<font style="font-size: 14px;color: red">['+empNum+']人</font>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#empNum',{tips:3, tipsMore:true, ltype:0,time:0});
			$("#empNum").focus();
			return flag==false;
		}

		return flag;
	}
	function bind() {
		util.bindEvents([
			{
				el: 'input:radio[name=entBelong]',  //你企业属于 独立核算 1  非独立核算 2
				event: 'click',
				handler: function () {
					var _value = $(this).val();
					if(_value=='1'){
						$(".units").addClass("required").removeAttr("readonly");
						$(".gongshi").addClass("required").removeAttr("disabled");
					}else{
						$(".units").attr("readonly",true).removeClass("required");
						$(".gongshi").removeClass("required").attr("disabled",true);
						$(".units").val(''); 										//设置值为空
						$("#ratGro").val('');										//设置纳税总额的值为空
						clearform.clearTips('js-inputs'); //清除非输入的校验
						clearform.clearTips('js-mod-bd');

					}
				}
			},
			{
				el: '.js-temporary',   //暂存操作
				event: 'click',
				handler: function () {
					var formParam = $('#yrassetbranchForm').serializeObject();
					formParam['sign'] = "temporary";  //暂存标记

					$(".js-temporary").attr("disabled", true);  //防止表单重复提交
					$(".js-save").attr("disabled", true); //防止表单重复提交
					http.httpRequest({
						url: '/reg/client/yr/ent/yrassetbranch/save',
						serializable: false,
						data: formParam,
						type: 'post',
						success: function (data) {
							if(data.status=='success') {
								layer.msg("暂存成功", {icon: 1, time: 1000}, function () {
									window.location.reload(); //重新加载页面
								});
							}else if(data.status=='fail'){
								$(".js-temporary").attr("disabled", false);
								$(".js-save").attr("disabled", false);
								layer.msg("暂存失败", {icon: 2,time: 1000});
							}

						},
						error:function(){
							$(".js-temporary").attr("disabled", false);
							$(".js-save").attr("disabled", false);
						}
					});
				}
			},
			{
				el: '.js_close_tips',          //触发提示关闭tip层
				event: 'click',
				handler: function () {
					layer.closeAll('tips'); //关闭所有的tips层
				}
			}

		])
	}

});