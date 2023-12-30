package com.Elif.controller;

import com.Elif.entity.User;
import com.Elif.repository.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private UserRepository userRepository;
    public UserController(){
        userRepository=new UserRepository();
    }

    public User Login(){
        System.out.println("""
                **********************************
                ******    KULLANICI GİRİŞ   ******
                **********************************   
                """);
        System.out.println("Kullanıcı adı.......:");
        String username=new Scanner(System.in).nextLine();
        System.out.println("Şifre.......: ");
        String password=new Scanner(System.in).nextLine();
        Optional<User> userOptional=userRepository.doLogin(username,password);
        if(userOptional.isPresent()){
            System.out.println("Giriş yapıldı.");
        }else{
            System.out.println("Kullanıcı adı ya da şifre hatalı.");
        }

        return userOptional.get();
    }

    public void Register(){
        System.out.println("""
                **********************************
                ********* YENİ KULLANICI *********
                **********************************   
                """);
        System.out.println("ad soyad........: ");
        String adsoyad = new Scanner(System.in).nextLine();
        System.out.println("Kullanıcı adı........: ");
        String username;
        boolean isUser;
        do{
            username=new Scanner(System.in).nextLine();
            isUser=userRepository.isUserName(username);
            if(isUser)
                System.out.println("Bu kullanıcı adı zaten kullanılıyor. Değiştirin");
        }while(isUser);

        System.out.println("Şifre........: ");
        String password = new Scanner(System.in).nextLine();
        System.out.println("Avatar........: ");
        String avatar = new Scanner(System.in).nextLine();

        User user=new User(adsoyad,username,password,avatar);
        userRepository.save(user);
    }

    public void printAllUsers(){
        userRepository.findAll().stream().forEach(x->{
            System.out.println("Kullanıcı Adı....:"+x.getUsername());
            System.out.println("Ad Soyad.........:" +x.getAdsoyad());
            System.out.println("Avatar...........:" +x.getAvatar());
            System.out.println("******************************");
        });
    }




}
