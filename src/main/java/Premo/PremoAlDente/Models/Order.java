package Premo.PremoAlDente.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderid;
	
	@Column(name = "products")
	private String[] products;
	
	@Column(name = "timestamp")
	private Date timestamp;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "zipcode")
	private int zipcode;
	
	
	@OneToMany(mappedBy = "customer")
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private long customerId;
	
	@OneToMany(mappedBy = "employee")
	@JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
	private long employeeId;
	

	public Order(String[] products, Date timestamp, double total, int zipcode, long customerId,
			long employeeId) {
		this.products = products;
		this.timestamp = timestamp;
		this.total = total;
		this.zipcode = zipcode;
		this.customerId = customerId;
		this.employeeId = employeeId;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String[] getProducts() {
		return products;
	}

	public void setProducts(String[] products) {
		this.products = products;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
}
