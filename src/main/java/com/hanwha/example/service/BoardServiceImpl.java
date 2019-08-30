package com.hanwha.example.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanwha.example.dao.BoardDao;
import com.hanwha.example.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	

	@Override
	public BoardVO detailBoard(int bno) {
		return boardDao.view(bno);
	}


	@Override
	public int deleteBoard(int bno) {
		// if(res == 0){
		// return res;
		// }else{
		// return res;
		// }
		return boardDao.delete(bno);
	}

	@Override
	public List<BoardVO>  listAll() throws Exception {
		// if(res == 0){
		// return res;
		// }else{
		// return res;
		// }
		return boardDao.listAll();
	}

	@Override
	public int writeBoard(BoardVO boardVO) {
		
		return boardDao.writeBoard(boardVO);
//		int res = boardDao.writeBoard(boardVO);
//		if(res == 0){
//			return res;
//		}else{
//			return res;
//		}
	}
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		// 세션에 저장된 조회시간 검색
		// 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행X
		if (session.getAttribute("update_time_" + bno) != null) {
			// 세션에서 읽어오기
			update_time = (Long) session.getAttribute("update_time_" + bno);
		}
		// 시스템의 현재시간을 current_time에 저장
		long current_time = System.currentTimeMillis();
		// 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
		// 시스템현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
		if (current_time - update_time > 5 * 1000) {
			boardDao.increaseViewcnt(bno);
			// 세션에 시간을 저장 : "update_time_"+bno는 다른변수와 중복되지 않게 명명한 것
			session.setAttribute("update_time_" + bno, current_time);

		}
	}


	@Override
	public int editBoard(BoardVO boardVO) {
		int res = boardDao.editBoard(boardVO);
		if(res == 0){
			return res;
		}else{
			return res;
		}
	}

}
