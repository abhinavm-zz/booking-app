package com.xyz.bookingapp.entities;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheatreRepository extends JpaRepository<TheatreDetails, Long> {
	@Query ("SELECT t FROM TheatreDetails t JOIN t.showDetails sd WHERE t.city = ?1 AND sd.showDate= ?2 AND sd.movieId = ?3")
	List <TheatreDetails> findBydCityAndDateAndMovie(String city, String date, Long movieId);
}