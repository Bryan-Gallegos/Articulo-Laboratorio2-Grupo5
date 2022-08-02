package Ejemplo;

public class Server extends Thread
{
    private SimulatorMonitor sm;
    private final int sleepMSeconds;
    private long serverTime;
    
    public Server(SimulatorMonitor sm){
        this.sm = sm;
        this.sleepMSeconds = 10000; 
        this.serverTime = System.nanoTime();
    }
    
    public void run(){
        while(true){
            try{
                Thread.sleep(this.sleepMSeconds); 
                System.out.println("Temporización (servidor) : " + this.serverTime);
                
                this.sm.setServerTime(this.serverTime);
                this.sm.calcAvgAndSet();
                this.serverTime += this.sm.getAverage();
                
                System.out.println("Temporización acordada (servidor) : " + this.serverTime);           
                this.sm.restartProcess();
            }catch(InterruptedException e){
            	e.printStackTrace();
            } 
        }
    } 
}
