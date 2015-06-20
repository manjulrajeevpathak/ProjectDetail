/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shussain
 */
public class Delay implements Runnable{
    
    public static void main(String []args)
    {
      Delay d=new Delay();
      Thread one=new Thread(d);
      TaskRepeater r=new TaskRepeater(d, 500);
      r.start();
      long t= System.currentTimeMillis();
      //r.shutdown();
   
        System.out.println(t);
      
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Delay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

 class TaskRepeater {  // code sketch only
    final long delay;  // delay between end of one execution and start of next
    final Runnable task;
    public TaskRepeater(Runnable r, long millisecondDelay) {
        task= r;
        delay = millisecondDelay;
    }

    volatile boolean terminated = false;
    final Thread worker = new Thread() {
        public void run() {
            while (!terminated) {
                try {
                    task.run();
                }
                catch(Throwable t) {
                    // log it or whatever, or let it escape and kill the worker
                }
                try {
                    Thread.sleep(delay);
                }
                catch(InterruptedException ex) {
                   // just re-loop and check condition
                }
            }
        }
    };
    public void start() {
        worker.start();  // will throw if already started
    }
    public void shutdown() {
        terminated = true;
        worker.interrupt();
    }
}