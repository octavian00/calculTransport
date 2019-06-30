import marfa.Marfa;
import transport.Broker;

import java.util.ArrayList;

import static marfa.prioritateTransport.*;

public class Main {
    public static void main(String[] args) {
        Marfa m=new Marfa(1,URGENT);
        Marfa m1=new Marfa(60,IEFTIN);
        Marfa m2=new Marfa(45,FURGENT);
        ArrayList<Marfa>marfa=new ArrayList<>();
        marfa.add(m);
        marfa.add(m1);
        marfa.add(m2);
        Broker b=new Broker(marfa);
        System.out.println(b.toString());
    }
}
