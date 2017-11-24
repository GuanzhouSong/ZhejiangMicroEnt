<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>网站网店信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
    <div class="mod mod-border investment-info mt10">
        <div class="mod-bd">
            <div class="content">
                <!-- 信息网站 start -->
                <div id="one" style="display: ${selectedValue=='1'?'block':'none'}" >

                    <form class="form-horizontal error-bottom" id="from_one" >
                        <div class="title"><h3>信息网站</h3></div>
                        <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                            <input type="hidden" name="webSmallType" value="2"><!--信息网站-->
                            <input type="hidden" name="webType"  class="webType" value="1"/><!--网站-->
                            <input type="hidden" name="priPID"   value="${priPID}"/>
                            <input type="hidden" name="year"     value="${year}"/>
                            <input type="hidden" name="anCheID"  value="${anCheID}">
                            <tbody>
                            <tr>
                                <td class="odd focus-state">
                                    <div class="item-name bg">
                                        <strong class="light">* </strong>网站名称
                                    </div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="webSitName" value="" class="ipt-txt ipt-txt-lg " >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>

                                <td class="odd focus-state">
                                    <div class="item-name bg">
                                        <i class="icon-question" id="wz-one" data-id="wz-one" data-msg="网站/网店的网址,如：http://www.baidu.com</br>https://www.baidu.com"></i>
                                        <strong class="light">* </strong>网址(域名)
                                    </div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="webSite" value="" class="ipt-txt ipt-txt-lg" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name">互联网信息服务(简称ICP)备案号</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="icpBackNO" value="" class="ipt-txt w-730" placeholder="" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state">
                                    <div class="item-name ">微信公众号</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="weChatPublicNO" value="" class="ipt-txt ipt-txt-lg "  placeholder="如有多个请以；隔开">
                                        <i class="icon-close"></i>
                                    </div>
                                </td>

                                <td class="odd focus-state">
                                    <div class="item-name ">手机APP服务</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="appNames" value="" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开">
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <div class="btn-box" id="js-div-one">
                            <input type="submit"  value="保存" class="btn-common js-save-one" />
                            <input type="button" value="关 闭" class="btn-common js-cancel">
                        </div>
                    </form>
                </div>

                <!-- 信息网站  end -->

                <!-- 交易网站 start-->
                <div id="two"  style="display: ${selectedValue=='2'?'block':'none'};"  >
                    <form class="form-horizontal error-bottom" id="from_two">
                        <div class="title"><h3>交易网站</h3></div>
                        <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                            <input type="hidden" name="webSmallType" value="1"><!--交易网站-->
                            <input type="hidden" name="webType"  class="webType" value="1"/><!--网站-->
                            <input type="hidden" name="priPID"   value="${priPID}"/>
                            <input type="hidden" name="year"     value="${year}"/>
                            <input type="hidden" name="anCheID"  value="${anCheID}">
                            <tbody>
                            <tr>
                                <td class="odd focus-state">
                                    <div class="item-name bg">
                                        <strong class="light">* </strong>网站名称
                                    </div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="webSitName" value="" class="ipt-txt ipt-txt-lg " >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>

                                <td class="odd focus-state">
                                    <div class="item-name bg">
                                        <i class="icon-question" id="wz-two" data-id="wz-two" data-msg="网站/网店的网址,如：http://www.baidu.com</br>https://www.baidu.com"></i>
                                        <strong class="light">* </strong>网址(域名)
                                    </div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="webSite" value="" class="ipt-txt ipt-txt-lg " >
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name">互联网信息服务(简称ICP)备案号</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" id="" name="icpBackNO" value="" class="ipt-txt w-730" placeholder="" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state">
                                    <div class="item-name ">微信公众号</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="weChatPublicNO" value="" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开">
                                        <i class="icon-close"></i>
                                    </div>
                                </td>

                                <td class="odd focus-state">
                                    <div class="item-name ">手机APP服务</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="appNames" value="" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开">
                                    </div>
                                </td>
                            </tr>

                            <div >
                                <tr>
                                    <td class="odd focus-state" colspan="2">
                                        <div class="item-name"><strong class="light">* </strong>网络交易平台运营类型</div>
                                        <div class="ipt-box js-ipt-box radio-box">
                                            <label><input type="radio" name="webPlatFormType" value="自营平台">自营平台</label>
                                            <label><input type="radio" name="webPlatFormType" value="第三方交易平台">第三方交易平台</label>
                                            <label><input type="radio" name="webPlatFormType" value="混合类平台(兼有自营和第三方交易)">混合类平台(兼有自营和第三方交易)</label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="odd focus-state" colspan="2">
                                        <div class="item-name"><strong class="light">* </strong>网络交易产品类型</div>
                                        <div class="ipt-box js-ipt-box radio-box">
                                            <label><input type="radio" name="webGoodsType" value="商品交易类平台">商品交易类平台</label>
                                            <label><input type="radio" name="webGoodsType" value="服务交易类平台">服务交易类平台</label>
                                            <label><input type="radio" name="webGoodsType" value="商品及服务交易类平台">商品及服务交易类平台</label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="odd focus-state" colspan="2">
                                        <div class="item-name"><strong class="light">* </strong>电商类型</div>
                                        <div class="ipt-box js-ipt-box radio-box">
                                            <label><input type="radio" name="eCommerceType" value="B2B">B2B</label>
                                            <label><input type="radio" name="eCommerceType" value="B2C">B2C</label>
                                            <label><input type="radio" name="eCommerceType" value="C2C">C2C</label>
                                            <label><input type="radio" name="eCommerceType" value="其他">其他</label>
                                        </div>
                                    </td>
                                </tr>
                            </div>

                            </tbody>
                        </table>
                        <div class="btn-box" id="js-div-two">
                            <input type="submit"  value="保存" class="btn-common js-save-two" />
                            <input type="button" value="关 闭" class="btn-common js-cancel">
                        </div>
                    </form>
                </div>

                <!-- 网店 start-->
                <div id="three"  style="display: ${selectedValue=='3'?'block':'none'};"  >
                    <form class="form-horizontal error-bottom" id="from_three" >
                        <div class="title"><h3>网店(或微店)</h3></div>
                        <table class="table-public table-contact" border="0" cellspacing="0" cellpadding="0">
                            <input type="hidden" name="webSmallType" value="2"><!--信息网站-->
                            <input type="hidden" name="webType"  class="webType" value="2"/><!--网站-->
                            <input type="hidden" name="priPID"   value="${priPID}"/>
                            <input type="hidden" name="year"     value="${year}"/>
                            <input type="hidden" name="anCheID"  value="${anCheID}">
                            <tbody>

                            <tr>
                                <td class="odd focus-state">
                                    <div class="item-name bg">
                                        <strong class="light">* </strong>网店(或微店)名称
                                    </div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="webSitName" value="" class="ipt-txt ipt-txt-lg " >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>

                                <td class="odd focus-state">
                                    <div class="item-name bg">
                                        <i class="icon-question" id="wz-three" data-id="wz-three" data-msg="网站/网店的网址,如：http://www.baidu.com</br>https://www.baidu.com"></i>
                                        <strong class="light">* </strong>网址(域名)
                                    </div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="webSite" value="" class="ipt-txt ipt-txt-lg " >
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name">互联网信息服务(简称ICP)备案号</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="icpBackNO" value="" class="ipt-txt w-730" placeholder="" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state">
                                    <div class="item-name ">微信公众号</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="weChatPublicNO" value="" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>

                                <td class="odd focus-state">
                                    <div class="item-name ">手机APP服务</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="appNames" value="" class="ipt-txt ipt-txt-lg " placeholder="如有多个请以；隔开">
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name"><strong class="light">* </strong>所属平台</div>
                                    <div class="ipt-box js-ipt-box radio-box">
                                        <label><input type="radio" name="belongPlatFormName" value="天猫">天猫</label>
                                        <label><input type="radio" name="belongPlatFormName" value="淘宝">淘宝</label>
                                        <label><input type="radio" name="belongPlatFormName" value="京东">京东</label>
                                        <label><input type="radio" name="belongPlatFormName" value="1688">1688</label>
                                        <label><input type="radio" name="belongPlatFormName" value="other">其他</label>
                                    </div>
                                    <div class="ipt-box js-ipt-box" id="js-select-other" style="display: none">
                                        <input type="text" id="js-other" name="otherName"  value="" class="ipt-txt ipt-txt-lg " >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name"><strong class="light">* </strong>发货地址</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="sendAddress" value="" class="ipt-txt w-730" placeholder="" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="odd focus-state" colspan="2">
                                    <div class="item-name"><strong class="light">* </strong>退货地址</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text"  name="backAddress" value="" class="ipt-txt w-730" placeholder="" >
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                        <div class="btn-box" id="js-div-three">
                            <input type="submit"  value="保存" class="btn-common js-save-three" />
                            <input type="button" value="关 闭" class="btn-common js-cancel">
                        </div>
                    </form>
                </div>
                <!-- 网店 end -->
            </div>
        </div>
    </div>

    <!--后台的传入的值-->

    <script src="<c:url value="/js/lib/require.js"/>"></script>
    <script src="<c:url value="/js/config.js"/>"></script>
    <script src="<c:url value="/js/reg/client/yr/sfcyr/websiteInfo_add.js"/>"></script>

</body>
</html>
