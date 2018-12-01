package com.geniusmonkey.deckOfCards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.geniusmonkey.deckOfCards")
@SpringBootApplication
public class App 
{
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
}
