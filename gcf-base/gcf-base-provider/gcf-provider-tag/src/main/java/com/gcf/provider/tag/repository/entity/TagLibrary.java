package com.gcf.provider.tag.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="CT_TAG_LIBRARY")
@Data
@EqualsAndHashCode(callSuper = true)
public class TagLibrary extends AbstractEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TAG_LIBRARY_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String tagLibraryCode;
	
	@Column(name="TAG_LIBRARY_NAME", length = 100, nullable = false)
	private String tagLibraryName;
	
	@Column(name="VIEW", length = 255)
	private String view;
	
	@Column(name="DESCRIPTION", length = 20, nullable = false)
	private String description;
	
	@Column(name="REF", length = 60, nullable = false)
	private String ref;

}
