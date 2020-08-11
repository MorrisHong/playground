# Real-World Software Development - 실전 자바 소프트웨어 개발
- [구매 링크](http://www.yes24.com/Product/Goods/90533758?OzSrank=1)

## 입출금 내역 분석기
> 사람들이 자신의 재정 상황을 더 잘 이해하도록 은행 계좌 내역을 분석하는 프로그램을 구현한다. 이 과정에서 **단일 책임 원칙**, **결합도**, **응집도** 같은 핵심 객체지향 디자인 기법을 배운다.

### 우리가 구현한 코드가 가졌으면 하는 속성.
- 특정 기능을 담당하는 코드를 쉽게 찾을 수 있어야한다.
- 코드가 어떤 일을 수행하는 지 쉽게 이해할 수 있어야 한다.
- 새로운 기능을 쉽게 추가하거나 기존 기능을 쉽게 제거할 수 있어야 한다.
- 캡슐화가 잘 되어 있어야한다. 사용자가 쉽게 코드를 이해하고, 기능을 바꿀 수 있어야 한다.
### 첫번째 코드
- [BankTransactionAnalyzerSimple.class](https://github.com/gracelove91/playground/blob/671b5e447aa9175ff1c788113165f8d5ba2ed07e/books/real-world-java/src/main/java/BankTransactionAnalyzerSimple.java)
### 두번째 코드
- [BankTransactionAnalyzerSimple.class](https://github.com/gracelove91/playground/blob/6eaf7c0ed2/books/real-world-java/src/main/java/BankTransactionAnalyzerSimple.java)
- 문제점
    - 사용자의 요구사항에 따라 1월달 입출금 내역만 계산한다. 하지만 2월달 3월달... 추가가 된다면? 
    - SRP(단일 책임 원칙) 관점으로 바라보자. 너무 많은 책임을 진다.
        - 입력 읽기.
        - 주어진 형식의 입력 파싱.
        - 결과 처리
        - 결과 요약 리포트.
### 세번째 코드
- [BankTransactionAnalyzerSimple.class](https://github.com/gracelove91/playground/blob/359f5fe3cc/books/real-world-java/src/main/java/BankTransactionAnalyzerSimple.java)
- SRP
    - 한 클래스는 한 기능만 책임진다.
    - 클래스가 바뀌어야 하는 이유는 오직 하나여야한다.
    - 파싱 기능을 책임지는 클래스(`simplebankstatementanalyzer.BankStatementCSVParser`)와 도메인 클래스(`simplebankstatementanalyzer.BankTransaction`)를 만들자.
- 응집도
    - 두번째 코드에 있는 `simplebankstatementanalyzer.BankStatementAnalyzer` 클래스를 살펴보자
    - 계산 작업하는 로직은 `simplebankstatementanalyzer.BankStatementAnalyzer` 내의 정적 메서드로 선언되어있다.
    - 파싱이나 결과 전송 같은 책임과는 직접적인 연관이 없다. 응집도가 떨어진다.
    - 계산 작업 로직을 `simplebankstatementanalyzer.BankStatementProcessor` 로 추출하자.
### 네번째 코드
- [Commit](https://github.com/gracelove91/playground/tree/df34527cd13ef954542844a7d81c9b4696a8d57d)
- 결합도
    - 코드가 서로 어떻게 의존하는지와 관련이 있다.
    - 어떤 클래스를 구현하는 데 얼마나 많은 지식(다른 클래스)을 참조했는가로 설명 가능하다.
    - 세 번째 코드를 보자. `BankTransactionAnalyzerSimple` 클래스는 `BankStatementCSVParser` 클래스에 의존한다. 
            만약 파일 포맷이 CSV가 아닌 JSON이라면? XML 이라면? 리팩토링 작업이 성가시다. 
    - 본 코드는 인터페이스로 결합도를 낮췄다. 
        
        
## 입출금 내역 분석기 확장판
> 앞에서 만든 코드에 **전략 디자인 패턴**, **개방 폐쇄/원칙** 을 이용해 기능을 추가하고, 예외를 이용해 실패를 처리하는 법을 배운다.
### 첫번째 코드
- [BankStatementProcessor](https://github.com/gracelove91/playground/blob/b3ee4c7176/books/real-world-java/src/main/java/extendbankstatementanalyzer/BankStatementProcessor.java)
- 요구사항
    - 특정 금액 이상의 은행 거래 내역 찾기. (`public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){...}`)
    - 특정 월의 입출금 내역 찾기. (`public List<BankTransaction> findTransactionsInMonth(final Month month) {...}`)
    - 특정 월이나 금액으로 입출금 내역 검색하기(`public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {...}`)
- 문제점
    - 위 요구사항을 다 구현했다. 이 코드의 문제점은 무엇일까.
    - 거래 내역의 여러 속성을 조합할 수록 코드가 점점 복잡해진다.
    - 반복 로직과 비즈니스 로직이 결합되어 분리가 어렵다.
    - 코드를 반복한다.
- 개선방법
    - 개방/폐쇄 원칙을 적용한다.
        - 요구사항에 맞춰 추가한 세 개의 메서드를 하나로 퉁칠 수 있다! 개방폐쇄 원칙을 적용하면 코드를 바꾸지 않고 동작을 확장시킬 수 있다.
        - 비즈니스 로직을 담당하는 `BankTransactionFilter` 인터페이스를 만들어서 결합도를 낮춰보자.
### 두번째 코드
- [BankStatementProcessor](https://github.com/gracelove91/playground/blob/81bfeddd0f/books/real-world-java/src/main/java/extendbankstatementanalyzer/BankStatementProcessor.java)
- [BankTransactionFilter](https://github.com/gracelove91/playground/blob/81bfeddd0f/books/real-world-java/src/main/java/extendbankstatementanalyzer/BankTransactionFilter.java)
- 개방/폐쇄 원칙을 적용했다.
    `BankStatementProcessor` 를 보면 첫 번째 코드의 요구사항을 반영한 세 개의 메서드가 `findTransactions(final BankTransactionFilter bankTransactionFilter)` 메서드 하나로 리팩터링 된 것을 볼 수 있다.
    `BankTransactionFilter`를 보면 Functional 인터페이스다. 이것을 구현한 비즈니스 로직을 인수로 넘겨주면 된다.
    [BankStatementAnalyzer](https://github.com/gracelove91/playground/blob/81bfeddd0f/books/real-world-java/src/main/java/extendbankstatementanalyzer/BankStatementAnalyzer.java) 의 `collectSummary()` 메서드의 마지막을 보자. 람다식으로 구현체를 만들어 인수로 넘겨줬다.
    
### 세번째 코드
- [BankStatementProcessor](https://github.com/gracelove91/playground/blob/81bfeddd0f/books/real-world-java/src/main/java/extendbankstatementanalyzer/BankStatementProcessor.java)
    - 개방/폐쇄 원칙을 적용해 `findTransactions` 메서드를 만들어 특정 조건에 의존하지 않게 리팩터링을 했다.
    - 그럼 `Transaction` 의 검색은 해결됐지만, 계산하는 메서드들(`calculateTotalAmount()`...)은 어떻게 해야할까?
        - 해결책 1.
            - 하나의 인터페이스로 `BankStatementProcessor` 의 모든 메서드를 추상화시킨다.
                - ```java
                  interface BankTransactionProcessor{
                      double calculateTotalAmount();
                      double calculateTotalInMonth(Month month);
                      double calculateTotalInJanuary();
                      ...
                  }
                  ```
            - 문제점
                - 갓인터페이스. 이 방법의 문제는 private으로 은닉할 수 있는 모든 헬퍼 연산이 명시적인 API 정의에 포함되어있어서 인터페이스가 복잡해진다.
                - 인터페이스를 바꾸면 이를 구현한 코드 또한 바뀌어야되는데, 더 많은 연산을 추가할 수록 더 자주 이런 일이 벌어지며, 문제가 발생할 수 있는 확률도 높아진다.
                - `calculateTotalInJanuary` 같은 API를 보면 도메인 객체의 특정 속성에 종속된다. 도메인 객체의 세부 내용이 바뀌면 인터페이스 또한 바뀌며, 결과적으로 구현 코드도 바뀐다.
        - 해결책 2.
            - 인터페이스 조금 더 작게 쪼개보자. 
                - ```java
                  interface CalculateTotalAmount{
                      double calculateTotalAmount();
                  }
                  interface CalculateTotalInMonth {
                      double calculateTotalInMonth(Month month);
                  }
                  ...
                  ```
            - 문제점
                - 안티 응집도. 즉 기능이 여러 인터페이스로 분산되어있어서 필요한 기능을 찾기 힘들다. 또 새로운 인터페이스가 계속해서 프로젝트에 추가된다.
        - 해결책 3.
            - 현재 코드다.
            - `BankTransactionProcessor`는 다양한 구현이 필요없으므로 interface의 필요성 또한 사라진다. 불필요한 추상화를 추가해 일을 복잡하게 만들 필요가 없다.
            단순히 입출금 내역에서 통계연산을 수행하는 클래스기 때문이다.
            - 고민
                - `findTransactions()` 메서드를 쉽게 정의할 수 있는 상황에서 `findTransactionsGreaterThanEqual()` 처럼 구체적인 메서드를 정의해야할까?
                이런 딜레마를 **암묵적 API 제공 vs 명시적 API 제공** 이라 한다.
                - 암묵적 API 제공 (`findTransactions()`)
                    - 처음 사용하기가 어렵다. 문서화를 잘해놓아야 한다.
                    - 하지만 거래 내역을 검색하는 데 필요한 모든 상황을 이 단순한 API 하나로 처리할 수 있다.
                - 명시적 API 제공 (`findTransactionsGreaterThanEqual()`...)
                    - 특정 상황에 종속된다. 각 상황에 맞는 새로운 메서드르 많이 만들어 내야한다.
                    - 하지만 사용하기 쉽다. API 가독성이 높아진다.
                - 그렇다면 어떻게?
                    - 지금 코드처럼 섞어 쓰면된다! 예를 들어 `findTransactionsGreaterThanEqual()`이 흔히 사용하는 연산이라면, 이를 명시적 API로 만드는 것이 합리적인 방법이다.
## 문서 관리 시스템
> 의사가 환자 기록을 더 잘 관리하도록 돕는다. 이 과정에서 **소프트웨어 설계상의 상속**, **리스코프 치환 원칙**, **조합과 상속**의 장단점을 소개한다. 또한 **자동화된 테스트 코드**로 더 안정적인 소프트웨어를 개발하는 방법도 배운다.

## 비즈니스 규칙 엔진
> 유연하고 유지보수하기 쉬운 핵심 비즈니스 규칙 엔진을 만드는 방법을 배운다. **테스트 주도 개발**, **플루언트 API 개발**, **인터페이스 분리 원칙** 을 알아본다.


## 트우터
> 서로의 팔로워에게 짧은 메시지를 발송하는 기능을 제공하는 메시징 플랫폼이다. 간단한 버전의 트우터 시스템 코어를 만든다. 이 과정에서 주어진 요구사항을 응용프로그램의 코어로 구현하는 방법도 배운다. 또한 **테스트 더블을 사용하는 방법**과 코드 베이스 내의 **다양한 컴포넌트와 상호작용을 테스트** 해본다.


## 트우터 확장판
> 앞에서 구현한 트우터를 확장한다. **의존관계 역전 원칙**을 설명하며, **이벤트 주도**와 **육각형 아키텍처** 같은 전체적인 아키텍처 선택 방법을 배운다. **테스트 자동화를 위한 스텁, 목과 같은 테스트 더블을 설명**하고,  **함수형 프로그래밍 기법**도 소개한다.



