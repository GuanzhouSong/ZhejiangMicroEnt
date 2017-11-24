package com.icinfo.cs.common.utils;

/** 
 * 描述: 通用返回结果处理
 * @author ZhouYan
 * @date 2016年9月28日 
 * @param <T> 
 */
public class ResultRtn<T> {
	
	//返回对象
	private T data;
	//标记
	private boolean flag;
	//编码
	private String errorCode;
	//内容
	private String error;
	
	public ResultRtn(boolean flag){
		this.flag = flag;
	}
	
	public ResultRtn(T data){
		this.data = data;
		this.flag = true;
	}
	
	public ResultRtn(String errorCode,String error){
		this.errorCode = errorCode;
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.flag = true;
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.flag =false;
		this.error = error;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public boolean isSucess(){
		return this.flag == true;
	}
}
