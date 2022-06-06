package com.xyz.bookingapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ShowDetails {

	private @Id
	@GeneratedValue
	Long id;
	private Long movieId;
	private Long theatreId;
	private String showDate;
	private String showTime;

	public ShowDetails() {
	}

	public ShowDetails(Long movieId,Long theatreId, String showDate, String showTime) {

		this.movieId = movieId;
		this.theatreId = theatreId;
		this.showDate = showDate;
		this.showTime = showTime;
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

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
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
		result = prime * result
				+ ((theatreId == null) ? 0 : theatreId.hashCode());
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
		if (theatreId == null) {
			if (other.theatreId != null)
				return false;
		} else if (!theatreId.equals(other.theatreId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShowDetails [id=" + id + ", movieId=" + movieId
				+ ", theatreId=" + theatreId + ", showDate=" + showDate
				+ ", showTime=" + showTime + "]";
	}

	

}