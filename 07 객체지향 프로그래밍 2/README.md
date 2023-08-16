
# 1. 상속 (inheritance)

## 1.1 상속의 정의와 장점

`상속`

- **정의 :** 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
- **장점 :** 코드의 재사용성을 높이고 중복을 제거해 프로그램의 생산성과 유지보수에 크게 기여

<br>


**상속 구현 방법**

```java
class Child extends Parent {
	// ...
}
```

**Parent - 상속해주는 클래스** (조상 클래스, 부모 클래스, 상위 클래스, 기반 클래스)

**Child - 상속 받는 클래스** (자손 클래스, 자식 클래스, 하위 클래스, 파생된 클래스)

<br>


> **- 생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.
- 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.
- 자손 클래스의 인스턴스를 생성하면 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성된다.**
> 

<br>
<br>

## 1.2 클래스간의 관계 - 포함관계

`포함(Composite) 관계`

- 상속이외의 클래스를 재사용하는 또 다른 방법
- 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻함

```java
class Point {
	int x;
	int y;
}

class Circle {
	Point c = new Point();  // Circle 클래스의 멤버 변수로 다른 클래스 Point의 참조변수 선언
	int r;
}
```

<br>
<br>

## 1.3 클래스간의 관계 결정하기

상속 관계 vs 포함 관계 ⇒ 헷갈린다

```java
// 포함 관계
class Circle {
	Point c = new Point();
	int r;
}

// 상속 관계
class Circle extends Point {
	int r;
}
```

Circle은 Point를 가지고 있다 ⇒ 포함 관계가 적절함

> **상속 관계 ‘~은 ~이다. (is-a)’
포함 관계 ‘~은 ~을 가지고 있다.(has-a)’**
> 

<br>
<br>

## 1.4 단일 상속 
**단일 상속 (sigle inheritance)**

자바는 오직 단일 상속만을 허용한다.

```java
class TVCR extends TV, VCR { // 에러. 조상은 하나만 허용된다.
	//,,,
}
```
<br>
<br>

## 1.5 Object 클래스

`Object 클래스` **- 모든 클래스의 조상**

- 모든 클래스 상속계층도의 **최상위에 있는 조상 클래스**이다.
- 다른 클래스로부터 상속 받지 않는 모든 클래스들은 컴파일러가 자동적으로 Object 클래스로부터 상속받게 한다.
- 그동안 toString()이나 equals(Object o)와 같은 메서드를 따로 정의하지 않고도 사용할 수 있었던 이유 : Object 클래스에 이 메서드들이 정의되어 있어서.

```java
class CaptionTv extends Tv {
	...
}
```

**Object ← Tv ← CaptionTv**

<br>
<br>
<br>

# 2. 오버라이딩(overriding)

## 2.1 오버라이딩이란?

`오버라이딩` : 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것 

**오버라이딩 예시**

```java
class Point {
	int x;
	int y;

	String getLocation() {
		return "x :" + x + ", y :" + y;
	} 
} 

class Point3D extends Point {
		int z;
		
		String getLocation() { // 오버라이딩
			return "x :" + x + ", y :" + y + ", z :" + z;
	}
}
```

<br>
<br>



## 2.2 오버라이딩의 조건

✅ **자손 클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와**

1. **이름**이 같아야 한다.
2. **매개변수**가 같아야 한다.
3. **반환타입**이 같아야 한다.

**⇒ 즉, 선언부가 서로 일치해야 한다.** (접근 제어자, 예외는 조건 아래 변경 가능)

<br>



✅ **조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때**

1. **접근 제어자**를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
2. **예외**는 조상 클래스의 메서드보다 많이 선언할 수 없다.
3. **인스턴스 메서드**를 **static 메서드**로 또는 그 반대로 변경할 수 없다.

<br>


📢 조상 클래스에 정의된 static 메서드를 자손 클래스에서 똑같은 이름의 static 메서드로 정의 가능?

⇒ 가능하다. 하지만 이는 오버라이딩은 아니다.

<br>

## 2.3 오버로딩 vs. 오버라이딩

`오버로딩(overloading)` **: 기존에 없는 새로운 메서드를 정의하는것 (new)**

`오버라이딩(overriding)` **: 상속받은 메서드의 내용을 변경하는 것 (change, modify)**

<br>
<br>

## 2.4 super

`super`

- **자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조 변수**
- 상속받은 멤버와 자신의 멤버와 이름이 같을 때 super로 구별할 수 있다.
- 조상의 멤버와 자신의 멤버를 구별하는데 사용된다는 점을 제외하고 **this와 근본적으로 동일**
- 모든 인스턴스 메서드에는 자신이 속한 인스턴스 주소가 지역변수로 저장되는데, 이것이 참조변수인 this와 super의 값이 된다.
- 인스턴스 메서드에서만 사용할 수 있다.

<br>


**변수 접근 예시**

```java
class SuperTest2 {
	public static void main(String args[]) {
		Child c = new Child();
		c.method();
	}
}

class Parent {
	int x=10;
}

class Child extends Parent {
	int x=20;
	
	void method() {
		System.out.println("x=" + x);
		System.out.println("this.x=" + this.x);
		System.out.println("super.x=" + super.x);
	}
}

// 실행결과
// x=20
// this.x=20
// super.x=10
```

<br>

**조상 클래스의 메서드를 자손 클래스에서 오버라이딩 시 super 사용**

