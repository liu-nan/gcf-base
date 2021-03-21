package com.gcf.provider.code.controller.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Data;

/**
 * 素材类型DTO实体
 * @author Romi.Liu
 *
 */
@Data
public class AssetTypeDto {

	private long id;
	//素材类型编码
	private String typeCode;
	
	//素材类型标题
	private String typeName;
	
	//素材类型描述
	private String description;

	@Column(name="VIEW", length = 255)
	private String view;	
	
	//权限引用
	private String ref;
	
	//共享类型，DEFAULT:默认-全体共享，PRIVATE:私有-租户独享
	private String sharedType;

	//创建时间
	private LocalDateTime createTime;

	//最后修改时间
	private LocalDateTime lastModifyTime;

	//创建账户
	private String createAccount;

	//最后修改账户
	private String lastModifyAccount;
	
	//基础状态，NOMAL:正常，DELETE:删除，FREEZE:冻结，DESTORY:废弃，
	private String baseStatus;
	
	//最后操作类型，CREATE:创建，MODIFY:修改，DELETE:删除，PUBLISH:发布，UNPUBLISH:下架，PUSH:推送
	private String lastOperatorType;
}
