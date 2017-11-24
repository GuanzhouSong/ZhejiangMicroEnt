/*
	if you have any problem
	just call com.icinfo.tc.lc
*/
function choseYear1() {
	//日期
	function day_title(day_name) {
		var str = "<TD ALIGN=center WIDTH=40><span class='tbl-title-week'>" + day_name + "</span></TD>";
		return str;
	}
	//填充表格
	function fill_table(month, month_length, num, beflength) {
		day = 1
		var strTable = "<div class='t1'><table class='tbl'><tr>";
		var strYearMonth = "<td colspan='7' align='center'><span class='tbl-title'>" + year + " 年  " + month + "</span></td><tr>";
		var strTitle = day_title("日") + day_title("一") + day_title("二") + day_title("三") + day_title("四") + day_title("五") + day_title("六") + "</TR><TR>"
		for (var i = 1; i < start_day; i++) {
			strTitle = strTitle + "<TD>"
		}
		for (var i = start_day; i < 8; i++) {
			var k = day - 1 + beflength;
			var strDay = "<td align='center'>\
								<a class='dayLabel' title='" + num + "月" + day +"日' id='dayLabel_" + yearinput + "-" + num + "-" + day + "' href='javascript:;' onclick='chaSta(\"" + yearinput + "-" + num + "-" + day + "\");'  ><input type='checkbox' style='display:none' id='" + yearinput + "-" + num + "-" + day + "' name='workdayWirteList[" + k + "].isHoliday' value='0' />" + day + "</a>\
								<input type='hidden' name='workdayWirteList[" + k + "].calendar' id='" + num + "inputday" + day + "'  value='" + yearinput + "-" + num + "-" + day + "' /></td>";
			strTitle = strTitle + strDay;
			day++;
		}
		strTitle = strTitle + "<TR>"
		while (day <= month_length) {
			for (var i = 1; i <= 7 && day <= month_length; i++) {
				var j = day - 1 + beflength;
				strTitle = strTitle + "<td align='center'>\
								<a class='dayLabel' title='" + num + "月" + day +"日' id='dayLabel_" + yearinput + "-" + num + "-" + day + "' href='javascript:;' onclick='chaSta(\"" + yearinput + "-" + num + "-" + day + "\");' ><input type='checkbox' style='display:none' id='" + yearinput + "-" + num + "-" + day + "' name='workdayWirteList[" + j + "].isHoliday'  value='0' />" + day + "</a>\
								<input type='hidden' name='workdayWirteList[" + j + "].calendar' id='" + num + "inputday" + day + "'  value='" + yearinput + "-" + num + "-" + day + "' /></td>"
				day++
			}
			strTitle = strTitle + "</tr><tr>";
			start_day = i
		}
		strTitle = strTitle + "</tr></table></div>";
		return strTable + strYearMonth + strTitle;
	}
	
	var obj = $.icinfo.url.get(url);
 
	var year = "";
	year = obj && obj.year ? obj.year : new Date().getFullYear();
 
	document.getElementById("select").value = year;
	//yearinput = year.toString().substr(2, 2);
	yearinput = year.toString();
	today = new Date("January 1, " + year)
	start_day = today.getDay() + 1
	var s1 = fill_table("一月", 31, 01, 0);
	var s2 = "";
	if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
		s2 = fill_table("二月", 29, 02, 31);
		var s3 = fill_table("三月", 31, 03, 60);
		var s4 = fill_table("四月", 30, 04, 91);
		var s5 = fill_table("五月", 31, 05, 121);
		var s6 = fill_table("六月", 30, 06, 152);
		var s7 = fill_table("七月", 31,07, 182);
		var s8 = fill_table("八月", 31, 08, 213);
		var s9 = fill_table("九月", 30, 09, 244);
		var s10 = fill_table("十月", 31, 10, 274);
		var s11 = fill_table("十一月", 30, 11, 305);
		var s12 = fill_table("十二月", 31, 12, 335);
	} else {
		s2 = fill_table("二月", 28, 02, 31);
		var s3 = fill_table("三月", 31, 03, 59);
		var s4 = fill_table("四月", 30, 04, 90);
		var s5 = fill_table("五月", 31, 05, 120);
		var s6 = fill_table("六月", 30, 06, 151);
		var s7 = fill_table("七月", 31, 07, 181);
		var s8 = fill_table("八月", 31, 08, 212);
		var s9 = fill_table("九月", 30, 09, 243);
		var s10 = fill_table("十月", 31, 10, 273);
		var s11 = fill_table("十一月", 30, 11, 304);
		var s12 = fill_table("十二月", 31, 12, 334);
	}
	var strSubmit = "<span style='margin-left:30px'>" +
			"<input type='button' class='btn btn-primary glyphicon glyphicon-hand-up' value='保存'/></span>";
 
	var HTMLcode =  s1 + "" 
						+ s2 + "" 
						+ s3 + ""   
						+ s4 + ""  
						+ s5 + ""  
						+ s6 + ""  
						+ s7 + ""   
						+ s8 + "" 
						+ s9 + "" 
						+ s10 + ""  
						+ s11 + ""  
						+ s12 + "<div style='clear:both'></div>"
					+ strSubmit;
					
	$("#theForm").html(HTMLcode);
	
	chk();
}