package com.Elif.repository;

import com.Elif.entity.Post;
import com.Elif.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository implements Repository<Post> {

    private CRUD crud;
    private String sql;
    private ResultSet rs;

    public PostRepository() {
        crud=new CRUD();
    }

    @Override
    public boolean save(Post entity) {
        sql="insert into tblpost(userid,title,shareddate,imageurl) " +
                "values("+entity.getUserid()+",'"+entity.getTitle()+"',"
                +entity.getShareddate()+",'"+entity.getImageurl()+"')";
        try {
            crud.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Post entity) {
        sql = "update tblpost set " +
                "userid='"+entity.getUserid()
                +"',title='"+entity.getTitle()
                +"',shareddate="+entity.getShareddate()
                +"',imageurl="+entity.getImageurl()
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
        sql = "delete from tblpost where id="+id;
        try {
            crud.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Post> findAll() {
        rs=crud.getAllTableRows("select * from tblpost");
        List<Post> postList=new ArrayList<>();
        try{
            while(rs.next()){
                Long id =rs.getLong("id");
                Long userid =rs.getLong("userid");
                String title =rs.getString("title");
                String postcomment =rs.getString("postcomment");
                Long shareddate= rs.getLong("shareddate");
                String imageurl =rs.getString("imageurl");

                Post post= new Post(id,userid,title,postcomment,shareddate,imageurl);
                postList.add(post);
            }
            return postList;
        }catch (Exception e){
            System.out.println("Tüm postları getirirken hata oluştu");
            return null;
        }
    }

    @Override
    public Optional<Post> findById(Long id) {
        sql="select * from tblpost where id="+id;
        rs=crud.getAllTableRows(sql);
        Optional<Post> postOptional = Optional.empty();
        try{
            while (rs.next()){
                Long id2 =rs.getLong("id2");
                Long userid =rs.getLong("userid");
                String title =rs.getString("title");
                String postcomment =rs.getString("postcomment");
                Long shareddate= rs.getLong("shareddate");
                String imageurl =rs.getString("imageurl");
                int likecount =rs.getInt("likecount");
                int commentcount =rs.getInt("commentcount");
                Post post=new Post(id2,userid,title,postcomment,shareddate,imageurl,likecount,commentcount);
                postOptional=Optional.of(post);
            }
        }catch (Exception e){
            System.out.println("Hata");
        }
        return postOptional;
    }
}
