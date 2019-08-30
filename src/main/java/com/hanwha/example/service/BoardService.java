package com.hanwha.example.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hanwha.example.dto.BoardVO;

public interface BoardService {
	// 01. 게시글 작성
	public int writeBoard(BoardVO boardVO);
	// 02. 게시글 상세보기
	public BoardVO detailBoard(int bno);
	// 03. 게시글 수정
	public int editBoard(BoardVO boardVO);
	// 04. 게시글 삭제
	public int deleteBoard(int bno);
	// 05. 게시글 전체 목록
	 public List<BoardVO> listAll() throws Exception;
	 
	 public void increaseViewcnt(int bno, HttpSession session) throws Exception;
}
