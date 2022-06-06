package com.xyz.bookingapp;


import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.bookingapp.entities.ShowDetails;
import com.xyz.bookingapp.entities.ShowRepository;
/**
 * Controller Class to handle the request for Show Details
 * This controller will be used by both Booking Gateway and TheatreAdminGateway to
 * Query and create/update respectively
 * @author Abhinav
 *
 */
@RestController
class ShowController {

  private final ShowRepository repository;

  ShowController(ShowRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/show")
  List<ShowDetails> all() {
    return repository.findAll();
  }


  @PostMapping("/showDetails")
  ShowDetails newShowe(@RequestBody ShowDetails showDetails) {
    return repository.save(showDetails);
  }

  
  @GetMapping("/showDetails/{id}")
  ShowDetails one(@PathVariable Long id) {
    
	  
	  
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Show Not Found"));
  }
  

  /**
   * End point to provide teh show details based on Theatre ID and Show Date.
   * The UI application will let user select the Theatre and date and pass the ID
   * to fetch the required data.
   * @param theatreId
   * @param showDate
   * @return
   */
  @GetMapping("/showDetails")
  List<ShowDetails> getByTheatreAndDate(@RequestParam ("theatreId") Long theatreId,
		  								@RequestParam ("showDate") String showDate ) {
    
	  
	  
    return repository.findByTheatreIdAndShowDate(theatreId, showDate);
  }


  @PutMapping("/showDetails/{id}")
  ShowDetails replaceShow(@RequestBody ShowDetails updatedShowDetails, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(showDetails -> {
    	showDetails.setShowDate(updatedShowDetails.getShowDate());
    	showDetails.setShowTime(updatedShowDetails.getShowTime());
        return repository.save(showDetails);
      })
      .orElseGet(() -> {
        return repository.save(updatedShowDetails);
      });
  }

  @DeleteMapping("/showDetails/{id}")
  void deleteShow(@PathVariable Long id) {
    repository.deleteById(id);
  }
}