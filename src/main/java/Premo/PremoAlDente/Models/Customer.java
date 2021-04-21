package Premo.PremoAlDente.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")

public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	public Customer(long customerId, String name, String address, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Column(name="phoneNumber")
	private String phoneNumber;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer() {
		super();
	}

}
