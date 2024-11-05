package com.jaeh.jh.controller;

import com.jaeh.jh.dto.request.BoardUpdate;
import com.jaeh.jh.interceptor.LoginInfo;
import com.jaeh.jh.dto.request.BoardCreate;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jaeh.jh.model.Board;
import com.jaeh.jh.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService){
		this.boardService = boardService;
	}

	@GetMapping
	public String getAllBoards(
			@RequestParam(value = "page", defaultValue = "0") int page,
			Model model
	) {
		int size = 10; // 한 페이지당 게시글 수
		Page<Board> boards = boardService.getAllBoards(PageRequest.of(page, size));
		model.addAttribute("boards", boards.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", boards.getTotalPages());
		return "getAllBoards";
	}

	@GetMapping("/create")
	public String getCreateBoard(){
		return "createBoard";
	}

	@PostMapping("/create")
	public String createBoard(
			@ModelAttribute BoardCreate board,
			HttpSession session
	) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		boardService.createBoard(loginInfo, board);
		return "redirect:/boards";
	}

	@GetMapping("/{id}")
	public String getBaordById(
			@PathVariable Long id,
			Model model
	) {
		Board board = boardService.getBoardById(id);
		if (board == null) {
			return "error/404"; // 404 페이지로 이동
		}
		model.addAttribute("board", board);
		return "getBoardInfo";
	}

	@PostMapping("/{id}/delete")
	public String deleteBoard(@PathVariable Long id) {
		boardService.deleteBoard(id);
		return "redirect:/boards";
	}

	@GetMapping("/{id}/patch")
	public String getUpdateBoard(
			@PathVariable Long id,
			Model model
	) {
		Board board = boardService.getBoardById(id);
		if (board == null) {
			return "error/404"; // 404 페이지로 이동
		}
		model.addAttribute("board", board);
		return "updateBoard";
	}

	@PostMapping("/{id}/patch")
	public String updateBoard(
			@PathVariable Long id,
			@ModelAttribute BoardUpdate boardUpdate
	) {
		boardService.updateBoard(id, boardUpdate);
		return "redirect:/boards/" + id;
	}
}
