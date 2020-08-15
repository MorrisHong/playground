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