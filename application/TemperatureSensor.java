package application;
import java.util.Random;
public class TemperatureSensor implements Sensor {
    private int value;
    private boolean on;
    public TemperatureSensor() {
        Random random = new Random();
        this.value = random.nextInt(60) - 30;
        this.on = false;
    }
    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        this.on = true;

    }

    @Override
    public void setOff() {
        this.on = false;
    }

    @Override
    public int read() {
        if(isOn()){
            Random random = new Random();
            this.value = random.nextInt(60) - 30;
        } else {
            throw new IllegalArgumentException("Sensor is off");
        }
        return this.value;
    }
    public static void main(String[] args){
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.setOn();
        System.out.println("Current temperature: " + sensor.read());
        sensor.setOff();
        try {
            System.out.println("Current temperature: " + sensor.read());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
