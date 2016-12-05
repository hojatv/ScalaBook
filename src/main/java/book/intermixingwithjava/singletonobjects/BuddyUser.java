package book.intermixingwithjava.singletonobjects;

/**
 * Created by hovaheb on 12/5/2016.
 */
public class BuddyUser {
    public static void main(String[] args) {
        new Buddy().greet();
        Buddy$.MODULE$.greet();
    }
}
