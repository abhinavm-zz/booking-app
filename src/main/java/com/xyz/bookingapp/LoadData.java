package com.xyz.bookingapp;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xyz.bookingapp.entities.ShowRepository;
import com.xyz.bookingapp.entities.ShowDetails;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ShowRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new ShowDetails(new Long(1), new Long(1), new GregorianCalendar(2022, 5, 2).getTime(), "12:00")));
      log.info("Preloading " + repository.save(new ShowDetails(new Long(1), new Long(1),  new GregorianCalendar(2022, 5, 1).getTime(), "15:00")));
      log.info("Preloading " + repository.save(new ShowDetails(new Long(1), new Long(1),  new GregorianCalendar(2022, 5, 4).getTime(), "15:00")));
    };
  }
}