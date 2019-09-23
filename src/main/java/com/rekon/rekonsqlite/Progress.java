/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

import java.awt.Component;
import javax.swing.ProgressMonitor;

/**
 *
 * @author PAKIVP
 */
public class Progress {
    
    private int min;// = 0;
    private int max;// = 100;

    private ProgressMonitor monitor;// = new ProgressMonitor(parent, "Wait for completion…….", "Iteration", 0, 10);
    private Runnable runnable;// = new Runnable();
    Thread thread;
    
    private Component frame;
    private String message;
    
   
   
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }       

    public ProgressMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(ProgressMonitor monitor) {
        this.monitor = monitor;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public Component getFrame() {
        return frame;
    }

    public void setFrame(Component frame) {
        this.frame = frame;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
        
    
    public void run(){
        
        monitor = new ProgressMonitor(frame,message, "Iteration", min, max);
        runnable = new Runnable() {
            @Override
            public void run() {
                int sleepTime = 500;
               for(int i = 1; i < max; i++)    
               {
                 try  
                 {
                   monitor.setNote("Iteration " + i);
                   monitor.setProgress(i);

                   if (monitor.isCanceled())    
                   {
                     monitor.setProgress(100);
                     break;             
                   }
                   Thread.sleep( sleepTime);
                 }
                 catch (InterruptedException e) { }
               }
               monitor.close();
            }
        }; 
        
        thread = new Thread(runnable);
        thread .start();
    }
                      
    
}
