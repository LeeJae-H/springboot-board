package com.jaeh.jh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaeh.jh.model.FreeBoard;
import com.jaeh.jh.service.FreeBoardService;

import java.util.List;

@Controller
@RequestMapping("/free-boards")
public class BoardController {

	private final FreeBoardService freeBoardService;

	@Autowired
	public BoardController(FreeBoardService freeBoardService){
		this.freeBoardService = freeBoardService;
	}

	@GetMapping
	public String getAllFreeBoard(
			Model model
	) {
		List<FreeBoard> freeBoards = freeBoardService.getAllFreeBoards();
		return "getAllFreeBoards";
	}

	@GetMapping("/create")
	public String getCreateFreeBoard(){
		return "createFreeBoard";
	}

	@PostMapping("/create")
	public String createFreeBoard(@ModelAttribute("freeBoard") FreeBoard freeBoard) {
		freeBoardService.createBoard(freeBoard);
		return "home";
	}

}
