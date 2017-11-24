var nodenum_gsxt = "330000"; //浙江省节点号
var collectUrl_gsxt = "http://106.38.252.33";
var sessionId_gsxt = "";

function getSessionId_gsxt() {
	var c_name = 'JSESSIONID';
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
			return unescape(document.cookie.substring(c_start, c_end));
		} else {
			if (sessionId_gsxt == "") {
				//console.log("cookie中部存在sessionId信息，请手动给sessionId_gsxt进行赋值。");
			}
			return sessionId_gsxt;
		}
	}
}

function addScriptTag_gsxt(src) {
	var script = document.createElement('script');
	script.setAttribute("type", "text/javascript");
	script.src = src;
	document.body.appendChild(script);
}

function getNowFormatDate_gsxt() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}

var getReferrer_gsxt=function() {
    var referrer = '';
    
    try {
        referrer = window.top.document.referrer;
        referrer = referrer.replace(/&/g,"%26");
    } catch(e) {
        if(window.parent) {
            try {
                referrer = window.parent.document.referrer;
                referrer = referrer.replace(/&/g,"%26");
            } catch(e2) {
                referrer = '';
            }
        }
    }
    if(referrer === '') {
        referrer = document.referrer;
        referrer = referrer.replace(/&/g,"%26");
    }
    return referrer;
};

function t1Collect_gsxt() {
	var log = {};
	log.sessionId = getSessionId_gsxt();
	log.referer = getReferrer_gsxt();
	log.host = window.location.host;
	log.url = window.location.href.replace(window.location.search,"");
	var str = window.location.search;
	if(str!=null){
		str = str.replace(/&/g,"%26");
	}
	log.queryString = str;
	log.nodenum = nodenum_gsxt;
	//console.log(log);
	var param = "{'sessionId':'"+log.sessionId
	+"','referer':'"+log.referer
	+"','host':'"+log.host
	+"','url':'"+log.url
	+"','queryString':'"+log.queryString
	+"','nodenum':'"+log.nodenum+"'}";
	addScriptTag_gsxt(collectUrl_gsxt + "/statistics/collectT1Log?param=" + param);
}

//window.onload = function() {
//	sessionId_gsxt = "0619804260462b2f65cd42163a08";
//	t1Collect_gsxt();
//	t2Collect_gsxt("", "", "", "东软集团（北京）有限公司", "");
//	searchKeywordCollect_gsxt("东软集团");
//	entnameCollect_gsxt("东软集团（北京）有限公司");
//}

function t2Collect_gsxt(entname) {
	var pripid="";
	var regno="";
	var uniscid="";
	var industryPhy="";
	var log = {};
	log.sessionId = getSessionId_gsxt();
	log.pripid = pripid;
	log.regno = regno;
	log.uniscid = uniscid;
	log.entname = entname;
	log.industryPhy = industryPhy;
	log.nodenum = nodenum_gsxt;
	//console.log(log);
	var param = "{'sessionId':'"+log.sessionId
	+"','pripid':'"+log.pripid
	+"','regno':'"+log.regno
	+"','uniscid':'"+log.uniscid
	+"','entname':'"+log.entname
	+"','industryPhy':'"+log.industryPhy
	+"','nodenum':'"+log.nodenum+"'}";
	addScriptTag_gsxt(collectUrl_gsxt + "/statistics/collectT2Log?param=" + param);
}

function searchKeywordCollect_gsxt(searchkeyword) {
	var param = "{'SEARCH_KEYWORD':'"+searchkeyword
	+"','NODENUM':'"+nodenum_gsxt+"'}";
	addScriptTag_gsxt(collectUrl_gsxt + "/statistics/addSearchLog?param=" + param);
}

function entnameCollect_gsxt(entname) {
	var param = "{'ENT_NAME':'"+entname
	+"','NODENUM':'"+nodenum_gsxt+"'}";
	addScriptTag_gsxt(collectUrl_gsxt + "/statistics/addDetailLog?param=" + param);
}