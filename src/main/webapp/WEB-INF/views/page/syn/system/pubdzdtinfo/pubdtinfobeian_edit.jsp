<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


   <h4 class="h4-title" style="font-weight: bold;">营业执照基本信息</h4>
   <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tbody>
        <tr>
            <td class="bg-gray left" width="10%">企业名称</td>
            <td width="10%" colspan="5">${pubDtInfo.entName}</td> 
        </tr>
        <tr>
            <td class="bg-gray left" width="10%">住所/经营场所</td>
            <td width="10%" colspan="5">${pubDtInfo.dom}</td> 
        </tr>
        <tr>
            <td class="bg-gray left" width="10%">生产经营场所</td>
            <td width="10%" colspan="5">${midBaseInfo.proLoc}</td> 
        </tr>
        <tr>
            <td class="bg-gray left" width="10%">法定代表人/负责人姓名</td>
            <td width="10%" >${pubDtInfo.leRep}</td> 
            <td class="bg-gray left" width="10%" >身份证号码</td> 
            <td width="10%" >${midBaseInfo.cerNO}</td> 
            <td class="bg-gray left" width="10%" >手机</td> 
            <td width="10%" >${pubDtInfo.tel}</td> 
        </tr>
      	<tr>
            <td class="bg-gray left" width="10%">经营范围</td>
            <td width="10%" colspan="5">${pubDtInfo.opScope}</td> 
        </tr> 
        </tbody>
    </table><br>

    <c:if test="${not empty hzDzhyDxscyqyrdbaList}"> 
	    <h4 class="h4-title" style="font-weight: bold;">大学生创业企业认定备案</h4>
	    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <tr>
	            <td colspan="4" class="td-font-18">
	            大学生创业企业备案认定是指：在校大学生和毕业5年以内高校毕业生创办个私企业，本人是经营者或法定代表人、负责人的
	            ，经认定备案享受跟踪服务。大学生范围包括全日制普通高等学校专科以上毕业生，以及经学历认证的留学回国人员
	            ，技工院校的高级工班、预备技师（技师）班毕业生及在校生，特殊教育院校职业教育类毕业生及在校生。
	            </td>
	        </tr>
	        <c:forEach items="${hzDzhyDxscyqyrdbaList}" var="hzDzhyDxscyqyrdba"> 
	        <tr>
	            <td class="bg-gray left">大学生姓名</td>
	            <td>${hzDzhyDxscyqyrdba.name}</td>
	            <td class="bg-gray left">职务</td>
	            <td>
		          	 <c:if test="${not empty hzDzhyDxscyqyrdba.position }">
		          	    <c:set value="${ fn:split(hzDzhyDxscyqyrdba.position, ',') }" var="positions" />
		          	    <c:forEach items="${positions}" var="position">
						    <c:if test="${position=='01'}">
						             法定代表人
						    </c:if>
						    <c:if test="${position=='02'}">
						           投资人
						    </c:if>
						    <c:if test="${position=='03'}">
						          经营者
						    </c:if>
						</c:forEach>
		          	 </c:if>  
	            </td>
	        </tr>
	        <tr>
	            <td class="bg-gray left">毕业院校/就读院校</td>
	            <td>
	                 ${hzDzhyDxscyqyrdba.university}
	            </td>
	            <td class="bg-gray left">专业及学制</td>
	            <td>${hzDzhyDxscyqyrdba.major}、${hzDzhyDxscyqyrdba.eduSystem}</td>
	        </tr>
	        <tr>
	            <td class="bg-gray left">学历</td>
	            <td>
	               <c:if test="${hzDzhyDxscyqyrdba.diploma=='11'}">
						  博士研究生       
				   </c:if>
				   <c:if test="${hzDzhyDxscyqyrdba.diploma=='14'}">
						  硕士研究生
				   </c:if>
				   <c:if test="${hzDzhyDxscyqyrdba.diploma=='20'}">
						  大学本科    
				   </c:if>
				   <c:if test="${hzDzhyDxscyqyrdba.diploma=='30'}">
						  大学专科    
				   </c:if>
				   <c:if test="${hzDzhyDxscyqyrdba.diploma=='40'}">
						 技工和技师      
				   </c:if>
				   <c:if test="${hzDzhyDxscyqyrdba.diploma=='99'}">
						  在读    
				   </c:if> 
	            </td>
	            <td class="bg-gray left">毕业证书签发时间或预计毕业时间</td>
	            <td><fmt:formatDate value="${hzDzhyDxscyqyrdba.dipsignDate}" type="date" pattern="yyyy-MM-dd"/></td>
	        </tr> 
	        </c:forEach> 
	        </tbody>
	    </table><br>
    </c:if>
    
   <c:if test="${not empty hzDzhyCsyspjydwbaList}">
   <h4 class="h4-title" style="font-weight: bold;">从事艺术品经营单位备案</h4>
   <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tbody>
        <tr>
            <td colspan="4" class="td-font-18">
            根据《艺术品经营管理办法》，艺术品是指绘画作品、书法篆刻作品、雕塑雕刻作品、艺术摄影作品、
            装置艺术作品、工艺美术作品等及上述作品的有限复制品，但不包括文物。本单位经营艺术品符合上述规定的范围。
            </td>
        </tr>
        <c:forEach items="${hzDzhyCsyspjydwbaList}" var="hzDzhyCsyspjydwba">
        <tr>
            <td class="bg-gray left" width="10%">经营单位性质</td>
            <td width="40%" colspan="3">
             <c:if test="${not empty hzDzhyCsyspjydwba.jydwxz }">
          	    <c:set value="${ fn:split(hzDzhyCsyspjydwba.jydwxz, ',') }" var="jydwxzs" />
          	    <c:forEach items="${jydwxzs}" var="jydwxz">
				    <c:if test="${jydwxz=='11'}">
				            画廊
				    </c:if>
				    <c:if test="${jydwxz=='12'}">
				           画店
				    </c:if>
				    <c:if test="${jydwxz=='13'}">
				          租赁
				    </c:if>
				    <c:if test="${jydwxz=='14'}">
				          拍卖
				    </c:if>
				    <c:if test="${jydwxz=='15'}">
				          进出口经营
				    </c:if>
				    <c:if test="${jydwxz=='16'}">
				          鉴定
				    </c:if>
				     <c:if test="${jydwxz=='17'}">
				          评估
				    </c:if>
				    <c:if test="${jydwxz=='18'}">
				          商业性展览
				    </c:if>
				    <c:if test="${jydwxz=='19'}">
				         艺术品电商平台
				    </c:if>
				    <c:if test="${jydwxz=='20'}">
				         艺术品网络租赁平台
				    </c:if>
				    <c:if test="${jydwxz=='21'}">
				         以艺术品为标的物的投资经营活动及服务企业
				    </c:if>
				    
				    <c:if test="${jydwxz=='22'}">
				        艺术品基金
				    </c:if>
				    <c:if test="${jydwxz=='23'}">
				         艺术品信托
				    </c:if>
				    <c:if test="${jydwxz=='24'}">
				        艺术银行
				    </c:if>
				    <c:if test="${jydwxz=='25'}">
				         艺术品交易所
				    </c:if>
				    <c:if test="${jydwxz=='26'}">
				         其它
				    </c:if>
				</c:forEach>
          	 </c:if>
            </td> 
        </tr>
        <tr>
            <td class="bg-gray left" width="10%">艺术品类型</td>
            <td width="40%" colspan="3">
            <c:if test="${not empty hzDzhyCsyspjydwba.ysptype }">
          	    <c:set value="${ fn:split(hzDzhyCsyspjydwba.ysptype, ',') }" var="yspTypes" />
          	    <c:forEach items="${yspTypes}" var="yspType">
				    <c:if test="${yspType=='11'}">
				           绘画作品
				    </c:if>
				    <c:if test="${yspType=='12'}">
				          书法篆刻作品
				    </c:if>
				    <c:if test="${yspType=='13'}">
				          雕塑雕刻作品
				    </c:if>
				    <c:if test="${yspType=='14'}">
				          艺术摄影作品
				    </c:if>
				    <c:if test="${yspType=='15'}">
				          装置艺术作品
				    </c:if>
				    <c:if test="${yspType=='16'}">
				          工艺美术作品
				    </c:if>
				     <c:if test="${yspType=='17'}">
				          上述作品的有限复制品
				    </c:if>
				</c:forEach>
          	 </c:if> 
            </td> 
        </tr>
        <tr>
            <td class="bg-gray left">具体经营品种</td>
            <td width="40%" colspan="3">
            <c:if test="${not empty hzDzhyCsyspjydwba.jypz }">
          	    <c:set value="${ fn:split(hzDzhyCsyspjydwba.jypz, ',') }" var="jypzs" />
          	    <c:forEach items="${jypzs}" var="jypz">
				    <c:if test="${jypz=='01'}">
				          行为艺术
				    </c:if>
				    <c:if test="${jypz=='02'}">
				          雕塑雕刻
				    </c:if>
				    <c:if test="${jypz=='03'}">
				          装置艺术
				    </c:if>
				    <c:if test="${jypz=='04'}">
				          摄影
				    </c:if>
				    <c:if test="${jypz=='05'}">
				          工艺美术设计
				    </c:if>
				    <c:if test="${jypz=='06'}">
				          观念艺术
				    </c:if>
				    <c:if test="${jypz=='07'}">
				          书法篆刻
				    </c:if>
				    <c:if test="${jypz=='08'}">
				          授权衍生
				    </c:if>
				    <c:if test="${jypz=='09'}">
				        绘画
				    </c:if>
				    <c:if test="${jypz=='10'}">
				        影像新媒体
				    </c:if>
				    
				</c:forEach>
          	 </c:if> 
            </td>
        </tr>
        <tr>
            <td class="bg-gray left" width="10%">实际经营场所面积</td>
           	<td width="40%" colspan="3">${hzDzhyCsyspjydwba.jymj} （平方米）
            </td>
        </tr> 
        </c:forEach>
        </tbody>
    </table><br>
   </c:if>
   
   <c:if test="${not empty hzDzhyFdcjjjgbaList }">
   <h4 class="h4-title" style="font-weight: bold;">房地产经纪机构及其分支机构备案</h4>
   <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tbody>
        <tr>
            <td class="left" width="10%">经纪人姓名</td>
            <td width="10%" >身份证号</td> 
            <td width="10%" >资格证名称</td> 
            <td width="10%" >资格证发证单位</td> 
            <td width="10%" >资格证号</td> 
            <td width="10%" >电话</td> 
        </tr>
        <c:forEach items="${hzDzhyFdcjjjgbaList}" var="hzDzhyFdcjjjgba">
        <tr>
            <td class="left" width="10%">${hzDzhyFdcjjjgba.name }</td>
            <td width="10%" >${hzDzhyFdcjjjgba.cerNo }</td> 
            <td width="10%" >${hzDzhyFdcjjjgba.qualificationName }</td> 
            <td width="10%" >${hzDzhyFdcjjjgba.zwgfzdw }</td> 
            <td width="10%" >${hzDzhyFdcjjjgba.qualificationNo }</td> 
            <td width="10%" >${hzDzhyFdcjjjgba.tel }</td> 
        </tr>
        </c:forEach> 
       <tr>
            <td colspan="6" class="td-font-18">
           我分公司已具备《房地产经纪管理办法》和《浙江省社会中介机构管理办法》规定的条件，
           并有健全的职业规则以及质量管理、档案管理、财务管理等制度，并承诺按上述管理制度从事经营活动。
            </td>
        </tr>
        </tbody>
    </table><br>
   </c:if>
   
    <c:if test="${not empty hzDzhyZfgjjjcdjList }"> 
    <h4 class="h4-title" style="font-weight: bold;">住房公积金缴存登记</h4>
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <c:forEach items="${hzDzhyZfgjjjcdjList}" var="hzDzhyZfgjjjcdj">
	        <tr>
	            <td class="bg-gray left" width="10%">公积金业务经办人姓名</td>
	            <td width="10%" >${hzDzhyZfgjjjcdj.jbr }</td> 
	            <td class="bg-gray left" width="10%" >身份证号码</td> 
	            <td width="10%" >${hzDzhyZfgjjjcdj.cerNo }</td> 
	            <td class="bg-gray left" width="10%" >手机号码</td> 
	            <td width="10%" >${hzDzhyZfgjjjcdj.mobtel }</td> 
	        </tr> 
	        </c:forEach>
	       	<tr>
	            <td colspan="6" class="td-font-18">
	           注：住房公积金缴存登记“多证合一”办理完成后，在首次办理住房公积金业务时，
	           还需要办理银行托收方式、缴纳公积金职工人员的情况的相关手续。
	            </td>
	        </tr>
	        </tbody>
	  </table><br>
	  </c:if>
	  
	  <c:if test="${not empty hzDzhyBagsslfgsbaList }">
	  <c:forEach items="${hzDzhyBagsslfgsbaList}" var="hzDzhyBagsslfgsba">
	  <h4 class="h4-title" style="font-weight: bold;">保安服务公司设立分公司备案</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <tr>
	            <td class="bg-gray left" width="10%" >总公司保安服务许可证发证机关</td>
	            <td width="10%" colspan="3">${hzDzhyBagsslfgsba.xkfzjg }</td> 
	            <td class="bg-gray left" width="10%" >编号</td> 
	            <td width="10%" >${hzDzhyBagsslfgsba.xkfzjgNo }</td> 
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" >拟开展的保安服务项目</td>
	            <td width="10%" colspan="5">
	            <c:if test="${not empty hzDzhyBagsslfgsba.bafwxm }">
          	    <c:set value="${ fn:split(hzDzhyBagsslfgsba.bafwxm, ',') }" var="bafwxms" />
          	    <c:forEach items="${bafwxms}" var="bafwxm">
				    <c:if test="${bafwxm=='01'}">
				           门卫
				    </c:if>
				    <c:if test="${bafwxm=='02'}">
				         巡逻
				    </c:if>
				    <c:if test="${bafwxm=='03'}">
				          守护
				    </c:if>
				    <c:if test="${bafwxm=='04'}">
				        武装押运
				    </c:if>
				    <c:if test="${bafwxm=='05'}">
				        一般押运
				    </c:if>
				    <c:if test="${bafwxm=='06'}">
				          随身护卫
				    </c:if>
				    <c:if test="${bafwxm=='07'}">
				          安全检查
				    </c:if>
				    <c:if test="${bafwxm=='08'}">
				          安全技术防范
				    </c:if>
				    <c:if test="${bafwxm=='09'}">
				          安全风险评估
				    </c:if>
				</c:forEach>
          	 	</c:if> 
	            </td>
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" >保卫工作联系人</td>
	            <td width="10%" colspan="2">${hzDzhyBagsslfgsba.bwName }</td>
	            <td class="bg-gray left" width="10%" >保卫工作联系人电话</td>
	            <td width="10%" colspan="2">${hzDzhyBagsslfgsba.baMobtel }</td>
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" rowspan="${empty hzDzhyBafzrgzqkList?'4':fn:length(hzDzhyBafzrgzqkList)+3 }">负责人姓名</td>
	            <td width="10%" rowspan="${empty hzDzhyBafzrgzqkList?'4':fn:length(hzDzhyBafzrgzqkList)+3 }">${hzDzhyBagsslfgsba.fzrName }</td> 
	            <td class="bg-gray left" width="10%" >毕业院校</td> 
	            <td width="10%" >${hzDzhyBagsslfgsba.fzredu }</td> 
	            <td class="bg-gray left" width="10%" >学历</td> 
	            <td width="10%" >
	               <c:if test="${hzDzhyBagsslfgsba.fzrxl=='10'}">
						  研究生       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='20'}">
						  大学本科
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='30'}">
						  大学专科   
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='40'}">
						  中等专业学校 
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='50'}">
						  技工学校       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='60'}">
						   高中     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='70'}">
						   初中      
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='80'}">
						   小学     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='90'}">
						   文盲或半文盲     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='99'}">
						  其他
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='8'}">
						  博士
				   </c:if>
	            </td> 
	        </tr>
	        <tr> 
	            <td class="center" width="10%" colspan="4">安保工作经验情况</td>
	        </tr> 
	        <tr> 
	            <td class="left" width="10%" colspan="2">时间</td> 
	            <td width="10%" >岗位</td> 
	            <td width="10%" >单位名称</td>
	        </tr>
	        <c:if test="${empty  hzDzhyBafzrgzqkList}">
	         <tr> 
	            <td class="left" width="10%" colspan="2"></td> 
	            <td width="10%" ></td> 
	            <td width="10%" ></td>
	       	 </tr>
	        </c:if>
	        <c:if test="${not empty  hzDzhyBafzrgzqkList}">
	         <c:forEach items="${hzDzhyBafzrgzqkList}" var="hzDzhyBafzrgzqk">
	         <tr> 
	            <td class="left" width="10%" colspan="2">
	            <fmt:formatDate value="${hzDzhyBafzrgzqk.gzrqq}" type="date" pattern="yyyy年MM月"/>
	            -
	            <fmt:formatDate value="${hzDzhyBafzrgzqk.gzrqz}" type="date" pattern="yyyy年MM月"/>
	            </td> 
	            <td width="10%" >${hzDzhyBafzrgzqk.gw}</td> 
	            <td width="10%" >${hzDzhyBafzrgzqk.entName}</td>
	       	 </tr> 
	       	 </c:forEach>
	        </c:if> 
	        <tr> 
	            <td class="left" width="10%" colspan="6">以下项目为外省保安公司填写：</td> 
	        </tr> 
	        <tr>
	            <td class="bg-gray left" width="10%" >总公司注册资本</td>
	            <td width="10%" colspan="3">${hzDzhyBagsslfgsba.regcap }${hzDzhyBagsslfgsba.currencyName}</td> 
	            <td class="bg-gray left" width="10%" >营业执照发证机关</td> 
	            <td width="10%" >${hzDzhyBagsslfgsba.zzfzjg }</td> 
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" >总公司地址</td>
	            <td width="10%" colspan="3">${hzDzhyBagsslfgsba.dom }</td> 
	            <td class="bg-gray left" width="10%" >营业场所面积</td> 
	            <td width="10%" >${hzDzhyBagsslfgsba.jymj }（平方米）</td> 
	        </tr>
	        <tr> 
	            <td class="center" width="10%" colspan="6">总公司人员情况</td> 
	        </tr> 
	        <tr>
	            <td class="center" width="10%" colspan="2">职务</td>
	            <td class="center" width="10%" >姓名</td> 
	            <td class="center" width="10%" >身份证号码</td> 
	            <td class="center" width="10%" >毕业院校</td> 
	            <td class="center" width="10%" >学历</td> 
	        </tr>
	        <tr>
	            <td class="center" width="10%" colspan="2">法定代表人</td>
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.fddbrName }</td> 
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.fddbrCerno }</td> 
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.fddbrEdu }</td> 
	            <td class="center" width="10%" >
	           	   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='10'}">
						  研究生       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='20'}">
						  大学本科
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='30'}">
						  大学专科     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='40'}">
						  中等专业学校    
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='50'}">
						  技工学校       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='60'}">
						   高中     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzrxl=='70'}">
						   初中      
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='80'}">
						   小学     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='90'}">
						   文盲或半文盲     
				  </c:if>
				  <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='99'}">
						   其他   
				  </c:if>
				  <c:if test="${hzDzhyBagsslfgsba.fddbrXl=='8'}">
						   博士  
				  </c:if>
	            </td> 
	        </tr>
	        <tr>
	            <td class="center" width="10%" colspan="2">总经理</td>
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.zjlName }</td> 
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.zjlcerNo }</td> 
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.zjledu }</td> 
	            <td class="center" width="10%" >
	               <c:if test="${hzDzhyBagsslfgsba.zjlxl=='10'}">
						  研究生       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='20'}">
						  大学本科
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='30'}">
						  大学专科   
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='40'}">
						  中等专业学校  
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='50'}">
						  技工学校       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='60'}">
						   高中     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='70'}">
						   初中      
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='80'}">
						   小学     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.zjlxl=='90'}">
						   文盲或半文盲     
				  </c:if>
				  <c:if test="${hzDzhyBagsslfgsba.zjlxl=='99'}">
						  其他
				  </c:if>
				  <c:if test="${hzDzhyBagsslfgsba.zjlxl=='8'}">
						   博士
				  </c:if>
	            </td> 
	        </tr>
	        <tr>
	            <td class="center" width="10%" colspan="2">副总经理</td>
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.fzjlName }</td> 
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.fzjlcerNo }</td> 
	            <td class="center" width="10%" >${hzDzhyBagsslfgsba.fzjledu }</td> 
	            <td class="center" width="10%" >
	               <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='10'}">
						  研究生       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='20'}">
						  大学本科
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='30'}">
						  大学专科
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='40'}">
						  中等专业学校 
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='50'}">
						  技工学校       
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='60'}">
						   高中     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='70'}">
						   初中      
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='80'}">
						   小学     
				   </c:if>
				   <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='90'}">
						   文盲或半文盲     
				  </c:if>
				  <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='99'}">
						   其他
				  </c:if>
				  <c:if test="${hzDzhyBagsslfgsba.fzjlxl=='8'}">
						  博士
				  </c:if>
	            </td> 
	        </tr>
	        <tr>
	            <td class="center" width="10%" colspan="2"></td>
	            <td class="center" width="10%" ></td> 
	            <td class="center" width="10%" ></td> 
	            <td class="center" width="10%" ></td> 
	            <td class="center" width="10%" ></td> 
	        </tr>
	       	<tr>
	            <td colspan="6" class="td-font-18">
	           本保安服务公司承诺：<br>
		分公司成立后即安装浙江省保安服务监管信息系统，并及时通过系统报备保安员信息。
	            </td>
	        </tr>
	        </tbody>
	  </table><br>
	  </c:forEach>
	  </c:if>
	  
	  <c:if test="${not empty hzDzhyZszyhsjyzbaList }">
	  <c:forEach items="${hzDzhyZszyhsjyzbaList}" var="hzDzhyZszyhsjyzba">
	  <h4 class="h4-title" style="font-weight: bold;">再生资源回收经营者备案</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <tr>
	            <td class="bg-gray left" width="10%" >再生资源回收范围</td>
	            <td width="10%" colspan="5">
	            <c:if test="${not empty hzDzhyZszyhsjyzba.hsfw }">
          	    <c:set value="${ fn:split(hzDzhyZszyhsjyzba.hsfw, ',') }" var="hsfws" />
          	    <c:forEach items="${hsfws}" var="hsfw">
				    <c:if test="${hsfw=='01'}">
				         废旧金属
				    </c:if>
				    <c:if test="${hsfw=='02'}">
				       废旧塑料
				    </c:if>
				    <c:if test="${hsfw=='03'}">
				       废旧纸张
				    </c:if>
				    <c:if test="${hsfw=='04'}">
				       废旧电器及电子产品
				    </c:if>
				    <c:if test="${bafwxm=='99'}">
				       其他废旧物品
				    </c:if>
				</c:forEach>
          	 	</c:if> 
	            </td> 
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" >再生资源回收渠道</td>
	            <td width="10%" colspan="5"> 
	            <c:if test="${not empty hzDzhyZszyhsjyzba.hsqd }">
          	    <c:set value="${ fn:split(hzDzhyZszyhsjyzba.hsqd, ',') }" var="hsqds" />
          	    <c:forEach items="${hsqds}" var="hsqd">
				    <c:if test="${hsqd=='01'}">
				         居民区零散回收
				    </c:if>
				    <c:if test="${hsqd=='02'}">
				       企业定点回收
				    </c:if>
				    <c:if test="${bafwxm=='99'}">
				       其他回收方式
				    </c:if>
				</c:forEach>
          	 	</c:if> 
	            </td> 
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" >回收网点地址</td>
	            <td width="10%" colspan="5">
	              1、${hzDzhyZszyhsjyzba.hswdshi1} ${hzDzhyZszyhsjyzba.hswdxian1 }
	              ${hzDzhyZszyhsjyzba.hswdroad1} ${hzDzhyZszyhsjyzba.hswdhao1 }<br>
	              
	              2、${hzDzhyZszyhsjyzba.hswdshi2} ${hzDzhyZszyhsjyzba.hswdxian2 }
	              ${hzDzhyZszyhsjyzba.hswdroad2} ${hzDzhyZszyhsjyzba.hswdhao2 }<br> 
	              
	              3、${hzDzhyZszyhsjyzba.hswdshi3} ${hzDzhyZszyhsjyzba.hswdxian3 }
	              ${hzDzhyZszyhsjyzba.hswdroad3} ${hzDzhyZszyhsjyzba.hswdhao3 }<br>
	            </td> 
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" rowspan="${empty hzDzhyHscyryList?'6':fn:length(hzDzhyHscyryList)+5 }">废旧金属回收填写</td>
	            <td width="10%" class="bg-gray left" >类型</td>
	            <td width="10%" colspan="4">
	            <c:if test="${not empty hzDzhyZszyhsjyzba.hsType }">
          	    <c:set value="${ fn:split(hzDzhyZszyhsjyzba.hsType, ',') }" var="hsTypes" />
          	    <c:forEach items="${hsTypes}" var="hsType">
				    <c:if test="${hsType=='1'}">
				       回收生产性废旧金属的再生资源回收企业
				    </c:if>
				    <c:if test="${hsType=='2'}">
				      回收非生产性废旧金属的再生资源回收经营者
				    </c:if>
				</c:forEach>
          	 	</c:if>
                </td>
	        </tr>
	        <tr> 
	            <td class="bg-gray left" width="10%" >监控设施情况</td> 
	            <td width="10%" colspan="4">
		                        安装监控探头数： ${hzDzhyZszyhsjyzba.jkNum}个；<br>
				安装监控探头的重点部位：  ${hzDzhyZszyhsjyzba.zdbw1} 、  ${hzDzhyZszyhsjyzba.zdbw2} 、${hzDzhyZszyhsjyzba.zdbw3}、  ${hzDzhyZszyhsjyzba.zdbw4}、${hzDzhyZszyhsjyzba.zdbw5}。<br>
				监控录像是否保存30天以上：${hzDzhyZszyhsjyzba.isSave=='1'?'是':'否'}
                </td>
	        </tr>
	        <tr> 
	         	<td class="bg-gray left" width="10%" rowspan="2">治安责任人</td> 
	          	<td width="10%">姓名</td>
	            <td width="10%">身份证件号码</td>
	            <td width="10%">现住址</td>
	            <td width="10%">联系电话</td>
	        </tr>
	        <tr> 
	          	<td width="10%">${hzDzhyZszyhsjyzba.name}</td>
	            <td width="10%">${hzDzhyZszyhsjyzba.cerNo}</td>
	            <td width="10%">${hzDzhyZszyhsjyzba.dom}</td>
	            <td width="10%">${hzDzhyZszyhsjyzba.mobtel}</td>
	        </tr>
	        <tr> 
	         	<td class="bg-gray left" width="10%" rowspan="${empty hzDzhyHscyryList?'2':fn:length(hzDzhyHscyryList)+1 }">从业人员情况</td> 
	          	<td width="10%">姓名</td>
	            <td width="10%">身份证件号码</td>
	            <td width="10%">联系方式</td>
	            <td width="10%">职务</td>
	        </tr>
	        <c:if test="${not empty hzDzhyHscyryList}">
	            <c:forEach items="${hzDzhyHscyryList}" var="hzDzhyHscyry">
	            <tr> 
	          	<td width="10%">${hzDzhyHscyry.name}</td>
	            <td width="10%">${hzDzhyHscyry.cerNo}</td>
	            <td width="10%">${hzDzhyHscyry.mobtel}</td>
	            <td width="10%">${hzDzhyHscyry.position}</td>
	            </tr>
	            </c:forEach>
	        </c:if>
	      	<c:if test="${empty hzDzhyHscyryList}">
	      	<tr> 
	          	<td width="10%"></td>
	            <td width="10%"></td>
	            <td width="10%"></td>
	            <td width="10%"></td>
	        </tr>
	      	</c:if> 
	      	<tr>
	            <td colspan="6" class="td-font-18">
	       		   本再生资源回收经营者承诺：<br>
				一、遵守商务部《再生资源回收管理办法》及其他相关法律法规接受监督检查和管理。<br>
				二、本栏中所填写的信息是完整、准确、真实合法的。<br>
				三、以上承诺是本申请人真实意愿，如有违反，愿意承担一切法律责任。　
	            </td>
	        </tr>
	        </tbody>
	  </table><br>
	  </c:forEach>
	  </c:if>
	   
	  <c:if test="${not empty hzDzhyLxsfsfwwdbaList }">
	  <h4 class="h4-title" style="font-weight: bold;">旅行社分社/服务网点备案</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody> 
	        <c:forEach items="${hzDzhyLxsfsfwwdbaList}" var="hzDzhyLxsfsfwwdba">
	        <tr>
	            <td class="bg-gray left" width="10%" >机构类型</td>
	            <td width="10%" colspan="5"> 
	            <c:if test="${not empty hzDzhyLxsfsfwwdba.jglx }">
          	    <c:set value="${ fn:split(hzDzhyLxsfsfwwdba.jglx, ',') }" var="jglxs" />
          	    <c:forEach items="${jglxs}" var="jglx">
				    <c:if test="${jglx=='01'}">
				      分社
				    </c:if>
				    <c:if test="${jglx=='02'}">
				     服务网点
				    </c:if>
				</c:forEach>
          	 	</c:if>
	            </td> 
	        </tr>
	        <tr>
	            <td class="bg-gray left" width="10%" >增存质量保证金</td>
	            <td width="10%" colspan="5">
	           	 我企业已于    
	           	 <fmt:formatDate value="${hzDzhyLxsfsfwwdba.addDate}" type="date" pattern="yyyy年MM月dd日"/>
	           	  将增存${hzDzhyLxsfsfwwdba.addje}万${hzDzhyLxsfsfwwdba.currencyName }质量保证金打入${ hzDzhyLxsfsfwwdba.zykhyh}银行${ hzDzhyLxsfsfwwdba.zykhyhzh}账户。（服务网点免填）
	            </td> 
	        </tr>
	        </c:forEach>
	        </tbody>
	  </table><br>
	  </c:if>
	  
	  <c:if test="${not empty hzDzhyCbdlfwjyzbaList }">
	  <h4 class="h4-title" style="font-weight: bold;">船舶代理、水路运输代理业务经营备案</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <c:forEach items="${hzDzhyCbdlfwjyzbaList}" var="hzDzhyCbdlfwjyzba">
	        <tr>
	            <td class="bg-gray left" width="10%" >经营类型</td>
	            <td width="10%" colspan="5">
	          	<c:if test="${not empty hzDzhyCbdlfwjyzba.jyzlx }">
          	    <c:set value="${ fn:split(hzDzhyCbdlfwjyzba.jyzlx, ',') }" var="jyzlxs" />
          	    <c:forEach items="${jyzlxs}" var="jyzlx">
				    <c:if test="${jyzlx=='01'}">
				     国内船舶代理
				    </c:if>
				    <c:if test="${jyzlx=='02'}">
				     国内水路货物运输代理
				    </c:if>
				    <c:if test="${jyzlx=='03'}">
				    国内水路旅客运输代理
				    </c:if>
				    <%-- <c:if test="${jyzlx=='04'}">
				    船舶经纪
				    </c:if> --%>
				</c:forEach>
          	 	</c:if>
	            </td> 
	        </tr>
	        </c:forEach>
	        </tbody>
	  </table><br>
	  </c:if>
	  
	  <c:if test="${not empty hzDzhyDlkyjyzslfgsbaList }">
	  <h4 class="h4-title" style="font-weight: bold;">道路客运经营者设立分公司报备</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <c:forEach items="${hzDzhyDlkyjyzslfgsbaList}" var="hzDzhyDlkyjyzslfgsba">
	        <tr>
	            <td class="bg-gray left" width="10%" >总公司道路运输许可证发证机关</td>
	            <td width="10%">${hzDzhyDlkyjyzslfgsba.dlxkzfzjg }</td>
	            <td class="bg-gray left" width="10%" >编号 </td> 
	            <td width="10%">${hzDzhyDlkyjyzslfgsba.licNo }</td>
	        </tr>
	        </c:forEach>
	        <tr> 
	            <td width="10%" colspan="4">我分公司已具备《道路货物运输及站场管理规定》所要求的安全生产等管理制度，并承诺按上述管理制度从事经营活动。</td> 
	        </tr>
	        </tbody>
	  </table><br>
	  </c:if>
	   
	  <c:if test="${not empty hzDzhyDlhwjyzslfgsbaList }">
	  <h4 class="h4-title" style="font-weight: bold;">道路货物运输经营者设立分公司报备</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <c:forEach items="${hzDzhyDlhwjyzslfgsbaList}" var="hzDzhyDlhwjyzslfgsba">
	        <tr>
	            <td class="bg-gray left" width="10%" >总公司道路运输许可证发证机关</td>
	            <td width="10%">${hzDzhyDlhwjyzslfgsba.dlxkzfzjg}</td>
	            <td class="bg-gray left" width="10%" >编号 </td> 
	            <td width="10%">${hzDzhyDlhwjyzslfgsba.licNo}</td>
	        </tr>
	        </c:forEach>
	        <tr> 
	            <td width="10%" colspan="4">我分公司已具备《道路货物运输及站场管理规定》所要求的安全生产等管理制度，并承诺按上述管理制度从事经营活动。</td> 
	        </tr>
	        </tbody>
	  </table><br>
	  </c:if>
	   
<!-- 	  <h4 class="h4-title" style="font-weight: bold;">其他信息</h4>
	  <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
	        <tbody>
	        <tr>
	            <td class="bg-gray left" width="10%" rowspan="3">减少多证合一事项</td>
	            <td width="10%" colspan="2">
	          	 原因：□经营范围减少  □投资人转让  □其他  。
	            </td> 
	        </tr>
	        <tr>
	            <td width="10%">
	          	     减少事项：□大学生创业企业认定备案  □从事艺术品经营单位备案  □房地产经纪机构及其分支机构备案
	          	  □保安服务公司设立分公司备案  □再生资源回收经营者备案    □旅行社分社/服务网点备案 
	          	  □船舶代理、水路运输代理业务经营备案    □道路客运经营者设立分公司报备□道路货物运输经营者设立分公司报备 
	            </td> 
	        </tr>
	        <tr>
	            <td width="10%">
	          	是否已申领相关证照：□是  □否
	            </td> 
	        </tr>
	        </tbody>
	  </table><br>  -->

 