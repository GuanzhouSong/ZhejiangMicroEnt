package com.icinfo.cs.common.utils;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.dataservice.CertInfo;
import com.icinfo.dataservice.IcinfoDataService;
import com.icinfo.dataservice.IcinfoDataServicePortType;
import com.icinfo.dataservice.SoapHeaderInterceptor;

/** 
 * 描述: 汇信数据服务客户端接口
 * @author ZhouYan
 * @date 2014年10月23日  
 */
public class InfoDataClient {
	
	@Autowired
	private IcinfoDataService icinfoDataService;
	
	@Autowired
	private IcinfoDataServicePortType icinfoDataServicePortType;
	
	/** 
	 * 描述: 初始化
	 * @auther ZhouYan
	 * @date 2014年10月23日 
	 * @throws Exception 
	 */
	public void initClient() throws Exception{
		try{
			if(icinfoDataServicePortType == null){
				URL clientUrl = new URL(Constants.INFO_DATA_SERVER_WSDL);
				icinfoDataService = new IcinfoDataService(clientUrl);
				icinfoDataServicePortType = icinfoDataService.getSOAP11Endpoint();
				
				//ESB调用用户名密码设置
				Client client=ClientProxy.getClient(icinfoDataServicePortType);
				client.getOutInterceptors().add(new SoapHeaderInterceptor("huixinws","esb8809hx"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 
	 * 描述: 根据注册号查询是否领证
	 * @auther ZhouYan
	 * @date 2014年10月23日 
	 * @param regNo
	 * @return
	 * @throws Exception 
	 */
	public List<CertInfo> getCertInfoByRegNo(String regNo) throws Exception {
		List<CertInfo> result = null;
		try{
			initClient();
			result = icinfoDataServicePortType.getCertInfoByRegNo(regNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result == null?new ArrayList<CertInfo>():result;
	}

	/**
	 * 描述: 根据内部序号查询是否领证
	 * @auther wangjin
	 * @date 2017年02月13日
	 * @param pripid
	 * @return
	 * @throws Exception
	 */
	public List<CertInfo> getCertInfoByCorpid(String pripid) throws Exception {
		List<CertInfo> result = null;
		try{
			initClient();
			result = icinfoDataServicePortType.getCertInfoByCorpid(pripid);
		}catch(Exception e){
			e.printStackTrace();
		}

		return result == null?new ArrayList<CertInfo>():result;
	}



}
