package it.unibas.corrieri.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class AdapterCorrieri extends BaseAdapter {

    List<Corriere> corrieri;

    public AdapterCorrieri(List<Corriere> corrieri) {
        this.corrieri = corrieri;
    }

    @Override
    public int getCount() {
        if(this.corrieri == null) {
            return 0;
        } else {
            return this.corrieri.size();
        }
    }

    @Override
    public Object getItem(int i) {
        return this.corrieri.get(i);
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
            riga = layoutInflater.inflate(R.layout.riga_corriere, viewGroup, false);
        }
        TextView campoNumero = riga.findViewById(R.id.campoNumero);
        TextView campoNome = riga.findViewById(R.id.campoNome);
        TextView campoZona = riga.findViewById(R.id.campoZona);
        Corriere corriere = this.corrieri.get(i);
        campoNumero.setText(corriere.getNumero() + "");
        campoNome.setText(corriere.getNome());
        campoZona.setText(corriere.getZona());
        return riga;
    }
}
