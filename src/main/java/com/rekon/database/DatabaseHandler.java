/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.database;

import com.rekon.rekonsqlite.Kinerja;
import static com.rekon.rekonsqlite.MainFrame.Waktu;
import static com.rekon.rekonsqlite.MainFrame.area;
import com.rekon.rekonsqlite.Pegawai;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PAKIVP
 */
public class DatabaseHandler {
    
    private Timestamp timestamp; 
    private  Connection c = null;
    private  Statement stmt = null;
    private final  String Insert_pns_sql = "INSERT INTO PNS (PNS_ID,NIP_BARU, NAMA) values (?, ?, ?)";
    private final  String Insert_kinerja_sql = "INSERT INTO KINERJA ("
            + "NIPATASANPEJABATPENILAI_ORANG_ID,"
            + "NIPPEJABATPENILAI_ORANG_ID, "
            + "NIPPNSDINILAI_ORANG_ID,"
            + "TAHUN,"
            + "NILAI_SKP,"
            + "ORIENTASI_PELAYANAN,"
            + "INTEGRITAS,"
            + "KOMITMEN,"
            + "DISIPLIN,"
            + "KERJASAMA,"
            + "KEPEMIMPINAN,"
            + "ATASAN_PENILAI_JABATAN,"
            + "PENILAI_JABATAN,"
            + "PENILAI_GOLONGAN,"
            + "ATASAN_PENILAI_GOLONGAN,"
            + "PENILAI_TMT_GOLONGAN,"
            + "ATASAN_PENILAI_TMT_GOLONGAN,"
            + "PENILAI_UNOR_NAMA,"
            + "ATASAN_PENILAI_UNOR_NAMA,"
            + "PENILAI_NAMA,"
            + "ATASAN_PENILAI_NAMA,"
            + "PENILAI_NIP_NRP,"
            + "ATASAN_PENILAI_NIP_NRP,"
            + "STATUS_PENILAI,"
            + "STATUS_ATASAN_PENILAI,"
            + "JENIS_JABATAN) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final  String Select_pns_sql = "SELECT PNS_ID,NIP_BARU, NAMA FROM PNS";
    private final  String Select_kinerja_sql = "SELECT * FROM KINERJA";
    private final  String Drop_pns_sql   = "DROP TABLE IF EXISTS PNS;";
    private final  String Drop_kinerja_sql   = "DROP TABLE IF EXISTS KINERJA;";
    private final  String Check_pns_sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='PNS'";
    private final  String Check_kinerja_sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='KINERJA'";
    private File Dir = null;
    private static Logger log = Logger.getLogger(DatabaseHandler.class.getName());
    private Vector<Pegawai> pegawais = new Vector();
    
    public DatabaseHandler() throws SQLException{
        
        log.info("Contructor DatabaseHandler load");
        try {
            this.Dir = createDir();
            connect();
            //dropTablePNS();
            //dropTableKINERJA();
            //createTablePNS();
            //createTableKINERJA();
            //selectAllPNS();
            //selectAllKINERJA();
           
        } catch (IOException ex) {
            log.info("file create directory " + ex.getMessage());
        }
    }
        
    public static File createDir() throws IOException {
             
        String temp_folder = System.getProperty("java.io.tmpdir") + "rekonSQLite";
        File file = new File(temp_folder);

        if (!file.exists()) {
            if (file.mkdir()) {
                log.info("Directory is created!");
            } else {
                log.info("Failed to create directory!");
            }
        }
        
            return file;       
    }
    
    public Connection connect(){
       
        try {
            Class.forName("org.sqlite.JDBC");            
            log.info("Default Directory is : " + Dir.getCanonicalPath());            
            c = DriverManager.getConnection("jdbc:sqlite:"+Dir.getCanonicalPath() + "\\rekon.db");           
            log.info("Sukses connect to database SQLite");
        } 
        catch ( Exception e ) {
            log.info( " Failed to connect : "  + e.getMessage() );          
        }
        return c;
    }
    
