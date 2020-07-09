package com.brasil.seg.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "releaseYear")
	private Integer releaseYear;

	@Column(name = "story")
	private String story;

	@Column(name = "base64Img")
	private String base64Img;

	@Column(name = "languageId")
	private Integer languageId;

	@Column(name = "genreId")
	private Integer genreId;

	@Column(name = "createdBy")
	private Integer createdBy;

	@Column(name = "active")
	private String active;

	@Column(name = "createdTimestamp")
	private Date createdTimestamp;

	@Column(name = "lastUpdtTimestamp")
	private Date lastUpdtTimestamp;

	@Transient
	private String genre;

	@Transient
	private String language;

	@Transient
	private List<Review> reviews;

	public Movie(String name, Integer releaseYear, String active, String genre, String language) {
		this.name = name;
		this.releaseYear = releaseYear;
		this.active = active;
		this.genre = genre;
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getLastUpdtTimestamp() {
		return lastUpdtTimestamp;
	}

	public void setLastUpdtTimestamp(Date lastUpdtTimestamp) {
		this.lastUpdtTimestamp = lastUpdtTimestamp;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
