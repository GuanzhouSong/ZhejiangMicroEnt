<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>详细信息</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<style type="text/css">
.gold{background-color: #fff4df;}
</style>
<body class="pd10">
<form id="hx-form">
    <input type="hidden" id="priPID" name="priPID" value="${dto.priPID}">
    <input type="hidden" name="priPIDs" value="${dto.priPID}">
    <input type="hidden" id="markCodes" name="markCodes">
    <input type="hidden" id="markNames" name="markNames">

<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
            <span class="name fl mr5">${dto.entName}</span>
            <span class="${hx:yReportStyle(dto.regState)}">${hx:publicStatus(dto.regState)}</span>
            <c:if test="${dto.isIndivid=='1'}"> 
             <span class="icon-rectangle blue fl mr10">个转企</span>
            </c:if>
            <c:if test="${isOpanomaly=='1'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>
            <c:if test="${isOpanomaly=='2'}">
             <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>
            <c:if test="${isOpanomaly=='3'}">
             <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${empty dto.uniCode?dto.regNO:dto.uniCode}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${dto.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>法定代表人：<span>${dto.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${dto.localAdmName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：<span><fmt:formatNumber value="${dto.regCap}" pattern="###,###,###,##0.0000"/>万元</span>
            </p>
            <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${dto.estDate}" pattern="yyyy-MM-dd"/></span></p>
        </div>
        <div class="clearfix">
           <c:if test="${dto.isIndivid=='1'}"> 
            <p class="w360">
                <i class="date-icon"></i>转企日期：<span><fmt:formatDate value="${dto.individDate}" pattern="yyyy-MM-dd"/></span>
            </p>
           </c:if> 
            <p>
                <c:if test="${dto.regState=='D'}">
	                <i class="date-icon"></i>吊销日期：
	                <span class="light"><fmt:formatDate value="${dto.punishDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
                <c:if test="${dto.regState=='XX'||dto.regState=='DX'}">
	                <i class="date-icon"></i>注销日期：
	                <span class="light"><fmt:formatDate value="${dto.altDate}" pattern="yyyy-MM-dd"/></span>
                </c:if>
            </p>
        </div>
      
    </div>
    <c:if test="${!empty isEscApp && isEscApp.simplecanRea =='4'}">
    <div class="notice"><i class="notice-icon"></i>正在进行简易注销公告：公告期：<fmt:formatDate value="${isEscApp.noticeFrom}" pattern="yyyy年MM月dd日"/>
           至<fmt:formatDate value="${isEscApp.noticeTo}" pattern="yyyy年MM月dd日"/></div>
    </c:if>
</div>
<!-- <div class="supervise-about mt5 mb5"> -->
<!--     <p><label>监管项目：</label><span>食口生产</span><span>保化品</span><span>食品经营</span></p> -->
<!--     <p> -->
<!--         <label>监管提示：</label><span>重点监管对象</span><span>关注服务对象</span><span>列入异常即将届满3年</span><span>许可证已到期</span><span>经营期限已到期</span> -->
<!--     </p> -->
<!--     <div class="more reverse">展开全部详情<i></i></div> -->
<%--     <div class="more">点击后删除reverse类名<i></i></div> --%>
<!-- </div> -->

<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                    ${dto.leRep}     ${dto.tel}
                </div>
            </div>
            <div class="col-4" id="entName">
                <label class="right col-6">工商联络员：</label>
                <div class="col-6">
                   ${liaName}   ${liaTel}
                </div>
            </div>
            <!-- <div class="col-4">
                <label class="right col-6">财务负责人：</label>
                <div class="col-6">
                    李二 13596489562
                </div>
            </div> -->
        </div>
    </div>
</div>

  <div class="tabbale" data-component="tab">
     <div class="tab-header w-a145 type-tab tbmr1 ent-tab person-tab">
                <ul class="clearfix">
                    <li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="0">部门公示许可证信息</a></span>
                    </li>
                    <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="1">企业公示许可证信息</a></span>
                    </li>
                     <li><span class="tab-item"><a href="javascript:void(0);" class="_tab" mtab="2">企业监管标签历史记录</a></span>
                    </li>
                </ul>
          </div>
    <div class="tab-content">  
                
               <div class="tab-panel" >
                    <div class="gold"> 
	                    <span class="fr line-h30">数据来源：各审批许可部门</span>
	                    <i id="licenceinfo" class="flex-icon dib2 va-3"></i>
	                    <h6 class="add-title dib2">行政许可信息（<span id="pubotherlicTotal" class="light">0</span>）</h6>
                    </div>
                    <table id="_tab-pubotherlicence" border="0" cellspacing="0" cellpadding="0" class="table-row" width="100%">
                        <thead>
                        <tr>
                            <th class="col-first" width="5%">序号 </th>
                            <th class="col-second" width="10%">许可文件编号 </th>
                            <th class="col-three" width="10%">许可文件名称 </th>
                            <th class="col-four" width="10%">有效期自 </th>
                            <th class="col-five" width="10%">有效期至 </th>
                            <th class="col-six" width="25%">许可机关 </th>
                            <th class="col-seven" width="25%">许可内容 </th>
		                    <th>状态</th>
<!--                        <th>详情</th> -->
                        </tr>
                        </thead>
                        <tbody id="table-pubotherlicence">
                          <tr id="tr-pubotherlicence"></tr>
                        </tbody>
                    </table>
               </div>
               

                <div class="tab-panel">
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30">数据来源：国家企业信用信息公示系统企业信息填报</span>
	                    <i class="flex-icon dib2 va-3" id="permit_li"></i>
	                    <h6 class="add-title dib2">行政许可信息（<span class="light" id="permittplTotal">0</span>）</h6>
                    </div>
                    <table id="permit_table" border="0" cellspacing="0" cellpadding="0" class="table-row"
                           width="100%">
                        <thead>
                        <tr>
                            <th width="8%">序号</th>
                            <th width="22%">许可文件编号</th>
                            <th>许可文件名称</th>
                            <th>有效期自</th>
                            <th>有效期至</th>
                            <th>许可机关</th>
                            <th>许可内容</th>
                            <th>状态</th>
                            <th>详情</th>
                        </tr>
                        </thead>
                        <tbody id="permit">
                        <tr id="permittplPage"></tr>
                        </tbody>
                    </table>
                    </div>
                    
                  
                </div>
                
                <div class="tab-panel">
                    
                    <div>
                     <div class="gold">
	                    <span class="fr line-h30"></span>
	                    <i class="flex-icon dib2 va-3" id="permit_li_mainmarkHis_table"></i>
	                    <h6 class="add-title dib2">企业监管标签历史记录（<span class="light" id="mainmarkHis_table_total">0</span>）</h6>
                    </div>
                    <table id="mainmarkHis_table"  border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                        <thead>
                        <tr>
                            <th style="padding:0 20px;">序号</th>
                            <th>原始标签</th>
                            <th>添加标签</th>
                            <th>去除标签</th>
                            <th>审核状态</th>
                            <th>申请人</th>
                            <th>申请日期</th>
                            <th>申请部门</th>
                            <th>审核人</th>
                            <th>审核日期</th>
                            <th>审核部门</th>
                        </tr>
                        </thead>
                    </table>
                    </div>
                  
                </div>
         </div>
</div>
<br>
<%-- <div class="pd10 bg-gray">
			<div class="border-bottom clearfix">
				
				<table class="mb10">
					<tr>
						<td width="40%">
						<h5 class="h6-title mb10 mt10">当前可选标签</h5>
							<div class="ipt-box">
								<select multiple class="select-mul" id="js-select-show">
								</select>
							</div>
						</td>
						<td width="15%">
							<div class="center " id="roleLabel">
								<input type="button" class="btn mb10 btn-sm" value=">>添加" id="js-item-add" /></br> <input type="button" class="btn btn-sm" value="删除" id="js-item-del"/>
							</div>
						</td>
						<td width="40%">
							<h5 class="h6-title mb10 mt10">企业关联标签</h5>
							<div class="ipt-box">
								<select id="js-select-add" class="select-mul" multiple>
								</select>
							</div>
						</td>
					</tr>
				</table>
				<div class="clear">
					<div class="form-item ">
						<div class="col-4">
							<div class="item-name col-4">申请人：</div>
							<div class="col-6">
								<div class="ipt-box">
									<input type="text" name="setName" readonly="readonly" class="ipt-txt" value="${null == markUuid || '' eq markUuid?sysUser.realName:mainMarkDto.setName}" />
								</div>
							</div>
						</div>
						<div class="col-4">
							<div class="item-name col-4">申请日期：</div>
							<div class="col-6">
								<div class="ipt-box">
									<c:if test="${null == markUuid || '' eq markUuid }">
										<input type="text" name="setTime" readonly="readonly" class="ipt-txt" value="${nowDate }" />
									</c:if>
									<c:if test="${null != markUuid && !empty markUuid}">
									<input type="text" name="setTime" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value="${mainMarkDto.setTime}" pattern="yyyy-MM-dd" />" />
									</c:if>
									
								</div>
							</div>
						</div>
						<div class="col-4">
							<div class="item-name col-3">申请部门：</div>
							<div class="col-6">
								<div class="ipt-box">
									<input type="text" name="setDeptname" readonly="readonly" class="ipt-txt" value="${null == markUuid || '' eq markUuid?sysUser.departMent.deptName:mainMarkDto.setDeptname}" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div> --%>
		
		<div class="page-content clear">
        <div class="col-4 border-box" style="border-right: 1px solid #CCC; min-height: 500px">
            <div>
            	<div class="ipt-box col-7">
					<input class="ipt-txt clx" id="idname" title="输入小类标签名称" placeholder="输入小类标签名称">
				</div>
				<input type="button" class="tree-box-searcher-btn btn" id="tree-box-searcher" value="检索">
                <ul id="ycCodeLicenseTree" class="ztree" style="width:100%;max-height:80%;overflow-y: auto"></ul>
            </div>
        </div>
        <div class="col-8 border-box pdl15">
        				<div class="form-item clearfix">
					<div class="col-12">
							<span class="light">提示：监管标签大类与中类由省局统一管理维护，各地可自行设置标签小类。</span>
					</div>
				</div>
            <table class="table table-horizontal ">
                <tbody id="showArea">
                </tbody>
            </table>
            <p class="center mt10 mb10">
				<input type="button" id="save" class="btn mr20" value="提 交" /> <input type="button" class="btn" value="取 消" id="cancel" />
			</p>
        </div>

    </div>

		

</form>
<script id="viewTemplate" type="text/x-handlebars-template">
    <tr>
                <tr>
                    <td class="right bg-gray"  width="18%">标签名称：</td>
                    <td class="left">{{idname}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">有效期至：</td>
                    <td class="left">{{validDateFormat validDate}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">适用范围：</td>
                    <td class="left">{{applicationScopeName}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">对应的双随机检查事项：</td>
                    <td class="left">{{doublyStoStateFormat doublyStoState doublyStoFirName doublyStoSecName doublyStoThiName}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">备注说明：</td>
                    <td class="left">{{iddesc}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">创建日期：</td>
                    <td class="left">{{createTime}}</td>
                </tr>
                <tr>
                    <td class="right bg-gray">最近修改日期：</td>
                    <td class="left">{{updateTime}}</td>
                </tr>
 				<tr>
                    <td class="right bg-gray">申请人：</td>
                    <td class="left"><input type="text" name="setName" readonly="readonly" class="ipt-txt"  value="${null == markUuid || '' eq markUuid?sysUser.realName:mainMarkDto.setName}" style="border: 0"/></td>
                </tr>
                 <tr>
                    <td class="right bg-gray">申请日期：</td>
                    <td class="left"><c:if test="${null == markUuid || '' eq markUuid }">
										<input type="text" name="setTime" readonly="readonly" class="ipt-txt" value="${nowDate }"style="border: 0" />
									</c:if>
									<c:if test="${null != markUuid && !empty markUuid}">
									<input type="text" name="setTime" readonly="readonly" class="ipt-txt" value="<fmt:formatDate value="${mainMarkDto.setTime}" pattern="yyyy-MM-dd" />" style="border: 0"/>
									</c:if></td>
                </tr>
                 <tr>
                    <td class="right bg-gray">申请部门：</td>
                    <td class="left"><input type="text" name="setDeptname" readonly="readonly" class="ipt-txt"  value="${null == markUuid || '' eq markUuid?sysUser.departMent.deptName:mainMarkDto.setDeptname}" style="border: 0" /></td>
                </tr>
</script>
<script id="table-template_pubotherlicence" type="text/x-handlebars-template">
    {{#each data}}
    		<tr>
        		<td>{{addOne @index}}</td>
        		<td>{{licNO}}</td>
        		<td>{{licNameCN}}</td>
        		<td>{{licValFromDesc}}</td>
        		<td>{{licValToDesc}}</td>
        		<td>{{licAnth}}</td>
        		<td style="width: 600px;">{{licScope}}</td>
				<td >{{translicState licState}}</td>
    		</tr>
			<tr style="{{dataList pubOtherlicenceModList}}">
            	<td colspan="9" class="tip2">
                        <div class="fl">有变更情形：</div>
                        <div class="fl">
                            {{#with pubOtherlicenceModList}}
                            	{{#each this}}
                                <p>{{addOne @index}}、{{altDate altDate}}将{{altItem}}由{{altBe}}变更为{{altAf}}。</p>
                                {{/each}}
                        	{{/with}}
                        </div>
            	</td>
            </tr>
    {{/each}}
</script>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
					 _urlHead:'/reg/server/panoramasearch/',
					 _encryPriPID:'${encryPriPID}'
		     } 
		}else{
			window._CONFIG = {
					_urlHead:'/syn/panoramasearch/',
					_encryPriPID:'${encryPriPID}'
		     } 
		}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/component/tab.js"></script>
<!-- <script src="/js/lib/laydate/laydate.js"></script> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/mainmark/mainmarkapply_edit.js"></script>
</body>
</html>
