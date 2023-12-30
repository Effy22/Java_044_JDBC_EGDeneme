package com.Elif;

import com.Elif.controller.PostController;
import com.Elif.controller.UserController;
import com.Elif.entity.User;

import java.util.Scanner;

public class Runner {
    private static UserController userController=new UserController();
    private static PostController postController=new PostController();
    private static User loginUser=null;

    public static void main(String[] args) {
        int secim;
        do {
            if (loginUser != null) {
                System.out.println("******************************");
                System.out.println(" HOŞGELDİN " + loginUser.getUsername());
                System.out.println("""
                         *** 1- Postları görüntüle
                         *** 2- Post Paylaş
                         *** 3- Kullanıcıları görüntüle
                         *** 4- Logout
                        """);
                System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz..: ");
                secim = new Scanner(System.in).nextInt();
                switch (secim) {
                    case 1: postController.printAllPosts();
                        break;
                    case 2: postController.sharePost(loginUser);
                        break;
                    case 3: userController.printAllUsers();
                        break;
                    case 4:
                        loginUser = null;
                        secim = 1;
                        System.err.println("Çıkış yapıldı");
                        break;
                    default:
                        System.out.println("Yanlış seçim yaptınız");
                }
            } else {
                System.out.println("""
                        **************************************
                        ******** Java Forum Sayfası **********
                        ************** GİRİŞ *****************
                        1- Login
                        2- Register
                        0- ÇIKIŞ
                        """);
                System.out.println("Lütfen seçiniz...: ");
                secim = new Scanner(System.in).nextInt();
                switch (secim) {
                    case 1:
                        loginUser = userController.Login();
                        break;
                    case 2:
                        new UserController().Register();
                        break;
                    case 0:
                        System.out.println("Çıkış yapılıyor!");
                        break;
                    default:
                        System.err.println("Geçerli bir seçim yapınız");
                        break;
                }
            }
        } while (secim != 0);
    }

}
