package boundary;


import control.ControlloreRecensione;
import entity.Recensione;
import exception.DeserializzazioneException;
import exception.SerializzazioneException;

import java.util.ArrayList;
import java.util.List;

public class BoundaryGestioneRecesioni {

    private ControlloreRecensione cr = new ControlloreRecensione();


    public int inserisciRecensione(String nomeLocazione,String tipoLocazione, String nomeRecensore, String Stelle, String testoRecensione) throws SerializzazioneException, DeserializzazioneException {

        int numeroStelle = Integer.parseInt(Stelle);

        return cr.inserisci(nomeLocazione,tipoLocazione,nomeRecensore,numeroStelle,testoRecensione);
    }

    public List<Recensione> visualizzaRecensioni(String nomeLocazione) throws DeserializzazioneException {

        return cr.ritornaRecensioni(nomeLocazione);
    }

    public int media(String nomeLocazione) throws DeserializzazioneException {

        return cr.calcolaMedia(nomeLocazione);
    }



}
