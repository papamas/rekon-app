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
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author PAKIVP
 */
public class KinerjaDao implements Dao<Kinerja>{
    
    private Vector<Kinerja> kinerjas = new Vector();
    private Kinerja k;
    private static Logger log = Logger.getLogger(KinerjaDao.class.getName());
    private static String FILE_NAME = null;
    
    public KinerjaDao(File f) {
        try {
            log.log(Level.INFO, "===Pegawai Dao=== {0}", f.getAbsolutePath());
            FILE_NAME = f.getAbsolutePath();
            //Create the CSVFormat object
            CSVFormat format = CSVFormat.DEFAULT.withHeader().withDelimiter(';');
            //initialize the CSVParser object
            CSVParser parser = new CSVParser(new FileReader(FILE_NAME), format);
            
            for(CSVRecord record : parser){           
                k = new Kinerja(record.get("ATASANPEJABATPENILAI_ORANG_ID"),
                        record.get("PEJABATPENILAI_ORANG_ID"),
                        record.get("PNSDINILAI_ORANG_ID"),record.get("TAHUN"),
                        record.get("NILAI_SKP"),
                        record.get("ORIENTASI_PELAYANAN"),
                        record.get("INTEGRITAS"),
                        record.get("KOMITMEN"),
                        record.get("DISIPLIN"),
                        record.get("KERJASAMA"),
                        record.get("KEPEMIMPINAN"),
                        record.get("ATASAN_PENILAI_JABATAN"),
                        record.get("PENILAI_JABATAN"),record.get("PENILAI_GOLONGAN"),
                        record.get("ATASAN_PENILAI_GOLONGAN"),
                        record.get("PENILAI_TMT_GOLONGAN"),
                        record.get("ATASAN_PENILAI_TMT_GOLONGAN"),
                        record.get("PENILAI_UNOR_NAMA"),
                        record.get("ATASAN_PENILAI_UNOR_NAMA"),record.get("PENILAI_NAMA"),
                        record.get("ATASAN_PENILAI_NAMA"),record.get("PENILAI_NIP_NRP"),
                        record.get("ATASAN_PENILAI_NIP_NRP"),record.get("STATUS_PENILAI"),
                        record.get("STATUS_ATASAN_PENILAI"),record.get("JENIS_JABATAN"));
                
                kinerjas.addElement(k);
            }
            parser.close();
        } catch (IOException ex) {
            Logger.getLogger(KinerjaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            log.info(ex.toString());
        }
    }

    @Override
    public Optional<Kinerja> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Kinerja> getAll() {
        return kinerjas;
    }

    @Override
    public void save(Kinerja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Kinerja t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Kinerja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
