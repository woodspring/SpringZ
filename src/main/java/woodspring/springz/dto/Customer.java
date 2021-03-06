package woodspring.springz.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	
	@Column(name="firstname")
    private String firstname;
	
	@Column(name="lastname")
    private String lastname;

	@Column(name="email")
    private String email;
	
	//@Transient
	//@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="customer")
	private List<Features> features;
	
//	@Column(name="created_ts")
//    private Timestamp createdTS;
//
//	@Column(name="updated_ts")	
//	private Timestamp udatedTS;


	@Column(nullable = false, updatable = false, name="created_ts")
	//@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTS;

	@Column(nullable = false, name="updated_ts")
	//@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date udatedTS;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Date createdTS) {
		this.createdTS = createdTS;
	}

	public Date getUdatedTS() {
		return udatedTS;
	}

	public void setUdatedTS(Date udatedTS) {
		this.udatedTS = udatedTS;
	}
	
	//@OneToMany(mappedBy="Customer", cascade = CascadeType.ALL)
	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> featuresList) {
		this.features = featuresList;
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", createdTS=" + createdTS + ", udatedTS=" + udatedTS + "]";
	}


}
