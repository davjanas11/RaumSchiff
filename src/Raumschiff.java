import java.util.ArrayList;

public class Raumschiff {
    private String schiffsname;
    private int huelleInProzent;
    private int schildeInProzent;
    private int energieversorgungInProzent;
    private int photonentorpedoAnzahl;
    private int lebenserhaltungssystemeInProzent;

    public Raumschiff(String schiffsname, int huelleInProzent, int schildeInProzent, int energieversorgungInProzent,
                      int photonentorpedoAnzahl, int lebenserhaltungssystemeInProzent) {
        this.schiffsname = schiffsname;
        this.huelleInProzent = huelleInProzent;
        this.schildeInProzent = schildeInProzent;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public void photonentorpedoSchiessen() {
        if (photonentorpedoAnzahl > 0) {
            treffer();
            photonentorpedoAnzahl--;
        }
    }

    public void phaserkanoneSchiessen() {
        treffer();
    }

    private void treffer() {
        this.setSchildeInProzent(this.getSchildeInProzent() - 50);
        if (this.getSchildeInProzent() <= 0) {
            this.setEnergieversorgungInProzent(this.getEnergieversorgungInProzent() - 50);
            this.setHuelleInProzent(this.getHuelleInProzent() - 50);
            if (this.getHuelleInProzent() < 0) {
                this.setHuelleInProzent(0);
            }
            if (this.getEnergieversorgungInProzent() < 0) {
                this.setEnergieversorgungInProzent(0);
            }
        }
    }

    // Getter und Setter Methoden

    public int getPhotonentorpedoAnzahl() {
        return photonentorpedoAnzahl;
    }

    public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahl) {
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
    }

    public int getEnergieversorgungInProzent() {
        return energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent;
    }

    public int getSchildeInProzent() {
        return schildeInProzent;
    }

    public void setSchildeInProzent(int schildeInProzent) {
        this.schildeInProzent = schildeInProzent;
    }

    public int getHuelleInProzent() {
        return huelleInProzent;
    }

    public void setHuelleInProzent(int huelleInProzent) {
        this.huelleInProzent = huelleInProzent;
    }

    public int getLebenserhaltungssystemeInProzent() {
        return lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public String getSchiffsname() {
        return schiffsname;
    }

    public void setSchiffsname(String schiffsname) {
        this.schiffsname = schiffsname;
    }
}
