package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Date;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Utente;

public class VistaNuovoPacco extends Fragment {

    private static String TAG = VistaNuovoPacco.class.getSimpleName();
    private CalendarView campoData;
    private TextView campoMittente;
    private TextView campoDestinatario;
    private EditText campoPeso;
    private Button bottoneSelezionaMittente;
    private Button bottoneSelezionaDestinatario;
    private Button bottoneNuovoPacco;
    private CheckBox checkBoxUrgente;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_nuovo_pacco, container, false);
        this.campoData = vista.findViewById(R.id.campoNome);
        this.campoMittente = vista.findViewById(R.id.campoIndirizzo);
        this.campoDestinatario = vista.findViewById(R.id.campoDestinatario);
        this.campoPeso = vista.findViewById(R.id.campoPeso);
        this.bottoneSelezionaMittente = vista.findViewById(R.id.bottoneSelezionaMittente);
        this.bottoneSelezionaDestinatario = vista.findViewById(R.id.bottoneSelezionaDestinatario);
        this.bottoneNuovoPacco = vista.findViewById(R.id.bottoneNuovoPacco);
        this.checkBoxUrgente = vista.findViewById(R.id.checkBoxUrgente);
        this.bottoneSelezionaMittente.setOnClickListener(Applicazione.getInstance().getControlloNuovoPacco().getAzioneSelezionaMittente());
        this.bottoneSelezionaDestinatario.setOnClickListener(Applicazione.getInstance().getControlloNuovoPacco().getAzioneSelezionaDestinatario());
        this.campoData.setOnDateChangeListener((CalendarView.OnDateChangeListener) Applicazione.getInstance().getControlloNuovoPacco().getAzioneSelezioneData());
        this.bottoneNuovoPacco.setOnClickListener(Applicazione.getInstance().getControlloNuovoPacco().getAzioneNuovoPacco());
        return vista;

    }

    @Override
    public void onResume() {
        super.onResume();
        Utente mittenteSelezionato = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.MITTENTE_SELEZIONATO);
        if(mittenteSelezionato == null) {
            this.campoMittente.setText("Nessun mittente selezionato");
        } else {
            this.campoMittente.setText(mittenteSelezionato.getNome().toString() + " " + mittenteSelezionato.getCognome().toString());
        }
        Utente destinatarioSelezionato = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.DESTINATARIO_SELEZIONATO);
        if(destinatarioSelezionato == null) {
            this.campoDestinatario.setText("Nessun destinatario selezionato");
        } else {
            this.campoDestinatario.setText(destinatarioSelezionato.getNome().toString() + " " + destinatarioSelezionato.getCognome().toString());
        }

    }

    public boolean isUrgente() {
        return this.checkBoxUrgente.isChecked();
    }

    public Date getData() {
        return new Date(campoData.getDate());
    }

    public String getPeso() {
        return this.campoPeso.getText().toString();
    }

}
