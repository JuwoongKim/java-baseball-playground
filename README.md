## 혼자 구현해보기

---
### 📌 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
- 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다

### 📌 프로그래밍 요구사항
- [ ]  자바 코드 컨벤션을 지키면서 프로그래밍한다. 
   - 기본적으로 Google Java Style Guide을 원칙으로 한다.
   - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- [ ] indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [ ] else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- [ ] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- [ ] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- [ ] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### 📌 커밋 컨벤션
![스크린샷 2024-02-24 오전 11.09.45.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fj2%2Flq2fjw4n0rlby3mg4xddx_mh0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_PYEOfz%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-02-24%20%EC%98%A4%EC%A0%84%2011.09.45.png)

### ⭐객체 역할 분담 
🟩 **NumberGenerator**
- 1부터 9까지 서로 다른 수로 구성된 3자리 수를 만든다.

🟩 **Validator**
- 두 GameValue 값을 비교해 Hint 를 반환한다.  

🟩 **GameValue**
- 값이 1~9까지 서로 다른 숫자인지 검증한다.

🟩 **Hint**
- 힌트 정보를 저장하고 결과 정보를 반환한다.

🟩 **Computer**
- 사용자 GameValue를 통해 Hint를 반환한다.

🟩 **InputView**
- 외부로부터 사용자의 입력값 받는다.  
- **개인목표** :꼭 콘솔에만 속하지 않도록 구현해보자

🟩 **OutputView**
- 외부에게 결과값을 출력한다.
- **개인목표** :꼭 콘솔에만 속하지 않도록 구현해보자

🟩 **Main**
- 시스템을 실행한다.
- 종료 후 재시도 여부를 분기처리한다.


### ⭐ 다이어그램
![스크린샷 2024-02-24 오전 11.11.51.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fj2%2Flq2fjw4n0rlby3mg4xddx_mh0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_km2Lg7%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-02-24%20%EC%98%A4%EC%A0%84%2011.11.51.png)
[링크](%3CmxGraphModel%3E%3Croot%3E%3CmxCell%20id%3D%220%22%2F%3E%3CmxCell%20id%3D%221%22%20parent%3D%220%22%2F%3E%3CmxCell%20id%3D%222%22%20value%3D%22%C2%ABvalue%C2%BB%26lt%3Bbr%26gt%3B%26lt%3Bb%26gt%3BName%26lt%3B%2Fb%26gt%3B%22%20style%3D%22html%3D1%3BwhiteSpace%3Dwrap%3B%22%20vertex%3D%221%22%20parent%3D%221%22%3E%3CmxGeometry%20x%3D%22330%22%20y%3D%22200%22%20width%3D%22110%22%20height%3D%2250%22%20as%3D%22geometry%22%2F%3E%3C%2FmxCell%3E%3C%2Froot%3E%3C%2FmxGraphModel%3E)

### ⭐작업 계획 목록
- [ ] NumberGenerator 의 "1부터 9까지 서로 다른 수로 구성된 3자리 수를 만든다." 구현
- [ ] GameValue 의 "값이 1~9까지 서로 다른 숫자인지 검증한다." 구현
- [ ] Hint 객체 생성
- [ ] Validator의 "두 GameValue 값을 비교해 Hint 를 반환한다." 구현
- [ ] Computer의 "사용자 GameValue를 통해 Hint를 반환한다." 구현
- [ ] InputView 인터페이스 및 Console 구현체 구현
- [ ] OutputView 인터페이스 및 Console 구현체 구현
- [ ] Main "종료 후 재시도 여부를 분기처리한다" 구현
- [ ] [선택] Main 객체 생성 전략 생각해보기

### 고민목록 
- [숫자야구 컴퓨터 랜덤수, 사용자 입력값 검증 처리](https://www.notion.so/c1178dbf8dc648e58de6ce33845e3b38?pvs=4)


### 기타 
- 컨벤션에 따른 학습은 네이버 켐퍼스 핵데이 코드 컨벤션을 사용한다.