```java
class Point {
	int x;
	int y;

	String getLocation() {
		return "x :" + x + ", y :" + y;
	}	
}

class Point3D extends Point {
	int z;
	
	String getLocation() { // 오버라이딩
		// return "x :" + x + ", y :" + y + ", z :" + z;
		return super.getLocation() + ", z :" + z; // 조상의 메서드 호출
	} 
}
```

- 후에 조상클래스의 메서드가 변경되더라도 변경된 내용이 자손 클래스의 메서드에 자동적으로 반영된다.

<br>
<br>

## 2.5 super()

`super()` **- 조상 클래스의 생성자
**
- **super()는 조상 클래스의 생성자를 호출하는데 사용된다.**
- cf. this()는 같은 클래스의 다른 생성자를 호출하는데 사용된다.
- **생성자의 첫 줄에서 super()를 호출해야하는 이유 :** 자손 클래스의 멤버가 조상 클래스의 멤버를 사용할수도 있기때문에 조상의 멤버들이 먼저 초기화되어 있어야 한기 때문이다.
- Object 클래스를 제외한 모든 클래스의 생성자 첫 줄에 this() 또는 super()를 호출해야한다. 그렇지 않으면 컴파일러가 자동적으로 ‘super();’를 생성자의 첫 줄에 삽입한다.

<br>

**인스턴스 생성 시** 클래스를 선택하는 것 만큼 **생성자를 선택하는 것도 중요**

1. **클래스 -** 어떤 클래스의 인스턴스를 생성할 것인가?
2. **생성자 -** 선택한 클래스의 어떤 생성자를 이용해서 인스턴스를 생성할 것인가?

