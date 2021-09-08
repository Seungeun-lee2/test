package com.jsp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jsp.dto.NoticeVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;

public interface NoticeService {

	// 공지사항 리스트조회
	List<NoticeVO> getNoticeList() throws SQLException;
	List<NoticeVO> getNoticeList(Criteria cri) throws SQLException;
	Map<String,Object> getNoticeList(SearchCriteria cri) throws SQLException;

	// 공지상세 조회
	NoticeVO getNoticeDetail(int nno) throws SQLException;;
	
	// 공지 등록
	public void insertNotice(NoticeVO notice) throws SQLException;
	
	// 공지 삭제
	public void deleteNotice(int nno) throws SQLException;
	
	// 공지 수정
	public void updateNotice(NoticeVO notice) throws SQLException;
	
}
