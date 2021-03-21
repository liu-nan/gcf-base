package com.gcf.provider.code.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 内容类型Repository实体
 * @author Romi.Liu
 *
 */
@Entity
@Table(name="CODE_CONTENT_TYPE")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContentTypeEntity extends AbstractEntity {
	
	//素材类型编码
	@Column(name="TYPE_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String typeCode;
	
	//素材类型标题
	@Column(name="TYPE_NAME", length = 100, nullable = false)
	private String typeName;
	
	//素材类型描述
	@Column(name="DESCRIPTION", length = 255, nullable = false)
	private String description;

	@Column(name="VIEW", length = 255)
	private String view;	
	
	//权限引用
	@Column(name="REF", length = 60, nullable = true)
	private String ref;
	
	//共享类型，DEFAULT:默认-全体共享，PRIVATE:私有-租户独享
	@Column(name="SHARED_TYPE", length = 60, nullable = false)
	private String sharedType;
}
