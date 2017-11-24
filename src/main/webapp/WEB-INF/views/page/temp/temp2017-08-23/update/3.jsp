<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 视图适配  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器默认视图 -->
    <meta name="renderer" content="webkit">
    <title>双随机</title>
    <link rel="stylesheet" href="/css/reg.server.css" type="text/css">
</head>
<body>
<div class="form-box bgfff mb5">
    <div class="form-list">
        <form id="">
            <input type="hidden" name="regState" id="">
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒领域：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="" id="">
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒事由：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="" id="">
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3">惩戒依据（条文）：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">惩戒规则：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125">惩戒执行措施：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒执行部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" class="ipt-txt clx">
                        </div>
                        <div class="ipt-box col-3">
                            <input type="button" value="部门列表" class="btn-new ml10 mr20">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 执行有效期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt zxyxq-btn clx">
                            至
                            <input type="text" class="ipt-txt zxyxq-btn clx">
                            <input type="checkbox" class="ipt-txt zxyxq-chk clx">终身
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span> 被惩戒当事人：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="button" value="添加名单" class="btn-new mr20">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"></label>
                    <div class="w875">
                        <table id="" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
                            <thead >
                            <tr>
                                <th>序号</th>
                                <th>操作</th>
                                <th>企业名称</th>
                                <th>统一信用代码/注册号</th>
                                <th>惩戒时的法定代表人（负责人）</th>
                                <th>身份证号</th>
                                <th>失信惩戒记录</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td></td>
                                <td><a href="">删除</a></td>
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
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>  法律文书编号：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>  文书出具日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span>  违法性质：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>  违法事实：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="" cols="30" rows="10"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>  认处理结果：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="" cols="30" rows="10"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-12">
                    <label class="item-name w125">证据资料上传：</label>
                    <div class="w875">
                        <div class="ipt-box col-8">
                            <div class="file-box mr5">
                                <input type="button" class="btn btn-sm file-btn" value="添加附件">
                                <span id=""><input type="file" class="btnFile" name="btnFile"></span>
                                <iframe width="0" height="0" name="uploadframe"></iframe>
                            </div>
                        </div>
                        <div class="col-4 fr file-explain">说明：支持图片、文档、照片等上传</div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>惩戒提请部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input style="background-color: #f4f4f4;" type="text" class="ipt-txt clx" name="cidRegNO" value="" readonly="readonly">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-6"><span class="start">*</span>是否需要执行部门反馈处理情况：</label>
                    <div style="line-height: 27px" class="col-6">
                        <input type="radio" name="asd" checked="checked"> 是
                        <input type="radio" name="asd"> 否
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>提请部门联系人：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="cidRegNO" value="">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">传真：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="cidRegNO" value="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>联系电话：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="cidRegNO" value="">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">电子邮箱：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="cidRegNO" value="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3">提请人：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx" name="cidRegNO" value="">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">提请日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx" name="cidRegNO" value="">
                        </div>
                    </div>
                </div>
            </div>

            <div class="examine-opinion">
                <div class="mb5">
                    <input type="radio" name="agr" checked="checked"> 同意发出
                    <input type="radio" name="agr"> 退回修改
                </div>
                <textarea class="examine-text mb5" placeholder="请输入审核意见"></textarea>
                <div class="form-item clearfix mb5">
                    <div class="col-6">
                        <label class="item-name fl">审核员：</label>
                        <div class="col-6">
                            <div class="ipt-box col-6">
                                <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx" name="cidRegNO" value="">
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <label class="item-name fl">审核日期：</label>
                        <div class="col-6">
                            <div class="ipt-box col-6">
                                <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx" name="cidRegNO" value="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix pd50">
                <div class="btn-box mt10">
                    <input type="button" value="提交" class="btn mr20">
                    <input type="button" value="取消" class="btn mr20">
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
