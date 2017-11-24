<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>关注服务活动创建单</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css"> 
</head>
<body  class="pd10">
<div>
    <div class="print-nocard mb20">
        <h3>关注服务活动创建单</h3>
    </div>
    <div class="form-list">
    
    	<form id="activityForm">
	        <div class="form-item clearfix">
	            <label class="item-name col-3"><span style="color: red"> *</span>关注服务主题：</label>
	            <div class="col-8">
	                <div class="ipt-box">
	                    <input type="text" class="ipt-txt" name="theme" value="" >
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3 newline"><span style="color: red"> *</span>关注服务内容：<p class="light-gray">（包括目的，具体形式，具体内容，开展效果评价等）</p></label>
	            <div class="col-8">
	                <div class="ipt-box">
	                    <textarea rows="5" name="content" ></textarea>
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3"><span style="color: red"> *</span>关注服务对象：</label>
	            <div class="col-8">
	                <div class="ipt-box col-6">
	                	<input type="text" class="ipt-txt" style="width:59%" id="markName" name="markName" value="" readonly >
	                	<input type="hidden" id="markNo" name="markNo" value="" >
	                    <input type="button" class="btn btn-sm" id="selectmark" value="选择.." >
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3"><span style="color: red"> *</span>开展部门：</label>
	            <div class="col-8">
	                <div class="ipt-box">
	                	<input type="text" class="ipt-txt"  style="width:75%" id="lauDeptName" name="lauDeptName" value="" readonly >
	                	<input type="hidden" id="lauDeptCode" name="lauDeptCode" value="" >
	                    <input type="button" class="btn btn-sm" id="selectLauDept" value="选择.." >
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix">
	            <label class="item-name col-3"><span style="color: red"> *</span>开展关注服务日期：</label>
	            <div class="col-8">
	                <div class="ipt-box col-2">
	                    <input type="text" class="ipt-txt" readonly="readonly" id="dateBegin" name="dateBegin" onclick="laydate();">
	                </div>
	                <span class="item-txt col-1"><i class="line-icon"></i></span>
	                <div class="ipt-box col-2">
	                    <input type="text" class="ipt-txt" readonly="readonly" id="dateEnd" name="dateEnd" onclick="laydate();">
	                </div>
	                <div class="radio-box">
	                    <label class="ml20"><input type="checkbox" id="isLong" name="isLong" value="1">长期</label>
	                </div>
	            </div>
	        </div>
	        
	        <div class="form-item clearfix">
	            <label class="item-name col-3"><span style="color: red"> *</span>关注服务形式：</label>
	            <div class="col-8">
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr10">
	                            <label><input type="radio" name="actFormat" value="贷款授信" class="money" >贷款授信</label>
	                        </div>
	                        <div class="fl col-7">
								<div class="item-name mr10">
									金额
								</div>
								<div class="ipt-box col-7">
									<input type="text" class="ipt-txt" name="amount" disabled="disabled" onblur="check(this)" onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" >
								</div>
								<div class="item-name">
									&nbsp;万元
								</div>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr10">
	                            <label><input type="radio" name="actFormat" value="奖金奖励" class="money">奖金奖励</label>
	                        </div>

	                        <div class="col-7 fl">

	                            <div class="item-name mr10">
									金额
								</div>
								<div class="ipt-box col-7">
									<input type="text" class="ipt-txt" name="amount" disabled="disabled" onblur="check(this)" onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" >
								</div>
								<div class="item-name">
									&nbsp;万元
								</div>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr10">
	                            <label><input type="radio" name="actFormat" value="税费优惠" class="money" >税费优惠</label>
	                        </div>
	                        <div class="col-7 fl">
								<div class="item-name mr10">金额</div>
								<div class="ipt-box col-7">
									<input type="text" class="ipt-txt" name="amount" disabled="disabled" onblur="check(this)" onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" >
								</div>
								<div class="item-name">&nbsp;万元</div>
							</div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="培训讲座" >培训讲座</label>
	                        </div>
	                    </div>
	                </div>
	                <script>
			            function check(e) { 
			                var re = /^\d+(?=\.{0,1}\d+$|$)/ 
			                if (e.value != "") { 
			                    if (!re.test(e.value)) { 
			                        alert("请输入正确的数字"); 
			                        e.value = ""; 
			                        e.focus(); 
			                    } 
			                } 
			            }
		            </script>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="表彰评优" >表彰评优</label>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="补贴补助" >补贴补助</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="品牌培育" >品牌培育</label>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="回访走访" >回访走访</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="展销展会" >展销展会</label>
	                        </div>
	                    </div>
	                    <div class="col-6 mb10">
	                        <div class="radio-box fl mr40">
	                            <label><input type="radio" class="nomoney" name="actFormat" value="登记许可指导" >登记许可指导</label>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-12 clearfix">
	                    <div class="radio-box mr10 fl">
	                        <label><input type="radio" id="other" name="actFormat" value="其他" >其他</label>
	                    </div>
	                    <div class="ipt-box col-10">
	                        <input type="text" class="ipt-txt" id="otherAct" name="otherAct" value="" disabled="disabled" >
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="form-item clearfix mt40">
	            <div class="btn-box">
	                <input type="button" id="print" value="打印" class="btn mr20">
	                <input type="button" id="save" value="提交" class="btn mr20">
	                <input type="button" id="cancel" value="取消申请" class="btn">
	            </div>
	        </div>
	    </div>
    </form>
    
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
	$(function(){
		$(".money").click(function(){
			$("input[name='amount']").val("").attr("disabled","disabled");
			$("#otherAct").val("").attr("disabled","disabled");
			if($(this).is(':checked')){
				$(this).parent().parent().next().find("input").removeAttr("disabled");
			}else
				$(this).parent().parent().next().find("input").val("").attr("disabled","disabled");
		})
		$(".nomoney").click(function(){
			$("#otherAct").val("").attr("disabled","disabled");
			$("input[name='amount']").val("").attr("disabled","disabled");
		});
		$("#isLong").click(function(){
			if($(this).is(':checked')){
				$("#dateBegin").val("").attr("disabled","disabled");
				$("#dateEnd").val("").attr("disabled","disabled");
			}else{
				$("#dateBegin").removeAttr("disabled");
				$("#dateEnd").removeAttr("disabled");
			}
		});
		$("#other").click(function(){
			$("input[name='amount']").val("").attr("disabled","disabled");
			if($(this).is(':checked')){
				$("#otherAct").removeAttr("disabled");
			}
		});
	})
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/concern/activity/con_activity_add.js"></script>
</body>
</html>