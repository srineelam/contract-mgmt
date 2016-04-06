package aconex.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

@Entity
@NamedQueries({
@NamedQuery(
            name="getContracts",
            query="SELECT a FROM Contract a inner join a.project p WHERE p.id = :id"
)
})
@Table(name="CONTRACT")
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	
	@Column(name="CODE", columnDefinition = "VARCHAR(30)")
	private String code;
	
	@Column(name="DESCRIPTION", columnDefinition = "VARCHAR(300)")
	private String description;
	
	@Column(name="VENDOR", columnDefinition = "VARCHAR(30)")
	private String vendor;
	
	@Digits(integer=7, fraction=2, message="Invalid Number")
	@Column(name="BUDGET", columnDefinition = "DECIMAL(7,2)", precision=7, scale=2)
	private BigDecimal budget;
	
	@Digits(integer=7, fraction=2, message="Invalid Number")
	@Column(name="COMMITTED_COST", columnDefinition = "DECIMAL(7,2)", precision=7, scale=2)
	private BigDecimal committedCost;
	
	@Digits(integer=7, fraction=2, message="Invalid Number")
	@Column(name="FORECAST", columnDefinition = "DECIMAL(7,2)", precision=7, scale=2)
	private BigDecimal forecast;
	
	@Digits(integer=7, fraction=2, message="Invalid Number")
	@Column(name="PAID", columnDefinition = "DECIMAL(7,2)", precision=7, scale=2)
	private BigDecimal paid;
	
	@Digits(integer=3, fraction=2, message="Invalid Number")
	@Column(name="COMPLETE", columnDefinition = "DECIMAL(3,2)", precision=3, scale=2)
	private BigDecimal complete;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="PROJECT_ID", columnDefinition = "BIGINT(20")
    private Project project;
	
	public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public BigDecimal getCommittedCost() {
		return committedCost;
	}
	public void setCommittedCost(BigDecimal committedCost) {
		this.committedCost = committedCost;
	}
	public BigDecimal getForecast() {
		return forecast;
	}
	public void setForecast(BigDecimal forecast) {
		this.forecast = forecast;
	}
	public BigDecimal getPaid() {
		return paid;
	}
	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}
	public BigDecimal getComplete() {
		return complete;
	}
	public void setComplete(BigDecimal complete) {
		this.complete = complete;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
