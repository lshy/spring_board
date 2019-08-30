package com.hanwha.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hanwha.example.dto.BoardVO;

@Component
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "board";

	// 01. 게시글 작성
	public int writeBoard(BoardVO boardVO){
		int res = sqlSession.insert("board.insert", boardVO);
		return res;
	}
	// 02. 게시글 상세보기
	public BoardVO view(int bno){
		BoardVO boardVO = sqlSession.selectOne(namespace+".view", bno);
		return boardVO;
	}
	// 03. 게시글 수정
	public int editBoard(BoardVO boardVO){
		return sqlSession.update("board.updateArticle",boardVO);
	}
	// 04. 게시글 삭제
	public int delete(int bno){
		return sqlSession.delete(namespace+".deleteArticle", bno);
	}
	// 05. 게시글 전체 목록
	public List<BoardVO> listAll() {
		List<BoardVO> list = sqlSession.selectList(namespace+".listAll");
		return list;
	}

	// 게시글 조회수 증가
	
	public int increaseViewcnt(int bno){
		return sqlSession.update("board.increaseViewcnt", bno);
	}
}
