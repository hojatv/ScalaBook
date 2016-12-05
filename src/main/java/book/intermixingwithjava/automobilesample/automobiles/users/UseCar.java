package book.intermixingwithjava.automobilesample.automobiles.users;

import book.intermixingwithjava.automobilesample.Car;

/**
 * Created by hovaheb on 12/5/2016.
 */
public class UseCar {
    public static void main(String[] args) {
        Car car = new Car(2009);
        System.out.println(car);
        car.drive(10);
        System.out.println(car);

    }
}