![](https://velog.velcdn.com/images/lwy210/post/34802c40-cf99-4024-b3e6-4927f3c8aa37/image.png)

<br>
<br>
<br>

# 3. package와 import

## 3.1 패키지(package)

`패키지`

- **클래스가 물리적으로 하나의 클래스파일(.class)인 것과 같이 패키지는 물리적으로 하나의 디렉토리이다.**
- 하나의 소스파일에는 첫 번째 문장으로 단 한 번의 패키지 선언만을 허용한다.
- 모든 클래스는 반드시 하나의 패키지에 속해야 한다.
- 패키지는 점(.)을 구분자로 하여 계층구조로 구성할 수 있다.
- 패키지는 물리적으로 클래스 파일(.class)을 포함하는 하나의 디렉토리이다.

<br>
<br>

## 3.2 패키지의 선언

```java
package 패키지명;
```

<br>
<br>

## 3.4 import문의 선언

일반적인 소스파일(*.java)의 구성은 다음의 순서로 되어 있다.

1. package문
2. import문
3. 클래스 선언

```java
import 패키지명.클래스명;
또는
import 패키지명.*;
```

<br>
<br>


## 3.5 static import문

**static import문을 사용하면 static 멤버를 호출할 때 클래스 이름을 생략할 수 있다.**

```java
import static java.lang.System.out;
import static java.lang.Math.*;

class StaticImportEx1 {
	public static void main(String args[]) {
		// System.out.println(Math.random());
		out.println(random());

		// System.out.println("Math.PI :", Math.PI);
		out.println("Math.PI :", PI);
	}
}
```

<br>
<br>
<br>

# 4. 제어자(modifier)

## 4.1 제어자란?

`제어자(modifier)`

- **클래스, 변수, 메서드의 선언부에 함계 사용되어 부가적인 의미를 부여**
- **접근 제어자 :** public, protected, default, private
- **그 외 :** static, final, abstract, native, transient, synchronized, volatile, strictfp

<br>
<br>

## 4.2 static

`static` **- 클래스의, 공통적인**

- 클래스 변수(static 멤버 변수)는 인스턴스에 관계없이 같은 값을 가진다.
- **static이 사용될 수 있는 곳 -** 멤버변수, 메서드, 초기화 블럭

| 대상 | 의미 |
| --- | --- |
| 멤버변수 | - 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다. <br> - 클래스변수는 인스턴스를 생성하지 않고도 사용가능하다. <br> - 클래스가 메모리에 로드될 때 생성된다. |
| 인스턴스 | - 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.<br> - static 메서드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다. |


```java
class StaticTest {
	static int width = 200;                // 클래스 변수 (static 변수)
	static int height = 120;               // 클래스 변수 (static 변수)

	static {                               // 클래스 초기화 블럭
		// static 변수의 복잡한 초기화 수행
	}

	static int max(int a, int b) {         // 클래스 메서드 (static 메서드)
		return a > b ? a : b;
	}
}
```

<br>
<br>

## 4.3 final

`final` **- 마지막의, 변경될 수 없는**

- 거의 모든 대상에 사용될 수 있다.
- **final이 사용될 수 있는 곳 -** 클래스, 메서드, 멤버변수, 지역변수

| 대상 | 의미 |
| --- | --- |
| 클래스 | 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다. <br> 그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다. |
| 메서드 | 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다. |
| 멤버변수 | 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다. |
| 지역변수 | 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다. |

```java
final class FinalTest {            // 조상이 될 수 없는 클래스
	final int MAX_SIZE = 10;         // 값을 변경할 수 없는 멤버변수 (상수)
	
	final void getMaxSize() {        // 오버라이딩할 수 없는 메서드 (변경 불가)
		final int LV = MAX_SIZE;       // 값을 변경할 수 없는 지역변수 (상수)
		return MAX_SIZE;
	}
}
```

<br>
<br>

## 4.4 abstract

`abstract`** - 추상의, 미완성의**

- 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드를 선언하는데 사용된다.
- **abstract가 사용될 수 있는 곳 -** 클래스, 메서드

| 대상 | 의미 |
| --- | --- |
| 클래스 | 클래스 내에 추상메서드가 선언되어 있음을 의미한다. |
| 메서드 | 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다. |

```java
abstract class AbstractTest {      // 추상 클래스 (추상 메서드를 포함한 클래스)
	abstract void move();            // 추상 메서드 (구현부가 없는 메서드)
}
```

<br>
<br>

## 4.5 접근 제어자

`접근 제어자` **(access modifier)
**
- `private` : 같은 클래스 내에서만 접근이 가능하다.
- `default` : 같은 패키지 내에서만 접근이 가능하다.
- `protected` : 같은 패키지내에서, 그리고 다른 패키지의 자손 클래스에서 접근이 가능하다.
- `public` : 접근 제한이 전혀 없다.
- 멤버 or 클래스에 사용되어, 해당하는 멤버 or 클래스를 **외부에서 접근하지 못하도록 제어하는 역할을 한다.**
- 클래스, 멤버변수, 메서드, 생성자에 접근 제어자가 지정되어 있지 않다면, 접근 제어자가 default임을 뜻한다.
- **접근 제어자가 사용될 수 있는 곳 -** 클래스, 멤버변수, 메서드, 생성자

- public > protected > (default) > private

| 제어자 | 같은 클래스 | 같은 패키지 | 자손 클래스 | 전체 |
| --- | --- | --- | --- | --- |
| public | O | O | O | O |
| protected | O | O | O |  |
| (default) | O | O |  |  |
| private | O |  |  |  |

<br>

**대상에 따라 사용할 수 있는 접근 제어자**

- **클래스 :** public, (default)
- **메서드 :** public, protected, (default), private
- **멤버변수 :** public, protected, (default), private
- **지역변수 :** 없음

<br>

💌 **접근 제어자를 이용한 캡슐화**

- 접근 제어자를 사용하는 이유
    - 외부로부터 데이터를 보호하기 위해서
    - 외부에는 불필요한, 내부적으로만 하용되는, 부분을 감추기 위해서

```java
public class Time {
 // 접근 제어자를 private으로 하여 외부에서 직접 접근하지 못하도록 한다.
	private int hour;
	private int minute;
	private int second;

	// ...
}
```

<br>

**생성자의 접근 제어자**

- 생성자에 접근 제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있다.
- 생성자의 접근 제어자를 private으로 지정하면, 외부에서 생성자에 접근할 수 없으므로 인스턴스를 생성할 수 없게되지만, 클래스 내부에서 인스턴스를 생성할 수 있다.

```java
class Singleton {
	...
	// getInstance()에서 사용될 수 있도록 인스턴스가 미리 생성되어야 하므로 static이어야한다.
	private static Singleton s = new Singleton();
	private Singleton() {
			...
	}	
	// 인스턴스를 생성하지 않고도 호출할 수 있어야 하므로 static 이어야 한다.
	public static Singleton getInstance() {
		return s;
	}
	...
}
```

- Singleton s = new Singleton(); ⇒ 에러!
- Singleton s = Singleton.getInstance();


<br>
<br>

## 4.6 제어자(modifier)의 조합

**⛔ 제어자를 조합해서 사용할 때 주의해야할 사항**

1. **메서드에 static과 abstract를 함께 사용할 수 없다.**
    
    static 메서드는 몸통이 있는 메서드에만 사용할 수 있기 때문이다.
    
2. **클래스에 abstract와 final을 동시에 사용할 수 없다.**
    
    클래스에 사용되는 final은 클래스를 확장할 수 없다는 의미이고 abstract는 상속을 통해서 완성이되어야 한다는 의미이므로 서로 모순되기 때문이다.
    
3. **abstract 메서드의 접근 제어자가 private일 수 없다.**
    
    abstract 메서드는 자손 클래스에서 구현해주어야 하는데 접근 제어자가 private이면, 자손 클래스에서 접근할 수 없기 때문이다.
    
4. **메서드에 private과 final을 같이 사용할 필요는 없다.**
    
    접근 제어자가 private인 메서드는 오버라이딩될 수 없기 때문이다. 이 둘 중 하나만 사용해도 의미가 충분하다.
    
    
<br>
<br>
<br>

# 5. 다형성(polymorphism)

## 5.1 다형성이란?

`다형성`

- 여러 가지 형태를 가질 수 있는 능력
- 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함
- **조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 했다.**

<br>

**예시**

```java
class Tv {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

class CaptionTv extends Tv {
	String text;
	void caption() { /* ... */ }
}
```

```java
// 조상 타입의 참조변수로 자손 인스턴스를 참조
Tv t = new CaptionTv(); 

// 자손 타입의 참조변수로 자손 인스턴스를 참조
CaptionTv() c = new CaptionTv();
```

![](https://velog.velcdn.com/images/lwy210/post/5b60ed58-832e-473b-a95c-81906a1b2d3d/image.png)


- 둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버 변수의 개수가 달라진다 (상기 그림 참조)

<br>

**🔎 자손 타입의 참조변수로 조상타입의 인스턴스를 참조하는 것은 가능할까?**

```java
CaptionTv c = new Tv(); // 컴파일 에러
```

- 참조변수가 사용할 수 있는 멤버의 개수는 인스턴스 멤버 개수보다 같거나 적어야 한다.

<br>

> **조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있다.
반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수는 없다.**
> 

<br>
<br>

## 5.2 참조변수의 형변환

**자손타입 → 조상타입 (Up-casting) :** 형변환 생략가능

**자손타입 ← 조상타입 (Down-casting) :** 형변환 생략불가

- **형변환은 참조변수의 타입을 변환하는 것**이지 인스턴스를 변환하는 것은 아니므로 참조변수의 형변환은 인스턴스에 아무런 영향을 미치지 않는다.
- 단지 참조변수의 형변환을 통해, 참조하고 있는 인스턴스에서 **사용할 수 있는 멤버의 범위를 조절하는 것 뿐이다.**
- `TV t = (Tv)new CaptionTv();`

```java
class Car {
	String color;
	int door;

void drive() {
		System.out.println("drive, Brr~");
	}

void stop() {
		System.out.println("stop!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water!");
	}
}

class CastingTest {
	public static void main(String args[]) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe;               // car = (Car)fe;에서 형변환이 생략된 형태
//  car.water();   ⚠ 컴파일 에러!! Car타입의 참조변수로는 water()를 호출할 수 없음
		fe2 = (FireEngine)car;  // 자손타입 <- 조상타입
    fe2.water();
	}
}

// 실행결과
// water!
// water!
```

<br>

- 서로 상속관계에 있는 타입간의 형변환은 양방향으로 자유롭게 수행될 수 있다.
- **But, 참조변수가 가리키는 인스턴스의 자손타입으로 형변환은 허용되지 않는다.**
- 그래서 참조변수가 가리키는 **인스턴스의 타입이 무엇인지 확인하는 것이 중요.**

<br>
<br>

## 5.3 instanceof 연산자

`instanceof 연산자`

- **참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 사용한다.**
- 주로 조건문에 사용된다.

<br>

```java
class InstanceofTest {
	public static void main(String args[]) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}
	
		if(fe instanceof Car) {
			System.out.println("This is a Car instance.");
		}

		if(fe instanceof Object) {
			System.out.println("This is a Object instance.");
		}

		System.out.println(fe.getClass().getName()); // 클래스의 이름을 출력
	}
}
class Car {}
class FireEngine extends Car {}

// 실행결과
// This is a FireEngine instance.
// This is a Car instance.
// This is a Object instance.
// FireEngine 
```

- 어떤 타입에 대한 instanceof 연산의 결과가 true라는 것은 **검사한 타입으로 형변환이 가능하다는 것을 뜻한다.**

<br>
<br>

## 5.4 참조변수와 인스턴스의 연결

- **⚠ 조상 클래스에 선언된 멤버변수와 같은 이름의 인스턴스 변수를 자손 클래스에 중복으로 정의 했을 때, 참조변수의 타입에 따라 결과가 달라진다. ⇒ 이를 구분하려면 super, this를 활용하자**
    - 조상타입의 참조변수를 사용했을 때는 조상 클래스에 선언된 멤버변수가 사용된다.
    - 자손타입의 참조변수를 사용했을 때는 자손 클래스에 선언된 멤버변수가 사용된다.
- 💬 **cf) 메소드의 경우 :** 조상 클래스의 메서드를 자손의 클래스에서 오버라이딩한 경우에도 참조변수의 타입에 관계없이 항상 실제 인스턴스의 메서드(오버라이딩된 메서드)가 호출됨
- 중복 정의되지 않은 경우, 차이가 없다. 선택의 여지가 없기 때문

<br>

**예시**

```java
class BindingTest {
	public static void main(String args[]) {
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x = " + p.x);
		p.method();
		
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent {
	int x = 100;
	
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	
	void method() {
		System.out.println("Child Method");
	}
}
// 실행 결과
// p.x = 100
// Child Method
// c.x = 200
// Child Method
```

- **실행 결과 주목! 멤버변수와 메서드의 차이가 명확하게 드러난다.**

<br>
<br>

## 5.5 매개변수의 다형성

```java
class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0); // 보너스 점수는 제품가격의 10%
	}
}

class Tv extends Product {
	Tv() {
		super(100); // Tv의 가격을 100만원으로 한다.
		public String toString() { return "Tv"; }	
	}
}

class Computer extends Product {
	Computer() {
		super(200);
		public String toString() { return "Computer"; }	
	}
}

class Buyer {
int money = 1000;
int bonusPoint = 0;

void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
	
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
}

class PolyArgumentTest {
	public static void main(String args[]) {
		Buyer b = new Buyer();

		b.buy(new Tv());
		b.buy(new Computer());
		
		System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
		System.out.println("현재 보너스 점수는 " + b.bonusPoint + "점 입니다.");
	}
}

// 실행 결과
// Tv을/를 구입하셨습니다.
// Computer을/를 구입하셨습니다.
// 현재 남은 돈은 700만원 입니다.
// 현재 보너스 점수는 30점 입니다.
```

- `void buy(Product P)` 처럼 매개변수에 다형성을 적용했기 때문에 제품의 종류가 늘어날 때마다 새로운 buy 메서드를 추가하지 않아도 된다.

<br>
<br>

## 5.6 여러 종류의 객체를 배열로

pass

<br>
<br>
<br>

# 6. 추상클래스(abstract class)

## 6.1 추상클래스란?

`추상클래스`

- **추상메서드가 있는 클래스**
- 키워드 ‘abstract’를 붙이기만 하면 된다.

```java
abstract class 클래스이름 {
	...
}
```

<br>
<br>

## 6.2 추상메서드

`추상메서드`** (abstract method)**

- **선언부만 작성하고 구현부는 작성하지 않은 채로 남겨둔 메서드**
- 메서드의 내용이 상속받는 클래스에따라 달라질 수 있기 때문에 미완성 상태로 남겨놓는다.
- 따라서, 추상클래스를 상속받는 자손클래스는 **조상의 추상 메서드를 상황에 맞게 적절히 구현해주어야 한다.**
- `abstract 리턴타입 메서드이름();`

```java
abstract class Player {          // 추상 클래스
	abstract void play(int pos);   // 추상 메서드
	abstract void stop();          // 추상 메서드
}

class AudioPlayer extends Player {
	void play(int pos) { /* ... */ }  // 추상메서드를 구현
	void stop() { /* ... */ }         // 추상메서드를 구현
}

abstract class AbstractPlayer extends Player {
	void play(int pos) { /* ... */ } // 추상메서드를 구현
}
```

- **AbstractPlayer**는 여전히 추상 클래스이다. 이는 **AbstractPlayer** 클래스에 여전히 구현되지 않은 추상 메서드가 있다는 것을 의미한다. (이 경우 **stop()** 메서드). 따라서 **AbstractPlayer** 클래스의 객체를 직접 생성할 수 없다.

<br>
<br>

## 6.3 추상클래스의 작성

> **추상화 :** 클래스간의 공통점을 찾아내서 공통의 조상을 만드는 작업
**구체화 :** 상속을 통해 클래스를 구현, 확장하는 작업
> 

- 굳이 abstract를 붙여서 추상메서드로 선언하는 이유는 **자손 클래스에서 추상메서드를 반드시 구현하도록 강요하기 위해서이다.** (구현하지 않으면 해당 클래스의 객체를 생성하지 못한다.)

<br>

```java
abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() { /* ... */ }
}

class Marine extends Unit { // 보병
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void stimPack() { /* 스팀팩을 사용 */ }
}

class Tank extends Unit { // 탱크
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void changeMove() { /* 공격모드로 변환한다. */ }
}

class Dropship extends Unit { // 수송선
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void load() { /* 선택된 대상을 태운다 */ }
	void unload() { /* 선택된 대상을 내린다 */ }
}
```

- 각 클래스의 공통부분을 뽑아내서 Unit 클래스를 정의하고 이로부터 상속을 받는다.
- Unit 클래스는 다른 유닛을 위한 클래스를 작성하는데 재활용될 수 있다.
- Marine, Tank는 지상 유닛이고 Dropship은 공중유닛이므로 이동하는 방법이 달라 move메서드의 실제 구현 내용이 다를 것이다. **하지만 move의 선언부는 같기 때문에 추상메서드로 정의할 수 있다.**

<br>
<br>
<br>

# 7. 인터페이스(interface)

## 7.1 인터페이스란?

- 일종의 추상클래스
- **추상메서드를 갖지만 일반 메서드, 멤버변수를 구성원으로 가질 수 없다.**
- 추상클래스보다 추상화 정도가 높다.
- 다른 클래스를 작성하는데 도움 줄 목적으로 작성된다.

<br>
<br>

## 7.2 인터페이스의 작성

- 클래스를 작성하는 것과 동일. 키워드로 class 대신 interface를 사용하면 된다.
- 접근제어자로 public 또는 default를 사용할 수 있다.

```java
interface 인터페이스이름 {
	public static final 타입 상수이름 = 값;
	public static abstract 메서드이름 (매개변수목록);
}
```

<br>

- **인터페이스 멤버들의 제약사항**
    - 모든 멤버변수는 **public static final** 이어야 하며, 이를 생략할 수 있다.
    - 모든 메서드는 **public abstract** 이어야 하며, 이를 생략할 수 있다.
    (단, static 메서드와 디폴트 메서드는 예외)
    
    <br>
    <br>

## 7.3 인터페이스의 상속

- 인터페이스는 **인터페이스로부터만 상속을 받을 수 있다.**
- 클래스와는 달리 **다중상속**, 즉 여러 개의 인터페이스로부터 상속을 받는 것이 가능하다.

```java
interface Movable {
	void move(int x, int y);
}

interface Attackable {
	void attack(Unit u);
}

interface Fightable extends Movable, Attackable { }
```

- 자손 인터페이스(Fightable)는 조상 인터페이스(Movable, Attackable)에 정의된 멤버를 모두 상속받는다.
- Fightable 자체에는 정의된 멤버가 없지만 조상 인터페이스로부터 상속받은 두 개의 추상메서드를 멤버로 갖게 된다.

<br>
<br>

## 7.4 인터페이스의 구현

- 인터페이스도 그 자체로는 인스턴스를 생성할 수 없으며, 자신에 정의된 추상메서드의 몸통을 만들어주는 클래스를 작성해야한다.
- 인터페이스는 구현한다는 의미의 키워드 ‘implements’를 사용한다.

```java
class FighterTest {
	public static void main(String args[]) {
		Fighter f = new Fighter();
		
		if (f instanceof Unit) 
			System.out.println("f는 Unit 클래스의 자손입니다.")
		
		if (f instanceof Fightable) 
			System.out.println("f는 Fightable 인터페이스를 구현했습니다.")
		
		if (f instanceof Movable) 
			System.out.println("f는 Movable 인터페이스를 구현했습니다.")
		
		if (f instanceof Attackable) 
			System.out.println("f는 Attackable인터페이스를 구현했습니다.")
		
		if (f instanceof Object) 
			System.out.println("f는 Object 클래스의 자손입니다.")
	}
}

class Fighter extends Unit implements Fightable {
	public void move(int x, int y) { /* ... */ }
	public void attack(Unit u) { /* ... */ }
}

class Unit {
	int currentHP;
	int x;
	int y;
}

interface Fightable extends Movable, Attackable { }
interface Movable { void move(int x, int y); }
interface Attackable { void attack(Unit u); }

// 실행결과
// f는 Unit 클래스의 자손입니다.
// f는 Fightable 인터페이스를 구현했습니다.
// f는 Movable 인터페이스를 구현했습니다.
// f는 Attackable인터페이스를 구현했습니다.
// f는 Object 클래스의 자손입니다.
```

![](https://velog.velcdn.com/images/lwy210/post/21f740b9-db54-4838-9e24-f9a60ca7e0fe/image.png)

<br>
<br>

## 7.5 인터페이스를 이용한 다중상속

- ‘자바도 인터페이스를 이용하면 다중상속이 가능하다’라고 하는 것일 뿐 **자바에서 인터페이스로 다중상속을 구현하는 경우는 거의 없다.**
- 만일 두 개의 클래스로부터 상속을 받아야 할 상황이라면,
    - 두 조상 클래스 중에서 비중이 높은 쪽을 선택하고 다른 한쪽은 클래스 내부에 멤버로 포함시키는 방식으로 처리하거나
    - 어느 한쪽의 필요한 부분을 뽑아서 인터페이스로 만든 다음 구현하도록 한다.
   
<br>

**1) 문제 상황**

```java
public class Tv {
	protected boolean power;
	protected int channel;
	protected int volume;
	
	public void power() { power = !power; }
	public void channelUp() { channel++; }
	public void channelDown() { channel--; }
	public void volumeUp() { volume++; }
	public void volumeDown() { volume--; }
}

public class VCR {
	protected int counter;

	public void play() { /* Tape를 재생한다. */ }
	public void stop() { /* 재생을 멈춘다. */ }
	public void reset() { counter = 0; }
	public int getCounter() { return counter; }
	public void setCounter() { counter = c; } 
}
```

- TV 클래스와 VCR 클래스가 있을 때, TVCR 클래스를 작성하기 위해 두 클래스로부터 상속을 받을 수 있으면 좋겠지만 다중상속은 허용되지 않는다.
- 따라서, 한 쪽만 선택하여 상속받고 나머지 한 쪽은 클래스 내에 포함시켜서 내부적으로 인스턴스를 생성해서 사용하도록 한다.

<br>

**2) VCR 클래스에 정의된 메서드와 일치하는 추상메서드를 갖는 인터페이스 작성**

