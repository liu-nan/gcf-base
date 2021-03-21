package com.gcf.provider.asset.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 素材分组库Repository实体
 * @author Romi.Liu
 *
 */
@Entity
@Table(name="A_GROUP_LIBRARY")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupLibrary extends AbstractEntity {
	
	@Column(name="GROUP_LIBRARY_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String categoryLibraryCode;
	
	@Column(name="GROUP_LIBRARY_NAME", length = 100, nullable = false)
	private String categoryLibraryName;
	
	@Column(name="VIEW", length = 255)
	private String view;
	
	@Column(name="DESCRIPTION", length = 20, nullable = false)
	private String description;
	
	@Column(name="REF", length = 60, nullable = false)
	private String ref;
}
