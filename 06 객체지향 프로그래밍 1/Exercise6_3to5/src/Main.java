
public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;
        System.out.println("이름:"+s.name);
        System.out.println("총점:"+s.getTotal());
        System.out.println("평균:"+s.getAverage());

        Student s2 = new Student("홍길동",1,1,100,60,76);
        System.out.println(s2.info());
    }
}

class Student {
    // ☑ [6-3] 다음과 같은 멤버변수를 갖는 클래스를 정의하시오.
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student() { }

    // [6-5] 다음과 같은 실행결과를 얻도록 클래스에 생성자와 info()를 추가하시오.
    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    String info() {
        return name + ',' + ban + ',' + no + ',' + kor + ',' + eng + ',' + math;
    }

    // ☑ [6-4] 두 개의 메서드 getTotal()과 getAverage() 추가
    int getTotal() {
        return this.kor + this.eng + this.math;
    }
    float getAverage() {
        return (int)(getTotal() / 3f * 10 + 0.5f) / 10f;
    }
}