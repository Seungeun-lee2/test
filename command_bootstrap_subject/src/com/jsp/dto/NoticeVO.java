package com.jsp.dto;

import java.util.Date;

public class NoticeVO {
	
	private int nno; //글넘버
	private String title; // 글제목
	private String writer; // 작성자
	private String content; // 글내용
	private Date regDate; //등록일
	private int viewcnt; //조회수
	private int point; //
	private Date startdate; 
	private Date enddate;
	private Date updatedate;
	private String dist;
	
	public NoticeVO () {}

	public NoticeVO(int nno, String title, String writer, String content, Date regDate, int viewcnt, int point,
			Date startdate, Date enddate, Date updatedate, String dist) {
		super();
		this.nno = nno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.viewcnt = viewcnt;
		this.point = point;
		this.startdate = startdate;
		this.enddate = enddate;
		this.updatedate = updatedate;
		this.dist = dist;
	}

	
	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	
	
	
	
	
	

}
