package book.intermixingwithjava.extendingclasses;

/**
 * Created by hovaheb on 12/5/2016.
 */
public class Pinguin extends Bird {
    @Override
    public void fly() throws NoFlyException {
        throw new NoFlyException();
    }
}
