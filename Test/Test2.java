package JAVA.Test;

class Test2 extends Test1 {

    int x;
    int y;

    public Test2(int x, int y) {
        super(2, 4);
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        Test1 t2 = new Test1(12, 56);

        Test1 t3 = new Test1(40, 76, "abcd", 'g', false);
        System.out.println("First object = " + t1.toString());
        System.out.println("Second object = " + t2.toString());
        System.out.println("Third object = " + t3.toString());

    }

}
