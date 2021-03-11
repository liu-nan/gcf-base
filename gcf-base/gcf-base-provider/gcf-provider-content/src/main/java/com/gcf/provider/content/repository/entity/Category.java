package com.gcf.provider.content.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="CT_CATEGORY")
@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String categoryCode;
	
	@Column(name="CATEGORY_NAME", length = 100, nullable = false)
	private String categoryName;
	
	@Column(name="VIEW", length = 255)
	private String view;
	
	@Column(name="DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	@Column(name="PARENT_CODE", length = 20, nullable = false)
	private String parentCode;
	
	@Column(name="LIBRARY_CODE", length = 20, nullable = false, updatable = false)
	private String libraryCode;

	@Column(name="STATUS")
	private short status;
}