    public void createTablePNS(){
        try {              
        stmt = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS PNS " +
                        "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
                        " PNS_ID            VARCHAR(50)     NOT NULL, " + 
                        " NIP_BARU          VARCHAR(18)     NOT NULL, " + 
                        " NAMA              VARCHAR(150)    NOT NULL)"; 
            stmt.executeUpdate(sql);
              log.info("Table pns created successfully");
            stmt.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );           
         }
      
    }
    
     public void createTableKINERJA(){
        try {              
        stmt = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS KINERJA " +
                        "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
                        " NIPATASANPEJABATPENILAI_ORANG_ID    VARCHAR(50)    NOT NULL, " + 
                        " NIPPEJABATPENILAI_ORANG_ID          VARCHAR(50)    NOT NULL, " + 
                        " NIPPNSDINILAI_ORANG_ID              VARCHAR(50)    NOT NULL, " +
                        " TAHUN VARCHAR(4) NOT NULL," +
                        " NILAI_SKP VARCHAR(10) NOT NULL," +
                        " ORIENTASI_PELAYANAN VARCHAR(10) NOT NULL," +
                        " INTEGRITAS VARCHAR(10) NOT NULL,"+
                        " KOMITMEN VARCHAR(10) NOT NULL," +
                        " DISIPLIN VARCHAR(10) NOT NULL," +
                        " KERJASAMA VARCHAR(10) NOT NULL," +
                        " KEPEMIMPINAN VARCHAR(10) NOT NULL," +
                        " ATASAN_PENILAI_JABATAN TEXT NOT NULL," +
                        " PENILAI_JABATAN TEXT NOT NULL,"+
                        " PENILAI_GOLONGAN VARCHAR(10) NOT NULL,"+
                        " ATASAN_PENILAI_GOLONGAN VARCHAR(10) NOT NULL,"+
                        " PENILAI_TMT_GOLONGAN DATE, " +
                        " ATASAN_PENILAI_TMT_GOLONGAN DATE, "+
                        " PENILAI_UNOR_NAMA TEXT NOT NULL,"+
                        " ATASAN_PENILAI_UNOR_NAMA TEXT NOT NULL,"+
                        " PENILAI_NAMA VARCHAR(150)NOT NULL,"+
                        " ATASAN_PENILAI_NAMA VARCHAR(150) NOT NULL,"+
                        " PENILAI_NIP_NRP VARCHAR(20),"+
                        " ATASAN_PENILAI_NIP_NRP VARCHAR(20),"+
                        " STATUS_PENILAI VARCHAR(5)NOT NULL," +
                        " STATUS_ATASAN_PENILAI VARCHAR(5)NOT NULL,"+
                        " JENIS_JABATAN CHAR(1)NOT NULL)"; 
            stmt.executeUpdate(sql);             
            log.info("Table kinerja created successfully");            
            stmt.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );           
         }
      
    }
    
    public void insertTablePNS(Vector<Pegawai> pegawais) throws SQLException{
       PreparedStatement pstmt = c.prepareStatement(Insert_pns_sql);
       c.setAutoCommit(false);       
        for (int i =0; i < pegawais.size();i++){      
            pstmt.setString(1,pegawais.get(i).getpnsId());
            pstmt.setString(2,pegawais.get(i).getnipBaru());
            pstmt.setString(3,pegawais.get(i).getNama());
            pstmt.addBatch();    
        }
        int[] result = pstmt.executeBatch();
        timestamp = new Timestamp(System.currentTimeMillis());
        area.append(Waktu.format(timestamp) + " "+"Data PNS yang di import sebanyak  : " +  result.length+ "\n");
        log.log(Level.INFO, "The number of rows inserted table pns: {0}", result.length);
        c.commit();      
    }
    
    
     public void insertTableKINERJA(Vector<Kinerja> kinerjas) throws SQLException{
        PreparedStatement pstmt = c.prepareStatement(Insert_kinerja_sql);      
        c.setAutoCommit(false);       
        for(int i=0;i< kinerjas.size();i++) {                
            pstmt.setString(1,kinerjas.get(i).getATASANPEJABATPENILAI_ORANG_ID());
            pstmt.setString(2,kinerjas.get(i).getPEJABATPENILAI_ORANG_ID());
            pstmt.setString(3,kinerjas.get(i).getPNSDINILAI_ORANG_ID());
            pstmt.setString(4,kinerjas.get(i).getTAHUN());
            pstmt.setString(5,kinerjas.get(i).getNILAI_SKP());
            pstmt.setString(6,kinerjas.get(i).getORIENTASI_PELAYANAN());
            pstmt.setString(7,kinerjas.get(i).getINTEGRITAS());
            pstmt.setString(8,kinerjas.get(i).getKOMITMEN());
            pstmt.setString(9,kinerjas.get(i).getDISIPLIN());
            pstmt.setString(10,kinerjas.get(i).getKERJASAMA());
            pstmt.setString(11,kinerjas.get(i).getKEPEMIMPINAN());
            pstmt.setString(12,kinerjas.get(i).getATASAN_PENILAI_JABATAN());
            pstmt.setString(13,kinerjas.get(i).getPENILAI_JABATAN());
            pstmt.setString(14,kinerjas.get(i).getPENILAI_GOLONGAN());
            pstmt.setString(15,kinerjas.get(i).getATASAN_PENILAI_GOLONGAN());
            pstmt.setString(16,kinerjas.get(i).getPENILAI_TMT_GOLONGAN());
            pstmt.setString(17,kinerjas.get(i).getATASAN_PENILAI_TMT_GOLONGAN());
            pstmt.setString(18,kinerjas.get(i).getPENILAI_UNOR_NAMA());   
            pstmt.setString(19,kinerjas.get(i).getATASAN_PENILAI_UNOR_NAMA());
            pstmt.setString(20,kinerjas.get(i).getPENILAI_NAMA());
            pstmt.setString(21,kinerjas.get(i).getATASAN_PENILAI_NAMA());
            pstmt.setString(22,kinerjas.get(i).getPENILAI_NIP_NRP());
            pstmt.setString(23,kinerjas.get(i).getATASAN_PENILAI_NIP_NRP());
            pstmt.setString(24,kinerjas.get(i).getSTATUS_PENILAI());
            pstmt.setString(25,kinerjas.get(i).getSTATUS_ATASAN_PENILAI()); 
            pstmt.setString(26,kinerjas.get(i).getJENIS_JABATAN());            
            pstmt.addBatch();            
        }
        
        int[] result = pstmt.executeBatch();
        timestamp = new Timestamp(System.currentTimeMillis());
        area.append(Waktu.format(timestamp) + " "+"Data Penilaian Kinerja  yang di import sebanyak  : " +  result.length + "\n");
        log.log(Level.INFO, "The number of rows inserted table kinerja : {0}", result.length);
        c.commit();
        
    }
    
    public void  selectAllPNS() throws SQLException{  
        
        log.info("=========selectAll PNS ==== ");
        stmt = c.createStatement();
        ResultSet rs    = stmt.executeQuery(Select_pns_sql);   
        while (rs.next()) {
            log.info(rs.getString("PNS_ID") +  "\t" + 
                              rs.getString("NIP_BARU") + "\t" +
                              rs.getString("NAMA") + "\t"                               
                   );
        }     
    }
    
     public void selectAllKINERJA() throws SQLException{  
        
        log.info("=========selectAll KINERJA ==== ");
        stmt = c.createStatement();
        ResultSet rs    = stmt.executeQuery(Select_kinerja_sql);           
        // loop through the result set
        while (rs.next()) {
            log.info(rs.getString("NIPATASANPEJABATPENILAI_ORANG_ID") +  "\t" + 
                              rs.getString("NIPPEJABATPENILAI_ORANG_ID") + "\t" +
                              rs.getString("NIPPNSDINILAI_ORANG_ID") + "\t" +
                            rs.getString("PENILAI_TMT_GOLONGAN") + "\t" 
                   );
        }    
      
    }
     
     public ResultSet exportKinerja() throws SQLException{
        String sql="SELECT a.*, b.PNS_ID ATASANPEJABATPENILAI_ORANG_ID,"
                + " c.PNS_ID PEJABATPENILAI_ORANG_ID, d.PNS_ID PNSDINILAI_ORANG_ID"
                + " FROM KINERJA a "
                + " LEFT JOIN PNS b ON a.NIPATASANPEJABATPENILAI_ORANG_ID = b.NIP_BARU "
                + " LEFT JOIN PNS c ON a.NIPPEJABATPENILAI_ORANG_ID = c.NIP_BARU "
                + " LEFT JOIN PNS d ON a.NIPPNSDINILAI_ORANG_ID = d.NIP_BARU ";
        stmt = c.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);           
        return rs;       
     }
    
    public void dropTablePNS() throws SQLException{         
        log.info("=========Drop Table PNS===========");
        stmt = c.createStatement();
        stmt.executeUpdate(Drop_pns_sql);  
    }
    
    public void dropTableKINERJA() throws SQLException{         
        log.info("=========Drop Table PNS===========");
        stmt = c.createStatement();
        stmt.executeUpdate(Drop_kinerja_sql);  
    }
    
    public void close() throws SQLException{  
        log.info("=========Close Connection===========");
        stmt.close();
        c.close();
    }
}
