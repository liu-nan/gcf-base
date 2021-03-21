package com.gcf.provider.asset.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 素材分组Repository实体
 * @author Romi.Liu
 *
 */
@Entity
@Table(name="A_GROUP")
@Data
@EqualsAndHashCode(callSuper = true)
public class Group extends AbstractEntity {
	
	@Column(name="GROUP_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String categoryCode;
	
	@Column(name="GROUP_NAME", length = 100, nullable = false)
	private String categoryName;
	
	@Column(name="VIEW", length = 255)
	private String view;
	
	@Column(name="DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	@Column(name="PARENT_CODE", length = 20, nullable = false)
	private String parentCode;
	
	@Column(name="LIBRARY_CODE", length = 20, nullable = false, updatable = false)
	private String libraryCode;
}
