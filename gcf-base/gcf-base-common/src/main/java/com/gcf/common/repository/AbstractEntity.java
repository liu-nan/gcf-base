package com.gcf.common.repository;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(name = "CREATE_TIME", nullable = false, updatable = false)
	private LocalDateTime createTime;

	@Column(name = "LAST_MODIFY_TIME", nullable = false)
	private LocalDateTime lastModifyTime;

	@Column(name = "CREATE_ACCOUNT", nullable = false, updatable = false)
	private String createAccount;

	@Column(name = "LAST_MODIFY_ACCOUNT", nullable = false)
	private String lastModifyAccount;
	
	@Column(name="LAST_OPERATOR_TYPE", nullable = false)
	private short lastOperatorType;
}
