<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>小微企业名录</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/smallent/style.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/smallent/main.css"/>"/>
    <!--[if lte IE 6]>
    <script src="js/smallent/iepng2.js" type="text/javascript"></script>
    <![endif]-->
    <style type="text/css">
        .beian_winBG { margin-top: -120px; left: 50%; margin-left: -300px;   position: absolute;
        background:#f9fafa;top: 50%;   border:#c3d4d1 1px solid;z-index: 1000;
        }
    </style>
</head>
<body class="bg">
	
<div id="alert_win" style="display:none;">

            <div id="mask" style="top:0;left:0;position: absolute;z-index:1000;" class="bg"></div>
            
            <DIV class=beian_winBG id=beian_popup><!--弹出框-->
            <div id="divOneStep" style="z-index:1002;width:100%; background: #fff;position:absolute;">
     
            
 <div id="annlid" class="woaicss" style="display:none;height:420px">
	<ul class="woaicss_title woaicss_title_bg1" id="woaicsstitle" style="border-bottom:1px solid #666;">
		<li><a href="javascript:;"  onmouseover="javascript:woaicssq(1)">企业联络员登录</a></li>
		<li><a href="javascript:;"  onmouseover="javascript:woaicssq(2)">电子营业执照登录</a></li>
        <li style="text-align:right; padding-left:100px;"> <a href="javascript:;" onClick="alert_win.style.display='none';annlid.style.display='none';" style="text-align:right;"> 关闭</a>&nbsp;</li>
  	</ul>
	<div class="woaicss_con" id="woaicss_con1" style="display:block;height:370px">
<ul>
      <li> 
         <div class="woaicss_con_left" >营业执照注册号：</div><div class="woaicss_con_right" ><input name="pName" onblur="setName()" type="text" /></div>
      </li>
      <li> 
         <div class="woaicss_con_left" >市场主体名称：</div><div class="woaicss_con_right" ><input id="marketName" type="text" style="background-color:#efefef;" readonly='true'/></div>
      </li>
      <li> 
         <div class="woaicss_con_left" >联络员姓名：</div><div class="woaicss_con_right" ><input id="name" type="text" style="background-color:#efefef;" readonly='true'/></div>
      </li>
      <li> 
         <div class="woaicss_con_left" > 联络员身份证号：</div><div class="woaicss_con_right" ><input type="text" onblur="getKey()"/></div>
      </li>
      <li> 
         <div class="woaicss_con_left" > 联络员手机号：</div><div class="woaicss_con_right" ><input id="telphone" type="text" style="width:50%;background-color:#efefef;" readonly='true'/>&nbsp;<input type="button" id="getKey" style="width:35%" value="获取验证码" disabled="true"/></div>
      </li>
      <li> 
         <div class="woaicss_con_left" > 备案手机验证码：</div>
         <div class="woaicss_con_right" ><input style="width:70px;" name="" type="text" style="margin-top: -35px;" /> </div>
      </li>
      <li class="denglu-an" style="height:30px;">
         <a href="javascript:;" onClick="tb()">登 录</a>
      </li>
      <li>
        <div>说明：用户可采用“企业联络员”或“电子营业执照”方<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;式登录填报。</div>
      </li>
 			</ul>
	</div>
	<div class="woaicss_con" id="woaicss_con2" style="display:none;height:310px">
			<ul>
           <br>
								<li> 
                   <div class="woaicss_con_left" >PIN码：</div><div class="woaicss_con_right" ><input name="" type="text" /></div>
                </li>
                 <li> 
                  <div class="woaicss_con_left" > 验证码：</div>
                  <div class="woaicss_con_right-1" style="width:250px"><input style="width:70px;" name="" type="text" style="margin-top: -35px;" /> <img src="<c:url value='/img/smallent/yanz.png'/>"  alt=""> <a href="#">换一张</a></div>
                </li>
                 <li> <div class="pinm"><a href="">安装指南</a> &nbsp;&nbsp;   <a href="">驱动安装</a></div></li>
                 
                <li class="denglu-an" style="height:30px;"><a href="javascript:;"  onClick="tb()">登 录</a></li>
                <li>
                  <div>说明：用户可采用“企业联络员”或“电子营业执照”方<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;式登录填报。</div>
                </li>
 			</ul>	</div>
  </div>	

  </div>
   
   
   <div id="zmdid" class="woaicss" style="display:none;">
		<ul class="woaicss_title woaicss_title_bg1" id="woaicsstitle" style="border-bottom:1px solid #666;">
			<li style="width:100px; height:34px; line-height:34px;"> 输入验证码 </li> 
	        <li style="text-align:right; padding-left:100px;"> 
            <a href="javascript:;" onClick="alert_win.style.display='none';zmdid.style.display='none'" style="text-align:right; width:180px;"> 关闭</a>&nbsp;
            </li>
	  	</ul>
		<div class="woaicss_con" id="woaicss_con1" style="display:block;">
				<ul>
                   <li id="suanshu1" style="display:block">请根据下图中的算术题，在查询框中输入计算结果。</li>
                     <li id="suanshu2" style="display:block">
                       <div style="width:150px; height:60px; float:left;   padding-left:110px; "><img id="yan" src="<c:url value='/img/smallent/yan-index-1.png'/>"  /></div>  
                       <div style="width:80px; height:60px; float:right;"><a href="#" onclick="changeYan(1)">换一张</a></div>
                    </li>

                   <li id="souzimu1" style="display:none">请根据下图中的汉字，在查询框中输入首字母。</li>
                     <li id="souzimu2" style="display:none">
                       <div style="width:150px; height:60px; float:left;   padding-left:110px; "><img id="yan" src="<c:url value='/img/smallent/yan-index-2.png'/>"  /></div>  
                       <div style="width:80px; height:60px; float:right;"><a href="#" onclick="changeYan(2)">换一张</a></div>
                    </li>

                   <li id="hanzi1" style="display:none">请根据下图中的汉字，在查询框中输入汉字。</li>
                     <li id="hanzi2" style="display:none">
                       <div style="width:150px; height:60px; float:left;   padding-left:110px; "><img id="yan" src="<c:url value='/img/smallent/yan-index-3.png'/>"  /></div>  
                       <div style="width:80px; height:60px; float:right;"><a href="#" onclick="changeYan(3)">换一张</a></div>
                    </li>
                    
					<li> 
	                   <div class="woaicss_con_left" >验证码 :</div>
                       <div class="woaicss_con_right" > <input style="width:155px" id="yzm" type="text" /> </div>
	                </li>

	                
	                <li class="denglu-an1"><a href="javascript:void(0)" id="searchSmallDir">搜索</a></li>
	
	 			</ul>
		</div>
	

  </div>         
  
 </DIV>

