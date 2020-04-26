package com.gcf.common.util.security;

public class Xor {

	/**
	 * byte按位异或
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static final byte xOR(byte b1, byte b2) {
		return (byte)(b1 ^ b2);
	}
	
	/**
	 * byte数组按位异或
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static final byte[] xOR(byte[] b1, byte[] b2) {
		//异或后的数组长度与两个数组中较短的数组长度相同
		int resultLength = b1.length >= b2.length ? b2.length : b1.length;
		byte[] result = new byte[resultLength];
		for (int i = 0; i < result.length; i++) {
			result[i] = xOR(b1[i], b2[i]);
		}
		return result;
	}
}