```java
public interface IVCR {
	public void play();
	public void stop();
	public void reset();
	public int getCounter();
	public void setCounter(int c);
}
```

<br>

**3) IVCR 인터페이스를 구현하고 Tv 클래스로부터 상속받는 TVCR 클래스를 작성**

```java
public class TVCR extends Tv implements IVCR {
	VCR vcr = new VCR();

	public void play() { vcr.play(); }
	public void stop() { vcr.stop(); }
	public void reset() { vcr.reset(); }
	public int getCounter() { return vcr.getCounter(); }
	public void setCounter() { vcr.setCounter(c); }
}
```

- **VCR 클래스 타입의 참조변수를 멤버변수로 선언해 IVCR 인터페이스의 추상메서드를 구현하는데 사용한다.**

- IVCR 인터페이스를 구현하기 위해서는 새로 메서드를 작성해야하는 부담이 있다.
- 하지만, 이처럼 VCR 클래스의 인스턴스를 사용하면 손쉽게 다중상속을 구현할 수 있다.
- VCR 클래스의 내용이 변경되어도 변경된 내용이 TVCR 클래스에도 자동적으로 반영되는 효과도 얻을 수 있다.

<br>
<br>

## 7.6 인터페이스를 이용한 다형성

- **인터페이스 역시 해당 인터페이스 타입의 참조변수를 이를 구현한 클래스의 인스턴스를 참조할 수 있으며, 인터페이스 타입으로의 형변환도 가능하다.**

