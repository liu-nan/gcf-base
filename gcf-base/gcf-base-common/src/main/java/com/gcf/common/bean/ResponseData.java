package com.gcf.common.bean;


/**
 * rest响应
 * 类不能被继承
 * @author Administrator
 *
 */
public final class ResponseData {
	
	public static final String STATUS_CODE_SUCCESS = "200";
	public static final String STATUS_CODE_FAIL = "400";
	public static final String STATUS_CODE_ERROR = "500";
	
	public static final String SUCCESS_MSG = "SUCCESS";
	public static final String FAIL_MSG = "FAIL";
	public static final String ERROR_MSG = "ERROR";

	private ResponseData() {
		
	}
	private ResponseData(String status, String msg, Object data) {
		this.responseStatus = status;
		this.responseMsg = msg;
		this.responseData = data;
	}
	//响应状态
	private String responseStatus = "";
	//响应消息
	private String responseMsg = "";
	//响应内容
	private Object responseData = null;
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	
	
	//请求成功
	public static ResponseData ok() {
		return new ResponseData(STATUS_CODE_SUCCESS, SUCCESS_MSG, null);
	}
	public static ResponseData ok(Object data) {
		return new ResponseData(STATUS_CODE_SUCCESS, SUCCESS_MSG, data);
	}
	public static ResponseData ok(String msg) {
		return new ResponseData(STATUS_CODE_SUCCESS, msg, null);
	}
	public static ResponseData ok(String msg, Object data) {
		return new ResponseData(STATUS_CODE_SUCCESS, msg, data);
	}
	
	//请求失败
	public static ResponseData fail() {
		return new ResponseData(STATUS_CODE_FAIL, FAIL_MSG, null);
	}
	public static ResponseData fail(Object data) {
		return new ResponseData(STATUS_CODE_FAIL, FAIL_MSG, data);
	}
	public static ResponseData fail(String msg) {
		return new ResponseData(STATUS_CODE_FAIL, msg, null);
	}
	public static ResponseData fail(String msg, Object data) {
		return new ResponseData(STATUS_CODE_FAIL, msg, data);
	}
	
	//请求异常
	public static ResponseData error() {
		return new ResponseData(STATUS_CODE_ERROR, ERROR_MSG, null);
	}
	public static ResponseData error(Object data) {
		return new ResponseData(STATUS_CODE_ERROR, ERROR_MSG, data);
	}
	public static ResponseData error(String msg) {
		return new ResponseData(STATUS_CODE_ERROR, msg, null);
	}
	public static ResponseData error(String msg, Object data) {
		return new ResponseData(STATUS_CODE_ERROR, msg, data);
	}
}
