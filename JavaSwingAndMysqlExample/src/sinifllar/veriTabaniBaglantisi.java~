/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinifllar;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author furkan
 */
public class veriTabaniBaglantisi {
    public Connection con;
    
    private String url="jdbc:mysql://localhost:3306/";
    private String driver="com.mysql.jdbc.Driver";
    private String dbname="ITS";
    private String username="root";
    private String password="123123124";
    
    
    public void baglan(){
        try {
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url+dbname,username,password);
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void baglantiKes(){
        try {
            con.close();
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
