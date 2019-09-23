/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Vector;

/**
 *
 * @author PAKIVP
 */
public class ExportKinerjaDao implements Dao<ExportKinerja> {
        
    private Vector<ExportKinerja> exportKinerjas = new Vector();
    private  ExportKinerja exKinerja;
   
    public ExportKinerjaDao(ResultSet record) throws SQLException{      
                     
        while (record.next()) {
            exKinerja= new ExportKinerja(
            record.getString("ATASANPEJABATPENILAI_ORANG_ID"),
            record.getString("PEJABATPENILAI_ORANG_ID"),
            record.getString("PNSDINILAI_ORANG_ID"),
            record.getString("TAHUN"),
            record.getString("NILAI_SKP"),
            record.getString("ORIENTASI_PELAYANAN"),
            record.getString("INTEGRITAS"),
            record.getString("KOMITMEN"),
            record.getString("DISIPLIN"),
            record.getString("KERJASAMA"),
            record.getString("KEPEMIMPINAN"),
            record.getString("ATASAN_PENILAI_JABATAN"),
            record.getString("PENILAI_JABATAN"),
            record.getString("PENILAI_GOLONGAN"),
            record.getString("ATASAN_PENILAI_GOLONGAN"),
            record.getString("PENILAI_TMT_GOLONGAN"),
            record.getString("ATASAN_PENILAI_TMT_GOLONGAN"),
            record.getString("PENILAI_UNOR_NAMA"),
            record.getString("ATASAN_PENILAI_UNOR_NAMA"),
            record.getString("PENILAI_NAMA"),
            record.getString("ATASAN_PENILAI_NAMA"),
            record.getString("PENILAI_NIP_NRP"),
            record.getString("ATASAN_PENILAI_NIP_NRP"),
            record.getString("STATUS_PENILAI"),
            record.getString("STATUS_ATASAN_PENILAI"),
            record.getString("JENIS_JABATAN"));
            
            exportKinerjas.addElement(exKinerja); 
        }    
        
    }

    @Override
    public Optional<ExportKinerja> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<ExportKinerja> getAll() {
        return exportKinerjas;
    }

    @Override
    public void save(ExportKinerja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ExportKinerja t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ExportKinerja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
