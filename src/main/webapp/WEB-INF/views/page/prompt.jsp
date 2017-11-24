<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>提示页面</title>
    <style type="text/css">
        body, html, div, p, span, h3, ol, ul, li {
            margin: 0;
            padding: 0;
        }

        ol, ul, li {
            list-style: none;
        }

        body, html {
            height: 100%;
        }

        .main {
            width: 100%;
            height: 100%;
            background: #e8e8e8;
            font-family: "微软雅黑", "宋体";
        }

        .con {
            width: 565px;
            *width: 568px;
            margin: 0 auto;
        }

        .result {
            background: #008ead;
            padding: 80px 0 80px;
        }

        .result h1 {
            width: 100%;
            padding-bottom: 10px;
            margin-bottom: 10px;
            font-size: 63px;
            color: #f00;
            font-weight: bold;
        }

        .result h3 {
            width: 100%;
            border-bottom: 1px solid #fff;
            padding-bottom: 10px;
            margin-bottom: 10px;
            font-size: 33px;
            color: #fff;
            font-weight: bold;
        }

        .result div {
            color: #e8e8e8;
        }

        .result p {
            font-size: 25px;
        }

        .result ol {
            padding-left: 25px;
            *padding-left: 28px;
        }

        .result ol li {
            list-style: decimal;
            font-size: 20px;
        }

        .explain {
            background: #e2e2e2;
            color: #666;
            font-size: 12px;
            padding: 20px 0;
        }

        .fontsize {
            font-size: 16px;;
        }

        .explain .info2 {
            margin-top: 15px;
        }

        .explain .info2 p {
            font-weight: bold;
        }

        .explain .info2 ul {
            padding-left: 15px;
        }

        .explain .info2 li {
            list-style: disc;
        }

        .tel {
            padding: 20px 0;
            color: #666;
        }

        .tel p {
            font-size: 16px;
        }

        .foodercon {
            width: 565px;
            *width: 568px;
            margin: 20px auto 10px;
        }
        .closeBtn{
            background: #4786c8;
            border: 1px solid #4786c8;
            color: #fff;
            width: 90px;
            height: 40px;
            font-size: 14px;
            font-weight: bold;
            border-radius: 2px;
            line-height: 40px;
            margin-top: 10px;
            text-align: center;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="result">
        <div class="con">
            <h3>很抱歉，您当前的操作出现了问题！</h3>
            <div>
                <p>造成问题的可能原因：</p>
                <ol>
                    <li>当前服务器访问量过大</li>
                    <li>网络不稳定</li>
                    <li>多台电脑同时填报</li>
                </ol>
            </div>
        </div>
    </div>
    <div class="explain fontsize">
        <div class="con">
            <h3>下面是我们为您准备的几个解决方案：</h3>
            <br>
            <div>
                <ol>
                    <li>1.点击下面的关闭按钮,重新选择填报</li><br>
                    <li>2.退出多台电脑登录填报,使用一台电脑进行填报</li><br>
                    <li>3.退出当前登录,重新登录再次进行填报</li><br>
                </ol>
            </div>
        </div>
    </div>
    <div style="text-align: center">
        <button class="closeBtn" onclick="closeBtn()">关 闭</button>
    </div>
</div>

<script>
    function closeBtn(){
        window.close();
    }
</script>


</body>
</html>
