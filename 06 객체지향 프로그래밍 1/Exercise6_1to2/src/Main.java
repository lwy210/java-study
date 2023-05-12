public class Main {
    public static void main(String[] args) {
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();
        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}

// ☑ [6-1] 다음과 같은 멤버변수를 갖는 클래스를 정의하시오.
class SutdaCard {
// ☑ [6-2] 문제 에서 정의한 클래스에 두 개의 생성자와 info()를 추가해서 실행 결과와 같은 결과를 얻도록 하시오.
   // member variables
    int num;
    boolean isKwang;

    // default constructor
    SutdaCard () {
        this(1, true);
    }

    // constructor 1
    SutdaCard (int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // method : print info
    String info() {
        return this.num + (isKwang ? "K" : "");
    }

}
