package com.gcf.provider.code.exception;

import com.gcf.common.exception.GcfException;

public class GcfCodeException extends GcfException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9115743468060259388L;

	public GcfCodeException(int code, String msg) {
		super(code, msg);
	}

}
