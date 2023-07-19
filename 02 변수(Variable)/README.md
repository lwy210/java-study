## 변수의 타입

### 기본형 vs 참조형

`기본형 (primitive type)` 

- 논리형(boolean), 문자형(char), 정수형(byte, short, int, long), 실수형(float, double) 계산을 위한 실제 값을 저장한다. 모두 8개

`참조형 (reference type)`

- 객체의 주소를 저장한다. 8개를 제외한 나머지 타입.
- 참조변수 선언 방법
    
    ```java
    클래스이름 변수이름; // 변수의 타입이 기본형이 아닌 것들은 모두 참조 변수이다.
    Date today = new Date(); // Date 객체를 생성해서, 그 주소를 today에 저장
    ```
    
    위의 코드는 Date클래스 타입의 참조변수 today를 선언한 것이다. 객체를 생성하는 연산자 new의 결과는 생성된 객체의 주소이다. 이제 참조변수 today를 통해서 생성된 객체를 사용할 수 있게 된다.

<br>    

### 상수와 리터럴

> `변수 (variable)` - 하나의 값을 저장하기 위한 공간
`상수 (constant)` - 값을 한번만 저장할 수 있는 공간
`리터럴 (literal)` - 그 자체로 값을 의미하는 것
> 

```java
int year = 2014;
final int MAX_VALUE = 100
```

- **변수 :** year
- **상수 :** MAX_VALUE
- **리터럴 :** 2014, 100



<br>

### 형식화된 출력 - prinf()

```java
System.out.printf("age:%d", age);
```

### 화면에서 입력받기 - Scanner

<br>

```java
import java.util.*;

class ScannerEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);

		System.out.println("입력내용 :"+input);
	}
}
```

<br>

## 형변환

```java
(타입)피연산자
```