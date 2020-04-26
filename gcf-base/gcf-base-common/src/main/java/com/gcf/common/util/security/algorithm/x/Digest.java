package com.gcf.common.util.security.algorithm.x;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.gcf.common.util.security.Constants;
import com.gcf.common.util.security.Convert;

/**
 * 散列
 * 
 * @author Administrator
 *
 */
public class Digest {
	public enum DigestAlgorithm{
		MD5,SHA1,SHA224,SHA256,SHA384,SHA512
	}
	/**
	 * 根据指定算法、指定安全框架提供者计算散列
	 * 
	 * @param data
	 * @param algorithm
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doDigest(byte[] data, DigestAlgorithm algorithm, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		MessageDigest digest = MessageDigest.getInstance(algorithm.name(), provider);
		digest.update(data);
		byte[] b = digest.digest();
		return b;
	}

	/**
	 * 根据指定算法、默认安全框架提供者（BC）计算散列
	 * 
	 * @param data
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doDigest(byte[] data, DigestAlgorithm algorithm)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, algorithm, Constants.X.PROVIDER);
	}

	/**
	 * 根据指定安全框架提供者计算MD5散列
	 * 
	 * @param data
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doMD5Digest(byte[] data, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, DigestAlgorithm.MD5, provider);
	}

	/**
	 * 根据默认安全框架提供者计算MD5散列
	 * 
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doMD5Digest(byte[] data) throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, DigestAlgorithm.MD5);
	}

	/**
	 * 根据指定安全框架提供者计算SHA1散列
	 * 
	 * @param data
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doSHA1Digest(byte[] data, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, DigestAlgorithm.SHA1, provider);
	}

	/**
	 * 根据默认安全框架提供者（BC）计算SHA1散列
	 * 
	 * @param data
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doSHA1Digest(byte[] data) throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, DigestAlgorithm.SHA1);
	}

	/**
	 * 根据指定安全框架提供者计算SHA256散列
	 * 
	 * @param data
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doSHA256Digest(byte[] data, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, DigestAlgorithm.SHA256, provider);
	}

	/**
	 * 根据默认安全框架提供者（BC）计算SHA256散列
	 * 
	 * @param data
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static byte[] doSHA256Digest(byte[] data) throws NoSuchAlgorithmException, NoSuchProviderException {
		return doDigest(data, DigestAlgorithm.SHA256);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		System.out.println(Convert.byteToHex(Digest.doMD5Digest("123".getBytes())));
		System.out.println(Convert.byteToHex(Digest.doMD5Digest("1123".getBytes())));
		System.out.println(Convert.byteToHex(Digest.doDigest("123".getBytes(), DigestAlgorithm.SHA1)));
		System.out.println(Convert.byteToHex(Digest.doDigest("123".getBytes(), DigestAlgorithm.SHA224)));
		System.out.println(Convert.byteToHex(Digest.doDigest("123".getBytes(), DigestAlgorithm.SHA256)));
		System.out.println(Convert.byteToHex(Digest.doDigest("123".getBytes(), DigestAlgorithm.SHA384)));
		System.out.println(Convert.byteToHex(Digest.doDigest("123".getBytes(), DigestAlgorithm.SHA512)));
	}
}
