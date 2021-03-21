package com.gcf.provider.content.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gcf.common.repository.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="CT_CONTENT")
@Data
@EqualsAndHashCode(callSuper = true)
public class Content extends AbstractEntity {
	
	@Column(name="CONTENT_CODE", unique = true, length = 20, nullable = false, updatable = false)
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
	
	@Column(name="FIRST_PUBLISH_TIME", updatable = false)
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
}
