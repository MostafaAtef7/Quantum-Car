import car.Car;
import car.CarFactory;

public class Main {

    public static void main(String[] args) {

        CarFactory factory = new CarFactory();

        System.out.println("1-GASOLINE CAR");
        Car gasCar = factory.createCar(CarFactory.EngineType.GASOLINE);
        gasCar.start();
        gasCar.accelerate();
        gasCar.accelerate();
        gasCar.brake();
        gasCar.brake();
        gasCar.stop();

        System.out.println("2-Electric car");
        Car electricCar = factory.createCar(CarFactory.EngineType.ELECTRONIC);
        electricCar.start();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.brake();
        electricCar.brake();
        electricCar.stop();

        System.out.println("3-Hybrid car");
        Car hybridCar = factory.createCar(CarFactory.EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();   // 20 -> electric
        hybridCar.accelerate();   // 40 -> electric
        hybridCar.accelerate();   // 60 -> gas  (crosses boundary)
        hybridCar.accelerate();   // 80 -> gas
        hybridCar.brake();        // 60 -> gas
        hybridCar.brake();        // 40 -> electric (back below 50)
        hybridCar.brake();        // 20 -> electric
        hybridCar.brake();        // 0  -> electric
        hybridCar.stop();

        System.out.println("4-Engine replacement");
        Car car = factory.createCar(CarFactory.EngineType.GASOLINE);
        car.start();
        car.accelerate();
        car.brake();
        car.stop();

        factory.replaceEngine(car, CarFactory.EngineType.HYBRID);

        car.start();
        car.accelerate();  // 20 -> electric
        car.accelerate();  // 40 -> electric
        car.accelerate();  // 60 -> gas
        car.brake();       // 40 -> electric
        car.brake();       // 20
        car.brake();       // 0
        car.stop();

        System.out.println("5-Some Exceptions");
        Car carWithExceptions = factory.createCar(CarFactory.EngineType.GASOLINE);
        carWithExceptions.start();
        carWithExceptions.accelerate();
        System.out.println("to continue with next steps please do brakes until car stop");
        System.out.println("UNCOMMENT LINES 65 TO CONTINUE");
        //carWithExceptions.brake();
        carWithExceptions.stop();    //there is exception will throw because car can not stop while the speed > 0

        carWithExceptions.start();
        carWithExceptions.accelerate();
        System.out.println("to continue with next steps please do brakes until car stop");
        System.out.println("UNCOMMENT LINES (72 AND 73) TO CONTINUE");
        //carWithExceptions.brake();
        //carWithExceptions.stop();
        factory.replaceEngine(carWithExceptions, CarFactory.EngineType.ELECTRONIC);

        carWithExceptions.start();
        for (int i = 0; i < 12; i++) carWithExceptions.accelerate();
        for (int i = 0; i < 11; i++) carWithExceptions.brake();
        carWithExceptions.stop();
    }


}
