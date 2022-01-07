package it.unibas.corrieri.modello;

import java.util.ArrayList;
import java.util.List;

public class Utente {

    private String codice;
    private String nome;
    private String cognome;
    private String via;
    private int numeroCivico;
    private List<Pacco> pacchiInviati = new ArrayList<>();

    public Utente(String codice, String nome, String cognome, String via, int numeroCivico) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.numeroCivico = numeroCivico;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getVia() {
        return via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public List<Pacco> getPacchiInviati() {
        return pacchiInviati;
    }

    public void aggiungiPaccoInviato(Pacco pacco) {
        this.pacchiInviati.add(pacco);
    }
}
