package com.gcf.common.util.security;

public interface Constants {
	// 16进制码表
	public static final String HEX_TABLE = "0123456789ABCDEF";

	//0向量
	public static final byte[] ZERO_IV_8 = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
	public static final byte[] ZERO_IV_16 = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

	/**
	 * 标密静态参数
	 * 
	 * @author Administrator
	 *
	 */
	public interface X {
		// 安全框架提供者
		public static final String PROVIDER = "BC";
	}

	/**
	 * 国密静态参数
	 * 
	 * @author Administrator
	 *
	 */
	public interface R {

	}
}
