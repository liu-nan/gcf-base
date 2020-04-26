package com.gcf.common.util.security;

import java.io.Serializable;


public class LocalKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9167735261564756092L;
	private String key;
	public String getKeyString() {
		return key;
	}
	public void setKeyString(String key) {
		this.key = key;
	}
	public byte[] getKeyByte() throws SecurityException {
		return Convert.hexToByte(this.key);
	}
	public void setKeyByte(byte[] key) {
		this.key = Convert.byteToHexStr(key);
	}
	
	public LocalKey(String key){
		this.key = key;
	}
	public LocalKey(byte[] key) {
		this.key = Convert.byteToHexStr(key);
	}
	public LocalKey() {
		
	}
}
