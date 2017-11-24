<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>仓储信息编辑页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<div class="mod-food">
   <form id="storageForm">
    <input type="hidden" id="fsinfoID" name="fsinfoID"/>
    <input type="hidden" id="info_id" name="id"/>
    <table class="table-public table-food" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
            <td class="focus-state">
                <div class="item-name">生产经营单位名称</div>
                <div class="ipt-box">
                    <input type="text" id="info_entName" name="entName" value="" class="ipt-txt" required>
                </div>
            </td>
            <td class="even focus-state">
                <div class="item-name">营业执照</div>
                <div class="ipt-box">
                    <input type="text" id="info_regNO" name="regNO" value="" class="ipt-txt" required>
                </div>
            </td>
        </tr>
        <tr>
            <td class="focus-state">
                <div class="item-name">法定代表人（负责人）</div>
                <div class="ipt-box">
                    <input type="text" id="info_leRep" name="leRep" value="" class="ipt-txt" required>
                    <i class="icon-close"></i>
                </div>
            </td>
            <td class="even focus-state">
                <div class="item-name">联系电话（手机）</div>
                <div class="ipt-box">
                    <input type="text" id="info_tel" name="tel" value="" class="ipt-txt" required>
                    <i class="icon-close"></i>
                </div>
            </td>
        </tr>
        <tr>
            <td class="focus-state" colspan="2">
                <div class="item-name">注册地址</div>
                <div class="ipt-box">
                    <input type="text" id="info_addr" name="addr" value="" class="ipt-txt ipt-txt-w480" required>
                    <i class="icon-close"></i>
                </div>
            </td>
        </tr>
        <tr>
            <td class="focus-state" colspan="2">
                <div class="item-name">仓库地址</div>
                <div class="ipt-box">
                    <input type="text" id="info_wareAddr" name="wareAddr" value="" class="ipt-txt ipt-txt-w480" required>
                    <i class="icon-close"></i>
                </div>
            </td>
        </tr>
        <tr>
            <td class="focus-state">
                <div class="item-name">仓库负责人</div>
                <div class="ipt-box">
                    <input type="text" id="info_linkman" name="linkman" value="" class="ipt-txt" required>
                    <i class="icon-close"></i>
                </div>
            </td>
            <td class="even focus-state">
                <div class="item-name">手机号码</div>
                <div class="ipt-box">
                    <input type="text" id="info_linktel" name="linktel" value="" class="ipt-txt" required>
                    <i class="icon-close"></i>
                </div>
            </td>
        </tr>
        <tr>
            <td class="focus-state">
                <div class="item-name">仓储从业人员数量</div>
                <div class="ipt-box">
                    <input type="text" id="info_empNum" name="empNum" value="" class="ipt-txt digits" required>
                    <i class="icon-close"></i>
                </div>
            </td>
            <td class="even focus-state">
                <div class="item-name">仓库面积（m<sup>2</sup>）</div>
                <div class="ipt-box">
                    <input type="text" id="info_opSpace" name="opSpace" value="" class="ipt-txt area" required>
                    <i class="icon-close"></i>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="item-name">建筑类型</div>
                <div class="food-right">
                    <div class="radio-box" id="building">
                        <label><input type="checkbox" value="31" supCode="1">砖木结构</label>
                        <label><input type="checkbox" value="32" supCode="1"/>砖混结构</label>
                        <label><input type="checkbox" value="33" supCode="1"/>钢结构</label>
                        <label><input type="checkbox" value="34" supCode="1"/>钢筋混泥土结构</label>
                        <label><input type="checkbox" value="35" supCode="1"/>其它()</label>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td-border-bottom">
                <div class="item-name">仓库类型</div>
                <div class="food-right">
                    <div class="radio-box" id="storage">
                        <label><input type="checkbox" value="41" supCode="2"/>常温仓库</label>
                        <label><input type="checkbox" value="42" supCode="2"/>冷藏仓库</label>
                        <label><input type="checkbox" value="43" supCode="2"/>冷冻仓库</label>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td-border-bottom">
                <div class="item-name special">库存食品主要种类</div>
                <div class="food-right">
                    <div class="radio-box" id="foodtype">　
                        <label><input type="checkbox" value="1" supCode="3"/>1、粮食及粮食制品</label>
                        <label><input type="checkbox" value="2" supCode="3"/>2、脂肪、油及乳化脂肪制品</label>
                        <label><input type="checkbox" value="3" supCode="3"/>3、冷冻饮品</label>
                        <label><input type="checkbox" value="4" supCode="3"/>4、水果</label>　
                    </div>
                    <div class="radio-box">　　　　　　　
                        <label><input type="checkbox" value="5" supCode="3"/>5、蔬菜</label>
                        <label><input type="checkbox" value="6" supCode="3"/>6、食用菌和藻类</label>
                        <label><input type="checkbox" value="7" supCode="3"/>7、豆类制品</label>
                        <label><input type="checkbox" value="8" supCode="3"/>8、坚果和籽类</label>
                    </div>
                    <div class="radio-box">
                        <label><input type="checkbox" value="9"  supCode="3"/>9、可可制品、巧克力及制品</label>
                        <label><input type="checkbox" value="10" supCode="3"/>10、糖果制品</label>
                        <label><input type="checkbox" value="11" supCode="3"/>11、乳及乳制品</label>
                    </div>
                    <div class="radio-box">
                        <label><input type="checkbox" value="12" supCode="3"/>12、焙烤食品</label>
                        <label><input type="checkbox" value="13" supCode="3"/>13、肉及肉制品</label>
                        <label><input type="checkbox" value="14" supCode="3"/>14、水产及其制品</label>
                        <label><input type="checkbox" value="15" supCode="3"/>15、蛋及蛋制品</label>
                    </div>
                    <div class="radio-box">
                        <label><input type="checkbox" value="16" supCode="3"/>16、甜味料</label>
                        <label><input type="checkbox" value="17" supCode="3"/>17、调味品</label>
                        <label><input type="checkbox" value="18" supCode="3"/>18、特殊膳食用食品</label>
                        <label><input type="checkbox" value="18.1" supCode="3"/>18.1、婴幼儿配方食品</label>
                    </div>
                    <div class="radio-box">
                        <label><input type="checkbox" value="18.2" supCode="3"/>18.2、婴幼儿辅助食品</label>
                        <label><input type="checkbox" value="19" supCode="3"/>19、饮料类</label>
                        <label><input type="checkbox" value="20" supCode="3"/>20、酒类</label>
                        <label><input type="checkbox" value="21" supCode="3"/>21、茶叶、咖啡</label>
                    </div>
                    <div class="radio-box">
                        <label><input type="checkbox" value="22" supCode="3"/>22、食品添加剂</label>
                        <label><input type="checkbox" value="23" supCode="3"/>23、保健食品</label>
                        <label><input type="checkbox" value="24" supCode="3"/>24、超市（综合类）</label>
                        <label><input type="checkbox" value="25" supCode="3"/>25、其他类食品</label>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td-border-bottom">
                <div class="item-name special">运输车辆</div>
                <div class="food-right">
                    <div class="radio-box" id="cartype">
                        <label><input id="traffic51" type="checkbox" value="51" supCode="4"/>普通运输车辆 (</label>
                        <label><input type="checkbox" class="traffic51" disabled="disabled"/>自有</label>
                        <label><input type="checkbox" class="traffic51" disabled="disabled"/>租赁</label>
                        <label><input type="checkbox" class="traffic51" disabled="disabled"/>其它 )</label>
                    </div>
                    <div class="radio-box">
                        <label><input id="traffic52" type="checkbox" value="52" supCode="4"/>冷冻、冷藏车 (</label>
                        <label><input type="checkbox" class="traffic52" disabled="disabled"/>自有</label>
                        <label><input type="checkbox" class="traffic52" disabled="disabled"/>租赁</label>
                        <label><input type="checkbox" class="traffic52" disabled="disabled"/>其它 )</label>
                    </div>
                    <div class="radio-box">
                        <label><input id="traffic53" type="checkbox" value="53" supCode="4"/>
                                                                 其他运输工具 (<input type="text" id="remark" maxlength="25" class="traffic53" style="border: 0;width: 150px;text-align: center;" disabled/>)(
                        </label>
                        <label><input type="checkbox" class="traffic53" disabled="disabled"/>自有</label>
                        <label><input type="checkbox" class="traffic53" disabled="disabled"/>租赁</label>
                        <label><input type="checkbox" class="traffic53" disabled="disabled"/>其它 )</label>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    <p class="btn center">
    <input type="submit" id="stocommit" value="保存" class="btn-common">
    <input id="storageCancel" type="button" value="取消" class="btn-common">
    </p>
  </form>
</div>
</body>
</html>