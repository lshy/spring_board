package com.hanwha.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanwha.example.dto.BoardVO;
import com.hanwha.example.service.BoardService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/restboard/*")
public class RestController {

	@Autowired
	BoardService boardService;
	
	// 01. 게시글 전체가져오기
	@RequestMapping("list.do")
	public List<BoardVO> list() throws Exception {
		List<BoardVO> list = boardService.listAll();
		return boardService.listAll();
	}
	
	// 02_02. 게시글 작성처리
	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public int insert(@ModelAttribute BoardVO boardVO) throws Exception {
		return boardService.writeBoard(boardVO);
	}
	
	
	
}
