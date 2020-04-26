package com.gcf.common.util.security.algorithm.x;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.gcf.common.util.security.Constants;


public class CreateKey {
	//RSA算法标识
	protected static final String ALGORITHM = "RSA";

	/**
	 * 构建公钥对象
	 * @param provider
	 * @param key
	 * @return
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws Exception
	 */
	protected static PublicKey createPublicKey(String provider, byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, provider);
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	/**
	 * 构建公钥对象
	 * @param key
	 * @return
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws Exception
	 */
	protected static PublicKey createPublicKey(byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		return createPublicKey(Constants.X.PROVIDER, key);
	}

	/**
	 * 构建私钥对象
	 * 
	 * @param key
	 * @return
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws Exception
	 */
	protected static PrivateKey createPrivateKey(String provider, byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, provider);
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	/**
	 * 构建私钥对象
	 * 
	 * @param key
	 * @return
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws Exception
	 */
	protected static PrivateKey createPrivateKey(byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		return createPrivateKey(Constants.X.PROVIDER, key);
	}
}
