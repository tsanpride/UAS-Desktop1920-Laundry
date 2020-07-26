package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tsanpride */

public class Koneksi {
    
    public static Connection con;
//    private final String url = "jdbc:mysql://localhost:3306/db_tubes_pbo";
//    private final String username = "root";
//    private final String password = "";
    
    public void connect() {
        try{
//            FileReader reader = new FileReader("conf.properties");
//            Properties p=new Properties();
//            p.load(reader);
//            String ip = p.getProperty("ip");
//            String port=p.getProperty("port");
            FileReader reader = new FileReader("conf.properties");
            Properties p=new Properties();
            p.load(reader);
            String ip = p.getProperty("ip");
            String port=p.getProperty("port");
            String url="jdbc:mysql://"+ip+":"+port+"/db_tubes_pbo";
            String username="root";
            String password="";
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database");
        } catch(SQLException se) {
            System.out.println("Connection to database error! "+se);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getKoneksi() {
        con = null;
        try {
            FileReader reader = new FileReader("conf.properties");
            Properties p=new Properties();
            p.load(reader);
            String ip = p.getProperty("ip");
            String port=p.getProperty("port");
            String url="jdbc:mysql://"+ip+":"+port+"/db_tubes_pbo";
            String username="root";
            String password="";
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            //return con;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            //return con;
        }
        return con;
    }
}
