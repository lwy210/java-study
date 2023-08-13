- [1. 객체지향언어](#1-------)
- [2. 클래스와 객체](#2--------)
  * [2.1 클래스와 객체의 정의와 용도](#21----------------)
  * [2.2 객체와 인스턴스](#22---------)
  * [2.3 객체의 구성요소 - 속성과 기능](#23------------------)
  * [2.4 인스턴스의 생성과 사용](#24-------------)
  * [2.5 객체 배열](#25------)
- [3. 변수와 메서드](#3--------)
  * [3.1 선언위치에 따른 변수의 종류](#31----------------)
  * [3.2 클래스변수와 인스턴스변수](#32--------------)
  * [3.3 메서드](#33----)
  * [3.7 JVM의 메모리 구조](#37-jvm--------)
  * [3.8 기본형 매개변수와 참조형 매개변수](#38-------------------)
  * [3.11 클래스 메서드(static 메서드)와 인스턴스 메서드](#311---------static---------------)
- [4. 오버로딩(overloading)](#4------overloading-)
  * [4.1 오버로딩이란?](#41--------)
  * [4.2 오버로딩의 조건](#42---------)
  * [4.3 오버로딩의 예](#43--------)
  * [4.4 가변인자(varargs)와 오버로딩](#44------varargs-------)
- [5. 생성자(Constructor)](#5-----constructor-)
  * [5.1 생성자란?](#51------)
  * [5.2 기본 생성자 (default constructor)](#52---------default-constructor-)
  * [5.3 매개변수가 있는 생성자](#53-------------)
  * [5.4 생성자에서 다른 생성자 호출하기 - this(), this](#54---------------------this----this)
  * [5.5 생성자를 이용한 인스턴스의 복사](#55------------------)
- [6. 변수의 초기화](#6--------)
  * [6.1 변수의 초기화](#61--------)
  * [6.2 명시적 초기화(explicit initialization)](#62---------explicit-initialization-)
  * [6.3 초기화 블럭(initialization block)](#63--------initialization-block-)
  * [6.3 멤버변수의 초기화 시기와 순서](#63-----------------)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>


<br>
<br>

## 1. 객체지향언어

1. **코드의 재사용성이 높다.**
    
    새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성할 수 있다.
    
2. **코드의 관리가 용이하다.**
    
    코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.
    
3. **신뢰성이 높은 프로그래밍을 가능하게 한다.**
    
    제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지할 수 있다.

<br>
<br>
<br>


## 2. 클래스와 객체

### 2.1 클래스와 객체의 정의와 용도

`클래스의 정의` : 클래스란 객체를 정의해 놓은 것이다.

`클래스의 용도` : 클래스틑 객체를 생성하는데 사용된다.

`객체의 정의` : 실제로 존재하는 것. 사물 or 개념

`객체의 용도` : 객체가 가지고 있는 기능과 속성에 따라 다름

<br>

### 2.2 객체와 인스턴스

클래스로부터 객체를 만드는 과정을 클래스의 `인스턴스화(instantiate)`라고 하며, 어떤 클래스로부터 만들어진 객체를 그 클래스의 `인스턴스(instance)`라고 한다.

> 클래스 — **인스턴스화** —> 인스턴스(객체)
> 

<br>

### 2.3 객체의 구성요소 - 속성과 기능

`속성(property)` : 멤버변수(member variable), 특성(attribute), 필드(field), 상태(state)

`기능(function)` : 메서드(method), 함수(function), 행위(behavior)

<br>

### 2.4 인스턴스의 생성과 사용

```java
클래스명 변수명;             // 클래스의 객체를 참조하기 위한 참조변수 선언
변수명 = new 클래스명();     // 클래스의 객체 생성 후, 객체의 주소를 참조변수에 저장

Tv t;                       // Tv클래스 타입의 참조변수 t를 선언
t = new Tv();               // Tv인스턴스를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장
```

<br>

**[ 예제 1 ]**

```java
class Tv {
	// Tv의 속성 (멤버변수)
	String color;
	boolean power;
	int channel;

	// Tv의 기능 (메서드)
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { channel; }
}

class TvTest {
	public static void main(String args[]) {
			Tv t;                 // Tv인스턴스를 참조하기 위한 변수 t를 선언
			t = new Tv();         // Tv인스턴스를 생성한다.
			t.channel = 7;        // Tv인스턴스의 멤버변수 channel의 값을 7로 한다.
			t.channelDown();      // Tv인스턴스의 메서드 channelDown()을 호출한다.
			System.out.println("현재 채널: " + t.channel) // 현재 채널: 6
	}
}

```

> **인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야한다.**
> 

<br>

**[ 예제 2 ]**

```java
class Tv {
	// Tv의 속성 (멤버변수)
	String color;
	boolean power;
	int channel;

	// Tv의 기능 (메서드)
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { channel; }
}

class TvTest {
	public static void main(String args[]) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();

		System.out.println("t1의 channel값: " + t1.channel); // t1의 channel값: 0
		System.out.println("t2의 channel값: " + t2.channel); // t2의 channel값: 0
		
		t2 = t1;         // t1이 저장하고 있는 값(주소)을 t2에 저장한다.
		t1.channel = 7;  // channel 값을 7로 한다.
		
		System.out.println("t1의 channel값: " + t1.channel); // t1의 channel값: 7
		System.out.println("t2의 channel값: " + t2.channel); // t2의 channel값: 7
	}
}
```

> **하나의 인스턴스를 여러 개의 참조변수가 가리키는 경우 (가능)
여러 인스턴스를 하나의 참조변수가 가리키는 경우 (불가능)**
> 

<br>

### 2.5 객체 배열

**[ 예시 ]**

```java
class TvTest {
	public static void main(String args[]) {
			Tv[] tvArr = new Tv[3];  // 길이가 3인 Tv객체 배열

			// Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장
			for(int i=0; i<tvArr.length; i++) {
				tvArr[i] = new Tv();
				tvArr[i].channel = i+10;
			}

			for(int i=0; i<tvArr.length; i++) {
				tvArr[i].channelUp();
				System.out.print("tvArr[%d].channel=%d, ", i, tv[Arr].channel);
				// tvArr[0].channel=11, tvArr[0].channel=12, tvArr[0].channel=13,
			}
	}
}
```

<br>
<br>
<br>


## 3. 변수와 메서드

### 3.1 선언위치에 따른 변수의 종류

```java
class Variables
{
	// 클래스 영역
	int iv;               // 인스턴스 변수
	static int cv;        // 클래스 변수 (static변수, 공유변수)

	void method()
	{
		// 메서드 영역
		int lv = 0;         // 지역 변수
	}
}
```

<br>

▼ 변수의 종류와 특징

| 변수의 종류 | 선언위치 | 생성시기 |
| --- | --- | --- |
| 클래스변수 <br> (class variable) | 클래스 영역 | 클래스가 메모리에 올라갈 때 |
| 인스턴스 변수 <br> (instance variable) | 클래스 영역 | 인스턴스가 생성되었을 때 |
| 지역 변수 <br> (local variable) | 클래스 영역 이외의 영역<br> (메서드, 생성자, 초기화 블럭 내부) | 변수 선언문이 수행되었을 때 |

<br>

1. `인스턴스변수 (instance variable)`
- 클래스 영역에 선언되며, 클래스의 인스턴스를 생성할 때 만들어진다.
- **조건 -** 인스턴스 변수의 값을 읽어 오거나 저장하기 위해서는 먼저 인스턴스를 생성해야한다.
- **저장공간 -** 인스턴스는 독립적인 저장공간을 가지므로 서로 다른 값을 가질 수 있다.
- **어떨 때 사용? -** 인스턴스마다 고유한 상태를 유지해야하는 속성의 경우

<br>

2. `클래스변수 (class variable)`
- **클래스 변수를 선언하는 방법 -** 인스턴스 변수 앞에 static을 붙이면 된다.
- **저장공간 -** 모든 인스턴스가 공통된 저장공간을 공유하게 된다.
- **어떨 때 사용? -** 한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우
- **언제든지 사용가능 -** 인스턴스를 생성하지 않고도 언제라도 바로 사용할 수 있다.
- **사용 형식 -** `‘클래스이름.클래스변수’`와 같은 형식으로 사용한다.

<br>

3. `지역변수 (local variable)`
- **사용 범위 -** 메서드 내에 선언되어 메서드 내에서만 사용 가능. 메서드 종료시 소멸

<br>
<br>


### 3.2 클래스변수와 인스턴스변수

> **인스턴스변수는 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다.**
> 

<br>
<br>

### 3.3 메서드

메서드를 사용하는 이유 세가지

1. **높은 재사용성 (resuability)**
2. **중복된 코드의 제거**
3. **프로그램의 구조화**

<br>
<br>

### 3.7 JVM의 메모리 구조

![image](https://github.com/lwy210/java-study/assets/33020581/ac329d18-d059-450e-a837-10e133a8dd7a)


1. `메서드 영역 (method area)`
- 프로그램 실행 중 어떤 클래스가 사용되면, 
JVM은 해당 클래스의 클래스파일을 읽고 분석해 클래스에 대한 정보를 이곳에 저장한다.
- 클래스의 클래스 변수도 이 영역에 함께 생성된다.
<br>

2. `호출스택 (call stack)`
- 호출스택은 메서드의 작업에 필요한 메모리 공간을 제공함.
- 메서드가 호출되면, 호출스택에 호출된 메서드를 위한 메모리가 할당되며, 이 메모리는 메서드가 작업을 수행하는 동안 지역변수들과 연산의 중간결과 등을 저장하는데 사용.
- 메서드가 작업을 마치면 할당되었던 메모리공간은 반환되어 비워짐.
<br>


- 호출 스택의 특징
    - 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
    - 메서드가 수행을 마치고나면 사용했던 메모리를 반환하고 스택에서 제거된다.
    - 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다.
    - 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다.


<br>

3. `힙 (heap)`
- 인스턴스(i.e. 인스턴스 변수)가 생성되는 공간.
- 프로그램 실행 중 생성되는 인스턴스는 모두 이곳에 생성된다.

<br>
<br>

### 3.8 기본형 매개변수와 참조형 매개변수

- 자바에서는 메서드를 호출할 때 매개변수로 지정한 값을 메서드의 매개변수에 복사해서 넘겨준다.
- **매개변수 타입이 기본형일 때 -** 기본형 값이 복사, 즉 단순히 저장된 값만 얻음 (read only)
- **매개변수 타입이 참조형일 때 -** 인스턴스의 주소가 복사, 즉 값이 저장된 곳의 주소를 알 수 있으몰 값을 읽어 오는 것은 물론 값을 변경하는 것도 가능 (read & write)

<br>
<br>

### 3.11 클래스 메서드(static 메서드)와 인스턴스 메서드

- `인스턴스 메서드`는 인스턴스 변수와 관련된 작업을 하는, 즉 메서드의 작업을 수행하는 데 인스턴스 변수를 필요로 하는 메서드이다.
- 인스턴스와 관계없는 메서드를 `클래스 메서드`로 정의한다.

<br>

1. 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙인다.
2. 클래스 변수는 인스턴스를 생성하지 않아도 사용할 수 있다.
3. 클래스 메서드는 인스턴스 변수를 사용할 수 없다.
4. 메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다.

<br>

> **- 클래스의 멤버변수 중 모든 인스턴스에 공통된 값을 유지해야하는 것이 있으면 살펴보고 있으면, static을 붙여준다. <br> - 작성한 메서드 중에서 인스턴스 변수나 인스턴스 메서드를 사용하지 않는 메서드에 static을 붙일 것을 교려한다.**
> 

<br>
<br>
<br>


## 4. 오버로딩(overloading)

### 4.1 오버로딩이란?

`오버로딩(overloading)` : 한 클래스 내에 같은 이름의 메서드를 여러개 정의하는 것.

<br>

### 4.2 오버로딩의 조건

1. 메서드 이름이 같아야한다.
2. 매개변수의 개수 또는 타입이 달라야한다.

***) 반환 타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.**

<br>

### 4.3 오버로딩의 예

```java
long add(int a, long b) { return a+b; }
long add(long a, int b) { return a+b; }
```

<br>

### 4.4 가변인자(varargs)와 오버로딩

- 가변인자는 항상 마지막 매개변수이어야 한다.
- 가변인자는 내부적으로 배열을 이용한다.

```java
class VarArgsEx {
	public static void main(String[] args) {
		String[] strArr = {100, 200, 300};

		System.out.println(concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+concatenate(",")+"]");
	}

	static String concatenate(String delim, String... args) {
		String result = "";

		for(String str : args) {
			result += str + delim;
		}
		return result;
	}

/*
	static String concatenate(String... args) {
		return concatenate("", args);
	} 두 오버로딩된 메서드가 구분되지 않아서 에러가 발생한다.
*/ 
}

// 출력 결과
// 100200300
// 100-200-300-
// 1,2,3,
// []
// []
```

<br>
<br>
<br>


## 5. 생성자(Constructor)

### 5.1 생성자란?

`생성자` : 인스턴스가 생성될 떄 호출되는 **인스턴스 초기화 메서드**이다.

<br>



**생성자의 조건**

1. 생성자의 이름은 클래스의 이름과 가아야 한다.
2. 생성자는 리턴 값이 없다.

***주의)** 연산자 new가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다.

<br>


```java
Card c = new Card();

// 1. 연산자 new에 의해 메모리(heap)에 Card 클래스의 인스턴스가 생성된다.
// 2. 생성자 Card()가 호출되어 수행된다.
// 3. 연산자 new의 결과로, 생선된 Card 인스턴스의 주소가 반환되어 참조변수 c에 저장된다.
```

<br>



### 5.2 기본 생성자 (default constructor)

- 컴파일러가 자동적으로 추가해주는 기본 생성자는 매개변수도 없고 아무런 내용도 없는 아주 간단한 것임
- **기본 생성자가 컴파일러에 의해서 추가되는 경우는 클래스에 정의된 생성자가 하나도 없을 때 뿐이다.** ⇒ 따라서 매개변수가 있는 생성자를 선언하면 기본 생성자가 추가되지 않기 때문에 매개변수 없이 생성자를 호출할 수 없으므로, 매개변수 없이 생성자를 호출하려면 기본 생성자를 사용자가 따로 작성해주어야한다.

<br>


### 5.3 매개변수가 있는 생성자

**[ 인스턴스를 생성한 다음 인스턴스변수의 값을 변경하는 방법 ]**

```java
Car c = new Car();
c.color = "white";
c.gearType = "auto";
c.door = 4;
```

<br>


**[ 매개변수를 갖는 생성자를 사용하는 방법 ] ⇒  간결 & 직관**

```java
Car c = new Car("white", "auto", 4);
```

<br>


### 5.4 생성자에서 다른 생성자 호출하기 - this(), this

**생성자 간에 서로 호출이 가능하기 위한 조건**

1. 생성자의 이름으로 클래스 이름 대신 this를 사용한다.
2. 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.

```java
Car(String color) {
	door = 5;               // 첫번째 줄
	Car(color, "auto", 4);  // 에러1. 생성자의 두 번째 줄에서 다른 생성자 호출
                          // 에러2. this(color, "auto", 4);로 해야함
}
```

<br>


`this`

- **인스턴스 자신을 가리키는 참조변수**
- 인스턴스의 주소가 저장되어 있다.
- 모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재한다.

<br>


`this(), this(매개변수)`

- **생성자**
- 같은 클래스의 다른 생성자를 호출할 때 사용한다.


<br>


**[ 예시 ]**

```java
class Car {
	String color;
	String gearType;
	int door;

	Car() {
		this("white", "auto", 4);      // Car(String color, String gearType, int door) 를 호출
	}

	Car(String color) {
		this(color, "auto", 4);
	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

class CarTest2 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("blue");
		
		System.out.println("c1의 color="+c1.color+", gearType="+c1.gearType+", door="+c1.door);
		System.out.println("c2의 color="+c2.color+", gearType="+c2.gearType+", door="+c2.door);
	}
}

// 출력 결과
// c1의 color=white, gearType=auto, door=4
// c2의 color=blue, gearType=auto, door=4
```

<br>


### 5.5 생성자를 이용한 인스턴스의 복사

```java
class Car {
	String color;
	String gearType;
	int door;

	Car() {
		this("white", "auto", 4);
	}

	Car(Car c) {    // 인스턴스의 복사를 위한 생성자.
		this(c.color, c.gearType, c.door);
	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

class CarTest3 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(c1); // c1의 복사본 c2를 생성한다.

		c1.door=100; // c1의 인스턴스 변수 door의 값을 변경한다. 
	}
}
```
<br>


> **인스턴스를 생성할 때는 다음의 2가지 사항을 결정해야한다. <br> 1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가? <br> 2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?**
> 

<br>
<br>
<br>



## 6. 변수의 초기화

### 6.1 변수의 초기화

- 지역변수는 사용하기 전에 반드시 초기화해야 한다.
- 멤버변수(클래스변수와 인스턴스변수)와 배열의 초기화는 선택적이지만, 지역변수의 초기화는 필수적이다.

<br>


**각 타입의 기본값**

| 자료형 | 기본값 |
| --- | --- |
| boolean | false |
| char | ‘\u0000’ |
| byte, short, int | 0 |
| long | 0L |
| float | 0.0f |
| double | 0.0d 또는 0.0 |
| 참조형 변수 | null |

<br>


**멤버변수의 초기화 방법**

- 명시적 초기화 (explicit initialization)
- 생성자 (constructor)
- 초기화 블럭 (initializtion block)
    - 인스턴스 초기화 블럭 : 인스턴스 변수를 초기화하는데 사용.
    - 클래스 초기화 블럭 : 클래스 변수를 초기화하는데 사용.

    <br>


### 6.2 명시적 초기화(explicit initialization)

`명시적 초기화` : 변수를 선언과 동시에 초기화하는 것

```java
class Car {
	int door = 4;                // 기본형 변수의 초기화
	Engine e = new Engine();     // 참조형 변수의 초기화
}
```

<br>


### 6.3 초기화 블럭(initialization block)

`인스턴스 초기화 블럭` 

- 인스턴스 변수를 초기화하는데 사용.
- 클래스 내에 블럭{}을 만들고 코드를 작성하면 된다.

<br>


`클래스 초기화 블럭` 

- 클래스 변수를 초기화하는데 사용.
- 클래스 내에 블럭{}을 만들고 static을 덧붙여 코드를 작성하면 된다.

<br>


**[ 이해를 위한 예시 ]**

```java
class BlockTest {
	// 클래스 초기화 블럭
	static {
		System.out.println("static { }");
	}
	
	// 인스턴스 초기화 블럭
	{
		System.out.println("{ }");
	}

	public BlockTest() {
		System.out.println("생성자");
	}

	public static void main(String args[]) {
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest bt = new BlockTest();

		System.out.println("BlockTest bt2 = new BlockTest();");
		BlockTest bt2 = new BlockTest();
	}
}
// 출력 결과
// static { }
// BlockTest bt = new BlockTest()
// { }
// 생성자
// BlockTest bt2 = new BlockTest();
// { }
// 생성자
```

<br>


**[ 활용 예시 ]**

```java
class StaticBlockTest {
	static int[] arr = new int[5];
	
	static {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10) + 1;
		}
	}

	public static void main(String args[]) {
		for(int i=0; i<arr.length; i++)
			System.out.println("arr["+i+"] :" + arr[i]);
	}
}
// 출력 결과
// arr[0] :4
// arr[1] :8
// arr[2] :10
// arr[3] :3
// arr[4] :2 
```

- 명시적 초기화를 통해 배열 arr을 생성
- 클래스 초기화 블럭을 이용해서 배열의 각 요소들을 임의의 값으로 채움
- 이처럼 배열이나 예외처리가 필요한 초기화에서는 클래스 초기화 블럭을 사용한다.

<br>


### 6.3 멤버변수의 초기화 시기와 순서

**초기화 시점**

`클래스변수의 초기화시점` : 클래스가 처음 로딩될 때 단 한번 초기화 된다.

`인스턴스변수의 초기화시점` : 인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.

<br>


**초기화 순서**

`클래스변수의 초기화순서` : 기본값 → 명시적초기화 → 클래스 초기화 블럭

`인스턴스변수의 초기화순서` :  기본값 → 명시적초기화 → 인스턴스 초기화 블럭 → 생성자

<br>


```java
class InitTest {
	static int cv = 1;        // 명시적 초기화
	int iv = 1;               // 명시적 초기화

	static { cv = 2; }        // 클래스 초기화 블럭
	{ iv = 2; }               // 인스턴스 초기화 블럭
	initTest() {              // 생성자
		iv = 3;                 
	}
}
```

![image](https://github.com/lwy210/java-study/assets/33020581/4f7fad1b-15a7-439f-b97b-a9b03ed53620)

- **클래스변수 초기화 (1~3) :** 클래스가 처음 메모리에 로딩될 때 차례대로 수행됨
- **인스턴스변수 초기화 (4~7) :** 인스턴스를 생성할 때 차례대로 수행된

<br>


[ **활용 예시 1 ]**

```java
class Product {
	static int count = 0;    // 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo;            // 인스턴스 고유의 번호

	// Product 인스턴스가 생성될 때마다 count의 값을 1씩 증가시켜서 serialNo에 저장한다.
	{
		++count;
		serialNo = count;
	}
}
```

<br>


**[ 활용 예시 2 ]**

```java
class Document {
	static int count = 0;
	String name;           // 문서명

	// 문서 생성 시 문서명을 지정하지 않았을 때
	Document() {
		this("제목없음" + ++count);
	}

	Document(String name) {
		this.name = name;
		System.out.println("문서 " + this.name + "가 생성되었습니다.");
	}
}
```
