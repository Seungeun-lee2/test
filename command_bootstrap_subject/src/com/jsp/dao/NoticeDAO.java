package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NoticeVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;

public interface NoticeDAO {

	// 공지리스트 조회
	List<NoticeVO> selectNoticeList(SqlSession session) throws SQLException;
	List<NoticeVO> selectNoticeList(SqlSession session, Criteria cri) throws SQLException;
	List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 공지상세 조회
	NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException;
	
	// 검색 결과 전체 리스트 개수 : count
	int selectNoticeListCount(SqlSession session,SearchCriteria cri) throws SQLException;

	// 공지 추가
	public void insertNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	// 공지 삭제
	public void deleteNotice(SqlSession session, int nno) throws SQLException;
	
	// 공지 수정
	public void updateNotice(SqlSession session, NoticeVO notice) throws SQLException;
	
	
}

