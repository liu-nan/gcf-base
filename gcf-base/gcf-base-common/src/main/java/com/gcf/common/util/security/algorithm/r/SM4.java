package com.gcf.common.util.security.algorithm.r;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.gcf.common.util.security.Convert;
import com.gcf.common.util.security.Xor;

public class SM4 {

	// s盒
	public static final byte[] S_BOX = { (byte) 0xd6, (byte) 0x90, (byte) 0xe9, (byte) 0xfe, (byte) 0xcc, (byte) 0xe1,
			0x3d, (byte) 0xb7, 0x16, (byte) 0xb6, 0x14, (byte) 0xc2, 0x28, (byte) 0xfb, 0x2c, 0x05, 0x2b, 0x67,
			(byte) 0x9a, 0x76, 0x2a, (byte) 0xbe, 0x04, (byte) 0xc3, (byte) 0xaa, 0x44, 0x13, 0x26, 0x49, (byte) 0x86,
			0x06, (byte) 0x99, (byte) 0x9c, 0x42, 0x50, (byte) 0xf4, (byte) 0x91, (byte) 0xef, (byte) 0x98, 0x7a, 0x33,
			0x54, 0x0b, 0x43, (byte) 0xed, (byte) 0xcf, (byte) 0xac, 0x62, (byte) 0xe4, (byte) 0xb3, 0x1c, (byte) 0xa9,
			(byte) 0xc9, 0x08, (byte) 0xe8, (byte) 0x95, (byte) 0x80, (byte) 0xdf, (byte) 0x94, (byte) 0xfa, 0x75,
			(byte) 0x8f, 0x3f, (byte) 0xa6, 0x47, 0x07, (byte) 0xa7, (byte) 0xfc, (byte) 0xf3, 0x73, 0x17, (byte) 0xba,
			(byte) 0x83, 0x59, 0x3c, 0x19, (byte) 0xe6, (byte) 0x85, 0x4f, (byte) 0xa8, 0x68, 0x6b, (byte) 0x81,
			(byte) 0xb2, 0x71, 0x64, (byte) 0xda, (byte) 0x8b, (byte) 0xf8, (byte) 0xeb, 0x0f, 0x4b, 0x70, 0x56,
			(byte) 0x9d, 0x35, 0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, (byte) 0xd1, (byte) 0xa2, 0x25, 0x22, 0x7c, 0x3b,
			0x01, 0x21, 0x78, (byte) 0x87, (byte) 0xd4, 0x00, 0x46, 0x57, (byte) 0x9f, (byte) 0xd3, 0x27, 0x52, 0x4c,
			0x36, 0x02, (byte) 0xe7, (byte) 0xa0, (byte) 0xc4, (byte) 0xc8, (byte) 0x9e, (byte) 0xea, (byte) 0xbf,
			(byte) 0x8a, (byte) 0xd2, 0x40, (byte) 0xc7, 0x38, (byte) 0xb5, (byte) 0xa3, (byte) 0xf7, (byte) 0xf2,
			(byte) 0xce, (byte) 0xf9, 0x61, 0x15, (byte) 0xa1, (byte) 0xe0, (byte) 0xae, 0x5d, (byte) 0xa4, (byte) 0x9b,
			0x34, 0x1a, 0x55, (byte) 0xad, (byte) 0x93, 0x32, 0x30, (byte) 0xf5, (byte) 0x8c, (byte) 0xb1, (byte) 0xe3,
			0x1d, (byte) 0xf6, (byte) 0xe2, 0x2e, (byte) 0x82, 0x66, (byte) 0xca, 0x60, (byte) 0xc0, 0x29, 0x23,
			(byte) 0xab, 0x0d, 0x53, 0x4e, 0x6f, (byte) 0xd5, (byte) 0xdb, 0x37, 0x45, (byte) 0xde, (byte) 0xfd,
			(byte) 0x8e, 0x2f, 0x03, (byte) 0xff, 0x6a, 0x72, 0x6d, 0x6c, 0x5b, 0x51, (byte) 0x8d, 0x1b, (byte) 0xaf,
			(byte) 0x92, (byte) 0xbb, (byte) 0xdd, (byte) 0xbc, 0x7f, 0x11, (byte) 0xd9, 0x5c, 0x41, 0x1f, 0x10, 0x5a,
			(byte) 0xd8, 0x0a, (byte) 0xc1, 0x31, (byte) 0x88, (byte) 0xa5, (byte) 0xcd, 0x7b, (byte) 0xbd, 0x2d, 0x74,
			(byte) 0xd0, 0x12, (byte) 0xb8, (byte) 0xe5, (byte) 0xb4, (byte) 0xb0, (byte) 0x89, 0x69, (byte) 0x97, 0x4a,
			0x0c, (byte) 0x96, 0x77, 0x7e, 0x65, (byte) 0xb9, (byte) 0xf1, 0x09, (byte) 0xc5, 0x6e, (byte) 0xc6,
			(byte) 0x84, 0x18, (byte) 0xf0, 0x7d, (byte) 0xec, 0x3a, (byte) 0xdc, 0x4d, 0x20, 0x79, (byte) 0xee, 0x5f,
			0x3e, (byte) 0xd7, (byte) 0xcb, 0x39, 0x48 };
	public static final Word[] FK = { new Word(0xa3b1bac6), new Word(0x56aa3350), new Word(0x677d9197),
			new Word(0xb27022dc) };

