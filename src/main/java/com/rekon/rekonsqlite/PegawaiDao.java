/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author PAKIVP
 */
public class PegawaiDao implements Dao<Pegawai>{
    
    private Vector<Pegawai> pegawais = new Vector();
    private Pegawai p;
    private static Logger log = Logger.getLogger(PegawaiDao.class.getName());
    private static String FILE_NAME = null;
    
    
    public PegawaiDao(File f)  {
        
        int i= 0;
        log.log(Level.INFO, "===Pegawai Dao=== {0}", f.getAbsolutePath());        
        FILE_NAME = f.getAbsolutePath();            
        //Create the CSVFormat object
        CSVFormat format = CSVFormat.DEFAULT.withHeader().withDelimiter(';');
        //initialize the CSVParser object      
        
        try {
            CSVParser parser = new CSVParser(new FileReader(FILE_NAME), format);
            for(CSVRecord record : parser){
               
                p = new Pegawai(record.get("PNS_ID"),record.get("NIP_BARU"),record.get("NAMA")) ;
                pegawais.addElement(p);  
                i++;
            }
            parser.close();  
        } catch (FileNotFoundException ex) {
            log.info(ex.getMessage());
        } catch (IOException ex) {
            log.info(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.info(ex.toString());
        }
              
          
        
        
    }

    

    @Override
    public Optional<Pegawai> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Pegawai> getAll() {
        return pegawais;
    }

    @Override
    public void save(Pegawai t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pegawai t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pegawai t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
