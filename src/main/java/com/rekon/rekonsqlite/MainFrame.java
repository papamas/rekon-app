/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

import com.rekon.database.DatabaseHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ProgressMonitor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 *
 * @author PAKIVP
 */
public class MainFrame extends JFrame implements ActionListener {
    
    private static Logger log = Logger.getLogger(MainFrame.class.getName());
    private static String FILE_NAME = null;
    public static JTextArea area;
    private static JScrollPane scroll;
    public static SimpleDateFormat  Waktu = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private Timestamp timestamp; 
    private ProgressMonitor progressMonitor;
    
    
    public static void  main(String[] args){
             
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                try { 
                    DatabaseHandler db = new DatabaseHandler();
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	});
       
    }
    
    public  MainFrame(){
       initGui();       
    }

    private  void initGui() {
        this.setTitle("Aplikasi Rekon Pelaporan Kinerja");       
        //  Create the menu and JmenuBar
        JMenuBar menuBar = new JMenuBar();       
        //  Build the first menu.
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);        
        
        JMenuItem imp = new JMenuItem("Import data PNS");
        fileMenu.add(imp);  
        
        JMenuItem impk = new JMenuItem("Import data Kinerja");
        fileMenu.add(impk);   
        
        JMenuItem eks = new JMenuItem("Export Pelaporan Kinerja");
        fileMenu.add(eks);
        
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);        
        JMenuItem tentang = new JMenuItem("Tentang Aplikasi");
        aboutMenu.add(tentang);
        
        imp.addActionListener(this);
        impk.addActionListener(this);
        eks.addActionListener(this);
        tentang.addActionListener(this);        
        
        area=new JTextArea();       
        scroll = new JScrollPane (area, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
        
       
        
        this.setJMenuBar(menuBar);
        this.pack();
        this.setSize(600,320);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    DatabaseHandler db = new DatabaseHandler();
                    db.dropTablePNS();
                    db.dropTableKINERJA();
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                e.getWindow().dispose();
                System.out.println("JFrame Closed!");
            }
        });
        
        MainFrame.setDefaultLookAndFeelDecorated(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        String cmd = e.getActionCommand();   
        
        switch(cmd){
            case  "Import data PNS":
            {                
                timestamp = new Timestamp(System.currentTimeMillis());
                area.append(Waktu.format(timestamp) + " "+cmd + "\n");
                timestamp = new Timestamp(System.currentTimeMillis());
                area.append(Waktu.format(timestamp) + " "+cmd + "\n");           
                importCmd();                
            }
            break;
            case  "Import data Kinerja":
            {  
                importCmdKinerja();
            }
            break;
            case  "Export Pelaporan Kinerja":
            {  
                timestamp = new Timestamp(System.currentTimeMillis());
                area.append(Waktu.format(timestamp)  + "  "+cmd + "\n");
                try {
                    exportCmdKinerja();
                } catch (SQLException | IOException ex) {
                    area.append(ex.getMessage() + "\n");
                }
            }
            break; 
            case "Tentang Aplikasi":
               JOptionPane.showMessageDialog(this, "Aplikasi Rekon Pelaporan Kinerja Berdasarkan Data PNS pada SAPK"+
                       "\nPersyaratan : " +
                       "\n1. File data unduh PNS bersumber dari Admin SAPK (.csv)"+
                       "\n2. File Kinerja PNS pada masing-masing OPD/Unit Kerja(.csv)"+
                       "\nDi buat Oleh : Nur Muhamad Holik", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            break;    
        }
    }
    
    void importCmd()  {
        JFileChooser fc = new JFileChooser();
        int returnValue = fc.showOpenDialog(null);
       
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
          
            if(selectedFile.getName().endsWith(".csv")){
                try {
                    
                    progressMonitor = new ProgressMonitor(null,
                       "Sedang proses import harap menunggu....",
                        "", 0, 100);

                    Task task = new Task();
                    task.start();
                    
                    timestamp = new Timestamp(System.currentTimeMillis());
                    area.append(Waktu.format(timestamp)  + " "+"Lokasi File :  " +  selectedFile.getAbsolutePath() + " \n");
                
                    PegawaiDao pegawaiDao = new PegawaiDao(selectedFile);
                    DatabaseHandler db = new DatabaseHandler();
                  
                    db.createTablePNS();
                    db.insertTablePNS(pegawaiDao.getAll());
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                     
                    
            }else{
                timestamp = new Timestamp(System.currentTimeMillis());                 
                area.append(Waktu.format(timestamp)  + " "+"Error File : Data PNS harus File CSV \n");
                JOptionPane.showMessageDialog(this, "Data PNS harus File CSV", "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }       
    }   
    
     void importCmdKinerja() {
        JFileChooser fc = new JFileChooser();
        int returnValue = fc.showOpenDialog(null);
       
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fc.getSelectedFile();            
                
                if(selectedFile.getName().endsWith(".csv")){
                     progressMonitor = new ProgressMonitor(null,
                            "Sedang proses import harap menunggu....",
                            "", 0, 100);

                    Task task = new Task();
                    task.start(); 
                   
                    timestamp = new Timestamp(System.currentTimeMillis());
                    area.append(Waktu.format(timestamp) + " "+"Lokasi File : " +  selectedFile.getAbsolutePath() + "\n");
                    
                    KinerjaDao kinerjaDao = new KinerjaDao(selectedFile);
                    DatabaseHandler db = new DatabaseHandler();
                    db.createTableKINERJA();
                    db.insertTableKINERJA(kinerjaDao.getAll());
                                      
                }else{
                    timestamp = new Timestamp(System.currentTimeMillis());                 
                    area.append(Waktu.format(timestamp)  + " "+"Error File : Data Pelaporan Kinerja  harus File CSV \n");
                    JOptionPane.showMessageDialog(this, "Data Pelaporan Kinerja harus File CSV", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        
        
    }    

    void exportCmdKinerja() throws SQLException, IOException {
        log.log(Level.INFO, "===Export Kinerja Action===");         
        
        DatabaseHandler db = new DatabaseHandler();
        ResultSet rs = db.exportKinerja();
        ExportKinerjaDao exportKinerjaDao = new ExportKinerjaDao(rs);
        String folder = System.getProperty("user.home");
        
        progressMonitor = new ProgressMonitor(null,
                        "Sedang proses Export harap menunggu....",
                        "", 0, 100);
                
        Task task = new Task();
        task.start();
        
        timestamp = new Timestamp(System.currentTimeMillis());            
        String csvFilePath = folder + "\\rekonPelaporanKinerja.csv";
        area.append(Waktu.format(timestamp) + " "+" Lokasi File : " + csvFilePath + "\n");
        
       
                
        try {
            //We have to create the CSVPrinter class object 
            FileWriter writer = new FileWriter(csvFilePath);
            CSVFormat format = CSVFormat.DEFAULT.withHeader( "ATASANPEJABATPENILAI_ORANG_ID",
                            "PEJABATPENILAI_ORANG_ID",
                            "PNSDINILAI_ORANG_ID", 
                            "TAHUN",
                            "NILAI_SKP",
                            "ORIENTASI_PELAYANAN",
                            "INTEGRITAS",
                            "KOMITMEN",
                            "DISIPLIN",
                            "KERJASAMA",
                            "KEPEMIMPINAN",
                            "ATASAN_PENILAI_JABATAN",
                            "PENILAI_JABATAN",
                            "PENILAI_GOLONGAN",
                            "ATASAN_PENILAI_GOLONGAN",
                            "PENILAI_TMT_GOLONGAN",
                            "ATASAN_PENILAI_TMT_GOLONGAN",
                            "PENILAI_UNOR_NAMA",
                            "ATASAN_PENILAI_UNOR_NAMA",
                            "PENILAI_NAMA",
                            "ATASAN_PENILAI_NAMA",
                            "PENILAI_NIP_NRP",
                            "ATASAN_PENILAI_NIP_NRP",
                            "STATUS_PENILAI",
                            "STATUS_ATASAN_PENILAI",
                            "JENIS_JABATAN").withDelimiter(';');
            CSVPrinter csvPrinter = new CSVPrinter(writer,format);     
         
            exportKinerjaDao.getAll().forEach(kinerja -> {           
                try {
                    
                    List list = new ArrayList();
                    list.add(kinerja.getATASANPEJABATPENILAI_ORANG_ID());
                    list.add(kinerja.getPEJABATPENILAI_ORANG_ID());
                    list.add(kinerja.getPNSDINILAI_ORANG_ID());
                    list.add(kinerja.getTAHUN());
                    list.add(kinerja.getNILAI_SKP());
                    list.add(kinerja.getORIENTASI_PELAYANAN()); 
                    list.add(kinerja.getINTEGRITAS());	
                    list.add(kinerja.getKOMITMEN());	
                    list.add(kinerja.getDISIPLIN());
                    list.add(kinerja.getKERJASAMA());
                    list.add(kinerja.getKEPEMIMPINAN());
                    list.add(kinerja.getATASAN_PENILAI_JABATAN());
                    list.add(kinerja.getPENILAI_JABATAN());
                    list.add(kinerja.getPENILAI_GOLONGAN());
                    list.add(kinerja.getATASAN_PENILAI_GOLONGAN());
                    list.add(kinerja.getPENILAI_TMT_GOLONGAN());
                    list.add(kinerja.getATASAN_PENILAI_TMT_GOLONGAN());
                    list.add(kinerja.getPENILAI_UNOR_NAMA());
                    list.add(kinerja.getATASAN_PENILAI_UNOR_NAMA());
                    list.add(kinerja.getPENILAI_NAMA());
                    list.add(kinerja.getATASAN_PENILAI_NAMA());
                    list.add(kinerja.getPENILAI_NIP_NRP());
                    list.add(kinerja.getATASAN_PENILAI_NIP_NRP());
                    list.add(kinerja.getSTATUS_PENILAI());
                    list.add(kinerja.getSTATUS_ATASAN_PENILAI());
                    list.add(kinerja.getJENIS_JABATAN());
                    csvPrinter.printRecord(list);                 
                    
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            });    
            
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
     }
    
    private class Task extends Thread {    
      public Task(){
      }
      public void run(){
         for(int i =0; i<= 100; i+=25){
            final int progress = i;
            
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {               
                   
                    timestamp = new Timestamp(System.currentTimeMillis());
                    area.append(Waktu.format(timestamp) + " "+" Completed "+ progress  + " % of task.\n");  
                    progressMonitor.setProgress(progress);
               }
            });
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {}
            
         }
      }
   }   
}
    
   
    