	public static final Word[] CK = { new Word(0x00070e15), new Word(0x1c232a31), new Word(0x383f464d),
			new Word(0x545b6269), new Word(0x70777e85), new Word(0x8c939aa1), new Word(0xa8afb6bd),
			new Word(0xc4cbd2d9), new Word(0xe0e7eef5), new Word(0xfc030a11), new Word(0x181f262d),
			new Word(0x343b4249), new Word(0x50575e65), new Word(0x6c737a81), new Word(0x888f969d),
			new Word(0xa4abb2b9), new Word(0xc0c7ced5), new Word(0xdce3eaf1), new Word(0xf8ff060d),
			new Word(0x141b2229), new Word(0x30373e45), new Word(0x4c535a61), new Word(0x686f767d),
			new Word(0x848b9299), new Word(0xa0a7aeb5), new Word(0xbcc3cad1), new Word(0xd8dfe6ed),
			new Word(0xf4fb0209), new Word(0x10171e25), new Word(0x2c333a41), new Word(0x484f565d),
			new Word(0x646b7279) };

	/**
	 * 非线性变换
	 * 
	 * @param in
	 * @return
	 */
	private static final Word r(Word in) {
		byte[] out = new byte[4];
		for (int i = 0; i < out.length; i++) {
			out[i] = S_BOX[in.get()[i] & 0xFF];
		}
		return new Word(out);
	}

	/**
	 * 线性变换
	 * 
	 * @param b
	 * @return
	 */
	private static final Word l(Word b) {
		return b.xOr(b.loopLeft(2)).xOr(b.loopLeft(10)).xOr(b.loopLeft(18)).xOr(b.loopLeft(24));
	}

	private static final Word l1(Word b) {
		return b.xOr(b.loopLeft(13)).xOr(b.loopLeft(23));
	}

	/**
	 * 合成置换
	 * 
	 * @param sk1
	 * @param sk2
	 * @param sk3
	 * @param ck
	 * @return
	 */
	private static final Word t(Word sk1, Word sk2, Word sk3, Word ck) {
		Word sk = sk1.xOr(sk2).xOr(sk3).xOr(ck);
		return l(r(sk));
	}

	private static final Word t1(Word sk1, Word sk2, Word sk3, Word ck) {
		Word sk = sk1.xOr(sk2).xOr(sk3).xOr(ck);
		return l1(r(sk));
	}

	/**
	 * 密钥扩散-计算轮密钥
	 * 
	 * @param mk
	 * @return
	 */
	private static final Word[] calculateStepKey(byte[] mk) {
		Word[] key = new Word[36];
		byte[] temp = new byte[4];
		int off = 0;
		for (int i = 0; i < mk.length;) {
			System.arraycopy(mk, i, temp, 0, 4);
			key[off] = new Word(temp).xOr(FK[off]);
			i += 4;
			off++;
		}
		for (; off < 36; off++) {
			key[off] = key[off - 4].xOr(t1(key[off - 3], key[off - 2], key[off - 1], CK[off - 4]));
		}
		Word[] sk = new Word[32];
		System.arraycopy(key, 4, sk, 0, 32);
		return sk;
	}

	/**
	 * 加密
	 * 
	 * @param key
	 * @param data
	 * @return
	 * @throws SecurityException
	 */
	private static final Word[] encrypt(Word[] sk, Word[] data) throws SecurityException {
		if (data.length != 4) {
			throw new SecurityException("data not padding");
		}

		Word[] buffer = new Word[36];
		System.arraycopy(data, 0, buffer, 0, 4);

		for (int i = 4; i < 36; i++) {
			buffer[i] = buffer[i - 4].xOr(t(buffer[i - 3], buffer[i - 2], buffer[i - 1], sk[i - 4]));
		}
		Word[] result = new Word[4];
		System.arraycopy(buffer, 32, result, 0, 4);
		return result;
	}

	/**
	 * 解密
	 * 
	 * @param sk
	 * @param data
	 * @return
	 * @throws SecurityException
	 */
	private static final Word[] decrypt(Word[] sk, Word[] data) throws SecurityException {
		if (data.length != 4) {
			throw new SecurityException("data not padding");
		}

		Word[] buffer = new Word[36];
		System.arraycopy(data, 0, buffer, 0, 4);

		for (int i = 4; i < 36; i++) {
			buffer[i] = buffer[i - 4].xOr(t(buffer[i - 3], buffer[i - 2], buffer[i - 1], sk[31 - i + 4]));
		}
		Word[] result = new Word[4];
		System.arraycopy(buffer, 32, result, 0, 4);
		return result;
	}

