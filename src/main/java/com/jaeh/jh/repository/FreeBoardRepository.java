package com.jaeh.jh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaeh.jh.model.FreeBoard;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

}
