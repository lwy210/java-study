## 배열(array)

### 배열의 선언과 생성

```java
// 1. 선언과 생성을 따로
타입[] 변수이름;                // 배열을 선언 (배열을 다루기 위한 참조변수 선언)
변수이름 = new 타입[길이];      // 배열을 생성 (실제 저장공간을 생성)

// 2. 선언과 생성을 동시에
타입[] 변수이름 = new 타입[길이]  
```

```java
// 1. 선언과 생성을 따로
int[] score;
score = new int[5]

// 2. 선언과 생성을 동시에
int[] score = new int [5]
```
<br>

### 배열의 길이 변경하기

1. 더 큰 배열을 새로 생성한다.
2. 기존 배열의 내용을 새로운 배열에 복사한다.
<br>

### 배열의 초기화

```java
int[] score = new int[]{ 50, 60, 70, 80, 90};
int[] score = { 50, 60, 70, 80, 90};

int add(int[] arr) { /*내용 생략*/ }
int result = add(new int[]{ 100, 90, 80, 70, 60});

// 길이가 0인 배열 생성
int[] score = new int[0];
int[] score = new int[]{};
int[] score = {};
```
<br>

### 배열의 출력

```java
int[] iArr = { 100, 95, 80, 70, 60};

for(int i=0; i<iArr.length; i++) {
	System.out.println(iArr[i]);
}
```
<br>


### 배열의 복사

- for문을 이용한 배열 복사
    
    ```java
    int[] arr = {1, 2, 3, 4, 5};
    int[] tmp = new int(arr.length*2) // 기존 배열보다 길이가 2배인 배열 생성
    
    for(int i=0; i<arr.length; i++) {
    	tmp[i] = arr[i];
    }
    
    arr = tmp // 참조변수 arr이 새로운 배열을 가리키게 한다.
    ```
    
- System.arraycopy()를 이용한 배열 복사
    
    for문 보다 효율적이다.
    
    ```java
    int[] arr = {1, 2, 3, 4, 5};
    int[] tmp = new int(arr.length*2) // 기존 배열보다 길이가 2배인 배열 생성
    
    System.arraycopy(arr, 0, tmp, 0, arr.length) // arr[0]에서 tmp[0]으로 arr.length개의 데이터를 복사
    ```
    
<br>
<br>

## String 배열

### String배열의 선언과 생성

```java
String name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다.
```

<br>

### String배열의 초기화

```java
String[] name = new String[]{"Kim", "Park", "Yi"};
String[] name = {"Kim", "Park", "Yi"};
```

<br>
<br>

## 다차원 배열

### 2차원 배열의 선언과 인덱스

| 선언 방법 | 선언 예 |
| --- | --- |
| 타입[][] 변수이름; | int[][] score; |
| 타입 변수이름[][]; | int score[][]; |
| 타입[] 변수이름[]; | int[] score[]; |

<br>

### 가변 배열

```java
int[][] score = new int[5][3]; // 5행 3열의 2차원 배열 생성

// 위 코드를 다음과 같이 표현할 수 있따.
int[][] score = new int[5][]; // 두 번째 차원의 길이는 지정하지 않는다.
socore[0] = new int[3];
socore[1] = new int[3];
socore[2] = new int[3];
socore[3] = new int[3];
socore[4] = new int[3];

// 행마다 다른 길이의 배열을 생성할 수 있다.
int[][] score = new int[5][]; // 두 번째 차원의 길이는 지정하지 않는다.
socore[0] = new int[4];
socore[1] = new int[3];
socore[2] = new int[2];
socore[3] = new int[2];
socore[4] = new int[3];
```