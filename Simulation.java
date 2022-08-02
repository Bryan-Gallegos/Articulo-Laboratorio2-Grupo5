package Ejemplo;

public class Simulation
{
    public static void main(String args[]){
        SimulatorMonitor sm = new SimulatorMonitor();
        
        Server srv = new Server(sm);
        srv.start();
        
        Client clv[] = new Client[3];
        for(int i=0;i<3;i++){
            clv[i] = new Client(i,sm);
            clv[i].start();
        }
            
    }
}