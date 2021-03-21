package com.gcf.common.util;

import com.gcf.common.constans.AlgorithmEnum;
import com.gcf.common.exception.GcfException;
import com.gcf.common.util.security.Convert;
import com.gcf.common.util.security.algorithm.r.SM4;
import com.gcf.common.util.security.algorithm.x.DES;

/**
 * 生成令牌
 * 
 * @author Administrator
 *
 */
public class ServiceTokenUtil {

	private AlgorithmEnum defaultAlgorithm = AlgorithmEnum.SM4;

	private String securityKey = "";

	private ServiceTokenUtil(String securityKey) throws GcfException {
		this(AlgorithmEnum.SM4, securityKey);
	}

	private ServiceTokenUtil(AlgorithmEnum algorithm, String securityKey) throws GcfException {
		if (null == securityKey) {
			throw new GcfException(500, "key is empty");
		}
		if (algorithm.equals(AlgorithmEnum.SM4) && securityKey.length() != 32) {
			throw new GcfException(500, "sm4 algorithm key length with 32");
		} else if (algorithm.equals(AlgorithmEnum.DES) && securityKey.length() != 16) {
			throw new GcfException(500, "sm4 algorithm key length with 16");
		} else if (algorithm.equals(AlgorithmEnum.DESede) && securityKey.length() != 32) {
			throw new GcfException(500, "sm4 algorithm key length with 32");
		}

		this.securityKey = securityKey;
	}

	public static final ServiceTokenUtil getInstance(String securityKey) throws GcfException {
		ServiceTokenUtil tokenUtil = new ServiceTokenUtil(securityKey);
		return tokenUtil;
	}
	public static final ServiceTokenUtil getInstance(AlgorithmEnum algorithm, String securityKey) throws GcfException {
		ServiceTokenUtil tokenUtil = new ServiceTokenUtil(securityKey);
		return tokenUtil;
	}

	public String getToken(String serviceId) throws GcfException {
		byte[] token= {};
		try {
			if(defaultAlgorithm.equals(AlgorithmEnum.SM4)) {
				token = SM4.encryptECB(Convert.hexToByte(securityKey), serviceId.getBytes());
			}else {
				token = DES.encryptECB(Convert.hexToByte(securityKey), serviceId.getBytes());
			}
		} catch (Exception e) {
			throw new GcfException(500, "security generic fail");
		}
		return Convert.byteToHexStr(token);
	}
	public boolean checkToken(String serviceId, String tokenExp) throws GcfException {
		byte[] token= {};
		try {
			if(defaultAlgorithm.equals(AlgorithmEnum.SM4)) {
				token = SM4.encryptECB(Convert.hexToByte(securityKey), serviceId.getBytes());
			}else {
				token = DES.encryptECB(Convert.hexToByte(securityKey), serviceId.getBytes());
			}
		} catch (Exception e) {
			throw new GcfException(500, "security generic fail");
		}
		return Convert.byteToHexStr(token).equals(tokenExp);
	}
}
