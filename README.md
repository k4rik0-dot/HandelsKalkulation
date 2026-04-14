# HandelsKalkulation

Java Konsolenanwendung zur kaufmännischen Kalkulation mit Lieferantenrabatt, Skonto, Handlungskosten, Gewinnzuschlag und MwSt.

## Beschreibung

Dieses Programm berechnet schrittweise den Verkaufspreis eines Produktes auf Basis verschiedener kaufmännischer Kennzahlen. Der Benutzer gibt die relevanten Werte interaktiv über die Konsole ein.

## Berechnungsschritte

1. **Listeneinkaufspreis (LEP)** – Ausgangspreis vom Lieferanten
2. **Lieferantenrabatt** – prozentualer Abzug vom LEP
3. **Lieferantenskonto** – weiterer prozentualer Abzug
4. **Frachtkosten** – Aufschlag für Lieferung → ergibt den **Einstandspreis**
5. **Handlungskosten** – prozentuale Betriebskosten → ergibt die **Selbstkosten**
6. **Gewinnzuschlag** – prozentualer Aufschlag → ergibt den **Barverkaufspreis**
7. **Kundenskonto** → ergibt den **Zielverkaufspreis**
8. **Kundenrabatt** → ergibt den **Listenverkaufspreis**
9. **MwSt (19%)** → ergibt den **Bruttoverkaufspreis**

## Features

- Eingabevalidierung mit Regex (Komma und Punkt als Dezimaltrennzeichen)
- Schrittweise Ausgabe aller Zwischenergebnisse
- Fehlerbehandlung bei ungültigen Eingaben

## Verwendung

```bash
javac HandelsKalkulation.java
java HandelsKalkulation
```

## Technologien

- Java
- Eclipse IDE
