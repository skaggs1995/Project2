package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Location")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Trainers { 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRAINERS_SEQ")
	@SequenceGenerator(name="TRAINERS_SEQ", sequenceName="TRAINERS_SEQ", allocationSize=1)
	@Column(name = "TRAINER_ID")
	private int id;

	@Column(name = "TRAINER_NAME")
	private String name;

	public Trainers(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
