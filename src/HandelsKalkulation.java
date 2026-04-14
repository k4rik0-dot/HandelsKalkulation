import java.util.Scanner;

public class HandelsKalkulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lep = 0; 
        double lieferantenrabatt = 0;
        double lieferantenSkonto = 0;
        double frachtkosten = 0;
        double handlungskosten = 0;
        double gewinn = 0;
        double kundenSkonto = 0;
        double kundenRabatt = 0;
        double mwst = 1.19;
        
        
        //Eingabe LEP
        while(true) {
        	System.out.println("Geben Sie den Listeneinkaufspreis (LEP) ein:");
        	String inputLep = scanner.nextLine();
        	
        	//Prüfen, ob Eingabe eine gültige zahl ist
        	if (inputLep.matches("\\d+(\\,\\d+)?")) {
        		
        		inputLep = inputLep.replace(",", ".");
        		//Umwandeln in Double
        		lep = Double.parseDouble(inputLep); //Konvertiert in Double
        		
        		break; //Gültige eingabe -> Schleife verlassen.#
        	} else {
        		System.out.println("Ungültige Eingabe!");
        	}
        	
        }
        System.out.println("Der eingegeben Listeinkaufspreis ist: " + lep + "€");
        
        //Eingabe Lieferantenrabatt
        while(true) {
            System.out.println("Bitte geben Sie den Lieferantenrabatt in % ein:");
            String inputLRabatt = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputLRabatt.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
                inputLRabatt = inputLRabatt.replace(",", ".");

                // Umwandeln in Double
                lieferantenrabatt = Double.parseDouble(inputLRabatt);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Der eingegebene Lieferantenrabatt ist: " + lieferantenrabatt + "%");
        
        //Eingabe von Lieferantenskonto.
        while(true) {
            System.out.println("Bitte geben Sie den Lieferantenskonto in % ein:");
            String inputLSkonto = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputLSkonto.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
                inputLSkonto = inputLSkonto.replace(",", ".");

                // Umwandeln in Double
                lieferantenSkonto = Double.parseDouble(inputLSkonto);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Der eingegebene Lieferantenskonto ist: " + lieferantenSkonto + "%");
        
        //Eingabe von Frachtkosten.
        while(true) {
            System.out.println("Bitte geben Sie die Frachkosten ein:");
            String inputFracht = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputFracht.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
                inputFracht = inputFracht.replace(",", ".");

                // Umwandeln in Double
                frachtkosten = Double.parseDouble(inputFracht);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Die eingegebenen Frachtkosten sind: " + frachtkosten + "€");
        
        //Eingabe von Handlungskosten.
        while(true) {
            System.out.println("Bitte geben Sie die Handlungskosten in % ein:");
            String inputHandlung = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputHandlung.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
            	inputHandlung = inputHandlung.replace(",", ".");

                // Umwandeln in Double
                handlungskosten = Double.parseDouble(inputHandlung);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Die eingegeben Handlungskosten sind: " + handlungskosten + "%");
        
        //Eingabe von Gewinnzuschlags
        while(true) {
            System.out.println("Bitte geben Sie den Gewinnzuschlag in % ein:");
            String inputGewinn = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputGewinn.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
            	inputGewinn = inputGewinn.replace(",", ".");

                // Umwandeln in Double
                gewinn = Double.parseDouble(inputGewinn);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Der eingegebene Gewinnzuschlag ist: " + gewinn + "%");
        
        //Eingabe von Kundenskonto
        while(true) {
            System.out.println("Bitte geben Sie den Kundenskonto in % ein:");
            String inputKSkonto = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputKSkonto.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
            	inputKSkonto = inputKSkonto.replace(",", ".");

                // Umwandeln in Double
                kundenSkonto = Double.parseDouble(inputKSkonto);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Der eingegebene Kundenskonto ist: " + kundenSkonto + "%");
        
        //Eingabe von Kundenrabatt
        while(true) {
            System.out.println("Bitte geben Sie den Kundenrabatt in % ein:");
            String inputKRabatt = scanner.nextLine();

            // Überprüfen, ob die Eingabe eine gültige Zahl ist, mit Punkt oder Komma.
            if (inputKRabatt.matches("\\d+(\\,\\d+)?")) {
                // Komma durch Punkt ersetzen
            	inputKRabatt = inputKRabatt.replace(",", ".");

                // Umwandeln in Double
                kundenRabatt = Double.parseDouble(inputKRabatt);
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        System.out.println("Der eingegebene Kundenrabatt ist: " + kundenRabatt + "%");
        
        
        //Berechnung von Bezugspreis nach Abzügen von lieferantenrabatt- und Skonto + Ausgabe
        double bezugspreisRabatt = lep * (1 - lieferantenrabatt / 100);
        double bezugspreisSkonto = bezugspreisRabatt * (1 - lieferantenSkonto / 100);
        System.out.printf("Bezugspreis nach Lieferantenrabatt: %.2f €%n", bezugspreisRabatt);
        System.out.printf("Bezugspreis nach Skonto: %.2f €%n", bezugspreisSkonto);
        
        //Berechnung von Einstandspreis + Ausgabe
        double einstandspreis = bezugspreisSkonto + frachtkosten;
        System.out.printf("Einstandspreis: %.2f €%n", einstandspreis);
        
        //Berechnung von Selbstkosten + Ausgabe 
        double selbstkosten = einstandspreis * (1 + handlungskosten / 100);
        System.out.printf("Selbstkosten: %.2f €%n", selbstkosten);
        
        //Berechnung von Barkverkaufspreis + Ausgabe
        double barverkaufspreis = selbstkosten * (1 + gewinn / 100);
        System.out.printf("Barverkaufspreis: %.2f €%n", barverkaufspreis);        
        
        //Berechnung von Zielverkaufspreis + Ausgabe
        double zielverkaufspreis = barverkaufspreis / (1 - (kundenSkonto / 100)); 
        System.out.printf("Zielverkaufspreis: %.2f €%n", zielverkaufspreis);
        
        //Berechnung Listenverkaufspreis 
        double listenverkaufspreis = zielverkaufspreis / (1 - (kundenRabatt / 100)); 
        System.out.printf("Listenverkaufspreis: %.2f €%n", listenverkaufspreis);
        
        double preisMwst = listenverkaufspreis * mwst;
        System.out.printf("Preis zzgl. MwSt: %.2f €%n", preisMwst);
    }
}