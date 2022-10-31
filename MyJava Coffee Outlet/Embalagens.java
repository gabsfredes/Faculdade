public enum Embalagens {
    GRANDE(20),
    MEDIA(10),
    PEQUENA(5);

    private double limitePacotes;

    Embalagens(double limitePacotes) {
        this.limitePacotes = limitePacotes;
    }

    public double getLimitePacotes() {
        return limitePacotes;
    }
}