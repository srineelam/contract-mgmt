package aconex.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", columnDefinition = "BIGINT(20)")
    private BigInteger id;
	
	@Column(name="NAME", columnDefinition = "VARCHAR(30)")
	private String name;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
