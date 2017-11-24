<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div class="form-box mb20">
    <div class="form-list">
        <div class="form-item clearfix">
            <div class="col-3">
                <label class="item-name col-5">统一社会信用代码：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">注册号：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-3">核准日期：</label>
                <div class="col-9">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">法定代表人：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-3">
                <label class="item-name col-5">企业名称：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">住所（经营场所）：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-3">推送日期：</label>
                <div class="col-9">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">企业登记事项：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="" id="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-3">
                <label class="item-name col-5">经营范围：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <input type="text" class="ipt-txt">
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">登记机关：</label>
                <div class="col-6">
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" placeholder="选择">
                        <span class="add-icon">
                            <i></i>
                        </span>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-3">认领日期：</label>
                <div class="col-9">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">

                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">审批认领：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="" id="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <div class="col-3">
                <label class="item-name col-5">后置审批事项：</label>
                <div class="col-6">
                    <div class="ipt-box col-6">
                        <input type="text" class="fl ipt-txt" placeholder="选择">
                        <span class="add-icon">
                            <i></i>
                        </span>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-5">抄告接收：</label>
                <div class="col-6">
                    <div class="ipt-box col-12">
                        <select name="" id="">
                            <option value=""></option>
                            <option value=""></option>
                            <option value=""></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <label class="item-name col-3">接收日期：</label>
                <div class="col-9">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                    <span class="item-txt col-2"><i class="line-icon"></i></span>
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt laydate-icon" onclick="laydate();">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-item">
            <div class="center">
                <input type="submit" value="查 询" class="btn mr20">
                <input type="submit" value="重 置" class="btn">
            </div>
        </div>
    </div>
</div>
<div class="clearfix mb5">
    <p class="fl"><input type="button" class="btn btn-sm mr5" value="批量处理"/></p>
</div>

<div class="light-info">
    <span class="light">提示：1. 勾选涉证企业可批量予以审批认领或抄告接收。2. 明确为错误推送的涉证企业可点击认领或接收中的“回退”后予以重新推送。3. 涉证企业处理时限：超过10个工作日未处理的显示<i class="xbt-icon red-lamp lamp"></i>，超过7个工作日未处理的
显示<i class="xbt-icon yellow-lamp lamp"></i>，7个工作内未处理的显示<i class="xbt-icon blue-lamp lamp"></i>。 4. 已经认领或接收的显示<i class="xbt-icon right-icon lamp"></i>。</span>

</div>
<div class="table-out">
    <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30">
        <tr>
            <th width="5.5%">全选 <input type="checkbox"> </th>
            <th width="5.6%">警示图标</th>
            <th width="5.3%">操作</th>
            <th width="4%">序号</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <td></td>
            <td><i class="xbt-icon red-lamp lamp"></i></td>
            <td>详情</td>
            <td>1</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><i class="xbt-icon yellow-lamp lamp"></i></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><i class="xbt-icon blue-lamp lamp"></i></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><i class="xbt-icon right-icon lamp"></i></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</div>
<div class="notice-pagination-box clearfix">
    <span class="page-total">共查询到<em id="_total"></em>条信息，共<em id="_pageNum">NaN</em>页</span>
    <div id="pagination" class="pagination"><span class="current prev disabled">首页</span><span class="current prev"><i class="icon-triangle-left"></i>上一页</span><span class="current">1</span><span class="current next">下一页<i class="icon-triangle-right"></i></span><span class="current prev disabled">末页</span></div>
</div>
<div class="layder-bd">
    <div class="send-message center">
        <p>
            确定全部认领或接收？
        </p>
        <div class="center">
            <input type="button" class="btn mr10" value="确 定">
            <input type="button" class="btn" value="取 消">
        </div>
    </div>
</div>
</body>
</html>