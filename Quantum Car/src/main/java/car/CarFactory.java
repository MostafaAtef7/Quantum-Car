package car;

import engine.ElectronicEngine;
import engine.Engine;
import engine.GasolineEngine;
import engine.HybridEngine;

public class CarFactory {

    public enum EngineType {
        GASOLINE,
        ELECTRONIC,
        HYBRID
    }
    
    private Engine buildEngine(EngineType type) {
        if (type == EngineType.GASOLINE) {
            return new GasolineEngine();
        } else if (type == EngineType.ELECTRONIC) {
            return new ElectronicEngine();
        } else if (type == EngineType.HYBRID) {
            return new HybridEngine();
        } else {
            throw new IllegalArgumentException("Enter valid engine type");
        }
    }
    public Car createCar(EngineType type) {
        Engine engine = buildEngine(type);
        return new Car(engine);
    }

    public void replaceEngine(Car car, EngineType type) {
        Engine newEngine = buildEngine(type);
        car.replaceEngine(newEngine);
    }


}
