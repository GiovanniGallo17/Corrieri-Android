package it.unibas.corrieri.modello;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OperatorePacchi {

    private static String TAG = OperatorePacchi.class.getSimpleName();

    public boolean verificaDataPacco(Date data) {
        Calendar dataLimite = new GregorianCalendar();
        dataLimite.add(Calendar.DAY_OF_MONTH, 1);
        if(data.after(dataLimite.getTime())) {
            return false;
        }
        return true;
    }
}
