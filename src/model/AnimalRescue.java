package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AnimalRescue")
public class AnimalRescue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ANIMALNAME")
	private String animalName;
	@Column(name="ANIMALTYPE")
	private String animalType;
	@Column(name="VENDOR")
	private int vendorId;

	public AnimalRescue() {}
	
	public AnimalRescue(String animalName, String animalType, int vendorId) {
		this.animalName = animalName;
		this.animalType = animalType;
		this.vendorId = vendorId;
	}
	
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getanimalName() {
		return animalName;
	}
	
	public void setanimalName(String animalName) {
		this.animalName = animalName;
	}
	
	public String getAnimalType() {
		return animalType;
	}
	
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	public String returnAnimalDetails( ) {
		return animalName + ": " + animalType + ": " + vendorId;
	}
}
