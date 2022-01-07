package it.unibas.corrieri.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public class AdapterUtenti extends BaseAdapter {

    List<Utente> utenti;

    public AdapterUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    @Override
    public int getCount() {
        if(this.utenti == null) {
            return 0;
        } else {
            return this.utenti.size();
        }
    }

    @Override
    public Object getItem(int i) {
        return this.utenti.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View riga;
        if(view != null) {
            riga = view;
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            riga = layoutInflater.inflate(R.layout.riga_utente, viewGroup, false);
        }
        Utente utente = this.utenti.get(i);
        TextView campoNome = riga.findViewById(R.id.campoNome);
        TextView campoIndirizzo = riga.findViewById(R.id.campoIndirizzo);
        campoNome.setText(utente.getNome().toString() + " " + utente.getCognome().toString());
        campoIndirizzo.setText(utente.getVia().toString() + " " +  utente.getNumeroCivico());
        return riga;
    }
}
