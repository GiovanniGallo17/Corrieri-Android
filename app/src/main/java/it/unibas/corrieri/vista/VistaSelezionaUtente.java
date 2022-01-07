package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Utente;

public class VistaSelezionaUtente extends Fragment {

    private ListView listaUtenti;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_seleziona_utente, container, false);
        this.listaUtenti = vista.findViewById(R.id.listaUtenti);
        this.listaUtenti.setOnItemClickListener(Applicazione.getInstance().getControlloSelezionaUtente().getAzioneSelezionaUtente());
        aggiornaDati();
        return vista;
    }

    public void aggiornaDati() {
        List<Utente> utenti = (List<Utente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_UTENTI);
        AdapterUtenti adapterUtenti = new AdapterUtenti(utenti);
        listaUtenti.setAdapter(adapterUtenti);
    }

}
