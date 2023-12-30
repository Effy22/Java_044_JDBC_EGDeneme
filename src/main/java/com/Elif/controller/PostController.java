package com.Elif.controller;

import com.Elif.entity.Post;
import com.Elif.entity.User;
import com.Elif.repository.PostRepository;
import com.Elif.repository.UserRepository;

import java.util.Date;
import java.util.Scanner;

public class PostController {
    private PostRepository postRepository;
    private UserRepository userRepository;
    public PostController(){
        postRepository=new PostRepository();
        userRepository=new UserRepository();
    }

    public void sharePost(User user){
        System.out.println("""
                **********************************
                ******    Ne düşünüyorsunuz ******
                **********************************   
                """);
        Long shareddate=System.currentTimeMillis();
        System.out.println("Başlığınızı yazınız.....:");
        String title=new Scanner(System.in).nextLine();
        System.out.println("Düşündüklerinizi yazınız......:");
        String postcomment=new Scanner(System.in).nextLine();
        System.out.println("Paylaşacağınız resmin urlsini yazınız.......: ");
        String imageurl=new Scanner(System.in).nextLine();
        postRepository.save(new Post(user.getId(),title,shareddate,imageurl));
        System.out.println("Postunuz paylaşıldı.");
    }

    public void printAllPosts(){
        postRepository.findAll().stream().forEach(x->{
            System.out.println("Kullanıcı Adı....:"+userRepository.findById(x.getUserid())
                    .map(user -> user.getUsername()) // Varsayılan olarak username döner
                    .orElse("Kullanıcı Bulunamadı"));
            System.out.println("Post Başlığı.........:" +x.getTitle());
            System.out.println("Post İçeriği.........:" +x.getPostcomment());
            System.out.println("Post Tarihi...........:" +new Date(x.getShareddate()));
            System.out.println("**************************************");
        });
    }
}
