package car;

import engine.Engine;

public class Car {

    private static final int MAX_SPEED = 200;
    private static final int MIN_SPEED = 0;
    private static final int SPEED_STEP = 20;
    private Engine engine;
    private int speed = 0;
    private boolean running = false;

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("car created with: " + engine.getName());
    }

    public void start() {
        if (running) {
            System.out.println("car is already running.");
        }
        running = true;
        speed = 0;
        engine.speedNotifier(speed);
        System.out.println("car started (engine: " + engine.getName() + ", speed: " + speed + " km/h)");
    }

    public void stop() {
        if (!running) {
            System.out.println("car is already stopped.");
        }
        if (speed != 0) {
            throw new IllegalStateException("Cannot stop: speed must be 0 before stopping (current: " + speed + " km/h). Brake first.");
        }
        running = false;
        engine.speedNotifier(0);
        System.out.println("car stopped");
    }
    
    public void accelerate() {
        if (!running) {
            throw new IllegalStateException("car is not running - call start() first.");
        }
        if (speed > MAX_SPEED) {
            throw new IllegalStateException("Already at maximum speed (" + MAX_SPEED + " km/h).");
        }
        speed = Math.min(speed + SPEED_STEP, MAX_SPEED);
        engine.speedNotifier(speed);
        System.out.println("car speed: " + speed + " km/h");
    }

    public void brake() {
        if (!running) {
            throw new IllegalStateException("car is not running - call start() first.");
        }
        if (speed < MIN_SPEED) {
            throw new IllegalStateException("Car stopped (speed is 0).");
        }
        speed = Math.max(speed - SPEED_STEP, MIN_SPEED);
        engine.speedNotifier(speed);
        System.out.println("car speed: " + speed + " km/h");
    }

    public void replaceEngine(Engine newEngine) {
        if (running) {
            throw new IllegalStateException("Cannot replace engine while car is running - stop first.");
        }
        System.out.println("Replacing: " + engine.getName() + " --> " + newEngine.getName());
        this.engine = newEngine;
    }

    public int getSpeed () {
        return speed;
    }
    public Engine getEngine () {
        return engine;
    }
    public boolean isRunning () {
        return running;
    }

}
