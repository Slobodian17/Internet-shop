package com.peter.nulp.rozrahunkova;

import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.interfaces.IUserRepository;
import com.peter.nulp.rozrahunkova.repository.user.find.UserFindByLoginPassword;
import com.peter.nulp.rozrahunkova.service.menu.Menu;
import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;
import com.peter.nulp.rozrahunkova.service.parameter.MapParams;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Application {

    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

    public static void main(String[] args) {
        new Application()
                .run();
    }

    public static ClassPathXmlApplicationContext getContext(){
        return context;
    }

    public void run(){

        IUserRepository userRepo = (IUserRepository) context.getBean("users");

        String login, password;
        System.out.println("Enter login & password: ");

        Scanner scanner = new Scanner(System.in);
        login = scanner.next();
        password = scanner.next();

        IMapParams mapParams = new MapParams();
        mapParams.put("login", login);
        mapParams.put("password", password);

        User user = userRepo.findOne(UserFindByLoginPassword.class, mapParams);
        if(user == null){
            System.out.println("User's not found!");
            System.exit(1);
        }

        System.out.println("You successfully authorized!");
        Menu.open(user);

    }
}
