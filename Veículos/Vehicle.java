public class Vehicle {
    private int Passengers; // number of passengers
    private int FuelCap; // fuel capacity in gallons
    private int MPG; // fuel consumption in miles per gallon
    private String nome; // nome do veiculo

    public Vehicle(int p, int f, int m, String nome) {
        Passengers = p;
        FuelCap = f;
        MPG = m;
        setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString () {
        String toString = String.format("\n|Veículo: %s (%d passageiros)\n|Suporta %d galões de gasolina\n|Faz %d milhas por galão", nome, Passengers, FuelCap, MPG);
        return toString;
    }
}
