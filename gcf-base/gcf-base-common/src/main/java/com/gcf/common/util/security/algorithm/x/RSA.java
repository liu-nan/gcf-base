package com.gcf.common.util.security.algorithm.x;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;

import com.gcf.common.util.security.Constants;
import com.gcf.common.util.security.Convert;
import com.gcf.common.util.security.LocalKeyPair;

/**
 * RSA加密算法应用类
 * @author Administrator
 *
 */
public class RSA extends CreateKey {
	//RSA最大加密明文大小
	private static final int MAX_ENCRYPT_BLOCK = 117;
	//RSA最大解密密文大小
	private static final int MAX_DECRYPT_BLOCK = 128;
	//RSA密钥长度-1024
	public static final int RSA_KEYSIZE_1024 = 1024;
	//RSA密钥长度-2048
	public static final int RSA_KEYSIZE_2048 = 2048;
	/**
	 * 返回指定长度和指定安全框架提供者生成的密钥对
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKeyPair generatorKeyPair(int keySize, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandom = new SecureRandom();

		//为RSA算法创建一个KeyPairGenerator对象
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM, provider);

		//利用上面的随机数据源初始化这个KeyPairGenerator对象
		keyPairGenerator.initialize(keySize, secureRandom);

		//生成密匙对
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		//得到公钥
		Key publicKey = keyPair.getPublic();

		//得到私钥
		Key privateKey = keyPair.getPrivate();

		return new LocalKeyPair(publicKey.getEncoded(), privateKey.getEncoded());
	}
	
	/**
	 * 返回指定长度和默认安全框架提供者（BC）生成的密钥对
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKeyPair generatorKeyPair(int keySize) throws NoSuchAlgorithmException, NoSuchProviderException {
		return generatorKeyPair(keySize, Constants.X.PROVIDER);
	}
	
	/**
	 * 返回默认长度（1024）和指定安全框架提供者生成的密钥对
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKeyPair generatorKeyPair(String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
		return generatorKeyPair(RSA_KEYSIZE_1024, provider);
	}
	
	/**
	 * 返回默认长度（1024）和默认安全框架提供者（BC）生成的密钥对
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKeyPair generatorKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
		return generatorKeyPair(RSA_KEYSIZE_1024, Constants.X.PROVIDER);
	}



	/**
	 * 公钥加密
	 * @param plainText
	 * @param publicKey
	 * @param provider
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] plainText, byte[] publicKey, String provider) throws Exception {
		PublicKey publicK = createPublicKey(publicKey);
		Cipher cipher = Cipher.getInstance(ALGORITHM, provider);
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = plainText.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		int i = 0;
		byte[] cache;
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(plainText, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(plainText, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptText = out.toByteArray();
		out.close();
		return encryptText;
	}
	/**
	 * 公钥加密
	 * @param plainText
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] plainText, String publicKey, String provider) throws Exception {
		return encrypt(plainText, Convert.hexToByte(publicKey), provider);
	}
	/**
	 * 公钥加密
	 * @param plainText
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] plainText, byte[] publicKey) throws Exception {
		return encrypt(plainText, publicKey, Constants.X.PROVIDER);
	}
	/**
	 * 公钥加密
	 * @param plainText
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] plainText, String publicKey) throws Exception {
		return encrypt(plainText, Convert.hexToByte(publicKey), Constants.X.PROVIDER);
	}

	/**
	 * 私钥解密
	 * 
	 * @param encryptText
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encryptText, byte[] privateKey, String provider) throws Exception {
		PrivateKey privateK = createPrivateKey(privateKey);
		Cipher cipher = Cipher.getInstance(ALGORITHM, provider);
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptText.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptText, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptText, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] plainText = out.toByteArray();
		out.close();
		return plainText;
	}
	
	/**
	 * 私钥解密
	 * 
	 * @param encryptText
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encryptText, String privateKey, String provider) throws Exception {
		return decrypt(encryptText, Convert.hexToByte(privateKey), provider);
	}
	/**
	 * 私钥解密
	 * 
	 * @param encryptText
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encryptText, byte[] privateKey) throws Exception {
		return decrypt(encryptText, privateKey, Constants.X.PROVIDER);
	}
	/**
	 * 私钥解密
	 * 
	 * @param encryptText
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encryptText, String privateKey) throws Exception {
		return decrypt(encryptText, Convert.hexToByte(privateKey), Constants.X.PROVIDER);
	}

	

	public static void main(String[] args) {
		byte[] cipherText;
		String input = "Hello World!测试";
		try {
			LocalKeyPair keyPair = generatorKeyPair();
			String publicKey = keyPair.getPublicKeyString();
			System.out.println("公钥------------------");
			System.out.println(publicKey);
			String privateKey = keyPair.getPrivateKeyString();
			System.out.println("私钥------------------");
			System.out.println(privateKey);

			System.out.println("测试可行性-------------------");
			System.out.println("明文=======" + input);

			cipherText = encrypt(input.getBytes(), publicKey);
			// 加密后的东西
			System.out.println("密文=======" + new String(cipherText));
			// 开始解密
			byte[] plainText = decrypt(cipherText, privateKey);
			System.out.println("解密后明文===== " + new String(plainText));
			System.out.println("验证签名-----------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
