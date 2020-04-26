package com.gcf.common.exception;

import com.gcf.common.bean.ResponseData;

public class GcfException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5606694707703655070L;
	public GcfException() {
		super();
	}
	public GcfException(String msg) {
		super(msg);
	}
	
	public ResponseData toResponseData() {
		return ResponseData.error(getMessage());
	}
}
