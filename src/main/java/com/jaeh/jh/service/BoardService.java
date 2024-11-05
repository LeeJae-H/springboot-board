package com.jaeh.jh.service;

import com.jaeh.jh.interceptor.LoginInfo;
import com.jaeh.jh.dto.request.BoardCreate;
import com.jaeh.jh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jaeh.jh.model.Board;
import com.jaeh.jh.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;

	public Page<Board> getAllBoards(PageRequest pageRequest) {
		return boardRepository.findAll(pageRequest);
	}

	public void createBoard(LoginInfo loginInfo, BoardCreate board) {
		Board newBoard = Board.builder()
						.title(board.getTitle())
						.content(board.getContent())
						.nickname(loginInfo.getNickname())
						.build();
		boardRepository.save(newBoard);
	}

	public Board getBoardById(Long id) {
		return boardRepository.findById(id).orElse(null);
	}

	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}

}
