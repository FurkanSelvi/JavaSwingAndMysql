/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinifllar;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author furkan
 */
public class Personel {
    private String tcno;
    private String sicilno;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String dogumtarihi;
    private String sehir;
    ResultSet rs;
    PreparedStatement ps;

    public Personel(String tcno, String sicilno, String ad, String soyad, String cinsiyet, String dogumtarihi, String sehir) {
        this.tcno = tcno;
        this.sicilno = sicilno;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dogumtarihi = dogumtarihi;
        this.sehir = sehir;
    }

    public int ctersGetir(String i) throws SQLException{
      if("Bay".equals(i)) return 1;
      else return 2; 
    }
    public String cGetir(int i) throws SQLException{
      if(i==1) return "Bay";
      else return "Bayan";
            /**
             * Bu kod Sıkıntı Cıkardı.
            veriTabaniBaglantisi vb= new veriTabaniBaglantisi();
            vb.baglan();
            String sorgu="select isim from cinsiyet where id=?";
            ps=vb.con.prepareStatement(sorgu);
            ps.setInt(1, i);
            rs=ps.executeQuery();
            rs.next();
            String cisim=rs.getString("isim");
        return cisim;
        */
    }
     public String dateFormat(Date d){
        DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        String date= df.format(d);
        return date;
    }
    
    public boolean personelEkle(Personel pEkle){
        try {
            veriTabaniBaglantisi vb= new veriTabaniBaglantisi();
            vb.baglan();
        String sorgu="insert into personel (tcno,sicilno,ad,soyad,cinsiyet,dogum_tarihi,sehir) values(?,?,?,?,?,?,?)";
            ps=vb.con.prepareStatement(sorgu);
            ps.setString(1, pEkle.getTcno());
            ps.setString(2, pEkle.getSicilno());
            ps.setString(3, pEkle.getAd());
            ps.setString(4, pEkle.getSoyad());
            ps.setInt(5, ctersGetir(pEkle.getCinsiyet()));
            ps.setString(6, pEkle.getDogumtarihi());
            ps.setString(7, pEkle.getSehir());
            ps.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean pSil(String pSil){
    try {
        veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
        vb.baglan();
        String sorgu="delete from personel where tcno=?";
        ps=vb.con.prepareStatement(sorgu);
        ps.setString(1, pSil);
        ps.execute();
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
        return true;
    }
    public boolean guncelle(Personel pDegistir,String tc){
        try {
            veriTabaniBaglantisi vb= new veriTabaniBaglantisi();
            vb.baglan();
            String sorgu="update personel set sicilno=?, ad=?, soyad=?, cinsiyet=?, dogum_tarihi =?, sehir=? where tcno=?";
            ps=vb.con.prepareStatement(sorgu);
            ps.setString(1, pDegistir.getTcno());
            ps.setString(1, pDegistir.getSicilno());
            ps.setString(2, pDegistir.getAd());
            ps.setString(3, pDegistir.getSoyad());
            ps.setInt(4, ctersGetir(pDegistir.getCinsiyet()));
            ps.setString(5, pDegistir.getDogumtarihi());
            ps.setString(6, pDegistir.getSehir());
            ps.setString(7, tc);
            ps.execute();
        } catch (Exception e) {
        return false;
        }
        return true;
    }
    
        public ObservableList<Personel> sicilara(String ad,String soyad,String sicil) throws SQLException{
             veriTabaniBaglantisi vb= new veriTabaniBaglantisi();
            vb.baglan();
            ObservableList<Personel> list=FXCollections.observableArrayList();
            String sorgu="select * from personel where ad like '%"+ad+"%' and soyad like '%"+soyad+"%' and sicilno like '%"+sicil+"%'";
            ps=vb.con.prepareStatement(sorgu);
            rs=ps.executeQuery();
            while(rs.next()){
           Personel pr=new Personel(rs.getString("tcno"),rs.getString("sicilno"),rs.getString("ad"), rs.getString("soyad"),cGetir(rs.getInt("cinsiyet")),dateFormat(rs.getDate("dogum_tarihi")),rs.getString("sehir"));
           list.add(pr);
          }
           ps.close();
           rs.close();
        return  list;
    }
     public ObservableList<Personel> pListele() throws SQLException{
    veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
    vb.baglan();
    ObservableList<Personel> list=FXCollections.observableArrayList();
    String sorgu ="select * from personel";
    ps=vb.con.prepareStatement(sorgu);
    rs=ps.executeQuery();
    while(rs.next()){
        Personel pr=new Personel(rs.getString("tcno"),rs.getString("sicilno"),rs.getString("ad"), rs.getString("soyad"),cGetir(rs.getInt("cinsiyet")),dateFormat(rs.getDate("dogum_tarihi")),rs.getString("sehir"));
        list.add(pr);
    }
    return list;
}
     public Personel pGetir(String tc) throws SQLException{
          veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
    vb.baglan();
    String sorgu ="select * from personel where tcno=?";
    ps=vb.con.prepareStatement(sorgu);
    ps.setString(1, tc);
    rs=ps.executeQuery();
    rs.next();
    Personel pr=new Personel(rs.getString("tcno"),rs.getString("sicilno"),rs.getString("ad"), rs.getString("soyad"),cGetir(rs.getInt("cinsiyet")),dateFormat(rs.getDate("dogum_tarihi")),rs.getString("sehir"));
      return pr;
     }
       
 
    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSicilno() {
        return sicilno;
    }

    public void setSicilno(String sicilno) {
        this.sicilno = sicilno;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDogumtarihi() {
        return dogumtarihi;
    }

    public void setDogumtarihi(String dogumtarihi) {
        this.dogumtarihi = dogumtarihi;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
}
