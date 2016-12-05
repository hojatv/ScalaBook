package book.intermixingwithjava.scalatraits;

/**
 * Created by hovaheb on 12/5/2016.
 */
public class AWritableJavaClass implements Writable{
    @Override
    public void write(String message) {
        System.out.println("message = " + message);
    }
}
