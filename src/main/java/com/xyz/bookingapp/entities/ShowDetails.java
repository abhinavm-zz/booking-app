package com.xyz.bookingapp.entities;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
public class ShowDetails  {

	private @Id
	@GeneratedValue
	Long id;
	private Long movieId;
	private String showDate;
	private String showTime;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "thatre_id", nullable = false)
	@JsonBackReference
    private TheatreDetails theatreDetails;
	
	
	public ShowDetails() {
	}

	public ShowDetails(Long movieId, String showDate, String showTime, TheatreDetails theatreDetails) {

		this.movieId = movieId;
		this.showDate = showDate;
		this.showTime = showTime;
		this.theatreDetails = theatreDetails;
	}
	public TheatreDetails getTheatreDetails() {
		return theatreDetails;
	}

	public void setTheatreDetails(TheatreDetails theatreDetails) {
		this.theatreDetails = theatreDetails;
	}

	

	public Long getId() {
		return this.id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result
				+ ((showDate == null) ? 0 : showDate.hashCode());
		result = prime * result
				+ ((showTime == null) ? 0 : showTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowDetails other = (ShowDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (showDate == null) {
			if (other.showDate != null)
				return false;
		} else if (!showDate.equals(other.showDate))
			return false;
		if (showTime == null) {
			if (other.showTime != null)
				return false;
		} else if (!showTime.equals(other.showTime))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "ShowDetails [id=" + id + ", movieId=" + movieId
				+ ", showDate=" + showDate
				+ ", showTime=" + showTime + "]";
	}

	

}