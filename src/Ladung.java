public class Ladung {
    private String bezeichnung;
    private int menge;

    public Ladung() {
    }

    public Ladung(String bezeichnung, int menge) {
        this.bezeichnung = bezeichnung;
        this.menge = menge;
    }

    public void setBezeichnung(String name) {
        this.bezeichnung = name;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getMenge() {
        return this.menge;
    }

    @Override
    public String toString() {
        return "Ladung{" + "bezeichnung='" + bezeichnung + "" + ", menge=" + menge + '}';
}
}
