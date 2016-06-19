package by.trepam.karotki.ht8.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String birthCountry;
	private ArrayList<String> actor = new ArrayList<String>();
	private ArrayList<String> director = new ArrayList<String>();
	private ArrayList<String> scenarioWriter = new ArrayList<String>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public ArrayList<String> getActor() {
		return actor;
	}

	public void setActor(ArrayList<String> actor) {
		this.actor = actor;
	}

	public ArrayList<String> getDirector() {
		return director;
	}

	public void setDirector(ArrayList<String> director) {
		this.director = director;
	}

	public ArrayList<String> getScenarioWriter() {
		return scenarioWriter;
	}

	public void setScenarioWriter(ArrayList<String> scenarioWriter) {
		this.scenarioWriter = scenarioWriter;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", birthCountry=" + birthCountry
				+ ", actor=" + actor + ", director=" + director + ", scenarioWriter=" + scenarioWriter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((birthCountry == null) ? 0 : birthCountry.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((scenarioWriter == null) ? 0 : scenarioWriter.hashCode());
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
		Author other = (Author) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (birthCountry == null) {
			if (other.birthCountry != null)
				return false;
		} else if (!birthCountry.equals(other.birthCountry))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (scenarioWriter == null) {
			if (other.scenarioWriter != null)
				return false;
		} else if (!scenarioWriter.equals(other.scenarioWriter))
			return false;
		return true;
	}

}