```java
Fightable f = (Fightable)new Fighter();
또는
Fightable f = new Fighter();
```

<br>

- 따라서 인터페이스는 다음과 같이 메서드의 매개변수의 타입으로 사용될 수 있다.

```java
class Fighter extends Unit implements Fightable {
	public void move(int x, int y) { /* ... */ }
	public void attack(Fightable f) { /* ... */ }
}
```

```java
Fightable method() {
	...
	Fighter f = new Fighter();
	return f;
}
```

- 리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다.

<br>
<br>

## 7.7 인터페이스의 장점

> 
- 개발 시간을 단축시킬 수 있다.
- 표준화가 가능하다.
- 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
- 독립적인 프로그래밍이 가능하다.
> 

<br>

**[ 예시 ]**

![](https://velog.velcdn.com/images/lwy210/post/51681308-5ce7-4fcf-99dc-aba1f00cd08f/image.png)


**📢 문제 상황 : SCV(건설인부)가 Tank, Dropship과 같은 기계화 유닛을 수리할 수 있는 기능을 제공하고싶다.** ① SCV에 repair()메서드를 작성하면 수리 가능한 유닛만큼의 오버 로딩된 메서드를 정의해야한다. ② 각 공통조상에 repair 메서드를 추가하면 클래스들의 공통 조상이 다르므로 공통조상 타입으로 메서드를 정의해도 최소 2개의 메서드가 필요하고, 기계화 유닛이 아닌 클래스도 포함이 된다는 문제가 있다. 

**💡 해결 :** Repairable이라는 인터페이스를 정의하고 수리가 가능한 기계화 유닛에게 이 인터페이스를 구현하도록 하면 된다.

```java
class RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);               // SCV가 Tank를 수리하도록 한다.
		scv.repair(dropship);           // SCV가 Dropship을 수리하도록 한다.
		// scv.repair(marine);          // 에러! 
	}
}

interface Repairable {}

class Unit {
	int hitPoint;
	final int MAX_HP;
	Unit(int hp) {
		MAX_HP = hp;
	}
	// ...
}

class GroundUnit extends Unit {
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable {
	Tank() {
		super(125);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Dropship";
	}
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit)r;    
			while(u.hitPoint! != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println( u.toString() + "의 수리가 끝났습니다." );
		}
	}
}

// 실행결과
// Tank의 수리가 끝났습니다.
// Dropship의 수리가 끝났습니다.
```

- `Unit u = (Unit)r;` : Repairable에 정의된 멤버가 없어 이 타입의 참조변수로는 할 수 있는 일이 없다. 따라서 타입 체크 뒤 캐스팅한다 ⇒ Unit 클래스에 정의된 hitPoint, MAX_HP 사용 가능.
- `scv.repair(marine);` : Marine은 Repairable 인터페이스를 구현하지 않았으므로 컴파일 시 에러.

<br>
<br>

## 7.8 인터페이스의 이해

**📢 인터페이스를 이해하기 위해서 염두에 두어야 할 것**

> **1. 클래스를 사용하는 쪽(User)과 클래스를 제공하는 쪽(Provider)이 있다. 
2. 메서드를 사용(호출)하는 쪽(User)에서는 사용하려는 메서드(Provider)의 선언부만 알면 된다. (내용은 몰라도 된다.)**
> 

<br>
<br>

**[ 직접적인 관계의 두 클래스 ]**

```java
class A {
	public void methodA(B b){
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB()");	
	}
}

class InterfaceTest {
	public static void main(String arg[]) {
		A a = new A();
		a.methodA(new B());
	}
}

// 실행결과
// methodB()
```

- **클래스A (User) → 클래스B(Provider)**
- 클래스 B의 methodB()의 선언부가 변경되면, 이를 사용하는 클래스 A도 변경되어야함
    - 즉, 한 쪽(Provider)이 변경되면 다른 한 쪽(User)도 변경되어야 한다는 단점
    
    
<br>

**[ 인터페이스를 매개체로 이용 ]**

```java
class A {
	void autoPlay(I i) {
		i.play();
	}
}

interface I {
	public abstract void play();
}

class B implements I {
	public void play() {
		System.out.println("play in B class");
	}
}

class C implements I {
	public void play() {
		System.out.println("play in C class");
	}
}

class InterfaceTest2 {
	public static void main(String args[]) {
		A a = new A();
		a.autoPlay(new B()); // void autoPlay(I i) 호출
		a.autoPlay(new C()); // void autoPlay(I i) 호출
	}
}
// 실행결과
// play in B class
// play in C class
```

- **클래스A (User) → 인터페이스I(클래스B(Provider))**
- **클래스A (User) → 인터페이스I(★)**
- Provider 클래스에 변경사항이 생기거나 다른 클래스로 대체되어도 User 클래스는 전혀 영향을 받지 않도록 된다.
- 클래스 A는 매개변수를 통해 인터페이스 I를 구현한 클래스의 인스턴스를 동적으로 제공받아야 한다.
- e.g.) 클래스 Thread의 생성자인 Thread(Runnable target)이 이런 방식으로 되어 있다.


