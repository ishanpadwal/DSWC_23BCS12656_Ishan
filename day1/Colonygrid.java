package day1;

class PowerManager {
    private byte sectorStates = 0;

    public void turnOnSector(int i) {
        sectorStates = (byte) (sectorStates | (1 << i));
    }

    public void turnOffSector(int i) {
        sectorStates = (byte) (sectorStates & ~(1 << i));
    }

    public boolean isSectorOn(int i) {
        return (sectorStates & (1 << i)) != 0;
    }

    public void displayStates() {
        System.out.println(
            String.format("%8s", Integer.toBinaryString(sectorStates & 0xFF))
                   .replace(' ', '0')
        );
    }
}

public class Colonygrid {
    public static void main(String[] args) {
        PowerManager pm = new PowerManager();
        pm.turnOnSector(0);
        pm.turnOnSector(3);
        pm.turnOnSector(7);
        pm.displayStates();
        System.out.println("Sector 3 ON? " + pm.isSectorOn(3));
        System.out.println("Sector 2 ON? " + pm.isSectorOn(2));
        pm.turnOffSector(3);
        pm.displayStates();
    }
}