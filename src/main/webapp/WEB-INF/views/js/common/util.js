/**
 * 工具集
 */
define(['jquery'], function () {

    return {
        /**
         * 事件绑定
         * @param bindings [{el:x,event:y,handler:z}]
         *                  el为页面元素 event为绑定事件 handler为事件响应函数
         */
        bindEvents: function (bindings) {
            $.each(bindings, function (i, v) {
                if (typeof v.el == 'string') {
                    $(document).on(v.event, v.el, v.handler);
                } else {
                    $(v.el).on(v.event, v.handler);
                }
            });
        },
        /**
         * 获取Url参数
         * @param url url地址
         */
        getUrlParams: function (url) {
            // 需要返回的参数集合
            var rtnParams = {},
                // 参数键值对
                paramPair = [];
            if (!url || url.indexOf('?') === -1) {
                return rtnParams;
            }

            $.each(url.substr(url.indexOf('?') + 1).split('&'), function (i, v) {
                paramPair = v.split('=');
                rtnParams[paramPair[0]] = paramPair[1];
            });

            return rtnParams;
        },
        /**
         * 去除空格
         * @param array
         * @returns {Array}
         */
        trims: function (array) {
            var newArr = [],
                ele;
            $.each(array, function (i, v) {
                ele = v.replace(/ /g, '');
                ele != '' && newArr.push(ele);
            });
            return newArr;
        },
        /**
         *  时间间隔计算工具
         * @param strInterval
         * @param num
         * @returns {string}
         */
        timeInterval: function (strInterval, num) {
            var date = arguments[2] || new Date();
            switch (strInterval) {
                case 's' :
                    date = new Date(date.getTime() + (1000 * num));
                    break;
                case 'n' :
                    date = new Date(date.getTime() + (60000 * num));
                    break;
                case 'h' :
                    date = new Date(date.getTime() + (3600000 * num));
                    break;
                case 'd' :
                    date = new Date(date.getTime() + (86400000 * num));
                    break;
                case 'w' :
                    date = new Date(date.getTime() + ((86400000 * 7) * num));
                    break;
                case 'm' :
                    date = new Date(date.getFullYear(), (date.getMonth()) + num, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
                    break;
                default:
                    date = new Date((date.getFullYear() + num), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
            }
            date = date.getTime() >= (new Date()).getTime() ? new Date() : date;
            return [date.getFullYear(), date.getMonth() + 1, date.getDate()].join('/');
        },
        /**
         * 格式化日期  /yy/mm/dd/hh/mm/ss
         * @param date
         * @param formatStr
         * @returns {*}
         */
        dateFormat: function (date, formatStr) {
            var str = formatStr;
            var Week = ['日', '一', '二', '三', '四', '五', '六'];
            str = str.replace(/yy/, date.getFullYear());
            str = str.replace(/y/, (date.getYear() % 100) > 9 ? (date.getYear() % 100).toString() : '0' + (date.getYear() % 100));
            str = str.replace(/mm/, date.getMonth() >= 9 ? (date.getMonth() + 1).toString() : '0' + (date.getMonth() + 1));
            str = str.replace(/m/g, date.getMonth() + 1);
            str = str.replace(/w|W/g, Week[date.getDay()]);
            str = str.replace(/dd/, date.getDate() > 9 ? date.getDate().toString() : '0' + date.getDate());
            str = str.replace(/d/g, date.getDate());
            str = str.replace(/hh/, date.getHours() > 9 ? date.getHours().toString() : '0' + date.getHours());
            str = str.replace(/h/g, date.getHours());
            str = str.replace(/mm/, date.getMinutes() > 9 ? date.getMinutes().toString() : '0' + date.getMinutes());
            str = str.replace(/m/g, date.getMinutes());
            str = str.replace(/ss/, date.getSeconds() > 9 ? date.getSeconds().toString() : '0' + date.getSeconds());
            str = str.replace(/s/g, date.getSeconds());
            return str;
        },
        /**
         * 2016-05-12转成2016/05/12  ie8 new date('2016-05-12')是NAN
         * @param str
         */
        dateTransform: function(str){
            return str.replace(/\-/g,'/');
        },

        /*时间格式化*/
        dateFtt:function(fmt,date){
            //dateFtt('yyyy-MM-dd',new Date(startTime));
            var o = {
                "M+" : date.getMonth()+1,                 //月份
                "d+" : date.getDate(),                    //日
                "h+" : date.getHours(),                   //小时
                "m+" : date.getMinutes(),                 //分
                "s+" : date.getSeconds(),                 //秒
                "q+" : Math.floor((date.getMonth()+3)/3), //季度
                "S"  : date.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            return fmt;
        },


        /**
         * 判断字段是否存在数组中
         * @autor:wangjin
         */
        in_array: function (array, e) {
            for (var i = 0; i < array.length; i++) {
                if (array[i] == e)return true;
            }
            return false;
        },
        /**
         * 搜索树--设置高亮
         * @autor:liuhaiqiang
         */
        setHighlight: function (treeId, treeNode) {
            return (treeNode.highlight) ? {
                color: "green",
                "font-weight": "bold",
                "background-color": "#ddd"
            } : {color: "#000", "font-weight": "normal"};
        },
    /**
     * 搜索树--设置高亮
     * @autor:liuhaiqiang
     */
    searchNode: function (value, type, treeObj,layer) {
        if (value==null||$.trim(value) == "") return;
        // 获取与value匹配的节点，使用的ztreeAPI getNodesByParam;type的值有id ,name两个。id用精确搜索
        var nodes={};
        if(type=="id"){
            nodes= treeObj.getNodesByParam(type, value);
        }else{
            nodes= treeObj.getNodesByParamFuzzy(type, value);
        }

        if (nodes == null || nodes.length == 0){
            if(layer!=null){
                layer.msg("无搜索结果！", {
                    time: 500
                });
            }
            return;
        }

        // 关闭所有节点的高亮
        // 使用API transformToArray获取所有的节点，getNodes()只能获得根节点，属性children也只能获取下一级节点
        var allNodes = treeObj.transformToArray(treeObj.getNodes());

        for (var i = 0; i < allNodes.length; i++) {

            // 关闭高亮是利用节点属性highlight来控制fontCss实现的
            // 需要配合setting.view中设置的fontCss使用，后面代码会说
            allNodes[i].highlight = false;

            // 更新节点，因为hightlight改变了，使用updateNode可以更新节点
            treeObj.updateNode(allNodes[i]);
        }
        // 先关闭所有节点
        treeObj.expandAll(false);

        // 展开根节点（如果不展开根节点，下面的节点无法展开，不知道是不是bug）
        treeObj.expandNode(treeObj.getNodes()[0], true);

        // 高亮并展开搜索到的节点
        for (var i = 0; i < nodes.length; i++) {

            nodes[i].highlight = true;
            treeObj.updateNode(nodes[i]); // 更新节点，让高亮生效

            // 展开搜索到的节点的父节点
            treeObj.expandNode(nodes[i].getParentNode(), true);
        }
    },
        /**
         * 搜索下拉框,value为空，相当于重置
         * @autor:liuhaiqiang
         */
        searchCheckbox: function (value,$obj,layer) {
            var flag=true;
            if (value==null||$.trim(value) == ""){
                $obj.each(function () {
                    $(this).show();
                })
                return;
            }
            $obj.each(function () {
                var $txtObj= $(this).find('input').next();
                var txt = $txtObj.html();
                if(txt.indexOf(value)>-1){
                    $(this).show();
                    flag=false;
                }else{
                    $(this).hide();
                }
            })
            if(flag){
                if(layer!=null){
                    layer.msg("无搜索结果！", {
                        time: 500
                    });
                }
            }

        },
    
	// 千分位显示格式
      toThousands: function (num) {
    	  if(num != null && num.toString().indexOf(".")> 0){
    		  num = num.toString();
    		  str = num.substr(num.indexOf(".")); //小数
        	  num = num.substring(0,num.indexOf("."));//整数
    		 return ((num || 0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,'))+str ;
    	  }
	    return (num || 0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
	}

}

});
