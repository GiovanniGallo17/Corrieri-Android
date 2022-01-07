package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.activity.ActivityDettaglioCorriere;
import it.unibas.corrieri.modello.Corriere;

public class VistaDettaglioCorriere extends Fragment {

    private TextView campoCorriere;
    private ListView listaPacchi;
    private Button bottoneNuovoPacco;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_dettaglio_corriere, container, false);
        this.campoCorriere = vista.findViewById(R.id.campoCorriere);
        this.listaPacchi = vista.findViewById(R.id.listaPacchi);
        this.bottoneNuovoPacco = vista.findViewById(R.id.bottoneNuovoPacco);
        this.bottoneNuovoPacco.setOnClickListener(Applicazione.getInstance().getControlloDettaglioCorriere().getAzioneNuovoPacco());
        aggiornaDati();
        return vista;
    }

    public void aggiornaDati() {
        Corriere corriere = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
        AdapterPacchi adapterPacchi = new AdapterPacchi(corriere.getPacchi());
        listaPacchi.setAdapter(adapterPacchi);
        campoCorriere.setText(corriere.getNome().toString());
    }

}
