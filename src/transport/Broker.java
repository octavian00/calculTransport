package transport;

import marfa.Marfa;
import transport.Transport;

import java.util.ArrayList;
public class Broker {
    private ArrayList<Marfa> marfa=new ArrayList<Marfa>();
    public Broker(ArrayList<Marfa> marfa){
        this.marfa=marfa;
    }
    public ArrayList<Transport> getMijlocTransport(){//m-am gandit ca un user poate da mai multe comenzi de aceea am ales sa fac metoda de tip arrayList
        ArrayList<Transport> transport=new ArrayList<>();
        for(Marfa m:marfa){
            if(m.getCantitate()==1){
                switch (m.getPrioritate()){
                    case FURGENT://am considerat in cazul in care avem doar un palet si are prioritate foarte URGENT sa fie transportat cu elicopterul
                        transport.add(Transport.ELICOPTER);
                        break;
                    case URGENT://in cazul in care e urgent il transportam cu avionul
                        transport.add(Transport.AVION);
                        break;
                    default://pentru restul cazurilor il transportam cu masina
                        transport.add(Transport.MASINA);
                }
            }else{
                if(m.getCantitate()>=2&&m.getCantitate()<=50){
                    switch (m.getPrioritate()){
                        case FURGENT:
                            transport.add(Transport.TIR);
                            break;
                        case URGENT:
                            transport.add(Transport.TIR);
                            break;
                        default:
                            transport.add(Transport.TREN);
                    }
                }else{
                    transport.add(Transport.VAPOR);
                }
            }
        }
        return  transport;
    }
    public ArrayList<Integer> getPret(){
        ArrayList<Integer> costuri=new ArrayList<>();
        ArrayList<Transport> transport=this.getMijlocTransport();
        for(int i=0;i<transport.size();i++){
            int sum=0;
            sum=transport.get(i).getPretPalet()*marfa.get(i).getCantitate();
            costuri.add(sum);
        }
        return  costuri;
    }
    public String toString(){
        String result="";
        ArrayList<Transport> transport=this.getMijlocTransport();
        ArrayList<Integer> preturi=this.getPret();
        for(int i=0;i<marfa.size();i++){
            result=result+"mijloc de transport: "+transport.get(i).toString()+" cost= "+preturi.get(i).toString()+"\n";
        }
        return  result;
    }
}
