package com.gcf.provider.asset.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 素材Repository实体
 * @author Romi.Liu
 *
 */
@Entity
@Table(name="A_ASSET")
@Data
@EqualsAndHashCode(callSuper = true)
public class Asset extends AbstractEntity {
	
	//素材编码
	@Column(name="ASSSET_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String assetCode;
	
	//素材标题
	@Column(name="TITLE", length = 100, nullable = false)
	private String title;
	
	//素材描述
	@Column(name="DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	//作者
	@Column(name="AUTHOR", length = 20, nullable = true)
	private String author;

	//素材类型，VIDEO/AUDIO/IMAGE/FILE
	@Column(name="TYPE_CODE", nullable = false)
	private String typeCode;
	
	//存储路径
	@Column(name="STORE_URL", length = 255, nullable = false)
	private String storeUrl;

	//访问路径
	@Column(name="ACCESS_URL", length = 255, nullable = false)
	private String accessUrl;
	
	//权限引用
	@Column(name="REF", length = 60, nullable = false)
	private String ref;
	
	//分组编号
	@Column(name="GROUP_CODE", length = 20, nullable = false)
	private String groupCode;
	
	//来源
	@Column(name="ORIGIN", nullable = false)
	private short origin;
	
	//版本
	@Column(name="VERSION", nullable = false)
	private int version;
	
	//授权起始日期
	@Column(name="AUTHORIZE_BEGIN_DATE")
	private LocalDateTime authorizeBeginDate;
	
	//授权结束日期
	@Column(name="AUTHORIZE_END_DATE")
	private LocalDateTime authorizeEndDate;
	
	//授权渠道
	@Column(name="AUTHORIZE_CHANNEL")
	private short authorizeChannel;
	
	//检测结果，PASS:通过，REVIEW:疑似，BLOCK:确认
	@Column(name="CHECK_RESULT", length = 10)
	private String checkResult;
	
	//检测结果编码
	@Column(name="RESULT_CODE")
	private String resultCode;
}
