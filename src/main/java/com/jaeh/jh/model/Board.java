package com.jaeh.jh.model;

import com.jaeh.jh.model.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column
	private String title;

	@Column
	private String content;

	@Column
	private String nickname;

	@Builder
	public Board(String title, String content, String nickname) {
		this.title = title;
		this.content = content;
		this.nickname = nickname;
	}
}
