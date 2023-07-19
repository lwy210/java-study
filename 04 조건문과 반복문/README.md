## 조건문 - if, switch

### if-else if 문

```java
if (조건식1) {
	// 조건식1의 연산결과가 참일 때
} else if (조건식2) {
	// 조건식2의 연산결과가 참일 때
} else if (조건식3) {
	// 조건식3의 연산결과가 참일 때
} else {
	// 위의 어떤 조건식도 만족하지 않을 때
}
```

<br>

### switch 문

```java
switch (조건식) {
	case 값1 :
		// 조건식 결과가 값1과 같을 경우
		break;
	case 값2 :
		// 조건식 결과가 값1과 같을 경우
		break;
	default :
		// 조건식의 결과와 일치하는 case문이 없을 때
}
```

**switch의 제약조건**

- switch문의 조건식 결과는 정수 또는 문자열이어야 한다.
- case문의 값을 정수 상수만 가능하며, 중복되지 않아야 한다.

<br>
<br>

## 반복문 - for, while, do-while

### for문

```java
for(int i=1; i<=5; i++) {  // 초기화;조건식;증감식
	System.out.println("I can do it.");
}
```

<br>

### while문

```java
while (조건식) {
	// 조건식의 연산결과가 참인 동안, 반복될 문장들
}
```
<br>

### do-while문

```java
do {
	// 조건식의 연산결과가 참인 동안, 반복될 문장들
} while (조건식);
```