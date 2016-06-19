package by.trepam.karotki.ht8.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private double budget;
	private double boxOfficeCash;
	private int audience;
	private String webSite;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private double rate;
	private ArrayList<String> genre = new ArrayList<String>();
	private ArrayList<Author> actors = new ArrayList<Author>();
	private ArrayList<Author> directors = new ArrayList<Author>();
	private ArrayList<Author> scenarioWriters = new ArrayList<Author>();
	private ArrayList<String> originCountries = new ArrayList<String>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getBoxOfficeCash() {
		return boxOfficeCash;
	}

	public void setBoxOfficeCash(double boxOfficeCash) {
		this.boxOfficeCash = boxOfficeCash;
	}

	public int getAudience() {
		return audience;
	}

	public void setAudience(int audience) {
		this.audience = audience;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}

	public ArrayList<Author> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Author> actors) {
		this.actors = actors;
	}

	public ArrayList<Author> getDirectors() {
		return directors;
	}

	public void setDirectors(ArrayList<Author> directors) {
		this.directors = directors;
	}

	public ArrayList<Author> getScenarioWriters() {
		return scenarioWriters;
	}

	public void setScenarioWriters(ArrayList<Author> scenarioWriters) {
		this.scenarioWriters = scenarioWriters;
	}

	public ArrayList<String> getOriginCountries() {
		return originCountries;
	}

	public void setOriginCountries(ArrayList<String> originCountries) {
		this.originCountries = originCountries;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", description=" + description + ", budget=" + budget + ", boxOfficeCash="
				+ boxOfficeCash + ", audience=" + audience + ", webSite=" + webSite + ", comments=" + comments
				+ ", rate=" + rate + ", genre=" + genre + ", actors=" + actors + ", directors=" + directors
				+ ", scenarioWriters=" + scenarioWriters + ", originCountries=" + originCountries + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + audience;
		long temp;
		temp = Double.doubleToLongBits(boxOfficeCash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(budget);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((directors == null) ? 0 : directors.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((originCountries == null) ? 0 : originCountries.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((scenarioWriters == null) ? 0 : scenarioWriters.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((webSite == null) ? 0 : webSite.hashCode());
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
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (audience != other.audience)
			return false;
		if (Double.doubleToLongBits(boxOfficeCash) != Double.doubleToLongBits(other.boxOfficeCash))
			return false;
		if (Double.doubleToLongBits(budget) != Double.doubleToLongBits(other.budget))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (directors == null) {
			if (other.directors != null)
				return false;
		} else if (!directors.equals(other.directors))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (originCountries == null) {
			if (other.originCountries != null)
				return false;
		} else if (!originCountries.equals(other.originCountries))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (scenarioWriters == null) {
			if (other.scenarioWriters != null)
				return false;
		} else if (!scenarioWriters.equals(other.scenarioWriters))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (webSite == null) {
			if (other.webSite != null)
				return false;
		} else if (!webSite.equals(other.webSite))
			return false;
		return true;
	}

}