<br>

**[ 제3의 클래스를 매개체로 이용 ]**

```java
class InterfaceTest3 {
	public static void main(String args[]) {
		A a = new A();
		a.method();
	}
}

class A {
	void methodA() {
		// 제3의 클래스의 메서드를 통해 인터페이스 I를 구현한 클래스의 인스턴스를 얻어온다.
		I i = InstanceManger.getInstance(); 
		i.methodB();
		System.out.println(i.toString());
	}
}

interface I {
	public abstract void methodB();
}

class B implements I {
	public void methodB() {
		System.out.println("methodB in B class");
	}
	public String toString() { return "class B"; }
}

class InstanceManger {
	public static I getInstance() {
		return new B(); // 다른 인스턴스로 바꾸려면 여기만 변경하면 된다.
	}
}

// 실행결과
// methodB in B class
// class B
```

- 인스턴스를 직접 생성하지 않고, getInstance()라는 메서드를 통해 제공받는다.
- 나중에 다른 클래스의 인스턴스로 변경되어도 A클래스의 변경없이 **getInstance()만 변경하면 된다는 장점이 생김.**


<br>
<br>

## 7.9 디폴트 메소드와 static 메서드

- 인터페이스의 모든 메서드는 추상 메서드이어야 한다.
- 인터페이스와 관련된 static 메서드는 별도의 클래스에 따로 두어야한다.
- e.g.) java.util.Collection

