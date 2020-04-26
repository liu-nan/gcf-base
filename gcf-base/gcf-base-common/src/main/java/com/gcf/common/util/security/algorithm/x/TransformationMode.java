package com.gcf.common.util.security.algorithm.x;

/**
 * 分组加密模式
 * CBC 需要初始向量。明文分组后，第一个明文分组与初始向量异或，然后与秘钥计算得到第一个密文，第一个密文与第二个分组异或，然后与秘钥计算得到第二个密文，以此类推，将每个密文连接起来组成最终的密文。
 * ECB 明文分组后，每个分组与密钥计算得到一个密文，将每个密文连接起来组成最终的密文。
 * @author Administrator
 *
 */
public enum TransformationMode {
	CBC,ECB
}
