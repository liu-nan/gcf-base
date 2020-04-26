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

public class DES {
	private static final String ALGORITHM = "DES";
	private static final int DES_KEYSIZE = 64;

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
		return Cipher.getInstance(ALGORITHM + "/" + mode.name() + "/" + padding.name().toUpperCase(), provider);
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
	 * @throws SecurityException
	 */
	public static byte[] encryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException, SecurityException {
		if (padding.name().equals(Padding.NoPadding.name())) {
			if (data.length % 8 != 0) {
				throw new SecurityException("data mulity 8");
			}
		}
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
	 * @throws SecurityException
	 */
	public static byte[] encryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException, SecurityException {
		return encryptCBC(data, iv, key, padding, Constants.X.PROVIDER);
	}
	public static byte[] encryptCBC(byte[] data, byte[] iv, byte[] key)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException, SecurityException {
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
	 * @throws SecurityException
	 */
	public static byte[] decryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, SecurityException {
		if (padding.name().equals(Padding.NoPadding.name())) {
			if (data.length % 8 != 0) {
				throw new SecurityException("data mulity 8");
			}
		}
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
	 * @throws SecurityException
	 */
	public static byte[] decryptCBC(byte[] data, byte[] iv, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, SecurityException {
		return decryptCBC(data, iv, key, padding, Constants.X.PROVIDER);
	}
	public static byte[] decryptCBC(byte[] data, byte[] iv, byte[] key)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, SecurityException {
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
	 * @throws SecurityException
	 */
	public static byte[] encryptECB(byte[] data, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException, SecurityException {
		if (padding.name().equals(Padding.NoPadding.name())) {
			if (data.length % 8 != 0) {
				throw new SecurityException("data mulity 8");
			}
		}
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
	 * @throws SecurityException
	 */
	public static byte[] encryptECB(byte[] data, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			InvalidKeySpecException, SecurityException {
		return encryptECB(data, key, padding, Constants.X.PROVIDER);
	}

	public static byte[] encryptECB(byte[] data, byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException,
			NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException, SecurityException {
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
	 * @throws SecurityException
	 */
	public static byte[] decryptECB(byte[] data, byte[] key, Padding padding, String provider)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, SecurityException {
		if (padding.name().equals(Padding.NoPadding.name())) {
			if (data.length % 8 != 0) {
				throw new SecurityException("data mulity 8");
			}
		}
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
	 * @throws SecurityException
	 */
	public static byte[] decryptECB(byte[] data, byte[] key, Padding padding)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, SecurityException {
		return decryptECB(data, key, padding, Constants.X.PROVIDER);
	}

	public static byte[] decryptECB(byte[] data, byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException,
			NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, SecurityException {
		return decryptECB(data, key, Padding.NoPadding, Constants.X.PROVIDER);
	}

	/**
	 * 生成DES密钥
	 * 
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKey generatorKey(String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM, provider);
		generator.init(DES_KEYSIZE);
		SecretKey key = generator.generateKey();
		return new LocalKey(key.getEncoded());
	}

	/**
	 * 生成DES密钥
	 * 
	 * @param provider
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static LocalKey generatorKey() throws NoSuchAlgorithmException, NoSuchProviderException {
		return generatorKey(Constants.X.PROVIDER);
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchProviderException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException, com.gcf.common.util.security.SecurityException {
//		byte[] keyBytes = new byte[] { 0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef };
//		byte[] iv = new byte[] { 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00 };
//		byte[] cipherText = DES.encryptCBC("0123456789abcdef".getBytes(), iv, keyBytes, Padding.NoPadding);
//		byte[] cipherText1 = DES.encryptECB("0123456789abcdef".getBytes(), keyBytes, Padding.NoPadding);
//		System.out.println("cipher: " + HEX.byteToHexStr(cipherText) + " bytes: " + cipherText.length);
//		System.out.println("cipher: " + HEX.byteToHex(cipherText1) + " bytes: " + cipherText.length);
//		 System.out.println("plain:" + new String(DES.decryptCBC(cipherText, iv,
//		 keyBytes)));
		//
		// byte[] t = DES.encryptECB("aaa中文".getBytes(), iv, keyBytes);
		// System.out.println("cipher_ecb:" + HEX.byteToHex(t));
		// System.out.println("plain_ecb:" + new String(DES.decryptECB(t, keyBytes)));
		// System.out.println(generatorKey().getKeyString());
		// System.out.println(Mode.CBC.toString());
//		String plainText = "C24A8FB57AA20123";//96D605EA176B7E9E
//		String key = "70F2A84CCBC2AE8625CBB0F2C22AB923";
//		System.out.println(HEX.hexToByte(plainText).length);
//		byte[] cipherText = DESede.encryptECB(HEX.hexToByte(plainText), HEX.hexToByte(key));
//		System.out.println(HEX.byteToHex(cipherText));
		System.out.println(Convert.byteToHex("4D08F434464FE7BF".getBytes()));
		byte[] r = DES.encryptECB(Convert.hexToByte("0123456789abcdef"), Convert.hexToByte("0123456789abcdef"));
		System.out.println(Convert.byteToHex(r));
	}
}
