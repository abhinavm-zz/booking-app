package com.xyz.bookingapp.entities;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShowRepository extends JpaRepository<ShowDetails, Long> {
	List <ShowDetails> findByTheatreIdAndShowDate (Long theatreId, String showDate);
}