</div>

	
<div id="header">
  <h1 style="background:url(http://gsxt.saic.gov.cn/xwqy/images/logo33.png) no-repeat left center;">小微企业名录</h1>
</div>

<div id="nav">
  <dl>
    <dt><a href="http://gsxt.saic.gov.cn/xwqy/home?df=33">首页</a></dt>
    <dd>|</dd>
    <dt><a href="http://gsxt.saic.gov.cn/xwqy/home/mirco/info_list?channelId=2200&organId=33">扶持政策集中公示</a></dt>
    <dd>|</dd>
    <dt><a href="http://gsxt.saic.gov.cn/xwqy/home/mirco/info_list?channelId=2300&organId=33">申请扶持政策导航</a></dt>
    <dd>|</dd>
    <dt><a href="javascript:void(0)" onclick="toSmallEntEnjSp()" >企业享受扶持信息公示</a></dt>
    <dd>|</dd>
    <dt class="current"><a href="javascript:void(0)" onclick="toSmallEntDirhtml()">小微企业库</a></dt>
  </dl>
</div>

    <div class="box1 search2 search21">      
      <ul>
        <li>
          <input name="nameOrRegNO" type="text" id="nameOrRegNO" value="请输入企业名称或注册号" class="serInput2 serInput1" onclick="if(value=='请输入企业名称或注册号') {value='';}" 
					onBlur="if(!value){value='请输入企业名称或注册号';}">
        &nbsp;&nbsp;
          <input type="submit" name="submit" id="submit" value="搜索" class="serBtn1" onclick="zdm()">
        </li>
      </ul>
    </div>
      
      
<div class="wrap1 clear">
  <div class="box">  
    <table id="dirInfoTable" cellspacing="0" cellpadding="0" class="tbList1">
      <tr class="tHead2">
        <td>企业名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td>注册号</td>
        <td>注册资本</td>
        <td>企业类型</td>
        <td>登记机关</td>
      </tr>
       <tbody id="smallentgrid"></tbody>
    </table>
     <div style="text-align: center;padding-top: 10px">
         <span class="page-total">共查询到<em id="info_total"></em>条信息，共<em id="info_pageNum"></em>页</span>
         <div id="" class="pagination" style="text-align: center;padding-top: 10px">
         </div>
     </div>
  </div>
</div>
<div id="footer">
  <ul>
    <li>版权所有：浙江省工商行政管理局 &nbsp; 地址：杭州市莫干山路77号金汇大厦北门&nbsp;</li>
    <li>业务咨询电话：400-888-4636&nbsp;&nbsp; 技术支持电话：400-888-4636&nbsp;&nbsp;邮政编码：310005</li>
  </ul>
</div>
</body>
<script id="dirinfoTemplate" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <th><a class="doView" href="javascript:void(0)" _id="{{uid}}">{{entName}}</a></th>
        <td>{{regNO}}</td>
        <td>{{regCap}}</td>
        <td>{{entTypeCatgDesc}}</td>
        <td>{{regOrgDesc}}</td>
    </tr>
    {{/each}}
	</script>
<script type="text/javascript">
function toSmallEntEnjSp(){
	 window.location.href="/pub/smallentsupport/index";
}
function toSmallEntDirhtml(){
	 window.location.href="/pub/smallentdir/index";
}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/smallent/smallentdir_main.js"></script>
</html>