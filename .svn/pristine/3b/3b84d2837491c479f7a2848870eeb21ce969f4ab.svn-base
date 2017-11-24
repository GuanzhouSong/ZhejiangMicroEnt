<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>责令整改申请录入其他页</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
<style type="text/css">
.hide{
		display: none;
}
</style>
<style media="print" type="text/css">
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
object { display: none}
.Noprint{ display:none; }
.PageNext{ page-break-after: always; clear: both; width: 100%}
	</style>
<style type="text/css">
	.height40{
		height: 40px;
	}
</style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6，2，433，14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div class="pd20 clearfix">
    <h4 class="h4-title mt10"> 
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right">统一信用代码/注册号</td>
            <td colspan="3">${empty midBaseInfo.uniCode ? midBaseInfo.regNO : midBaseInfo.uniCode}</td>
            <td class="bg-gray right">企业名称</td>
            <td colspan="3">${midBaseInfo.entName}</td>
        </tr> 
        <tr>
            <td class="bg-gray right" width="12%">开始日期</td>
            <td width="15%">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" onclick="laydate()"   id="staDateTem" value="<fmt:formatDate value="${orderReformSet.staDate}" pattern="yyyy-MM-dd" /> ">
                </div>
            </td>
            <td class="bg-gray right" width="10%">结束日期</td>
            <td width="15%">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" onclick="laydate()"   id="endDateTem" value="<fmt:formatDate value="${orderReformSet.endDate}" pattern="yyyy-MM-dd" /> ">
                </div>
            </td>
            <td class="bg-gray right" width="10%">申请人</td>
            <td width="13%">${orderReformSet.applyMan}</td>
            <td class="bg-gray right" width="10%">申请日期</td>
            <td><fmt:formatDate value="${orderReformSet.applyDate}" pattern="yyyy-MM-dd" /></td>
        </tr>
        <c:if test="${orderReformSet.auditState=='2'}">
             <tr>
	            <td class="bg-gray right">审核结果</td>
	            <td colspan="3">
	                <div class="radio-box">
		               ${orderReformSet.auditState==1? '同意责令整改':'' }  
		               ${orderReformSet.auditState==2? '退回修改':'' }  
		               ${orderReformSet.auditState==3? '取消责令整改':'' }  
		           </div>
	            </td>
	            <td class="bg-gray right">审核人</td>
	            <td >${orderReformSet.auditName}</td> 
	            <td class="bg-gray right">审核日期</td> 
	            <td ><fmt:formatDate value="${orderReformSet.auditDate}" pattern="yyyy-MM-dd" /></td>
	        </tr>
	         <tr>
	            <td class="bg-gray right">审核意见</td>
	            <td colspan="9">
	                <div class="ipt-box col-12">
	                        <textarea   rows="2"  disabled="disabled"  >${orderReformSet.auditRemark}</textarea>
	                </div>
	            </td> 
	         </tr>
           </c:if>
           <c:if test="${orderReformSet.auditState=='3'}">
             <tr>
	            <td class="bg-gray right">审核结果</td>
	            <td colspan="3">
	                <div class="radio-box">
		               ${orderReformSet.auditState==1? '同意责令整改':'' }  
		               ${orderReformSet.auditState==2? '退回修改':'' }  
		               ${orderReformSet.auditState==3? '取消责令整改':'' }  
		           </div>
	            </td>
	            <td class="bg-gray right">审核人</td>
	            <td >${orderReformSet.auditName}</td> 
	            <td class="bg-gray right">审核日期</td> 
	            <td ><fmt:formatDate value="${orderReformSet.auditDate}" pattern="yyyy-MM-dd" /></td>
	        </tr>
	         <tr>
	            <td class="bg-gray right">审核意见</td>
	            <td colspan="9">
	                <div class="ipt-box col-12">
	                        <textarea   rows="2"  disabled="disabled"  >${orderReformSet.auditRemark}</textarea>
	                </div>
	            </td> 
	         </tr>
           </c:if>
          <tr>
            <td class="bg-gray right">责令整改项目</td>
            <td colspan="3">
            <input type="hidden" name="adminGuideTypeTem" id="adminGuideTypeTem" value=" ${orderReformSet.adminGuideType}" /> 
             ${orderReformSet.adminGuideType==0? '其他':'' }
             ${orderReformSet.adminGuideType==1? '逾期出资':'' }  
             ${orderReformSet.adminGuideType==2? '法定代表人(高管)任职资格':'' }  
             ${orderReformSet.adminGuideType==3? '许可证到期、被吊销、被撤销':'' }
             ${orderReformSet.adminGuideType==4? '经营期限到期':'' }
             ${orderReformSet.adminGuideType==5? '登记事项变更或备案':'' }
            </td>
            <td class="bg-gray right">其他送达方式</td>
            <td colspan="3"> 
            <div class="ipt-box col-12"> 
            <input type="checkbox" name="adminGuideDocTypeTem" value="1"   disabled="disabled">通过公示系统提醒
            <input type="checkbox" name="adminGuideDocTypeTem" value="2"   disabled="disabled">企信联连
            <input type="checkbox" name="adminGuideDocTypeTem" value="3"   disabled="disabled">电子邮件
            <input type="checkbox" name="adminGuideDocTypeTem" value="4"   disabled="disabled">短信
            </div> 
            </td>
        </tr>
        </tbody>
    </table> 
    
    <!-- 其他 -->
    <c:if test="${orderReformSet.adminGuideType=='0' }"> 
    <div class="bg-gray pdt30lr50b30 mb20 ohter">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">经查，你企业因</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid ?guideContentArr[0]:''}" >
                </div>
                <div class="item-name3">行为，违反了</div>
                <input type="hidden"  value="${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[1]:''}"   id="otherLawOne">
                <span class="txt-bline " id="otherLawOneText">${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[1]:''}</span>
                                                        的规定，属于
                <input type="hidden" value="${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[2]:''}" id="illegalone">
                <span class="txt-bline " id="illegaloneText">${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[2]:''}</span> 
                                                  ，根据中华人民共和国
              	<input type="hidden"  id="otherLawTwo" value="${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[3]:''}">
                <span class="txt-bline " id="otherLawTwoText">${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[3]:''}</span>
        		的规定，现责令你企业在 
                <select   id="chooseDayohter" >
                   <option value="">请选择</option>
                   <option value="3">三个月内</option>
                   <option value="60">六十日内</option>
                   <option value="30">三十日内</option>
                   <option value="15">十五日内</option>
                </select>
       			 改正上诉违法行为。责令改正具体事项如下：
                <input type="hidden"  value="${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[4]:''}"  id="orderreformse"/>
                <span class="txt-bline " id="orderreformseText">${orderReformSet.adminGuideType=='0' && not empty  orderReformSet.uid?guideContentArr[4]:''}</span>
               	。</span>
               </div>
            </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div> 
    </c:if>
    
    <!--逾期出资  -->
    <c:if test="${orderReformSet.adminGuideType=='1' }">
    <div class="bg-gray pdt30lr50b30 mb20 outMoney">
        <div class="form-list2">
            <div class="form-item3">
                <input type="hidden" value="${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[0]:''}" >
                <input type="hidden"  value="${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[1]:''}}" >
                <div class="item-name3 tindent24">你公司注册资本<span>${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[0]:''}</span>万元，截止目前实收资本
                 <span>${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[1]:''}</span>万元，根据公司章程和有关法律法规的规定，投资人（股东）应与
                </div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[2]:''}" >
                </div>
                <div class="item-name3">前缴纳出资款</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[3]:''}" >
                </div>
                <div class="item-name3">，（其中 </div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='1' && not empty  orderReformSet.uid ?guideContentArr[4]:''}">
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
    </c:if>
    
    <c:if test="${orderReformSet.adminGuideType=='2' }">
    <!-- 法定代表人任职资格 --> 
    <div class="bg-gray pdt30lr50b30 mb20 legzg">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">经查，你企业法定代表人(高管)</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='2' && not empty  orderReformSet.uid ?guideContentArr[0]:''}">
                </div>
                <div class="item-name3">曾担任</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='2' && not empty  orderReformSet.uid ?guideContentArr[1]:''}">
                </div>
                <div class="item-name3">的法定代表人(高管)，该企业于</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="">
                </div>
                <div class="item-name3">被</div>
                <div class="ipt-box3">
                    <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='2' && not empty  orderReformSet.uid ?guideContentArr[2]:''}">
                </div>
               	 ，根据《公司法》第一百四十七条、《企业法人法定
                                               代表人登记管理规定》第四条等相关法律法规的规定，
                <input type="hidden"  id="leReppunishOne" value="${orderReformSet.adminGuideType=='2' && not empty  orderReformSet.uid ?guideContentArr[4]:''}">
                <span class="txt-bline " id="leReppunishOneText">${orderReformSet.adminGuideType=='2' && not empty  orderReformSet.uid ?guideContentArr[4]:''}</span>
               	  不得担任其他企业的法定代表人 或高级管理人员等职务。 现根据《企业法人法定代表人登记管理规定第八条、第十二条的规定，责令你企业于
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
    </c:if>
    
    <!-- 许可证到期、被吊销、被撤销 -->
    <c:if test="${orderReformSet.adminGuideType=='3' }">
    <div class="bg-gray pdt30lr50b30 mb20 licenseexpire">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">你企业经营范围中涉及的专项审批许可证:</div>
                <div class="item-name3 tindent24"></div>
                <div class="ipt-box3">
                   <input type="hidden"   id="chooseLicenceOne" value="${orderReformSet.adminGuideType=='3' && not empty  orderReformSet.uid ?guideContentArr[0]:''}">
                   <span class="txt-bline " id="chooseLicenceOneText">${orderReformSet.adminGuideType=='3' && not empty  orderReformSet.uid ?guideContentArr[0]:''}</span>
               </div>
                                                 有效期已届满（/被许可部门撤销、吊销），
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
            </div> 
            <jsp:include page="orderreformsetbootom_edit.jsp"></jsp:include>
        </div>
    </div>
    </c:if>
    
    <!-- 经营期限到期 -->
    <c:if test="${orderReformSet.adminGuideType=='4' }"> 
    <div class="bg-gray pdt30lr50b30 mb20 jyexpire">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">你企业章程规定的经营期限已于</div>
                <div class="ipt-box3">
                     <input type="text" class="ipt-txt3" value="${orderReformSet.adminGuideType=='4' && not empty  orderReformSet.uid ?guideContentArr[0]:''}"  >
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
    </c:if>
    
    <!-- 登记事项变更或备案 -->
    <c:if test="${orderReformSet.adminGuideType=='5' }"> 
    <div class="bg-gray pdt30lr50b30 mb20 licensemod">
        <div class="form-list2">
            <div class="form-item3">
                <div class="item-name3 tindent24">你企业的登记事项已发生变动（
                 <input type="hidden"  value="${orderReformSet.adminGuideType=='5' && not empty  orderReformSet.uid ?guideContentArr[0]:''}" id="chooseregistrationOne">
                 <span class="txt-bline " id="chooseregistrationOneText">${orderReformSet.adminGuideType=='5' && not empty  orderReformSet.uid ?guideContentArr[0]:''}</span>
                                                   ），与工商部门的核准登记内容不符。 
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
    </c:if>
</div> 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/orderreformset/orderreformsetaudit_print_main.js"/>"></script> 
<script>
    window._CONFIG = {
    		_adminGuideType:'${orderReformSet.adminGuideType}',//整改项目 
    		_adminGuideDocType:'${orderReformSet.adminGuideDocType}',  //通知书送达方式
    		_chooseDay:'${chooseDay}' ,
    		_viewFlag:'${viewFlag}',
    		_uid:'${orderReformSet.uid}'
     } 
</script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>