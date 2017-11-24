package com.icinfo.cs.simpleesc.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RestFulClient;
import com.icinfo.cs.simpleesc.dto.ErEscObjinfoDto;

@Component
public class DataExChange {

	@Value("${esc.appCode}")
	private String appCode;// 应用名称

	@Value("${esc.userName}")
	private String userName;// AIC服务的登录账户

	@Value("${esc.passWord}")
	private String passWord;// AIC服务的登录密码

	@Value("${esc.serverIp}")
	private String serverIp;// AIC服务IP

	@Value("${esc.caches}")
	private String caches;// 缓存集群的地址

	@Autowired
	RestFulClient sclient;

	/**
	 * 描述：简易注销异议信息数据交换
	 *
	 * @author baifangfang
	 * @date 2017年2月17日
	 * @param erEscObjinfo
	 * @param type
	 * @param insertMethod
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	public String objectionExChange(ErEscObjinfoDto erEscObjinfo, String type, String insertMethod) throws Exception {
		String objParam = getParameter(erEscObjinfo, type, insertMethod);
		// 调用远程服务
		String result = sclient.callRemoteService(objParam);
		return result;
	}

	/**
	 * 描述：生成webservice接口参数
	 * 
	 * @author baifangfang
	 * @date 2017-02-17
	 * @param erEscAppinfo,type,method
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	private String getParameter(ErEscObjinfoDto erEscAppinfo, String type, String method)
			throws UnsupportedEncodingException {
		if ("1".equals(type)) {// 自然人异议
			return "method=" + method + "&PRIPID=" + erEscAppinfo.getPriPID() + "&NAME="
					+ exchangeToGBK(erEscAppinfo.getName()) + "&CERNO=" + erEscAppinfo.getCerNO() + "&CERTIFICATESPIC="
					+ exchangeToGBK(erEscAppinfo.getCertificatesPic()) + "&B_CERTIFICATESPIC="
					+ exchangeToGBK(erEscAppinfo.getBcertificatesPic()) + "&REGORG=" + erEscAppinfo.getRegOrg()
					+ "&LOCALADM=" + erEscAppinfo.getLocalAdm() + "&MOBTEL=" + erEscAppinfo.getMobTel() + "&TYPE="
					+ type + "&OBJECTION=" + exchangeToGBK(erEscAppinfo.getObjection()) + "&OBJAPPTIME="
					+ getFormatDate(erEscAppinfo.getObjapptime());
		} else if ("2".equals(type)) {// 企业异议
			return "method=" + method + "&PRIPID=" + erEscAppinfo.getPriPID() + "&ENTNAME="
					+ exchangeToGBK(erEscAppinfo.getEntName()) + "&UNISCID=" + erEscAppinfo.getUniSCID() + "&REGNO="
					+ exchangeToGBK(erEscAppinfo.getRegNO()) + "&LEREP=" + exchangeToGBK(erEscAppinfo.getLeRep())
					+ "&CERNO=" + erEscAppinfo.getCerNO() + "&CERTIFICATESPIC="
					+ exchangeToGBK(erEscAppinfo.getCertificatesPic()) + "&REGORG=" + erEscAppinfo.getRegOrg()
					+ "&LOCALADM=" + erEscAppinfo.getLocalAdm() + "&NAME=" + exchangeToGBK(erEscAppinfo.getName())
					+ "&MOBTEL=" + erEscAppinfo.getMobTel() + "&TYPE=" + type + "&OBJECTION="
					+ exchangeToGBK(erEscAppinfo.getObjection()) + "&OBJAPPTIME="
					+ getFormatDate(erEscAppinfo.getObjapptime());
		} else if ("3".equals(type)) {// 其他相关单位异议
			return "method=" + method + "&PRIPID=" + erEscAppinfo.getPriPID() + "&UNITNAME="
					+ exchangeToGBK(erEscAppinfo.getEntName()) + "&UNISCID=" + erEscAppinfo.getUniSCID() + "&REGNO="
					+ exchangeToGBK(erEscAppinfo.getRegNO()) + "&CERTIFICATESPIC="
					+ exchangeToGBK(erEscAppinfo.getCertificatesPic()) + "&REGORG=" + erEscAppinfo.getRegOrg()
					+ "&LOCALADM=" + erEscAppinfo.getLocalAdm() + "&NAME=" + exchangeToGBK(erEscAppinfo.getName())
					+ "&MOBTEL=" + erEscAppinfo.getMobTel() + "&TYPE=" + type + "&OBJECTION="
					+ exchangeToGBK(erEscAppinfo.getObjection()) + "&OBJAPPTIME="
					+ getFormatDate(erEscAppinfo.getObjapptime());
		} else {
			return null;
		}

	}

	/**
	 * 描述：编码转GBK
	 * 
	 * @throws UnsupportedEncodingException
	 * @date 2017-02-14
	 */
	public String exchangeToGBK(String objStr) throws UnsupportedEncodingException {
		if (objStr == null) {
			return null;
		}
		return java.net.URLEncoder.encode(objStr, "GBK");
	}

	/**
	 * 描述：时间处理
	 * 
	 * @date 2017-02-14
	 */
	public String getFormatDate(Date date) {
		if (date == null) {
			return null;
		}
		return DateUtil.formatDateNew(date);
	}
}
