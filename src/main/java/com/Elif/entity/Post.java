package com.Elif.entity;

public class Post {
    Long id;
    Long userid;
    String title;
    String postcomment;
    Long shareddate;
    String imageurl;
    int likecount;
    int commentcount;

    public Post() {
    }

    public Post(Long userid, String title, Long shareddate, String imageurl) {
        this.userid = userid;
        this.title = title;
        this.shareddate = shareddate;
        this.imageurl = imageurl;
    }

    public Post(Long userid, String title, Long shareddate, String imageurl, int commentcount) {
        this.userid = userid;
        this.title = title;
        this.shareddate = shareddate;
        this.imageurl = imageurl;
        this.commentcount = commentcount;
    }

    public Post(Long id, Long userid, String title, String postcomment, Long shareddate, String imageurl) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.postcomment = postcomment;
        this.shareddate = shareddate;
        this.imageurl = imageurl;
    }

    public Post(Long id, Long userid, String title, String postcomment, Long shareddate, String imageurl, int likecount, int commentcount) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.postcomment = postcomment;
        this.shareddate = shareddate;
        this.imageurl = imageurl;
        this.likecount = likecount;
        this.commentcount = commentcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostcomment() {
        return postcomment;
    }

    public void setPostcomment(String postcomment) {
        this.postcomment = postcomment;
    }

    public Long getShareddate() {
        return shareddate;
    }

    public void setShareddate(Long shareddate) {
        this.shareddate = shareddate;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", postcomment='" + postcomment + '\'' +
                ", shareddate=" + shareddate +
                ", imageurl='" + imageurl + '\'' +
                ", likecount=" + likecount +
                ", commentcount=" + commentcount +
                '}';
    }
}
