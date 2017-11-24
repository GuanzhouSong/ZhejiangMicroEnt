require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'common/validateRules',
    'jquery.validate',
    'jquery.serialize',
    'component/backToTop',
    'component/report'
], function (layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {
        $.extend($.validator.messages, {
            required: "请输入文本值",
            digits: "只能输入数字",
            maxlength: $.validator.format("输入的字数不能超过 {0} 个字符"),
        });
        initTab(); //初始化模板 Tab
        initAssetTbl();//初始化财务输入框
        init_busStatusCN();//初始化企业经营
        formValid();
        bind();
    }

    //初始化模板 Tab
    function initTab() {
        var year = $("#_year").val();
        var tabName = $("#tabName").val();
        http.httpRequest({
            url: '/reg/client/yr/yrwritehomepage/tab_template',
            serializable: false,
            type: 'post',
            data:{'year':year,'tabName':tabName},
            dataType:'html',
            success: function (data) {
                $("#_tab").empty(); //每次进入都进行一次清空
                var $data = $(data);
                $data.prependTo('#_tab');
            }
        })
    };


    //初始化财务输入框
    function initAssetTbl() {
        //只允许输入数字，且精确到分 (【元】 为单位 保留小数点后两位有效数字)
        $(".assetItem").focus(function() {
            $(this).select();
        }).blur(function() {
             var reg = /^[\-\+]?\d+(\.\d{1,2})?$/;  //只能输入数字和小数的正则表达式,小数点后面保留1到2位{1,2}表示的是小数点后面保留几位小数
             var _v = $(this).val().trim();      //获取当前值并且去掉左右空格
             if(_v){
                 if(!reg.test(_v)){
                     layer.tips('金额为数字且最多精确到分! 如：100.68',$(this),{tips:3, tipsMore:true, ltype:0});
                     $(this).focus();return;
                 }
             }
            //长度校验
            if(_v.length>14){
                layer.tips('您输入的金额度长度超出正常值！',$(this),{tips:3, tipsMore:true, ltype:0});
                $(this).focus();return;
            }

            $(this).val(parseFloat((_v == "" || isNaN(_v) ? "0.00" : _v) - 0).toFixed(2));  //为空或为整数的时候(默认追加小数点后2为小数00)
            //计算纳税总额
            doCalAssRatGro();
        });

        //(【万元】 为单位 保留小数点后四位有效数字)
        $(".million_yuan").focus(function() {
            $(this).select();
        }).blur(function() {
            var reg = /^[\-\+]?\d+(\.\d{1,4})?$/;  //只能输入数字和小数的正则表达式,小数点后面保留1到4位{1,4}表示的是小数点后面保留几位小数
            var _v = $(this).val().trim();      //获取当前值并且去掉左右空格
            if(_v){
                if(!reg.test(_v)){
                    layer.tips('金额为数字且最多精确到十位! 如：100.6812',$(this),{tips:3, tipsMore:true, ltype:0});
                    $(this).focus();return;
                }
            }
            //长度校验
            if(_v.length>14){
                layer.tips('您输入的金额度长度超出正常值！',$(this),{tips:3, tipsMore:true, ltype:0});
                $(this).focus();return;
            }
            $(this).val(parseFloat((_v == "" || isNaN(_v) ? "0.0000" : _v) - 0).toFixed(4));  //为空或为整数的时候(默认追加小数点后4为小数0000)
            //计算纳税总额
            doCalAssRatGro();
        });
    };

    //提交前再次判断金额输入框是否都输入正确
    function _moneyValidate(){
        var flag = true;
        $(".assetItem").each(function(){
            var reg = /^[\-\+]?\d+(\.\d{2})?$/;
            var _v = $(this).val();      //获取当前值
            if(_v){ if (!reg.test(_v)){ flag = false; } }
            //长度校验
            if(_v.length>16){ flag = false; }
        });
        $(".million_yuan").each(function() {
            var reg = /^[\-\+]?\d+(\.\d{4})?$/;
            var _v = $(this).val();      //获取当前值
            if(_v){if(!reg.test(_v)){flag = false;}}
            //长度校验
            if(_v.length>16){flag = false;}
        });
        return flag;
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
        $("#ratGro").val(assRatGro);
    };

    /***初始化企业当前的经营状态 ： start*/
    function init_busStatusCN(){
        $("input[rel='busStatusCN']").bind("click", doSwitchBusSt);
        $("#vendInc").bind("change",doSwitchBusSt);//修改营业总数变化触发
        var val = $("input[rel='busStatusCN']:checked").val();//获取当前选中的选项
        if(val == 4 || parseInt(Math.round($("#vendInc").val() * 100)) <= 10000){
            $("#noBusRea").attr("name","noBusRea");
            $("#_noBusRea").slideDown("slow"); //显示
        }else{
            $("#noBusRea").attr("name","");
            $("#_noBusRea").slideUp("slow");   //隐藏
        }
    }
    //修改营业总数变化触发 判断出是否显示：无经营活动收入或歇业的原因 输入框
    function doSwitchBusSt(){
        var val = $("input[rel='busStatusCN']:checked").val();
        var text = $("input[rel='busStatusCN']:checked").data("text"); //获取选中的状态中文
        $("#busStatusCN").val(text);//设置给隐藏域中的值
        if(val == 4 || parseInt(Math.round($("#vendInc").val() * 100)) <= 10000){
            $("#noBusRea").attr("name","noBusRea");
            $("#_noBusRea").slideDown("slow"); //显示
        }else{
            $("#noBusRea").attr("name","");
            $("#_noBusRea").slideUp("slow");   //隐藏

        }
    }
    /***初始化企业当前的经营状态 ： end**/


    /**
     * 表单验证 并保存
     */
    function formValid() {
        $('#yrassetForm').validate({
            rules: {
                /////////////////企业财务信息 start /////////////////
                moneFunds: { //货币资金
                    required: true
                },
                accPay: { //应付账款
                    required: true
                },
                accRec: { //应收账款
                    required: true
                },
                othPay: { //其他应付款
                    required: true
                },
                othAccRec: { //其他应收款
                    required: true
                },
                totCurrLiab: { //流动负债合计
                    required: true
                },
                inventory: { //存货
                    required: true
                },
                liaGro: { //负债总额
                    required: true
                },
                liaGroIsPub: { //负债总额 公示 不公示
                    required: true
                },
                totCurrAssets: { //流动资产合计
                    required: true
                },
                totEqu: { //所有者权益合计
                    required: true
                },
                totEquIsPub: { //所有者权益合计 公示 不公示
                    required: true
                },
                longInvest: { //长期投资
                    required: true
                },
                vendInc: { //营业总收入
                    required: true
                },
                vendIncIsPub: { //营业总收入 公示 不公示
                    required: true
                },
                fixAssets: { //固定资产
                    required: true
                },
                maiBusInc: { //其中：主营业务收入
                    required: true
                },
                maiBusIncIsPub: { //其中：主营业务收入 公示 不公示
                    required: true
                },
                intAssets: { //无形资产
                    required: true
                },
                proGro: { //利润总额
                    required: true
                },
                proGroIsPub: { //利润总额 公示 不公示
                    required: true
                },
                assGro: { //资产总额
                    required: true
                },
                assGroIsPub: { //资产总额 公示 不公示
                    required: true
                },
                netInc: { //净利润
                    required: true
                },
                netIncIsPub: { //净利润 公示 不公示
                    required: true
                },
                expGro: { //当年年出口创汇总额
                    required: true
                },
                intelGro: { //当年研究开发、技术改造、科技创新等方面的支出
                    required: true
                },
                busSt : { //企业当前的经营状态
                    required: true
                },
                noBusRea:{ //无经营活动收入或歇业的原因
                    required: true,
                    maxlength:100
                },

                /////////////////企业财务信息 end/////////////////

                finOrgLoan:{ //当年从金融机构获得贷款总额
                    required: true
                },
                comLoan:{ //当年从小额贷款公司等其他渠道融资总额
                    required: true
                },
                endLoan:{ //截止当年年末，从金融机构获得的贷款余额
                    required: true
                },
                payLoan:{ // 当年贷款利息支出总额
                    required: true
                },
                /////////////////企业税费缴纳 start/////////////////
                addTax:{ //增值税
                    required: true
                },
                cityTax:{ //城市维护建设税
                    required: true
                },
                mngTax:{ //营业税
                    required: true
                },
                floTax:{ //印花税
                    required: true
                },
                expenseTax:{ //消费税
                    required: true
                },
                entTax:{ //企业所得税
                    required: true
                },
                landTax:{ //土地增值税
                    required: true
                },
                personTax:{ //个人所得税
                    required: true
                },
                dutyTax:{ //关税
                    required: true
                },
                houseTax:{ //房产税
                    required: true
                },
                techTax:{ //教育费附加
                    required: true
                },
                lanUseTax:{ //城镇土地使用税
                    required: true
                },
                waterTax:{ //水利基金
                    required: true
                },
                otherTax:{ //其他
                    required: true
                },
                ratGro:{ //纳税总额
                    //required: true
                },
                ratGroIsPub:{ //纳税总额 公示 不公示
                    required: true
                },
                isMinDis:{ //当年是否享受小微企业减免残保金政策
                    required: true
                },
                minNationTax:{ //当年减免国税
                    required: true
                },
                isLegPay:{ //当年是否依法交纳残保金
                    required: true
                },
                minLandTax:{ //2016年减免地税
                    required: true
                },
                /////////////////企业税费缴纳 end/////////////////
                empNum:{ //企业从业人员数
                    required: true,
                    digits:true,
                    maxlength:6

                },
                empNumDis:{ //企业从业人员数 公示 不公示
                    required: true,
                    digits:true
                },
                isLegRep:{ // 企业法定代表人是否属于
                    required: true
                },
                uniGradOpers:{ //从业人员中属于 高校毕业生
                    required: true,
                    digits:true,
                    maxlength:6
                },
                exSoldOpers:{ //从业人员中属于 退役士兵
                    required: true,
                    digits:true,
                    maxlength:6
                },
                disOpers:{ //从业人员中属于 残疾人
                    required: true,
                    digits:true,
                    maxlength:6
                },
                unemOpers:{ //从业人员中属于 失业人员再就业
                    required: true,
                    digits:true,
                    maxlength:6
                },

                uniGradEmps:{ //从业人员中该年新雇佣 高校毕业生
                    required: true,
                    digits:true,
                    maxlength:6
                },
                exSoldEmps:{ //从业人员中该年新雇佣 退役士兵
                    required: true,
                    maxlength:6
                },
                disEmps:{ //从业人员中该年新雇佣 残疾人
                    required: true,
                    digits:true,
                    maxlength:6
                },
                unemEmps:{ //从业人员中该年新雇佣 失业人员再就业
                    required: true,
                    digits:true,
                    maxlength:6
                },

                entOugthSetDis:{ //企业应安置残疾人员数
                    required: true,
                    digits:true,
                    maxlength:6
                },
                entSetDis:{ //企业已安置残疾人员数
                    required: true,
                    digits:true,
                    maxlength:6
                },
                /////////////////企业用工情况 end /////////////////
                waterFee:{ //该年水电费支出总额
                    required: true
                },
                salaryFee:{ //该年工资支出总额
                    required: true
                },
                rentFee:{ //该年房租（含物业费）支出总额
                    required: true
                },
                socFee:{ //该年五险一金支出总额
                    required: true
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#yrassetForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            messages: {
                liaGroIsPub:"请选择一项",
                totEquIsPub:"请选择一项",
                vendIncIsPub:"请选择一项",
                maiBusIncIsPub:"请选择一项",
                proGroIsPub:"请选择一项",
                assGroIsPub:"请选择一项",
                netIncIsPub:"请选择一项",
                busSt:"请选择一项",
                //企业财务信息 end
                //企业税费缴纳 start
                ratGroIsPub:"请选择一项",
                isMinDis:"请选择一项",
                isLegPay:"请选择一项",
                //企业税费缴纳 end
                //企业用工情况 start
                empNumDis:"请选择一项",
                isLegRep:"请选择一项",
                //企业用工情况 end
                //企业经营情况
                noBusRea:"输入的字数在100个字以内!"
            },
         /*   submitHandler: function () {  //测试使用 使用完删除使用下面的
                    //提交：
                        var formParam = $('#yrassetForm').serializeObject();
                        http.httpRequest({
                            url: '/reg/client/yr/ent/yrasset/save',
                            serializable: true,
                            data: formParam,
                            type: 'post',
                            success: function (data) {
                                console.log(data);
                                layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                    window.location.reload(); //重新加载页面
                                });
                            }
                        });
            }*/
            submitHandler: function () {
                if(!_validate()){ //效验没有通过！！！
                   return;
                }
                //提交前再次判断金额是否输入正确！
                if(!_moneyValidate()){
                    return ;
                }
                /////////////////////////////////数据填写范围提示 start/////////////////////////////////

                //企业经营费用
                var _empNum = $("#empNum").val(); //企业从业人员数
                var socFee = parseInt(Math.round($("#socFee").val() * 100)), //五险一金总额
                    salaryFee = parseInt(Math.round($("#salaryFee").val() * 100)), //工资总额
                    avgAssSalaryFee = parseInt(Math.round(salaryFee)) / _empNum; // 人均年工资（工资总额/从业人员数）
                var _msg = "";
                // 企业财务信息项出现≥1亿时，
                $(".billionCheck").each(function(){
                    if(parseInt(Math.round($(this).val() * 100)) >= 10000000000) {
                        _msg += "“" + $(this).data("title") + "”为" + $(this).val() + "元;";
                    }
                });
                // 人均年工资（工资总额/从业人员数）≥10万或≤1.5万，
                if(avgAssSalaryFee >= 10000000 || avgAssSalaryFee <= 1500000) {
                    _msg += "“" + $("#salaryFee").data("title") + "”为" + $("#salaryFee").val() + "元，";
                }

                // 企业纳税总额、水电费、房租(含物业费)支出总额、五险一金费出现≥1千万时，
                $(".millionCheck").each(function(){
                    if(parseInt(Math.round($(this).val() * 100)) >= 1000000000) {
                        _msg += "“" + $(this).data("title") + "”为" + $(this).val() + "元，";
                    }
                });
                if(_msg.length>0){
                    layer.confirm(_msg+" 请注意确认您填写的数据是否有误！若“无误”点击【确定】", {icon: 2, title: '提示'}, function (index) {_prompt();});
                }else{_prompt();}
                /////////////////////////////////数据填写范围提示 end  /////////////////////////////////

                ///提示提交的选择判断///
                function _prompt() {
                    ///////////////////////////////// 判断 长期投资≠对外投资实缴总额 start /////////////////////////////////
                    //判断 长期投资≠对外投资实缴总额
                    var _f = true;
                    var _longInvest; //长期投资 声明
                    var _actAmountSum;//对外投资实缴总额声明
                    function checkInvest() {
                        _longInvest = $("#longInvest").val()-0;//获取长期投资值
                        http.httpRequest({
                            url: '/reg/client/yr/ent/forinvestment/selectInvestSumByYearAndPriPid',
                            serializable: false,
                            data: {'year': $("#_year").val(), 'priPid': $("#priPID").val()}, //隐藏参数传递
                            type: 'post',
                            async: false,//同步
                            success: function (data) {
                                if (data.status == 'success') {
                                    _longInvest = _longInvest || 0;//长期投资金额
                                    _actAmountSum = data.data || 0;//当年对外投资实缴总额
                                    _actAmountSum = parseFloat((isNaN(_actAmountSum) ? "0.0000" : _actAmountSum) - 0).toFixed(4);
                                    if (_longInvest != (_actAmountSum * 10000)) {
                                        _f = false;
                                    }
                                }
                            }
                        });
                    }
                    ///////////////////////////////// 判断 长期投资≠对外投资实缴总额 end  /////////////////////////////////
                    checkInvest();
                    if (!_f) {
                        layer.confirm('你企业财务报表中的“长期投资”为 ' + _longInvest + '元，与你企业对外投资的实缴总额 ' + _actAmountSum + '万元不一致，请注意确认数据是否正确无误？如有误请取消返回修改。',
                            {icon: 2, title: '提示'}, function (index) {_submit()});} else {_submit()}
                    //提交：
                    function _submit() {
                        var formParam = $('#yrassetForm').serializeObject();
                        var _index;
                        http.httpRequest({
                            url: '/reg/client/yr/ent/yrasset/save',
                            beforeSend:function(){ //发送前执
                                _index = layer.load(2, {shade: 0.5});
                            },
                            serializable: true,
                            data: formParam,
                            type: 'post',
                            success: function (data) {
                                if(data.status=='success') {
                                    layer.close(_index);
                                    layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                        window.location.reload(); //重新加载页面
                                    });
                                }else if(data.status=='fail'){
                                    layer.close(_index);
                                    layer.msg(data.msg, {icon: 2,time: 1000});
                                }
                            }
                        });
                    }
                }
            }
        })
    }

    //效验：
    function _validate(){

        var flag = true;
        /************************************数据逻辑关系 start*******************************/
        /* 1)资产总额 = 负债总额 + 所有者权益合计
         2)营业总收入  ≥ 主营业务收入
         3)流动资产合计  ≥ 货币资金 + 应收账款 + 其他应收款 + 存货
         4)资产总额  ≥ 流动资产合计 + 长期投资 + 固定资产 + 无形资产
         5)负债总额  ≥ 流动负债合计
         6)出口创汇额 ≤ 营业总收入*/

        //1)资产总额 = 负债总额 + 所有者权益合计
        var assGro = parseInt(Math.round($("#assGro").val() * 100)), //资产总额
            liaGro = parseInt(Math.round($("#liaGro").val() * 100)), //负债总额
            totEqu = parseInt(Math.round($("#totEqu").val() * 100)); //所有者权益合计
        if(!(assGro == liaGro + totEqu)) {
            layer.tips('数据逻辑关系（资产总额 = 负债总额 + 所有者权益合计）错误！','#assGro',{tips:3, tipsMore:true, ltype:0});
            $("#assGro").focus();
            return flag==false;
        };

        //2)营业总收入  ≥ 主营业务收入
        var vendInc = parseInt(Math.round($("#vendInc").val() * 100)), //营业总收入
            maiBusInc = parseInt(Math.round($("#maiBusInc").val() * 100)); //主营业务收入
        if(vendInc < maiBusInc) {
            layer.tips('数据逻辑关系（营业总收入  ≥ 主营业务收入）错误！','#vendInc',{tips:3, tipsMore:true, ltype:0});
            $("#vendInc").focus();
            return flag==false;
        };

        //3)流动资产合计  ≥ 货币资金 + 应收账款 + 其他应收款 + 存货
        var totCurrAssets = parseInt(Math.round($("#totCurrAssets").val() * 100)), //流动资产合计
            moneFunds = parseInt(Math.round($("#moneFunds").val() * 100)), //货币资金
            accRec = parseInt(Math.round($("#accRec").val() * 100)), //应收账款
            othAccRec = parseInt(Math.round($("#othAccRec").val() * 100)), //其他应收款
            inventory = parseInt(Math.round($("#inventory").val() * 100)); //存货
        if(totCurrAssets < moneFunds + accRec + othAccRec + inventory) {
            layer.tips('数据逻辑关系（流动资产合计  ≥ 货币资金 + 应收账款 + 其他应收款 + 存货）错误！','#totCurrAssets',{tips:3, tipsMore:true, ltype:0});
            $("#totCurrAssets").focus();
            return flag==false;
        }

        //4)资产总额  ≥ 流动资产合计 + 长期投资 + 固定资产 + 无形资产
        var longInvest = parseInt(Math.round($("#longInvest").val() * 100)), //长期投资
            fixAssets = parseInt(Math.round($("#fixAssets").val() * 100)), //固定资产
            intAssets = parseInt(Math.round($("#intAssets").val() * 100)), //无形资产
            totCurrLiab = parseInt(Math.round($("#totCurrLiab").val() * 100)), //流动负债合计
            expGro = parseInt(Math.round($("#expGro").val() * 100)); // 出口创汇总额
        if(assGro < totCurrAssets + longInvest + fixAssets + intAssets) {
            layer.tips('数据逻辑关系（资产总额  ≥ 流动资产合计 + 长期投资 + 固定资产 + 无形资产）错误！','#assGro',{tips:3, tipsMore:true, ltype:0});
            $("#assGro").focus();
            return flag==false;
        }
        //5)负债总额  ≥ 流动负债合计
        if(liaGro<totCurrLiab){
            layer.tips('数据逻辑关系（负债总额  ≥ 流动负债合计）错误！','#liaGro',{tips:3, tipsMore:true, ltype:0});
            $("#liaGro").focus();
            return flag==false;
        }
        //6)出口创汇总额 ≤ 营业总收入
        if(expGro>vendInc){
            layer.tips('数据逻辑关系（出口创汇额 ≤ 营业总收入）错误！','#expGro',{tips:3, tipsMore:true, ltype:0});
            $("#expGro").focus();
            return flag==false;
        }
        /************************************数据逻辑关系 end*******************************/
        /*
         非私营企业：
         9)从业人员中属于残疾人雇工人数 不能大于企业从业人员数
         <%--目前不能确认企业的类型是非私营和私营： 从业人员中属于残疾人雇工人数 对应的是：其中残疾人人数(雇工)disEmps--%>
         私营企业（小类1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580）：

         18)各类从业人员人数不能大于企业从业人员数

         */
        var empNum = $("#empNum").val()-0; //企业从业人员数
        var disOpers = $("#disOpers").val()-0;//残疾人
        if(window._CONFIG._entype!=-1){
            /**************************私营企业 start**********************************/
            //从业人员中属于：
            var uniGradOpers = $("#uniGradOpers").val()-0;//高校毕业生
            var exSoldOpers = $("#exSoldOpers").val()-0;//退役士兵
            var unemOpers = $("#unemOpers").val()-0;//失业人员再就业

            //从业人员中该 年新雇佣
            var uniGradEmps = $("#uniGradEmps").val()-0;//高校毕业生
            var exSoldEmps = $("#exSoldEmps").val()-0;//退役士兵
            var disEmps = $("#disEmps").val()-0;//残疾人
            var unemEmps = $("#unemEmps").val()-0;//失业人员再就业


            //10)从业人员中属于高校毕业生人数不能大于企业从业人员数
            if(uniGradOpers>empNum){
                layer.tips('从业人员中属于高校毕业生人数不能大于企业从业人员数','#uniGradOpers',{tips:3, tipsMore:true, ltype:0});
                $("#uniGradOpers").focus();
                return flag==false;
            };
            //12)从业人员中属于退役士兵人数不能大于企业从业人员数
            if(exSoldOpers>empNum){
                layer.tips('从业人员中属于退役士兵人数不能大于企业从业人员数','#exSoldOpers',{tips:3, tipsMore:true, ltype:0});
                $("#exSoldOpers").focus();
                return flag==false;
            };
            //14)从业人员中属于残疾人人数不能大于企业从业人员数
            if(disOpers>empNum){
                layer.tips('从业人员中属于残疾人人数不能大于企业从业人员数','#disOpers',{tips:3, tipsMore:true, ltype:0});
                $("#disOpers").focus();
                return flag==false;
            };
            //16)从业人员中属于失业人员再就业人数不能大于企业从业人员数
            if(unemOpers>empNum){
                layer.tips('从业人员中属于失业人员再就业人数不能大于企业从业人员数','#disOpers',{tips:3, tipsMore:true, ltype:0});
                $("#disOpers").focus();
                return flag==false;
            };

            //11)从业人员中当年度新雇佣高校毕业生人数不能大于从业人员中属于高校毕业生人数
            if(uniGradEmps>uniGradOpers){
                layer.tips('从业人员中当年度新雇佣高校毕业生人数不能大于从业人员中属于高校毕业生人数','#uniGradEmps',{tips:3, tipsMore:true, ltype:0});
                $("#uniGradEmps").focus();
                return flag==false;
            }

            //13)从业人员中当年度新雇佣退役士兵人数 不能大于从业人员中属于退役士兵人数
            if(exSoldEmps>exSoldOpers){
                layer.tips('从业人员中当年度新雇佣退役士兵人数不能大于从业人员中属于退役士兵人数','#exSoldEmps',{tips:3, tipsMore:true, ltype:0});
                $("#exSoldEmps").focus();
                return flag==false;
            };
            //15)从业人员中当年度新雇佣残疾人人数 不能大于从业人员中属于残疾人人数
            if(disEmps>disOpers){
                layer.tips('从业人员中当年度新雇佣残疾人人数不能大于从业人员中属于残疾人人数','#disEmps',{tips:3, tipsMore:true, ltype:0});
                $("#disEmps").focus();
                return flag==false;
            };
            //17)从业人员中当年新雇失业人员再就业人数不能大于从业人员中属于失业人员再就业人数
            if(unemEmps>unemOpers){
                layer.tips('从业人员中当年新雇失业人员再就业人数不能大于从业人员中属于失业人员再就业人数','#unemEmps',{tips:3, tipsMore:true, ltype:0});
                $("#unemEmps").focus();
                return flag==false;
            };

            //18)各类从业人员人数不能大于企业从业人员数
            var _total=(uniGradOpers+exSoldOpers+disOpers+unemOpers);
            if(_total>empNum){
                layer.tips('各类从业人员人数<font style="font-size: 14px;color: red">['+_total+']</font>不能大于企业从业人员数<font style="font-size: 14px;color: red">['+empNum+']</font>','#empNum',{tips:3, tipsMore:true, ltype:0});
                $("#empNum").focus();
                return flag==false;
            }
            /**************************私营企业 end***************************************/
        }else{
            /***************************非私营企业 start**********************************/
            if(disOpers>empNum){
                layer.tips('从业人员中属于残疾人雇工人数' +disOpers+'不能大于企业从业人员数 '+empNum,'#disOpers',{tips:3, tipsMore:true, ltype:0});
                $("#disOpers").focus();
                return flag==false;
            };
            /****************************非私营企业 end**********************************/

        }
        //19)企业应安置残疾人员数 ≥ 企业从业人员数的1.5%
        var entOugthSetDis = $("#entOugthSetDis").val()-0;
        if((empNum * 0.015) >= 1){
            if(entOugthSetDis < (empNum * 0.015)) {
                layer.tips('数据逻辑关系（应安置残疾人员数 ≥ 企业从业人员数的1.5%）错误！','#entOugthSetDis',{tips:3, tipsMore:true, ltype:0});
                $("#entOugthSetDis").focus();
                return flag==false;
            }
        }
        //20)企业已安置残疾人员数 ≤ 企业从业人员数
        var entSetDis = $("#entSetDis").val()-0;
        if(entSetDis>empNum){
            layer.tips('数据逻辑关系（已安置残疾人员数 ≤ 企业从业人员数）错误！','#entSetDis',{tips:3, tipsMore:true, ltype:0});
            $("#entSetDis").focus();
            return flag==false;
        }
        return flag;
    };


    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function () {
                //layer.close();
                alert("111");
            }
        }
        ])
    }

});