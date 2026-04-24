package engine;

public class GasolineEngine implements Engine {
    private int speed = 0;
    
    @Override
    public void increase() {
        speed++;
        System.out.println("  GasolineEngine speed increased to " + speed + " km/h");
    }

    @Override
    public void decrease() {
        if (speed > 0) {
            speed--;
        }
        System.out.println("  GasolineEngine speed decreased to " + speed + " km/h");
    }

    @Override
    public void speedNotifier(int carSpeed) {
        this.speed = carSpeed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return "Gasoline";
    }
}
