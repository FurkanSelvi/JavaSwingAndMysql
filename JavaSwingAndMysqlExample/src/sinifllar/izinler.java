/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinifllar;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.collections.ObservableArray;

/**
 *
 * @author furkan
 */
public class izinler {
    private String kayitNo;
    private String birim;
    private String kalan;
    private String baslangic;
    private String bitis;
    private String kullanılan;
    private String turu;
    private String tcno;

    public izinler(String kayitNo, String birim, String kalan, String baslangic, String bitis, String kullanılan, String turu, String tcno) {
        this.kayitNo = kayitNo;
        this.birim = birim;
        this.kalan = kalan;
        this.baslangic = baslangic;
        this.bitis = bitis;
        this.kullanılan = kullanılan;
        this.turu = turu;
        this.tcno = tcno;
    }
     ResultSet rs;
    PreparedStatement ps;

     public String dateFormat(Date d){
        DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        String date= df.format(d);
        return date;
    }
    
    public boolean izinEkle(izinler iEkle){
        try {
            veriTabaniBaglantisi vb= new veriTabaniBaglantisi();
            vb.baglan();
            String sorgu="insert into izinler (birim,kalan,baslangic,bitis,kullanilan,turu,tcno) values(?,?,?,?,?,?,?)";
            ps=vb.con.prepareStatement(sorgu);
            ps.setString(1, iEkle.getBirim());
            ps.setString(2, iEkle.getKalan());
            ps.setString(3, iEkle.getBaslangic() );
            ps.setString(4, iEkle.getBitis());
            ps.setString(5, iEkle.getKullanılan());
            ps.setString(6, iEkle.getTuru());
            ps.setString(7, iEkle.getTcno());
            ps.execute();
            
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    public boolean iSil(String iSil){
    try {
        veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
        vb.baglan();
        String sorgu="delete from izinler where kayit_no=?";
        ps=vb.con.prepareStatement(sorgu);
        ps.setString(1, iSil);
        ps.execute();
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
        return true;
    }
    
    

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }
   

    public String getKayitNo() {
        return kayitNo;
    }

    public void setKayitNo(String kayitNo) {
        this.kayitNo = kayitNo;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getKalan() {
        return kalan;
    }

    public void setKalan(String kalan) {
        this.kalan = kalan;
    }

    public String getBaslangic() {
        return baslangic;
    }

    public void setBaslangic(String baslangic) {
        this.baslangic = baslangic;
    }

    public String getBitis() {
        return bitis;
    }

    public void setBitis(String bitis) {
        this.bitis = bitis;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getKullanılan() {
        return kullanılan;
    }

    public void setKullanılan(String kullanılan) {
        this.kullanılan = kullanılan;
    }
    
    
    
}
