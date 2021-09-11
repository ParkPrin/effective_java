# 익명 클래스보다는 람다를 사용하라

## 서론
- 자바에서 함수타입 표현: 추상 메서드를 하나만 다음 인터페이스를 사용: @FunctionalInterface 선언한 인터페이스
- 인터페이스의 인스턴스를 함수객체(function object)
- 인터페이스는 추상 전략을 뜻하고, 구체적인 전략은 익명 클래스 방식에서 구현했다.
- 그러나 익명클래스의 표기가 길어서 람다식으로 표현방식을 축소하였다.
- 자바 8에 와서 추상 메서드 하나짜리 인터페이스는 특별한 의미를 인정받아 특별한 대우를 받게 되었고 지금은 함수형 인터페이스라 부르는 이 인터페이스들의 인스턴스를 람다식을 이용해서 만들게 되었다.

## 코드의 변화

### 익명클래스 구현
```
Collections.sort(words, new Comparator<String>() {
    @Override public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
});
```

### 람다식 구현

```
Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
```

### 람다식 + 생성자 레퍼런스 방식
```
Collections.sort(words, Comparator.comparingInt(String::length));
```

### 리스트 + 람다식 + 생성자 래퍼런스
```
words.sort(Comparator.comparingInt(String::length));
```

## 람다식의 원칙
- 람다는 이름이 없고 문서화도 못한다. 따라서 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다를 쓰지 말아야한다.
- 람다는 한 줄 일 때 가장 좋고 길어야 세 줄 안에 끝내는 것이 좋다.
- 추상클래스의 인스턴스를 만들 때 람다를 쓸 수 없으니, 익명 클래스를 써야 한다.
- 추상 메서드가 여러 개인 인터페인스의 인스턴스를 만들 때도 익명 클래스를 쓸 수 있다.
- 람다는 자신을 참조할 수 없다.(this 사용불가)