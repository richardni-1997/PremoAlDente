package Premo.PremoAlDente.Models;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@Column(name = "products")
	private String products;
	
	@Column(name = "timestamp")
	private Date timestamp;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "zipcode")
	private int zipcode;

	@Column(name = "customerId")
	private long customerId;
	
	@Column(name = "employeeId")
	private long employeeId;
	
	public Order () {}
	public Order(long orderId, String products, Date timestamp, double total, int zipcode, long customerId,
			long employeeId) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.timestamp = timestamp;
		this.total = total;
		this.zipcode = zipcode;
		this.customerId = customerId;
		this.employeeId = employeeId;
	}

	public Order(String products, Date timestamp, double total, int zipcode, long customerId,
			long employeeId) {
		this.products = products;
		this.timestamp = timestamp;
		this.total = total;
		this.zipcode = zipcode;
		this.customerId = customerId;
		this.employeeId = employeeId;
	}

	public long getOrderid() {
		return orderId;
	}

	public void setOrderid(long orderid) {
		this.orderId = orderid;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
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

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", timestamp=" + timestamp
				+ ", total=" + total + ", zipcode=" + zipcode + ", customerId=" + customerId + ", employeeId="
				+ employeeId + "]";
	}
}