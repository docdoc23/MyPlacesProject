package controldecorator;


//Decorator
public abstract class DecoratorPrezzo extends ComponentePrezzo {

    private ComponentePrezzo component;

    public DecoratorPrezzo(ComponentePrezzo component){
        this.component = component;
    }

    @Override
    public int calcolaPrezzo() {
        /* i-n-t resultsFromRedirection = this.component.calcolaPrezzo()
        return resultsFromRedirection*/
        return this.component.calcolaPrezzo();
    }
}
