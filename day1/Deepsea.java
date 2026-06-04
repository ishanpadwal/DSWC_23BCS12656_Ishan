package day1;
class HardwareLockException extends Exception {
    public HardwareLockException(String message) {
        super(message);
    }
}

class SensorCorruptionException extends RuntimeException {
    public SensorCorruptionException(String message) {
        super(message);
    }
}

class TelemetryStream implements AutoCloseable {
    public void readData() {
        System.out.println("Reading telemetry data...");
    }

    @Override
    public void close() {
        System.out.println("TelemetryStream closed.");
    }
}

public class Deepsea{
    public static void parseTelemetry() throws HardwareLockException {
        try (TelemetryStream stream = new TelemetryStream()) {
            stream.readData();
            boolean fileLocked = false;
            boolean sensorCorrupted = true;
            if (fileLocked)
                throw new HardwareLockException("Telemetry file is locked!");
            if (sensorCorrupted)
                throw new SensorCorruptionException("Invalid sensor value detected!");
            System.out.println("Telemetry parsed successfully.");
        }
    }

    public static void main(String[] args) {
        try {
            parseTelemetry();
        } catch (HardwareLockException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        } catch (SensorCorruptionException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }
}