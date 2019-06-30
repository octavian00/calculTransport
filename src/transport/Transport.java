package transport;

public enum Transport {//mi s-a parut mai eficent sa folosesc un enum decat sa fac clase pentru fiecare
    ELICOPTER(6),
    AVION(5),
    MASINA(4),
    TIR(3),
    TREN(2),
    VAPOR(1)
    ;
    private int pretPalet;
    Transport(int pretPalet) {
        this.pretPalet=pretPalet;
    }
    public int getPretPalet(){
        return  pretPalet;
    }
}
