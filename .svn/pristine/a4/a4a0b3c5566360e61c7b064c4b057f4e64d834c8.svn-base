<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业查询列表页面</title>
    <link rel="stylesheet" href="/css/pub.css">
    <script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
    <script src="/js/pub/entinfo/des.js"></script>
    <script type="text/javascript">
    $(function(){
    	//初始化搜索框
		var keyWord ="${flag}".substring("${flag}".indexOf("KeyWord=")+8,"${flag}".indexOf("&current"));
		if(keyWord=="null"){
			keyWord="";
		}else{
			keyWord=strDec(keyWord,'a','b','c');
		}
		$(".se-box").val(keyWord);
	    /*
		全匹配
		$(".name").each(function(){
			var entName = $(this).text();
			var arry =new Array(i);
			if(keyWord!=null||keyWord!=""){
				//关键字特殊字符处理
				keyWord=keyWord.replace(/\s+/g, "");
				keyWord=keyWord.replace(/\<+/g, "");
				keyWord=keyWord.replace(/\>+/g, "");
				keyWord=keyWord.replace(/\&nbsp+/g, "");
				keyWord=keyWord.replace(/[\\\/]/g,"");
				keyWord=keyWord.replace(/\alert+/g,"");
				keyWord=keyWord.replace(/\light+/g,"");

			}

			var length=keyWord.length;
			for(var i=1;i<=length;i++ ){
				arry[i-1]=keyWord.substring(i-1,i);
				if(entName.indexOf(arry[i-1])>-1){
					entName = entName.split(arry[i-1]).join("<span class='light'>" +arry[i-1]+ "</span>");
				  $(this).html(entName);
				  };
			};
		});*/
    })

    </script>
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>

    <!-- 企业信用信息列表 -->
    <div class="mod enterprise-info">
    <c:if test="${entBasicInfos.totalPages>=50}">
        <h3 class="title">查询结果超过 <span class="light">50</span> 条信息，用时 ${took/1000 } 秒，请输入更精确的查询条件</h3>
    </c:if>
    <c:if test="${entBasicInfos.totalPages<50}">
        <h3 class="title">用时 ${took/1000 } 秒，查询到 <span class="light">${size }</span> 条信息</h3>
    </c:if>
        <ul class="enterprise-info-list">
        <c:if test="${not empty entBasicInfos}">
 		<c:forEach items="${entBasicInfos.content}" var="ppBasicInfo" varStatus="status">

            <li>
                <a href="selectByDocId?docId=${ppBasicInfo.encryPriPID}&classFlag=${classFlag}&pubType=2" target="_blank">
                <span>${ppBasicInfo.entName}</span>
                <i class="icon-rectangle  ${hx:publicStatusStyle(ppBasicInfo.regState)}">${hx:publicStatus(ppBasicInfo.regState)}</i>
                <span class="tip">
                <c:if test="${classFlag==2||ppBasicInfo.isOpanomaly==1 }">
                	<font color="red">( 该企业被列入经营异常名录 )</font>
                </c:if>
                <c:if test="${ppBasicInfo.isSimpleCancle==1 }">
                	<font color="red">( 该企业正在进行简易注销公告 )</font>
                </c:if>
                </span></a>
                <div class="item-text">
                    <span class="code"><i class="book-icon"></i>统一社会信用代码/注册号:
                    	<c:choose>
							<c:when test="${!empty ppBasicInfo.UNICODE}">
								${ppBasicInfo.UNICODE }
							</c:when>
							<c:otherwise>
							    ${ppBasicInfo.regNO }
							</c:otherwise>
						</c:choose>
                    </span>
                    <span class="person"><i class="person-icon"></i>
                    
                    <c:choose>
						<c:when test="${fn:indexOf('17,24,12,14,34,32,22,28', ppBasicInfo.entTypeCatg)!=-1}">
							负责人
						</c:when>
						<c:when test="${fn:indexOf('31', ppBasicInfo.entTypeCatg)!=-1}">
							投资人
						</c:when>
						<c:when test="${fn:indexOf('27,33', ppBasicInfo.entTypeCatg)!=-1}">
							执行事务合伙人
						</c:when>
						<c:when test="${fn:indexOf('50', ppBasicInfo.entTypeCatg)!=-1}">
							经营者
						</c:when>
						<c:otherwise>
						    法定代表人
						</c:otherwise>
					</c:choose>
                    
                    	：${ppBasicInfo.leRep}</span>
                    <span><i class="date-icon"></i>成立日期：${ppBasicInfo.estDateStr}</span>
                </div><br>
                <c:if test="${!empty ppBasicInfo.hisEntName}">
                <div class="item-text">
                	<span>历史名称：${ppBasicInfo.hisEntName}</span>
                </div>
                </c:if>
            </li>

      </c:forEach>
      </c:if>
        </ul>
   <!--class="current prev"  -->
    <div class="pagination-box">
        <div class="pagination">
        <c:if test="${entBasicInfos.totalPages>0}">
            <a href="${flag}0">首页</a>
            <c:if test="${entBasicInfos.number>0}">
            	<a href="${flag}${entBasicInfos.number-1 }"><i class="icon-triangle-left"></i>上一页</a>
           	</c:if>
           	<c:if test="${entBasicInfos.number<=0}">
            	<a class="current prev"><i class="icon-triangle-left"></i>上一页</a>
           	</c:if>
           	
            <a <c:if test="${entBasicInfos.number==0}">class="current"</c:if> href="${flag}0">1</a>
            
            <c:if test="${entBasicInfos.totalPages>1}">
            	<a <c:if test="${entBasicInfos.number==1}">class="current"</c:if> href="${flag}1">2</a>
            </c:if>
            <c:if test="${entBasicInfos.totalPages>2}">
            	<a <c:if test="${entBasicInfos.number==2}">class="current"</c:if> href="${flag}2">3</a>
            </c:if>
            <c:if test="${entBasicInfos.totalPages>3}">
            	<a <c:if test="${entBasicInfos.number==3}">class="current"</c:if> href="${flag}3">4</a>
            </c:if>
            <c:if test="${entBasicInfos.totalPages>4}">
            	<a <c:if test="${entBasicInfos.number==4}">class="current"</c:if> href="${flag}4">5</a>
            </c:if>
          
            <c:if test="${(entBasicInfos.number+1)<entBasicInfos.totalPages&&entBasicInfos.number<4 }">
            	<a href="${flag}${entBasicInfos.number+1 }" class="next">下一页<i class="icon-triangle-right"></i></a>
            </c:if>
            <c:if test="${entBasicInfos.number>=4||entBasicInfos.totalPages==1 }">
            	<a class="next current prev">下一页<i class="icon-triangle-right"></i></a>
            </c:if>
            
            <c:if test="${entBasicInfos.totalPages<=5 }">
	            <a href="${flag}${entBasicInfos.totalPages-1 }">末页</a>
            </c:if>
            <c:if test="${entBasicInfos.totalPages>5 }">
	            <a href="${flag}4">末页</a>
            </c:if>
         </c:if> 
         <c:if test="${entBasicInfos.totalPages<=0}">
				<p class="text-warning  h2">没有检索到结果，请输入更精确的查询条件</p>
		</c:if>  
    </div>
</div></div>
<!-- 底部信息 -->
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script type="text/javascript" src="http://fwtj.gsxt.gov.cn/js/logcollector.js?nodenum=330000"></script>
<!-- <script src="<c:url value="/js/pub/count/logcollector.js"/>"></script> -->
<script type="text/javascript">
window.onload = function() {
	var searchKeyWord = $(".se-box").val();
	var sessionId = '<%=request.getSession().getId()%>';
	sessionId_gsxt = sessionId; // 正常情况JS可以拿到sessionId,但经过测试发现有些web服务器，js拿不到sessionId，这种情况需要手动对sessionId进行赋值，如sessionId_gsxt=${sessionId}
	try{
		t1Collect_gsxt(); // 收集访问信息，每个页面都需要调用该方法
		searchKeywordCollect_gsxt(searchKeyWord); // 在用户点击搜索按钮时，页面需要执行该方法，并传入参数为搜索的关键词
    }catch(e){
    	
    }
}
</script>
</body>
</html>