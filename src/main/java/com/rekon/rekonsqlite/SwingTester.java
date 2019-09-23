/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author PAKIVP
 */
public class SwingTester {
     private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   
   public SwingTester(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingTester  swingControlDemo = new SwingTester();      
      swingControlDemo.showProgressBarDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private ProgressMonitor progressMonitor;
   private Task task;
   private JButton startButton;
   private JTextArea outputTextArea;
   
   private void showProgressBarDemo(){
      headerLabel.setText("Control in action: ProgressMonitor");
      startButton = new JButton("Start");
      outputTextArea = new JTextArea("",5,20);
      JScrollPane scrollPane = new JScrollPane(outputTextArea);    
      
      startButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            progressMonitor = new ProgressMonitor(mainFrame,
            "Running Task",
            "", 0, 100);
            progressMonitor.setProgress(0);
            task = new Task();                
            task.start();
         }
      });
      controlPanel.add(startButton);
      controlPanel.add(scrollPane);
      mainFrame.setVisible(true);  
   }
   private class Task extends Thread {    
      public Task(){
      }
      public void run(){
         for(int i =0; i<= 100; i+=10){
            final int progress = i;
            
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  progressMonitor.setProgress(progress);
                  outputTextArea.setText(outputTextArea.getText() 
                     + String.format("Completed %d%% of task.\n", progress));
               }
            });
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {}
         }
      }
   }   
}
