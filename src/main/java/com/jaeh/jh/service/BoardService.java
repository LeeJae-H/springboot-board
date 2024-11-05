package com.jaeh.jh.service;

import com.jaeh.jh.dto.request.BoardCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Page<Board> getAllBoards(PageRequest pageRequest) {
		return boardRepository.findAll(pageRequest);
	}

	public void createBoard(BoardCreate board) {
		Board newBoard = Board.builder()
						.title(board.getTitle())
						.content(board.getContent())
						.build();
		boardRepository.save(newBoard);
	}

	public Board getBoardById(Long id) {
		return boardRepository.findById(id).orElse(null);
	}

}
