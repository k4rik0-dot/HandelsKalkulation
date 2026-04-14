package HK_Übungen_Variationen;

import java.util.Scanner;

public class handelskalkulation3 {

    // Methode zur Eingabeprüfung
    public static double EingabePrüfung(String eingabeA, Scanner scanner) {
        while (true) {
            System.out.println(eingabeA);
            String input = scanner.nextLine();

            // Prüfen, ob Eingabe eine gültige Zahl ist
            if (input.matches("\\d+(\\,\\d+)?")) {
                input = input.replace(",", "."); // Komma durch Punkt ersetzen
                return Double.parseDouble(input); // Gültige Eingabe zurückgeben
            } else {
                System.out.println("Ungültige Eingabe, bitte versuchen Sie es noch einmal.");
            }
        }
    }

    // Methode zur Sammlung der Eingaben
    public static double[] sammleEingaben(Scanner scanner) {
        double[] werte = new double[8]; // Array zur Speicherung der Eingaben für Vorwärtskalkulation

        werte[0] = EingabePrüfung("Geben Sie den Listeneinkaufspreis (LEP) ein:", scanner);
        werte[1] = EingabePrüfung("Geben Sie den Lieferantenrabatt in % ein:", scanner);
        werte[2] = EingabePrüfung("Geben Sie den Lieferantenskonto in % ein:", scanner);
        werte[3] = EingabePrüfung("Geben Sie Frachtkosten ein:", scanner);
        werte[4] = EingabePrüfung("Geben Sie die Handlungskosten in % ein:", scanner);
        werte[5] = EingabePrüfung("Geben Sie den Gewinnzuschlag in % ein:", scanner);
        werte[6] = EingabePrüfung("Geben Sie den Kundenskonto in % ein:", scanner);
        werte[7] = EingabePrüfung("Geben Sie den Kundenrabatt in % ein:", scanner);

        return werte; // Gibt das Array mit den Werten zurück
    }
    
    //Methode zur Sammlung der Eingaben für Rückwärtskalkulation
    public static double[] sammleEingabenRückwärts(Scanner scanner) {
    	double[] werte = new double[8];
    	werte[7] = EingabePrüfung("Geben Sie den Listeneinkaufspreis (LVP) ein:", scanner);
    	werte[6] = EingabePrüfung("Geben Sie den Kundenrabatt in % ein:", scanner);
    	werte[5] = EingabePrüfung("Geben Sie den Kundenskonto in % ein:", scanner);
    	werte[4] = EingabePrüfung("Geben Sie den Gewinnzuschlag in % ein:", scanner);
    	werte[3] = EingabePrüfung("Geben Sie die Handlungskosten in % ein:", scanner);
    	werte[2] = EingabePrüfung("Geben Sie die Frachtkosten ein:", scanner);
    	werte[1] = EingabePrüfung("Geben Sie den Lieferantenskonto in % ein:", scanner);
    	werte[0] = EingabePrüfung("Geben Sie den Lieferantenrabatt in % ein:", scanner);
    	return werte;
    }

    // Methode zur Berechnung (Subtraktion)
    public static double[] berechnungSubtraktion(double wert1, double wert2) {
        double ergebnis = wert1 * (1 - wert2 / 100);
        double differenz = wert1 - ergebnis;
        return new double[]{ergebnis, differenz};
    }

    // Methode zur Berechnung (Addition)
    public static double[] berechnungAddition(double wert1, double wert2) {
        double ergebnis = wert1 * (1 + wert2 / 100);
        double differenz = ergebnis - wert1;
        return new double[]{ergebnis, differenz};
    }

    // Methode zur Berechnung (Division)
    public static double[] berechnungDivision(double wert1, double wert2) {
        double ergebnis = wert1 / (1 - wert2 / 100);
        double differenz = ergebnis - wert1;
        return new double[]{ergebnis, differenz};
    }

    // Methode zur Verarbeitung und Ausgabe der Berechnungen
    public static void verarbeiteEingaben(double[] werte) {
        // Werte aus dem Array abrufen
        double lep = werte[0];
        double lieferantenrabatt = werte[1];
        double lieferantenSkonto = werte[2];
        double frachtkosten = werte[3];
        double handlungskosten = werte[4];
        double gewinn = werte[5];
        double kundenSkonto = werte[6];
        double kundenRabatt = werte[7];

        // Berechnungen
        double[] zieleinkaufspreis = berechnungSubtraktion(lep, lieferantenrabatt);
        double[] bareinkaufspreis = berechnungSubtraktion(zieleinkaufspreis[0], lieferantenSkonto);
        double bezugspreis = bareinkaufspreis[0] + frachtkosten;
        double[] selbstkosten = berechnungAddition(bezugspreis, handlungskosten);
        double[] barverkaufspreis = berechnungAddition(selbstkosten[0], gewinn);
        double[] zielverkaufspreis = berechnungDivision(barverkaufspreis[0], kundenSkonto);
        double[] lvp = berechnungDivision(zielverkaufspreis[0], kundenRabatt);

        // Ausgabe
        System.out.println("==============================================");
        System.out.println("=             Handels-Kalkulation            =");
        System.out.println("==============================================");
        System.out.printf("%-25s: %.2f €%n", "Listeneinkaufspreis", lep);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Lieferantenrabatt", zieleinkaufspreis[1]);
        System.out.printf("%-25s: %.2f €%n", "Zieleinkaufspreis", zieleinkaufspreis[0]);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Lieferantenskonto", bareinkaufspreis[1]);
        System.out.printf("%-25s: %.2f €%n", "Bareinkaufspreis", bareinkaufspreis[0]);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Frachtkosten", frachtkosten);
        System.out.printf("%-25s: %.2f €%n", "Bezugspreis", bezugspreis);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Handlungskosten", selbstkosten[1]);
        System.out.printf("%-25s: %.2f €%n", "Selbstkosten", selbstkosten[0]);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Gewinn", barverkaufspreis[1]);
        System.out.printf("%-25s: %.2f €%n", "Barverkaufspreis", barverkaufspreis[0]);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Kundenskonto", zielverkaufspreis[1]);
        System.out.printf("%-25s: %.2f €%n", "Zielverkaufspreis", zielverkaufspreis[0]);
        System.out.println("----------------------------------------------");
        System.out.printf("%-25s: %.2f €%n", "Kundenrabatt", lvp[1]);
        System.out.printf("%-25s: %.2f €%n", "Listenverkaufspreis", lvp[0]);
        System.out.println("==============================================");
    }

    // Hauptmethode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Möchten Sie eine Vorwärts- oder Rpckwärtskalkulation durchführen? (V/R)"); // Aufforderung und Eingame ob Vortwärts- oder Rückwerts
        String wahl = scanner.nextLine().trim().toUpperCase();
        
        // Schleife zur Überprüfung der wahl.
        if (wahl.equals("V")) {
        	double[] werte = sammleEingaben(scanner);
        	verarbeiteEingaben(werte);
        	}else if(wahl.equals("R")) {
        		double[] werte = sammleEingabenRückwärts(scanner);
        	}else {
        		System.out.println("Ungültige Eingabe. Bitte starten Sie das Programm neu und wählen Sie 'V' oder 'R'.");
        	}
        // Eingaben sammeln
        double[] werte = sammleEingaben(scanner);

        // Verarbeitung und Ausgabe
        verarbeiteEingaben(werte);
    }
}
