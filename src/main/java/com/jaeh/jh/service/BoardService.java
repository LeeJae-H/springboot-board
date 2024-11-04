package com.jaeh.jh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaeh.jh.model.Board;
import com.jaeh.jh.repository.BoardRepository;

import java.util.List;

@Service
public class BoardService {

	private final BoardRepository boardRepository;

	@Autowired
	public BoardService(BoardRepository boardRepository){
		this.boardRepository = boardRepository;
	}

	public List<Board> getAllBoards() {
		return boardRepository.findAll();
	}

	public void createBoard(Board board) {
		Board newBoard = new Board();
		newBoard.setTitle(board.getTitle());
		newBoard.setContent(board.getContent());
		boardRepository.save(newBoard);
	}
}
