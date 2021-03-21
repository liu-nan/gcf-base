package com.gcf.common.exception;

import com.gcf.common.bean.ResponseData;

public class GcfException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5606694707703655070L;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private final int code;

	private final String msg;

	public GcfException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public ResponseData toResponseData() {
		return ResponseData.error(getMessage());
	}
}
