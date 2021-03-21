package com.gcf.common.repository;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Repository实体超类，定义实体公共属性
 * 
 * @author Romi.Liu
 *
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEntity {

	// 主键Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = true, updatable = false)
	private long id;

	// 创建时间
	@Column(name = "CREATE_TIME", nullable = false, updatable = false)
	private LocalDateTime createTime;

	// 最后修改时间
	@Column(name = "LAST_MODIFY_TIME", nullable = false)
	private LocalDateTime lastModifyTime;

	// 创建账户
	@Column(name = "CREATE_ACCOUNT", nullable = false, updatable = false)
	private String createAccount;

	// 最后修改账户
	@Column(name = "LAST_MODIFY_ACCOUNT", nullable = false)
	private String lastModifyAccount;

	// 基础状态，NOMAL:正常，DELETE:删除，FREEZE:冻结，DESTORY:废弃，
	@Column(name = "BASE_STATUS", nullable = false)
	private String baseStatus;

	// 最后操作类型，CREATE:创建，MODIFY:修改，DELETE:删除，PUBLISH:发布，UNPUBLISH:下架，PUSH:推送
	@Column(name = "LAST_OPERATOR_TYPE", nullable = false)
	private String lastOperatorType;
	
}
