package it.unibas.corrieri.modello;

import java.util.Calendar;

public class Pacco {

    private Calendar dataSpedizione;
    private double peso;
    private boolean urgente;
    private Utente mittente;
    private Utente destinatario;

    public Pacco(Calendar dataSpedizione, double peso, boolean urgente, Utente mittente, Utente destinatario) {
        this.dataSpedizione = dataSpedizione;
        this.peso = peso;
        this.urgente = urgente;
        this.mittente = mittente;
        this.destinatario = destinatario;
    }

    public Calendar getDataSpedizione() {
        return dataSpedizione;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public Utente getMittente() {
        return mittente;
    }

    public Utente getDestinatario() {
        return destinatario;
    }
}
