package com.gcf.common.util.security.algorithm.r;

import com.gcf.common.util.security.Convert;
import com.gcf.common.util.security.Xor;

/**
 * 字，作为国密算法基础计算单位
 * @author Administrator
 *
 */
public class Word {
	//字的值
	private byte[] g = new byte[4];

	public byte[] get() {
		return g;
	}

	public void set(byte[] in) {
		g[0] = in[0];
		g[1] = in[1];
		g[2] = in[2];
		g[3] = in[3];
	}

	public Word(byte[] g) {
		set(g);
	}

	public Word(int g) {
		set(Convert.intToByte(g));
	}

	/**
	 * Word异或
	 * @param sk
	 * @return
	 */
	public Word xOr(Word sk) {
		return new Word(Xor.xOR(get(), sk.get()));
	}
	
	/**
	 * Word与运算
	 * @param o
	 * @return
	 */
	public Word and (Word o) {
		byte[] w = new byte[4];
		w[0] = (byte)(g[0] & o.get()[0]);
		w[1] = (byte)(g[1] & o.get()[1]);
		w[2] = (byte)(g[2] & o.get()[2]);
		w[3] = (byte)(g[3] & o.get()[3]);
		return new Word(w);
	}
	
	/**
	 * Word或运算
	 * @param o
	 * @return
	 */
	public Word or (Word o) {
		byte[] w = new byte[4];
		w[0] = (byte)(g[0] | o.get()[0]);
		w[1] = (byte)(g[1] | o.get()[1]);
		w[2] = (byte)(g[2] | o.get()[2]);
		w[3] = (byte)(g[3] | o.get()[3]);
		return new Word(w);
	}
	
	/**
	 * Word非运算
	 * @return
	 */
	public Word not () {
		byte[] w = new byte[4];
		w[0] = (byte)(g[0] ^ 0xFF);
		w[1] = (byte)(g[1] ^ 0xFF);
		w[2] = (byte)(g[2] ^ 0xFF);
		w[3] = (byte)(g[3] ^ 0xFF);
		return new Word(w);
	}
	
	/**
	 * Word相加运算
	 * @param o
	 * @return
	 */
	public Word add (Word o) {
		return new Word(Convert.byteToInt(get()) + Convert.byteToInt(o.get()));
	}

	/**
	 * Word中bit位循环左移运算
	 * @param bit
	 * @return
	 */
	public Word loopLeft(int bit) {
		int bit8 = (bit / 8);
		byte[] buffer = new byte[4];
		buffer[0] = g[(bit8 + 0) % 4];
		buffer[1] = g[(bit8 + 1) % 4];
		buffer[2] = g[(bit8 + 2) % 4];
		buffer[3] = g[(bit8 + 3) % 4];
		
		int bit1 = bit % 8;
		byte g0 = buffer[0];
		buffer[0] = (byte)(((buffer[0] & 0xFF) << bit1) | ((buffer[1] & 0xFF) >> (8 - bit1)));
		buffer[1] = (byte)(((buffer[1] & 0xFF) << bit1) | ((buffer[2] & 0xFF) >> (8 - bit1)));
		buffer[2] = (byte)(((buffer[2] & 0xFF) << bit1) | ((buffer[3] & 0xFF) >> (8 - bit1)));
		buffer[3] = (byte)(((buffer[3] & 0xFF) << bit1) | ((g0 & 0xFF) >> (8 - bit1)));
		return new Word(buffer);
	}
	
	/**
	 * byte数组转成Word数组，byte数组长度必须是4的倍数
	 * @param in
	 * @return
	 * @throws SecurityException
	 */
	public static Word[] byteToWord(byte[] in) throws SecurityException {
		if(in.length % 4 != 0) {
			throw new SecurityException("in mulity 4");
		}
		Word[] buffer = new Word[in.length / 4];
		for(int i = 0; i < in.length;) {
			byte[] b = new byte[4];
			b[0] = in[i++];
			b[1] = in[i++];
			b[2] = in[i++];
			b[3] = in[i++];
			buffer[(i / 4) - 1] = new Word(b);
		}
		return buffer;
	}
	
	public String toString() {
		return Convert.byteToHexStr(g);
	}
}
