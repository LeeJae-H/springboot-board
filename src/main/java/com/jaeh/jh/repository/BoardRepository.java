package com.jaeh.jh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaeh.jh.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
