require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'ztree','ztreeCheck','handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	
	
    $(function(){
    	
    	
    	
    	    //权限树配置
    	    var treeSetting = {
    	    			check: {
    	    				enable: true,
    	    				chkStyle: "radio",
    	    				radioType :"all" 
    	    			},
    				 
    				data: {
    					simpleData: {
    						enable: true
    					}
    				},
    	 
    				 
    				callback: {
    					//beforeClick: beforeClick,
    					 
    				}
    	    };
    	//需求类别树data
    	var HelpTypeCodeData = [ {
    		"id" : "GS",
    		"pId" : "0",
    		"name" : "工商(市场监管)类",
    		"nocheck":"true"
    	}, {
    		"id" : "ZYHFW",
    		"pId" : "0",
    		"name" : "专业化服务类",
   		 "nocheck":"true"
    	}, {
    		"id" : "QT",
    		"pId" : "0",
    		"name" : "其他需求",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_CWGL",
    		"pId" : "ZYHFW",
    		"name" : "财务管理类",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_FLZX",
    		"pId" : "ZYHFW",
    		"name" : "法律咨询",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_QT",
    		"pId" : "ZYHFW",
    		"name" : "其他需求",
   		 "nocheck":"true"
    	}, {
    		"id" : "GS_QYZC",
    		"pId" : "GS",
    		"name" : "企业注册",
   		 "nocheck":"true"
    	}, {
    		"id" : "GS_SBZC",
    		"pId" : "GS",
    		"name" : "商标注册",
   		 "nocheck":"true"
    	}, {
    		"id" : "GS_DJWQ",
    		"pId" : "GS",
    		"name" : "打假维权",
   		 "nocheck":"true"
    	}, {
    		"id" : "GS_XYJS",
    		"pId" : "GS",
    		"name" : "信用建设",
   		 "nocheck":"true"
    	}, {
    		"id" : "GS_QT",
    		"pId" : "GS",
    		"name" : "其他"
    	}, {
    		"id" : "ZYHFW_CWGL_GSMS",
    		"pId" : "ZYHFW_CWGL",
    		"name" : "公司秘书",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_CWGL_KJZX",
    		"pId" : "ZYHFW_CWGL",
    		"name" : "会计咨询",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_CWGL_SJJZ",
    		"pId" : "ZYHFW_CWGL",
    		"name" : "审计鉴证",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_CWGL_ZCPG",
    		"pId" : "ZYHFW_CWGL",
    		"name" : "资产评估"
    	}, {
    		"id" : "ZYHFW_FLZX_YDYCQBH",
    		"pId" : "ZYHFW_FLZX",
    		"name" : "一对一知识产权保护",
   		 "nocheck":"true"
    	}, {
    		"id" : "ZYHFW_FLZX_ZSJZ",
    		"pId" : "ZYHFW_FLZX",
    		"name" : "法律知识讲座"
    	}, {
    		"id" : "ZYHFW_QT_SSFD",
    		"pId" : "ZYHFW_QT",
    		"name" : "上市辅导"
    	}, {
    		"id" : "ZYHFW_QT_GPQYRZPX",
    		"pId" : "ZYHFW_QT",
    		"name" : "挂牌企业融资培训"
    	}, {
    		"id" : "ZYHFW_QT_QHCPZX",
    		"pId" : "ZYHFW_QT",
    		"name" : "期货产品咨询"
    	}, {
    		"id" : "ZYHFW_QT_JGGLPX",
    		"pId" : "ZYHFW_QT",
    		"name" : "经管管理培训"
    	}, {
    		"id" : "ZYHFW_QT_JYJCFW",
    		"pId" : "ZYHFW_QT",
    		"name" : "检验检测服务"
    	}, {
    		"id" : "QT_RZQDTK",
    		"pId" : "QT",
    		"name" : "融资渠道拓宽"
    	}, {
    		"id" : "QT_SSYHZCZX",
    		"pId" : "QT",
    		"name" : "税收优惠政策咨询"
    	}, {
    		"id" : "QT_TDYHZCZX",
    		"pId" : "QT",
    		"name" : "土地优惠政策咨询"
    	}, {
    		"id" : "GS_QYZC_GSZCBGDJ",
    		"pId" : "GS_QYZC",
    		"name" : "工商注册变更登记"
    	}, {
    		"id" : "GS_SBZC_SBZC",
    		"pId" : "GS_SBZC",
    		"name" : "商标注册"
    	}, {
    		"id" : "GS_SBZC_CMZMSBSB",
    		"pId" : "GS_SBZC",
    		"name" : "驰名著名商标申报"
    	}, {
    		"id" : "GS_SBZC_CMZMSBYX",
    		"pId" : "GS_SBZC",
    		"name" : "驰名著名商标延续"
    	}, {
    		"id" : "GS_DJWQ_SYMMBH",
    		"pId" : "GS_DJWQ",
    		"name" : "商业秘密保护"
    	}, {
    		"id" : "GS_DJWQ_SBQBH",
    		"pId" : "GS_DJWQ",
    		"name" : "商标权保护"
    	}, {
    		"id" : "GS_DJWQ_SHQBH",
    		"pId" : "GS_DJWQ",
    		"name" : "商号权保护"
    	}, {
    		"id" : "GS_DJWQ_SPBZ",
    		"pId" : "GS_DJWQ",
    		"name" : "商品包装"
    	}, {
    		"id" : "GS_DJWQ_HQBH",
    		"pId" : "GS_DJWQ",
    		"name" : "潢权保护"
    	}, {
    		"id" : "GS_DJWQ_QT",
    		"pId" : "GS_DJWQ",
    		"name" : "其他"
    	}, {
    		"id" : "GS_XYJS_SHTZXYQYSQ",
    		"pId" : "GS_XYJS",
    		"name" : "守合同重信用企业申请"
    	}, {
    		"id" : "GS_XYJS_XYGLSFQYSQ",
    		"pId" : "GS_XYJS",
    		"name" : "信用管理示范企业申请"
    	}, {
    		"id" : "ZYHFW_CWGL_GSMS_DL",
    		"pId" : "ZYHFW_CWGL_GSMS",
    		"name" : "代理登记、代理记账、代理年度报告申报、代理申办相关法律手续"
    	}, {
    		"id" : "ZYHFW_CWGL_KJZX_ZXPX",
    		"pId" : "ZYHFW_CWGL_KJZX",
    		"name" : "会计、税务等咨询和培训服务"
    	}, {
    		"id" : "ZYHFW_CWGL_SJJZ_SJSYPGFW",
    		"pId" : "ZYHFW_CWGL_SJJZ",
    		"name" : "审计、审阅、评估服务"
    	}, {
    		"id" : "ZYHFW_FLZX_YDYCQBH_DHZX",
    		"pId" : "ZYHFW_FLZX_YDYCQBH",
    		"name" : "电话咨询"
    	}, {
    		"id" : "ZYHFW_FLZX_YDYCQBH_QYZF",
    		"pId" : "ZYHFW_FLZX_YDYCQBH",
    		"name" : "企业走访"
    	} ];
    	 var treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, HelpTypeCodeData); 

   	 init();
   	 
   	 /**
      * 初始化函数集合
      */
     function init() {
         bind();
     }

    

     /*function beforeClick(treeId, treeNode) {
     	var check = (treeNode && !treeNode.isParent);
     	if (!check)   layer.msg("父级不可选", {ltype: 0,time:500});;
     	return check;
     }*/
     
     function zTreeOnCheck(event, treeId, treeNode) {
     	var zTree = $.fn.zTree.getZTreeObj("permisionTree");
         var  	nodes = zTree.getSelectedNodes();
     	alert(nodes);

     };
     /**
      * 点击触发事件
      */
     function onClick(e, treeId, treeNode) {
     	var zTree = $.fn.zTree.getZTreeObj("permisionTree"),
     	nodes = zTree.getSelectedNodes(),
     	v = "";
     	c="";
     	nodes.sort(function compare(a,b){return a.id-b.id;});
     	for (var i=0, l=nodes.length; i<l; i++) {
     		v += nodes[i].name + ",";
     	    c+=nodes[i].id+",";
     	}
     	if (v.length > 0 ) v = v.substring(0, v.length-1);
     	 
       $("#values").text(v);
     }



     function bind() {
         util.bindEvents([{
             el: '#cancel',
             event: 'click',
             handler: function () {
                 layer.close();
             }
         }, {
             el: '#save',
             event: 'click',
             handler: function () {
             	debugger;
             	var nodes = treeObj.getCheckedNodes(true);
     			var array = "";
     			var names= new Array();
     			var codes=new Array();
     			$.each(nodes, function(k, v) {
     				array += v.id + ",";
     				names[k]=v.name;
     				codes[k]=v.id;
     			});
             	  var data=new Object();
       		 
       			data.returncode=array; 
       			data.returncodes=codes.toString();
       			data.returnname=names.toString();
             	  layer.close(data);
             	  
             }
         }])
     }
	});
	
   
    
  
   

})