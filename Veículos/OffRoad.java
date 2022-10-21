public class OffRoad extends Vehicle {
    private int GroundClearance; // ground clearance in inches

    public OffRoad(int p, int f, int m, int g, String nome) {
        super(p, f, m, nome);
        GroundClearance = g;
    }

    public String toString() {
        return super.toString() + String.format("\n|Distância entre o solo e o veículo: %d cm", GroundClearance);
    }
}
