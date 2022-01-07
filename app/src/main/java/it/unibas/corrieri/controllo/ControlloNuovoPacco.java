package it.unibas.corrieri.controllo;

import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityNuovoPacco;
import it.unibas.corrieri.modello.OperatorePacchi;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;
import it.unibas.corrieri.vista.VistaNuovoPacco;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneSelezionaMittente = new AzioneSelezionaUtente(Costanti.AZIONE_SELEZIONA_MITTENTE);
    private View.OnClickListener azioneSelezionaDestinatario = new AzioneSelezionaUtente(Costanti.AZIONE_SELEZIONA_DESTINATARIO);
    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();
    private CalendarView.OnDateChangeListener azioneSelezioneData = new AzioneSelezioneData();

    public CalendarView.OnDateChangeListener getAzioneSelezioneData() {
        return azioneSelezioneData;
    }

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    public View.OnClickListener getAzioneSelezionaMittente() {
        return azioneSelezionaMittente;
    }

    public View.OnClickListener getAzioneSelezionaDestinatario() {
        return azioneSelezionaDestinatario;
    }

    private class AzioneSelezioneData implements CalendarView.OnDateChangeListener {


        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
            Calendar calendar = new GregorianCalendar(i, i1-1, i2);
            Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA, calendar);
        }
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        private OperatorePacchi operatorePacchi = new OperatorePacchi();

        @Override
        public void onClick(View view) {
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            VistaNuovoPacco vistaNuovoPacco = activityNuovoPacco.getVistaNuovoPacco();
            Utente mittente = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.MITTENTE_SELEZIONATO);
            Utente destinatario = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.DESTINATARIO_SELEZIONATO);
            Boolean urgente = vistaNuovoPacco.isUrgente();
            String stringaPeso = vistaNuovoPacco.getPeso();
            Calendar dataSelezionata = (Calendar) Applicazione.getInstance().getModello().getBean(Costanti.DATA_SELEZIONATA);
            String errori = convalida(mittente, destinatario, stringaPeso, dataSelezionata, urgente);
            if(!errori.isEmpty()) {
                activityNuovoPacco.mostraFinestraErrori(errori);
                return;
            }
            double peso = Double.parseDouble(stringaPeso);
            Pacco nuovoPacco = new Pacco(dataSelezionata, peso, urgente, mittente, destinatario);
        }

        private String convalida(Utente mittente, Utente destinatario, String stringaPeso, Calendar dataSelezionata, Boolean urgente) {
            StringBuilder errori = new StringBuilder();
            if(mittente == null) {
                errori.append("Mittente obbligatorio\n");
            }
            if(destinatario == null) {
                errori.append("Destinatario obbligatorio\n");
            }
            if(mittente != null && destinatario != null && mittente.getCodice().equalsIgnoreCase(destinatario.getCodice())) {
                errori.append("Mittente e destinatario devono essere persone diverse\n");
            }
            if(stringaPeso.isEmpty()) {
                errori.append("Peso obbligatorio\n");
            }
            if(dataSelezionata == null) {
                errori.append("Data obbligatoria\n");
            } else if(urgente && operatorePacchi.verificaDataPacco(dataSelezionata.getTime())){
                errori.append("Data non valida ");
            }
            return errori.toString();
        }
    }

    private class AzioneSelezionaUtente implements View.OnClickListener {

        private String tipoSelezione;

        public AzioneSelezionaUtente(String tipoSelezione) {
            this.tipoSelezione = tipoSelezione;
        }

        @Override
        public void onClick(View view) {
            List<Utente> listaUtenti = Applicazione.getInstance().getServerMock().cercaUtenti();
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_UTENTI, listaUtenti);
            Applicazione.getInstance().getModello().putBean(Costanti.TIPO_SELEZIONE, tipoSelezione);
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            activityNuovoPacco.mostraActivitySelezionaUtente();
        }
    }
}
