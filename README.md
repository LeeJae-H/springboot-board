## 자유 게시판 및 채팅방 기능이 있는 커뮤니티 만들기 - 1인 프로젝트 (2024.11.3 ~ )

#### *언어 & 프레임워크*
- Java 17
- Spring Boot 3.3.3 

#### *ORM & 데이터베이스*
- JPA (Spring Data JPA)
- MySQL

#### *기타*
- Thymeleaf

<br>

## 프로젝트 소개
**0. 홈 화면**
<div align="center">
    <img width="810" height="460" alt="pr" src="https://github.com/user-attachments/assets/d50c3092-6dac-4873-87e4-70d5920c5b1d">
</div>

    - 로그인, 인증 및 인가  
      -> 세션 방식 (세션에 담긴 사용자 정보는 userId와 nickname)  
      -> 로그인 페이지 및 회원가입 페이지 외에는 로그인한 사용자만 이용 가능 (By 스프링 Intercpetor)  
      -> 로그인 시 우측 상단의 로그인 버튼과 회원가입 버튼이 사라지고 로그아웃 버튼이 보임  
      
    - 자유게시판 or 채팅방 으로 이동하기 버튼

**1. 자유 게시판**
<div align="center">
    <img width="810" height="460" alt="pr" src="https://github.com/user-attachments/assets/d27baa14-4572-4b55-946f-897ee2b7b5bc">
</div>
<div align="center">
    <img width="810" height="460" alt="pr" src="https://github.com/user-attachments/assets/84e00d8d-68f1-44ca-9581-0129c8747826">
</div>

    - 전체 게시글 불러올 때 10개 단위로 페이징 처리
    
    - 게시글 제목 누르면 해당 게시글의 내용이 담긴 페이지로 이동


<div align="center">
    <img width="810" height="460" alt="pr" src="https://github.com/user-attachments/assets/56853af3-f400-41de-9815-935ede45093b">
</div>
<div align="center">
    <img width="810" height="460" alt="pr" src="https://github.com/user-attachments/assets/864b8562-6d88-48c5-8793-bd25c2546617">
</div>
    
      - if (해당 게시글의 작성자 == 세션에 담긴 사용자 정보의 nickname) 수정 및 삭제 버튼 보임

**2. 채팅방**

    - 진행 중


## 프로젝트 폴더 구조
  - 진행 중
