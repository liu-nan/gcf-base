package com.gcf.common.constans;

/**
 * http请求响应状态
 * 200：成功
 * 400：失败
 * 500：服务器错误
 * @author Administrator
 *
 */
public enum ResponseStatusEnum {
	STATUS200("200"),STATUS400("400"),STATUS500("500");
	private String value;
	public String getValue() {
		return this.value;
	}
	ResponseStatusEnum(String value){
		this.value = value;
	}
}
