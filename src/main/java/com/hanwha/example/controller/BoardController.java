package com.hanwha.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hanwha.example.dto.BoardVO;
import com.hanwha.example.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;

	// 01. SNS 목록
		@RequestMapping("sns.do")
		public ModelAndView sns() throws Exception {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("board/sns");
			return mav;
		}
	
	// 01. 게시글 목록
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");
		mav.addObject("boardList", boardService.listAll());
		return mav;
	}

	// 02_01. 게시글 작성화면
	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");
		return mav;
	}

	// 02_02. 게시글 작성처리
	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO boardVO) throws Exception {
		boardService.writeBoard(boardVO);
		return "redirect:list.do";
	}

//	 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
	@RequestMapping(value = "view.do", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		boardService.increaseViewcnt(bno, session);

		mav.addObject("board", boardService.detailBoard(bno));
		return mav;
	}

	// 04. 게시글 수정
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardVO boardVO) throws Exception {
		int res = boardService.editBoard(boardVO);
		return "redirect:list.do";
	}

	// 05. 게시글 삭제
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam int bno) throws Exception {
		boardService.deleteBoard(bno);
		return "redirect:list.do";
	}

}
