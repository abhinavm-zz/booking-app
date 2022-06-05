package com.xyz.bookingapp;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.bookingapp.entities.ShowDetails;
import com.xyz.bookingapp.entities.ShowRepository;

@RestController
class ShowController {

  private final ShowRepository repository;

  ShowController(ShowRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/show")
  List<ShowDetails> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/showDetails")
  ShowDetails newShowe(@RequestBody ShowDetails showDetails) {
    return repository.save(showDetails);
  }

  // Single item
  
  @GetMapping("/showDetails/{id}")
  ShowDetails one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Show Not Found"));
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