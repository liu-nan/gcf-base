package com.gcf.provider.tag.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="CT_TAG")
@Data
@EqualsAndHashCode(callSuper = true)
public class Tag extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false, updatable = false)
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TAG_CODE", unique = true, length = 20, nullable = false, updatable = false)
	private String tagCode;
	
	@Column(name="TAG_NAME", length = 100, nullable = false)
	private String tagName;
	
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
	
	@Column(name="CREATE_TIME", nullable = false, updatable = false)
	private LocalDateTime createTime;
	
	@Column(name="LAST_MODIFY_TIME", nullable = false)
	private LocalDateTime lastModifyTime;
	
	@Column(name="CREATE_ACCOUNT", nullable = false, updatable = false)
	private String createAccount;
	
	@Column(name="LAST_MODIFY_ACCOUNT", nullable = false)
	private String lastModifyAccount;
	
	@Column(name="LAST_OPERATOR_TYPE", nullable = false)
	private short lastOperatorType;
}
