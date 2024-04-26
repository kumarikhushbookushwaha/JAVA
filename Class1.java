package JAVA;

class Class1 {

    public static void print(final String Str) {
        System.out.println(Str);
    }

    public Class1() {
        Class1.print("Inside default super const");
    }

    public Class1(final int x) {
        Class1.print("Inside super const" + x);

    }
}

class Class2 extends Class1 {
    public Class2() {
        super(10);
        Class1.print("Inside default sub class const");

    }

    public static void main(final String[] args) {
        String str = "ramendra";
        System.out.println(str.substring(str.length() - 3));

        Runnable ru = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside run");
            }
        };
        Thread th = new Thread(ru);
        th.start();

        final Class2 cs = new Class2();
        // super.print("Inside main");
        for (final String st : args) {
            System.out.println(st);
        }
        final Integer a = null;
        final String s1 = "";
        System.out.println(s1 instanceof java.lang.String);
        System.out.println(a instanceof java.lang.Integer);
        try {
            cs.display();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "____" + e.toString());
        }

    }

    public void display() throws ArithmeticException {
        int a = 5 / 0;

        super.print("Inside main" + a);

    }

}
