<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/reg.server.css">
    <style type="text/css">
        .hide {
            display: none;
        }
    </style>
</head>
<body>
<div class="pd20 clearfix">
<h4 class="h4-title mt10">添加责令整改 ${midBaseInfo.entName}</h4>
 	<form id="orderreformsetform">
    <input type="hidden"    name="priPID" id="priPID" value="${midBaseInfo.priPID}">
    <input type="hidden"    name="regNo" value="${midBaseInfo.regNO}">
    <input type="hidden"    name="uniSCID" value="${midBaseInfo.uniCode}">
    <input type="hidden"    name="entName" value="${midBaseInfo.entName}"> 
    <input type="hidden"    name="entType" value="${midBaseInfo.entType}">
    <input type="hidden"    name="busSt" value="">
    <input type="hidden"    name="busStatusCN" value="">
    <input type="hidden"    name="industryCo" value="${midBaseInfo.industryCo}"> 
    <input type="hidden"    name="regOrg" value="${midBaseInfo.regOrg}">
    <input type="hidden"    name="localAdm" value="${midBaseInfo.localAdm}">
    <input type="hidden"    name="localAdmName" id="localAdmName" value="${midBaseInfo.localAdmName}">
    <input type="hidden"    name="regOrgName"  id="regOrgName" value="${midBaseInfo.regOrgName}"> 
    <input type="hidden"    name="leRep" value="${midBaseInfo.leRep}"> 
    <input type="hidden"    name="applyMan" value="${sysUser.realName}"> 
    <input type="hidden"    name="applyDate" value="${appDate}"> 
    <input type="hidden"    name="efftStatus" value="2"> 
    <input type="hidden"    name="auditState" value="0"> 
    <input type="hidden"    name="isAbort" value="0"> 
    <input type="hidden"    name="applyDate" value="${appDate}"> 
    <input type="hidden"    name="staDate" id="staDate" value=""> 
    <input type="hidden"    name="endDate" id="endDate" value=""> 
    <input type="hidden"    name="adminGuideDocType" id="adminGuideDocType" value=""> 
    <input type="hidden"    name="adminGuideType" id="adminGuideType" value=""> 
    <input type="hidden"    name="adminGuideCerContent" id="adminGuideCerContent" value="">
    <input type="hidden"    name="linkMan" id="linkMan" value="">
    <input type="hidden"    name="tel" id="tel" value=""> 
    <input type="hidden"    name="assignDate" id="assignDate" value=""> 
    <input type="hidden"    name="year"   value="${appYear}">
    </form>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right">统一信用代码/注册号</td>
            <td colspan="3">${empty midBaseInfo.uniCode ? midBaseInfo.regNO : midBaseInfo.uniCode}</td>
            <td class="bg-gray right">企业名称</td>
            <td colspan="3">${midBaseInfo.entName}</td>
        </tr>
        <tr>
            <td class="bg-gray right" width="12%">* 开始日期</td>
            <td width="15%">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt"    id="staDateTem" value="" readonly="readonly">
                </div>
            </td>
            <td class="bg-gray right" width="10%">* 结束日期</td>
            <td width="15%">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt"   id="endDateTem" value="" readonly="readonly">
                </div>
            </td>
            <td class="bg-gray right" width="10%">申请人</td>
            <td width="13%">${sysUser.realName}</td>
            <td class="bg-gray right" width="10%">申请日期</td>
            <td>${appDate}</td>
        </tr>
        <tr>
            <td class="bg-gray right">* 责令整改项目</td>
            <td colspan="3">
                <select id="adminGuideTypeTem" >
                  <option value="">请选择</option>
		          <option value="0">其他</option>
		          <option value="1">逾期出资</option>
		          <option value="2">法定代表人(高管)任职资格</option>
		          <option value="3">许可证到期、被吊销、被撤销</option>
		          <option value="4">经营期限到期</option>
		          <option value="5">登记事项变更或备案</option>
	            </select>
            </td>
            <td class="bg-gray right">* 其他送达方式</td>
            <td colspan="3"> 
            <div class="ipt-box col-12"> 
            <input type="checkbox" name="adminGuideDocTypeTem" value="1"  >通过公示系统提醒
            <input type="checkbox" name="adminGuideDocTypeTem" value="2"  >企信联连
            <input type="checkbox" name="adminGuideDocTypeTem" value="3"  >电子邮件
            <input type="checkbox" name="adminGuideDocTypeTem" value="4"  >短信
            </div> 
            </td>
        </tr>
        </tbody>
    </table>
    
    <!-- 其他 -->
    <div class="bg-gray pdt30lr50b30 mb20 ohter">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">经查，你企业因</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="" >
                </div>
                <div class="item-name3">行为，违反了</div>
                    <input type="hidden"  value=""  id="otherLawOne">
                    <span class="txt-bline pdlr" id="otherLawOneText"></span>
                    <span class="light"><a href="javascript:void(0);" class="otherLawOne">选择违法法律</a> </span>的规定，属于
                    <input type="hidden" class="ipt-txt3" value="" id="illegalone">
                    <span class="txt-bline pdlr" id="illegaloneText"></span>
                <span class="light"><a href="javascript:void(0);" class="illegalone">选择违法行为</a></span> ，根据中华人民共和国
              	<input type="hidden"  id="otherLawTwo">
                <span class="txt-bline pdlr" id="otherLawTwoText"></span>
                <span class="light"><a href="javascript:void(0);" class="otherLawTwo">选择依据法律</a></span>的规定，现责令你企业在 
                <select   id="chooseDayohter" >
                   <option value="">请选择</option>
                   <option value="3">三个月内</option>
                   <option value="60">六十日内</option>
                   <option value="30">三十日内</option>
                   <option value="15">十五日内</option>
                </select>
       			 改正上诉违法行为。责令改正具体事项如下：
                <input type="hidden"  value=""  id="orderreformse"/>
                <span class="txt-bline pdlr" id="orderreformseText"></span>
                <div class="item-name3"><span class="light"><a href="javascript:void(0);" class="orderreformsetree">选择责令整改事项</a></span>。</div>
            </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div> 
    
    <!--逾期出资  -->
    <div class="bg-gray pdt30lr50b30 mb20 outMoney hide">
        <div class="form-list2">
            <div class="form-item3">
                <input type="hidden" value="${empty midBaseInfo.regCap?'0':midBaseInfo.regCap}" >
                <input type="hidden"  value="${empty midBaseInfo.recCapRMB ?'0' :midBaseInfo.recCapRMB}" >
                <div class="item-name3 tindent24">你公司注册资本<span>${empty midBaseInfo.regCap?'0':midBaseInfo.regCap}</span>万元，截止目前实收资本
                 <span>${empty midBaseInfo.recCapRMB ?'0' :midBaseInfo.recCapRMB}</span>万元，根据公司章程和有关法律法规的规定，投资人（股东）应于
                </div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="" >
                </div>
                <div class="item-name3">前缴纳出资款</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="" >
                </div>
                <div class="item-name3">，（其中 </div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="">
                </div>
                )，现出资期限已届满但上述投资人(股东)未按规定足额出资，上述行为违反了
                                                  《中华人民共和国公司法》第二十八条第一款、第二百条;《中华人民共和国公司登记管理条例》第七十条的规定
                                                构成了公司股东未按期交付作为出资的货币行为。根据《中华人民共和国公司法》第二百条、《中华人民共和国公司登记管理条例》第七十条的规定，现
                                                责令你公司投资人(股东)改正，在 
				<div class="ipt-box3">
                    <select   id="chooseDayoutMoney">
                       <option value="">请选择</option>
                       <option value="3">三个月内</option>
                       <option value="60">六十日内</option>
                       <option value="30">三十日内</option>
                       <option value="15">十五日内</option>
                    </select>
                </div>足额交付出资，或者依法办理减少注册资本手续，或者依法办理清算注销手续。
            </div>
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div>
    
    <!-- 法定代表人任职资格 -->
    <div class="bg-gray pdt30lr50b30 mb20 legzg hide">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">经查，你企业法定代表人(高管)</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${midBaseInfo.leRep}">
                </div>
                <div class="item-name3">曾担任</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="">
                </div>
                <div class="item-name3">的法定代表人(高管)，该企业于</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="">
                </div>
                <div class="item-name3">被</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="">
                </div>
               	 ，根据《公司法》第一百四十七条、《企业法人法定
                                               代表人登记管理规定》第四条等相关法律法规的规定，
                <input type="hidden"  id="leReppunishOne">
                <span class="txt-bline pdlr" id="leReppunishOneText"></span>
                <span class="light"><a href="javascript:void(0);" class="leReppunishOne">选择法人处罚</a> </span>不得担任其他企业的法定代表人 
            	或高级管理人员等职务。 现根据《企业法人法定代表人登记管理规定第八条、第十二条的规定，责令你企业于
                <div class="ipt-box3">
                    <select   id="chooseDaylegzg">
                       <option value="">请选择</option>
                       <option value="3">三个月内</option>
                       <option value="60">六十日内</option>
                       <option value="30">三十日内</option>
                       <option value="15">十五日内</option>
                    </select>
                </div>
                                                   依法办理法定代表人(高管) 的变更登记。出现不符合任职资格情形又拒不履行变更登记义务的，  企业登记机关可以依法实施行政处罚，情节严重的，撤销企业登记，吊销企业法人营业执照。
                </div>
            </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div>
    
    <!-- 许可证到期、被吊销、被撤销 -->
   <div class="bg-gray pdt30lr50b30 mb20 licenseexpire hide">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">你企业经营范围中涉及的专项审批许可证:</div>
                <div class="item-name3 tindent24"></div>
                <div class="ipt-box3">
                    <input type="hidden"  value="" id="chooseLicenceOne">
                    <span class="txt-bline pdlr" id="chooseLicenceOneText"></span>
                </div>
                <a href="javascript:void(0);" class="chooseLicenceOne">选择许可证</a> 有效期已届满（/被许可部门撤销、吊销），
    			根据企业登记管理相关法律法规的规定，现责令你企业立即停止上述专项审批许可项目经营活动，在 
                <select   id="chooseDaylicenseexpire">
                   <option value="">请选择</option>
                   <option value="3">三个月内</option>
                   <option value="60">六十日内</option>
                   <option value="30">三十日内</option>
                   <option value="15">十五日内</option>
                </select> 
                                                  变更经营范围取消上述经营项目，或者依法重新申领有关专项审批许可证并到工商部门办理相
              	  关变更手续，或者依法办理企业注销手续 。拒不办理相关手续的，工商部门可以依法实施行政处罚，情节严重的， 可以撤销企业登记或吊销
                                                 企业法人营业执照。 未取得合法有效专项审批许可证擅自从事经营项目的，依照无证无照经营予以定性查处。
            </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div>
    
    <!-- 经营期限到期 -->
    <div class="bg-gray pdt30lr50b30 mb20 jyexpire hide">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">你企业章程规定的经营期限已于</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value=""  >
                </div>
                <div class="item-name3">届满，根据企业登记管理相关法律法规的规定，</div>
                <div class="item-name3">现责令你企业</div>
                <div class="ipt-box3">
                    <select   id="chooseDayjyexpire">
                       <option value="">请选择</option>
                       <option value="3">三个月内</option>
                       <option value="60">六十日内</option>
                       <option value="30">三十日内</option>
                       <option value="15">十五日内</option>
                    </select>
                </div>
                                               依法办理企业经营期限延期变更或注销手续。 拒不办理相关手续的，工商部门可以依法实施行政处罚。
             </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div>
    
    <!-- 登记事项变更或备案 -->
    <div class="bg-gray pdt30lr50b30 mb20 licensemod hide">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">你企业的登记事项已发生变动（
                    <input type="hidden"  value="" id="chooseregistrationOne">
                    <span class="txt-bline pdlr" id="chooseregistrationOneText"></span>
                <a href="javascript:void(0);" class="chooseregistrationOne">选择登记事项</a> ），与工商部门的核准登记内容不符。 
               	根据企业登记管理相关法律法规  的规定，现责令你企业于
	                    <select   id="chooseDaylicensemod">
	                       <option value="">请选择</option>
	                       <option value="3">三个月内</option>
	                       <option value="60">六十日内</option>
	                       <option value="30">三十日内</option>
	                       <option value="15">十五日内</option>
	                    </select>
                                               依法向工商部门申请办理相关的变更或备案手续。
                                               出现登记事项与实际情况不符合又拒不履行变更或备案登记义务的，工商部门将依法实施行政处罚。
            	</div> 
            </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div>

    <div class="center">
        <input type="submit" class="btn mr20" value="打 印" id="printorderreformset">
        <input type="submit" class="btn mr20" value="保 存" id="saveorderreformset">
        <input type="button" class="btn" value="取 消" id="cancel">
    </div>
</div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/orderreformset/orderreformsetapply_edit_main.js"/>"></script> 
<script>
    window._CONFIG = {
    		_adminGuideType:'${orderReformSet.adminGuideType}',
    		_uid:'${orderReformSet.uid}' ,
    		_encodeCorpid:'${encodeCorpid}'  //加密后的主体身份代码 
     } 
</script>
</body>
</html>