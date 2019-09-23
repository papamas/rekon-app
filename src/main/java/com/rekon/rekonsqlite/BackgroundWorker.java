/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author PAKIVP
 */
public class BackgroundWorker extends SwingWorker<Integer, String>{

    private JProgressBar pb;
    private JDialog dialog;
    private int Max = 100;
    
    
    public void setMax(int max){
        this.Max = max;
    }
    
    public int getMax(){
        return Max;
    }

    /*
                
    public BackgroundWorker() {
        addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                                if (dialog == null) {
                                        dialog = new JDialog();
                                        dialog.setTitle("Processing");
                                        dialog.setLayout(new GridBagLayout());
                                        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                                        GridBagConstraints gbc = new GridBagConstraints();
                                        gbc.insets = new Insets(2, 2, 2, 2);
                                        gbc.weightx = 1;
                                        gbc.gridy = 0;
                                        dialog.add(new JLabel("Processing..."), gbc);
                                        pb = new JProgressBar();
                                        pb.setStringPainted(true);
                                        gbc.gridy = 1;
                                        dialog.add(pb, gbc);
                                        dialog.pack();
                                        dialog.setLocationRelativeTo(null);
                                        dialog.setModal(true);
                                        JDialog.setDefaultLookAndFeelDecorated(true); 
                                        dialog.setVisible(true);
                                }
                                pb.setValue(getProgress());
                        }
                }
        });
    }

    @Override
    protected void done() {
        if (dialog != null) {
                dialog.dispose();
        }
    }
    
    */
    
    /*
    @Override
    protected Void doInBackground() throws InterruptedException  {
        for (int index = 0; index < this.Max; index++) {
                setProgress(index);
                Thread.sleep(100);
                /**
                 *  Do work
                 *  Do work
                 *  Do work
                 
        }
        return null;
    }

   */

    @Override
    protected Integer doInBackground() throws Exception {
        // Start
        publish("Start");
        setProgress(1);

        // More work was done
        publish("More work was done");
        setProgress(10);

        // Complete
        publish("Complete");
        setProgress(100);
        return 1;
    }

    
    
}
