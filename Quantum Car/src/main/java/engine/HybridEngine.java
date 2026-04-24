package engine;

public class HybridEngine implements Engine {

    private static final int ELECTRIC_THRESHOLD = 50;
    private final ElectronicEngine electricEngine = new ElectronicEngine();
    private final GasolineEngine gasolineEngine = new GasolineEngine();

    private Engine activeEngine(int carSpeed) {
        if (carSpeed < ELECTRIC_THRESHOLD) {
            return electricEngine;
        }
        else {
            return gasolineEngine;
        }
    }

    @Override
    public void increase() {
        activeEngine(getSpeed()).increase();
    }

    @Override
    public void decrease() {
        activeEngine(getSpeed()).decrease();
    }
    
    @Override
    public void speedNotifier(int carSpeed) {
        System.out.println("HybridEngine car speed is " + carSpeed + " km/h"
                + " converting to " + activeEngine(carSpeed).getName());

        if (carSpeed < ELECTRIC_THRESHOLD) {
            electricEngine.speedNotifier(carSpeed);
            gasolineEngine.speedNotifier(0);   // idle gas engine
        }
        else {
            gasolineEngine.speedNotifier(carSpeed);
            electricEngine.speedNotifier(0);   // idle electric engine
        }
    }

    @Override
    public int getSpeed() {
        return Math.max(electricEngine.getSpeed(), gasolineEngine.getSpeed());
    }

    @Override
    public String getName() {
        return "Hybrid engine";
    }
}
