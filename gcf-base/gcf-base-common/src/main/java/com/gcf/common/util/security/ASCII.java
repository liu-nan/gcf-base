package com.gcf.common.util.security;

/**
 * ASCII码转换
 * @author Administrator
 *
 */
public class ASCII {

	public static int charToInt(char c) {
		return (int) c;
	}

	public static int[] charArrToIntArr(char[] cArr) {
		int[] result = new int[cArr.length];
		for (int i = 0; i < cArr.length; i++) {
			result[i] = charToInt(cArr[i]);
		}
		return result;
	}

	public static int[] stringToIntArr(String s) {
		return charArrToIntArr(s.toCharArray());
	}

	public static byte charToByte(char c) {
		return (byte) c;
	}

	public static byte[] charArrToByteArr(char[] cArr) {
		byte[] result = new byte[cArr.length];
		for (int i = 0; i < cArr.length; i++) {
			result[i] = charToByte(cArr[i]);
		}
		return result;
	}

	public static byte[] stringToByteArr(String s) {
		return charArrToByteArr(s.toCharArray());
	}

	public static char intToChar(int c) {
		return (char) c;
	}

	public static char[] intArrToCharArr(int[] cArr) {
		char[] result = new char[cArr.length];
		for (int i = 0; i < cArr.length; i++) {
			result[i] = intToChar(cArr[i]);
		}
		return result;
	}

	public static String intArrToString(int[] s) {
		return new String(intArrToCharArr(s));
	}

	public static char byteToChar(byte c) {
		return (char) c;
	}

	public static char[] byteArrToCharArr(byte[] s) {
		char[] result = new char[s.length];
		for (int i = 0; i < s.length; i++) {
			result[i] = byteToChar(s[i]);
		}
		return result;
	}

	public static String byteArrToString(byte[] s) {
		return new String(byteArrToCharArr(s));
	}

	public static void main(String[] args) {
		char a = '1';
		int b = (int) a;
		System.out.println(b);
	}
}
