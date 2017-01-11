package book.practicefromwork;

/**
 * Created by hovaheb on 1/10/2017.
 */
public abstract class TestAbstractClass {
    public String getName(String name) {
        return name;
    }

    public abstract void test();

    static class A extends TestAbstractClass {
        @Override
        public void test() {
            System.out.println("test");
        }
    }

    public static void main(String args[]) {
        TestAbstractClass testAbstractClass = new A();
        System.out.println(testAbstractClass.getName("Reza"));
        testAbstractClass.test();
    }
}
