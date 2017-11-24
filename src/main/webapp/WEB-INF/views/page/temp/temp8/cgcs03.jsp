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
<body>
<div class="pd20">
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-header type-tab clear pdb10 border-bottom">
                <label class="right">请选择抄告类型：</label>
                <ul class="clearfix">
                    <li class="tab-selected"><span class="tab-item"><a href="javascript:void(0);">无证无照</a></span></li>
                    <li><span class="tab-item"><a href="javascript:void(0);">企业违法案件线索</a></span></li>
                    <li><span class="tab-item"><a href="javascript:void(0);">其它情况抄告</a></span></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-panel tab-panel-show">
                    <div class="">
                        <div class="print-nocard">
                            <h3 class="mt33">
                                部门抄告单（无证无照信息）
                                <span>抄告单编号： 杭 桐庐 公安 （2016） 2号</span>
                            </h3>
                            <p class="right print-data">抄告发起日期：<span></span>年<span></span>月<span></span>日</p>
                            <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                <tbody><tr>
                                    <td class="tb-form-hd" width="140px">
                                        抄告接收部门
                                    </td>
                                    <td width="52%">
                                        【已选】桐庐县工商局；桐庐县文化局
                                        <input type="button" class="btn btn-xs chose" value="选择">
                                    </td>
                                    <td class="tb-form-hd" width="100px">
                                        抄告类型
                                    </td>
                                    <td>
                                        无证无照
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">涉嫌违法事项</td>
                                    <td>
                                        【已选】桐庐县工商局；桐庐县文化局
                                        <input type="button" class="btn btn-xs chose" value="选择">
                                    </td>
                                    <td class="tb-form-hd">
                                        抄告类型
                                    </td>
                                    <td>
                                        <div class="radio-box">
                                            <label><input type="radio">检查发现</label>
                                            <label><input type="radio">群众举报</label>
                                            <label><input type="radio">上级交办</label>
                                            <label><input type="radio">其他</label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">涉嫌违法当事人列表<input type="button" class="btn btn-xs add" value="添加"></td>
                                    <td colspan="3" class="pd0">
                                        <table class="inner-table center">
                                            <tbody><tr>
                                                <th>当事人姓名</th>
                                                <th>证件类型</th>
                                                <th>证件号</th>
                                                <th>地址</th>
                                                <th>当事人联系电话</th>
                                                <th width="90" class="last-col">操作</th>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td class="last-col">
                                                    <a href="#">修改</a>
                                                    <a href="#">删除</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td class="last-col"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td class="last-col"></td>
                                            </tr>
                                            <tr class="last-row">
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td class="last-col"></td>
                                            </tr>
                                            </tbody></table>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">具体违法情况</td>
                                    <td colspan="3" class="pd3">
                                        <div><textarea name="" id="" cols=" " rows="5">具体违法情况如下：</textarea></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">证据资料上传</td>
                                    <td colspan="3" class="pd1">
                                        <div class="file-upload-out">
                                            <i class="xbt-icon file-icon"></i>行政处罚文书.doc（12.5K）
                                        </div>
                                        <p class="pd10 file-upload">
                                            <input type="button" class="btn btn-xs" value="添加附件">
                                            说明：支持图片、文档、照片等上传
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">
                                        抄告发起部门
                                    </td>
                                    <td width="52%">
                                    </td>
                                    <td class="tb-form-hd" width="160px">
                                        是否需要反馈处理结果
                                    </td>
                                    <td>
                                        <div class="radio-box">
                                            <label><input type="radio">是</label>
                                            <label><input type="radio">否</label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd" rowspan="3">抄告发起部门联系人</td>
                                    <td rowspan="3" class="pd3">
                                        <div><textarea name="" id="" cols=" " rows="7"></textarea></div>
                                    </td>
                                    <td class="tb-form-hd">
                                        联系电话（必填）
                                    </td>
                                    <td class="pd3">
                                        <div class="ipt-box">
                                            <input type="text" class="ipt-txt">
                                        </div>

                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">
                                        传真
                                    </td>
                                    <td class="pd3">
                                        <div class="ipt-box">
                                            <input type="text" class="ipt-txt">
                                        </div>

                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">
                                        邮件
                                    </td>
                                    <td class="pd3">
                                        <div class="ipt-box">
                                            <input type="text" class="ipt-txt">
                                        </div>
                                    </td>
                                </tr>
                                </tbody></table>
                        </div>
                        <p class="center mt20"><input type="button" class="btn mr20" value="打 印"><input type="button" class="btn mr20" value="保存并提交审核"><input type="button" class="btn mr20" value="取消编辑"></p>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>