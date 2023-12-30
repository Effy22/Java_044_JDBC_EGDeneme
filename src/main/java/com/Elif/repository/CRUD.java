package com.Elif.repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CRUD {

    private Connection conn;
    private ResultSet rs;
    private boolean openConnection(){
        try{
            Driver.class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/ForumDB",
                    "postgres","root");
            return true;
        }catch (Exception e){
            System.out.println("Bağlantı hatası. "+e.getMessage());
            return false;
        }
    }
    private void closeConnection(){
        try{
            if(!conn.isClosed()) {
                this.conn.close();
            }
        }catch (Exception exception){
            System.out.println("Bağlantı kapatma hatası....: "+ exception);
        }
    }
    public boolean executeUpdate(String SQL){
        try {
            if(openConnection()){
                conn.prepareStatement(SQL).executeUpdate();
                closeConnection();
                return true;
            }else{
                System.out.println("Bağlantı açılamadı");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Database Update İşlem Hatası ..:"+e);
            return false;
        }
    }
    public ResultSet getAllTableRows(String SQL){

        try{
            if(openConnection()){
                rs=conn.prepareStatement(SQL).executeQuery();
                closeConnection();
                return rs;
            }else{
                System.out.println("Bağlantı açılamadı");
                return null;
            }
        }catch (Exception e){
            System.out.println("Database sorgu hatası");
            return null;
        }

    }

}
