package com.gcf.common.constans;

public enum AlgorithmEnum {

	SM4("SM4"), DES("DES"), DESede("DESEDE");
	public String value;
	private AlgorithmEnum(String value) {
		this.value = value;
	}
}
