package com.icinfo.cs.common.utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * 描述: HTTP请求工具类
 * 
 * @author baifangfang
 * @date 2016年8月29日
 */
public class HttpFluent {
	private static final Logger logger = LoggerFactory.getLogger(HttpFluent.class);

	/**
	 * 描述：GET请求
	 * 
	 * @author baifangfang
	 * @date 2016年8月29日
	 * @param url
	 * @return String
	 */
	public static String getData(String url) {
		logger.info("get url {}", url);

		String responseStr = "";
		try {
			Response resp;
			resp = Request.Get(url).execute();

			HttpResponse returnResponse = resp.returnResponse();
			StatusLine statusLine = returnResponse.getStatusLine();

			if (statusLine.getStatusCode() >= 300) {
				throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
			}
			responseStr = EntityUtils.toString(returnResponse.getEntity(), "utf-8");
		} catch (IOException e) {
//			logger.error("authen core error for url: {}", url, e);
		}
		return responseStr;
	}

	/**
	 * 描述:POST请求
	 * 
	 * @author baifangfang
	 * @date 2016年8月29日
	 * @param url
	 * @param requestBody
	 * @return String
	 * @throws IOException
	 */
	public static String postData(String url, String requestBody) throws IOException {
		logger.debug("post url {},requestBody {}", url, requestBody);
		String responseStr = "";
		responseStr = postJsonAction(requestBody, url);
		logger.debug("responseStr {}", responseStr);

		if (Strings.isNullOrEmpty(responseStr)) {
			throw new IOException("no response [" + responseStr + "] for fastreal request " + requestBody);
		} else {
			return responseStr;
		}
	}

	/**
	 * 
	 * 描述 : 发送put 请求 
	 * @author: 赵祥江 
	 * @date : 2016年7月21日 上午10:28:50 
	 * @param 
	 * @return: String 
	 * @throws
	 */
	public static String putData(String url, String requestBody) throws IOException {

		String responseStr = "";
		try {

			logger.debug("requestUrl {}, requestBody {}", url, requestBody);

			// String body = new ObjectMapper().writeValueAsString(requestObj);
			Response response = Request.Put(url).bodyString(requestBody, ContentType.APPLICATION_JSON).execute();

			HttpResponse returnResponse = response.returnResponse();

			StatusLine statusLine = returnResponse.getStatusLine();

			responseStr = EntityUtils.toString(returnResponse.getEntity());

			if (statusLine.getStatusCode() >= 300) {
				throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
			}
			//logger.info("{} response status: {} body: {}", url, statusLine, responseStr);

			return responseStr;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error("error request {}", requestBody, e);
			throw e;
		} catch (IOException e) {
			logger.error("error request {}", requestBody, e);
			throw e;
		}

	}

	/**
	 * 描述：将一个对象序列化为 JSON 格式，并 post 到一个目标 URL，将返回结果的 body 返回为一个 string
	 * 
	 * @author baifangfang
	 * @date 2016年8月29日
	 * @param requestObj
	 * @param url
	 * @return String
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private static String postJsonAction(String requestObj, String url) throws ClientProtocolException, IOException {
		logger.debug("requestUrl {}, requestBody {}", url, requestObj);

		Response response = Request.Post(url).bodyString(requestObj, ContentType.APPLICATION_JSON).execute();
		HttpResponse returnResponse = response.returnResponse();
		StatusLine statusLine = returnResponse.getStatusLine();
		String responseStr = EntityUtils.toString(returnResponse.getEntity());

		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

		//logger.info("{} response status: {} body: {}", url, statusLine, responseStr);
		return responseStr;
	}

	/**
	 * 
	 * 描述 : 发送delte 请求 
	 * @author: 赵祥江 
	 * @date : 2016年7月21日 上午10:28:50 
	 * @param
	 * @return: String 
	 * @throws
	 */
	public static String deleteData(String url) throws IOException {

		String responseStr = "";
		try {

			logger.debug("requestUrl {}, requestBody {}", url);

			// String body = new ObjectMapper().writeValueAsString(requestObj);
			Response response = Request.Delete(url).execute();

			HttpResponse returnResponse = response.returnResponse();

			StatusLine statusLine = returnResponse.getStatusLine();

			responseStr = EntityUtils.toString(returnResponse.getEntity());

			if (statusLine.getStatusCode() >= 300) {
				throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
			}
			//logger.info("{} response status: {} body: {}", url, statusLine, responseStr);

			return responseStr;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error("error request {}", e);
			throw e;
		} catch (IOException e) {
			logger.error("error request {}", e);
			throw e;
		}

	}
}
