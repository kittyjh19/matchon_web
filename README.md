# ⚽ MATCHON

<div align="center">
  <img src="./src/main/resources/img/matchon_logo.png" alt="MatchON Logo" width="300"/>

**팀 스포츠 실시간 매칭 플랫폼**

[📺 시연 영상](https://www.youtube.com/watch?v=lWkFdvAquZ4) | [📖 API 문서](#)

</div>

---

## 📋 목차

- [프로젝트 소개](#-프로젝트-소개)
- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [시스템 아키텍처](#-시스템-아키텍처)
- [담당 기능](#-담당-기능)
- [주요 구현 사항](#-주요-구현-사항)
- [트러블 슈팅](#-트러블-슈팅)
- [프로젝트 성과](#-프로젝트-성과)
- [팀 구성](#-팀-구성)
- [API 문서](#-api-문서)

---

## 🎯 프로젝트 소개

**MatchOn**은 팀 스포츠를 즐기고 싶은 일반 사용자 및 경기 주최자를 위한 **실시간 매칭 플랫폼**입니다.

사용자들이 실시간으로 팀을 구성하고, 경기 정보를 관리하며, 커뮤니티 활동을 할 수 있는 종합 스포츠 플랫폼을 목표로 개발되었습니다.

### 📅 프로젝트 정보

- **개발 기간**: 2025.04.29 ~ 2025.06.13 (7주)
- **팀 구성**: Full-Stack 5명 (각 기능별 백엔드/프론트 담당)
- **개발 역할**: 회원 관리, 메일 알림, 1:1 문의, AI 챗봇, 대회 이벤트 (백엔드 + 프론트)
- **프로젝트 성과**: 최우수상 수상 🏆

---

## ✨ 주요 기능

### 🔐 회원 관리
- JWT 기반 인증/인가 (AccessToken, RefreshToken)
- 회원가입, 로그인, 로그아웃
- 임시 비밀번호 발급 및 이메일 발송
- 프로필 관리 (사진 업로드, 활동 시간대, 포지션)

### ⚽ 매칭 시스템
- 경기 모집 게시글 생성
- 실시간 참가 요청 및 승인
- 사용자 리뷰 및 매너 온도 시스템

### 💬 실시간 소통
- STOMP 기반 실시간 채팅
- WebSocket 실시간 알림
- AI 챗봇 (Google Dialogflow)

### 📧 알림 서비스
- 비동기 이메일 알림 (Gmail API)
- 사용자/주최자/관리자별 맞춤 알림

### 🏆 대회 관리
- 대회 등록 및 승인 시스템 (주최자/관리자 권한 분리)
- 달력 기반 일정 확인
- Kakao Map API 연동 장소 등록

### 💬 고객 지원
- 1:1 문의 시스템
- FAQ 챗봇
- 신고 처리

---

## 🛠 기술 스택

### Backend
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)

### Database
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)

### Infrastructure
![AWS EC2](https://img.shields.io/badge/AWS%20EC2-FF9900?style=for-the-badge&logo=amazon-ec2&logoColor=white)
![AWS S3](https://img.shields.io/badge/AWS%20S3-569A31?style=for-the-badge&logo=amazon-s3&logoColor=white)
![AWS RDS](https://img.shields.io/badge/AWS%20RDS-527FFF?style=for-the-badge&logo=amazon-rds&logoColor=white)
![AWS ALB](https://img.shields.io/badge/AWS%20ALB-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white)

### Tools & API
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Gmail API](https://img.shields.io/badge/Gmail%20API-EA4335?style=for-the-badge&logo=gmail&logoColor=white)
![Dialogflow](https://img.shields.io/badge/Dialogflow-FF9800?style=for-the-badge&logo=dialogflow&logoColor=white)
![Kakao Map](https://img.shields.io/badge/Kakao%20Map-FFCD00?style=for-the-badge&logo=kakao&logoColor=black)

### Communication
![WebSocket](https://img.shields.io/badge/WebSocket-010101?style=for-the-badge&logo=socket.io&logoColor=white)
![STOMP](https://img.shields.io/badge/STOMP-000000?style=for-the-badge&logo=apache&logoColor=white)

---

## 🏗 시스템 아키텍처

```
Internet
    ↓
┌─────────────────┐
│   AWS ALB       │  ← Load Balancing
└─────────────────┘
    ↓
┌─────────────────┐
│   EC2 Instance  │  ← Spring Boot Application
└─────────────────┘
    ↓
┌──────────┬──────────┬──────────────┐
│  MySQL   │  Redis   │   AWS S3     │
│  (RDS)   │ (Cache)  │ (File Store) │
└──────────┴──────────┴──────────────┘
    ↓
┌──────────────────────────────────┐
│  External APIs                    │
│  - Kakao Map API                 │
│  - Google Dialogflow             │
│  - Gmail API                     │
└──────────────────────────────────┘
```

### 주요 구성 요소

1. **ALB (Application Load Balancer)**
   - 로드밸런싱을 통한 트래픽 분산
   - HTTPS 통신 보안

2. **EC2 Instance**
   - Spring Boot 애플리케이션 서버
   - WebSocket 실시간 통신 처리

3. **MySQL RDS**
   - 관계형 데이터베이스
   - 사용자, 팀, 매치업 등 핵심 데이터 저장

4. **Redis**
   - 세션 캐싱
   - 실시간 알림 처리

5. **S3**
   - 프로필 이미지 등 정적 파일 저장
   - presignedURL을 통한 안전한 접근

---

## 👨‍💻 담당 기능

### 1️⃣ 회원 관리 시스템
- JWT 기반 인증/인가 구현
- AccessToken + RefreshToken 이중 토큰 방식
- HttpOnly Cookie를 통한 보안 강화
- 임시 비밀번호 발급 및 이메일 발송

### 2️⃣ 마이페이지
- 프로필 정보 조회 및 수정
- S3 연동 프로필 사진 업로드/삭제
- presignedURL을 통한 안전한 이미지 조회
- 주최 기관명 등록 및 중복 검사

### 3️⃣ 메일 알림 서비스
- Spring `@Async`를 통한 비동기 메일 발송
- Gmail API 연동
- 사용자/주최자/관리자별 맞춤 알림
- redirectUrl을 통한 편리한 페이지 이동

### 4️⃣ 1:1 문의 시스템
- 문의 등록/조회/삭제 API
- 카테고리 및 키워드 기반 검색
- 관리자 답변 시스템
- 답변 완료 후 삭제 가능한 비즈니스 로직

### 5️⃣ AI 챗봇
- Google Dialogflow API 연동
- Intent 기반 자동 응답
- 자주 묻는 질문(FAQ) chips 기능

### 6️⃣ 대회 일정 관리
- 주최자 대회 등록
- 관리자 승인 시스템 (권한 분리)
- 달력 기반 일정 조회
- Kakao Map API 연동 장소 등록

---

## 🔧 주요 구현 사항

### 🔐 JWT 인증 시스템

```java
// JWT 토큰 발급 및 HttpOnly Cookie 저장
public ResponseEntity<?> login(LoginRequest request) {
    // 인증 처리
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(), 
            request.getPassword()
        )
    );
    
    // JWT 토큰 생성
    String accessToken = jwtTokenProvider.createAccessToken(authentication);
    String refreshToken = jwtTokenProvider.createRefreshToken(authentication);
    
    // HttpOnly Cookie에 저장
    ResponseCookie accessCookie = ResponseCookie.from("Access-Token", accessToken)
        .httpOnly(true)
        .secure(true)
        .path("/")
        .maxAge(3600)
        .build();
        
    return ResponseEntity.ok()
        .header(HttpHeaders.SET_COOKIE, accessCookie.toString())
        .body(new LoginResponse("로그인 성공"));
}
```

### 📧 비동기 메일 발송

```java
@Async
public void sendNotificationEmail(NotificationDto notification) {
    try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setTo(notification.getRecipientEmail());
        helper.setSubject(notification.getSubject());
        helper.setText(createHtmlContent(notification), true);
        
        mailSender.send(message);
        log.info("알림 메일 발송 성공: {}", notification.getRecipientEmail());
    } catch (MessagingException e) {
        log.error("메일 발송 실패", e);
    }
}
```

### 🤖 AI 챗봇 (Dialogflow)

```java
public ChatResponse getChatbotResponse(String userMessage) {
    try {
        SessionsClient sessionsClient = SessionsClient.create();
        SessionName session = SessionName.of(projectId, sessionId);
        
        TextInput.Builder textInput = TextInput.newBuilder()
            .setText(userMessage)
            .setLanguageCode("ko");
            
        QueryInput queryInput = QueryInput.newBuilder()
            .setText(textInput)
            .build();
            
        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
        
        return new ChatResponse(
            response.getQueryResult().getFulfillmentText()
        );
    } catch (IOException e) {
        throw new ChatbotException("챗봇 응답 실패", e);
    }
}
```

---

## 🚨 트러블 슈팅

### 1. JWT RefreshToken 보안 취약점 개선

**🔴 문제점**
- 로그아웃 후에도 `RefreshToken`이 클라이언트에 남아있어 재로그인 가능
- `LocalStorage`에 토큰 저장으로 인한 XSS 공격 취약점

**🟢 해결방안**
1. **저장 방식 변경**
   - `LocalStorage` → `HttpOnly Cookie`로 전환
   - JavaScript를 통한 토큰 접근 원천 차단

2. **서버 측 토큰 무효화**
   ```java
   @PostMapping("/logout")
   public ResponseEntity<?> logout() {
       // RefreshToken 쿠키 즉시 만료
       ResponseCookie cookie = ResponseCookie.from("Refresh-Token", "")
           .httpOnly(true)
           .secure(true)
           .path("/")
           .maxAge(0)  // 즉시 만료
           .build();
           
       return ResponseEntity.ok()
           .header(HttpHeaders.SET_COOKIE, cookie.toString())
           .body("로그아웃 성공");
   }
   ```

**✅ 결과**
- XSS 공격으로부터 토큰 보호
- 로그아웃 시 완벽한 토큰 제거
- 예상치 못한 인증 상태 잔류 현상 해결

---

### 2. 관리자 계정 로그인 오류

**🔴 문제점**
- 관리자 계정 로그인 시 "비밀번호가 일치하지 않습니다" 오류 지속 발생
- 올바른 비밀번호 입력에도 인증 실패

**🔍 원인 분석**
- DB에 저장된 관리자 비밀번호가 평문 상태
- `BCryptPasswordEncoder`가 예상하는 형식과 불일치
- `passwordEncoder.matches()` 로직은 정상, 비교 대상 값이 문제

**🟢 해결방안**
1. **비밀번호 암호화**
   ```java
   @Test
   void encryptAdminPassword() {
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       String rawPassword = "admin1234";
       String encrypted = encoder.encode(rawPassword);
       System.out.println(encrypted);
       // $2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
   }
   ```

2. **DB 업데이트**
   ```sql
   UPDATE member 
   SET password = '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
   WHERE email = 'admin@matchon.com';
   ```

**✅ 결과**
- 관리자 로그인 정상 동작
- Spring Security 암호화 방식에 대한 이해 향상
- 데이터베이스 직접 수정 시 암호화 로직 고려 필요성 인식

---

### 3. 마이페이지 수정 요청 401 Unauthorized

**🔴 문제점**
- `PUT /mypage/update` 요청 시 401 오류 발생
- POST 요청은 정상 동작하나 PUT 요청만 실패

**🔍 원인 분석**
1. **CORS Preflight 요청 차단**
   - PUT 요청은 CORS preflight 검증 필요
   - Spring Security 설정에서 `.cors()` 누락

2. **컨트롤러 메서드 부재**
   - `@PutMapping("/update")` 메서드 미구현

3. **데이터베이스 값 불일치**
   - Enum 타입 `positionName` 값이 DB에 누락

**🟢 해결방안**
1. **CORS 설정 추가**
   ```java
   @Configuration
   public class SecurityConfig {
       @Bean
       public SecurityFilterChain filterChain(HttpSecurity http) {
           http
               .cors(Customizer.withDefaults())  // 추가
               .csrf(csrf -> csrf.disable())
               // ... 나머지 설정
       }
   }
   ```

2. **컨트롤러 메서드 구현**
   ```java
   @PutMapping("/update")
   public ResponseEntity<?> updateProfile(
       @RequestBody Map<String, Object> updateData,
       @AuthenticationPrincipal CustomUserDetails user
   ) {
       memberService.updateProfile(user.getEmail(), updateData);
       return ResponseEntity.ok("프로필 수정 완료");
   }
   ```

3. **DB 데이터 동기화**
   ```sql
   INSERT INTO positions (position_name) VALUES
   ('CENTRAL_DEFENSIVE_MIDFIELDER'),
   ('LEFT_MIDFIELDER'),
   ('RIGHT_MIDFIELDER');
   ```

**✅ 결과**
- PUT 요청 정상 처리
- CORS preflight 요청에 대한 이해 향상
- 클라이언트-서버 간 데이터 일관성 확보

---

### 4. Gmail SMTP 발송 제한

**🔴 문제점**
- 운영 서버에서 모든 메일 전송 실패
- Gmail 일일 발송 한도(500건) 초과

**🔍 원인 분석**
- 모든 이벤트 알림(회원가입, 경기 알림, 오류 등)이 관리자 메일로 발송
- 유효하지 않은 이메일(가짜 도메인)로 전송 시도
- 비즈니스 로직 설계 문제

**🟢 해결방안**
1. **알림 발송 로직 개선**
   ```java
   public void sendNotification(NotificationEvent event) {
       // 필수 알림만 발송
       if (event.isCritical()) {
           emailService.send(event.toEmail());
       }
   }
   ```

2. **이메일 유효성 검사**
   ```java
   public boolean isValidEmail(String email) {
       String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
       Pattern pattern = Pattern.compile(regex);
       return pattern.matcher(email).matches() && 
              !isFakeDomain(email);
   }
   ```

**✅ 결과**
- 불필요한 알림 발송 차단
- 메일 발송 한도 준수
- 비즈니스 로직 최적화

---

## 📊 프로젝트 성과

### 개발 성과
- ✅ 기획 기능 35개 중 26개 구현 **(개발률 74.3%)**
- ✅ 실시간 기능 안정적 동작 (STOMP 채팅 및 알림)
- ✅ AWS 배포 및 실서비스 운영 경험
- ✅ **최우수상 수상** 🏆

### 기술적 성장
- 🔐 JWT 인증 시스템 설계 및 보안 강화
- 📧 비동기 처리 및 외부 API 연동
- 🏗 클라우드 인프라 구축 (AWS EC2, RDS, S3)
- 🤝 실무 중심 협업 (Git, 코드 리뷰, 일일 스크럼)
- 🐛 트러블 슈팅 및 문제 해결 능력 향상

### 학습 포인트
- Spring Security와 JWT 인증의 깊이 있는 이해
- CORS 및 HTTP 메서드별 요청 특성 이해
- 비즈니스 로직 설계의 중요성
- Git 협업 및 코드 네이밍 일관성 유지

---

## 👥 팀 구성

| 이름 | 역할 | 담당 기능 |
|------|------|----------|
| **홍주희** | Full-Stack | 회원 관리, 메일 알림 서비스, 1:1 문의, 대회 이벤트, AI 챗봇, 시스템 설계, 노션 관리, PPT |
| **최효민 (팀장)** 🚩 | Full-Stack | MatchUP 기능, 게임/단체 채팅, 매너온도 평가, 알림 서비스, DB & Git 관리, 배포 |
| 전준혁 | Full-Stack | 커뮤니티 기능, 댓글 기능, 사용자 신고 및 정지 기능, 서비스 UI |
| 정준열 | Full-Stack | Team 기능, 리뷰 기능, Team 채팅, 발표 |
| 최성은 | Full-Stack | FAQ 기능, 구장 조회 |

---

## 📝 ERD

```
┌─────────────┐      ┌─────────────┐      ┌─────────────┐
│   Member    │──────│    Team     │──────│  MatchUp    │
│             │ 1:N  │             │ 1:N  │   Board     │
│ - member_id │      │ - team_id   │      │ - board_id  │
│ - email     │      │ - team_name │      │ - title     │
│ - password  │      │ - leader_id │      │ - stadium   │
└─────────────┘      └─────────────┘      └─────────────┘
       │                     │
       │ 1:N                 │ 1:N
       │                     │
┌─────────────┐      ┌─────────────┐
│   Review    │      │   Stadium   │
│             │      │             │
│ - review_id │      │ - stadium_id│
│ - content   │      │ - name      │
│ - rating    │      │ - address   │
└─────────────┘      └─────────────┘
```

---

## 📚 API 문서

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/signup` | 회원가입 |
| POST | `/api/auth/login` | 로그인 |
| POST | `/api/auth/logout` | 로그아웃 |
| GET | `/api/mypage` | 마이페이지 조회 |
| PUT | `/api/mypage/update` | 프로필 수정 |
| POST | `/api/inquiry` | 1:1 문의 등록 |
| GET | `/api/inquiry` | 문의 목록 조회 |
| POST | `/api/inquiry/{id}/answer` | 문의 답변 (관리자) |
| POST | `/api/chat` | AI 챗봇 대화 |
| POST | `/api/competition` | 대회 등록 (주최자) |
| PUT | `/api/competition/{id}/approve` | 대회 승인 (관리자) |
| GET | `/api/competition/calendar` | 대회 일정 조회 |

---


## 👨‍💻 Contact

**홍주희** - Software Developer

- 📧 Email: [kittyjh1019@naver.com]
- 🐱 GitHub: [@kittyjh19](https://github.com/kittyjh19)

---

<div align="center">

**⚽ MATCHON** - 팀 스포츠 실시간 매칭 플랫폼

Made with ❤️ by Team MatchOn

</div>
