package com.xyz.bookingapp;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xyz.bookingapp.entities.ScreenDetails;
import com.xyz.bookingapp.entities.ScreenRepository;
import com.xyz.bookingapp.entities.ShowRepository;
import com.xyz.bookingapp.entities.ShowDetails;
import com.xyz.bookingapp.entities.TheatreDetails;
import com.xyz.bookingapp.entities.TheatreRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ShowRepository repository, TheatreRepository tr) {

    return args -> {
      TheatreDetails td  = new TheatreDetails("Theatre1", "address1", "pune");
      td.setShowDetails(new HashSet<ShowDetails>());
      td.getShowDetails().add (new ShowDetails(new Long(1), "2022-06-04", "12:00",td));
      td.getShowDetails().add (new ShowDetails(new Long(1), "2022-06-05", "12:00",td));
      td.getShowDetails().add (new ShowDetails(new Long(2), "2022-06-05", "12:00",td));
      tr.save (td);
      log.info("initialised " + td);
      td  = new TheatreDetails("Theatre2", "address2", "pune");
      td.setShowDetails(new HashSet<ShowDetails>());
      td.getShowDetails().add (new ShowDetails(new Long(2), "2022-06-03", "12:00",td));
      td.getShowDetails().add (new ShowDetails(new Long(1), "2022-06-05", "12:00",td));
      tr.save (td);
      
      log.info("initialised " + td);
    };
  }
}