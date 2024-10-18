package org.example._citizencardproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitizenCardProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitizenCardProjApplication.class, args);
    }
    public int add(int a , int b){
        for(int i=0;i<=5;i++){
            a=a+b;
        }
        return a;
    }
}
