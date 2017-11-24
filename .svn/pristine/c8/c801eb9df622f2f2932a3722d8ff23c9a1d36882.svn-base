<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业高级查询</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="../common/menu.jsp?module=qygjcx&menu=qygjcx"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="/depsyn/index">首页</a> &gt;
            <a href="javascript:void(0)">信息查询</a> &gt;
            <a href="javascript:void(0)" class="cur">企业高级查询</a>
        </div>
        
        <div class="clearfix advance-query-box">
            <div class="query-box">
                <div class="search-panel clearfix">
                
                	<form id="search-from"  method="post" >
	                    <input type="text" id="key" value="" placeholder="企业名称  统一信用代码/注册号  法定代表人" />
	                    <button type="button" id="search" >搜索</button>
	                    <a href="javascript:void(0)" id="savekeys">保存筛选条件</a>
		                <!-- 表单域 -->
		                <input type="hidden" id="type" name="type" value="0" />
						<input type="hidden" name="keyword" id="keyword" value=""  />
						<input type="hidden" name="entTypeCatg" id="entType" value="" />
						<input type="hidden" name="regState" id="regState" value="" />
						<input type="hidden" name="regCapStart" id="regCapStart" value="" />
						<input type="hidden" name="regCapEnd" id="regCapEnd" value="" />
						<input type="hidden" name="estDateStart" id="estDateStart" value="" />
						<input type="hidden" name="estDateEnd" id="estDateEnd" value="" />
						<input type="hidden" name="industryCo" id="industryCo" value="" />
					</form>
					
                </div>
				
				
                <div class="group-search-panel clearfix">
                    <div class="tab-header clearfix">
                        <ul id="search_tab">
                            <li class="selected"><a href="javascript:void(0);">全文</a></li>
                            <li><a href="javascript:void(0);">企业名称</a></li>
                            <li><a href="javascript:void(0);">统一社会信用代码/注册号</a></li>
                            <li><a href="javascript:void(0);">法定代表人</a></li>
                            <li><a href="javascript:void(0);">经营范围</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <div class="tab-panel">
                            <div class="group-type clearfix">
                                <label for="">专题分类：</label>
                                <div class="group-type-ct" id="p-topic">
                                    <a href="javascript:void(0)" class="selected">全部</a>
                                    <a href="javascript:void(0)">经营异常名录</a>
                                    <a href="javascript:void(0)">严重违法失信名单</a>
                                </div>
                            </div>
                            <div class="group-type clearfix">
                                <label for="">企业分类：</label>
                                <div class="group-type-ct" id="p-entType">
                                    <a href="javascript:void(0)" class="selected" data="">全部</a>
                                    <a href="javascript:void(0)" data="11,12,13,14,15,31,32,33,34">内资</a>
                                    <a href="javascript:void(0)" data="21,22,23,24,25,26,27,28">外资</a>
                                    <a href="javascript:void(0)" data="16,17">农专</a>
                                    <a href="javascript:void(0)" data="50">个体</a>
                                </div>
                            </div>
                            <div class="group-type clearfix">
                                <label for="">企业状态：</label>
                                <div class="group-type-ct" id="p-regState">
                                    <a href="javascript:void(0)" class="selected" data="">全部</a>
      								<a href="javascript:void(0)" data="A,B,K,DA">存续（在营、开业、在册）</a>
                                    <a href="javascript:void(0)" data="D">吊销，未注销</a>
                                    <a href="javascript:void(0)" data="D,X">吊销，已注销</a>
                                    <a href="javascript:void(0)" data="X">注销</a>
                                    <a href="javascript:void(0)" data="C">撤销</a>
                                    <a href="javascript:void(0)" data="Q">迁出</a>
                                    <a href="javascript:void(0)" data="E">其他</a>
                                </div>
                            </div>
                            <div class="group-type clearfix">
                                <label for="">注册资本：</label>
                                <div class="group-type-ct" id="p-regCap">
                                    <a href="javascript:void(0)" class="selected" data="">全部</a>
                                    <a href="javascript:void(0)" data="100">0-100万</a>
                                    <a href="javascript:void(0)" data="200">100-200万</a>
                                    <a href="javascript:void(0)" data="500">200-500万</a>
                                    <a href="javascript:void(0)" data="1000">500-1000万</a>
                                    <a href="javascript:void(0)" data="more">1000万以上</a>
                                    <a href="">自定义</a>
                                </div>
                            </div>
                            <div class="group-type clearfix">
                                <label for="">成立年限：</label>
                                <div class="group-type-ct" id="p-estDate">
                                    <a href="javascript:void(0)" class="selected" data="">全部</a>
                                    <a href="javascript:void(0)" data="1">成立1年内</a>
                                    <a href="javascript:void(0)" data="5">成立1-5年</a>
                                    <a href="javascript:void(0)" data="10">成立5-10年</a>
                                    <a href="javascript:void(0)" data="15">成立10-15年</a>
                                    <a href="">自定义</a>
                                </div>
                            </div>
                            <div class="group-type clearfix">
                                <label for="">行业：</label>
                                <div class="group-type-ct" id="p-industryCo">
                                    <a href="javascript:void(0)" class="selected" data="">全部</a>
                                    <a href="javascript:void(0)" data="0170,0252,0300,0310,0311,0312,0313,0314,0315,0319,0320,0251,0250,0190,0200,0210,0211,0212,0220,0230,0240,0241,0242,0321,0322,0511,0512,0513,0519,0520,0521,0522,0523,0529,0530,0510,0500,0323,0329,0330,0400,0410,0411,0412,0420,0421,0422,0540,0390,0133,0132,0130,0123,0122,0121,0120,0119,0113,0112,0111,0110,0100,0131,0134,0140,0169,0163,0162,0161,0160,0159,0154,0153,0152,0141,0142,0143,0149,0150,0151">农、林、牧、渔业</a>
                                    <a href="javascript:void(0)" data="0915,1020,1013,1012,1010,1000,0933,0931,0930,0922,0919,0917,0916,0914,0920,0929,0932,1030,1091,1092,1100,1110,1120,1190,1200,0921,1099,1090,1019,1011,0939,1093,0913,0912,0600,0610,0620,0690,0700,0710,0720,0800,0911,0910,0900,0890,0820,0810">采矿业</a>
                                    <a href="javascript:void(0)" data="3953,3461,3460,3459,3452,4119,3952,3951,3950,3940,3939,3932,3931,2460,2461,2462,2613,2612,2611,2610,2600,2530,2520,2512,2511,2510,2500,2469,3462,3930,3922,3869,3861,3860,3859,3857,2614,2619,2620,2621,2622,2623,2624,3870,3871,3872,3921,3920,3919,3913,3912,3911,3910,3900,3899,3891,3890,3879,3856,4026,4013,4012,4011,4000,3990,3972,3971,3970,3969,3963,3962,3961,4014,4019,4020,4027,4029,4030,4040,4041,4090,4100,4111,4025,4024,4023,4022,2010,1959,1953,3479,3475,3474,3473,3472,3471,3470,3468,3467,3466,3465,3464,3480,3481,3482,1951,3515,3514,3513,3512,3511,3510,3500,3490,3489,3484,3483,3463,3620,3583,3582,3581,3580,3579,3577,3576,3575,3574,3573,3572,3571,3584,3585,3586,3610,3600,3599,3597,3596,3595,3594,3593,3592,3591,3590,3589,3570,3562,3561,3533,3532,3531,3530,3529,3525,3524,3523,3522,3521,3520,3516,3534,3540,3541,3560,3554,3553,3552,3551,3550,3549,3546,3545,3544,3543,3542,3630,3640,3855,3825,3824,3823,3822,3821,3820,3819,3812,3811,3810,3800,3799,3829,3830,3831,3854,3853,3852,3851,3850,3849,3842,3841,3840,3839,3833">制造业</a>
                                    <a href="javascript:void(0)" data="4415,4412,4500,4610,4620,4600,4414,4430,4420,4411,4410,4400,4413,4419,4690">电力、热力、燃气及生产和供应业</a>
                                    <a href="javascript:void(0)" data="4821,4820,4819,4813,4812,4810,4800,4700,4822,4823,4830,5090,4811,5030,5029,5021,5020,5010,5000,4990,4850,4840,4851,4852,4890,4900,4910,4920">建筑业</a>
                                    
                                    <a href="javascript:void(0)" data="5260,5252,5250,5249,5242,5248,5247,5251,5246,5245,5244,5243,5261,5262,5263,5285,5284,5283,5282,5281,5280,5279,5273,5272,5271,5270,5264,5286,5241,5274,5224,5223,5222,5221,5220,5219,5212,5211,5210,5200,5199,5225,5226,5227,5240,5100,5239,5238,5236,5235,5234,5233,5232,5231,5230,5229,5237,5132,5146,5149,5150,5151,5152,5153,5160,5161,5162,5145,5144,5143,5133,5134,5135,5136,5137,5139,5140,5141,5142,5163,5164,5178,5179,5180,5181,5182,5189,5294,5291,5190,5176,5175,5174,5165,5166,5167,5168,5169,5170,5171,5172,5173,5191,5131,5113,5112,5111,5110,5299,5287,5289,5290,5292,5293,5296,5297,5295,5114,5115,5130,5129,5128,5127,5126,5125,5124,5123,5116,5119,5120,5121,5122,5177" class="ind-more" style="display:none">批发和零售业</a>
                                    <a href="javascript:void(0)" data="5910,6020,5990,5822,5829,5810,5400,5411,5413,5430,5441,5449,5521,5531,5600,5612,5632,5331,6000,5539,5631,5510,5300,5310,5320,5330,5332,5339,5410,5412,5919,6010,5511,5440,5420,5419,5911,5513,5512,5630,5620,5611,5610,5532,5530,5523,5522,5520,5639,5442,5700,5800,5820,5821,5500,5912,5900" class="ind-more" style="display:none">交通运输、仓储和邮政业</a>
                                    <a href="javascript:void(0)" data="6239,6291,6232,6230,6100,6210,6190,6110,6231,6292,6290,6233,6299,6120,6220,6200" class="ind-more" style="display:none">住宿和餐饮业</a>
                                    <a href="javascript:void(0)" data="6321,6319,6320,6592,6599,6310,6312,6550,6322,6500,6590,6311,6300,6330,6400,6410,6490,6420,6510,6591,6520,6530,6540" class="ind-more" style="display:none">信息传输、软件和信息技术服务业</a>
                                    <a href="javascript:void(0)" data="6639,6633,6631,6630,6620,6600,6720,6700,6990,6830,6730,6712,6640,6632,6610,6840,6850,6860,6890,6891,6920,6899,6900,6910,6930,6940,6820,6812,6713,6711,6710,6721,6790,6729,6740,6800,6810,6811" class="ind-more" style="display:none">金融业</a>
                                    <a href="javascript:void(0)" data="7090,7040,7010,7000,7020,7030" class="ind-more" style="display:none">房地产业</a>
                                    <a href="javascript:void(0)" data="7296,7210,7291,7121,7295,7270,7292,7293,7269,7299,7294,7100,7230,7229,7222,7112,7221,7220,7219,7213,7212,7113,7211,7200,7129,7123,7114,7119,7120,7231,7232,7233,7290,7289,7282,7281,7280,7279,7272,7271,7110,7263,7262,7261,7260,7250,7240,7111,7239,7122" class="ind-more" style="display:none">租赁和商务服务业</a>
                                    <a href="javascript:void(0)" data="7590,7492,7491,7490,7483,7482,7481,7480,7475,7493,7499,7520,7519,7514,7513,7512,7511,7510,7500,7474,7473,7410,7400,7350,7340,7330,7320,7310,7300,7420,7430,7440,7472,7471,7470,7462,7461,7460,7450" class="ind-more" style="display:none">科学研究和技术服务业</a>
                                    <a href="javascript:void(0)" data="7722,7723,7724,7725,7729,7810,7820,7830,7840,7850,7851,7852,7721,7720,7719,7800,7600,7610,7620,7630,7640,7690,7700,7710,7711,7712,7713" class="ind-more" style="display:none">水利、环境和公共设施管理业</a>
                                    <a href="javascript:void(0)" data="7960,8092,8091,8090,8032,8031,8093,8099,8100,8110,8111,8119,8190,7900,8030,8029,8022,7910,7920,7930,7940,7950,7970,7980,7990,8020,8012,8011,8010,8000,8021" class="ind-more" style="display:none">居民服务、修理和其他服务业</a>
                                    <a href="javascript:void(0)" data="8290,8291,8293,8294,8299,8233,8240,8250,8292,8242,8241,8236,8200,8210,8220,8221,8222,8230,8231,8232,8234,8235" class="ind-more" style="display:none">教育</a>
                                    <a href="javascript:void(0)" data="8410,8340,8320,8314,8311,8300,8415,8313,8412,8400,8413,8414,8419,8420,8421,8330,8411,8390,8315,8310,8316,8321,8323,8350,8360,8370,8429,8322,8312" class="ind-more" style="display:none">卫生和社会工作</a>
                                    <a href="javascript:void(0)" data="8760,8630,8770,8790,8520,8522,8525,8529,8710,8740,8820,8900,8911,8750,8732,8650,8640,8620,8610,8600,8720,8524,8523,8521,8510,8500,8660,8730,8810,8700,8920,8919,8940,8930,8941,8942,8949,8990,8913,8910,8890,8830,8731,8800,8912" class="ind-more" style="display:none">文化、体育和娱乐业</a>
                                    <a href="javascript:void(0)" data="9100,9120,9000,9124,9429,9420,9413,9411,9200,9131,9123,9110,9121,9122,9412,9419,9421,9430,9440,9422,9500,9520,9410,9400,9300,9510,9125,9126,9130,9132,9190,9210,9220" class="ind-more" style="display:none">公共管理、社会保障和社会组织</a>
                                    <a href="javascript:void(0)" data="9600" class="ind-more" style="display:none">国际组织</a>
                                </div>
                                <a href="javascript:void(0);" class="up" id="ind-more">展开<i></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="border-box" id="result-box">
                    <div class="title" id="title" style="display:none">查询结果超过<span class="light" id="total"></span>条信息，用时<span class="light" id="costtime"></span>
                        秒，请输入更精确的查询条件
                    </div>
                    <ul class="enterprise-info-list" id="ent-list"></ul>
                    <div class="notice-pagination-box pagination-box pagination-box2 clearfix">
                        <span class="page-total fl">共<em id="totalPage" class="light">-</em>页</span>
                        <div class="pagination fr" id="pagination" style="margin-right:5px">
                        </div>
                    </div>
                </div>
            </div>
            <div class="query-condi-box">
                <div class="border-box">
                    <div class="title">历史筛选条件</div>
                    <ul class="border-box-list" id="params"></ul>
                </div>
                <div class="border-box">
                    <div class="title">历史查询</div>
                    <ul class="border-box-list" id="history"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/search/search_list.js"></script>
</body>
</html>