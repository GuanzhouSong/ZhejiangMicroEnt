require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	 
      init();
    /**
     * 初始化函数集合
     */
    function init() { 
        bind(); 
        }  
    
    //验证身份证号码  
    function validateCerNO(idcard){
		var area = {
                11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江",
                34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川",
                52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
            };
            var Y, JYM, S, M, ereg,idcard_array =  idcard.split("");
            if (area[parseInt(idcard.substr(0, 2))] == null) {
                return false;
            }
            switch (idcard.length) {
                case 15:
                    if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0)) {
                        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;
                    } else {
                        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;
                    }
                    if (ereg.test(idcard)) {
                        return true;
                    } else {
                        return false;
                    }
                    break;
                case 18:
                    if (parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard.substr(6, 4)) % 4 == 0)) {
                        ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;
                    } else {
                        ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;
                    }
                    if (ereg.test(idcard)) {
                        S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
                            + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
                            + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
                            + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
                            + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
                            + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
                            + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
                            + parseInt(idcard_array[7]) * 1
                            + parseInt(idcard_array[8]) * 6
                            + parseInt(idcard_array[9]) * 3;
                        Y = S % 11;
                        M = "F";
                        JYM = "10X98765432";
                        M = JYM.substr(Y, 1);
                        if (M == idcard_array[17]) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
            	}
            }

    function bind() {
        util.bindEvents([ 
        {
            el: '#btn_cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },
        {
            el: '#btn_save',
            event: 'click',
            handler: function () {
            	var proveType=window._CONFIG.proveType;
            	var regNO="";
            	var entName="";
            	if(proveType=="1"){//企业
            		regNO=$.trim($("#regNO").val());  
                	entName=$.trim($("#entName").val());
                	if(regNO==null||regNO==""){
                		layer.msg("统一信用代码/注册号不能为空", {ltype: 0,time:3000});
        	    		return false;
                	}
                	if(entName==null||entName==""){
                		layer.msg("企业名称不能为空", {ltype: 0,time:3000});
        	    		return false;
                	}
            	}else{
            		regNO=$.trim($("#tname").val());  
                	entName=$.trim($("#cerNO").val());
                	if(regNO==null||regNO==""){
                		layer.msg("姓名不能为空", {ltype: 0,time:3000});
        	    		return false;
                	}
                	if(entName==null||entName==""){
                		layer.msg("身份证号码不能为空", {ltype: 0,time:3000});
        	    		return false;
                	}
                	if(!validateCerNO(entName)){
                		layer.msg("身份证号码格式错误", {ltype: 0,time:3000});
        	    		return false;
                	}
            	}
            	
        		
            	http.httpRequest({
                    url: window._CONFIG.url+'/creditprovelist/saveCreditProveList',
                    serializable: false,
                    data: {"regNO":regNO,"entName":entName,"proveType":proveType},
                    type: 'get',
	                success: function (data) {  
	                	layer.close(data);
                    }
                });
            }
        }
        ])
    }

})
