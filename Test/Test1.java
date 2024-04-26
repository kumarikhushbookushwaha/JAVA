package JAVA.Test;

class Test1 {

    int a = 10;
    int b = 30;
    String c = "aa";
    char e = 'c';
    boolean d = true;

    public Test1() {

    }

    public Test1(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Inside constructor 1" + a + " " + b);
    }

    public Test1(int a, int b, String c, char e, boolean d) {
        this(a, b);
        this.c = c;
        this.d = d;
        this.e = e;
        System.out.println("Inside constructor 2");
    }

    @Override
    public String toString() {
        return "Test1 [a=" + a + ", b=" + b + ", c=" + c + ", e=" + e + ", d=" + d + "]";
    }

    public static void main(String[] args) {
        System.out.println("Test1 is Compiled");
    }

}
