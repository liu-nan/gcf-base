package com.gcf.common.util.security.algorithm.x;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.gcf.common.util.security.Constants;
import com.gcf.common.util.security.Convert;
import com.gcf.common.util.security.LocalKey;

public class DESede {
	private static final String ALGORITHM = "DESede";
	public static final int DESEDE_KEYSIZE_192 = 192;
	public static final int DESEDE_KEYSIZE_128 = 128;

	/**
	 * 创建加密对象
	 * 
	 * @param mode
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 */
	private static Cipher createCipher(TransformationMode mode, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		return Cipher.getInstance(ALGORITHM + "/" + mode.name() + "/" + padding.name(), provider);
	}

	/**
	 * 根据byte数组密钥，创建加密密钥对象
	 * 
	 * @param keyByte
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private static SecretKey createKey(byte[] keyByte, String provider)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		return new SecretKeySpec(keyByte, ALGORITHM);
	}

	/**
	 * CBC模式加密/指定安全框架提供者
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] encryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException {
		Cipher cipher = createCipher(TransformationMode.CBC, padding, provider);
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, createKey(key, provider), ivSpec);
		byte[] cipherText = new byte[cipher.getOutputSize(data.length)];
		int ctLength = cipher.update(data, 0, data.length, cipherText, 0);

		ctLength += cipher.doFinal(cipherText, ctLength);

		return cipherText;
	}

	/**
	 * CBC模式加密/默认安全框架提供者（BC）
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] encryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException {
		return encryptCBC(data, iv, key, padding, Constants.X.PROVIDER);
	}
	public static byte[] encryptCBC(byte[] data, byte[] iv, byte[] key)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException {
		return encryptCBC(data, iv, key, Padding.NoPadding, Constants.X.PROVIDER);
	}

	/**
	 * CBC模式解密
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] decryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		Cipher cipher = createCipher(TransformationMode.CBC, padding, provider);
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, createKey(key, provider), ivSpec);
		byte[] plainText = new byte[cipher.getOutputSize(data.length)];
		int ctLength = cipher.update(data, 0, data.length, plainText, 0);

		ctLength += cipher.doFinal(plainText, ctLength);

		return plainText;
	}

	/**
	 * CBC模式解密
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException 
	 */
	public static byte[] decryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		return decryptCBC(data, iv, key, padding, Constants.X.PROVIDER);
	}
	public static byte[] decryptCBC(byte[] data, byte[] iv, byte[] key)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		return decryptCBC(data, iv, key, Padding.NoPadding, Constants.X.PROVIDER);
	}

	/**
	 * ECB模式加密/指定安全框架提供者
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeySpecException 
	 */
	public static byte[] encryptECB(byte[] data, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		Cipher cipher = createCipher(TransformationMode.ECB, padding, provider);
		cipher.init(Cipher.ENCRYPT_MODE, createKey(key, provider));
		byte[] cipherText = new byte[cipher.getOutputSize(data.length)];
		int ctLength = cipher.update(data, 0, data.length, cipherText, 0);

		ctLength += cipher.doFinal(cipherText, ctLength);

		return cipherText;
	}

	/**
	 * ECB模式加密/默认安全框架提供者（BC）
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeySpecException 
	 */
	public static byte[] encryptECB(byte[] data, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		return encryptECB(data, key, padding, Constants.X.PROVIDER);
	}
	public static byte[] encryptECB(byte[] data, byte[] key)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		return encryptECB(data, key, Padding.NoPadding, Constants.X.PROVIDER);
	}

	/**
	 * ECB模式解密
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException 
	 */
	public static byte[] decryptECB(byte[] data, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		Cipher cipher = createCipher(TransformationMode.ECB, padding, provider);
		cipher.init(Cipher.DECRYPT_MODE, createKey(key, provider));
		byte[] buffer = new byte[cipher.getOutputSize(data.length)];
		int ctLength = cipher.update(data, 0, data.length, buffer, 0);

		ctLength += cipher.doFinal(buffer, ctLength);

		return buffer;
	}

	/**
	 * ECB模式解密
	 * 
	 * @param data
	 * @param iv
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws ShortBufferException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] decryptECB(byte[] data, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		return decryptECB(data, key, padding, Constants.X.PROVIDER);
	}
	public static byte[] decryptECB(byte[] data, byte[] key)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		return decryptECB(data, key, Padding.NoPadding, Constants.X.PROVIDER);
	}
	
	
	/**
	 * 生成3DES密钥
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKey generatorKey(int keySize, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM, provider);
		generator.init(keySize);
		SecretKey key = generator.generateKey();
		return new LocalKey(key.getEncoded());
	}
	
	/**
	 * 生成3DES密钥
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKey generatorKey(int keySize) throws NoSuchAlgorithmException, NoSuchProviderException {
		return generatorKey(keySize, Constants.X.PROVIDER);
	}

	public static void main(String[] args)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException, com.gcf.common.util.security.SecurityException {
		byte[] keyBytes = Convert.hexToByte("94520BC2261FF237AEB6A10D6BD615D5");//generatorKey(DESede.DESEDE_KEYSIZE_128).getKeyByte();
//		byte[] iv = new byte[] { 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00 };
//		byte[] cipherText = DESede.encryptCBC("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef".getBytes(), iv,
//				keyBytes);
//		System.out.println("cipher: " + HEX.byteToHex(cipherText) + " bytes: " + cipherText.length);
//		System.out.println("plain:" + new String(DESede.decryptCBC(cipherText, iv, keyBytes, "BC")));

		byte[] t = DESede.encryptECB("061253DFFEDCBA98".getBytes(), keyBytes, Padding.NoPadding);
		System.out.println("cipher_ecb:" + Convert.byteToHexStr(t));
		System.out.println("plain_ecb:" + new String(DESede.decryptECB(t, keyBytes, Padding.NoPadding)));
//		System.out.println(generatorKey(DESede.DESEDE_KEYSIZE_128).getKeyString());
		
	}
}
