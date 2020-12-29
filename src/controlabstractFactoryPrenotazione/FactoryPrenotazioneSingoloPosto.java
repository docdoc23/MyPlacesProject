package controlabstractfactoryprenotazione;


public class FactoryPrenotazioneSingoloPosto extends FactoryPrenotazione {


    private FactoryPrenotazioneSingoloPosto(){//default

    }

    //Instance necessaria per il singleton
    private static FactoryPrenotazioneSingoloPosto instance = null;

    //Metodo necessario per il singleton
    public static synchronized final FactoryPrenotazioneSingoloPosto getFactoryPrenotazioneSingoloPosto(){
        if(FactoryPrenotazioneSingoloPosto.instance==null)
            FactoryPrenotazioneSingoloPosto.instance = new FactoryPrenotazioneSingoloPosto();
        return instance;
    }

    @Override
    public ControlloreRegistraPrenotazione creaControlloreRegistraPrenotati() {
        return new ControlloreRegistraPrenotazioniSingoloPosto();
    }

	@Override
	public ControlloreDisponibilita creaControlloreDisponibilita() {
		
		return new ControlloreDisponibilitaSingoloPosto();
	}
}
