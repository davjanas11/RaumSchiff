public class Main {
    public static void main(String[] args) {
        // Erstellen der Raumschiffe
        Raumschiff klingonen = new Raumschiff("IKS Hagh'ta", 100, 100, 100, 3, 100);
        Raumschiff romulaner = new Raumschiff("IRW Khazara", 100, 100, 50, 2, 100);
        Raumschiff vulkanier = new Raumschiff("N'Var", 100, 100, 100, 3, 100);

        // Ausführen der Aktionen
        klingonen.photonentorpedoSchiessen(romulaner);
        romulaner.phaserkanoneSchiessen(klingonen);
        vulkanier.sendeNachricht("Gewalt ist nicht logisch");
        klingonen.zustandAbrufen();
        klingonen.ladungsverzeichnisAusgeben();
        klingonen.photonentorpedoSchiessen(romulaner);
        klingonen.photonentorpedoSchiessen(romulaner);
        klingonen.zustandAbrufen();
        klingonen.ladungsverzeichnisAusgeben();
        romulaner.zustandAbrufen();
        romulaner.ladungsverzeichnisAusgeben();
        vulkanier.zustandAbrufen();
        vulkanier.ladungsverzeichnisAusgeben();
    }
}



