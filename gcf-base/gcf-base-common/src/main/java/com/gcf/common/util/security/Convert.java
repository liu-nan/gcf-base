package com.gcf.common.util.security;


public class Convert {

	//16进制对照表
	private static final char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };
	
	/**
	 * byte转16进制字符数组（数组长度位2）
	 * @param b
	 * @return
	 */
	public static char[] byteToHex(byte b) {
		char[] hex = new char[2];
		hex[0] = HEX_CHAR[(b & 0xF0) >>> 4];
		hex[1] = HEX_CHAR[b & 0xF];
		return hex;
	}
	
	/**
	 * byte转16进制字符串（字符串长度位2）
	 * @param b
	 * @return
	 */
	public static String byteToHexStr(byte b) {
		return new String(byteToHex(b));
	}
	
	/**
	 * byte数组转16进制字符数组（字符数组长度为byte数组长度的2倍）
	 * @param b
	 * @return
	 */
	public static char[] byteToHex(byte[] b) {

		char[] hex = new char[b.length << 1];
		char[] tmp;
		int off = 0;
		for (byte i : b) {
			tmp = byteToHex(i);
			hex[off++] = tmp[0];
			hex[off++] = tmp[1];
			
		}
		return hex;
	}
	
	/**
	 * byte数组转16进制字符串（字符串长度为byte数组长度的2倍）
	 * @param b
	 * @return
	 */
	public static String byteToHexStr(byte[] b) {
		return new String(byteToHex(b));
	}
	
	/**
	 * 16进制字符数组转byte数组（byte数组长度为字符数组长度的一半）
	 * @param hex
	 * @return
	 * @throws SecurityException
	 */
	public static byte[] hexToByte(char[] hex) throws SecurityException {
		int len = hex.length;

        if ((len & 0x01) != 0) {
            throw new SecurityException("bad parameter.");
        }
        byte[] arr = new byte[len >> 1];
        
        int off = 0;
        for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte)(((Character.digit(hex[off++], 16) << 4) | Character.digit(hex[off++], 16)) & 0xFF);
		}
        
		return arr;
	}

	/**
	 * 16进制字符串转byte数组（byte数组长度为字符串长度的一半）
	 * @param hex
	 * @return
	 * @throws SecurityException
	 */
	public static byte[] hexToByte(String hex) throws SecurityException {
		return hexToByte(hex.toCharArray());
	}
	
	/**
	 * int类型转byte数组，数组长度为4
	 * @param v
	 * @return
	 */
	public static byte[] intToByte(int v) {
		byte[] arr = new byte[4];
		arr[0] = (byte)(0xFF & (v >> 24));
		arr[1] = (byte)(0xFF & (v >> 16));
		arr[2] = (byte)(0xFF & (v >> 8));
		arr[3] = (byte)(0xFF & v);
		return arr;
	}
	
	/**
	 * byte数组转int，数组长度位4
	 * @param arr
	 * @return
	 */
	public static int byteToInt(byte[] arr) {
		int tmp = 0;
		tmp |= ((arr[0] & 0x000000FF) << 24);
		tmp |= ((arr[1] & 0x000000FF) << 16);
		tmp |= ((arr[2] & 0x000000FF) << 8);
		tmp |= (arr[3] & 0x000000FF);
		return tmp;
	}
	
	public static byte[] longToByte(long v) {
		byte[] arr = new byte[8];
		arr[0] = (byte)(0xFF & (v >> 56));
		arr[1] = (byte)(0xFF & (v >> 48));
		arr[2] = (byte)(0xFF & (v >> 40));
		arr[3] = (byte)(0xFF & (v >> 32));
		arr[4] = (byte)(0xFF & (v >> 24));
		arr[5] = (byte)(0xFF & (v >> 16));
		arr[6] = (byte)(0xFF & (v >> 8));
		arr[7] = (byte)(0xFF & v);
		return arr;
	}
	public static void main(String[] args) {
	}
}
