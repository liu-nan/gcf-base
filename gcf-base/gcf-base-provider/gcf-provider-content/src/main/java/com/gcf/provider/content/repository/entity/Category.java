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
@Table(name="CT_CATEGORY")
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_CODE", unique = true, length = 20, nullable = false)
	private String categoryCode;
	
	@Column(name="CATEGORY_NAME", length = 100, nullable = false)
	private String categoryName;
	
	@Column(name="VIEW", length = 255)
	private String view;
	
	@Column(name="DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	@Column(name="PARENT_CODE", length = 20, nullable = false)
	private String parentCode;
	
	@Column(name="LIBRARY_CODE", length = 20, nullable = false)
	private String libraryCode;

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
