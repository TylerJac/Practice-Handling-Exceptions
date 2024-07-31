package application;

public class StandardSensor implements Sensor {
    private final int value;

    public StandardSensor(int value) {
        this.value = value;
    }

    @Override
    public boolean isOn() {
        return true; // Standard sensor is always on
    }

    @Override
    public void setOn() {
        // No effect, sensor is always on
    }

    @Override
    public void setOff() {
        // No effect, sensor is always on
    }

    @Override
    public int read() {
        return this.value;
    }

    public static void main(String[] args) {
        StandardSensor ten = new StandardSensor(10);
        StandardSensor minusFive = new StandardSensor(-5);

        System.out.println(ten.read());
        System.out.println(minusFive.read());

        System.out.println(ten.isOn());
        ten.setOff();
        System.out.println(ten.isOn());
    }
}