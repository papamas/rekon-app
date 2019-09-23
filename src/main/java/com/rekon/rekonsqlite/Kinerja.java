/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rekon.rekonsqlite;
import java.sql.Date;

/**
 *
 * @author PAKIVP
 */
public class Kinerja {
    
    private int id;
    private String ATASANPEJABATPENILAI_ORANG_ID;
    private String PEJABATPENILAI_ORANG_ID;
    private String PNSDINILAI_ORANG_ID;
    private String TAHUN;
    private String NILAI_SKP;
    private String ORIENTASI_PELAYANAN;
    private String INTEGRITAS;
    private String KOMITMEN;
    private String DISIPLIN;
    private String KERJASAMA;
    private String KEPEMIMPINAN;
    private String ATASAN_PENILAI_JABATAN;
    private String PENILAI_JABATAN;
    private String PENILAI_GOLONGAN;
    private String ATASAN_PENILAI_GOLONGAN;
    private String PENILAI_TMT_GOLONGAN;
    private String ATASAN_PENILAI_TMT_GOLONGAN;
    private String PENILAI_UNOR_NAMA;
    private String ATASAN_PENILAI_UNOR_NAMA;
    private String PENILAI_NAMA;
    private String ATASAN_PENILAI_NAMA;
    private String PENILAI_NIP_NRP;
    private String ATASAN_PENILAI_NIP_NRP;
    private String STATUS_PENILAI;
    private String STATUS_ATASAN_PENILAI;
    private String JENIS_JABATAN;

