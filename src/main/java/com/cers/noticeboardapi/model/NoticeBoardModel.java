package com.cers.noticeboardapi.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table (name = "TB_NOTICEBOARD")
public class NoticeBoardModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	@Lob
	private String description;
	
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate publishDate;
	
	private Date viewDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	
	public Date getViewDate() {
		return viewDate;
	}
	
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	
}
