package it.unibas.corrieri.controllo;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityPrincipale;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneCerca = new AzioneCerca();
    private AdapterView.OnItemClickListener azioneSeleziona = new AzioneSeleziona();

    public AdapterView.OnItemClickListener getAzioneSeleziona() {
        return azioneSeleziona;
    }

    public View.OnClickListener getAzioneCerca() {
        return azioneCerca;
    }

    private class AzioneCerca implements View.OnClickListener {

        private String TAG = AzioneCerca.class.getSimpleName();

        @Override
        public void onClick(View view) {
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            String zona = vistaPrincipale.getCampoZona();
            List<Corriere> corrieriPerZona = Applicazione.getInstance().getServerMock().cercaCorrierePerZona(zona);
            Applicazione.getInstance().getModello().putBean(Costanti.CORRIERI, corrieriPerZona);
            Log.d(TAG, "Caricati : " + corrieriPerZona.size() + " corrieri");
            vistaPrincipale.aggiornaDati();
        }
    }

    private class AzioneSeleziona implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            List<Corriere> corrieri = (List<Corriere>) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERI);
            Corriere corriereSelezionato = corrieri.get(i);
            Applicazione.getInstance().getModello().putBean(Costanti.CORRIERE_SELEZIONATO, corriereSelezionato);
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            activityPrincipale.mostraActivityDettaglioCorriere();
        }
    }
}
