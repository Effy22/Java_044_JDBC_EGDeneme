package com.Elif.repository;

import com.Elif.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User>{

    private CRUD crud;
    private String sql;
    private ResultSet rs;

    public UserRepository(){
        crud=new CRUD();
    }

    @Override
    public boolean save(User entity) {
        sql="insert into tbluser(adsoyad,username,password,avatar) " +
                "values('"+entity.getAdsoyad()+"','"+entity.getUsername()+"','"
                +entity.getPassword()+"','"+entity.getAvatar()+"')";
        try {
            crud.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User entity) {
        sql = "update tbluser set " +
                "adsoyad='"+entity.getAdsoyad()
                +"',username='"+entity.getUsername()
                +"',password="+entity.getPassword()
                +",avatar='"+entity.getAvatar()
                +"' where id="+entity.getId();
        try {
            crud.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        sql = "delete from tbluser where id="+id;
        try {
            crud.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> findAll() {
       rs=crud.getAllTableRows("select * from tbluser");
       List<User> userList=new ArrayList<>();
       try{
           while(rs.next()){
               int id =rs.getInt("id");
               String adsoyad =rs.getString("adsoyad");
               String username =rs.getString("username");
               String password= rs.getString("password");
               String avatar =rs.getString("avatar");

               User user= new User(adsoyad,username,password,avatar);
               userList.add(user);
           }
           return userList;
       }catch (Exception e){
           System.out.println("Tüm kullanıcıları getirirken hata oluştu");
           return userList;
       }
    }

    @Override
    public Optional<User> findById(Long id) {
        sql="select * from tbluser where id="+id;
        rs=crud.getAllTableRows(sql);
        Optional<User> userOptional = Optional.empty();
        try{
            while (rs.next()){
                Long db_id=rs.getLong("id");
                String db_adsoyad=rs.getString("adsoyad");
                String db_username=rs.getString("username");
                String db_password =rs.getString("password");
                String db_avatar =rs.getString("avatar");
                User user=new User(db_id,db_adsoyad,db_username,db_password,db_avatar);
                userOptional=Optional.of(user);
            }
        }catch (Exception e){
            System.out.println("Hata");
        }
        return userOptional;
    }

    public Optional<User> doLogin(String username, String password){
        sql="select * from tbluser where username='"+username +"' and password='"+password+"'";
        rs=crud.getAllTableRows(sql);
        Optional<User> userOptional = Optional.empty();

        try{
            while (rs.next()){
                Long db_id=rs.getLong("id");
                String db_adsoyad=rs.getString("adsoyad");
                String db_username=rs.getString("username");
                String db_password =rs.getString("password");
                String db_avatar =rs.getString("avatar");
                User user=new User(db_id,db_adsoyad,db_username,db_password,db_avatar);
                userOptional=Optional.of(user);
            }
        }catch (Exception e){
            System.out.println("Hata");
        }
        return userOptional;
    }
    public boolean isUserName (String username){
        sql="select * from tbluser where username='"+username+"'";
        rs=crud.getAllTableRows(sql);
        boolean isUser=false;
        try{
            while(rs.next()){
                //olur da bu döngünün içine girebildiyse
                isUser=true;
            }
        }catch (Exception e){
            System.out.println("User aranırken hata oluştu.");
        }
        return isUser;
    }
}
