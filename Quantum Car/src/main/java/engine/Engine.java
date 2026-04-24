package engine;

public interface Engine {
    void increase();
    void decrease();
    void speedNotifier(int carSpeed);
    int getSpeed();
    String getName();
}
