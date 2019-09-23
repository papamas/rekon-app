/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;

/**
 *
 * @author PAKIVP
 */
public class Pegawai {
    
    private String pnsId;
    private String nipBaru;
    private String nama;
    
    public Pegawai(String pnsId,String nipBaru, String nama){
        this.pnsId = pnsId;
        this.nipBaru = nipBaru;
        this.nama  = nama;
    }
    
    public void setpnsId(String pnsId){
        this.pnsId = pnsId;       
    }
    
    public String getpnsId(){
        return pnsId;
    }
    
    public void setnipBaru(String nipBaru){
        this.nipBaru = nipBaru;
    }
    
    public String getnipBaru(){
        return nipBaru;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    
    @Override
    public String  toString(){
        return "["+ 
               this.pnsId+","+
               this.nipBaru+","+
               this.nama+","+
                "]";
    }
   
    
}
