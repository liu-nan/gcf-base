package com.gcf.provider.content.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CT_CATEGORY_LIBRARY")
@Data
public class CategoryLibrary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_LIBRARY_CODE", unique = true, length = 20, nullable = false)
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
	
	@Column(name="CREATE_TIME", nullable = false)
	private LocalDateTime createTime;
	
	@Column(name="LAST_MODIFY_TIME", nullable = false)
	private LocalDateTime lastModifyTime;
	
	@Column(name="CREATE_ACCOUNT", nullable = false)
	private String createAccount;
	
	@Column(name="LAST_MODIFY_ACCOUNT", nullable = false)
	private String lastModifyAccount;
	
	@Column(name="LAST_OPERATOR_TYPE", nullable = false)
	private short lastOperatorType;
}
