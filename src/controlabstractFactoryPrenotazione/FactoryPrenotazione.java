package controlabstractFactoryPrenotazione;

public abstract class FactoryPrenotazione {

    public abstract ControlloreDisponibilita creaControlloreDisponibilita();
    public abstract ControlloreRegistraPrenotazione creaControlloreRegistraPrenotati();

}
