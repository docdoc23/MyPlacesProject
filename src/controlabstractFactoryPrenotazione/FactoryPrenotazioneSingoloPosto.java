package controlabstractFactoryPrenotazione;


public class FactoryPrenotazioneSingoloPosto extends FactoryPrenotazione {


    private FactoryPrenotazioneSingoloPosto(){

    }

    //Instance necessaria per il singleton
    private static FactoryPrenotazioneSingoloPosto instance = null;

    //Metodo necessario per il singleton
    public synchronized static final FactoryPrenotazioneSingoloPosto getFactoryPrenotazioneSingoloPosto(){
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
		// TODO Auto-generated method stub
		return new ControlloreDisponibilitaSingoloPosto();
	}
}
