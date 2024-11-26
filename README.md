# **온라인 모의고사 및 성적조회 서비스**  
52기 [디지털컨버전스] ICT융합 풀스택(자바/스프링) 개발자 양성과정

---

## 📖 목차
1. [프로젝트 소개](#1-프로젝트-소개)
2. [팀원 소개](#2-팀원-소개)  
3. [프로젝트 일정](#3-프로젝트-일정)  
4. [기술 스택](#4-기술-스택)  
5. [개발 환경](#5-개발-환경)  
6. [프로젝트 구조](#6-프로젝트-구조)  
7. [주요 기능 설명](#7-주요-기능-설명)  
8. [역할 분담](#8-역할-분담)  
9. [페이지별 기능](#9-페이지별-기능)  
10. [프로젝트 후기](#10-프로젝트-후기)  

---

## 📖1. 프로젝트 소개
대학 입시에 필수적인 대학수학능력시험을 온라인 모의고사로 준비할 수 있도록 하고, 이를 통해 성적을 분석하여 개인의 취약점을 파악하고 학습 성과를 점검하며 효과적인 학습 계획을 세울 수 있다.  
**주요 기능:**
- 모의고사 응시 및 해설 제공
- 모의고사 기간별 결과분석
- 모의고사 성적조회
- 학습계획 수립 및 관리

---

## 🧑‍💻2. 팀원 소개
| 이름   | GitHub                                   | 이메일                |
|--------|------------------------------------------|-----------------------|
| 김승수 | [김승수의 GitHub](https://github.com/thooX2)      | thox2q9@gmail.com     |
| 김도영 | [김도영의 GitHub](https://github.com/Doyoung9568)  | doyoung9568@gmail.com |
| 문성민 | [문성민의 GitHub](https://github.com/leeyeonghee) | leeyeonghee@example.com |
| 최승현 | [최승현의 GitHub](https://github.com/leeyeonghee) | leeyeonghee@example.com |

---

## 📈3. 프로젝트 일정
1. **요구사항 분석** : 2024.08.05. ~ 2024.08.11. (7일)
2. **개발문서 작성** : 2024.08.12. ~ 2024.09.30. (50일)
3. **개발**: 2024.09.01. ~ 2024.11.10. (71일)
4. **테스트 및 배포**: 2024.11.11. ~ 2024.11.17. (7일) 

---

## ✨4. 기술 스택

#### FE
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 

#### BE
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/Java Script-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> <img src="https://img.shields.io/badge/thyme leaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">

#### WS
<img src="https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=black">

#### WAS
<img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black">

#### FrameWork
<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/MyBatis-0D0D0D?style=for-the-badge&logo=MyBatis&logoColor=white">

#### DBMS
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

#### Version Control
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
<img src="https://img.shields.io/badge/git hub-181717?style=for-the-badge&logo=github&logoColor=white">

#### CI/CD
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)

---

## 💻5. 개발 환경
- **IDE**: Spring Tool Suite (STS)  
- **운영체제**: Windows 10, macOS  
- **서버**: Tomcat 9  
- **DBMS**: MySQL 8.0  

![image](https://github.com/user-attachments/assets/c1ac2280-d961-44f4-a892-e5494e9093b6)

---

## 📂6. 프로젝트 구조



```bash
📦 src/main 
┣ 📂 java/ks52team01
┃ ┣ 📂 DTO
┃ ┣ 📂 controller 
┃ ┣ 📂 service 
┃ ┗ 📂 mapper
┣ 📂 resources
┃ ┣ 📂 mapper
┃ ┣ 📂 static
┃ ┣ 📂 template
┃ ┗ application.properties
```
### **java/ks52team01**
- **DTO** : Data Transfer Object
- **controller** : 요청 처리 및 API 매핑  
- **service** : 비즈니스 로직  
- **mapper** : mapper.xml에서 실행할 메서드의 인터페이스 정의
### **resources**
- **mapper** : SQL 쿼리 정의
- **static** : 정적 리소스
- **template** : 동적 리소스
---

## ✅7. **주요 기능 설명**
### **학생 기능**
- **모의고사 보기**: 과목 선택 및 문제 풀이 기능  
- **시험 결과 확인**: 점수와 정답/오답 피드백 제공  
- **성적 조회** : 성적 시각화 종합 조회

### **관리자 기능**
- **문제 관리**: 문제 추가/수정/삭제 가능  
- **시험 관리**: 시험 일정 설정 및 관리  
- **결과 분석**: 학생들의 시험 결과 데이터를 시각적으로 분석  

---

## 🎨8. 역할 분담
- **김승수** : 
  - 기획, 자료조사, 설계, 구현, 오류 수정, 배포, 업부분장, 문서 작성 전반 관리
  - 성적조회 연결 클래스와 전송방식 작성
  - 성적조회 DB 기초 table 작성
  - 성적조회 사용할 논리적, 물리적 DB 구현
  - 성적조회 사용할 Table 상세 데이터 입력
  - 성적조회 프로세스 흐름도를 도표로 표현
  - 성적조회 프로세스 흐름도를 도표로 표현
  - 성적조회 서비스별 기능 작성
  - 성적조회 각 테이블의 컬럼 정보 정리 및 작성
  - 성적조회 공통된 네이밍 규칙 정리
  - 성적조회 화면 설계서 작성
  - 성적조회 화면 경로 작성
  - 성적조회 클래스 경로 작성
  - 성적조회 전체적인 ERD 작성
  - 성적조회 화면 및 기능 구현 
- **김도영**: 
  - 문서작업  
    - 모의고사 파트 연결 클래스와 전송방식 작성
    - 모의고사 파트 DB 기초 table 작성
    - 모의고사 파트 사용할 논리적, 물리적 DB 구현
    - 모의고사 파트 사용할 Table 상세 데이터 입력
    - 모의고사 파트 프로세스 흐름도를 도표로 표현
    - 서비스별 프로세스 흐름도를 도표로 표현
    - 모의고사 파트 서비스별 기능 작성
    - 모의고사 파트 각 테이블의 컬럼 정보 정리 및 작성
    - 모의고사 파트 공통된 네이밍 규칙 정리
    - 모의고사 파트 화면 설계서 작성
    - 모의고사 파트 화면 경로 작성
    - 모의고사 파트 클래스 경로 작성
    - dbeaver를 사용하여 모의고사 부분 전체적인 ERD 작성
  - 화면 구현
     - 기간별 성적 분석  
- **문성민**: 
  - DB 설계 및 데이터 모델링  
  - MyBatis 연동 및 SQL 최적화  
- **최승현**: 
  - DB 설계 및 데이터 모델링  
  - MyBatis 연동 및 SQL 최적화
---

## 📄9. **페이지별 기능**
| 페이지          | 주요 기능                                                              |
|------------------|-----------------------------------------------------------------------|
| **시험 목록**    | 과목별 시험 리스트 조회, 시험 시작 버튼                               |
| **문제 풀이**    | 문제 풀기 UI, 정답 선택 및 제출 기능                                  |
| **시험 결과**    | 시험 점수 및 정답/오답 분석 제공                                     |
| **성적 조회**    | 모의고사 점수 종합 조회 및 시각화                                    |
| **관리자 페이지** | 문제 추가/수정/삭제, 시험 일정 관리                                  |

---

## 💬10. **프로젝트 후기**
- **김승수**: *"요구사항을 분석하고 설계하는 과정의 중요함을 느꼈고 프로젝트 전반을 관리하는 값진 경험을 할 수 있었습니다."*  
- **김도영**: *"명확한 개발문서 작성 및 효율적인 데이터베이스 설계와 SQL 최적화의 중요성을 배우는 기회가 되었습니다."*  
- **문성민**: *""*
- **최승현**: *""*

---
