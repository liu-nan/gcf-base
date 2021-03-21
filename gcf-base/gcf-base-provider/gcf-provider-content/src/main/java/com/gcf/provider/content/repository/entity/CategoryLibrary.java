package com.gcf.provider.content.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="CT_CATEGORY_LIBRARY")
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryLibrary extends AbstractEntity {
	
	@Column(name="CATEGORY_LIBRARY_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String categoryLibraryCode;
	
	@Column(name="CATEGORY_LIBRARY_NAME", length = 100, nullable = false)
	private String categoryLibraryName;
	
	@Column(name="VIEW", length = 255)
	private String view;
	
	@Column(name="DESCRIPTION", length = 20, nullable = false)
	private String description;
	
	@Column(name="REF", length = 60, nullable = false)
	private String ref;

	@Column(name="STATUS")
	private short status;
}
