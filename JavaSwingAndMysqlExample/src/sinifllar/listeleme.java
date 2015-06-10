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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author furkan
 */
public class listeleme {
     ResultSet rs;
    PreparedStatement ps;
    
   public String dateFormat(Date d){
        DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        String date= df.format(d);
        return date;
    }
    
    public ObservableList<izinler> listele(String tc) throws SQLException{
    veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
    vb.baglan();
    ObservableList<izinler> list=FXCollections.observableArrayList();
    String sorgu ="select * from izinler where tcno=?";
    ps=vb.con.prepareStatement(sorgu);
    ps.setString(1, tc);
    rs=ps.executeQuery();
    while(rs.next()){
        izinler iz = new izinler(rs.getString("kayit_no"), rs.getString("birim"), rs.getString("kalan"), dateFormat(rs.getDate("baslangic")), dateFormat(rs.getDate("bitis")), rs.getString("kullanilan"), rs.getString("turu"), rs.getString("tcno"));
        list.add(iz);
    }
    return list;
}
     public ObservableList<ArrayList> listele2() throws SQLException{
    veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
    vb.baglan();
    ObservableList<ArrayList> list=FXCollections.observableArrayList();
    String sorgu ="select p.ad,p.soyad,sum(i.kullanilan) from personel p, izinler i where p.tcno=i.tcno group by p.tcno";
    ps=vb.con.prepareStatement(sorgu);
    rs=ps.executeQuery();
    while(rs.next()){
        ArrayList<String> liste = new ArrayList<>();
        liste.add(rs.getString("p.ad"));
        liste.add(rs.getString("p.soyad"));
        liste.add(rs.getString("sum(i.kullanilan)"));
    
        list.add(liste);
    }
    
    return list;
}
     public ObservableList<ArrayList> tarihVarMi(String Tarih) throws SQLException{
         veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
    vb.baglan();
    ObservableList<ArrayList> list=FXCollections.observableArrayList();
     String sorgu ="select p.ad,p.soyad,i.bitis from izinler i, personel p where p.tcno=i.tcno and  date_format(?,'%Y-%m-%d') between i.baslangic and i.bitis";
    ps=vb.con.prepareStatement(sorgu);
    ps.setString(1, Tarih);
    rs=ps.executeQuery();
    while(rs.next()){
        ArrayList<String> liste = new ArrayList<>();
        liste.add(rs.getString("p.ad"));
        liste.add(rs.getString("p.soyad"));
        liste.add(rs.getString("i.bitis"));
    
        list.add(liste);
    }
    return list;
     }
       
       public ObservableList<ArrayList> sicilGetir() throws SQLException{
          veriTabaniBaglantisi vb = new veriTabaniBaglantisi();
    vb.baglan();
    ObservableList<ArrayList> list=FXCollections.observableArrayList();
     String sorgu ="select sicilno from personel";
    ps=vb.con.prepareStatement(sorgu);
    rs=ps.executeQuery();
    while(rs.next()){
        ArrayList<String> liste = new ArrayList<>();
        liste.add(rs.getString("sicilno"));
        list.add(liste);
    }
    return list;  
       }

}
