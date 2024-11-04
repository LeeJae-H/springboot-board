package com.jaeh.jh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaeh.jh.model.Board;
import com.jaeh.jh.service.BoardService;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService){
		this.boardService = boardService;
	}

	@GetMapping
	public String getAllBoards(Model model) {
		List<Board> boards = boardService.getAllBoards();
		return "getAllBoards";
	}

	@GetMapping("/create")
	public String getCreateBoard(){
		return "createBoard";
	}

	@PostMapping("/create")
	public String createBoard(@ModelAttribute("freeBoard") Board board) {
		boardService.createBoard(board);
		return "home";
	}
}