<br>

`디폴트 메소드`

- **추상 메서드의 기본적인 구현을 제공하는 메서드**
- **고안 배경 :** 인터페이스에 메서드를 추가한다는 것은, 추상 메서드를 추가한다는 것이고, 이 인터페이스를 구현한 기존의 모든 클래스들이 새로 추가된 메서드를 구현해야한다.
- **장점 :** 추상 메서드가 아니므로 디폴트 메서드가 새로 추가되어도 해당 인터페이스를 구현한 클래스는 변경하지 않아도 된다.

```java
interface MyInterface {
	void method();
	void newMethod(); // 추상 메서드
}
⇓
interface MyInterface {
	void method();
	**default void newMethod(); // 기존의 MyInterface를 구현한 클래스를 변경하지 않아도 됨**
}
```

<br>


**새로 추가된 디폴트 메서드가 기존의 메서드와 이름이 중복되어 충돌 할 경우 해결법**

1. **여러 인터페이스의 디폴트 메서드 간의 충돌**
    
    인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩해야 한다.
    
2. **디폴트 메서드와 조상 클래스의 메서드간의 충돌**
    
    조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.
    

**⇒ 💡 외우기 귀찮다?** 필요한 쪽의 메서드와 같은 내용으로 오버라이딩 하자.

<br>
<br>
<br>

