package woodspring.springz.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="FEATURES")
public class Features implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	
	@Column(name="address")
    private String address;
	
	@Column(name="country")
    private String country;
	
	@Column(name="region")
    private String region;
	
	@Column(name="price")
    private BigDecimal price;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Features() {}
	
	public Features(int id, String address, String country, String region, BigDecimal price, Customer aCustomer) {
		this.id = id;
		this.address = address;
		this.country = country;
		this.region = region;
		this.price = price;
		this.customer = aCustomer;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
