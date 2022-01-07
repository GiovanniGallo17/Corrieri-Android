package it.unibas.corrieri.modello;

import java.util.ArrayList;
import java.util.List;

public class Corriere implements Comparable<Corriere> {

    private int numero;
    private String nome;
    private String zona;
    private List<Pacco> pacchi = new ArrayList<>();

    public Corriere(int numero, String nome, String zona) {
        this.numero = numero;
        this.nome = nome;
        this.zona = zona;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getZona() {
        return zona;
    }

    public List<Pacco> getPacchi() {
        return pacchi;
    }

    public void aggiungiPacco(Pacco pacco) {
        this.pacchi.add(pacco);
    }

    @Override
    public int compareTo(Corriere corriere) {
        return this.nome.compareTo(corriere.getNome());
    }
}
