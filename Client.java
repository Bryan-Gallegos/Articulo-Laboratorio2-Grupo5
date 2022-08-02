package Ejemplo;

public class Client extends Thread
{
    private int clientID;
    private long clientTime;
    private SimulatorMonitor sm;
    private final boolean addDelay = true;
    public Client(int clientID,SimulatorMonitor sm){
        this.sm         = sm;
        this.clientID   = clientID;
        this.clientTime = System.nanoTime();
    }
    
    public void run(){
        while(true){ 
                this.clientTime += (this.addDelay) ? (this.clientID+1)*2 : 0;
                System.out.println("Temporización (cliente " + clientID + ") : " + this.clientTime);
                this.sm.setDiffTimes(this.clientTime,this.clientID); 
                this.clientTime += this.sm.getSettingTime(this.clientID); 
                System.out.println("Temporización acordada (cliente " + clientID + ") : " + this.clientTime);
        }
    }
                 
}