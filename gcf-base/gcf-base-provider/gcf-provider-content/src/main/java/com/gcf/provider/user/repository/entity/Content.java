package com.gcf.provider.user.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CT_CONTENT")
@Data
public class Content {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private int id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTENT_CODE", unique = true, length = 20, nullable = false)
	private String contentCode;
	
	@Column(name="TITLE", length = 100, nullable = false)
	private String title;
	
	@Column(name="DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	@Column(name="AUTHOR", length = 20, nullable = false)
	private String author;
	
	@Column(name="CONVERT_URL", length = 255, nullable = false)
	private String convertUrl;
	
	@Column(name="TYPE", nullable = false)
	private short type;
	
	@Column(name="REF", length = 60, nullable = false)
	private String ref;
	
	@Column(name="CATEGORY_CODE", length = 20, nullable = false)
	private String categoryCode;
	
	@Column(name="TAG_IDS", length = 255, nullable = false)
	private String tagIds;
	
	@Column(name="TAG_LABELS", length = 255, nullable = false)
	private String tagLabels;
	
	@Column(name="ORIGIN", nullable = false)
	private short origin;
	
	@Column(name="VERSION", nullable = false)
	private int version;
	
	@Column(name="STATUS")
	private short status;
	
	@Column(name="PUBLISH_STATUS", nullable = false)
	private short publishStatus;
	
	@Column(name="PUBLISH_TIME")
	private LocalDateTime publishTime;
	
	@Column(name="FIRST_PUBLISH_TIME")
	private LocalDateTime firstPublishTime;
	
	@Column(name="PUSH_STATUS", nullable = false)
	private short pushStatus;
	
	@Column(name="PUSH_TIME")
	private LocalDateTime pushTime;
	
	@Column(name="AUTHORIZE_BEGIN_DATE")
	private LocalDateTime authorizeBeginDate;
	
	@Column(name="AUTHORIZE_END_DATE")
	private LocalDateTime authorizeEndDate;
	
	@Column(name="AUTHORIZE_CHANNEL")
	private short authorizeChannel;
	
	@Column(name="CHECK_RESULT")
	private short checkResult;
	
	@Column(name="PREVIEW_URL")
	private short previewUrl;
	
	@Column(name="PUBLISH_URL")
	private short publishUrl;
	
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
