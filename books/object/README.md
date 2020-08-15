# 오브젝트: 코드로 이해하는 객체지향 설계

## chapter01
> 티켓 판매 애플리케이션 구현.

### 첫번째 코드
- [commit](https://github.com/gracelove91/playground/tree/ee8c0842db83f360560baf39219e28e45228fd13/books/object/src/main/java/chapter01)
- `Theater` 의 enter 메서드를 보자. 이를 이해하기 위해선 `Audience` 가 `Bag`을 가지고 있고, `Bag`안에는 현금과 티켓이 들어있으며, `TicketSeller` 가 .... 어쩌구저쩌구..
하나의 클래스나 메서드에서 너무 많은 세부사항을 다 알아야한다!  `Audience`와 `TicketSeller` 를 변경할 경우 `Theater` 또한 변경된다!
- 해결책?
`Theater` 가 `Audience` 와 `TicketSeller` 에 관해 너무 세세한 부분까지 알지 못하도록 정보를 차단하자!
관람객과 판매원을 자율적인 존재로 만들자!

### 두번째 코드
- [commit](https://github.com/gracelove91/playground/tree/869e8662d0aa8edbf205411792c94036492b336e/books/object/src/main/java/chapter01)
- 첫번째 코드와 비교해보자. 첫번째 코드에선 `Theater`가 너무 많은 책임을 졌다.
두번째 코드에선 각 객체가 자신이 맡은 일을 스스로 책임을 진다.
첫번째 코드는 모든 책임이 `Theater`에 몰려있었기 때문에, `Theater`가, 필요한 모든 객체에 의존해야했다. 따라서 변경애 취약했다.

> 설계를 어렵게 만드는 것은 *의존성* 때문이다. 불필요한 의존성을 제거함으로써 *결합도를 낮추자.*
>우리는 `Theater`가 몰라도 되는 세부사항을 `Audience`와 `TicketSeller` 내부로 감춰 **캡슐화**를 함으로써 객체의 자율 성을 높이고 응집도 높은 객체들의 공동체를 창조해냈다. 
>불필요한 세부사항을 캡슐화를 하고, 자율적인 객체들이 낮은 결합, 높은 응집을 가지고 협력하도록
>*최소한의 의존성* 만을 남기는 것이 훌륭한 객체지향 설계다.