## 개요
객체지향 설계를 통해 햄버거를 주문하는 키오스크

`console` 기반 키오스크

## [ 요구사항 ]
### ✔️ 필수 구현 (lv1~lv5)
- 햄버거 메뉴를 클래스로 관리
- 키오스크 순서 제어
- 음식 메뉴와 주문 내역을 클래스 기반으로 관리


### ✅ 도전 구현 (challenge)
#### 1. 장바구니 및 구매하기 기능
- 장바구니 생성 및 관리 기능
- 장바구니 출력 및 금액 계산
- 장바구니 담기 기능
- 주문 기능

#### 2. Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리
- Enum을 활용한 사용자 유형별 할인율 관리
- 람다 & 스트림을 활용한 장바구니 조회


---
## 파일 구조
```
📦KioskProject
 ┣ 📂src
 ┃ ┣ 📂challenge
 ┃ ┃ ┣ 📂lv1
 ┃ ┃ ┗ 📂lv2
 ┃ ┃ ┃ ┣ 📜Customer.java //lv1에서 추가된 파일
 ┃ ┃ ┃ ┣ 📜Discount.java //lv1에서 추가된 파일
 ┃ ┃ ┃ ┣ 📜Kiosk.java
 ┃ ┃ ┃ ┣ 📜Main.java
 ┃ ┃ ┃ ┣ 📜Menu.java
 ┃ ┃ ┃ ┣ 📜MenuItem.java
 ┃ ┃ ┃ ┗ 📜OrderList.java
 ┃ ┣ 📂lv1
 ┃ ┣ 📂lv2
 ┃ ┣ 📂lv3
 ┃ ┗ 📂lv4lv5
 ┃ ┃ ┣ 📜Kiosk4.java
 ┃ ┃ ┣ 📜Main4.java
 ┃ ┃ ┣ 📜Menu.java
 ┃ ┃ ┗ 📜MenuItem4.java
 ┗ 📜KioskProject.iml
```

## 실행 방법 및 예시
1. `Main`클래스 실행
2. 메뉴 카테고리 선택
3. 세부 메뉴 선택
4. 장바구니 담기
5. 가격 확인 및 최종 주문
