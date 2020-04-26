package com.gcf.common.util.security.algorithm.x;

public enum Padding {
	NoPadding,ISO10126Padding,PKCS5Padding,PKCS7Padding,PKCS1Padding;
	
	public String getDefault() {
		return NoPadding.name();
	}
}
