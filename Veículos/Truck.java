public class Truck extends Vehicle {
    private int CargoCap; // cargo capacity in pounds

    public Truck(int p, int f, int m, int c, String nome) {
        super(p, f, m, nome);
        CargoCap = c;
    }

    public String toString () {
        return super.toString() + String.format("\n|Suporta %d KG de carga", CargoCap);
    }
    
}