	/**
	 * ECB加密
	 * 
	 * @param key
	 * @param data
	 * @return
	 * @throws IOException
	 * @throws SecurityException
	 */
	public static final byte[] encryptECB(byte[] key, byte[] data) throws IOException, SecurityException {
		Word[] sk = calculateStepKey(key);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int off = 0;
		while (off < data.length) {
			byte[] b = new byte[16];
			System.arraycopy(data, off, b, 0, 16);
			Word[] result = encrypt(sk, Word.byteToWord(b));
			for (int i = result.length; i > 0; i--) {
				out.write(result[i - 1].get());
			}
			off += 16;
		}
		byte[] outByte = out.toByteArray();
		out.close();
		out.flush();
		return outByte;
	}

	/**
	 * ECB解密
	 * 
	 * @param key
	 * @param data
	 * @return
	 * @throws IOException
	 * @throws SecurityException
	 */
	public static final byte[] decryptECB(byte[] key, byte[] data) throws IOException, SecurityException {
		Word[] sk = calculateStepKey(key);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int off = 0;
		while (off < data.length) {
			byte[] b = new byte[16];
			System.arraycopy(data, off, b, 0, 16);
			Word[] result = decrypt(sk, Word.byteToWord(b));
			for (int i = result.length; i > 0; i--) {
				out.write(result[i - 1].get());
			}
			off += 16;
		}
		byte[] outByte = out.toByteArray();
		out.close();
		out.flush();
		return outByte;
	}

	/**
	 * CBC加密
	 * 
	 * @param key
	 * @param data
	 * @param iv
	 * @return
	 * @throws IOException
	 * @throws SecurityException
	 */
	public static final byte[] encryptCBC(byte[] key, byte[] data, byte[] iv) throws IOException, SecurityException {
		Word[] sk = calculateStepKey(key);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int off = 0;
		while (off < data.length) {
			byte[] b = new byte[16];
			System.arraycopy(data, off, b, 0, 16);
			b = Xor.xOR(b, iv);
			Word[] result = encrypt(sk, Word.byteToWord(b));
			for (int i = result.length; i > 0; i--) {
				out.write(result[i - 1].get());
			}
			off += 16;
		}
		byte[] outByte = out.toByteArray();
		out.close();
		out.flush();
		return outByte;
	}

	/**
	 * CBC解密
	 * 
	 * @param key
	 * @param data
	 * @param iv
	 * @return
	 * @throws IOException
	 * @throws SecurityException
	 */
	public static final byte[] decryptCBC(byte[] key, byte[] data, byte[] iv) throws IOException, SecurityException {
		Word[] sk = calculateStepKey(key);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int off = 0;
		while (off < data.length) {
			byte[] b = new byte[16];
			System.arraycopy(data, off, b, 0, 16);
			Word[] result = decrypt(sk, Word.byteToWord(b));
			byte[] resultByte = new byte[result.length << 2];
			int roff = 0;
			for (int i = result.length; i > 0; i--) {
				System.arraycopy(result[i - 1].get(), 0, resultByte, roff, 4);
				roff += 4;
			}
			resultByte = Xor.xOR(resultByte, iv);
			out.write(resultByte);
			off += 16;
		}
		byte[] outByte = out.toByteArray();
		out.close();
		out.flush();
		return outByte;
	}

	public static void main(String[] args) throws com.gcf.common.util.security.SecurityException, IOException {
		System.out.println(4 << 2);

		// Step[] key =
		// calculateStepKey(HEX.hexToByte("0123456789ABCDEFFEDCBA9876543210"));
		// for (Step stepKey : key) {
		// System.out.println(stepKey.toString());
		// }
		//
		// byte[] text =
		// encryptECB(HEX.hexToByte("0123456789ABCDEFFEDCBA9876543210"),HEX.hexToByte("0123456789ABCDEFFEDCBA9876543210"));
		// System.out.println(HEX.byteToHexStr(text));
		// System.out.println(HEX.byteToHexStr(decryptECB(HEX.hexToByte("0123456789ABCDEFFEDCBA9876543210"),HEX.hexToByte("681EDF34D206965E86B3E94F536E4246"))));

		byte[] text = encryptCBC(Convert.hexToByte("0123456789ABCDEFFEDCBA9876543210"),
				Convert.hexToByte("0123456789ABCDEFFEDCBA9876543210"),
				Convert.hexToByte("0123456789ABCDEFFEDCBA9876543210"));
		System.out.println(Convert.byteToHexStr(text));
		System.out.println(Convert.byteToHexStr(decryptCBC(Convert.hexToByte("0123456789ABCDEFFEDCBA9876543210"),
				Convert.hexToByte("2677F46B09C122CC975533105BD4A22A"),
				Convert.hexToByte("0123456789ABCDEFFEDCBA9876543210"))));
	}
}
