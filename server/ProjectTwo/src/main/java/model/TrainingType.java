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
@Table(name="TRAINING_TYPE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class TrainingType {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRAININGTYPE_SEQ")
	@SequenceGenerator(name="TRAININGTYPE_SEQ", sequenceName="TRAININGTYPE_SEQ", allocationSize=1)
	@Column(name="TRAINING_ID")
	private int id;
	
	@Column(name="TRAINING_NAME")
	private String name;

	public TrainingType(int id, String name) {
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
