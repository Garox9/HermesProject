package com.garox.hermesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class HermesProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext hermes = SpringApplication.run(HermesProjectApplication.class, args);
        HermesController controller = hermes.getBean(HermesController.class);
        controller.mainLoop();
    }

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }

}
