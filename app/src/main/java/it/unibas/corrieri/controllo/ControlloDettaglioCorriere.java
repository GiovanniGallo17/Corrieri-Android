package it.unibas.corrieri.controllo;

import android.util.Log;
import android.view.View;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.activity.ActivityDettaglioCorriere;

public class ControlloDettaglioCorriere {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();

    private static String TAG = ControlloDettaglioCorriere.class.getSimpleName();

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            ActivityDettaglioCorriere activityDettaglioCorriere = (ActivityDettaglioCorriere) Applicazione.getInstance().getCurrentActivity();
            activityDettaglioCorriere.mostraActivityNuovoPacco();
            Log.d(TAG, "Azioneeeeeeeeeeeeeeeeeeee");
        }
    }
}
