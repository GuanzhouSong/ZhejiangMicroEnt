package com.icinfo.cs.common.utils;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log4jUtil {

	public void matchSQL(String line) {
		// String info = "INFO 2016-02-23 11:12:02 sqltiming-357 :$$$$$$: delete
		// from PUB_IND_REPORT_LICENSE where corpid = '3304243000024352' and
		// year = '2015' {executed in 4 msec}";
		// String info ="2016-12-22 11:31:51,731 [catalina-exec-472] INFO
		// jdbc.sqltiming - time：4 ms - SQL:SELECT t.id, t.LicName, t.ValTo,
		// t.CreateTime, t.LicNameCN, t.LicID, t.AnCheID, (SELECT
		// GROUP_CONCAT(s.AltItem separator ',') from cs_pb_updateinfo s where
		// s.AnCheID = t.AnCheID and s.AltTable = 'PbLicenceinfo' and s.AltID =
		// t.LicID) AltItem FROM cs_pb_licenceinfo t where 1=1 and t.AnCheID
		// ='33010200001001782013'";
		String regexString
			= "2016-12-2([1-9]+)\\s([\\S]+)\\s([\\S]+)\\s([\\S]+)[\\s\\S]+time[\\s\\S]+[1-9][1-9][1-9][\\s\\S]+ms[\\s\\S]+";
		
		Pattern pattern = Pattern.compile(regexString, Pattern.MULTILINE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(line);
		// boolean b = matcher.find(); //当条件满足时，将返回true，否则返回false
		if (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	public void print(BufferedReader reader) throws Exception {
		String line = null;
		String str = "";
		while ((line = reader.readLine()) != null) {
			str += line;
			if (line.indexOf("time") == -1) {
				continue;
			}
			matchSQL(str);
			str = "";
		}
		reader.close();
	}

	public static void main(String[] args) {
		try {
			Log4jUtil log = new Log4jUtil();
			/*
			 * BufferedReader reader = new BufferedReader(new FileReader(
			 * "H:\\个体户分析\\110\\catalina.out"));// 换成你的文件名 log.print(reader);
			 */
			BufferedReader reader2 = new BufferedReader(new FileReader("H:\\65-72sql\\sql_2016-12-22_1020.log"));// 换成你的文件名
			// log.matchSQL("line");
			log.print(reader2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
