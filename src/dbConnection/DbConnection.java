/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import domen.IndexSlider;
import domen.PhotoGallery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import setup.SeleniumProperties;

/**
 *
 * @author Sofija
 */
public class DbConnection {

    private static Connection conn;

    public static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            SeleniumProperties.init();

            conn = DriverManager.getConnection(SeleniumProperties.dbUrl, SeleniumProperties.dbUsername, SeleniumProperties.dbPassword);
            System.out.println(SeleniumProperties.dbUrl);
            System.out.println(SeleniumProperties.dbUsername);
            System.out.println(SeleniumProperties.dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static IndexSlider getIndexSlider(String query) {
        IndexSlider is = new IndexSlider();
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println(query);
            
            if(rs.next()){
              is.setId(rs.getInt(1));
              is.setTitle(rs.getString(2));
              is.setDescription(rs.getString(3));
              is.setLinkType(rs.getString(4));
              is.setLinkLabel(rs.getString(5));
              is.setDeleted(false);
            } else {
                is.setDeleted(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return is;
    }

    public static PhotoGallery getPhotoGallery(String query) {
        PhotoGallery pg = new PhotoGallery();
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println(query);
            
            if(rs.next()){
              pg.setId(rs.getInt(1));
              pg.setTitle(rs.getString(2));
              pg.setDescription(rs.getString(3));
              pg.setDeleted(false);
            } else {
                pg.setDeleted(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pg;
    }
    
    public static Boolean isDeleted(String query) {
         
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println(query);

            if (rs.next()) {
                return false;
            } else {
                return  true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

