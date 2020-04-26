package com.gcf.common.util.security.algorithm.r;

import com.gcf.common.util.security.Convert;

/**
 * SM3杂凑算法
 * @author Administrator
 *
 */
public class SM3 {
	
	//hash值byte长度
	private static final int HASH_LENGTH_BYTE = 32;
	//hash值WORD长度
	private static final int HASH_LENGTH_WORD = 8;
	
	public static int getHashLenByte() {
		return HASH_LENGTH_BYTE;
	}
	
	private static final int BLOCK_LENGTH_BYTE = 64;
	private static final int BLOCK_LENGTH_WORD = 16;
	
	// 初始向量，用于杂凑函数初始化寄存器，详细说明见《SM3密码杂凑算法》4.1初始值
	public static final Word[] IV = { new Word(0x7380166f), new Word(0x4914b2b9), new Word(0x172442d7),
			new Word(0xda8a0600), new Word(0xa96f30bc), new Word(0x163138aa), new Word(0xe38dee4d),
			new Word(0xb0fb0e4e) };
	// SM3常量；当数组下标大于等于0并且小于等于15时，填充0x79CC4519;当数组下标大于等于16并且小于等于63时，填充0x7A879D8A；详细说明见《SM3密码杂凑算法》4.2常量
	public static final Word[] TJ = { new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519),
			new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519),
			new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519),
			new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519), new Word(0x79cc4519),
			new Word(0x79cc4519), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a), new Word(0x7a879d8a),
			new Word(0x7a879d8a) };

	/**
	 * 置换函数
	 * 
	 * @param w
	 * @return
	 */
	private static final Word p0(Word w) {
		return w.xOr(w.loopLeft(9)).xOr(w.loopLeft(17));
	}

	private static final Word p1(Word w) {
		return w.xOr(w.loopLeft(15)).xOr(w.loopLeft(23));
	}

	/**
	 * 布尔函数
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param j
	 * @return
	 */
	private static final Word ff(Word x, Word y, Word z, int j) {
		if (j < 16) {
			return x.xOr(y).xOr(z);
		} else {
			return x.and(y).or(x.and(z)).or(y.and(z));
		}
	}

	private static final Word gg(Word x, Word y, Word z, int j) {
		if (j < 16) {
			return x.xOr(y).xOr(z);
		} else {
			return x.and(y).or(x.not().and(z));
		}
	}

	/**
	 * 数据填充
	 * 
	 * @param in
	 * @return
	 */
	private static final byte[] padding(byte[] in) {
		int inLen = in.length;
		byte[] paddingLength = Convert.longToByte(inLen * 8);

		int resultLength = (inLen + 9) % BLOCK_LENGTH_BYTE == 0 ? (inLen + 9) : (((inLen + 9 + BLOCK_LENGTH_BYTE) >> 6) << 6);
		byte[] paddingIn = new byte[resultLength];

		System.arraycopy(in, 0, paddingIn, 0, inLen);
		paddingIn[inLen] = (byte) 0x80;
		System.arraycopy(paddingLength, 0, paddingIn, resultLength - 8, 8);
		return paddingIn;
	}

	/**
	 * 消息扩展
	 * 
	 * @param in
	 * @return
	 * @throws SecurityException
	 */
	private static final Word[] expand(Word[] in) throws SecurityException {
		Word[] w = new Word[132];
		int off = in.length;
		System.arraycopy(in, 0, w, 0, off);
		for (; off < 132;) {
			if (off < 68) {
				w[off] = p1(w[off - 16].xOr(w[off - 9]).xOr(w[off - 3].loopLeft(15))).xOr(w[off - 13].loopLeft(7))
						.xOr(w[off - 6]);
			} else {
				w[off] = w[off - 68].xOr(w[off - 64]);
			}
			off++;
		}
		return w;
	}

	/**
	 * 压缩函数
	 * 
	 * @param iv
	 * @param block
	 * @return
	 * @throws SecurityException
	 */
	private static final Word[] cf(Word[] iv, Word[] block) throws SecurityException {
		Word[] w132 = expand(block);
		Word a = iv[0];
		Word b = iv[1];
		Word c = iv[2];
		Word d = iv[3];
		Word e = iv[4];
		Word f = iv[5];
		Word g = iv[6];
		Word h = iv[7];
		Word ss1, ss2, tt1, tt2;
		for (int j = 0; j < 64; j++) {
			ss1 = a.loopLeft(12).add(e).add(TJ[j].loopLeft(j)).loopLeft(7);
			ss2 = ss1.xOr(a.loopLeft(12));
			tt1 = ff(a, b, c, j).add(d).add(ss2).add(w132[j + 68]);
			tt2 = gg(e, f, g, j).add(h).add(ss1).add(w132[j]);
			d = c;
			c = b.loopLeft(9);
			b = a;
			a = tt1;
			h = g;
			g = f.loopLeft(19);
			f = e;
			e = p0(tt2);
		}
		Word[] r = new Word[HASH_LENGTH_WORD];
		r[0] = iv[0].xOr(a);
		r[1] = iv[1].xOr(b);
		r[2] = iv[2].xOr(c);
		r[3] = iv[3].xOr(d);
		r[4] = iv[4].xOr(e);
		r[5] = iv[5].xOr(f);
		r[6] = iv[6].xOr(g);
		r[7] = iv[7].xOr(h);
		return r;
	}

	/**
	 * 迭代压缩
	 * @param msg
	 * @return
	 * @throws com.hsm.security.SecurityException 
	 * @throws SecurityException
	 * @throws com.hsm.security.SecurityException 
	 */
	public static final byte[] digest(byte[] msg) throws com.gcf.common.util.security.SecurityException{
		byte[] paddingMsg = padding(msg);
		Word[] msgBlock = Word.byteToWord(paddingMsg);
		
		Word[] iv = SM3.IV.clone();
		int off = 0;
		Word[] block = new Word[BLOCK_LENGTH_WORD];
		while(true) {
			if(off == msgBlock.length) {
				break;
			}
			System.arraycopy(msgBlock, off, block, 0, BLOCK_LENGTH_WORD);
			iv = cf(iv, block);
			off += 16;
		}
		
		
		byte[] result = new byte[HASH_LENGTH_BYTE];
		for (int i = 0; i < iv.length; i++) {
			byte[] w = iv[i].get();
			System.arraycopy(w, 0, result, i * 4, 4);
		}
		return result;
	}
	
	/**
	 * 签名
	 * @param msg
	 * @param type
	 * @return
	 * @throws com.hsm.security.SecurityException 
	 * @throws SecurityException
	 */
	public static final String digest(String msg, MsgType type) throws com.gcf.common.util.security.SecurityException{
		if(type.equals(MsgType.HEX)) {
			return Convert.byteToHexStr(digest(Convert.hexToByte(msg)));
		}else {
			return Convert.byteToHexStr(digest(msg.getBytes()));
		}
	}

	public static void main(String[] args) throws  com.gcf.common.util.security.SecurityException {
		byte[] msg = "ererfeiisgod".getBytes();
		byte[] result = digest(msg);
		System.out.println(Convert.byteToHexStr(result));
		
		System.out.println(digest("ererfeiisgod", MsgType.ASCII));
		

	}
}
