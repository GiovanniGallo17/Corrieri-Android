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

public class AdapterPacchi extends BaseAdapter {

    List<Pacco> pacchi;

    public AdapterPacchi(List<Pacco> pacchi) {
        this.pacchi = pacchi;
    }

    @Override
    public int getCount() {
        if(this.pacchi == null) {
            return 0;
        } else {
            return this.pacchi.size();
        }
    }

    @Override
    public Object getItem(int i) {
        return this.pacchi.get(i);
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
            riga = layoutInflater.inflate(R.layout.riga_pacco, viewGroup, false);
        }
        Pacco pacco = this.pacchi.get(i);
        TextView campoData = riga.findViewById(R.id.campoNome);
        TextView campoPeso = riga.findViewById(R.id.campoCognome);
        TextView campoUrgente = riga.findViewById(R.id.campoUrgente);
        TextView campoMittente = riga.findViewById(R.id.campoIndirizzo);
        TextView campoDestinatario = riga.findViewById(R.id.campoDestinatario);
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        campoData.setText(df.format(pacco.getDataSpedizione().getTime()));
        campoPeso.setText(pacco.getPeso() + " kg");
        if(pacco.isUrgente()) {
            campoUrgente.setText(" Urgente");
        } else {
            campoUrgente.setText((" Non urgente"));
        }
        campoMittente.setText("Mittente : " + pacco.getMittente().getNome().toString() + " " + pacco.getMittente().getCognome().toString());
        campoDestinatario.setText("Destinatario : " + pacco.getDestinatario().getNome().toString() + " " + pacco.getDestinatario().getCognome().toString());
        return riga;
    }
}
