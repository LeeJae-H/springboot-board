package com.jaeh.jh.model.user;

import com.jaeh.jh.model.common.BaseEntity;
import com.jaeh.jh.model.common.converter.SexConverter;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String nickname;

	@Column(nullable = false)
	@Convert(converter = SexConverter.class)
	private Sex sex;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Builder
	public User(String email, String password, String nickname, String sex, UserRole role){
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.sex = Sex.ofStatus(sex);
		this.role = role;
	}
}
