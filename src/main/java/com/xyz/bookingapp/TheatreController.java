package com.xyz.bookingapp;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.bookingapp.entities.TheatreDetails;
import com.xyz.bookingapp.entities.TheatreRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Controller Class to handle the request for Theatre Details
 * This controller will be used by both Booking Gateway and TheatreAdminGateway to
 * Query and create/update respectively
 * @author Abhinav
 *
 */
@RestController
class TheatreController {

  private final TheatreRepository repository;

  TheatreController(TheatreRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/theatreDetailAll")
  List<TheatreDetails> all() {
    return repository.findAll();
  }


  @PostMapping("/theatreDetails")
  TheatreDetails newShowe(@RequestBody TheatreDetails theatreDetails) {
    return repository.save(theatreDetails);
  }

  
  @GetMapping("/theatreDetails/{id}")
  TheatreDetails one(@PathVariable Long id) {
	    return repository.findById(id)
	    	      .orElseThrow(() -> new RuntimeException("Show Not Found"));
  }
  
  /**
   * End point to provide teh show details based on movie Id, City and Show Date.
   * The UI application will let user select the Theatre and date and pass the ID
   * to fetch the required data.
   * @param city
   * @param showDate
   * @param movieId
   * @return
   */
  @GetMapping("/theatreDetails")
  List<TheatreDetails> getByTheatreAndDate(@RequestParam ("city") String city,
		  								@RequestParam ("showDate") String showDate,
		  								@RequestParam ("movieId") Long movieId) {
    
	  
	  
	  List<TheatreDetails> tdList = repository.findBydCityAndDateAndMovie(city, showDate, movieId);
	  //Filter the children as JPA loads all the children regardless of query.
	  for (TheatreDetails td :tdList){
		 // td.getShowDetails().removeIf(p.getMovieId() != movieId && p.getShowDate()!=showDate);
		  td.setShowDetails(td.getShowDetails().stream()
				    .filter(p -> p.getMovieId().equals(movieId) && p.getShowDate().equals (showDate)).collect(Collectors.toSet()));
		  
	  }
	  return tdList;
  }
	 
}