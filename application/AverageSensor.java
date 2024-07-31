package application;
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private boolean on;
    private final List<Sensor> sensors;

    public AverageSensor() {
        this.on = false;
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        this.on = true;
        for (Sensor s : sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        this.on = false;
    }

    @Override
    public int read() {
        int value;
        if (isOn()) {
            int sum = 0;
            for (Sensor sensor : sensors) {
                sum += sensor.read();
            }
            value = sum / sensors.size();
        } else {
            throw new IllegalArgumentException("Sensor is off");
        }
        return value;
    }

    public List<Integer> readings() {
        List<Integer> readings = new ArrayList<>();
        if (isOn()) {
            for (Sensor sensor : sensors) {
                readings.add(sensor.read());
            }
        } else {
            throw new IllegalArgumentException("Sensor is off");
        }
        return readings;
    }

    public static void main(String[] args) {
        Sensor kumpula = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);
        try {
            helsinkiRegion.setOn();
            System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
            System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
            System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");

            System.out.println("readings: " + helsinkiRegion.readings());
            helsinkiRegion.setOff();
            System.out.println("temperature in Helsinki region after turning off: " + helsinkiRegion.read() + " degrees Celsius");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}