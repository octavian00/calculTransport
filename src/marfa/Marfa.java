package marfa;

public class Marfa {
    private int cantitate;//consideram cantitatea in paleti
    private prioritateTransport prioritate;
    public Marfa()  {   }
    public Marfa(int cantitate, prioritateTransport prioritate){
        this.cantitate=cantitate;
        this.prioritate=prioritate;
    }
    public int getCantitate(){
        return cantitate;
    }
    public prioritateTransport getPrioritate(){
        return  prioritate;
    }

}
