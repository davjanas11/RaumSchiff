import java.util.ArrayList;

public class Raumschiff {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    private int photonentorpedoAnzahl;
    private int energieversorgungInProzent;
    private int schildeInProzent;
    private int huelleInProzent;
    private int lebenserhaltungssystemeInProzent;
    private int androidenAnzahl;
    private String schiffsname;
    private ArrayList<String> broadcastKommunikator;
    private ArrayList<Ladung> ladungsverzeichnis;

    public Raumschiff() {
        broadcastKommunikator = new ArrayList<>();
        ladungsverzeichnis = new ArrayList<>();
    }

    public Raumschiff(int photonentorpedoAnzahl, int energieversorgungInProzent, int schildeInProzent,
                      int huelleInProzent, int lebenserhaltungssystemeInProzent, int androidenAnzahl, String schiffsname) {
        this();
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schildeInProzent = schildeInProzent;
        this.huelleInProzent = huelleInProzent;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
        this.androidenAnzahl = androidenAnzahl;
        this.schiffsname = schiffsname;
    }

    public int getPhotonentorpedoAnzahl() {
        return this.photonentorpedoAnzahl;
    }

    public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahl) {
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
    }

    public int getEnergieversorgungInProzent() {
        return this.energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent;
    }

    public int getSchildeInProzent() {
        return this.schildeInProzent;
    }

    public void setSchildeInProzent(int schildeInProzent) {
        this.schildeInProzent = schildeInProzent;
    }

    public int getHuelleInProzent() {
        return this.huelleInProzent;
    }

    public void setHuelleInProzent(int huelleInProzent) {
        this.huelleInProzent = huelleInProzent;
    }

    public int getLebenserhaltungssystemeInProzent() {
        return this.lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public int getAndroidenAnzahl() {
        return this.androidenAnzahl;
    }

    public void setAndroidenAnzahl(int androidenAnzahl) {
        this.androidenAnzahl = androidenAnzahl;
    }

    public String getSchiffsname() {
        return this.schiffsname;
    }

    public void setSchiffsname(String schiffsname) {
        this.schiffsname = schiffsname;
    }

    public void addLadung(Ladung neueLadung) {
        this.ladungsverzeichnis.add(neueLadung);
    }

    public void photonentorpedoSchiessen(Raumschiff r) {
        if (this.photonentorpedoAnzahl <= 0) {
            nachrichtAnAlle("-=*Click*=-");
        } else {
            this.photonentorpedoAnzahl--;
            nachrichtAnAlle("Photonentorpedo abgeschossen");
            treffer(r);
        }
    }

    public void phaserkanoneSchiessen(Raumschiff r) {
        if (this.energieversorgungInProzent < 50) {
            nachrichtAnAlle("-=*Click*=-");
        } else {
            this.energieversorgungInProzent -= 50;
            nachrichtAnAlle("Phaserkanone abgeschossen");
            treffer(r);
        }
    }

    private void treffer(Raumschiff r) {
        r.setSchildeInProzent(r.getSchildeInProzent() - 50);
        if (r.getSchildeInProzent() <= 0) {
            r.setEnergieversorgungInProzent(r.getEnergieversorgungInProzent() - 50);
            r.setHuelleInProzent(r.getHuelleInProzent() - 50);
            if (r.getHuelleInProzent() < 0) {
                r.setHuelleInProzent(0);
            }
            if (r.getHuelleInProzent() == 0) {
                r.setLebenserhaltungssystemeInProzent(0);
                nachrichtAnAlle("Die Lebenserhaltungssysteme von " + r.getSchiffsname() + " wurden vernichtet!");
            }
        }
    }


    public void nachrichtAnAlle(String message) {
        this.broadcastKommunikator.add(message);
    }

    public ArrayList<String> eintraegeLogbuchZurueckgeben() {
        return this.broadcastKommunikator;
    }

    public void photonentorpedosLaden(int anzahlTorpedos) {
        this.photonentorpedoAnzahl += anzahlTorpedos;
    }

    public void photonentorpedosAusLadungLaden(int anzahlTorpedos) {
        int vorhandeneTorpedos = 0;
        for (Ladung ladung : this.ladungsverzeichnis) {
            if (ladung.getBezeichnung().equals("Photonentorpedos")) {
                vorhandeneTorpedos = ladung.getMenge();
                break;
            }
        }
        if (vorhandeneTorpedos >= anzahlTorpedos) {
            this.photonentorpedoAnzahl += anzahlTorpedos;
        } else {
            this.photonentorpedoAnzahl += vorhandeneTorpedos;
            nachrichtAnAlle("Nur " + vorhandeneTorpedos + " Photonentorpedos geladen, da nicht genug in der Ladung vorhanden.");
        }
    }

    public void reparaturDurchfuehren(boolean schutzschilde, boolean energieversorgung, boolean schiffshuelle,
                                      int anzahlDroiden) {
        if (this.getAndroidenAnzahl() < anzahlDroiden) {
            System.out.println("Nicht genug Androiden für die Reparatur!");
            return;
        }

        if (schutzschilde) {
            this.setSchildeInProzent(100);
            System.out.println("Schutzschilde wurden repariert.");
        }

        if (energieversorgung) {
            this.setEnergieversorgungInProzent(100);
            System.out.println("Energieversorgung wurde repariert.");
        }

        if (schiffshuelle) {
            this.setHuelleInProzent(100);
            System.out.println("Schiffshülle wurde repariert.");
        }

        this.setAndroidenAnzahl(this.getAndroidenAnzahl() - anzahlDroiden);
    }

    public void zustandRaumschiff() {
        System.out.println("Photonentorpedo Anzahl: " + this.photonentorpedoAnzahl);
        System.out.println("Energieversorgung in Prozent: " + this.energieversorgungInProzent);
        System.out.println("Schilde in Prozent: " + this.schildeInProzent);
        System.out.println("Hülle in Prozent: " + this.huelleInProzent);
        System.out.println("Lebenserhaltungssysteme in Prozent: " + this.lebenserhaltungssystemeInProzent);
        System.out.println("Androiden Anzahl: " + this.androidenAnzahl);
        System.out.println("Schiffsname: " + this.schiffsname);
    }

    public void ladungsverzeichnisAusgeben() {
        for (Ladung ladung : this.ladungsverzeichnis) {
            System.out.println("Bezeichnung: " + ladung.getBezeichnung() + ", Menge: " + ladung.getMenge());
        }
    }

    public void ladungsverzeichnisAufraeumen() {
        this.ladungsverzeichnis.removeIf(ladung -> ladung.getMenge() == 0);
    }

    public void logbuchAusgeben() {
        System.out.println("Logbuch für das Schiff: " + this.schiffsname);
        for (String eintrag : this.broadcastKommunikator) {
            System.out.println(eintrag);
        }
    }
}