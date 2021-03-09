package com.gcf.provider.user.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CT_CONTENT_TEXT")
@Data
public class ContentText {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private long id;
	
	@Column(name="CONTENT_CODE", length = 20, nullable = false)
	private String contentCode;
	
	@Column(name=" SEQUENCE_NUMBER", nullable = false)
	private int sequenceNumber;
	
	@Column(name="CONTENT_TYPE", nullable = false)
	private short contentType;
	
	@Column(name="CONTENT_VALUE", length = 255, nullable = false)
	private String contentValue;
	
	@Column(name="CONTENT_STYLE", length = 255)
	private short contentStyle;
	
	@Column(name="REF", length = 60)
	private String ref;
}