    public Kinerja(String ATASANPEJABATPENILAI_ORANG_ID, String PEJABATPENILAI_ORANG_ID,
            String PNSDINILAI_ORANG_ID, String TAHUN,
            String NILAI_SKP, String ORIENTASI_PELAYANAN, 
            String INTEGRITAS, String KOMITMEN, String DISIPLIN, 
            String KERJASAMA, String KEPEMIMPINAN,
            String ATASAN_PENILAI_JABATAN,
            String PENILAI_JABATAN, String PENILAI_GOLONGAN,
            String ATASAN_PENILAI_GOLONGAN, String PENILAI_TMT_GOLONGAN,
            String ATASAN_PENILAI_TMT_GOLONGAN,
            String PENILAI_UNOR_NAMA, String ATASAN_PENILAI_UNOR_NAMA, 
            String PENILAI_NAMA, String ATASAN_PENILAI_NAMA, 
            String PENILAI_NIP_NRP, String ATASAN_PENILAI_NIP_NRP,
            String STATUS_PENILAI, String STATUS_ATASAN_PENILAI, String JENIS_JABATAN) {
        
        this.ATASANPEJABATPENILAI_ORANG_ID = ATASANPEJABATPENILAI_ORANG_ID;
        this.PEJABATPENILAI_ORANG_ID = PEJABATPENILAI_ORANG_ID;
        this.PNSDINILAI_ORANG_ID = PNSDINILAI_ORANG_ID;
        this.TAHUN = TAHUN;
        this.NILAI_SKP = NILAI_SKP;
        this.ORIENTASI_PELAYANAN = ORIENTASI_PELAYANAN;
        this.INTEGRITAS = INTEGRITAS;
        this.KOMITMEN = KOMITMEN;
        this.DISIPLIN = DISIPLIN;
        this.KERJASAMA = KERJASAMA;
        this.KEPEMIMPINAN = KEPEMIMPINAN;
        this.ATASAN_PENILAI_JABATAN = ATASAN_PENILAI_JABATAN;
        this.PENILAI_JABATAN = PENILAI_JABATAN;
        this.PENILAI_GOLONGAN = PENILAI_GOLONGAN;
        this.ATASAN_PENILAI_GOLONGAN = ATASAN_PENILAI_GOLONGAN;
        this.PENILAI_TMT_GOLONGAN = PENILAI_TMT_GOLONGAN;
        this.ATASAN_PENILAI_TMT_GOLONGAN = ATASAN_PENILAI_TMT_GOLONGAN;
        this.PENILAI_UNOR_NAMA = PENILAI_UNOR_NAMA;
        this.ATASAN_PENILAI_UNOR_NAMA = ATASAN_PENILAI_UNOR_NAMA;
        this.PENILAI_NAMA = PENILAI_NAMA;
        this.ATASAN_PENILAI_NAMA = ATASAN_PENILAI_NAMA;
        this.PENILAI_NIP_NRP = PENILAI_NIP_NRP;
        this.ATASAN_PENILAI_NIP_NRP = ATASAN_PENILAI_NIP_NRP;
        this.STATUS_PENILAI = STATUS_PENILAI;
        this.STATUS_ATASAN_PENILAI = STATUS_ATASAN_PENILAI;
        this.JENIS_JABATAN = JENIS_JABATAN;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getATASANPEJABATPENILAI_ORANG_ID() {
        return ATASANPEJABATPENILAI_ORANG_ID;
    }

    public void setATASANPEJABATPENILAI_ORANG_ID(String ATASANPEJABATPENILAI_ORANG_ID) {
        this.ATASANPEJABATPENILAI_ORANG_ID = ATASANPEJABATPENILAI_ORANG_ID;
    }

    public String getPEJABATPENILAI_ORANG_ID() {
        return PEJABATPENILAI_ORANG_ID;
    }

    public void setPEJABATPENILAI_ORANG_ID(String PEJABATPENILAI_ORANG_ID) {
        this.PEJABATPENILAI_ORANG_ID = PEJABATPENILAI_ORANG_ID;
    }

    public String getPNSDINILAI_ORANG_ID() {
        return PNSDINILAI_ORANG_ID;
    }

    public void setPNSDINILAI_ORANG_ID(String PNSDINILAI_ORANG_ID) {
        this.PNSDINILAI_ORANG_ID = PNSDINILAI_ORANG_ID;
    }

    public String getTAHUN() {
        return TAHUN;
    }

    public void setTAHUN(String TAHUN) {
        this.TAHUN = TAHUN;
    }

    public String getNILAI_SKP() {
        return NILAI_SKP;
    }

    public void setNILAI_SKP(String NILAI_SKP) {
        this.NILAI_SKP = NILAI_SKP;
    }

    public String getORIENTASI_PELAYANAN() {
        return ORIENTASI_PELAYANAN;
    }

    public void setORIENTASI_PELAYANAN(String ORIENTASI_PELAYANAN) {
        this.ORIENTASI_PELAYANAN = ORIENTASI_PELAYANAN;
    }

    public String getINTEGRITAS() {
        return INTEGRITAS;
    }

    public void setINTEGRITAS(String INTEGRITAS) {
        this.INTEGRITAS = INTEGRITAS;
    }

    public String getKOMITMEN() {
        return KOMITMEN;
    }

    public void setKOMITMEN(String KOMITMEN) {
        this.KOMITMEN = KOMITMEN;
    }

    public String getDISIPLIN() {
        return DISIPLIN;
    }

    public void setDISIPLIN(String DISIPLIN) {
        this.DISIPLIN = DISIPLIN;
    }

    public String getKERJASAMA() {
        return KERJASAMA;
    }

    public void setKERJASAMA(String KERJASAMA) {
        this.KERJASAMA = KERJASAMA;
    }

    public String getKEPEMIMPINAN() {
        return KEPEMIMPINAN;
    }

    public void setKEPEMIMPINAN(String KEPEMIMPINAN) {
        this.KEPEMIMPINAN = KEPEMIMPINAN;
    }

    public String getATASAN_PENILAI_JABATAN() {
        return ATASAN_PENILAI_JABATAN;
    }

    public void setATASAN_PENILAI_JABATAN(String ATASAN_PENILAI_JABATAN) {
        this.ATASAN_PENILAI_JABATAN = ATASAN_PENILAI_JABATAN;
    }

    public String getPENILAI_JABATAN() {
        return PENILAI_JABATAN;
    }

    public void setPENILAI_JABATAN(String PENILAI_JABATAN) {
        this.PENILAI_JABATAN = PENILAI_JABATAN;
    }

    public String getPENILAI_GOLONGAN() {
        return PENILAI_GOLONGAN;
    }

    public void setPENILAI_GOLONGAN(String PENILAI_GOLONGAN) {
        this.PENILAI_GOLONGAN = PENILAI_GOLONGAN;
    }

    public String getATASAN_PENILAI_GOLONGAN() {
        return ATASAN_PENILAI_GOLONGAN;
    }

    public void setATASAN_PENILAI_GOLONGAN(String ATASAN_PENILAI_GOLONGAN) {
        this.ATASAN_PENILAI_GOLONGAN = ATASAN_PENILAI_GOLONGAN;
    }

    public String getPENILAI_TMT_GOLONGAN() {
        return PENILAI_TMT_GOLONGAN;
    }

    public void setPENILAI_TMT_GOLONGAN(String PENILAI_TMT_GOLONGAN) {
        this.PENILAI_TMT_GOLONGAN = PENILAI_TMT_GOLONGAN;
    }

    public String getATASAN_PENILAI_TMT_GOLONGAN() {
        return ATASAN_PENILAI_TMT_GOLONGAN;
    }

    public void setATASAN_PENILAI_TMT_GOLONGAN(String ATASAN_PENILAI_TMT_GOLONGAN) {
        this.ATASAN_PENILAI_TMT_GOLONGAN = ATASAN_PENILAI_TMT_GOLONGAN;
    }

    public String getPENILAI_UNOR_NAMA() {
        return PENILAI_UNOR_NAMA;
    }

    public void setPENILAI_UNOR_NAMA(String PENILAI_UNOR_NAMA) {
        this.PENILAI_UNOR_NAMA = PENILAI_UNOR_NAMA;
    }

    public String getATASAN_PENILAI_UNOR_NAMA() {
        return ATASAN_PENILAI_UNOR_NAMA;
    }

    public void setATASAN_PENILAI_UNOR_NAMA(String ATASAN_PENILAI_UNOR_NAMA) {
        this.ATASAN_PENILAI_UNOR_NAMA = ATASAN_PENILAI_UNOR_NAMA;
    }

    public String getPENILAI_NAMA() {
        return PENILAI_NAMA;
    }

    public void setPENILAI_NAMA(String PENILAI_NAMA) {
        this.PENILAI_NAMA = PENILAI_NAMA;
    }

    public String getATASAN_PENILAI_NAMA() {
        return ATASAN_PENILAI_NAMA;
    }

    public void setATASAN_PENILAI_NAMA(String ATASAN_PENILAI_NAMA) {
        this.ATASAN_PENILAI_NAMA = ATASAN_PENILAI_NAMA;
    }

    public String getPENILAI_NIP_NRP() {
        return PENILAI_NIP_NRP;
    }

    public void setPENILAI_NIP_NRP(String PENILAI_NIP_NRP) {
        this.PENILAI_NIP_NRP = PENILAI_NIP_NRP;
    }

    public String getATASAN_PENILAI_NIP_NRP() {
        return ATASAN_PENILAI_NIP_NRP;
    }

    public void setATASAN_PENILAI_NIP_NRP(String ATASAN_PENILAI_NIP_NRP) {
        this.ATASAN_PENILAI_NIP_NRP = ATASAN_PENILAI_NIP_NRP;
    }

    public String getSTATUS_PENILAI() {
        return STATUS_PENILAI;
    }

    public void setSTATUS_PENILAI(String STATUS_PENILAI) {
        this.STATUS_PENILAI = STATUS_PENILAI;
    }

    public String getSTATUS_ATASAN_PENILAI() {
        return STATUS_ATASAN_PENILAI;
    }

    public void setSTATUS_ATASAN_PENILAI(String STATUS_ATASAN_PENILAI) {
        this.STATUS_ATASAN_PENILAI = STATUS_ATASAN_PENILAI;
    }

    public String getJENIS_JABATAN() {
        return JENIS_JABATAN;
    }

    public void setJENIS_JABATAN(String JENIS_JABATAN) {
        this.JENIS_JABATAN = JENIS_JABATAN;
    }
    
    
    @Override
    public String toString() {
        return "Kinerja{"+"ATASANPEJABATPENILAI_ORANG_ID=" + ATASANPEJABATPENILAI_ORANG_ID + ", PEJABATPENILAI_ORANG_ID=" + PEJABATPENILAI_ORANG_ID + ", PNSDINILAI_ORANG_ID=" + PNSDINILAI_ORANG_ID + ", TAHUN=" + TAHUN + ", NILAI_SKP=" + NILAI_SKP + ", ORIENTASI_PELAYANAN=" + ORIENTASI_PELAYANAN + ", INTEGRITAS=" + INTEGRITAS + ", KOMITMEN=" + KOMITMEN + ", DISIPLIN=" + DISIPLIN + ", KERJASAMA=" + KERJASAMA + ", KEPEMIMPINAN=" + KEPEMIMPINAN + ", ATASAN_PENILAI_JABATAN=" + ATASAN_PENILAI_JABATAN + ", PENILAI_JABATAN=" + PENILAI_JABATAN + ", PENILAI_GOLONGAN=" + PENILAI_GOLONGAN + ", ATASAN_PENILAI_GOLONGAN=" + ATASAN_PENILAI_GOLONGAN + ", PENILAI_TMT_GOLONGAN=" + PENILAI_TMT_GOLONGAN + ", ATASAN_PENILAI_TMT_GOLONGAN=" + ATASAN_PENILAI_TMT_GOLONGAN + ", PENILAI_UNOR_NAMA=" + PENILAI_UNOR_NAMA + ", ATASAN_PENILAI_UNOR_NAMA=" + ATASAN_PENILAI_UNOR_NAMA + ", PENILAI_NAMA=" + PENILAI_NAMA + ", ATASAN_PENILAI_NAMA=" + ATASAN_PENILAI_NAMA + ", PENILAI_NIP_NRP=" + PENILAI_NIP_NRP + ", ATASAN_PENILAI_NIP_NRP=" + ATASAN_PENILAI_NIP_NRP + ", STATUS_PENILAI=" + STATUS_PENILAI + ", STATUS_ATASAN_PENILAI=" + STATUS_ATASAN_PENILAI + ", JENIS_JABATAN=" + JENIS_JABATAN + '}';
    }
}
