package com.jaeh.jh.service;

import com.jaeh.jh.dto.request.BoardCreate;
import com.jaeh.jh.model.user.User;
import com.jaeh.jh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jaeh.jh.model.Board;
import com.jaeh.jh.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;

	public Page<Board> getAllBoards(PageRequest pageRequest) {
		return boardRepository.findAll(pageRequest);
	}

	public void createBoard(Long userId, BoardCreate board) {
		String userNickname = getUserById(userId).getNickname();
		Board newBoard = Board.builder()
						.title(board.getTitle())
						.content(board.getContent())
						.nickname(userNickname)
						.build();
		boardRepository.save(newBoard);
	}

	public Board getBoardById(Long id) {
		return boardRepository.findById(id).orElse(null);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
}
