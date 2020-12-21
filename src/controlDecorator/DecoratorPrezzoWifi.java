package controlDecorator;


//ConcreteDecorator 3
public class DecoratorPrezzoWifi extends DecoratorPrezzo {

    private int prezzoWifi;

    public DecoratorPrezzoWifi(ComponentePrezzo component, int prezzoWifi){
        super(component);
        this.prezzoWifi = prezzoWifi;

    }

    protected int applyWifi(int input){
        int output = input + this.prezzoWifi;
        return output;
    }

    @Override
    public int calcolaPrezzo() {
        int preliminaryPrice = super.calcolaPrezzo();
        preliminaryPrice = this.applyWifi(preliminaryPrice);
        return preliminaryPrice;
    }

}
