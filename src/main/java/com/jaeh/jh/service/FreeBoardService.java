package com.jaeh.jh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaeh.jh.model.FreeBoard;
import com.jaeh.jh.repository.FreeBoardRepository;

import java.util.List;

@Service
public class FreeBoardService {

	private final FreeBoardRepository freeBoardRepository;

	@Autowired
	public FreeBoardService(FreeBoardRepository freeBoardRepository){
		this.freeBoardRepository = freeBoardRepository;
	}

	public List<FreeBoard> getAllFreeBoards() {
		return freeBoardRepository.findAll();
	}

	public void createBoard(FreeBoard freeBoard) {
		FreeBoard newBoard = new FreeBoard();
		newBoard.setTitle(freeBoard.getTitle());
		newBoard.setContent(freeBoard.getContent());
		freeBoardRepository.save(newBoard);
	}

}
