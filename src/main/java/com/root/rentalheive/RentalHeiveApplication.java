package com.root.rentalheive;

import com.root.rentalheive.repositories.DemandeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentalHeiveApplication {

   /* @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }*/
    public static void main(String[] args) {
//        System.setProperty("liquibase.secureParsing", "false");
        SpringApplication.run(RentalHeiveApplication.class, args);
    }

}
