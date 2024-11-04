package com.jaeh.jh.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignup {

    @Email(message = "유효한 이메일을 입력하세요.")
    private String email;

    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String password;

    @NotNull(message = "닉네임을 입력하세요.")
    private String nickname;

    @NotNull(message = "성별을 선택하세요.")
    private String sex;
}