# 8. 내부 클래스(inner class)

## 8.1 내부 클래스란?

- **클래스 내에 선언된 클래스**
- 두 클래스가 서로 긴말한 관계에 있을 때 클래스에 다른 클래스를 선언한다.
- **장점 1 :** 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
- **장점 2 :** 코드의 복잡성을 줄일 수 있다. (캡슐화)

<br>


## 8.2 내부 클래스의 종류와 특징

| 내부 클래스 | 특징 |
| --- | --- |
| 인스턴스 클래스 (instance class) | - 외부 클래스의 멤버변수 선언위치에 선언 <br>- 외부 클래스의 인스턴스 멤버처럼 다루어짐  <br>- 주로 외부 클래스의 인스턴스 멤버들과 관련된 작업에 사용될 목적으로 선언 됨 |
| 스태틱 클래스 (static class) | - 외부 클래스의 멤버변수 선언위치에 선언 <br>- 외부 클래스의 static 멤버처럼 다루어짐 <br>- 주로 외부 클래스의 static 멤버, 특히 static 메서드에서 사용될 목적으로 사용됨 |
| 지역 클래스 (local class) | - 외부 클래스의 메서드나 초기화 블럭 안에 선언하며, 선언된 영역 내부에서만 사용될 수 있음 |
| 익명 클래스 (anonymous class) | - 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스 (일회용) |

<br>
<br>

## 8.3 내부 클래스의 선언

**내부 클래스의 선언위치가 변수의 선언위치와 동일하다!**

```java
class Outer {
	class InstanceInner {}
	static class StaticInner {}

	void myMethod() {
		class LocalInner {}
	}
}
```

<br>
<br>

### 8.4 내부 클래스의 제어자와 접근성

- 내부 클래스도 클래스이므로 abstract, final, private, protected와 같은 제어자를 사용할 수 있다.
- 내부 클래스에 멤버 변수로 `static` → 에러, `final static` → 상수이므로 허용
- 하지만, 내부클래스 중 스태틱 클래스는 static 멤버를 가질 수 있다.
- 스태틱 클래스는 외부 클래스의 인스턴스멤버와 인스턴스클래스의 멤버들을 를 객체생성 없이 사용할 수 없다.
- 지역 클래스는 외부 클래스의 인스턴스멤버와 static멤버를 모두 사용할 수 있으며, 지역 클래스가 포함된 메서드에 정의된 지역변수도 사용할 수 있다. 단, final이 붙은 지역변수만 접근가능한데 그 이유는 메서드가 수행을 마쳐서 지역변수가 소멸된 시점에도, 지역 클래스의 인스턴스가 소멸된 지역변수를 참조하려는 경우가 발생할 수 있기 때문

<br>

- 컴파일 했을 때 생성되는 파일명은 **‘외부 클래스명$내부클래스명.class’**형식으로 되어 있다.

```java
class Outer {
	void myMethod() {
		class LocalInner() {}
	}
	void myMethod2() {
		class LocalInner() {}
	}
}

// 컴파일 시 생성되는 클래스 파일
// Outer.class
// Outer$1LocalInner.class
// Outer$2LocalInner.class
```

<br>


- 내부 클래스와 외부 클래스에 선언된 변수의 이름이 같을 때 변수 앞에 ‘this’ 또는 ‘외부 클래스명.this’를 뭍여서 서로 구별할 수 있다

```java
class Outer {
	int value = 10; // Outer.this.value

	class Inner {
		int value = 20; // this.value

		void method1() {
			int value = 30;
			System.out.println("           value :" + value);
			System.out.println("      this.value :" + this.value);
			System.out.println("Outer.this.value :" + Outer.this.value);
		}
	}
}

class InnerEx5 {
	public static void main(String arg[]) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method1();
	}
}

// 실행결과
//            value :30
//       this.value :20
// Outer.this.value :10
```

<br>
<br>

## 8.5 익명 클래스(anonymous class)

- **이름이 없는 클래스**
- 클래스의 선언과 객체의 생성을 동시에 하므로 단 한번만 사용될 수 있고 오직 하나의 객체만을 생성할 수 있는 일회용 클래스이다.

<br>

**[ 예시 1 ]**

```java
class InnerEx6 {
	Object iv = new Object() { void method(){} };        // 익명 클래스
	static Object cv = new Object() { void method(){} }; // 익명 클래스

	void myMethod() {
		Object lv = new Object() { void method(){} };       // 익명 클래스
	}
}

// 컴파일 시 생성되는 클래스 파일
// InnerEx6.class
// InnerEx6$1.class
// InnerEx6$2.class
// InnerEx6$3.class
```

<br>


**[ 익명 클래스 변환 전 ]**

```java
import java.awt.*;
import java.awt.event.*;

class InnerEx7 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
	}
}

class EventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!!!");
	}
}
```

<br>


**[ 익명 클래스 변환 전 ]**

```java
import java.awt.*;
import java.awt.event.*;

class InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(**new EventHandler() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("ActionEvent occurred!!!");
				}
			} // 익명 클래스의 끝**
		);
	} // main의 끝
} // InnerEx8의 끝
```

<br>
<br>
<br>