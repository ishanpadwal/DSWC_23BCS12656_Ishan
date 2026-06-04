abstract class SpaceVessel {
    short shipId;
    boolean isOperational;
    char fleetClass;

    public SpaceVessel(short shipId, boolean isOperational, char fleetClass) {
        this.shipId = shipId;
        this.isOperational = isOperational;
        this.fleetClass = fleetClass;
    }
}

class MiningShip extends SpaceVessel {
    float[][] cargoHold;

    public MiningShip(short shipId, boolean isOperational, char fleetClass, float[][] cargoHold) {
        super(shipId, isOperational, fleetClass);
        this.cargoHold = cargoHold;
    }

    public float calculateTotalOreWeight() {
        float total = 0;
        for (float[] bay : cargoHold)
            for (float container : bay)
                total += container;
        return total;
    }

    public float findHeaviestContainer() {
        float max = cargoHold[0][0];
        for (float[] bay : cargoHold)
            for (float container : bay)
                if (container > max) max = container;
        return max;
    }
}

public class Mininfleet {
    public static void main(String[] args) {
        float[][] ore = {
            {1200.5f, 3400.2f},
            {5000.0f, 2800.7f}
        };

        MiningShip ship = new MiningShip((short) 101, true, 'A', ore);
        System.out.println("Total Ore Weight = " + ship.calculateTotalOreWeight());
        System.out.println("Heaviest Container = " + ship.findHeaviestContainer());
    }
}