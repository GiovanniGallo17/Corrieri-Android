package it.unibas.corrieri.persistenza;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public class ServerMock {

    private List<Corriere> corrieri = new ArrayList<Corriere>();
    private List<Utente> utenti = new ArrayList<Utente>();

    public ServerMock() {
        Utente u1 = new Utente("MR01", "Mario", "Rossi", "Via Verdi", 1);
        Utente u2 = new Utente("SG02", "Sofia", "Gatti", "Via Milano", 2);
        Utente u3 = new Utente("FG99", "Franco", "Galli", "Via Manzoni", 5);
        Utente u4 = new Utente("KM01", "Kevin", "Moss", "Via Leopardi", 25);
        utenti.add(u1);
        utenti.add(u2);
        utenti.add(u3);
        utenti.add(u4);
        Corriere c1 = new Corriere(3, "GLS", "Centro");
        Corriere c2 = new Corriere(5, "GLS", "Periferia");
        Corriere c3 = new Corriere(1, "Bartolini", "Centro");
        Corriere c4 = new Corriere(2, "Bartolini", "Centro");
        Corriere c5 = new Corriere(3, "Bartolini", "Centro");
        corrieri.add(c1);
        corrieri.add(c2);
        corrieri.add(c3);
        corrieri.add(c4);
        corrieri.add(c5);
        Pacco p1 = new Pacco(new GregorianCalendar(2021, Calendar.DECEMBER, 2), 2.0, false, u1, u2);
        Pacco p2 = new Pacco(new GregorianCalendar(2021, Calendar.DECEMBER, 5), 1.7, true, u1, u3);
        Pacco p3= new Pacco(new GregorianCalendar(2021, Calendar.DECEMBER, 12), 4.0, false, u3, u4);
        Pacco p4= new Pacco(new GregorianCalendar(2021, Calendar.DECEMBER, 15), 0.7, true, u3, u4);
        u1.aggiungiPaccoInviato(p1);
        u1.aggiungiPaccoInviato(p2);
        u3.aggiungiPaccoInviato(p3);
        u4.aggiungiPaccoInviato(p4);
        c1.aggiungiPacco(p1);
        c3.aggiungiPacco(p2);
        c4.aggiungiPacco(p3);
        c5.aggiungiPacco(p4);
    }

    public List<Corriere> cercaCorrierePerZona(String zona) {
        List<Corriere> corrieriPerZona = new ArrayList<>();
        for (Corriere corriere : this.corrieri) {
            if (corriere.getZona().equalsIgnoreCase(zona)) {
                corrieriPerZona.add(corriere);
            }
        }
        return corrieriPerZona;
    }

    public List<Utente> cercaUtenti() {
        return this.utenti;
    }

    public void salvaPacco() {
        //nulla
    }
}
