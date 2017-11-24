package com.icinfo.cs.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.chinaoly.oss.SgsOSSClient;

/**
 * 描述：OSS相关调用方法
 * @author
 * @date
 * @throws
 */
@Component("ossClient")
public class OssClient {
	
	@Autowired
	SgsOSSClient soc;

	
	/**
	 * 列出文件夹下一定数目的文件
	 * @param dir 文件夹路径，路径结尾需带/，若dir为null或空或/，则为应用根目录
	 * @return
	 */
	public   List<String> listObjects(String dir, Integer num) {
		if (num < 1 || num > 1000) {
			return null;
		}
		List<String> list = soc.listObjects(dir, num);// 返回文件列表
		return list;
	}
	
	/**
	 * 列出对应文件夹下的所有文件
	 * @param dir 文件夹路径，路径结尾需带/，若dir为null或空或/，则为应用根目录
	 * @return
	 */
	public  List<String> listAllObjects(String dir) {
		List<String> list = soc.listAllObjects(dir);	// 返回文件列表
		return list;
	}
	
	/**
	 * 
	 * @param srcFilePath 文件来源路径
	 * @param targetFilePath   要上传到OSS上的文件路径
	 * @return
	 */
	public  boolean putFile(String srcFilePath, String targetFilePath) {
		System.out.println("文件来源路径：" + srcFilePath);
		System.out.println("要上传到OSS上的文件路径：" + targetFilePath);
		boolean result = soc.putFile(targetFilePath, srcFilePath);	// 返回true:上传成功；false：上传失败
		System.out.println("oss 上传结束，返回结果" + result);
		return result;
	}
	
	/**
	 * 
	 * @param srcFilePath 文件来源路径
	 * @param targetFilePath   要上传到OSS上的文件路径
	 * @return
	 */
	public  boolean putStream(String srcFilePath, String targetFilePath) throws IOException {
		File file = new File(srcFilePath);
		InputStream content = new FileInputStream(file);	  // 要上传的文件流
		boolean result = soc.putStream(targetFilePath, content);	 // 返回true:上传成功；false：上传失败
		content.close();
		System.out.println("oss 上传结束，返回结果" + result);
		return result;
	}
	
	/**
	 * 直接上传Spring mvc 的MultipartFile文件流
	 * @param file
	 * @param targetFilePath
	 * @return
	 * @throws IOException
	 */
	public  boolean putStream(MultipartFile file, String targetFilePath) throws Exception {
		System.out.println("OSS 上传开始");
		InputStream content =file.getInputStream();	  // 要上传的文件流
		boolean result = soc.putStream(targetFilePath, content);	 // 返回true:上传成功；false：上传失败
		content.close();
		System.out.println("oss 上传结束，返回结果" + result);
		return result;
	}
	
	/**
	 * 下载文件到本地
	 * @param srcFilePath OSS文件存放路径
	 * @param localFilePath 保存本地文件路径
	 */
	public  boolean saveFile(String srcFilePath, String localFilePath) {
		if (isWindows()) {
			localFilePath = localFilePath.replaceAll("\\\\", "/");
		}
		System.out.println("OSS 下载开始");
		System.out.println("OSS文件存放路径：" + srcFilePath);
		System.out.println("保存本地文件路径：" + localFilePath);
		boolean result = false;
		result = soc.saveFile(srcFilePath, localFilePath);	// 返回true:下载成功；false：下载失败
		System.out.println("oss 下载结束，返回结果" + result);
		return result;
	}

	/**
	 * 下载文件流
	 * @param srcFilePath --OSS文件存放路径
	 * @return
	 */
	public  byte[] getStream(String srcFilePath) throws Exception {
		System.out.println(new Date() + "--OSS 下载开始");
		System.out.println(new Date() + "--OSS文件存放路径：" + srcFilePath);
		byte[] data = null;
		InputStream result = soc.getStream(srcFilePath);	// 返回一个文件流
		data = readInputStream(result);
		return data;
	}
	
	public  byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		byte[] byteArray = outStream.toByteArray();
		outStream.close();
		return byteArray;
	}
	
	/**
	 * 生成签名URL
	 */
	public  String getUrl() {
		String key = "png/jpg/4.jpg";//OSS上的文件路径
		int seconds = 3600;//URL过期时间，单位为秒
		URL url = soc.getUrl(key, seconds);//返回文件签名URL
		return url.toString();
	}
	
	/**
	 * 删除文件
	 * @param srcFilePath --OSS上的文件路径
	 * @return
	 */
	public  boolean deleteObject(String srcFilePath) {
		boolean flag = false;
		soc.deleteObject(srcFilePath);// 删除文件
		return flag;
	}
	
//	/**
//	 * 关闭OSSClient,操作完必须关闭
//	 */
//	public  void close(){
//		soc.close();
//	}
	
	/**
	 * 描述: 判断是否为WINDOWS系统 
	 */
	private  final boolean isWindows() {
		return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
	}
	
	public void main(String[] args) {
		try {
			putFile("D:/111.txt", "test/111.txt");
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message: " + oe.getErrorMessage());
			System.out.println("Error Code: " + oe.getErrorCode());
			System.out.println("Request ID: " + oe.getRequestId());
			System.out.println("Host ID: " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Code: " + ce.getErrorCode());
			System.out.println("Error Message: " + ce.getErrorMessage());
		}
	}
	

}

